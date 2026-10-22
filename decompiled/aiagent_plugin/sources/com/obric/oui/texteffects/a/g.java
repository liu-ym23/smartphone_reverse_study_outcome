package com.obric.oui.texteffects.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TextEffectProtocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g {

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f36394a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(Float.valueOf(this.f36394a), Float.valueOf(r6.f36394a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f36394a);
        }

        public String toString() {
            return "DimensionDp(value=" + this.f36394a + ')';
        }

        public a(float r2) {
            super(null);
            this.f36394a = r2;
        }

        public final float a() {
            return this.f36394a;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f36395a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(Float.valueOf(this.f36395a), Float.valueOf(r6.f36395a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f36395a);
        }

        public String toString() {
            return "FloatValue(value=" + this.f36395a + ')';
        }

        public b(float r2) {
            super(null);
            this.f36395a = r2;
        }

        public final float a() {
            return this.f36395a;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f36396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f36397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f36398c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f36396a, r6.f36396a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f36397b, r6.f36397b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(Float.valueOf(this.f36398c), Float.valueOf(r6.f36398c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f36396a.hashCode() * 31) + this.f36397b.hashCode()) * 31) + Float.hashCode(this.f36398c);
        }

        public String toString() {
            return "InterpolatedDimension(from=" + this.f36396a + ", to=" + this.f36397b + ", progress=" + this.f36398c + ')';
        }

        public final g a() {
            return this.f36396a;
        }

        public final g b() {
            return this.f36397b;
        }

        public final float c() {
            return this.f36398c;
        }

        public c(g r2, g r3, float r4) {
            d.h.b.o.e(r2, "from");
            d.h.b.o.e(r3, "to");
            super(null);
            this.f36396a = r2;
            this.f36397b = r3;
            this.f36398c = r4;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f36399a;

        public d() {
            this(0.0f, 1, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(Float.valueOf(this.f36399a), Float.valueOf(r6.f36399a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f36399a);
        }

        public String toString() {
            return "LayerWidth(extraDp=" + this.f36399a + ')';
        }

        public d(float r2) {
            super(null);
            this.f36399a = r2;
        }

        public /* synthetic */ d(float r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0.0f;
        L5:
            this(r1);
        }

        public final float a() {
            return this.f36399a;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f36400a;

        public e() {
            this(0.0f, 1, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(Float.valueOf(this.f36400a), Float.valueOf(r6.f36400a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f36400a);
        }

        public String toString() {
            return "ParentWidth(extraDp=" + this.f36400a + ')';
        }

        public e(float r2) {
            super(null);
            this.f36400a = r2;
        }

        public /* synthetic */ e(float r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0.0f;
        L5:
            this(r1);
        }

        public final float a() {
            return this.f36400a;
        }
    }

    /* JADX INFO: compiled from: TextEffectProtocol.kt */
    public static final class f extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f36401a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(Float.valueOf(this.f36401a), Float.valueOf(r6.f36401a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Float.hashCode(this.f36401a);
        }

        public String toString() {
            return "TextWidthRatio(ratio=" + this.f36401a + ')';
        }

        public f(float r2) {
            super(null);
            this.f36401a = r2;
        }

        public final float a() {
            return this.f36401a;
        }
    }

    public /* synthetic */ g(d.h.b.h r1) {
        this();
    }

    private g() {
    }
}
