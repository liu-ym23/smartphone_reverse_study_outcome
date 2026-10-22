package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010$\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/d;", "", "", "subscribed", "Z", "e", "()Z", "setSubscribed", "(Z)V", "", "scheduledTimeText", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setScheduledTimeText", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "", "appointmentId", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setAppointmentId", "(J)V", "", "scheduleTime", "I", "getScheduleTime", "()I", "setScheduleTime", "(I)V", "scheduleDate", "getScheduleDate", "setScheduleDate", "nextLiveStartTime", "b", "setNextLiveStartTime", "", "scheduleWeekdays", "Ljava/util/List;", "c", "()Ljava/util/List;", "setScheduleWeekdays", "(Ljava/util/List;)V", "<init>", "()V", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("appointment_id")
    private long appointmentId;

    @SerializedName("content")
    private String content;

    @SerializedName("next_live_start_time")
    private int nextLiveStartTime;

    @SerializedName("scheduled_date")
    private int scheduleDate;

    @SerializedName("scheduled_time")
    private int scheduleTime;

    @SerializedName("scheduled_weekdays")
    private List<Integer> scheduleWeekdays;

    @SerializedName("scheduled_time_text")
    private String scheduledTimeText;

    @SerializedName("subscribed")
    private boolean subscribed;

    public d() {
        this.scheduledTimeText = "";
        this.content = "";
    }

    public final long a() {
        return this.appointmentId;
    }

    public final int b() {
        return this.nextLiveStartTime;
    }

    public final List<Integer> c() {
        return this.scheduleWeekdays;
    }

    public final String d() {
        return this.scheduledTimeText;
    }

    public final boolean e() {
        return this.subscribed;
    }
}
