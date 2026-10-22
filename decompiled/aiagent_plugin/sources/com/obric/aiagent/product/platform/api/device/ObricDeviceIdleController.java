package com.obric.aiagent.product.platform.api.device;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.platform.impl.a.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ObricDeviceIdleController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObricDeviceIdleController {
    public static final Companion Companion = null;
    private static final String TAG = "ObricDeviceIdleController";
    private static IObricDeviceIdleController instance;

    /* JADX INFO: compiled from: ObricDeviceIdleController.kt */
    public static final class Companion implements IObricDeviceIdleController {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }

        @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
        public boolean addToTemporaryAllowList(String[] r1, long r2, String r4) {
            o.e(r1, "pkgList");
            o.e(r4, "reason");
            IObricDeviceIdleController r0 = ObricDeviceIdleController.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.addToTemporaryAllowList(r1, r2, r4);
        }

        @Override // com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController
        public boolean removeFromTemporaryAllowList(String[] r1, String r2) {
            o.e(r1, "pkgList");
            o.e(r2, "reason");
            IObricDeviceIdleController r0 = ObricDeviceIdleController.access$getInstance$cp();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.removeFromTemporaryAllowList(r1, r2);
        }
    }

    public static /* synthetic */ Object lambda$fHaiA36mpl3mYMep5T4FrGqexNw() {
        return _init_$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$vG-PYSmvoNluEGaF7pjjawslnxc, reason: not valid java name */
    public static /* synthetic */ Object m209lambda$vGPYSmvoNluEGaF7pjjawslnxc() {
        return _init_$lambda$1();
    }

    public ObricDeviceIdleController() {
    }

    public static final /* synthetic */ IObricDeviceIdleController access$getInstance$cp() {
        return instance;
    }

    static {
        Companion = new Companion(null);
    L8:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "bind DeviceIdleController failed", th);
    L10:
        instance = (IObricDeviceIdleController) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IObricDeviceIdleController.class, false), IObricDeviceIdleController.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "ObricDeviceIdleController instance: " + instance);
        return;
    L4:
        if (b.f18770a.a() == false) goto L6;
        ServiceManager.get().bind(IObricDeviceIdleController.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricDeviceIdleController$fHaiA36mpl3mYMep5T4FrGqexNw.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
    L12:
        goto L10
    L6:
        ServiceManager.get().bind(IObricDeviceIdleController.class, (ServiceProvider) ZeusTransformUtils.preCheckCast(new SingletonProvider($$Lambda$ObricDeviceIdleController$vGPYSmvoNluEGaF7pjjawslnxc.INSTANCE), ServiceProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        goto L12
    }

    private static final Object _init_$lambda$0() {
        return new a();
    }

    private static final Object _init_$lambda$1() {
        return new com.obric.aiagent.product.platform.impl.a.b();
    }
}
