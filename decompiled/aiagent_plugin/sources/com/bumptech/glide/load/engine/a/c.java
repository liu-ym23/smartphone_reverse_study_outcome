package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AttributeStrategy.java */
/* JADX INFO: loaded from: classes.dex */
class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f3524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f3525b;

    /* JADX INFO: compiled from: AttributeStrategy.java */
    static class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f3526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f3529d;

        public a(b r1) {
            this.f3526a = r1;
        }

        public void a(int r1, int r2, Bitmap.Config r3) {
            this.f3527b = r1;
            this.f3528c = r2;
            this.f3529d = r3;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L12;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
            if (this.f3527b == r5.f3527b) goto L7;
            return false;
        L7:
            if (this.f3528c == r5.f3528c) goto L9;
            return false;
        L9:
            if (this.f3529d != r5.f3529d) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = ((this.f3527b * 31) + this.f3528c) * 31;
            Bitmap.Config r2 = this.f3529d;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r0 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            return c.c(this.f3527b, this.f3528c, this.f3529d);
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void a() {
            this.f3526a.a(this);
        }
    }

    /* JADX INFO: compiled from: AttributeStrategy.java */
    static class b extends d<a> {
        @Override // com.bumptech.glide.load.engine.a.d
        public /* synthetic */ m b() {
            return a();
        }

        b() {
        }

        a a(int r3, int r4, Bitmap.Config r5) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(c(), a.class, "com.obric.aiagent.plugin");
            r2.a(r3, r4, r5);
            return r2;
        }

        public a a() {
            return new a(this);
        }
    }

    c() {
        this.f3524a = new b();
        this.f3525b = new h();
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public void a(Bitmap r5) {
        a r0 = this.f3524a.a(r5.getWidth(), r5.getHeight(), r5.getConfig());
        this.f3525b.a(r0, r5);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a(int r2, int r3, Bitmap.Config r4) {
        a r5 = this.f3524a.a(r2, r3, r4);
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.f3525b.a(r5), Bitmap.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a() {
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.f3525b.a(), Bitmap.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(Bitmap r1) {
        return d(r1);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(int r1, int r2, Bitmap.Config r3) {
        return c(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public int c(Bitmap r1) {
        return com.bumptech.glide.f.k.a(r1);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f3525b;
    }

    private static String d(Bitmap r2) {
        return c(r2.getWidth(), r2.getHeight(), r2.getConfig());
    }

    static String c(int r2, int r3, Bitmap.Config r4) {
        return "[" + r2 + "x" + r3 + "], " + r4;
    }
}
