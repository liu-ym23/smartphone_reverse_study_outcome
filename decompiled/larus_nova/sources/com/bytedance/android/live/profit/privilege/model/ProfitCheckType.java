package com.bytedance.android.live.profit.privilege.model;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00062"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/ProfitCheckType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "", "index", "J", "getIndex", "()J", "setIndex", "(J)V", "", "localReport", "Z", "getLocalReport", "()Z", "setLocalReport", "(Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ANCHOR_GIFT_IM", "ANCHOR_GIFT_EFFECT", "Unknown", "GIFT_TRAY", "GIFT_EFFECT", "GIFT_PUBLIC_AREA_MSG", "ENTER_ROOM_EFFECT", "DRESS_SHOW", "DRESS_OPEN_EFFECT", "GIFT_LIST_INFO", "SCREEN_CHAT_DISPLAY", "FANS_CLUB_PAGE", "PK", "GRADE_LEVEL", "EXHIBITION_INFO", "WISH_LIST", "AUDIENCE_RANK_LIST", "AWMELITE_TASK", "LINK_MIC_CONTRIBUTE_RANK_LIST", "CONSUME_REQUEST", "GIFT_EFFECT_SELF_IM", "GIFT_OPTION_RIGHT", "SHORT_TOUCH_SELF_LUCKYMONEY", "RECHARGE_COUPON_ACTIVITY", "GENERAL_TASK", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ProfitCheckType extends Enum<ProfitCheckType> {
    public static final ProfitCheckType ANCHOR_GIFT_EFFECT = null;
    public static final ProfitCheckType ANCHOR_GIFT_IM = null;
    public static final ProfitCheckType AUDIENCE_RANK_LIST = null;
    public static final ProfitCheckType AWMELITE_TASK = null;
    public static final ProfitCheckType CONSUME_REQUEST = null;
    public static final a Companion = null;
    public static final ProfitCheckType DRESS_OPEN_EFFECT = null;
    public static final ProfitCheckType DRESS_SHOW = null;
    public static final ProfitCheckType ENTER_ROOM_EFFECT = null;
    public static final ProfitCheckType EXHIBITION_INFO = null;
    public static final ProfitCheckType FANS_CLUB_PAGE = null;
    public static final ProfitCheckType GENERAL_TASK = null;
    public static final ProfitCheckType GIFT_EFFECT = null;
    public static final ProfitCheckType GIFT_EFFECT_SELF_IM = null;
    public static final ProfitCheckType GIFT_LIST_INFO = null;
    public static final ProfitCheckType GIFT_OPTION_RIGHT = null;
    public static final ProfitCheckType GIFT_PUBLIC_AREA_MSG = null;
    public static final ProfitCheckType GIFT_TRAY = null;
    public static final ProfitCheckType GRADE_LEVEL = null;
    public static final ProfitCheckType LINK_MIC_CONTRIBUTE_RANK_LIST = null;
    public static final long LOCAL_REPORT_INDEX = -114514;
    public static final ProfitCheckType PK = null;
    public static final ProfitCheckType RECHARGE_COUPON_ACTIVITY = null;
    public static final ProfitCheckType SCREEN_CHAT_DISPLAY = null;
    public static final ProfitCheckType SHORT_TOUCH_SELF_LUCKYMONEY = null;
    public static final ProfitCheckType Unknown = null;
    public static final ProfitCheckType WISH_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProfitCheckType[] f88415a = null;
    private long index;
    private boolean localReport;
    private String typeName;

    public static final class a {
        public a() {
        }
    }

    public static ProfitCheckType valueOf(String r100) {
        return (ProfitCheckType) r27.a.a(ProfitCheckType.class, r100);
    }

    public static ProfitCheckType[] values() {
        return (ProfitCheckType[]) f88415a.clone();
    }

    static {
        ProfitCheckType r100 = new ProfitCheckType("ANCHOR_GIFT_IM", 0, "anchor_gift_im", LOCAL_REPORT_INDEX, true);
        ANCHOR_GIFT_IM = r100;
        ProfitCheckType r101 = new ProfitCheckType("ANCHOR_GIFT_EFFECT", 1, "anchor_gift_effect", LOCAL_REPORT_INDEX, true);
        ANCHOR_GIFT_EFFECT = r101;
        boolean r102 = false;
        int r110 = 4;
        DefaultConstructorMarker r111 = null;
        ProfitCheckType r103 = new ProfitCheckType("Unknown", 2, "unKnown", 0, r102, r110, r111);
        Unknown = r103;
        ProfitCheckType r104 = new ProfitCheckType("GIFT_TRAY", 3, "gift_tray", 1, r102, r110, r111);
        GIFT_TRAY = r104;
        ProfitCheckType r105 = new ProfitCheckType("GIFT_EFFECT", 4, IPerformanceManager.MODULE_GIFT_EFFECT, 2, r102, r110, r111);
        GIFT_EFFECT = r105;
        ProfitCheckType r106 = new ProfitCheckType("GIFT_PUBLIC_AREA_MSG", 5, "gift_public_area_msg", 3, r102, r110, r111);
        GIFT_PUBLIC_AREA_MSG = r106;
        ProfitCheckType r107 = new ProfitCheckType("ENTER_ROOM_EFFECT", 6, "enter_room_effect", 4, r102, r110, r111);
        ENTER_ROOM_EFFECT = r107;
        ProfitCheckType r108 = new ProfitCheckType("DRESS_SHOW", 7, "dress_show", 5, r102, r110, r111);
        DRESS_SHOW = r108;
        ProfitCheckType r109 = new ProfitCheckType("DRESS_OPEN_EFFECT", 8, "dress_open_effect", 6, r102, r110, r111);
        DRESS_OPEN_EFFECT = r109;
        ProfitCheckType r112 = new ProfitCheckType("GIFT_LIST_INFO", 9, "gift_list_info", 7, r102, r110, r111);
        GIFT_LIST_INFO = r112;
        ProfitCheckType r113 = new ProfitCheckType("SCREEN_CHAT_DISPLAY", 10, "screenchat_display", 8, r102, r110, r111);
        SCREEN_CHAT_DISPLAY = r113;
        ProfitCheckType r114 = new ProfitCheckType("FANS_CLUB_PAGE", 11, "fansclub_page", 9, r102, r110, r111);
        FANS_CLUB_PAGE = r114;
        ProfitCheckType r115 = new ProfitCheckType("PK", 12, PbRequest.SwitchType.PK, 10, r102, r110, r111);
        PK = r115;
        ProfitCheckType r116 = new ProfitCheckType("GRADE_LEVEL", 13, "grade_level", 11, r102, r110, r111);
        GRADE_LEVEL = r116;
        ProfitCheckType r117 = new ProfitCheckType("EXHIBITION_INFO", 14, "exhibition_info", 12, r102, r110, r111);
        EXHIBITION_INFO = r117;
        ProfitCheckType r118 = new ProfitCheckType("WISH_LIST", 15, "wish_list", 13, r102, r110, r111);
        WISH_LIST = r118;
        ProfitCheckType r119 = new ProfitCheckType("AUDIENCE_RANK_LIST", 16, "audience_ranklist", 14, r102, r110, r111);
        AUDIENCE_RANK_LIST = r119;
        ProfitCheckType r120 = new ProfitCheckType("AWMELITE_TASK", 17, "awmelite_task", 15, r102, r110, r111);
        AWMELITE_TASK = r120;
        ProfitCheckType r121 = new ProfitCheckType("LINK_MIC_CONTRIBUTE_RANK_LIST", 18, "linkmic_contribute_ranklist", 16, r102, r110, r111);
        LINK_MIC_CONTRIBUTE_RANK_LIST = r121;
        ProfitCheckType r122 = new ProfitCheckType("CONSUME_REQUEST", 19, "consume_request", 17, r102, r110, r111);
        CONSUME_REQUEST = r122;
        ProfitCheckType r123 = new ProfitCheckType("GIFT_EFFECT_SELF_IM", 20, "gift_effect_self_im", 18, r102, r110, r111);
        GIFT_EFFECT_SELF_IM = r123;
        ProfitCheckType r124 = new ProfitCheckType("GIFT_OPTION_RIGHT", 21, "gift_option_right", 19, r102, r110, r111);
        GIFT_OPTION_RIGHT = r124;
        ProfitCheckType r125 = new ProfitCheckType("SHORT_TOUCH_SELF_LUCKYMONEY", 22, "short_touch_self_luckymoney", 21, false, 4, null);
        SHORT_TOUCH_SELF_LUCKYMONEY = r125;
        ProfitCheckType r126 = new ProfitCheckType("RECHARGE_COUPON_ACTIVITY", 23, "recharge_coupon_activity", 22, true);
        RECHARGE_COUPON_ACTIVITY = r126;
        ProfitCheckType r127 = new ProfitCheckType("GENERAL_TASK", 24, "general_task", 100, false, 4, null);
        GENERAL_TASK = r127;
        f88415a = new ProfitCheckType[]{r100, r101, r103, r104, r105, r106, r107, r108, r109, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
        Companion = new a();
    }

    public final long getIndex() {
        return this.index;
    }

    public final boolean getLocalReport() {
        return this.localReport;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final void setIndex(long r100) {
        this.index = r100;
    }

    public final void setLocalReport(boolean r100) {
        this.localReport = r100;
    }

    public final void setTypeName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.typeName = r100;
    }

    public ProfitCheckType(String r100, int r101, String r102, long r103, boolean r104) {
        super(r100, r101);
        this.typeName = r102;
        this.index = r103;
        this.localReport = r104;
    }

    public /* synthetic */ ProfitCheckType(String r100, int r101, String r110, long r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 4) == 0) goto L5;
        boolean r102 = false;
    L6:
        this(r100, r101, r110, r111, r102);
        return;
    L5:
        r102 = r112;
        goto L6
    }
}
