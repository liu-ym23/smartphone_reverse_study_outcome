package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.AnnouncementInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R&\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/SimpleAnnouncementInfo;", "", "()V", "appointmentId", "", "getAppointmentId", "()J", "setAppointmentId", "(J)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "scheduleDate", "", "getScheduleDate", "()I", "setScheduleDate", "(I)V", "scheduleTime", "getScheduleTime", "setScheduleTime", "scheduleWeekdays", "", "getScheduleWeekdays", "()Ljava/util/List;", "setScheduleWeekdays", "(Ljava/util/List;)V", "scheduledTimeText", "getScheduledTimeText", "setScheduledTimeText", "subscribed", "", "getSubscribed", "()Z", "setSubscribed", "(Z)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleAnnouncementInfo implements h {

    @SerializedName("appointment_id")
    protected long appointmentId;

    @SerializedName("content")
    protected String content;

    @SerializedName("scheduled_date")
    protected int scheduleDate;

    @SerializedName("scheduled_time")
    protected int scheduleTime;

    @SerializedName("scheduled_weekdays")
    protected List<Integer> scheduleWeekdays;

    @SerializedName("scheduled_time_text")
    protected String scheduledTimeText;

    @SerializedName("subscribed")
    protected boolean subscribed;

    public SimpleAnnouncementInfo() {
        this.scheduledTimeText = "";
        this.content = "";
    }

    public final long getAppointmentId() {
        return this.appointmentId;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getScheduleDate() {
        return this.scheduleDate;
    }

    public final int getScheduleTime() {
        return this.scheduleTime;
    }

    public final List<Integer> getScheduleWeekdays() {
        return this.scheduleWeekdays;
    }

    public final String getScheduledTimeText() {
        return this.scheduledTimeText;
    }

    public final boolean getSubscribed() {
        return this.subscribed;
    }

    public SimpleAnnouncementInfo(g r100) {
        this.scheduleWeekdays = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.scheduleWeekdays.add(Integer.valueOf(r100.i()));
        goto L3
    L8:
        this.scheduleDate = r100.i();
        goto L3
    L9:
        this.scheduleTime = r100.i();
        goto L3
    L10:
        this.appointmentId = r100.j();
        goto L3
    L11:
        this.subscribed = am3.h.a(r100);
        goto L3
    L12:
        this.content = am3.h.c(r100);
        goto L3
    L13:
        this.scheduledTimeText = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.scheduledTimeText != null) goto L18;
        this.scheduledTimeText = "";
    L18:
        if (this.content != null) goto L39;
        this.content = "";
        return;
    }

    public final void setAppointmentId(long r100) {
        this.appointmentId = r100;
    }

    public final void setContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setScheduleDate(int r100) {
        this.scheduleDate = r100;
    }

    public final void setScheduleTime(int r100) {
        this.scheduleTime = r100;
    }

    public final void setScheduleWeekdays(List<Integer> r100) {
        this.scheduleWeekdays = r100;
    }

    public final void setScheduledTimeText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scheduledTimeText = r100;
    }

    public final void setSubscribed(boolean r100) {
        this.subscribed = r100;
    }
}
