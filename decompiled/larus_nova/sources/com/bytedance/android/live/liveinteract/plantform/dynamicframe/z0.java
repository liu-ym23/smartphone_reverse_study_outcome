package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.na0;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f77176a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f77177b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ih0.c f77178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MultiLinkSimplePools<ih0.c> f77179d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Disposable f77180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Disposable f77181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final z0 f77182g = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ih0.c f77183a;

        public a(ih0.c r100) {
            this.f77183a = r100;
        }

        public final void a() {
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card start");
            ih0.c r100 = this.f77183a;
            if (r100 == null) goto L5;
            ih0.c.a.a(r100, null, null, 7);
        L5:
            ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card end");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f77184a = null;

        static {
            f77184a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            f2.g();
            int r102 = z0.f77177b;
            if (z0.d() == false) goto L11;
            ih0.c r103 = z0.f77178c;
            if (r103 == null) goto L7;
            r103.J();
        L7:
            ih0.c r104 = z0.f77178c;
            if (r104 == null) goto L10;
            r104.release();
        L10:
            z0.f77178c = null;
        L14:
            ALogger.d("MultiLinkDynamicWidget", "清除渲染容器缓存");
            return;
        L11:
            ih0.c r105 = z0.f77179d.acquire();
        L12:
            if (r105 == null) goto L14;
            r105.J();
            r105.release();
            r105 = z0.f77179d.acquire();
            goto L12
        }
    }

    public z0() {
    }

    static {
        f77182g = new z0();
        f77176a = vm2.h.O().g();
        f77177b = vm2.h.O().d();
        f77179d = new MultiLinkSimplePools(vm2.h.O().f());
    }

    public static boolean c() {
        boolean r100 = false;
        if (d() == false) goto L12;
        StringBuilder r101 = new StringBuilder("有无AnnieCard缓存？ ");
        if (f77178c == null) goto L7;
        boolean r102 = true;
    L8:
        r101.append(r102);
        ALogger.i("MultiLinkRenderWidgetReuseManager", r101.toString());
        if (f77178c == null) goto L32;
        return true;
    L32:
        return false;
    L7:
        r102 = false;
        goto L8
    L12:
        StringBuilder r103 = new StringBuilder("有无AnnieCard复用池缓存？ ");
        MultiLinkSimplePools<ih0.c> r104 = f77179d;
        if (r104.f76865a.size() != 0) goto L15;
        boolean r105 = true;
    L16:
        r103.append(!r105);
        r103.append(" mHybridCardPool=");
        r103.append(r104.a());
        ALogger.i("MultiLinkRenderWidgetReuseManager", r103.toString());
        if (MultiLinkLoadWidgetUtils.g() == true) goto L19;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == false) goto L29;
        if (r104.f76865a.size() != 0) goto L27;
        r100 = true;
    L27:
        return !r100;
    L29:
        if (r104.a() < f77177b) goto L33;
        return true;
    L33:
        return false;
    L19:
        if (vm2.h.W().disablePreloadRenderWidget() == false) goto L21;
        r106 = true;
        goto L22
    L15:
        r105 = false;
        goto L16
    }

    public static boolean d() {
        if (vm2.h.O().i() == true) goto L5;
        return true;
    L5:
        if (vm2.h.O().f() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static void e(ih0.c r100) {
        if (com.bytedance.android.live.liveinteract.utils.w0.a() == false) goto L5;
        Schedulers.io().scheduleDirect(new a(r100));
        return;
    L5:
        ALogger.i("MultiLinkDynamicWidget-Time", ThreadMethodProxy.currentThread().getName() + ":load card 2 start");
        ih0.c.a.a(r100, null, null, 7);
    }

    public static com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b a(z0 r100, Context r101, DataCenter r102) {
        r100.getClass();
        boolean r103 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f77143a;
        String r104 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r105 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        com.bytedance.live.datacontext.m<IRoom> r106 = o3.j(r102).getRoom();
        HybridCard r107 = null;
        if (r106 == null) goto L7;
        IRoom r108 = r106.getValue();
        if (r108 == null) goto L7;
        Long r109 = Long.valueOf(r108.getRoomId());
    L8:
        Uri r110 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r104, r105, r109, false, 0, false, 48);
        y0 r111 = new y0(r110, null);
        IBaseBrowserService r112 = (IBaseBrowserService) jc1.k.f(IBaseBrowserService.class);
        if (r112 == null) goto L11;
        r107 = r112.getHybridCard(r101, r110, r111);
    L11:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b r113 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(r107);
        r111.f77169a = r113;
        return r113;
    L7:
        r109 = null;
        goto L8
    }

    public static void g(ih0.c r100, DataCenter r101, MessageHub r102) {
        ALogger.i("MultiLinkRenderWidgetReuseManager", "开始回收AnnieCard...AnnieCard=" + r100);
        JsonObject r103 = new JsonObject();
        r103.addProperty(NewBroadcastMonitor.STAGE.LIFECYCLE, BasicTestActionHandler.TEST_ACTION_RESET);
        if (r100 == null) goto L5;
        r100.sendJsEvent("renderWidgetLifecycle", r103);
    L5:
        ih0.c r104 = f77178c;
        if (r104 == null) goto L9;
        r104.J();
    L9:
        if (d() == false) goto L18;
        ih0.c r105 = f77178c;
        if (r105 != null) goto L14;
        f77178c = r100;
        ALogger.e("MultiLinkRenderWidgetReuseManager", "回收AnnieCard...无AnnieCard缓存，回收后作为缓存！mHybridCard=" + f77178c);
    L26:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "回收AnnieCard成功！");
        Disposable r106 = f77181f;
        if (r106 == null) goto L29;
        r106.dispose();
    L29:
        f77181f = RxUtilKt.h(Observable.timer(vm2.h.O().h(), TimeUnit.SECONDS)).subscribe(b.f77184a);
        if (r100 == null) goto L44;
        View r107 = r100.getHybridView();
        if (r107 == null) goto L47;
        com.bytedance.live.datacontext.j<ylc.e> r108 = o3.j(r101).w1();
        if (r108 == null) goto L37;
        ylc.e r109 = r108.getValue();
    L38:
        com.bytedance.android.live.browser.utils.j.c(r107);
        int r110 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.f77134a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.i(r100);
        com.bytedance.android.live.browser.utils.n.d(r107, r101, r102);
        com.bytedance.android.live.browser.utils.n.a(r107, r109, r102);
        if (r101 == null) goto L45;
        HashMap r111 = (HashMap) r101.get("multilink_jsb_message_filter", null);
        if (r111 == null) goto L46;
        r111.clear();
        return;
    L46:
        return;
    L45:
        return;
    L37:
        r109 = null;
        goto L38
    L47:
        return;
    L44:
        return;
    L14:
        if ((!Intrinsics.areEqual(r105, r100)) == false) goto L26;
        ALogger.e("MultiLinkRenderWidgetReuseManager", "回收AnnieCard...有AnnieCard缓存，但与此处回收的AnnieCard不相符！mHybridCard=" + f77178c + "，annieCard=hybridCard");
        if (r100 == null) goto L26;
        r100.release();
        goto L26
    L18:
        if (r100 == null) goto L26;
        MultiLinkSimplePools<ih0.c> r112 = f77179d;
        if (r112.release(r100) == true) goto L23;
        r100.J();
        r100.release();
    L25:
        ALogger.e("MultiLinkRenderWidgetReuseManager", "回收AnnieCard...放入复用池！mHybridCardPool=" + r112.a());
        goto L26
    L23:
        if (j1.f142014a.getValue().getOpenFixV2() == false) goto L25;
        r100.J();
        r100.f1();
        goto L25
    }

    public final ih0.c b(Context r110, Long r111, DataCenter r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "dataCenter");
        ALogger.i("MultiLinkRenderWidgetReuseManager", "开始获取AnnieCard...mHybridCard=" + f77178c);
        Disposable r100 = f77181f;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        long r101 = System.currentTimeMillis();
        boolean r102 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f77143a;
        String r103 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r104 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        com.bytedance.live.datacontext.m<IRoom> r105 = o3.j(r112).getRoom();
        if (r105 == null) goto L10;
        IRoom r106 = r105.getValue();
        if (r106 == null) goto L10;
        Long r107 = Long.valueOf(r106.getRoomId());
    L11:
        Uri r108 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r103, r104, r107, false, 0, false, 48);
        if (d() == true) goto L14;
        LinkedHashMap r109 = new LinkedHashMap();
        if (r111 != null) goto L37;
        com.bytedance.live.datacontext.m<IRoom> r113 = o3.j(r112).getRoom();
        if (r113 == null) goto L36;
        IRoom r114 = r113.getValue();
        if (r114 == null) goto L36;
        Long r115 = Long.valueOf(r114.getRoomId());
    L38:
        if (r115 == null) goto L40;
        r109.put("room_id", String.valueOf(r115.longValue()));
    L40:
        com.bytedance.live.datacontext.m<IRoom> r116 = o3.j(r112).getRoom();
        if (r116 == null) goto L45;
        IRoom r117 = r116.getValue();
        if (r117 == null) goto L45;
        String r118 = r117.getOwnerUserIdString();
    L46:
        String r119 = gh0.a.c();
        if (r118 == null) goto L50;
        r109.put("anchor_id", r118);
    L50:
        if (r2.a(r119) == true) goto L53;
        r119 = null;
    L53:
        if (r119 == null) goto L55;
        r109.put("user_id", r119);
    L55:
        MultiLinkSimplePools<ih0.c> r120 = f77179d;
        ih0.c r121 = r120.acquire();
        if (r121 == null) goto L60;
        ALogger.i("MultiLinkRenderWidgetReuseManager", "有AnnieCard复用池缓存，直接使用，item=" + r121 + ", mHybridCardPool=" + r120.a());
        View r122 = r121.S0();
        if (r122 == null) goto L67;
        r122.setTag(R.id.ttlive_multilink_hybrid_card_reuse_tag, Boolean.TRUE);
    L67:
        r121.updateGlobalProps(r109);
        return r121;
    L60:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "无AnnieCard复用池缓存，开始创建");
        if (na0.f120816a.getValue().booleanValue() == false) goto L63;
        y0 r123 = new y0(r108, null);
        int r124 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.f77142a;
        ih0.c r125 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(r110, r108, r123, r101, r112, false);
        r123.f77169a = r125;
    L64:
        r121 = r125;
        View r126 = r121.S0();
        if (r126 == null) goto L67;
        r126.setTag(R.id.ttlive_multilink_hybrid_card_reuse_tag, Boolean.FALSE);
        goto L67
    L63:
        r125 = a(this, r110, r112);
    L45:
        r118 = null;
    L36:
        r115 = null;
        goto L38
    L37:
        r115 = r111;
        goto L38
    L14:
        if (f77178c != null) goto L22;
        ALogger.i("MultiLinkRenderWidgetReuseManager", "无AnnieCard缓存，开始创建");
        if (na0.f120816a.getValue().booleanValue() == false) goto L18;
        y0 r127 = new y0(r108, null);
        int r128 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.f77142a;
        ih0.c r129 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(r110, r108, r127, r101, r112, false);
        r127.f77169a = r129;
    L19:
        f77178c = r129;
        View r130 = r129.S0();
        if (r130 == null) goto L28;
        r130.setTag(R.id.ttlive_multilink_hybrid_card_reuse_tag, Boolean.FALSE);
    L28:
        return f77178c;
    L18:
        r129 = a(this, r110, r112);
        goto L19
    L22:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "有AnnieCard缓存，直接使用，mHybridCard=" + f77178c);
        ih0.c r131 = f77178c;
        if (r131 == null) goto L28;
        View r132 = r131.S0();
        if (r132 == null) goto L28;
        r132.setTag(R.id.ttlive_multilink_hybrid_card_reuse_tag, Boolean.TRUE);
    L10:
        r107 = null;
        goto L11
    }

    public final void f(Context r110, DataCenter r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (vm2.h.O().i() == true) goto L5;
        return;
    L5:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "开始预加载AnnieCard...");
        long r100 = System.currentTimeMillis();
        boolean r101 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.f77143a;
        String r102 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.d();
        String r113 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.c();
        com.bytedance.live.datacontext.m<IRoom> r103 = o3.j(r111).getRoom();
        if (r103 == null) goto L10;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L10;
        Long r114 = Long.valueOf(r104.getRoomId());
    L11:
        Uri r105 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.j.a(r102, r113, r114, false, 0, r112, 16);
        if (f77177b > 0) goto L15;
        return;
    L15:
        if (d() == false) goto L25;
        if (f77178c != null) goto L23;
        y0 r106 = new y0(r105, null);
        if (na0.f120816a.getValue().booleanValue() == false) goto L21;
        int r107 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.f77142a;
        int r108 = e0.f76917o;
        ih0.c r109 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(e0.a.a(r110), r105, r106, r100, r111, false);
        r106.f77169a = r109;
    L22:
        f77178c = r109;
        e(r109);
        ALogger.i("MultiLinkRenderWidgetReuseManager", "预加载AnnieCard成功！mHybridCard=" + f77178c);
        return;
    L21:
        int r115 = e0.f76917o;
        r109 = a(this, e0.a.a(r110), r111);
        goto L22
    L23:
        ALogger.i("MultiLinkRenderWidgetReuseManager", "已有AnnieCard缓存！无需再预加载，mHybridCard=" + f77178c);
        return;
    L25:
        if (c() == false) goto L27;
        return;
    L27:
        if (na0.f120816a.getValue().booleanValue() == false) goto L29;
        y0 r116 = new y0(r105, null);
        int r117 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.f77142a;
        int r118 = e0.f76917o;
        ih0.c r119 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a(e0.a.a(r110), r105, r116, r100, r111, false);
        r116.f77169a = r119;
    L30:
        e(r119);
        if (f77179d.release(r119) == true) goto L34;
        r119.J();
        r119.release();
        return;
    L34:
        if (j1.f142014a.getValue().getOpenFixV2() == false) goto L41;
        r119.J();
        r119.f1();
        return;
    L41:
        return;
    L29:
        int r120 = e0.f76917o;
        r119 = a(this, e0.a.a(r110), r111);
    L10:
        r114 = null;
        goto L11
    }
}
