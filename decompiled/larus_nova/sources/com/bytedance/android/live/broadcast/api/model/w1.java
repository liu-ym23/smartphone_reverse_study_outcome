package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.user.LiveUserInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/w1;", "", "", "id", "J", "", "openId", "Ljava/lang/String;", "secUid", "nickName", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "followInfo", "Lcom/bytedance/android/live/base/model/user/FollowInfo;", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatarMedium", "avatarLarge", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w1 implements vh7.h {

    @SerializedName("avatar_large")
    public ImageModel avatarLarge;

    @SerializedName("avatar_medium")
    public ImageModel avatarMedium;

    @SerializedName("avatar_thumb")
    public ImageModel avatarThumb;

    @SerializedName("follow_info")
    public FollowInfo followInfo;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f59044id;

    @SerializedName(InstantPlayContext.NICKNAME)
    public String nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    public String openId;

    @IgnoreProtoFieldCheck
    @SerializedName("sec_id")
    public String secUid;

    public w1() {
        this.openId = "0";
        this.secUid = "";
        this.nickName = "";
    }

    public w1(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        if (r102 != 5000) goto L7;
        this.openId = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this.secUid = am3.h.c(r100);
        goto L3
    L10:
        this.followInfo = new FollowInfo(r100);
        goto L3
    L11:
        this.avatarLarge = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L12:
        this.avatarMedium = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L13:
        this.avatarThumb = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L14:
        this.nickName = am3.h.c(r100);
        goto L3
    L15:
        this.f59044id = r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.openId != null) goto L21;
        this.openId = "0";
    L21:
        if (this.secUid != null) goto L24;
        this.secUid = "";
    L24:
        if (this.nickName != null) goto L48;
        this.nickName = "";
        return;
    }
}
