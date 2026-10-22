package com.bytedance.android.annie.container.dialog;

import android.os.Bundle;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes43.dex */
public interface l {
    void attach(FrameLayout r100, ia.f r101, t36.f r102, boolean r103);

    boolean getModStatusBar();

    void handlePullStateChange(int r100);

    boolean needAdapterStatusBarColor();

    void onActivityCreatedProxy(Bundle r100);

    void onDestroyProxy();

    void onDestroyViewProxy();

    void setModStatusBar(boolean r100);
}
