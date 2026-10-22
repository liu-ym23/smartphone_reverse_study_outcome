package com.bytedance.android.live.performance.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes46.dex */
public class PerftoolsRelativeLayout extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f85387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Dialog f85388b;

    public PerftoolsRelativeLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        Dialog r101 = this.f85388b;
        if (r101 == null) goto L5;
        r101.dispatchKeyEvent(r100);
    L5:
        Activity r102 = this.f85387a;
        if (r102 == null) goto L10;
        r102.dispatchKeyEvent(r100);
        return false;
    L10:
        return false;
    }

    public void setActivity(Activity r100) {
        this.f85387a = r100;
    }

    public void setDialog(Dialog r100) {
        this.f85388b = r100;
    }

    public PerftoolsRelativeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public PerftoolsRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
