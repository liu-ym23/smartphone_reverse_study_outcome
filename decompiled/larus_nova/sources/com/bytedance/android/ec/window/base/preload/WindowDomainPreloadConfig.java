package com.bytedance.android.ec.window.base.preload;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/window/base/preload/WindowDomainPreloadConfig;", "Ljava/io/Serializable;", "()V", "shopCoreHost", "", "", "getShopCoreHost", "()Ljava/util/List;", "setShopCoreHost", "(Ljava/util/List;)V", "shopPicHost", "getShopPicHost", "setShopPicHost", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowDomainPreloadConfig implements Serializable {

    @SerializedName("shop_core_host")
    private List<String> shopCoreHost;

    @SerializedName("shop_pic_host")
    private List<String> shopPicHost;

    public WindowDomainPreloadConfig() {
    }

    public final List<String> getShopCoreHost() {
        return this.shopCoreHost;
    }

    public final List<String> getShopPicHost() {
        return this.shopPicHost;
    }

    public final void setShopCoreHost(List<String> r100) {
        this.shopCoreHost = r100;
    }

    public final void setShopPicHost(List<String> r100) {
        this.shopPicHost = r100;
    }
}
