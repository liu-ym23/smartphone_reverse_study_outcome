package com.bytedance.android.livehostapi.foundation.flavor.hotsoon;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostPluginForHS extends IService, IBaseHostPlugin {
    void check(Context r100, PluginType r101, String r102, IHostPlugin.Callback r103);

    void check(Context r100, PluginType r101, String r102, IHostPlugin.Callback r103, boolean r104);

    boolean checkPluginInstalled(String r100);

    String getCameraPluginPackage();

    String getHostPackageName();

    String getNativeLibraryDir(String r100);

    int getPluginAttributeMinVersion(String r100);

    boolean isFull();

    boolean loadLibrary(int r100, Context r101, String r102, String r103, ClassLoader r104);

    Pair<Boolean, String> loadLibraryV2(int r100, Context r101, String r102, String r103, ClassLoader r104);

    void preload(String r100);
}
