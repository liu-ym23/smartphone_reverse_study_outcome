package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010*\u001a\u00020\nH\u0016J\u0006\u0010+\u001a\u00020(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSLinkedRoomNode;", "", "()V", "episodeExtra", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "getEpisodeExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "setEpisodeExtra", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;)V", "liveRoomMode", "", "getLiveRoomMode", "()I", "setLiveRoomMode", "(I)V", "owner", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOwner", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setOwner", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "roomIdStr", "", "getRoomIdStr", "()Ljava/lang/String;", "setRoomIdStr", "(Ljava/lang/String;)V", "source", "getSource", "setSource", "title", "getTitle", d.f25925o, "equals", "", "other", "hashCode", "isVS", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLinkedRoomNode implements h {
    private Episode episodeExtra;

    @SerializedName("live_room_mode")
    protected int liveRoomMode;

    @SerializedName("owner")
    protected IBaseUser owner;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("room_id_str")
    protected String roomIdStr;

    @SerializedName("source")
    protected int source;

    @SerializedName("title")
    protected String title;

    public VSLinkedRoomNode() {
    }

    public int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.roomIdStr;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.title;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (((r105 + r107) * 31) + this.liveRoomMode) * 31;
        IBaseUser r109 = this.owner;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        return ((r108 + r103) * 31) + this.source;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final boolean isVS() {
        if (this.episodeExtra == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Episode getEpisodeExtra() {
        return this.episodeExtra;
    }

    public final int getLiveRoomMode() {
        return this.liveRoomMode;
    }

    public final IBaseUser getOwner() {
        return this.owner;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getRoomIdStr() {
        return this.roomIdStr;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public VSLinkedRoomNode(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.source = r100.i();
        goto L3
    L8:
        this.owner = f.a(r100, IBaseUser.class);
        goto L3
    L9:
        this.liveRoomMode = (int) r100.j();
        goto L3
    L10:
        this.title = am3.h.c(r100);
        goto L3
    L11:
        this.roomIdStr = am3.h.c(r100);
        goto L3
    L12:
        this.roomId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        k r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(VSLinkedRoomNode.class, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L52;
        VSLinkedRoomNode r103 = (VSLinkedRoomNode) r100;
        if (this.roomId == r103.roomId) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.roomIdStr, r103.roomIdStr)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.title, r103.title)) == false) goto L23;
        return false;
    L23:
        if (this.liveRoomMode == r103.liveRoomMode) goto L25;
        return false;
    L25:
        IBaseUser r104 = this.owner;
        if (r104 == null) goto L28;
        String r105 = r104.getIdString();
    L29:
        IBaseUser r106 = r103.owner;
        if (r106 == null) goto L32;
        String r107 = r106.getIdString();
    L34:
        if ((!Intrinsics.areEqual(r105, r107)) == false) goto L36;
        return false;
    L36:
        IBaseUser r108 = this.owner;
        if (r108 == null) goto L50;
        k r109 = r108.getAvatarMedium();
        if (r109 == null) goto L50;
        IBaseUser r110 = r103.owner;
        if (r110 == null) goto L44;
        r101 = r110.getAvatarMedium();
    L44:
        if (r109.equalsOnlyUri(r101) != true) goto L50;
        if (this.source == r103.source) goto L49;
        return false;
    L49:
        return true;
    L50:
        return false;
    L32:
        r107 = null;
        goto L34
    L28:
        r105 = null;
        goto L29
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode");
    L8:
        r102 = null;
        goto L10
    }

    public final void setEpisodeExtra(Episode r100) {
        this.episodeExtra = r100;
    }

    public final void setLiveRoomMode(int r100) {
        this.liveRoomMode = r100;
    }

    public final void setOwner(IBaseUser r100) {
        this.owner = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setRoomIdStr(String r100) {
        this.roomIdStr = r100;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
