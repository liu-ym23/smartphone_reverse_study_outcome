package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b0<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f38567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallContext f38568b;

    public b0(e0 r100, CallContext r101) {
        this.f38567a = r100;
        this.f38568b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<GetDeviceStatsResultModel> r110) {
        Intrinsics.checkNotNullParameter(r110, "emitter");
        GetDeviceStatsResultModel r100 = new GetDeviceStatsResultModel();
        r100.c(new GetDeviceStatsResultModel.a());
        if (Intrinsics.areEqual(this.f38567a.b(), Boolean.TRUE) == false) goto L31;
        GetDeviceStatsResultModel.a r101 = r100.a();
        if (r101 == null) goto L31;
        int r102 = com.bytedance.android.annie.util.n.f40069c;
        long r103 = System.currentTimeMillis();
        if ((r103 - com.bytedance.android.annie.util.n.f40067a) >= 360) goto L10;
        double r104 = com.bytedance.android.annie.util.n.f40068b;
    L30:
        r101.b(Double.valueOf(r104));
        goto L31
    L10:
        com.bytedance.android.annie.util.n.f40067a = r103;
        long r105 = com.bytedance.android.annie.util.n.b();
        if (r105 == (-1)) goto L29;
        long r106 = com.bytedance.android.annie.util.n.c();
        if (r106 == (-1)) goto L29;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L18
        Thread.sleep(360);     // Catch: Throwable -> L18
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        long r107 = com.bytedance.android.annie.util.n.b();
        if (r107 == (-1)) goto L29;
        long r112 = com.bytedance.android.annie.util.n.c();
        if (r112 == (-1)) goto L29;
        long r113 = r112 - r106;
        if (r113 <= 0) goto L29;
        r104 = (r107 - r105) / r113;
        com.bytedance.android.annie.util.n.f40068b = r104;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L29:
        r104 = -1.0d;
    L31:
        Boolean r109 = this.f38567a.d();
        Boolean r114 = Boolean.TRUE;
        if (Intrinsics.areEqual(r109, r114) == false) goto L38;
        GetDeviceStatsResultModel.a r115 = r100.a();
        if (r115 == null) goto L38;
        r115.d(Double.valueOf(y8.a.f566652a.d(this.f38568b.getContext())));
    L38:
        if (Intrinsics.areEqual(this.f38567a.e(), r114) == false) goto L44;
        GetDeviceStatsResultModel.a r116 = r100.a();
        if (r116 == null) goto L44;
        r116.e(Float.valueOf(y8.a.f566652a.a(this.f38568b.getContext())));
    L44:
        if (Intrinsics.areEqual(this.f38567a.a(), r114) == false) goto L71;
        GetDeviceStatsResultModel.a r117 = r100.a();
        if (r117 == null) goto L71;
        y8.a r118 = y8.a.f566652a;
        Context r119 = this.f38568b.getContext();
        monitor-enter(r118);
        long r120 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L67
        Map<String, Pair<Long, Object>> r121 = y8.a.f566653b;     // Catch: Throwable -> L67
        if (r121.containsKey("battery_level") == false) goto L57;
        Object r122 = ((LinkedHashMap) r121).get("battery_level");     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r122);     // Catch: Throwable -> L67
        if ((r120 - ((Number) ((Pair) r122).getFirst()).longValue()) >= 5000) goto L57;
        Object r123 = ((LinkedHashMap) r121).get("battery_level");     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r123);     // Catch: Throwable -> L67
        Object r124 = ((Pair) r123).getSecond();     // Catch: Throwable -> L67
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L67
        int r125 = ((Integer) r124).intValue();     // Catch: Throwable -> L67
        monitor-exit(r118);
    L66:
        r117.a(Integer.valueOf(r125));
    L57:
        int r126 = com.bytedance.android.annie.util.n.f40069c;     // Catch: Throwable -> L67
        if (r119 == null) goto L63;
        Intent r127 = com.bytedance.android.annie.util.n.a(r119, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L67
        if (r127 == null) goto L63;
        r125 = r127.getIntExtra("level", -1);     // Catch: Throwable -> L67
    L64:
        r121.put("battery_level", new Pair(Long.valueOf(r120), Integer.valueOf(r125)));     // Catch: Throwable -> L67
        monitor-exit(r118);
    L63:
        r125 = -1;
    L67:
        th = move-exception;
        throw th;
    L71:
        if (Intrinsics.areEqual(this.f38567a.c(), r114) == false) goto L76;
        GetDeviceStatsResultModel.a r128 = r100.a();
        if (r128 == null) goto L76;
        y8.a r129 = y8.a.f566652a;
        r128.c(Float.valueOf(y8.a.c()));
    L76:
        r110.onNext(r100);
        r110.onComplete();
    }
}
