package com.obric.appstore.buss.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import bb.e;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.Category;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.widget.oui.ViewExtKt;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseLoadMoreListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.base.IPageLoadViewModel;
import com.obric.appstore.base.LocaleChangeAwareKt;
import com.obric.appstore.base.o;
import com.obric.appstore.buss.search.transition.SearchTransition;
import com.obric.appstore.ui.adapter.AppInfoLoadMoreUIAdapter;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.util.s;
import com.obric.oui.blur.OBlurMaskView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J%\u0010\u001e\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010/\u001a\u00020*8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020<8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/obric/appstore/buss/category/CategoryFragment;", "Lcom/obric/appstore/base/BaseLoadMoreListFragment;", "Lcom/bytedanceos/common/model/AppInfo;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", FixCard.FixStyle.KEY_X, "()Landroid/os/Bundle;", "Lcom/obric/oui/status/OPageStatus;", "empty", "Q", "(Lcom/obric/oui/status/OPageStatus;)V", "onDestroyView", "", "Lcom/bytedanceos/common/model/Category;", ServerElements.CATEGORYS, "", "secondId", "h0", "(Ljava/util/List;Ljava/lang/String;)V", "Lcom/obric/oui/tab/OTabLayout;", "tabLayout", "m0", "(Lcom/obric/oui/tab/OTabLayout;Ljava/util/List;Ljava/lang/String;)V", "Lcom/obric/appstore/buss/category/b;", "p", "Lkotlin/Lazy;", "j0", "()Lcom/obric/appstore/buss/category/b;", "categoryVM", "Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "q", "Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "i0", "()Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "adapter", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "r", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "searchScene2", "", "s", "Z", "isUpdatingSecondCategoryTabs", "", "v", "()I", "headerLayoutId", "Lcom/obric/appstore/base/o;", "k0", "()Lcom/obric/appstore/base/o;", "loadMoreVM", "t", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCategoryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CategoryFragment.kt\ncom/obric/appstore/buss/category/CategoryFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n106#2,15:217\n1#3:232\n304#4,2:233\n302#4:235\n1855#5,2:236\n350#5,7:238\n*S KotlinDebug\n*F\n+ 1 CategoryFragment.kt\ncom/obric/appstore/buss/category/CategoryFragment\n*L\n41#1:217,15\n165#1:233,2\n167#1:235\n187#1:236,2\n193#1:238,7\n*E\n"})
public final class CategoryFragment extends BaseLoadMoreListFragment<AppInfo> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f10597t = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f10598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AppInfoLoadMoreUIAdapter f10599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SearchTransition.b f10600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f10601s;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b implements OTabLayoutBase.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CategoryFragment f10602a;

        public b(CategoryFragment r10) {
            this.f10602a = r10;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabReselected(OTabLayoutBase.h r10) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabSelected(OTabLayoutBase.h r10) {
            if (CategoryFragment.g0(this.f10602a) == false) goto L5;
            return;
        L5:
            String r11 = null;
            if (r10 == null) goto L8;
            Object r12 = r10.e();
        L10:
            if ((r12 instanceof String) == false) goto L12;
            r11 = (String) r12;
        L12:
            if (r11 == null) goto L15;
            CategoryFragment.f0(this.f10602a).F(r11);
            return;
        L15:
            return;
        L8:
            r12 = null;
            goto L10
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabUnselected(OTabLayoutBase.h r10) {
        }
    }

    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f10603a;

        public c(Function1 r10) {
            q.g(r10, "function");
            this.f10603a = r10;
        }

        public final boolean equals(Object r10) {
            if ((r10 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r10 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return q.b(getFunctionDelegate(), ((FunctionAdapter) r10).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function getFunctionDelegate() {
            return this.f10603a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r10) {
            this.f10603a.invoke(r10);
        }
    }

    static {
        f10597t = new a(null);
    }

    public CategoryFragment() {
        final Function0<Fragment> r10 = new CategoryFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new CategoryFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10598p = FragmentViewModelLazyKt.c(this, u.b(com.obric.appstore.buss.category.b.class), new CategoryFragment$special$$inlined$viewModels$default$3(r11), new CategoryFragment$special$$inlined$viewModels$default$4(r12, r11), new CategoryFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10599q = new AppInfoLoadMoreUIAdapter();
        this.f10600r = new SearchTransition.b();
    }

    public static /* synthetic */ void d0(CategoryFragment r10, Locale r11) {
        l0(r10, r11);
    }

    public static final /* synthetic */ void e0(CategoryFragment r10, List r11, String r12) {
        r10.h0(r11, r12);
    }

    public static final /* synthetic */ com.obric.appstore.buss.category.b f0(CategoryFragment r10) {
        return r10.j0();
    }

    public static final /* synthetic */ boolean g0(CategoryFragment r10) {
        return r10.f10601s;
    }

    public static final void l0(CategoryFragment r10, Locale r11) {
        q.g(r10, "this$0");
        q.g(r11, "it");
        r10.j0().a();
        ILoadViewModel.s(r10.j0(), true, false, 2, null);
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void Q(OPageStatus r10) {
        q.g(r10, "empty");
        if (getView() == null) goto L6;
        r10.setTitle(getString(R.string.obric_empty_apps));
        return;
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment, com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return i0();
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment
    public /* bridge */ /* synthetic */ IPageLoadViewModel b0() {
        return k0();
    }

    public final void h0(List r10, String r11) {
        View r12 = getView();
        if (r12 == null) goto L33;
        View r13 = ViewExtKt.findView(r12, R.id.second_category_container);
        if (r13 == null) goto L35;
        View r14 = getView();
        if (r14 == null) goto L34;
        OTabLayout r15 = (OTabLayout) ViewExtKt.findView(r14, R.id.second_category_tab_layout);
        if (r15 == null) goto L36;
        View r16 = getView();
        if (r16 == null) goto L21;
        final OBlurMaskView r17 = (OBlurMaskView) ViewExtKt.findView(r16, R.id.blur_view);
        if (r17 == null) goto L21;
        if (r10.isEmpty() == false) goto L19;
        ActivityUtilKt.b(r17, new CategoryFragment$changeSecondCategory$1$1(r17, this));
        goto L21
    L19:
        ActivityUtilKt.b(r17, new CategoryFragment$changeSecondCategory$1$2(r17, this));
    L21:
        if (r10.isEmpty() == false) goto L23;
        int r18 = 8;
    L24:
        r13.setVisibility(r18);
        final RecyclerView r19 = Y();
        if (r19 != null) goto L27;
    L31:
        m0(r15, r10, r11);
        return;
    L27:
        if (r13.getVisibility() != 8) goto L29;
        final int r20 = r19.getResources().getDimensionPixelSize(R.dimen.game_app_list_top_margin);
    L30:
        ActivityUtilKt.b(r19, new CategoryFragment$changeSecondCategory$2$1(r20, r19));
        goto L31
    L29:
        r20 = r19.getResources().getDimensionPixelSize(R.dimen.category_list_top_margin);
        goto L30
    L23:
        r18 = 0;
        goto L24
    L36:
        return;
    L34:
        return;
    L35:
        return;
    }

    public AppInfoLoadMoreUIAdapter i0() {
        return this.f10599q;
    }

    public final com.obric.appstore.buss.category.b j0() {
        return (com.obric.appstore.buss.category.b) this.f10598p.getValue();
    }

    public o k0() {
        return j0();
    }

    public final void m0(OTabLayout r10, List r11, String r12) {
        this.f10601s = true;
        r10.V();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Category r14 = (Category) r13.next();
        OTabLayoutBase.h r15 = r10.T(0).r(r14.getName()).q(r14.getId());
        q.f(r15, "setTag(...)");
        r10.q(r15, false);
        goto L4
    L6:
        Iterator r16 = r11.iterator();
        int r17 = 0;
    L8:
        if (r16.hasNext() == false) goto L13;
        if (q.b(((Category) r16.next()).getId(), r12) == true) goto L14;
        r17 = r17 + 1;
    L14:
        Integer r18 = Integer.valueOf(r17);
        String r19 = null;
        if (r18.intValue() >= 0) goto L18;
        r18 = null;
    L18:
        if (r18 == null) goto L20;
        int r20 = r18.intValue();
    L22:
        if (r11.isEmpty() == true) goto L24;
        r10.X(r20);
    L24:
        this.f10601s = false;
        Category r21 = (Category) b0.a0(r11, r20);
        if (r21 == null) goto L27;
        r19 = r21.getId();
    L27:
        if (r19 != null) goto L30;
        r19 = "";
    L30:
        if (r19.length() > 0) goto L32;
        return;
    L32:
        if (q.b(r19, r12) == true) goto L39;
        j0().F(r19);
        return;
    L39:
        return;
    L20:
        r20 = 0;
        goto L22
    L13:
        r17 = -1;
        goto L14
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r10) {
        q.g(r10, "context");
        super.onAttach(r10);
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L8;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L9;
        this.f10600r.c(r12);
        return;
    L9:
        return;
    }

    @Override // com.obric.appstore.base.BaseLoadMoreListFragment, com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        oe.a.a("appstore_page_show", AnonymousClass1.INSTANCE);
        if (r13 != null) goto L17;
        com.obric.appstore.buss.category.b r14 = j0();
        Intent r10 = r();
        String r11 = "";
        if (r10 == null) goto L8;
        String r12 = r10.getStringExtra("category_first");
        if (r12 == null) goto L8;
    L9:
        Intent r15 = r();
        if (r15 == null) goto L15;
        String r16 = r15.getStringExtra("category_second");
        if (r16 == null) goto L15;
        r11 = r16;
    L15:
        r14.M(r12, r11);
    L8:
        r12 = "";
    L17:
        if (j0().H().length() != 0) goto L22;
        j.b(getPageSource() + " categoryFirstId is empty");
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L24;
        r17.finish();
        return;
    L24:
        return;
    L22:
        i0().addItemProvider(new ItemAppProvider(getPageSource(), false, false, null, Integer.valueOf(com.obric.appstore.buss.detail.o.a()), true, false, 0.0f, 136, null));
        LocaleChangeAwareKt.a(this, new com.obric.appstore.buss.category.a(this));
        ILoadViewModel.s(j0(), false, false, 3, null);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        s r12 = J();
        if (r12 == null) goto L9;
        sa.c r13 = r12.k();
        if (r13 == null) goto L9;
        ViewStub r14 = r13.f24568b;
        if (r14 == null) goto L9;
        r14.setLayoutResource(R.layout.common_state_empty_view_medium);
    L9:
        OFloatingTitleBar r15 = y();
        if (r15 == null) goto L21;
        Intent r16 = r();
        if (r16 == null) goto L14;
        String r17 = r16.getStringExtra("category_title");
    L15:
        if (r17 != null) goto L18;
        r17 = "";
    L18:
        if (r17.length() != 0) goto L20;
        r17 = getString(R.string.category);
        q.f(r17, "getString(...)");
    L20:
        r15.setCenterTitle(r17);
        m(r15);
        this.f10600r.a(r15);
        goto L21
    L14:
        r17 = null;
    L21:
        ((OTabLayout) ViewExtKt.findView(r10, R.id.second_category_tab_layout)).addOnTabSelectedListener(new b(this));
        j0().K().i(getViewLifecycleOwner(), new c(new AnonymousClass4(this)));
        j0().J().i(getViewLifecycleOwner(), new c(new AnonymousClass5(this)));
        j0().L().i(getViewLifecycleOwner(), new c(new AnonymousClass6(this)));
        RecyclerView r18 = Y();
        if (r18 == null) goto L25;
        r18.setClipToPadding(false);
        r18.addItemDecoration(new e(com.obric.appstore.buss.detail.o.c(), com.obric.appstore.buss.detail.o.b(), com.obric.appstore.buss.detail.o.c(), false, 0, com.obric.appstore.buss.detail.o.b()));
        return;
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return R.layout.obric_category_header;
    }

    @Override // com.obric.appstore.base.e
    public Bundle x() {
        SearchTransition.b r10 = this.f10600r;
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L7;
        return null;
    L7:
        return r10.b(r11);
    }
}
