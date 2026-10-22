package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.GameCPUserDownloadMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/v4;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/z0;", "", "_userNickName", "Ljava/lang/String;", "get_userNickName", "()Ljava/lang/String;", "set_userNickName", "(Ljava/lang/String;)V", "", "_downloadCount", "J", "get_downloadCount", "()J", "set_downloadCount", "(J)V", "_downloadContent", "get_downloadContent", "set_downloadContent", "_gameName", "get_gameName", "set_gameName", "", "_fromType", "I", "get_fromType", "()I", "set_fromType", "(I)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v4 extends o0 implements com.bytedance.android.live.base.model.message.z0, vh7.h {

    @SerializedName("user_download_content")
    protected String _downloadContent;

    @SerializedName("user_download_count")
    protected long _downloadCount;

    @SerializedName("type")
    protected int _fromType;

    @SerializedName("download_game_name")
    protected String _gameName;

    @SerializedName("user_nick_name")
    protected String _userNickName;

    public v4() {
        this.type = MessageType.GAME_CP_USER_DOWNLOAD_MESSAGE;
    }

    @Override // com.bytedance.android.live.base.model.message.z0
    public final String X0() {
        return this._downloadContent;
    }

    @Override // com.bytedance.android.live.base.model.message.z0
    public final int c() {
        return this._fromType;
    }

    @Override // com.bytedance.android.live.base.model.message.z0
    public final long getDownloadCount() {
        return this._downloadCount;
    }

    @Override // com.bytedance.android.live.base.model.message.z0
    public final String getGameName() {
        return this._gameName;
    }

    @Override // com.bytedance.android.live.base.model.message.z0
    public final String h() {
        return this._userNickName;
    }

    public v4(am3.g r100) {
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
        this._fromType = r100.i();
        goto L3
    L8:
        this._gameName = am3.h.c(r100);
        goto L3
    L9:
        this._downloadContent = am3.h.c(r100);
        goto L3
    L10:
        this._downloadCount = r100.j();
        goto L3
    L11:
        this._userNickName = am3.h.c(r100);
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        this.type = MessageType.GAME_CP_USER_DOWNLOAD_MESSAGE;
    }
}
