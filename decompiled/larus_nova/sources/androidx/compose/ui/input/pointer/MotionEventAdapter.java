package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u001f\u001a\u00020 *\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0017\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010'\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "<init>", "()V", "nextId", "", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousToolType", "", "previousSource", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui_release", "endStream", "", "pointerId", "addFreshIds", "removeStaleIds", "hasPointerId", "", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "clearOnDeviceChange", "createPointerInputEventData", "index", "pressed", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MotionEventAdapter {
    public static final int $stable = 8;
    private final SparseBooleanArray activeHoverIds;
    private final SparseLongArray motionEventToComposePointerIdMap;
    private long nextId;
    private final List<PointerInputEventData> pointers;
    private int previousSource;
    private int previousToolType;

    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    public MotionEventAdapter() {
        this.motionEventToComposePointerIdMap = new SparseLongArray();
        this.activeHoverIds = new SparseBooleanArray();
        this.pointers = new ArrayList();
        this.previousToolType = -1;
        this.previousSource = -1;
    }

    public final SparseLongArray getMotionEventToComposePointerIdMap$ui_release() {
        return this.motionEventToComposePointerIdMap;
    }

    private final void addFreshIds(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
    L12:
        int r102 = r100.getActionIndex();
        int r103 = r100.getPointerId(r102);
        if (this.motionEventToComposePointerIdMap.indexOfKey(r103) >= 0) goto L20;
        SparseLongArray r104 = this.motionEventToComposePointerIdMap;
        long r105 = this.nextId;
        this.nextId = 1 + r105;
        r104.put(r103, r105);
        if (r100.getToolType(r102) != 3) goto L21;
        this.activeHoverIds.put(r103, true);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r101 == 5) goto L12;
        if (r101 != 9) goto L22;
        int r106 = r100.getPointerId(0);
        if (this.motionEventToComposePointerIdMap.indexOfKey(r106) >= 0) goto L18;
        SparseLongArray r107 = this.motionEventToComposePointerIdMap;
        long r108 = this.nextId;
        this.nextId = 1 + r108;
        r107.put(r106, r108);
        return;
    L18:
        return;
    }

    private final void clearOnDeviceChange(MotionEvent r100) {
        if (r100.getPointerCount() == 1) goto L5;
        return;
    L5:
        int r101 = r100.getToolType(0);
        int r102 = r100.getSource();
        if (r101 == this.previousToolType) goto L8;
    L9:
        this.previousToolType = r101;
        this.previousSource = r102;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
        return;
    L8:
        if (r102 != this.previousSource) goto L9;
    }

    /* JADX INFO: renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m6056getComposePointerId_I2yYro(int r100) {
        int r101 = this.motionEventToComposePointerIdMap.indexOfKey(r100);
        if (r101 < 0) goto L5;
        long r102 = this.motionEventToComposePointerIdMap.valueAt(r101);
    L7:
        return PointerId.m6106constructorimpl(r102);
    L5:
        r102 = this.nextId;
        this.nextId = 1 + r102;
        this.motionEventToComposePointerIdMap.put(r100, r102);
        goto L7
    }

    private final void removeStaleIds(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (r101 != 1) goto L5;
    L7:
        int r102 = r100.getPointerId(r100.getActionIndex());
        if (this.activeHoverIds.get(r102, false) == true) goto L11;
        this.motionEventToComposePointerIdMap.delete(r102);
        this.activeHoverIds.delete(r102);
    L11:
        if (this.motionEventToComposePointerIdMap.size() <= r100.getPointerCount()) goto L19;
        int r103 = this.motionEventToComposePointerIdMap.size() - 1;
    L14:
        if ((-1) >= r103) goto L23;
        int r104 = this.motionEventToComposePointerIdMap.keyAt(r103);
        if (hasPointerId(r100, r104) == true) goto L18;
        this.motionEventToComposePointerIdMap.removeAt(r103);
        this.activeHoverIds.delete(r104);
    L18:
        r103 = r103 - 1;
        goto L14
    L23:
        return;
    L19:
        return;
    L5:
        if (r101 == 6) goto L7;
        goto L7
    }

    public final void endStream(int r100) {
        this.activeHoverIds.delete(r100);
        this.motionEventToComposePointerIdMap.delete(r100);
    }

    private final boolean hasPointerId(MotionEvent r100, int r101) {
        int r102 = r100.getPointerCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r100.getPointerId(r103) == r101) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent r110, PositionCalculator r111) {
        int r100 = r110.getActionMasked();
        if (r100 != 3) goto L5;
    L40:
        this.motionEventToComposePointerIdMap.clear();
        this.activeHoverIds.clear();
        return null;
    L5:
        if (r100 == 4) goto L40;
        clearOnDeviceChange(r110);
        addFreshIds(r110);
        if (r100 != 9) goto L9;
    L14:
        boolean r101 = true;
    L16:
        if (r100 != 8) goto L18;
        boolean r102 = true;
    L19:
        if (r101 == false) goto L21;
        int r103 = r110.getPointerId(r110.getActionIndex());
        this.activeHoverIds.put(r103, true);
    L21:
        if (r100 != 1) goto L23;
        int r104 = 0;
    L27:
        this.pointers.clear();
        int r105 = r110.getPointerCount();
        int r106 = 0;
    L28:
        if (r106 >= r105) goto L38;
        List<PointerInputEventData> r107 = this.pointers;
        if (r101 == true) goto L36;
        if (r106 == r104) goto L36;
        if (r102 == true) goto L34;
    L35:
        boolean r108 = true;
    L37:
        r107.add(createPointerInputEventData(r111, r110, r106, r108));
        r106 = r106 + 1;
        goto L28
    L34:
        if (r110.getButtonState() != 0) goto L35;
    L36:
        r108 = false;
        goto L37
    L38:
        removeStaleIds(r110);
        return new PointerInputEvent(r110.getEventTime(), this.pointers, r110);
    L23:
        if (r100 == 6) goto L25;
        r104 = -1;
        goto L27
    L25:
        r104 = r110.getActionIndex();
        goto L27
    L18:
        r102 = false;
        goto L19
    L9:
        if (r100 == 7) goto L14;
        if (r100 == 10) goto L14;
        r101 = false;
        goto L16
    }

    private final PointerInputEventData createPointerInputEventData(PositionCalculator r310, MotionEvent r311, int r312, boolean r313) {
        int r100 = r312;
        long r101 = m6056getComposePointerId_I2yYro(r311.getPointerId(r312));
        float r110 = r311.getPressure(r312);
        float r102 = r311.getX(r312);
        float r103 = r311.getY(r312);
        long r104 = Float.floatToRawIntBits(r102);
        long r105 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax) | (r104 << 32));
        long r210 = Offset.m4576copydBAh8RU$default(r105, 0.0f, 0.0f, 3, null);
        if (r100 != 0) goto L7;
        float r106 = r311.getRawX();
        float r107 = r311.getRawY();
        long r108 = Float.floatToRawIntBits(r106);
        long r109 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r107)) & BodyPartID.bodyIdMax) | (r108 << 32));
        long r111 = r310.mo6208screenToLocalMKHz9U(r109);
    L5:
        long r112 = r109;
        long r113 = r111;
    L10:
        int r114 = r311.getToolType(r312);
        if (r114 == 0) goto L24;
        if (r114 != 1) goto L14;
        int r115 = PointerType.Companion.m6205getTouchT8wyACA();
    L25:
        int r116 = r115;
        ArrayList r117 = new ArrayList(r311.getHistorySize());
        int r118 = r311.getHistorySize();
        int r119 = 0;
    L26:
        if (r119 >= r118) goto L40;
        float r120 = r311.getHistoricalX(r100, r119);
        float r211 = r311.getHistoricalY(r100, r119);
        if ((Float.floatToRawIntBits(r120) & Integer.MAX_VALUE) >= 2139095040) goto L30;
        boolean r121 = true;
    L31:
        if (r121 == false) goto L38;
        if ((Float.floatToRawIntBits(r211) & Integer.MAX_VALUE) >= 2139095040) goto L35;
        boolean r122 = true;
    L36:
        if (r122 == false) goto L38;
        long r123 = Float.floatToRawIntBits(r120);
        long r314 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r211)) & BodyPartID.bodyIdMax) | (r123 << 32));
        r117.add(new HistoricalChange(r311.getHistoricalEventTime(r119), r314, r314, null));
        goto L38
    L35:
        r122 = false;
    L38:
        r119 = r119 + 1;
        r100 = r312;
        goto L26
    L30:
        r121 = false;
        goto L31
    L40:
        if (r311.getActionMasked() != 8) goto L42;
        float r124 = r311.getAxisValue(10);
        float r125 = (-r311.getAxisValue(9)) + 0.0f;
        long r126 = Float.floatToRawIntBits(r124);
        long r127 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r125)) & BodyPartID.bodyIdMax) | (r126 << 32));
    L44:
        return new PointerInputEventData(r101, r311.getEventTime(), r112, r113, r313, r110, r116, this.activeHoverIds.get(r311.getPointerId(r312), false), r117, r127, r210, null);
    L42:
        r127 = Offset.Companion.m4598getZeroF1C5BW0();
        goto L44
    L14:
        if (r114 != 2) goto L16;
        r115 = PointerType.Companion.m6204getStylusT8wyACA();
        goto L25
    L16:
        if (r114 != 3) goto L18;
        r115 = PointerType.Companion.m6203getMouseT8wyACA();
        goto L25
    L18:
        if (r114 == 4) goto L20;
        r115 = PointerType.Companion.m6206getUnknownT8wyACA();
        goto L25
    L20:
        r115 = PointerType.Companion.m6202getEraserT8wyACA();
        goto L25
    L24:
        r115 = PointerType.Companion.m6206getUnknownT8wyACA();
        goto L25
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        r109 = MotionEventHelper.INSTANCE.m6057toRawOffsetdBAh8RU(r311, r100);
        r111 = r310.mo6208screenToLocalMKHz9U(r109);
        goto L5
    L9:
        r113 = r105;
        r112 = r310.mo6207localToScreenMKHz9U(r105);
        goto L10
    }
}
