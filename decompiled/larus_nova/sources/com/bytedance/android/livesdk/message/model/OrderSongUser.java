package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.OrderSongUser")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/OrderSongUser;", "", "()V", "avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatarThumb", "()Lcom/bytedance/android/live/base/model/ImageModel;", "id", "", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", InstantPlayContext.NICKNAME, "", "getNickname", "()Ljava/lang/String;", "openId", "getOpenId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OrderSongUser implements vh7.h {

    @SerializedName("avatar_thumb")
    protected ImageModel avatarThumb;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected Long f153608id;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String nickname;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openId;

    public OrderSongUser() {
    }

    public final ImageModel getAvatarThumb() {
        return this.avatarThumb;
    }

    public final Long getId() {
        return this.f153608id;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public OrderSongUser(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.f153608id = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.nickname = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.avatarThumb = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this.openId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
