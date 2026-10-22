package com.bytedance.android.shopping.anchorv4.video;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.LiveVolume;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class AnchorV4PlayerStateManager implements com.bytedance.android.shopping.anchorv4.video.f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map<String, Boolean> f167503q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final fj.a f167504r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static VolumeBroadcastReceiver f167505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final b f167506t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f167507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f167508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f167509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f167510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function3<? super Boolean, ? super Boolean, ? super String, Unit> f167511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super Boolean, ? super Boolean, ? super String, Unit> f167512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f167513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f167514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.video.e> f167515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f167516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f167517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.video.e> f167518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<? extends com.bytedance.android.shopping.anchorv4.video.e> f167519m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Boolean f167520n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f167521o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.video.g f167522p;

    public static final class a extends com.bytedance.android.shopping.anchorv4.video.d {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Long f167523i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ AnchorV4PlayerStateManager f167524j;

        @Override // com.bytedance.android.shopping.anchorv4.video.e
        public final Object getPlayer() {
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.e
        public final boolean e() {
            int r100 = ECSdk.f48106a;
            IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r101 == null) goto L5;
            Boolean r102 = r101.hasLivePlayingMute();
        L7:
            return Intrinsics.areEqual(r102, Boolean.TRUE);
        L5:
            r102 = null;
            goto L7
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
        public final boolean c() {
            if (isPlaying() == false) goto L6;
            this.f167524j.t(false);
            return true;
        L6:
            return false;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.e
        public final boolean isPlaying() {
            if (com.bytedance.android.ec.core.abtest.d.p() == false) goto L12;
            int r100 = ECSdk.f48106a;
            IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r101 == null) goto L7;
            Boolean r102 = r101.hasLivePlayingMute();
        L8:
            if (r102 == null) goto L10;
            return true;
        L10:
            return false;
        L7:
            r102 = null;
            goto L8
        L12:
            AnchorV4PlayerStateManager.f167506t.getClass();
            return b.c();
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
        public final Long d() {
            return this.f167523i;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.d, com.bytedance.android.shopping.anchorv4.video.e
        public final boolean g(boolean r100) {
            if (isPlaying() == false) goto L7;
            this.f167524j.t(r100);
            return true;
        L7:
            return true;
        }

        @Override // com.bytedance.android.shopping.anchorv4.video.d
        public final void o(Long r100) {
            this.f167523i = r100;
        }

        public a(AnchorV4PlayerStateManager r100, com.bytedance.android.shopping.anchorv4.video.f r101) {
            this.f167524j = r100;
            super("float_live", r101, null, false, false, 60);
            this.f167523i = 0L;
        }
    }

    public static final class b {
        public b() {
        }

        public static boolean b() {
            fj.a r100 = AnchorV4PlayerStateManager.f167504r;
            if (r100 == null) goto L7;
            r100.c();
            return false;
        L7:
            return false;
        }

        public static boolean c() {
            int r100 = ECSdk.f48106a;
            IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r101 == null) goto L9;
            j r102 = r101.getLiveWindowService();
            if (r102 == null) goto L9;
            if (r102.isFloatWindowShowing() != true) goto L9;
            return true;
        L9:
            return false;
        }

        public static void a(Context r100) {
            if (AnchorV4PlayerStateManager.f167505s == null) goto L5;
            return;
        L5:
            if (r100 == null) goto L7;
            Context r101 = r100.getApplicationContext();
        L8:
            VolumeBroadcastReceiver r102 = new VolumeBroadcastReceiver(r101);
            if (r100 == null) goto L43;
            Context r103 = r100.getApplicationContext();
            if (r103 == null) goto L43;
            IntentFilter r104 = new IntentFilter();
            r104.addAction("android.media.VOLUME_CHANGED_ACTION");
            Unit r105 = Unit.INSTANCE;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L46;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L46:
        L38:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
            ReceiverRegisterCrashOptimizer.registerReceiver(r102, r104);
            goto L43
        L42:
            throw e;
        L16:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L29;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r104) == false) goto L29;
            int r106 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r104, 0, null, null, 2, r103).result;     // Catch: Exception -> L38
            if (r106 != 1) goto L22;
            r103.registerReceiver(r102, r104);     // Catch: Exception -> L38
        L45:
            goto L43
        L22:
            if (r106 != 2) goto L24;
            new Intent();     // Catch: Exception -> L38
            goto L45
        L24:
            if (r106 == 3) goto L45;
            r103.registerReceiver(r102, r104);     // Catch: Exception -> L38
        L29:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L32;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L38
            r103.registerReceiver(r102, r104, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L38
            goto L45
        L32:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L34;
        L36:
            r103.registerReceiver(r102, r104);     // Catch: Exception -> L38
            goto L45
        L34:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r104) == false) goto L36;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L38
            ContextCompat.registerReceiver(r103, r102, r104, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L38
        L43:
            AnchorV4PlayerStateManager.f167505s = r102;
            return;
        L7:
            r101 = null;
            goto L8
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((com.bytedance.android.shopping.anchorv4.video.e) r100).d(), ((com.bytedance.android.shopping.anchorv4.video.e) r101).d());
        }
    }

    public static final class d {
        public d() {
        }
    }

    public static final class e implements com.bytedance.android.ec.model.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4PlayerStateManager f167525a;

        @Override // com.bytedance.android.ec.model.j
        public final void onClick() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onReturnClick() {
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onShow() {
        }

        public e(AnchorV4PlayerStateManager r100) {
            this.f167525a = r100;
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onClose(boolean r100) {
            if (r100 == false) goto L7;
            dm.a.a("LiveWindow").b("用户手动关闭直播小窗", null);
            wu1.a r101 = (wu1.a) this.f167525a.f167521o.getValue();
            if (r101 == null) goto L8;
            FloatWindowState r102 = FloatWindowState.STOP;
            Scene r103 = Scene.LIVE;
            r101.b(r102);
            return;
        L8:
            return;
        }

        @Override // com.bytedance.android.ec.model.j
        public final void onMuteButtonClick(boolean r100) {
            if (r100 == false) goto L4;
            LiveVolume r101 = LiveVolume.MUTE;
        L5:
            Object r102 = null;
            dm.a.a("LiveWindow").b("用户手动切换静音状态 " + r101, null);
            wu1.a r103 = (wu1.a) this.f167525a.f167521o.getValue();
            if (r103 == null) goto L8;
            Scene r104 = Scene.LIVE;
            r103.d(r101);
        L8:
            this.f167525a.f167510d = Boolean.valueOf(r100);
            this.f167525a.f167520n = Boolean.valueOf(r100);
            AnchorV4PlayerStateManager r105 = this.f167525a;
            Iterator r106 = ((ArrayList) r105.f167515i).iterator();
        L10:
            if (r106.hasNext() == false) goto L14;
            Object r107 = r106.next();
            if (com.bytedance.android.shopping.anchorv4.video.c.a((com.bytedance.android.shopping.anchorv4.video.e) r107) == false) goto L10;
            r102 = r107;
        L14:
            r105.k(r100, (com.bytedance.android.shopping.anchorv4.video.e) r102);
            return;
        L4:
            r101 = LiveVolume.UNMUTE;
            goto L5
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.anchorv4.video.e f167526a;

        public f(com.bytedance.android.shopping.anchorv4.video.e r100) {
            this.f167526a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f167526a.g(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4PlayerStateManager f167527a;

        @Override // com.bytedance.android.shopping.anchorv4.video.h
        public final void a() {
            AnchorV4PlayerStateManager.f167506t.getClass();
            b.b();
            AnchorV4PlayerStateManager r100 = this.f167527a;
            if (r100.f167508b == true) goto L17;
            List<com.bytedance.android.shopping.anchorv4.video.e> r101 = r100.f167515i;
            if ((r101 instanceof Collection) == true) goto L7;
        L9:
            Iterator r102 = ((ArrayList) r101).iterator();
        L11:
            if (r102.hasNext() == false) goto L15;
            if (((com.bytedance.android.shopping.anchorv4.video.e) r102.next()).a() == false) goto L11;
            boolean r103 = true;
        L16:
            if (r103 == true) goto L17;
            return;
        L15:
            r103 = false;
            goto L16
        L7:
            if (((ArrayList) r101).isEmpty() == false) goto L9;
        L17:
            List<com.bytedance.android.shopping.anchorv4.video.e> r104 = this.f167527a.f167515i;
            ArrayList r105 = new ArrayList();
            Iterator r106 = ((ArrayList) r104).iterator();
        L19:
            if (r106.hasNext() == false) goto L28;
            Object r107 = r106.next();
            com.bytedance.android.shopping.anchorv4.video.e r108 = (com.bytedance.android.shopping.anchorv4.video.e) r107;
            if (r108.isPlaying() == true) goto L23;
        L25:
            boolean r109 = false;
        L26:
            if (r109 == false) goto L19;
            r105.add(r107);
            goto L19
        L23:
            if (r108.d() == null) goto L25;
            r109 = true;
            goto L26
        L28:
            com.bytedance.android.shopping.anchorv4.video.e r110 = (com.bytedance.android.shopping.anchorv4.video.e) CollectionsKt.lastOrNull(CollectionsKt.sortedWith(r105, new com.bytedance.android.shopping.anchorv4.video.b()));
            if (r110 == null) goto L41;
            r110.g(false);
            return;
        }

        public g(AnchorV4PlayerStateManager r100) {
            this.f167527a = r100;
        }
    }

    public final void r() {
        this.f167508b = false;
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 == null) goto L5;
        Boolean r102 = r101.hasLivePlayingMute();
    L6:
        this.f167516j = r102;
        Iterator r103 = ((ArrayList) this.f167515i).iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        com.bytedance.android.shopping.anchorv4.video.e r104 = (com.bytedance.android.shopping.anchorv4.video.e) r103.next();
        if (r104.m() == false) goto L8;
        if (r104.isPlaying() == false) goto L8;
        r104.b();
        ((ArrayList) this.f167518l).add(r104);
        goto L8
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void s() {
        this.f167508b = true;
        Iterator r100 = ((ArrayList) this.f167518l).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.video.e) r100.next()).c();
        goto L4
    L6:
        ((ArrayList) this.f167518l).clear();
        if (com.bytedance.android.ec.core.abtest.d.p() == true) goto L9;
        return;
    L9:
        if ((true ^ Intrinsics.areEqual(o(), Boolean.FALSE)) == false) goto L31;
        Iterator r101 = ((ArrayList) this.f167515i).iterator();
    L12:
        if (r101.hasNext() == false) goto L16;
        Object r102 = r101.next();
        if (com.bytedance.android.shopping.anchorv4.video.c.a((com.bytedance.android.shopping.anchorv4.video.e) r102) == false) goto L12;
    L17:
        com.bytedance.android.shopping.anchorv4.video.e r103 = (com.bytedance.android.shopping.anchorv4.video.e) r102;
        f167506t.getClass();
        if (b.c() == true) goto L20;
        if (r103 == null) goto L35;
        r103.g(false);
        return;
    L35:
        return;
    L20:
        if (Intrinsics.areEqual(this.f167516j, Boolean.FALSE) == false) goto L32;
        if (r103 == null) goto L33;
        r103.g(false);
        return;
    L33:
        return;
    L32:
        return;
    L16:
        r102 = null;
        goto L17
    }

    static {
        f167506t = new b();
        f167503q = new LinkedHashMap();
        f167504r = com.bytedance.android.ec.sdk.helper.d.f48119b.getAudioMuteService();
    }

    public final void l() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f167515i.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        com.bytedance.android.shopping.anchorv4.video.e r102 = (com.bytedance.android.shopping.anchorv4.video.e) r101.next();
        if (r102.isPlaying() == false) goto L4;
        if (com.bytedance.android.shopping.anchorv4.video.c.a(r102) == true) goto L4;
        r102.b();
        r100.add(r102);
        goto L4
    L10:
        this.f167519m = r100;
    }

    public final void m() {
        List<? extends com.bytedance.android.shopping.anchorv4.video.e> r100 = this.f167519m;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((com.bytedance.android.shopping.anchorv4.video.e) r101.next()).c();
    L8:
        this.f167519m = null;
    }

    public final Boolean n() {
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.hasLivePlayingMute();
    }

    public final Boolean o() {
        List<com.bytedance.android.shopping.anchorv4.video.e> r100 = this.f167515i;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L14;
        Object r104 = r102.next();
        com.bytedance.android.shopping.anchorv4.video.e r105 = (com.bytedance.android.shopping.anchorv4.video.e) r104;
        if (r105.isPlaying() == true) goto L8;
    L12:
        if (r103 == false) goto L3;
        r101.add(r104);
        goto L3
    L8:
        if (r105.d() == null) goto L12;
        if (com.bytedance.android.shopping.anchorv4.video.c.a(r105) == true) goto L12;
        r103 = true;
        goto L12
    L14:
        com.bytedance.android.shopping.anchorv4.video.e r106 = (com.bytedance.android.shopping.anchorv4.video.e) CollectionsKt.getOrNull(CollectionsKt.sortedWith(r101, new c()), 0);
        if (r106 != null) goto L24;
        return null;
    L24:
        return Boolean.valueOf(r106.e());
    }

    public final void p() {
        fj.a r100 = f167504r;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        VolumeBroadcastReceiver r101 = f167505s;
        if (r101 == null) goto L8;
        final g r102 = this.f167513g;
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.a(new VolumeBroadcastReceiver$addListener$1(r102));
        r101.f167528a.add(new WeakReference(r102));
    L8:
        int r103 = ECSdk.f48106a;
        IAdapterService r104 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r104 == null) goto L13;
        j r105 = r104.getLiveWindowService();
        if (r105 == null) goto L13;
        Object r106 = r105.f(new e(this));
    L14:
        this.f167514h = r106;
        return;
    L13:
        r106 = null;
        goto L14
    }

    public final void q() {
        fj.a r100 = f167504r;
        if (r100 == null) goto L5;
        r100.b();
    L5:
        VolumeBroadcastReceiver r101 = f167505s;
        if (r101 == null) goto L8;
        final g r102 = this.f167513g;
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.a(new VolumeBroadcastReceiver$removeListener$1(r102));
    L8:
        Object r103 = this.f167514h;
        if (r103 == null) goto L17;
        int r104 = ECSdk.f48106a;
        IAdapterService r105 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r105 == null) goto L15;
        j r106 = r105.getLiveWindowService();
        if (r106 == null) goto L15;
        r106.d(r103);
    L15:
        this.f167514h = null;
    L17:
        if (this.f167522p.b() == false) goto L22;
        int r107 = ECSdk.f48106a;
        IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r108 == null) goto L23;
        r108.cancelMuteLiveRoom();
        return;
    L23:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final boolean e() {
        Intrinsics.checkNotNullParameter("head_video", "scene");
        Iterator r100 = ((ArrayList) this.f167515i).iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        Object r101 = r100.next();
        com.bytedance.android.shopping.anchorv4.video.e r102 = (com.bytedance.android.shopping.anchorv4.video.e) r101;
        if (r102.isPlaying() == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L4;
    L14:
        if (r101 == null) goto L22;
        return true;
    L22:
        return false;
    L8:
        if (Intrinsics.areEqual(r102.getScene(), "head_video") == false) goto L10;
        r103 = true;
        goto L11
    L13:
        r101 = null;
        goto L14
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final boolean i() {
        return this.f167517k;
    }

    public AnchorV4PlayerStateManager(com.bytedance.android.shopping.anchorv4.video.g r100) {
        Intrinsics.checkNotNullParameter(r100, "stateProvider");
        this.f167522p = r100;
        new d();
        this.f167513g = new g(this);
        ArrayList r101 = new ArrayList();
        this.f167515i = r101;
        this.f167518l = new ArrayList();
        r101.add(new a(this, this));
        this.f167521o = LazyKt.lazy(AnchorV4PlayerStateManager$ecLiveStataController$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final void a(com.bytedance.android.shopping.anchorv4.video.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((ArrayList) this.f167518l).add(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final void c(com.bytedance.android.shopping.anchorv4.video.e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((ArrayList) this.f167515i).add(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final void d(boolean r100) {
        this.f167517k = r100;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final void g(com.bytedance.android.shopping.anchorv4.video.e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((ArrayList) this.f167515i).remove(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final boolean h(com.bytedance.android.shopping.anchorv4.video.e r100) {
        if (r100 != null) goto L6;
        f167506t.getClass();
        b.b();
        return false;
    L6:
        Map<String, Boolean> r101 = f167503q;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        Boolean r103 = (Boolean) r102.get(r100.getScene());
        f167506t.getClass();
        b.b();
        Boolean r104 = r100.j(r103, false);
        if (r104 != null) goto L9;
        Boolean r105 = (Boolean) r102.get(r100.getScene());
        if (r105 != null) goto L13;
        b.b();
        Boolean r106 = r100.k();
        if (r106 != null) goto L17;
        return false;
    L17:
        return r106.booleanValue();
    L13:
        return r105.booleanValue();
    L9:
        return r104.booleanValue();
    }

    public final void t(boolean r100) {
        if (com.bytedance.android.ec.core.abtest.d.p() == false) goto L20;
        f167506t.getClass();
        if (b.c() == false) goto L12;
        int r101 = ECSdk.f48106a;
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r102 == null) goto L12;
        j r103 = r102.getLiveWindowService();
        if (r103 == null) goto L12;
        r103.toggleLiveAudio(r100);
    L12:
        if (this.f167522p.b() == false) goto L25;
        if (r100 == false) goto L17;
        int r104 = ECSdk.f48106a;
        IAdapterService r105 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r105 == null) goto L25;
        r105.muteLiveRoom();
        goto L25
    L17:
        int r106 = ECSdk.f48106a;
        IAdapterService r107 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r107 == null) goto L25;
        r107.cancelMuteLiveRoom();
    L25:
        this.f167510d = Boolean.valueOf(r100);
        return;
    L20:
        int r108 = ECSdk.f48106a;
        IAdapterService r109 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r109 == null) goto L25;
        j r110 = r109.getLiveWindowService();
        if (r110 == null) goto L25;
        r110.toggleLiveAudio(r100);
        goto L25
    }

    public final void k(boolean r100, com.bytedance.android.shopping.anchorv4.video.e r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.isPlaying() != true) goto L34;
        Iterator<T> r102 = this.f167515i.iterator();
    L8:
        if (r102.hasNext() == false) goto L35;
        com.bytedance.android.shopping.anchorv4.video.e r103 = (com.bytedance.android.shopping.anchorv4.video.e) r102.next();
        if ((!Intrinsics.areEqual(r103.getPlayer(), r101.getPlayer())) == false) goto L8;
        if (r103.isPlaying() == false) goto L8;
        if (r100 == true) goto L15;
        r103.g(true);
        goto L8
    L15:
        if (com.bytedance.android.shopping.anchorv4.video.c.a(r103) == true) goto L18;
        if (h(r103) == true) goto L8;
    L18:
        r103.g(false);
        return;
    L35:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final void b(com.bytedance.android.shopping.anchorv4.video.e r100, boolean r101, boolean r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r102 = h(r100);
        r100.g(r102);
        Iterator r103 = ((ArrayList) this.f167515i).iterator();
    L5:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L8;
        ((com.bytedance.android.shopping.anchorv4.video.e) r103.next()).h(r100, true);
        goto L5
    L8:
        Function3<? super Boolean, ? super Boolean, ? super String, Unit> r105 = this.f167511e;
        if (r105 == null) goto L12;
        Unit r106 = r105.invoke(Boolean.TRUE, Boolean.valueOf(r102), r100.getScene());
    L12:
        if (this.f167508b == true) goto L15;
        if (r110 == true) goto L15;
        return;
    L15:
        if (r101 == true) goto L17;
        return;
    L17:
        ArrayList r107 = new ArrayList();
        Iterator r111 = ((ArrayList) this.f167515i).iterator();
        com.bytedance.android.shopping.anchorv4.video.e r108 = null;
    L18:
        boolean r109 = false;
        if (r111.hasNext() == false) goto L47;
        com.bytedance.android.shopping.anchorv4.video.e r112 = (com.bytedance.android.shopping.anchorv4.video.e) r111.next();
        if ((!Intrinsics.areEqual(r100, r112)) == false) goto L18;
        if (r112.isPlaying() == false) goto L18;
        if (com.bytedance.android.shopping.anchorv4.video.c.a(r112) == true) goto L26;
        if (r100.l() == false) goto L18;
        if (r112.l() == false) goto L18;
        if (r100.getPlayer() == null) goto L18;
        if ((!Intrinsics.areEqual(r112.getPlayer(), r100.getPlayer())) == false) goto L18;
        r107.add(r112);
        r112.b();
        goto L18
    L26:
        if (r102 == false) goto L27;
        if (Intrinsics.areEqual(n(), Boolean.FALSE) == false) goto L18;
        Lazy r113 = UIUtils.f45548a;
        UIUtils.c().post(new f(r112));
        goto L18
    L27:
        Boolean r114 = n();
        if (r114 != null) goto L30;
        r114 = this.f167510d;
    L30:
        if (r114 == null) goto L32;
        r109 = r114.booleanValue();
    L32:
        if (r109 == true) goto L34;
        r108 = r112;
    L34:
        r112.g(true);
        goto L18
    L47:
        if (r108 != null) goto L49;
        r108 = (com.bytedance.android.shopping.anchorv4.video.e) CollectionsKt.firstOrNull(r107);
    L49:
        this.f167509c = null;
        if (r108 != null) goto L52;
        return;
    L52:
        if (Intrinsics.areEqual(r108.getScene(), "head_video") == true) goto L54;
    L56:
        r104 = false;
    L57:
        if (r104 == true) goto L85;
        this.f167509c = new i(r108, r100);
        return;
    L85:
        return;
    L54:
        if (Intrinsics.areEqual(r100.getScene(), "head_video") == false) goto L56;
        goto L56
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final void f(boolean r100, boolean r101, com.bytedance.android.shopping.anchorv4.video.e r102) {
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f167507a == false) goto L7;
        return;
    L7:
        this.f167507a = true;
        Function3<? super Boolean, ? super Boolean, ? super String, Unit> r103 = this.f167512f;
        if (r103 == null) goto L10;
        Unit r104 = r103.invoke(Boolean.valueOf(r100), Boolean.valueOf(r101), r102.getScene());
    L10:
        if (r101 == false) goto L16;
        f167503q.put(r102.getScene(), Boolean.valueOf(r100));
        if (r100 == true) goto L16;
        fj.a r105 = f167504r;
        if (r105 == null) goto L16;
        r105.c();
    L16:
        k(r100, r102);
        this.f167507a = false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.video.f
    public final void j(com.bytedance.android.shopping.anchorv4.video.e r100, boolean r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        Function3<? super Boolean, ? super Boolean, ? super String, Unit> r103 = this.f167511e;
        if (r103 == null) goto L8;
        Unit r104 = r103.invoke(Boolean.FALSE, null, r100.getScene());
    L8:
        if (this.f167508b == true) goto L11;
        if (r102 == true) goto L11;
        return;
    L11:
        Iterator r105 = ((ArrayList) this.f167515i).iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        ((com.bytedance.android.shopping.anchorv4.video.e) r105.next()).h(r100, false);
        goto L13
    L15:
        if (r101 == false) goto L53;
        Iterator r106 = ((ArrayList) this.f167515i).iterator();
    L18:
        if (r106.hasNext() == false) goto L31;
        Object r107 = r106.next();
        com.bytedance.android.shopping.anchorv4.video.e r108 = (com.bytedance.android.shopping.anchorv4.video.e) r107;
        if ((!Intrinsics.areEqual(r108, r100)) == true) goto L22;
    L28:
        boolean r109 = false;
    L29:
        if (r109 == false) goto L18;
    L32:
        if (r107 == null) goto L34;
        boolean r110 = true;
    L35:
        if (r110 == true) goto L54;
        i r111 = this.f167509c;
        if (r111 == null) goto L44;
        if (r111.f167679a == 1) goto L41;
        return;
    L41:
        if (Intrinsics.areEqual(r100, r111.f167681c) == false) goto L56;
        r111.f167680b.c();
        this.f167509c = null;
        return;
    L56:
        return;
    L44:
        if ((!Intrinsics.areEqual(this.f167520n, Boolean.TRUE)) == false) goto L58;
        t(false);
        return;
    L58:
        return;
    L54:
        return;
    L34:
        r110 = false;
        goto L35
    L22:
        if (r108.l() == false) goto L28;
        if (r108.isPlaying() == false) goto L28;
        if (com.bytedance.android.shopping.anchorv4.video.c.a(r108) == true) goto L28;
        r109 = true;
        goto L29
    L31:
        r107 = null;
        goto L32
    }
}
