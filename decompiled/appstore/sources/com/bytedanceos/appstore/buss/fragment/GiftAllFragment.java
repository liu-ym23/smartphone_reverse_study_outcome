package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.GiftAllEntity;
import com.bytedanceos.appstore.buss.viewmodels.GiftViewModel;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003R\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00158TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/GiftAllFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "onResume", "Lcom/bytedanceos/appstore/buss/viewmodels/GiftViewModel;", "f", "Lkotlin/Lazy;", "J", "()Lcom/bytedanceos/appstore/buss/viewmodels/GiftViewModel;", NetKey.MODEL, "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "g", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "", "h", "I", "defaultSpanCount", "i", "currentSpanCount", "Lx7/d;", "()Lx7/d;", "commonRecyclerViewBinding", "", "q", "()Z", "showHeader", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftAllFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftAllFragment.kt\ncom/bytedanceos/appstore/buss/fragment/GiftAllFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,109:1\n172#2,9:110\n57#3,3:119\n50#4,9:122\n*S KotlinDebug\n*F\n+ 1 GiftAllFragment.kt\ncom/bytedanceos/appstore/buss/fragment/GiftAllFragment\n*L\n31#1:110,9\n72#1:119,3\n47#1:122,9\n*E\n"})
public final class GiftAllFragment extends h7.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BinderAdapter f8576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8578i;

    public GiftAllFragment() {
        Function0 r10 = GiftAllFragment$model$2.INSTANCE;
        KClass r11 = kotlin.jvm.internal.u.b(GiftViewModel.class);
        Function0<ViewModelStore> r12 = new GiftAllFragment$special$$inlined$activityViewModels$default$1(this);
        final Function0 r13 = null;
        Function0<CreationExtras> r14 = new GiftAllFragment$special$$inlined$activityViewModels$default$2(r13, this);
        if (r10 != null) goto L5;
        r10 = new GiftAllFragment$special$$inlined$activityViewModels$default$3(this);
    L5:
        this.f8575f = FragmentViewModelLazyKt.c(this, r11, r12, r14, r10);
        this.f8577h = 1;
        this.f8578i = 1;
    }

    public static /* synthetic */ void G(GiftAllFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        K(r10, r11);
    }

    public static final /* synthetic */ GiftViewModel H(GiftAllFragment r10) {
        return r10.J();
    }

    private final x7.d I() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public static final void K(GiftAllFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L17;
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
    L15:
        String r13 = r10.getString(R.string.tv_all_gift_state_empty_title_text);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        r10.z(r13, r10.getString(R.string.tv_all_gift_state_empty_desc_text), R.drawable.icon_tv_gift_no_gap);
        return;
    L10:
        if (r12.isEmpty() == true) goto L15;
        r10.r();
        BinderAdapter r14 = r10.f8576g;
        if (r14 == null) goto L21;
        r14.setList(r12);
        return;
    L21:
        return;
    L17:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L24;
        com.bytedanceos.appstore.buss.network.h.a r15 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r15.c());
        r10.D(r15);
        return;
    }

    @Override // h7.c
    public void E() {
        J().i().i(this, new m0(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (I().f25515b == null) goto L13;
        com.bytedanceos.appstore.buss.utilities.f r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r11 = r10.f(getActivity());
        if (r11 == this.f8578i) goto L12;
        RecyclerView.LayoutManager r12 = I().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r12).Q(r11);
        this.f8578i = r11;
        ViewGroup.LayoutParams r13 = I().f25515b.getLayoutParams();
        r13.width = r11 * r10.a();
        I().f25515b.setLayoutParams(r13);
        return;
    L12:
        return;
    }

    public final GiftViewModel J() {
        return (GiftViewModel) this.f8575f.getValue();
    }

    @Override // h7.c
    public void initData() {
        int r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        if (r10 != 0) goto L5;
        I().f25515b.setLayoutManager(new GridLayoutManager(l(), this.f8577h));
    L6:
        this.f8578i = r10;
        I().f25515b.addItemDecoration(new u7.b(0, 1, null));
        I().f25515b.setPageSource("page_all_gift");
        BinderAdapter r11 = new BinderAdapter();
        r11.addItemBinder(GiftAllEntity.class, new d7.a(), null);
        this.f8576g = r11;
        I().f25515b.setAdapter(this.f8576g);
        return;
    L5:
        I().f25515b.setLayoutManager(new GridLayoutManager(l(), r10));
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_gift_all;
    }

    @Override // h7.c
    public Function0 o() {
        return new GiftAllFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8576g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle r10 = new Bundle();
        r10.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_all_gift");
        f9.b.b("exposure_pages_main", r10);
    }

    @Override // h7.c
    public boolean q() {
        return false;
    }

    @Override // h7.c
    public void t() {
    }
}
