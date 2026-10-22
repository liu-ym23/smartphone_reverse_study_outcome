package com.bytedance.android.ec.hybrid.card.util;

import com.bytedance.android.ec.hybrid.monitor.ECHybridMonitorUtil$monitorEvent$1;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f46602a = 0;

    static {
    }

    public static void a(final String r100, final JSONObject r101, final JSONObject r102, final JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        boolean r104 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Single.fromCallable(new ECHybridMonitorUtil$monitorEvent$1(r100, r101, r102, r103)).subscribeOn(Schedulers.io()).subscribe();
        Lazy r105 = ECHybridLogger.f46584a;
        ECHybridLogger.a("monitorEvent, name: " + r100 + ", category: " + r101 + ", metric: " + r102);
    }
}
