package androidx.compose.ui.input.pointer;

import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\r\u001a\u00020\f*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\bJ/\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010&\u001a\u00020%8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u0003\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102¨\u00064"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/MotionEvent;", "motionEvent", "LC7/r;", "addFreshIds", "(Landroid/view/MotionEvent;)V", "removeStaleIds", "", "pointerId", "", "hasPointerId", "(Landroid/view/MotionEvent;I)Z", "motionEventPointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "getComposePointerId-_I2yYro", "(I)J", "getComposePointerId", "clearOnDeviceChange", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "positionCalculator", "index", "pressed", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "createPointerInputEventData", "(Landroidx/compose/ui/input/pointer/PositionCalculator;Landroid/view/MotionEvent;IZ)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "convertToPointerInputEvent$ui_release", "(Landroid/view/MotionEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;)Landroidx/compose/ui/input/pointer/PointerInputEvent;", "convertToPointerInputEvent", "endStream", "(I)V", "", "nextId", "J", "Landroid/util/SparseLongArray;", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release", "()Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui_release$annotations", "Landroid/util/SparseBooleanArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "", "pointers", "Ljava/util/List;", "previousToolType", "I", "previousSource", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MotionEventAdapter {
    public static final int $stable = 8;
    private long nextId;
    private final SparseLongArray motionEventToComposePointerIdMap = new SparseLongArray();
    private final SparseBooleanArray activeHoverIds = new SparseBooleanArray();
    private final List<PointerInputEventData> pointers = new ArrayList();
    private int previousToolType = -1;
    private int previousSource = -1;

    private final void addFreshIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 9) {
                return;
            }
            int pointerId = motionEvent.getPointerId(0);
            if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId) < 0) {
                SparseLongArray sparseLongArray = this.motionEventToComposePointerIdMap;
                long j5 = this.nextId;
                this.nextId = 1 + j5;
                sparseLongArray.put(pointerId, j5);
                return;
            }
            return;
        }
        int actionIndex = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex);
        if (this.motionEventToComposePointerIdMap.indexOfKey(pointerId2) < 0) {
            SparseLongArray sparseLongArray2 = this.motionEventToComposePointerIdMap;
            long j6 = this.nextId;
            this.nextId = 1 + j6;
            sparseLongArray2.put(pointerId2, j6);
            if (motionEvent.getToolType(actionIndex) == 3) {
                this.activeHoverIds.put(pointerId2, true);
            }
        }
    }

    private final void clearOnDeviceChange(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return;
        }
        int toolType = motionEvent.getToolType(0);
        int source = motionEvent.getSource();
        if (toolType == this.previousToolType && source == this.previousSource) {
            return;
        }
        this.previousToolType = toolType;
        this.previousSource = source;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    private final PointerInputEventData createPointerInputEventData(PositionCalculator positionCalculator, MotionEvent motionEvent, int index, boolean pressed) {
        long jM5352toRawOffsetdBAh8RU;
        long jMo5502screenToLocalMKHz9U;
        long j5;
        int i = index;
        long jM5351getComposePointerId_I2yYro = m5351getComposePointerId_I2yYro(motionEvent.getPointerId(index));
        float pressure = motionEvent.getPressure(index);
        long j6 = 4294967295L;
        long jM3889copydBAh8RU$default = Offset.m3889copydBAh8RU$default(Offset.m3887constructorimpl((Float.floatToRawIntBits(motionEvent.getY(index)) & 4294967295L) | (Float.floatToRawIntBits(motionEvent.getX(index)) << 32)), 0.0f, 0.0f, 3, null);
        if (i == 0) {
            jM5352toRawOffsetdBAh8RU = Offset.m3887constructorimpl((Float.floatToRawIntBits(motionEvent.getRawY()) & 4294967295L) | (Float.floatToRawIntBits(motionEvent.getRawX()) << 32));
            jMo5502screenToLocalMKHz9U = positionCalculator.mo5502screenToLocalMKHz9U(jM5352toRawOffsetdBAh8RU);
        } else {
            jM5352toRawOffsetdBAh8RU = MotionEventHelper.INSTANCE.m5352toRawOffsetdBAh8RU(motionEvent, i);
            jMo5502screenToLocalMKHz9U = positionCalculator.mo5502screenToLocalMKHz9U(jM5352toRawOffsetdBAh8RU);
        }
        int toolType = motionEvent.getToolType(index);
        int iM5500getUnknownT8wyACA = toolType != 0 ? toolType != 1 ? toolType != 2 ? toolType != 3 ? toolType != 4 ? PointerType.INSTANCE.m5500getUnknownT8wyACA() : PointerType.INSTANCE.m5496getEraserT8wyACA() : PointerType.INSTANCE.m5497getMouseT8wyACA() : PointerType.INSTANCE.m5498getStylusT8wyACA() : PointerType.INSTANCE.m5499getTouchT8wyACA() : PointerType.INSTANCE.m5500getUnknownT8wyACA();
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
        int historySize = motionEvent.getHistorySize();
        int i6 = 0;
        while (i6 < historySize) {
            float historicalX = motionEvent.getHistoricalX(i, i6);
            float historicalY = motionEvent.getHistoricalY(i, i6);
            long j10 = j6;
            if ((Float.floatToRawIntBits(historicalX) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(historicalY) & Integer.MAX_VALUE) >= 2139095040) {
                j5 = jM5352toRawOffsetdBAh8RU;
            } else {
                long jFloatToRawIntBits = Float.floatToRawIntBits(historicalX);
                j5 = jM5352toRawOffsetdBAh8RU;
                long jM3887constructorimpl = Offset.m3887constructorimpl((Float.floatToRawIntBits(historicalY) & j10) | (jFloatToRawIntBits << 32));
                arrayList.add(new HistoricalChange(motionEvent.getHistoricalEventTime(i6), jM3887constructorimpl, jM3887constructorimpl, null));
            }
            i6++;
            i = index;
            jM5352toRawOffsetdBAh8RU = j5;
            j6 = j10;
        }
        return new PointerInputEventData(jM5351getComposePointerId_I2yYro, motionEvent.getEventTime(), jM5352toRawOffsetdBAh8RU, jMo5502screenToLocalMKHz9U, pressed, pressure, iM5500getUnknownT8wyACA, this.activeHoverIds.get(motionEvent.getPointerId(index), false), arrayList, motionEvent.getActionMasked() == 8 ? Offset.m3887constructorimpl((Float.floatToRawIntBits((-motionEvent.getAxisValue(9)) + 0.0f) & j6) | (Float.floatToRawIntBits(motionEvent.getAxisValue(10)) << 32)) : Offset.INSTANCE.m3911getZeroF1C5BW0(), jM3889copydBAh8RU$default, null);
    }

    /* renamed from: getComposePointerId-_I2yYro, reason: not valid java name */
    private final long m5351getComposePointerId_I2yYro(int motionEventPointerId) {
        long jValueAt;
        int iIndexOfKey = this.motionEventToComposePointerIdMap.indexOfKey(motionEventPointerId);
        if (iIndexOfKey >= 0) {
            jValueAt = this.motionEventToComposePointerIdMap.valueAt(iIndexOfKey);
        } else {
            long j5 = this.nextId;
            this.nextId = 1 + j5;
            this.motionEventToComposePointerIdMap.put(motionEventPointerId, j5);
            jValueAt = j5;
        }
        return PointerId.m5401constructorimpl(jValueAt);
    }

    @VisibleForTesting
    public static /* synthetic */ void getMotionEventToComposePointerIdMap$ui_release$annotations() {
    }

    private final boolean hasPointerId(MotionEvent motionEvent, int i) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i6 = 0; i6 < pointerCount; i6++) {
            if (motionEvent.getPointerId(i6) == i) {
                return true;
            }
        }
        return false;
    }

    private final void removeStaleIds(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (!this.activeHoverIds.get(pointerId, false)) {
                this.motionEventToComposePointerIdMap.delete(pointerId);
                this.activeHoverIds.delete(pointerId);
            }
        }
        if (this.motionEventToComposePointerIdMap.size() > motionEvent.getPointerCount()) {
            for (int size = this.motionEventToComposePointerIdMap.size() - 1; -1 < size; size--) {
                int iKeyAt = this.motionEventToComposePointerIdMap.keyAt(size);
                if (!hasPointerId(motionEvent, iKeyAt)) {
                    this.motionEventToComposePointerIdMap.removeAt(size);
                    this.activeHoverIds.delete(iKeyAt);
                }
            }
        }
    }

    public final PointerInputEvent convertToPointerInputEvent$ui_release(MotionEvent motionEvent, PositionCalculator positionCalculator) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 4) {
            this.motionEventToComposePointerIdMap.clear();
            this.activeHoverIds.clear();
            return null;
        }
        clearOnDeviceChange(motionEvent);
        addFreshIds(motionEvent);
        boolean z10 = actionMasked == 9 || actionMasked == 7 || actionMasked == 10;
        boolean z11 = actionMasked == 8;
        if (z10) {
            this.activeHoverIds.put(motionEvent.getPointerId(motionEvent.getActionIndex()), true);
        }
        int actionIndex = actionMasked != 1 ? actionMasked != 6 ? -1 : motionEvent.getActionIndex() : 0;
        this.pointers.clear();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (i < pointerCount) {
            this.pointers.add(createPointerInputEventData(positionCalculator, motionEvent, i, (z10 || i == actionIndex || (z11 && motionEvent.getButtonState() == 0)) ? false : true));
            i++;
        }
        removeStaleIds(motionEvent);
        return new PointerInputEvent(motionEvent.getEventTime(), this.pointers, motionEvent);
    }

    public final void endStream(int pointerId) {
        this.activeHoverIds.delete(pointerId);
        this.motionEventToComposePointerIdMap.delete(pointerId);
    }

    /* renamed from: getMotionEventToComposePointerIdMap$ui_release, reason: from getter */
    public final SparseLongArray getMotionEventToComposePointerIdMap() {
        return this.motionEventToComposePointerIdMap;
    }
}
