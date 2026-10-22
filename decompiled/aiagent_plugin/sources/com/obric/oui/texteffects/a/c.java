package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f36369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f36370c;

        public a() {
            this(0, 0.0f, 0.0f, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f36368a == r6.f36368a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(Float.valueOf(this.f36369b), Float.valueOf(r6.f36369b)) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(Float.valueOf(this.f36370c), Float.valueOf(r6.f36370c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f36368a) * 31) + Float.hashCode(this.f36369b)) * 31) + Float.hashCode(this.f36370c);
        }

        public String toString() {
            return "AeAnimator(mode=" + this.f36368a + ", easeLow=" + this.f36369b + ", easeHigh=" + this.f36370c + ')';
        }

        public /* synthetic */ a(int r2, float r3, float r4, int r5, d.h.b.h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0.0f;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0.0f;
        L11:
            this(r2, r3, r4);
        }

        public final int a() {
            return this.f36368a;
        }

        public final float b() {
            return this.f36369b;
        }

        public final float c() {
            return this.f36370c;
        }

        public a(int r2, float r3, float r4) {
            super(null);
            this.f36368a = r2;
            this.f36369b = r3;
            this.f36370c = r4;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f36371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f36372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f36373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f36374d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(Float.valueOf(this.f36371a), Float.valueOf(r6.f36371a)) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(Float.valueOf(this.f36372b), Float.valueOf(r6.f36372b)) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(Float.valueOf(this.f36373c), Float.valueOf(r6.f36373c)) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(Float.valueOf(this.f36374d), Float.valueOf(r6.f36374d)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.f36371a) * 31) + Float.hashCode(this.f36372b)) * 31) + Float.hashCode(this.f36373c)) * 31) + Float.hashCode(this.f36374d);
        }

        public String toString() {
            return "CubicBezier(x1=" + this.f36371a + ", y1=" + this.f36372b + ", x2=" + this.f36373c + ", y2=" + this.f36374d + ')';
        }

        public final float a() {
            return this.f36371a;
        }

        public final float b() {
            return this.f36372b;
        }

        public final float c() {
            return this.f36373c;
        }

        public final float d() {
            return this.f36374d;
        }

        public b(float r2, float r3, float r4, float r5) {
            super(null);
            this.f36371a = r2;
            this.f36372b = r3;
            this.f36373c = r4;
            this.f36374d = r5;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.texteffects.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class C0998c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0998c f36375a = null;

        static {
            f36375a = new C0998c();
        }

        private C0998c() {
            super(null);
        }
    }

    public /* synthetic */ c(d.h.b.h r1) {
        this();
    }

    private c() {
    }
}
