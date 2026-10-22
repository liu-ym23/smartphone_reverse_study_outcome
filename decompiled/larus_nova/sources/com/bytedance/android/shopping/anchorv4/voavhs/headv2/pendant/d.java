package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f169875a;

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f169875a == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public final void setLoadSuccess(boolean r100) {
        this.f169875a = r100;
    }
}
