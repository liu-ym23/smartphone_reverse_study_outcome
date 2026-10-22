package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdk.config.q61;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class PadBubbleLoader extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f115789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f115790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f115791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f115792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f115793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f115794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f115795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Keva f115796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f115797j;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f115798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ToolbarButton f115799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final pp1.c f115800c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C1715a f115801d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PadBubbleLoader f115802e;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.PadBubbleLoader$a$a, reason: collision with other inner class name */
        public static final class C1715a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f115803a;

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r100) {
                Intrinsics.checkNotNullParameter(r100, "bubble");
            }

            public C1715a(a r100) {
                this.f115803a = r100;
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r100) {
                Intrinsics.checkNotNullParameter(r100, "bubble");
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r101 = this.f115803a.f115802e.f115779a.a().query(r100.getId());
                if (r101 == null) goto L6;
                r101.h();
                this.f115803a.f115802e.f115779a.a().f(r101);
                return;
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r110) {
                Intrinsics.checkNotNullParameter(r110, "bubble");
                if (r110.getId() != 1001) goto L43;
                PadBubbleLoader r111 = this.f115803a.f115802e;
                String r100 = r111.f115796i.getString(r111.f115797j, "");
                List r101 = null;
                if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r100) == false) goto L7;
                String r102 = r100;
            L8:
                if (r102 == null) goto L27;
                List r103 = StringsKt.split$default(r102, new String[]{","}, false, 0, 6, null);
                if (r103 == null) goto L27;
                ArrayList r104 = new ArrayList();
                Iterator r105 = r103.iterator();
            L13:
                if (r105.hasNext() == false) goto L17;
                Long r106 = StringsKt.toLongOrNull((String) r105.next());
                if (r106 == null) goto L13;
                r104.add(r106);
                goto L13
            L17:
                List r107 = CollectionsKt.toMutableList(r104);
                if (r107 == null) goto L27;
                r107.add(Long.valueOf(System.currentTimeMillis()));
                Unit r108 = Unit.INSTANCE;
                List r109 = CollectionsKt.takeLast(r107, 3);
                if (r109 == null) goto L27;
                if ((!r109.isEmpty()) == false) goto L24;
                r101 = r109;
            L24:
                if (r101 == null) goto L27;
                String r112 = CollectionsKt.joinToString$default(r101, ",", null, null, 0, null, null, 62, null);
                if (r112 == null) goto L27;
            L29:
                if (v.a() == false) goto L36;
                MorePanelBubbleAlog.SimpleAlogArgsBuilder r113 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
                r113.d(r111.f115789b);
                r113.c("vs气泡展示记录：" + r112);
                MorePanelBubbleAlog.a(r113.b());
            L36:
                r111.f115796i.storeString(r111.f115797j, r112);     // Catch: Exception -> L33
                return;
            L33:
                e = move-exception;
                EnsureManager.ensureNotReachHere(e, "PadBubbleLoader: 保存近3次展示时间差失败");
                return;
            L27:
                r112 = String.valueOf(System.currentTimeMillis());
                goto L29
            L7:
                r102 = null;
                goto L8
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.f115799b;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return this.f115801d;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return this.f115798a;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.f115800c;
        }

        public a(PadBubbleLoader r100) {
            this.f115802e = r100;
            RoomContext r101 = r100.f115779a.f115776b;
            if (r101 != null) goto L5;
        L7:
            int r102 = 1000;
        L8:
            this.f115798a = r102;
            this.f115799b = ToolbarButton.PAD_AND_PC_PLAY;
            int r103 = pp1.c.f530166o;
            String r104 = ((q61) r100.f115791d.getValue()).b();
            Intrinsics.checkNotNullParameter(r104, "content");
            pp1.c.a.C7221a r105 = new pp1.c.a.C7221a(r104);
            r105.f530182b = (int) ((q61) r100.f115791d.getValue()).c();
            this.f115800c = r105.a();
            this.f115801d = new C1715a(this);
            return;
        L5:
            if (r101.isVSRoom() != true) goto L7;
            r102 = 1001;
            goto L8
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        if (com.bytedance.android.livesdk.castscreen.utils.d.c() == true) goto L5;
    L11:
        boolean r100 = false;
    L12:
        RoomContext r101 = this.f115779a.f115776b;
        if (r101 != null) goto L15;
    L66:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r102 = this.f115779a.a().query(1000);
        if (r102 != null) goto L69;
        return r100;
    L69:
        boolean r103 = r102.g();
        if (Math.abs(System.currentTimeMillis() - r102.c()) > 604800000) goto L72;
        boolean r104 = true;
    L73:
        if (r103 == true) goto L78;
        if (r104 == true) goto L78;
    L76:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r105 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r105.d(this.f115789b);
        r105.c("enable load padcast bubble guide: " + r100);
        MorePanelBubbleAlog.a(r105.b());
        return r100;
    L78:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r106 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r106.d(this.f115789b);
        r106.c("直播间无法加载pad投屏引导气泡（频控）");
        Pair[] r107 = {TuplesKt.to("interceptShowByCommonCondition", Boolean.valueOf(r103)), TuplesKt.to("onWeekShowIntercept", Boolean.valueOf(r104))};
        int r108 = 0;
    L79:
        if (r108 >= 2) goto L86;
        Pair r109 = r107[r108];
        if (r109 == null) goto L85;
        Object r110 = r109.getSecond();
        if (r110 == null) goto L85;
        r106.a((String) r109.getFirst(), r110);
    L85:
        r108 = r108 + 1;
        goto L79
    L86:
        MorePanelBubbleAlog.a(r106.b());
        return false;
    L72:
        r104 = false;
        goto L73
    L15:
        if (r101.isVSRoom() != true) goto L66;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r111 = this.f115779a.a().query(1001);
        if (r111 != null) goto L19;
        return r100;
    L19:
        Calendar r112 = Calendar.getInstance();
        r112.add(2, -3);
        long r113 = r112.getTimeInMillis();
        boolean r114 = r111.e();
        long r115 = System.currentTimeMillis();
        String r116 = this.f115796i.getString(this.f115797j, "");
        if (r116 != null) goto L22;
    L45:
        boolean r117 = false;
    L46:
        if (r114 == false) goto L48;
    L52:
        boolean r118 = false;
    L53:
        if (r114 == true) goto L56;
        if (r117 == true) goto L56;
        if (r118 == false) goto L76;
    L56:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r119 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r119.d(this.f115789b);
        r119.c("vs直播间无法加载pad投屏引导气泡（频控）");
        Pair[] r120 = {TuplesKt.to("hasFinished", Boolean.valueOf(r114)), TuplesKt.to("inVsInterval", Boolean.valueOf(r117)), TuplesKt.to("isTimeout", Boolean.valueOf(r118))};
        int r121 = 0;
    L57:
        if (r121 >= 3) goto L64;
        Pair r122 = r120[r121];
        if (r122 == null) goto L63;
        Object r123 = r122.getSecond();
        if (r123 == null) goto L63;
        r119.a((String) r122.getFirst(), r123);
    L63:
        r121 = r121 + 1;
        goto L57
    L64:
        MorePanelBubbleAlog.a(r119.b());
        return false;
    L48:
        if (r111.d() < 5) goto L52;
        if (r111.c() >= r113) goto L52;
        r118 = true;
        goto L53
    L22:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r116) == true) goto L25;
        r116 = null;
    L25:
        String r124 = r116;
        if (r124 == null) goto L45;
        List r125 = StringsKt.split$default(r124, new String[]{","}, false, 0, 6, null);
        if (r125 == null) goto L45;
        ArrayList r126 = new ArrayList();
        Iterator r127 = r125.iterator();
    L31:
        if (r127.hasNext() == false) goto L35;
        Long r128 = StringsKt.toLongOrNull((String) r127.next());
        if (r128 == null) goto L31;
        r126.add(r128);
        goto L31
    L35:
        List r129 = CollectionsKt.asReversed(r126);
        if (r129 == null) goto L45;
        Iterator r130 = r129.iterator();
        int r131 = 0;
    L39:
        if (r130.hasNext() == false) goto L45;
        if (Math.abs(r115 - ((Number) r130.next()).longValue()) > 604800000) goto L44;
        if (r131 < 2) goto L44;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r132 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r132.d(this.f115789b);
        r132.c("展示pad引导气泡被拦截，vs房间一周最多展示3次");
        MorePanelBubbleAlog.a(r132.b());
        r117 = true;
    L44:
        r131 = r131 + 1;
        goto L39
    L5:
        if (PadConfigUtils.a() == true) goto L11;
        if (z.e(this.f115779a.f115777c, false) == true) goto L11;
        if (((q61) this.f115791d.getValue()).d() != 1) goto L11;
        r100 = true;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return new a(this);
    }

    public final void b() {
        boolean r100 = LivePadAndPcPlayUtil.i(this.f115779a.f115777c);
        boolean r101 = LivePadAndPcPlayUtil.g(this.f115779a.f115777c);
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r102 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r102.d(this.f115789b);
        r102.c("check2ShowBubble");
        int r103 = 0;
        Pair[] r104 = {TuplesKt.to("isTimeToShow", Boolean.valueOf(this.f115793f)), TuplesKt.to("hasDevices", Boolean.valueOf(this.f115794g)), TuplesKt.to("hasNotify2Show", Boolean.valueOf(this.f115795h)), TuplesKt.to("pcRoomAuthEnable", Boolean.valueOf(r100)), TuplesKt.to("padRoomAuthEnable", Boolean.valueOf(r101))};
    L3:
        if (r103 >= 5) goto L10;
        Pair r105 = r104[r103];
        if (r105 == null) goto L9;
        Object r106 = r105.getSecond();
        if (r106 == null) goto L9;
        r102.a((String) r105.getFirst(), r106);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        MorePanelBubbleAlog.a(r102.b());
        if (this.f115793f == true) goto L13;
        return;
    L13:
        if (this.f115794g == true) goto L15;
        return;
    L15:
        if (this.f115795h == true) goto L26;
        if (r100 == false) goto L27;
        if (r101 == false) goto L28;
        this.f115795h = true;
        a();
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        this.f115794g = ((IHostBusiness) this.f115792e.getValue()).hasPadDevice();
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r100 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r100.d(this.f115789b);
        r100.c("checkDevices");
        r100.a("hasDevices", Boolean.valueOf(this.f115794g));
        MorePanelBubbleAlog.a(r100.b());
        if (this.f115794g == true) goto L7;
        Pair<Disposable, Observable<Map<String, Object>>> r101 = ((IHostBusiness) this.f115792e.getValue()).startScanPadDevice();
        if (r101 == null) goto L8;
        this.f115790c.add(r101.getFirst());
        RxUtilKt.c(RxUtilKt.h(r101.getSecond()).subscribe(new f(this), g.f115832a), this.f115790c);
    L8:
        Function0<Unit> r102 = new PadBubbleLoader$checkTime2Show$1(this);
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        Boolean r104 = null;
        if (r103 == null) goto L13;
        IRoomEventHub r105 = r103.getEventHub();
        if (r105 == null) goto L13;
        MutableLiveData<Boolean> r106 = r105.getFirstFrame();
    L14:
        if (r106 == null) goto L17;
        r104 = r106.getValue();
    L17:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L19;
        r102.invoke();
        return;
    L19:
        i r107 = new i(r102);
        if (r106 == null) goto L22;
        r106.observeForever(r107);
    L22:
        this.f115790c.add(Disposables.fromAction(new h(r106, r107)));
        return;
    L13:
        r106 = null;
        goto L14
    L7:
        b();
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
        this.f115790c.clear();
    }

    public PadBubbleLoader(BubbleEnv r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        super(r100);
        this.f115789b = "PadBubbleLoader";
        this.f115790c = new CompositeDisposable();
        this.f115791d = LazyKt.lazy(PadBubbleLoader$setting$2.INSTANCE);
        this.f115792e = LazyKt.lazy(PadBubbleLoader$hostBusiness$2.INSTANCE);
        this.f115796i = Keva.getRepo("PadBubble");
        this.f115797j = "PadCastForVs";
    }
}
