package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.viewmodels.AppWishViewModel;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.utils.BytedanceMenuHelper;
import com.obric.appstore.R;
import com.obric.oui.popover.OPopover;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001$\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0004J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u001f\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R$\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00150,j\b\u0012\u0004\u0012\u00020\u0015`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00150,j\b\u0012\u0004\u0012\u00020\u0015`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010=R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020;8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b<\u0010ER\u001c\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010G8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b?\u0010HR\u0014\u0010M\u001a\u00020J8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006T"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppWishFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "Lp7/c;", "event", "onEvent", "(Lp7/c;)V", "onDestroyView", "Y", "", "", "wishAppList", "X", "(Ljava/util/List;)V", "", "f", "Lkotlin/Lazy;", "getPageSource", "()Ljava/lang/String;", "pageSource", "Lcom/bytedanceos/appstore/buss/viewmodels/AppWishViewModel;", "g", "U", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppWishViewModel;", "viewModel", "com/bytedanceos/appstore/buss/fragment/AppWishFragment$b", "h", "Lcom/bytedanceos/appstore/buss/fragment/AppWishFragment$b;", "appOnLongClickListener", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "i", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "Ljava/util/ArrayList;", "wishDataList", "k", "recommendList", "Lcom/obric/oui/popover/OPopover;", "l", "Lcom/obric/oui/popover/OPopover;", "popupMenu", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "m", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "commonAppEntity", "", "n", "I", "defaultSpanCount", "o", "currentSpanCount", "Lcom/bytedanceos/common/utils/BytedanceMenuHelper$OUIMenuItem$OnMenuItemClickListener;", "p", "Lcom/bytedanceos/common/utils/BytedanceMenuHelper$OUIMenuItem$OnMenuItemClickListener;", "mOnMenuItemClickListener", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "Lx7/s;", "S", "()Lx7/s;", "fragmentTvAppWishBinding", "Lx7/s0;", "T", "()Lx7/s0;", "tvItemAppWishEmptyBinding", "q", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppWishFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWishFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppWishFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,303:1\n106#2,15:304\n57#3,3:319\n57#3,3:322\n50#4,9:325\n50#4,9:334\n*S KotlinDebug\n*F\n+ 1 AppWishFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppWishFragment\n*L\n71#1:304,15\n148#1:319,3\n149#1:322,3\n107#1:325,9\n265#1:334,9\n*E\n"})
public final class AppWishFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f8542q = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f8545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BinderAdapter f8546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f8547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f8548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OPopover f8549l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CommonAppEntity f8550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8551n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener f8553p;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10) {
            AppWishFragment r11 = new AppWishFragment();
            r11.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a(NetKey.PAGE_SOURCE, r10)}));
            return r11;
        }

        public a() {
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppWishFragment f8554a;

        public b(AppWishFragment r10) {
            this.f8554a = r10;
        }

        public void a(View r10, CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "tvEntity");
            AppWishFragment.Q(this.f8554a, r11);
            OPopover r12 = AppWishFragment.O(this.f8554a);
            if (r12 == null) goto L5;
            r12.dismiss();
        L5:
            AppWishFragment r13 = this.f8554a;
            AppWishFragment.R(r13, BytedanceMenuHelper.g(r10, AppWishFragment.N(r13)));
            OPopover r14 = AppWishFragment.O(this.f8554a);
            if (r14 == null) goto L8;
            com.obric.oui.popover.f.a(r14, r10, 80, true, 0.0f, r10.getMeasuredWidth() / 2, r10.getMeasuredHeight() / 2, false);
        L8:
            Bundle r15 = new Bundle();
            r15.putString("long_click_operation", "remove_wish");
            f9.b.b("longpress_appmanager", r15);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    public static final class c extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppWishFragment f8555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8556b;

        public c(AppWishFragment r10, Ref$IntRef r11) {
            this.f8555a = r10;
            this.f8556b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = AppWishFragment.L(this.f8555a);
            if (r11 == null) goto L7;
            List<Object> r12 = r11.getData();
            if (r12 == null) goto L7;
            Object r13 = r12.get(r10);
        L9:
            if ((r13 instanceof CommonAppEntity) == true) goto L16;
            int r14 = this.f8556b.element;
            if (r14 != 0) goto L15;
            return 1;
        L15:
            return r14;
        L16:
            return 1;
        L7:
            r13 = null;
            goto L9
        }
    }

    public static final class d extends GridLayoutManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppWishFragment f8557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f8558b;

        public d(AppWishFragment r10, Ref$IntRef r11) {
            this.f8557a = r10;
            this.f8558b = r11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.b
        public int getSpanSize(int r10) {
            BinderAdapter r11 = AppWishFragment.L(this.f8557a);
            if (r11 == null) goto L7;
            List<Object> r12 = r11.getData();
            if (r12 == null) goto L7;
            Object r13 = r12.get(r10);
        L9:
            if ((r13 instanceof CommonAppEntity) == true) goto L16;
            int r14 = this.f8558b.element;
            if (r14 != 0) goto L15;
            return 1;
        L15:
            return r14;
        L16:
            return 1;
        L7:
            r13 = null;
            goto L9
        }
    }

    static {
        f8542q = new a(null);
    }

    public AppWishFragment() {
        this.f8543f = kotlin.b.b(new AppWishFragment$pageSource$2(this));
        final Function0<Fragment> r10 = new AppWishFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppWishFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8544g = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppWishViewModel.class), new AppWishFragment$special$$inlined$viewModels$default$3(r11), new AppWishFragment$special$$inlined$viewModels$default$4(r12, r11), new AppWishFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f8545h = new b(this);
        this.f8547j = new ArrayList();
        this.f8548k = new ArrayList();
        this.f8551n = 1;
        this.f8552o = 1;
        this.f8553p = new d0(this);
    }

    public static /* synthetic */ boolean G(AppWishFragment r10, BytedanceMenuHelper.OUIMenuItem r11) {
        return V(r10, r11);
    }

    public static /* synthetic */ void H(AppWishFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        W(r10, r11);
    }

    public static /* synthetic */ void I(AppWishFragment r10, List r11) {
        a0(r10, r11);
    }

    public static /* synthetic */ void J(AppWishFragment r10, List r11) {
        b0(r10, r11);
    }

    public static /* synthetic */ void K(AppWishFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        Z(r10, r11);
    }

    public static final /* synthetic */ BinderAdapter L(AppWishFragment r10) {
        return r10.f8546i;
    }

    public static final /* synthetic */ BaseActivity M(AppWishFragment r10) {
        return r10.l();
    }

    public static final /* synthetic */ BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener N(AppWishFragment r10) {
        return r10.f8553p;
    }

    public static final /* synthetic */ OPopover O(AppWishFragment r10) {
        return r10.f8549l;
    }

    public static final /* synthetic */ AppWishViewModel P(AppWishFragment r10) {
        return r10.U();
    }

    public static final /* synthetic */ void Q(AppWishFragment r10, CommonAppEntity r11) {
        r10.f8550m = r11;
    }

    public static final /* synthetic */ void R(AppWishFragment r10, OPopover r11) {
        r10.f8549l = r11;
    }

    public static final boolean V(final AppWishFragment r10, BytedanceMenuHelper.OUIMenuItem r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        CommonAppEntity r12 = r10.f8550m;
        if (r12 == null) goto L7;
        int r13 = r10.f8547j.indexOf(r12);
        if (r13 == (-1)) goto L7;
        r10.U().j().i(r10, new h0(r10));
        r10.U().o(r13, r12);
    L7:
        OPopover r14 = r10.f8549l;
        if (r14 == null) goto L10;
        r14.dismiss();
    L10:
        Bundle r15 = new Bundle();
        r15.putString("long_click_operation", "remove_wish");
        f9.b.b("click_longpress_appmanager", r15);
        return true;
    }

    public static final void W(AppWishFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L13;
        kotlin.jvm.internal.x r12 = kotlin.jvm.internal.x.f21192a;
        CommonAppEntity r13 = r10.f8550m;
        if (r13 == null) goto L10;
        String r14 = r13.getName();
    L11:
        String r15 = r10.getString(R.string.myapp_toast_app_delete, new Object[]{r14});
        kotlin.jvm.internal.q.f(r15, "getString(...)");
        String r16 = String.format(r15, Arrays.copyOf(new Object[0], 0));
        kotlin.jvm.internal.q.f(r16, "format(...)");
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r16);
        return;
    L10:
        r14 = null;
        goto L11
    L13:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L17;
        com.bytedanceos.appstore.buss.network.h.a r17 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r17.c());
        com.bytedanceos.appstore.buss.utilities.s.e(r10, r17.c());
        return;
    }

    public static final void Z(AppWishFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L9;
        r10.r();
        r10.X((List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a());
        return;
    L9:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L20;
        com.bytedanceos.appstore.buss.network.h.a r12 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r12.c());
        r10.r();
        if (r12.b() != (-3)) goto L14;
        r10.Y();
        return;
    L14:
        if (CommonUtil.f8830a.c(r12.b(), r10.l()) == false) goto L16;
        r10.Y();
        return;
    L16:
        r10.D(r12);
        return;
    }

    public static final void a0(AppWishFragment r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        ArrayList r12 = new ArrayList();
        if (r11 == null) goto L5;
        r12.addAll(r11);
    L5:
        r12.addAll(r10.f8548k);
        r10.X(r12);
    }

    public static final void b0(AppWishFragment r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f8548k.clear();
        r10.f8548k.addAll(r11);
    }

    private final String getPageSource() {
        return (String) this.f8543f.getValue();
    }

    @Override // h7.c
    public void E() {
        U().m().i(this, new e0(this));
        U().h().i(this, new f0(this));
        U().k().i(this, new g0(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (S().f25750b == null) goto L13;
        Ref$IntRef r10 = new Ref$IntRef();
        int r11 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        r10.element = r11;
        if (r11 == this.f8552o) goto L12;
        RecyclerView.LayoutManager r12 = S().f25750b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager r13 = (GridLayoutManager) r12;
        r13.Q(r10.element);
        r13.R(new d(this, r10));
        this.f8552o = r10.element;
        return;
    L12:
        return;
    }

    public final x7.s S() {
        x7.s r10 = x7.s.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final x7.s0 T() {
        x7.s0 r10 = x7.s0.a(m().findViewById(R.id.item_wish_empty));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final AppWishViewModel U() {
        return (AppWishViewModel) this.f8544g.getValue();
    }

    public final void X(List r10) {
        if (AccountDataCache.b().n() == true) goto L13;
        T().f25752b.setVisibility(0);
        T().f25754d.setText(getString(R.string.login_alert, new Object[]{getString(R.string.myapp_collection)}));
        T().f25755e.setVisibility(0);
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.isEmpty() == true) goto L29;
        this.f8547j.clear();
        this.f8547j.addAll(r10);
        BinderAdapter r11 = this.f8546i;
        if (r11 == null) goto L28;
        r11.setList(this.f8547j);
        return;
    L28:
        return;
    L29:
        return;
    L13:
        this.f8547j.clear();
        if (r10 != null) goto L16;
    L22:
        T().f25752b.setVisibility(0);
        T().f25754d.setText(getString(R.string.tv_wish_state_empty_text));
        T().f25755e.setVisibility(8);
    L23:
        ArrayList r12 = this.f8547j;
        kotlin.jvm.internal.q.d(r10);
        r12.addAll(r10);
        BinderAdapter r13 = this.f8546i;
        if (r13 == null) goto L30;
        r13.setList(this.f8547j);
        return;
    L30:
        return;
    L16:
        if (r10.isEmpty() == true) goto L22;
        if (r10.size() == this.f8548k.size()) goto L22;
        T().f25752b.setVisibility(8);
        goto L23
    }

    public final void Y() {
        T().f25752b.setVisibility(0);
        T().f25754d.setText(getString(R.string.login_alert, new Object[]{getString(R.string.myapp_collection)}));
        T().f25755e.setVisibility(0);
    }

    @Override // h7.c
    public void initData() {
        EventBus.getDefault().register(this);
        h7.c.w(this, getString(R.string.myapp_collection), false, false, 6, null);
        BinderAdapter r10 = new BinderAdapter();
        d7.c r11 = new d7.c(getPageSource());
        r11.d(this.f8545h);
        r11.g(true);
        r10.addItemBinder(CommonAppEntity.class, r11, null);
        r10.addItemBinder(AppEntityWrap.class, new d7.k(getPageSource()), null);
        this.f8546i = r10;
        S().f25750b.setAdapter(this.f8546i);
        Ref$IntRef r12 = new Ref$IntRef();
        int r13 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        r12.element = r13;
        if (r13 != 0) goto L5;
        GridLayoutManager r14 = new GridLayoutManager(l(), this.f8551n);
    L6:
        this.f8552o = r12.element;
        r14.R(new c(this, r12));
        S().f25750b.setLayoutManager(r14);
        S().f25750b.setPageSource(getPageSource());
        T().f25755e.setOnClickListener(this);
        Bundle r15 = new Bundle();
        r15.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r15);
        return;
    L5:
        r14 = new GridLayoutManager(l(), r12.element);
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_wish;
    }

    @Override // h7.c
    public Function0 o() {
        return new AppWishFragment$onRetryListener$1(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L4;
        Integer r11 = Integer.valueOf(r10.getId());
    L5:
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.intValue() != R.id.tv_login) goto L11;
        CommonUtil.f8830a.h(l(), "page_app_wish", true);
        return;
    L11:
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        this.f8546i = null;
        this.f8547j.clear();
        U().p(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull p7.c r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        if (r10.a() == false) goto L5;
        U().n();
        return;
    L5:
        Y();
    }

    @Override // h7.c
    public void t() {
    }
}
