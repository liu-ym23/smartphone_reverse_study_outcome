package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import android.view.MotionEvent;
import com.bytedance.android.gamecp.business.gamedetail.view.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScaffoldWidgetV5 f55022a;

    public k(ScaffoldWidgetV5 r100) {
        this.f55022a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.view.m
    public final void onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L6;
        ScaffoldWidgetV5.Rq(this.f55022a, "touchesBegan");
        return;
    L6:
        if (r100.getAction() != 1) goto L10;
        ScaffoldWidgetV5.Rq(this.f55022a, "touchesEnded");
        return;
    }
}
