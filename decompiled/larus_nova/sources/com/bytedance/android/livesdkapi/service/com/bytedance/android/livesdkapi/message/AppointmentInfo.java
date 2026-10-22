package com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message;

import am3.g;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR&\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/com/bytedance/android/livesdkapi/message/AppointmentInfo;", "", "()V", "appointmentId", "", "getAppointmentId", "()Ljava/lang/String;", "setAppointmentId", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "nextLiveStartTime", "", "getNextLiveStartTime", "()J", "setNextLiveStartTime", "(J)V", "scheduledDate", "", "getScheduledDate", "()I", "setScheduledDate", "(I)V", "scheduledTime", "getScheduledTime", "setScheduledTime", "scheduledTimeText", "getScheduledTimeText", "setScheduledTimeText", "scheduledWeekdays", "", "getScheduledWeekdays", "()Ljava/util/List;", "setScheduledWeekdays", "(Ljava/util/List;)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentInfo implements h {

    @SerializedName("appointment_id")
    protected String appointmentId;

    @SerializedName("content")
    protected String content;

    @SerializedName("enabled")
    protected boolean enabled;

    @SerializedName("next_live_start_time")
    protected long nextLiveStartTime;

    @SerializedName("scheduled_date")
    protected int scheduledDate;

    @SerializedName("scheduled_time")
    protected int scheduledTime;

    @SerializedName("scheduled_time_text")
    protected String scheduledTimeText;

    @SerializedName("scheduled_weekdays")
    protected List<Integer> scheduledWeekdays;

    public AppointmentInfo() {
        this.appointmentId = "";
        this.scheduledTimeText = "";
        this.scheduledWeekdays = new ArrayList();
        this.content = "";
    }

    public final String getAppointmentId() {
        return this.appointmentId;
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final long getNextLiveStartTime() {
        return this.nextLiveStartTime;
    }

    public final int getScheduledDate() {
        return this.scheduledDate;
    }

    public final int getScheduledTime() {
        return this.scheduledTime;
    }

    public final String getScheduledTimeText() {
        return this.scheduledTimeText;
    }

    public final List<Integer> getScheduledWeekdays() {
        return this.scheduledWeekdays;
    }

    public AppointmentInfo(g r100) {
        this.scheduledWeekdays = new ArrayList();
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
        this.content = am3.h.c(r100);
        goto L3
    L8:
        this.scheduledWeekdays.add(Integer.valueOf(r100.i()));
        goto L3
    L9:
        this.nextLiveStartTime = r100.j();
        goto L3
    L10:
        this.scheduledDate = r100.i();
        goto L3
    L11:
        this.scheduledTime = r100.i();
        goto L3
    L12:
        this.scheduledTimeText = am3.h.c(r100);
        goto L3
    L13:
        this.appointmentId = am3.h.c(r100);
        goto L3
    L14:
        this.enabled = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.appointmentId != null) goto L19;
        this.appointmentId = "";
    L19:
        if (this.scheduledTimeText != null) goto L22;
        this.scheduledTimeText = "";
    L22:
        if (this.scheduledWeekdays.isEmpty() == false) goto L25;
        this.scheduledWeekdays = new ArrayList();
    L25:
        if (this.content != null) goto L48;
        this.content = "";
        return;
    }

    public final void setAppointmentId(String r100) {
        this.appointmentId = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    public final void setNextLiveStartTime(long r100) {
        this.nextLiveStartTime = r100;
    }

    public final void setScheduledDate(int r100) {
        this.scheduledDate = r100;
    }

    public final void setScheduledTime(int r100) {
        this.scheduledTime = r100;
    }

    public final void setScheduledTimeText(String r100) {
        this.scheduledTimeText = r100;
    }

    public final void setScheduledWeekdays(List<Integer> r100) {
        this.scheduledWeekdays = r100;
    }
}
