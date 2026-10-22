package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.model.DisplayRatio;

/* JADX INFO: loaded from: classes46.dex */
public interface c {
    void a(int r100);

    void b(int r100);

    void c(int r100);

    int d();

    boolean e();

    void f(int r100);

    int getBottom();

    DisplayRatio getDisplayRatio();

    int getHeight();

    int getLeft();

    int getRight();

    int getScaleType();

    float getScaleX();

    float getScaleY();

    int getTop();

    float getTranslationX();

    float getTranslationY();

    int getWidth();

    void requestLayout(String r100);

    void setDisplayRatio(DisplayRatio r100);

    void setGravity(int r100);

    void setHeight(int r100);

    void setScaleType(int r100);

    void setScaleX(float r100);

    void setScaleY(float r100);

    void setTranslationX(float r100);

    void setTranslationY(float r100);

    void setWidth(int r100);
}
