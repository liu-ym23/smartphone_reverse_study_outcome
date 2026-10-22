package androidx.compose.ui.input.pointer;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "Use PointerInputChange.isConsumed and PointerInputChange.consume() instead")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038F@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038F@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/input/pointer/ConsumedData;", "", "positionChange", "", "downChange", "<init>", "(ZZ)V", "change", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "value", "getPositionChange$annotations", "()V", "getPositionChange", "()Z", "setPositionChange", "(Z)V", "getDownChange$annotations", "getDownChange", "setDownChange", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ConsumedData {
    public static final int $stable = 8;
    private PointerInputChange change;
    private boolean downChange;
    private boolean positionChange;

    public ConsumedData() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static /* synthetic */ void getDownChange$annotations() {
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static /* synthetic */ void getPositionChange$annotations() {
    }

    public final boolean getDownChange() {
        PointerInputChange r100 = this.change;
        if (r100 == null) goto L7;
        PointerInputChange r101 = r100.getConsumedDelegate$ui_release();
        if (r101 == null) goto L7;
    L12:
        return r101.getDownChange$ui_release();
    L7:
        r101 = this.change;
        if (r101 != null) goto L12;
        return this.downChange;
    }

    public final boolean getPositionChange() {
        PointerInputChange r100 = this.change;
        if (r100 == null) goto L7;
        PointerInputChange r101 = r100.getConsumedDelegate$ui_release();
        if (r101 == null) goto L7;
    L12:
        return r101.getPositionChange$ui_release();
    L7:
        r101 = this.change;
        if (r101 != null) goto L12;
        return this.positionChange;
    }

    public ConsumedData(PointerInputChange r100) {
        this(r100.getPositionChange$ui_release(), r100.getDownChange$ui_release());
        this.change = r100;
    }

    public final void setDownChange(boolean r100) {
        PointerInputChange r101 = this.change;
        if (r101 == null) goto L7;
        PointerInputChange r102 = r101.getConsumedDelegate$ui_release();
        if (r102 == null) goto L7;
        r102.setDownChange$ui_release(r100);
    L7:
        PointerInputChange r103 = this.change;
        if (r103 == null) goto L10;
        r103.setDownChange$ui_release(r100);
    L10:
        this.downChange = r100;
    }

    public final void setPositionChange(boolean r100) {
        PointerInputChange r101 = this.change;
        if (r101 == null) goto L7;
        PointerInputChange r102 = r101.getConsumedDelegate$ui_release();
        if (r102 == null) goto L7;
        r102.setPositionChange$ui_release(r100);
    L7:
        PointerInputChange r103 = this.change;
        if (r103 == null) goto L10;
        r103.setPositionChange$ui_release(r100);
    L10:
        this.positionChange = r100;
    }

    public ConsumedData(boolean r100, boolean r101) {
        this.positionChange = r100;
        this.downChange = r101;
    }

    public /* synthetic */ ConsumedData(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
