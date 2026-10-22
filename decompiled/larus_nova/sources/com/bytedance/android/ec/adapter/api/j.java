package com.bytedance.android.ec.adapter.api;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: loaded from: classes43.dex */
public interface j {
    void a(DialogFragment r100, FrameLayout r101, a r102);

    void b(Activity r100);

    void c(Activity r100, a r101);

    boolean checkWindowConflict();

    void d(Object r100);

    void e(Activity r100, a r101);

    Object f(com.bytedance.android.ec.model.j r100);

    void g(DialogFragment r100, FrameLayout r101);

    boolean isFloatWindowShowing();

    void setFloatWindowBottomMargin(int r100);

    void stopShowFloat();

    void stopShowFloatInNextLifecycle();

    void stopShowNow();

    void toggleLiveAudio(boolean r100);
}
