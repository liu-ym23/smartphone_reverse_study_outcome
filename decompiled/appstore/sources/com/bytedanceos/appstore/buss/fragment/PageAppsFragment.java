package com.bytedanceos.appstore.buss.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.appstore.buss.adapter.app.pager.adapter.PageAppsAdapter;
import com.bytedanceos.appstore.buss.adapter.nav.EntityVideoProvider;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.viewmodels.PageAppsViewModel;
import com.bytedanceos.common.eventbus.AppStatusEvent;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.obric.appstore.R;
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
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010.RQ\u0010<\u001a<\u0012\u0013\u0012\u001101¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0013\u0012\u001105¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u000400j\b\u0012\u0004\u0012\u000205`78\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u001aR\u001c\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010C8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006H"}, d2 = {"Lcom/bytedanceos/appstore/buss/fragment/PageAppsFragment;", "Lh7/c;", "<init>", "()V", "", "E", "initData", "F", "t", "Lcom/bytedanceos/common/eventbus/AppStatusEvent;", "event", "onEvent", "(Lcom/bytedanceos/common/eventbus/AppStatusEvent;)V", "onResume", "onPause", "onDestroyView", "R", "", "f", "Lkotlin/Lazy;", "Q", "()Ljava/lang/String;", "title", "", "g", "P", "()I", "source", "h", "N", "pageId", "", "i", "O", "()Z", "showHomeAsUp", "j", "getPageSource", "pageSource", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PageAppsAdapter;", "k", "Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PageAppsAdapter;", "tvAppAdapter", "Lcom/bytedanceos/appstore/buss/viewmodels/PageAppsViewModel;", "l", "M", "()Lcom/bytedanceos/appstore/buss/viewmodels/PageAppsViewModel;", NetKey.MODEL, "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "m", "Lkotlin/jvm/functions/Function2;", "getVideoItemClickListener", "()Lkotlin/jvm/functions/Function2;", "videoItemClickListener", "Lx7/d;", "L", "()Lx7/d;", "commonRecyclerViewBinding", "n", "layoutId", "Lkotlin/Function0;", "o", "()Lkotlin/jvm/functions/Function0;", "onRetryListener", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPageAppsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PageAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/PageAppsFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 NetSource.kt\ncom/bytedanceos/appstore/buss/network/NetSourceKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,186:1\n106#2,15:187\n50#3,3:202\n53#3,6:209\n1855#4:205\n1855#4,2:206\n1856#4:208\n*S KotlinDebug\n*F\n+ 1 PageAppsFragment.kt\ncom/bytedanceos/appstore/buss/fragment/PageAppsFragment\n*L\n79#1:187,15\n86#1:202,3\n86#1:209,6\n94#1:205\n103#1:206,2\n94#1:208\n*E\n"})
public final class PageAppsFragment extends h7.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8615n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f8619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f8620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PageAppsAdapter f8621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f8622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function2 f8623m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Fragment a(String r10, Integer r11, Integer r12, boolean r13, String r14) {
            PageAppsFragment r15 = new PageAppsFragment();
            r15.setArguments(androidx.core.os.c.a(new Pair[]{kotlin.d.a("title", r10), kotlin.d.a("source", r11), kotlin.d.a("pageId", r12), kotlin.d.a("showHomeAsUp", Boolean.valueOf(r13)), kotlin.d.a(NetKey.PAGE_SOURCE, r14)}));
            return r15;
        }

        public a() {
        }
    }

    public static final class b implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PageAppsFragment f8624a;

        public b(PageAppsFragment r10) {
            this.f8624a = r10;
        }

        public void a(View r10, AppEntityWrap r11) {
            kotlin.jvm.internal.q.g(r10, "view");
            kotlin.jvm.internal.q.g(r11, "entity");
            PageAppsFragment.K(this.f8624a);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(Object r10, Object r11) {
            a((View) r10, (AppEntityWrap) r11);
            return Unit.f21064a;
        }
    }

    static {
        f8615n = new a(null);
    }

    public PageAppsFragment() {
        this.f8616f = kotlin.b.b(new PageAppsFragment$title$2(this));
        this.f8617g = kotlin.b.b(new PageAppsFragment$source$2(this));
        this.f8618h = kotlin.b.b(new PageAppsFragment$pageId$2(this));
        this.f8619i = kotlin.b.b(new PageAppsFragment$showHomeAsUp$2(this));
        this.f8620j = kotlin.b.b(new PageAppsFragment$pageSource$2(this));
        Function0<ViewModelProvider.Factory> r10 = new PageAppsFragment$model$2(this);
        final Function0<Fragment> r11 = new PageAppsFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r12 = kotlin.b.a(LazyThreadSafetyMode.NONE, new PageAppsFragment$special$$inlined$viewModels$default$2(r11));
        final Function0 r13 = null;
        this.f8622l = FragmentViewModelLazyKt.c(this, kotlin.jvm.internal.u.b(PageAppsViewModel.class), new PageAppsFragment$special$$inlined$viewModels$default$3(r12), new PageAppsFragment$special$$inlined$viewModels$default$4(r13, r12), r10);
        this.f8623m = new b(this);
    }

    public static /* synthetic */ void G(PageAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        S(r10, r11);
    }

    public static final /* synthetic */ PageAppsViewModel H(PageAppsFragment r10) {
        return r10.M();
    }

    public static final /* synthetic */ int I(PageAppsFragment r10) {
        return r10.N();
    }

    public static final /* synthetic */ int J(PageAppsFragment r10) {
        return r10.P();
    }

    public static final /* synthetic */ void K(PageAppsFragment r10) {
        r10.R();
    }

    private final x7.d L() {
        x7.d r10 = x7.d.a(m().findViewById(R.id.recycler_view));
        kotlin.jvm.internal.q.f(r10, "bind(...)");
        return r10;
    }

    private final boolean O() {
        return ((Boolean) this.f8619i.getValue()).booleanValue();
    }

    private final int P() {
        return ((Number) this.f8617g.getValue()).intValue();
    }

    private final String Q() {
        return (String) this.f8616f.getValue();
    }

    public static final void S(PageAppsFragment r10, com.bytedanceos.appstore.buss.network.h r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.d(r11);
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.b) == false) goto L6;
        r10.B();
        return;
    L6:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.c) == false) goto L49;
        List r12 = (List) ((com.bytedanceos.appstore.buss.network.h.c) r11).a();
        if (r12 != null) goto L10;
    L47:
        h7.c.A(r10, null, null, 0, 7, null);
        return;
    L10:
        if (r12.isEmpty() == true) goto L47;
        r10.r();
        Iterator r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L44;
        AppEntityWrap r14 = (AppEntityWrap) r13.next();
        String r15 = r14.getTemplate();
        if (r15 != null) goto L18;
    L20:
        String r16 = r14.getTemplate();
        if (r16 != null) goto L23;
    L34:
        com.bytedanceos.common.utils.h.i(r14.getApps());
        if (r14.getVideo_img() == null) goto L14;
        if (r14.getVideo_url() == null) goto L14;
        List<CommonAppEntity> r17 = r14.getApps();
        if (r17 == null) goto L14;
        Iterator<T> r18 = r17.iterator();
    L42:
        if (r18.hasNext() == false) goto L14;
        ((CommonAppEntity) r18.next()).setPageTitle(r10.Q());
        goto L42
    L23:
        if (Integer.parseInt(r16) != 12) goto L34;
    L24:
        List<CommonAppEntity> r19 = r14.getApps();
        List<CommonAppEntity> r20 = null;
        if (r19 == null) goto L27;
        Integer r21 = Integer.valueOf(r19.size());
    L28:
        kotlin.jvm.internal.q.d(r21);
        if (r21.intValue() <= 8) goto L34;
        List<CommonAppEntity> r22 = r14.getApps();
        if (r22 == null) goto L33;
        r20 = r22.subList(0, 8);
    L33:
        r14.setApps(r20);
        goto L34
    L27:
        r21 = null;
        goto L28
    L18:
        if (Integer.parseInt(r15) != 11) goto L20;
    L44:
        PageAppsAdapter r23 = r10.f8621k;
        if (r23 == null) goto L62;
        r23.setList(r12);
        return;
    L62:
        return;
    L49:
        if ((r11 instanceof com.bytedanceos.appstore.buss.network.h.a) == false) goto L65;
        com.bytedanceos.appstore.buss.network.h.a r24 = (com.bytedanceos.appstore.buss.network.h.a) r11;
        com.bytedanceos.appstore.buss.utilities.j.f8856a.c(r24.c());
        r10.D(r24);
        return;
    }

    private final String getPageSource() {
        return (String) this.f8620j.getValue();
    }

    @Override // h7.c
    public void E() {
        M().i().i(this, new u0(this));
    }

    @Override // h7.c
    public void F() {
    }

    public final PageAppsViewModel M() {
        return (PageAppsViewModel) this.f8622l.getValue();
    }

    public final int N() {
        return ((Number) this.f8618h.getValue()).intValue();
    }

    public final void R() {
        ComponentName r10 = new ComponentName("com.bytedanceos.manual", "com.bytedanceos.manual.activity.StartVideoActivity");     // Catch: Exception -> L5
        Intent r11 = new Intent();     // Catch: Exception -> L5
        r11.setComponent(r10);     // Catch: Exception -> L5
        r11.putExtra("video_name", "onestep_video");     // Catch: Exception -> L5
        Context r12 = getContext();     // Catch: Exception -> L5
        if (r12 == null) goto L7;
        r12.startActivity(r11);     // Catch: Exception -> L5
    L7:
        f9.b.b("click_video_pages_onestep", null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedanceos.common.toolbox.j.b(e.getMessage());
    }

    @Override // h7.c
    public void initData() {
        EventBus.getDefault().register(this);
        h7.c.w(this, Q(), O(), false, 4, null);
        u(Q());
        PageAppsAdapter r10 = new PageAppsAdapter(getPageSource());
        EntityVideoProvider r11 = new EntityVideoProvider();
        r11.b(this.f8623m);
        r10.addItemProvider(r11);
        this.f8621k = r10;
        L().f25515b.setLayoutManager(new LinearLayoutManager(l()));
        L().f25515b.setAdapter(this.f8621k);
        L().f25515b.setPageSource(getPageSource());
        Bundle r12 = new Bundle();
        r12.putString(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, getPageSource());
        f9.b.b("exposure_pages_main", r12);
    }

    @Override // h7.c
    public int n() {
        return R.layout.fragment_tv_page_apps;
    }

    @Override // h7.c
    public Function0 o() {
        return new PageAppsFragment$onRetryListener$1(this);
    }

    @Override // h7.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        M().j(this);
        PageAppsAdapter r10 = this.f8621k;
        if (r10 == null) goto L5;
        r10.b();
    L5:
        this.f8621k = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull AppStatusEvent r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        if (N() != 2) goto L8;
        PageAppsAdapter r11 = this.f8621k;
        if (r11 == null) goto L9;
        r11.notifyItemRangeChanged(0, 2);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PageAppsAdapter r10 = this.f8621k;
        if (r10 == null) goto L6;
        r10.onPause();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PageAppsAdapter r10 = this.f8621k;
        if (r10 == null) goto L6;
        r10.onResume();
        return;
    }

    @Override // h7.c
    public void t() {
    }
}
