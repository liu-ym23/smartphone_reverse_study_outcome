package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.user.BroadcastConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b8\u00109R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\"\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\"\u0010!\u001a\u00020 8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020'8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001018\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/bytedance/android/live/base/model/user/BroadcastConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/user/p;", "", "scheduledMasterSwitch", "I", "getScheduledMasterSwitch", "()I", "setScheduledMasterSwitch", "(I)V", "scheduledProfileSwitch", "getScheduledProfileSwitch", "setScheduledProfileSwitch", "scheduledDays", "getScheduledDays", "setScheduledDays", "", "scheduledTime", "Ljava/lang/String;", "getScheduledTime", "()Ljava/lang/String;", "setScheduledTime", "(Ljava/lang/String;)V", "scheduledTimeText", "getScheduledTimeText", "setScheduledTimeText", "scheduledNoticeSwitchDisplay", "getScheduledNoticeSwitchDisplay", "setScheduledNoticeSwitchDisplay", "scheduledNoticeSwitch", "getScheduledNoticeSwitch", "setScheduledNoticeSwitch", "", "subscribeStatus", "Z", "getSubscribeStatus", "()Ljava/lang/Boolean;", "setSubscribeStatus", "(Z)V", "", "appointmentId", "J", "getAppointmentId", "()Ljava/lang/Long;", "setAppointmentId", "(J)V", "nextScheduledTime", "getNextScheduledTime", "setNextScheduledTime", "", "scheduledWeekDays", "Ljava/util/List;", "getScheduledWeekDays", "()Ljava/util/List;", "setScheduledWeekDays", "(Ljava/util/List;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BroadcastConfig extends FlexModelBase<p> implements p, vh7.h {

    @IgnoreProtoFieldCheck
    @SerializedName("appointment_id")
    protected long appointmentId;

    @IgnoreProtoFieldCheck
    @SerializedName("next_scheduled_time")
    protected long nextScheduledTime;

    @SerializedName("scheduled_days")
    protected int scheduledDays;

    @SerializedName("scheduled_master_switch")
    protected int scheduledMasterSwitch;

    @SerializedName("scheduled_notice_switch")
    protected int scheduledNoticeSwitch;

    @SerializedName("scheduled_notice_switch_display")
    protected int scheduledNoticeSwitchDisplay;

    @SerializedName("scheduled_profile_switch")
    protected int scheduledProfileSwitch;

    @SerializedName("scheduled_time")
    protected String scheduledTime;

    @SerializedName("scheduled_time_text")
    protected String scheduledTimeText;

    @IgnoreProtoFieldCheck
    @SerializedName("scheduled_week_days")
    protected List<Integer> scheduledWeekDays;

    @IgnoreProtoFieldCheck
    @SerializedName("subscribe_status")
    protected boolean subscribeStatus;

    public BroadcastConfig() {
        super(p.class);
    }

    @Override // com.bytedance.android.live.base.model.user.p
    public Long getAppointmentId() {
        return Long.valueOf(this.appointmentId);
    }

    @Override // com.bytedance.android.live.base.model.user.p
    public Long getNextScheduledTime() {
        return Long.valueOf(this.nextScheduledTime);
    }

    @Override // com.bytedance.android.live.base.model.user.p
    public Boolean getSubscribeStatus() {
        return Boolean.valueOf(this.subscribeStatus);
    }

    public final int getScheduledDays() {
        return this.scheduledDays;
    }

    @Override // com.bytedance.android.live.base.model.user.p
    public int getScheduledMasterSwitch() {
        return this.scheduledMasterSwitch;
    }

    public final int getScheduledNoticeSwitch() {
        return this.scheduledNoticeSwitch;
    }

    public final int getScheduledNoticeSwitchDisplay() {
        return this.scheduledNoticeSwitchDisplay;
    }

    public final int getScheduledProfileSwitch() {
        return this.scheduledProfileSwitch;
    }

    public final String getScheduledTime() {
        return this.scheduledTime;
    }

    @Override // com.bytedance.android.live.base.model.user.p
    public String getScheduledTimeText() {
        return this.scheduledTimeText;
    }

    @Override // com.bytedance.android.live.base.model.user.p
    public List<Integer> getScheduledWeekDays() {
        return this.scheduledWeekDays;
    }

    public BroadcastConfig(am3.g r100) {
        super(p.class);
        this.scheduledWeekDays = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this.nextScheduledTime = r100.j();
        goto L3
    L9:
        this.scheduledWeekDays.add(Integer.valueOf(r100.i()));
        goto L3
    L10:
        this.appointmentId = r100.j();
        goto L3
    L11:
        this.subscribeStatus = am3.h.a(r100);
        goto L3
    L12:
        this.scheduledNoticeSwitch = r100.i();
        goto L3
    L13:
        this.scheduledNoticeSwitchDisplay = r100.i();
        goto L3
    L14:
        this.scheduledTimeText = am3.h.c(r100);
        goto L3
    L15:
        this.scheduledDays = r100.i();
        goto L3
    L16:
        this.scheduledTime = am3.h.c(r100);
        goto L3
    L17:
        this.scheduledProfileSwitch = r100.i();
        goto L3
    L18:
        this.scheduledMasterSwitch = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L19:
        r100.d(r101);
        setThreadSafe(true);
    }

    public void setAppointmentId(long r100) {
        this.appointmentId = r100;
    }

    public void setNextScheduledTime(long r100) {
        this.nextScheduledTime = r100;
    }

    public final void setScheduledDays(int r100) {
        this.scheduledDays = r100;
    }

    public void setScheduledMasterSwitch(int r100) {
        this.scheduledMasterSwitch = r100;
    }

    public final void setScheduledNoticeSwitch(int r100) {
        this.scheduledNoticeSwitch = r100;
    }

    public final void setScheduledNoticeSwitchDisplay(int r100) {
        this.scheduledNoticeSwitchDisplay = r100;
    }

    public final void setScheduledProfileSwitch(int r100) {
        this.scheduledProfileSwitch = r100;
    }

    public final void setScheduledTime(String r100) {
        this.scheduledTime = r100;
    }

    public void setScheduledTimeText(String r100) {
        this.scheduledTimeText = r100;
    }

    public void setScheduledWeekDays(List<Integer> r100) {
        this.scheduledWeekDays = r100;
    }

    public void setSubscribeStatus(boolean r100) {
        this.subscribeStatus = r100;
    }
}
