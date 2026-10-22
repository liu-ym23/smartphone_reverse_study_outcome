package com.bytedance.android.livehostapi.foundation.depend;

import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.MainCameraPluginStrategy;
import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.MiniGameEnginePluginStrategy;
import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.SaaSLiveResourceStrategy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public class PluginFactory {
    private ConcurrentHashMap<String, PluginStrategy> strategyHashMap;

    public PluginFactory() {
        this.strategyHashMap = new ConcurrentHashMap();
    }

    public boolean findStrategy(String r100) {
        return this.strategyHashMap.containsKey(r100);
    }

    private void addStrategy(String r100, PluginStrategy r101) {
        this.strategyHashMap.put(r100, r101);
    }

    private void installPluginTypeFactory(String r100, boolean r101, String r102) {
        if ("live_engine".equals(r100) == false) goto L6;
        addStrategy(r100, new SaaSLiveResourceStrategy(r100, r101, r102));
        return;
    L6:
        if ("camera".equals(r100) == false) goto L9;
        addStrategy(r100, new MainCameraPluginStrategy(r100, r101, r102));
        return;
    L9:
        if ("minigamelite".equals(r100) == false) goto L14;
        addStrategy(r100, new MiniGameEnginePluginStrategy(r100, r101, r102));
        return;
    }

    public PluginStrategy createOrGet(IPluginType r100, String r101, boolean r102, String r103) {
        if (this.strategyHashMap.containsKey(r101) == true) goto L5;
        installPluginTypeFactory(r101, r102, r103);
        if (this.strategyHashMap.containsKey(r101) == false) goto L11;
        return this.strategyHashMap.get(r101);
    L11:
        return new PluginStrategy(r101, r102, r103);
    L5:
        return this.strategyHashMap.get(r101);
    }
}
