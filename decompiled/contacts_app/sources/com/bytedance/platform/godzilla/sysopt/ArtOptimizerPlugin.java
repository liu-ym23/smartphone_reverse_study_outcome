package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.ArtOptimizer;

/* JADX INFO: loaded from: classes2.dex */
public class ArtOptimizerPlugin extends BasePlugin {
    private Application mApp;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "ArtOptimizerPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
    }

    public ArtOptimizerPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mApp = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        Application r0 = this.mApp;
        if (r0 == null) goto L6;
        ArtOptimizer.optSuspendTimeout(r0);
        return;
    }
}
