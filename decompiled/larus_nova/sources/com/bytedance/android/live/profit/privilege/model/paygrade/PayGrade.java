package com.bytedance.android.live.profit.privilege.model.paygrade;

import com.bytedance.android.live.base.model.user.v;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\bE\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0010\b\u0002\u0010%\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0010\b\u0002\u0010&\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e\u0012\b\b\u0002\u0010'\u001a\u00020\u0010\u0012\b\b\u0002\u0010(\u001a\u00020\u0012\u0012(\b\u0002\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0015\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010.\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\b\b\u0002\u0010/\u001a\u00020\u0012\u0012\b\b\u0002\u00100\u001a\u00020\u0012\u0012\u0010\b\u0002\u00101\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\bX\u0010YJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\u0011\u0010\f\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\u0011\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0010HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0012HÆ\u0003J)\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0015HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0012HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0012HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J\u0097\u0002\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0010\b\u0002\u0010%\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\u0010\b\u0002\u0010&\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e2\b\b\u0002\u0010'\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00122(\b\u0002\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00152\b\b\u0002\u0010*\u001a\u00020\u00122\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010.\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n2\b\b\u0002\u0010/\u001a\u00020\u00122\b\b\u0002\u00100\u001a\u00020\u00122\u0010\b\u0002\u00101\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0001J\t\u00103\u001a\u00020\u0007HÖ\u0001J\t\u00104\u001a\u00020\u0012HÖ\u0001J\u0013\u00106\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u00109R\u0017\u0010 \u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b:\u00109R\u0017\u0010!\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b;\u00109R\u0017\u0010\"\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b<\u00109R\u0019\u0010#\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010?R\u001f\u0010$\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bA\u0010BR\u001f\u0010%\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bC\u0010BR\u001f\u0010&\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8\u0006¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010'\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b'\u0010G\u001a\u0004\bH\u0010IR\u0017\u0010(\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b(\u0010J\u001a\u0004\bK\u0010LR7\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00158\u0006¢\u0006\f\n\u0004\b)\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010*\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bP\u0010LR\u0019\u0010+\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b+\u0010=\u001a\u0004\bQ\u0010?R\u0019\u0010,\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b,\u0010=\u001a\u0004\bR\u0010?R\u0019\u0010-\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b-\u0010=\u001a\u0004\bS\u0010?R\u001f\u0010.\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b.\u0010@\u001a\u0004\bT\u0010BR\u0017\u0010/\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b/\u0010J\u001a\u0004\bU\u0010LR\u0017\u00100\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b0\u0010J\u001a\u0004\bV\u0010LR\u001f\u00101\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n8\u0006¢\u0006\f\n\u0004\b1\u0010@\u001a\u0004\bW\u0010B¨\u0006Z"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/paygrade/PayGrade;", "", "", "component1", "component2", "component3", "component4", "", "component5", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "component6", "component7", "Lcom/bytedance/android/live/base/model/user/v;", "Lcom/bytedance/android/live/api/IGradeBuffInfoKt;", "component8", "", "component9", "", "component10", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", com.bytedance.android.ec.core.event.a.KEY_SCORE, "level", "this_grade_min_diamond", "this_grade_max_diamond", "grade_describe", "new_im_icon_with_level", "new_live_icon", "buff_info", "grade_describe_shining", "describe_type", "extra", "effectType", "shortDesc", "shortPreDesc", "jumpSchema", "effectImg", "effectDurationMilli", "effectPlayTimes", "recentConsumeBadge", "copy", "toString", "hashCode", "other", "equals", "J", "getScore", "()J", "getLevel", "getThis_grade_min_diamond", "getThis_grade_max_diamond", "Ljava/lang/String;", "getGrade_describe", "()Ljava/lang/String;", "Lpy/k;", "getNew_im_icon_with_level", "()Lpy/k;", "getNew_live_icon", "Lcom/bytedance/android/live/base/model/user/v;", "getBuff_info", "()Lcom/bytedance/android/live/base/model/user/v;", "Z", "getGrade_describe_shining", "()Z", "I", "getDescribe_type", "()I", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "getEffectType", "getShortDesc", "getShortPreDesc", "getJumpSchema", "getEffectImg", "getEffectDurationMilli", "getEffectPlayTimes", "getRecentConsumeBadge", "<init>", "(JJJJLjava/lang/String;Lpy/k;Lpy/k;Lcom/bytedance/android/live/base/model/user/v;ZILjava/util/Map;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lpy/k;IILpy/k;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PayGrade {
    private final v buff_info;
    private final int describe_type;
    private final int effectDurationMilli;
    private final k effectImg;
    private final int effectPlayTimes;
    private final int effectType;
    private final Map<String, String> extra;
    private final String grade_describe;
    private final boolean grade_describe_shining;
    private final String jumpSchema;
    private final long level;
    private final k new_im_icon_with_level;
    private final k new_live_icon;
    private final k recentConsumeBadge;
    private final long score;
    private final String shortDesc;
    private final String shortPreDesc;
    private final long this_grade_max_diamond;
    private final long this_grade_min_diamond;

    public PayGrade() {
        this(0, 0, 0, 0, null, null, null, null, false, 0, null, 0, null, null, null, null, 0, 0, null, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayGrade copy$default(PayGrade r110, long r111, long r210, long r211, long r212, String r213, k r214, k r215, v r216, boolean r310, int r311, Map r312, int r313, String r314, String r315, String r316, k r317, int r318, int r319, k r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        long r100 = r110.score;
    L7:
        if ((r411 & 2) == 0) goto L9;
        long r101 = r110.level;
    L11:
        if ((r411 & 4) == 0) goto L13;
        long r102 = r110.this_grade_min_diamond;
    L15:
        if ((r411 & 8) == 0) goto L17;
        long r103 = r110.this_grade_max_diamond;
    L19:
        if ((r411 & 16) == 0) goto L21;
        String r112 = r110.grade_describe;
    L23:
        if ((r411 & 32) == 0) goto L25;
        k r113 = r110.new_im_icon_with_level;
    L27:
        if ((r411 & 64) == 0) goto L29;
        k r114 = r110.new_live_icon;
    L31:
        if ((r411 & 128) == 0) goto L33;
        v r115 = r110.buff_info;
    L35:
        if ((r411 & 256) == 0) goto L37;
        boolean r116 = r110.grade_describe_shining;
    L39:
        if ((r411 & 512) == 0) goto L41;
        int r117 = r110.describe_type;
    L42:
        int r320 = r117;
        if ((r411 & 1024) == 0) goto L45;
        Map r118 = r110.extra;
    L46:
        Map r321 = r118;
        if ((r411 & 2048) == 0) goto L49;
        int r119 = r110.effectType;
    L50:
        int r322 = r119;
        if ((r411 & 4096) == 0) goto L53;
        String r120 = r110.shortDesc;
    L54:
        String r323 = r120;
        if ((r411 & 8192) == 0) goto L57;
        String r121 = r110.shortPreDesc;
    L58:
        String r324 = r121;
        if ((r411 & 16384) == 0) goto L61;
        String r122 = r110.jumpSchema;
    L62:
        String r325 = r122;
        if ((r411 & 32768) == 0) goto L65;
        k r123 = r110.effectImg;
    L66:
        k r326 = r123;
        if ((r411 & 65536) == 0) goto L69;
        int r124 = r110.effectDurationMilli;
    L70:
        int r327 = r124;
        if ((r411 & 131072) == 0) goto L73;
        int r125 = r110.effectPlayTimes;
    L75:
        if ((r411 & 262144) == 0) goto L77;
        k r104 = r110.recentConsumeBadge;
    L79:
        return r110.copy(r100, r101, r102, r103, r112, r113, r114, r115, r116, r320, r321, r322, r323, r324, r325, r326, r327, r125, r104);
    L77:
        r104 = r410;
        goto L79
    L73:
        r125 = r319;
        goto L75
    L69:
        r124 = r318;
        goto L70
    L65:
        r123 = r317;
        goto L66
    L61:
        r122 = r316;
        goto L62
    L57:
        r121 = r315;
        goto L58
    L53:
        r120 = r314;
        goto L54
    L49:
        r119 = r313;
        goto L50
    L45:
        r118 = r312;
        goto L46
    L41:
        r117 = r311;
        goto L42
    L37:
        r116 = r310;
        goto L39
    L33:
        r115 = r216;
        goto L35
    L29:
        r114 = r215;
        goto L31
    L25:
        r113 = r214;
        goto L27
    L21:
        r112 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.score;
    }

    public final int component10() {
        return this.describe_type;
    }

    public final Map<String, String> component11() {
        return this.extra;
    }

    public final int component12() {
        return this.effectType;
    }

    public final String component13() {
        return this.shortDesc;
    }

    public final String component14() {
        return this.shortPreDesc;
    }

    public final String component15() {
        return this.jumpSchema;
    }

    public final k component16() {
        return this.effectImg;
    }

    public final int component17() {
        return this.effectDurationMilli;
    }

    public final int component18() {
        return this.effectPlayTimes;
    }

    public final k component19() {
        return this.recentConsumeBadge;
    }

    public final long component2() {
        return this.level;
    }

    public final long component3() {
        return this.this_grade_min_diamond;
    }

    public final long component4() {
        return this.this_grade_max_diamond;
    }

    public final String component5() {
        return this.grade_describe;
    }

    public final k component6() {
        return this.new_im_icon_with_level;
    }

    public final k component7() {
        return this.new_live_icon;
    }

    public final v component8() {
        return this.buff_info;
    }

    public final boolean component9() {
        return this.grade_describe_shining;
    }

    public final PayGrade copy(long r210, long r211, long r310, long r311, String r312, k r313, k r314, v r315, boolean r316, int r317, Map<String, String> r410, int r411, String r412, String r413, String r414, k r415, int r416, int r417, k r418) {
        return new PayGrade(r210, r211, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PayGrade) == false) goto L44;
        PayGrade r101 = (PayGrade) r100;
        if (this.score == r101.score) goto L8;
        return false;
    L8:
        if (this.level == r101.level) goto L10;
        return false;
    L10:
        if (this.this_grade_min_diamond == r101.this_grade_min_diamond) goto L12;
        return false;
    L12:
        if (this.this_grade_max_diamond == r101.this_grade_max_diamond) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.grade_describe, r101.grade_describe) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.new_im_icon_with_level, r101.new_im_icon_with_level) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.new_live_icon, r101.new_live_icon) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.buff_info, r101.buff_info) == true) goto L22;
        return false;
    L22:
        if (this.grade_describe_shining == r101.grade_describe_shining) goto L24;
        return false;
    L24:
        if (this.describe_type == r101.describe_type) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L28;
        return false;
    L28:
        if (this.effectType == r101.effectType) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shortDesc, r101.shortDesc) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.shortPreDesc, r101.shortPreDesc) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.jumpSchema, r101.jumpSchema) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.effectImg, r101.effectImg) == true) goto L38;
        return false;
    L38:
        if (this.effectDurationMilli == r101.effectDurationMilli) goto L40;
        return false;
    L40:
        if (this.effectPlayTimes == r101.effectPlayTimes) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.recentConsumeBadge, r101.recentConsumeBadge) == true) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    public int hashCode() {
        long r100 = this.score;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.level;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.this_grade_min_diamond;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.this_grade_max_diamond;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.grade_describe;
        int r109 = 0;
        if (r108 == null) goto L5;
        int r110 = r108.hashCode();
    L6:
        int r111 = (r107 + r110) * 31;
        k r112 = this.new_im_icon_with_level;
        if (r112 == null) goto L9;
        int r113 = r112.hashCode();
    L10:
        int r114 = (r111 + r113) * 31;
        k r115 = this.new_live_icon;
        if (r115 == null) goto L13;
        int r116 = r115.hashCode();
    L14:
        int r117 = (r114 + r116) * 31;
        v r118 = this.buff_info;
        if (r118 == null) goto L17;
        int r119 = r118.hashCode();
    L18:
        int r120 = (r117 + r119) * 31;
        boolean r121 = this.grade_describe_shining;
        ?? r122 = r121;
        if (r121 == false) goto L21;
        r122 = 1;
    L21:
        int r123 = (((r120 + r122) * 31) + this.describe_type) * 31;
        Map<String, String> r124 = this.extra;
        if (r124 == null) goto L24;
        int r125 = r124.hashCode();
    L25:
        int r126 = (((r123 + r125) * 31) + this.effectType) * 31;
        String r127 = this.shortDesc;
        if (r127 == null) goto L28;
        int r128 = r127.hashCode();
    L29:
        int r129 = (r126 + r128) * 31;
        String r130 = this.shortPreDesc;
        if (r130 == null) goto L32;
        int r131 = r130.hashCode();
    L33:
        int r132 = (r129 + r131) * 31;
        String r133 = this.jumpSchema;
        if (r133 == null) goto L36;
        int r134 = r133.hashCode();
    L37:
        int r135 = (r132 + r134) * 31;
        k r136 = this.effectImg;
        if (r136 == null) goto L40;
        int r137 = r136.hashCode();
    L41:
        int r138 = (((((r135 + r137) * 31) + this.effectDurationMilli) * 31) + this.effectPlayTimes) * 31;
        k r139 = this.recentConsumeBadge;
        if (r139 == null) goto L45;
        r109 = r139.hashCode();
    L45:
        return r138 + r109;
    L40:
        r137 = 0;
        goto L41
    L36:
        r134 = 0;
        goto L37
    L32:
        r131 = 0;
        goto L33
    L28:
        r128 = 0;
        goto L29
    L24:
        r125 = 0;
        goto L25
    L17:
        r119 = 0;
        goto L18
    L13:
        r116 = 0;
        goto L14
    L9:
        r113 = 0;
        goto L10
    L5:
        r110 = 0;
        goto L6
    }

    public String toString() {
        return "PayGrade(score=" + this.score + ", level=" + this.level + ", this_grade_min_diamond=" + this.this_grade_min_diamond + ", this_grade_max_diamond=" + this.this_grade_max_diamond + ", grade_describe=" + this.grade_describe + ", new_im_icon_with_level=" + this.new_im_icon_with_level + ", new_live_icon=" + this.new_live_icon + ", buff_info=" + this.buff_info + ", grade_describe_shining=" + this.grade_describe_shining + ", describe_type=" + this.describe_type + ", extra=" + this.extra + ", effectType=" + this.effectType + ", shortDesc=" + this.shortDesc + ", shortPreDesc=" + this.shortPreDesc + ", jumpSchema=" + this.jumpSchema + ", effectImg=" + this.effectImg + ", effectDurationMilli=" + this.effectDurationMilli + ", effectPlayTimes=" + this.effectPlayTimes + ", recentConsumeBadge=" + this.recentConsumeBadge + ")";
    }

    public final v getBuff_info() {
        return this.buff_info;
    }

    public final int getDescribe_type() {
        return this.describe_type;
    }

    public final int getEffectDurationMilli() {
        return this.effectDurationMilli;
    }

    public final k getEffectImg() {
        return this.effectImg;
    }

    public final int getEffectPlayTimes() {
        return this.effectPlayTimes;
    }

    public final int getEffectType() {
        return this.effectType;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final String getGrade_describe() {
        return this.grade_describe;
    }

    public final boolean getGrade_describe_shining() {
        return this.grade_describe_shining;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final long getLevel() {
        return this.level;
    }

    public final k getNew_im_icon_with_level() {
        return this.new_im_icon_with_level;
    }

    public final k getNew_live_icon() {
        return this.new_live_icon;
    }

    public final k getRecentConsumeBadge() {
        return this.recentConsumeBadge;
    }

    public final long getScore() {
        return this.score;
    }

    public final String getShortDesc() {
        return this.shortDesc;
    }

    public final String getShortPreDesc() {
        return this.shortPreDesc;
    }

    public final long getThis_grade_max_diamond() {
        return this.this_grade_max_diamond;
    }

    public final long getThis_grade_min_diamond() {
        return this.this_grade_min_diamond;
    }

    public PayGrade(long r100, long r101, long r102, long r110, String r111, k r112, k r113, v r114, boolean r115, int r116, Map<String, String> r117, int r118, String r210, String r211, String r212, k r213, int r214, int r215, k r216) {
        this.score = r100;
        this.level = r101;
        this.this_grade_min_diamond = r102;
        this.this_grade_max_diamond = r110;
        this.grade_describe = r111;
        this.new_im_icon_with_level = r112;
        this.new_live_icon = r113;
        this.buff_info = r114;
        this.grade_describe_shining = r115;
        this.describe_type = r116;
        this.extra = r117;
        this.effectType = r118;
        this.shortDesc = r210;
        this.shortPreDesc = r211;
        this.jumpSchema = r212;
        this.effectImg = r213;
        this.effectDurationMilli = r214;
        this.effectPlayTimes = r215;
        this.recentConsumeBadge = r216;
    }

    public /* synthetic */ PayGrade(long r210, long r211, long r212, long r310, String r311, k r312, k r313, v r314, boolean r315, int r316, Map r317, int r318, String r410, String r411, String r412, k r413, int r414, int r415, k r416, int r417, DefaultConstructorMarker r418) {
        long r100 = 0;
        if ((r417 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r417 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r417 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r417 & 8) != 0) goto L19;
        r100 = r310;
    L19:
        if ((r417 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r417 & 32) == 0) goto L25;
        k r110 = null;
    L27:
        if ((r417 & 64) == 0) goto L29;
        k r111 = null;
    L31:
        if ((r417 & 128) == 0) goto L33;
        v r112 = null;
    L35:
        if ((r417 & 256) == 0) goto L37;
        boolean r113 = false;
    L39:
        if ((r417 & 512) == 0) goto L41;
        int r114 = 0;
    L43:
        if ((r417 & 1024) == 0) goto L45;
        Map r115 = null;
    L46:
        Map r419 = r115;
        if ((r417 & 2048) == 0) goto L49;
        int r116 = 0;
    L50:
        int r117 = r116;
        if ((r417 & 4096) == 0) goto L53;
        String r118 = null;
    L54:
        String r119 = r118;
        if ((r417 & 8192) == 0) goto L57;
        String r120 = null;
    L58:
        String r121 = r120;
        if ((r417 & 16384) == 0) goto L61;
        String r122 = null;
    L63:
        if ((r417 & 32768) == 0) goto L65;
        k r123 = null;
    L67:
        if ((r417 & 65536) == 0) goto L69;
        int r213 = 0;
    L71:
        if ((r417 & 131072) == 0) goto L73;
        int r214 = 0;
    L75:
        if ((r417 & 262144) == 0) goto L77;
        k r105 = null;
    L78:
        this(r101, r102, r103, r100, r104, r110, r111, r112, r113, r114, r419, r117, r119, r121, r122, r123, r213, r214, r105);
        return;
    L77:
        r105 = r416;
        goto L78
    L73:
        r214 = r415;
        goto L75
    L69:
        r213 = r414;
        goto L71
    L65:
        r123 = r413;
        goto L67
    L61:
        r122 = r412;
        goto L63
    L57:
        r120 = r411;
        goto L58
    L53:
        r118 = r410;
        goto L54
    L49:
        r116 = r318;
        goto L50
    L45:
        r115 = r317;
        goto L46
    L41:
        r114 = r316;
        goto L43
    L37:
        r113 = r315;
        goto L39
    L33:
        r112 = r314;
        goto L35
    L29:
        r111 = r313;
        goto L31
    L25:
        r110 = r312;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L13:
        r103 = r212;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
