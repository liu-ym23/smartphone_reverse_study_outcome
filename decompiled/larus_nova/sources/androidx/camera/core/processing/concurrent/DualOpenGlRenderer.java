package androidx.camera.core.processing.concurrent;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.processing.OpenGlRenderer;
import androidx.camera.core.processing.ShaderProvider;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.core.processing.util.GraphicDeviceInfo;
import androidx.camera.core.processing.util.OutputSurface;
import androidx.core.util.Preconditions;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class DualOpenGlRenderer extends OpenGlRenderer {
    private static final String TAG = "DualOpenGlRenderer";
    private int mPrimaryExternalTextureId;
    private final LayoutSettings mPrimaryLayoutSettings;
    private int mSecondaryExternalTextureId;
    private final LayoutSettings mSecondaryLayoutSettings;

    @Override // androidx.camera.core.processing.OpenGlRenderer
    public void release() {
        super.release();
        this.mPrimaryExternalTextureId = -1;
        this.mSecondaryExternalTextureId = -1;
    }

    public int getTextureName(boolean r100) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        if (r100 == false) goto L6;
        return this.mPrimaryExternalTextureId;
    L6:
        return this.mSecondaryExternalTextureId;
    }

    public DualOpenGlRenderer(LayoutSettings r100, LayoutSettings r101) {
        this.mPrimaryExternalTextureId = -1;
        this.mSecondaryExternalTextureId = -1;
        this.mPrimaryLayoutSettings = r100;
        this.mSecondaryLayoutSettings = r101;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer
    public GraphicDeviceInfo init(DynamicRange r100, Map<GLUtils.InputFormat, ShaderProvider> r101) {
        GraphicDeviceInfo r102 = super.init(r100, r101);
        this.mPrimaryExternalTextureId = GLUtils.createTexture();
        this.mSecondaryExternalTextureId = GLUtils.createTexture();
        return r102;
    }

    private static float[] getTransformMatrix(Size r100, Size r101, LayoutSettings r102) {
        float[] r103 = GLUtils.create4x4IdentityMatrix();
        float[] r104 = GLUtils.create4x4IdentityMatrix();
        float[] r105 = GLUtils.create4x4IdentityMatrix();
        Matrix.scaleM(r103, 0, r100.getWidth() / r101.getWidth(), r100.getHeight() / r101.getHeight(), 1.0f);
        Matrix.translateM(r104, 0, r102.getOffsetX() / r102.getWidth(), r102.getOffsetY() / r102.getHeight(), 0.0f);
        Matrix.multiplyMM(r105, 0, r103, 0, r104, 0);
        return r105;
    }

    public void render(long r110, Surface r111, SurfaceOutput r112, SurfaceTexture r113, SurfaceTexture r114) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        OutputSurface r100 = getOutSurfaceOrThrow(r111);
        if (r100 != GLUtils.NO_OUTPUT_SURFACE) goto L9;
        r100 = createOutputSurfaceInternal(r111);
        if (r100 != null) goto L7;
        return;
    L7:
        this.mOutputSurfaceMap.put(r111, r100);
    L9:
        if (r111 == this.mCurrentSurface) goto L11;
        makeCurrent(r100.getEglSurface());
        this.mCurrentSurface = r111;
    L11:
        GLES30.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES30.glClear(16384);
        OutputSurface r101 = r100;
        renderInternal(r101, r112, r113, this.mPrimaryLayoutSettings, this.mPrimaryExternalTextureId, true);
        renderInternal(r101, r112, r114, this.mSecondaryLayoutSettings, this.mSecondaryExternalTextureId, true);
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, r100.getEglSurface(), r110);
        if (EGL14.eglSwapBuffers(this.mEglDisplay, r100.getEglSurface()) == true) goto L15;
        Logger.w(TAG, "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        removeOutputSurfaceInternal(r111, false);
        return;
    }

    private void renderInternal(OutputSurface r100, SurfaceOutput r101, SurfaceTexture r102, LayoutSettings r103, int r104, boolean r105) {
        useAndConfigureProgramWithTexture(r104);
        GLES20.glViewport(0, 0, r100.getWidth(), r100.getHeight());
        GLES20.glScissor(0, 0, r100.getWidth(), r100.getHeight());
        float[] r106 = new float[16];
        r102.getTransformMatrix(r106);
        float[] r107 = new float[16];
        r101.updateTransformMatrix(r107, r106, r105);
        GLUtils.Program2D r108 = (GLUtils.Program2D) Preconditions.checkNotNull(this.mCurrentProgram);
        if ((r108 instanceof GLUtils.SamplerShaderProgram) == false) goto L5;
        ((GLUtils.SamplerShaderProgram) r108).updateTextureMatrix(r107);
    L5:
        r108.updateTransformMatrix(getTransformMatrix(new Size((int) (r100.getWidth() * r103.getWidth()), (int) (r100.getHeight() * r103.getHeight())), new Size(r100.getWidth(), r100.getHeight()), r103));
        r108.updateAlpha(r103.getAlpha());
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        GLES20.glDisable(3042);
    }
}
