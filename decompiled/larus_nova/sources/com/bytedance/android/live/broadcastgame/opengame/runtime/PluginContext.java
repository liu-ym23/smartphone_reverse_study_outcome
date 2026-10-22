package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService;
import com.bytedance.android.live.broadcastgame.opengame.auth.OpenSonicAuthService;
import com.bytedance.android.live.broadcastgame.opengame.control.OpenPlatformControlService;
import com.bytedance.android.live.broadcastgame.opengame.message.c0;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.service.AudienceMiniGameIntroCardService;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenFeatureIconStateService;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.service.PanelStateReportService;
import com.bytedance.android.live.broadcastgame.opengame.service.PerformanceDetectionService;
import com.bytedance.android.live.broadcastgame.opengame.service.ReportService;
import com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackLynxService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameCardService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.broadcastgame.opengame.service.base.PluginServiceImpl;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.GameCastStrategy;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class PluginContext implements p, com.bytedance.android.live.broadcastgame.opengame.panel.i, o {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final HashSet<Class<? extends y10.a>> f60795r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final HashMap<PluginType, List<Class<? extends y10.a>>> f60796s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f60797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PluginType f60798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f60799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Class<?>, Class<? extends y10.a>> f60800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f60801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f60802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.panel.h f60803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f60804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataCenter f60805i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.opengame.i f60806j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q f60807k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c0 f60808l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.opengame.t f60809m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f60810n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f60811o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f60812p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f60813q;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.broadcastgame.opengame.utils.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PluginContext f60814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f60815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f60816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f60817d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.h.a
        public final void onFail() {
            ((IInteractService) jc1.k.n(IInteractService.class)).startLinkCast(LinkScreenCastType.CAST_TYPE_GAME, this.f60814a.f60809m.f61083i, this.f60815b, this.f60816c, null, (String) this.f60817d.element, false);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.h.a
        public final void onSuccess(Bitmap r110) {
            Intrinsics.checkNotNullParameter(r110, SimplayerImageStrategy.RESULT_BITMAP);
            ((IInteractService) jc1.k.n(IInteractService.class)).startLinkCast(LinkScreenCastType.CAST_TYPE_GAME, this.f60814a.f60809m.f61083i, this.f60815b, this.f60816c, r110, (String) this.f60817d.element, false);
        }

        public b(PluginContext r100, int r101, int r102, Ref.ObjectRef r103) {
            this.f60814a = r100;
            this.f60815b = r101;
            this.f60816c = r102;
            this.f60817d = r103;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    public final ConcurrentHashMap<Class<? extends y10.a>, Object> p() {
        return (ConcurrentHashMap) this.f60801e.getValue();
    }

    static {
        f60795r = SetsKt.hashSetOf(new Class[]{PanelStateReportService.class, SimplePanelStateDispatchService.class, ReportService.class, BootInfoService.class, OpenFeatureIconStateService.class, PerformanceDetectionService.class, OpenPlatformMonitorService.class, OpenPlatformControlService.class, OpenBaseAuthService.class});
        f60796s = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(PluginType.LYNX, CollectionsKt.listOf(new Class[]{TrackLynxService.class, CommercialService.class, AudienceMiniGameIntroCardService.class, TrackMiniGameCardService.class})), TuplesKt.to(PluginType.SONIC_GAME, CollectionsKt.listOf(new Class[]{TrackMiniGameService.class, CommercialService.class, AudienceMiniGameIntroCardService.class, TrackMiniGameCardService.class, OpenSonicAuthService.class}))});
    }

    public final Context i() {
        Object r100 = this.f60803g;
        if ((r100 instanceof Context) == true) goto L5;
        r100 = null;
    L5:
        Context r101 = (Context) r100;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return this.f60804h;
    }

    public final PanelType j() {
        com.bytedance.android.live.broadcastgame.opengame.panel.h r100 = this.f60803g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPanelType();
    }

    public final k k() {
        k r100 = this.f60797a;
        if (r100 == null) goto L6;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(CloudControlInf.PLUGIN);
        return r100;
    L8:
        return r100;
    L6:
        return null;
    }

    public final PluginType m() {
        PluginType r100 = this.f60798b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        PluginType.a r101 = PluginType.Companion;
        String r102 = this.f60809m.f61088n;
        r101.getClass();
        PluginType r103 = PluginType.a.a(r102);
        this.f60798b = r103;
        return r103;
    }

    public final Room n() {
        DataCenter r100 = this.f60805i;
        if (r100 != null) goto L5;
        return null;
    L5:
        return (Room) r100.get("data_room", null);
    }

    public final boolean r() {
        g r100 = this.f60809m.f61086l;
        if (r100 == null) goto L28;
        j r101 = r100.f60835b;
        if (r101 == null) goto L29;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r102 = r101.f60839a;
        if (r102 == null) goto L30;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        if (((com.bytedance.android.live.broadcastgame.opengame.network.a.C0989a) r104.next()).c().equals("doScreencast") == false) goto L15;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L22;
        return false;
    L22:
        if (s() == false) goto L32;
        return true;
    L32:
        return false;
    L19:
        r105 = false;
        goto L20
    L11:
        if (r103.isEmpty() == false) goto L13;
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    }

    public final boolean s() {
        IInteractService r100 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isCurrentSceneSupportShowCastEntrance());
    L7:
        if (this.f60811o == true) goto L9;
    L15:
        return false;
    L9:
        if (PadConfigUtils.a() == true) goto L15;
        if (tb1.c.f545229a == false) goto L15;
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L15;
        return true;
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
    public final void v() {
        if (this.f60811o == true) goto L5;
        return;
    L5:
        PanelType r100 = j();
        if (r100 == null) goto L8;
        int r101 = r100.getWidth();
    L9:
        PanelType r102 = j();
        if (r102 == null) goto L12;
        int r103 = r102.getHeight();
    L13:
        com.bytedance.android.live.broadcastgame.api.model.u r104 = this.f60809m.e();
        if (r104 == null) goto L16;
        List<String> r105 = r104.iconUrl;
    L17:
        Ref.ObjectRef r106 = new Ref.ObjectRef();
        r106.element = "";
        if (r105 != null) goto L20;
    L22:
        if (r101 == 0) goto L25;
        if (r103 == 0) goto L25;
        int r107 = com.bytedance.android.live.broadcastgame.opengame.utils.h.f61158a;
        com.bytedance.android.live.broadcastgame.opengame.utils.h.a(this.f60809m.f61083i, r101, r103, new b(this, r101, r103, r106));
        return;
    L25:
        ((IInteractService) jc1.k.n(IInteractService.class)).startLinkCast(LinkScreenCastType.CAST_TYPE_GAME, this.f60809m.f61083i, r101, r103, null, (String) r106.element, false);
        return;
    L20:
        if ((!r105.isEmpty()) == false) goto L22;
        r106.element = (String) ListProtector.get(r105, 0);
        goto L22
    L16:
        r105 = null;
        goto L17
    L12:
        r103 = 0;
        goto L13
    L8:
        r101 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r104.next()).a();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r104.next()).b();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void e() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof o) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((o) r104.next()).e();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void f() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof o) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((o) r104.next()).f();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof p) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((p) r104.next()).hide();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof p) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((p) r104.next()).launch();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r104.next()).onBackPressed();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r104.next()).onPanelCancel();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof p) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((p) r104.next()).start();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        Collection<Object> r100 = p().values();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof p) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((p) r104.next()).stop();
        goto L10
    }

    public final Context getContext() {
        return this.f60804h;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Collection<Object> r101 = p().values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof o) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        ((o) r105.next()).d(r100);
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Collection<Object> r101 = p().values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof p) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        ((p) r105.next()).fail(r100);
        goto L10
    }

    public final <T> T g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) ((LinkedHashMap) this.f60802f).get(r100);
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public final GameCastStrategy h(boolean r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.sonicgame.e.f61062a;
        return com.bytedance.android.live.broadcastgame.opengame.sonicgame.e.a(r100, this.f60805i);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r100) {
        Collection<Object> r101 = p().values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof p) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        ((p) r105.next()).l(r100);
        goto L10
    }

    public final <T extends y10.a> T o(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Class<T> r101 = (Class) this.f60800d.get(r100);
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        if (p().containsKey(r100) == false) goto L14;
        Object r102 = p().get(r100);
        if (r102 == null) goto L13;
        return (T) r102;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L14:
        t(r100);
        Object r103 = p().get(r100);
        if (r103 == null) goto L19;
        return (T) r103;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public final <T extends y10.a> void q(Class<T> r100) {
        Annotation[] r101 = r100.getAnnotations();
        int r102 = r101.length;
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L8;
        Annotation r103 = r101[r102];
        if ((r103 instanceof PluginServiceImpl) == false) goto L3;
    L9:
        if (r103 != null) goto L11;
    L23:
        t(r100);
        return;
    L11:
        if ((r103 instanceof PluginServiceImpl) == false) goto L23;
        if (this.f60811o == false) goto L15;
    L18:
        Class<? extends y10.a> r104 = ((PluginServiceImpl) r103).anchorService();
    L20:
        if (r100.isAssignableFrom(r104) == true) goto L22;
        ALogger.e("PluginContext", r104.getCanonicalName() + " is no a subClass for " + r100.getCanonicalName());
        return;
    L22:
        this.f60800d.put(r100, r104);
        t(r104);
        return;
    L15:
        if (this.f60812p == true) goto L18;
        r104 = ((PluginServiceImpl) r103).audienceService();
        goto L20
    L8:
        r103 = null;
        goto L9
    }

    public final <T extends y10.a> void t(Class<T> r100) {
        if (p().containsKey(r100) == false) goto L5;
        return;
    L5:
        Object r101 = this.f60799c;
        monitor-enter(r101);
        ConcurrentHashMap<Class<? extends y10.a>, Object> r102 = p();     // Catch: Throwable -> L14
        T r103 = r100.getConstructor(new Class[]{PluginContext.class}).newInstance(new Object[]{this});     // Catch: Throwable -> L14
        if (r103 == null) goto L13;
        T r104 = r103;     // Catch: Throwable -> L14
        r104.g();     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r102.put(r100, r104);     // Catch: Throwable -> L14
        monitor-exit(r101);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void u(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f60802f.put(r100, r101);
    }

    public PluginContext(Context r100, DataCenter r101, com.bytedance.android.live.broadcastgame.opengame.i r102, q r103, c0 r104, com.bytedance.android.live.broadcastgame.opengame.t r105, Map<String, ? extends Object> r106, boolean r107, boolean r110, com.bytedance.android.live.pushstream.d r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "runtime");
        Intrinsics.checkNotNullParameter(r105, "pluginInfo");
        Intrinsics.checkNotNullParameter(r106, "params");
        this.f60804h = r100;
        this.f60805i = r101;
        this.f60806j = r102;
        this.f60807k = r103;
        this.f60808l = r104;
        this.f60809m = r105;
        this.f60810n = r106;
        this.f60811o = r107;
        this.f60812p = r110;
        this.f60813q = r111;
        this.f60799c = new Object();
        this.f60800d = new HashMap();
        this.f60801e = LazyKt.lazy(PluginContext$servicePool$2.INSTANCE);
        new LinkedHashMap();
        this.f60802f = new LinkedHashMap();
        Iterator<T> r108 = f60795r.iterator();
    L4:
        if (r108.hasNext() == false) goto L6;
        q((Class) r108.next());
        goto L4
    L6:
        List<Class<? extends y10.a>> r109 = f60796s.get(m());
        if (r109 == null) goto L17;
        Iterator<T> r112 = r109.iterator();
    L10:
        if (r112.hasNext() == false) goto L25;
        Class<? extends y10.a> r113 = (Class) r112.next();
        q(r113);
        Iterator<T> r114 = f60795r.iterator();
    L13:
        if (r114.hasNext() == false) goto L10;
        Class<?> r115 = (Class) r114.next();
        if (r115.isAssignableFrom(r113) == false) goto L13;
        this.f60800d.put(r115, r113);
        goto L13
    L25:
        return;
    }
}
