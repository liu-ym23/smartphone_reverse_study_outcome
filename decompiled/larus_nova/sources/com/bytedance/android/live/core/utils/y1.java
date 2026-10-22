package com.bytedance.android.live.core.utils;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.LivePlayerPixelCopy;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class y1 {

    public static final class a implements PixelCopy.OnPixelCopyFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f66430a = null;

        static {
            f66430a = new a();
        }

        public a() {
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int r100) {
        }
    }

    public static final class b extends Handler {
        public b(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            Runnable r102 = r100.getCallback();
            if (r102 == null) goto L7;
            r102.run();
            return true;
        L7:
            return true;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final Bitmap a(IRenderView r100, ILivePlayerClient r101) {
        Intrinsics.checkNotNullParameter(r100, "renderView");
        if ((r100 instanceof SurfaceRenderView) == true) goto L5;
    L17:
        if (r101 != null) goto L21;
        return null;
    L21:
        return r101.getBitmap();
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L17;
        SurfaceView r102 = (SurfaceView) r100;
        SurfaceHolder r103 = r102.getHolder();
        if (r103 == null) goto L17;
        if (r103.getSurface() == null) goto L17;
        if (r103.getSurface().isValid() == false) goto L17;
        int r104 = r102.getWidth();
        int r105 = r102.getHeight();
        if (r104 <= 0) goto L17;
        if (r105 <= 0) goto L17;
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.RGB_565);
        LivePlayerPixelCopy.Companion.request(r102, r106, a.f66430a, new b(Looper.getMainLooper()));
        return r106;
    }
}
