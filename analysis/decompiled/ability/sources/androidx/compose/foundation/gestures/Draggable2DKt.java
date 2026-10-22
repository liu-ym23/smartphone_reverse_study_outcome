package androidx.compose.foundation.gestures;

import C7.c;
import C7.r;
import S7.k;
import S7.o;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u001a#\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aq\u0010\u0014\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u009d\u0001\u0010\u0014\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2*\b\u0002\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00162*\b\u0002\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u001a\"6\u0010\u001b\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\" \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\"6\u0010\u001f\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001c\" \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "LC7/r;", "onDelta", "Landroidx/compose/foundation/gestures/Draggable2DState;", "Draggable2DState", "(LS7/k;)Landroidx/compose/foundation/gestures/Draggable2DState;", "rememberDraggable2DState", "(LS7/k;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/Draggable2DState;", "Landroidx/compose/ui/Modifier;", "state", "", "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "startDragImmediately", "onDragStarted", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped", "reverseDirection", "draggable2D", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLS7/k;LS7/k;Z)Landroidx/compose/ui/Modifier;", "Lkotlin/Function3;", "Lm9/z;", "LH7/c;", "", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLS7/o;LS7/o;Z)Landroidx/compose/ui/Modifier;", "NoOpOnDragStarted", "LS7/o;", "NoOpOnDragStart", "LS7/k;", "NoOpOnDragStopped", "NoOpOnDragStop", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Draggable2DKt {
    private static final o NoOpOnDragStarted = new Draggable2DKt$NoOpOnDragStarted$1(null);
    private static final k NoOpOnDragStart = new k() { // from class: androidx.compose.foundation.gestures.Draggable2DKt$NoOpOnDragStart$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m452invokek4lQ0M(((Offset) obj).m3905unboximpl());
            return r.f317a;
        }

        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m452invokek4lQ0M(long j5) {
        }
    };
    private static final o NoOpOnDragStopped = new Draggable2DKt$NoOpOnDragStopped$1(null);
    private static final k NoOpOnDragStop = new k() { // from class: androidx.compose.foundation.gestures.Draggable2DKt$NoOpOnDragStop$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m454invokeTH1AsA0(((Velocity) obj).getPackedValue());
            return r.f317a;
        }

        /* renamed from: invoke-TH1AsA0, reason: not valid java name */
        public final void m454invokeTH1AsA0(long j5) {
        }
    };

    @ExperimentalFoundationApi
    public static final Draggable2DState Draggable2DState(k kVar) {
        return new DefaultDraggable2DState(kVar);
    }

    @Stable
    @ExperimentalFoundationApi
    public static final Modifier draggable2D(Modifier modifier, Draggable2DState draggable2DState, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, k kVar, k kVar2, boolean z12) {
        return modifier.then(new Draggable2DElement(draggable2DState, z10, mutableInteractionSource, z11, kVar, kVar2, z12));
    }

    @Composable
    @ExperimentalFoundationApi
    public static final Draggable2DState rememberDraggable2DState(k kVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1150277615, i, -1, "androidx.compose.foundation.gestures.rememberDraggable2DState (Draggable2D.kt:120)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(kVar, composer, i & 14);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = Draggable2DState(new k() { // from class: androidx.compose.foundation.gestures.Draggable2DKt$rememberDraggable2DState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m456invokek4lQ0M(((Offset) obj).m3905unboximpl());
                    return r.f317a;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m456invokek4lQ0M(long j5) {
                    stateRememberUpdatedState.getValue().invoke(Offset.m3884boximpl(j5));
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        Draggable2DState draggable2DState = (Draggable2DState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return draggable2DState;
    }

    @Stable
    @c
    @ExperimentalFoundationApi
    public static final /* synthetic */ Modifier draggable2D(Modifier modifier, Draggable2DState draggable2DState, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, o oVar, o oVar2, boolean z12) {
        return modifier.then(new Draggable2DCompatElement(draggable2DState, z10, mutableInteractionSource, z11, oVar, oVar2, z12));
    }
}
