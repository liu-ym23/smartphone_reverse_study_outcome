package com.obric.autogui.operator.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;

/* JADX INFO: compiled from: SwipeV3Request.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f29865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f29866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f29867e;
    private final int f;
    private final m<Float, Float> g;
    private final m<Float, Float> h;

    /* JADX INFO: compiled from: SwipeV3Request.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final f a(int r13, m<Float, Float> r14, m<Float, Float> r15) {
            o.e(r14, "start");
            o.e(r15, "end");
            if (r13 < 0) goto L56;
            float r0 = ((Number) ZeusTransformUtils.preCheckCast(r14.a(), Number.class, "com.obric.aiagent.plugin")).floatValue();
            boolean r3 = true;
            if (Float.isInfinite(r0) == false) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == false) goto L57;
            float r2 = ((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).floatValue();
            if (Float.isInfinite(r2) == false) goto L14;
        L16:
            boolean r4 = false;
        L17:
            if (r4 == false) goto L58;
            float r5 = ((Number) ZeusTransformUtils.preCheckCast(r15.a(), Number.class, "com.obric.aiagent.plugin")).floatValue();
            if (Float.isInfinite(r5) == false) goto L21;
        L23:
            boolean r6 = false;
        L24:
            if (r6 == false) goto L59;
            float r7 = ((Number) ZeusTransformUtils.preCheckCast(r15.b(), Number.class, "com.obric.aiagent.plugin")).floatValue();
            if (Float.isInfinite(r7) == false) goto L28;
        L30:
            boolean r8 = false;
        L31:
            if (r8 == true) goto L33;
            return null;
        L33:
            if (((Number) ZeusTransformUtils.preCheckCast(r14.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() >= 0.0f) goto L35;
            return null;
        L35:
            if (((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() >= 0.0f) goto L37;
            return null;
        L37:
            if (((Number) ZeusTransformUtils.preCheckCast(r15.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() >= 0.0f) goto L39;
            return null;
        L39:
            if (((Number) ZeusTransformUtils.preCheckCast(r15.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() >= 0.0f) goto L42;
            return null;
        L42:
            if (((Number) ZeusTransformUtils.preCheckCast(r14.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() == ((Number) ZeusTransformUtils.preCheckCast(r15.a(), Number.class, "com.obric.aiagent.plugin")).floatValue()) goto L45;
            r3 = false;
        L45:
            if (r3 == true) goto L47;
            return null;
        L47:
            int r9 = d.i.a.a(((Number) ZeusTransformUtils.preCheckCast(r14.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(r15.a(), Number.class, "com.obric.aiagent.plugin")).floatValue());
            int r16 = d.i.a.a(((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - ((Number) ZeusTransformUtils.preCheckCast(r15.b(), Number.class, "com.obric.aiagent.plugin")).floatValue());
            if (Math.abs(r16) > 400) goto L50;
            return null;
        L50:
            float r10 = r9;
            float r11 = r16;
            float r12 = 64.0f / ((float) Math.sqrt((r10 * r10) + (r11 * r11)));
            int r17 = d.i.a.a(r10 * r12);
            int r18 = d.i.a.a(r11 * r12);
            int r19 = r9 - r17;
            int r20 = r16 - r18;
            if (r19 != 0) goto L55;
            if (r20 != 0) goto L55;
            return null;
        L55:
            return new f(r13, ((Number) ZeusTransformUtils.preCheckCast(r14.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).floatValue(), r19, r20, r14, s.a(Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r17), Float.valueOf(((Number) ZeusTransformUtils.preCheckCast(r14.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r18)));
        L28:
            if (Float.isNaN(r7) == true) goto L30;
            r8 = true;
            goto L31
        L59:
            return null;
        L21:
            if (Float.isNaN(r5) == true) goto L23;
            r6 = true;
            goto L24
        L58:
            return null;
        L14:
            if (Float.isNaN(r2) == true) goto L16;
            r4 = true;
            goto L17
        L57:
            return null;
        L7:
            if (Float.isNaN(r0) == true) goto L9;
            r1 = true;
            goto L10
        L56:
            return null;
        }
    }

    static {
        f29863a = new a(null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f29864b == r6.f29864b) goto L12;
        return false;
    L12:
        if (Float.compare(this.f29865c, r6.f29865c) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f29866d, r6.f29866d) == 0) goto L18;
        return false;
    L18:
        if (this.f29867e == r6.f29867e) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L24;
        return false;
    L24:
        if (o.a(this.g, r6.g) == true) goto L27;
        return false;
    L27:
        if (o.a(this.h, r6.h) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.f29864b) * 31) + Float.hashCode(this.f29865c)) * 31) + Float.hashCode(this.f29866d)) * 31) + Integer.hashCode(this.f29867e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "SwipeV3Request(displayId=" + this.f29864b + ", x=" + this.f29865c + ", y=" + this.f29866d + ", deltaX=" + this.f29867e + ", deltaY=" + this.f + ", touchTailStart=" + this.g + ", touchTailEnd=" + this.h + ')';
    }

    public f(int r2, float r3, float r4, int r5, int r6, m<Float, Float> r7, m<Float, Float> r8) {
        o.e(r7, "touchTailStart");
        o.e(r8, "touchTailEnd");
        this.f29864b = r2;
        this.f29865c = r3;
        this.f29866d = r4;
        this.f29867e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final int a() {
        return this.f29864b;
    }

    public final float b() {
        return this.f29865c;
    }

    public final float c() {
        return this.f29866d;
    }

    public final int d() {
        return this.f29867e;
    }

    public final int e() {
        return this.f;
    }

    public final m<Float, Float> f() {
        return this.g;
    }

    public final m<Float, Float> g() {
        return this.h;
    }
}
