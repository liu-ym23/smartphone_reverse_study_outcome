package com.bytedance.android.livesdk.livecommerce.hybrid;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.List;
import kotlin.jvm.functions.Function0;
import ti.i;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveCommerceBridgeProvider implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveCommerceBridgeProvider f147816a = null;

    public LiveCommerceBridgeProvider() {
    }

    static {
        f147816a = new LiveCommerceBridgeProvider();
    }

    @Override // ti.i
    public final Function0<List<ECBaseBridgeMethod>> b() {
        return LiveCommerceBridgeProvider$getHostBridgeProvider$1.INSTANCE;
    }

    @Override // ti.i
    public final Function0<List<ECBaseBridgeMethod>> c() {
        return LiveCommerceBridgeProvider$getLiveBridgeProvider$1.INSTANCE;
    }
}
