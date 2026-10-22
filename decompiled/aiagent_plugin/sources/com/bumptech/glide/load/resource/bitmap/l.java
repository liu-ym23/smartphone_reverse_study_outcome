package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DownsampleStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f3807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f3808b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f3809c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l f3810d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f3811e = null;
    public static final l f = null;
    public static final l g = null;
    public static final com.bumptech.glide.load.h<l> h = null;
    static final boolean i = false;

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class a extends l {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float a(int r1, int r2, int r3, int r4) {
            int r0 = Math.min(r2 / r4, r1 / r3);
            if (r0 != 0) goto L6;
            return 1.0f;
        L6:
            return 1.0f / Integer.highestOneBit(r0);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public g b(int r1, int r2, int r3, int r4) {
            return g.f3813b;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class b extends l {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float a(int r1, int r2, int r3, int r4) {
            int r0 = (int) Math.ceil(Math.max(r2 / r4, r1 / r3));
            int r5 = 1;
            int r6 = Math.max(1, Integer.highestOneBit(r0));
            if (r6 < r0) goto L7;
            r5 = 0;
        L7:
            return 1.0f / (r6 << r5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public g b(int r1, int r2, int r3, int r4) {
            return g.f3812a;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class c extends l {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float a(int r1, int r2, int r3, int r4) {
            return Math.min(1.0f, f3809c.a(r1, r2, r3, r4));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public g b(int r2, int r3, int r4, int r5) {
            if (a(r2, r3, r4, r5) != 1.0f) goto L6;
            return g.f3813b;
        L6:
            return f3809c.b(r2, r3, r4, r5);
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class d extends l {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float a(int r1, int r2, int r3, int r4) {
            return Math.max(r3 / r1, r4 / r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public g b(int r1, int r2, int r3, int r4) {
            return g.f3813b;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class e extends l {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float a(int r1, int r2, int r3, int r4) {
            if (i == true) goto L5;
            int r0 = Math.max(r2 / r4, r1 / r3);
            if (r0 != 0) goto L10;
            return 1.0f;
        L10:
            return 1.0f / Integer.highestOneBit(r0);
        L5:
            return Math.min(r3 / r1, r4 / r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public g b(int r1, int r2, int r3, int r4) {
            if (i == false) goto L7;
            return g.f3813b;
        L7:
            return g.f3812a;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    private static class f extends l {
        @Override // com.bumptech.glide.load.resource.bitmap.l
        public float a(int r1, int r2, int r3, int r4) {
            return 1.0f;
        }

        f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.l
        public g b(int r1, int r2, int r3, int r4) {
            return g.f3813b;
        }
    }

    /* JADX INFO: compiled from: DownsampleStrategy.java */
    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f3812a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f3813b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ g[] f3814c = null;

        private g(String r1, int r2) {
            super(r1, r2);
        }

        public static g valueOf(String r2) {
            return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
        }

        public static g[] values() {
            return (g[]) ZeusTransformUtils.preCheckCast(f3814c.clone(), g[].class, "com.obric.aiagent.plugin");
        }

        static {
            g r0 = new g("MEMORY", 0);
            f3812a = r0;
            g r1 = new g("QUALITY", 1);
            f3813b = r1;
            f3814c = new g[]{r0, r1};
        }
    }

    public abstract float a(int r1, int r2, int r3, int r4);

    public abstract g b(int r1, int r2, int r3, int r4);

    public l() {
    }

    static {
        f3807a = new a();
        f3808b = new b();
        f3809c = new e();
        f3810d = new c();
        d r0 = new d();
        f3811e = r0;
        f = new f();
        g = r0;
        h = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", r0);
        if (Build.VERSION.SDK_INT < 19) goto L5;
        boolean r1 = true;
    L6:
        i = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }
}
