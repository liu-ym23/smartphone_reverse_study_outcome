package com.bytedance.android.livehostapi.foundation.depend.pluginstrategy;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public class MiniGameEnginePluginStrategy extends SaaSPluginStrategy {
    @Override // com.bytedance.android.livehostapi.foundation.depend.PluginStrategy, com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isInstalled() {
        return ((IHostPlugin) k.f(IHostPlugin.class)).checkPluginInstalled(getPackageName());
    }

    public MiniGameEnginePluginStrategy(String r100, boolean r101, String r102) {
        super(r100, r101, r102);
    }
}
