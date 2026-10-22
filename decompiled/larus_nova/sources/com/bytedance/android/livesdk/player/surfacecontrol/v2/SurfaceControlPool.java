package com.bytedance.android.livesdk.player.surfacecontrol.v2;

import android.view.SurfaceControl;
import android.view.SurfaceView;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class SurfaceControlPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f156171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f156172b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f156173c = null;

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f156174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f156175b;

        public T a() {
            int r100 = this.f156175b;
            if (r100 <= 0) goto L10;
            int r101 = r100 - 1;
            Object[] r102 = this.f156174a;
            T r103 = (T) r102[r101];
            if (r103 == null) goto L9;
            r102[r101] = null;
            this.f156175b = r100 - 1;
            return r103;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L10:
            return null;
        }

        public a(int r100) {
            if (r100 <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L10;
            this.f156174a = new Object[r100];
            return;
        L10:
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        L5:
            r101 = false;
            goto L6
        }

        public int b(T r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            int r101 = this.f156175b;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            if (this.f156174a[r102] == r100) goto L6;
            r102 = r102 + 1;
            goto L3
        L6:
            return r102;
        L8:
            return -1;
        }

        public boolean c(T r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            if (b(r100) < 0) goto L5;
            return true;
        L5:
            int r101 = this.f156175b;
            Object[] r102 = this.f156174a;
            if (r101 >= r102.length) goto L9;
            r102[r101] = r100;
            this.f156175b = r101 + 1;
            return true;
        L9:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean d(com.bytedance.android.livesdk.player.surfacecontrol.v2.a r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            int r101 = b(r100);
            if (r101 >= 0) goto L6;
            return false;
        L6:
            int r102 = this.f156175b - 1;
        L7:
            if (r101 >= r102) goto L9;
            Object[] r103 = this.f156174a;
            int r104 = r101 + 1;
            r103[r101] = r103[r104];
            r101 = r104;
            goto L7
        L9:
            Object[] r105 = this.f156174a;
            int r106 = this.f156175b - 1;
            r105[r106] = null;
            this.f156175b = r106;
            return true;
        }
    }

    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f156176c;

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.v2.SurfaceControlPool.a
        public final T a() {
            Object r100 = this.f156176c;
            monitor-enter(r100);
            T r101 = (T) super.a();
            monitor-exit(r100);
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public b(int r100) {
            super(r100);
            this.f156176c = new Object();
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.v2.SurfaceControlPool.a
        public final int b(T r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            Object r101 = this.f156176c;
            monitor-enter(r101);
            int r102 = super.b(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.v2.SurfaceControlPool.a
        public final boolean c(T r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            Object r101 = this.f156176c;
            monitor-enter(r101);
            boolean r102 = super.c(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return r102;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.v2.SurfaceControlPool.a
        public final boolean d(com.bytedance.android.livesdk.player.surfacecontrol.v2.a r100) {
            Intrinsics.checkNotNullParameter(r100, "instance");
            Object r101 = this.f156176c;
            monitor-enter(r101);
            boolean r102 = super.d(r100);     // Catch: Throwable -> L7
            monitor-exit(r101);
            return r102;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class c implements com.bytedance.android.livesdk.player.surfacecontrol.v2.a.b {
        public c() {
        }

        @Override // com.bytedance.android.livesdk.player.surfacecontrol.v2.a.b
        public final void a(com.bytedance.android.livesdk.player.surfacecontrol.v2.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "surfaceControlObj");
            if (r101 != 2) goto L5;
        L6:
            monitor-enter(r100);
            WeakReference<SurfaceControl> r102 = r100.f156181d;     // Catch: Throwable -> L25
            if (r102 == null) goto L10;
            SurfaceControl r103 = r102.get();     // Catch: Throwable -> L25
        L12:
            if (r103 != null) goto L16;
            if (r100.f156182e == true) goto L16;
            boolean r104 = true;
        L17:
            monitor-exit(r100);
            if (r104 == false) goto L31;
            a r105 = (a) SurfaceControlPool.f156171a.getValue();
            if (r105 != null) goto L22;
        L23:
            r100.d();
            com.bytedance.android.live.player.utils.b.g("SurfaceControlManager", "releaseSurfaceControlObj: " + r100);
            return;
        L22:
            if (r105.c(r100) != true) goto L23;
            return;
        L31:
            return;
        L16:
            r104 = false;
            goto L17
        L10:
            r103 = null;
        L25:
            th = move-exception;
            throw th;
        L5:
            if (r101 == 4) goto L6;
        }
    }

    public static int b() {
        return ((Number) f156172b.getValue()).intValue();
    }

    static {
        f156171a = LazyKt.lazy(SurfaceControlPool$unUsedPool$2.INSTANCE);
        f156172b = LazyKt.lazy(SurfaceControlPool$tagId$2.INSTANCE);
        f156173c = new c();
    }

    public static com.bytedance.android.livesdk.player.surfacecontrol.v2.a a(SurfaceView r100) {
        com.bytedance.android.livesdk.player.surfacecontrol.v2.a r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag(b());
    L7:
        if ((r102 instanceof com.bytedance.android.livesdk.player.surfacecontrol.v2.a) == false) goto L30;
        Object r103 = r100.getTag(b());
        if ((r103 instanceof com.bytedance.android.livesdk.player.surfacecontrol.v2.a) == true) goto L11;
        r103 = null;
    L11:
        com.bytedance.android.livesdk.player.surfacecontrol.v2.a r104 = (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) r103;
        if (r104 == null) goto L30;
        if (r104.f156182e == true) goto L30;
        monitor-enter(r104);
        SurfaceControl r105 = r104.f156178a;     // Catch: Throwable -> L27
        monitor-exit(r104);
        if (r105 == null) goto L30;
        if (r105.isValid() != true) goto L30;
        a r106 = (a) f156171a.getValue();
        if (r106 != null) goto L24;
    L26:
        return r104;
    L24:
        if (r106.d(r104) != true) goto L26;
        com.bytedance.android.live.player.utils.b.g("SurfaceControlManager", "removeSurfaceControlObj: " + r104);
    L27:
        th = move-exception;
        throw th;
    L30:
        a r107 = (a) f156171a.getValue();
        if (r107 == null) goto L33;
        r101 = (com.bytedance.android.livesdk.player.surfacecontrol.v2.a) r107.a();
    L33:
        com.bytedance.android.live.player.utils.b.g("SurfaceControlManager", "allocSurfaceControlObj: " + r101);
        if (r101 == null) goto L36;
        return r101;
    L36:
        return new com.bytedance.android.livesdk.player.surfacecontrol.v2.a(f156173c);
    L5:
        r102 = null;
        goto L7
    }
}
