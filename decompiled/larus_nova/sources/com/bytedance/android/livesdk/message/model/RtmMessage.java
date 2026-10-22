package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.RTMMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RtmMessage;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/h2;", "", "mPayload", "[B", "getMPayload", "()[B", "setMPayload", "([B)V", "Lcom/bytedance/android/livesdk/message/model/RtmMessage$Header;", "mHeader", "Lcom/bytedance/android/livesdk/message/model/RtmMessage$Header;", "getMHeader", "()Lcom/bytedance/android/livesdk/message/model/RtmMessage$Header;", "setMHeader", "(Lcom/bytedance/android/livesdk/message/model/RtmMessage$Header;)V", "getPayload", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/android/livesdk/link/model/bridge/h2$b;", "getHeader", "()Lcom/bytedance/android/livesdk/link/model/bridge/h2$b;", "header", "<init>", "()V", "Header", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RtmMessage extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.h2> implements com.bytedance.android.livesdk.link.model.bridge.h2, vh7.h {

    @SerializedName("header")
    protected Header mHeader;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    protected byte[] mPayload;

    @ProtoMessage("webcast.data.RTMMessage.Header")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u00060\u0003j\u0002`\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007R\u0018\u0010\u001b\u001a\u00060\u0003j\u0002`\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0018\u0010\u001d\u001a\u00060\u0003j\u0002`\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0007R\u0014\u0010\u001f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RtmMessage$Header;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/h2$b;", "", "mMsgId", "J", "getMMsgId", "()J", "setMMsgId", "(J)V", "mRoomId", "getMRoomId", "setMRoomId", "mCreateTime", "getMCreateTime", "setMCreateTime", "", "mMethod", "Ljava/lang/String;", "getMMethod", "()Ljava/lang/String;", "setMMethod", "(Ljava/lang/String;)V", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getMsgId", RemoteMessageConst.MSGID, "getRoomId", "roomId", "getCreateTime", "createTime", "getMethod", com.alipay.sdk.m.p.e.f25671s, "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Header extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.h2.b> implements com.bytedance.android.livesdk.link.model.bridge.h2.b, vh7.h {

        @SerializedName("create_time")
        protected long mCreateTime;

        @SerializedName(com.alipay.sdk.m.p.e.f25671s)
        protected String mMethod;

        @SerializedName("msg_id")
        protected long mMsgId;

        @SerializedName("room_id")
        protected long mRoomId;

        public Header() {
            super(com.bytedance.android.livesdk.link.model.bridge.h2.b.class);
        }

        @Override // com.bytedance.android.livesdk.link.model.bridge.h2.b
        public long getCreateTime() {
            return this.mCreateTime;
        }

        public final long getMCreateTime() {
            return this.mCreateTime;
        }

        public final String getMMethod() {
            return this.mMethod;
        }

        public final long getMMsgId() {
            return this.mMsgId;
        }

        public final long getMRoomId() {
            return this.mRoomId;
        }

        @Override // com.bytedance.android.livesdk.link.model.bridge.h2.b
        public String getMethod() {
            return this.mMethod;
        }

        @Override // com.bytedance.android.livesdk.link.model.bridge.h2.b
        public long getMsgId() {
            return this.mMsgId;
        }

        @Override // com.bytedance.android.livesdk.link.model.bridge.h2.b
        public long getRoomId() {
            return this.mRoomId;
        }

        public Header(am3.g r100) {
            super(com.bytedance.android.livesdk.link.model.bridge.h2.b.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            am3.g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.mMethod = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.mMsgId = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.mRoomId = r100.j();
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.mCreateTime = r100.j();
            goto L3
        L13:
            am3.h.d(r103, r100);
            goto L3
        L18:
            r100.d(r101);
            setThreadSafe(true);
        }

        public final void setMCreateTime(long r100) {
            this.mCreateTime = r100;
        }

        public final void setMMethod(String r100) {
            this.mMethod = r100;
        }

        public final void setMMsgId(long r100) {
            this.mMsgId = r100;
        }

        public final void setMRoomId(long r100) {
            this.mRoomId = r100;
        }
    }

    public RtmMessage() {
        super(com.bytedance.android.livesdk.link.model.bridge.h2.class);
    }

    public RtmMessage(am3.g r100) {
        super(com.bytedance.android.livesdk.link.model.bridge.h2.class);
        new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.mHeader = new Header(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.mPayload = am3.h.b(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h2
    public com.bytedance.android.livesdk.link.model.bridge.h2.b getHeader() {
        return this.mHeader;
    }

    public final Header getMHeader() {
        return this.mHeader;
    }

    public final byte[] getMPayload() {
        return this.mPayload;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.h2
    public byte[] getPayload() {
        return this.mPayload;
    }

    public final void setMHeader(Header r100) {
        this.mHeader = r100;
    }

    public final void setMPayload(byte[] r100) {
        this.mPayload = r100;
    }
}
