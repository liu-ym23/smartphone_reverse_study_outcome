package com.bytedance.android.livesdk.chatroom.miniapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.larus.nova.R;
import oh1.a;

/* JADX INFO: loaded from: classes7.dex */
public class LiveMiniAppRoundedRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f106876a;

    public LiveMiniAppRoundedRelativeLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        int r101 = this.f106876a;
        super.dispatchDraw(r100);
    }

    public void setBorderRadius(int r100) {
        this.f106876a = r100;
        invalidate();
    }

    public LiveMiniAppRoundedRelativeLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveMiniAppRoundedRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f106876a = 0;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(0) == false) goto L5;
        this.f106876a = r103.getDimensionPixelOffset(0, 0);
    L5:
        r103.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f106876a <= 0) goto L6;
        setClipToOutline(true);
        setOutlineProvider(new a(this.f106876a, r100, r101));
        return;
    }
}
