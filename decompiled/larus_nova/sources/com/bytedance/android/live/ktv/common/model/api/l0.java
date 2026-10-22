package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\"\u0010$\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 ¨\u0006("}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/l0;", "", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "getUserId$annotations", "()V", "", "openId", "Ljava/lang/String;", "getOpenId", "()Ljava/lang/String;", "setOpenId", "(Ljava/lang/String;)V", "getOpenId$annotations", "Lpy/k;", "avatar", "Lpy/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "", "secret", "I", "getSecret", "()I", "setSecret", "(I)V", "secUid", "getSecUid", "setSecUid", "mysteryMan", "getMysteryMan", "setMysteryMan", "<init>", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l0 implements vh7.h {

    @SerializedName("avatar_thumb")
    protected py.k avatar;

    @SerializedName("mystery_man")
    protected int mysteryMan;

    @IgnoreProtoFieldCheck
    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    @SerializedName("sec_uid")
    protected String secUid;

    @SerializedName("secret")
    protected int secret;

    @IgnoreProtoFieldCheck
    @SerializedName("id")
    protected long userId;

    public l0() {
        this.openId = "";
        this.secUid = "";
    }

    public final py.k a() {
        return this.avatar;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public l0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.userId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.avatar = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.secret = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.secUid = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.mysteryMan = r100.i();
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this.openId = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.openId != null) goto L28;
        this.openId = "";
    L28:
        if (this.secUid != null) goto L52;
        this.secUid = "";
        return;
    }
}
