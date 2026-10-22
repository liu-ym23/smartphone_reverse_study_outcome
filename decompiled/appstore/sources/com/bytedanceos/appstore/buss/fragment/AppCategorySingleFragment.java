package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemHorizontalAdapter;
import com.bytedanceos.appstore.buss.viewmodels.AppCategorySingleViewModel;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0019\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0018R\u001c\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010/8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00106\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppCategorySingleFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "", "f", "I", "defaultSpanCount", "g", "currentSpanCount", "", "h", "Lkotlin/Lazy;", "N", "()Ljava/lang/String;", "title", "i", "K", "()I", "categoryId", "", "j", "M", "()Z", "showHomeAsUp", "Lcom/bytedanceos/appstore/buss/viewmodels/AppCategorySingleViewModel;", "k", "O", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppCategorySingleViewModel;", "viewModel", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "l", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "adapter", "", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "m", "Ljava/util/List;", "dataList", "n", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/e;", "L", "()Lx7/e;", "commonRecyclerViewWrapBinding", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppCategorySingleFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppCategorySingleFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppCategorySingleFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,178:1\n106#2,15:179\n50#3,9:194\n*S KotlinDebug\n*F\n+ 1 AppCategorySingleFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppCategorySingleFragment\n*L\n61#1:179,15\n73#1:194,9\n*E\n"})
public final class AppCategorySingleFragment extends h7.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8457n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f8463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ItemHorizontalAdapter f8464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f8465m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10, Integer r11, boolean r12) {
            AppCategorySingleFragment r13 = new AppCategorySingleFragment();
            r13.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("title", r10), kotlin.d.a("categoryId", r11), kotlin.d.a("showHomeAsUp", Boolean.valueOf(r12))}));
            return r13;
        }

        public a() {
        }
    }

    static {
        f8457n = new a(null);
    }

    public AppCategorySingleFragment() {
        this.f8458f = 1;
        this.f8459g = 1;
        this.f8460h = kotlin.b.b(new AppCategorySingleFragment$title$2(this));
        this.f8461i = kotlin.b.b(new AppCategorySingleFragment$categoryId$2(this));
        this.f8462j = kotlin.b.b(new AppCategorySingleFragment$showHomeAsUp$2(this));
        Function0<ViewModelProvider.Factory> r10 = new AppCategorySingleFragment$viewModel$2(this);
        final Function0<Fragment> r11 = new AppCategorySingleFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppCategorySingleFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8463k = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppCategorySingleViewModel.class), new AppCategorySingleFragment$special$$inlined$viewModels$default$3(r12), new AppCategorySingleFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
        this.f8465m = new ArrayList();
    }

    public static /* synthetic */ void G(AppCategorySingleFragment r10) {
        P(r10);
    }

    public static /* synthetic */ void H(AppCategorySingleFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        Q(r10, r11);
    }

    public static final /* synthetic */ int I(AppCategorySingleFragment r10) {
        return r10.K();
    }

    public static final /* synthetic */ AppCategorySingleViewModel J(AppCategorySingleFragment r10) {
        return r10.O();
    }

    private final int K() {
        return ((Number) this.f8461i.getValue()).intValue();
    }

    private final boolean M() {
        return ((Boolean) this.f8462j.getValue()).booleanValue();
    }

    private final String N() {
        return (String) this.f8460h.getValue();
    }

    public static final void P(AppCategorySingleFragment r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.O().i();
    }

    public static final void Q(AppCategorySingleFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L8;
        if (r10.O().h() != 1) goto L68;
        r10.B();
        return;
    L68:
        return;
    L8:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L58;
        com.bytedanceos.appstore.buss.network.h.c r12 = (com.bytedanceos.appstore.buss.network.h.c) r11;
        List r13 = (List) r12.a();
        if (r10.O().h() != 1) goto L20;
        if (r13 != null) goto L13;
    L19:
        h7.c.A(r10, null, null, 0, 7, null);
    L36:
        if (r13 != null) goto L38;
    L52:
        ItemHorizontalAdapter r14 = r10.f8464l;
        if (r14 == null) goto L73;
        BaseLoadMoreModule r15 = r14.getLoadMoreModule();
        if (r15 == null) goto L74;
        BaseLoadMoreModule.loadMoreEnd$default(r15, false, 1, null);
        return;
    L74:
        return;
    L73:
        return;
    L38:
        if (r13.isEmpty() == true) goto L52;
        if (r13.size() < r10.O().j()) goto L52;
        if (r12.b().getHas_more() == null) goto L52;
        if (kotlin.jvm.internal.q.b(r12.b().getHas_more(), Boolean.FALSE) == true) goto L52;
        ItemHorizontalAdapter r16 = r10.f8464l;
        if (r16 == null) goto L70;
        BaseLoadMoreModule r17 = r16.getLoadMoreModule();
        if (r17 == null) goto L71;
        r17.loadMoreComplete();
        return;
    L71:
        return;
    L70:
        return;
    L13:
        if (r13.isEmpty() == true) goto L19;
        r10.r();
        r10.f8465m.clear();
        r10.f8465m.addAll(r13);
        ItemHorizontalAdapter r18 = r10.f8464l;
        if (r18 == null) goto L18;
        r18.setList(r10.f8465m);
    L18:
        AppCategorySingleViewModel r19 = r10.O();
        r19.l(r19.h() + 1);
        goto L36
    L20:
        r10.r();
        if (r10.f8465m.size() < (r10.O().h() * r10.O().j())) goto L23;
    L32:
        ItemHorizontalAdapter r20 = r10.f8464l;
        if (r20 == null) goto L35;
        r20.setList(r10.f8465m);
    L35:
        AppCategorySingleViewModel r21 = r10.O();
        r21.l(r21.h() + 1);
        goto L36
    L23:
        if ((r10.f8465m.size() % r10.O().j()) != 0) goto L32;
        if (r13 == null) goto L35;
        if (r13.isEmpty() == true) goto L35;
        r10.f8465m.addAll(r13);
        ItemHorizontalAdapter r22 = r10.f8464l;
        if (r22 == null) goto L35;
        r22.setList(r10.f8465m);
        goto L35
    L58:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L76;
        com.bytedanceos.appstore.buss.network.h.a r110 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r110.c());
        if (r10.O().h() != 1) goto L62;
        r10.D(r110);
        return;
    L62:
        ItemHorizontalAdapter r111 = r10.f8464l;
        if (r111 == null) goto L78;
        BaseLoadMoreModule r112 = r111.getLoadMoreModule();
        if (r112 == null) goto L79;
        r112.loadMoreFail();
        return;
    L79:
        return;
    L78:
        return;
    }

    @Override // h7.c
    public void E() {
        O().g().i(this, new e(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (L().f25538b == null) goto L13;
        com.bytedanceos.appstore.buss.utilities.f r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r11 = r10.f(getActivity());
        if (r11 == this.f8459g) goto L12;
        RecyclerView.LayoutManager r12 = L().f25538b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r12).Q(r11);
        this.f8459g = r11;
        ViewGroup.LayoutParams r13 = L().f25538b.getLayoutParams();
        r13.width = r11 * r10.a();
        L().f25538b.setLayoutParams(r13);
        return;
    L12:
        return;
    }

    public final x7.e L() {
        x7.e r10 = x7.e.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final AppCategorySingleViewModel O() {
        return (AppCategorySingleViewModel) this.f8463k.getValue();
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, N(), M(), false, 4, null);
        int r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        if (r10 != 0) goto L5;
        L().f25538b.setLayoutManager(new GridLayoutManager(l(), this.f8458f));
    L6:
        this.f8459g = r10;
        Map r11 = k8.a.f21034a;
        ItemHorizontalAdapter r12 = new ItemHorizontalAdapter(false, null, (String) r11.get(Integer.valueOf(K())), 3, null);
        r12.getLoadMoreModule().setOnLoadMoreListener(new d(this));
        r12.getLoadMoreModule().setAutoLoadMore(true);
        r12.getLoadMoreModule().setEnableLoadMore(true);
        r12.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(false);
        this.f8464l = r12;
        L().f25538b.setHasFixedSize(true);
        L().f25538b.setAdapter(this.f8464l);
        L().f25538b.setPageSource((String) r11.get(Integer.valueOf(K())));
        u7.a.f24888a.a(L().f25538b);
        Bundle r13 = new Bundle();
        r13.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, (String) r11.get(Integer.valueOf(K())));
        f9.b.b("exposure_pages_main", r13);
        return;
    L5:
        L().f25538b.setLayoutManager(new GridLayoutManager(l(), r10));
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_category_single;
    }

    @Override // h7.c
    public Function0 o() {
        return new AppCategorySingleFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8464l = null;
        O().k(this);
    }

    @Override // h7.c
    public void t() {
    }
}
