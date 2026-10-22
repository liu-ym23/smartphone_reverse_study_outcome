package com.bytedance.android.shopping.store.mall.follows;

import com.bytedance.android.shopping.store.mall.follows.apidata.FollowStoreApiDataCacheKey;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002JB\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/FollowStoreViewModel;", "Lcom/bytedance/android/shopping/store/mall/follows/basic/BaseFollowStoreViewModel;", "()V", "hasSkinInfo", "", "init", "", "pageParams", "", "", "", "reqParams", "perfParams", "Lorg/json/JSONObject;", "cacheKey", "Lcom/bytedance/android/shopping/store/mall/follows/apidata/FollowStoreApiDataCacheKey;", "updatePageParams", "updateThemeStatus", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowStoreViewModel extends BaseFollowStoreViewModel {
    private final boolean hasSkinInfo() {
        Object r100 = getPageParams().get(BaseFollowStoreViewModel.KEY_SKIN_INFO);
        if ((r100 instanceof Map) == true) goto L5;
        r100 = null;
    L5:
        Map r101 = (Map) r100;
        if (r101 == null) goto L8;
        int r102 = r101.size();
    L9:
        if (r102 <= 0) goto L12;
        return true;
    L12:
        return false;
    L8:
        r102 = 0;
        goto L9
    }

    private final void updateThemeStatus() {
        if (Intrinsics.areEqual(getPageParams().get(BaseFollowStoreViewModel.KEY_APP_THEME), "dark") == false) goto L9;
        if (hasSkinInfo() == false) goto L7;
        ThemeStatus r100 = ThemeStatus.BIG_SALE_DARK;
    L12:
        getThemeStatus().g(r100);
        return;
    L7:
        r100 = ThemeStatus.COMMON_DARK;
        goto L12
    L9:
        if (hasSkinInfo() == false) goto L11;
        r100 = ThemeStatus.BIG_SALE_LIGHT;
        goto L12
    L11:
        r100 = ThemeStatus.COMMON_LIGHT;
        goto L12
    }

    public FollowStoreViewModel() {
    }

    @Override // com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel
    public void updatePageParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "pageParams");
        super.updatePageParams(r100);
        updateThemeStatus();
    }

    @Override // com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel
    public void init(Map<String, ? extends Object> r100, Map<String, ? extends Object> r101, JSONObject r102, FollowStoreApiDataCacheKey r103) {
        Intrinsics.checkNotNullParameter(r100, "pageParams");
        Intrinsics.checkNotNullParameter(r101, "reqParams");
        Intrinsics.checkNotNullParameter(r103, "cacheKey");
        super.init(r100, r101, r102, r103);
        updateThemeStatus();
    }
}
