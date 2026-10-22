package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.im.Message")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R0\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/n;", "", "", "_method", "Ljava/lang/String;", "", WsConstants.KEY_PAYLOAD, "[B", "e", "()[B", "setPayload", "([B)V", "", RemoteMessageConst.MSGID, "J", "c", "()J", "setMsgId", "(J)V", "", "msgType", "I", "d", "()I", "setMsgType", "(I)V", "offset", "getOffset", "setOffset", "", "extra", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n implements vh7.h {

    @SerializedName(com.alipay.sdk.m.p.e.f25671s)
    protected String _method;

    @SerializedName(AppConstants.KEY_MESSAGE_EXTRA)
    protected Map<String, String> extra;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName(SeiMessageConst.MSG_TYPE)
    protected int msgType;

    @SerializedName("offset")
    protected long offset;

    @SerializedName(WsConstants.KEY_PAYLOAD)
    protected byte[] payload;

    public n() {
    }

    public final String b() {
        String r100 = this._method;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final Map<String, String> a() {
        return this.extra;
    }

    public final long c() {
        return this.msgId;
    }

    public final int d() {
        return this.msgType;
    }

    public final byte[] e() {
        return this.payload;
    }

    public n(am3.g r110) {
        new ArrayList();
        this.extra = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L39;
        if (r101 != 1) goto L8;
        this._method = am3.h.c(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.payload = am3.h.b(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.msgId = r110.j();
        goto L3
    L12:
        if (r101 != 4) goto L14;
        this.msgType = r110.i();
        goto L3
    L14:
        if (r101 != 5) goto L16;
        this.offset = r110.j();
        goto L3
    L16:
        if (r101 != 9) goto L17;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L19:
        int r105 = r110.f();
        if (r105 == (-1)) goto L26;
        if (r105 != 1) goto L22;
        r103 = am3.h.c(r110);
        goto L19
    L22:
        if (r105 != 2) goto L23;
        r104 = am3.h.c(r110);
        goto L19
    L23:
        am3.h.e(r110);
        goto L19
    L26:
        r110.d(r102);
        Map<String, String> r106 = this.extra;
        if (r103 == null) goto L33;
        if (r104 == null) goto L31;
        r106.put(r103, r104);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L17:
        am3.h.e(r110);
        goto L3
    L39:
        r110.d(r100);
    }
}
