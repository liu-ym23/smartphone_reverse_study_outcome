package com.bytedance.android.ec.common.impl.sku.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f43485a;

    public e(TextView r100) {
        this.f43485a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        this.f43485a.setAlpha(0.75f);
        return false;
    L5:
        if (r102 != 1) goto L7;
    L9:
        this.f43485a.setAlpha(1.0f);
        return false;
    L7:
        if (r102 == 3) goto L9;
        return false;
    }
}
