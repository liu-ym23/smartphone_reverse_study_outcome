package com.bytedance.android.livehostapi.business.depend.share;

import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\b¨\u0006,"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/LiveAnnouncementShareConfig;", "", "()V", "anchorId", "", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "announcementId", "", "getAnnouncementId", "()J", "setAnnouncementId", "(J)V", "announcementType", "getAnnouncementType", "setAnnouncementType", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "content", "getContent", "setContent", "displayScheduleTime", "getDisplayScheduleTime", "setDisplayScheduleTime", "isAnchor", "", "()Z", "setAnchor", "(Z)V", "isFans", "setFans", "nickName", "getNickName", "setNickName", "scheduleTime", "getScheduleTime", "setScheduleTime", "source", "getSource", "setSource", "anchorIdStr", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnnouncementShareConfig {

    @SerializedName("anchor_id")
    private String anchorId;

    @SerializedName("announcement_id")
    private long announcementId;

    @SerializedName("announcement_type")
    private String announcementType;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("content")
    private String content;

    @SerializedName("scheduled_time_text")
    private String displayScheduleTime;

    @SerializedName(IPerformanceManager.Params.is_anchor)
    private boolean isAnchor;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_IS_FANS)
    private boolean isFans;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName("schedule_time")
    private long scheduleTime;

    @SerializedName("source")
    private String source;

    public final String anchorIdStr() {
        o0.a r100 = o0.f58946a;
        String r101 = String.valueOf(this.anchorId);
        r100.getClass();
        return r101;
    }

    public LiveAnnouncementShareConfig() {
        this.announcementId = -1;
        this.scheduleTime = -1;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final long getAnnouncementId() {
        return this.announcementId;
    }

    public final String getAnnouncementType() {
        return this.announcementType;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getDisplayScheduleTime() {
        return this.displayScheduleTime;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final long getScheduleTime() {
        return this.scheduleTime;
    }

    public final String getSource() {
        return this.source;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final boolean isFans() {
        return this.isFans;
    }

    public final void setAnchor(boolean r100) {
        this.isAnchor = r100;
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setAnnouncementId(long r100) {
        this.announcementId = r100;
    }

    public final void setAnnouncementType(String r100) {
        this.announcementType = r100;
    }

    public final void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setDisplayScheduleTime(String r100) {
        this.displayScheduleTime = r100;
    }

    public final void setFans(boolean r100) {
        this.isFans = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setScheduleTime(long r100) {
        this.scheduleTime = r100;
    }

    public final void setSource(String r100) {
        this.source = r100;
    }
}
