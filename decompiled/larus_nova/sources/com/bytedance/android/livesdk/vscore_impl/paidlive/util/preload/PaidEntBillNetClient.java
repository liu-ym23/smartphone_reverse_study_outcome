package com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes11.dex */
public final class PaidEntBillNetClient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f160603c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Object> f160604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.a f160605b;

    public static final class a {
    }

    static {
        f160603c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PaidEntBillNetClient$Companion$instance$2.INSTANCE);
    }

    public PaidEntBillNetClient(com.bytedance.android.livesdk.vscore_impl.paidlive.util.preload.a r100) {
        this.f160605b = r100;
        this.f160604a = new ConcurrentHashMap();
    }
}
