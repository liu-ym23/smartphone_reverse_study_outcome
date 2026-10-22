package com.bytedanceos.appstore.buss.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemHorizontalAdapter;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PagerTypeAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.viewmodels.AppUpdateViewModel;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.eventbus.AddUpdateEvent;
import com.bytedanceos.common.eventbus.AppStatusEvent;
import com.bytedanceos.common.eventbus.PackageChangeEvent;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.utils.BytedanceMenuHelper;
import com.obric.appstore.R;
import com.obric.oui.popover.OPopover;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001:\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001\\B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0016\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0004R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001d\u0010'\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u0002048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b;\u0010VR\u001c\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010X8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b?\u0010Y¨\u0006]"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppUpdateFragment;", "Lh7/c;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "btnStatus", "", "W", "(Ljava/lang/String;)V", "c0", "d0", "E", "initData", "F", "t", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "Lcom/bytedanceos/common/eventbus/PackageChangeEvent;", "event", "onEvent", "(Lcom/bytedanceos/common/eventbus/PackageChangeEvent;)V", "Lcom/bytedanceos/common/eventbus/AppStatusEvent;", "(Lcom/bytedanceos/common/eventbus/AppStatusEvent;)V", "onDestroyView", "", "f", "Lkotlin/Lazy;", "V", "()Z", "isFromNotification", "g", "T", "updateAll", "h", "getPageSource", "()Ljava/lang/String;", "pageSource", "i", "Z", "appUpdate", "Lcom/bytedanceos/appstore/buss/viewmodels/AppUpdateViewModel;", "j", "U", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppUpdateViewModel;", "viewModel", "Lcom/obric/oui/popover/OPopover;", "k", "Lcom/obric/oui/popover/OPopover;", "popupMenu", "", "l", "I", "defaultSpanCount", "m", "currentSpanCount", "com/bytedanceos/appstore/buss/fragment/AppUpdateFragment$b", "n", "Lcom/bytedanceos/appstore/buss/fragment/AppUpdateFragment$b;", "appLongClickListener", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "o", "Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemHorizontalAdapter;", "updateAdapter", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "p", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "recommendAdapter", "Lx7/r;", "P", "()Lx7/r;", "fragmentTvAppUpdateBinding", "Lx7/p0;", "Q", "()Lx7/p0;", "tvItemAppUpdateEmptyBinding", "Lx7/q0;", "R", "()Lx7/q0;", "tvItemAppUpdateIgnoreBinding", "Lx7/r0;", "S", "()Lx7/r0;", "tvItemAppUpdateUpdateBinding", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "q", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppUpdateFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppUpdateFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppUpdateFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,419:1\n106#2,15:420\n50#3,3:435\n53#3,6:440\n1855#4,2:438\n*S KotlinDebug\n*F\n+ 1 AppUpdateFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppUpdateFragment\n*L\n103#1:420,15\n186#1:435,3\n186#1:440,6\n188#1:438,2\n*E\n"})
public final class AppUpdateFragment extends h7.c implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f8529q = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OPopover f8535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f8538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ItemHorizontalAdapter f8539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PagerTypeAdapter f8540p;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ Fragment b(a r10, boolean r11, boolean r12, String r13, int r14, Object r15) {
            if ((r14 & 2) == 0) goto L6;
            r12 = false;
        L6:
            return r10.a(r11, r12, r13);
        }

        public final Fragment a(boolean r10, boolean r11, String r12) {
            AppUpdateFragment r13 = new AppUpdateFragment();
            r13.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("fromNotification", Boolean.valueOf(r10)), kotlin.d.a("updateAll", Boolean.valueOf(r11)), kotlin.d.a(NetKey.PAGE_SOURCE, r12)}));
            return r13;
        }

        public a() {
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppUpdateFragment f8541a;

        public b(AppUpdateFragment r10) {
            this.f8541a = r10;
        }

        public static /* synthetic */ boolean a(CommonAppEntity r10, AppUpdateFragment r11, BytedanceMenuHelper.OUIMenuItem r12) {
            return c(r10, r11, r12);
        }

        public static final boolean c(CommonAppEntity r10, AppUpdateFragment r11, BytedanceMenuHelper.OUIMenuItem r12) {
            kotlin.jvm.internal.q.g(r10, "$entity");
            kotlin.jvm.internal.q.g(r11, "this$0");
            BaseApplication.c().b().K(r10.convertAppInfo(), true);
            EventBus.getDefault().post(new AddUpdateEvent());
            OPopover r13 = AppUpdateFragment.L(r11);
            if (r13 == null) goto L5;
            r13.dismiss();
        L5:
            Bundle r14 = new Bundle();
            r14.putString("long_click_operation", "ignore_update");
            f9.b.b("click_longpress_appmanager", r14);
            return true;
        }

        public void b(View r10, final CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            OPopover r12 = AppUpdateFragment.L(this.f8541a);
            if (r12 == null) goto L5;
            r12.dismiss();
        L5:
            final AppUpdateFragment r13 = this.f8541a;
            AppUpdateFragment.N(r13, BytedanceMenuHelper.f(r10, new c0(r11, r13)));
            OPopover r14 = AppUpdateFragment.L(this.f8541a);
            if (r14 == null) goto L8;
            com.obric.oui.popover.f.a(r14, r10, 80, true, 0.0f, r10.getMeasuredWidth() / 2, r10.getMeasuredHeight() / 2, false);
        L8:
            Bundle r15 = new Bundle();
            r15.putString("long_click_operation", "ignore_update");
            f9.b.b("longpress_appmanager", r15);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            b((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    static {
        f8529q = new a(null);
    }

    public AppUpdateFragment() {
        this.f8530f = kotlin.b.b(new AppUpdateFragment$isFromNotification$2(this));
        this.f8531g = kotlin.b.b(new AppUpdateFragment$updateAll$2(this));
        this.f8532h = kotlin.b.b(new AppUpdateFragment$pageSource$2(this));
        final Function0<Fragment> r10 = new AppUpdateFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppUpdateFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8534j = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppUpdateViewModel.class), new AppUpdateFragment$special$$inlined$viewModels$default$3(r11), new AppUpdateFragment$special$$inlined$viewModels$default$4(r12, r11), new AppUpdateFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f8536l = 2;
        this.f8537m = 1;
        this.f8538n = new b(this);
    }

    public static /* synthetic */ void G(AppUpdateFragment r10, List r11) {
        Y(r10, r11);
    }

    public static /* synthetic */ void H(AppUpdateFragment r10, Integer r11) {
        Z(r10, r11);
    }

    public static /* synthetic */ void I(AppUpdateFragment r10, Boolean r11) {
        X(r10, r11);
    }

    public static /* synthetic */ void J(AppUpdateFragment r10, Integer r11) {
        b0(r10, r11);
    }

    public static /* synthetic */ void K(AppUpdateFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        a0(r10, r11);
    }

    public static final /* synthetic */ OPopover L(AppUpdateFragment r10) {
        return r10.f8535k;
    }

    public static final /* synthetic */ void M(AppUpdateFragment r10, boolean r11) {
        r10.f8533i = r11;
    }

    public static final /* synthetic */ void N(AppUpdateFragment r10, OPopover r11) {
        r10.f8535k = r11;
    }

    public static final /* synthetic */ void O(AppUpdateFragment r10) {
        r10.d0();
    }

    public static final void X(AppUpdateFragment r10, Boolean r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        TextView r12 = r10.P().f25742e;
        kotlin.jvm.internal.q.d(r11);
        if (r11.booleanValue() == false) goto L5;
        int r13 = 0;
    L6:
        r12.setVisibility(r13);
        return;
    L5:
        r13 = 8;
        goto L6
    }

    public static final void Y(AppUpdateFragment r10, List r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.r();
        if (r11 != null) goto L5;
    L8:
        r10.Q().f25727b.setVisibility(0);
        r10.S().f25747e.setVisibility(8);
    L9:
        ItemHorizontalAdapter r12 = r10.f8539o;
        if (r12 == null) goto L13;
        r12.setList(r11);
        return;
    L13:
        return;
    L5:
        if (r11.isEmpty() == true) goto L8;
        r10.Q().f25727b.setVisibility(8);
        r10.S().f25747e.setVisibility(0);
        r10.d0();
        r10.S().f25746d.setText(r10.getResources().getQuantityString(R.plurals.myapp_update_count, r11.size(), new Object[]{Integer.valueOf(r11.size())}));
        goto L9
    }

    public static final void Z(AppUpdateFragment r10, Integer r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r11 != null) goto L6;
    L8:
        TextView r12 = r10.R().f25737e;
        kotlin.jvm.internal.x r13 = kotlin.jvm.internal.x.f21192a;
        String r14 = r10.getString(R.string.tv_app_ignore_update_amount, new Object[]{r11});
        kotlin.jvm.internal.q.f(r14, "getString(...)");
        String r15 = String.format(r14, Arrays.copyOf(new Object[0], 0));
        kotlin.jvm.internal.q.f(r15, "format(...)");
        r12.setText(r15);
        r10.R().f25734b.setVisibility(0);
        return;
    L6:
        if (r11.intValue() != 0) goto L8;
        r10.R().f25734b.setVisibility(8);
    }

    public static final void a0(AppUpdateFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L21;
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 == null) goto L13;
        Iterator r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        com.bytedanceos.common.utils.h.i(((AppEntityWrap) r13.next()).getApps());
    L13:
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.isEmpty() == true) goto L30;
        PagerTypeAdapter r14 = r10.f8540p;
        if (r14 == null) goto L26;
        r14.setList(r12);
        return;
    L26:
        return;
    L30:
        return;
    L21:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L28;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(((com.bytedanceos.appstore.buss.network.h.a) r11).c());
        return;
    }

    public static final void b0(AppUpdateFragment r10, Integer r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        if (r11 == null) goto L9;
        if (r11.intValue() != 2) goto L9;
        r10.S().f25745c.setAlpha(1.0f);
        r10.f8533i = true;
        r10.S().f25748f.setVisibility(8);
        r10.S().f25745c.setText(r10.getString(R.string.pause_all));
        r10.S().f25745c.setEnabled(true);
        r10.W("update_all");
        return;
    L9:
        if (r11 != null) goto L12;
    L14:
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.intValue() != 1) goto L22;
        r10.S().f25745c.setAlpha(1.0f);
        r10.f8533i = false;
        r10.S().f25748f.setVisibility(0);
        r10.S().f25745c.setText(r10.getString(R.string.update_all));
        r10.S().f25745c.setEnabled(true);
        r10.W("pause_all");
        return;
    L22:
        return;
    L12:
        if (r11.intValue() != 3) goto L14;
        r10.S().f25745c.setAlpha(0.5f);
        r10.S().f25745c.setText(r10.getString(R.string.pause_all));
        r10.S().f25745c.setEnabled(false);
        r10.W("update_all");
    }

    private final String getPageSource() {
        return (String) this.f8532h.getValue();
    }

    @Override // h7.c
    public void E() {
        U().g().i(this, new x(this));
        U().k().i(this, new y(this));
        U().h().i(this, new z(this));
        U().i().i(this, new a0(this));
        U().f().i(this, new b0(this));
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (P().f25740c == null) goto L13;
        com.bytedanceos.appstore.buss.utilities.f r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r11 = r10.f(getActivity());
        if (r11 == this.f8537m) goto L12;
        RecyclerView.LayoutManager r12 = P().f25740c.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r12).Q(r11);
        this.f8537m = r11;
        ViewGroup.LayoutParams r13 = P().f25740c.getLayoutParams();
        r13.width = r11 * r10.a();
        P().f25740c.setLayoutParams(r13);
        return;
    L12:
        return;
    }

    public final x7.r P() {
        x7.r r10 = x7.r.a(m());
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final x7.p0 Q() {
        x7.p0 r10 = x7.p0.a(m().findViewById(R.id.item_empty_layout));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final x7.q0 R() {
        x7.q0 r10 = x7.q0.a(m().findViewById(R.id.item_ignore_layout));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final x7.r0 S() {
        x7.r0 r10 = x7.r0.a(m().findViewById(R.id.update_all_layout));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    public final boolean T() {
        return ((Boolean) this.f8531g.getValue()).booleanValue();
    }

    public final AppUpdateViewModel U() {
        return (AppUpdateViewModel) this.f8534j.getValue();
    }

    public final boolean V() {
        return ((Boolean) this.f8530f.getValue()).booleanValue();
    }

    public final void W(String r10) {
        Bundle r11 = new Bundle();
        r11.putString("update_install_button_status", r10);
        f9.b.b("click_update_Install_all", r11);
    }

    public final void c0() {
        if (com.bytedanceos.common.toolbox.e.A0(l()) == true) goto L5;
        return;
    L5:
        if (this.f8533i == true) goto L17;
        int r10 = com.bytedanceos.common.toolbox.e.A();
        if (r10 == 2) goto L9;
    L13:
        BaseApplication.c().b().v("UPDATE");
        if (r10 == 2) goto L16;
        long r11 = BaseApplication.c().b().F();
        com.bytedanceos.appstore.buss.widget.dialog.g.f9260a.c(l(), r11, AppUpdateFragment$updateAll$5.INSTANCE, new AppUpdateFragment$updateAll$6(this));
        return;
    L16:
        this.f8533i = true;
        d0();
        com.bytedanceos.common.utils.j.h(false);
        return;
    L9:
        if (com.bytedanceos.common.toolbox.s.g(l()) == true) goto L13;
        if (com.bytedanceos.common.toolbox.g0.a().b() == true) goto L13;
        com.bytedanceos.appstore.buss.widget.dialog.j.f9266a.c(l(), new AppUpdateFragment$updateAll$4(this));
        f9.b.b("exposure_dialog_autoupdate", null);
        return;
    L17:
        this.f8533i = false;
        d0();
        com.bytedanceos.common.utils.j.l();
    }

    public final void d0() {
        if (this.f8533i == false) goto L12;
        TextView r10 = S().f25745c;
        if (r10 == null) goto L8;
        r10.setText(getString(R.string.pause_all));
    L8:
        View r11 = S().f25748f;
        if (r11 == null) goto L22;
        r11.setVisibility(8);
        return;
    L22:
        return;
    L12:
        TextView r12 = S().f25745c;
        if (r12 == null) goto L16;
        r12.setText(getString(R.string.update_all));
    L16:
        View r13 = S().f25748f;
        if (r13 == null) goto L23;
        r13.setVisibility(0);
        return;
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, "应用更新", false, false, 6, null);
        P().f25741d.setNewData("应用更新");
        EventBus.getDefault().register(this);
        if (V() == true) goto L12;
        Intent r10 = new Intent();
        if (com.bytedanceos.appstore.utils.d.a() == false) goto L7;
        r10.setAction("com.bytedanceos.appstore.sync.update.apps");
    L8:
        Context r11 = getContext();
        if (r11 == null) goto L12;
        r11.sendBroadcast(r10);
        goto L12
    L7:
        r10.setAction("com.bytedanceos.gamestore.sync.update.apps");
    L12:
        if (T() == false) goto L14;
        c0();
    L14:
        R().f25734b.setOnClickListener(this);
        S().f25745c.setOnClickListener(this);
        int r12 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        if (r12 != 0) goto L17;
        P().f25740c.setLayoutManager(new GridLayoutManager(l(), this.f8536l));
    L18:
        this.f8537m = r12;
        this.f8539o = new ItemHorizontalAdapter(false, this.f8538n, getPageSource(), 1, null);
        P().f25740c.addItemDecoration(new u7.b(0, 1, null));
        P().f25740c.setAdapter(this.f8539o);
        this.f8540p = new PagerTypeAdapter(null, getPageSource(), 1, null);
        P().f25739b.setLayoutManager(new LinearLayoutManager(l()));
        P().f25739b.setAdapter(this.f8540p);
        P().f25739b.setPageSource(getPageSource());
        Bundle r13 = new Bundle();
        r13.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r13);
        return;
    L17:
        P().f25740c.setLayoutManager(new GridLayoutManager(l(), r12));
        goto L18
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_update;
    }

    @Override // h7.c
    public Function0 o() {
        return AppUpdateFragment$onRetryListener$1.INSTANCE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getId());
    L6:
        if (r11 != null) goto L9;
    L11:
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.intValue() != R.id.tv_all_update) goto L18;
        c0();
        return;
    L18:
        return;
    L9:
        if (r11.intValue() != R.id.item_ignore_layout) goto L11;
        i7.a.g(this, AppIgnoreUpdateFragment.f8494p.a(), false, 2, null);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8539o = null;
        this.f8540p = null;
        EventBus.getDefault().unregister(this);
        U().m(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PackageChangeEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        int r11 = r10.getEventStatus();
        if (r11 != 1) goto L5;
    L7:
        EventBus.getDefault().post(new AddUpdateEvent());
        return;
    L5:
        if (r11 == 2) goto L7;
    }

    @Override // h7.c
    public void t() {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull AppStatusEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        List r11 = BaseApplication.c().b().v("UPDATE");
        U().f().m(Integer.valueOf(BaseApplication.c().b().j(r11)));
    }
}
