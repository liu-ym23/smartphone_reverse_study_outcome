package com.bytedance.android.shopping.store.home.slice;

import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0011\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R2\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/store/home/slice/ECStoreHeaderInfoSliceConfig;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/store/slicecard/dto/ShopSliceItemConfig;", "sliceItemConfig", "Lcom/bytedance/android/shopping/store/slicecard/dto/ShopSliceItemConfig;", "getSliceItemConfig", "()Lcom/bytedance/android/shopping/store/slicecard/dto/ShopSliceItemConfig;", "setSliceItemConfig", "(Lcom/bytedance/android/shopping/store/slicecard/dto/ShopSliceItemConfig;)V", "", "", "", "sliceItemActions", "Ljava/util/Map;", "getSliceItemActions", "()Ljava/util/Map;", "setSliceItemActions", "(Ljava/util/Map;)V", "sliceItemStates", "getSliceItemStates", "setSliceItemStates", "sliceItemExtra", "getSliceItemExtra", "setSliceItemExtra", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHeaderInfoSliceConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("slice_item_actions")
    private Map<String, ? extends Object> sliceItemActions;

    @SerializedName("slice_item_config")
    private ShopSliceItemConfig sliceItemConfig;

    @SerializedName("slice_item_extra")
    private Map<String, ? extends Object> sliceItemExtra;

    @SerializedName("slice_item_states")
    private Map<String, ? extends Object> sliceItemStates;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreHeaderInfoSliceConfig() {
    }

    public final Map<String, Object> getSliceItemActions() {
        return this.sliceItemActions;
    }

    public final ShopSliceItemConfig getSliceItemConfig() {
        return this.sliceItemConfig;
    }

    public final Map<String, Object> getSliceItemExtra() {
        return this.sliceItemExtra;
    }

    public final Map<String, Object> getSliceItemStates() {
        return this.sliceItemStates;
    }

    public final void setSliceItemActions(Map<String, ? extends Object> r100) {
        this.sliceItemActions = r100;
    }

    public final void setSliceItemConfig(ShopSliceItemConfig r100) {
        this.sliceItemConfig = r100;
    }

    public final void setSliceItemExtra(Map<String, ? extends Object> r100) {
        this.sliceItemExtra = r100;
    }

    public final void setSliceItemStates(Map<String, ? extends Object> r100) {
        this.sliceItemStates = r100;
    }
}
