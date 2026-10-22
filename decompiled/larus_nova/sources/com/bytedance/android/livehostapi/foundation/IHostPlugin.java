package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.foundation.base.IBaseHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.IExoPlayer;
import com.bytedance.android.livehostapi.foundation.depend.IPluginType;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostPlugin extends IService, IBaseHostPlugin {
    public static final String ENTER_FROM = "enter_from";
    public static final String ENTER_FROM_LINKMIC_TYPE = "interact";
    public static final int LOAD_TYPE_BUILD_FULL = 3;
    public static final int LOAD_TYPE_HOST = 1;
    public static final int LOAD_TYPE_OTHER = 2;
    public static final int LOAD_TYPE_PLUGIN = 0;
    public static final int LOAD_TYPE_PLUGIN_ENV = 4;

    public interface Callback {
        void onCancel(String r100);

        void onSuccess(String r100);
    }

    void check(Context r100, IPluginType r101, String r102, Callback r103);

    void check(Context r100, IPluginType r101, String r102, Callback r103, boolean r104);

    boolean checkPluginInstalled(String r100);

    boolean checkPluginLoaded(String r100);

    IExoPlayer createExoPlayerWrapper(Context r100, IExoPlayer.PlayerListener r101);

    boolean enableMiraClassLoaderOpt();

    boolean exoPlayerPluginReady();

    String getCameraPluginPackage();

    String getHostModeFilePath();

    String getHostPackageName();

    String getNativeLibraryDir(String r100);

    <T> T getOrNull(Class<T> r100);

    int getPluginAttributeMinVersion(String r100);

    boolean isFull();

    boolean isPlugin(String r100);

    boolean load(String r100);

    boolean loadLibrary(int r100, Context r101, String r102, String r103, ClassLoader r104);

    Pair<Boolean, String> loadLibraryV2(int r100, Context r101, String r102, String r103, ClassLoader r104);

    void preload(String r100, Callback r101);
}
