package com.bytedance.android.live.ui;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;

/* JADX INFO: loaded from: classes7.dex */
public interface o {
    void b();

    void c();

    void d(String r100, String r101, n r102);

    void hide();

    boolean isPlaying();

    boolean isVisible();

    void setShowArea(IThemeShowArea r100);

    void setThemeViewAlpha(float r100);

    void show();

    void tryResumePlay();
}
