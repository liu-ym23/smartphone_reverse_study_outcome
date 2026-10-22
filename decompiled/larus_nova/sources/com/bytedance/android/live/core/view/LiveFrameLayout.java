package com.bytedance.android.live.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import com.bytedance.android.live.ILiveCheckDraw;

/* JADX INFO: loaded from: classes45.dex */
@RemoteViews.RemoteView
public class LiveFrameLayout extends FrameLayout {
    public LiveFrameLayout(Context r100) {
        super(r100);
    }

    public LiveFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public LiveFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r100, View r101, long r102) {
        if (ILiveCheckDraw.a(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.drawChild(r100, r101, r102) == false) goto L7;
        return true;
    }
}
