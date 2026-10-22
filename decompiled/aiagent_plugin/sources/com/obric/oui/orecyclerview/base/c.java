package com.obric.oui.orecyclerview.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: FluidScroller.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35514a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f35515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f35516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f35517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f35518e;

    /* JADX INFO: compiled from: FluidScroller.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: FluidScroller.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f35519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f35520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f35521c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(Float.valueOf(this.f35519a), Float.valueOf(r6.f35519a)) == true) goto L12;
            return false;
        L12:
            if (o.a(Float.valueOf(this.f35520b), Float.valueOf(r6.f35520b)) == true) goto L15;
            return false;
        L15:
            if (this.f35521c == r6.f35521c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = ((Float.hashCode(this.f35519a) * 31) + Float.hashCode(this.f35520b)) * 31;
            boolean r2 = this.f35521c;
            ?? r3 = r2;
            if (r2 == false) goto L6;
            r3 = 1;
        L6:
            return r0 + r3;
        }

        public String toString() {
            return "ScrollValue(value=" + this.f35519a + ", velocity=" + this.f35520b + ", isFinished=" + this.f35521c + ')';
        }

        public b(float r1, float r2, boolean r3) {
            this.f35519a = r1;
            this.f35520b = r2;
            this.f35521c = r3;
        }

        public final float a() {
            return this.f35519a;
        }

        public final float b() {
            return this.f35520b;
        }

        public final boolean c() {
            return this.f35521c;
        }
    }

    static {
        f35514a = new a(null);
    }

    public c() {
        this(0.0f, 1, null);
    }

    public c(float r1) {
        this.f35515b = r1;
        this.f35518e = 0.099999994f;
    }

    public /* synthetic */ c(float r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.998f;
    L5:
        this(r1);
    }

    public final void a(float r1, float r2) {
        this.f35516c = r1;
        this.f35517d = r2;
    }

    public final b a(float r4) {
        float r0 = b(r4);
        float r5 = c(r4);
        if (Math.abs(r0) >= this.f35518e) goto L5;
        boolean r3 = true;
    L7:
        return new b(r5, r0, r3);
    L5:
        r3 = false;
        goto L7
    }

    public final float a() {
        float r0 = Math.abs(this.f35517d);
        float r1 = this.f35518e;
        if (r0 >= r1) goto L7;
        return 0.0f;
    L7:
        return c(((float) Math.log(r1 / Math.abs(this.f35517d))) / ((float) Math.log(this.f35515b)));
    }

    private final float b(float r4) {
        return this.f35517d * ((float) Math.pow(this.f35515b, r4));
    }

    private final float c(float r7) {
        return this.f35516c + (((this.f35517d * (1.0f / ((float) Math.log(this.f35515b)))) * (((float) Math.pow(this.f35515b, r7)) - 1.0f)) * 1.1111112f);
    }
}
