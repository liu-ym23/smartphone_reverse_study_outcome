package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001a!\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001aË\u0001\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2>\b\u0002\u0010\u0012\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001b2>\b\u0002\u0010\u001c\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001b\u0010 \u001a\u00020\u0004*\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010 \u001a\u00020\u0004*\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\"\u001a\u0013\u0010%\u001a\u00020#*\u00020#H\u0002¢\u0006\u0004\b&\u0010'\"F\u0010(\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010)\"F\u0010*\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013¢\u0006\u0002\b\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006+"}, d2 = {"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "draggable", "Landroidx/compose/ui/Modifier;", "state", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "reverseDirection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toValidVelocity", "toValidVelocity-TH1AsA0", "(J)J", "NoOpOnDragStarted", "Lkotlin/jvm/functions/Function3;", "NoOpOnDragStopped", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DraggableKt {
    private static final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> NoOpOnDragStarted = null;
    private static final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> NoOpOnDragStopped = null;

    public static /* synthetic */ Unit a(State r100, float r101) {
        return rememberDraggableState$lambda$1$lambda$0(r100, r101);
    }

    static {
        NoOpOnDragStarted = new DraggableKt$NoOpOnDragStarted$1(null);
        NoOpOnDragStopped = new DraggableKt$NoOpOnDragStopped$1(null);
    }

    public static final /* synthetic */ Function3 access$getNoOpOnDragStarted$p() {
        return NoOpOnDragStarted;
    }

    public static final /* synthetic */ Function3 access$getNoOpOnDragStopped$p() {
        return NoOpOnDragStopped;
    }

    public static final DraggableState DraggableState(Function1<? super Float, Unit> r100) {
        return new DefaultDraggableState(r100);
    }

    /* JADX INFO: renamed from: access$toValidVelocity-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ long m437access$toValidVelocityTH1AsA0(long r100) {
        return m440toValidVelocityTH1AsA0(r100);
    }

    /* JADX INFO: renamed from: toValidVelocity-TH1AsA0, reason: not valid java name */
    private static final long m440toValidVelocityTH1AsA0(long r100) {
        float r101 = 0.0f;
        if (Float.isNaN(Velocity.m7786getXimpl(r100)) == false) goto L5;
        float r102 = 0.0f;
    L7:
        if (Float.isNaN(Velocity.m7787getYimpl(r100)) == true) goto L11;
        r101 = Velocity.m7787getYimpl(r100);
    L11:
        return VelocityKt.Velocity(r102, r101);
    L5:
        r102 = Velocity.m7786getXimpl(r100);
        goto L7
    }

    /* JADX INFO: renamed from: access$toFloat-3MmeM6k, reason: not valid java name */
    public static final /* synthetic */ float m435access$toFloat3MmeM6k(long r100, Orientation r101) {
        return m438toFloat3MmeM6k(r100, r101);
    }

    /* JADX INFO: renamed from: access$toFloat-sF-c-tU, reason: not valid java name */
    public static final /* synthetic */ float m436access$toFloatsFctU(long r100, Orientation r101) {
        return m439toFloatsFctU(r100, r101);
    }

    private static final Unit rememberDraggableState$lambda$1$lambda$0(State r100, float r101) {
        ((Function1) r100.getValue()).invoke(Float.valueOf(r101));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: toFloat-3MmeM6k, reason: not valid java name */
    private static final float m438toFloat3MmeM6k(long r100, Orientation r101) {
        if (r101 != Orientation.Vertical) goto L5;
        long r102 = r100 & BodyPartID.bodyIdMax;
    L7:
        return Float.intBitsToFloat((int) r102);
    L5:
        r102 = r100 >> 32;
        goto L7
    }

    /* JADX INFO: renamed from: toFloat-sF-c-tU, reason: not valid java name */
    private static final float m439toFloatsFctU(long r100, Orientation r101) {
        if (r101 != Orientation.Vertical) goto L6;
        return Velocity.m7787getYimpl(r100);
    L6:
        return Velocity.m7786getXimpl(r100);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-183245213, r102, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:130)");
    L5:
        final State r103 = SnapshotStateKt.rememberUpdatedState(r100, r101, r102 & 14);
        Object r104 = r101.rememberedValue();
        if (r104 != Composer.Companion.getEmpty()) goto L8;
        r104 = DraggableState(new q1(r103));
        r101.updateRememberedValue(r104);
    L8:
        DraggableState r105 = (DraggableState) r104;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r105;
    }

    public static final Modifier draggable(Modifier r110, DraggableState r111, Orientation r112, boolean r113, MutableInteractionSource r114, boolean r115, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> r116, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> r117, boolean r118) {
        return r110.then(new DraggableElement(r111, r112, r113, r114, r115, r116, r117, r118));
    }

    public static /* synthetic */ Modifier draggable$default(Modifier r110, DraggableState r111, Orientation r112, boolean r113, MutableInteractionSource r114, boolean r115, Function3 r116, Function3 r117, boolean r118, int r210, Object r211) {
        if ((r210 & 4) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r210 & 8) == 0) goto L9;
        MutableInteractionSource r101 = null;
    L11:
        if ((r210 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r210 & 32) == 0) goto L17;
        Function3 r103 = NoOpOnDragStarted;
    L19:
        if ((r210 & 64) == 0) goto L21;
        Function3 r104 = NoOpOnDragStopped;
    L23:
        if ((r210 & 128) == 0) goto L25;
        boolean r119 = false;
    L27:
        return draggable(r110, r111, r112, r100, r101, r102, r103, r104, r119);
    L25:
        r119 = r118;
        goto L27
    L21:
        r104 = r117;
        goto L23
    L17:
        r103 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
