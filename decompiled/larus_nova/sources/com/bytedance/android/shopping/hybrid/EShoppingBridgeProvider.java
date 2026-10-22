package com.bytedance.android.shopping.hybrid;

import com.bytedance.android.ec.core.hybrid.ECBridgeProviderInjector;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import g33.e;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import ti.i;

/* JADX INFO: loaded from: classes13.dex */
public final class EShoppingBridgeProvider implements i, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EShoppingBridgeProvider f176198a = null;

    public EShoppingBridgeProvider() {
    }

    static {
        f176198a = new EShoppingBridgeProvider();
    }

    @Override // g33.e
    public final void a() {
        Lazy r100 = ECBridgeProviderInjector.f44104b;
        ((CopyOnWriteArrayList) ECBridgeProviderInjector.a.a().f44105a).add(this);
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
