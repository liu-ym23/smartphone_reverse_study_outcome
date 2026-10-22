package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.TransformOrigin;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J4\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Landroidx/compose/animation/Scale;", "", "scale", "", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "<init>", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScale", "()F", "getTransformOrigin-SzJe1aQ", "()J", "J", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "component1", "component2", "component2-SzJe1aQ", "component3", "copy", "copy-bnNdC4k", "(FJLandroidx/compose/animation/core/FiniteAnimationSpec;)Landroidx/compose/animation/Scale;", "equals", "", "other", "hashCode", "", "toString", "", GXTemplateKey.GAIAX_ANIMATION}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Scale {
    public static final int $stable = 0;
    private final FiniteAnimationSpec<Float> animationSpec;
    private final float scale;
    private final long transformOrigin;

    public /* synthetic */ Scale(float r100, long r101, FiniteAnimationSpec r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-bnNdC4k$default, reason: not valid java name */
    public static /* synthetic */ Scale m101copybnNdC4k$default(Scale r100, float r101, long r102, FiniteAnimationSpec r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.scale;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.transformOrigin;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.animationSpec;
    L12:
        return r100.m103copybnNdC4k(r101, r102, r103);
    }

    public final float component1() {
        return this.scale;
    }

    /* JADX INFO: renamed from: component2-SzJe1aQ, reason: not valid java name */
    public final long m102component2SzJe1aQ() {
        return this.transformOrigin;
    }

    public final FiniteAnimationSpec<Float> component3() {
        return this.animationSpec;
    }

    /* JADX INFO: renamed from: copy-bnNdC4k, reason: not valid java name */
    public final Scale m103copybnNdC4k(float r100, long r101, FiniteAnimationSpec<Float> r110) {
        return new Scale(r100, r101, r110, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Scale) == true) goto L8;
        return false;
    L8:
        Scale r101 = (Scale) r100;
        if (Float.compare(this.scale, r101.scale) == 0) goto L12;
        return false;
    L12:
        if (TransformOrigin.m5238equalsimpl0(this.transformOrigin, r101.transformOrigin) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.animationSpec, r101.animationSpec) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.scale) * 31) + TransformOrigin.m5241hashCodeimpl(this.transformOrigin)) * 31) + this.animationSpec.hashCode();
    }

    public String toString() {
        return "Scale(scale=" + this.scale + ", transformOrigin=" + TransformOrigin.m5242toStringimpl(this.transformOrigin) + ", animationSpec=" + this.animationSpec + ')';
    }

    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final float getScale() {
        return this.scale;
    }

    /* JADX INFO: renamed from: getTransformOrigin-SzJe1aQ, reason: not valid java name */
    public final long m104getTransformOriginSzJe1aQ() {
        return this.transformOrigin;
    }

    private Scale(float r100, long r101, FiniteAnimationSpec<Float> r102) {
        this.scale = r100;
        this.transformOrigin = r101;
        this.animationSpec = r102;
    }
}
