package com.bytedance.android.livesdk.announce;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.AnnouncementInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/announce/SimpleAnnouncementInfo;", "", "()V", "appointmentId", "", "content", "", "scheduleDate", "", "scheduleTime", "scheduleWeekdays", "", "scheduledTimeText", "subscribed", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleAnnouncementInfo implements h {

    @SerializedName("appointment_id")
    public long appointmentId;

    @SerializedName("content")
    public String content;

    @SerializedName("scheduled_date")
    public int scheduleDate;

    @SerializedName("scheduled_time")
    public int scheduleTime;

    @SerializedName("scheduled_weekdays")
    public List<Integer> scheduleWeekdays;

    @SerializedName("scheduled_time_text")
    public String scheduledTimeText;

    @SerializedName("subscribed")
    public boolean subscribed;

    public SimpleAnnouncementInfo() {
        this.scheduledTimeText = "";
        this.content = "";
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
}
