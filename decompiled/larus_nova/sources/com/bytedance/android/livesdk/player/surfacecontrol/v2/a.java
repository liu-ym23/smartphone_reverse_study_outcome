package com.bytedance.android.livesdk.player.surfacecontrol.v2;

import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.android.livesdkapi.view.ISurfaceControlParent;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f156177h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SurfaceControl f156178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f156179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<Object> f156180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<SurfaceControl> f156181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f156182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.player.surfacecontrol.v2.b f156183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f156184g;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.player.surfacecontrol.v2.a$a, reason: collision with other inner class name */
    public static final class C2388a {
    }

    public interface b {
        void a(a r100, int r101);
    }

    static {
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        WeakReference<Object> r100 = this.f156180c;     // Catch: Throwable -> L37
        if (r100 == null) goto L6;
        Object r101 = r100.get();     // Catch: Throwable -> L37
    L8:
        if ((r101 instanceof SurfaceView) == true) goto L10;
        r101 = null;
    L10:
        SurfaceView r102 = (SurfaceView) r101;     // Catch: Throwable -> L37
        if (r102 == null) goto L35;
        int r103 = r102.getWidth();     // Catch: Throwable -> L37
        int r104 = r102.getHeight();     // Catch: Throwable -> L37
        SurfaceControl r105 = r102.getSurfaceControl();     // Catch: Throwable -> L37
        SurfaceControl r106 = this.f156178a;     // Catch: Throwable -> L37
        if (r106 != null) goto L15;
    L17:
        boolean r107 = false;
    L18:
        if (r105 != null) goto L20;
    L22:
        boolean r108 = false;
    L23:
        if (r103 <= 0) goto L26;
        if (r104 <= 0) goto L26;
        boolean r109 = true;
    L27:
        if (r109 == false) goto L35;
        if (r107 == false) goto L35;
        if (r108 == false) goto L35;
        SurfaceControl r110 = this.f156178a;     // Catch: Throwable -> L37
        if (r110 == null) goto L35;
        new SurfaceControl.Transaction().reparent(r110, r105).setBufferSize(r110, r103, r104).setVisibility(r110, true).setLayer(r110, 1).setGeometry(r110, null, null, 0).apply();     // Catch: Throwable -> L37
        this.f156181d = new WeakReference(r105);     // Catch: Throwable -> L37
        this.f156184g.a(this, 3);     // Catch: Throwable -> L37
        monitor-exit(this);
        return true;
    L26:
        r109 = false;
        goto L27
    L20:
        if (r105.isValid() != true) goto L22;
        r108 = true;
        goto L23
    L15:
        if (r106.isValid() != true) goto L17;
        r107 = true;
    L35:
        monitor-exit(this);
        return false;
    L6:
        r101 = null;
    L37:
        th = move-exception;
        throw th;
    }

    public final synchronized void d() {
        monitor-enter(this);
        SurfaceControl r100 = this.f156178a;     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        r100.release();     // Catch: Throwable -> L12
    L6:
        Surface r101 = this.f156179b;     // Catch: Throwable -> L12
        if (r101 == null) goto L9;
        r101.release();     // Catch: Throwable -> L12
    L9:
        this.f156179b = null;     // Catch: Throwable -> L12
        this.f156178a = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public a(SurfaceControlPool.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f156184g = r100;
        this.f156183f = new com.bytedance.android.livesdk.player.surfacecontrol.v2.b(this);
    }

    public static void b(a r100, SurfaceView r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        WeakReference<Object> r102 = r100.f156180c;
        if (r102 == null) goto L5;
        Object r103 = r102.get();
    L6:
        boolean r104 = !Intrinsics.areEqual(r101, r103);
        WeakReference<Object> r105 = r100.f156180c;
        if (r105 == null) goto L9;
        Object r106 = r105.get();
    L11:
        if ((r106 instanceof SurfaceView) == true) goto L13;
        r106 = null;
    L13:
        SurfaceView r107 = (SurfaceView) r106;
        WeakReference<Object> r108 = new WeakReference(r101);
        r100.f156180c = r108;
        Object r109 = r108.get();
        if ((r109 instanceof SurfaceView) == true) goto L16;
        r109 = null;
    L16:
        SurfaceView r110 = (SurfaceView) r109;
        if (r110 == null) goto L21;
        SurfaceHolder r111 = r110.getHolder();
        if (r111 == null) goto L21;
        r111.removeCallback(r100.f156183f);
    L21:
        r101.getHolder().addCallback(r100.f156183f);
        if ((!Intrinsics.areEqual(r107, r101)) == false) goto L31;
        if ((r107 instanceof ISurfaceControlParent) == true) goto L26;
        Object r112 = null;
    L27:
        ISurfaceControlParent r113 = (ISurfaceControlParent) r112;
        if (r113 == null) goto L31;
        r113.onSurfaceControlDetach(true);
        goto L31
    L26:
        r112 = r107;
    L31:
        if (r100.a() == true) goto L33;
        return;
    L33:
        if ((r101 instanceof ISurfaceControlParent) == true) goto L35;
        Object r114 = null;
    L36:
        ISurfaceControlParent r115 = (ISurfaceControlParent) r114;
        if (r115 == null) goto L39;
        r115.onSurfaceControlAttached(r100.f156178a);
    L39:
        if (r107 == null) goto L41;
        r107.setTag(SurfaceControlPool.b(), null);
    L41:
        r101.setTag(SurfaceControlPool.b(), r100);
        return;
    L35:
        r114 = r101;
        goto L36
    L9:
        r106 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }

    public final void c(int r100, int r101) {
        Intrinsics.checkNotNullParameter("live-player-surface", "name");
        SurfaceControl r102 = this.f156178a;
        if (r102 != null) goto L5;
    L10:
        SurfaceControl.Builder r103 = new SurfaceControl.Builder();
        StringBuilder r104 = new StringBuilder("live-player-surface-");
        int r105 = f156177h;
        f156177h = r105 + 1;
        r104.append(r105);
        this.f156178a = r103.setName(r104.toString()).setBufferSize(r100, r101).build();
        return;
    L5:
        if (r102.isValid() != true) goto L10;
        SurfaceControl r106 = this.f156178a;
        if (r106 == null) goto L12;
        new SurfaceControl.Transaction().setBufferSize(r106, r100, r101).apply();
        return;
    }
}
