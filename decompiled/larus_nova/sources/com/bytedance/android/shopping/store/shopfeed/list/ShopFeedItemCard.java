package com.bytedance.android.shopping.store.shopfeed.list;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedItemCard;", "Ljava/io/Serializable;", "", "itemType", "Ljava/lang/Integer;", "getItemType", "()Ljava/lang/Integer;", "setItemType", "(Ljava/lang/Integer;)V", "", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "lynxCardSchema", "getLynxCardSchema", "setLynxCardSchema", "lynxCardData", "getLynxCardData", "setLynxCardData", "nativeCardData", "getNativeCardData", "setNativeCardData", "sliceCardData", "getSliceCardData", "setSliceCardData", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getExtraLynxCardData", "setExtraLynxCardData", "extraLynxCardData", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedItemCard implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Map<String, ? extends Object> f186196a;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("item_id")
    private String itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName("lynx_card_data")
    private String lynxCardData;

    @SerializedName("lynx_card_schema")
    private String lynxCardSchema;

    @SerializedName("native_card_data")
    private String nativeCardData;

    @SerializedName("slice_card_data")
    private String sliceCardData;

    public ShopFeedItemCard() {
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Map<String, Object> getExtraLynxCardData() {
        return this.f186196a;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final String getLynxCardData() {
        return this.lynxCardData;
    }

    public final String getLynxCardSchema() {
        return this.lynxCardSchema;
    }

    public final String getNativeCardData() {
        return this.nativeCardData;
    }

    public final String getSliceCardData() {
        return this.sliceCardData;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setExtraLynxCardData(Map<String, ? extends Object> r100) {
        this.f186196a = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setItemType(Integer r100) {
        this.itemType = r100;
    }

    public final void setLynxCardData(String r100) {
        this.lynxCardData = r100;
    }

    public final void setLynxCardSchema(String r100) {
        this.lynxCardSchema = r100;
    }

    public final void setNativeCardData(String r100) {
        this.nativeCardData = r100;
    }

    public final void setSliceCardData(String r100) {
        this.sliceCardData = r100;
    }
}
