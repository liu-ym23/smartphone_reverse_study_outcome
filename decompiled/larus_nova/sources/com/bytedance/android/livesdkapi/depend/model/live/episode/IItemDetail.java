package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R$\u0010 \u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R$\u0010$\u001a\u0004\u0018\u00010\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012RJ\u0010-\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u0001`'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\b\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010.8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\b\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010;\u001a\u0004\u0018\u0001058&@&X§\u000e¢\u0006\u0012\u0012\u0004\b:\u0010\b\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010?\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\b\u001a\u0004\b<\u0010\u0004\"\u0004\b=\u0010\u0006¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IItemDetail;", "Lvh7/c;", "", "getOrderType", "()I", "setOrderType", "(I)V", "getOrderType$annotations", "()V", "orderType", "getItemType", "setItemType", "getItemType$annotations", "itemType", "", "getSkuId", "()Ljava/lang/String;", "setSkuId", "(Ljava/lang/String;)V", "getSkuId$annotations", "skuId", "getItemId", "setItemId", "getItemId$annotations", "itemId", "getItemTitle", "setItemTitle", "getItemTitle$annotations", "itemTitle", "getItemIconUri", "setItemIconUri", "getItemIconUri$annotations", "itemIconUri", "getDescription", "setDescription", "getDescription$annotations", "description", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IPriceInfo;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPlatformPriceList", "()Ljava/util/Map;", "setPlatformPriceList", "(Ljava/util/Map;)V", "getPlatformPriceList$annotations", "platformPriceList", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMarkDetail;", "getMarkInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMarkDetail;", "setMarkInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMarkDetail;)V", "getMarkInfo$annotations", "markInfo", "Lpy/k;", "getItemIcon", "()Lpy/k;", "setItemIcon", "(Lpy/k;)V", "getItemIcon$annotations", "itemIcon", "getItemSaleType", "setItemSaleType", "getItemSaleType$annotations", "itemSaleType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IItemDetail extends c<IItemDetail> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "Description")
        public static /* synthetic */ void getDescription$annotations() {
        }

        @FieldName(name = "ItemIcon")
        public static /* synthetic */ void getItemIcon$annotations() {
        }

        @FieldName(name = "ItemIconUri")
        public static /* synthetic */ void getItemIconUri$annotations() {
        }

        @FieldName(name = "ItemID")
        public static /* synthetic */ void getItemId$annotations() {
        }

        @FieldName(name = "ItemSaleType")
        public static /* synthetic */ void getItemSaleType$annotations() {
        }

        @FieldName(name = "ItemTitle")
        public static /* synthetic */ void getItemTitle$annotations() {
        }

        @FieldName(name = "ItemType")
        public static /* synthetic */ void getItemType$annotations() {
        }

        @FieldName(name = "MarkInfo")
        public static /* synthetic */ void getMarkInfo$annotations() {
        }

        @FieldName(name = "OrderType")
        public static /* synthetic */ void getOrderType$annotations() {
        }

        @FieldName(name = "platformPriceList")
        public static /* synthetic */ void getPlatformPriceList$annotations() {
        }

        @FieldName(name = "ItemSKU")
        public static /* synthetic */ void getSkuId$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "Description")
    String getDescription();

    @FieldName(name = "ItemIcon")
    k getItemIcon();

    @FieldName(name = "ItemIconUri")
    String getItemIconUri();

    @FieldName(name = "ItemID")
    String getItemId();

    @FieldName(name = "ItemSaleType")
    int getItemSaleType();

    @FieldName(name = "ItemTitle")
    String getItemTitle();

    @FieldName(name = "ItemType")
    int getItemType();

    @FieldName(name = "MarkInfo")
    IMarkDetail getMarkInfo();

    @FieldName(name = "OrderType")
    int getOrderType();

    @FieldName(name = "platformPriceList")
    Map<Integer, IPriceInfo> getPlatformPriceList();

    @FieldName(name = "ItemSKU")
    String getSkuId();

    @FieldName(name = "Description#setter")
    void setDescription(String r100);

    @FieldName(name = "ItemIcon#setter")
    void setItemIcon(k r100);

    @FieldName(name = "ItemIconUri#setter")
    void setItemIconUri(String r100);

    @FieldName(name = "ItemID#setter")
    void setItemId(String r100);

    @FieldName(name = "ItemSaleType#setter")
    void setItemSaleType(int r100);

    @FieldName(name = "ItemTitle#setter")
    void setItemTitle(String r100);

    @FieldName(name = "ItemType#setter")
    void setItemType(int r100);

    @FieldName(name = "MarkInfo#setter")
    void setMarkInfo(IMarkDetail r100);

    @FieldName(name = "OrderType#setter")
    void setOrderType(int r100);

    @FieldName(name = "platformPriceList#setter")
    void setPlatformPriceList(Map<Integer, ? extends IPriceInfo> r100);

    @FieldName(name = "ItemSKU#setter")
    void setSkuId(String r100);
}
