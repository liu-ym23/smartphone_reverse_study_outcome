package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.viewmodels.AppIgnoreUpdateViewModel;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.utils.BytedanceMenuHelper;
import com.obric.appstore.R;
import com.obric.oui.popover.OPopover;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001-\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0016j\b\u0012\u0004\u0012\u00020\u0012`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R'\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120(0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u00104R\u0014\u00109\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020!8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010:R\u001c\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010<8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010=¨\u0006A"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/AppIgnoreUpdateFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "onDestroyView", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "f", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Lcom/obric/oui/popover/OPopover;", "g", "Lcom/obric/oui/popover/OPopover;", "popupMenu", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "h", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "commonAppEntity", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "data", "Lcom/bytedanceos/appstore/buss/viewmodels/AppIgnoreUpdateViewModel;", "j", "Lkotlin/Lazy;", "Q", "()Lcom/bytedanceos/appstore/buss/viewmodels/AppIgnoreUpdateViewModel;", "viewModel", "", "k", "I", "defaultSpanCount", "l", "currentSpanCount", "Landroidx/lifecycle/Observer;", "", "m", "P", "()Landroidx/lifecycle/Observer;", "observer", "com/bytedanceos/appstore/buss/fragment/AppIgnoreUpdateFragment$b", "n", "Lcom/bytedanceos/appstore/buss/fragment/AppIgnoreUpdateFragment$b;", "appOnLongClickListener", "Lcom/bytedanceos/common/utils/BytedanceMenuHelper$OUIMenuItem$OnMenuItemClickListener;", "o", "O", "()Lcom/bytedanceos/common/utils/BytedanceMenuHelper$OUIMenuItem$OnMenuItemClickListener;", "mOnMenuItemClickListener", "Lx7/d;", "N", "()Lx7/d;", "commonRecyclerViewBinding", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "p", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppIgnoreUpdateFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppIgnoreUpdateFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppIgnoreUpdateFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,172:1\n106#2,15:173\n57#3,3:188\n1864#4,3:191\n*S KotlinDebug\n*F\n+ 1 AppIgnoreUpdateFragment.kt\ncom/bytedanceos/appstore/buss/fragment/AppIgnoreUpdateFragment\n*L\n53#1:173,15\n91#1:188,3\n101#1:191,3\n*E\n"})
public final class AppIgnoreUpdateFragment extends h7.c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f8494p = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BinderAdapter f8495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OPopover f8496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonAppEntity f8497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f8498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f8502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f8503n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f8504o;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a() {
            return new AppIgnoreUpdateFragment();
        }

        public a() {
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppIgnoreUpdateFragment f8505a;

        public b(AppIgnoreUpdateFragment r10) {
            this.f8505a = r10;
        }

        public void a(View r10, CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "tvEntity");
            AppIgnoreUpdateFragment.L(this.f8505a, r11);
            OPopover r12 = AppIgnoreUpdateFragment.J(this.f8505a);
            if (r12 == null) goto L5;
            r12.dismiss();
        L5:
            AppIgnoreUpdateFragment r13 = this.f8505a;
            AppIgnoreUpdateFragment.M(r13, BytedanceMenuHelper.c(r10, AppIgnoreUpdateFragment.I(r13)));
            OPopover r14 = AppIgnoreUpdateFragment.J(this.f8505a);
            if (r14 == null) goto L8;
            com.obric.oui.popover.f.a(r14, r10, 80, true, 0.0f, r10.getMeasuredWidth() / 2, r10.getMeasuredHeight() / 2, false);
        L8:
            Bundle r15 = new Bundle();
            r15.putString("long_click_operation", "cancle_ignore_update");
            f9.b.b("longpress_appmanager", r15);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    static {
        f8494p = new a(null);
    }

    public AppIgnoreUpdateFragment() {
        this.f8498i = new ArrayList();
        final Function0<Fragment> r10 = new AppIgnoreUpdateFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new AppIgnoreUpdateFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8499j = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(AppIgnoreUpdateViewModel.class), new AppIgnoreUpdateFragment$special$$inlined$viewModels$default$3(r11), new AppIgnoreUpdateFragment$special$$inlined$viewModels$default$4(r12, r11), new AppIgnoreUpdateFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f8500k = 1;
        this.f8501l = 1;
        this.f8502m = kotlin.b.b(new AppIgnoreUpdateFragment$observer$2(this));
        this.f8503n = new b(this);
        this.f8504o = kotlin.b.b(new AppIgnoreUpdateFragment$mOnMenuItemClickListener$2(this));
    }

    public static final /* synthetic */ BinderAdapter G(AppIgnoreUpdateFragment r10) {
        return r10.f8495f;
    }

    public static final /* synthetic */ CommonAppEntity H(AppIgnoreUpdateFragment r10) {
        return r10.f8497h;
    }

    public static final /* synthetic */ BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener I(AppIgnoreUpdateFragment r10) {
        return r10.O();
    }

    public static final /* synthetic */ OPopover J(AppIgnoreUpdateFragment r10) {
        return r10.f8496g;
    }

    public static final /* synthetic */ AppIgnoreUpdateViewModel K(AppIgnoreUpdateFragment r10) {
        return r10.Q();
    }

    public static final /* synthetic */ void L(AppIgnoreUpdateFragment r10, CommonAppEntity r11) {
        r10.f8497h = r11;
    }

    public static final /* synthetic */ void M(AppIgnoreUpdateFragment r10, OPopover r11) {
        r10.f8496g = r11;
    }

    private final x7.d N() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    private final Observer P() {
        return (Observer) this.f8502m.getValue();
    }

    @Override // h7.c
    public void E() {
        Q().f().i(this, P());
    }

    @Override // h7.c
    public void F() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (N().f25515b == null) goto L13;
        com.bytedanceos.appstore.buss.utilities.f r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a;
        int r11 = r10.f(getActivity());
        if (r11 == this.f8501l) goto L12;
        RecyclerView.LayoutManager r12 = N().f25515b.getLayoutManager();
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) r12).Q(r11);
        this.f8501l = r11;
        ViewGroup.LayoutParams r13 = N().f25515b.getLayoutParams();
        r13.width = r11 * r10.a();
        N().f25515b.setLayoutParams(r13);
        return;
    L12:
        return;
    }

    public final BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener O() {
        return (BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener) this.f8504o.getValue();
    }

    public final AppIgnoreUpdateViewModel Q() {
        return (AppIgnoreUpdateViewModel) this.f8499j.getValue();
    }

    @Override // h7.c
    public void initData() {
        h7.c.w(this, getString(R.string.update_footer_text), true, false, 4, null);
        int r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a.f(getActivity());
        if (r10 != 0) goto L5;
        N().f25515b.setLayoutManager(new GridLayoutManager(l(), this.f8500k));
    L6:
        this.f8501l = r10;
        BinderAdapter r11 = new BinderAdapter();
        d7.c r12 = new d7.c("page_ignore_update");
        r12.d(this.f8503n);
        r11.addItemBinder(CommonAppEntity.class, r12, null);
        this.f8495f = r11;
        N().f25515b.setAdapter(this.f8495f);
        int r13 = 0;
        N().f25515b.addItemDecoration(new u7.b(0, 1, null));
        N().f25515b.setPageSource("page_ignore_update");
        List r14 = BaseApplication.c().b().v("HIDE");
        this.f8498i.clear();
        kotlin.jvm.internal.q.d(r14);
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L13;
        Object r16 = r15.next();
        int r17 = r13 + 1;
        if (r13 >= 0) goto L12;
        kotlin.collections.t.q();
    L12:
        this.f8498i.add(com.bytedanceos.appstore.utils.a.e((AppInfo) r16));
        r13 = r17;
        goto L8
    L13:
        BinderAdapter r18 = this.f8495f;
        if (r18 == null) goto L16;
        r18.setList(this.f8498i);
    L16:
        Bundle r19 = new Bundle();
        r19.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "page_ignore_update");
        f9.b.b("exposure_pages_main", r19);
        return;
    L5:
        N().f25515b.setLayoutManager(new GridLayoutManager(l(), r10));
        goto L6
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_app_ignore_update;
    }

    @Override // h7.c
    public Function0 o() {
        return null;
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8495f = null;
        Q().i(this);
    }

    @Override // h7.c
    public void t() {
        r();
    }
}
