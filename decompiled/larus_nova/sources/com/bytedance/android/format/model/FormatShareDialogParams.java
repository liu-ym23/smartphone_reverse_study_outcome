package com.bytedance.android.format.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b \b\u0007\u0018\u0000 32\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b¨\u00065"}, d2 = {"Lcom/bytedance/android/format/model/FormatShareDialogParams;", "", "", "formatId", "Ljava/lang/String;", "getFormatId", "()Ljava/lang/String;", "setFormatId", "(Ljava/lang/String;)V", "botId", "getBotId", "setBotId", "nickName", "getNickName", "setNickName", "discussionTopic", "getDiscussionTopic", "setDiscussionTopic", "iconUrl", "getIconUrl", "setIconUrl", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "editHint", "getEditHint", "setEditHint", "toastText", "getToastText", "setToastText", "toastType", "I", "getToastType", "()I", "setToastType", "(I)V", "toastIcon", "getToastIcon", "setToastIcon", "ownerId", "getOwnerId", "setOwnerId", "botSecUid", "getBotSecUid", "setBotSecUid", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatShareDialogParams {
    public static final a Companion = null;
    public static final int TYPE_BOT_SHARE = 1;

    @SerializedName("im_bot_id")
    private String botId;

    @SerializedName("bot_sec_uid")
    private String botSecUid;

    @SerializedName("discussion_topic")
    private String discussionTopic;

    @SerializedName("edit_hint")
    private String editHint;

    @SerializedName("format_id")
    private String formatId;

    @SerializedName("avatar_url")
    private String iconUrl;

    @SerializedName("nick_name")
    private String nickName;

    @SerializedName("owner_id")
    private String ownerId;

    @SerializedName("toast_icon")
    private String toastIcon;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
    private String toastText;

    @SerializedName("toast_type")
    private int toastType;

    @SerializedName("share_type")
    private Integer type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FormatShareDialogParams() {
        this.toastType = 1;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getBotSecUid() {
        return this.botSecUid;
    }

    public final String getDiscussionTopic() {
        return this.discussionTopic;
    }

    public final String getEditHint() {
        return this.editHint;
    }

    public final String getFormatId() {
        return this.formatId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getToastIcon() {
        return this.toastIcon;
    }

    public final String getToastText() {
        return this.toastText;
    }

    public final int getToastType() {
        return this.toastType;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setBotId(String r100) {
        this.botId = r100;
    }

    public final void setBotSecUid(String r100) {
        this.botSecUid = r100;
    }

    public final void setDiscussionTopic(String r100) {
        this.discussionTopic = r100;
    }

    public final void setEditHint(String r100) {
        this.editHint = r100;
    }

    public final void setFormatId(String r100) {
        this.formatId = r100;
    }

    public final void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public final void setToastIcon(String r100) {
        this.toastIcon = r100;
    }

    public final void setToastText(String r100) {
        this.toastText = r100;
    }

    public final void setToastType(int r100) {
        this.toastType = r100;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }
}
