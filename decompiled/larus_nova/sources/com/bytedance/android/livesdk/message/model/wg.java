package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.OChannelUserMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/wg;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_startTimeStamp", "J", FaceService.neutralLabel, "()J", "set_startTimeStamp", "(J)V", "_endTimeStamp", ExifInterface.LONGITUDE_EAST, "set_endTimeStamp", "_maxEnterTime", "G", "set_maxEnterTime", "_roomId", "get_roomId", "set_roomId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wg extends o0 implements vh7.h {

    @SerializedName("end_timestamp")
    protected long _endTimeStamp;

    @SerializedName("max_enter_time")
    protected long _maxEnterTime;

    @SerializedName("room_id")
    protected long _roomId;

    @SerializedName("start_timestamp")
    protected long _startTimeStamp;

    public wg() {
        this.type = MessageType.OFFICIAL_CHANNEL_FOR_USER_MESSAGE;
    }

    public final long E() {
        return this._endTimeStamp;
    }

    public final long G() {
        return this._maxEnterTime;
    }

    public final long H() {
        return this._startTimeStamp;
    }

    public wg(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._startTimeStamp = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._endTimeStamp = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._maxEnterTime = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._roomId = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        this.type = MessageType.OFFICIAL_CHANNEL_FOR_USER_MESSAGE;
    }
}
