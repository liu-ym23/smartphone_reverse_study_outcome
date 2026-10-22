package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.vi.VIContext;
import java.io.File;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f9294a;

    /* renamed from: b, reason: collision with root package name */
    private String f9295b;

    /* renamed from: c, reason: collision with root package name */
    private String f9296c;

    /* renamed from: d, reason: collision with root package name */
    private String f9297d;

    /* renamed from: e, reason: collision with root package name */
    private String f9298e;

    /* renamed from: f, reason: collision with root package name */
    private String f9299f;

    /* renamed from: g, reason: collision with root package name */
    private String f9300g;

    public void a(Context context) {
        this.f9294a = context.getFilesDir().getAbsolutePath();
        String absolutePath = context.getCacheDir().getAbsolutePath();
        this.f9297d = absolutePath;
        this.f9298e = absolutePath;
        this.f9295b = Environment.getExternalStorageDirectory().getPath();
        this.f9296c = Environment.getExternalStorageDirectory().getPath();
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            this.f9299f = externalFilesDir.getAbsolutePath();
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            this.f9300g = externalCacheDir.getAbsolutePath();
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f9299f)) {
            a(VIContext.getContext());
        }
        return this.f9299f;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f9297d)) {
            a(VIContext.getContext());
        }
        return this.f9297d;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f9294a)) {
            a(VIContext.getContext());
        }
        return this.f9294a;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f9295b)) {
            a(VIContext.getContext());
        }
        return this.f9295b;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f9296c)) {
            a(VIContext.getContext());
        }
        return this.f9296c;
    }
}
