package com.stepos.activeview.texture;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.stepos.activeview.utils.FileUtil;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Property;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public class GLRenderDefault {
    private String fileFrag;
    private String fileVertes;
    private Context mContext;
    private String mFragmentShader;
    private float[] mMVPMatrix;
    private int mProgram;
    private int mTextureUniformHandle;
    private FloatBuffer mVertexBuffer;
    private String mVertexShader;
    private int maPositionHandle;
    private int muMVPMatrixHandle;
    private int muTimeHandle;
    private int mvResolutionHandle;
    private float[] mProjMatrix = new float[16];
    private float[] mVMatrix = new float[16];
    private float mResolutionx = Property.DEFAULT_FLOAT_VALUE;
    private float mResolutiony = Property.DEFAULT_FLOAT_VALUE;
    private float[] mMMatrix = new float[16];
    private int vCount = 0;

    public GLRenderDefault(Context context, String str, String str2, String str3) {
        this.mContext = context;
        initVertexData();
        this.fileVertes = str;
        this.fileFrag = str2;
        initShader(context, str, str2, str3);
    }

    private void initVertexData() {
        this.vCount = 6;
        float[] fArr = {-1.0f, -1.0f, Property.DEFAULT_FLOAT_VALUE, 1.0f, -1.0f, Property.DEFAULT_FLOAT_VALUE, 1.0f, 1.0f, Property.DEFAULT_FLOAT_VALUE, 1.0f, 1.0f, Property.DEFAULT_FLOAT_VALUE, -1.0f, 1.0f, Property.DEFAULT_FLOAT_VALUE, -1.0f, -1.0f, Property.DEFAULT_FLOAT_VALUE};
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(72);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.mVertexBuffer = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr);
        this.mVertexBuffer.position(0);
    }

    public void drawSelf(float f4) {
        GLES20.glUseProgram(this.mProgram);
        Matrix.setRotateM(this.mMMatrix, 0, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f, Property.DEFAULT_FLOAT_VALUE);
        Matrix.translateM(this.mMMatrix, 0, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, getFianlMatrix(this.mMMatrix), 0);
        GLES20.glUniform1i(this.mTextureUniformHandle, 0);
        GLES20.glUniform1f(this.muTimeHandle, f4);
        GLES20.glUniform2f(this.mvResolutionHandle, this.mResolutionx, this.mResolutiony);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 12, (Buffer) this.mVertexBuffer);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        GLES20.glDrawArrays(4, 0, this.vCount);
    }

    public float[] getFianlMatrix(float[] fArr) {
        float[] fArr2 = new float[16];
        this.mMVPMatrix = fArr2;
        Matrix.multiplyMM(fArr2, 0, this.mVMatrix, 0, fArr, 0);
        float[] fArr3 = this.mMVPMatrix;
        Matrix.multiplyMM(fArr3, 0, this.mProjMatrix, 0, fArr3, 0);
        return this.mMVPMatrix;
    }

    public void initShader(Context context, String str, String str2, String str3) {
        this.mVertexShader = FileUtil.loadFile(str);
        String strLoadFile = FileUtil.loadFile(str2);
        this.mFragmentShader = strLoadFile;
        int iCreateProgram = ShaderUtil.createProgram(this.mVertexShader, strLoadFile);
        this.mProgram = iCreateProgram;
        this.maPositionHandle = GLES20.glGetAttribLocation(iCreateProgram, "aPosition");
        this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
        this.muTimeHandle = GLES20.glGetUniformLocation(this.mProgram, AppSuggestStorable.COLUMN_TIME);
        this.mvResolutionHandle = GLES20.glGetUniformLocation(this.mProgram, "resolution");
        int iLoadTexture = ShaderUtil.loadTexture(this.mContext, str3);
        this.mTextureUniformHandle = GLES20.glGetUniformLocation(this.mProgram, "noise");
        GLES20.glActiveTexture(33984);
        GLES20.glUniform1i(this.mTextureUniformHandle, 0);
        GLES20.glBindTexture(3553, iLoadTexture);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
    }

    public void setFrustumM(float f4, float f5, float f6, float f7, float f8, float f9) {
        Matrix.frustumM(this.mProjMatrix, 0, f4, f5, f6, f7, f8, f9);
    }

    public void setResolution(int i4, int i5) {
        this.mResolutionx = i4;
        this.mResolutiony = i5;
    }

    public void setViewMat(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        Matrix.setLookAtM(this.mVMatrix, 0, f4, f5, f6, f7, f8, f9, f10, f11, f12);
    }
}
