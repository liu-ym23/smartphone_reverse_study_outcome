package com.obric.oui.orecyclerview.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: FluidSpringBack.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f35522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f35523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f35524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f35525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f35526e;

    /* JADX INFO: compiled from: FluidSpringBack.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f35527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f35528b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(Float.valueOf(this.f35527a), Float.valueOf(r6.f35527a)) == true) goto L12;
            return false;
        L12:
            if (this.f35528b == r6.f35528b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int r0 = Float.hashCode(this.f35527a) * 31;
            boolean r1 = this.f35528b;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return r0 + r2;
        }

        public String toString() {
            return "SpringBackValue(value=" + this.f35527a + ", isFinished=" + this.f35528b + ')';
        }

        public a(float r1, boolean r2) {
            this.f35527a = r1;
            this.f35528b = r2;
        }

        public final float a() {
            return this.f35527a;
        }

        public final boolean b() {
            return this.f35528b;
        }
    }

    public d() {
        this.f35525d = 0.1f;
        this.f35526e = 0.01f;
    }

    public final void a(float r3, float r4) {
        this.f35524c = 10.927279f;
        this.f35522a = r4;
        this.f35523b = (r3 * 1000.0f) + (10.927279f * r4);
    }

    public final a a(float r5) {
        float r6 = r5 / 1000.0f;
        float r1 = (this.f35522a + (this.f35523b * r6)) * ((float) Math.exp((-this.f35524c) * r6));
        float r7 = b(r6);
        if (Math.abs(r1) >= this.f35525d) goto L8;
        if ((Math.abs(r7) / 1000.0f) >= this.f35526e) goto L8;
        return new a(0.0f, true);
    L8:
        return new a(r1, false);
    }

    private final float b(float r4) {
        float r0 = this.f35523b;
        float r1 = this.f35524c;
        return (r0 - ((this.f35522a + (r0 * r4)) * r1)) * ((float) Math.exp((-r1) * r4));
    }
}
