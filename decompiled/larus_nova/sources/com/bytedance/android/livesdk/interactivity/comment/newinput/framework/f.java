package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f135495a;

    public f(boolean r100) {
        this.f135495a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        return !this.f135495a;
    }
}
