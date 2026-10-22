package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014B]\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0015BS\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0018Bw\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u001dJ\u0006\u0010A\u001a\u00020BJi\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\bN\u0010OJg\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\bP\u0010QJq\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0004\bR\u0010SJq\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\bT\u0010UJw\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u0007¢\u0006\u0004\bV\u0010WJ\u0081\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00052\b\b\u0002\u0010K\u001a\u00020\u00072\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001a\u00020[H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0013\u0010\r\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0013\u0010\u0010\u001a\u00020\u0011¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0013\u0010\u0012\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8F¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u00020\u0007X\u0080\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b1\u0010\u001f\"\u0004\b2\u00103R\u0011\u00104\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b4\u0010$R\u001a\u00105\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010$\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u00108R\u001c\u0010<\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010C\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bD\u0010ER\u001a\u0010\u0016\u001a\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010E\u001a\u0004\bG\u0010H¨\u0006\\"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "pressure", "", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "scrollDelta", "<init>", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-J3iCeTQ", "()J", "J", "getUptimeMillis", "getPosition-F1C5BW0", "getPressed", "()Z", "getPressure", "()F", "getPreviousUptimeMillis", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getType-T8wyACA", "()I", "I", "getScrollDelta-F1C5BW0", "getHistorical", "()Ljava/util/List;", "_historical", "getOriginalEventPosition-F1C5BW0$ui_release", "setOriginalEventPosition-k-4lQ0M$ui_release", "(J)V", "isConsumed", "downChange", "getDownChange$ui_release", "setDownChange$ui_release", "(Z)V", "positionChange", "getPositionChange$ui_release", "setPositionChange$ui_release", "consumedDelegate", "getConsumedDelegate$ui_release", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setConsumedDelegate$ui_release", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "consume", "", "_consumed", "get_consumed$annotations", "()V", "getConsumed$annotations", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PointerInputChange {
    public static final int $stable = 0;
    private ConsumedData _consumed;
    private List<HistoricalChange> _historical;
    private PointerInputChange consumedDelegate;
    private boolean downChange;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f15256id;
    private long originalEventPosition;
    private final long position;
    private boolean positionChange;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long r100, long r101, long r102, boolean r103, float r104, long r105, long r110, boolean r111, boolean r112, int r113, long r114, DefaultConstructorMarker r115) {
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114);
    }

    public /* synthetic */ PointerInputChange(long r100, long r101, long r102, boolean r103, float r104, long r105, long r110, boolean r111, boolean r112, int r113, List r114, long r115, long r116, DefaultConstructorMarker r210) {
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(expression = "this(id, uptimeMillis, position, pressed, previousUptimeMillis, previousPosition, previousPressed, consumed.downChange || consumed.positionChange, type, Offset.Zero)", imports = {}))
    public /* synthetic */ PointerInputChange(long r100, long r101, long r102, boolean r103, long r104, long r110, boolean r111, ConsumedData r112, int r113, DefaultConstructorMarker r114) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113);
    }

    public /* synthetic */ PointerInputChange(long r100, long r101, long r102, boolean r103, long r104, long r110, boolean r111, boolean r112, int r113, long r114, DefaultConstructorMarker r115) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static /* synthetic */ void getConsumed$annotations() {
    }

    private static /* synthetic */ void get_consumed$annotations() {
    }

    public final void consume() {
        PointerInputChange r100 = this.consumedDelegate;
        if (r100 != null) goto L5;
        this.downChange = true;
        this.positionChange = true;
        return;
    L5:
        if (r100 == null) goto L9;
        r100.consume();
        return;
    }

    public final ConsumedData getConsumed() {
        if (this._consumed != null) goto L5;
        this._consumed = new ConsumedData(this);
    L5:
        ConsumedData r100 = this._consumed;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> r100 = this._historical;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean isConsumed() {
        PointerInputChange r100 = this.consumedDelegate;
        if (r100 == null) goto L6;
        return r100.isConsumed();
    L6:
        if (this.downChange == false) goto L8;
    L11:
        return true;
    L8:
        if (this.positionChange == true) goto L11;
        return false;
    }

    public String toString() {
        return "PointerInputChange(id=" + PointerId.m6110toStringimpl(this.f15256id) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.m4590toStringimpl(this.position) + ", pressed=" + this.pressed + ", pressure=" + this.pressure + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + Offset.m4590toStringimpl(this.previousPosition) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + PointerType.m6200toStringimpl(this.type) + ", historical=" + getHistorical() + ",scrollDelta=" + Offset.m4590toStringimpl(this.scrollDelta) + ')';
    }

    public final PointerInputChange getConsumedDelegate$ui_release() {
        return this.consumedDelegate;
    }

    public final boolean getDownChange$ui_release() {
        return this.downChange;
    }

    /* JADX INFO: renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m6124getIdJ3iCeTQ() {
        return this.f15256id;
    }

    /* JADX INFO: renamed from: getOriginalEventPosition-F1C5BW0$ui_release, reason: not valid java name */
    public final long m6125getOriginalEventPositionF1C5BW0$ui_release() {
        return this.originalEventPosition;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m6126getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPositionChange$ui_release() {
        return this.positionChange;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* JADX INFO: renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name */
    public final long m6127getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* JADX INFO: renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m6128getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m6129getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final void setConsumedDelegate$ui_release(PointerInputChange r100) {
        this.consumedDelegate = r100;
    }

    public final void setDownChange$ui_release(boolean r100) {
        this.downChange = r100;
    }

    /* JADX INFO: renamed from: setOriginalEventPosition-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m6130setOriginalEventPositionk4lQ0M$ui_release(long r100) {
        this.originalEventPosition = r100;
    }

    public final void setPositionChange$ui_release(boolean r100) {
        this.positionChange = r100;
    }

    private PointerInputChange(long r210, long r211, long r212, boolean r213, long r214, long r215, boolean r310, ConsumedData r311, int r312) {
        float r100 = 1.0f;
        if (r311.getDownChange() == false) goto L5;
    L8:
        boolean r110 = true;
    L9:
        this(r210, r211, r212, r213, r100, r214, r215, r310, r110, r312, Offset.Companion.m4598getZeroF1C5BW0(), null);
        return;
    L5:
        if (r311.getPositionChange() == true) goto L8;
        r110 = false;
        goto L9
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(expression = "copy(id,currentTime, currentPosition, currentPressed, previousTime,previousPosition, previousPressed, consumed, type, this.scrollDelta)", imports = {}))
    /* JADX INFO: renamed from: copy-Ezr-O64, reason: not valid java name */
    public final /* synthetic */ PointerInputChange m6119copyEzrO64(long r210, long r211, long r212, boolean r310, long r311, long r312, boolean r313, ConsumedData r314, int r315) {
        float r100 = this.pressure;
        if (r314.getDownChange() == false) goto L5;
    L8:
        boolean r110 = true;
    L9:
        boolean r111 = r110;
        PointerInputChange r112 = new PointerInputChange(r210, r211, r212, r310, r100, r311, r312, r313, r111, r315, getHistorical(), this.scrollDelta, this.originalEventPosition, null);
        r112.positionChange = this.positionChange;
        r112.downChange = this.downChange;
        return r112;
    L5:
        if (r314.getPositionChange() == true) goto L8;
        r110 = false;
        goto L9
    }

    /* JADX INFO: renamed from: copy-JKmWfYY, reason: not valid java name */
    public final PointerInputChange m6120copyJKmWfYY(long r210, long r211, long r212, boolean r213, long r214, long r215, boolean r310, int r311, long r312) {
        PointerInputChange r100 = m6123copywbzehF4(r210, r211, r212, r213, this.pressure, r214, r215, r310, r311, getHistorical(), r312);
        PointerInputChange r110 = this.consumedDelegate;
        if (r110 != null) goto L5;
        r110 = this;
    L5:
        r100.consumedDelegate = r110;
        return r100;
    }

    private PointerInputChange(long r210, long r211, long r212, boolean r213, long r214, long r215, boolean r310, boolean r311, int r312, long r313) {
        this(r210, r211, r212, r213, 1.0f, r214, r215, r310, r311, r312, r313, null);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(expression = "copy(id, currentTime, currentPosition, currentPressed, previousTime, previousPosition, previousPressed, type, scrollDelta)", imports = {}))
    /* JADX INFO: renamed from: copy-0GkPj7c, reason: not valid java name */
    public final PointerInputChange m6118copy0GkPj7c(long r210, long r211, long r212, boolean r310, long r311, long r312, boolean r313, ConsumedData r314, int r315, long r316) {
        float r100 = this.pressure;
        if (r314.getDownChange() == false) goto L5;
    L8:
        boolean r110 = true;
    L9:
        boolean r111 = r110;
        PointerInputChange r112 = new PointerInputChange(r210, r211, r212, r310, r100, r311, r312, r313, r111, r315, getHistorical(), r316, this.originalEventPosition, null);
        r112.positionChange = this.positionChange;
        r112.downChange = this.downChange;
        return r112;
    L5:
        if (r314.getPositionChange() == true) goto L8;
        r110 = false;
        goto L9
    }

    /* JADX INFO: renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m6121copyOHpmEuE(long r210, long r211, long r212, boolean r213, long r214, long r215, boolean r310, int r311, List<HistoricalChange> r312, long r313) {
        PointerInputChange r100 = m6123copywbzehF4(r210, r211, r212, r213, this.pressure, r214, r215, r310, r311, r312, r313);
        PointerInputChange r101 = this.consumedDelegate;
        if (r101 != null) goto L5;
        r101 = this;
    L5:
        r100.consumedDelegate = r101;
        return r100;
    }

    /* JADX INFO: renamed from: copy-Tn9QgHE, reason: not valid java name */
    public final PointerInputChange m6122copyTn9QgHE(long r210, long r211, long r212, boolean r310, float r311, long r312, long r313, boolean r314, int r315, long r316) {
        PointerInputChange r110 = new PointerInputChange(r210, r211, r212, r310, r311, r312, r313, r314, false, r315, getHistorical(), r316, this.originalEventPosition, null);
        PointerInputChange r100 = this.consumedDelegate;
        if (r100 != null) goto L5;
        r100 = this;
    L5:
        r110.consumedDelegate = r100;
        return r110;
    }

    private PointerInputChange(long r100, long r101, long r102, boolean r110, float r111, long r112, long r113, boolean r114, boolean r115, int r116, long r210) {
        this.f15256id = r100;
        this.uptimeMillis = r101;
        this.position = r102;
        this.pressed = r110;
        this.pressure = r111;
        this.previousUptimeMillis = r112;
        this.previousPosition = r113;
        this.previousPressed = r114;
        this.type = r116;
        this.scrollDelta = r210;
        this.originalEventPosition = Offset.Companion.m4598getZeroF1C5BW0();
        this.downChange = r115;
        this.positionChange = r115;
    }

    /* JADX INFO: renamed from: copy-wbzehF4, reason: not valid java name */
    public final PointerInputChange m6123copywbzehF4(long r210, long r211, long r212, boolean r310, float r311, long r312, long r313, boolean r314, int r315, List<HistoricalChange> r316, long r410) {
        PointerInputChange r110 = new PointerInputChange(r210, r211, r212, r310, r311, r312, r313, r314, false, r315, r316, r410, this.originalEventPosition, null);
        PointerInputChange r100 = this.consumedDelegate;
        if (r100 != null) goto L5;
        r100 = this;
    L5:
        r110.consumedDelegate = r100;
        return r110;
    }

    public /* synthetic */ PointerInputChange(long r110, long r210, long r211, boolean r212, long r213, long r214, boolean r215, ConsumedData r310, int r311, int r312, DefaultConstructorMarker r313) {
        if ((r312 & 256) == 0) goto L5;
        int r111 = PointerType.Companion.m6205getTouchT8wyACA();
    L6:
        this(r110, r210, r211, r212, r213, r214, r215, r310, r111, null);
        return;
    L5:
        r111 = r311;
        goto L6
    }

    public /* synthetic */ PointerInputChange(long r210, long r211, long r212, boolean r213, long r214, long r310, boolean r311, boolean r312, int r313, long r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 256) == 0) goto L5;
        int r110 = PointerType.Companion.m6205getTouchT8wyACA();
    L7:
        if ((r315 & 512) == 0) goto L9;
        long r111 = Offset.Companion.m4598getZeroF1C5BW0();
    L10:
        this(r210, r211, r212, r213, r214, r310, r311, r312, r110, r111, null);
        return;
    L9:
        r111 = r314;
        goto L10
    L5:
        r110 = r313;
        goto L7
    }

    /* JADX INFO: renamed from: copy-Ezr-O64$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m6113copyEzrO64$default(PointerInputChange r110, long r111, long r112, long r210, boolean r211, long r212, long r213, boolean r214, ConsumedData r215, int r216, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        long r100 = r110.f15256id;
    L7:
        if ((r310 & 2) == 0) goto L9;
        long r101 = r110.uptimeMillis;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r102 = r110.position;
    L15:
        if ((r310 & 8) == 0) goto L17;
        boolean r103 = r110.pressed;
    L19:
        if ((r310 & 16) == 0) goto L21;
        long r104 = r110.previousUptimeMillis;
    L23:
        if ((r310 & 32) == 0) goto L25;
        long r113 = r110.previousPosition;
    L27:
        if ((r310 & 64) == 0) goto L29;
        boolean r114 = r110.previousPressed;
    L31:
        if ((r310 & 128) == 0) goto L33;
        ConsumedData r115 = r110.getConsumed();
    L35:
        if ((r310 & 256) == 0) goto L37;
        int r105 = r110.type;
    L39:
        return r110.m6119copyEzrO64(r100, r101, r102, r103, r104, r113, r114, r115, r105);
    L37:
        r105 = r216;
        goto L39
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-JKmWfYY$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m6114copyJKmWfYY$default(PointerInputChange r110, long r111, long r112, long r210, boolean r211, long r212, long r213, boolean r214, int r215, long r310, int r311, Object r312) {
        if ((r311 & 1) == 0) goto L5;
        long r100 = r110.f15256id;
    L7:
        if ((r311 & 2) == 0) goto L9;
        long r101 = r110.uptimeMillis;
    L11:
        if ((r311 & 4) == 0) goto L13;
        long r102 = r110.position;
    L15:
        if ((r311 & 8) == 0) goto L17;
        boolean r103 = r110.pressed;
    L19:
        if ((r311 & 16) == 0) goto L21;
        long r104 = r110.previousUptimeMillis;
    L23:
        if ((r311 & 32) == 0) goto L25;
        long r113 = r110.previousPosition;
    L27:
        if ((r311 & 64) == 0) goto L29;
        boolean r114 = r110.previousPressed;
    L31:
        if ((r311 & 128) == 0) goto L33;
        int r115 = r110.type;
    L34:
        int r216 = r115;
        if ((r311 & 256) == 0) goto L37;
        long r116 = r110.scrollDelta;
    L39:
        return r110.m6120copyJKmWfYY(r100, r101, r102, r103, r104, r113, r114, r216, r116);
    L37:
        r116 = r310;
        goto L39
    L33:
        r115 = r215;
        goto L34
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ PointerInputChange(long r210, long r211, long r212, boolean r213, float r214, long r310, long r311, boolean r312, boolean r313, int r314, long r315, int r316, DefaultConstructorMarker r410) {
        if ((r316 & 512) == 0) goto L5;
        int r110 = PointerType.Companion.m6205getTouchT8wyACA();
    L7:
        if ((r316 & 1024) == 0) goto L9;
        long r111 = Offset.Companion.m4598getZeroF1C5BW0();
    L10:
        this(r210, r211, r212, r213, r214, r310, r311, r312, r313, r110, r111, null);
        return;
    L9:
        r111 = r315;
        goto L10
    L5:
        r110 = r314;
        goto L7
    }

    /* JADX INFO: renamed from: copy-0GkPj7c$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m6112copy0GkPj7c$default(PointerInputChange r110, long r111, long r210, long r211, boolean r212, long r213, long r214, boolean r215, ConsumedData r310, int r311, long r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = r110.f15256id;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = r110.uptimeMillis;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r102 = r110.position;
    L15:
        if ((r313 & 8) == 0) goto L17;
        boolean r103 = r110.pressed;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r104 = r110.previousUptimeMillis;
    L23:
        if ((r313 & 32) == 0) goto L25;
        long r112 = r110.previousPosition;
    L27:
        if ((r313 & 64) == 0) goto L29;
        boolean r113 = r110.previousPressed;
    L31:
        if ((r313 & 256) == 0) goto L33;
        int r114 = r110.type;
    L34:
        int r115 = r114;
        if ((r313 & 512) == 0) goto L37;
        long r116 = r110.scrollDelta;
    L39:
        return r110.m6118copy0GkPj7c(r100, r101, r102, r103, r104, r112, r113, r310, r115, r116);
    L37:
        r116 = r312;
        goto L39
    L33:
        r114 = r311;
        goto L34
    L29:
        r113 = r215;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-OHpmEuE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m6115copyOHpmEuE$default(PointerInputChange r110, long r111, long r210, long r211, boolean r212, long r213, long r214, boolean r215, int r310, List r311, long r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = r110.f15256id;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = r110.uptimeMillis;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r102 = r110.position;
    L15:
        if ((r313 & 8) == 0) goto L17;
        boolean r103 = r110.pressed;
    L19:
        if ((r313 & 16) == 0) goto L21;
        long r104 = r110.previousUptimeMillis;
    L23:
        if ((r313 & 32) == 0) goto L25;
        long r112 = r110.previousPosition;
    L27:
        if ((r313 & 64) == 0) goto L29;
        boolean r113 = r110.previousPressed;
    L31:
        if ((r313 & 128) == 0) goto L33;
        int r114 = r110.type;
    L34:
        int r115 = r114;
        if ((r313 & 512) == 0) goto L37;
        long r116 = r110.scrollDelta;
    L39:
        return r110.m6121copyOHpmEuE(r100, r101, r102, r103, r104, r112, r113, r115, r311, r116);
    L37:
        r116 = r312;
        goto L39
    L33:
        r114 = r310;
        goto L34
    L29:
        r113 = r215;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    /* JADX INFO: renamed from: copy-Tn9QgHE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m6116copyTn9QgHE$default(PointerInputChange r110, long r111, long r112, long r210, boolean r211, float r212, long r213, long r214, boolean r215, int r310, long r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        long r100 = r110.f15256id;
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r101 = r110.uptimeMillis;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r102 = r110.position;
    L15:
        if ((r312 & 8) == 0) goto L17;
        boolean r103 = r110.pressed;
    L19:
        if ((r312 & 16) == 0) goto L21;
        float r104 = r110.pressure;
    L23:
        if ((r312 & 32) == 0) goto L25;
        long r113 = r110.previousUptimeMillis;
    L27:
        if ((r312 & 64) == 0) goto L29;
        long r114 = r110.previousPosition;
    L31:
        if ((r312 & 128) == 0) goto L33;
        boolean r115 = r110.previousPressed;
    L35:
        if ((r312 & 256) == 0) goto L37;
        int r116 = r110.type;
    L38:
        boolean r216 = r115;
        int r314 = r116;
        if ((r312 & 512) == 0) goto L41;
        long r117 = r110.scrollDelta;
    L43:
        return r110.m6122copyTn9QgHE(r100, r101, r102, r103, r104, r113, r114, r216, r314, r117);
    L41:
        r117 = r311;
        goto L43
    L37:
        r116 = r310;
        goto L38
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    private PointerInputChange(long r210, long r211, long r212, boolean r213, float r214, long r215, long r310, boolean r311, boolean r312, int r313, List<HistoricalChange> r314, long r315, long r316) {
        this(r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r315, null);
        this._historical = r314;
        this.originalEventPosition = r316;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-wbzehF4$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m6117copywbzehF4$default(PointerInputChange r110, long r111, long r112, long r210, boolean r211, float r212, long r213, long r214, boolean r215, int r310, List r311, long r312, int r313, Object r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = r110.f15256id;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r101 = r110.uptimeMillis;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r102 = r110.position;
    L15:
        if ((r313 & 8) == 0) goto L17;
        boolean r103 = r110.pressed;
    L19:
        if ((r313 & 16) == 0) goto L21;
        float r104 = r110.pressure;
    L23:
        if ((r313 & 32) == 0) goto L25;
        long r113 = r110.previousUptimeMillis;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r114 = r110.previousPosition;
    L31:
        if ((r313 & 128) == 0) goto L33;
        boolean r115 = r110.previousPressed;
    L35:
        if ((r313 & 256) == 0) goto L37;
        int r116 = r110.type;
    L38:
        int r315 = r116;
        if ((r313 & 512) == 0) goto L41;
        List r117 = r110.getHistorical();
    L42:
        boolean r216 = r115;
        List r316 = r117;
        if ((r313 & 1024) == 0) goto L45;
        long r118 = r110.scrollDelta;
    L47:
        return r110.m6123copywbzehF4(r100, r101, r102, r103, r104, r113, r114, r216, r315, r316, r118);
    L45:
        r118 = r312;
        goto L47
    L41:
        r117 = r311;
        goto L42
    L37:
        r116 = r310;
        goto L38
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
