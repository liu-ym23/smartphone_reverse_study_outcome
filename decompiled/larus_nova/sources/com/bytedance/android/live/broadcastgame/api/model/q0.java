package com.bytedance.android.live.broadcastgame.api.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/q0;", "", "", "gameId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "channel", "b", "", "gameDirection", "I", "getGameDirection", "()I", "height", "d", "width", "e", "h5Url", "getH5Url", "mobileH5Url", "getMobileH5Url", "", "isSupportMultiPlayer", "Z", "f", "()Z", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("channel")
    private final String channel;

    @SerializedName("game_direction")
    private final int gameDirection;

    @SerializedName("game_id")
    private final String gameId;

    @SerializedName("h5_url")
    private final String h5Url;

    @SerializedName("height")
    private final int height;

    @SerializedName("support_guide_enabled")
    private final boolean isSupportMultiPlayer;

    @SerializedName("mobile_h5_url")
    private final String mobileH5Url;

    @SerializedName("width")
    private final int width;

    public q0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q0) == false) goto L22;
        q0 r101 = (q0) r100;
        if (Intrinsics.areEqual(this.gameId, r101.gameId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L10;
        return false;
    L10:
        if (this.gameDirection == r101.gameDirection) goto L12;
        return false;
    L12:
        if (this.height == r101.height) goto L14;
        return false;
    L14:
        if (this.width == r101.width) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.h5Url, r101.h5Url) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mobileH5Url, r101.mobileH5Url) == true) goto L20;
        return false;
    L20:
        if (this.isSupportMultiPlayer == r101.isSupportMultiPlayer) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.gameId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.channel;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((((r103 + r105) * 31) + this.gameDirection) * 31) + this.height) * 31) + this.width) * 31;
        String r107 = this.h5Url;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.mobileH5Url;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.isSupportMultiPlayer;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "XplayInfo(gameId=" + this.gameId + ", channel=" + this.channel + ", gameDirection=" + this.gameDirection + ", height=" + this.height + ", width=" + this.width + ", h5Url=" + this.h5Url + ", mobileH5Url=" + this.mobileH5Url + ", isSupportMultiPlayer=" + this.isSupportMultiPlayer + ")";
    }

    public final String b() {
        return this.channel;
    }

    public final String c() {
        return this.gameId;
    }

    public final int d() {
        return this.height;
    }

    public final int e() {
        return this.width;
    }

    public final boolean f() {
        return this.isSupportMultiPlayer;
    }

    public /* synthetic */ q0(int r110) {
        this("", "", 0, 0, 0, "", "", false);
    }

    public static q0 a(q0 r100, String r110) {
        int r101 = r100.gameDirection;
        String r102 = r100.h5Url;
        String r103 = r100.mobileH5Url;
        boolean r104 = r100.isSupportMultiPlayer;
        Intrinsics.checkNotNullParameter(r110, "gameId");
        Intrinsics.checkNotNullParameter("", "channel");
        Intrinsics.checkNotNullParameter(r102, "h5Url");
        Intrinsics.checkNotNullParameter(r103, "mobileH5Url");
        return new q0(r110, "", r101, 4, 3, r102, r103, r104);
    }

    public q0(String r100, String r101, int r102, int r103, int r104, String r105, String r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "channel");
        Intrinsics.checkNotNullParameter(r105, "h5Url");
        Intrinsics.checkNotNullParameter(r106, "mobileH5Url");
        this.gameId = r100;
        this.channel = r101;
        this.gameDirection = r102;
        this.height = r103;
        this.width = r104;
        this.h5Url = r105;
        this.mobileH5Url = r106;
        this.isSupportMultiPlayer = r107;
    }
}
