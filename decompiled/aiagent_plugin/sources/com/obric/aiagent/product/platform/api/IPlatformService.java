package com.obric.aiagent.product.platform.api;

import com.obric.aiagent.product.platform.api.app.IObricActivityManager;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.device.IObricDeviceIdleController;
import com.obric.aiagent.product.platform.api.memory.IObricMemoryManager;
import com.obric.aiagent.product.platform.api.notification.IObricNotificationManager;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aiagent.product.platform.api.sleepmode.IObricSleepModeManager;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import com.obric.aiagent.product.platform.api.view.IObricWindowManager;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.obric.aiagent.product.platform.impl.a;
import com.obric.framework.inputmethod.api.IObricInputmethodManager;

/* JADX INFO: compiled from: IPlatformService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IPlatformService {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IPlatformService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final IPlatformService get() {
            return a.f18799a.a();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    IObricActivityManager activityManager();

    IObricActivityTaskManager activityTaskManager();

    void destroy();

    IObricDeviceIdleController deviceIdleController();

    void init();

    IObricInputmethodManager inputmethodManager();

    IObricMemoryManager memoryManager();

    IObricNotificationManager notificationManager();

    IRomInfo romInfo();

    IObricSleepModeManager sleepModeManager();

    IVibrateFeedback vibrateFeedback();

    IWindowEffects windowEffects();

    IObricWindowManager windowManager();
}
