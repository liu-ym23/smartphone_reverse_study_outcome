package com.stepos.ailauncher.chat.voice.longpress;

import android.view.MotionEvent;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003J)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/P;", "", "<init>", "()V", "", "pointerId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", Const.INTENT_KEY_PKGNAME, "e", "f", "Landroid/view/MotionEvent;", "event", "Lkotlin/Function1;", "dispatchSingle", "c", "(Landroid/view/MotionEvent;Lp9/l;)V", UxipConstants.f30680s, "ownerId", "I", "getOwnerId", "()I", "", "isLocked", "Z", Const.INTENT_KEY_UMID, "()Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class P {
    private boolean isLocked;
    private int ownerId = -1;

    public final void a(int pointerId) {
        if (this.isLocked) {
            return;
        }
        this.ownerId = pointerId;
        this.isLocked = true;
    }

    public final void b() {
        this.ownerId = -1;
        this.isLocked = true;
    }

    public final void c(MotionEvent event, InterfaceC5074l<? super MotionEvent, Y8.t> dispatchSingle) {
        int iFindPointerIndex;
        int actionMasked;
        int actionMasked2;
        kotlin.jvm.internal.p.i(event, "event");
        kotlin.jvm.internal.p.i(dispatchSingle, "dispatchSingle");
        int i10 = this.ownerId;
        if (i10 == -1 || (iFindPointerIndex = event.findPointerIndex(i10)) == -1 || (actionMasked = event.getActionMasked()) == 5) {
            return;
        }
        if (actionMasked != 6) {
            actionMasked2 = event.getActionMasked();
        } else if (event.getPointerId(event.getActionIndex()) != i10) {
            return;
        } else {
            actionMasked2 = 1;
        }
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        event.getPointerProperties(iFindPointerIndex, pointerProperties);
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        event.getPointerCoords(iFindPointerIndex, pointerCoords);
        float f10 = pointerCoords.x;
        float f11 = pointerCoords.y;
        pointerCoords.x = event.getRawX(iFindPointerIndex);
        pointerCoords.y = event.getRawY(iFindPointerIndex);
        MotionEvent motionEventObtain = MotionEvent.obtain(event.getDownTime(), event.getEventTime(), actionMasked2, 1, new MotionEvent.PointerProperties[]{pointerProperties}, new MotionEvent.PointerCoords[]{pointerCoords}, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getFlags());
        motionEventObtain.offsetLocation(f10 - pointerCoords.x, f11 - pointerCoords.y);
        try {
            kotlin.jvm.internal.p.f(motionEventObtain);
            dispatchSingle.invoke(motionEventObtain);
        } finally {
            motionEventObtain.recycle();
            if (actionMasked2 == 1 || actionMasked2 == 3) {
                e();
            }
        }
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsLocked() {
        return this.isLocked;
    }

    public final void e() {
        this.ownerId = -1;
    }

    public final void f() {
        this.ownerId = -1;
        this.isLocked = false;
    }
}
