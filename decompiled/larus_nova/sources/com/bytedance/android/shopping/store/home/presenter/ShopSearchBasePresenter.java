package com.bytedance.android.shopping.store.home.presenter;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.search.activity.ShopSearchResultActivity;
import com.bytedance.android.shopping.store.search.fragment.ECShopSearchFragment;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "SearchMode", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopSearchBasePresenter extends QPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f184108e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter$SearchMode;", "", "", "type", "I", "getType", "()I", "KEYBOARD", "BUTTON", "HISTORY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SearchMode extends Enum<SearchMode> {
        public static final SearchMode BUTTON = null;
        public static final SearchMode HISTORY = null;
        public static final SearchMode KEYBOARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SearchMode[] f184109a = null;
        private final int type;

        static {
            SearchMode r100 = new SearchMode("KEYBOARD", 0, 0);
            KEYBOARD = r100;
            SearchMode r101 = new SearchMode("BUTTON", 1, 1);
            BUTTON = r101;
            SearchMode r102 = new SearchMode("HISTORY", 2, 2);
            HISTORY = r102;
            f184109a = new SearchMode[]{r100, r101, r102};
        }

        public static SearchMode valueOf(String r100) {
            return (SearchMode) r27.a.a(SearchMode.class, r100);
        }

        public static SearchMode[] values() {
            return (SearchMode[]) f184109a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public SearchMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public final ShopSearchViewModel E() {
        return (ShopSearchViewModel) this.f184108e.getValue();
    }

    public ShopSearchBasePresenter() {
        this.f184108e = LazyKt.lazy(new ShopSearchBasePresenter$viewModel$2(this));
    }

    public final ECShopSearchFragment D() {
        Fragment r100 = u().d().i();
        if ((r100 instanceof ECShopSearchFragment) == true) goto L6;
        r100 = null;
    L6:
        return (ECShopSearchFragment) r100;
    }

    public final void F(SearchMode r110) {
        Intrinsics.checkNotNullParameter(r110, "searchMode");
        String r100 = E().getSearchContent().a();
        FragmentActivity r101 = null;
        if (r100 == null) goto L5;
        String r102 = StringsKt.trim(r100).toString();
    L7:
        if (g4.f184184a[r110.ordinal()] == 1) goto L9;
        String r111 = "normal_search";
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L19;
        String r112 = String.valueOf(E().getSearchHint().a());
        if (TextUtils.isEmpty(r112) == true) goto L17;
        int r103 = com.bytedance.android.ec.core.utils.g1.f45599a;
        if ((!Intrinsics.areEqual(com.bytedance.android.ec.core.utils.g1.a.c(u().c(), R.string.commerce_store_v3_search_here, new Object[0]), r112)) == false) goto L17;
        r102 = r112;
    L17:
        r111 = "hint_word_search";
    L19:
        if (TextUtils.isEmpty(r102) == true) goto L32;
        Lazy r104 = ECStoreFoldPhoneHelper.f183487a;
        ECStoreFoldPhoneHelper.f(D());
        E().getSearchContent().g(r102);
        ECShopSearchParam r105 = E().getSearchParam();
        if (r102 != null) goto L23;
        String r106 = "";
    L24:
        r105.setSearchKeyword(r106);
        E().getSearchParam().setSearchSource(r111);
        E().getSearchParam().setFromSug(false);
        int r113 = ShopSearchResultActivity.f185983m;
        QContext r114 = u();
        FragmentActivity r107 = com.bytedance.android.ec.core.utils.l0.c(r114.c());
        if ((r107 instanceof FragmentActivity) == false) goto L28;
        r101 = r107;
    L28:
        if (r101 != null) goto L30;
        r101 = r114.a();
    L30:
        ShopSearchResultActivity.a.a(r101, E().getSearchParam(), 1, BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8121.c478706.d826529", PageFinder.via(y()), null, 4, null), 16);
        E().getPostKeyword().setValue(r102);
        return;
    L23:
        r106 = r102;
        goto L24
    L32:
        return;
    L9:
        r111 = "search_history";
        goto L11
    L5:
        r102 = null;
        goto L7
    }
}
