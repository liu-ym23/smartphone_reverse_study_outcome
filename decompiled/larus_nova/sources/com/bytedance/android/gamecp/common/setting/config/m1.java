package com.bytedance.android.gamecp.common.setting.config;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R4\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/m1;", "", "", "", "style", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m1 {

    @SerializedName("style")
    private final Map<String, Map<String, String>> style;

    public m1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m1) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.style, ((m1) r100).style) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, Map<String, String>> r100 = this.style;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GameMountContainerConfig(style=" + this.style + ")";
    }

    public final Map<String, Map<String, String>> a() {
        return this.style;
    }

    public m1(Object r110) {
        this.style = MapsKt.mapOf(new Pair[]{TuplesKt.to("1", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "popup"), TuplesKt.to(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom"), TuplesKt.to("height", "5000"), TuplesKt.to(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR, "black"), TuplesKt.to(AppConstants.TRANS_STATUS_BAR, "1"), TuplesKt.to("hide_status_bar", "0")})), TuplesKt.to("2", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "fullscreen"), TuplesKt.to(AppConstants.TRANS_STATUS_BAR, "1"), TuplesKt.to(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom"), TuplesKt.to(AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR, "black"), TuplesKt.to("hide_status_bar", "0"), TuplesKt.to("hide_nav_bar", "1"), TuplesKt.to("web_bg_color", "#FFFFFFFF"), TuplesKt.to(ECFindSimilarConfig.HEIGHT_PERCENT, "100"), TuplesKt.to("enable_preload", PullConfiguration.PROCESS_NAME_MAIN)})), TuplesKt.to("5", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "popup"), TuplesKt.to(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom"), TuplesKt.to("rate_height", "593"), TuplesKt.to("radius", "12"), TuplesKt.to("disable_input_scroll", "1")}))});
    }
}
