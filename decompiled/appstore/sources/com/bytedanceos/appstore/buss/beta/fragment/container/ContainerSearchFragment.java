package com.bytedanceos.appstore.buss.beta.fragment.container;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedanceos.appstore.buss.fragment.SearchRecommendFragment;
import com.bytedanceos.appstore.buss.fragment.SearchResultFragment;
import com.bytedanceos.appstore.buss.fragment.SearchTipFragment;
import com.bytedanceos.appstore.buss.viewmodels.MainViewModel;
import com.obric.appstore.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlin.text.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0014X\u0094D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/fragment/container/ContainerSearchFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "f", "Lkotlin/Lazy;", "I", "()Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "mainViewModel", "", "g", "Z", "q", "()Z", "showHeader", "", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "h", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContainerSearchFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerSearchFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerSearchFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,92:1\n172#2,9:93\n*S KotlinDebug\n*F\n+ 1 ContainerSearchFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerSearchFragment\n*L\n26#1:93,9\n*E\n"})
public final class ContainerSearchFragment extends h7.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f8414h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8416g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f8414h = new a(null);
    }

    public ContainerSearchFragment() {
        final Function0 r10 = null;
        this.f8415f = FragmentViewModelLazyKt.c(this, u.b(MainViewModel.class), new ContainerSearchFragment$special$$inlined$activityViewModels$default$1(this), new ContainerSearchFragment$special$$inlined$activityViewModels$default$2(r10, this), new ContainerSearchFragment$special$$inlined$activityViewModels$default$3(this));
    }

    public static /* synthetic */ void G(ContainerSearchFragment r10, String r11) {
        J(r10, r11);
    }

    public static /* synthetic */ void H(ContainerSearchFragment r10, String r11) {
        K(r10, r11);
    }

    private final MainViewModel I() {
        return (MainViewModel) this.f8415f.getValue();
    }

    public static final void J(ContainerSearchFragment r10, String r11) {
        q.g(r10, "this$0");
        if (r11 != null) goto L5;
    L11:
        r10.getChildFragmentManager().h1(null, 1);
        return;
    L5:
        if (o.r(r11) == true) goto L11;
        FragmentTransaction r12 = r10.getChildFragmentManager().o();
        q.f(r12, "beginTransaction(...)");
        if (r10.getChildFragmentManager().i0("searchTip") != null) goto L10;
        r12.v(R.id.fl_container, new SearchTipFragment(), "searchTip");
        r12.h("searchTip");
        r12.j();
        return;
    L10:
        r10.getChildFragmentManager().h1("searchTip", 0);
    }

    public static final void K(ContainerSearchFragment r10, String r11) {
        q.g(r10, "this$0");
        if (r11 != null) goto L5;
        return;
    L5:
        if (o.r(r11) == true) goto L14;
        FragmentTransaction r12 = r10.getChildFragmentManager().o();
        q.f(r12, "beginTransaction(...)");
        if (r10.getChildFragmentManager().i0("searchResult") != null) goto L10;
        r12.v(R.id.fl_container, new SearchResultFragment(), "searchResult");
        r12.h("searchResult");
        r12.j();
        return;
    L10:
        r10.getChildFragmentManager().h1("searchResult", 0);
        return;
    }

    @Override // h7.c
    public void E() {
        r();
        MainViewModel r10 = I();
        r10.j().i(this, new b(this));
        r10.k().i(this, new c(this));
    }

    @Override // h7.c
    public void F() {
        Fragment r10 = getChildFragmentManager().h0(R.id.fl_container);
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.base.BaseFragment");
        ((h7.c) r10).F();
    }

    @Override // h7.c
    public void initData() {
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_container;
    }

    @Override // h7.c
    public Function0 o() {
        return ContainerSearchFragment$onRetryListener$1.INSTANCE;
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        I().n(this);
    }

    @Override // h7.c
    public boolean q() {
        return this.f8416g;
    }

    @Override // h7.c
    public void t() {
        getChildFragmentManager().o().v(R.id.fl_container, new SearchRecommendFragment(), "searchRecommend").j();
    }
}
