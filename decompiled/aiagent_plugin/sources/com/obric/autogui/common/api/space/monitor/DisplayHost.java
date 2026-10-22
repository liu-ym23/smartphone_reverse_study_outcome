package com.obric.autogui.common.api.space.monitor;

import android.view.SurfaceView;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DisplayHost.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DisplayHost {

    /* JADX INFO: compiled from: DisplayHost.kt */
    public static final class Mirror extends DisplayHost {
        private final View view;

        public static /* synthetic */ Mirror copy$default(Mirror r0, View r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.view;
        L6:
            return r0.copy(r1);
        }

        public final View component1() {
            return this.view;
        }

        public final Mirror copy(View r1) {
            o.e(r1, "view");
            return new Mirror(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Mirror.class) == true) goto L8;
            return false;
        L8:
            Mirror r6 = (Mirror) ZeusTransformUtils.preCheckCast(r5, Mirror.class, "com.obric.aiagent.plugin");
            if (o.a(this.view, r6.view) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.view.hashCode();
        }

        public String toString() {
            return "Mirror(view=" + this.view + ')';
        }

        public Mirror(View r2) {
            o.e(r2, "view");
            super(null);
            this.view = r2;
        }

        public final View getView() {
            return this.view;
        }
    }

    /* JADX INFO: compiled from: DisplayHost.kt */
    public static final class Surface extends DisplayHost {
        private final SurfaceView surfaceView;

        public static /* synthetic */ Surface copy$default(Surface r0, SurfaceView r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.surfaceView;
        L6:
            return r0.copy(r1);
        }

        public final SurfaceView component1() {
            return this.surfaceView;
        }

        public final Surface copy(SurfaceView r1) {
            o.e(r1, "surfaceView");
            return new Surface(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Surface.class) == true) goto L8;
            return false;
        L8:
            Surface r6 = (Surface) ZeusTransformUtils.preCheckCast(r5, Surface.class, "com.obric.aiagent.plugin");
            if (o.a(this.surfaceView, r6.surfaceView) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.surfaceView.hashCode();
        }

        public String toString() {
            return "Surface(surfaceView=" + this.surfaceView + ')';
        }

        public Surface(SurfaceView r2) {
            o.e(r2, "surfaceView");
            super(null);
            this.surfaceView = r2;
        }

        public final SurfaceView getSurfaceView() {
            return this.surfaceView;
        }
    }

    public /* synthetic */ DisplayHost(h r1) {
        this();
    }

    private DisplayHost() {
    }
}
