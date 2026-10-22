package com.baidu.mapsdkplatform.comapi.util;

import B0.g;
import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f8213a;

    /* renamed from: b, reason: collision with root package name */
    private final String f8214b;

    /* renamed from: c, reason: collision with root package name */
    private final String f8215c;

    /* renamed from: d, reason: collision with root package name */
    private final String f8216d;

    /* renamed from: e, reason: collision with root package name */
    private final String f8217e;

    /* renamed from: f, reason: collision with root package name */
    private final String f8218f;

    public d(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null || !externalFilesDir.exists()) {
            this.f8214b = context.getFilesDir().getPath();
        } else {
            this.f8214b = externalFilesDir.getPath();
        }
        this.f8213a = false;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8214b);
        this.f8215c = g.r(sb, File.separator, "BaiduMapSDKNew");
        this.f8216d = context.getCacheDir().getAbsolutePath();
        this.f8217e = "";
        this.f8218f = "";
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8214b);
        return g.r(sb, File.separator, "BaiduMapSDKNew");
    }

    public String b() {
        return this.f8216d;
    }

    public String c() {
        return this.f8214b;
    }

    public String d() {
        return this.f8217e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !d.class.isInstance(obj)) {
            return false;
        }
        return this.f8214b.equals(((d) obj).f8214b);
    }
}
