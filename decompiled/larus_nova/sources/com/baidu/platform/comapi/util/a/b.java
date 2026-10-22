package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.vi.VIContext;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f33415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f33416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f33417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f33418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f33419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f33420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f33421g;

    public String a() {
        if (TextUtils.isEmpty(this.f33417c) == false) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33417c;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f33420f) == false) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33420f;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f33418d) == false) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33418d;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f33415a) == false) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33415a;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f33416b) == false) goto L6;
        a(VIContext.getContext());
    L6:
        return this.f33416b;
    }

    public b() {
    }

    public void a(Context r100) {
        this.f33415a = r100.getFilesDir().getAbsolutePath();
        String r101 = r100.getCacheDir().getAbsolutePath();
        this.f33418d = r101;
        this.f33419e = r101;
        this.f33416b = Environment.getExternalStorageDirectory().getPath();
        this.f33417c = Environment.getExternalStorageDirectory().getPath();
        File r102 = r100.getExternalFilesDir(null);
        if (r102 == null) goto L5;
        this.f33420f = r102.getAbsolutePath();
    L5:
        File r103 = r100.getExternalCacheDir();
        if (r103 == null) goto L9;
        this.f33421g = r103.getAbsolutePath();
        return;
    }
}
