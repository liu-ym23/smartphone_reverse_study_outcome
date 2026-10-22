package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseModelListScrollManager f141128a;

    public a(BaseModelListScrollManager r100) {
        this.f141128a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() == 1) goto L5;
        return false;
    L5:
        if (this.f141128a.f141122j.canScrollVertically(1) == true) goto L7;
        this.f141128a.d(BaseModelListScrollManager.ScrollState.AutoScroll);
        return false;
    L7:
        this.f141128a.d(BaseModelListScrollManager.ScrollState.Focus);
        BaseModelListScrollManager.a(this.f141128a);
        return false;
    }
}
