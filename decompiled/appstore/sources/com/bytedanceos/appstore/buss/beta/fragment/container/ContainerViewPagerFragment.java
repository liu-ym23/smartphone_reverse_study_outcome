package com.bytedanceos.appstore.buss.beta.fragment.container;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedanceos.appstore.buss.AppStoreActivity;
import com.bytedanceos.appstore.buss.beta.entity.BetaNavTitleEntity;
import com.bytedanceos.appstore.buss.beta.fragment.ContainerContentFragment;
import com.bytedanceos.appstore.buss.utilities.j;
import com.bytedanceos.appstore.buss.viewmodels.MainViewModel;
import com.obric.appstore.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\tH\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J!\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0007R\u001a\u0010!\u001a\u00020\u001c8\u0014X\u0094D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00108TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/bytedanceos/appstore/buss/beta/fragment/container/ContainerViewPagerFragment;", "Lh7/c;", "<init>", "()V", "Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;", "entity", "Landroidx/fragment/app/Fragment;", "I", "(Lcom/bytedanceos/appstore/buss/beta/entity/BetaNavTitleEntity;)Landroidx/fragment/app/Fragment;", "", "E", "initData", "F", "t", "onDestroyView", "", "", "Lkotlin/Function0;", "J", "()Ljava/util/Map;", "Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "f", "Lkotlin/Lazy;", "L", "()Lcom/bytedanceos/appstore/buss/viewmodels/MainViewModel;", "mainViewModel", "g", "currentPagerPosition", "", "h", "Z", "q", "()Z", "showHeader", "n", "()I", "layoutId", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/u;", "K", "()Lx7/u;", "fragmentTvContainerViewPagerBinding", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContainerViewPagerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContainerViewPagerFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerViewPagerFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,112:1\n172#2,9:113\n215#3,2:122\n*S KotlinDebug\n*F\n+ 1 ContainerViewPagerFragment.kt\ncom/bytedanceos/appstore/buss/beta/fragment/container/ContainerViewPagerFragment\n*L\n32#1:113,9\n85#1:122,2\n*E\n"})
public final class ContainerViewPagerFragment extends h7.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8419h;

    public ContainerViewPagerFragment() {
        final Function0 r10 = null;
        this.f8417f = FragmentViewModelLazyKt.c(this, u.b(MainViewModel.class), new ContainerViewPagerFragment$special$$inlined$activityViewModels$default$1(this), new ContainerViewPagerFragment$special$$inlined$activityViewModels$default$2(r10, this), new ContainerViewPagerFragment$special$$inlined$activityViewModels$default$3(this));
    }

    public static /* synthetic */ void G(ContainerViewPagerFragment r10, BetaNavTitleEntity r11) {
        M(r10, r11);
    }

    public static final /* synthetic */ Fragment H(ContainerViewPagerFragment r10, BetaNavTitleEntity r11) {
        return r10.I(r11);
    }

    private final Fragment I(BetaNavTitleEntity r10) {
        ContainerContentFragment r11 = new ContainerContentFragment();
        r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("entity", r10)}));
        return r11;
    }

    private final MainViewModel L() {
        return (MainViewModel) this.f8417f.getValue();
    }

    public static final void M(ContainerViewPagerFragment r10, BetaNavTitleEntity r11) {
        q.g(r10, "this$0");
        if (r11 != null) goto L6;
        return;
    L6:
        if (r10.K().f25764b.getAdapter() != null) goto L8;
        j7.c r12 = new j7.c(r10.J(), r10);
        r10.K().f25764b.setUserInputEnabled(false);
        r10.K().f25764b.setAdapter(r12);
        View r13 = r10.K().f25764b.getChildAt(0);
        q.e(r13, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView) r13).setItemViewCacheSize(0);
        r10.K().f25764b.setOrientation(1);
    L8:
        r10.f8418g = r11.getNavPosition();
        j.a r14 = j.f8856a;
        StringBuilder r15 = new StringBuilder();
        r15.append(r10.f8418g);
        r15.append("  ");
        ViewPager2 r16 = r10.K().f25764b;
        if (r16 == null) goto L13;
        RecyclerView.Adapter r17 = r16.getAdapter();
        if (r17 == null) goto L13;
        Integer r18 = Integer.valueOf(r17.getItemCount());
    L14:
        r15.append(r18);
        r14.a(r15.toString());
        ViewPager2 r19 = r10.K().f25764b;
        if (r19 == null) goto L18;
        r19.j(r10.f8418g, false);
        return;
    L18:
        return;
    L13:
        r18 = null;
        goto L14
    }

    @Override // h7.c
    public void E() {
        r();
        L().l().i(this, new d(this));
    }

    @Override // h7.c
    public void F() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public final Map J() {
        HashMap r10 = new HashMap();
        FragmentActivity r11 = requireActivity();
        q.f(r11, "requireActivity(...)");
        if ((r11 instanceof AppStoreActivity) == true) goto L5;
        return r10;
    L5:
        Iterator r12 = ((AppStoreActivity) r11).M().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        final BetaNavTitleEntity r13 = (BetaNavTitleEntity) ((Map.Entry) r12.next()).getValue();
        r10.put(Integer.valueOf(r13.getNavPosition()), new ContainerViewPagerFragment$createFragmentsByNavEntityList$1$1(this, r13));
        goto L7
    L9:
        return r10;
    }

    public final x7.u K() {
        x7.u r10 = x7.u.a(m());
        q.f(r10, "bind(...)");
        return r10;
    }

    @Override // h7.c
    public void initData() {
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_container_view_pager;
    }

    @Override // h7.c
    public Function0 o() {
        return ContainerViewPagerFragment$onRetryListener$1.INSTANCE;
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        L().n(this);
    }

    @Override // h7.c
    public boolean q() {
        return this.f8419h;
    }

    @Override // h7.c
    public void t() {
    }
}
