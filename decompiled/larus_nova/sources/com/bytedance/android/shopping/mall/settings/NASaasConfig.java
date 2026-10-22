package com.bytedance.android.shopping.mall.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/mall/settings/NASaasConfig;", "Ljava/io/Serializable;", "", "enableFirstScreenStraightOut", "", "naBundleConfigUrl", "Ljava/lang/String;", "getNaBundleConfigUrl", "()Ljava/lang/String;", "naGeckoChannel", "getNaGeckoChannel", "", "naFirstScreenRender", "I", "getNaFirstScreenRender", "()I", "mallStraightOutSync", "getMallStraightOutSync", "mallBundleConfigPreload", "Z", "getMallBundleConfigPreload", "()Z", "disableBuiltin", "getDisableBuiltin", "pageCardDelayInit", "getPageCardDelayInit", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NASaasConfig implements Serializable {
    public static final a Companion = null;
    public static final String DEFAULT = "{\n  \"native_mall_bundle_config_url\": \"https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_mall_cards_toutiao/config.json\",\n  \"mall_gecko_channel\": \"ecom_mall_cards_toutiao\",\n  \"mall_enable_first_screen_render\": 1\n}";

    @SerializedName("native_mall_bundle_config_disable_builtin")
    private final boolean disableBuiltin;

    @SerializedName("native_mall_bundle_config_preload")
    private final boolean mallBundleConfigPreload;

    @SerializedName("mall_enable_straight_out_sync")
    private final int mallStraightOutSync;

    @SerializedName("native_mall_bundle_config_url")
    private final String naBundleConfigUrl;

    @SerializedName("mall_enable_first_screen_render")
    private final int naFirstScreenRender;

    @SerializedName("mall_gecko_channel")
    private final String naGeckoChannel;

    @SerializedName("native_mall_page_card_delay")
    private final int pageCardDelayInit;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean enableFirstScreenStraightOut() {
        if (this.naFirstScreenRender != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public NASaasConfig() {
        this.naFirstScreenRender = 1;
    }

    public final boolean getDisableBuiltin() {
        return this.disableBuiltin;
    }

    public final boolean getMallBundleConfigPreload() {
        return this.mallBundleConfigPreload;
    }

    public final int getMallStraightOutSync() {
        return this.mallStraightOutSync;
    }

    public final String getNaBundleConfigUrl() {
        return this.naBundleConfigUrl;
    }

    public final int getNaFirstScreenRender() {
        return this.naFirstScreenRender;
    }

    public final String getNaGeckoChannel() {
        return this.naGeckoChannel;
    }

    public final int getPageCardDelayInit() {
        return this.pageCardDelayInit;
    }
}
