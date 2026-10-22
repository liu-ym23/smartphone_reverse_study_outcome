package com.bytedance.android.shopping.store.moments.dto;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECSectionOperationType;
import com.bytedance.android.ec.hybrid.list.entity.f;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.repository.dto.l;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopEndDTO;
import com.bytedance.android.shopping.store.hybridproduct.dto.ECShopFooterDTO;
import com.bytedance.android.shopping.store.moments.dto.card.ShortVideoDTO;
import com.bytedance.android.shopping.store.repository.dto.DividingLineDTO;
import com.bytedance.android.shopping.store.repository.dto.ShopCardDTO;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import dj3.e;
import dj3.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated(message = "商城混排别用这个了,统一下数据处理 @see ECHybridListSectionDTO")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/dto/HybridListDTO;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "listStyle", "Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "getListStyle", "()Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "setListStyle", "(Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;)V", "", "", "Lcom/bytedance/android/shopping/store/moments/dto/ItemConfigDTO;", "itemConfigs", "Ljava/util/Map;", "getItemConfigs", "()Ljava/util/Map;", "setItemConfigs", "(Ljava/util/Map;)V", "", "Lcom/bytedance/android/shopping/store/moments/dto/SectionDTO;", "sections", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "setSections", "(Ljava/util/List;)V", "extra", "getExtra", "setExtra", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridListDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("item_configs")
    private Map<String, ItemConfigDTO> itemConfigs;

    @SerializedName("list_style")
    private StyleDTO listStyle;

    @SerializedName("sections")
    private List<SectionDTO> sections;

    public static final class a {
        public a() {
        }

        public static k a(HybridListDTO r110) {
            Intrinsics.checkNotNullParameter(r110, "dto");
            k r100 = new k();
            StyleDTO.a r101 = StyleDTO.Companion;
            StyleDTO r102 = r110.getListStyle();
            r101.getClass();
            r100.f47128a = StyleDTO.a.a(r102);
            Map<String, ItemConfigDTO> r103 = r110.getItemConfigs();
            ArrayList<i> r104 = null;
            if (r103 == null) goto L28;
            Map r105 = new LinkedHashMap(MapsKt.mapCapacity(r103.size()));
            Iterator<T> r106 = r103.entrySet().iterator();
        L6:
            if (r106.hasNext() == false) goto L29;
            Map.Entry r107 = (Map.Entry) r106.next();
            Object r108 = r107.getKey();
            k.a r109 = new k.a(null);
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L25
            Gson r112 = new Gson();     // Catch: Throwable -> L25
            ItemConfigDTO r113 = (ItemConfigDTO) r107.getValue();     // Catch: Throwable -> L25
            if (r113 == null) goto L11;
            String r114 = r113.getLynxConfig();     // Catch: Throwable -> L25
        L12:
            LynxConfigDTO r115 = (LynxConfigDTO) r112.fromJson(r114, LynxConfigDTO.class);     // Catch: Throwable -> L25
            LynxConfigDTO.Companion.getClass();     // Catch: Throwable -> L25
            f r116 = new f();     // Catch: Throwable -> L25
            if (r115 == null) goto L15;
            String r117 = r115.getLynxSchema();     // Catch: Throwable -> L25
        L16:
            r116.f47100a = r117;     // Catch: Throwable -> L25
            if (r115 == null) goto L19;
            double r118 = r115.getPredictHeight();     // Catch: Throwable -> L25
        L20:
            r116.f47101b = r118;     // Catch: Throwable -> L25
            if (r115 == null) goto L23;
            r115.getFixedHeight();     // Catch: Throwable -> L25
        L23:
            r109.f47132a = r116;     // Catch: Throwable -> L25
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            r105.put(r108, r109);
            goto L6
        L19:
            r118 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L20
        L15:
            r117 = null;
            goto L16
        L11:
            r114 = null;
        L25:
            th = move-exception;
            Result.Companion r119 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L29:
            if (r105 != null) goto L31;
            r105 = MapsKt.emptyMap();
        L31:
            r100.f47129b = new HashMap(r105);
            List<SectionDTO> r120 = r110.getSections();
            if (r120 == null) goto L116;
            List<SectionDTO> r121 = r120;
            ArrayList<i> r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
            Iterator<T> r123 = r121.iterator();
        L35:
            if (r123.hasNext() == false) goto L115;
            SectionDTO r124 = (SectionDTO) r123.next();
            SectionDTO.Companion.getClass();
            if (r124 != null) goto L39;
            i r125 = new i();
        L114:
            r122.add(r125);
            goto L35
        L39:
            i r126 = new i();
            r126.f47112f = r124.getLayoutColumn();
            StyleDTO.a r127 = StyleDTO.Companion;
            StyleDTO r128 = r124.getSectionStyle();
            r127.getClass();
            r126.f47114h = StyleDTO.a.a(r128);
            ArrayList<ItemDTO> r129 = r124.getItems();
            if (r129 == null) goto L95;
            ArrayList<ECHybridListItemVO> r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
            Iterator<T> r131 = r129.iterator();
        L43:
            if (r131.hasNext() == false) goto L96;
            ItemDTO r132 = (ItemDTO) r131.next();
            ItemDTO.Companion.getClass();
            if (r132 != null) goto L47;
            ECHybridListItemVO r133 = new ECHybridListItemVO();
        L94:
            r130.add(r133);
            goto L43
        L47:
            ECHybridListItemVO r134 = new ECHybridListItemVO();
            r134.f47038l = true;
            r134.f47028c = Integer.valueOf(r132.getItemType());
            r134.f47029d = r132.getItemId();
            r134.f47026a = r132.getSpanSize();
            if (ComparisonsKt.compareValues(Integer.valueOf(r132.getItemType()), Integer.valueOf(ECHybridListItemType.NATIVE_VIEW_HOLDER_MAX.getType())) <= 0) goto L119;
            r134.o(r132.getItemData());
        L93:
            r133 = r134;
            goto L94
        L119:
            int r135 = r132.getItemType();     // Catch: Exception -> L118
            if (r135 != ECHybridListItemType.SHOP_MOMENTS_SHORT_VIDEO_CARD_V2.getType()) goto L53;
            Object r136 = new Gson().fromJson(r132.getItemData(), ShortVideoDTO.class);     // Catch: Exception -> L118
        L91:
            r134.o(r136);
            goto L93
        L53:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD.getType()) goto L55;
        L88:
            r136 = new Gson().fromJson(r132.getItemData(), l.class);     // Catch: Exception -> L118
            goto L91
        L55:
            if (r135 == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_SINGLE.getType()) goto L88;
            if (r135 == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_GUESS_LIKE.getType()) goto L88;
            if (r135 == ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCT_CARD_CUR_STORE_GUESS_LIKE.getType()) goto L88;
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_SORT_FILTER.getType()) goto L65;
            r136 = new Gson().fromJson(r132.getItemData(), g.class);     // Catch: Exception -> L118
            goto L91
        L65:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_WINDOW_ENTRANCE.getType()) goto L68;
            r136 = new Gson().fromJson(r132.getItemData(), dj3.f.class);     // Catch: Exception -> L118
            goto L91
        L68:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_FEED_DIVIDER.getType()) goto L71;
            r136 = new Gson().fromJson(r132.getItemData(), DividingLineDTO.class);     // Catch: Exception -> L118
            goto L91
        L71:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_PRODUCTS_FOOTER.getType()) goto L74;
            r136 = new Gson().fromJson(r132.getItemData(), ECShopFooterDTO.class);     // Catch: Exception -> L118
            goto L91
        L74:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_SHOP_CARD.getType()) goto L77;
            r136 = new Gson().fromJson(r132.getItemData(), ShopCardDTO.class);     // Catch: Exception -> L118
            goto L91
        L77:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_RECOMMEND_MULTI_SHOP_CARD.getType()) goto L80;
            r136 = new Gson().fromJson(r132.getItemData(), List.class);     // Catch: Exception -> L118
            goto L91
        L80:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY.getType()) goto L83;
            r136 = new Gson().fromJson(r132.getItemData(), dj3.f.class);     // Catch: Exception -> L118
            goto L91
        L83:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_EMPTY_NEW.getType()) goto L86;
            r136 = new Gson().fromJson(r132.getItemData(), e.class);     // Catch: Exception -> L118
            goto L91
        L86:
            if (r135 != ECHybridListItemType.SHOP_PRODUCT_LIST_END.getType()) goto L90;
            r136 = new Gson().fromJson(r132.getItemData(), ECShopEndDTO.class);     // Catch: Exception -> L118
        L90:
            r136 = null;
        L96:
            r126.f47115i = r130;
            r126.f47113g = r124.getType();
            r126.f47107a = r124.getSectionId();
            Integer r137 = r124.getOperationType();
            if (r137 != null) goto L100;
        L102:
            if (r137 != null) goto L105;
        L107:
            if (r137 != null) goto L110;
        L112:
            ECSectionOperationType r138 = ECSectionOperationType.NONE;
        L113:
            r126.c(r138);
            r125 = r126;
            goto L114
        L110:
            if (r137.intValue() != 3) goto L112;
            r138 = ECSectionOperationType.APPEND_ITEM;
            goto L113
        L105:
            if (r137.intValue() != 2) goto L107;
            r138 = ECSectionOperationType.DELETE_SECTION;
            goto L113
        L100:
            if (r137.intValue() != 1) goto L102;
            r138 = ECSectionOperationType.INSERT_SECTION;
            goto L113
        L95:
            r130 = null;
            goto L96
        L115:
            r104 = r122;
        L116:
            r100.f47130c = r104;
            r100.f47131d = r110.getExtra();
            return r100;
        L28:
            r105 = null;
            goto L29
        }
    }

    static {
        Companion = new a();
    }

    public HybridListDTO() {
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Map<String, ItemConfigDTO> getItemConfigs() {
        return this.itemConfigs;
    }

    public final StyleDTO getListStyle() {
        return this.listStyle;
    }

    public final List<SectionDTO> getSections() {
        return this.sections;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setItemConfigs(Map<String, ItemConfigDTO> r100) {
        this.itemConfigs = r100;
    }

    public final void setListStyle(StyleDTO r100) {
        this.listStyle = r100;
    }

    public final void setSections(List<SectionDTO> r100) {
        this.sections = r100;
    }
}
