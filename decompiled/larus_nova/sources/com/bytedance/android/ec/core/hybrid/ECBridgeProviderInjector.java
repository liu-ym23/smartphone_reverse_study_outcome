package com.bytedance.android.ec.core.hybrid;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import ti.h;
import ti.i;

/* JADX INFO: loaded from: classes43.dex */
public final class ECBridgeProviderInjector implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f44104b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<i> f44105a;

    public static final class a {
        public static ECBridgeProviderInjector a() {
            return (ECBridgeProviderInjector) ECBridgeProviderInjector.f44104b.getValue();
        }
    }

    static {
        f44104b = LazyKt.lazy(ECBridgeProviderInjector$Companion$INSTANCE$2.INSTANCE);
    }

    public ECBridgeProviderInjector() {
        this.f44105a = new CopyOnWriteArrayList();
    }
}
