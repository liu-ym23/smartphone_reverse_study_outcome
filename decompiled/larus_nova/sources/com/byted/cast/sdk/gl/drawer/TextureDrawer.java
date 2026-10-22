package com.byted.cast.sdk.gl.drawer;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.byted.cast.sdk.gl.utils.GLUtils;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes43.dex */
public class TextureDrawer {
    private static final String TAG = "TextureDrawer";
    private float[] mCustomMVP;
    private int mDrawX;
    private int mDrawY;
    private int mHeight;
    private boolean mIsSetup;
    private Logger mLogger;
    private int mMVPMatrixLoc;
    private String mMirrorId;
    private int mProgram;
    private float mRotation;
    private int mTexCoordsLoc;
    private int mTexTransMatrixLoc;
    private float[] mTextureCoordinate;
    private int mVao;
    private int mVboTexCoords;
    private int mVboVertices;
    private float[] mVertexPosition;
    private int mVerticesLoc;
    private int mWidth;

    private void afterDraw() {
    }

    private void beforeDraw() {
    }

    public int getTextureTarget() {
        return 3553;
    }

    private boolean setupLocations() {
        this.mVerticesLoc = GLES20.glGetAttribLocation(this.mProgram, "a_pos");
        this.mTexCoordsLoc = GLES20.glGetAttribLocation(this.mProgram, "a_tex");
        this.mMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "u_mvp");
        this.mTexTransMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "u_tex_trans");
        return GLUtils.checkGlError("TextureDrawer glBindAttribLocation", this.mMirrorId);
    }

    private void setupVBO() {
        GLES20.glBindBuffer(34962, this.mVboVertices);
        GLES20.glEnableVertexAttribArray(this.mVerticesLoc);
        GLES20.glVertexAttribPointer(this.mVerticesLoc, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.mVboTexCoords);
        GLES20.glEnableVertexAttribArray(this.mTexCoordsLoc);
        GLES20.glVertexAttribPointer(this.mTexCoordsLoc, 2, 5126, false, 0, 0);
    }

    public String[] getShaderSources() {
        return new String[]{GLUtils.TEXTURE_VS, GLUtils.TEXTURE_2D_FS};
    }

    public void release() {
        int r100 = this.mProgram;
        if (r100 == 0) goto L5;
        GLES20.glDeleteProgram(r100);
        this.mProgram = 0;
    L5:
        int r101 = this.mVboVertices;
        if (r101 == 0) goto L8;
        GLES20.glDeleteBuffers(1, new int[]{r101}, 0);
        this.mVboVertices = 0;
    L8:
        int r102 = this.mVboTexCoords;
        if (r102 == 0) goto L11;
        GLES20.glDeleteBuffers(1, new int[]{r102}, 0);
        this.mVboTexCoords = 0;
    L11:
        int r103 = this.mVao;
        if (r103 == 0) goto L15;
        GLES30.glDeleteVertexArrays(1, new int[]{r103}, 0);
        this.mVao = 0;
        return;
    }

    private boolean setupBuffers() {
        float[] r100 = getVertexPosition();
        ByteBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4);
        r101.order(ByteOrder.nativeOrder());
        FloatBuffer r102 = r101.asFloatBuffer();
        r102.put(r100);
        r102.rewind();
        float[] r103 = getTextureCoordinate();
        ByteBuffer r104 = ByteBuffer.allocateDirect(r103.length * 4);
        r104.order(ByteOrder.nativeOrder());
        FloatBuffer r105 = r104.asFloatBuffer();
        r105.put(r103);
        r105.rewind();
        int[] r106 = new int[2];
        GLES20.glGenBuffers(2, r106, 0);
        int r107 = r106[0];
        this.mVboVertices = r107;
        this.mVboTexCoords = r106[1];
        GLES20.glBindBuffer(34962, r107);
        GLES20.glBufferData(34962, 32, r102, 35044);
        GLES20.glBindBuffer(34962, this.mVboTexCoords);
        GLES20.glBufferData(34962, 32, r105, 35044);
        GLES20.glBindBuffer(34962, 0);
        if (GLUtils.isGL3() == false) goto L5;
        int r108 = GLUtils.createVAO();
        this.mVao = r108;
        GLES30.glBindVertexArray(r108);
    L5:
        setupVBO();
        if (GLUtils.isGL3() == false) goto L8;
        GLES30.glBindVertexArray(0);
    L8:
        GLES20.glBindBuffer(34962, 0);
        return GLUtils.checkGlError("TextureDrawer setup VAO, VBOs.", this.mMirrorId);
    }

    private boolean setupShaders() {
        String[] r100 = getShaderSources();
        int r101 = GLUtils.createProgram(r100[0], r100[1], this.mMirrorId);
        this.mProgram = r101;
        if (r101 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean setup() {
        if (setupShaders() == true) goto L6;
        return false;
    L6:
        if (setupLocations() == true) goto L9;
        return false;
    L9:
        if (setupBuffers() == true) goto L11;
        return false;
    L11:
        this.mIsSetup = true;
        return true;
    }

    private float[] getTextureCoordinate() {
        return this.mTextureCoordinate;
    }

    private float[] getVertexPosition() {
        return this.mVertexPosition;
    }

    public int getDrawX() {
        return this.mDrawX;
    }

    public int getDrawY() {
        return this.mDrawY;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isSetup() {
        return this.mIsSetup;
    }

    public TextureDrawer(String r100) {
        this.mVertexPosition = GLUtils.VERTEX_POSITION;
        this.mTextureCoordinate = GLUtils.TEXTURE_COORDINATE;
        this.mMirrorId = r100;
        this.mLogger = LoggerManager.getLogger(r100);
    }

    public void draw(int r100) {
        draw(r100, null);
    }

    public void setRotation(float r100) {
        if (this.mCustomMVP != null) goto L5;
        this.mCustomMVP = new float[16];
    L5:
        this.mRotation = r100;
        Matrix.setIdentityM(this.mCustomMVP, 0);
        Matrix.rotateM(this.mCustomMVP, 0, r100, 0.0f, 0.0f, -1.0f);
    }

    public void setTextureCoordinate(float[] r100) {
        this.mTextureCoordinate = r100;
    }

    private void generateFitConfig(int r100, int r101) {
        this.mTextureCoordinate = GLUtils.TEXTURE_COORDINATE;
        int r102 = this.mWidth;
        float r103 = 1.0f;
        int r104 = this.mHeight;
        float r105 = (r100 * 1.0f) / r101;
        float r106 = 0.0f;
        if (r105 >= ((r102 * 1.0f) / r104)) goto L5;
        float r107 = r104 * r105;
        float r108 = 0.5f - ((r107 / r102) / 2.0f);
        this.mDrawX = (int) (r102 * r108);
        r106 = r108;
        r103 = ((r107 / r102) / 2.0f) + 0.5f;
        float r109 = 0.0f;
        float r110 = 1.0f;
    L6:
        ortho(r106, r103, r109, r110);
        return;
    L5:
        float r111 = r102 / r105;
        r109 = 0.5f - ((r111 / r104) / 2.0f);
        r110 = ((r111 / r104) / 2.0f) + 0.5f;
        this.mDrawY = (int) (r104 * r109);
        goto L6
    }

    private void generateFullConfig(int r110, int r111) {
        this.mVertexPosition = GLUtils.VERTEX_POSITION;
        float r100 = (this.mWidth * 1.0f) / this.mHeight;
        float r101 = r110;
        float r102 = r111;
        if (((r101 * 1.0f) / r102) >= r100) goto L5;
        float r103 = ((r102 - (r101 / r100)) / 2.0f) / r102;
        float r104 = 1.0f - r103;
        this.mTextureCoordinate = new float[]{0.0f, r103, 0.0f, r104, 1.0f, r103, 1.0f, r104};
        return;
    L5:
        float r105 = ((r101 - (r102 * r100)) / 2.0f) / r101;
        float r106 = 1.0f - r105;
        this.mTextureCoordinate = new float[]{r105, 0.0f, r105, 1.0f, r106, 0.0f, r106, 1.0f};
    }

    public void draw(int r100, float[] r101) {
        GLES20.glUseProgram(this.mProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(getTextureTarget(), r100);
        if (GLUtils.isGL3() == false) goto L5;
        GLES30.glBindVertexArray(this.mVao);
    L6:
        int r102 = this.mMVPMatrixLoc;
        float[] r103 = this.mCustomMVP;
        if (r103 != null) goto L10;
        r103 = GLUtils.IDENTITY_MATRIX;
    L10:
        GLES20.glUniformMatrix4fv(r102, 1, false, r103, 0);
        if (r101 != null) goto L13;
        r101 = GLUtils.IDENTITY_MATRIX;
    L13:
        GLES20.glUniformMatrix4fv(this.mTexTransMatrixLoc, 1, false, r101, 0);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        beforeDraw();
        GLES20.glDrawArrays(5, 0, 4);
        afterDraw();
        if (GLUtils.isGL3() == false) goto L16;
        GLES30.glBindVertexArray(0);
    L16:
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(getTextureTarget(), 0);
        return;
    L5:
        setupVBO();
        goto L6
    }

    public boolean setViewportSize(int r100, int r101) {
        this.mWidth = r100;
        this.mHeight = r101;
        return true;
    }

    public boolean setup(int r100, int r101, GLUtils.DISPLAY_MODE r102) {
        if (r102 != GLUtils.DISPLAY_MODE.FULL) goto L6;
        generateFullConfig(r100, r101);
    L9:
        return setup();
    L6:
        if (r102 != GLUtils.DISPLAY_MODE.FIT) goto L9;
        generateFitConfig(r100, r101);
        goto L9
    }

    private void ortho(float r210, float r211, float r212, float r213) {
        float r100 = (this.mWidth * 1.0f) / this.mHeight;
        float r101 = r100 * 2.0f;
        float r110 = (r210 * r101) - r100;
        float r102 = (r101 * r211) - r100;
        float r111 = ((r212 * 2.0f) - 1.0f) * (-1.0f);
        float r103 = ((2.0f * r213) - 1.0f) * (-1.0f);
        float[] r104 = new float[16];
        this.mCustomMVP = r104;
        Matrix.orthoM(r104, 0, -r100, r100, -1.0f, 1.0f, -1.0f, 1.0f);
        Matrix.rotateM(this.mCustomMVP, 0, this.mRotation, 0.0f, 0.0f, -1.0f);
        this.mVertexPosition = new float[]{r110, r103, r110, r111, r102, r103, r102, r111};
    }
}
