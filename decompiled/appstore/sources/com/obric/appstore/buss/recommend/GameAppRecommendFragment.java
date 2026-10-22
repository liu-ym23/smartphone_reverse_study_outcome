package com.obric.appstore.buss.recommend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.buss.search.transition.SearchTransition;
import com.obric.appstore.network.entity.template.PageType;
import com.obric.appstore.ui.adapter.HorGridAppsItemProvider;
import com.obric.appstore.ui.adapter.HorGridCategoryItemProvider;
import com.obric.appstore.ui.adapter.TemplateUILoadMoreAdapter;
import com.obric.appstore.util.m;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.tmall.wireless.tangram.structure.card.FixCard;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u0004R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010%\u001a\u00020 8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u001a8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001e¨\u0006."}, d2 = {"Lcom/obric/appstore/buss/recommend/GameAppRecommendFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lza/f;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "toolBar", "D", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", FixCard.FixStyle.KEY_X, "()Landroid/os/Bundle;", "h0", "f0", "Lcom/obric/appstore/buss/recommend/GameRecommendVM;", "o", "Lkotlin/Lazy;", "e0", "()Lcom/obric/appstore/buss/recommend/GameRecommendVM;", "recommendVM", "Lcom/obric/appstore/ui/adapter/TemplateUILoadMoreAdapter;", "p", "Lcom/obric/appstore/ui/adapter/TemplateUILoadMoreAdapter;", "c0", "()Lcom/obric/appstore/ui/adapter/TemplateUILoadMoreAdapter;", "adapter", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "q", "Lcom/obric/appstore/buss/search/transition/SearchTransition$b;", "searchScene2", "d0", "listVM", "r", "a", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameAppRecommendFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameAppRecommendFragment.kt\ncom/obric/appstore/buss/recommend/GameAppRecommendFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n106#2,15:100\n1#3:115\n*S KotlinDebug\n*F\n+ 1 GameAppRecommendFragment.kt\ncom/obric/appstore/buss/recommend/GameAppRecommendFragment\n*L\n27#1:100,15\n*E\n"})
public final class GameAppRecommendFragment extends BaseListFragment<za.f> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f10800r = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f10801o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TemplateUILoadMoreAdapter f10802p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SearchTransition.b f10803q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f10800r = new a(null);
    }

    public GameAppRecommendFragment() {
        final Function0<Fragment> r10 = new GameAppRecommendFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new GameAppRecommendFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10801o = FragmentViewModelLazyKt.c(this, u.b(GameRecommendVM.class), new GameAppRecommendFragment$special$$inlined$viewModels$default$3(r11), new GameAppRecommendFragment$special$$inlined$viewModels$default$4(r12, r11), new GameAppRecommendFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10802p = new TemplateUILoadMoreAdapter();
        this.f10803q = new SearchTransition.b();
    }

    public static /* synthetic */ void a0(GameAppRecommendFragment r10, View r11) {
        g0(r10, r11);
    }

    public static final /* synthetic */ GameRecommendVM b0(GameAppRecommendFragment r10) {
        return r10.e0();
    }

    public static final void g0(GameAppRecommendFragment r10, View r11) {
        q.g(r10, "this$0");
        FragmentActivity r12 = r10.getActivity();
        if (r12 == null) goto L6;
        r12.finish();
        return;
    }

    @Override // com.obric.appstore.base.e
    public void D(OFloatingTitleBar r10) {
        q.g(r10, "toolBar");
        super.D(r10);
        r10.setMaskBlurRadius(8.0f);
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return c0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return d0();
    }

    public TemplateUILoadMoreAdapter c0() {
        return this.f10802p;
    }

    public GameRecommendVM d0() {
        return e0();
    }

    public final GameRecommendVM e0() {
        return (GameRecommendVM) this.f10801o.getValue();
    }

    public final void f0() {
        OFloatingTitleBar r10 = y();
        if (r10 == null) goto L10;
        r10.A();
        r10.k(R.drawable.oui_title_bar_back, -1, new com.obric.appstore.buss.recommend.a(this));
        if (e0().v() != PageType.APPS_PAGE) goto L7;
        String r11 = getString(R.string.app_recommend);
    L8:
        q.d(r11);
        r10.setCenterTitle(r11);
        m(r10);
        this.f10803q.a(r10);
        return;
    L7:
        r11 = getString(R.string.game_recommend);
        goto L8
    }

    public final void h0() {
        TemplateUILoadMoreAdapter r10 = c0();
        r10.addItemProvider(new HorGridCategoryItemProvider(getPageSource()));
        r10.addItemProvider(new HorGridAppsItemProvider(getPageSource()));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r10) {
        q.g(r10, "context");
        super.onAttach(r10);
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L8;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L9;
        this.f10803q.c(r12);
        return;
    L9:
        return;
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        h0();
        GameRecommendVM r11 = e0();
        Intent r12 = r();
        if (r12 == null) goto L5;
        String r13 = r12.getStringExtra("page_type");
    L6:
        PageType r14 = PageType.APPS_PAGE;
        if (q.b(r13, r14.getValue()) == true) goto L10;
        r14 = PageType.GAME_PAGE;
    L10:
        r11.w(r14);
        m.a("appstore_page_show", new AnonymousClass1(this));
        ILoadViewModel.s(e0(), false, false, 3, null);
        return;
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        f0();
        final RecyclerView r12 = Y();
        if (r12 == null) goto L6;
        ActivityUtilKt.b(r12, new GameAppRecommendFragment$onViewCreated$1$1(r12));
        r12.setClipToPadding(false);
        return;
    }

    @Override // com.obric.appstore.base.e
    public Bundle x() {
        SearchTransition.b r10 = this.f10803q;
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L7;
        return null;
    L7:
        return r10.b(r11);
    }
}
