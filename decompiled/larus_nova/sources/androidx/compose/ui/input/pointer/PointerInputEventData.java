package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b*\u0010\u0018J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\u0010\u0010,\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b-\u0010\u0018J\u0010\u0010.\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b/\u0010\u0018J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\u0010\u00102\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b3\u0010\"J\t\u00104\u001a\u00020\nHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0010\u00106\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b7\u0010\u0018J\u0010\u00108\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b9\u0010\u0018J\u0084\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b;\u0010<J\u0013\u0010=\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\b\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0013\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0018R\u0013\u0010\u0014\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b(\u0010\u0018¨\u0006C"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "", "pressure", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "activeHover", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "originalEventPosition", "<init>", "(JJJJZFIZLjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-J3iCeTQ", "()J", "J", "getUptime", "getPositionOnScreen-F1C5BW0", "getPosition-F1C5BW0", "getDown", "()Z", "getPressure", "()F", "getType-T8wyACA", "()I", "I", "getActiveHover", "getHistorical", "()Ljava/util/List;", "getScrollDelta-F1C5BW0", "getOriginalEventPosition-F1C5BW0", "component1", "component1-J3iCeTQ", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component7", "component7-T8wyACA", "component8", "component9", "component10", "component10-F1C5BW0", "component11", "component11-F1C5BW0", "copy", "copy-rc8HELY", "(JJJJZFIZLjava/util/List;JJ)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PointerInputEventData {
    public static final int $stable = 8;
    private final boolean activeHover;
    private final boolean down;
    private final List<HistoricalChange> historical;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f15257id;
    private final long originalEventPosition;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long r100, long r101, long r102, long r103, boolean r104, float r110, int r111, boolean r112, List r113, long r114, long r115, DefaultConstructorMarker r116) {
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-rc8HELY$default, reason: not valid java name */
    public static /* synthetic */ PointerInputEventData m6132copyrc8HELY$default(PointerInputEventData r110, long r111, long r112, long r210, long r211, boolean r212, float r213, int r214, boolean r215, List r216, long r310, long r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        long r100 = r110.f15257id;
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r101 = r110.uptime;
    L11:
        if ((r312 & 4) == 0) goto L13;
        long r102 = r110.positionOnScreen;
    L15:
        if ((r312 & 8) == 0) goto L17;
        long r103 = r110.position;
    L19:
        if ((r312 & 16) == 0) goto L21;
        boolean r113 = r110.down;
    L23:
        if ((r312 & 32) == 0) goto L25;
        float r114 = r110.pressure;
    L27:
        if ((r312 & 64) == 0) goto L29;
        int r115 = r110.type;
    L31:
        if ((r312 & 128) == 0) goto L33;
        boolean r116 = r110.activeHover;
    L35:
        if ((r312 & 256) == 0) goto L37;
        List r117 = r110.historical;
    L38:
        List r217 = r117;
        if ((r312 & 512) == 0) goto L41;
        long r118 = r110.scrollDelta;
    L42:
        long r314 = r118;
        if ((r312 & 1024) == 0) goto L45;
        long r119 = r110.originalEventPosition;
    L47:
        return r110.m6139copyrc8HELY(r100, r101, r102, r103, r113, r114, r115, r116, r217, r314, r119);
    L45:
        r119 = r311;
        goto L47
    L41:
        r118 = r310;
        goto L42
    L37:
        r117 = r216;
        goto L38
    L33:
        r116 = r215;
        goto L35
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = r213;
        goto L27
    L21:
        r113 = r212;
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

    /* JADX INFO: renamed from: component1-J3iCeTQ, reason: not valid java name */
    public final long m6133component1J3iCeTQ() {
        return this.f15257id;
    }

    /* JADX INFO: renamed from: component10-F1C5BW0, reason: not valid java name */
    public final long m6134component10F1C5BW0() {
        return this.scrollDelta;
    }

    /* JADX INFO: renamed from: component11-F1C5BW0, reason: not valid java name */
    public final long m6135component11F1C5BW0() {
        return this.originalEventPosition;
    }

    public final long component2() {
        return this.uptime;
    }

    /* JADX INFO: renamed from: component3-F1C5BW0, reason: not valid java name */
    public final long m6136component3F1C5BW0() {
        return this.positionOnScreen;
    }

    /* JADX INFO: renamed from: component4-F1C5BW0, reason: not valid java name */
    public final long m6137component4F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    public final float component6() {
        return this.pressure;
    }

    /* JADX INFO: renamed from: component7-T8wyACA, reason: not valid java name */
    public final int m6138component7T8wyACA() {
        return this.type;
    }

    public final boolean component8() {
        return this.activeHover;
    }

    public final List<HistoricalChange> component9() {
        return this.historical;
    }

    /* JADX INFO: renamed from: copy-rc8HELY, reason: not valid java name */
    public final PointerInputEventData m6139copyrc8HELY(long r210, long r211, long r212, long r213, boolean r214, float r310, int r311, boolean r312, List<HistoricalChange> r313, long r314, long r315) {
        return new PointerInputEventData(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PointerInputEventData) == true) goto L8;
        return false;
    L8:
        PointerInputEventData r101 = (PointerInputEventData) r100;
        if (PointerId.m6108equalsimpl0(this.f15257id, r101.f15257id) == true) goto L12;
        return false;
    L12:
        if (this.uptime == r101.uptime) goto L15;
        return false;
    L15:
        if (Offset.m4579equalsimpl0(this.positionOnScreen, r101.positionOnScreen) == true) goto L18;
        return false;
    L18:
        if (Offset.m4579equalsimpl0(this.position, r101.position) == true) goto L21;
        return false;
    L21:
        if (this.down == r101.down) goto L24;
        return false;
    L24:
        if (Float.compare(this.pressure, r101.pressure) == 0) goto L27;
        return false;
    L27:
        if (PointerType.m6198equalsimpl0(this.type, r101.type) == true) goto L30;
        return false;
    L30:
        if (this.activeHover == r101.activeHover) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.historical, r101.historical) == true) goto L36;
        return false;
    L36:
        if (Offset.m4579equalsimpl0(this.scrollDelta, r101.scrollDelta) == true) goto L39;
        return false;
    L39:
        if (Offset.m4579equalsimpl0(this.originalEventPosition, r101.originalEventPosition) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r100 = PointerId.m6109hashCodeimpl(this.f15257id) * 31;
        long r101 = this.uptime;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Offset.m4584hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m4584hashCodeimpl(this.position)) * 31;
        int r103 = 1231;
        if (this.down == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (((((r102 + r104) * 31) + Float.floatToIntBits(this.pressure)) * 31) + PointerType.m6199hashCodeimpl(this.type)) * 31;
        if (this.activeHover == true) goto L11;
        r103 = 1237;
    L11:
        return ((((((r105 + r103) * 31) + this.historical.hashCode()) * 31) + Offset.m4584hashCodeimpl(this.scrollDelta)) * 31) + Offset.m4584hashCodeimpl(this.originalEventPosition);
    L5:
        r104 = 1237;
        goto L6
    }

    public String toString() {
        return "PointerInputEventData(id=" + PointerId.m6110toStringimpl(this.f15257id) + ", uptime=" + this.uptime + ", positionOnScreen=" + Offset.m4590toStringimpl(this.positionOnScreen) + ", position=" + Offset.m4590toStringimpl(this.position) + ", down=" + this.down + ", pressure=" + this.pressure + ", type=" + PointerType.m6200toStringimpl(this.type) + ", activeHover=" + this.activeHover + ", historical=" + this.historical + ", scrollDelta=" + Offset.m4590toStringimpl(this.scrollDelta) + ", originalEventPosition=" + Offset.m4590toStringimpl(this.originalEventPosition) + ')';
    }

    public final boolean getActiveHover() {
        return this.activeHover;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* JADX INFO: renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m6140getIdJ3iCeTQ() {
        return this.f15257id;
    }

    /* JADX INFO: renamed from: getOriginalEventPosition-F1C5BW0, reason: not valid java name */
    public final long m6141getOriginalEventPositionF1C5BW0() {
        return this.originalEventPosition;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m6142getPositionF1C5BW0() {
        return this.position;
    }

    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m6143getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* JADX INFO: renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m6144getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* JADX INFO: renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m6145getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }

    private PointerInputEventData(long r100, long r101, long r102, long r110, boolean r111, float r112, int r113, boolean r114, List<HistoricalChange> r115, long r116, long r117) {
        this.f15257id = r100;
        this.uptime = r101;
        this.positionOnScreen = r102;
        this.position = r110;
        this.down = r111;
        this.pressure = r112;
        this.type = r113;
        this.activeHover = r114;
        this.historical = r115;
        this.scrollDelta = r116;
        this.originalEventPosition = r117;
    }

    public /* synthetic */ PointerInputEventData(long r210, long r211, long r212, long r213, boolean r310, float r311, int r312, boolean r313, List r314, long r315, long r316, int r317, DefaultConstructorMarker r410) {
        if ((r317 & 128) == 0) goto L5;
        boolean r110 = false;
    L7:
        if ((r317 & 256) == 0) goto L9;
        List r111 = new ArrayList();
    L11:
        if ((r317 & 512) == 0) goto L13;
        long r112 = Offset.Companion.m4598getZeroF1C5BW0();
    L15:
        if ((r317 & 1024) == 0) goto L17;
        long r113 = Offset.Companion.m4598getZeroF1C5BW0();
    L18:
        this(r210, r211, r212, r213, r310, r311, r312, r110, r111, r112, r113, null);
        return;
    L17:
        r113 = r316;
        goto L18
    L13:
        r112 = r315;
        goto L15
    L9:
        r111 = r314;
        goto L11
    L5:
        r110 = r313;
        goto L7
    }
}
