package com.obric.common.oea.foundation.animation.spec.tween;

import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.token.CubicBezierEasing;
import com.obric.common.oea.foundation.animation.token.OEasingKt;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FloatTweenSpec.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J-\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/tween/FloatTweenSpec;", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", "durationMillis", "", "delay", "easing", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "(IILcom/obric/common/oea/foundation/animation/token/Token$Easing;)V", "TAG", "", "getDelay", "()I", "getDurationMillis", "getEasing", "()Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "clampPlayTimeNanos", "", "playTimeNanos", "dump", "equals", "", "other", "", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "getValueFromNanos", "(JFFF)Ljava/lang/Float;", "getVelocityFromNanos", "hashCode", "isFinishedFromNanos", "durationNanos", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatTweenSpec implements AnimationSpec<Float> {
    private final String TAG;
    private final int delay;
    private final int durationMillis;
    private final Token.Easing easing;

    public FloatTweenSpec() {
        this(0, 0, null, 7, null);
    }

    public FloatTweenSpec(int r2, int r3, Token.Easing r4) {
        Intrinsics.checkNotNullParameter(r4, "easing");
        this.durationMillis = r2;
        this.delay = r3;
        this.easing = r4;
        this.TAG = "FloatTweenSpec";
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ long getDurationNanos(Float r1, Float r2, float r3) {
        return getDurationNanos(r1.floatValue(), r2.floatValue(), r3);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ Float getValueFromNanos(long r7, Float r9, Float r10, float r11) {
        return getValueFromNanos(r7, r9.floatValue(), r10.floatValue(), r11);
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public /* bridge */ /* synthetic */ float getVelocityFromNanos(long r7, Float r9, Float r10, float r11) {
        return getVelocityFromNanos(r7, r9.floatValue(), r10.floatValue(), r11);
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final int getDelay() {
        return this.delay;
    }

    public /* synthetic */ FloatTweenSpec(int r1, int r2, Token.Easing r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 300;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = Token.Easing.OUI_ANIMATION_EASING_STANDARD;
    L11:
        this(r1, r2, r3);
    }

    public final Token.Easing getEasing() {
        return this.easing;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public String dump() {
        return "FloatTweenSpec(durationMillis: " + this.durationMillis + ", delay: " + this.delay + ", easing: " + this.easing + ')';
    }

    public Float getValueFromNanos(long r6, float r8, float r9, float r10) {
        long r7 = clampPlayTimeNanos(r6);
        int r11 = this.durationMillis;
        float r0 = 1.0f;
        if (r11 != 0) goto L5;
        float r12 = 1.0f;
    L6:
        Token.Easing r13 = this.easing;
        Token.Easing r14 = Token.Easing.OUI_ANIMATION_EASING_LINEAR;
        Token.Easing r5 = this.easing;
        if (r13 != r14) goto L9;
        float r15 = TokenKt.toLinearEasing(r5).transform(r12);
    L18:
        return Float.valueOf(OEasingKt.lerp(r8, r9, r15));
    L9:
        CubicBezierEasing r16 = TokenKt.toCubicBezierEasing(r5);
        if (r12 >= 0.0f) goto L13;
        r12 = 0.0f;
    L13:
        if (r12 > 1.0f) goto L16;
        r0 = r12;
    L16:
        r15 = r16.transform(r0);
        goto L18
    L5:
        r12 = r7 / (((long) r11) * 1000000);
        goto L6
    }

    public long getDurationNanos(float r1, float r2, float r3) {
        return ((long) this.durationMillis) * 1000000;
    }

    private final long clampPlayTimeNanos(long r11) {
        return RangesKt.coerceIn(r11 - (((long) this.delay) * 1000000), 0, ((long) this.durationMillis) * 1000000);
    }

    public float getVelocityFromNanos(long r10, float r12, float r13, float r14) {
        long r1 = clampPlayTimeNanos(r10);
        if (r1 >= 0) goto L6;
        return 0.0f;
    L6:
        if (r1 != 0) goto L8;
        return r14;
    L8:
        float r11 = getValueFromNanos(r1 - 1000000, r12, r13, r14).floatValue();
        return (getValueFromNanos(r1, r12, r13, r14).floatValue() - r11) * 1000.0f;
    }

    @Override // com.obric.common.oea.foundation.animation.spec.AnimationSpec
    public boolean isFinishedFromNanos(long r5, long r7) {
        if (r5 < (r7 + (((long) this.delay) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof FloatTweenSpec) == false) goto L12;
        FloatTweenSpec r5 = (FloatTweenSpec) r4;
        if (r5.durationMillis == this.durationMillis) goto L7;
        return false;
    L7:
        if (r5.delay == this.delay) goto L9;
        return false;
    L9:
        if (r5.easing != this.easing) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        return (((this.durationMillis * 31) + this.easing.hashCode()) * 31) + this.delay;
    }
}
