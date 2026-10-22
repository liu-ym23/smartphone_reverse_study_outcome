package com.bytedance.android.livesdk.widget.schedule;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements rv2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<rv2.a> f162094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f162095b;

    @Override // rv2.a
    public final void E() {
    }

    @Override // rv2.a
    public final void F() {
    }

    @Override // rv2.a
    public final void G() {
    }

    @Override // rv2.a
    public final void I() {
    }

    @Override // rv2.a
    public final void K() {
    }

    @Override // rv2.a
    public final void M() {
    }

    @Override // rv2.a
    public final void N(DataCenter r100) {
    }

    @Override // rv2.a
    public final void onDestroy() {
    }

    @Override // rv2.a
    public final void x() {
    }

    public c() {
        this.f162095b = new b();
    }

    @Override // rv2.a
    public final void H(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        WeakReference<rv2.a> r102 = this.f162094a;
        if (r102 == null) goto L5;
        rv2.a r103 = r102.get();
    L6:
        if (r103 == null) goto L8;
        r103.H(r100, r101);
        return;
    L8:
        this.f162095b.H(r100, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // rv2.a
    public final void J(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        WeakReference<rv2.a> r102 = this.f162094a;
        if (r102 == null) goto L5;
        rv2.a r103 = r102.get();
    L6:
        if (r103 == null) goto L8;
        r103.J(r100, r101);
        return;
    L8:
        this.f162095b.J(r100, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // rv2.a
    public final void L(com.bytedance.android.live.core.tetris.task.a r100, rv2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Intrinsics.checkNotNullParameter(r101, "widgetVisibilityControl");
        WeakReference<rv2.a> r102 = this.f162094a;
        if (r102 == null) goto L5;
        rv2.a r103 = r102.get();
    L6:
        if (r103 == null) goto L8;
        r103.L(r100, r101);
        return;
    L8:
        this.f162095b.L(r100, r101);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
