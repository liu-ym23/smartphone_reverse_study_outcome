package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.baidu.mapsdkplatform.comapi.Initializer;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f32318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f32320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f32322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f32323f;

    public String a() {
        return this.f32319b + File.separator + "BaiduMapSDKNew";
    }

    public String b() {
        return this.f32321d;
    }

    public String c() {
        return this.f32319b;
    }

    public String d() {
        return this.f32322e;
    }

    public e(Context r100) {
        if (Build.VERSION.SDK_INT < 29) goto L11;
        File r101 = r100.getExternalFilesDir(null);
        if (r101 != null) goto L7;
    L9:
        this.f32319b = r100.getFilesDir().getPath();
    L14:
        this.f32318a = false;
        this.f32320c = this.f32319b + File.separator + "BaiduMapSDKNew";
        this.f32321d = r100.getCacheDir().getAbsolutePath();
        this.f32322e = "";
        this.f32323f = "";
        return;
    L7:
        if (r101.exists() == false) goto L9;
        this.f32319b = r101.getPath();
        goto L14
    L11:
        if (Initializer.isAgreePrivacyMode() == false) goto L13;
        this.f32319b = Environment.getExternalStorageDirectory().getAbsolutePath();
        goto L14
    L13:
        this.f32319b = r100.getFilesDir().getAbsolutePath();
        goto L14
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (e.class.isInstance(r100) == true) goto L7;
        return false;
    L7:
        return this.f32319b.equals(((e) r100).f32319b);
    }
}
