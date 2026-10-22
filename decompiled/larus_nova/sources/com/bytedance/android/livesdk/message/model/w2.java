package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0013\u0010\u0004\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/w2;", "", "", "idStr", "Ljava/lang/String;", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "getIdStr$annotations", "()V", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "getUid$annotations", "openId", "getOpenId", "setOpenId", "getOpenId$annotations", "nickName", "getNickName", "setNickName", "Lpy/k;", "avatar", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "c", "(Lpy/k;)V", "Lcom/bytedance/android/livesdk/message/model/q4;", "followInfo", "Lcom/bytedance/android/livesdk/message/model/q4;", "getFollowInfo", "()Lcom/bytedance/android/livesdk/message/model/q4;", "setFollowInfo", "(Lcom/bytedance/android/livesdk/message/model/q4;)V", "Lcom/bytedance/android/livesdk/message/model/wh;", "ownRoom", "Lcom/bytedance/android/livesdk/message/model/wh;", "getOwnRoom", "()Lcom/bytedance/android/livesdk/message/model/wh;", "setOwnRoom", "(Lcom/bytedance/android/livesdk/message/model/wh;)V", "", "secret", "I", "getSecret", "()I", "setSecret", "(I)V", "<init>", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class w2 implements vh7.h {

    @SerializedName("avatar_thumb")
    protected py.k avatar;

    @SerializedName("follow_info")
    protected q4 followInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("id_str")
    protected String idStr;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String nickName;

    @IgnoreProtoFieldCheck
    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("own_room")
    protected wh ownRoom;

    @SerializedName("secret")
    protected int secret;

    @IgnoreProtoFieldCheck
    @SerializedName("id")
    protected long uid;

    public final String b() {
        String r100 = com.bytedance.android.livesdk.d9.a(this.idStr);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return com.bytedance.android.livesdk.d9.c(Long.valueOf(this.uid), this.openId);
    }

    public w2() {
        this.idStr = "";
        this.openId = "";
    }

    public final py.k a() {
        return this.avatar;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public w2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        if (r102 != 8) goto L8;
        this.idStr = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 5000) goto L9;
        this.openId = am3.h.c(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            default: goto L10;
        };
    L11:
        this.secret = r100.i();
        goto L3
    L12:
        this.ownRoom = new wh(r100);
        goto L3
    L13:
        this.followInfo = new q4(r100);
        goto L3
    L14:
        this.avatar = vh7.f.a(r100, py.k.class);
        goto L3
    L15:
        this.nickName = am3.h.c(r100);
        goto L3
    L16:
        this.uid = r100.j();
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
        if (this.idStr != null) goto L23;
        this.idStr = "";
    L23:
        if (this.openId != null) goto L48;
        this.openId = "";
        return;
    }

    public final void c(py.k r100) {
        this.avatar = r100;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        MutablePropertyReference0Impl r101 = new ChorusRankUser$uidString$1(this);
        MutablePropertyReference0Impl r102 = new ChorusRankUser$uidString$2(this);
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "uidStringMain");
        Intrinsics.checkNotNullParameter(r102, "uidStringSaas");
        r101.set(r100);
        r102.set(r100);
        com.bytedance.android.livesdk.d9.b(r100, new ChorusRankUser$uidString$3(this), new ChorusRankUser$uidString$4(this));
    }
}
