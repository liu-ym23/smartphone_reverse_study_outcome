package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes8.dex */
public class TapGuideView extends SlideGuideView {
    public TapGuideView(Context r100) {
        super(r100);
        LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) this.f118691a.getLayoutParams();
        r101.width = com.bytedance.android.live.core.utils.s1.f(160.0f);
        r101.height = com.bytedance.android.live.core.utils.s1.f(160.0f);
        this.f118691a.setLayoutParams(r101);
    }

    public void setMultiLine(boolean r100) {
        this.f118693c.setSingleLine(!r100);
    }

    public TapGuideView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public TapGuideView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
