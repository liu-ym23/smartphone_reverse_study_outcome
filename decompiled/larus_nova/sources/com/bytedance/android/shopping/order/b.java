package com.bytedance.android.shopping.order;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f179670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f179671b;

    public b(Context r100, View r101) {
        this.f179670a = r100;
        this.f179671b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r100 = UIUtils.dip2Px(this.f179670a, 295.0f);     // Catch: Throwable -> L10
        View r101 = this.f179671b;     // Catch: Throwable -> L10
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();     // Catch: Throwable -> L10
        FrameLayout.LayoutParams r103 = null;
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r102;     // Catch: Throwable -> L10
        if (r104 == null) goto L8;
        r104.width = (int) r100;     // Catch: Throwable -> L10
        r104.height = (int) (r100 * 1.7777778f);     // Catch: Throwable -> L10
        r104.gravity = 16;     // Catch: Throwable -> L10
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r103 = r104;
    L8:
        r101.setLayoutParams(r103);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
