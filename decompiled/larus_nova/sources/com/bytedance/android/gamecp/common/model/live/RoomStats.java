package com.bytedance.android.gamecp.common.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.RoomStats")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b(\b\u0007\u0018\u0000 V2\u00020\u0001:\u0002WXB\u0007¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010'\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001f\u001a\u0004\b9\u0010!\"\u0004\b:\u0010#R$\u0010;\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u00103\u001a\u0004\b<\u00105\"\u0004\b=\u00107R$\u0010>\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u00103\u001a\u0004\b?\u00105\"\u0004\b@\u00107R$\u0010A\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u00103\u001a\u0004\bB\u00105\"\u0004\bC\u00107R$\u0010D\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u00103\u001a\u0004\bE\u00105\"\u0004\bF\u00107R\"\u0010G\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u001f\u001a\u0004\bH\u0010!\"\u0004\bI\u0010#R$\u0010J\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u00103\u001a\u0004\bK\u00105\"\u0004\bL\u00107R$\u0010M\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u00103\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001a\u0010P\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\bP\u0010\u001f\u001a\u0004\bQ\u0010!R\u001a\u0010R\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\bR\u0010\u001f\u001a\u0004\bS\u0010!¨\u0006Y"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/live/RoomStats;", "Lcom/bytedance/android/gamecp/common/model/live/b;", "other", "", "initWith", "", "o", "", "equals", "", "hashCode", "", "getId", "getTicket", "getMoney", "getTotalUser", "getFollowCount", "getGiftUVCount", DBDefinition.ID, "J", "get_id", "()J", "set_id", "(J)V", "_ticket", "get_ticket", "set_ticket", "_money", "get_money", "set_money", "_totalUser", "I", "get_totalUser", "()I", "set_totalUser", "(I)V", "_followCount", "get_followCount", "set_followCount", "_giftUVCount", "get_giftUVCount", "set_giftUVCount", "Lcom/bytedance/android/gamecp/common/model/live/RoomStats$b;", "userComposition", "Lcom/bytedance/android/gamecp/common/model/live/RoomStats$b;", "getUserComposition", "()Lcom/bytedance/android/gamecp/common/model/live/RoomStats$b;", "setUserComposition", "(Lcom/bytedance/android/gamecp/common/model/live/RoomStats$b;)V", "", "idStr", "Ljava/lang/String;", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "enterCount", "getEnterCount", "setEnterCount", "totalUserDesp", "getTotalUserDesp", "setTotalUserDesp", "douPlusPromotion", "getDouPlusPromotion", "setDouPlusPromotion", "totalUserStr", "getTotalUserStr", "setTotalUserStr", "userCountStr", "getUserCountStr", "setUserCountStr", "commentCount", "getCommentCount", "setCommentCount", "topRightStr", "getTopRightStr", "setTopRightStr", "topRightStrComplete", "getTopRightStrComplete", "setTopRightStrComplete", "INT_32", "getINT_32", "INT_31", "getINT_31", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStats implements com.bytedance.android.gamecp.common.model.live.b, h {
    public static final a Companion = null;
    private final int INT_31;
    private final int INT_32;

    @SerializedName("follow_count")
    protected int _followCount;

    @SerializedName("gift_uv_count")
    protected int _giftUVCount;

    @SerializedName("id")
    protected long _id;

    @SerializedName("money")
    protected long _money;

    @SerializedName("fan_ticket")
    protected long _ticket;

    @SerializedName("total_user")
    protected int _totalUser;

    @SerializedName("comment_count")
    protected int commentCount;

    @SerializedName("dou_plus_promotion")
    protected String douPlusPromotion;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTER_COUNT)
    protected int enterCount;

    @SerializedName("id_str")
    protected String idStr;

    @SerializedName("up_right_stats_str")
    protected String topRightStr;

    @SerializedName("up_right_stats_str_complete")
    protected String topRightStrComplete;

    @SerializedName("total_user_desp")
    protected String totalUserDesp;

    @SerializedName("total_user_str")
    protected String totalUserStr;

    @SerializedName("user_count_composition")
    protected b userComposition;

    @SerializedName("user_count_str")
    protected String userCountStr;

    public static final class a {
        public a() {
        }
    }

    @ProtoMessage("webcast.data.RoomStats.UserCountComposition")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/live/RoomStats$b;", "", "", "city", "D", "getCity", "()D", "setCity", "(D)V", "video", "getVideo", "setVideo", "follow", "getFollow", "setFollow", "other", "getOther", "setOther", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b implements h {

        @SerializedName("city")
        protected double city;

        @SerializedName("my_follow")
        protected double follow;

        @SerializedName("other")
        protected double other;

        @SerializedName("video_detail")
        protected double video;

        public b() {
        }

        public b(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.city = Double.longBitsToDouble(r100.h());
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.video = Double.longBitsToDouble(r100.h());
            goto L3
        L10:
            if (r102 != 3) goto L12;
            this.follow = Double.longBitsToDouble(r100.h());
            goto L3
        L12:
            if (r102 != 4) goto L13;
            this.other = Double.longBitsToDouble(r100.h());
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    static {
        Companion = new a();
    }

    public RoomStats() {
        this.INT_32 = 32;
        this.INT_31 = 31;
    }

    public int hashCode() {
        int r100 = (int) (getId() ^ (getId() >>> this.INT_32));
        int r101 = (this.INT_31 * r100) + ((int) (getTicket() ^ (getTicket() >>> this.INT_32)));
        int r102 = (this.INT_31 * r101) + ((int) (getMoney() ^ (getMoney() >>> this.INT_32)));
        int r103 = (this.INT_31 * r102) + getTotalUser();
        int r104 = (this.INT_31 * r103) + getFollowCount();
        int r105 = (this.INT_31 * r104) + getGiftUVCount();
        int r106 = this.INT_31 * r105;
        String r107 = this.idStr;
        int r108 = 0;
        if (r107 == null) goto L7;
        if (r107 == null) goto L7;
        r108 = r107.hashCode();
    L7:
        return r106 + r108;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    public final String getDouPlusPromotion() {
        return this.douPlusPromotion;
    }

    public final int getEnterCount() {
        return this.enterCount;
    }

    @Override // com.bytedance.android.gamecp.common.model.live.b
    public int getFollowCount() {
        return this._followCount;
    }

    @Override // com.bytedance.android.gamecp.common.model.live.b
    public int getGiftUVCount() {
        return this._giftUVCount;
    }

    public final int getINT_31() {
        return this.INT_31;
    }

    public final int getINT_32() {
        return this.INT_32;
    }

    @Override // com.bytedance.android.gamecp.common.model.live.b
    public long getId() {
        return this._id;
    }

    public final String getIdStr() {
        return this.idStr;
    }

    @Override // com.bytedance.android.gamecp.common.model.live.b
    public long getMoney() {
        return this._money;
    }

    @Override // com.bytedance.android.gamecp.common.model.live.b
    public long getTicket() {
        return this._ticket;
    }

    public final String getTopRightStr() {
        return this.topRightStr;
    }

    public final String getTopRightStrComplete() {
        return this.topRightStrComplete;
    }

    @Override // com.bytedance.android.gamecp.common.model.live.b
    public int getTotalUser() {
        return this._totalUser;
    }

    public final String getTotalUserDesp() {
        return this.totalUserDesp;
    }

    public final String getTotalUserStr() {
        return this.totalUserStr;
    }

    public final b getUserComposition() {
        return this.userComposition;
    }

    public final String getUserCountStr() {
        return this.userCountStr;
    }

    public final int get_followCount() {
        return this._followCount;
    }

    public final int get_giftUVCount() {
        return this._giftUVCount;
    }

    public final long get_id() {
        return this._id;
    }

    public final long get_money() {
        return this._money;
    }

    public final long get_ticket() {
        return this._ticket;
    }

    public final int get_totalUser() {
        return this._totalUser;
    }

    public RoomStats(g r100) {
        this.INT_32 = 32;
        this.INT_31 = 31;
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        switch(r102) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L6;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L9;
            case 18: goto L6;
            case 19: goto L8;
            case 20: goto L7;
            default: goto L6;
        };
    L7:
        this.topRightStrComplete = am3.h.c(r100);
        goto L3
    L8:
        this.topRightStr = am3.h.c(r100);
        goto L3
    L9:
        this.commentCount = (int) r100.j();
        goto L3
    L10:
        this.userCountStr = am3.h.c(r100);
        goto L3
    L11:
        this.totalUserStr = am3.h.c(r100);
        goto L3
    L12:
        this.totalUserDesp = am3.h.c(r100);
        goto L3
    L13:
        this.douPlusPromotion = am3.h.c(r100);
        goto L3
    L14:
        this.enterCount = (int) r100.j();
        goto L3
    L15:
        this.userComposition = new b(r100);
        goto L3
    L16:
        this._followCount = (int) r100.j();
        goto L3
    L17:
        this._giftUVCount = (int) r100.j();
        goto L3
    L18:
        this._totalUser = (int) r100.j();
        goto L3
    L19:
        this._money = r100.j();
        goto L3
    L20:
        this._ticket = r100.j();
        goto L3
    L21:
        this.idStr = am3.h.c(r100);
        goto L3
    L22:
        this._id = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L23:
        r100.d(r101);
    }

    private final void initWith(com.bytedance.android.gamecp.common.model.live.b r100) {
        this._id = r100.getId();
        this._ticket = r100.getTicket();
        this._money = r100.getMoney();
        this._totalUser = r100.getTotalUser();
        this._followCount = r100.getFollowCount();
        this._giftUVCount = r100.getGiftUVCount();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L37:
        return false;
    L8:
        if ((!Intrinsics.areEqual(RoomStats.class, r100.getClass())) == true) goto L37;
        RoomStats r101 = (RoomStats) r100;
        if (getId() == r101.getId()) goto L14;
        return false;
    L14:
        if (getTicket() == r101.getTicket()) goto L17;
        return false;
    L17:
        if (getMoney() == r101.getMoney()) goto L20;
        return false;
    L20:
        if (getFollowCount() == r101.getFollowCount()) goto L23;
        return false;
    L23:
        if (getGiftUVCount() == r101.getGiftUVCount()) goto L25;
        return false;
    L25:
        String r102 = this.idStr;
        if (r102 == null) goto L29;
        boolean r103 = !Intrinsics.areEqual(r102, r101.idStr);
    L32:
        if (r103 == false) goto L35;
    L33:
        return false;
    L35:
        if (getTotalUser() != r101.getTotalUser()) goto L33;
        return true;
    L29:
        if (r101.idStr == null) goto L31;
        r103 = true;
        goto L32
    L31:
        r103 = false;
        goto L32
    }

    public final void setCommentCount(int r100) {
        this.commentCount = r100;
    }

    public final void setDouPlusPromotion(String r100) {
        this.douPlusPromotion = r100;
    }

    public final void setEnterCount(int r100) {
        this.enterCount = r100;
    }

    public final void setIdStr(String r100) {
        this.idStr = r100;
    }

    public final void setTopRightStr(String r100) {
        this.topRightStr = r100;
    }

    public final void setTopRightStrComplete(String r100) {
        this.topRightStrComplete = r100;
    }

    public final void setTotalUserDesp(String r100) {
        this.totalUserDesp = r100;
    }

    public final void setTotalUserStr(String r100) {
        this.totalUserStr = r100;
    }

    public final void setUserComposition(b r100) {
        this.userComposition = r100;
    }

    public final void setUserCountStr(String r100) {
        this.userCountStr = r100;
    }

    public final void set_followCount(int r100) {
        this._followCount = r100;
    }

    public final void set_giftUVCount(int r100) {
        this._giftUVCount = r100;
    }

    public final void set_id(long r100) {
        this._id = r100;
    }

    public final void set_money(long r100) {
        this._money = r100;
    }

    public final void set_ticket(long r100) {
        this._ticket = r100;
    }

    public final void set_totalUser(int r100) {
        this._totalUser = r100;
    }
}
