package com.bytedance.android.livehostapi.foundation.depend;

/* JADX INFO: loaded from: classes7.dex */
public class PluginTypeFactoryService implements IPluginTypeFactoryService {
    private PluginFactory factory;

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginTypeFactoryService
    public boolean isRegister(IPluginType r100) {
        return false;
    }

    public PluginTypeFactoryService() {
        this.factory = new PluginFactory();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginTypeFactoryService
    public PluginStrategy create(IPluginType r100, String r101, boolean r102, String r103) {
        return this.factory.createOrGet(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginTypeFactoryService
    public /* bridge */ /* synthetic */ IPluginType create(IPluginType r100, String r101, boolean r102, String r103) {
        return create(r100, r101, r102, r103);
    }
}
