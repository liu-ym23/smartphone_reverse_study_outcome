package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomDigitalHumanMessage")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/wj;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "Lcom/bytedance/android/livesdk/message/model/wj$b;", "digitalHumanInfoList", "Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/List;", "setDigitalHumanInfoList", "(Ljava/util/List;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class wj extends o0 implements vh7.h {

    @SerializedName("info_list")
    protected List<b> digitalHumanInfoList;

    public static final class a {
    }

    @ProtoMessage("webcast.im.RoomDigitalHumanMessage.DigitalHumanUsageInfo")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/wj$b;", "", "", "status", "J", "b", "()J", "setStatus", "(J)V", "", "avatarID", "Ljava/lang/String;", "getAvatarID", "()Ljava/lang/String;", "setAvatarID", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/message/model/wj$c;", "rtcInfo", "Lcom/bytedance/android/livesdk/message/model/wj$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/message/model/wj$c;", "setRtcInfo", "(Lcom/bytedance/android/livesdk/message/model/wj$c;)V", "userId", "c", "setUserId", "scene", "getScene", "setScene", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("avatar_id")
        protected String avatarID;

        @SerializedName("public_output_stream")
        protected c rtcInfo;

        @SerializedName("scene")
        protected String scene;

        @SerializedName("status")
        protected long status;

        @SerializedName("user_id")
        protected String userId;

        public b() {
            this.status = -1;
            this.avatarID = "";
            this.userId = "";
            this.scene = "";
        }

        public final c a() {
            return this.rtcInfo;
        }

        public final long b() {
            return this.status;
        }

        public final String c() {
            return this.userId;
        }

        public b(am3.g r100) {
            long r101 = r100.c();
            boolean r102 = false;
        L3:
            int r103 = r100.f();
            if (r103 == (-1)) goto L20;
            if (r103 != 1) goto L7;
            this.status = r100.i();
            r102 = r102 | true;
            goto L3
        L7:
            if (r103 != 2) goto L9;
            this.avatarID = am3.h.c(r100);
            goto L3
        L9:
            if (r103 != 3) goto L11;
            this.rtcInfo = new c(r100);
            goto L3
        L11:
            if (r103 != 4) goto L13;
            this.userId = am3.h.c(r100);
            goto L3
        L13:
            if (r103 != 5) goto L14;
            this.scene = am3.h.c(r100);
            goto L3
        L14:
            am3.h.e(r100);
            goto L3
        L20:
            r100.d(r101);
            if ((r102 & true) == true) goto L24;
            this.status = -1;
        L24:
            if (this.avatarID != null) goto L27;
            this.avatarID = "";
        L27:
            if (this.userId != null) goto L30;
            this.userId = "";
        L30:
            if (this.scene != null) goto L51;
            this.scene = "";
            return;
        }
    }

    @ProtoMessage("webcast.im.RoomDigitalHumanMessage.DigitalHumanUsageInfo.RtcInfo")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/wj$c;", "", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "streamID", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setStreamID", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("channel_id")
        protected String channelId;

        @SerializedName("stream_id")
        protected String streamID;

        public c() {
            this.channelId = "";
            this.streamID = "";
        }

        public final String a() {
            return this.streamID;
        }

        public c(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.channelId = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.streamID = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
            if (this.channelId != null) goto L16;
            this.channelId = "";
        L16:
            if (this.streamID != null) goto L28;
            this.streamID = "";
            return;
        }
    }

    static {
    }

    public wj() {
        this.type = MessageType.LIVE_ROOM_DIGITAL_HUMAN_MESSAGE;
    }

    public final List<b> E() {
        return this.digitalHumanInfoList;
    }

    public wj(am3.g r100) {
        this.digitalHumanInfoList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.digitalHumanInfoList.add(new b(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.LIVE_ROOM_DIGITAL_HUMAN_MESSAGE;
    }
}
