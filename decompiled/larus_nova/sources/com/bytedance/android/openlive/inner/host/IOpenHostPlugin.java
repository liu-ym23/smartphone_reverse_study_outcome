package com.bytedance.android.openlive.inner.host;

import android.content.Context;
import com.bytedance.android.live.base.IService;

/* JADX INFO: loaded from: classes12.dex */
public interface IOpenHostPlugin extends IService {
    void check(Context r100, String r101, String r102, IPluginCallback r103);

    void check(Context r100, String r101, String r102, IPluginCallback r103, boolean r104);

    boolean checkPluginInstalled(String r100);

    String getHostPackageName();

    boolean loadLibrary(int r100, Context r101, String r102, String r103, ClassLoader r104);

    void preload(String r100);
}
