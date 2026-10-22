package com.bytedance.android.window.shop.search.presenter;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.window.shop.search.activity.WindowSearchResultActivity;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "SearchMode", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowSearchBasePresenter extends QPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WindowSearchViewModel f189684e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter$SearchMode;", "", "", "type", "I", "getType", "()I", "KEYBOARD", "BUTTON", "HISTORY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SearchMode extends Enum<SearchMode> {
        public static final SearchMode BUTTON = null;
        public static final SearchMode HISTORY = null;
        public static final SearchMode KEYBOARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SearchMode[] f189685a = null;
        private final int type;

        static {
            SearchMode r100 = new SearchMode("KEYBOARD", 0, 0);
            KEYBOARD = r100;
            SearchMode r101 = new SearchMode("BUTTON", 1, 1);
            BUTTON = r101;
            SearchMode r102 = new SearchMode("HISTORY", 2, 2);
            HISTORY = r102;
            f189685a = new SearchMode[]{r100, r101, r102};
        }

        public static SearchMode valueOf(String r100) {
            return (SearchMode) r27.a.a(SearchMode.class, r100);
        }

        public static SearchMode[] values() {
            return (SearchMode[]) f189685a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public SearchMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public WindowSearchBasePresenter() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public void A(QModel r100) {
        this.f189684e = (WindowSearchViewModel) ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
    }

    public final void D(SearchMode r110) {
        Intrinsics.checkNotNullParameter(r110, "searchMode");
        WindowSearchViewModel r100 = this.f189684e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r101 = r100.getSearchContent().a();
        FragmentActivity r102 = null;
        if (r101 == null) goto L8;
        String r103 = StringsKt.trim(r101).toString();
    L10:
        if (a.f189730a[r110.ordinal()] == 1) goto L12;
        String r104 = "normal_search";
    L14:
        if (TextUtils.isEmpty(r103) == false) goto L30;
        if (r110 != SearchMode.BUTTON) goto L19;
        r104 = "search_button";
    L21:
        WindowSearchViewModel r111 = this.f189684e;
        if (r111 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        String r112 = String.valueOf(r111.getSearchHint().a());
        if (TextUtils.isEmpty(r112) == true) goto L30;
        int r105 = g1.f45599a;
        if ((!Intrinsics.areEqual(g1.a.c(u().c(), R.string.commerce_store_v2_search_here, new Object[0]), r112)) == false) goto L30;
        r103 = r112;
        goto L30
    L19:
        if (r110 != SearchMode.KEYBOARD) goto L21;
        r104 = "default_search_keyword";
    L30:
        if (TextUtils.isEmpty(r103) == true) goto L61;
        WindowSearchViewModel r113 = this.f189684e;
        if (r113 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r113.getSearchContent().g(r103);
        WindowSearchViewModel r114 = this.f189684e;
        if (r114 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        ECWindowSearchParam r115 = r114.getSearchParam();
        if (r103 != null) goto L40;
        String r106 = "";
    L41:
        r115.setSearchKeyword(r106);
        WindowSearchViewModel r116 = this.f189684e;
        if (r116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        r116.getSearchParam().setSearchSource(r104);
        WindowSearchViewModel r117 = this.f189684e;
        if (r117 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L47:
        r117.getSearchParam().setFromSug(false);
        int r118 = WindowSearchResultActivity.f189665l;
        QContext r119 = u();
        FragmentActivity r107 = l0.c(r119.c());
        if ((r107 instanceof FragmentActivity) == false) goto L51;
        r102 = r107;
    L51:
        if (r102 != null) goto L53;
        r102 = r119.a();
    L53:
        WindowSearchViewModel r120 = this.f189684e;
        if (r120 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L56:
        ECWindowSearchParam r121 = r120.getSearchParam();
        String r108 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8121.c478706.d826529", PageFinder.via(y()), null, 4, null);
        Intrinsics.checkNotNullParameter(r102, "activity");
        Intrinsics.checkNotNullParameter(r121, "searchParam");
        Intent r109 = new Intent(r102, WindowSearchResultActivity.class);
        r109.putExtra("search_param", r121);
        r109.putExtra(PhotoEnterModel.SOURCE_BTM_TOKEN, r108);
        r109.putExtra("is_from_search_activity", true);
        r102.startActivityForResult(r109, 1);
        r102.overridePendingTransition(0, 0);
        WindowSearchViewModel r122 = this.f189684e;
        if (r122 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L59:
        r122.getPostKeyword().setValue(r103);
        return;
    L40:
        r106 = r103;
        goto L41
    L61:
        return;
    L12:
        r104 = "search_history";
        goto L14
    L8:
        r103 = null;
        goto L10
    }
}
