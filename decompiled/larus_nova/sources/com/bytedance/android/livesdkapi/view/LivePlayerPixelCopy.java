package com.bytedance.android.livesdkapi.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import android.view.ViewParent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/LivePlayerPixelCopy;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerPixelCopy {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/LivePlayerPixelCopy$Companion;", "", "()V", "request", "", "surfaceView", "Landroid/view/SurfaceView;", "dest", "Landroid/graphics/Bitmap;", "listener", "Landroid/view/PixelCopy$OnPixelCopyFinishedListener;", "listenerThread", "Landroid/os/Handler;", "srcRect", "Landroid/graphics/Rect;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void request(SurfaceView r100, Bitmap r101, PixelCopy.OnPixelCopyFinishedListener r102, Handler r103) {
            Intrinsics.checkNotNullParameter(r100, "surfaceView");
            Intrinsics.checkNotNullParameter(r101, "dest");
            Intrinsics.checkNotNullParameter(r102, "listener");
            Intrinsics.checkNotNullParameter(r103, "listenerThread");
            ViewParent r104 = r100.getParent();
            Surface r105 = null;
            if ((r104 instanceof LivePlayerView) == true) goto L5;
            r104 = null;
        L5:
            LivePlayerView r106 = (LivePlayerView) r104;
            if (r106 == null) goto L10;
            ILivePlayerClient r107 = r106.getClient();
            if (r107 == null) goto L10;
            SurfaceControl r108 = r107.getSurfaceControl();
        L11:
            if (r108 == null) goto L13;
            boolean r109 = true;
        L14:
            if (r109 == false) goto L23;
            ViewParent r110 = r100.getParent();
            if ((r110 instanceof LivePlayerView) == true) goto L18;
            r110 = null;
        L18:
            LivePlayerView r111 = (LivePlayerView) r110;
            if (r111 == null) goto L23;
            ILivePlayerClient r112 = r111.getClient();
            if (r112 == null) goto L23;
            r105 = r112.getPlayerSurface();
        L23:
            if (r109 == false) goto L26;
            if (r105 == null) goto L26;
            PixelCopy.request(r105, r101, r102, r103);
            return;
        L26:
            PixelCopy.request(r100, r101, r102, r103);
            return;
        L13:
            r109 = false;
        L10:
            r108 = null;
            goto L11
        }

        public final void request(SurfaceView r100, Rect r101, Bitmap r102, PixelCopy.OnPixelCopyFinishedListener r103, Handler r104) {
            Intrinsics.checkNotNullParameter(r100, "surfaceView");
            Intrinsics.checkNotNullParameter(r102, "dest");
            Intrinsics.checkNotNullParameter(r103, "listener");
            Intrinsics.checkNotNullParameter(r104, "listenerThread");
            ViewParent r105 = r100.getParent();
            Surface r106 = null;
            if ((r105 instanceof LivePlayerView) == true) goto L5;
            r105 = null;
        L5:
            LivePlayerView r107 = (LivePlayerView) r105;
            if (r107 == null) goto L10;
            ILivePlayerClient r108 = r107.getClient();
            if (r108 == null) goto L10;
            SurfaceControl r109 = r108.getSurfaceControl();
        L11:
            if (r109 == null) goto L13;
            boolean r110 = true;
        L14:
            if (r110 == false) goto L23;
            ViewParent r111 = r100.getParent();
            if ((r111 instanceof LivePlayerView) == true) goto L18;
            r111 = null;
        L18:
            LivePlayerView r112 = (LivePlayerView) r111;
            if (r112 == null) goto L23;
            ILivePlayerClient r113 = r112.getClient();
            if (r113 == null) goto L23;
            r106 = r113.getPlayerSurface();
        L23:
            if (r110 == false) goto L26;
            if (r106 == null) goto L26;
            PixelCopy.request(r106, r101, r102, r103, r104);
            return;
        L26:
            PixelCopy.request(r100, r101, r102, r103, r104);
            return;
        L13:
            r110 = false;
        L10:
            r109 = null;
            goto L11
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LivePlayerPixelCopy() {
    }
}
