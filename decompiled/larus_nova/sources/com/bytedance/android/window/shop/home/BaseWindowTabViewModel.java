package com.bytedance.android.window.shop.home;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.window.shop.home.tab.BaseTabViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107J'\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\tH\u0014R$\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001b\u0010)\u001a\u00020$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010+\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010,R\u001d\u00102\u001a\b\u0012\u0004\u0012\u000201008\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedance/android/window/shop/home/BaseWindowTabViewModel;", "Lcom/bytedance/android/window/shop/home/tab/BaseTabViewModel;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lfo/a;", "dataKey", "getExtension", "(Lfo/a;)Ljava/lang/Object;", "data", "", "registerExtension", "(Lfo/a;Ljava/lang/Object;)V", "", "categoryId", "prepareDataSource", "onCleared", "categoryName", "Ljava/lang/String;", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "lastCategoryId", "getLastCategoryId", "setLastCategoryId", "lastSubCategoryId", "getLastSubCategoryId", "setLastSubCategoryId", "Lcom/bytedance/android/window/shop/c;", "shopWindowItemType", "Lcom/bytedance/android/window/shop/c;", "getShopWindowItemType", "()Lcom/bytedance/android/window/shop/c;", "targetFilterType", "getTargetFilterType", "setTargetFilterType", "Lcom/bytedance/android/window/shop/home/WindowTabEventContext;", "windowTabEventContext$delegate", "Lkotlin/Lazy;", "getWindowTabEventContext", "()Lcom/bytedance/android/window/shop/home/WindowTabEventContext;", "windowTabEventContext", "Lfo/b;", "tabCache", "Lfo/b;", "getTabCache", "()Lfo/b;", "unImportantExtensions", "Lcom/bytedance/android/window/shop/home/tab/common/a;", "Lcom/bytedance/android/window/shop/home/viewmodel/b;", "tabRefreshRegistry", "Lcom/bytedance/android/window/shop/home/tab/common/a;", "getTabRefreshRegistry", "()Lcom/bytedance/android/window/shop/home/tab/common/a;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseWindowTabViewModel extends BaseTabViewModel {
    private String categoryName;
    private String lastCategoryId;
    private String lastSubCategoryId;
    private final com.bytedance.android.window.shop.c shopWindowItemType;
    private final fo.b tabCache;
    private final com.bytedance.android.window.shop.home.tab.common.a<com.bytedance.android.window.shop.home.viewmodel.b> tabRefreshRegistry;
    private String targetFilterType;
    private final fo.b unImportantExtensions;
    private final Lazy windowTabEventContext$delegate;

    public final WindowTabEventContext getWindowTabEventContext() {
        return (WindowTabEventContext) this.windowTabEventContext$delegate.getValue();
    }

    public abstract void prepareDataSource(String r100);

    public BaseWindowTabViewModel() {
        this.lastCategoryId = "-1";
        this.lastSubCategoryId = "";
        ConcurrentHashMap<Integer, com.bytedance.android.window.shop.c> r100 = com.bytedance.android.window.shop.c.f187761b;
        this.shopWindowItemType = com.bytedance.android.window.shop.c.f187762c;
        this.targetFilterType = "";
        this.windowTabEventContext$delegate = LazyKt.lazy(new BaseWindowTabViewModel$windowTabEventContext$2(this));
        this.tabCache = new fo.b();
        this.unImportantExtensions = new fo.b();
        this.tabRefreshRegistry = new com.bytedance.android.window.shop.home.tab.common.a();
    }

    @Override // com.bytedance.android.ec.core.arch.viewmodel.BaseViewModel, com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        fo.b r100 = this.unImportantExtensions;
        r100.f478066b.clear();
        r100.f478065a.clear();
        this.tabRefreshRegistry.f188738a.clear();
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getLastCategoryId() {
        return this.lastCategoryId;
    }

    public final String getLastSubCategoryId() {
        return this.lastSubCategoryId;
    }

    public final com.bytedance.android.window.shop.c getShopWindowItemType() {
        return this.shopWindowItemType;
    }

    public final fo.b getTabCache() {
        return this.tabCache;
    }

    public final com.bytedance.android.window.shop.home.tab.common.a<com.bytedance.android.window.shop.home.viewmodel.b> getTabRefreshRegistry() {
        return this.tabRefreshRegistry;
    }

    public final String getTargetFilterType() {
        return this.targetFilterType;
    }

    public final <T> T getExtension(fo.a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        return (T) this.unImportantExtensions.a(r100);
    }

    public final void setCategoryName(String r100) {
        this.categoryName = r100;
    }

    public final void setLastCategoryId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lastCategoryId = r100;
    }

    public final void setLastSubCategoryId(String r100) {
        this.lastSubCategoryId = r100;
    }

    public final void setTargetFilterType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.targetFilterType = r100;
    }

    public final <T> void registerExtension(fo.a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "dataKey");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.unImportantExtensions.b(r100, r101);
    }
}
