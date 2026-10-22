package com.bytedance.android.shopping.api.mall.homepage;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/homepage/ECMallBackgroundGradientConfig;", "Ljava/io/Serializable;", "", "", "colors", "Ljava/util/List;", "getColors", "()Ljava/util/List;", "setColors", "(Ljava/util/List;)V", "", "locations", "getLocations", "setLocations", "startPoint", "getStartPoint", "setStartPoint", "endPoint", "getEndPoint", "setEndPoint", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "Ljava/lang/Float;", "getRatio", "()Ljava/lang/Float;", "setRatio", "(Ljava/lang/Float;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallBackgroundGradientConfig implements Serializable {
    public static final a Companion = null;
    public static final String ENABLE_KEY = "ec_mall_gradient_background_enable";

    @SerializedName("colors")
    private List<String> colors;

    @SerializedName("end_point")
    private List<Float> endPoint;

    @SerializedName("locations")
    private List<Float> locations;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private Float ratio;

    @SerializedName("start_point")
    private List<Float> startPoint;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECMallBackgroundGradientConfig() {
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final List<Float> getEndPoint() {
        return this.endPoint;
    }

    public final List<Float> getLocations() {
        return this.locations;
    }

    public final Float getRatio() {
        return this.ratio;
    }

    public final List<Float> getStartPoint() {
        return this.startPoint;
    }

    public final void setColors(List<String> r100) {
        this.colors = r100;
    }

    public final void setEndPoint(List<Float> r100) {
        this.endPoint = r100;
    }

    public final void setLocations(List<Float> r100) {
        this.locations = r100;
    }

    public final void setRatio(Float r100) {
        this.ratio = r100;
    }

    public final void setStartPoint(List<Float> r100) {
        this.startPoint = r100;
    }
}
