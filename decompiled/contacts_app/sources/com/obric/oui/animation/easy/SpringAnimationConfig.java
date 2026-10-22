package com.obric.oui.animation.easy;

import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.oui.animation.engine.DynamicAnimation;
import com.obric.oui.animation.engine.SpringAnimation;
import com.obric.oui.animation.engine.SpringForce;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpringAnimationConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4Jh\u00105\u001a\u0002012`\u00106\u001a\\\u0012\u0013\u0012\u001103¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020107JS\u0010=\u001a\u0002012K\u00106\u001aG\u0012\u0013\u0012\u001103¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u0002010>R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0004R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR$\u0010\"\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0004R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0004R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0004R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/oui/animation/easy/SpringAnimationConfig;", "", "finalValue", "", "(F)V", "cancelIfRunning", "", "getCancelIfRunning", "()Z", "setCancelIfRunning", "(Z)V", "value", "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "dampingRatioIsSet", "defaultDampingRatio", "getDefaultDampingRatio$OUIAnimation_release", "setDefaultDampingRatio$OUIAnimation_release", "defaultStiffness", "getDefaultStiffness$OUIAnimation_release", "setDefaultStiffness$OUIAnimation_release", "endListener", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationEndListener;", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "skipToEndIfRunning", "getSkipToEndIfRunning", "setSkipToEndIfRunning", "startValue", "getStartValue", "setStartValue", "startValueIsSet", "startVelocity", "getStartVelocity", "setStartVelocity", "startVelocityIsSet", "stiffness", "getStiffness", "setStiffness", "stiffnessIsSet", "updateListener", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "applyTo", "", "animation", "Lcom/obric/oui/animation/engine/SpringAnimation;", "applyTo$OUIAnimation_release", "onEnd", "function", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "spring", "canceled", RealFpsTracer.SCROLL_VELOCITY, "onUpdate", "Lkotlin/Function3;", "Companion", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpringAnimationConfig {
    public static final Companion Companion = null;
    private static final float NOT_SET = 0.0f;
    private boolean cancelIfRunning;
    private float dampingRatio;
    private boolean dampingRatioIsSet;
    private float defaultDampingRatio;
    private float defaultStiffness;
    private DynamicAnimation.OnAnimationEndListener endListener;
    private float finalValue;
    private float maxValue;
    private float minValue;
    private boolean skipToEndIfRunning;
    private float startValue;
    private boolean startValueIsSet;
    private float startVelocity;
    private boolean startVelocityIsSet;
    private float stiffness;
    private boolean stiffnessIsSet;
    private DynamicAnimation.OnAnimationUpdateListener updateListener;

    /* JADX INFO: compiled from: SpringAnimationConfig.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/animation/easy/SpringAnimationConfig$Companion;", "", "()V", "NOT_SET", "", "getNOT_SET", "()F", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final float getNOT_SET() {
            return SpringAnimationConfig.access$getNOT_SET$cp();
        }
    }

    public static /* synthetic */ void $r8$lambda$_d1_O6WipVlVuuG5MyTTgEyIXts(Function4 r0, DynamicAnimation r1, boolean r2, float r3, float r4) {
        m396onEnd$lambda1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$nPbJML4rRnPdkWjjmiMM_4VrXxc(Function3 r0, DynamicAnimation r1, float r2, float r3) {
        m397onUpdate$lambda0(r0, r1, r2, r3);
    }

    public SpringAnimationConfig(float r1) {
        this.finalValue = r1;
        float r2 = NOT_SET;
        this.startValue = r2;
        this.startVelocity = r2;
        this.maxValue = Float.MAX_VALUE;
        this.minValue = -Float.MAX_VALUE;
        this.defaultDampingRatio = 0.5f;
        this.dampingRatio = 0.5f;
        this.defaultStiffness = 1500.0f;
        this.stiffness = 1500.0f;
    }

    public static final /* synthetic */ float access$getNOT_SET$cp() {
        return NOT_SET;
    }

    static {
        Companion = new Companion(null);
        NOT_SET = Float.MAX_VALUE;
    }

    public final float getStartValue() {
        return this.startValue;
    }

    public final void setStartValue(float r2) {
        this.startValueIsSet = true;
        this.startValue = r2;
    }

    public final float getStartVelocity() {
        return this.startVelocity;
    }

    public final void setStartVelocity(float r2) {
        this.startVelocityIsSet = true;
        this.startVelocity = r2;
    }

    public final float getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(float r1) {
        this.maxValue = r1;
    }

    public final float getMinValue() {
        return this.minValue;
    }

    public final void setMinValue(float r1) {
        this.minValue = r1;
    }

    public final float getDefaultDampingRatio$OUIAnimation_release() {
        return this.defaultDampingRatio;
    }

    public final void setDefaultDampingRatio$OUIAnimation_release(float r1) {
        this.defaultDampingRatio = r1;
    }

    public final float getDampingRatio() {
        if (this.dampingRatioIsSet == false) goto L6;
        return this.dampingRatio;
    L6:
        return this.defaultDampingRatio;
    }

    public final void setDampingRatio(float r2) {
        this.dampingRatioIsSet = true;
        this.dampingRatio = r2;
    }

    public final float getDefaultStiffness$OUIAnimation_release() {
        return this.defaultStiffness;
    }

    public final void setDefaultStiffness$OUIAnimation_release(float r1) {
        this.defaultStiffness = r1;
    }

    public final float getStiffness() {
        if (this.stiffnessIsSet == false) goto L6;
        return this.stiffness;
    L6:
        return this.defaultStiffness;
    }

    public final void setStiffness(float r2) {
        this.stiffnessIsSet = true;
        this.stiffness = r2;
    }

    public final boolean getSkipToEndIfRunning() {
        return this.skipToEndIfRunning;
    }

    public final void setSkipToEndIfRunning(boolean r1) {
        this.skipToEndIfRunning = r1;
    }

    public final boolean getCancelIfRunning() {
        return this.cancelIfRunning;
    }

    public final void setCancelIfRunning(boolean r1) {
        this.cancelIfRunning = r1;
    }

    public final void onUpdate(final Function3<? super SpringAnimation, ? super Float, ? super Float, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        this.updateListener = new SpringAnimationConfig$$ExternalSyntheticLambda1(r2);
    }

    /* JADX INFO: renamed from: onUpdate$lambda-0, reason: not valid java name */
    private static final void m397onUpdate$lambda0(Function3 r1, DynamicAnimation r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "$function");
        if (r2 == null) goto L7;
        r1.invoke((SpringAnimation) r2, Float.valueOf(r3), Float.valueOf(r4));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.animation.engine.SpringAnimation");
    }

    public final void onEnd(final Function4<? super SpringAnimation, ? super Boolean, ? super Float, ? super Float, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        this.endListener = new SpringAnimationConfig$$ExternalSyntheticLambda0(r2);
    }

    /* JADX INFO: renamed from: onEnd$lambda-1, reason: not valid java name */
    private static final void m396onEnd$lambda1(Function4 r1, DynamicAnimation r2, boolean r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r1, "$function");
        if (r2 == null) goto L7;
        r1.invoke((SpringAnimation) r2, Boolean.valueOf(r3), Float.valueOf(r4), Float.valueOf(r5));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.animation.engine.SpringAnimation");
    }

    public final void applyTo$OUIAnimation_release(SpringAnimation r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.skipToEndIfRunning == false) goto L6;
        r3.skipToEnd();
    L8:
        r3.setMinValue(this.minValue);
        r3.setMaxValue(this.maxValue);
        if (this.startValueIsSet == false) goto L12;
        r3.setStartValue(this.startValue);
    L12:
        if (this.startVelocityIsSet == false) goto L15;
        r3.setStartVelocity(this.startVelocity);
    L15:
        if (r3.getSpring() != null) goto L17;
        r3.setSpring(new SpringForce());
    L17:
        r3.getSpring().setDampingRatio(getDampingRatio());
        r3.getSpring().setStiffness(getStiffness());
        r3.getSpring().setFinalPosition(this.finalValue);
        if (r3.isRunning() == true) goto L23;
        DynamicAnimation.OnAnimationUpdateListener r0 = this.updateListener;
        if (r0 == null) goto L23;
        r3.addUpdateListener(r0);
    L23:
        if (r3.isRunning() == true) goto L28;
        DynamicAnimation.OnAnimationEndListener r2 = this.endListener;
        if (r2 == null) goto L29;
        r3.addEndListener(r2);
        return;
    L29:
        return;
    L28:
        return;
    L6:
        if (this.cancelIfRunning == false) goto L8;
        r3.cancel();
        goto L8
    }
}
