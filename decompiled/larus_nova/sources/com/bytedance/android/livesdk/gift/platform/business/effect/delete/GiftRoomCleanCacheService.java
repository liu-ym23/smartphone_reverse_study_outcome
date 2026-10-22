package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.push.LivePushInfo;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftRoomCleanCacheService implements dy0.d, com.bytedance.android.scope.o, yz0.m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f129205i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.business.effect.delete.b f129206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LivePushInfo.d f129207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<LivePushInfo.f, Unit> f129208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f129209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f129210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f129211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final yz0.k f129212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.room.c f129213h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftRoomCleanCacheService f129214a;

        public b(GiftRoomCleanCacheService r100) {
            this.f129214a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Long r111 = (Long) r110;
            GiftRoomCleanCacheService r112 = this.f129214a;
            r112.getClass();
            LinkedList r100 = null;
            LinkedList r101 = (LinkedList) ay1.b.f16726z0.getValue(null, ay1.b.f16675a[92]);
            Iterator r102 = r101.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            if ((System.currentTimeMillis() - (com.bytedance.android.livesdk.gift.platform.business.i.d().T8() * 1000)) <= ((Number) r102.next()).longValue()) goto L8;
            r102.remove();
        L8:
            r101.size();
            boolean r103 = true;
            if ((!r101.isEmpty()) == false) goto L11;
            r100 = r101;
        L11:
            if (r100 == null) goto L14;
            Long r104 = (Long) r100.getFirst();
        L14:
            if (r101.size() >= com.bytedance.android.livesdk.gift.platform.business.i.d().H5()) goto L16;
            boolean r105 = true;
        L17:
            if (r105 == true) goto L19;
            return;
        L19:
            if (((Integer) r112.f129213h.getDataCenter().get("data_member_count", 0)).intValue() > com.bytedance.android.livesdk.gift.platform.business.i.d().Q4()) goto L21;
            boolean r106 = true;
        L22:
            if (r106 == true) goto L24;
            return;
        L24:
            if (r112.f129211f.a() > com.bytedance.android.livesdk.gift.platform.business.i.d().d4()) goto L27;
            r103 = false;
        L27:
            if (r103 == false) goto L35;
            RxUtilKt.c(Single.create(d.f129281a).toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r112)), r112.f129210e);
            return;
        L35:
            return;
        L21:
            r106 = false;
            goto L22
        L16:
            r105 = false;
            goto L17
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    public final void c() {
        com.bytedance.android.livesdk.gift.platform.business.effect.delete.b r100 = this.f129206a;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L21:
        this.f129206a = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f129210e.clear();
        c();
        LivePushInfo.d r100 = this.f129207b;
        if (r100 == null) goto L5;
        r100.dismiss();
    L5:
        Iterator r101 = ((ArrayList) this.f129211f.f129273a).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.gift.platform.business.effect.delete.a) r101.next()).e(CleanOpportunity.MANUAL_CLEAN_IN_ROOM);
        goto L7
    L9:
        ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).g(1);
    }

    @Override // yz0.m
    public final void i() {
        if (com.bytedance.android.livesdk.gift.platform.business.i.d().getEnable() == true) goto L6;
        return;
    L6:
        if (this.f129212g.isAnchor() == false) goto L8;
        return;
    L8:
        RxUtilKt.c(Observable.timer(com.bytedance.android.livesdk.gift.platform.business.i.d().Q8(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this)), this.f129210e);
    }

    public GiftRoomCleanCacheService(c r100, yz0.k r101, com.bytedance.android.livesdk.revenue.service.room.c r102) {
        Intrinsics.checkNotNullParameter(r100, "cleanGlobalManagerService");
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "revRoomService");
        this.f129211f = r100;
        this.f129212g = r101;
        this.f129213h = r102;
        this.f129208c = new GiftRoomCleanCacheService$reportAction$1(this);
        this.f129210e = new CompositeDisposable();
    }

    public static final void a(GiftRoomCleanCacheService r100, com.bytedance.android.live.base.model.push.b r101, String r102, Map r103) {
        r100.getClass();
        HashMap r104 = new HashMap();
        String r105 = r101.getScene();
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r104.put("business_scene", r105);
        r104.put("action_type", r102);
        r104.put("content", String.valueOf(r101.getContent()));
        r104.put("push_reason", "cache_optimize");
        r104.putAll(r103);
        mz0.n r106 = new mz0.n();
        Map<String, String> r107 = r106.f516447a;
        Intrinsics.checkNotNullParameter(r107, "map");
        Intrinsics.checkNotNullParameter(r104, "map");
        r107.putAll(r104);
        mz0.m r108 = new mz0.m();
        r108.b(LogCommon.ROOM);
        r108.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r109 = r106.f516448b;
        ArrayList r110 = (ArrayList) r109;
        r110.addAll(r108.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r111 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("livesdk_live_common_inner_push", r106.f516447a, r106.f516448b);
    }
}
