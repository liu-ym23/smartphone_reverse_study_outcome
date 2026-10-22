package com.bytedance.android.accessibilityLib_Core.helper;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f38280a;

    @Override // android.view.Window
    public final View getDecorView() {
        return this.f38280a;
    }

    @Override // android.view.Window
    public final View peekDecorView() {
        return this.f38280a;
    }

    public d(Context r100, FrameLayout r101) {
        super(r100);
        this.f38280a = r101;
    }
}
