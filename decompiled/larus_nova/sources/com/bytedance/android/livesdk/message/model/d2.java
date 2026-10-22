package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/d2;", "", "", "userId", "J", "", "openId", "Ljava/lang/String;", "nickName", com.bytedance.android.ec.core.event.a.KEY_SCORE, "Lpy/k;", "avatarThumb", "Lpy/k;", "avatarMedium", "avatarLarge", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d2 implements vh7.h {

    @SerializedName("avatar_large")
    public py.k avatarLarge;

    @SerializedName("avatar_medium")
    public py.k avatarMedium;

    @SerializedName("avatar_thumb")
    public py.k avatarThumb;

    @SerializedName(InstantPlayContext.NICKNAME)
    public String nickName;

    @IgnoreProtoFieldCheck
    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    public String openId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    public long score;

    @IgnoreProtoFieldCheck
    @SerializedName("user_id")
    public long userId;

    public final String toString() {
        return "{user_id=" + this.userId + ", nickname=" + this.nickName + ", score=" + this.score + ", avatar_thumb=" + this.avatarThumb + ", avatar_medium=" + this.avatarMedium + ", avatar_large=" + this.avatarLarge + '}';
    }

    public d2() {
        this.openId = "";
        this.nickName = "";
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public d2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        if (r102 != 5000) goto L7;
        this.openId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        this.avatarLarge = vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        this.avatarMedium = vh7.f.a(r100, py.k.class);
        goto L3
    L11:
        this.avatarThumb = vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        this.score = r100.j();
        goto L3
    L13:
        this.nickName = am3.h.c(r100);
        goto L3
    L14:
        this.userId = r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.openId != null) goto L20;
        this.openId = "";
    L20:
        if (this.nickName != null) goto L42;
        this.nickName = "";
        return;
    }
}
