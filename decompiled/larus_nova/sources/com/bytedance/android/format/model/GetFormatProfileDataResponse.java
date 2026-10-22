package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010)\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u0010,\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\"\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b/\u00101\"\u0004\b2\u00103R \u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR \u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR&\u0010;\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR\"\u0010E\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bF\u0010\"\"\u0004\bG\u0010$¨\u0006H"}, d2 = {"Lcom/bytedance/android/format/model/GetFormatProfileDataResponse;", "Ljava/io/Serializable;", "()V", "avatarAliasName", "", "getAvatarAliasName", "()Ljava/lang/String;", "setAvatarAliasName", "(Ljava/lang/String;)V", "avatarAuthor", "", "getAvatarAuthor", "()Ljava/lang/Integer;", "setAvatarAuthor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "avatarLarge", "Lcom/bytedance/android/format/model/UrlStruct;", "getAvatarLarge", "()Lcom/bytedance/android/format/model/UrlStruct;", "setAvatarLarge", "(Lcom/bytedance/android/format/model/UrlStruct;)V", "avatarMedium", "getAvatarMedium", "setAvatarMedium", "avatarOpenStatus", "getAvatarOpenStatus", "setAvatarOpenStatus", "avatarThumb", "getAvatarThumb", "setAvatarThumb", "botId", "", "getBotId", "()Ljava/lang/Long;", "setBotId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "discussionTopic", "getDiscussionTopic", "setDiscussionTopic", "formatDigitalHumanId", "getFormatDigitalHumanId", "setFormatDigitalHumanId", "formatID", "getFormatID", "setFormatID", "isFollowing", "", "()Ljava/lang/Boolean;", "setFollowing", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "nickName", "getNickName", "setNickName", "secUid", "getSecUid", "setSecUid", "skillInfos", "", "Lcom/bytedance/android/format/model/SimpleSkillInfo;", "getSkillInfos", "()Ljava/util/List;", "setSkillInfos", "(Ljava/util/List;)V", "strFormatId", "getStrFormatId", "setStrFormatId", "userCount", "getUserCount", "setUserCount", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetFormatProfileDataResponse implements Serializable {

    @SerializedName("avatar_alias_name")
    private String avatarAliasName;

    @SerializedName("avatar_author")
    private Integer avatarAuthor;

    @SerializedName("avatar_large")
    private UrlStruct avatarLarge;

    @SerializedName("avatar_medium")
    private UrlStruct avatarMedium;

    @SerializedName("avatar_open_status")
    private String avatarOpenStatus;

    @SerializedName("avatar_thumb")
    private UrlStruct avatarThumb;

    @SerializedName("im_bot_id")
    private Long botId;

    @SerializedName("discussion_topic")
    private String discussionTopic;

    @SerializedName("format_digital_human_id")
    private Long formatDigitalHumanId;

    @SerializedName("format_id")
    private Long formatID;

    @SerializedName("is_following")
    private Boolean isFollowing;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName("sec_uid")
    private String secUid;

    @SerializedName("skill_infos")
    private List<SimpleSkillInfo> skillInfos;

    @SerializedName("str_format_id")
    private String strFormatId;

    @SerializedName("user_count")
    private Long userCount;

    public GetFormatProfileDataResponse() {
    }

    public final String getAvatarAliasName() {
        return this.avatarAliasName;
    }

    public final Integer getAvatarAuthor() {
        return this.avatarAuthor;
    }

    public final UrlStruct getAvatarLarge() {
        return this.avatarLarge;
    }

    public final UrlStruct getAvatarMedium() {
        return this.avatarMedium;
    }

    public final String getAvatarOpenStatus() {
        return this.avatarOpenStatus;
    }

    public final UrlStruct getAvatarThumb() {
        return this.avatarThumb;
    }

    public final Long getBotId() {
        return this.botId;
    }

    public final String getDiscussionTopic() {
        return this.discussionTopic;
    }

    public final Long getFormatDigitalHumanId() {
        return this.formatDigitalHumanId;
    }

    public final Long getFormatID() {
        return this.formatID;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final List<SimpleSkillInfo> getSkillInfos() {
        return this.skillInfos;
    }

    public final String getStrFormatId() {
        return this.strFormatId;
    }

    public final Long getUserCount() {
        return this.userCount;
    }

    public final Boolean isFollowing() {
        return this.isFollowing;
    }

    public final void setAvatarAliasName(String r100) {
        this.avatarAliasName = r100;
    }

    public final void setAvatarAuthor(Integer r100) {
        this.avatarAuthor = r100;
    }

    public final void setAvatarLarge(UrlStruct r100) {
        this.avatarLarge = r100;
    }

    public final void setAvatarMedium(UrlStruct r100) {
        this.avatarMedium = r100;
    }

    public final void setAvatarOpenStatus(String r100) {
        this.avatarOpenStatus = r100;
    }

    public final void setAvatarThumb(UrlStruct r100) {
        this.avatarThumb = r100;
    }

    public final void setBotId(Long r100) {
        this.botId = r100;
    }

    public final void setDiscussionTopic(String r100) {
        this.discussionTopic = r100;
    }

    public final void setFollowing(Boolean r100) {
        this.isFollowing = r100;
    }

    public final void setFormatDigitalHumanId(Long r100) {
        this.formatDigitalHumanId = r100;
    }

    public final void setFormatID(Long r100) {
        this.formatID = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setSecUid(String r100) {
        this.secUid = r100;
    }

    public final void setSkillInfos(List<SimpleSkillInfo> r100) {
        this.skillInfos = r100;
    }

    public final void setStrFormatId(String r100) {
        this.strFormatId = r100;
    }

    public final void setUserCount(Long r100) {
        this.userCount = r100;
    }
}
