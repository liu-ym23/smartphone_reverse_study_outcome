package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;

/* JADX INFO: loaded from: classes2.dex */
public class EnterTransitionCrashPlugin extends BasePlugin {
    private Context mContext;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "EnterTransitionCrashPlugin";
    }

    public EnterTransitionCrashPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mContext = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        EnterTransitionCrashOptimizer.fix(this.mContext);
    }
}
