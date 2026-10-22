package com.bytedance.android.livehostapi.foundation.depend.pluginstrategy;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.depend.PluginStrategy;
import com.bytedance.android.livesdk.config.uh;
import tb1.c;

/* JADX INFO: loaded from: classes7.dex */
public class MainLiveResourceStrategy extends PluginStrategy {
    private final Boolean isRemoveResourcePlugin;

    @Override // com.bytedance.android.livehostapi.foundation.depend.PluginStrategy, com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getPackageName() {
        return "com.ss.android.ies.live.liveresource";
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.PluginStrategy, com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isInstalled() {
        if (c.f545231c == false) goto L6;
        return true;
    L6:
        if (this.isRemoveResourcePlugin.booleanValue() == false) goto L10;
        ALogger.w("LiveBroadcastContext", "just return, isInstalled: true");
        return true;
    L10:
        return super.isInstalled();
    }

    public MainLiveResourceStrategy(String r100, boolean r101, String r102) {
        super(r100, r101, r102);
        this.isRemoveResourcePlugin = uh.f121373a.getValue();
    }
}
