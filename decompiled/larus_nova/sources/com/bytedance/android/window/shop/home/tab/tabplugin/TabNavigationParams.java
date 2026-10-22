package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.window.shop.repository.api.ForceInsertInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001+BS\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b(\u0010)J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003Jh\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b'\u0010\u001e¨\u0006,"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "", "component1", "", "component2", "()Ljava/lang/Long;", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "component6", "forceInsertInfo", "sortType", "categoryId", "subCategoryId", "targetTabType", "childCategoryVO", "copy", "(Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/Long;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)Lcom/bytedance/android/window/shop/home/tab/tabplugin/TabNavigationParams;", "toString", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "getForceInsertInfo", "()Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;", "Ljava/lang/Long;", "getSortType", "getCategoryId", "Ljava/lang/String;", "getSubCategoryId", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getTargetTabType", "getChildCategoryVO", "<init>", "(Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/Long;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/window/shop/home/tab/tabplugin/WindowNavigationParam;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabNavigationParams implements Serializable {
    public static final a Companion = null;
    private final WindowNavigationParam<String> categoryId;
    private final WindowNavigationParam<String> childCategoryVO;
    private final WindowNavigationParam<String> forceInsertInfo;
    private final Long sortType;
    private final String subCategoryId;
    private final Integer targetTabType;

    public static final class a {
        public a() {
        }

        public static TabNavigationParams a(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "params");
            Long r100 = Long.valueOf(r110.optLong(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, Long.MIN_VALUE));
            if (r100.longValue() == Long.MIN_VALUE) goto L5;
            boolean r101 = true;
        L6:
            String r102 = null;
            JSONObject r103 = null;
            if (r101 == false) goto L9;
            Long r104 = r100;
        L10:
            String r105 = r110.optString("category_id", "");
            if ((!Intrinsics.areEqual(r105, "")) == true) goto L14;
            r105 = null;
        L14:
            int r106 = r110.optInt("tab_select", 100);
            String r107 = r110.optString("target_subcategory_id", "");
            if ((!Intrinsics.areEqual(r107, "")) == false) goto L17;
            String r111 = r107;
        L18:
            String r112 = r110.optString("can_use_products", "");
            if (Intrinsics.areEqual(r112, "") == false) goto L29;
        L27:
            WindowNavigationParam.Companion.getClass();
            return new TabNavigationParams(WindowNavigationParam.a.c(r102), r104, WindowNavigationParam.a.c(r105), r111, Integer.valueOf(r106), WindowNavigationParam.a.b());
        L29:
            r103 = new JSONObject(r112);     // Catch: Exception -> L23
        L24:
            if (r103 != null) goto L26;
            ForceInsertInfo r108 = new ForceInsertInfo();
            r108.setPromotionIds(r112);
            r108.setScene(1);
            r112 = r108.serializeAsJson();
        L26:
            r102 = r112;
            goto L27
        L17:
            r111 = null;
            goto L18
        L9:
            r104 = null;
            goto L10
        L5:
            r101 = false;
            goto L6
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabNavigationParams copy$default(TabNavigationParams r100, WindowNavigationParam r101, Long r102, WindowNavigationParam r103, String r104, Integer r105, WindowNavigationParam r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.forceInsertInfo;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.sortType;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.categoryId;
    L11:
        WindowNavigationParam r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.subCategoryId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.targetTabType;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.childCategoryVO;
    L20:
        WindowNavigationParam r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final WindowNavigationParam<String> component1() {
        return this.forceInsertInfo;
    }

    public final Long component2() {
        return this.sortType;
    }

    public final WindowNavigationParam<String> component3() {
        return this.categoryId;
    }

    public final String component4() {
        return this.subCategoryId;
    }

    public final Integer component5() {
        return this.targetTabType;
    }

    public final WindowNavigationParam<String> component6() {
        return this.childCategoryVO;
    }

    public final TabNavigationParams copy(WindowNavigationParam<String> r100, Long r110, WindowNavigationParam<String> r111, String r112, Integer r113, WindowNavigationParam<String> r114) {
        Intrinsics.checkNotNullParameter(r114, "childCategoryVO");
        return new TabNavigationParams(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TabNavigationParams) == false) goto L18;
        TabNavigationParams r101 = (TabNavigationParams) r100;
        if (Intrinsics.areEqual(this.forceInsertInfo, r101.forceInsertInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sortType, r101.sortType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.categoryId, r101.categoryId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subCategoryId, r101.subCategoryId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.targetTabType, r101.targetTabType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.childCategoryVO, r101.childCategoryVO) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        WindowNavigationParam<String> r100 = this.forceInsertInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.sortType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        WindowNavigationParam<String> r107 = this.categoryId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subCategoryId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.targetTabType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        WindowNavigationParam<String> r116 = this.childCategoryVO;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "TabNavigationParams(forceInsertInfo=" + this.forceInsertInfo + ", sortType=" + this.sortType + ", categoryId=" + this.categoryId + ", subCategoryId=" + this.subCategoryId + ", targetTabType=" + this.targetTabType + ", childCategoryVO=" + this.childCategoryVO + ")";
    }

    static {
        Companion = new a();
    }

    public final WindowNavigationParam<String> getCategoryId() {
        return this.categoryId;
    }

    public final WindowNavigationParam<String> getChildCategoryVO() {
        return this.childCategoryVO;
    }

    public final WindowNavigationParam<String> getForceInsertInfo() {
        return this.forceInsertInfo;
    }

    public final Long getSortType() {
        return this.sortType;
    }

    public final String getSubCategoryId() {
        return this.subCategoryId;
    }

    public final Integer getTargetTabType() {
        return this.targetTabType;
    }

    public TabNavigationParams(WindowNavigationParam<String> r100, Long r101, WindowNavigationParam<String> r102, String r103, Integer r104, WindowNavigationParam<String> r105) {
        Intrinsics.checkNotNullParameter(r105, "childCategoryVO");
        this.forceInsertInfo = r100;
        this.sortType = r101;
        this.categoryId = r102;
        this.subCategoryId = r103;
        this.targetTabType = r104;
        this.childCategoryVO = r105;
    }
}
