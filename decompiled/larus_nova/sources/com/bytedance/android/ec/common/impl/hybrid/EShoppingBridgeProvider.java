package com.bytedance.android.ec.common.impl.hybrid;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import java.util.List;
import kotlin.jvm.functions.Function0;
import ti.i;

/* JADX INFO: loaded from: classes43.dex */
public final class EShoppingBridgeProvider implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EShoppingBridgeProvider f42897a = null;

    public EShoppingBridgeProvider() {
    }

    static {
        f42897a = new EShoppingBridgeProvider();
    }

    @Override // ti.i
    public final Function0<List<ECBaseBridgeMethod>> b() {
        return EShoppingBridgeProvider$getHostBridgeProvider$1.INSTANCE;
    }

    @Override // ti.i
    public final Function0<List<ECBaseBridgeMethod>> c() {
        return EShoppingBridgeProvider$getLiveBridgeProvider$1.INSTANCE;
    }
}
