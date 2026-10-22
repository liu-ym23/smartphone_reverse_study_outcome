package com.bytedance.android.livehostapi.foundation;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.depend.IExoPlayer;
import com.bytedance.android.livehostapi.foundation.depend.IPluginType;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public class LiveHostPlugin implements IHostPlugin {
    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
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
    public boolean exoPlayerPluginReady() {
        return false;
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
    public void preload(String r100, IHostPlugin.Callback r101) {
    }

    public LiveHostPlugin() {
        k.l(IHostPlugin.class, this);
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean enableMiraClassLoaderOpt() {
        notImplemented();
        return false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public String getCameraPluginPackage() {
        notImplemented();
        return null;
    }

    public void notImplemented() {
        if (v.a() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not implemented on saas");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_android_livehostapi_foundation_LiveHostPlugin_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public <T> T getOrNull(Class<T> r100) {
        notImplemented();
        return null;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public boolean loadLibrary(int r100, Context r101, String r102, String r103, ClassLoader r104) {
        INVOKESTATIC_com_bytedance_android_livehostapi_foundation_LiveHostPlugin_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r103);
        return true;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin
    public Pair<Boolean, String> loadLibraryV2(int r100, Context r101, String r102, String r103, ClassLoader r104) {
        INVOKESTATIC_com_bytedance_android_livehostapi_foundation_LiveHostPlugin_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r103);     // Catch: Exception -> L4
        return new Pair(Boolean.TRUE, "");
    L4:
        e = move-exception;
        return new Pair(Boolean.FALSE, e.toString());
    }
}
