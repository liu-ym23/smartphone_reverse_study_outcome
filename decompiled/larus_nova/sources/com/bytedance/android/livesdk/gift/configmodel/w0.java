package com.bytedance.android.livesdk.gift.configmodel;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R:\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/w0;", "", "", "enable", "Z", "b", "()Z", "enableRecommendFastGift", "d", "enableRecommendCombo", "c", "removeSelectTypeChangeOpt", ce.f26395j, "recommendTopicDefaultShow", RXScreenCaptureService.KEY_INDEX, "", "comboRecommendPageSchema", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "fastGiftSupportScene", "Ljava/util/HashMap;", "h", "()Ljava/util/HashMap;", "", "fastGiftRecommendDuration", "J", "f", "()J", "enableResort", "e", "", "fastGiftRecommendScene", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w0 {

    @SerializedName("combo_recommend_page_schema")
    private final String comboRecommendPageSchema;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_recommend_combo")
    private final boolean enableRecommendCombo;

    @SerializedName("enable_recommend_fast_gift")
    private final boolean enableRecommendFastGift;

    @SerializedName("enable_resort")
    private final boolean enableResort;

    @SerializedName("fast_gift_recommend_duration")
    private final long fastGiftRecommendDuration;

    @SerializedName("speedy_gift_scene")
    private final List<String> fastGiftRecommendScene;

    @SerializedName("fast_gift_support_scene")
    private final HashMap<String, String> fastGiftSupportScene;

    @SerializedName("recommend_topic_default_show")
    private final boolean recommendTopicDefaultShow;

    @SerializedName("remove_select_type_change_opt")
    private final boolean removeSelectTypeChangeOpt;

    public w0() {
        this.comboRecommendPageSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_interactive_gift_lynx_douyin%2Fpages%2Fbig_gift_combo%2Ftemplate.js";
        this.fastGiftSupportScene = new HashMap();
        this.fastGiftRecommendDuration = 10000;
        this.fastGiftRecommendScene = CollectionsKt.listOf("broadcast_precision");
    }

    public final String a() {
        return this.comboRecommendPageSchema;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableRecommendCombo;
    }

    public final boolean d() {
        return this.enableRecommendFastGift;
    }

    public final boolean e() {
        return this.enableResort;
    }

    public final long f() {
        return this.fastGiftRecommendDuration;
    }

    public final List<String> g() {
        return this.fastGiftRecommendScene;
    }

    public final HashMap<String, String> h() {
        return this.fastGiftSupportScene;
    }

    public final boolean i() {
        return this.recommendTopicDefaultShow;
    }

    public final boolean j() {
        return this.removeSelectTypeChangeOpt;
    }
}
