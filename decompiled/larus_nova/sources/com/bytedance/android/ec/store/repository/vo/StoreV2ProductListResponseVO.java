package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.store.repository.dto.StoreV2CartsInfoDTO;
import com.bytedance.android.ec.store.repository.dto.StoreV2ProductListResponseDTO;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 x2\u00020\u0001:\u0001yB\u0007¢\u0006\u0004\bv\u0010wR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010%\u001a\u0004\b?\u0010'\"\u0004\b@\u0010)R$\u0010A\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010%\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R$\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010K\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u00103\u001a\u0004\bL\u00105\"\u0004\bM\u00107R$\u0010N\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010%\u001a\u0004\bO\u0010'\"\u0004\bP\u0010)R$\u0010Q\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u00103\u001a\u0004\bR\u00105\"\u0004\bS\u00107R*\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010\u0005\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010\tR0\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010_\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010%\u001a\u0004\b`\u0010'\"\u0004\ba\u0010)R$\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010p\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010%\u001a\u0004\bq\u0010'\"\u0004\br\u0010)R$\u0010s\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010%\u001a\u0004\bt\u0010'\"\u0004\bu\u0010)¨\u0006z"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductListResponseVO;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/store/repository/vo/q;", "goodTypes", "Ljava/util/List;", "getGoodTypes", "()Ljava/util/List;", "setGoodTypes", "(Ljava/util/List;)V", "Lcom/bytedance/android/ec/store/repository/vo/r;", "sortTypes", "getSortTypes", "setSortTypes", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "products", "getProducts", "setProducts", "recommendProducts", "getRecommendProducts", "setRecommendProducts", "", EffectConfiguration.KEY_CURSOR, "J", "getCursor", "()J", "setCursor", "(J)V", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "", "materialTitle", "Ljava/lang/String;", "getMaterialTitle", "()Ljava/lang/String;", "setMaterialTitle", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/store/repository/vo/p;", "cartsInfo", "Lcom/bytedance/android/ec/store/repository/vo/p;", "getCartsInfo", "()Lcom/bytedance/android/ec/store/repository/vo/p;", "setCartsInfo", "(Lcom/bytedance/android/ec/store/repository/vo/p;)V", "", "layoutType", "Ljava/lang/Integer;", "getLayoutType", "()Ljava/lang/Integer;", "setLayoutType", "(Ljava/lang/Integer;)V", "recommendModuleType", "I", "getRecommendModuleType", "()I", "setRecommendModuleType", "(I)V", "bottomModuleParams", "getBottomModuleParams", "setBottomModuleParams", "innerflowSchema", "getInnerflowSchema", "setInnerflowSchema", "Lcom/bytedance/android/ec/store/repository/vo/n;", "discountFilterButtons", "Lcom/bytedance/android/ec/store/repository/vo/n;", "getDiscountFilterButtons", "()Lcom/bytedance/android/ec/store/repository/vo/n;", "setDiscountFilterButtons", "(Lcom/bytedance/android/ec/store/repository/vo/n;)V", "forceProductLayout", "getForceProductLayout", "setForceProductLayout", "nextPageParams", "getNextPageParams", "setNextPageParams", "styleType", "getStyleType", "setStyleType", "Lcom/bytedance/android/ec/store/repository/dto/g;", "pickTypes", "getPickTypes", "setPickTypes", "", "bizExtra", "Ljava/util/Map;", "getBizExtra", "()Ljava/util/Map;", "setBizExtra", "(Ljava/util/Map;)V", "toast", "getToast", "setToast", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "hybridList", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "getHybridList", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "setHybridList", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "hybridListVO", "Lcom/bytedance/android/ec/hybrid/list/entity/k;", "getHybridListVO", "()Lcom/bytedance/android/ec/hybrid/list/entity/k;", "setHybridListVO", "(Lcom/bytedance/android/ec/hybrid/list/entity/k;)V", "paginationParams", "getPaginationParams", "setPaginationParams", "hybridParams", "getHybridParams", "setHybridParams", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StoreV2ProductListResponseVO implements Serializable {
    public static final a Companion = null;
    private Map<String, String> bizExtra;
    private String bottomModuleParams;
    private p cartsInfo;
    private long cursor;
    private n discountFilterButtons;
    private Integer forceProductLayout;
    private List<q> goodTypes;
    private boolean hasMore;
    private ECHybridListDTO hybridList;
    private com.bytedance.android.ec.hybrid.list.entity.k hybridListVO;
    private String hybridParams;
    private String innerflowSchema;
    private Integer layoutType;
    private String materialTitle;
    private String nextPageParams;
    private String paginationParams;
    private List<com.bytedance.android.ec.store.repository.dto.g> pickTypes;
    private List<? extends StoreV2ProductItemVO> products;
    private int recommendModuleType;
    private List<? extends StoreV2ProductItemVO> recommendProducts;
    private List<r> sortTypes;
    private Integer styleType;
    private String toast;

    public static final class a {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO] */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.util.ArrayList] */
        public static StoreV2ProductListResponseVO a(StoreV2ProductListResponseDTO r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            ?? r102 = new StoreV2ProductListResponseVO();
            List<com.bytedance.android.ec.store.repository.dto.k> r103 = r100.getGoodTypes();
            p r104 = null;
            if (r103 == null) goto L8;
            List<com.bytedance.android.ec.store.repository.dto.k> r105 = r103;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r107 = r105.iterator();
        L6:
            if (r107.hasNext() == false) goto L9;
            com.bytedance.android.ec.store.repository.dto.k r108 = (com.bytedance.android.ec.store.repository.dto.k) r107.next();
            int r109 = q.f48476c;
            r106.add(q.a.a(r108));
        L9:
            r102.setGoodTypes(r106);
            List<com.bytedance.android.ec.store.repository.dto.m> r110 = r100.getSortTypes();
            if (r110 == null) goto L15;
            List<com.bytedance.android.ec.store.repository.dto.m> r111 = r110;
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator r113 = r111.iterator();
        L13:
            if (r113.hasNext() == false) goto L16;
            com.bytedance.android.ec.store.repository.dto.m r114 = (com.bytedance.android.ec.store.repository.dto.m) r113.next();
            int r115 = r.f48479t;
            r112.add(r.a.a(r114));
        L16:
            r102.setSortTypes(r112);
            List<com.bytedance.android.ec.store.repository.dto.l> r116 = r100.getProducts();
            if (r116 == null) goto L26;
            List<com.bytedance.android.ec.store.repository.dto.l> r117 = r116;
            ?? r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
            Iterator r119 = r117.iterator();
        L20:
            if (r119.hasNext() == false) goto L27;
            com.bytedance.android.ec.store.repository.dto.l r120 = (com.bytedance.android.ec.store.repository.dto.l) r119.next();
            if (r101 == false) goto L24;
            o.R.getClass();
            com.bytedance.android.shopping.store.hybridproduct.extension.d r121 = o.a.a(r120);
        L25:
            r118.add(r121);
            goto L20
        L24:
            StoreV2ProductItemVO.Q.getClass();
            r121 = StoreV2ProductItemVO.a.b(r120);
        L27:
            r102.setProducts(r118);
            r102.setCursor(r100.getCursor());
            r102.setHasMore(r100.getHasMore());
            r102.setMaterialTitle(r100.getMaterialTitle());
            StoreV2CartsInfoDTO r122 = r100.getCartsInfo();
            if (r122 == null) goto L30;
            int r123 = p.f48474b;
            r104 = p.a.a(r122);
        L30:
            r102.setCartsInfo(r104);
            r102.setLayoutType(r100.getLayout());
            Integer r124 = r100.getRecommendModuleType();
            if (r124 == null) goto L33;
            int r125 = r124.intValue();
        L34:
            r102.setRecommendModuleType(r125);
            r102.setBottomModuleParams(r100.getBottomModuleParams());
            r102.setInnerflowSchema(r100.getInnerflowSchema());
            int r126 = n.f48472b;
            List<com.bytedance.android.ec.store.repository.dto.c> r127 = r100.getSelectButtons();
            n r128 = new n();
            r128.f48473a = r127;
            r102.setDiscountFilterButtons(r128);
            r102.setNextPageParams(r100.getNextPageParams());
            r102.setStyleType(r100.getStyleType());
            r102.setPickTypes(r100.getPickTypes());
            r102.setBizExtra(r100.getBizExtra());
            String r129 = r100.getToast();
            if (r129 == null) goto L37;
            r102.setToast(r129);
        L37:
            return r102;
        L33:
            r125 = 0;
            goto L34
        L26:
            r118 = CollectionsKt.emptyList();
            goto L27
        L15:
            r112 = null;
            goto L16
        L8:
            r106 = null;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO] */
        public static StoreV2ProductListResponseVO b(a r100, StoreV2ProductListResponseDTO r101) {
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "dto");
            ?? r102 = new StoreV2ProductListResponseVO();
            List<com.bytedance.android.ec.store.repository.dto.k> r103 = r101.getGoodTypes();
            p r104 = null;
            if (r103 == null) goto L8;
            List<com.bytedance.android.ec.store.repository.dto.k> r105 = r103;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r107 = r105.iterator();
        L6:
            if (r107.hasNext() == false) goto L9;
            com.bytedance.android.ec.store.repository.dto.k r108 = (com.bytedance.android.ec.store.repository.dto.k) r107.next();
            int r109 = q.f48476c;
            r106.add(q.a.a(r108));
        L9:
            r102.setGoodTypes(r106);
            List<com.bytedance.android.ec.store.repository.dto.m> r110 = r101.getSortTypes();
            if (r110 == null) goto L15;
            List<com.bytedance.android.ec.store.repository.dto.m> r111 = r110;
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
            Iterator r113 = r111.iterator();
        L13:
            if (r113.hasNext() == false) goto L16;
            com.bytedance.android.ec.store.repository.dto.m r114 = (com.bytedance.android.ec.store.repository.dto.m) r113.next();
            int r115 = r.f48479t;
            r112.add(r.a.a(r114));
        L16:
            r102.setSortTypes(r112);
            List<com.bytedance.android.ec.store.repository.dto.l> r116 = r101.getProducts();
            if (r116 == null) goto L22;
            List<com.bytedance.android.ec.store.repository.dto.l> r117 = r116;
            ?? r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
            Iterator r119 = r117.iterator();
        L20:
            if (r119.hasNext() == false) goto L23;
            com.bytedance.android.ec.store.repository.dto.l r120 = (com.bytedance.android.ec.store.repository.dto.l) r119.next();
            StoreV2ProductItemVO.Q.getClass();
            r118.add(StoreV2ProductItemVO.a.d(r120));
        L23:
            r102.setProducts(r118);
            r102.setCursor(r101.getCursor());
            r102.setHasMore(r101.getHasMore());
            r102.setMaterialTitle(r101.getMaterialTitle());
            StoreV2CartsInfoDTO r121 = r101.getCartsInfo();
            if (r121 == null) goto L26;
            int r122 = p.f48474b;
            r104 = p.a.a(r121);
        L26:
            r102.setCartsInfo(r104);
            r102.setLayoutType(r101.getLayout());
            Integer r123 = r101.getRecommendModuleType();
            if (r123 == null) goto L29;
            int r124 = r123.intValue();
        L30:
            r102.setRecommendModuleType(r124);
            r102.setBottomModuleParams(r101.getBottomModuleParams());
            r102.setInnerflowSchema(r101.getInnerflowSchema());
            int r125 = n.f48472b;
            List<com.bytedance.android.ec.store.repository.dto.c> r126 = r101.getSelectButtons();
            n r127 = new n();
            r127.f48473a = r126;
            r102.setDiscountFilterButtons(r127);
            r102.setNextPageParams(r101.getNextPageParams());
            r102.setStyleType(r101.getStyleType());
            r102.setPickTypes(r101.getPickTypes());
            r102.setBizExtra(r101.getBizExtra());
            String r128 = r101.getToast();
            if (r128 == null) goto L33;
            r102.setToast(r128);
        L33:
            return r102;
        L29:
            r124 = 0;
            goto L30
        L22:
            r118 = CollectionsKt.emptyList();
            goto L23
        L15:
            r112 = null;
            goto L16
        L8:
            r106 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    public StoreV2ProductListResponseVO() {
        this.products = CollectionsKt.emptyList();
        this.recommendProducts = CollectionsKt.emptyList();
        this.toast = "";
    }

    public final Map<String, String> getBizExtra() {
        return this.bizExtra;
    }

    public final String getBottomModuleParams() {
        return this.bottomModuleParams;
    }

    public final p getCartsInfo() {
        return this.cartsInfo;
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final n getDiscountFilterButtons() {
        return this.discountFilterButtons;
    }

    public final Integer getForceProductLayout() {
        return this.forceProductLayout;
    }

    public final List<q> getGoodTypes() {
        return this.goodTypes;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ECHybridListDTO getHybridList() {
        return this.hybridList;
    }

    public final com.bytedance.android.ec.hybrid.list.entity.k getHybridListVO() {
        return this.hybridListVO;
    }

    public final String getHybridParams() {
        return this.hybridParams;
    }

    public final String getInnerflowSchema() {
        return this.innerflowSchema;
    }

    public final Integer getLayoutType() {
        return this.layoutType;
    }

    public final String getMaterialTitle() {
        return this.materialTitle;
    }

    public final String getNextPageParams() {
        return this.nextPageParams;
    }

    public final String getPaginationParams() {
        return this.paginationParams;
    }

    public final List<com.bytedance.android.ec.store.repository.dto.g> getPickTypes() {
        return this.pickTypes;
    }

    public final List<StoreV2ProductItemVO> getProducts() {
        return this.products;
    }

    public final int getRecommendModuleType() {
        return this.recommendModuleType;
    }

    public final List<StoreV2ProductItemVO> getRecommendProducts() {
        return this.recommendProducts;
    }

    public final List<r> getSortTypes() {
        return this.sortTypes;
    }

    public final Integer getStyleType() {
        return this.styleType;
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setBizExtra(Map<String, String> r100) {
        this.bizExtra = r100;
    }

    public final void setBottomModuleParams(String r100) {
        this.bottomModuleParams = r100;
    }

    public final void setCartsInfo(p r100) {
        this.cartsInfo = r100;
    }

    public final void setCursor(long r100) {
        this.cursor = r100;
    }

    public final void setDiscountFilterButtons(n r100) {
        this.discountFilterButtons = r100;
    }

    public final void setForceProductLayout(Integer r100) {
        this.forceProductLayout = r100;
    }

    public final void setGoodTypes(List<q> r100) {
        this.goodTypes = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setHybridList(ECHybridListDTO r100) {
        this.hybridList = r100;
    }

    public final void setHybridListVO(com.bytedance.android.ec.hybrid.list.entity.k r100) {
        this.hybridListVO = r100;
    }

    public final void setHybridParams(String r100) {
        this.hybridParams = r100;
    }

    public final void setInnerflowSchema(String r100) {
        this.innerflowSchema = r100;
    }

    public final void setLayoutType(Integer r100) {
        this.layoutType = r100;
    }

    public final void setMaterialTitle(String r100) {
        this.materialTitle = r100;
    }

    public final void setNextPageParams(String r100) {
        this.nextPageParams = r100;
    }

    public final void setPaginationParams(String r100) {
        this.paginationParams = r100;
    }

    public final void setPickTypes(List<com.bytedance.android.ec.store.repository.dto.g> r100) {
        this.pickTypes = r100;
    }

    public final void setProducts(List<? extends StoreV2ProductItemVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.products = r100;
    }

    public final void setRecommendModuleType(int r100) {
        this.recommendModuleType = r100;
    }

    public final void setRecommendProducts(List<? extends StoreV2ProductItemVO> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recommendProducts = r100;
    }

    public final void setSortTypes(List<r> r100) {
        this.sortTypes = r100;
    }

    public final void setStyleType(Integer r100) {
        this.styleType = r100;
    }

    public final void setToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.toast = r100;
    }
}
