package com.bytedance.android.livesdk.common;

import android.graphics.Paint;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public interface j {

    public interface a {
        void onEnd();

        void onStart();
    }

    void cancelAnimation();

    View getA11yDescView();

    String getContent();

    String getOriginText();

    Paint getPaint();

    void scrollToOrigin();

    void setIncludeFontPadding(boolean r100);

    void setMaxWidth(int r100);

    void setScrollEnd(boolean r100);

    void setSpeed(int r100);

    void setTextColor(int r100);

    void setTextSize(int r100, float r101);

    void setTextWithEllipsis(String r100);

    void setTextWithEllipsisImmediately(String r100);

    void setTextWithFading(String r100);

    void setTextWithFadingMode(String r100);

    void startMarqueeIfNeed(a r100);

    void startMarqueeIfNeed(Function1<? super Boolean, Unit> r100);

    void textNeedLeftEdge(boolean r100);
}
