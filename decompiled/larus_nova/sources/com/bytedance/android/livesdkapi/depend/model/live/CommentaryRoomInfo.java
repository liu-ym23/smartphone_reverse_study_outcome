package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdkapi.depend.model.live.utils.UserUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/CommentaryRoomInfo;", "", "", "getUserIdStr", "", "userId", "Ljava/lang/Long;", "getUserId$annotations", "()V", "openID", "Ljava/lang/String;", "getOpenID$annotations", "Lpy/k;", "avatar", "Lpy/k;", "getAvatar", "()Lpy/k;", "setAvatar", "(Lpy/k;)V", "nickName", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "roomId", "J", "getRoomId", "()J", "setRoomId", "(J)V", "<init>", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommentaryRoomInfo implements h {

    @SerializedName("avatar")
    protected k avatar;

    @SerializedName(InstantPlayContext.NICKNAME)
    protected String nickName;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String openID;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("title")
    protected String title;

    @SerializedName("user_id")
    protected Long userId;

    public CommentaryRoomInfo() {
    }

    @Deprecated(message = "")
    private static /* synthetic */ void getOpenID$annotations() {
    }

    @Deprecated(message = "")
    private static /* synthetic */ void getUserId$annotations() {
    }

    public final String getUserIdStr() {
        return UserUtils.INSTANCE.getUserIdStr(String.valueOf(this.userId), this.openID);
    }

    public final k getAvatar() {
        return this.avatar;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    public CommentaryRoomInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.userId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.avatar = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.nickName = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.title = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.roomId = r100.j();
        goto L3
    L16:
        if (r102 != 5000) goto L17;
        this.openID = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
    }

    public final void setAvatar(k r100) {
        this.avatar = r100;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
