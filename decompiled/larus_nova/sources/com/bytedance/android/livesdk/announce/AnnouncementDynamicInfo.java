package com.bytedance.android.livesdk.announce;

import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class AnnouncementDynamicInfo extends com.bytedance.android.live.base.model.dynamic.c {

    @SerializedName("audit_status")
    public int auditStatus;

    @SerializedName("avatar")
    public ImageModel avatar;

    @SerializedName("content")
    public String content;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f103129id;
    public boolean isAnchor;

    @SerializedName("is_subscribed")
    public boolean isSubscribed;

    @SerializedName("nick_name")
    public String nickname;

    @SerializedName("release_time")
    public long releaseTime;

    @SerializedName("scheduled_date")
    public long scheduledDate;

    @SerializedName("scheduled_time")
    public long scheduledTime;

    @SerializedName("scheduled_time_text")
    public String scheduledTimeText;

    @SerializedName("scheduled_weekdays")
    public List<Integer> scheduledWeekDays;

    @SerializedName("subscribe_count")
    public long subscribeCount;

    @SerializedName("subscribe_user_avatar")
    public List<ImageModel> subscribeList;

    @SerializedName("switch")
    public boolean switchStatus;

    public boolean expired() {
        if (this.auditStatus != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public AnnouncementDynamicInfo() {
        this.scheduledTime = 0;
        this.scheduledDate = 0;
        this.scheduledWeekDays = new ArrayList();
        this.scheduledTimeText = "";
        this.content = "";
        this.auditStatus = 1;
        this.releaseTime = 0;
        this.isSubscribed = false;
        this.subscribeCount = 0;
        this.nickname = "";
        this.avatar = null;
        this.switchStatus = false;
        this.subscribeList = new ArrayList();
        this.isAnchor = false;
    }
}
