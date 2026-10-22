package com.bytedance.android.live.revenue.platform.container.impl.core;

import android.content.Context;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class NativeHostServiceImpl extends com.bytedance.android.live.revenue.platform.container.impl.core.a implements f80.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f91175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vy0.c f91176e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f91177a = null;

        public a() {
        }

        static {
            f91177a = new a();
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (v.a() == true) goto L6;
        com.bytedance.platform.aio.b.a r100 = com.bytedance.platform.aio.b.f266552a;
        oy0.a r101 = oy0.a.f527122b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        com.bytedance.platform.aio.b.a.f266553a = r101;
        return;
    }

    public NativeHostServiceImpl(vy0.c r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridService");
        Intrinsics.checkNotNullParameter(r101, "centerDriverService");
        super(r101);
        this.f91176e = r100;
        this.f91175d = LazyKt.lazy(NativeHostServiceImpl$shareViewService$2.INSTANCE);
    }

    public final l b0(Context r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        l r102 = this.f91181b;
        if (r102 != null) goto L18;
        vy0.c r103 = this.f91176e;
        int r104 = com.bytedance.revenue.platform.api.core.e.f267507a;
        ReadOnlyProperty r105 = b.f91185c;
        KProperty<?>[] r106 = b.f91183a;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r107 = r103.q8(r100, com.bytedance.revenue.platform.api.core.e.a((String) r105.getValue(null, r106[1])).buildUpon().appendQueryParameter("revenue_service_urls", GsonProtectorUtils.toJson(l97.a.f508113a, (List) b.f91186d.getValue(null, r106[2]))).build(), new NativeHostServiceImpl$createAnnieXCard$center$1(this, r101));
        if (r107 == null) goto L17;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r108 = r107.f91467d;
        Iterator<T> r109 = ((com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a) this.f91175d.getValue()).getMethods().iterator();
    L8:
        if (r109.hasNext() == false) goto L15;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e r110 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e) r109.next();
        if ((r110 instanceof com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a) == true) goto L11;
        if ((r110 instanceof com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b) == false) goto L8;
        String r111 = r110.f91403a;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b r112 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b) r110;
        r108.registerMethod(r111, null);
        goto L8
    L11:
        r108.registerMethod(r110.f91403a, ((com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a) r110).f91404b);
        goto L8
    L15:
        ReadOnlyProperty r113 = k.f91206c;
        KProperty<?>[] r114 = k.f91204a;
        r108.b(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("live_service_center_reuse", Boolean.valueOf(k.a())), TuplesKt.to("live_service_center_aiolink_async", Boolean.valueOf(((Boolean) r113.getValue(null, r114[1])).booleanValue())), TuplesKt.to("live_redpacket_service_lazy_load", Boolean.valueOf(((Boolean) k.f91207d.getValue(null, r114[2])).booleanValue()))}));
        g r115 = this.f91182c;
        RevenueJsDriver r116 = r107.f91474b;
        Intrinsics.checkNotNull(r116);
        r115.L0(r116);
        l r117 = new l(r107.f91474b, r107);
        this.f91181b = r117;
        return r117;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.hybrid.impl.ui.AnnieXCardImpl");
    L18:
        return r102;
    }

    public final void w0(h r100, com.bytedance.android.scope.j r101) {
        Intrinsics.checkNotNullParameter(r100, "centerServiceManager");
        Intrinsics.checkNotNullParameter(r101, "scope");
        this.f91180a.put(r101, r100);
        if (k.a() == true) goto L8;
        zy0.b r102 = r100.D();
        if (r102 == null) goto L9;
        this.f91181b = new l(r100.c(), r102);
        return;
    L9:
        return;
    }
}
