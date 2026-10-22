package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusServiceImpl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class InteractiveSongMvManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f74048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f74049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextureView f74050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f74051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IOrderSingMVInfo f74052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IOrderSingMVInfo f74053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f74054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvapi.model.mv.c f74055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f74056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f74057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f74058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f74059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f74060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f74061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f74062p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f74063q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final zd0.e f74064r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f74065s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f74066t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function1<? super Integer, Unit> f74067u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f74068v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f74069w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Context f74070x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DataCenter f74071y;

    public static final class a {
    }

    public static final class b implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InteractiveSongMvManager f74072a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public b(InteractiveSongMvManager r100) {
            this.f74072a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            com.bytedance.android.livesdk.ktvapi.model.mv.c r103 = this.f74072a.f74055i;
            if (r103 == null) goto L6;
            r103.c(new Surface(r100));
            return;
        }
    }

    public static final class c<T> implements IMediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f74073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f74074b;

        public c(Function1 r100, Function0 r101) {
            this.f74073a = r100;
            this.f74074b = r101;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer.OnErrorListener
        public final void a(AbsPlayer r100, int r101, int r102, String r103) {
            Function0 r104 = this.f74074b;
            if (r104 == null) goto L6;
            Unit r105 = (Unit) r104.invoke();
            return;
        }
    }

    static {
    }

    public final void f() {
        this.f74052f = null;
        this.f74053g = null;
        m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L16;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L16;
        if (r101.isLiveTypeAudio() != true) goto L16;
        j<com.bytedance.android.live.pushstream.d> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r102 == null) goto L16;
        com.bytedance.android.live.pushstream.d r103 = r102.getValue();
        if (r103 == null) goto L16;
        r103.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "InteractiveSongMvManager.resetData", null));
        com.bytedance.android.livesdk.ktvapi.model.mv.c r104 = this.f74055i;
        if (r104 == null) goto L16;
        r104.f(false, r103, false);
    L16:
        if (vm2.d.n0() == true) goto L23;
        FrameLayout r105 = this.f74049c;
        if (r105 == null) goto L20;
        r105.setVisibility(8);
    L20:
        View r106 = this.f74051e;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
    L23:
        zd0.e r107 = this.f74064r;
        if (r107 == null) goto L26;
        r107.f571287a = false;
        int r108 = vd0.a.f554147g;
        vd0.a.C7981a.a(r107.f571288b).c();
    L26:
        Disposable r109 = this.f74057k;
        if (r109 == null) goto L29;
        r109.dispose();
    L29:
        Disposable r110 = this.f74058l;
        if (r110 == null) goto L32;
        r110.dispose();
    L32:
        TextureView r111 = this.f74050d;
        if (r111 == null) goto L36;
        r111.setSurfaceTextureListener(null);
        return;
    }

    public final void b() {
        if (this.f74065s != 0) goto L5;
        return;
    L5:
        long r100 = System.currentTimeMillis() - this.f74065s;
        this.f74066t += r100;
        InteractiveSongContext r101 = InteractiveSongContext.Companion.getContext();
        if (r101 == null) goto L8;
        r101.setMvWatchDuration(r101.getMvWatchDuration() + r100);
    L8:
        this.f74065s = 0;
    }

    public final void c() {
        this.f74061o = "";
        com.bytedance.android.livesdk.ktvapi.model.mv.c r100 = this.f74055i;
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.model.mv.h<?> r101 = r100.a();
        if (r101 == null) goto L7;
        r101.stop();
    L7:
        b();
        InteractiveSongContext r102 = InteractiveSongContext.Companion.getContext();
        if (r102 == null) goto L10;
        r102.setCurHasMvIsPlaying(false);
    L10:
        FrameLayout r103 = this.f74049c;
        if (r103 == null) goto L13;
        r103.setVisibility(8);
    L13:
        zd0.e r104 = this.f74064r;
        if (r104 == null) goto L16;
        r104.f571287a = false;
        int r105 = vd0.a.f554147g;
        vd0.a.C7981a.a(r104.f571288b).c();
    L16:
        DataCenter r106 = this.f74071y;
        if (r106 == null) goto L19;
        r106.put("data_audio_background_load", Boolean.TRUE);
    L19:
        this.f74059m = false;
        Disposable r107 = this.f74057k;
        if (r107 == null) goto L22;
        r107.dispose();
    L22:
        Disposable r108 = this.f74058l;
        if (r108 == null) goto L26;
        r108.dispose();
        return;
    }

    public final void e() {
        f();
        this.f74049c = null;
        String r100 = this.f74068v;
        if (r100 == null) goto L9;
        IInteractService r101 = (IInteractService) k.f(IInteractService.class);
        if (r101 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r102 = r101.getMultiLinkPerfAbilityManager(false);
        if (r102 == null) goto L9;
        r102.c("multilink_dynamic_bg", r100);
    L9:
        this.f74068v = null;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r103 = this.f74055i;
        if (r103 == null) goto L12;
        r103.release();
    L12:
        this.f74055i = null;
        this.f74071y = null;
    }

    public final Context getContext() {
        return this.f74070x;
    }

    public static final Boolean a(InteractiveSongMvManager r100) {
        if (r100.f74069w != null) goto L11;
        IInteractService r101 = (IInteractService) k.f(IInteractService.class);
        boolean r102 = true;
        if (r101 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r103 = r101.getMultiLinkPerfAbilityManager(true);
        if (r103 == null) goto L9;
        r102 = r103.a("multilink_dynamic_bg");
    L9:
        r100.f74069w = Boolean.valueOf(r102);
    L11:
        return r100.f74069w;
    }

    public final void h(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        this.f74049c = r100;
        View r101 = new View(this.f74070x);
        r101.setBackgroundColor(s1.h(R.color.ttlive_interactive_song_mv_bg_mask));
        r101.setAlpha(0.3f);
        int r102 = 8;
        if (vm2.d.n0() == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        Unit r104 = Unit.INSTANCE;
        this.f74051e = r101;
        this.f74050d = new TextureView(this.f74070x);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout r106 = this.f74049c;
        if (r106 == null) goto L12;
        r106.removeAllViews();
        r106.addView(this.f74050d, r105);
        r106.addView(this.f74051e, r105);
        if (vm2.d.n0() == false) goto L11;
        r102 = 0;
    L11:
        r106.setVisibility(r102);
    L12:
        TextureView r107 = this.f74050d;
        if (r107 == null) goto L16;
        r107.setSurfaceTextureListener(new b(this));
        return;
    L16:
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public InteractiveSongMvManager(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f74070x = r100;
        this.f74071y = r101;
        this.f74047a = vm2.d.m0().e();
        OpusServiceImpl r102 = null;
        this.f74048b = ((Boolean) vm2.d.H2.getValue(null, vm2.d.f555776a[187(0xbb, float:2.62E-43)])).booleanValue();
        this.f74061o = "";
        com.bytedance.android.livesdk.ktvapi.model.mv.d r103 = ((IKtvService) k.n(IKtvService.class)).createOpusMvService();
        if (r103 == null) goto L7;
        HashMap r104 = new HashMap();
        r104.put(199, 1);
        Unit r105 = Unit.INSTANCE;
        com.bytedance.android.livesdk.ktvimpl.mv.opus.d r106 = r103.a(r104);
        if (r106 == null) goto L7;
        r102 = r106.build(r100);
    L7:
        this.f74055i = r102;
        DataCenter r107 = this.f74071y;
        zd0.e r108 = new zd0.e(r107);
        int r109 = vd0.a.f554147g;
        vd0.a r110 = vd0.a.C7981a.a(r107);
        Intrinsics.checkNotNullParameter(r108, "bgView");
        ((ArrayList) r110.f554149b.f563274a).add(r108);
        Unit r111 = Unit.INSTANCE;
        this.f74064r = r108;
    }

    public final void d(boolean r100, boolean r101) {
        if (r100 == true) goto L4;
    L10:
        int r102 = MultiSceneEnterRoomStatisticsUtils.f78650u;
        MultiSceneEnterRoomStatisticsUtils r103 = MultiSceneEnterRoomStatisticsUtils.a.a(this.f74071y, 0L);
        if (r103 == null) goto L13;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r103, "background_Load", 0, 2, null);
    L13:
        FrameLayout r104 = this.f74049c;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
    L16:
        zd0.e r105 = this.f74064r;
        if (r105 == null) goto L19;
        r105.f571287a = true;
        int r106 = vd0.a.f554147g;
        vd0.a.C7981a.a(r105.f571288b).c();
    L19:
        View r107 = this.f74051e;
        if (r107 == null) goto L22;
        r107.setVisibility(0);
    L22:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r108 = this.f74055i;
        if (r108 == null) goto L27;
        com.bytedance.android.livesdk.ktvapi.model.mv.h<?> r109 = r108.a();
        if (r109 == null) goto L27;
        r109.start();
    L27:
        this.f74065s = System.currentTimeMillis();
        InteractiveSongContext r110 = InteractiveSongContext.Companion.getContext();
        if (r110 == null) goto L30;
        r110.setCurHasMvIsPlaying(true);
    L30:
        this.f74059m = true;
        if (r101 == true) goto L40;
        IOrderSingMVInfo r111 = this.f74052f;
        if (r111 != null) goto L35;
    L36:
        Disposable r112 = this.f74058l;
        if (r112 == null) goto L39;
        r112.dispose();
    L39:
        this.f74058l = Observable.interval(this.f74047a, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.interactivesong.panel.b(this));
        goto L40
    L35:
        if (r111.getMvType() != 1) goto L36;
    L40:
        DataCenter r113 = this.f74071y;
        if (r113 == null) goto L44;
        r113.put("data_audio_background_load", Boolean.FALSE);
        return;
    L44:
        return;
    L4:
        if (this.f74059m == false) goto L10;
        if (this.f74049c == null) goto L10;
        if (this.f74052f == null) goto L10;
    }

    public final boolean g(JSONObject r110, Function1<? super IOrderSingMVInfo, Unit> r210) {
        Intrinsics.checkNotNullParameter(r110, "jsonObj");
        String r100 = "";
        if (Intrinsics.areEqual(this.f74061o, "") == false) goto L5;
        return false;
    L5:
        Object r101 = r110.get("ts");
        String r102 = null;
        if ((r101 instanceof Long) == true) goto L8;
        r101 = null;
    L8:
        Long r103 = (Long) r101;
        if (r103 == null) goto L11;
        long r111 = r103.longValue();
    L12:
        this.f74062p = System.currentTimeMillis();
        Object r104 = r110.get("mv_id");
        if ((r104 instanceof String) == true) goto L15;
        r104 = null;
    L15:
        String r105 = (String) r104;
        if (r105 == null) goto L19;
        r100 = r105;
    L19:
        Object r106 = r110.get("push");
        if ((r106 instanceof Boolean) == true) goto L22;
        r106 = null;
    L22:
        Boolean r107 = (Boolean) r106;
        if (r107 == null) goto L25;
        boolean r108 = r107.booleanValue();
    L26:
        Object r109 = r110.get("offset");
        if ((r109 instanceof Integer) == true) goto L29;
        r109 = null;
    L29:
        Integer r112 = (Integer) r109;
        if (r112 == null) goto L32;
        int r113 = r112.intValue();
    L33:
        int r114 = Math.abs(this.f74060n - r113);
        long r115 = System.currentTimeMillis() - this.f74063q;
        if (this.f74048b == false) goto L52;
        long r116 = r114;
        if (r116 <= vm2.d.m0().a()) goto L40;
        if (r115 <= vm2.d.m0().d()) goto L40;
    L44:
        if (this.f74056j == 0) goto L51;
        long r117 = ((long) ((int) ((System.currentTimeMillis() - r111) + ((long) r113)))) % this.f74056j;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r118 = this.f74055i;
        if (r118 == null) goto L51;
        com.bytedance.android.livesdk.ktvapi.model.mv.h<?> r119 = r118.a();
        if (r119 == null) goto L51;
        r119.seekTo((int) r117);
    L51:
        this.f74063q = System.currentTimeMillis();
    L40:
        if (r116 <= vm2.d.m0().c()) goto L52;
        if (r115 > vm2.d.m0().b()) goto L44;
    L52:
        IOrderSingMVInfo r120 = this.f74053g;
        if (r120 == null) goto L57;
        IMVBaseInfo r121 = r120.getMvBaseInfo();
        if (r121 == null) goto L57;
        String r122 = r121.getVid();
    L59:
        if (Intrinsics.areEqual(r100, r122) == false) goto L69;
        IOrderSingMVInfo r123 = this.f74053g;
        if (r123 == null) goto L69;
        if (r123.getMvType() != 2) goto L69;
        if (this.f74054h == false) goto L69;
        if (r210 == null) goto L68;
        Unit r124 = r210.invoke(this.f74053g);
    L68:
        this.f74054h = false;
    L69:
        IOrderSingMVInfo r125 = this.f74052f;
        if (r125 != null) goto L72;
    L93:
        IOrderSingMVInfo r126 = this.f74052f;
        if (r126 != null) goto L96;
    L97:
        if (r108 == false) goto L100;
    L98:
        return true;
    L100:
        return false;
    L96:
        if (r126.getMvType() == 1) goto L98;
    L72:
        if (r125.getMvType() != 2) goto L93;
        if (r100.length() <= 0) goto L76;
        boolean r127 = true;
    L77:
        if (r127 == false) goto L85;
        IOrderSingMVInfo r128 = this.f74052f;
        if (r128 == null) goto L84;
        IMVBaseInfo r129 = r128.getMvBaseInfo();
        if (r129 == null) goto L84;
        r102 = r129.getVid();
    L84:
        if ((!Intrinsics.areEqual(r102, r100)) == false) goto L85;
    L86:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r130 = this.f74055i;
        if (r130 == null) goto L91;
        com.bytedance.android.livesdk.ktvapi.model.mv.h<?> r131 = r130.a();
        if (r131 == null) goto L91;
        r131.pause();
    L91:
        b();
        this.f74059m = false;
        return false;
    L85:
        if (r108 == true) goto L93;
    L76:
        r127 = false;
    L57:
        r122 = null;
        goto L59
    L32:
        r113 = 0;
        goto L33
    L25:
        r108 = false;
        goto L26
    L11:
        r111 = 0;
        goto L12
    }

    public static /* synthetic */ void j(InteractiveSongMvManager r100, IOrderSingMVInfo r101, boolean r102) {
        r100.i(r101, false, r102, null, null);
    }

    public final void i(IOrderSingMVInfo r100, boolean r101, boolean r110, final Function1<? super Long, Unit> r111, final Function0<Unit> r112) {
        b();
        this.f74053g = r100;
        String r102 = "";
        if (r100 == null) goto L8;
        IMVBaseInfo r103 = r100.getMvBaseInfo();
        if (r103 == null) goto L8;
        String r104 = r103.getVid();
        if (r104 == null) goto L8;
    L9:
        this.f74061o = r104;
        boolean r105 = true;
        if (r100 != null) goto L12;
    L13:
        if (r110 == true) goto L22;
        if (r101 == true) goto L22;
        if (r100 != null) goto L18;
    L19:
        if (r110 == true) goto L30;
        this.f74054h = true;
        return;
    L30:
        InteractiveSongContext r113 = InteractiveSongContext.Companion.getContext();
        if (r113 == null) goto L37;
        com.bytedance.live.datacontext.i<Boolean> r114 = r113.isFeed();
        if (r114 == null) goto L37;
        if (r114.getValue().booleanValue() == true) goto L37;
        final boolean r115 = true;
    L39:
        if (r115 == false) goto L49;
        String r106 = this.f74068v;
        if (r106 != null) goto L48;
        IInteractService r107 = (IInteractService) k.f(IInteractService.class);
        if (r107 == null) goto L47;
        com.bytedance.android.live.liveinteract.plantform.performance.a r108 = r107.getMultiLinkPerfAbilityManager(true);
        if (r108 == null) goto L47;
        r106 = r108.b("multilink_dynamic_bg", new InteractiveSongMvManager$setMvInfo$1(this));
    L47:
        r106 = null;
    L48:
        this.f74068v = r106;
    L49:
        if (r100 == null) goto L57;
        IMVBaseInfo r109 = r100.getMvBaseInfo();
        if (r109 == null) goto L57;
        IMVUrlStruct r116 = r109.getDownloadAddr();
        if (r116 == null) goto L57;
        List<String> r117 = r116.getUrlList();
        if (r117 == null) goto L57;
        int r118 = r117.size();
    L58:
        if (r118 <= 0) goto L73;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r119 = this.f74055i;
        if (r119 == null) goto L73;
        if (r100 == null) goto L72;
        IMVBaseInfo r120 = r100.getMvBaseInfo();
        if (r120 == null) goto L72;
        IMVUrlStruct r121 = r120.getDownloadAddr();
        if (r121 == null) goto L72;
        List<String> r122 = r121.getUrlList();
        if (r122 == null) goto L72;
        String r123 = (String) ListProtector.get(r122, 0);
        if (r123 == null) goto L72;
        r102 = r123;
    L72:
        r119.h(r102);
    L73:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r124 = this.f74055i;
        if (r124 == null) goto L81;
        com.bytedance.android.livesdk.ktvapi.model.mv.h<?> r125 = r124.a();
        if (r125 == null) goto L81;
        this.f74060n = 0;
        r125.l(new InteractiveSongMvManager$setMvInfo$$inlined$apply$lambda$1(this, r115, r111, r112));
        Function1<? super Integer, Unit> r126 = this.f74067u;
        if (r126 == null) goto L80;
        r125.i(r126);
    L80:
        Function1<Integer, Unit> r127 = new InteractiveSongMvManager$setMvInfo$$inlined$apply$lambda$2(this, r115, r111, r112);
        this.f74067u = r127;
        r125.k(r127);
        r125.f451187e = new c(r111, r112);
        r125.pause();
        this.f74059m = false;
    L81:
        if (r101 == false) goto L83;
        if (r100 == null) goto L83;
    L86:
        d(false, r101);
        if (r101 == false) goto L111;
        m<IRoom> r128 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r128 == null) goto L112;
        IRoom r129 = r128.getValue();
        if (r129 != null) goto L93;
        return;
    L93:
        if (r129.isLiveTypeAudio() != true) goto L114;
        j<com.bytedance.android.live.pushstream.d> r130 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r130 == null) goto L115;
        com.bytedance.android.live.pushstream.d r131 = r130.getValue();
        if (r131 != null) goto L99;
        return;
    L99:
        if (r100.getMvType() == 2) goto L102;
        r105 = false;
    L102:
        if (r105 == false) goto L104;
        r131.Z0(4, new uv0.a(LiveRequestSourceRole.Business, "InteractiveSongMvManager.openMvBackgroundExtern", null));
    L105:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r132 = this.f74055i;
        if (r132 == null) goto L117;
        r132.f(r105, r131, false);
        return;
    L117:
        return;
    L104:
        r131.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "InteractiveSongMvManager.openMvBackgroundRadio", null));
        goto L105
    L115:
        return;
    L114:
        return;
    L112:
        return;
    L111:
        return;
    L83:
        if (r100 != null) goto L85;
        return;
    L85:
        if (r100.getMvType() == 1) goto L86;
        return;
    L57:
        r118 = 0;
    L37:
        r115 = false;
        goto L39
    L18:
        if (r100.getMvType() == 1) goto L30;
    L22:
        if (r110 == true) goto L29;
        Disposable r133 = this.f74057k;
        if (r133 == null) goto L26;
        r133.dispose();
    L26:
        Disposable r134 = this.f74058l;
        if (r134 == null) goto L29;
        r134.dispose();
    L29:
        this.f74052f = r100;
        goto L30
    L12:
        if (r100.getMvType() == 1) goto L22;
    L8:
        r104 = "";
        goto L9
    }
}
