package com.obric.common.oea.foundation.animation.spec.spring;

import bg.h;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import hb.d;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements AnimationSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f11551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f11553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f11554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f11555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f11556g;

    public b(float r10, float r11, int r12, float r13) {
        this.f11553d = r10;
        this.f11554e = r11;
        this.f11555f = r12;
        this.f11556g = r13;
        this.f11550a = "FloatSpringSpec";
        d r14 = new d(1.0f);
        r14.d(r10);
        r14.f(r11);
        Unit r15 = Unit.f21064a;
        this.f11551b = r14;
        this.f11552c = 1.0f;
    }

    public final long a(long r10, float r11, float r12, float r13) {
        long r14 = b(r11, r12, r13);
        long r15 = r10 - (((long) this.f11555f) * BatteryFactorConfig.WIFI_BPS);
        if (r14 < 0) goto L5;
        long r16 = r14;
    L7:
        return h.l(r15, 0, r16);
    L5:
        r16 = 0;
        goto L7
    }

    public long b(float r10, float r11, float r12) {
        float r13 = this.f11551b.b();
        float r14 = this.f11551b.a();
        float r15 = r10 - r11;
        float r16 = this.f11556g;
        float r17 = r12 / r16;
        return FloatSpringSpecKt.c(r13, r14, r17, r15 / r16, this.f11552c) * BatteryFactorConfig.WIFI_BPS;
    }

    public Float c(long r10, float r11, float r12, float r13) {
        long r14 = a(r10, r11, r12, r13) / BatteryFactorConfig.WIFI_BPS;
        this.f11551b.e(r12);
        return Float.valueOf(this.f11551b.g(r11, r13, r14).a());
    }

    public float d(long r10, float r11, float r12, float r13) {
        long r14 = a(r10, r11, r12, r13) / BatteryFactorConfig.WIFI_BPS;
        this.f11551b.e(r12);
        return this.f11551b.g(r11, r13, r14).b();
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public String dump() {
        return "FloatSpringSpec(dampingRatio: " + this.f11553d + ", stiffness: " + this.f11554e + ", delay: " + this.f11555f + ", visibilityThreshold: " + this.f11556g + ", delta: " + this.f11552c + ')';
    }

    public final void e(float r10) {
        this.f11552c = r10;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ long getDurationNanos(Object r10, Object r11, float r12) {
        return b(((Number) r10).floatValue(), ((Number) r11).floatValue(), r12);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ Object getValueFromNanos(long r10, Object r11, Object r12, float r13) {
        return c(r10, ((Number) r11).floatValue(), ((Number) r12).floatValue(), r13);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ float getVelocityFromNanos(long r10, Object r11, Object r12, float r13) {
        return d(r10, ((Number) r11).floatValue(), ((Number) r12).floatValue(), r13);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public boolean isFinishedFromNanos(long r10, long r11) {
        if (r10 < (r11 + (((long) this.f11555f) * BatteryFactorConfig.WIFI_BPS))) goto L5;
        return true;
    L5:
        return false;
    }

    public /* synthetic */ b(float r10, float r11, int r12, float r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 1.0f;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = 1.0f;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = 0;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = 0.01f;
    L14:
        this(r10, r11, r12, r13);
    }
}
