package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R6\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR4\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/c2;", "", "", "", "", "Ljava/lang/Object;", "gameAttrConfig", "Ljava/util/List;", "getGameAttrConfig", "()Ljava/util/List;", "setGameAttrConfig", "(Ljava/util/List;)V", "gameInfoConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGameInfoConfig", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c2 {

    @SerializedName("game_attr_config")
    private List<? extends Map<String, ? extends Object>> gameAttrConfig;

    @SerializedName("game_info_config")
    private List<? extends Map<String, ? extends Object>> gameInfoConfig;

    public c2() {
        Boolean r100 = Boolean.TRUE;
        this.gameInfoConfig = CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("key", EventConstants.ExtraJson.GAME_NAME), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "android_package_version"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "android_package_name"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "ios_bundle_id"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", BdpAppEventConstant.PARAMS_GAME_CATEGORY), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "ios_app_store_id"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "developer"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", HianalyticsBaseData.SDK_TYPE), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "sdk_version"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "is_biz"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "biz_type"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "biz_extra"), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", IPerformanceManager.MODULE_LIVE_GAME_PLATFORM), TuplesKt.to("report_enable", r100)}), MapsKt.mapOf(new Pair[]{TuplesKt.to("key", "settle_cloud"), TuplesKt.to("report_enable", r100)})});
    }

    public final List<Map<String, Object>> a() {
        return this.gameInfoConfig;
    }
}
