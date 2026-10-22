package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.MyAppNumEntity;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.viewmodels.MyAppViewModel;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.eventbus.LocalAppsLoadedEvent;
import com.bytedanceos.common.eventbus.MyAppsEvent;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.utils.BytedanceMenuHelper;
import com.obric.appstore.R;
import com.obric.oui.popover.OPopover;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001GB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\f\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00109\u001a\u00020 8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010:8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/MyAppsFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "E", "initData", "F", "t", "Lcom/bytedanceos/common/eventbus/MyAppsEvent;", "event", "onEvent", "(Lcom/bytedanceos/common/eventbus/MyAppsEvent;)V", "Lcom/bytedanceos/common/eventbus/LocalAppsLoadedEvent;", "(Lcom/bytedanceos/common/eventbus/LocalAppsLoadedEvent;)V", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "onDestroyView", "", "f", "Lkotlin/Lazy;", "getPageSource", "()Ljava/lang/String;", "pageSource", "Lcom/bytedanceos/appstore/buss/viewmodels/MyAppViewModel;", "g", "P", "()Lcom/bytedanceos/appstore/buss/viewmodels/MyAppViewModel;", "viewModel", "", "h", "I", "defaultSpanCount", "i", "currentSpanCount", "", "", "j", "Ljava/util/List;", "myItems", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "k", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Lcom/obric/oui/popover/OPopover;", "l", "Lcom/obric/oui/popover/OPopover;", "popupMenu", "Lx7/d;", "M", "()Lx7/d;", "commonRecyclerViewBinding", "n", "()I", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/j1;", "N", "()Lx7/j1;", "tvMyAppItemSubscribeViewBinding", "Lx7/k1;", "O", "()Lx7/k1;", "tvMyAppItemUninstallViewBinding", "m", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyAppsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/MyAppsFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,280:1\n106#2,15:281\n57#3,3:296\n57#3,3:299\n50#4,9:302\n50#4,9:311\n*S KotlinDebug\n*F\n+ 1 MyAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/MyAppsFragment\n*L\n77#1:281,15\n145#1:296,3\n187#1:299,3\n91#1:302,9\n103#1:311,9\n*E\n"})
public final class MyAppsFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f8592m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f8597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BinderAdapter f8598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OPopover f8599l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10) {
            MyAppsFragment r11 = new MyAppsFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a(NetKey.PAGE_SOURCE, r10)}));
            return r11;
        }

        public a() {
        }
    }

    public static final class b extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MyAppsFragment f8600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8601b;

        public b(MyAppsFragment r10, Ref$IntRef r11) {
            this.f8600a = r10;
            this.f8601b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = MyAppsFragment.J(this.f8600a);
            if (r11 == null) goto L7;
            List<Object> r12 = r11.getData();
            if (r12 == null) goto L7;
            Object r13 = r12.get(r10);
        L9:
            if ((r13 instanceof String) == false) goto L15;
            int r14 = this.f8601b.element;
            if (r14 != 0) goto L14;
            return 1;
        L14:
            return r14;
        L15:
            return 1;
        L7:
            r13 = null;
            goto L9
        }
    }

    public static final class c implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MyAppsFragment f8602a;

        public c(MyAppsFragment r10) {
            this.f8602a = r10;
        }

        public static /* synthetic */ boolean a(CommonAppEntity r10, MyAppsFragment r11, BytedanceMenuHelper.OUIMenuItem r12) {
            return c(r10, r11, r12);
        }

        public static final boolean c(CommonAppEntity r10, MyAppsFragment r11, BytedanceMenuHelper.OUIMenuItem r12) {
            kotlin.jvm.internal.q.g(r10, "$entity");
            kotlin.jvm.internal.q.g(r11, "this$0");
            AppInfo r13 = r10.convertAppInfo();
            kotlin.jvm.internal.q.f(r13, "convertAppInfo(...)");
            r13.downloadId = r10.getDownloadId();
            BaseApplication.c().b().p0(r13);
            OPopover r14 = MyAppsFragment.K(r11);
            if (r14 == null) goto L5;
            r14.dismiss();
        L5:
            Bundle r15 = new Bundle();
            r15.putString("long_click_operation", "cancle_download");
            f9.b.b("click_longpress_appmanager", r15);
            return true;
        }

        public void b(View r10, final CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            if (BaseApplication.c().b().Y(r11.getPkg()) == true) goto L5;
            return;
        L5:
            OPopover r12 = MyAppsFragment.K(this.f8602a);
            if (r12 == null) goto L8;
            r12.dismiss();
        L8:
            final MyAppsFragment r13 = this.f8602a;
            MyAppsFragment.L(r13, BytedanceMenuHelper.d(r10, new s0(r11, r13)));
            OPopover r14 = MyAppsFragment.K(this.f8602a);
            if (r14 == null) goto L11;
            com.obric.oui.popover.f.a(r14, r10, 80, true, 0.0f, r10.getMeasuredWidth() / 2, r10.getMeasuredHeight() / 2, false);
        L11:
            Bundle r15 = new Bundle();
            r15.putString("long_click_operation", "cancle_download");
            f9.b.b("longpress_appmanager", r15);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            b((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    public static final class d extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MyAppsFragment f8603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8604b;

        public d(MyAppsFragment r10, Ref$IntRef r11) {
            this.f8603a = r10;
            this.f8604b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = MyAppsFragment.J(this.f8603a);
            if (r11 == null) goto L7;
            List<Object> r12 = r11.getData();
            if (r12 == null) goto L7;
            Object r13 = r12.get(r10);
        L9:
            if ((r13 instanceof String) == false) goto L15;
            int r14 = this.f8604b.element;
            if (r14 != 0) goto L14;
            return 1;
        L14:
            return r14;
        L15:
            return 1;
        L7:
            r13 = null;
            goto L9
        }
    }

    static {
        f8592m = new a(null);
    }

    public MyAppsFragment() {
        this.f8593f = kotlin.b.b(new MyAppsFragment$pageSource$2(this));
        final Function0<Fragment> r10 = new MyAppsFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new MyAppsFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8594g = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(MyAppViewModel.class), new MyAppsFragment$special$$inlined$viewModels$default$3(r11), new MyAppsFragment$special$$inlined$viewModels$default$4(r12, r11), new MyAppsFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f8595h = 1;
        this.f8596i = 1;
        this.f8597j = new ArrayList();
    }

    public static /* synthetic */ void G(MyAppsFragment r10, List r11) {
        S(r10, r11);
    }

    public static /* synthetic */ void H(MyAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        R(r10, r11);
    }

    public static /* synthetic */ void I(MyAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        Q(r10, r11);
    }

    public static final /* synthetic */ BinderAdapter J(MyAppsFragment r10) {
        return r10.f8598k;
    }

    public static final /* synthetic */ OPopover K(MyAppsFragment r10) {
        return r10.f8599l;
    }

    public static final /* synthetic */ void L(MyAppsFragment r10, OPopover r11) {
        r10.f8599l = r11;
    }

    private final x7.d M() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public static final void Q(MyAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L18;
        com.bytedanceos.appstore.buss.network.h.c r12 = (com.bytedanceos.appstore.buss.network.h.c) r11;
        Map r13 = (Map) r12.a();
        if (r13 != null) goto L10;
    L16:
        r10.O().f25643d.setText(r10.getString(R.string.myapp_log_to_show_install_history));
        r10.O().f25644e.setVisibility(8);
        return;
    L10:
        if (r13.isEmpty() == true) goto L16;
        if (AccountDataCache.b().n() == false) goto L16;
        r10.O().f25644e.setVisibility(0);
        r10.O().f25644e.setText(String.valueOf(((Map) r12.a()).size()));
        r10.O().f25643d.setText(r10.getString(R.string.myapp_show_install_history));
        return;
    L18:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L23;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(((com.bytedanceos.appstore.buss.network.h.a) r11).c());
        return;
    }

    public static final void R(MyAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L13;
        MyAppNumEntity r12 = (MyAppNumEntity) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.getGameSubNum() <= 0) goto L17;
        r10.N().f25627f.setVisibility(0);
        r10.N().f25627f.setText(String.valueOf(r12.getGameSubNum()));
        return;
    L17:
        return;
    L13:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L19;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(((com.bytedanceos.appstore.buss.network.h.a) r11).c());
        return;
    }

    public static final void S(MyAppsFragment r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        BinderAdapter r12 = r10.f8598k;
        if (r12 == null) goto L5;
        r12.setList(r11);
    L5:
        r10.r();
    }

    private final String getPageSource() {
        return (String) this.f8593f.getValue();
    }

    @Override // h7.c
    public void E() {
        P().k().i(this, new p0(this));
        P().j().i(this, new q0(this));
        P().h().i(this, new r0(this));
    }

    @Override // h7.c
    public void F() {
        P().i();
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (M().f25515b == null) goto L13;
        Ref$IntRef r10 = new Ref$IntRef();
        com.bytedanceos.appstore.buss.utilities.f r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r12 = r11.f(getActivity());
        r10.element = r12;
        if (r12 == this.f8596i) goto L12;
        RecyclerView.LayoutManager r13 = M().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r13, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager r14 = (GridLayoutManager) r13;
        r14.Q(r10.element);
        r14.R(new d(this, r10));
        this.f8596i = r10.element;
        ViewGroup.LayoutParams r15 = M().f25515b.getLayoutParams();
        r15.width = r10.element * r11.a();
        M().f25515b.setLayoutParams(r15);
        return;
    L12:
        return;
    }

    public final x7.j1 N() {
        x7.j1 r10 = x7.j1.a(m().findViewById(R.id.subscribe_app_layout));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final x7.k1 O() {
        x7.k1 r10 = x7.k1.a(m().findViewById(R.id.uninstalled_app_layout));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final MyAppViewModel P() {
        return (MyAppViewModel) this.f8594g.getValue();
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, getString(R.string.myapp_buy), false, false, 6, null);
        EventBus.getDefault().register(this);
        O().f25645f.setOnClickListener(this);
        N().f25625d.setOnClickListener(this);
        O().f25645f.setEnabled(true);
        N().f25625d.setEnabled(true);
        Ref$IntRef r10 = new Ref$IntRef();
        int r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        r10.element = r11;
        if (r11 != 0) goto L5;
        GridLayoutManager r12 = new GridLayoutManager(l(), this.f8595h);
    L6:
        this.f8596i = r10.element;
        r12.R(new b(this, r10));
        M().f25515b.addItemDecoration(new u7.b(0, 1, null));
        BinderAdapter r13 = new BinderAdapter();
        r13.addItemBinder(String.class, new d7.d(), null);
        d7.c r14 = new d7.c(getPageSource());
        r14.d(new c(this));
        r13.addItemBinder(CommonAppEntity.class, r14, null);
        this.f8598k = r13;
        M().f25515b.setLayoutManager(r12);
        M().f25515b.setAdapter(this.f8598k);
        M().f25515b.setPageSource(getPageSource());
        if (AccountDataCache.b().n() == false) goto L9;
        O().f25643d.setText(getString(R.string.myapp_show_install_history));
    L9:
        Bundle r15 = new Bundle();
        r15.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r15);
        return;
    L5:
        r12 = new GridLayoutManager(l(), r10.element);
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_my_apps;
    }

    @Override // h7.c
    public Function0 o() {
        return MyAppsFragment$onRetryListener$1.INSTANCE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getId());
    L7:
        if (r11 != null) goto L10;
    L15:
        if (r11 != null) goto L18;
        return;
    L18:
        if (r11.intValue() != R.id.subscribe_app_layout) goto L23;
        N().f25625d.setEnabled(false);
        i7.a.g(this, MySubFragment.f8605k.a(), false, 2, null);
        return;
    L23:
        return;
    L10:
        if (r11.intValue() != R.id.uninstalled_app_layout) goto L15;
        if (AccountDataCache.b().n() == false) goto L14;
        O().f25645f.setEnabled(false);
        i7.a.g(this, UninstallAppsFragment.f8672r.a(), false, 2, null);
        return;
    L14:
        CommonUtil.f8830a.h(l(), "page_my_app", true);
        return;
    L5:
        r11 = null;
        goto L7
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8598k = null;
        this.f8599l = null;
        EventBus.getDefault().unregister(this);
        P().m(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull MyAppsEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        P().g();
    }

    @Override // h7.c
    public void t() {
        BaseApplication.c().b().v0("LOCAL_APPS_ONLINE");
        BaseApplication.c().b().A0();
        P().g();
        com.bytedanceos.appstore.datacache.a.N0().B0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull LocalAppsLoadedEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        P().g();
    }
}
