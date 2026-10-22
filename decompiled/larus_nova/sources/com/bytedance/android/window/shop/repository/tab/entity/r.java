package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR4\u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\r\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/r;", "", "", "Lcom/bytedance/android/ec/window/base/repository/dto/q;", "sorts", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "layoutType", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "layoutStyles", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "Lcom/bytedance/android/window/shop/repository/dto/p;", "subCategories", "f", "Lcom/bytedance/android/window/shop/repository/tab/entity/a;", "childCategories", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/window/shop/repository/dto/a;", "filterType", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("child_category_list")
    private final List<a> childCategories;

    @SerializedName(EffectConfiguration.KEY_FILTER_TYPE)
    private final List<com.bytedance.android.window.shop.repository.dto.a> filterType;

    @SerializedName("layout_styles")
    private final Map<String, Map<Integer, ECHybridListStyleDTO>> layoutStyles;

    @SerializedName("layout_type")
    private final Integer layoutType;

    @SerializedName("sort_types")
    private final List<com.bytedance.android.ec.window.base.repository.dto.q> sorts;

    @SerializedName("sub_category_list")
    private final List<com.bytedance.android.window.shop.repository.dto.p> subCategories;

    public r() {
        this.sorts = null;
        this.layoutType = null;
        this.layoutStyles = null;
        this.subCategories = null;
        this.childCategories = null;
        this.filterType = null;
    }

    public final List<a> a() {
        return this.childCategories;
    }

    public final List<com.bytedance.android.window.shop.repository.dto.a> b() {
        return this.filterType;
    }

    public final Map<String, Map<Integer, ECHybridListStyleDTO>> c() {
        return this.layoutStyles;
    }

    public final Integer d() {
        return this.layoutType;
    }

    public final List<com.bytedance.android.ec.window.base.repository.dto.q> e() {
        return this.sorts;
    }

    public final List<com.bytedance.android.window.shop.repository.dto.p> f() {
        return this.subCategories;
    }
}
