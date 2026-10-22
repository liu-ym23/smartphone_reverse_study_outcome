package com.bumptech.glide.load.engine.d;

import android.graphics.Bitmap;
import com.bumptech.glide.f.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PreFillType.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Bitmap.Config f3628a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bitmap.Config f3631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3632e;

    /* JADX INFO: compiled from: PreFillType.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f3635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3636d;

        public a a(Bitmap.Config r1) {
            this.f3635c = r1;
            return this;
        }

        Bitmap.Config a() {
            return this.f3635c;
        }

        d b() {
            return new d(this.f3633a, this.f3634b, this.f3635c, this.f3636d);
        }
    }

    static {
        f3628a = Bitmap.Config.RGB_565;
    }

    d(int r3, int r4, Bitmap.Config r5, int r6) {
        this.f3631d = (Bitmap.Config) ZeusTransformUtils.preCheckCast(j.a(r5, "Config must not be null"), Bitmap.Config.class, "com.obric.aiagent.plugin");
        this.f3629b = r3;
        this.f3630c = r4;
        this.f3632e = r6;
    }

    int a() {
        return this.f3629b;
    }

    int b() {
        return this.f3630c;
    }

    Bitmap.Config c() {
        return this.f3631d;
    }

    int d() {
        return this.f3632e;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L14;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
        if (this.f3630c == r5.f3630c) goto L7;
        return false;
    L7:
        if (this.f3629b == r5.f3629b) goto L9;
        return false;
    L9:
        if (this.f3632e == r5.f3632e) goto L11;
        return false;
    L11:
        if (this.f3631d != r5.f3631d) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((this.f3629b * 31) + this.f3630c) * 31) + this.f3631d.hashCode()) * 31) + this.f3632e;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f3629b + ", height=" + this.f3630c + ", config=" + this.f3631d + ", weight=" + this.f3632e + '}';
    }
}
