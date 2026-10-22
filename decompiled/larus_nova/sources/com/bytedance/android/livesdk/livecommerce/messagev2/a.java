package com.bytedance.android.livesdk.livecommerce.messagev2;

import ak2.l;
import am3.g;
import android.content.Context;
import bh2.w;
import bh2.x;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.live.r;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.controller.y;
import com.bytedance.android.livesdk.livecommerce.room.j;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sg2.e0;
import sg2.g0;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends c0 implements td.a, IExternalMessageListener, nl2.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f149392k = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.d f149393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f149394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e0> f149395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<y>> f149396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<r> f149397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.messagev2.b f149398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j f149399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ nl2.a f149400j;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.messagev2.a$a, reason: collision with other inner class name */
    public static final class C2312a {
    }

    public static final class b<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f149401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ee.a f149402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f149403c;

        public b(a r100, ee.a r101, boolean r102) {
            this.f149401a = r100;
            this.f149402b = r101;
            this.f149403c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final sg2.a call() {
            a r100 = this.f149401a;
            fe.a r101 = (fe.a) this.f149402b;
            boolean r110 = this.f149403c;
            int r102 = a.f149392k;
            r100.getClass();
            long r111 = System.currentTimeMillis();
            x r103 = x.f19023e;
            String r104 = r101.u();
            String r105 = r101.getContentType();
            byte[] r106 = r101.getContent();
            if (x.f19020b == true) goto L18;
            monitor-enter(r103);
        L14:
            th = move-exception;
            throw th;
        L6:
            if (x.f19020b == true) goto L12;
            Iterator r107 = ((ArrayList) x.f19019a).iterator();     // Catch: Throwable -> L14
        L9:
            if (r107.hasNext() == false) goto L11;
            w r108 = (w) r107.next();     // Catch: Throwable -> L14
            x.f19021c.putAll(r108.b());     // Catch: Throwable -> L14
            x.f19022d.putAll(r108.a());     // Catch: Throwable -> L14
            goto L9
        L11:
            ((ArrayList) x.f19019a).clear();     // Catch: Throwable -> L14
            x.f19020b = true;     // Catch: Throwable -> L14
        L12:
            monitor-exit(r103);
        L18:
            if (r104 != null) goto L20;
        L23:
            boolean r109 = true;
        L25:
            if (r109 == true) goto L63;
            if (r105 != null) goto L28;
        L31:
            boolean r112 = true;
        L32:
            if (r112 == true) goto L63;
            if (r106 != null) goto L36;
        L62:
            bh2.a.a("decode_err_content_empty", r105);
        L64:
            final sg2.a r113 = null;
        L65:
            if (r113 == null) goto L67;
            String r114 = r101.m();
            String r115 = r101.getContentType();
            long r116 = r101.x();
            TraceTimeMetricV2 r117 = r101.d();
            r101.f();
            int r118 = 2;
            r113.setCommon(new sg2.b(r114, r115, r116, r117, null, r110, System.currentTimeMillis()));
        L68:
            Pair[] r119 = new Pair[r118];
            r119[0] = TuplesKt.to("contentType", r101.getContentType());
            r119[1] = TuplesKt.to(ChameleonOpenTracker.ParamKey.COST, String.valueOf(System.currentTimeMillis() - r111));
            final Map r120 = MapsKt.mutableMapOf(r119);
            com.bytedance.android.ec.sdk.helper.l.a(new MessageV2Controller$decodeMessage$$inlined$apply$lambda$1(r120, r113));
            Unit r121 = Unit.INSTANCE;
            xh.b r122 = new xh.b();
            r122.c(null);
            r122.b("MsgDecode");
            r122.a(r120);
            xh.c.a("Live").f(r118, r122);
            return r113;
        L67:
            r118 = 2;
            goto L68
        L36:
            if (r106.length != 0) goto L38;
            boolean r123 = true;
        L39:
            if (r123 == true) goto L62;
            if (Intrinsics.areEqual(r104, "application/vnd.google.protobuf") == false) goto L61;
            Class<?> r124 = (Class) ((LinkedHashMap) x.f19021c).get(r105);
            if (r124 != null) goto L46;
            Map r125 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "msg clazz not registered"), TuplesKt.to("contentType", r105)});
            xh.b r126 = new xh.b();
            r126.c(null);
            r126.b("MsgDecode");
            r126.a(r125);
            xh.c.a("Live").f(5, r126);
            goto L64
        L46:
            am3.c<?> r127 = r103.a(r124);
            g r128 = new g();
            r128.k(new am3.b(r106));     // Catch: Exception -> L60
            if (r127 == null) goto L50;
            Object r129 = r127.decode(r128);     // Catch: Exception -> L60
        L51:
            if (r129 != null) goto L56;
            if (r127 != null) goto L54;
            bh2.a.a("decode_err_decoder_notfound", r105);     // Catch: Exception -> L60
            goto L56
        L54:
            bh2.a.a("decode_err_decode_bytes", r105);     // Catch: Exception -> L60
        L56:
            if ((r129 instanceof sg2.a) == true) goto L58;
            r129 = null;
        L58:
            r113 = (sg2.a) r129;     // Catch: Exception -> L60
            goto L65
        L50:
            r129 = null;
        L60:
            bh2.a.a("decode_err_exception", r105);
            goto L64
        L61:
            bh2.a.a("decode_err_invalid_format", r105);
            goto L64
        L38:
            r123 = false;
            goto L39
        L28:
            if (r105.length() == 0) goto L31;
            r112 = false;
        L63:
            bh2.a.a("decode_err_info_empty", r105);
            goto L64
        L20:
            if (r104.length() == 0) goto L23;
            r109 = false;
            goto L25
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f149404a;

        public c(a r100) {
            this.f149404a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            sg2.a r111 = (sg2.a) r110;
            a r100 = this.f149404a;
            r100.getClass();
            if (r111 == null) goto L7;
            sg2.b r101 = r111.getCommon();
            if (r101 == null) goto L7;
            String r102 = r101.f541771b;
        L8:
            if (r102 == null) goto L53;
            boolean r103 = false;
            monitor-enter(r100);     // Catch: Exception -> L33
        L30:
            th = move-exception;
            throw th;     // Catch: Exception -> L33
        L13:
            if (((ArrayList) r100.f149395e).isEmpty() == false) goto L15;
            List<e0> r104 = r100.f149395e;     // Catch: Throwable -> L30
            int r105 = com.bytedance.android.livesdk.livecommerce.message.c.f149391a;     // Catch: Throwable -> L30
            ((ArrayList) r104).addAll(com.bytedance.android.livesdk.livecommerce.message.c.a(true, r100.A()));     // Catch: Throwable -> L30
        L15:
            ArrayList r106 = (ArrayList) r100.f149395e;     // Catch: Throwable -> L30
            Iterator r107 = r106.iterator();     // Catch: Throwable -> L30
        L17:
            if (r107.hasNext() == false) goto L25;
            e0 r108 = (e0) r107.next();     // Catch: Throwable -> L30
            if ((r108 instanceof com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a) == true) goto L21;
            r108 = null;
        L21:
            com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a r109 = (com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a) r108;     // Catch: Throwable -> L30
            if (r109 == null) goto L17;
            j r112 = r100.f149399i;     // Catch: Throwable -> L30
            Intrinsics.checkNotNullParameter(r112, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Throwable -> L30
            r109.f149416a = r112;     // Catch: Throwable -> L30
            r109.f149417b = r112.roomId();     // Catch: Throwable -> L30
            r109.f149418c = r112.a();     // Catch: Throwable -> L30
            r109.e(r109.f149417b, r112.isAnchor());     // Catch: Throwable -> L30
            goto L17
        L25:
            if (r106.size() > 0) goto L27;
            boolean r113 = false;
        L28:
            monitor-exit(r100);     // Catch: Exception -> L33
            r103 = r113;
        L35:
            if (r103 == true) goto L42;
            List r114 = (List) ((HashMap) r100.f149396f).get(r102);
            if (r114 == null) goto L42;
            Iterator<T> r115 = r114.iterator();
        L40:
            if (r115.hasNext() == false) goto L42;
            ((y) r115.next()).onReceive(r111);
        L42:
            r100.A().f151427r.K();
            return;
        L27:
            r113 = ((e0) ListProtector.get(r106, 0)).a(new g0(r106, 1, r111));     // Catch: Throwable -> L30
        L33:
            e = move-exception;
            ECExceptionMonitor.e(e);
            goto L35
        L53:
            return;
        L7:
            r102 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f149405a;

        public d(a r100) {
            this.f149405a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            String r102 = r101.getMessage();
            if (r102 != null) goto L6;
            r102 = "";
        L6:
            if (StringsKt.contains$default(r102, "The callable returned a null value", false, 2, null) == false) goto L8;
            this.f149405a.getClass();
            Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "msg decode return null, pls check cause message before")});
            xh.b r104 = new xh.b();
            r104.c(null);
            r104.b("MsgDecode");
            r104.a(r103);
            xh.c.a("Live").f(5, r104);
            return;
        L8:
            ECExceptionMonitor.e(r101);
        }
    }

    static {
    }

    @Override // nl2.c
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f149400j.add(r100);
        return r100;
    }

    public final synchronized void I() {
        monitor-enter(this);
        l r100 = this.f149394d;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        r100.b();     // Catch: Throwable -> L10
        Map r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "releaseVirtualMessageManager: virturalMsgManager: " + this.f149394d)});     // Catch: Throwable -> L10
        xh.b r102 = new xh.b();     // Catch: Throwable -> L10
        r102.c(null);     // Catch: Throwable -> L10
        r102.b("VirtualMsgChannel");     // Catch: Throwable -> L10
        r102.a(r101);     // Catch: Throwable -> L10
        xh.c.a("Live").f(4, r102);     // Catch: Throwable -> L10
    L7:
        this.f149394d = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        CompositeDisposable r100 = this.f149400j.f519544a;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        com.bytedance.android.livesdk.livecommerce.room.api.d r101 = this.f149393c;
        if (r101 == null) goto L11;
        r101.b(this);
        com.bytedance.android.livesdk.livecommerce.room.api.d r102 = this.f149393c;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("messageHandler");
    L10:
        r102.c(this);
    L11:
        I();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        monitor-enter(this);
        ((ArrayList) this.f149395e).clear();     // Catch: Throwable -> L8
        ((HashMap) this.f149396f).clear();     // Catch: Throwable -> L8
        ((ArrayList) this.f149397g).clear();     // Catch: Throwable -> L8
        monitor-exit(this);
        I();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void H(long r110) {
        if (r110 <= 0) goto L44;
        monitor-enter(this);
        l r100 = this.f149394d;     // Catch: Throwable -> L40
        if (r100 != null) goto L9;
    L19:
        if (r100 == null) goto L22;
        I();     // Catch: Throwable -> L40
        Map r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "Warning: an unreleased VirtualMessageManager before create new: " + this.f149394d)});     // Catch: Throwable -> L40
        xh.b r102 = new xh.b();     // Catch: Throwable -> L40
        r102.c(null);     // Catch: Throwable -> L40
        r102.b("VirtualMsgChannel");     // Catch: Throwable -> L40
        r102.a(r101);     // Catch: Throwable -> L40
        xh.c.a("Live").f(5, r102);     // Catch: Throwable -> L40
    L22:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L28;
        ILiveService r103 = TTLiveService.getLiveService();     // Catch: Throwable -> L40
        if (r103 == null) goto L26;
        vlc.d r104 = r103.createCustomSceneMessageManager("ecom_live_virtual", r110, m(), new LinkedHashMap());     // Catch: Throwable -> L40
    L27:
        this.f149394d = new l(r110, r104);     // Catch: Throwable -> L40
    L31:
        l r105 = this.f149394d;     // Catch: Throwable -> L40
        if (r105 == null) goto L34;
        r105.c();     // Catch: Throwable -> L40
    L34:
        l r106 = this.f149394d;     // Catch: Throwable -> L40
        if (r106 == null) goto L37;
        r106.a(this);     // Catch: Throwable -> L40
    L37:
        Map r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "createMessageManagerByVirtualID: " + r110 + ", virturalMsgManager: " + this.f149394d)});     // Catch: Throwable -> L40
        xh.b r112 = new xh.b();     // Catch: Throwable -> L40
        r112.c(null);     // Catch: Throwable -> L40
        r112.b("VirtualMsgChannel");     // Catch: Throwable -> L40
        r112.a(r111);     // Catch: Throwable -> L40
        xh.c.a("Live").f(4, r112);     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L26:
        r104 = null;
        goto L27
    L28:
        int r107 = ECSdk.f48106a;     // Catch: Throwable -> L40
        IAdapterService r108 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Throwable -> L40
        if (r108 == null) goto L31;
        r108.getMessageManagerService();     // Catch: Throwable -> L40
        goto L31
    L9:
        if (r100.f3989a != r110) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == false) goto L14;
        l r113 = r100;
    L15:
        if (r113 == null) goto L19;
        Map r114 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("detail", "virtualMessageManager already created, VirtualID: " + r110)});     // Catch: Throwable -> L40
        xh.b r115 = new xh.b();     // Catch: Throwable -> L40
        r115.c(null);     // Catch: Throwable -> L40
        r115.b("VirtualMsgChannel");     // Catch: Throwable -> L40
        r115.a(r114);     // Catch: Throwable -> L40
        xh.c.a("Live").f(3, r115);     // Catch: Throwable -> L40
        monitor-exit(this);
        return;
    L14:
        r113 = null;
        goto L15
    L11:
        r109 = false;
    L40:
        th = move-exception;
        throw th;
    L44:
        if (r110 != (-1)) goto L48;
        I();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void g(com.bytedance.android.livesdk.livecommerce.room.api.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        Intrinsics.checkNotNullParameter(r100, "messageHandler");
        this.f149393c = r100;
        r100.a(1003, this);
        r100.d(this);
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof fe.a) == false) goto L6;
        f((ee.a) r100, false);
        return;
    }

    public a(RealRoomController$roomResources$1 r100, RealRoomController.d r101) {
        Intrinsics.checkNotNullParameter(r100, "roomResources");
        Intrinsics.checkNotNullParameter(r101, "roomStateProvider");
        super(r100);
        this.f149400j = new nl2.a();
        this.f149399i = r101;
        this.f149395e = new ArrayList();
        this.f149396f = new HashMap();
        this.f149397g = new ArrayList();
        this.f149398h = new com.bytedance.android.livesdk.livecommerce.messagev2.b(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r100, com.bytedance.android.ec.adapter.api.state.a r101) {
        super.c(r100, r101);
        monitor-enter(this);
        ((ArrayList) this.f149395e).clear();     // Catch: Throwable -> L8
        ((HashMap) this.f149396f).clear();     // Catch: Throwable -> L8
        ((ArrayList) this.f149397g).clear();     // Catch: Throwable -> L8
        monitor-exit(this);
        I();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // td.a
    public final void f(ee.a r100, boolean r101) {
        if ((r100 instanceof fe.a) == false) goto L6;
        nl2.b.a(Single.fromCallable(new b(this, r100, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this)), this);
        return;
    }
}
