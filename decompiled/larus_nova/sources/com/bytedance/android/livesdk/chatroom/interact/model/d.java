package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.RivalsResponse.ActivityTimeConfig")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/d;", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/c;", "activityTimeToday", "Lcom/bytedance/android/livesdk/chatroom/interact/model/c;", "getActivityTimeToday", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/c;", "setActivityTimeToday", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/c;)V", "activityTimeTomorrow", "getActivityTimeTomorrow", "setActivityTimeTomorrow", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements vh7.h {

    @SerializedName("activity_time_today")
    protected c activityTimeToday;

    @SerializedName("activity_time_tomorrow")
    protected c activityTimeTomorrow;

    public d() {
    }

    public d(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.activityTimeToday = new c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.activityTimeTomorrow = new c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
