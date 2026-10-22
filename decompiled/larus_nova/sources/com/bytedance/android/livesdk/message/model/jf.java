package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.ChatMatchGroupInfo;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicChatMatchMessage")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0005\"#$%&B\u0007¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jf;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "msgType", "Ljava/lang/Integer;", "getMsgType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/message/model/jf$d;", "userJoinContent", "Lcom/bytedance/android/livesdk/message/model/jf$d;", "getUserJoinContent", "()Lcom/bytedance/android/livesdk/message/model/jf$d;", "Lcom/bytedance/android/livesdk/message/model/jf$e;", "userLeaveContent", "Lcom/bytedance/android/livesdk/message/model/jf$e;", "getUserLeaveContent", "()Lcom/bytedance/android/livesdk/message/model/jf$e;", "Lcom/bytedance/android/livesdk/message/model/jf$a;", "finishGroupContent", "Lcom/bytedance/android/livesdk/message/model/jf$a;", "getFinishGroupContent", "()Lcom/bytedance/android/livesdk/message/model/jf$a;", "Lcom/bytedance/android/livesdk/message/model/jf$b;", "matchResultContent", "Lcom/bytedance/android/livesdk/message/model/jf$b;", "getMatchResultContent", "()Lcom/bytedance/android/livesdk/message/model/jf$b;", "Lcom/bytedance/android/livesdk/message/model/jf$c;", "startCountDownContent", "Lcom/bytedance/android/livesdk/message/model/jf$c;", "getStartCountDownContent", "()Lcom/bytedance/android/livesdk/message/model/jf$c;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class jf extends o0 implements vh7.h {

    @SerializedName("chat_match_finish_group_content")
    protected a finishGroupContent;

    @SerializedName("chat_match_result_content")
    protected b matchResultContent;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    protected Integer msgType;

    @SerializedName("chat_match_start_count_down_content")
    protected c startCountDownContent;

    @SerializedName("chat_match_user_join_content")
    protected d userJoinContent;

    @SerializedName("chat_match_user_leave_content")
    protected e userLeaveContent;

    @ProtoMessage("webcast.im.LinkmicChatMatchFinishGroupContent")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jf$a;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("join_room_id")
        protected String roomId;

        public a() {
        }

        public a(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.roomId = am3.h.c(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.LinkmicChatMatchResultContent")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jf$b;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "groupInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "getGroupInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements vh7.h {

        @SerializedName("group_info")
        protected ChatMatchGroupInfo groupInfo;

        public b() {
        }

        public b(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.groupInfo = new ChatMatchGroupInfo(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.LinkmicChatMatchStartCountDownContent")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jf$c;", "", "", "disbandTime", "Ljava/lang/Long;", "getDisbandTime", "()Ljava/lang/Long;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("disband_time")
        protected Long disbandTime;

        public c() {
            this.disbandTime = 0L;
        }

        public c(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.disbandTime = Long.valueOf(r100.j());
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
            if (this.disbandTime != null) goto L19;
            this.disbandTime = 0L;
            return;
        }
    }

    @ProtoMessage("webcast.im.LinkmicChatMatchUserJoinContent")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jf$d;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "groupInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "getGroupInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d implements vh7.h {

        @SerializedName("group_info")
        protected ChatMatchGroupInfo groupInfo;

        public d() {
        }

        public d(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L9;
            if (r102 != 1) goto L7;
            this.groupInfo = new ChatMatchGroupInfo(r100);
            goto L3
        L7:
            am3.h.e(r100);
            goto L3
        L9:
            r100.d(r101);
        }
    }

    @ProtoMessage("webcast.im.LinkmicChatMatchUserLeaveContent")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/jf$e;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "groupInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "getGroupInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ChatMatchGroupInfo;", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "deviceId", "getDeviceId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e implements vh7.h {

        @SerializedName("device_id")
        protected String deviceId;

        @SerializedName("group_info")
        protected ChatMatchGroupInfo groupInfo;

        @SerializedName("user_id")
        protected String userId;

        public e() {
        }

        public e(am3.g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.groupInfo = new ChatMatchGroupInfo(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.userId = am3.h.c(r100);
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.deviceId = am3.h.c(r100);
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    public jf() {
        this.msgType = 0;
        this.type = MessageType.CHAT_MATCH_MESSAGE;
    }

    public jf(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.msgType = Integer.valueOf(r100.i());
        goto L3
    L9:
        switch(r102) {
            case 21: goto L15;
            case 22: goto L14;
            case 23: goto L13;
            case 24: goto L12;
            case 25: goto L11;
            default: goto L10;
        };
    L11:
        this.startCountDownContent = new c(r100);
        goto L3
    L12:
        this.matchResultContent = new b(r100);
        goto L3
    L13:
        this.finishGroupContent = new a(r100);
        goto L3
    L14:
        this.userLeaveContent = new e(r100);
        goto L3
    L15:
        this.userJoinContent = new d(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.msgType != null) goto L21;
        this.msgType = 0;
    L21:
        this.type = MessageType.CHAT_MATCH_MESSAGE;
    }
}
