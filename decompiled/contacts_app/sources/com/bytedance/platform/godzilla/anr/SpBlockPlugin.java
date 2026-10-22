package com.bytedance.platform.godzilla.anr;

import android.app.Application;
import com.bytedance.platform.godzilla.anr.sp.QueuedWorkProxyWrapper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes2.dex */
public class SpBlockPlugin extends BasePlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "SpPlugin";
    }

    public SpBlockPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        QueuedWorkProxyWrapper.hookQueuedWork();
        Logger.e(getName(), "start");
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }
}
