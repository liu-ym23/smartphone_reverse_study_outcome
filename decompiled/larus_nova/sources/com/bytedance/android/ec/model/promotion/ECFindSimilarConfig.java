package com.bytedance.android.ec.model.promotion;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECFindSimilarConfig;", "Ljava/io/Serializable;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "schema", "getSchema", "schemaParamsType", "getSchemaParamsType", "", "type", "I", "getType", "()I", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECFindSimilarConfig implements Serializable {
    public static final a Companion = null;
    public static final String ENTER_FROM_SECOND = "enter_from_second";
    public static final String ENTER_FROM_VALUE = "live_sold_out_find_similar";
    public static final String FLOAT_SCREEN_HEIGHT = "float_screen";
    public static final String HEIGHT_PERCENT = "height_percent";
    public static final String PHOTO_SEARCH_PREVIOUS_PAGE = "photo_search_previous_page";
    public static final String PREVIOUS_PAGE_VALUE = "live_sold_out_page";
    public static final String SEARCH_IMAGE_URL = "search_image_url";
    public static final String SEARCH_PASSTHROUGH_PARAMS = "search_passthrough_params";
    public static final String SEARCH_SCAN_PARAMS = "search_scan_params";

    @SerializedName("schema")
    private final String schema;

    @SerializedName("schema_params_type")
    private final String schemaParamsType;

    @SerializedName("title")
    private final String title;

    @SerializedName("type")
    private final int type;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECFindSimilarConfig() {
        this.title = "找相似";
        this.schema = "sslocal://webcast_webview?type=popup&web_bg_color=%23FFFFFF&url=https%3A%2F%2Fffh.jinritemai.com%2Frender%2Fecommerce_mall_similar_find%2Findex.html%3F__pia_manifest__%3D%257B%2522worker%2522%253Atrue%252C%2522page_name%2522%253A%2522index%2522%252C%2522public_path%2522%253A%2522https%253A%252F%252Flf-webcast-sourcecdn-tos.bytegecko.com%252Fobj%252Fbyte-gurd-source%252F10181%252Fgecko%252Fresource%252Fecommerce_mall_similar_find%252F%2522%257D%26enter_from%3Dlive_list_card%26product_id%3D123456%26half_screen%3D1%26disable_slide_fetch%3D1%26next_page_half%3D1%26show_same_shop_rec%3D1%26show_mall_entrance%3D1&hide_nav_bar=1&title=%E6%89%BE%E7%9B%B8%E4%BC%BC&status_bar_color=black&status_font_dark=1&trans_status_bar=1&use_wk_falcon=1&use_pia=1&gravity=bottom&height_percent=73&add_safe_area_height=0&use_real_screen_height=1";
        this.schemaParamsType = "find_similar";
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getSchemaParamsType() {
        return this.schemaParamsType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }
}
