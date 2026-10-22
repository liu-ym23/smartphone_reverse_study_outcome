package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.bytedanceos.appstore.buss.adapter.BinderAdapter;
import com.bytedanceos.appstore.buss.base.BaseActivity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.appstore.buss.viewmodels.UninstallAppsViewModel;
import com.bytedanceos.common.eventbus.MyAppsEvent;
import com.bytedanceos.common.eventbus.PackageChangeEvent;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.utils.BytedanceMenuHelper;
import com.obric.appstore.R;
import com.obric.oui.popover.OPopover;
import com.obric.oui.titlebar.OCTitleBar;
import com.tmall.wireless.tangram.eventbus.BusSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001T\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u000e\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0006J\u001f\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0004\b%\u0010\u0006R!\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010/R$\u00107\u001a\u0012\u0012\u0004\u0012\u00020'03j\b\u0012\u0004\u0012\u00020'`48\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010)\u001a\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JRH\u0010S\u001a6\u0012\u0013\u0012\u00110\u0016¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110'¢\u0006\f\bM\u0012\b\bN\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u00070Lj\u0002`Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010]\u001a\u00020-8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\\R\u001c\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010^8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010_¨\u0006c"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment;", "Lh7/c;", "Ljava/util/Observer;", "Landroid/view/View$OnClickListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "<init>", "()V", "", "E", "initData", "F", "t", "Lcom/bytedanceos/common/eventbus/PackageChangeEvent;", "event", "onEvent", "(Lcom/bytedanceos/common/eventbus/PackageChangeEvent;)V", "Ljava/util/Observable;", "o", "", "arg", "update", "(Ljava/util/Observable;Ljava/lang/Object;)V", "Landroid/view/View;", "v", BusSupport.EVENT_ON_CLICK, "(Landroid/view/View;)V", "Lcom/bytedanceos/common/eventbus/MyAppsEvent;", "(Lcom/bytedanceos/common/eventbus/MyAppsEvent;)V", "onDestroyView", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "onCheckedChanged", "(Landroid/widget/CompoundButton;Z)V", "T", "W", "V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "f", "Lkotlin/Lazy;", "R", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "itemData", "", "g", "I", "defaultSpanCount", "h", "currentSpanCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "selectedData", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "j", "Lcom/bytedanceos/appstore/buss/adapter/BinderAdapter;", "adapter", "Lcom/obric/oui/titlebar/OCTitleBar;", "k", "Lcom/obric/oui/titlebar/OCTitleBar;", "toolbar", "l", "Z", "showEdit", "Lcom/bytedanceos/appstore/buss/viewmodels/UninstallAppsViewModel;", "m", "S", "()Lcom/bytedanceos/appstore/buss/viewmodels/UninstallAppsViewModel;", "uninstallAppsViewModel", "Lcom/obric/oui/popover/OPopover;", "n", "Lcom/obric/oui/popover/OPopover;", "popupMenu", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnLongClickListener;", "Lkotlin/jvm/functions/Function2;", "appOnLongClickListener", "com/bytedanceos/appstore/buss/fragment/UninstallAppsFragment$c", "p", "Lcom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment$c;", "editAppOnClickListener", "Ld7/c;", "q", "Ld7/c;", "horizontalBinder", "()I", "layoutId", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "r", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUninstallAppsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UninstallAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n*L\n1#1,592:1\n106#2,15:593\n1855#3,2:608\n1855#3,2:610\n50#4,9:612\n*S KotlinDebug\n*F\n+ 1 UninstallAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/UninstallAppsFragment\n*L\n84#1:593,15\n577#1:608,2\n584#1:610,2\n157#1:612,9\n*E\n"})
public final class UninstallAppsFragment extends h7.c implements Observer, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f8672r = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8674g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f8676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BinderAdapter f8677j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OCTitleBar f8678k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8679l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f8680m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OPopover f8681n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function2 f8682o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f8683p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d7.c f8684q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a() {
            return new UninstallAppsFragment();
        }

        public a() {
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UninstallAppsFragment f8685a;

        public b(UninstallAppsFragment r10) {
            this.f8685a = r10;
        }

        public static /* synthetic */ boolean a(UninstallAppsFragment r10, CommonAppEntity r11, BytedanceMenuHelper.OUIMenuItem r12) {
            return c(r10, r11, r12);
        }

        public static final boolean c(UninstallAppsFragment r10, CommonAppEntity r11, BytedanceMenuHelper.OUIMenuItem r12) {
            kotlin.jvm.internal.q.g(r10, "this$0");
            kotlin.jvm.internal.q.g(r11, "$entity");
            if (com.bytedanceos.common.toolbox.e.A0(UninstallAppsFragment.H(r10)) == false) goto L5;
            UninstallAppsFragment.M(r10).f(kotlin.collections.s.e(r11));
        L6:
            OPopover r13 = UninstallAppsFragment.K(r10);
            if (r13 == null) goto L9;
            r13.dismiss();
        L9:
            Bundle r14 = new Bundle();
            r14.putString("long_click_operation", "delete_uninstall_app");
            f9.b.b("click_longpress_appmanager", r14);
            return true;
        L5:
            String r15 = r10.getString(R.string.retry_connection);
            kotlin.jvm.internal.q.f(r15, "getString(...)");
            com.bytedanceos.appstore.buss.utilities.s.e(r10, r15);
            goto L6
        }

        public void b(View r10, final CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            OPopover r12 = UninstallAppsFragment.K(this.f8685a);
            if (r12 == null) goto L5;
            r12.dismiss();
        L5:
            final UninstallAppsFragment r13 = this.f8685a;
            UninstallAppsFragment.O(r13, BytedanceMenuHelper.e(r10, new o1(r13, r11)));
            OPopover r14 = UninstallAppsFragment.K(this.f8685a);     // Catch: Exception -> L9
            if (r14 == null) goto L11;
            com.obric.oui.popover.f.a(r14, r10, 80, true, 0.0f, r10.getMeasuredWidth() / 2, r10.getMeasuredHeight() / 2, false);     // Catch: Exception -> L9
        L11:
            Bundle r15 = new Bundle();     // Catch: Exception -> L9
            r15.putString("long_click_operation", "delete_uninstall_app");     // Catch: Exception -> L9
            f9.b.b("longpress_appmanager", r15);     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            b((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    public static final class c implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UninstallAppsFragment f8686a;

        public c(UninstallAppsFragment r10) {
            this.f8686a = r10;
        }

        public void a(View r10, CommonAppEntity r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            if (r11.getCheckState() == false) goto L5;
            UninstallAppsFragment.L(this.f8686a).add(r11);
        L6:
            UninstallAppsFragment.Q(this.f8686a);
            return;
        L5:
            UninstallAppsFragment.L(this.f8686a).remove(r11);
            goto L6
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (CommonAppEntity) r11);
            return Unit.f21064a;
        }
    }

    static {
        f8672r = new a(null);
    }

    public UninstallAppsFragment() {
        this.f8673f = kotlin.b.b(UninstallAppsFragment$itemData$2.INSTANCE);
        this.f8674g = 1;
        this.f8675h = 1;
        this.f8676i = new ArrayList();
        final Function0<Fragment> r10 = new UninstallAppsFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new UninstallAppsFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f8680m = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(UninstallAppsViewModel.class), new UninstallAppsFragment$special$$inlined$viewModels$default$3(r11), new UninstallAppsFragment$special$$inlined$viewModels$default$4(r12, r11), new UninstallAppsFragment$special$$inlined$viewModels$default$5(this, r11));
        b r13 = new b(this);
        this.f8682o = r13;
        c r14 = new c(this);
        this.f8683p = r14;
        d7.c r15 = new d7.c("page_uninstall_apps");
        r15.d(r13);
        r15.f(r14);
        this.f8684q = r15;
    }

    public static /* synthetic */ void G(UninstallAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        U(r10, r11);
    }

    public static final /* synthetic */ BaseActivity H(UninstallAppsFragment r10) {
        return r10.l();
    }

    public static final /* synthetic */ d7.c I(UninstallAppsFragment r10) {
        return r10.f8684q;
    }

    public static final /* synthetic */ CopyOnWriteArrayList J(UninstallAppsFragment r10) {
        return r10.R();
    }

    public static final /* synthetic */ OPopover K(UninstallAppsFragment r10) {
        return r10.f8681n;
    }

    public static final /* synthetic */ ArrayList L(UninstallAppsFragment r10) {
        return r10.f8676i;
    }

    public static final /* synthetic */ UninstallAppsViewModel M(UninstallAppsFragment r10) {
        return r10.S();
    }

    public static final /* synthetic */ void N(UninstallAppsFragment r10) {
        r10.T();
    }

    public static final /* synthetic */ void O(UninstallAppsFragment r10, OPopover r11) {
        r10.f8681n = r11;
    }

    public static final /* synthetic */ void P(UninstallAppsFragment r10, boolean r11) {
        r10.f8679l = r11;
    }

    public static final /* synthetic */ void Q(UninstallAppsFragment r10) {
        r10.V();
    }

    public static final void U(UninstallAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L19;
        r10.r();
        r10.R().clear();
        r10.f8676i.clear();
        Map r12 = (Map) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
    L13:
        String r13 = r10.getString(R.string.tv_uninstall_app_state_empty_title_text);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        r10.z(r13, r10.getString(R.string.tv_uninstall_app_state_empty_desc_text), R.drawable.icon_tv_uninstall_empty);
    L14:
        BinderAdapter r14 = r10.f8677j;
        if (r14 == null) goto L17;
        r14.setList(r10.R());
    L17:
        r10.W();
        return;
    L10:
        if (r12.isEmpty() == true) goto L13;
        r10.R().addAll(r12.values());
        goto L14
    L19:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L30;
        com.bytedanceos.appstore.buss.network.h.a r15 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r15.c());
        if (AccountDataCache.b().n() == true) goto L23;
    L26:
        String r16 = r10.getString(R.string.tv_uninstall_app_state_empty_desc_text);
        kotlin.jvm.internal.q.f(r16, "getString(...)");
        String r17 = r10.getString(R.string.tv_uninstall_app_state_empty_title_text);
        kotlin.jvm.internal.q.f(r17, "getString(...)");
        String r18 = r10.getString(R.string.loginBtn);
        kotlin.jvm.internal.q.f(r18, "getString(...)");
        r10.C(R.drawable.icon_tv_uninstall_empty, r16, r17, r18);
        return;
    L23:
        if (CommonUtil.f8830a.b(r15.b()) == true) goto L26;
        r10.D(r15);
        return;
    }

    @Override // h7.c
    public void E() {
        S().g().i(this, new n1(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final CopyOnWriteArrayList R() {
        return (CopyOnWriteArrayList) this.f8673f.getValue();
    }

    public final UninstallAppsViewModel S() {
        return (UninstallAppsViewModel) this.f8680m.getValue();
    }

    public final void T() {
    }

    public final void V() {
    }

    public final void W() {
    }

    @Override // h7.c
    public void initData() {
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_uninstall_apps;
    }

    @Override // h7.c
    public Function0 o() {
        return new UninstallAppsFragment$onRetryListener$1(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "buttonView");
        this.f8676i.clear();
        if (r11 == false) goto L11;
        Iterator r12 = R().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        ((CommonAppEntity) r12.next()).setCheckState(true);
        goto L6
    L8:
        this.f8676i.addAll(R());
        BinderAdapter r13 = this.f8677j;
        if (r13 == null) goto L18;
        r13.notifyDataSetChanged();
    L18:
        V();
        return;
    L11:
        Iterator r14 = R().iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        ((CommonAppEntity) r14.next()).setCheckState(false);
        goto L13
    L15:
        BinderAdapter r15 = this.f8677j;
        if (r15 == null) goto L18;
        r15.notifyDataSetChanged();
        goto L18
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull MyAppsEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
    }

    @Override // h7.c
    public void t() {
    }

    @Override // java.util.Observer
    public void update(Observable r10, Object r11) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PackageChangeEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        int r11 = r10.getEventStatus();
        if (r11 != 1) goto L5;
    L7:
        S().h();
        if (this.f8679l == false) goto L13;
        OCTitleBar r12 = this.f8678k;
        if (r12 == null) goto L14;
        String r13 = getResources().getQuantityString(R.plurals.header_selected_item, this.f8676i.size(), new Object[]{Integer.valueOf(this.f8676i.size())});
        kotlin.jvm.internal.q.f(r13, "getQuantityString(...)");
        r12.setCenterText(r13);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r11 == 2) goto L7;
    }
}
