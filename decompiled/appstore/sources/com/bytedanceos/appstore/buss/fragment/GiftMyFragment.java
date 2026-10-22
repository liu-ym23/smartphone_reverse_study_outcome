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
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.GiftMyEntity;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.viewmodels.GiftViewModel;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00103\u001a\u00020 8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001c\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/GiftMyFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "Lp7/c;", "event", "onEvent", "(Lp7/c;)V", "onDestroyView", "onResume", "N", "Lcom/bytedanceos/appstore/buss/viewmodels/GiftViewModel;", "f", "Lkotlin/Lazy;", "M", "()Lcom/bytedanceos/appstore/buss/viewmodels/GiftViewModel;", NetKey.MODEL, "Ljava/util/ArrayList;", "Lcom/bytedanceos/appstore/buss/entity/GiftMyEntity;", "Lkotlin/collections/ArrayList;", "g", "Ljava/util/ArrayList;", "itemData", "", "h", "Z", "loadSucceeded", "", "i", "I", "defaultSpanCount", "j", "currentSpanCount", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "k", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Lx7/d;", "L", "()Lx7/d;", "commonRecyclerViewBinding", "q", "()Z", "showHeader", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "l", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftMyFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftMyFragment.kt\ncom/bytedanceos/appstore/buss/fragment/GiftMyFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,170:1\n172#2,9:171\n57#3,3:180\n50#4,9:183\n*S KotlinDebug\n*F\n+ 1 GiftMyFragment.kt\ncom/bytedanceos/appstore/buss/fragment/GiftMyFragment\n*L\n39#1:171,9\n100#1:180,3\n63#1:183,9\n*E\n"})
public final class GiftMyFragment extends h7.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f8585l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f8587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BinderAdapter f8591k;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f8585l = new a(null);
    }

    public GiftMyFragment() {
        Function0 r10 = GiftMyFragment$model$2.INSTANCE;
        KClass r11 = kotlin.jvm.internal.u.b(GiftViewModel.class);
        Function0<ViewModelStore> r12 = new GiftMyFragment$special$$inlined$activityViewModels$default$1(this);
        final Function0 r13 = null;
        Function0<CreationExtras> r14 = new GiftMyFragment$special$$inlined$activityViewModels$default$2(r13, this);
        if (r10 != null) goto L5;
        r10 = new GiftMyFragment$special$$inlined$activityViewModels$default$3(this);
    L5:
        this.f8586f = FragmentViewModelLazyKt.c(this, r11, r12, r14, r10);
        this.f8587g = new ArrayList();
        this.f8589i = 1;
        this.f8590j = 1;
    }

    public static /* synthetic */ void G(GiftMyFragment r10, List r11) {
        P(r10, r11);
    }

    public static /* synthetic */ void H(GiftMyFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        O(r10, r11);
    }

    public static final /* synthetic */ BaseActivity I(GiftMyFragment r10) {
        return r10.l();
    }

    public static final /* synthetic */ boolean J(GiftMyFragment r10) {
        return r10.f8588h;
    }

    public static final /* synthetic */ GiftViewModel K(GiftMyFragment r10) {
        return r10.M();
    }

    private final x7.d L() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    private final GiftViewModel M() {
        return (GiftViewModel) this.f8586f.getValue();
    }

    public static final void O(GiftMyFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L9;
        return;
    L9:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L19;
        com.bytedanceos.appstore.buss.network.h.a r12 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r12.c());
        r10.f8588h = false;
        if (AccountDataCache.b().n() == true) goto L13;
    L16:
        r10.N();
        return;
    L13:
        if (CommonUtil.f8830a.c(r12.b(), r10.l()) == true) goto L16;
        r10.D(r12);
        return;
    }

    public static final void P(GiftMyFragment r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (AccountDataCache.b().n() == true) goto L6;
        String r12 = r10.getString(R.string.gift_login);
        kotlin.jvm.internal.q.f(r12, "getString(...)");
        String r13 = r10.getString(R.string.tv_my_gift_state_no_login_desc_text);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        String r14 = r10.getString(R.string.login_ok);
        kotlin.jvm.internal.q.f(r14, "getString(...)");
        r10.C(R.drawable.icon_tv_gift_no_gap, r12, r13, r14);
        return;
    L6:
        r10.f8588h = true;
        r10.f8587g.clear();
        if (r11 != null) goto L9;
    L12:
        String r15 = r10.getString(R.string.tv_my_gift_state_empty_title_text);
        kotlin.jvm.internal.q.f(r15, "getString(...)");
        String r16 = r10.getString(R.string.tv_my_gift_state_empty_desc_text);
        kotlin.jvm.internal.q.f(r16, "getString(...)");
        String r17 = r10.getString(R.string.tv_my_gift_state_empty_next_text);
        kotlin.jvm.internal.q.f(r17, "getString(...)");
        r10.C(R.drawable.icon_tv_gift_no_gap, r15, r16, r17);
    L13:
        BinderAdapter r18 = r10.f8591k;
        if (r18 == null) goto L17;
        r18.setList(r10.f8587g);
        return;
    L17:
        return;
    L9:
        if (r11.isEmpty() == true) goto L12;
        r10.r();
        r10.f8587g.addAll(r11);
        goto L13
    }

    @Override // h7.c
    public void E() {
        M().l().i(this, new n0(this));
        M().j().i(this, new o0(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (L().f25515b == null) goto L13;
        com.bytedanceos.appstore.buss.utilities.f r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r11 = r10.f(getActivity());
        if (r11 == this.f8590j) goto L12;
        RecyclerView.LayoutManager r12 = L().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r12).Q(r11);
        this.f8590j = r11;
        ViewGroup.LayoutParams r13 = L().f25515b.getLayoutParams();
        r13.width = r11 * r10.a();
        L().f25515b.setLayoutParams(r13);
        return;
    L12:
        return;
    }

    public final void N() {
        String r10 = getString(R.string.gift_login);
        kotlin.jvm.internal.q.f(r10, "getString(...)");
        String r11 = getString(R.string.tv_my_gift_state_no_login_desc_text);
        kotlin.jvm.internal.q.f(r11, "getString(...)");
        String r12 = getString(R.string.login_ok);
        kotlin.jvm.internal.q.f(r12, "getString(...)");
        C(R.drawable.icon_tv_gift_no_gap, r10, r11, r12);
    }

    @Override // h7.c
    public void initData() {
        EventBus.getDefault().register(this);
        BinderAdapter r10 = new BinderAdapter();
        r10.addItemBinder(GiftMyEntity.class, new d7.b(), null);
        this.f8591k = r10;
        L().f25515b.addItemDecoration(new u7.b(0, 1, null));
        int r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        if (r11 != 0) goto L5;
        L().f25515b.setLayoutManager(new GridLayoutManager(l(), this.f8589i));
    L6:
        this.f8590j = r11;
        L().f25515b.setAdapter(this.f8591k);
        L().f25515b.setPageSource("page_my_gift");
        return;
    L5:
        L().f25515b.setLayoutManager(new GridLayoutManager(l(), r11));
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_gift_my;
    }

    @Override // h7.c
    public Function0 o() {
        return new GiftMyFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        M().m(this);
        this.f8591k = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull p7.c r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        if (r10.a() == false) goto L5;
        M().k();
        return;
    L5:
        N();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle r10 = new Bundle();
        r10.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_my_gift");
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
