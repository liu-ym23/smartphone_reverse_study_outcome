package com.bytedanceos.appstore.buss.network;

import com.bytedanceos.appstore.buss.network.base.BaseHttpEngine;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes2.dex */
public final class AppHttpEngine extends BaseHttpEngine {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppHttpEngine f8769b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f8770c = null;

    static {
        f8769b = new AppHttpEngine();
        f8770c = kotlin.b.b(AppHttpEngine$service$2.INSTANCE);
    }

    public AppHttpEngine() {
    }

    public static final /* synthetic */ Object e(AppHttpEngine r10, Class r11, String r12) {
        return r10.c(r11, r12);
    }

    @Override // com.bytedanceos.appstore.buss.network.base.BaseHttpEngine
    public void d(OkHttpClient.Builder r10) {
        q.g(r10, "builder");
        super.d(r10);
        r10.a(new q7.c());
        r10.a(new q7.d());
    }

    public final StoreService f() {
        return (StoreService) f8770c.getValue();
    }
}
