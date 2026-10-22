package com.byted.cast.sdk;

import android.opengl.GLSurfaceView;
import com.byted.cast.engine.VoipVideoRender;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes43.dex */
public final class RTCVideoRender extends VoipVideoRender {

    /* JADX INFO: renamed from: com.byted.cast.sdk.RTCVideoRender$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ContextFactory implements GLSurfaceView.EGLContextFactory {
        private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private ContextFactory() {
        }

        public /* synthetic */ ContextFactory(AnonymousClass1 r100) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
            return r100.eglCreateContext(r101, r102, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            r100.eglDestroyContext(r101, r102);
        }
    }

    public interface StatusListener {
        void onVideoSimulcasted(int r100);

        void onVideoStatusChanged(boolean r100);
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public boolean clearSource() {
        return super.clearSource();
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public RTCMediaKind getMediaKind() {
        return super.getMediaKind();
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public String getUserId() {
        return super.getUserId();
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public boolean isSetSource() {
        return super.isSetSource();
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public boolean isSubscribed() {
        return super.isSubscribed();
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public boolean subscribe() {
        return super.subscribe();
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public boolean unsubscribe() {
        return super.unsubscribe();
    }

    public RTCVideoRender(GLSurfaceView r100, String r101) {
        super(r100, r101);
        r100.setEGLContextFactory(new ContextFactory(null));
        r100.setEGLContextClientVersion(2);
        r100.setRenderer(this);
        r100.setRenderMode(0);
    }

    @Override // com.byted.cast.engine.VoipVideoRender
    public boolean setSource(String r100, RTCMediaKind r101, StatusListener r102) {
        return super.setSource(r100, r101, r102);
    }
}
