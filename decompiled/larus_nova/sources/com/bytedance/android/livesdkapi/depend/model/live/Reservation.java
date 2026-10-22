package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.Reservation")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001e\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/Reservation;", "", "()V", "anchorId", "", "getAnchorId", "()J", "setAnchorId", "(J)V", "appointmentId", "getAppointmentId", "setAppointmentId", "buttonColor", "", "getButtonColor", "()Ljava/lang/String;", "setButtonColor", "(Ljava/lang/String;)V", "buttonRect", "", "getButtonRect", "()Ljava/util/List;", "setButtonRect", "(Ljava/util/List;)V", "endTime", "getEndTime", "setEndTime", "isReserved", "", "()Z", "setReserved", "(Z)V", "roomId", "getRoomId", "setRoomId", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Reservation implements h {

    @SerializedName("anchor_id")
    protected long anchorId;

    @SerializedName("appointment_id")
    protected long appointmentId;

    @SerializedName("btn_color")
    protected String buttonColor;

    @SerializedName("btn_rect")
    protected List<Long> buttonRect;

    @SerializedName("end_time")
    protected long endTime;

    @SerializedName("is_reserved")
    protected boolean isReserved;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    public Reservation() {
    }

    public final long getAnchorId() {
        return this.anchorId;
    }

    public final long getAppointmentId() {
        return this.appointmentId;
    }

    public final String getButtonColor() {
        return this.buttonColor;
    }

    public final List<Long> getButtonRect() {
        return this.buttonRect;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final boolean isReserved() {
        return this.isReserved;
    }

    public Reservation(g r100) {
        this.buttonRect = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        this.isReserved = am3.h.a(r100);
        goto L3
    L8:
        this.buttonColor = am3.h.c(r100);
        goto L3
    L9:
        this.buttonRect.add(Long.valueOf(r100.j()));
        goto L3
    L10:
        this.endTime = r100.j();
        goto L3
    L11:
        this.startTime = r100.j();
        goto L3
    L12:
        this.roomId = r100.j();
        goto L3
    L13:
        this.anchorId = r100.j();
        goto L3
    L14:
        this.appointmentId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setAnchorId(long r100) {
        this.anchorId = r100;
    }

    public final void setAppointmentId(long r100) {
        this.appointmentId = r100;
    }

    public final void setButtonColor(String r100) {
        this.buttonColor = r100;
    }

    public final void setButtonRect(List<Long> r100) {
        this.buttonRect = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setReserved(boolean r100) {
        this.isReserved = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }
}
