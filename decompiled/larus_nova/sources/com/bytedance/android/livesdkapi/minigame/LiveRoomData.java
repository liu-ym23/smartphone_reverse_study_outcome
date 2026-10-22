package com.bytedance.android.livesdkapi.minigame;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/LiveRoomData;", "Ljava/io/Serializable;", "shouldShow", "", "liveTips", "", "watchCount", "", "newFansCount", "commentCount", "giftCount", "(ZLjava/lang/String;JJJJ)V", "getCommentCount", "()J", "setCommentCount", "(J)V", "getGiftCount", "setGiftCount", "getLiveTips", "()Ljava/lang/String;", "setLiveTips", "(Ljava/lang/String;)V", "getNewFansCount", "setNewFansCount", "getShouldShow", "()Z", "setShouldShow", "(Z)V", "getWatchCount", "setWatchCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomData implements Serializable {

    @SerializedName("comment_count")
    private long commentCount;

    @SerializedName("gift_count")
    private long giftCount;

    @SerializedName("live_tips")
    private String liveTips;

    @SerializedName("new_fans_count")
    private long newFansCount;

    @SerializedName("should_show")
    private boolean shouldShow;

    @SerializedName("watch_count")
    private long watchCount;

    public LiveRoomData() {
        this(false, null, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ LiveRoomData copy$default(LiveRoomData r110, boolean r111, String r112, long r113, long r114, long r115, long r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        boolean r100 = r110.shouldShow;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.liveTips;
    L11:
        if ((r211 & 4) == 0) goto L13;
        long r102 = r110.watchCount;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r103 = r110.newFansCount;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r104 = r110.commentCount;
    L23:
        if ((r211 & 32) == 0) goto L25;
        long r105 = r110.giftCount;
    L27:
        return r110.copy(r100, r101, r102, r103, r104, r105);
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.shouldShow;
    }

    public final String component2() {
        return this.liveTips;
    }

    public final long component3() {
        return this.watchCount;
    }

    public final long component4() {
        return this.newFansCount;
    }

    public final long component5() {
        return this.commentCount;
    }

    public final long component6() {
        return this.giftCount;
    }

    public final LiveRoomData copy(boolean r110, String r111, long r112, long r113, long r114, long r210) {
        Intrinsics.checkNotNullParameter(r111, "liveTips");
        return new LiveRoomData(r110, r111, r112, r113, r114, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveRoomData) == false) goto L18;
        LiveRoomData r101 = (LiveRoomData) r100;
        if (this.shouldShow == r101.shouldShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveTips, r101.liveTips) == true) goto L10;
        return false;
    L10:
        if (this.watchCount == r101.watchCount) goto L12;
        return false;
    L12:
        if (this.newFansCount == r101.newFansCount) goto L14;
        return false;
    L14:
        if (this.commentCount == r101.commentCount) goto L16;
        return false;
    L16:
        if (this.giftCount == r101.giftCount) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public int hashCode() {
        boolean r100 = this.shouldShow;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.liveTips;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L9:
        int r105 = (r102 + r104) * 31;
        long r106 = this.watchCount;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.newFansCount;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.commentCount;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.giftCount;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L8:
        r104 = 0;
        goto L9
    }

    public String toString() {
        return "LiveRoomData(shouldShow=" + this.shouldShow + ", liveTips=" + this.liveTips + ", watchCount=" + this.watchCount + ", newFansCount=" + this.newFansCount + ", commentCount=" + this.commentCount + ", giftCount=" + this.giftCount + ")";
    }

    public final long getCommentCount() {
        return this.commentCount;
    }

    public final long getGiftCount() {
        return this.giftCount;
    }

    public final String getLiveTips() {
        return this.liveTips;
    }

    public final long getNewFansCount() {
        return this.newFansCount;
    }

    public final boolean getShouldShow() {
        return this.shouldShow;
    }

    public final long getWatchCount() {
        return this.watchCount;
    }

    public final void setCommentCount(long r100) {
        this.commentCount = r100;
    }

    public final void setGiftCount(long r100) {
        this.giftCount = r100;
    }

    public final void setLiveTips(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveTips = r100;
    }

    public final void setNewFansCount(long r100) {
        this.newFansCount = r100;
    }

    public final void setShouldShow(boolean r100) {
        this.shouldShow = r100;
    }

    public final void setWatchCount(long r100) {
        this.watchCount = r100;
    }

    public LiveRoomData(boolean r100, String r101, long r102, long r103, long r104, long r110) {
        Intrinsics.checkNotNullParameter(r101, "liveTips");
        this.shouldShow = r100;
        this.liveTips = r101;
        this.watchCount = r102;
        this.newFansCount = r103;
        this.commentCount = r104;
        this.giftCount = r110;
    }

    public /* synthetic */ LiveRoomData(boolean r110, String r111, long r112, long r113, long r114, long r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = "";
    L10:
        long r102 = 0;
        if ((r211 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r105 = 0;
    L23:
        if ((r211 & 32) != 0) goto L26;
        r102 = r210;
    L26:
        this(r100, r101, r103, r104, r105, r102);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
