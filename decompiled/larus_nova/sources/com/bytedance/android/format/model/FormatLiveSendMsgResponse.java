package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveSendMsgResponse;", "Ljava/io/Serializable;", "()V", RemoteMessageConst.MSGID, "", "getMsgId", "()J", "userPunishInfo", "Lcom/bytedance/android/format/model/UserPunishInfo;", "getUserPunishInfo", "()Lcom/bytedance/android/format/model/UserPunishInfo;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatLiveSendMsgResponse implements Serializable {

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final long msgId;

    @SerializedName("user_punish_info")
    private final UserPunishInfo userPunishInfo;

    public FormatLiveSendMsgResponse() {
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final UserPunishInfo getUserPunishInfo() {
        return this.userPunishInfo;
    }
}
