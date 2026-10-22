package com.bytedance.android.livehostapi.foundation.depend;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;

/* JADX INFO: loaded from: classes7.dex */
public interface IPluginType {
    void checkInstall(Context r100, IHostPlugin.Callback r101);

    void checkInstall(Context r100, String r101, IHostPlugin.Callback r102);

    void checkInstall(Context r100, String r101, IHostPlugin.Callback r102, boolean r103);

    boolean checkLoaded();

    String getPackageName();

    String[] getPluginSoFiles();

    String getType();

    boolean isInstalled();

    boolean isNeedPreload();

    boolean isPlugin();

    void load(Context r100, boolean r101);

    boolean load();

    void preload();

    void preload(IHostPlugin.Callback r100);
}
