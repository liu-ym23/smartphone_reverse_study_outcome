package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.sva.sdk.data.ISmModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010#\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010\u0015J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010&\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u00020\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u001a\u001a\u00020\u001b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0015R&\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "<init>", "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "(Ljava/util/List;)V", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "classification", "", "getClassification", "()I", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "I", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "value", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final int classification;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public final MotionEvent getMotionEvent() {
        InternalPointerEvent r100 = this.internalPointerEvent;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMotionEvent();
    }

    /* JADX INFO: renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m6065calculatePointerEventType7fucELk() {
        MotionEvent r100 = getMotionEvent();
        if (r100 == null) goto L19;
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L18;
        if (r101 == 1) goto L40;
        if (r101 == 2) goto L39;
        switch(r101) {
            case 5: goto L18;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            default: goto L35;
        };
    L35:
        return PointerEventType.Companion.m6085getUnknown7fucELk();
    L36:
        return PointerEventType.Companion.m6080getExit7fucELk();
    L37:
        return PointerEventType.Companion.m6079getEnter7fucELk();
    L38:
        return PointerEventType.Companion.m6084getScroll7fucELk();
    L39:
        return PointerEventType.Companion.m6081getMove7fucELk();
    L40:
        return PointerEventType.Companion.m6083getRelease7fucELk();
    L18:
        return PointerEventType.Companion.m6082getPress7fucELk();
    L19:
        List<PointerInputChange> r102 = this.changes;
        int r103 = r102.size();
        int r104 = 0;
    L20:
        if (r104 >= r103) goto L31;
        PointerInputChange r105 = (PointerInputChange) ListProtector.get(r102, r104);
        if (PointerEventKt.changedToUpIgnoreConsumed(r105) == true) goto L24;
        if (PointerEventKt.changedToDownIgnoreConsumed(r105) == true) goto L28;
        r104 = r104 + 1;
        goto L20
    L28:
        return PointerEventType.Companion.m6082getPress7fucELk();
    L24:
        return PointerEventType.Companion.m6083getRelease7fucELk();
    L31:
        return PointerEventType.Companion.m6081getMove7fucELk();
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    /* JADX INFO: renamed from: getButtons-ry648PA, reason: not valid java name */
    public final int m6066getButtonsry648PA() {
        return this.buttons;
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    public final int getClassification() {
        return this.classification;
    }

    public final InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name */
    public final int m6067getKeyboardModifiersk7X9c1A() {
        return this.keyboardModifiers;
    }

    /* JADX INFO: renamed from: getType-7fucELk, reason: not valid java name */
    public final int m6068getType7fucELk() {
        return this.type;
    }

    public PointerEvent(List<PointerInputChange> r100) {
        this(r100, null);
    }

    /* JADX INFO: renamed from: setType-EhbLWgg$ui_release, reason: not valid java name */
    public final void m6069setTypeEhbLWgg$ui_release(int r100) {
        this.type = r100;
    }

    public PointerEvent(List<PointerInputChange> r100, InternalPointerEvent r101) {
        this.changes = r100;
        this.internalPointerEvent = r101;
        int r102 = 0;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        MotionEvent r103 = getMotionEvent();
        if (r103 == null) goto L7;
        int r104 = r103.getClassification();
    L8:
        this.classification = r104;
        MotionEvent r105 = getMotionEvent();
        if (r105 == null) goto L11;
        int r106 = r105.getButtonState();
    L12:
        this.buttons = PointerButtons.m6059constructorimpl(r106);
        MotionEvent r107 = getMotionEvent();
        if (r107 == null) goto L15;
        r102 = r107.getMetaState();
    L15:
        this.keyboardModifiers = PointerKeyboardModifiers.m6189constructorimpl(r102);
        this.type = m6065calculatePointerEventType7fucELk();
        return;
    L11:
        r106 = 0;
    L7:
        r104 = 0;
        goto L8
    }

    public final PointerEvent copy(List<PointerInputChange> r310, MotionEvent r311) {
        if (r311 != null) goto L6;
        return new PointerEvent(r310, null);
    L6:
        if (Intrinsics.areEqual(r311, getMotionEvent()) == true) goto L23;
        LongSparseArray r100 = new LongSparseArray(r310.size());
        ArrayList r101 = new ArrayList(r310.size());
        int r102 = r310.size();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L18;
        PointerInputChange r104 = (PointerInputChange) ListProtector.get(r310, r103);
        r100.put(r104.m6124getIdJ3iCeTQ(), r104);
        long r110 = r104.m6124getIdJ3iCeTQ();
        long r111 = r104.getUptimeMillis();
        long r112 = r104.m6126getPositionF1C5BW0();
        long r113 = r104.m6126getPositionF1C5BW0();
        boolean r210 = r104.getPressed();
        float r211 = r104.getPressure();
        int r212 = r104.m6129getTypeT8wyACA();
        InternalPointerEvent r114 = this.internalPointerEvent;
        int r312 = r103;
        if (r114 != null) goto L13;
    L15:
        boolean r213 = false;
    L16:
        r101.add(new PointerInputEventData(r110, r111, r112, r113, r210, r211, r212, r213, null, 0, 0, ISmModel.VERSION_0700, null));
        r103 = r312 + 1;
        goto L9
    L13:
        if (r114.m6054activeHoverEvent0FcD4WY(r104.m6124getIdJ3iCeTQ()) != true) goto L15;
        r213 = true;
        goto L16
    L18:
        return new PointerEvent(r310, new InternalPointerEvent(r100, new PointerInputEvent(r311.getEventTime(), r101, r311)));
    L23:
        return new PointerEvent(r310, this.internalPointerEvent);
    }
}
