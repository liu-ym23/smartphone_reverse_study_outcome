package com.stepos.core.common.cloudconfig;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import b6.j;
import com.stepos.cloudsdk.ICloudListener;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudConfigProvider {
    private final Context context;
    private final String pkg;

    public CloudConfigProvider(Context context, String pkg) {
        g.f(context, "context");
        g.f(pkg, "pkg");
        this.context = context;
        this.pkg = pkg;
    }

    public final void addListener(String key, final p<? super String, ? super InputStream, ? extends ICloudListener.ResultCode> onBytes) {
        g.f(key, "key");
        g.f(onBytes, "onBytes");
        com.stepos.cloudsdk.a aVar = e8.a.a().f8619a;
        ICloudListener iCloudListener = new ICloudListener() { // from class: com.stepos.core.common.cloudconfig.CloudConfigProvider.addListener.1
            @Override // com.stepos.cloudsdk.ICloudListener
            public ICloudListener.ResultCode applyInputStream(String k9, InputStream stream) {
                g.f(k9, "k");
                g.f(stream, "stream");
                return onBytes.invoke(k9, stream);
            }
        };
        ConcurrentHashMap concurrentHashMap = aVar.f6420c;
        if (TextUtils.isEmpty(key)) {
            Log.e("CloudSDK_".concat("CloudClientImpl"), "addListener: key is empty, use global listener instead");
            concurrentHashMap.put("__GLOBAL__", iCloudListener);
            a4.a.k("CloudClientImpl", "addListener: global listener added, total=" + concurrentHashMap.size());
            return;
        }
        concurrentHashMap.put(key, iCloudListener);
        a4.a.k("CloudClientImpl", "addListener: key=" + key + ", total=" + concurrentHashMap.size());
    }

    public final void init() {
        Context context = this.context;
        String str = this.pkg;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Package name cannot be empty");
        }
        if (e8.a.f8617b == null) {
            synchronized (e8.a.f8618c) {
                try {
                    if (e8.a.f8617b == null) {
                        e8.a.f8617b = new e8.a();
                        e8.a.f8617b.f8619a = new com.stepos.cloudsdk.a(context, str);
                        Log.i("CloudSDK_".concat("CloudSdk"), "init: SDK initialized, packageName=" + str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void registerForUpdates() {
        com.stepos.cloudsdk.a aVar = e8.a.a().f8619a;
        synchronized (aVar) {
            try {
                if (aVar.f6423f) {
                    a4.a.k("CloudClientImpl", "registerForUpdates: already registered");
                    return;
                }
                if (aVar.f6422e == null) {
                    aVar.f6422e = new j(new bd.j(aVar));
                }
                j jVar = aVar.f6422e;
                Context context = aVar.f6418a;
                jVar.getClass();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.stepos.cloudconfig.ACTION_CONFIG_UPDATED");
                context.registerReceiver(jVar, intentFilter, "com.stepos.permission.SEND_CLOUD_CONFIG", null, 2);
                a4.a.k("ConfigUpdateReceiver", "register: registered with permission com.stepos.permission.SEND_CLOUD_CONFIG");
                aVar.f6423f = true;
                a4.a.k("CloudClientImpl", "registerForUpdates: registered");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void release() {
        try {
            e8.a aVarA = e8.a.a();
            aVarA.getClass();
            synchronized (e8.a.f8618c) {
                try {
                    com.stepos.cloudsdk.a aVar = aVarA.f8619a;
                    if (aVar != null) {
                        aVar.b();
                        aVarA.f8619a = null;
                    }
                    e8.a.f8617b = null;
                    Log.i("CloudSDK_".concat("CloudSdk"), "release: SDK released");
                } catch (Throwable th) {
                    throw th;
                }
            }
            n nVar = n.f10413a;
        } catch (Throwable th2) {
            c.a(th2);
        }
    }
}
