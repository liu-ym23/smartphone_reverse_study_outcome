package com.bytedance.android.shopping.orderlist.common.controller;

import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.list.container.OrderListFragment;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderBottomBarHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f179685i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f179686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f179687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f179688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gg3.b f179689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OrderListFragment f179690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AndroidYaTaInstance f179691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OrderListLinkedScrollView f179692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f179693h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderBottomBarHandler f179694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f179695b;

        public b(OrderBottomBarHandler r100, boolean r101) {
            this.f179694a = r100;
            this.f179695b = r101;
        }

        public final void a() {
            if (this.f179695b == false) goto L5;
            this.f179694a.f179693h.animate().setInterpolator(new LinearInterpolator()).setDuration(250).translationY(-this.f179694a.f179693h.getHeight()).start();
            return;
        L5:
            this.f179694a.f179693h.animate().translationY(0.0f).setDuration(250).setInterpolator(new LinearInterpolator()).start();
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

    static {
    }

    public final void b() {
        if (this.f179687b == true) goto L5;
        return;
    L5:
        AndroidYaTaInstance r100 = this.f179691f;
        gg3.b r101 = null;
        if (r100 == null) goto L8;
        List<com.bytedance.kmp.ec.yata.store.node.c> r102 = r100.q(OrderBottomBarHandler$handleProtocolReload$targetNode$1.INSTANCE);
    L9:
        if (r102 == null) goto L19;
        Iterator<T> r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L19;
        com.bytedance.kmp.ec.yata.store.node.c r104 = (com.bytedance.kmp.ec.yata.store.node.c) r103.next();
        AndroidYaTaInstance r105 = this.f179691f;
        if (r105 == null) goto L12;
        YataEventCenter r106 = r105.k();
        if (r106 == null) goto L12;
        r106.d(com.bytedance.kmp.ec.yata.event.common.e.f251660a.a(this.f179691f, null, r104.getKey(), "showBottomBar", null, "handleProtocolReload"));
    L19:
        if (this.f179689d != null) goto L39;
        AndroidYaTaInstance r107 = this.f179691f;
        if (r107 == null) goto L23;
        Object r108 = r107.i("mall_banner_show_config");
    L25:
        if ((r108 instanceof Map) == true) goto L27;
        r108 = null;
    L27:
        Map r109 = (Map) r108;
        if (r109 == null) goto L30;
        Intrinsics.checkNotNullParameter(r109, "$this$toBarShowConfig");
        r101 = new gg3.b(com.bytedance.android.shopping.extensions.k.r(String.valueOf(r109.get("not_click_times_for_shield")), 3), com.bytedance.android.shopping.extensions.k.r(String.valueOf(r109.get("shield_num_of_days")), 604800), com.bytedance.android.shopping.extensions.k.r(String.valueOf(r109.get("top_residence_size")), 500), com.bytedance.android.shopping.extensions.k.r(String.valueOf(r109.get("top_residence_time")), 3));
    L30:
        this.f179689d = r101;
        return;
    L23:
        r108 = null;
        goto L25
    L39:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void c() {
        OrderCommonErrorMonitorKt.c(this.f179690e.Y90().getTracker(), "OrderBottomBarController-init", new OrderBottomBarHandler$init$1(this));
    }

    public final void a(boolean r100) {
        this.f179693h.post(new b(this, r100));
    }

    public OrderBottomBarHandler(OrderListFragment r100, AndroidYaTaInstance r101, OrderListLinkedScrollView r102, LinearLayout r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "listLinkedScrollView");
        Intrinsics.checkNotNullParameter(r103, "barContainer");
        this.f179690e = r100;
        this.f179691f = r101;
        this.f179692g = r102;
        this.f179693h = r103;
        this.f179688c = true;
    }
}
