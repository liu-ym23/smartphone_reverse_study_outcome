package com.bytedance.android.live.effect.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.base.RenderTriggerType;
import com.bytedance.android.livesdk.config.pb;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveEffectMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PthreadHandlerThreadV2 f68860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f68861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f68862c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveEffectMonitor$monitorRenderEffect$1 f68863a;

        public a(LiveEffectMonitor$monitorRenderEffect$1 r100) {
            this.f68863a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f68863a.invoke2();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public LiveEffectMonitor() {
    }

    public static void h() {
        Intrinsics.checkNotNullParameter("", "extra");
        NewBroadcastMonitor.a r100 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.TTLIVE_ANCHOR_PREFIX_GET_LINK_OBJ_STICKERS, null, null, 14);
        r100.l(-1);
        r100.i("origin_extra", "");
        r100.a().report();
    }

    static {
    }

    public static void a(boolean r100) {
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_BEAUTY_EFFECT_STATUS, null, null, 14);
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        r101.c(r102);
        r101.a().report();
        return;
    L5:
        r102 = "0";
        goto L6
    }

    public static void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_RENDER_EFFECT, null, null, 14);
        r101.i("mutex_type", r100);
        r101.a().report();
    }

    public static void k(boolean r100) {
        NewBroadcastMonitor.a r101 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_NO_BEAUTIFY_STATUS, null, null, 14);
        if (r100 == false) goto L5;
        String r102 = "1";
    L6:
        r101.c(r102);
        r101.a().report();
        return;
    L5:
        r102 = "0";
        goto L6
    }

    @JvmStatic
    public static final void f(String r100, List<EffectCategoryModel> r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "categoryList");
        List<EffectCategoryModel> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(((EffectCategoryModel) r104.next()).getKey());
        goto L4
    L6:
        NewBroadcastMonitor.a r105 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_PANEL, null, null, 14);
        r105.l(0);
        r105.c(r100);
        r105.i(LocationMonitorConst.ERR_MSG, r103);
        r105.a().report();
    }

    public static void g(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_GET_CAMPAIGN_STICKER, null, null, 14);
        r102.l(r101);
        r102.c(r100);
        r102.a().report();
    }

    public static void l(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_GET_RECOMMEND_STICKER, null, null, 14);
        r102.l(r100);
        r102.i("origin_extra", r101);
        r102.a().report();
    }

    @JvmStatic
    public static final void d(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        NewBroadcastMonitor.a r103 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST, null, null, 14);
        r103.l(r101);
        r103.c(r100);
        r103.i(LocationMonitorConst.ERR_MSG, r102);
        r103.a().report();
    }

    @JvmStatic
    public static final void e(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        NewBroadcastMonitor.a r103 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_PANEL, null, null, 14);
        r103.l(r101);
        r103.c(r100);
        r103.i(LocationMonitorConst.ERR_MSG, r102);
        r103.a().report();
    }

    @JvmStatic
    public static final void b(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "category");
        NewBroadcastMonitor.a r104 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST_BY_CATEGORY, null, null, 14);
        r104.l(r102);
        r104.c(r100);
        r104.d(r101);
        r104.i(LocationMonitorConst.ERR_MSG, r103);
        r104.a().report();
    }

    @JvmStatic
    public static final void c(String r100, String r101, List<? extends Effect> r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r102, "effectList");
        NewBroadcastMonitor.a r104 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST_BY_CATEGORY, null, null, 14);
        r104.l(0);
        r104.c(r100);
        r104.d(r101);
        r104.g("duration", r103);
        r104.a().report();
    }

    public static void i(boolean r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "effectID");
        Intrinsics.checkNotNullParameter(r103, "failReason");
        NewBroadcastMonitor.a r104 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_ANCHOR_GIFT_MENU_STICKER_RENDER, null, null, 14);
        if (r102 == false) goto L5;
        int r105 = 0;
    L6:
        r104.l(r105);
        if (r100 == false) goto L9;
        String r106 = "add";
    L10:
        r104.c(r106);
        r104.i(MobConstants.EFFECT_ID, r101);
        r104.i("fail_reason", r103);
        r104.a().report();
        return;
    L9:
        r106 = "remove";
        goto L10
    L5:
        r105 = -1;
        goto L6
    }

    public static /* synthetic */ void n(String r100, String r110, int r111, String r112, String r113, String r114, String r115, String r116) {
        m(r100, r110, r111, r112, r113, r114, r115, r116, null);
    }

    public static void m(String r110, String r111, int r112, String r113, String r114, String r115, String r116, String r117, RenderTriggerType r118) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r113, "curList");
        Intrinsics.checkNotNullParameter(r114, "addList");
        Intrinsics.checkNotNullParameter(r115, "removeList");
        Intrinsics.checkNotNullParameter(r116, "endType");
        Intrinsics.checkNotNullParameter(r117, "extraLog");
        LiveEffectMonitor$monitorRenderEffect$1 r100 = new LiveEffectMonitor$monitorRenderEffect$1(r112, r110, r111, r113, r114, r115, r116, r117, r118);
        if ((!pb.f120965a.getValue().booleanValue()) == true) goto L5;
        r100.invoke2();
        return;
    L5:
        if (f68862c == true) goto L13;
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("LiveEffectMonitor");
        f68860a = r101;
        ThreadMethodProxy.start(r101);
        PthreadHandlerThreadV2 r102 = f68860a;
        if (r102 == null) goto L12;
        Looper r103 = r102.getLooper();
        if (r103 == null) goto L12;
        f68861b = new Handler(r103);
    L12:
        f68862c = true;
    L13:
        Handler r104 = f68861b;
        if (r104 == null) goto L18;
        r104.post(new a(r100));
        return;
    }
}
