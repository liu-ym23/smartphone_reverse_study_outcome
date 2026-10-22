package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J<\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Landroidx/compose/foundation/WrappedOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "attachNode", "", "eventHandlingEnabled", "innerOverscrollEffect", "<init>", "(ZZLandroidx/compose/foundation/OverscrollEffect;)V", "applyToScroll", "Landroidx/compose/ui/geometry/Offset;", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isInProgress", "()Z", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "equals", "other", "hashCode", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class WrappedOverscrollEffect implements OverscrollEffect {
    private final boolean attachNode;
    private final boolean eventHandlingEnabled;
    private final OverscrollEffect innerOverscrollEffect;
    private final DelegatableNode node;

    @Override // androidx.compose.foundation.OverscrollEffect
    public final /* synthetic */ Modifier getEffectModifier() {
        return OverscrollEffect.CC.$default$getEffectModifier(this);
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.attachNode == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.eventHandlingEnabled == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.innerOverscrollEffect.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        return this.innerOverscrollEffect.isInProgress();
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.node;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WrappedOverscrollEffect) == true) goto L8;
        return false;
    L8:
        WrappedOverscrollEffect r101 = (WrappedOverscrollEffect) r100;
        if (this.attachNode == r101.attachNode) goto L12;
        return false;
    L12:
        if (this.eventHandlingEnabled == r101.eventHandlingEnabled) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.innerOverscrollEffect, r101.innerOverscrollEffect) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public WrappedOverscrollEffect(boolean r100, boolean r101, OverscrollEffect r102) {
        this.attachNode = r100;
        this.eventHandlingEnabled = r101;
        this.innerOverscrollEffect = r102;
        if (r100 == false) goto L5;
        DelegatableNode r103 = r102.getNode();
    L6:
        this.node = r103;
        return;
    L5:
        r103 = new WrappedOverscrollEffect$node$1();
        goto L6
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToFling-BMRW4eQ */
    public Object mo210applyToFlingBMRW4eQ(long r100, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if (this.eventHandlingEnabled == false) goto L9;
        Object r103 = this.innerOverscrollEffect.mo210applyToFlingBMRW4eQ(r100, r101, r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r103;
    L8:
        return Unit.INSTANCE;
    L9:
        Object r104 = r101.invoke(Velocity.m7777boximpl(r100), r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r104;
    L13:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* JADX INFO: renamed from: applyToScroll-Rhakbz0 */
    public long mo211applyToScrollRhakbz0(long r100, int r101, Function1<? super Offset, Offset> r102) {
        if (this.eventHandlingEnabled == false) goto L6;
        return this.innerOverscrollEffect.mo211applyToScrollRhakbz0(r100, r101, r102);
    L6:
        return r102.invoke(Offset.m4571boximpl(r100)).m4592unboximpl();
    }
}
