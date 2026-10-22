package com.bytedanceos.common.ui.widget.guide.model;

import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import com.bytedanceos.common.ui.widget.guide.core.Controller;
import com.bytedanceos.common.ui.widget.guide.util.GuideLogUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class RelativeGuide {
    public int gravity;
    public HighLight highLight;

    @LayoutRes
    public int layout;
    public int padding;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LimitGravity {
    }

    public static class MarginInfo {
        public int bottomMargin;
        public int gravity;
        public int leftMargin;
        public int rightMargin;
        public int topMargin;

        public MarginInfo() {
        }

        public String toString() {
            return "MarginInfo{leftMargin=" + this.leftMargin + ", topMargin=" + this.topMargin + ", rightMargin=" + this.rightMargin + ", bottomMargin=" + this.bottomMargin + ", gravity=" + this.gravity + '}';
        }
    }

    public RelativeGuide(@LayoutRes int r10, int r11) {
        this.layout = r10;
        this.gravity = r11;
    }

    private MarginInfo getMarginInfo(int r10, ViewGroup r11, View r12) {
        MarginInfo r13 = new MarginInfo();
        RectF r14 = this.highLight.getRectF(r11);
        if (r10 == 3) goto L12;
        if (r10 != 5) goto L6;
        r13.leftMargin = (int) (r14.right + this.padding);
        r13.topMargin = (int) r14.top;
    L13:
        return r13;
    L6:
        if (r10 == 48) goto L10;
        if (r10 != 80) goto L13;
        r13.topMargin = (int) (r14.bottom + this.padding);
        r13.leftMargin = (int) r14.left;
        goto L13
    L10:
        r13.gravity = 80;
        r13.bottomMargin = (int) ((r11.getHeight() - r14.top) + this.padding);
        r13.leftMargin = (int) r14.left;
        goto L13
    L12:
        r13.gravity = 5;
        r13.rightMargin = (int) ((r11.getWidth() - r14.left) + this.padding);
        r13.topMargin = (int) r14.top;
        goto L13
    }

    public final View getGuideLayout(ViewGroup r10, Controller r11) {
        View r12 = LayoutInflater.from(r10.getContext()).inflate(this.layout, r10, false);
        onLayoutInflated(r12);
        onLayoutInflated(r12, r11);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12.getLayoutParams();
        MarginInfo r14 = getMarginInfo(this.gravity, r10, r12);
        GuideLogUtil.e(r14.toString());
        offsetMargin(r14, r10, r12);
        r13.gravity = r14.gravity;
        r13.leftMargin += r14.leftMargin;
        r13.topMargin += r14.topMargin;
        r13.rightMargin += r14.rightMargin;
        r13.bottomMargin += r14.bottomMargin;
        r12.setLayoutParams(r13);
        return r12;
    }

    public void offsetMargin(MarginInfo r10, ViewGroup r11, View r12) {
    }

    @Deprecated
    public void onLayoutInflated(View r10) {
    }

    public void onLayoutInflated(View r10, Controller r11) {
    }

    public RelativeGuide(@LayoutRes int r10, int r11, int r12) {
        this.layout = r10;
        this.gravity = r11;
        this.padding = r12;
    }
}
