package com.byted.cast.sdk.gl.drawer;

import android.opengl.GLES20;
import com.byted.cast.sdk.gl.utils.GLUtils;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;

/* JADX INFO: loaded from: classes43.dex */
public class TextureProcessor extends TextureDrawer {
    private int mFbo;
    private Logger mLogger;
    private String mMirrorId;
    private int mOutTex;

    private void releaseOutTex() {
        int r100 = this.mOutTex;
        if (r100 == 0) goto L6;
        GLES20.glDeleteTextures(1, new int[]{r100}, 0);
        this.mOutTex = 0;
        return;
    }

    private void setupFBO() {
        this.mFbo = GLUtils.createFBO();
    }

    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public void release() {
        super.release();
        int r100 = this.mFbo;
        if (r100 == 0) goto L5;
        GLES20.glDeleteFramebuffers(1, new int[]{r100}, 0);
        this.mFbo = 0;
    L5:
        releaseOutTex();
    }

    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public boolean setup() {
        setupFBO();
        return super.setup();
    }

    public TextureProcessor(String r100) {
        super(r100);
        this.mMirrorId = r100;
        this.mLogger = LoggerManager.getLogger(r100);
    }

    public int process(int r100) {
        return process(r100, null);
    }

    private boolean setupTexture(int r100, int r101) {
        this.mOutTex = GLUtils.createImageTexture(null, r100, r101, 6408, this.mMirrorId);
        return true;
    }

    public int process(int r100, float[] r101) {
        return process(r100, r101, this.mOutTex);
    }

    @Override // com.byted.cast.sdk.gl.drawer.TextureDrawer
    public boolean setViewportSize(int r100, int r101) {
        super.setViewportSize(r100, r101);
        releaseOutTex();
        return setupTexture(r100, r101);
    }

    public int process(int r100, float[] r101, int r102) {
        GLES20.glBindFramebuffer(36160, this.mFbo);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r102, 0);
        GLES20.glClear(16384);
        draw(r100, r101);
        GLES20.glBindFramebuffer(36160, 0);
        return r102;
    }
}
