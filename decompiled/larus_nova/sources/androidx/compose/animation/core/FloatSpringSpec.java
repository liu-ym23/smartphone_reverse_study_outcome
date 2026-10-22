package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/FloatSpringSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "<init>", "(FFF)V", "getDampingRatio", "()F", "getStiffness", "spring", "Landroidx/compose/animation/core/SpringSimulation;", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "getVelocityFromNanos", "getEndVelocity", "getDurationNanos", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatSpringSpec implements FloatAnimationSpec {
    public static final int $stable = 8;
    private final float dampingRatio;
    private final SpringSimulation spring;
    private final float stiffness;
    private final float visibilityThreshold;

    public FloatSpringSpec() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getEndVelocity(float r100, float r101, float r102) {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* bridge */ /* synthetic */ VectorizedAnimationSpec vectorize(TwoWayConverter r100) {
        return FloatAnimationSpec.CC.$default$vectorize(this, r100);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec, androidx.compose.animation.core.AnimationSpec
    public final /* synthetic */ VectorizedFloatAnimationSpec vectorize(TwoWayConverter r100) {
        return FloatAnimationSpec.CC.m155$default$vectorize(this, r100);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getStiffness() {
        return this.stiffness;
    }

    public FloatSpringSpec(float r100, float r101, float r102) {
        this.dampingRatio = r100;
        this.stiffness = r101;
        this.visibilityThreshold = r102;
        SpringSimulation r103 = new SpringSimulation(1.0f);
        r103.setDampingRatio(r100);
        r103.setStiffness(r101);
        this.spring = r103;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long getDurationNanos(float r100, float r101, float r102) {
        float r103 = this.spring.getStiffness();
        float r104 = this.spring.getDampingRatio();
        float r105 = r100 - r101;
        float r106 = this.visibilityThreshold;
        float r107 = r102 / r106;
        return SpringEstimationKt.estimateAnimationDurationMillis(r103, r104, r107, r105 / r106, 1.0f) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getValueFromNanos(long r100, float r101, float r102, float r103) {
        this.spring.setFinalPosition(r102);
        SpringSimulation r104 = this.spring;
        return Float.intBitsToFloat((int) (r104.m170updateValuesIJZedt4$animation_core(r101, r103, r100 / 1000000) >> 32));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float getVelocityFromNanos(long r100, float r101, float r102, float r103) {
        this.spring.setFinalPosition(r102);
        SpringSimulation r104 = this.spring;
        return Float.intBitsToFloat((int) (r104.m170updateValuesIJZedt4$animation_core(r101, r103, r100 / 1000000) & BodyPartID.bodyIdMax));
    }

    public /* synthetic */ FloatSpringSpec(float r100, float r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 1.0f;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 1500.0f;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0.01f;
    L11:
        this(r100, r101, r102);
    }
}
