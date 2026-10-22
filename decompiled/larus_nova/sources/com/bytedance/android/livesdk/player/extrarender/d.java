package com.bytedance.android.livesdk.player.extrarender;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public interface d {
    boolean a();

    boolean b();

    View curExtraRenderView();

    void g(boolean r100, boolean r101);

    void hideExtraRender();

    void i();

    void l(Context r100);

    void onFoldDeviceStateChanged();

    void onScreenPortrait();
}
