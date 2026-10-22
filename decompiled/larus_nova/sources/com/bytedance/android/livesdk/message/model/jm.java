package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ContentOpenTrackReportMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jm;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_eventType", "I", "get_eventType", "()I", "set_eventType", "(I)V", "", "_eventTime", "J", "get_eventTime", "()J", "set_eventTime", "(J)V", "", "_uniqueId", "Ljava/lang/String;", "get_uniqueId", "()Ljava/lang/String;", "set_uniqueId", "(Ljava/lang/String;)V", "_openRoomId", "get_openRoomId", "set_openRoomId", "_bizExtra", "get_bizExtra", "set_bizExtra", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class jm extends o0 implements vh7.h {

    @SerializedName("biz_extra")
    protected String _bizExtra;

    @SerializedName("event_time")
    protected long _eventTime;

    @SerializedName("event_type")
    protected int _eventType;

    @SerializedName("open_room_id")
    protected String _openRoomId;

    @SerializedName(BdpAppEventConstant.PARAMS_UNIQUEID)
    protected String _uniqueId;

    public static final class a {
    }

    static {
    }

    public jm() {
        this.type = MessageType.TRACK_REPORT_MESSAGE;
    }

    public jm(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._eventType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._eventTime = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._uniqueId = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._openRoomId = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 255) goto L17;
        this._bizExtra = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        this.type = MessageType.TRACK_REPORT_MESSAGE;
    }
}
