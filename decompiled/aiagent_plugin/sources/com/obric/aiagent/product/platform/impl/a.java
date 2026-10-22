package com.obric.aiagent.product.platform.impl;

import android.app.Application;
import android.content.Context;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController;
import com.obric.aiagent.product.platform.api.device.ObricDeviceIdleController;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryManager;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.notification.ObricNotificationManager;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager;
import com.obric.aiagent.product.platform.api.sleepmode.ObricSleepModeManager;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import com.obric.aiagent.product.platform.api.vibratefeedback.VibrateFeedback;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.aiagent.product.platform.api.view.ObricWindowManager;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.obric.aiagent.product.platform.api.windoweffects.WindowEffects;
import com.obric.framework.inputmethod.api.IObricInputmethodManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PlatformServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IPlatformService {
    private static final String TAG = "PlatformServiceImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0398a f18799a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f<a> f18800c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f18801b;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlatformServiceImpl.kt */
    public static final class C0398a {
        public /* synthetic */ C0398a(h r1) {
            this();
        }

        private C0398a() {
        }

        private final a b() {
            return (a) ZeusTransformUtils.preCheckCast(a.a().b(), a.class, "com.obric.aiagent.plugin");
        }

        public final synchronized IPlatformService a() {
            monitor-enter(this);
            IPlatformService r0 = (IPlatformService) ZeusTransformUtils.preCheckCast(b(), IPlatformService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ Context lambda$Bm2ZMTDqxah9UlXeIJagYHy4rJw() {
        return b();
    }

    public static /* synthetic */ a lambda$xa2f4dcgY83Y2qMCKt846ba8QGM() {
        return c();
    }

    public a() {
        this.f18801b = g.a($$Lambda$a$Bm2ZMTDqxah9UlXeIJagYHy4rJw.INSTANCE);
    }

    public static final /* synthetic */ f a() {
        return f18800c;
    }

    static {
        f18799a = new C0398a(null);
        f18800c = g.a($$Lambda$a$xa2f4dcgY83Y2qMCKt846ba8QGM.INSTANCE);
    }

    private static final a c() {
        return new a();
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.f18801b.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private static final Context b() {
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L13;
        Object r1 = IAIAgentPlatform.Companion.getCommonParams("base");
        o.a(r1, "null cannot be cast to non-null type android.content.Context");
        return (Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.aiagent.plugin");
    L13:
        return (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin");
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public void init() {
        ILogDepend.Companion.i(TAG, "init");
        RomInfo.INSTANCE.tryInit();
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public void destroy() {
        ILogDepend.Companion.i(TAG, "destroy");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IRomInfo romInfo() {
        return (IRomInfo) ZeusTransformUtils.preCheckCast(RomInfo.INSTANCE, IRomInfo.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricActivityManager activityManager() {
        return (IObricActivityManager) ZeusTransformUtils.preCheckCast(ObricActivityManager.Companion, IObricActivityManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricActivityTaskManager activityTaskManager() {
        return (IObricActivityTaskManager) ZeusTransformUtils.preCheckCast(ObricActivityTaskManager.Companion, IObricActivityTaskManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricWindowManager windowManager() {
        return (IObricWindowManager) ZeusTransformUtils.preCheckCast(ObricWindowManager.Companion, IObricWindowManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricInputmethodManager inputmethodManager() {
        return (IObricInputmethodManager) ZeusTransformUtils.preCheckCast(com.obric.framework.inputmethod.a.f33232a, IObricInputmethodManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricSleepModeManager sleepModeManager() {
        return (IObricSleepModeManager) ZeusTransformUtils.preCheckCast(ObricSleepModeManager.Companion, IObricSleepModeManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricMemoryManager memoryManager() {
        return (IObricMemoryManager) ZeusTransformUtils.preCheckCast(ObricMemoryManager.Companion, IObricMemoryManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricDeviceIdleController deviceIdleController() {
        return (IObricDeviceIdleController) ZeusTransformUtils.preCheckCast(ObricDeviceIdleController.Companion, IObricDeviceIdleController.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IObricNotificationManager notificationManager() {
        return (IObricNotificationManager) ZeusTransformUtils.preCheckCast(ObricNotificationManager.Companion, IObricNotificationManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IVibrateFeedback vibrateFeedback() {
        return (IVibrateFeedback) ZeusTransformUtils.preCheckCast(VibrateFeedback.INSTANCE, IVibrateFeedback.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.IPlatformService
    public IWindowEffects windowEffects() {
        return (IWindowEffects) ZeusTransformUtils.preCheckCast(WindowEffects.INSTANCE, IWindowEffects.class, "com.obric.aiagent.plugin");
    }
}
