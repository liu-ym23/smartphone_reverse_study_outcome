package com.bytedance.android.gamecp.common.setting.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001aR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001c\u0010\"\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u001c\u0010$\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013R\u001c\u0010&\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u001c\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u001d\u001a\u0004\b.\u0010\u001fR\"\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007R\"\u00102\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R\u001c\u00104\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b5\u0010\u0013R\u001c\u00106\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013R\u001c\u00108\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u001d\u001a\u0004\b9\u0010\u001fR\u001c\u0010:\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001fR\u001c\u0010<\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u0011\u001a\u0004\b=\u0010\u0013R\u001c\u0010>\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010?\u001a\u0004\bC\u0010AR\u001c\u0010D\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010*\u001a\u0004\bE\u0010,R\u001c\u0010F\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013R(\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020I\u0018\u00010H8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010\u001d\u001a\u0004\bO\u0010\u001f¨\u0006P"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/d;", "", "", "", "airCompressWhiteGameIdList", "Ljava/util/List;", "q", "()Ljava/util/List;", "", "airCompressWhiteGameListEnable", "Z", "r", "()Z", "airCompressBlackGameIdList", "p", "isHandleAirCompressFirst", "acCheckSumEnable", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "", "acDeviceScore", "Ljava/lang/Float;", "getAcDeviceScore", "()Ljava/lang/Float;", "acAbTestSwitch", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "acPluginInitRetryCnt", "Ljava/lang/Integer;", "l", "()Ljava/lang/Integer;", "acPluginInitSwitch", "m", "installAppRestoreSwitch", "t", "controlGroupUrlSwitch", "getControlGroupUrlSwitch", "checkSumTrackingSwitch", "s", "", "restoreTimeout", "Ljava/lang/Long;", BaseSwitches.V, "()Ljava/lang/Long;", "restoreFailRetryCnt", "u", "Lcom/bytedance/android/gamecp/common/setting/config/o0;", "acWhiteList", "o", "acBlackList", "b", "acWhiteBlackSwitch", OfficeSDKRequestTag.KEY_NEW_USER, "acGetPackageInfoSwitch", "h", "acCheckInterval", "c", "acMaxCheckCount", RXScreenCaptureService.KEY_INDEX, "acDeleteTargetApk", "e", "acTempSuffix", "Ljava/lang/String;", "getAcTempSuffix", "()Ljava/lang/String;", "acReplaceSuffix", "getAcReplaceSuffix", "acPluginInitCount", ce.f26395j, "acPluginInitOptEnable", ce.f26396k, "", "Lcom/bytedance/android/gamecp/common/setting/config/e;", "acExp4PWhiteConfig", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "acExp4P", "f", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("ac_ab_test_switch")
    private final Boolean acAbTestSwitch;

    @SerializedName("ac_black_list")
    private final List<o0> acBlackList;

    @SerializedName("ac_fd_check_interval")
    private final Integer acCheckInterval;

    @SerializedName("ac_check_sum_enable")
    private final Boolean acCheckSumEnable;

    @SerializedName("ac_delete_target_apk")
    private final Boolean acDeleteTargetApk;

    @SerializedName("ac_device_score")
    private final Float acDeviceScore;

    @SerializedName("ac_exp4p_white_config_strategy")
    private final Integer acExp4P;

    @SerializedName("ac_exp4p_white_config")
    private final Map<String, e> acExp4PWhiteConfig;

    @SerializedName("ac_get_package_info_switch")
    private final Boolean acGetPackageInfoSwitch;

    @SerializedName("ac_max_fd_check_count")
    private final Integer acMaxCheckCount;

    @SerializedName("ac_plugin_init_count")
    private final Long acPluginInitCount;

    @SerializedName("ac_plugin_init_opt_enable")
    private final Boolean acPluginInitOptEnable;

    @SerializedName("ac_plugin_init_retry_cnt")
    private final Integer acPluginInitRetryCnt;

    @SerializedName("ac_plugin_init_switch")
    private final Boolean acPluginInitSwitch;

    @SerializedName("ac_replace_suffix")
    private final String acReplaceSuffix;

    @SerializedName("ac_temp_suffix")
    private final String acTempSuffix;

    @SerializedName("ac_white_black_switch")
    private final Boolean acWhiteBlackSwitch;

    @SerializedName("ac_white_list")
    private final List<o0> acWhiteList;

    @SerializedName("air_compress_black_game_id_list")
    private final List<String> airCompressBlackGameIdList;

    @SerializedName("air_compress_game_id_list")
    private final List<String> airCompressWhiteGameIdList;

    @SerializedName("air_compress_game_white_list_enable")
    private final boolean airCompressWhiteGameListEnable;

    @SerializedName("checksum_tracking_switch")
    private final Boolean checkSumTrackingSwitch;

    @SerializedName("control_group_url_switch")
    private final Boolean controlGroupUrlSwitch;

    @SerializedName("install_app_restore_switch")
    private final Boolean installAppRestoreSwitch;

    @SerializedName("is_handle_air_compress_first")
    private final boolean isHandleAirCompressFirst;

    @SerializedName("restore_fail_retry_cnt")
    private final Integer restoreFailRetryCnt;

    @SerializedName("restore_timeout")
    private final Long restoreTimeout;

    public static final class a {
    }

    static {
    }

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L60;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.airCompressWhiteGameIdList, r101.airCompressWhiteGameIdList) == true) goto L8;
        return false;
    L8:
        if (this.airCompressWhiteGameListEnable == r101.airCompressWhiteGameListEnable) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.airCompressBlackGameIdList, r101.airCompressBlackGameIdList) == true) goto L12;
        return false;
    L12:
        if (this.isHandleAirCompressFirst == r101.isHandleAirCompressFirst) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.acCheckSumEnable, r101.acCheckSumEnable) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.acDeviceScore, r101.acDeviceScore) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.acAbTestSwitch, r101.acAbTestSwitch) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.acPluginInitRetryCnt, r101.acPluginInitRetryCnt) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.acPluginInitSwitch, r101.acPluginInitSwitch) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.installAppRestoreSwitch, r101.installAppRestoreSwitch) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.controlGroupUrlSwitch, r101.controlGroupUrlSwitch) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.checkSumTrackingSwitch, r101.checkSumTrackingSwitch) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.restoreTimeout, r101.restoreTimeout) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.restoreFailRetryCnt, r101.restoreFailRetryCnt) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.acWhiteList, r101.acWhiteList) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.acBlackList, r101.acBlackList) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.acWhiteBlackSwitch, r101.acWhiteBlackSwitch) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.acGetPackageInfoSwitch, r101.acGetPackageInfoSwitch) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.acCheckInterval, r101.acCheckInterval) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.acMaxCheckCount, r101.acMaxCheckCount) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.acDeleteTargetApk, r101.acDeleteTargetApk) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.acTempSuffix, r101.acTempSuffix) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.acReplaceSuffix, r101.acReplaceSuffix) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.acPluginInitCount, r101.acPluginInitCount) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.acPluginInitOptEnable, r101.acPluginInitOptEnable) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.acExp4PWhiteConfig, r101.acExp4PWhiteConfig) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.acExp4P, r101.acExp4P) == true) goto L91;
        return false;
    L91:
        return true;
    L60:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        List<String> r100 = this.airCompressWhiteGameIdList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.airCompressWhiteGameListEnable;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        List<String> r108 = this.airCompressBlackGameIdList;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.isHandleAirCompressFirst;
        if (r111 == true) goto L17;
        r105 = r111;
    L17:
        int r112 = (r110 + r105) * 31;
        Boolean r113 = this.acCheckSumEnable;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.acDeviceScore;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.acAbTestSwitch;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.acPluginInitRetryCnt;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.acPluginInitSwitch;
        if (r125 == null) goto L36;
        int r126 = r125.hashCode();
    L37:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.installAppRestoreSwitch;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.controlGroupUrlSwitch;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.checkSumTrackingSwitch;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.restoreTimeout;
        if (r137 == null) goto L52;
        int r138 = r137.hashCode();
    L53:
        int r139 = (r136 + r138) * 31;
        Integer r140 = this.restoreFailRetryCnt;
        if (r140 == null) goto L56;
        int r141 = r140.hashCode();
    L57:
        int r142 = (r139 + r141) * 31;
        List<o0> r143 = this.acWhiteList;
        if (r143 == null) goto L60;
        int r144 = r143.hashCode();
    L61:
        int r145 = (r142 + r144) * 31;
        List<o0> r146 = this.acBlackList;
        if (r146 == null) goto L64;
        int r147 = r146.hashCode();
    L65:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.acWhiteBlackSwitch;
        if (r149 == null) goto L68;
        int r150 = r149.hashCode();
    L69:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.acGetPackageInfoSwitch;
        if (r152 == null) goto L72;
        int r153 = r152.hashCode();
    L73:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.acCheckInterval;
        if (r155 == null) goto L76;
        int r156 = r155.hashCode();
    L77:
        int r157 = (r154 + r156) * 31;
        Integer r158 = this.acMaxCheckCount;
        if (r158 == null) goto L80;
        int r159 = r158.hashCode();
    L81:
        int r160 = (r157 + r159) * 31;
        Boolean r161 = this.acDeleteTargetApk;
        if (r161 == null) goto L84;
        int r162 = r161.hashCode();
    L85:
        int r163 = (r160 + r162) * 31;
        String r164 = this.acTempSuffix;
        if (r164 == null) goto L88;
        int r165 = r164.hashCode();
    L89:
        int r166 = (r163 + r165) * 31;
        String r167 = this.acReplaceSuffix;
        if (r167 == null) goto L92;
        int r168 = r167.hashCode();
    L93:
        int r169 = (r166 + r168) * 31;
        Long r170 = this.acPluginInitCount;
        if (r170 == null) goto L96;
        int r171 = r170.hashCode();
    L97:
        int r172 = (r169 + r171) * 31;
        Boolean r173 = this.acPluginInitOptEnable;
        if (r173 == null) goto L100;
        int r174 = r173.hashCode();
    L101:
        int r175 = (r172 + r174) * 31;
        Map<String, e> r176 = this.acExp4PWhiteConfig;
        if (r176 == null) goto L104;
        int r177 = r176.hashCode();
    L105:
        int r178 = (r175 + r177) * 31;
        Integer r179 = this.acExp4P;
        if (r179 == null) goto L109;
        r101 = r179.hashCode();
    L109:
        return r178 + r101;
    L104:
        r177 = 0;
        goto L105
    L100:
        r174 = 0;
        goto L101
    L96:
        r171 = 0;
        goto L97
    L92:
        r168 = 0;
        goto L93
    L88:
        r165 = 0;
        goto L89
    L84:
        r162 = 0;
        goto L85
    L80:
        r159 = 0;
        goto L81
    L76:
        r156 = 0;
        goto L77
    L72:
        r153 = 0;
        goto L73
    L68:
        r150 = 0;
        goto L69
    L64:
        r147 = 0;
        goto L65
    L60:
        r144 = 0;
        goto L61
    L56:
        r141 = 0;
        goto L57
    L52:
        r138 = 0;
        goto L53
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L36:
        r126 = 0;
        goto L37
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AirCompressConfig(airCompressWhiteGameIdList=" + this.airCompressWhiteGameIdList + ", airCompressWhiteGameListEnable=" + this.airCompressWhiteGameListEnable + ", airCompressBlackGameIdList=" + this.airCompressBlackGameIdList + ", isHandleAirCompressFirst=" + this.isHandleAirCompressFirst + ", acCheckSumEnable=" + this.acCheckSumEnable + ", acDeviceScore=" + this.acDeviceScore + ", acAbTestSwitch=" + this.acAbTestSwitch + ", acPluginInitRetryCnt=" + this.acPluginInitRetryCnt + ", acPluginInitSwitch=" + this.acPluginInitSwitch + ", installAppRestoreSwitch=" + this.installAppRestoreSwitch + ", controlGroupUrlSwitch=" + this.controlGroupUrlSwitch + ", checkSumTrackingSwitch=" + this.checkSumTrackingSwitch + ", restoreTimeout=" + this.restoreTimeout + ", restoreFailRetryCnt=" + this.restoreFailRetryCnt + ", acWhiteList=" + this.acWhiteList + ", acBlackList=" + this.acBlackList + ", acWhiteBlackSwitch=" + this.acWhiteBlackSwitch + ", acGetPackageInfoSwitch=" + this.acGetPackageInfoSwitch + ", acCheckInterval=" + this.acCheckInterval + ", acMaxCheckCount=" + this.acMaxCheckCount + ", acDeleteTargetApk=" + this.acDeleteTargetApk + ", acTempSuffix=" + this.acTempSuffix + ", acReplaceSuffix=" + this.acReplaceSuffix + ", acPluginInitCount=" + this.acPluginInitCount + ", acPluginInitOptEnable=" + this.acPluginInitOptEnable + ", acExp4PWhiteConfig=" + this.acExp4PWhiteConfig + ", acExp4P=" + this.acExp4P + ")";
    }

    public final Boolean a() {
        return this.acAbTestSwitch;
    }

    public final List<o0> b() {
        return this.acBlackList;
    }

    public final Integer c() {
        return this.acCheckInterval;
    }

    public final Boolean d() {
        return this.acCheckSumEnable;
    }

    public final Boolean e() {
        return this.acDeleteTargetApk;
    }

    public final Integer f() {
        return this.acExp4P;
    }

    public final Map<String, e> g() {
        return this.acExp4PWhiteConfig;
    }

    public final Boolean h() {
        return this.acGetPackageInfoSwitch;
    }

    public final Integer i() {
        return this.acMaxCheckCount;
    }

    public final Long j() {
        return this.acPluginInitCount;
    }

    public final Boolean k() {
        return this.acPluginInitOptEnable;
    }

    public final Integer l() {
        return this.acPluginInitRetryCnt;
    }

    public final Boolean m() {
        return this.acPluginInitSwitch;
    }

    public final Boolean n() {
        return this.acWhiteBlackSwitch;
    }

    public final List<o0> o() {
        return this.acWhiteList;
    }

    public final List<String> p() {
        return this.airCompressBlackGameIdList;
    }

    public final List<String> q() {
        return this.airCompressWhiteGameIdList;
    }

    public final boolean r() {
        return this.airCompressWhiteGameListEnable;
    }

    public final Boolean s() {
        return this.checkSumTrackingSwitch;
    }

    public final Boolean t() {
        return this.installAppRestoreSwitch;
    }

    public final Integer u() {
        return this.restoreFailRetryCnt;
    }

    public final Long v() {
        return this.restoreTimeout;
    }

    public d(Object r110) {
        ArrayList r100 = CollectionsKt.arrayListOf(new String[]{"cg2f99d58a22c3fec8", "cgmocn000000001000046467", "cgb92d480e85694bab", "cgmocn000000000003024347", "cgm-e0fd4828dcc3afbc", "cgxxcn000000000003166139", "cgmocn000000000003050522", "cgmocn000000000007114000", "cgm-72d5b2697550ec10", "cgmocn000000001000010353", "cg4658af1b97456328"});
        ArrayList r101 = new ArrayList();
        Boolean r102 = Boolean.FALSE;
        Float r103 = Float.valueOf(8.0f);
        ArrayList r111 = new ArrayList();
        ArrayList r112 = new ArrayList();
        Boolean r113 = Boolean.TRUE;
        this.airCompressWhiteGameIdList = r100;
        this.airCompressWhiteGameListEnable = true;
        this.airCompressBlackGameIdList = r101;
        this.isHandleAirCompressFirst = false;
        this.acCheckSumEnable = r102;
        this.acDeviceScore = r103;
        this.acAbTestSwitch = r102;
        this.acPluginInitRetryCnt = 1;
        this.acPluginInitSwitch = r102;
        this.installAppRestoreSwitch = r102;
        this.controlGroupUrlSwitch = r102;
        this.checkSumTrackingSwitch = r102;
        this.restoreTimeout = 300000L;
        this.restoreFailRetryCnt = 0;
        this.acWhiteList = r111;
        this.acBlackList = r112;
        this.acWhiteBlackSwitch = r102;
        this.acGetPackageInfoSwitch = r102;
        this.acCheckInterval = 0;
        this.acMaxCheckCount = 0;
        this.acDeleteTargetApk = r102;
        this.acTempSuffix = ".tp";
        this.acReplaceSuffix = "";
        this.acPluginInitCount = 1L;
        this.acPluginInitOptEnable = r113;
        this.acExp4PWhiteConfig = null;
        this.acExp4P = 0;
    }
}
