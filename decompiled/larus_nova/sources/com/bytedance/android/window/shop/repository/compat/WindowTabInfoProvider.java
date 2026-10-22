package com.bytedance.android.window.shop.repository.compat;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.window.shop.repository.dto.p;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/repository/compat/WindowTabInfoProvider;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowTabInfoProvider extends CommerceBaseResponse {
    public abstract /* synthetic */ int cardCount();

    public abstract /* synthetic */ List<p> categories();

    public abstract /* synthetic */ String getTargetSelectCategoryId();

    public abstract /* synthetic */ String getTargetSelectSubCategoryId();

    public abstract /* synthetic */ WindowLayoutType getWindowLayoutType();

    public abstract /* synthetic */ int getWindowStatusCode();

    public abstract /* synthetic */ String msg();

    public abstract /* synthetic */ List<p> subCategories();

    public WindowTabInfoProvider() {
    }
}
