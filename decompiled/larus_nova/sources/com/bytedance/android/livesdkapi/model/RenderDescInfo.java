package com.bytedance.android.livesdkapi.model;

import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/RenderDescInfo;", "", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "isGame", "", "()Z", "setGame", "(Z)V", "nickName", "getNickName", "setNickName", "roomId", "getRoomId", "setRoomId", "title", "getTitle", d.f25925o, "userId", "getUserId", "setUserId", "width", "", "getWidth", "()I", "setWidth", "(I)V", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RenderDescInfo {
    private String avatar;
    private boolean isGame;
    private String nickName;
    private String roomId;
    private String title;
    private String userId;
    private int width;

    public String toString() {
        return "RenderDescInfo(ownerId='" + this.userId + "', avatar='" + this.avatar + "', nickName='" + this.nickName + "', roomId='" + this.roomId + "', title='" + this.title + "', width=" + this.width + ", isGame=" + this.isGame + ')';
    }

    public RenderDescInfo() {
        this.userId = "";
        this.avatar = "";
        this.nickName = "";
        this.roomId = "";
        this.title = "";
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isGame() {
        return this.isGame;
    }

    public final void setAvatar(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatar = r100;
    }

    public final void setGame(boolean r100) {
        this.isGame = r100;
    }

    public final void setNickName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nickName = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userId = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
