package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\u0010\u0010\u0017\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJ$\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0097\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\r\u0010&\u001a\u00020\u001d*\u00020\u001dH\u0097\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/foundation/layout/BoxScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "minWidth", "Landroidx/compose/ui/unit/Dp;", "getMinWidth-D9Ej5fM", "()F", "maxWidth", "getMaxWidth-D9Ej5fM", "minHeight", "getMinHeight-D9Ej5fM", "maxHeight", "getMaxHeight-D9Ej5fM", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "equals", "", "other", "", "hashCode", "", "matchParentSize", "toString", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {
    private final /* synthetic */ BoxScopeInstance $$delegate_0;
    private final long constraints;
    private final Density density;

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    private final Density component1() {
        return this.density;
    }

    /* JADX INFO: renamed from: copy-0kLqBqw$default, reason: not valid java name */
    public static /* synthetic */ BoxWithConstraintsScopeImpl m642copy0kLqBqw$default(BoxWithConstraintsScopeImpl r100, Density r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.density;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.constraints;
    L9:
        return r100.m644copy0kLqBqw(r101, r102);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier align(Modifier r100, Alignment r101) {
        return this.$$delegate_0.align(r100, r101);
    }

    /* JADX INFO: renamed from: component2-msEJaDk, reason: not valid java name */
    public final long m643component2msEJaDk() {
        return this.constraints;
    }

    /* JADX INFO: renamed from: copy-0kLqBqw, reason: not valid java name */
    public final BoxWithConstraintsScopeImpl m644copy0kLqBqw(Density r100, long r101) {
        return new BoxWithConstraintsScopeImpl(r100, r101, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BoxWithConstraintsScopeImpl) == true) goto L8;
        return false;
    L8:
        BoxWithConstraintsScopeImpl r101 = (BoxWithConstraintsScopeImpl) r100;
        if (Intrinsics.areEqual(this.density, r101.density) == true) goto L12;
        return false;
    L12:
        if (Constraints.m7480equalsimpl0(this.constraints, r101.constraints) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m7490hashCodeimpl(this.constraints);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    public Modifier matchParentSize(Modifier r100) {
        return this.$$delegate_0.matchParentSize(r100);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + Constraints.m7492toStringimpl(this.constraints) + ')';
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM */
    public float mo638getMaxHeightD9Ej5fM() {
        Density r100 = this.density;
        if (Constraints.m7482getHasBoundedHeightimpl(mo637getConstraintsmsEJaDk()) == false) goto L6;
        return r100.mo368toDpu2uoSUM(Constraints.m7486getMaxHeightimpl(mo637getConstraintsmsEJaDk()));
    L6:
        return Dp.Companion.m7563getInfinityD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM */
    public float mo639getMaxWidthD9Ej5fM() {
        Density r100 = this.density;
        if (Constraints.m7483getHasBoundedWidthimpl(mo637getConstraintsmsEJaDk()) == false) goto L6;
        return r100.mo368toDpu2uoSUM(Constraints.m7487getMaxWidthimpl(mo637getConstraintsmsEJaDk()));
    L6:
        return Dp.Companion.m7563getInfinityD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM */
    public float mo640getMinHeightD9Ej5fM() {
        return this.density.mo368toDpu2uoSUM(Constraints.m7488getMinHeightimpl(mo637getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM */
    public float mo641getMinWidthD9Ej5fM() {
        return this.density.mo368toDpu2uoSUM(Constraints.m7489getMinWidthimpl(mo637getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo637getConstraintsmsEJaDk() {
        return this.constraints;
    }

    private BoxWithConstraintsScopeImpl(Density r100, long r101) {
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
        this.density = r100;
        this.constraints = r101;
    }
}
