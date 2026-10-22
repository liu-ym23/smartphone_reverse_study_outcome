package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.FollowGuideMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u000b¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/p4;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_duration", "J", FaceService.neutralLabel, "()J", "set_duration", "(J)V", "", "_content", "Ljava/lang/String;", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_avatarUrl", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_avatarUrl", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_avatarUrl", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_giftId", "get_giftId", "set_giftId", "_hourRankInfo", "P", "set_hourRankInfo", "_popupReason", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p4 extends o0 implements vh7.h {

    @SerializedName("avatarUrl")
    protected ImageModel _avatarUrl;

    @SerializedName("content")
    protected String _content;

    @SerializedName("duration")
    protected long _duration;

    @SerializedName("giftId")
    protected long _giftId;

    @SerializedName("hourRankInfo")
    protected String _hourRankInfo;

    @SerializedName("popupReason")
    protected String _popupReason;

    public final String G() {
        String r100 = this._popupReason;
        if (r100 != null) goto L6;
        return "no_reason_from_server";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean canText() {
        return !StringUtils.isEmpty(this._content);
    }

    public p4() {
        this._duration = 4000;
        this.type = MessageType.FOLLOW_GUIDE;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        CommonMessageData r100 = getBaseMessage();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.supportDisplayText() != true) goto L7;
        return true;
    }

    public final ImageModel E() {
        return this._avatarUrl;
    }

    public final long H() {
        return this._duration;
    }

    public final String P() {
        return this._hourRankInfo;
    }

    public final String getContent() {
        return this._content;
    }

    public p4(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this._popupReason = am3.h.c(r100);
        goto L3
    L8:
        this._duration = r100.j();
        r102 = r102 | true;
        goto L3
    L9:
        this._giftId = r100.j();
        goto L3
    L10:
        this._hourRankInfo = am3.h.c(r100);
        goto L3
    L11:
        this._content = am3.h.c(r100);
        goto L3
    L12:
        this._avatarUrl = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & true) == true) goto L17;
        this._duration = 4000;
    L17:
        this.type = MessageType.FOLLOW_GUIDE;
    }

    public final void setContent(String r100) {
        this._content = r100;
    }
}
