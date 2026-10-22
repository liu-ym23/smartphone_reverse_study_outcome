package com.bytedance.android.ec.store.preload;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/store/preload/ShopImagePreloadConfig;", "Ljava/io/Serializable;", "()V", "firstScreenCount", "", "getFirstScreenCount", "()Ljava/lang/Integer;", "setFirstScreenCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "loadMoreCount", "getLoadMoreCount", "setLoadMoreCount", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopImagePreloadConfig implements Serializable {

    @SerializedName("preload_image_num_first_screen")
    private Integer firstScreenCount;

    @SerializedName("preload_image_num_load_more")
    private Integer loadMoreCount;

    public ShopImagePreloadConfig() {
    }

    public final Integer getFirstScreenCount() {
        return this.firstScreenCount;
    }

    public final Integer getLoadMoreCount() {
        return this.loadMoreCount;
    }

    public final void setFirstScreenCount(Integer r100) {
        this.firstScreenCount = r100;
    }

    public final void setLoadMoreCount(Integer r100) {
        this.loadMoreCount = r100;
    }
}
