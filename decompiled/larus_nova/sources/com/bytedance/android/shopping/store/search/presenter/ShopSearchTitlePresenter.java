package com.bytedance.android.shopping.store.search.presenter;

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
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.repository.vo.SearchSuggestWord;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchTitlePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "", "resume", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchTitlePresenter extends ShopSearchBasePresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EditText f186058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f186059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f186060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f186061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f186062j;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchTitlePresenter f186063a;

        public a(ShopSearchTitlePresenter r100) {
            this.f186063a = r100;
        }

        public final void a() {
            EditText r100 = this.f186063a.f186058f;
            if (r100 == null) goto L5;
            r100.requestFocus();
        L5:
            QContext r101 = this.f186063a.u();
            FragmentActivity r102 = com.bytedance.android.ec.core.utils.l0.c(r101.c());
            if ((r102 instanceof FragmentActivity) == true) goto L8;
            r102 = null;
        L8:
            if (r102 != null) goto L10;
            r102 = r101.a();
        L10:
            Object r103 = r102.getSystemService("input_method");
            if (r103 == null) goto L15;
            ((InputMethodManager) r103).showSoftInput(this.f186063a.f186058f, 0);
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
        EditText r100 = this.f186058f;
        if (r100 == null) goto L6;
        r100.postDelayed(new a(this), 300);
        return;
    }

    public ShopSearchTitlePresenter() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f186059g = (ImageView) w().b(R.id.commerce_store_search_close).f();
        this.f186060h = (ImageView) w().b(R.id.commerce_store_search_camera).f();
        this.f186061i = w().b(R.id.commerce_store_search_divider).f();
        Lazy r101 = ECAppInfoService.f48110a;
        JSONObject r102 = null;
        if (we.a.f559330a == true) goto L10;
        ImageView r103 = this.f186060h;
        if (r103 == null) goto L7;
        r103.setVisibility(0);
    L7:
        View r104 = this.f186061i;
        if (r104 == null) goto L26;
        r104.setVisibility(0);
    L26:
        ImageView r105 = this.f186059g;
        if (r105 == null) goto L29;
        r105.setOnClickListener(new f0(this));
    L29:
        ImageView r106 = this.f186060h;
        if (r106 == null) goto L32;
        r106.setOnClickListener(new g0(this));
    L32:
        this.f186058f = (EditText) w().b(R.id.commerce_store_search_input).f();
        List<SearchSuggestWord> r107 = E().getSearchParam().getSearchSuggestWords();
        if (r107 == null) goto L37;
        SearchSuggestWord r108 = (SearchSuggestWord) CollectionsKt.firstOrNull(r107);
        if (r108 == null) goto L37;
        String r109 = r108.getWord();
    L38:
        EditText r110 = this.f186058f;
        if (r110 == null) goto L49;
        if (r109 != null) goto L42;
    L45:
        boolean r111 = true;
    L46:
        if (r111 == false) goto L48;
        r109 = ag4.a.d(R.string.commerce_store_v3_search_here);
    L48:
        r110.setHint(r109);
        goto L49
    L42:
        if (r109.length() == 0) goto L45;
        r111 = false;
    L49:
        EditText r112 = this.f186058f;
        if (r112 == null) goto L52;
        r112.addTextChangedListener(new h0(this));
    L52:
        EditText r113 = this.f186058f;
        if (r113 == null) goto L55;
        r113.setOnEditorActionListener(new i0(this));
    L55:
        ((TextView) w().b(R.id.commerce_store_search_title_go).f()).setOnClickListener(new j0(this));
        View r114 = y().findViewById(R.id.ec_store_fold_close_btn);
        if (E().getSearchParam().isSplitMode() == false) goto L59;
        ExtensionsKt.visible(r114);
        r114.setOnClickListener(new d0(this));
    L59:
        if (E().getSearchParam().isSplitMode() == false) goto L64;
        View r115 = y().findViewById(R.id.commerce_store_search_title_back);
        if (r115 == null) goto L63;
        d2.d(r115, com.bytedance.android.shopping.extensions.b.b(7), 0, com.bytedance.android.shopping.extensions.b.b(0), 0);
    L63:
        View r116 = y().findViewById(R.id.commerce_store_search_container);
        d2.d(r116, 0, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(8));
        r116.setPadding(0, 0, 0, 0);
        d2.d(y().findViewById(R.id.commerce_store_search_bar), 0, 0, com.bytedance.android.shopping.extensions.b.b(8), 0);
    L64:
        ((ImageView) w().b(R.id.commerce_store_search_title_back).f()).setOnClickListener(new e0(this));
        int r117 = com.bytedance.android.ec.store.utils.h.f48668a;
        String r118 = E().getSearchParam().getEntranceInfo();
        if ((!StringsKt.isBlank(r118)) == true) goto L68;
        r118 = null;
    L68:
        if (r118 == null) goto L70;
        r102 = z1.g(r118);
    L70:
        com.bytedance.android.ec.store.utils.h.d(r102, "othershow", "shop", E().getAdParams(), "search_middle_ad");
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        E().getSearchContent().b(ECQuickUtilKt.a(u()), new a0(this));
        E().getSearchHint().b(ECQuickUtilKt.a(u()), new b0(this));
        E().getInitSearchText().b(ECQuickUtilKt.a(u()), new c0(this));
        E().getSearchHint().g(E().getSearchParam().getSearchHint());
        E().getInitSearchText().g(E().getSearchParam().getInitSearchText());
        return;
    L37:
        r109 = null;
        goto L38
    L10:
        ImageView r119 = this.f186060h;
        if (r119 == null) goto L13;
        r119.setVisibility(8);
    L13:
        View r120 = this.f186061i;
        if (r120 == null) goto L16;
        r120.setVisibility(8);
    L16:
        ImageView r121 = this.f186059g;
        if (r121 == null) goto L19;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L21:
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == true) goto L23;
        r122 = null;
    L23:
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        if (r123 == null) goto L26;
        r123.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(8));
        goto L26
    L19:
        r122 = null;
        goto L21
    }

    public static final void G(ShopSearchTitlePresenter r100, ShopSearchBasePresenter.SearchMode r101) {
        QLiveData<String> r102 = r100.E().getSearchHint();
        EditText r103 = r100.f186058f;
        Editable r104 = null;
        if (r103 == null) goto L5;
        CharSequence r105 = r103.getHint();
    L6:
        r102.g(String.valueOf(r105));
        QLiveData<String> r106 = r100.E().getSearchContent();
        EditText r107 = r100.f186058f;
        if (r107 == null) goto L9;
        r104 = r107.getText();
    L9:
        r106.g(String.valueOf(r104));
        r100.E().getSearchParam().setHistory(false);
        r100.F(r101);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
