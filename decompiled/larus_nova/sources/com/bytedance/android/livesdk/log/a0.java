package com.bytedance.android.livesdk.log;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f153275a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/log/a0$a;", "", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "", "position", "I", "getPosition", "()I", "", "watchDuration", "J", "getWatchDuration", "()J", "giftCount", "getGiftCount", "giftValue", "getGiftValue", "likeCount", "getLikeCount", "commentCount", "getCommentCount", "doFollow", "getDoFollow", "doUnFollow", "getDoUnFollow", "livelogger_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("comment_count")
        private final int commentCount;

        @SerializedName("is_follow")
        private final int doFollow;

        @SerializedName("is_unfollow")
        private final int doUnFollow;

        @SerializedName("gift_count")
        private final long giftCount;

        @SerializedName("gift_value")
        private final long giftValue;

        @SerializedName("like_count")
        private final int likeCount;

        @SerializedName("position")
        private final int position;

        @SerializedName("gid")
        private final String roomId;

        @SerializedName("duration")
        private final long watchDuration;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L24;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
            return false;
        L8:
            if (this.position == r101.position) goto L10;
            return false;
        L10:
            if (this.watchDuration == r101.watchDuration) goto L12;
            return false;
        L12:
            if (this.giftCount == r101.giftCount) goto L14;
            return false;
        L14:
            if (this.giftValue == r101.giftValue) goto L16;
            return false;
        L16:
            if (this.likeCount == r101.likeCount) goto L18;
            return false;
        L18:
            if (this.commentCount == r101.commentCount) goto L20;
            return false;
        L20:
            if (this.doFollow == r101.doFollow) goto L22;
            return false;
        L22:
            if (this.doUnFollow == r101.doUnFollow) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final int hashCode() {
            String r100 = this.roomId;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = ((r101 * 31) + this.position) * 31;
            long r103 = this.watchDuration;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.giftCount;
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = this.giftValue;
            return ((((((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.likeCount) * 31) + this.commentCount) * 31) + this.doFollow) * 31) + this.doUnFollow;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveRoomDetailInfo(roomId=" + this.roomId + ", position=" + this.position + ", watchDuration=" + this.watchDuration + ", giftCount=" + this.giftCount + ", giftValue=" + this.giftValue + ", likeCount=" + this.likeCount + ", commentCount=" + this.commentCount + ", doFollow=" + this.doFollow + ", doUnFollow=" + this.doUnFollow + ")";
        }

        public /* synthetic */ a(int r110) {
            this("", 0, 0, 0, 0, 0, 0, 0, 0);
        }

        public a(String r100, int r101, long r102, long r103, long r104, int r105, int r110, int r111, int r112) {
            this.roomId = r100;
            this.position = r101;
            this.watchDuration = r102;
            this.giftCount = r103;
            this.giftValue = r104;
            this.likeCount = r105;
            this.commentCount = r110;
            this.doFollow = r111;
            this.doUnFollow = r112;
        }
    }

    static {
        f153275a = new a(0);
    }

    public static String a() {
        String r100 = GsonProtectorUtils.toJson(new Gson(), f153275a);
        if (r100.length() <= 600) goto L6;
        return "";
    L6:
        return r100;
    }
}
