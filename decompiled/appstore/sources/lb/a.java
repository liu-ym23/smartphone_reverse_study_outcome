package lb;

import bg.h;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.jvm.internal.q;
import mb.b;
import mb.c;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements AnimationSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Token$Easing f21929d;

    public a(int r10, int r11, Token$Easing r12) {
        q.g(r12, "easing");
        this.f21927b = r10;
        this.f21928c = r11;
        this.f21929d = r12;
        this.f21926a = "FloatTweenSpec";
    }

    public final long a(long r11) {
        return h.l(r11 - (((long) this.f21928c) * BatteryFactorConfig.WIFI_BPS), 0, ((long) this.f21927b) * BatteryFactorConfig.WIFI_BPS);
    }

    public long b(float r10, float r11, float r12) {
        return ((long) this.f21927b) * BatteryFactorConfig.WIFI_BPS;
    }

    public Float c(long r10, float r11, float r12, float r13) {
        long r14 = a(r10);
        int r15 = this.f21927b;
        float r16 = 1.0f;
        if (r15 != 0) goto L5;
        float r17 = 1.0f;
    L6:
        Token$Easing r18 = this.f21929d;
        if (r18 != Token$Easing.OUI_ANIMATION_EASING_LINEAR) goto L9;
        float r19 = c.b(r18).transform(r17);
    L18:
        return Float.valueOf(b.h(r11, r12, r19));
    L9:
        mb.a r20 = c.a(r18);
        if (r17 >= 0.0f) goto L13;
        r17 = 0.0f;
    L13:
        if (r17 > 1.0f) goto L16;
        r16 = r17;
    L16:
        r19 = r20.transform(r16);
        goto L18
    L5:
        r17 = r14 / (((long) r15) * BatteryFactorConfig.WIFI_BPS);
        goto L6
    }

    public float d(long r10, float r12, float r13, float r14) {
        long r11 = a(r10);
        if (r11 >= 0) goto L6;
        return 0.0f;
    L6:
        if (r11 != 0) goto L8;
        return r14;
    L8:
        float r15 = c(r11 - BatteryFactorConfig.WIFI_BPS, r12, r13, r14).floatValue();
        return (c(r11, r12, r13, r14).floatValue() - r15) * 1000.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public String dump() {
        return "FloatTweenSpec(durationMillis: " + this.f21927b + ", delay: " + this.f21928c + ", easing: " + this.f21929d + ')';
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof a) == false) goto L12;
        a r11 = (a) r10;
        if (r11.f21927b == this.f21927b) goto L7;
        return false;
    L7:
        if (r11.f21928c == this.f21928c) goto L9;
        return false;
    L9:
        if (r11.f21929d != this.f21929d) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
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

    public int hashCode() {
        return (((this.f21927b * 31) + this.f21929d.hashCode()) * 31) + this.f21928c;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public boolean isFinishedFromNanos(long r10, long r11) {
        if (r10 < (r11 + (((long) this.f21928c) * BatteryFactorConfig.WIFI_BPS))) goto L5;
        return true;
    L5:
        return false;
    }
}
