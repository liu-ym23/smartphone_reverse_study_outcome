package com.stepos.cloudsdk;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import b6.j;
import com.stepos.cloudsdk.ICloudListener;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6418a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6419b;

    /* renamed from: e, reason: collision with root package name */
    public j f6422e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6423f = false;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f6420c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f6421d = Executors.newFixedThreadPool(2);

    public a(Context context, String str) {
        this.f6418a = context.getApplicationContext();
        this.f6419b = str;
    }

    public final InputStream a(String str) throws FileNotFoundException {
        try {
            InputStream inputStreamOpenInputStream = this.f6418a.getContentResolver().openInputStream(Uri.parse("content://com.stepos.cloudconfig.provider/file/" + this.f6419b + "/" + str));
            StringBuilder sb2 = new StringBuilder("openFileInputStream: key=");
            sb2.append(str);
            sb2.append(", success=");
            sb2.append(inputStreamOpenInputStream != null);
            a4.a.k("CloudClientImpl", sb2.toString());
            return inputStreamOpenInputStream;
        } catch (Exception e10) {
            Log.e("CloudSDK_".concat("CloudClientImpl"), ai.onnxruntime.a.k("openFileInputStream: failed for key=", str), e10);
            return null;
        }
    }

    public final void b() {
        j jVar;
        synchronized (this) {
            try {
                if (!this.f6423f || (jVar = this.f6422e) == null) {
                    a4.a.k("CloudClientImpl", "unregisterForUpdates: not registered");
                } else {
                    try {
                        this.f6418a.unregisterReceiver(jVar);
                        a4.a.k("ConfigUpdateReceiver", "unregister: unregistered");
                    } catch (IllegalArgumentException e10) {
                        Log.w("CloudSDK_".concat("ConfigUpdateReceiver"), "unregister: receiver not registered", e10);
                    }
                    this.f6423f = false;
                    a4.a.k("CloudClientImpl", "unregisterForUpdates: unregistered");
                }
            } finally {
            }
        }
        ConcurrentHashMap concurrentHashMap = this.f6420c;
        int size = concurrentHashMap.size();
        concurrentHashMap.clear();
        a4.a.k("CloudClientImpl", "removeAllListeners: removed " + size + " listeners");
        this.f6421d.shutdown();
        a4.a.k("CloudClientImpl", "release: resources released");
    }

    public final void c(String str, ICloudListener.ResultCode resultCode) {
        String str2 = resultCode.f6417a;
        try {
            Uri uri = Uri.parse("content://com.stepos.cloudconfig.provider/state/" + this.f6419b + "/" + str);
            ContentValues contentValues = new ContentValues();
            if (resultCode == ICloudListener.ResultCode.SUCCESS) {
                contentValues.put("state", (Integer) 1);
            } else {
                contentValues.put("state", (Integer) 2);
            }
            contentValues.put("result_code", str2);
            a4.a.k("CloudClientImpl", "updateConfigState: key=" + str + ", result=" + str2 + ", rowsUpdated=" + this.f6418a.getContentResolver().update(uri, contentValues, null, null));
        } catch (Exception e10) {
            Log.e("CloudSDK_".concat("CloudClientImpl"), ai.onnxruntime.a.k("updateConfigState: failed for key=", str), e10);
        }
    }
}
