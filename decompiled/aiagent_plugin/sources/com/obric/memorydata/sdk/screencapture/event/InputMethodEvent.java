package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InputMethodEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InputMethodEvent extends ScreenEvent {
    private final ScreenEvent.a eventType;
    private final boolean visible;

    public static /* synthetic */ InputMethodEvent copy$default(InputMethodEvent r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final InputMethodEvent copy(boolean r1) {
        return new InputMethodEvent(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InputMethodEvent.class) == true) goto L8;
        return false;
    L8:
        InputMethodEvent r6 = (InputMethodEvent) ZeusTransformUtils.preCheckCast(r5, InputMethodEvent.class, "com.obric.aiagent.plugin");
        if (this.visible == r6.visible) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Boolean.hashCode(this.visible);
    }

    public String toString() {
        return "InputMethodEvent(visible=" + this.visible + ')';
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public InputMethodEvent(boolean r2) {
        super(null);
        this.visible = r2;
        this.eventType = ScreenEvent.a.f33863b;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.a getEventType() {
        return this.eventType;
    }

    public InputMethodEvent(Parcel r2) {
        o.e(r2, "parcel");
        if (r2.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeByte(this.visible ? 1 : 0);
    }
}
