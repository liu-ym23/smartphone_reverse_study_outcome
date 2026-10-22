package com.bytedance.android.window.shop.search.presenter;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/search/presenter/WindowSearchTitlePresenter;", "Lcom/bytedance/android/window/shop/search/presenter/WindowSearchBasePresenter;", "", "resume", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchTitlePresenter extends WindowSearchBasePresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WindowSearchViewModel f189723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EditText f189724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f189725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f189726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f189727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f189728k;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowSearchTitlePresenter f189729a;

        public a(WindowSearchTitlePresenter r100) {
            this.f189729a = r100;
        }

        public final void a() {
            EditText r100 = this.f189729a.f189724g;
            if (r100 == null) goto L5;
            r100.requestFocus();
        L5:
            QContext r101 = this.f189729a.u();
            FragmentActivity r102 = l0.c(r101.c());
            if ((r102 instanceof FragmentActivity) == true) goto L8;
            r102 = null;
        L8:
            if (r102 != null) goto L10;
            r102 = r101.a();
        L10:
            Object r103 = r102.getSystemService("input_method");
            if (r103 == null) goto L15;
            ((InputMethodManager) r103).showSoftInput(this.f189729a.f189724g, 0);
            return;
        L15:
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume() {
        EditText r100 = this.f189724g;
        if (r100 == null) goto L6;
        r100.postDelayed(new a(this), 300);
        return;
    }

    public WindowSearchTitlePresenter() {
    }

    public static final /* synthetic */ WindowSearchViewModel E(WindowSearchTitlePresenter r100) {
        WindowSearchViewModel r101 = r100.f189723f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    @Override // com.bytedance.android.window.shop.search.presenter.WindowSearchBasePresenter, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        super.A(r100);
        this.f189723f = (WindowSearchViewModel) ECQuickUtilKt.c(u(), WindowSearchViewModel.class);
        this.f189725h = (ImageView) w().b(R.id.commerce_store_search_close).f();
        this.f189726i = (ImageView) w().b(R.id.commerce_store_search_camera).f();
        this.f189727j = w().b(R.id.commerce_store_search_divider).f();
        ImageView r101 = this.f189726i;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        View r102 = this.f189727j;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        ImageView r103 = this.f189725h;
        ViewGroup.LayoutParams r104 = null;
        if (r103 == null) goto L11;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
    L13:
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r104 = r105;
    L16:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r104;
        if (r106 == null) goto L19;
        r106.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(8));
    L19:
        ImageView r107 = this.f189725h;
        if (r107 == null) goto L22;
        r107.setOnClickListener(new w(this));
    L22:
        ImageView r108 = this.f189726i;
        if (r108 == null) goto L25;
        r108.setOnClickListener(new x(this));
    L25:
        EditText r109 = (EditText) w().b(R.id.commerce_store_search_input).f();
        this.f189724g = r109;
        r109.setHint(ag4.a.d(R.string.commerce_store_v2_search_here));
        EditText r110 = this.f189724g;
        if (r110 == null) goto L28;
        r110.addTextChangedListener(new y(this));
    L28:
        EditText r111 = this.f189724g;
        if (r111 == null) goto L31;
        r111.setOnEditorActionListener(new z(this));
    L31:
        ((TextView) w().b(R.id.commerce_store_search_title_go).f()).setOnClickListener(new a0(this));
        ((ImageView) w().b(R.id.commerce_store_search_title_back).f()).setOnClickListener(new b0(this));
        int r112 = com.bytedance.android.ec.window.base.utils.i.f49729a;
        WindowSearchViewModel r113 = this.f189723f;
        if (r113 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        JSONObject r114 = z1.g(r113.getSearchParam().getEntranceInfo());
        WindowSearchViewModel r115 = this.f189723f;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        com.bytedance.android.ec.window.base.utils.i.e(r114, "othershow", "shop", r115.getAdParams(), "search_middle_ad");
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        WindowSearchViewModel r116 = this.f189723f;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        r116.getSearchContent().b(ECQuickUtilKt.a(u()), new u(this));
        WindowSearchViewModel r117 = this.f189723f;
        if (r117 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r117.getSearchHint().b(ECQuickUtilKt.a(u()), new v(this));
        return;
    L11:
        r105 = null;
        goto L13
    }

    public static final void F(WindowSearchTitlePresenter r100, WindowSearchBasePresenter.SearchMode r101) {
        WindowSearchViewModel r102 = r100.f189723f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        QLiveData<String> r103 = r102.getSearchHint();
        EditText r104 = r100.f189724g;
        Editable r105 = null;
        if (r104 == null) goto L8;
        CharSequence r106 = r104.getHint();
    L9:
        r103.g(String.valueOf(r106));
        WindowSearchViewModel r107 = r100.f189723f;
        if (r107 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L12:
        QLiveData<String> r108 = r107.getSearchContent();
        EditText r109 = r100.f189724g;
        if (r109 == null) goto L15;
        r105 = r109.getText();
    L15:
        r108.g(String.valueOf(r105));
        WindowSearchViewModel r110 = r100.f189723f;
        if (r110 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r110.getSearchParam().setHistory(false);
        r100.D(r101);
        return;
    L8:
        r106 = null;
        goto L9
    }
}
