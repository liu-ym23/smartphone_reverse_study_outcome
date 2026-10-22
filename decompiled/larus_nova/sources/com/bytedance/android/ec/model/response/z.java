package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/z;", "", "", "carouselTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setCarouselTime", "(J)V", "", "Lcom/bytedance/android/ec/model/response/ECCarouselData;", "data", "Ljava/util/List;", "b", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/model/response/ECSalePointDataV2;", "dataV2", "c", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("carousel_time")
    private long carouselTime;

    @SerializedName("data")
    private List<ECCarouselData> data;

    @SerializedName("data_v2")
    private final List<ECSalePointDataV2> dataV2;

    public z() {
    }

    public final long a() {
        return this.carouselTime;
    }

    public final List<ECCarouselData> b() {
        return this.data;
    }

    public final List<ECSalePointDataV2> c() {
        return this.dataV2;
    }
}
