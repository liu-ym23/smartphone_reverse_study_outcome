package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/MiniAppChooseSearchFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/c;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseSearchFragment extends BaseFragment implements com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f84255j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f84256d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public lp0.a f84257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MiniAppChooseSearchViewModel f84258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f84259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f84260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerViewScrollReportHelper<MiniAppEntranceCell> f84261i;

    public static final class a {
    }

    static {
    }

    public MiniAppChooseSearchFragment() {
        this.f84256d = new LinkedHashMap();
        this.f84259g = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseSearchFragment$searchHistoryAdapter$2(this));
        this.f84260h = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseSearchFragment$searchResultAdapter$2(this));
    }

    public final void hideLoading() {
        ((LiveDoubleColorBallAnimationView) S90(R.id.loading_view)).setVisibility(8);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        lp0.a r100 = this.f84257e;
        if (r100 == null) goto L8;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b r101 = r100.getContainer();
        if (r101 == null) goto L9;
        r101.j30(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        MiniAppChooseSearchViewModel r100 = this.f84258f;
        if (r100 == null) goto L5;
        r100.saveHistoryList();
    L5:
        ((LinkedHashMap) this.f84256d).clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        int r100 = com.bytedance.android.live.openplatform.impl.base.utils.k.f84065a;
        com.bytedance.android.live.openplatform.impl.base.utils.k.a(getContext(), S90(R.id.search_edit));
    }

    public static final void T90(MiniAppChooseSearchFragment r100) {
        String r101 = ((EditText) r100.S90(R.id.search_edit)).getText().toString();
        if (r101 == null) goto L11;
        String r102 = StringsKt.trim(r101).toString();
        if (TextUtils.isEmpty(r102) == true) goto L12;
        MiniAppChooseSearchViewModel r103 = r100.f84258f;
        if (r103 == null) goto L13;
        r103.searchMiniApp(r102);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c
    public final void MX(int r100) {
        if (r100 == 0) goto L5;
        int r101 = com.bytedance.android.live.openplatform.impl.base.utils.k.f84065a;
        com.bytedance.android.live.openplatform.impl.base.utils.k.a(getContext(), S90(R.id.search_edit));
        return;
    }

    public final View S90(int r100) {
        if (this.f84256d != null) goto L5;
        this.f84256d = new LinkedHashMap();
    L5:
        View r101 = this.f84256d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f84256d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        lp0.a r101 = this.f84257e;
        Intrinsics.checkNotNullParameter(this, "frag");
        Intrinsics.checkNotNullParameter(MiniAppChooseSearchViewModel.class, "modelClass");
        MiniAppChooseBaseViewModel r102 = (MiniAppChooseBaseViewModel) ViewModelProviders.of(this).get(MiniAppChooseSearchViewModel.class);
        r102.setScope(r101);
        this.f84258f = (MiniAppChooseSearchViewModel) r102;
        lp0.a r103 = this.f84257e;
        if (r103 == null) goto L8;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b r104 = r103.getContainer();
        if (r104 == null) goto L9;
        r104.Iz(this);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        hideLoading();
        ((OpenPlatformFullScreenErrorView) S90(R.id.error_view)).R5();
        ((ConstraintLayout) S90(R.id.search_root)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.a(this));
        ((EditText) S90(R.id.search_edit)).setOnEditorActionListener(new b(this));
        ((EditText) S90(R.id.search_edit)).addTextChangedListener(new c(this));
        ((EditText) S90(R.id.search_edit)).setOnFocusChangeListener(new d(this));
        ((ImageView) S90(R.id.clear_search_input)).setOnClickListener(new e(this));
        ((ImageView) S90(R.id.clear_search_input)).setVisibility(4);
        ((TextView) S90(R.id.cancel_search)).setOnClickListener(new f(this));
        RecyclerView r102 = (RecyclerView) S90(R.id.search_history);
        LinearLayoutManager r103 = new LinearLayoutManager(getContext());
        r103.setStackFromEnd(true);
        r103.setReverseLayout(true);
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutManager(r103);
        ((RecyclerView) S90(R.id.search_history)).setAdapter((SearchHistoryAdapter) this.f84259g.getValue());
        ((RecyclerView) S90(R.id.search_history)).setVisibility(0);
        ((TextView) S90(R.id.clear_all_histories)).setOnClickListener(new g(this));
        ((RecyclerView) S90(R.id.search_result)).setOverScrollMode(2);
        ((RecyclerView) S90(R.id.search_result)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) S90(R.id.search_result)).setAdapter((SearchResultAdapter) this.f84260h.getValue());
        ((RecyclerView) S90(R.id.search_result)).setVisibility(8);
        this.f84261i = new RecyclerViewScrollReportHelper((RecyclerView) S90(R.id.search_result), 1, 1, new h(this));
        ((EditText) S90(R.id.search_edit)).setFocusable(true);
        ((EditText) S90(R.id.search_edit)).setFocusableInTouchMode(true);
        ((EditText) S90(R.id.search_edit)).requestFocus();
        int r105 = com.bytedance.android.live.openplatform.impl.base.utils.k.f84065a;
        Context r106 = getContext();
        View r107 = S90(R.id.search_edit);
        if (r106 == null) goto L14;
        if (r107 == null) goto L14;
        r107.requestFocus();     // Catch: Exception -> L12
        Object r108 = r106.getSystemService("input_method");     // Catch: Exception -> L12
        if (r108 == null) goto L11;
        ((InputMethodManager) r108).showSoftInput(r107, 2);     // Catch: Exception -> L12
        goto L14
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        MiniAppChooseSearchViewModel r109 = this.f84258f;
        if (r109 == null) goto L19;
        MutableLiveData<LinkedList<String>> r110 = r109.getHistoryListUiState();
        if (r110 == null) goto L19;
        r110.observe(getViewLifecycleOwner(), new i(this));
    L19:
        MiniAppChooseSearchViewModel r111 = this.f84258f;
        if (r111 == null) goto L24;
        MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> r112 = r111.getSearchResultUiState();
        if (r112 == null) goto L24;
        r112.observe(getViewLifecycleOwner(), new k(this));
    L24:
        MiniAppChooseSearchViewModel r113 = this.f84258f;
        if (r113 == null) goto L29;
        r113.loadHistoryList();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_mini_app_choose_search_fragment, r101, false);
    }
}
