package com.bytedance.android.livehostapi.foundation.depend;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import java.io.File;
import java.io.FilenameFilter;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public enum NewPluginType extends Enum<NewPluginType> implements IPluginType {
    private static final /* synthetic */ NewPluginType[] $VALUES = null;
    public static final NewPluginType Camera = null;
    public static final NewPluginType IESVideoClipLibPlugin = null;
    public static final NewPluginType LiveResource = null;
    private static final String TAG = "PluginType";
    private final boolean mNeedPreload;
    private final String mPackageName;
    private String[] mPluginSoFiles;
    private final FilenameFilter mSoFileFilter;
    private final String mType;
    private final IPluginType strategy;

    public static /* synthetic */ boolean a(File r100, String r101) {
        return lambda$new$0(r100, r101);
    }

    static {
        final String r100 = "LiveResource";
        final int r101 = 0;
        final String r102 = "live_engine";
        final boolean r103 = true;
        final String r104 = NewPluginTypeExt.INSTANCE.getLiveResourcePackageName();
        NewPluginType r105 = new AnonymousClass1(r100, r101, r102, r103, r104);
        LiveResource = r105;
        NewPluginType r106 = new NewPluginType("Camera", 1, "camera", true, "com.ss.android.ugc.live.liveshortvideo_so");
        Camera = r106;
        final String r110 = "IESVideoClipLibPlugin";
        final int r111 = 2;
        final String r112 = "iesvideocliplib_plugin";
        final boolean r113 = true;
        final String r114 = "com.ss.android.ugc.aweme.iesvideoclip";
        NewPluginType r107 = new AnonymousClass2(r110, r111, r112, r113, r114);
        IESVideoClipLibPlugin = r107;
        $VALUES = new NewPluginType[]{r105, r106, r107};
    }

    public static NewPluginType[] values() {
        return (NewPluginType[]) $VALUES.clone();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean checkLoaded() {
        return this.strategy.checkLoaded();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getPackageName() {
        return this.strategy.getPackageName();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String[] getPluginSoFiles() {
        return this.strategy.getPluginSoFiles();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getType() {
        return this.strategy.getType();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isInstalled() {
        return this.strategy.isInstalled();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isNeedPreload() {
        return this.strategy.isNeedPreload();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isPlugin() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPlugin(getPackageName());
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean load() {
        return this.strategy.load();
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void preload() {
        this.strategy.preload(null);
    }

    public static NewPluginType valueOf(String r100) {
        return (NewPluginType) r27.a.a(NewPluginType.class, r100);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void preload(IHostPlugin.Callback r100) {
        this.strategy.preload(r100);
    }

    private static /* synthetic */ boolean lambda$new$0(File r100, String r101) {
        if (r101.startsWith("lib") == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.endsWith(".so") == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, IHostPlugin.Callback r101) {
        this.strategy.checkInstall(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void load(Context r100, boolean r101) {
        this.strategy.load(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, String r101, IHostPlugin.Callback r102) {
        this.strategy.checkInstall(r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, String r101, IHostPlugin.Callback r102, boolean r103) {
        this.strategy.checkInstall(r100, r101, r102, r103);
    }

    private NewPluginType(String r100, int r101, String r102, boolean r103, String r104) {
        super(r100, r101);
        this.mSoFileFilter = new a();
        this.mType = r102;
        this.mNeedPreload = r103;
        this.mPackageName = r104;
        this.strategy = ((IPluginTypeFactoryService) k.f(IPluginTypeFactoryService.class)).create(this, r102, r103, r104);
    }

    public /* synthetic */ NewPluginType(String r100, int r101, String r102, boolean r103, String r104, AnonymousClass1 r105) {
        this(r100, r101, r102, r103, r104);
    }
}
