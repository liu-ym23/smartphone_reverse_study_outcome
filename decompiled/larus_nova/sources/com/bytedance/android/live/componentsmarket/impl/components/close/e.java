package com.bytedance.android.live.componentsmarket.impl.components.close;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends TouchDelegate {
    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return super.onTouchEvent(r100);
    }

    public e(Rect r100, View r101) {
        super(r100, r101);
    }
}
