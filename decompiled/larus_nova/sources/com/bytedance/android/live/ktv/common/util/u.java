package com.bytedance.android.live.ktv.common.util;

/* JADX INFO: loaded from: classes45.dex */
public interface u {
    void attachFromWindow(String r100);

    void detachFromWindow(String r100);

    boolean isVHPaused();

    boolean isVHSelected();

    String name();

    void onVHPaused();

    void onVHResume();

    void onVHSelected();

    void onVHUnBind();

    void onVHUnSelected();
}
