package com.bytedance.android.livehostapi.hostdefault;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.IExoPlayer;
import com.bytedance.android.livehostapi.foundation.depend.IPluginType;

/* JADX INFO: loaded from: classes7.dex */
public class HostPluginDefault implements IHostPlugin {
    public HostPluginDefault() {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public void check(Context r100, IPluginType r101, String r102, IHostPlugin.Callback r103) {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public void check(Context r100, IPluginType r101, String r102, IHostPlugin.Callback r103, boolean r104) {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean checkPluginInstalled(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean checkPluginLoaded(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public IExoPlayer createExoPlayerWrapper(Context r100, IExoPlayer.PlayerListener r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean enableMiraClassLoaderOpt() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean exoPlayerPluginReady() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getCameraPluginPackage() {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getHostModeFilePath() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getHostPackageName() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getNativeLibraryDir(String r100) {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public <T> T getOrNull(Class<T> r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public int getPluginAttributeMinVersion(String r100) {
        return 0;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean isFull() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean isPlugin(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean load(String r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean loadLibrary(int r100, Context r101, String r102, String r103, ClassLoader r104) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public Pair<Boolean, String> loadLibraryV2(int r100, Context r101, String r102, String r103, ClassLoader r104) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public void preload(String r100, IHostPlugin.Callback r101) {
    }
}
