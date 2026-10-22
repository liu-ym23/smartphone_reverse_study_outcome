package com.bytedance.android.shopping.anchorv4.perf.helper;

import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.utils.b2;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpNetworkWarmup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f167190a = null;

    static {
        f167190a = LazyKt.lazy(PdpNetworkWarmup$hasWarmup$2.INSTANCE);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        if (PdpPerfOpt.b().m(8) == false) goto L5;
    L6:
        PdpPerfOpt.i("call PdpNetworkWarmup from=".concat(r100));
        if (PdpPerfOpt.b().m(16) == true) goto L9;
        b2.b(PdpNetworkWarmup$preConnectUrl$1.INSTANCE);
        return;
    L9:
        if (((AtomicBoolean) f167190a.getValue()).compareAndSet(false, true) == false) goto L14;
        b2.b(PdpNetworkWarmup$preConnectUrl$1.INSTANCE);
        return;
    L14:
        return;
    L5:
        if (PdpPerfOpt.b().m(16) == true) goto L6;
    }
}
