package com.obric.common.oea.foundation.animation;

import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator;
import com.obric.common.oea.foundation.animation.calculator.FloatAnimationValueCalculator;
import com.obric.common.oea.foundation.animation.calculator.IntAnimationValueCalculator;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AnimationInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u000e\u0010/\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000e\u00100\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\fHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003Jh\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\u0004J\u0013\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0006\u0010:\u001a\u00020\u0014J\u0006\u0010;\u001a\u00020\u0014J\u0013\u0010<\u001a\u00028\u00002\u0006\u0010=\u001a\u00020\u0014¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u0014J\t\u0010@\u001a\u00020AHÖ\u0001J\u000e\u0010B\u001a\u00020!2\u0006\u0010=\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020!J\u001e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0014J\u000e\u0010J\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0014J\u000e\u0010K\u001a\u00020D2\u0006\u0010I\u001a\u00020\u0014J\u000e\u0010L\u001a\u00020D2\u0006\u0010E\u001a\u00020!J\t\u0010M\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006N"}, d2 = {"Lcom/obric/common/oea/foundation/animation/AnimationInfo;", ExifInterface.GPS_DIRECTION_TRUE, "", "property", "", "initialValue", "targetValue", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "", "valueClass", "Lkotlin/reflect/KClass;", "currentVelocity", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;Lkotlin/reflect/KClass;F)V", "getCurrentVelocity", "()F", "setCurrentVelocity", "(F)V", "durationNanos", "", "firstFrameTimeNanos", "getInitialValue", "()Ljava/lang/Object;", "setInitialValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getInitialVelocity", "()Ljava/lang/Float;", "setInitialVelocity", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "isRunning", "", "lastFrameTimeNanos", "getProperty", "()Ljava/lang/String;", "publicDurationNanos", "getPublicDurationNanos", "()J", "getSpec", "()Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "getTargetValue", "setTargetValue", "getValueClass", "()Lkotlin/reflect/KClass;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;Lkotlin/reflect/KClass;F)Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "dump", "equals", "other", "getFirstFrameTimeNanos", "getLastFrameTimeNanos", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "hashCode", "", "isFinishedFromNanos", "reset", "", "running", "reverse", "clearVelocity", "setDurationNanos", "timeNanos", "setFirstFrameTimeNanos", "setLastFrameTimeNanos", "setRunning", "toString", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationInfo<T> {
    private float currentVelocity;
    private long durationNanos;
    private long firstFrameTimeNanos;
    private T initialValue;
    private Float initialVelocity;
    private boolean isRunning;
    private long lastFrameTimeNanos;
    private final String property;
    private final AnimationSpec<T> spec;
    private T targetValue;
    private final KClass<T> valueClass;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimationInfo copy$default(AnimationInfo r5, String r6, Object r7, Object r8, AnimationSpec r9, Float r10, KClass r11, float r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.property;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.initialValue;
    L8:
        Object r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.targetValue;
    L11:
        Object r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.spec;
    L14:
        AnimationSpec r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.initialVelocity;
    L17:
        Float r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.valueClass;
    L20:
        KClass r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.currentVelocity;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.property;
    }

    public final T component2() {
        return this.initialValue;
    }

    public final T component3() {
        return this.targetValue;
    }

    public final AnimationSpec<T> component4() {
        return this.spec;
    }

    public final Float component5() {
        return this.initialVelocity;
    }

    public final KClass<T> component6() {
        return this.valueClass;
    }

    public final float component7() {
        return this.currentVelocity;
    }

    public final AnimationInfo<T> copy(String r9, T r10, T r11, AnimationSpec<T> r12, Float r13, KClass<T> r14, float r15) {
        Intrinsics.checkNotNullParameter(r9, "property");
        Intrinsics.checkNotNullParameter(r10, "initialValue");
        Intrinsics.checkNotNullParameter(r11, "targetValue");
        Intrinsics.checkNotNullParameter(r12, "spec");
        Intrinsics.checkNotNullParameter(r14, "valueClass");
        return new AnimationInfo(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnimationInfo) == false) goto L20;
        AnimationInfo r4 = (AnimationInfo) r3;
        if (Intrinsics.areEqual(this.property, r4.property) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.initialValue, r4.initialValue) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.targetValue, r4.targetValue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.spec, r4.spec) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.initialVelocity, r4.initialVelocity) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.valueClass, r4.valueClass) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.currentVelocity, r4.currentVelocity) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.property;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        T r4 = this.initialValue;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        T r7 = this.targetValue;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        AnimationSpec<T> r10 = this.spec;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.initialVelocity;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        KClass<T> r16 = this.valueClass;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return ((r15 + r1) * 31) + Float.hashCode(this.currentVelocity);
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AnimationInfo(property=" + this.property + ", initialValue=" + this.initialValue + ", targetValue=" + this.targetValue + ", spec=" + this.spec + ", initialVelocity=" + this.initialVelocity + ", valueClass=" + this.valueClass + ", currentVelocity=" + this.currentVelocity + ")";
    }

    public AnimationInfo(String r2, T r3, T r4, AnimationSpec<T> r5, Float r6, KClass<T> r7, float r8) {
        Intrinsics.checkNotNullParameter(r2, "property");
        Intrinsics.checkNotNullParameter(r3, "initialValue");
        Intrinsics.checkNotNullParameter(r4, "targetValue");
        Intrinsics.checkNotNullParameter(r5, "spec");
        Intrinsics.checkNotNullParameter(r7, "valueClass");
        this.property = r2;
        this.initialValue = r3;
        this.targetValue = r4;
        this.spec = r5;
        this.initialVelocity = r6;
        this.valueClass = r7;
        this.currentVelocity = r8;
        this.durationNanos = -1;
        this.firstFrameTimeNanos = -1;
        this.lastFrameTimeNanos = -1;
        this.isRunning = true;
    }

    public final String getProperty() {
        return this.property;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public final void setInitialValue(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.initialValue = r2;
    }

    public final T getTargetValue() {
        return this.targetValue;
    }

    public final void setTargetValue(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.targetValue = r2;
    }

    public final AnimationSpec<T> getSpec() {
        return this.spec;
    }

    public final Float getInitialVelocity() {
        return this.initialVelocity;
    }

    public final void setInitialVelocity(Float r1) {
        this.initialVelocity = r1;
    }

    public final KClass<T> getValueClass() {
        return this.valueClass;
    }

    public /* synthetic */ AnimationInfo(String r10, Object r11, Object r12, AnimationSpec r13, Float r14, KClass r15, float r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 64) == 0) goto L5;
        float r8 = 0.0f;
    L6:
        this(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final float getCurrentVelocity() {
        return this.currentVelocity;
    }

    public final void setCurrentVelocity(float r1) {
        this.currentVelocity = r1;
    }

    public final long getPublicDurationNanos() {
        if (this.durationNanos >= 0) goto L10;
        AnimationSpec<T> r0 = this.spec;
        T r1 = this.initialValue;
        T r2 = this.targetValue;
        Float r3 = this.initialVelocity;
        if (r3 == null) goto L7;
        float r4 = r3.floatValue();
    L8:
        this.durationNanos = r0.getDurationNanos(r1, r2, r4);
        goto L10
    L7:
        r4 = 0.0f;
    L10:
        return this.durationNanos;
    }

    public final void setDurationNanos(long r1) {
        this.durationNanos = r1;
    }

    public final void setFirstFrameTimeNanos(long r1) {
        this.firstFrameTimeNanos = r1;
    }

    public final long getFirstFrameTimeNanos() {
        return this.firstFrameTimeNanos;
    }

    public final void setLastFrameTimeNanos(long r1) {
        this.lastFrameTimeNanos = r1;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final void setRunning(boolean r1) {
        this.isRunning = r1;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public final T getValueFromNanos(long r9) {
        KClass<T> r0 = this.valueClass;
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L11;
        FloatAnimationValueCalculator r1 = FloatAnimationValueCalculator.INSTANCE;
        if (r1 == null) goto L9;
        IntAnimationValueCalculator r2 = r1;
    L7:
        AnimationValueCalculator r3 = r2;
        T r4 = this.initialValue;
        T r5 = this.targetValue;
        Float r6 = this.initialVelocity;
        if (r6 == null) goto L18;
        float r7 = r6.floatValue();
    L20:
        return (T) r3.getValueFromNanos(r9, r4, r5, r7, this.spec);
    L18:
        r7 = 0.0f;
        goto L20
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L11:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L24;
        IntAnimationValueCalculator r8 = IntAnimationValueCalculator.INSTANCE;
        if (r8 == null) goto L22;
        r2 = r8;
        goto L7
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L24:
        throw new IllegalArgumentException("Unsupported type " + this.valueClass);
    }

    public final float getVelocityVectorFromNanos(long r9) {
        KClass<T> r0 = this.valueClass;
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L11;
        FloatAnimationValueCalculator r1 = FloatAnimationValueCalculator.INSTANCE;
        if (r1 == null) goto L9;
        IntAnimationValueCalculator r2 = r1;
    L7:
        AnimationValueCalculator r3 = r2;
        T r4 = this.initialValue;
        T r5 = this.targetValue;
        Float r6 = this.initialVelocity;
        if (r6 == null) goto L18;
        float r7 = r6.floatValue();
    L19:
        float r10 = r3.getVelocityFromNanos(r9, r4, r5, r7, this.spec);
        this.currentVelocity = r10;
        return r10;
    L18:
        r7 = 0.0f;
        goto L19
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L11:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L24;
        IntAnimationValueCalculator r8 = IntAnimationValueCalculator.INSTANCE;
        if (r8 == null) goto L22;
        r2 = r8;
        goto L7
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L24:
        throw new IllegalArgumentException("Unsupported type " + this.valueClass);
    }

    public final boolean isFinishedFromNanos(long r8) {
        KClass<T> r0 = this.valueClass;
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L11;
        FloatAnimationValueCalculator r1 = FloatAnimationValueCalculator.INSTANCE;
        if (r1 == null) goto L9;
        IntAnimationValueCalculator r2 = r1;
    L16:
        return r2.isFinishedFromNanos(r8, getPublicDurationNanos(), this.spec);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L11:
        if (Intrinsics.areEqual(r0, Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L20;
        IntAnimationValueCalculator r3 = IntAnimationValueCalculator.INSTANCE;
        if (r3 == null) goto L18;
        r2 = r3;
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.calculator.AnimationValueCalculator<T>");
    L20:
        throw new IllegalArgumentException("Unsupported type " + this.valueClass);
    }

    public final void reset(boolean r3, boolean r4, boolean r5) {
        this.isRunning = r3;
        if (r5 == false) goto L5;
        float r6 = 0.0f;
    L6:
        this.currentVelocity = r6;
        this.firstFrameTimeNanos = -1;
        this.lastFrameTimeNanos = -1;
        if (r4 == false) goto L10;
        T r7 = this.initialValue;
        this.initialValue = this.targetValue;
        this.targetValue = r7;
        return;
    L10:
        return;
    L5:
        r6 = this.currentVelocity;
        goto L6
    }

    public final String dump() {
        return "AnimationInfo(property: " + this.property + ", initialValue: " + this.initialValue + ", targetValue: " + this.targetValue + ", spec: " + this.spec.dump() + ", initialVelocity: " + this.initialVelocity + ", valueClass: " + this.valueClass + ", currentVelocity: " + this.currentVelocity + ", durationNanos: " + this.durationNanos + ", firstFrameTimeNanos: " + this.firstFrameTimeNanos + ", lastFrameTimeNanos: " + this.lastFrameTimeNanos + ", isRunning: " + this.isRunning + ')';
    }
}
