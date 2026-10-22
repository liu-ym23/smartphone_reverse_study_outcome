package com.bytedanceos.appstore.buss.beta.fragment.container;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavTitleEntity;
import com.bytedanceos.appstore.buss.beta.fragment.ContainerContentFragment;
import com.bytedanceos.appstore.buss.viewmodels.MainViewModel;
import com.obric.appstore.R;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\nR\u0014\u0010\"\u001a\u00020\u001f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/fragment/container/ContainerPrimaryFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroidx/fragment/app/Fragment;", "I", "()Landroidx/fragment/app/Fragment;", "K", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "entity", "M", "(Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;)V", "H", "(Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;)Landroidx/fragment/app/Fragment;", "Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "f", "Lkotlin/Lazy;", "J", "()Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "mainViewModel", "g", "Landroidx/fragment/app/Fragment;", "currentFragment", "", "h", "currentId", "", "q", "()Z", "showHeader", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContainerPrimaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerPrimaryFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerPrimaryFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n*L\n1#1,112:1\n172#2,9:113\n50#3,12:122\n*S KotlinDebug\n*F\n+ 1 ContainerPrimaryFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerPrimaryFragment\n*L\n23#1:113,9\n74#1:122,12\n*E\n"})
public final class ContainerPrimaryFragment extends h7.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Fragment f8412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8413h;

    public ContainerPrimaryFragment() {
        final Function0 r10 = null;
        this.f8411f = FragmentViewModelLazyKt.c(this, u.b(MainViewModel.class), new ContainerPrimaryFragment$special$$inlined$activityViewModels$default$1(this), new ContainerPrimaryFragment$special$$inlined$activityViewModels$default$2(r10, this), new ContainerPrimaryFragment$special$$inlined$activityViewModels$default$3(this));
        this.f8413h = -1;
    }

    public static /* synthetic */ void G(ContainerPrimaryFragment r10, BetaNavTitleEntity r11) {
        L(r10, r11);
    }

    public static final void L(ContainerPrimaryFragment r10, BetaNavTitleEntity r11) {
        q.g(r10, "this$0");
        if (r11 != null) goto L6;
        return;
    L6:
        if (r10.f8413h != r11.getId()) goto L9;
        r10.K();
        return;
    L9:
        r10.M(r11);
    }

    @Override // h7.c
    public void E() {
        r();
        J().l().i(this, new a(this));
    }

    @Override // h7.c
    public void F() {
        Fragment r10 = this.f8412g;
        if (r10 == null) goto L6;
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.base.BaseFragment");
        ((h7.c) r10).F();
        return;
    }

    public final Fragment H(BetaNavTitleEntity r10) {
        ContainerContentFragment r11 = new ContainerContentFragment();
        r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("entity", r10)}));
        return r11;
    }

    public final Fragment I() {
        return this.f8412g;
    }

    public final MainViewModel J() {
        return (MainViewModel) this.f8411f.getValue();
    }

    public final void K() {
        Fragment r10 = this.f8412g;
        if (r10 == null) goto L8;
        FragmentManager r11 = r10.getChildFragmentManager();
        if (r11 == null) goto L9;
        r11.h1(null, 1);
        return;
    L9:
        return;
    }

    public final void M(BetaNavTitleEntity r10) {
        FragmentManager r11 = getChildFragmentManager();
        q.f(r11, "getChildFragmentManager(...)");
        FragmentTransaction r12 = r11.o();
        q.f(r12, "beginTransaction()");
        Fragment r13 = H(r10);
        r12.u(R.id.fl_container, r13);
        this.f8413h = r10.getId();
        this.f8412g = r13;
        r12.l();
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
        return ContainerPrimaryFragment$onRetryListener$1.INSTANCE;
    }

    @Override // h7.c
    public boolean q() {
        return false;
    }

    @Override // h7.c
    public void t() {
    }
}
