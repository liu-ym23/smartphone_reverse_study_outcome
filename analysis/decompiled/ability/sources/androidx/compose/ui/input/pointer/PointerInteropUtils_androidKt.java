package androidx.compose.ui.input.pointer;

import S7.k;
import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a/\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u000b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0000¢\u0006\u0004\b\n\u0010\b\u001a-\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "LC7/r;", "block", "toMotionEventScope-d-4ec7I", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLS7/k;)V", "toMotionEventScope", "toCancelMotionEventScope-d-4ec7I", "toCancelMotionEventScope", "", "nowMillis", "emptyCancelMotionEventScope", "(JLS7/k;)V", "", "cancel", "toMotionEventScope-ubNVwUQ", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLS7/k;Z)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long j5, k kVar) {
        MotionEvent motionEventObtain = MotionEvent.obtain(j5, j5, 3, 0.0f, 0.0f, 0);
        motionEventObtain.setSource(0);
        kVar.invoke(motionEventObtain);
        motionEventObtain.recycle();
    }

    public static /* synthetic */ void emptyCancelMotionEventScope$default(long j5, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = SystemClock.uptimeMillis();
        }
        emptyCancelMotionEventScope(j5, kVar);
    }

    /* renamed from: toCancelMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m5479toCancelMotionEventScoped4ec7I(PointerEvent pointerEvent, long j5, k kVar) {
        m5481toMotionEventScopeubNVwUQ(pointerEvent, j5, kVar, true);
    }

    /* renamed from: toMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m5480toMotionEventScoped4ec7I(PointerEvent pointerEvent, long j5, k kVar) {
        m5481toMotionEventScopeubNVwUQ(pointerEvent, j5, kVar, false);
    }

    /* renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    private static final void m5481toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j5, k kVar, boolean z10) {
        MotionEvent motionEvent = pointerEvent.getMotionEvent();
        if (motionEvent == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.");
        }
        int action = motionEvent.getAction();
        if (z10) {
            motionEvent.setAction(3);
        }
        int i = (int) (j5 >> 32);
        int i6 = (int) (j5 & 4294967295L);
        motionEvent.offsetLocation(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i6));
        kVar.invoke(motionEvent);
        motionEvent.offsetLocation(Float.intBitsToFloat(i), Float.intBitsToFloat(i6));
        motionEvent.setAction(action);
    }
}
