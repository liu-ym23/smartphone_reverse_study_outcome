package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/user/p;", "Lvh7/c;", "", "getScheduledMasterSwitch", "()I", "scheduledMasterSwitch", "", "getScheduledTimeText", "()Ljava/lang/String;", "scheduledTimeText", "", "getSubscribeStatus", "()Ljava/lang/Boolean;", "subscribeStatus", "", "getAppointmentId", "()Ljava/lang/Long;", "appointmentId", "getNextScheduledTime", "nextScheduledTime", "", "getScheduledWeekDays", "()Ljava/util/List;", "scheduledWeekDays", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p extends vh7.c<p> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    Long getAppointmentId();

    Long getNextScheduledTime();

    int getScheduledMasterSwitch();

    String getScheduledTimeText();

    List<Integer> getScheduledWeekDays();

    Boolean getSubscribeStatus();
}
