package com.obric.autoaction.inittasks.refactor;

import com.obric.autogui.common.api.AOThermalManager;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.thermal.IAutoActionThermalStateApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.x;

/* JADX INFO: compiled from: InitThermalListeningTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class InitThermalListeningTask implements IAutoActionFoundationReadyTask {
    public static final Companion Companion = null;
    private static final String TAG = "InitThermal";

    /* JADX INFO: compiled from: InitThermalListeningTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public InitThermalListeningTask() {
    }

    @Override // com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask
    public Object run(d<? super x> r4) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, " - initialising thermal manager...");
        AOThermalManager.INSTANCE.initThermalStateMonitor();     // Catch: Throwable -> L5
    L15:
        IAutoActionThermalStateApi.ThermalLevelState r5 = AOThermalManager.INSTANCE.getThermalLevelState();     // Catch: Throwable -> L9
    L11:
        Loog.INSTANCE.i(TAG, " - thermal state: " + r5);
        return x.f38692a;
    L9:
        th = move-exception;
        Loog.INSTANCE.w(TAG, " - get thermal state errored: " + th.getMessage(), th);
        r5 = null;
    L5:
        th = move-exception;
        Loog.INSTANCE.w(TAG, " - init thermal monitor errored: " + th.getMessage(), th);
        goto L15
    }
}
