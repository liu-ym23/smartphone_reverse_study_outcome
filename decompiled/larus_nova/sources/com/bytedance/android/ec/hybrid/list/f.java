package com.bytedance.android.ec.hybrid.list;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0007\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\\R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*R.\u00101\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010/j\n\u0012\u0004\u0012\u00020&\u0018\u0001`08\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R.\u00105\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010/j\n\u0012\u0004\u0012\u00020&\u0018\u0001`08\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00104R.\u00107\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010/j\n\u0012\u0004\u0012\u00020&\u0018\u0001`08\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00104R.\u00109\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010/j\n\u0012\u0004\u0012\u00020&\u0018\u0001`08\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R\u001c\u0010;\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010\t\u001a\u0004\b<\u0010\u000bR\u001c\u0010=\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010\u0004\u001a\u0004\b>\u0010\u0006R\u001c\u0010?\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010\u0004\u001a\u0004\b@\u0010\u0006R\u001c\u0010A\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\t\u001a\u0004\bB\u0010\u000bR\u001c\u0010C\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010\t\u001a\u0004\bD\u0010\u000bR\u001c\u0010E\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bF\u0010\u000bR\u001c\u0010G\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010\t\u001a\u0004\bH\u0010\u000bR\"\u0010I\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010(\u001a\u0004\bJ\u0010*R\"\u0010K\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010(\u001a\u0004\bL\u0010*R\u001c\u0010M\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\u0006R\u001c\u0010O\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006R\u001c\u0010R\u001a\u0004\u0018\u00010Q8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\"\u0010V\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bV\u0010(\u001a\u0004\bW\u0010*R\u001c\u0010X\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010\t\u001a\u0004\bY\u0010\u000bR\u001c\u0010Z\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010\t\u001a\u0004\b[\u0010\u000b¨\u0006]"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/f;", "", "", "autoplayEnable", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "", "cardHasPlayedTime", "Ljava/lang/Integer;", "getCardHasPlayedTime", "()Ljava/lang/Integer;", "firstRowHasPlayedTime", "getFirstRowHasPlayedTime", "firstRowStopByCover", "getFirstRowStopByCover", "", "cardPlayHighPriorityPercent", "Ljava/lang/Double;", "getCardPlayHighPriorityPercent", "()Ljava/lang/Double;", "cardPlayTopVisiblePercent", RXScreenCaptureService.KEY_INDEX, "cardPlayVisiblePercent", ce.f26395j, "sameRowPlayedTime", "getSameRowPlayedTime", "cardSimultaneousPlayNum", "l", "legouAutoplayOptEnable", "getLegouAutoplayOptEnable", "thirdPlayableCardPlayFirst", "getThirdPlayableCardPlayFirst", "playCardWhenVisible", "getPlayCardWhenVisible", "playCardWhileSliding", "getPlayCardWhileSliding", "", "", "unsupportAutoplayPageName", "Ljava/util/List;", "getUnsupportAutoplayPageName", "()Ljava/util/List;", "unsupportAutoplayWhileSlidingPageName", "getUnsupportAutoplayWhileSlidingPageName", "unsupportAutoplaySimultaneousPlayPageName", "getUnsupportAutoplaySimultaneousPlayPageName", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "autoplayV3", "Ljava/util/ArrayList;", ce.f26391f, "()Ljava/util/ArrayList;", "autoPlayV4", "d", "autoPlayV5", "e", "playV4Tab", "r", "usePriority", "t", "limitPlayWithSecond", "o", "allLimitPlay", "b", "limitPlayMinDistance", OfficeSDKRequestTag.KEY_NEW_USER, "limitPlayMaxIndex", "m", "autoPlayDuration", "c", "playDurationLimit", "q", "tabIdFromLib", "s", "pageNameFromLib", "getPageNameFromLib", "cardClickPlayBackOpt", "h", "cardScrollPlayOpt", ce.f26396k, "", "obstructThreshold", "Ljava/lang/Float;", "p", "()Ljava/lang/Float;", "autoplayDualPlayPages", "getAutoplayDualPlayPages", "autoplayDualPlayExemptCount", "getAutoplayDualPlayExemptCount", "autoplayDualPlayWindowByIndex", "getAutoplayDualPlayWindowByIndex", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("all_limit_play_with_second")
    private final Boolean allLimitPlay;

    @SerializedName("auto_play_limit_duration")
    private final Integer autoPlayDuration;

    @SerializedName("autoplay_v4_page_names")
    private final ArrayList<String> autoPlayV4;

    @SerializedName("autoplay_v5_page_names")
    private final ArrayList<String> autoPlayV5;

    @SerializedName("autoplay_dual_play_exempt_count")
    private final Integer autoplayDualPlayExemptCount;

    @SerializedName("autoplay_dual_play_pages")
    private final List<String> autoplayDualPlayPages;

    @SerializedName("autoplay_dual_play_window_by_index")
    private final Integer autoplayDualPlayWindowByIndex;

    @SerializedName("autoplay_enable")
    private final Boolean autoplayEnable;

    @SerializedName("autoplay_v3_page_names")
    private final ArrayList<String> autoplayV3;

    @SerializedName("card_click_play_back_opt")
    private final Boolean cardClickPlayBackOpt;

    @SerializedName("card_has_played_time")
    private final Integer cardHasPlayedTime;

    @SerializedName("card_play_high_priority_percent")
    private final Double cardPlayHighPriorityPercent;

    @SerializedName("card_play_top_visible_percent")
    private final Double cardPlayTopVisiblePercent;

    @SerializedName("card_play_visible_percent")
    private final Double cardPlayVisiblePercent;

    @SerializedName("card_scroll_play_opt")
    private final Boolean cardScrollPlayOpt;

    @SerializedName("card_simultaneous_play_num")
    private final Integer cardSimultaneousPlayNum;

    @SerializedName("first_row_has_played_time")
    private final Integer firstRowHasPlayedTime;

    @SerializedName("first_row_stop_by_cover")
    private final Boolean firstRowStopByCover;

    @SerializedName("legou_autoplay_opt_enable")
    private final Boolean legouAutoplayOptEnable;

    @SerializedName("limit_play_max_index")
    private final Integer limitPlayMaxIndex;

    @SerializedName("limit_play_min_distance")
    private final Integer limitPlayMinDistance;

    @SerializedName("limit_play_with_second")
    private final Boolean limitPlayWithSecond;

    @SerializedName("obstruct_threshold")
    private final Float obstructThreshold;

    @SerializedName("page_name")
    private final List<String> pageNameFromLib;

    @SerializedName("autoplay_while_visible")
    private final Boolean playCardWhenVisible;

    @SerializedName("autoplay_while_sliding")
    private final Boolean playCardWhileSliding;

    @SerializedName("play_duration_limit")
    private final Integer playDurationLimit;

    @SerializedName("autoplay_v4_tab_id")
    private final ArrayList<String> playV4Tab;

    @SerializedName("same_row_played_time")
    private final Integer sameRowPlayedTime;

    @SerializedName("tab_id")
    private final List<String> tabIdFromLib;

    @SerializedName("third_playable_card_play_first")
    private final Boolean thirdPlayableCardPlayFirst;

    @SerializedName("unsupport_autoplay_page_name")
    private final List<String> unsupportAutoplayPageName;

    @SerializedName("unsupport_autoplay_simultaneous_play_page_name")
    private final List<String> unsupportAutoplaySimultaneousPlayPageName;

    @SerializedName("unsupport_autoplay_while_sliding_page_name")
    private final List<String> unsupportAutoplayWhileSlidingPageName;

    @SerializedName("use_priority")
    private final Integer usePriority;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L76;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.autoplayEnable, r101.autoplayEnable) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cardHasPlayedTime, r101.cardHasPlayedTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.firstRowHasPlayedTime, r101.firstRowHasPlayedTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.firstRowStopByCover, r101.firstRowStopByCover) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cardPlayHighPriorityPercent, r101.cardPlayHighPriorityPercent) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cardPlayTopVisiblePercent, r101.cardPlayTopVisiblePercent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cardPlayVisiblePercent, r101.cardPlayVisiblePercent) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.sameRowPlayedTime, r101.sameRowPlayedTime) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.cardSimultaneousPlayNum, r101.cardSimultaneousPlayNum) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.legouAutoplayOptEnable, r101.legouAutoplayOptEnable) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.thirdPlayableCardPlayFirst, r101.thirdPlayableCardPlayFirst) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.playCardWhenVisible, r101.playCardWhenVisible) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.playCardWhileSliding, r101.playCardWhileSliding) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.unsupportAutoplayPageName, r101.unsupportAutoplayPageName) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.unsupportAutoplayWhileSlidingPageName, r101.unsupportAutoplayWhileSlidingPageName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.unsupportAutoplaySimultaneousPlayPageName, r101.unsupportAutoplaySimultaneousPlayPageName) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.autoplayV3, r101.autoplayV3) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.autoPlayV4, r101.autoPlayV4) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.autoPlayV5, r101.autoPlayV5) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.playV4Tab, r101.playV4Tab) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.usePriority, r101.usePriority) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.limitPlayWithSecond, r101.limitPlayWithSecond) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.allLimitPlay, r101.allLimitPlay) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.limitPlayMinDistance, r101.limitPlayMinDistance) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.limitPlayMaxIndex, r101.limitPlayMaxIndex) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.autoPlayDuration, r101.autoPlayDuration) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.playDurationLimit, r101.playDurationLimit) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.tabIdFromLib, r101.tabIdFromLib) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.pageNameFromLib, r101.pageNameFromLib) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.cardClickPlayBackOpt, r101.cardClickPlayBackOpt) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.cardScrollPlayOpt, r101.cardScrollPlayOpt) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.obstructThreshold, r101.obstructThreshold) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.autoplayDualPlayPages, r101.autoplayDualPlayPages) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.autoplayDualPlayExemptCount, r101.autoplayDualPlayExemptCount) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.autoplayDualPlayWindowByIndex, r101.autoplayDualPlayWindowByIndex) == true) goto L115;
        return false;
    L115:
        return true;
    L76:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.autoplayEnable;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cardHasPlayedTime;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.firstRowHasPlayedTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.firstRowStopByCover;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.cardPlayHighPriorityPercent;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Double r116 = this.cardPlayTopVisiblePercent;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.cardPlayVisiblePercent;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.sameRowPlayedTime;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.cardSimultaneousPlayNum;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.legouAutoplayOptEnable;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.thirdPlayableCardPlayFirst;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.playCardWhenVisible;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.playCardWhileSliding;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        List<String> r140 = this.unsupportAutoplayPageName;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        List<String> r143 = this.unsupportAutoplayWhileSlidingPageName;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        List<String> r146 = this.unsupportAutoplaySimultaneousPlayPageName;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        ArrayList<String> r149 = this.autoplayV3;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        ArrayList<String> r152 = this.autoPlayV4;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        ArrayList<String> r155 = this.autoPlayV5;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        ArrayList<String> r158 = this.playV4Tab;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.usePriority;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Boolean r164 = this.limitPlayWithSecond;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        Boolean r167 = this.allLimitPlay;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        Integer r170 = this.limitPlayMinDistance;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        Integer r173 = this.limitPlayMaxIndex;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        Integer r176 = this.autoPlayDuration;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        Integer r179 = this.playDurationLimit;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        List<String> r182 = this.tabIdFromLib;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        List<String> r185 = this.pageNameFromLib;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        Boolean r188 = this.cardClickPlayBackOpt;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        Boolean r191 = this.cardScrollPlayOpt;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        Float r194 = this.obstructThreshold;
        if (r194 == null) goto L129;
        int r195 = r194.hashCode();
    L130:
        int r196 = (r193 + r195) * 31;
        List<String> r197 = this.autoplayDualPlayPages;
        if (r197 == null) goto L133;
        int r198 = r197.hashCode();
    L134:
        int r199 = (r196 + r198) * 31;
        Integer r200 = this.autoplayDualPlayExemptCount;
        if (r200 == null) goto L137;
        int r201 = r200.hashCode();
    L138:
        int r202 = (r199 + r201) * 31;
        Integer r203 = this.autoplayDualPlayWindowByIndex;
        if (r203 == null) goto L142;
        r101 = r203.hashCode();
    L142:
        return r202 + r101;
    L137:
        r201 = 0;
        goto L138
    L133:
        r198 = 0;
        goto L134
    L129:
        r195 = 0;
        goto L130
    L125:
        r192 = 0;
        goto L126
    L121:
        r189 = 0;
        goto L122
    L117:
        r186 = 0;
        goto L118
    L113:
        r183 = 0;
        goto L114
    L109:
        r180 = 0;
        goto L110
    L105:
        r177 = 0;
        goto L106
    L101:
        r174 = 0;
        goto L102
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "MallFeedAutoplayConfig(autoplayEnable=" + this.autoplayEnable + ", cardHasPlayedTime=" + this.cardHasPlayedTime + ", firstRowHasPlayedTime=" + this.firstRowHasPlayedTime + ", firstRowStopByCover=" + this.firstRowStopByCover + ", cardPlayHighPriorityPercent=" + this.cardPlayHighPriorityPercent + ", cardPlayTopVisiblePercent=" + this.cardPlayTopVisiblePercent + ", cardPlayVisiblePercent=" + this.cardPlayVisiblePercent + ", sameRowPlayedTime=" + this.sameRowPlayedTime + ", cardSimultaneousPlayNum=" + this.cardSimultaneousPlayNum + ", legouAutoplayOptEnable=" + this.legouAutoplayOptEnable + ", thirdPlayableCardPlayFirst=" + this.thirdPlayableCardPlayFirst + ", playCardWhenVisible=" + this.playCardWhenVisible + ", playCardWhileSliding=" + this.playCardWhileSliding + ", unsupportAutoplayPageName=" + this.unsupportAutoplayPageName + ", unsupportAutoplayWhileSlidingPageName=" + this.unsupportAutoplayWhileSlidingPageName + ", unsupportAutoplaySimultaneousPlayPageName=" + this.unsupportAutoplaySimultaneousPlayPageName + ", autoplayV3=" + this.autoplayV3 + ", autoPlayV4=" + this.autoPlayV4 + ", autoPlayV5=" + this.autoPlayV5 + ", playV4Tab=" + this.playV4Tab + ", usePriority=" + this.usePriority + ", limitPlayWithSecond=" + this.limitPlayWithSecond + ", allLimitPlay=" + this.allLimitPlay + ", limitPlayMinDistance=" + this.limitPlayMinDistance + ", limitPlayMaxIndex=" + this.limitPlayMaxIndex + ", autoPlayDuration=" + this.autoPlayDuration + ", playDurationLimit=" + this.playDurationLimit + ", tabIdFromLib=" + this.tabIdFromLib + ", pageNameFromLib=" + this.pageNameFromLib + ", cardClickPlayBackOpt=" + this.cardClickPlayBackOpt + ", cardScrollPlayOpt=" + this.cardScrollPlayOpt + ", obstructThreshold=" + this.obstructThreshold + ", autoplayDualPlayPages=" + this.autoplayDualPlayPages + ", autoplayDualPlayExemptCount=" + this.autoplayDualPlayExemptCount + ", autoplayDualPlayWindowByIndex=" + this.autoplayDualPlayWindowByIndex + ")";
    }

    public final Boolean b() {
        return this.allLimitPlay;
    }

    public final Integer c() {
        return this.autoPlayDuration;
    }

    public final ArrayList<String> d() {
        return this.autoPlayV4;
    }

    public final ArrayList<String> e() {
        return this.autoPlayV5;
    }

    public final Boolean f() {
        return this.autoplayEnable;
    }

    public final ArrayList<String> g() {
        return this.autoplayV3;
    }

    public final Boolean h() {
        return this.cardClickPlayBackOpt;
    }

    public final Double i() {
        return this.cardPlayTopVisiblePercent;
    }

    public final Double j() {
        return this.cardPlayVisiblePercent;
    }

    public final Boolean k() {
        return this.cardScrollPlayOpt;
    }

    public final Integer l() {
        return this.cardSimultaneousPlayNum;
    }

    public final Integer m() {
        return this.limitPlayMaxIndex;
    }

    public final Integer n() {
        return this.limitPlayMinDistance;
    }

    public final Boolean o() {
        return this.limitPlayWithSecond;
    }

    public final Float p() {
        return this.obstructThreshold;
    }

    public final Integer q() {
        return this.playDurationLimit;
    }

    public final ArrayList<String> r() {
        return this.playV4Tab;
    }

    public final List<String> s() {
        return this.tabIdFromLib;
    }

    public final Integer t() {
        return this.usePriority;
    }

    public f(Object r100) {
        this.autoplayEnable = null;
        this.cardHasPlayedTime = null;
        this.firstRowHasPlayedTime = null;
        this.firstRowStopByCover = null;
        this.cardPlayHighPriorityPercent = null;
        this.cardPlayTopVisiblePercent = null;
        this.cardPlayVisiblePercent = null;
        this.sameRowPlayedTime = null;
        this.cardSimultaneousPlayNum = null;
        this.legouAutoplayOptEnable = null;
        this.thirdPlayableCardPlayFirst = null;
        this.playCardWhenVisible = null;
        this.playCardWhileSliding = null;
        this.unsupportAutoplayPageName = null;
        this.unsupportAutoplayWhileSlidingPageName = null;
        this.unsupportAutoplaySimultaneousPlayPageName = null;
        this.autoplayV3 = null;
        this.autoPlayV4 = null;
        this.autoPlayV5 = null;
        this.playV4Tab = null;
        this.usePriority = null;
        this.limitPlayWithSecond = null;
        this.allLimitPlay = null;
        this.limitPlayMinDistance = null;
        this.limitPlayMaxIndex = null;
        this.autoPlayDuration = null;
        this.playDurationLimit = null;
        this.tabIdFromLib = null;
        this.pageNameFromLib = null;
        this.cardClickPlayBackOpt = null;
        this.cardScrollPlayOpt = null;
        this.obstructThreshold = null;
        this.autoplayDualPlayPages = null;
        this.autoplayDualPlayExemptCount = null;
        this.autoplayDualPlayWindowByIndex = null;
    }

    public final boolean a(String r100, Integer r101) {
        if (r101 == null) goto L4;
        String r102 = String.valueOf(r101.intValue());
    L6:
        if (r100 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L30;
        if (r102 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == true) goto L31;
        List<String> r105 = this.pageNameFromLib;
        if (r105 != null) goto L23;
        return false;
    L23:
        if (r105.contains(r100) != true) goto L33;
        List<String> r106 = this.tabIdFromLib;
        if (r106 != null) goto L27;
        return false;
    L27:
        if (r106.contains(r102) != true) goto L35;
        return true;
    L35:
        return false;
    L33:
        return false;
    L31:
        return false;
    L15:
        if (r102.length() == 0) goto L18;
        r104 = false;
        goto L19
    L30:
        return false;
    L8:
        if (r100.length() == 0) goto L11;
        r103 = false;
        goto L12
    L4:
        r102 = null;
        goto L6
    }

    public final boolean u(String r100, Integer r101) {
        if (a(r100, r101) == true) goto L5;
        return false;
    L5:
        return Intrinsics.areEqual(this.allLimitPlay, Boolean.TRUE);
    }

    public final boolean v(String r100, Integer r101) {
        if (a(r100, r101) == true) goto L5;
        return false;
    L5:
        return Intrinsics.areEqual(this.limitPlayWithSecond, Boolean.TRUE);
    }
}
