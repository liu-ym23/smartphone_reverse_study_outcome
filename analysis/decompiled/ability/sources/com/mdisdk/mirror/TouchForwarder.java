package com.mdisdk.mirror;

import android.graphics.PointF;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.base.ALog;
import com.mdisdk.capability.input.EventInjectManager;
import com.mdisdk.capability.model.WindowStateInfo;
import g1.AbstractC1451a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/mdisdk/mirror/TouchForwarder;", "", AppAgent.CONSTRUCT, "()V", "Lcom/mdisdk/mirror/LogicalTouchEvent;", "logical", "", WindowStateInfo.KEY_DISPLAY_ID, "", "inject", "(Lcom/mdisdk/mirror/LogicalTouchEvent;I)Z", "Lcom/mdisdk/mirror/ScaleMode;", "mode", "LC7/r;", "setScaleMode", "(Lcom/mdisdk/mirror/ScaleMode;)V", "getScaleMode", "()Lcom/mdisdk/mirror/ScaleMode;", "viewWidth", "viewHeight", "displayWidth", "displayHeight", "updateViewSize", "(IIII)V", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "forward", "(Landroid/view/MotionEvent;I)Z", "cancel", "(I)V", "Lcom/mdisdk/mirror/PointerStateMachine;", "stateMachine", "Lcom/mdisdk/mirror/PointerStateMachine;", "Lcom/mdisdk/mirror/DisplayScaler;", "scaler", "Lcom/mdisdk/mirror/DisplayScaler;", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TouchForwarder {
    private static final String TAG = "TouchForwarder";
    private final PointerStateMachine stateMachine = new PointerStateMachine();
    private final DisplayScaler scaler = new DisplayScaler();

    private final boolean inject(LogicalTouchEvent logical, int displayId) {
        List<PointerRecord> pointers = logical.getPointers();
        if (pointers.isEmpty()) {
            return false;
        }
        int size = pointers.size();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[size];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[size];
        int size2 = pointers.size();
        boolean z10 = false;
        for (int i = 0; i < size2; i++) {
            PointerRecord pointerRecord = pointers.get(i);
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = pointerRecord.getLogicalId();
            pointerProperties.toolType = 1;
            pointerPropertiesArr[i] = pointerProperties;
            PointF pointFScalePoint = this.scaler.scalePoint(pointerRecord.getX(), pointerRecord.getY());
            float fT = pointFScalePoint.x;
            float fT2 = pointFScalePoint.y;
            if (this.scaler.isInDisplayBounds(fT, fT2)) {
                fT = AbstractC1451a.t(fT, 0.0f, this.scaler.getDisplayWidth());
                fT2 = AbstractC1451a.t(fT2, 0.0f, this.scaler.getDisplayHeight());
            } else {
                z10 = true;
            }
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.x = fT;
            pointerCoords.y = fT2;
            pointerCoords.pressure = pointerRecord.getPressure();
            pointerCoords.size = 1.0f;
            pointerCoordsArr[i] = pointerCoords;
        }
        if (z10 && logical.getAction() == 0) {
            ALog.d$default(TAG, "ACTION_DOWN in letterbox/out-of-bounds area — discarded", null, 4, null);
            this.stateMachine.reset();
            return false;
        }
        try {
            MotionEvent motionEventObtain = MotionEvent.obtain(logical.getDownTime(), logical.getEventTime(), logical.getAction(), size, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0);
            boolean zInjectRawMotionEvent = EventInjectManager.injectRawMotionEvent(motionEventObtain, displayId);
            motionEventObtain.recycle();
            return zInjectRawMotionEvent;
        } catch (Exception e) {
            ALog.e(TAG, "Failed to build/inject MotionEvent: " + e.getMessage(), e);
            return false;
        }
    }

    public final void cancel(int displayId) {
        LogicalTouchEvent logicalTouchEventReset = this.stateMachine.reset();
        if (logicalTouchEventReset == null) {
            return;
        }
        inject(logicalTouchEventReset, displayId);
    }

    public final boolean forward(MotionEvent event, int displayId) {
        k.f(event, "event");
        LogicalTouchEvent logicalTouchEventOnMotionEvent = this.stateMachine.onMotionEvent(event);
        if (logicalTouchEventOnMotionEvent == null) {
            return false;
        }
        return inject(logicalTouchEventOnMotionEvent, displayId);
    }

    public final ScaleMode getScaleMode() {
        return this.scaler.getScaleMode();
    }

    public final void setScaleMode(ScaleMode mode) {
        k.f(mode, "mode");
        this.scaler.setScaleMode(mode);
    }

    public final void updateViewSize(int viewWidth, int viewHeight, int displayWidth, int displayHeight) {
        this.scaler.calculateScale(viewWidth, viewHeight, displayWidth, displayHeight);
    }
}
