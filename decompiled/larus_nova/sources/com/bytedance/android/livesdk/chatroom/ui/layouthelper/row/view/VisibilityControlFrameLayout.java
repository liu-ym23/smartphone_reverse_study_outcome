package com.bytedance.android.livesdk.chatroom.ui.layouthelper.row.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes8.dex */
public class VisibilityControlFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f113672a;

    public VisibilityControlFrameLayout(Context r100) {
        super(r100);
        this.f113672a = true;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        boolean r101 = this.f113672a;
        super.setVisibility(r100);
    }

    public VisibilityControlFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f113672a = true;
    }

    public VisibilityControlFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f113672a = true;
    }
}
