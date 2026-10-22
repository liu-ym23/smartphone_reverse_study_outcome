package gb;

import com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f20028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f20031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f20032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f20033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AnimationSpec f20034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Float f20035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final KClass f20036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f20037k;

    public a(String r10, Object r11, Object r12, AnimationSpec r13, Float r14, KClass r15, float r16) {
        q.g(r10, "property");
        q.g(r11, "initialValue");
        q.g(r12, "targetValue");
        q.g(r13, "spec");
        q.g(r15, "valueClass");
        this.f20031e = r10;
        this.f20032f = r11;
        this.f20033g = r12;
        this.f20034h = r13;
        this.f20035i = r14;
        this.f20036j = r15;
        this.f20037k = r16;
        this.f20027a = -1;
        this.f20028b = -1;
        this.f20029c = -1;
        this.f20030d = true;
    }

    public final String a() {
        return "AnimationInfo(property: " + this.f20031e + ", initialValue: " + this.f20032f + ", targetValue: " + this.f20033g + ", spec: " + this.f20034h.dump() + ", initialVelocity: " + this.f20035i + ", valueClass: " + this.f20036j + ", currentVelocity: " + this.f20037k + ", durationNanos: " + this.f20027a + ", firstFrameTimeNanos: " + this.f20028b + ", lastFrameTimeNanos: " + this.f20029c + ", isRunning: " + this.f20030d + ')';
    }

    public final float b() {
        return this.f20037k;
    }

    public final long c() {
        return this.f20028b;
    }

    public final Object d() {
        return this.f20032f;
    }

    public final Float e() {
        return this.f20035i;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L20;
        a r11 = (a) r10;
        if (q.b(this.f20031e, r11.f20031e) == true) goto L8;
        return false;
    L8:
        if (q.b(this.f20032f, r11.f20032f) == true) goto L10;
        return false;
    L10:
        if (q.b(this.f20033g, r11.f20033g) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f20034h, r11.f20034h) == true) goto L14;
        return false;
    L14:
        if (q.b(this.f20035i, r11.f20035i) == true) goto L16;
        return false;
    L16:
        if (q.b(this.f20036j, r11.f20036j) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f20037k, r11.f20037k) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final String f() {
        return this.f20031e;
    }

    public final long g() {
        if (this.f20027a >= 0) goto L10;
        AnimationSpec r10 = this.f20034h;
        Object r11 = this.f20032f;
        Object r12 = this.f20033g;
        Float r13 = this.f20035i;
        if (r13 == null) goto L7;
        float r14 = r13.floatValue();
    L8:
        this.f20027a = r10.getDurationNanos(r11, r12, r14);
        goto L10
    L7:
        r14 = 0.0f;
    L10:
        return this.f20027a;
    }

    public final Object h() {
        return this.f20033g;
    }

    public int hashCode() {
        String r10 = this.f20031e;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        Object r14 = this.f20032f;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        Object r17 = this.f20033g;
        if (r17 == null) goto L13;
        int r18 = r17.hashCode();
    L14:
        int r19 = (r16 + r18) * 31;
        AnimationSpec r20 = this.f20034h;
        if (r20 == null) goto L17;
        int r21 = r20.hashCode();
    L18:
        int r22 = (r19 + r21) * 31;
        Float r23 = this.f20035i;
        if (r23 == null) goto L21;
        int r24 = r23.hashCode();
    L22:
        int r25 = (r22 + r24) * 31;
        KClass r26 = this.f20036j;
        if (r26 == null) goto L26;
        r11 = r26.hashCode();
    L26:
        return ((r25 + r11) * 31) + Float.hashCode(this.f20037k);
    L21:
        r24 = 0;
        goto L22
    L17:
        r21 = 0;
        goto L18
    L13:
        r18 = 0;
        goto L14
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public final Object i(long r11) {
        KClass r10 = this.f20036j;
        if (q.b(r10, u.b(Float.TYPE)) == false) goto L10;
        AnimationValueCalculator r12 = hb.a.f20386a;
        if (r12 == null) goto L8;
    L6:
        AnimationValueCalculator r13 = r12;
        Object r14 = this.f20032f;
        Object r15 = this.f20033g;
        Float r16 = this.f20035i;
        if (r16 == null) goto L18;
        float r17 = r16.floatValue();
    L20:
        return r13.getValueFromNanos(r11, r14, r15, r17, this.f20034h);
    L18:
        r17 = 0.0f;
        goto L20
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L10:
        if (q.b(r10, u.b(Integer.TYPE)) == false) goto L24;
        r12 = hb.b.f20387a;
        if (r12 != null) goto L6;
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L24:
        throw new IllegalArgumentException("Unsupported type " + this.f20036j);
    }

    public final float j(long r11) {
        KClass r10 = this.f20036j;
        if (q.b(r10, u.b(Float.TYPE)) == false) goto L10;
        AnimationValueCalculator r12 = hb.a.f20386a;
        if (r12 == null) goto L8;
    L6:
        AnimationValueCalculator r13 = r12;
        Object r14 = this.f20032f;
        Object r15 = this.f20033g;
        Float r16 = this.f20035i;
        if (r16 == null) goto L18;
        float r17 = r16.floatValue();
    L19:
        float r18 = r13.getVelocityFromNanos(r11, r14, r15, r17, this.f20034h);
        this.f20037k = r18;
        return r18;
    L18:
        r17 = 0.0f;
        goto L19
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L10:
        if (q.b(r10, u.b(Integer.TYPE)) == false) goto L24;
        r12 = hb.b.f20387a;
        if (r12 != null) goto L6;
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L24:
        throw new IllegalArgumentException("Unsupported type " + this.f20036j);
    }

    public final boolean k(long r10) {
        KClass r11 = this.f20036j;
        if (q.b(r11, u.b(Float.TYPE)) == false) goto L10;
        AnimationValueCalculator r12 = hb.a.f20386a;
        if (r12 == null) goto L8;
    L15:
        return r12.isFinishedFromNanos(r10, g(), this.f20034h);
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L10:
        if (q.b(r11, u.b(Integer.TYPE)) == false) goto L19;
        r12 = hb.b.f20387a;
        if (r12 != null) goto L15;
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L19:
        throw new IllegalArgumentException("Unsupported type " + this.f20036j);
    }

    public final boolean l() {
        return this.f20030d;
    }

    public final void m(boolean r10, boolean r11, boolean r12) {
        this.f20030d = r10;
        if (r12 == false) goto L5;
        float r13 = 0.0f;
    L6:
        this.f20037k = r13;
        this.f20028b = -1;
        this.f20029c = -1;
        if (r11 == false) goto L10;
        Object r14 = this.f20032f;
        this.f20032f = this.f20033g;
        this.f20033g = r14;
        return;
    L10:
        return;
    L5:
        r13 = this.f20037k;
        goto L6
    }

    public final void n(long r10) {
        this.f20028b = r10;
    }

    public final void o(Float r10) {
        this.f20035i = r10;
    }

    public final void p(long r10) {
        this.f20029c = r10;
    }

    public final void q(boolean r10) {
        this.f20030d = r10;
    }

    public String toString() {
        return "AnimationInfo(property=" + this.f20031e + ", initialValue=" + this.f20032f + ", targetValue=" + this.f20033g + ", spec=" + this.f20034h + ", initialVelocity=" + this.f20035i + ", valueClass=" + this.f20036j + ", currentVelocity=" + this.f20037k + ")";
    }

    public /* synthetic */ a(String r10, Object r11, Object r12, AnimationSpec r13, Float r14, KClass r15, float r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 64) == 0) goto L5;
        float r19 = 0.0f;
    L6:
        this(r10, r11, r12, r13, r14, r15, r19);
        return;
    L5:
        r19 = r16;
        goto L6
    }
}
