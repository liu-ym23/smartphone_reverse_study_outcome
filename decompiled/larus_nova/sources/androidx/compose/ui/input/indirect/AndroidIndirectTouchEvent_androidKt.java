package androidx.compose.ui.input.indirect;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\r\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"nativeEvent", "Landroid/view/MotionEvent;", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "getNativeEvent$annotations", "(Landroidx/compose/ui/input/indirect/IndirectTouchEvent;)V", "getNativeEvent", "(Landroidx/compose/ui/input/indirect/IndirectTouchEvent;)Landroid/view/MotionEvent;", "IndirectTouchEvent", "motionEvent", "convertActionToIndirectTouchEventType", "Landroidx/compose/ui/input/indirect/IndirectTouchEventType;", "actionMasked", "", "(I)I", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidIndirectTouchEvent_androidKt {
    public static /* synthetic */ void getNativeEvent$annotations(IndirectTouchEvent r100) {
    }

    public static final IndirectTouchEvent IndirectTouchEvent(MotionEvent r100) {
        float r101 = r100.getX();
        float r102 = r100.getY();
        long r103 = Float.floatToRawIntBits(r101);
        return new AndroidIndirectTouchEvent(Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax) | (r103 << 32)), r100.getEventTime(), convertActionToIndirectTouchEventType(r100.getActionMasked()), r100, null);
    }

    public static final int convertActionToIndirectTouchEventType(int r100) {
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L13;
        return IndirectTouchEventType.Companion.m5663getUnknownLxEHWp8();
    L13:
        return IndirectTouchEventType.Companion.m5660getMoveLxEHWp8();
    L14:
        return IndirectTouchEventType.Companion.m5662getReleaseLxEHWp8();
    L11:
        return IndirectTouchEventType.Companion.m5661getPressLxEHWp8();
    }

    public static final MotionEvent getNativeEvent(IndirectTouchEvent r100) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.ui.input.indirect.AndroidIndirectTouchEvent");
        return ((AndroidIndirectTouchEvent) r100).getNativeEvent$ui_release();
    }
}
