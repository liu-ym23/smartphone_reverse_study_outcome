package com.mdisdk.mirror;

import D7.v;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\fJ\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dR0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u001ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f`\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/mdisdk/mirror/PointerStateMachine;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/MotionEvent;", "ev", "LC7/r;", "clearAndInit", "(Landroid/view/MotionEvent;)V", "", "physicalId", "allocLogicalId", "(I)I", "index", "logicalId", "Lcom/mdisdk/mirror/PointerRecord;", "createPointer", "(Landroid/view/MotionEvent;II)Lcom/mdisdk/mirror/PointerRecord;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "", "time", "Lcom/mdisdk/mirror/LogicalTouchEvent;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "(IJ)Lcom/mdisdk/mirror/LogicalTouchEvent;", "pointerDownAction", "pointerUpAction", "reset", "()Lcom/mdisdk/mirror/LogicalTouchEvent;", "onMotionEvent", "(Landroid/view/MotionEvent;)Lcom/mdisdk/mirror/LogicalTouchEvent;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "physicalToLogical", "Ljava/util/LinkedHashMap;", "activePointers", "nextLogicalId", "I", "downTime", "J", "", "isActive", "Z", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PointerStateMachine {
    private static final int MAX_POINTERS = 5;
    private long downTime;
    private boolean isActive;
    private int nextLogicalId;
    private final LinkedHashMap<Integer, Integer> physicalToLogical = new LinkedHashMap<>();
    private final LinkedHashMap<Integer, PointerRecord> activePointers = new LinkedHashMap<>();

    private final int allocLogicalId(int physicalId) {
        LinkedHashMap<Integer, Integer> linkedHashMap = this.physicalToLogical;
        Integer numValueOf = Integer.valueOf(physicalId);
        Integer numValueOf2 = linkedHashMap.get(numValueOf);
        if (numValueOf2 == null) {
            int i = this.nextLogicalId;
            this.nextLogicalId = i + 1;
            numValueOf2 = Integer.valueOf(i);
            linkedHashMap.put(numValueOf, numValueOf2);
        }
        return numValueOf2.intValue();
    }

    private final LogicalTouchEvent build(int action, long time) {
        Collection<PointerRecord> collectionValues = this.activePointers.values();
        k.e(collectionValues, "<get-values>(...)");
        return new LogicalTouchEvent(action, v.f1(collectionValues), this.downTime, time);
    }

    private final void clearAndInit(MotionEvent ev) {
        this.physicalToLogical.clear();
        this.activePointers.clear();
        this.nextLogicalId = 0;
        this.downTime = ev.getDownTime();
        this.isActive = true;
    }

    private final PointerRecord createPointer(MotionEvent ev, int index, int logicalId) {
        return new PointerRecord(logicalId, ev.getX(index), ev.getY(index), ev.getPressure(index));
    }

    private final int pointerDownAction(int logicalId) {
        Set<Integer> setKeySet = this.activePointers.keySet();
        k.e(setKeySet, "<get-keys>(...)");
        return (v.E0(setKeySet, Integer.valueOf(logicalId)) << 8) | 5;
    }

    private final int pointerUpAction(int logicalId) {
        Set<Integer> setKeySet = this.activePointers.keySet();
        k.e(setKeySet, "<get-keys>(...)");
        return (v.E0(setKeySet, Integer.valueOf(logicalId)) << 8) | 6;
    }

    public final LogicalTouchEvent onMotionEvent(MotionEvent ev) {
        PointerRecord pointerRecord;
        k.f(ev, "ev");
        long eventTime = ev.getEventTime();
        int actionMasked = ev.getActionMasked();
        if (actionMasked == 0) {
            clearAndInit(ev);
            int iAllocLogicalId = allocLogicalId(ev.getPointerId(0));
            this.activePointers.put(Integer.valueOf(iAllocLogicalId), createPointer(ev, 0, iAllocLogicalId));
            return build(0, eventTime);
        }
        if (actionMasked == 1) {
            if (!this.isActive) {
                return null;
            }
            LogicalTouchEvent logicalTouchEventBuild = build(1, eventTime);
            this.physicalToLogical.clear();
            this.activePointers.clear();
            this.isActive = false;
            this.nextLogicalId = 0;
            return logicalTouchEventBuild;
        }
        if (actionMasked == 2) {
            if (!this.isActive) {
                return null;
            }
            int pointerCount = ev.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                Integer num = this.physicalToLogical.get(Integer.valueOf(ev.getPointerId(i)));
                if (num != null && (pointerRecord = this.activePointers.get(num)) != null) {
                    pointerRecord.setX(ev.getX(i));
                    pointerRecord.setY(ev.getY(i));
                    pointerRecord.setPressure(ev.getPressure(i));
                }
            }
            return build(2, eventTime);
        }
        if (actionMasked == 3) {
            return reset();
        }
        if (actionMasked == 5) {
            if (!this.isActive || this.activePointers.size() >= 5) {
                return null;
            }
            int actionIndex = ev.getActionIndex();
            int iAllocLogicalId2 = allocLogicalId(ev.getPointerId(actionIndex));
            this.activePointers.put(Integer.valueOf(iAllocLogicalId2), createPointer(ev, actionIndex, iAllocLogicalId2));
            return build(pointerDownAction(iAllocLogicalId2), eventTime);
        }
        if (actionMasked != 6 || !this.isActive) {
            return null;
        }
        int actionIndex2 = ev.getActionIndex();
        int pointerId = ev.getPointerId(actionIndex2);
        Integer num2 = this.physicalToLogical.get(Integer.valueOf(pointerId));
        if (num2 == null) {
            return null;
        }
        int iIntValue = num2.intValue();
        PointerRecord pointerRecord2 = this.activePointers.get(num2);
        if (pointerRecord2 != null) {
            pointerRecord2.setX(ev.getX(actionIndex2));
            pointerRecord2.setY(ev.getY(actionIndex2));
        }
        LogicalTouchEvent logicalTouchEventBuild2 = build(pointerUpAction(iIntValue), eventTime);
        this.physicalToLogical.remove(Integer.valueOf(pointerId));
        this.activePointers.remove(num2);
        return logicalTouchEventBuild2;
    }

    public final LogicalTouchEvent reset() {
        if (!this.isActive) {
            return null;
        }
        Collection<PointerRecord> collectionValues = this.activePointers.values();
        k.e(collectionValues, "<get-values>(...)");
        LogicalTouchEvent logicalTouchEvent = new LogicalTouchEvent(3, v.f1(collectionValues), this.downTime, SystemClock.uptimeMillis());
        this.physicalToLogical.clear();
        this.activePointers.clear();
        this.isActive = false;
        this.nextLogicalId = 0;
        return logicalTouchEvent;
    }
}
