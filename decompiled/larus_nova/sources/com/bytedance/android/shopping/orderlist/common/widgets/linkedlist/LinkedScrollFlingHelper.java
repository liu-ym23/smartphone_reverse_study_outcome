package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import android.content.Context;
import android.view.VelocityTracker;
import android.widget.Scroller;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class LinkedScrollFlingHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scroller f180041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VelocityTracker f180042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f180043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BaseLinkedScrollView f180044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, Unit> f180045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f180046f;

    public final void a() {
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.a("LinkedScrollFlingHelper", LinkedScrollFlingHelper$stopFling$1.INSTANCE);
        this.f180041a.forceFinished(true);
        this.f180046f.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkedScrollFlingHelper(Context r100, BaseLinkedScrollView r101, Function1<? super Integer, Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "scrollYDispatcher");
        Intrinsics.checkNotNullParameter(r103, "stopScrollCallback");
        this.f180044d = r101;
        this.f180045e = r102;
        this.f180046f = r103;
        this.f180041a = new Scroller(r100);
        this.f180042b = VelocityTracker.obtain();
    }
}
