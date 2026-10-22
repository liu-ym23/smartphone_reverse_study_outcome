package com.bytedance.android.livehostapi.foundation.depend;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public class PluginStrategy implements IPluginType {
    private static final String TAG = "PluginType";
    private final boolean mNeedPreload;
    private final String mPackageName;
    private String[] mPluginSoFiles;
    private final FilenameFilter mSoFileFilter;
    private final String mType;

    public static /* synthetic */ boolean a(File r100, String r101) {
        return lambda$new$0(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void load(Context r100, boolean r101) {
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean checkLoaded() {
        return ((IHostPlugin) k.f(IHostPlugin.class)).checkPluginLoaded(this.mPackageName);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isInstalled() {
        IHostPlugin r100 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = r100.isFull();
        boolean r102 = r100.checkPluginInstalled(getPackageName());
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
        return false;
    L8:
        return true;
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
        return ((IHostPlugin) k.f(IHostPlugin.class)).load(this.mPackageName);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void preload() {
        ((IHostPlugin) k.f(IHostPlugin.class)).preload(getPackageName(), null);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String[] getPluginSoFiles() {
        long r100 = System.currentTimeMillis();
        String r101 = getPackageName();
        if (this.mPluginSoFiles != null) goto L11;
        String r102 = ((IHostPlugin) k.f(IHostPlugin.class)).getNativeLibraryDir(r101);
        if (r102 != null) goto L8;
        return null;
    L8:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.isDirectory() == false) goto L11;
        this.mPluginSoFiles = r103.list(this.mSoFileFilter);
    L11:
        String.format("%s getPluginSoFiles cost: %s ms", new Object[]{this.mPackageName, Long.valueOf(System.currentTimeMillis() - r100)});
        return this.mPluginSoFiles;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public String getType() {
        return this.mType;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public boolean isNeedPreload() {
        return this.mNeedPreload;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void preload(IHostPlugin.Callback r100) {
        ((IHostPlugin) k.f(IHostPlugin.class)).preload(getPackageName(), r100);
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
        checkInstall(r100, "", r101);
    }

    public PluginStrategy(String r100, boolean r101, String r102) {
        this.mSoFileFilter = new b();
        this.mType = r100;
        this.mNeedPreload = r101;
        this.mPackageName = r102;
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, String r101, IHostPlugin.Callback r102) {
        if (isInstalled() == false) goto L7;
        if (r102 == null) goto L9;
        r102.onSuccess(getPackageName());
        return;
    L9:
        return;
    L7:
        ((IHostPlugin) k.f(IHostPlugin.class)).check(r100, this, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IPluginType
    public void checkInstall(Context r100, String r101, IHostPlugin.Callback r110, boolean r111) {
        if (isInstalled() == false) goto L7;
        if (r110 == null) goto L9;
        r110.onSuccess(getPackageName());
        return;
    L9:
        return;
    L7:
        ((IHostPlugin) k.f(IHostPlugin.class)).check(r100, this, r101, r110, r111);
    }
}
