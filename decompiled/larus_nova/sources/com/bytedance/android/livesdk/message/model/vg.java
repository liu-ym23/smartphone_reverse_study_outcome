package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.OChannelAnchorMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/vg;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/j3;", "", "_startTimeStamp", "J", ExifInterface.LONGITUDE_EAST, "()J", "set_startTimeStamp", "(J)V", "_endTimeStamp", "get_endTimeStamp", "set_endTimeStamp", "", "_content", "Ljava/lang/String;", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "_roomId", "get_roomId", "set_roomId", "Lcom/bytedance/android/live/base/model/user/User;", "_channelUser", "Lcom/bytedance/android/live/base/model/user/User;", "get_channelUser", "()Lcom/bytedance/android/live/base/model/user/User;", "set_channelUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class vg extends o0 implements com.bytedance.android.live.base.model.message.j3, vh7.h {

    @SerializedName("channel_user")
    protected User _channelUser;

    @SerializedName("content")
    protected String _content;

    @SerializedName("end_timestamp")
    protected long _endTimeStamp;

    @SerializedName("room_id")
    protected long _roomId;

    @SerializedName("start_timestamp")
    protected long _startTimeStamp;

    public vg() {
        this.type = MessageType.OFFICIAL_CHANNEL_FOR_ANCHOR_MESSAGE;
    }

    public final long E() {
        return this._startTimeStamp;
    }

    @Override // com.bytedance.android.live.base.model.message.j3
    public final IBaseUser getChannelUser() {
        return this._channelUser;
    }

    @Override // com.bytedance.android.live.base.model.message.j3
    public final long getEndTimeStamp() {
        return this._endTimeStamp;
    }

    public vg(am3.g r100) {
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
        this._channelUser = new User(r100);
        goto L3
    L8:
        this._roomId = r100.j();
        goto L3
    L9:
        this._content = am3.h.c(r100);
        goto L3
    L10:
        this._endTimeStamp = r100.j();
        goto L3
    L11:
        this._startTimeStamp = r100.j();
        goto L3
    L12:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        this.type = MessageType.OFFICIAL_CHANNEL_FOR_ANCHOR_MESSAGE;
    }
}
