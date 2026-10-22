package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a&\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0000\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"toMotionEventScope", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "offset", "Landroidx/compose/ui/geometry/Offset;", "block", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "toMotionEventScope-d-4ec7I", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;)V", "toCancelMotionEventScope", "toCancelMotionEventScope-d-4ec7I", "emptyCancelMotionEventScope", "nowMillis", "", "cancel", "", "toMotionEventScope-ubNVwUQ", "(Landroidx/compose/ui/input/pointer/PointerEvent;JLkotlin/jvm/functions/Function1;Z)V", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long r100, Function1<? super MotionEvent, Unit> r110) {
        MotionEvent r101 = MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0);
        r101.setSource(0);
        r110.invoke(r101);
        r101.recycle();
    }

    /* JADX INFO: renamed from: toCancelMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m6185toCancelMotionEventScoped4ec7I(PointerEvent r100, long r101, Function1<? super MotionEvent, Unit> r102) {
        m6187toMotionEventScopeubNVwUQ(r100, r101, r102, true);
    }

    /* JADX INFO: renamed from: toMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m6186toMotionEventScoped4ec7I(PointerEvent r100, long r101, Function1<? super MotionEvent, Unit> r102) {
        m6187toMotionEventScopeubNVwUQ(r100, r101, r102, false);
    }

    public static /* synthetic */ void emptyCancelMotionEventScope$default(long r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = SystemClock.uptimeMillis();
    L5:
        emptyCancelMotionEventScope(r100, r101);
    }

    /* JADX INFO: renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    private static final void m6187toMotionEventScopeubNVwUQ(PointerEvent r100, long r101, Function1<? super MotionEvent, Unit> r102, boolean r103) {
        MotionEvent r104 = r100.getMotionEvent();
        if (r104 == null) goto L10;
        int r105 = r104.getAction();
        if (r103 == false) goto L7;
        r104.setAction(3);
    L7:
        int r106 = (int) (r101 >> 32);
        float r107 = -Float.intBitsToFloat(r106);
        int r108 = (int) (r101 & BodyPartID.bodyIdMax);
        r104.offsetLocation(r107, -Float.intBitsToFloat(r108));
        r102.invoke(r104);
        r104.offsetLocation(Float.intBitsToFloat(r106), Float.intBitsToFloat(r108));
        r104.setAction(r105);
        return;
    L10:
        throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
    }
}
