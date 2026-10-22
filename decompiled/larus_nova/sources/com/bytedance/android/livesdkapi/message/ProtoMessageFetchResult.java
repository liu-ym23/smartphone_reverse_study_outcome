package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.Response")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR&\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\f\"\u0004\b*\u0010\u000eR \u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR,\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/ProtoMessageFetchResult;", "", "()V", EffectConfiguration.KEY_CURSOR, "", "getCursor", "()Ljava/lang/String;", "setCursor", "(Ljava/lang/String;)V", "fetchInterval", "", "getFetchInterval", "()J", "setFetchInterval", "(J)V", "fetchType", "", "getFetchType", "()I", "setFetchType", "(I)V", "heartbeatDuration", "getHeartbeatDuration", "setHeartbeatDuration", "internalExt", "getInternalExt", "setInternalExt", "messages", "", "Lcom/bytedance/android/livesdkapi/message/ProtoMessageFetchResult$BaseProtoMessage;", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", "needAck", "", "getNeedAck", "()Z", "setNeedAck", "(Z)V", TriggerTiming.NOW, "getNow", "setNow", "pushServer", "getPushServer", "setPushServer", "routeParams", "", "getRouteParams", "()Ljava/util/Map;", "setRouteParams", "(Ljava/util/Map;)V", "BaseProtoMessage", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProtoMessageFetchResult implements h {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    protected String cursor;

    @SerializedName("fetch_interval")
    protected long fetchInterval;

    @SerializedName("fetch_type")
    protected int fetchType;

    @SerializedName("heartbeat_duration")
    protected long heartbeatDuration;

    @SerializedName("internal_ext")
    protected String internalExt;

    @SerializedName("messages")
    protected List<BaseProtoMessage> messages;

    @SerializedName(WsConstants.KEY_NEED_ACK)
    protected boolean needAck;

    @SerializedName(TriggerTiming.NOW)
    protected long now;

    @SerializedName("push_server")
    protected String pushServer;

    @SerializedName("route_params")
    protected Map<String, String> routeParams;

    @ProtoMessage("webcast.im.Message")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/ProtoMessageFetchResult$BaseProtoMessage;", "", "()V", e.f25671s, "", "getMethod", "()Ljava/lang/String;", "setMethod", "(Ljava/lang/String;)V", RemoteMessageConst.MSGID, "", "getMsgId", "()J", "setMsgId", "(J)V", "msgType", "", "getMsgType", "()I", "setMsgType", "(I)V", "offset", "getOffset", "setOffset", WsConstants.KEY_PAYLOAD, "", "getPayload", "()[B", "setPayload", "([B)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BaseProtoMessage implements h {

        @SerializedName(e.f25671s)
        protected String method;

        @SerializedName("msg_id")
        protected long msgId;

        @SerializedName(SeiMessageConst.MSG_TYPE)
        protected int msgType;

        @SerializedName("offset")
        protected long offset;

        @SerializedName(WsConstants.KEY_PAYLOAD)
        protected byte[] payload;

        public BaseProtoMessage() {
        }

        public final String getMethod() {
            return this.method;
        }

        public final long getMsgId() {
            return this.msgId;
        }

        public final int getMsgType() {
            return this.msgType;
        }

        public final long getOffset() {
            return this.offset;
        }

        public final byte[] getPayload() {
            return this.payload;
        }

        public BaseProtoMessage(g r100) {
            new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L21;
            if (r102 != 1) goto L8;
            this.method = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.payload = am3.h.b(r100);
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.msgId = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L14;
            this.msgType = r100.i();
            goto L3
        L14:
            if (r102 != 5) goto L15;
            this.offset = r100.j();
            goto L3
        L15:
            am3.h.e(r100);
            goto L3
        L21:
            r100.d(r101);
        }

        public final void setMethod(String r100) {
            this.method = r100;
        }

        public final void setMsgId(long r100) {
            this.msgId = r100;
        }

        public final void setMsgType(int r100) {
            this.msgType = r100;
        }

        public final void setOffset(long r100) {
            this.offset = r100;
        }

        public final void setPayload(byte[] r100) {
            this.payload = r100;
        }
    }

    public ProtoMessageFetchResult() {
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final long getFetchInterval() {
        return this.fetchInterval;
    }

    public final int getFetchType() {
        return this.fetchType;
    }

    public final long getHeartbeatDuration() {
        return this.heartbeatDuration;
    }

    public final String getInternalExt() {
        return this.internalExt;
    }

    public final List<BaseProtoMessage> getMessages() {
        return this.messages;
    }

    public final boolean getNeedAck() {
        return this.needAck;
    }

    public final long getNow() {
        return this.now;
    }

    public final String getPushServer() {
        return this.pushServer;
    }

    public final Map<String, String> getRouteParams() {
        return this.routeParams;
    }

    public ProtoMessageFetchResult(g r110) {
        this.messages = new ArrayList();
        this.routeParams = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L34;
        switch(r101) {
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.pushServer = am3.h.c(r110);
        goto L3
    L8:
        this.needAck = am3.h.a(r110);
        goto L3
    L9:
        this.heartbeatDuration = r110.j();
        goto L3
    L10:
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L20;
        if (r105 != 1) goto L16;
        r103 = am3.h.c(r110);
        goto L11
    L16:
        if (r105 != 2) goto L17;
        r104 = am3.h.c(r110);
        goto L11
    L17:
        am3.h.e(r110);
        goto L11
    L20:
        r110.d(r102);
        Map<String, String> r106 = this.routeParams;
        if (r103 == null) goto L27;
        if (r104 == null) goto L25;
        r106.put(r103, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L28:
        this.fetchType = r110.i();
        goto L3
    L29:
        this.internalExt = am3.h.c(r110);
        goto L3
    L30:
        this.now = r110.j();
        goto L3
    L31:
        this.fetchInterval = r110.j();
        goto L3
    L32:
        this.cursor = am3.h.c(r110);
        goto L3
    L33:
        this.messages.add(new BaseProtoMessage(r110));
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L34:
        r110.d(r100);
    }

    public final void setCursor(String r100) {
        this.cursor = r100;
    }

    public final void setFetchInterval(long r100) {
        this.fetchInterval = r100;
    }

    public final void setFetchType(int r100) {
        this.fetchType = r100;
    }

    public final void setHeartbeatDuration(long r100) {
        this.heartbeatDuration = r100;
    }

    public final void setInternalExt(String r100) {
        this.internalExt = r100;
    }

    public final void setMessages(List<BaseProtoMessage> r100) {
        this.messages = r100;
    }

    public final void setNeedAck(boolean r100) {
        this.needAck = r100;
    }

    public final void setNow(long r100) {
        this.now = r100;
    }

    public final void setPushServer(String r100) {
        this.pushServer = r100;
    }

    public final void setRouteParams(Map<String, String> r100) {
        this.routeParams = r100;
    }
}
