package com.bytedance.android.live.revenue.platform.network.impl;

import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class MiddlewareConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<? extends MiddlewarePriority, Boolean> f91532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.network.d f91533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.revenue.network.a> f91534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.revenue.network.a> f91535d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/impl/MiddlewareConverter$MiddlewarePriority;", "", "Self", "Platform", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum MiddlewarePriority extends Enum<MiddlewarePriority> {
        public static final MiddlewarePriority Platform = null;
        public static final MiddlewarePriority Self = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MiddlewarePriority[] f91536a = null;

        static {
            MiddlewarePriority r100 = new MiddlewarePriority("Self", 0);
            Self = r100;
            MiddlewarePriority r101 = new MiddlewarePriority("Platform", 1);
            Platform = r101;
            f91536a = new MiddlewarePriority[]{r100, r101};
        }

        public static MiddlewarePriority valueOf(String r100) {
            return (MiddlewarePriority) r27.a.a(MiddlewarePriority.class, r100);
        }

        public static MiddlewarePriority[] values() {
            return (MiddlewarePriority[]) f91536a.clone();
        }

        public MiddlewarePriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MiddlewareConverter(List<? extends com.bytedance.android.livesdk.revenue.network.a> r110, List<? extends com.bytedance.android.livesdk.revenue.network.a> r111, com.bytedance.android.livesdk.revenue.network.d r112) {
        Intrinsics.checkNotNullParameter(r110, "selfMiddlewareList");
        Intrinsics.checkNotNullParameter(r111, "platformMiddleWareList");
        Intrinsics.checkNotNullParameter(r112, "originRequest");
        this.f91534c = r110;
        this.f91535d = r111;
        String r100 = r112.f157204a;
        Unit r101 = Unit.INSTANCE;
        Iterator r113 = r111.iterator();
    L3:
        Boolean r102 = null;
        if (r113.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.revenue.network.a r103 = (com.bytedance.android.livesdk.revenue.network.a) r113.next();
        MiddlewarePriority r104 = MiddlewarePriority.Platform;
        if (r103.h() == null) goto L23;
        Pair<? extends MiddlewarePriority, Boolean> r105 = this.f91532a;
        if (r105 == null) goto L10;
        MiddlewarePriority r106 = r105.getFirst();
    L11:
        if (r106 != r104) goto L20;
        Pair<? extends MiddlewarePriority, Boolean> r107 = this.f91532a;
        if (r107 == null) goto L16;
        r102 = r107.getSecond();
    L16:
        if ((true ^ Intrinsics.areEqual(r102, r103.h())) == false) goto L20;
        throw new IllegalStateException("same priority middleware has more than one [enablePB] values".toString());
    L20:
        Boolean r108 = r103.h();
        if (r108 == null) goto L23;
        this.f91532a = TuplesKt.to(r104, Boolean.valueOf(r108.booleanValue()));
        goto L23
    L10:
        r106 = null;
    L23:
        Unit r109 = Unit.INSTANCE;
        goto L3
    L24:
        Iterator r114 = r110.iterator();
    L26:
        if (r114.hasNext() == false) goto L47;
        com.bytedance.android.livesdk.revenue.network.a r115 = (com.bytedance.android.livesdk.revenue.network.a) r114.next();
        MiddlewarePriority r116 = MiddlewarePriority.Self;
        if (r115.h() == null) goto L46;
        Pair<? extends MiddlewarePriority, Boolean> r117 = this.f91532a;
        if (r117 == null) goto L32;
        MiddlewarePriority r118 = r117.getFirst();
    L33:
        if (r118 != r116) goto L43;
        Pair<? extends MiddlewarePriority, Boolean> r119 = this.f91532a;
        if (r119 == null) goto L37;
        Boolean r120 = r119.getSecond();
    L39:
        if ((!Intrinsics.areEqual(r120, r115.h())) == false) goto L43;
        throw new IllegalStateException("same priority middleware has more than one [enablePB] values".toString());
    L37:
        r120 = null;
    L43:
        Boolean r121 = r115.h();
        if (r121 == null) goto L46;
        this.f91532a = TuplesKt.to(r116, Boolean.valueOf(r121.booleanValue()));
        goto L46
    L32:
        r118 = null;
    L46:
        Unit r122 = Unit.INSTANCE;
        goto L26
    L47:
        List<com.bytedance.android.livesdk.revenue.network.a> r123 = this.f91534c;
        Iterator<T> r124 = this.f91535d.iterator();
        com.bytedance.android.livesdk.revenue.network.d r125 = r112;
    L49:
        if (r124.hasNext() == false) goto L51;
        com.bytedance.android.livesdk.revenue.network.a r126 = (com.bytedance.android.livesdk.revenue.network.a) r124.next();
        MiddlewarePriority r127 = MiddlewarePriority.Self;
        r100 = r126.g(r100, r112.f157204a);
        r125 = r126.x(r100, r112);
        goto L49
    L51:
        Iterator<T> r128 = r123.iterator();
        String r129 = r100;
    L53:
        if (r128.hasNext() == false) goto L55;
        com.bytedance.android.livesdk.revenue.network.a r130 = (com.bytedance.android.livesdk.revenue.network.a) r128.next();
        MiddlewarePriority r131 = MiddlewarePriority.Self;
        r129 = r130.g(r129, r112.f157204a);
        r125 = r130.x(r129, r112);
        goto L53
    L55:
        Map r132 = MapsKt.toMutableMap(r125.f157205b);
        Map<String, String> r133 = r125.f157206c;
        Map<String, String> r134 = r125.f157207d;
        JsonObject r135 = r125.f157210g;
        Pair<? extends MiddlewarePriority, Boolean> r136 = this.f91532a;
        if (r136 != null) goto L58;
    L60:
        this.f91533b = new com.bytedance.android.livesdk.revenue.network.d(r129, r132, r133, r134, r112.f157208e, r112.f157209f, r135);
        if (r112.f157210g != null) goto L63;
        return;
    L63:
        if ((!r112.f157207d.isEmpty()) == true) goto L66;
        return;
    L66:
        throw new IllegalArgumentException("cannot add field when contentType is application/json");
    L58:
        if (r136.getSecond().booleanValue() != true) goto L60;
        r132.put("response-format", "protobuf");
        goto L60
    }
}
