package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.XHookPlugin;
import com.bytedance.sysoptimizer.MTK_PVR_Optimizer;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes2.dex */
public class MTK_PVR_OptimizerPlugin extends XHookPlugin {
    private boolean mAlwaysCatchSIGSEGV;
    private Application mApp;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "MTK_PVR_OptimizerPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
    }

    public MTK_PVR_OptimizerPlugin(boolean r1) {
        this.mAlwaysCatchSIGSEGV = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mApp = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        MTK_PVR_Optimizer.setAlwaysCatchSIGSEGV(this.mAlwaysCatchSIGSEGV);
        MTK_PVR_Optimizer.enable(this.mApp);
    }

    @Override // com.bytedance.platform.godzilla.plugin.XHookPlugin
    public void invokeXHookRefresh() {
        SysOptimizer.hookOptimizerEnable();
    }
}
