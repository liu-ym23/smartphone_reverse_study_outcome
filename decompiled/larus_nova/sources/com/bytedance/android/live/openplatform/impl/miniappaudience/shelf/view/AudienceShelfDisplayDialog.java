package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.MicroAppLabel;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAudienceServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.viewmodel.AudienceShelfDisplayViewModel;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.MicroAppLabelListAdapter;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.widget.MaxHeightRecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qq0.h;
import qq0.k;
import qq0.l;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/view/AudienceShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayDialog;", "Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/viewmodel/AudienceShelfDisplayViewModel;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AudienceShelfDisplayDialog extends CommonShelfDisplayDialog<AudienceShelfDisplayViewModel> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f84965v = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<Integer, View> f84966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public to0.a f84967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OpenPlatformContext f84968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f84969m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<ShelfCardInfo> f84970n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f84971o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f84972p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MicroAppLabelListAdapter f84973q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e f84974r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d f84975s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f84976t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f84977u;

    public static final class a {
    }

    public static final class b extends IHostAppMonitorListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceShelfDisplayDialog f84978a;

        public b(AudienceShelfDisplayDialog r100) {
            this.f84978a = r100;
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r101) {
            super.appEnterBackground(r100, r101);
            if (r100 == false) goto L5;
            qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterBackground, caused by app enter background");
            this.f84978a.f84975s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.C1309b.f84952a);
            return;
        L5:
            qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterForeground, caused by app enter foreground");
            this.f84978a.f84975s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.c.f84953a);
            Iterator r102 = ((ArrayList) this.f84978a.f84970n).iterator();
        L7:
            if (r102.hasNext() == false) goto L11;
            ShelfCardInfo r103 = (ShelfCardInfo) r102.next();
            this.f84978a.ca0(r103);
            goto L7
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceShelfDisplayDialog f84979a;

        public c(AudienceShelfDisplayDialog r100) {
            this.f84979a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            to0.a r100 = this.f84979a.f84967k;     // Catch: Throwable -> L10
            if (r100 == null) goto L13;
            OpenPlatformContext r101 = r100.a();     // Catch: Throwable -> L10
            if (r101 != null) goto L7;
            return;
        L7:
            if (((OpenPlatformPerformanceReportService) r101.getService(OpenPlatformPerformanceReportService.class)) == null) goto L18;
            OpenPlatformPerformanceReportService.j(false);     // Catch: Throwable -> L10
            return;
        L18:
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class d implements OnMiniAppLifecycleChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceShelfDisplayDialog f84980a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void a() {
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void c() {
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void b() {
            qo0.a.c("AudienceShelfDisplayDialog", "transit event OpenMiniApp, caused by open miniapp");
            this.f84980a.f84975s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.C1310d.f84954a);
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.context.OnMiniAppLifecycleChangeListener
        public final void d() {
            qo0.a.c("AudienceShelfDisplayDialog", "transit event CloseMiniApp, caused by close miniapp");
            this.f84980a.f84975s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.a.f84951a);
        }

        public d(AudienceShelfDisplayDialog r100) {
            this.f84980a = r100;
        }
    }

    public static final class e implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceShelfDisplayDialog f84981a;

        public e(AudienceShelfDisplayDialog r100) {
            this.f84981a = r100;
        }

        @Override // qq0.k
        public final void a(rq0.a r100, MountedMiniAppSource r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "cardInfo");
            Intrinsics.checkNotNullParameter(r101, "source");
            if (r101 != MountedMiniAppSource.ShelfPageCardActionButton) goto L5;
            String r103 = "view";
        L6:
            OpenPlatformContext r104 = this.f84981a.f84968l;
            if (r104 == null) goto L11;
            AudienceMiniAppAppLogContextService r105 = (AudienceMiniAppAppLogContextService) r104.getService(AudienceMiniAppAppLogContextService.class);
            if (r105 == null) goto L11;
            r105.reportMpLiveLinkShelfCardClick(r100.f538918a, r103, r102, this.f84981a.da0());
        L11:
            OpenPlatformContext r106 = this.f84981a.f84968l;
            if (r106 == null) goto L16;
            AudienceLaunchContextService r107 = (AudienceLaunchContextService) r106.getService(AudienceLaunchContextService.class);
            if (r107 == null) goto L16;
            r107.openMiniApp(r101, r100.f538918a);
        L16:
            OpenPlatformContext r108 = this.f84981a.f84968l;
            if (r108 == null) goto L22;
            AudienceShelfInfoService r109 = (AudienceShelfInfoService) r108.getService(AudienceShelfInfoService.class);
            if (r109 == null) goto L23;
            r109.m(3, r100.getCardId());
            return;
        L23:
            return;
        L22:
            return;
        L5:
            r103 = BrowserDependency.UrlClickType.CARD;
            goto L6
        }
    }

    public static final class f implements com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceShelfDisplayDialog f84982a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.a
        public final void a() {
            OpenPlatformContext r100 = this.f84982a.f84968l;
            if (r100 == null) goto L8;
            AudienceMiniAppAppLogContextService r101 = (AudienceMiniAppAppLogContextService) r100.getService(AudienceMiniAppAppLogContextService.class);
            if (r101 == null) goto L9;
            r101.reportMpLiveLinkShelfShow(this.f84982a.da0());
            return;
        L9:
            return;
        }

        public f(AudienceShelfDisplayDialog r100) {
            this.f84982a = r100;
        }

        @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.a
        public final void b(long r100, long r101) {
            OpenPlatformContext r102 = this.f84982a.f84968l;
            if (r102 == null) goto L8;
            AudienceMiniAppAppLogContextService r103 = (AudienceMiniAppAppLogContextService) r102.getService(AudienceMiniAppAppLogContextService.class);
            if (r103 == null) goto L9;
            r103.reportMpLiveLinkShelfStayTime(r100, r101);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void S90() {
        this.f84966j.clear();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final int U90() {
        ee0 r100 = ee0.f120119a;
        int r101 = r100.getValue().p();
        if (r101 == 1) goto L11;
        if (r101 != 2) goto L9;
        MiniAppDataContext.Companion.getClass();
        if (g.d(MiniAppDataContext.a.b()) == true) goto L11;
    L9:
        return 0;
    L11:
        return UtilityKotlinExtentionsKt.i(r100.getValue().r());
    }

    public AudienceShelfDisplayDialog() {
        this.f84966j = new LinkedHashMap();
        this.f84969m = true;
        this.f84970n = new ArrayList();
        this.f84971o = -1;
        this.f84972p = -1;
        this.f84973q = new MicroAppLabelListAdapter(new ArrayList());
        this.f84974r = new e(this);
        this.f84975s = new com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d(new f(this));
        this.f84976t = new b(this);
        this.f84977u = new d(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final CommonShelfDisplayViewModel Z90() {
        return (AudienceShelfDisplayViewModel) ViewModelProviders.of(this).get(AudienceShelfDisplayViewModel.class);
    }

    public final boolean da0() {
        ShelfMicroAppInfo r100 = W90().getShelfMicroAppInfo().getValue();
        if (r100 == null) goto L5;
        List<MicroAppLabel> r101 = r100.label;
    L6:
        List<MicroAppLabel> r102 = r101;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        return !r103;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final void initView() {
        super.initView();
        View r100 = this.f85063f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r100.setBackgroundResource(R.drawable.ttlive_bg_white_shelf_display_dialog);
        X90().setOnClickListener(new qq0.e(this));
        ((ListView) X90().findViewById(R.id.label_container)).setAdapter(this.f84973q);
        W90().getShelfMicroAppInfo().observe(this, new qq0.f(this));
        W90().getShelfCardInfoList().observe(this, new qq0.a(this));
        W90().getCardListChanged().observe(this, new qq0.b(this));
        W90().getDisplayItemInfoList().observe(this, new qq0.c(this));
        V90().z2(lo0.a.class, new l(new qq0.d(this)));
        V90().z2(rq0.a.class, new h(this.f84974r));
        ((MaxHeightRecyclerView) T90(R.id.shelf_page_list)).addOnScrollListener(new AudienceShelfDisplayDialog$initListView$5(this));
        ((MaxHeightRecyclerView) T90(R.id.shelf_page_list)).post(new c(this));
        OpenPlatformContext r101 = this.f84968l;
        int r102 = 1;
        if (r101 != null) goto L8;
    L10:
        int r103 = no0.a.f519883a;
        no0.a.d(2, r102, 5, "", "");
        return;
    L8:
        if (r101.isInLive() != true) goto L10;
        r102 = 2;
        goto L10
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        OpenPlatformContext r100 = this.f84968l;
        if ((r100 instanceof MiniAppContext) == true) goto L5;
        r100 = null;
    L5:
        MiniAppContext r101 = (MiniAppContext) r100;
        if (r101 == null) goto L8;
        r101.unregisterMiniAppLifecycleChangeListener(this.f84977u);
    L8:
        Lazy r102 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().b(this.f84976t);
        qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterBackground, caused by close shelf");
        this.f84975s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.C1309b.f84952a);
        S90();
    }

    public static final void ba0(AudienceShelfDisplayDialog r110) {
        RecyclerView.LayoutManager r100 = ((MaxHeightRecyclerView) r110.T90(R.id.shelf_page_list)).getLayoutManager();
        if (r100 == null) goto L40;
        int r101 = ((LinearLayoutManager) r100).findFirstVisibleItemPosition();
        RecyclerView.LayoutManager r102 = ((MaxHeightRecyclerView) r110.T90(R.id.shelf_page_list)).getLayoutManager();
        if (r102 == null) goto L38;
        int r103 = ((LinearLayoutManager) r102).findLastVisibleItemPosition();
        List<Object> r104 = r110.W90().getDisplayItemInfoList().getValue();
        if (r104 != null) goto L9;
        return;
    L9:
        if (r103 >= r104.size()) goto L53;
        if (r101 > r103) goto L29;
        int r105 = r101;
    L12:
        Object r106 = ListProtector.get(r104, r105);
        if ((r106 instanceof rq0.a) == false) goto L27;
        Iterator r107 = ((ArrayList) r110.f84970n).iterator();
    L16:
        if (r107.hasNext() == false) goto L23;
        Object r108 = r107.next();
        if (((ShelfCardInfo) r108).getCardId() != ((rq0.a) r106).f538918a.getCardId()) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L16;
    L25:
        if (((ShelfCardInfo) r108) != null) goto L27;
        r110.ca0(((rq0.a) r106).f538918a);
        goto L27
    L20:
        r109 = false;
        goto L21
    L23:
        r108 = null;
    L27:
        if (r105 == r103) goto L29;
        r105 = r105 + 1;
    L29:
        ((ArrayList) r110.f84970n).clear();
        Iterator<T> r111 = r104.subList(r101, r103 + 1).iterator();
    L31:
        if (r111.hasNext() == false) goto L35;
        Object r112 = r111.next();
        if ((r112 instanceof rq0.a) == false) goto L31;
        List<ShelfCardInfo> r113 = r110.f84970n;
        ArrayList r114 = (ArrayList) r113;
        r114.add(((rq0.a) r112).f538918a);
        goto L31
    L35:
        r110.f84971o = r101;
        r110.f84972p = r103;
        return;
    L53:
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final View T90(int r100) {
        if (this.f84966j != null) goto L5;
        this.f84966j = new LinkedHashMap();
    L5:
        Map<Integer, View> r101 = this.f84966j;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        View r103 = (View) r102.get(Integer.valueOf(R.id.shelf_page_list));
        if (r103 != null) goto L14;
        View r104 = getView();
        if (r104 == null) goto L12;
        View r105 = r104.findViewById(R.id.shelf_page_list);
        if (r105 == null) goto L12;
        this.f84966j.put(Integer.valueOf(R.id.shelf_page_list), r105);
        return r105;
    L12:
        return null;
    L14:
        return r103;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog
    public final View Y90(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        ViewStub r101 = (ViewStub) r100.findViewById(R.id.top_view_stub);
        r101.setLayoutResource(R.layout.ttlive_miniapp_shelf_page_audience_top);
        View r102 = r101.inflate();
        int r103 = UtilityKotlinExtentionsKt.i(60);
        Intrinsics.checkNotNullParameter(r102, "$this$setHeight");
        r102.getLayoutParams().height = r103;
        r102.requestLayout();
        return r102;
    }

    public final void ca0(ShelfCardInfo r100) {
        OpenPlatformContext r101 = this.f84968l;
        if (r101 == null) goto L8;
        AudienceMiniAppAppLogContextService r102 = (AudienceMiniAppAppLogContextService) r101.getService(AudienceMiniAppAppLogContextService.class);
        if (r102 == null) goto L9;
        r102.reportMpLiveLinkShelfCardShow(r100, W90().isPinCard(r100), da0());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayDialog, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        OpenPlatformAudienceServiceImpl.Companion.getClass();
        po0.a.b r102 = (po0.a.b) OpenPlatformAudienceServiceImpl.access$getDiComponent$cp();
        r102.getClass();
        to0.a r103 = r102.f530020a.f530023d.get();
        this.f84967k = r103;
        OpenPlatformContext r104 = null;
        if (r103 == null) goto L5;
        OpenPlatformContext r105 = r103.a();
    L6:
        this.f84968l = r105;
        if ((r105 instanceof MiniAppContext) == false) goto L10;
        r104 = r105;
    L10:
        MiniAppContext r106 = (MiniAppContext) r104;
        if (r106 == null) goto L13;
        r106.registerMiniAppLifecycleChangeListener(this.f84977u);
    L13:
        qo0.a.c("AudienceShelfDisplayDialog", "transit event EnterForeground, caused by open shelf");
        this.f84975s.a(com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.d.b.c.f84953a);
        Lazy r107 = HostAppMonitorService.f102946c;
        HostAppMonitorService.a.a().a(this.f84976t);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
