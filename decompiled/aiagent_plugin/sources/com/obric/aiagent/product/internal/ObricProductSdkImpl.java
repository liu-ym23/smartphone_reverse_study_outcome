package com.obric.aiagent.product.internal;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.feature.api.IFeatureService;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g;
import d.h.b.h;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: ObricProductSdkImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricProductSdkImpl implements com.obric.aiagent.product.a {
    public static final a Companion = null;
    private static final String TAG = "ObricProductSdkImpl";
    private static final ObricProductSdkImpl instance = null;
    private final AtomicBoolean init;
    private ca loopJob;
    private final am scope;

    /* JADX INFO: compiled from: ObricProductSdkImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final ObricProductSdkImpl a() {
            return ObricProductSdkImpl.access$getInstance$cp();
        }
    }

    public ObricProductSdkImpl() {
        this.scope = an.a(bd.c().plus((g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), g.class, "com.obric.aiagent.plugin")));
        this.init = new AtomicBoolean(false);
    }

    public static final /* synthetic */ ObricProductSdkImpl access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new a(null);
        instance = new ObricProductSdkImpl();
    }

    public final boolean getInitialize() {
        return this.init.get();
    }

    public void init() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.init.get() == false) goto L6;
        ILogDepend.Companion.e(TAG, "product sdk is already init");     // Catch: Throwable -> L10
    L7:
        x r0 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        IFeatureService.Companion.get().init();     // Catch: Throwable -> L10
        IPlatformService.Companion.get().init();     // Catch: Throwable -> L10
        this.init.set(true);     // Catch: Throwable -> L10
        goto L7
    }

    public IPlatformService platformService() {
        return IPlatformService.Companion.get();
    }

    public IFeatureService featureService() {
        return IFeatureService.Companion.get();
    }

    public void destroy() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.init.get() == true) goto L6;
        ILogDepend.Companion.e(TAG, "product sdk is not init");     // Catch: Throwable -> L10
    L7:
        x r0 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        IFeatureService.Companion.get().destroy();     // Catch: Throwable -> L10
        IPlatformService.Companion.get().destroy();     // Catch: Throwable -> L10
        this.init.set(false);     // Catch: Throwable -> L10
        goto L7
    }
}
