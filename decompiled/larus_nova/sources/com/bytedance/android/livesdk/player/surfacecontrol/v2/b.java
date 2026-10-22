package com.bytedance.android.livesdk.player.surfacecontrol.v2;

import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.android.livesdkapi.view.ISurfaceControlParent;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f156185a;

    public b(a r100) {
        this.f156185a = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        WeakReference<Object> r101 = this.f156185a.f156180c;
        SurfaceHolder r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get();
    L7:
        if ((r103 instanceof SurfaceView) == true) goto L9;
        r103 = null;
    L9:
        SurfaceView r104 = (SurfaceView) r103;
        if (r104 == null) goto L19;
        SurfaceHolder r105 = r104.getHolder();
        if (r105 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r105, r100) == false) goto L16;
        r102 = r105;
    L16:
        if (r102 == null) goto L21;
        this.f156185a.a();
        return;
    L21:
        return;
    L19:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        WeakReference<Object> r101 = this.f156185a.f156180c;
        if (r101 == null) goto L5;
        Object r102 = r101.get();
    L7:
        if ((r102 instanceof SurfaceView) == true) goto L9;
        r102 = null;
    L9:
        SurfaceView r103 = (SurfaceView) r102;
        if (r103 == null) goto L56;
        SurfaceHolder r104 = r103.getHolder();
        if (r104 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r104, r100) == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L60;
        r100.removeCallback(this);
        a r105 = this.f156185a;
        WeakReference<Object> r106 = r105.f156180c;
        if (r106 == null) goto L21;
        Object r107 = r106.get();
    L22:
        if (r107 == null) goto L55;
        SurfaceView r108 = (SurfaceView) r107;
        Intrinsics.checkNotNullParameter(r108, "view");
        WeakReference<Object> r109 = r105.f156180c;
        if (r109 == null) goto L26;
        Object r110 = r109.get();
    L28:
        if (Intrinsics.areEqual(r108, r110) == false) goto L61;
        WeakReference<Object> r111 = r105.f156180c;
        if (r111 == null) goto L32;
        r111.clear();
    L32:
        SurfaceHolder r112 = r108.getHolder();
        if (r112 == null) goto L36;
        r112.removeCallback(r105.f156183f);
    L36:
        if ((r108 instanceof ISurfaceControlParent) == true) goto L38;
        Object r113 = null;
    L39:
        ISurfaceControlParent r114 = (ISurfaceControlParent) r113;
        if (r114 == null) goto L42;
        r114.onSurfaceControlDetach(false);
    L42:
        monitor-enter(r105);
        SurfaceControl r115 = r105.f156178a;     // Catch: Throwable -> L51
        if (r115 == null) goto L49;
        new SurfaceControl.Transaction().reparent(r115, null).setVisibility(r115, false).apply();     // Catch: Throwable -> L51
        WeakReference<SurfaceControl> r116 = r105.f156181d;     // Catch: Throwable -> L51
        if (r116 == null) goto L48;
        r116.clear();     // Catch: Throwable -> L51
    L48:
        r105.f156181d = null;     // Catch: Throwable -> L51
        r105.f156184g.a(r105, 4);     // Catch: Throwable -> L51
    L49:
        monitor-exit(r105);
        r108.setTag(SurfaceControlPool.b(), null);
        return;
    L51:
        th = move-exception;
        throw th;
    L38:
        r113 = r108;
        goto L39
    L61:
        return;
    L26:
        r110 = null;
        goto L28
    L55:
        throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
    L21:
        r107 = null;
        goto L22
    L60:
        return;
    L56:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        WeakReference<Object> r104 = this.f156185a.f156180c;
        SurfaceHolder r105 = null;
        if (r104 == null) goto L5;
        Object r106 = r104.get();
    L7:
        if ((r106 instanceof SurfaceView) == true) goto L9;
        r106 = null;
    L9:
        SurfaceView r107 = (SurfaceView) r106;
        if (r107 == null) goto L19;
        SurfaceHolder r108 = r107.getHolder();
        if (r108 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r108, r100) == false) goto L16;
        r105 = r108;
    L16:
        if (r105 == null) goto L21;
        this.f156185a.a();
        return;
    L21:
        return;
    L19:
        return;
    L5:
        r106 = null;
        goto L7
    }
}
