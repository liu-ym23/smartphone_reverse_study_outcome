package com.bytedance.android.live.base.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.RoomStats")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b(\b\u0007\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002RSB\u0007¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR$\u00106\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b6\u0010.\u001a\u0004\b7\u00100\"\u0004\b8\u00102R$\u00109\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b9\u0010.\u001a\u0004\b:\u00100\"\u0004\b;\u00102R$\u0010<\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b<\u0010.\u001a\u0004\b=\u00100\"\u0004\b>\u00102R$\u0010?\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b?\u0010.\u001a\u0004\b@\u00100\"\u0004\bA\u00102R\"\u0010B\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bB\u0010\u001a\u001a\u0004\bC\u0010\u001c\"\u0004\bD\u0010\u001eR$\u0010E\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bE\u0010.\u001a\u0004\bF\u00100\"\u0004\bG\u00102R$\u0010H\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bH\u0010.\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R\u001a\u0010K\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bK\u0010\u001a\u001a\u0004\bL\u0010\u001cR\u001a\u0010M\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\bM\u0010\u001a\u001a\u0004\bN\u0010\u001c¨\u0006T"}, d2 = {"Lcom/bytedance/android/live/base/model/live/RoomStats;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats;", "other", "", "initWith", "", "o", "", "equals", "", "hashCode", "", "id", "J", "getId", "()J", "setId", "(J)V", "ticket", "getTicket", "setTicket", "money", "getMoney", "setMoney", "totalUser", "I", "getTotalUser", "()I", "setTotalUser", "(I)V", "followCount", "getFollowCount", "setFollowCount", "giftUVCount", "getGiftUVCount", "setGiftUVCount", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "userComposition", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "getUserComposition", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "setUserComposition", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;)V", "", "idStr", "Ljava/lang/String;", "getIdStr", "()Ljava/lang/String;", "setIdStr", "(Ljava/lang/String;)V", "enterCount", "getEnterCount", "setEnterCount", "totalUserDesp", "getTotalUserDesp", "setTotalUserDesp", "douPlusPromotion", "getDouPlusPromotion", "setDouPlusPromotion", "totalUserStr", "getTotalUserStr", "setTotalUserStr", "userCountStr", "getUserCountStr", "setUserCountStr", "commentCount", "getCommentCount", "setCommentCount", "topRightStr", "getTopRightStr", "setTopRightStr", "topRightStrComplete", "getTopRightStrComplete", "setTopRightStrComplete", "INT_32", "getINT_32", "INT_31", "getINT_31", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UserComposition", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomStats extends FlexModelBase<IRoomStats> implements IRoomStats, h {
    public static final a Companion = null;
    private final int INT_31;
    private final int INT_32;

    @SerializedName("comment_count")
    protected int commentCount;

    @SerializedName("dou_plus_promotion")
    protected String douPlusPromotion;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTER_COUNT)
    protected int enterCount;

    @SerializedName("follow_count")
    protected int followCount;

    @SerializedName("gift_uv_count")
    protected int giftUVCount;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f58839id;

    @SerializedName("id_str")
    protected String idStr;

    @SerializedName("money")
    protected long money;

    @SerializedName("fan_ticket")
    protected long ticket;

    @SerializedName("up_right_stats_str")
    protected String topRightStr;

    @SerializedName("up_right_stats_str_complete")
    protected String topRightStrComplete;

    @SerializedName("total_user")
    protected int totalUser;

    @SerializedName("total_user_desp")
    protected String totalUserDesp;

    @SerializedName("total_user_str")
    protected String totalUserStr;

    @SerializedName("user_count_composition")
    protected IRoomStats.IUserComposition userComposition;

    @SerializedName("user_count_str")
    protected String userCountStr;

    @ProtoMessage("webcast.data.RoomStats.UserCountComposition")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/base/model/live/RoomStats$UserComposition;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomStats$IUserComposition;", "()V", "city", "", "getCity", "()D", "setCity", "(D)V", "follow", "getFollow", "setFollow", "other", "getOther", "setOther", "video", "getVideo", "setVideo", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UserComposition extends FlexModelBase<IRoomStats.IUserComposition> implements IRoomStats.IUserComposition, h {

        @SerializedName("city")
        protected double city;

        @SerializedName("my_follow")
        protected double follow;

        @SerializedName("other")
        protected double other;

        @SerializedName("video_detail")
        protected double video;

        public UserComposition() {
            super(IRoomStats.IUserComposition.class);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats.IUserComposition
        public double getCity() {
            return this.city;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats.IUserComposition
        public double getFollow() {
            return this.follow;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats.IUserComposition
        public double getOther() {
            return this.other;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats.IUserComposition
        public double getVideo() {
            return this.video;
        }

        public UserComposition(g r100) {
            super(IRoomStats.IUserComposition.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            g.a r103 = decodeExtensionFields(r102, r100);
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
            am3.h.d(r103, r100);
            goto L3
        L18:
            r100.d(r101);
            setThreadSafe(true);
        }

        public void setCity(double r100) {
            this.city = r100;
        }

        public void setFollow(double r100) {
            this.follow = r100;
        }

        public void setOther(double r100) {
            this.other = r100;
        }

        public void setVideo(double r100) {
            this.video = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RoomStats() {
        super(IRoomStats.class);
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
        int r107 = 0;
        if (getIdStr() == null) goto L8;
        String r108 = getIdStr();
        if (r108 == null) goto L8;
        r107 = r108.hashCode();
    L8:
        return r106 + r107;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public int getCommentCount() {
        return this.commentCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public String getDouPlusPromotion() {
        return this.douPlusPromotion;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public int getEnterCount() {
        return this.enterCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public int getFollowCount() {
        return this.followCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public int getGiftUVCount() {
        return this.giftUVCount;
    }

    public final int getINT_31() {
        return this.INT_31;
    }

    public final int getINT_32() {
        return this.INT_32;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public long getId() {
        return this.f58839id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public String getIdStr() {
        return this.idStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public long getMoney() {
        return this.money;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public long getTicket() {
        return this.ticket;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public String getTopRightStr() {
        return this.topRightStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public String getTopRightStrComplete() {
        return this.topRightStrComplete;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public int getTotalUser() {
        return this.totalUser;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public String getTotalUserDesp() {
        return this.totalUserDesp;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public String getTotalUserStr() {
        return this.totalUserStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public IRoomStats.IUserComposition getUserComposition() {
        return this.userComposition;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public String getUserCountStr() {
        return this.userCountStr;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.livesdkapi.depend.model.live.IRoomStats$IUserComposition, java.lang.Object] */
    public RoomStats(g r100) {
        super(IRoomStats.class);
        this.INT_32 = 32;
        this.INT_31 = 31;
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L7;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L7;
            case 19: goto L9;
            case 20: goto L8;
            default: goto L7;
        };
    L8:
        this.topRightStrComplete = am3.h.c(r100);
        goto L3
    L9:
        this.topRightStr = am3.h.c(r100);
        goto L3
    L10:
        this.commentCount = (int) r100.j();
        goto L3
    L11:
        this.userCountStr = am3.h.c(r100);
        goto L3
    L12:
        this.totalUserStr = am3.h.c(r100);
        goto L3
    L13:
        this.totalUserDesp = am3.h.c(r100);
        goto L3
    L14:
        this.douPlusPromotion = am3.h.c(r100);
        goto L3
    L15:
        this.enterCount = (int) r100.j();
        goto L3
    L16:
        this.userComposition = f.a(r100, IRoomStats.IUserComposition.class);
        goto L3
    L17:
        this.followCount = (int) r100.j();
        goto L3
    L18:
        this.giftUVCount = (int) r100.j();
        goto L3
    L19:
        this.totalUser = (int) r100.j();
        goto L3
    L20:
        this.money = r100.j();
        goto L3
    L21:
        this.ticket = r100.j();
        goto L3
    L22:
        this.idStr = am3.h.c(r100);
        goto L3
    L23:
        this.f58839id = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    private final void initWith(IRoomStats r100) {
        setId(r100.getId());
        setTicket(r100.getTicket());
        setMoney(r100.getMoney());
        setTotalUser(r100.getTotalUser());
        setFollowCount(r100.getFollowCount());
        setGiftUVCount(r100.getGiftUVCount());
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
        if (getGiftUVCount() == r101.getGiftUVCount()) goto L26;
        return false;
    L26:
        if (getIdStr() == null) goto L29;
        boolean r102 = !Intrinsics.areEqual(getIdStr(), r101.getIdStr());
    L32:
        if (r102 == false) goto L35;
    L33:
        return false;
    L35:
        if (getTotalUser() != r101.getTotalUser()) goto L33;
        return true;
    L29:
        if (r101.getIdStr() == null) goto L31;
        r102 = true;
        goto L32
    L31:
        r102 = false;
        goto L32
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setCommentCount(int r100) {
        this.commentCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setDouPlusPromotion(String r100) {
        this.douPlusPromotion = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setEnterCount(int r100) {
        this.enterCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setFollowCount(int r100) {
        this.followCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setGiftUVCount(int r100) {
        this.giftUVCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setId(long r100) {
        this.f58839id = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setIdStr(String r100) {
        this.idStr = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setMoney(long r100) {
        this.money = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setTicket(long r100) {
        this.ticket = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setTopRightStr(String r100) {
        this.topRightStr = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setTopRightStrComplete(String r100) {
        this.topRightStrComplete = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setTotalUser(int r100) {
        this.totalUser = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setTotalUserDesp(String r100) {
        this.totalUserDesp = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setTotalUserStr(String r100) {
        this.totalUserStr = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setUserComposition(IRoomStats.IUserComposition r100) {
        this.userComposition = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomStats
    public void setUserCountStr(String r100) {
        this.userCountStr = r100;
    }
}
