package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "", "<init>", "()V", "previousPointerInputData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "produce", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "clear", "", "PointerInputData", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PointerInputChangeEventProducer {
    private final LongSparseArray<PointerInputData> previousPointerInputData;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN, "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUptime", "()J", "getPositionOnScreen-F1C5BW0", "J", "getDown", "()Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final long uptime;

        public /* synthetic */ PointerInputData(long r100, long r101, boolean r102, DefaultConstructorMarker r103) {
            this(r100, r101, r102);
        }

        public final boolean getDown() {
            return this.down;
        }

        /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
        public final long m6131getPositionOnScreenF1C5BW0() {
            return this.positionOnScreen;
        }

        public final long getUptime() {
            return this.uptime;
        }

        private PointerInputData(long r100, long r101, boolean r102) {
            this.uptime = r100;
            this.positionOnScreen = r101;
            this.down = r102;
        }
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    public PointerInputChangeEventProducer() {
        this.previousPointerInputData = new LongSparseArray(0, 1, null);
    }

    public final InternalPointerEvent produce(PointerInputEvent r310, PositionCalculator r311) {
        LongSparseArray r100 = new LongSparseArray(r310.getPointers().size());
        List<PointerInputEventData> r101 = r310.getPointers();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        PointerInputEventData r104 = (PointerInputEventData) ListProtector.get(r101, r103);
        PointerInputData r105 = this.previousPointerInputData.get(r104.m6140getIdJ3iCeTQ());
        if (r105 != null) goto L7;
        long r106 = r104.getUptime();
        long r210 = r106;
        long r211 = r104.m6142getPositionF1C5BW0();
        boolean r212 = false;
    L8:
        r100.put(r104.m6140getIdJ3iCeTQ(), new PointerInputChange(r104.m6140getIdJ3iCeTQ(), r104.getUptime(), r104.m6142getPositionF1C5BW0(), r104.getDown(), r104.getPressure(), r210, r211, r212, false, r104.m6145getTypeT8wyACA(), r104.getHistorical(), r104.m6144getScrollDeltaF1C5BW0(), r104.m6141getOriginalEventPositionF1C5BW0(), null));
        if (r104.getDown() == false) goto L11;
        this.previousPointerInputData.put(r104.m6140getIdJ3iCeTQ(), new PointerInputData(r104.getUptime(), r104.m6143getPositionOnScreenF1C5BW0(), r104.getDown(), null));
    L12:
        r103 = r103 + 1;
        goto L3
    L11:
        this.previousPointerInputData.remove(r104.m6140getIdJ3iCeTQ());
        goto L12
    L7:
        long r107 = r105.getUptime();
        boolean r110 = r105.getDown();
        r210 = r107;
        r212 = r110;
        r211 = r311.mo6208screenToLocalMKHz9U(r105.m6131getPositionOnScreenF1C5BW0());
        goto L8
    L14:
        return new InternalPointerEvent(r100, r310);
    }
}
