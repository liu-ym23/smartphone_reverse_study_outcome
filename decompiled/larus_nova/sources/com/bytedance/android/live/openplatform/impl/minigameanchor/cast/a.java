package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.os.Handler;
import android.view.Surface;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f85133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f85134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0.e f85135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EGL10 f85136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EGLDisplay f85137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EGLContext f85138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EGLSurface f85139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Surface f85140i;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.minigameanchor.cast.a$a, reason: collision with other inner class name */
    public static final class C1316a {
    }

    public static final class b implements h0.e.a {
        public b() {
        }
    }

    static {
    }

    public a(Surface r100) {
        Intrinsics.checkNotNullParameter(r100, "littleWindowSurface");
        this.f85140i = r100;
        this.f85132a = "CameraPreviewRenderer";
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r101 = ILiveWrappedLivePusher.a.b();
        if (r101 == null) goto L5;
        h0.e r102 = r101.newTextureFrameAvailableListener(new b());
    L6:
        this.f85135d = r102;
        FloatBuffer r103 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r103.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
        FloatBuffer r104 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r104.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f}).position(0);
        PthreadHandlerThreadV2 r105 = new PthreadHandlerThreadV2("mg_cast_camera_preview_EGLRender");
        ThreadMethodProxy.start(r105);
        this.f85133b = new Handler(r105.getLooper());
        EGL r106 = EGLContext.getEGL();
        if (r106 == null) goto L11;
        this.f85136e = (EGL10) r106;
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
    L5:
        r102 = null;
        goto L6
    }
}
