package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.XHookPlugin;
import com.bytedance.sysoptimizer.DvmDeadLockOptimizer;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes2.dex */
public class DvmDeadLockOptimizerPlugin extends XHookPlugin {
    private Application mApp;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "DvmDeadLockOptimizerPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
    }

    public DvmDeadLockOptimizerPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mApp = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        DvmDeadLockOptimizer.optimize(this.mApp);
    }

    @Override // com.bytedance.platform.godzilla.plugin.XHookPlugin
    public void invokeXHookRefresh() {
        SysOptimizer.hookOptimizerEnable();
    }
}
