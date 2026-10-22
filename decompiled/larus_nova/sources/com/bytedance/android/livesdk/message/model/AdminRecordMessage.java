package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.AdminRecordAdminInfo;
import com.bytedance.android.livesdkapi.depend.model.live.PublishItemTextExtraInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.search.dto.UserGroupScene;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.AdminRecordMessage")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/AdminRecordMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "item_id", "J", "getItem_id", "()J", "setItem_id", "(J)V", "draft_id", "getDraft_id", "setDraft_id", "", "videoUrl", "Ljava/lang/String;", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "videoText", "getVideoText", "setVideoText", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/PublishItemTextExtraInfo;", "textDescInfos", "Ljava/util/List;", "getTextDescInfos", "()Ljava/util/List;", "setTextDescInfos", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/AdminRecordAdminInfo;", UserGroupScene.DEFAULT_NAME_SPACE, "Lcom/bytedance/android/livesdkapi/depend/model/live/AdminRecordAdminInfo;", "getAdmin", "()Lcom/bytedance/android/livesdkapi/depend/model/live/AdminRecordAdminInfo;", "setAdmin", "(Lcom/bytedance/android/livesdkapi/depend/model/live/AdminRecordAdminInfo;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AdminRecordMessage extends o0 implements vh7.h {

    @SerializedName(UserGroupScene.DEFAULT_NAME_SPACE)
    protected AdminRecordAdminInfo admin;

    @SerializedName("draft_id")
    protected long draft_id;

    @SerializedName("item_id")
    protected long item_id;

    @SerializedName("video_text_extra")
    protected List<PublishItemTextExtraInfo> textDescInfos;

    @SerializedName("video_text")
    protected String videoText;
    private String videoUrl;

    public AdminRecordMessage() {
        this.type = MessageType.ADMIN_RECORD_MESSAGE;
    }

    public final AdminRecordAdminInfo getAdmin() {
        return this.admin;
    }

    public final long getDraft_id() {
        return this.draft_id;
    }

    public final long getItem_id() {
        return this.item_id;
    }

    public final List<PublishItemTextExtraInfo> getTextDescInfos() {
        return this.textDescInfos;
    }

    public final String getVideoText() {
        return this.videoText;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public AdminRecordMessage(am3.g r100) {
        this.textDescInfos = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.textDescInfos.add(new PublishItemTextExtraInfo(r100));
        goto L3
    L8:
        this.videoText = am3.h.c(r100);
        goto L3
    L9:
        this.draft_id = r100.j();
        goto L3
    L10:
        this.item_id = r100.j();
        goto L3
    L11:
        this.admin = new AdminRecordAdminInfo(r100);
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        this.type = MessageType.ADMIN_RECORD_MESSAGE;
    }

    public final void setAdmin(AdminRecordAdminInfo r100) {
        this.admin = r100;
    }

    public final void setDraft_id(long r100) {
        this.draft_id = r100;
    }

    public final void setItem_id(long r100) {
        this.item_id = r100;
    }

    public final void setTextDescInfos(List<PublishItemTextExtraInfo> r100) {
        this.textDescInfos = r100;
    }

    public final void setVideoText(String r100) {
        this.videoText = r100;
    }

    public final void setVideoUrl(String r100) {
        this.videoUrl = r100;
    }
}
