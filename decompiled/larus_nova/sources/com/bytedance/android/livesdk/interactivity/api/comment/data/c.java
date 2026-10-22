package com.bytedance.android.livesdk.interactivity.api.comment.data;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/data/c;", "", "", "leftDiamond", "I", "b", "()I", "setLeftDiamond", "(I)V", "", RemoteMessageConst.MSGID, "J", "getMsgId", "()J", "setMsgId", "(J)V", "", "orderId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "content", "getContent", "", "isSendTcs", "Z", "f", "()Z", "showIdentity", "e", "setShowIdentity", "Lpy/k;", "identityLabel", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "setIdentityLabel", "(Lpy/k;)V", "screenChatMsg", "d", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("content")
    private final String content;

    @SerializedName("identity_label")
    private k identityLabel;

    @SerializedName("is_send_tcs")
    private final boolean isSendTcs;

    @SerializedName("left_diamond")
    private int leftDiamond;

    @SerializedName("msg_id")
    private long msgId;

    @SerializedName("order_id")
    private final String orderId;

    @SerializedName("msg")
    private final String screenChatMsg;

    @SerializedName("show_identity")
    private int showIdentity;

    public c() {
    }

    public final k a() {
        return this.identityLabel;
    }

    public final int b() {
        return this.leftDiamond;
    }

    public final String c() {
        return this.orderId;
    }

    public final String d() {
        return this.screenChatMsg;
    }

    public final int e() {
        return this.showIdentity;
    }

    public final boolean f() {
        return this.isSendTcs;
    }
}
