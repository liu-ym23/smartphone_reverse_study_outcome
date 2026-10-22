package androidx.compose.foundation.gestures;

import C7.r;
import S7.k;
import S7.o;
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
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a¥\u0001\u0010\u001a\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2*\b\u0002\u0010\u0017\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00122*\b\u0002\u0010\u0018\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00122\b\b\u0002\u0010\u0019\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u001e\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u001e\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u001d\u001a\u0016\u0010#\u001a\u00020\u001f*\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\"6\u0010$\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%\"6\u0010&\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Lkotlin/Function1;", "", "LC7/r;", "onDelta", "Landroidx/compose/foundation/gestures/DraggableState;", "DraggableState", "(LS7/k;)Landroidx/compose/foundation/gestures/DraggableState;", "rememberDraggableState", "(LS7/k;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "", "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "startDragImmediately", "Lkotlin/Function3;", "Lm9/z;", "Landroidx/compose/ui/geometry/Offset;", "LH7/c;", "", "onDragStarted", "onDragStopped", "reverseDirection", "draggable", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLS7/o;LS7/o;Z)Landroidx/compose/ui/Modifier;", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "toFloat", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toValidVelocity-TH1AsA0", "(J)J", "toValidVelocity", "NoOpOnDragStarted", "LS7/o;", "NoOpOnDragStopped", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DraggableKt {
    private static final o NoOpOnDragStarted = new DraggableKt$NoOpOnDragStarted$1(null);
    private static final o NoOpOnDragStopped = new DraggableKt$NoOpOnDragStopped$1(null);

    public static final DraggableState DraggableState(k kVar) {
        return new DefaultDraggableState(kVar);
    }

    @Stable
    public static final Modifier draggable(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, o oVar, o oVar2, boolean z12) {
        return modifier.then(new DraggableElement(draggableState, orientation, z10, mutableInteractionSource, z11, oVar, oVar2, z12));
    }

    public static /* synthetic */ Modifier draggable$default(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z10, MutableInteractionSource mutableInteractionSource, boolean z11, o oVar, o oVar2, boolean z12, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = true;
        }
        boolean z13 = z10;
        if ((i & 8) != 0) {
            mutableInteractionSource = null;
        }
        return draggable(modifier, draggableState, orientation, z13, mutableInteractionSource, (i & 16) != 0 ? false : z11, (i & 32) != 0 ? NoOpOnDragStarted : oVar, (i & 64) != 0 ? NoOpOnDragStopped : oVar2, (i & 128) != 0 ? false : z12);
    }

    @Composable
    public static final DraggableState rememberDraggableState(k kVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183245213, i, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:136)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(kVar, composer, i & 14);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = DraggableState(new k() { // from class: androidx.compose.foundation.gestures.DraggableKt$rememberDraggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).floatValue());
                    return r.f317a;
                }

                public final void invoke(float f) {
                    stateRememberUpdatedState.getValue().invoke(Float.valueOf(f));
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        DraggableState draggableState = (DraggableState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return draggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-3MmeM6k, reason: not valid java name */
    public static final float m464toFloat3MmeM6k(long j5, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m3896getYimpl(j5) : Offset.m3895getXimpl(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-sF-c-tU, reason: not valid java name */
    public static final float m465toFloatsFctU(long j5, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m7083getYimpl(j5) : Velocity.m7082getXimpl(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toValidVelocity-TH1AsA0, reason: not valid java name */
    public static final long m466toValidVelocityTH1AsA0(long j5) {
        return VelocityKt.Velocity(Float.isNaN(Velocity.m7082getXimpl(j5)) ? 0.0f : Velocity.m7082getXimpl(j5), Float.isNaN(Velocity.m7083getYimpl(j5)) ? 0.0f : Velocity.m7083getYimpl(j5));
    }
}
