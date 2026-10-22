package com.bytedance.android.gamecp.common.track.monitor;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f56836a;

    public c(a r100) {
        this.f56836a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = a.f56810y;
        a.C0914a.a(r100, false);
        this.f56836a.b();
        WeakReference<View> r102 = this.f56836a.f56812b;
        if (r102 == null) goto L10;
        View r103 = r102.get();
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.hasWindowFocus() != true) goto L12;
        this.f56836a.a();
        return;
    L12:
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = a.f56810y;
        a.C0914a.a(r100, true);
        this.f56836a.b();
        this.f56836a.h();
        a r102 = this.f56836a;
        if (r102.f56832v == true) goto L5;
        r102.d();
        return;
    L5:
        r102.f56821k.sendEmptyMessageDelayed(1020304051, r102.f56829s);
    }
}
