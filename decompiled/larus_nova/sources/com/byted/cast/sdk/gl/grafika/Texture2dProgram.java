package com.byted.cast.sdk.gl.grafika;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public class Texture2dProgram {
    private static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    private static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final int KERNEL_SIZE = 9;
    private static final String TAG = "Grafika";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private float mColorAdjust;
    private float[] mKernel;
    private int mProgramHandle;
    private ProgramType mProgramType;
    private float[] mTexOffset;
    private int mTextureTarget;
    private int maPositionLoc;
    private int maTextureCoordLoc;
    private int muColorAdjustLoc;
    private int muKernelLoc;
    private int muMVPMatrixLoc;
    private int muTexMatrixLoc;
    private int muTexOffsetLoc;

    /* JADX INFO: renamed from: com.byted.cast.sdk.gl.grafika.Texture2dProgram$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$sdk$gl$grafika$Texture2dProgram$ProgramType = null;

        static {
            int[] r100 = new int[ProgramType.values().length];
            $SwitchMap$com$byted$cast$sdk$gl$grafika$Texture2dProgram$ProgramType = r100;
            r100[ProgramType.TEXTURE_2D.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$byted$cast$sdk$gl$grafika$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$byted$cast$sdk$gl$grafika$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_BW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$byted$cast$sdk$gl$grafika$Texture2dProgram$ProgramType[ProgramType.TEXTURE_EXT_FILT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum ProgramType extends Enum<ProgramType> {
        private static final /* synthetic */ ProgramType[] $VALUES = null;
        public static final ProgramType TEXTURE_2D = null;
        public static final ProgramType TEXTURE_EXT = null;
        public static final ProgramType TEXTURE_EXT_BW = null;
        public static final ProgramType TEXTURE_EXT_FILT = null;

        static {
            ProgramType r100 = new ProgramType("TEXTURE_2D", 0);
            TEXTURE_2D = r100;
            ProgramType r101 = new ProgramType("TEXTURE_EXT", 1);
            TEXTURE_EXT = r101;
            ProgramType r102 = new ProgramType("TEXTURE_EXT_BW", 2);
            TEXTURE_EXT_BW = r102;
            ProgramType r103 = new ProgramType("TEXTURE_EXT_FILT", 3);
            TEXTURE_EXT_FILT = r103;
            $VALUES = new ProgramType[]{r100, r101, r102, r103};
        }

        public static ProgramType[] values() {
            return (ProgramType[]) $VALUES.clone();
        }

        public static ProgramType valueOf(String r100) {
            return (ProgramType) a.a(ProgramType.class, r100);
        }

        private ProgramType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int createTextureObject() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        GlUtil.checkGlError("glGenTextures");
        int r101 = r100[0];
        GLES20.glBindTexture(this.mTextureTarget, r101);
        GlUtil.checkGlError("glBindTexture " + r101);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        return r101;
    }

    public void release() {
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public ProgramType getProgramType() {
        return this.mProgramType;
    }

    public Texture2dProgram(ProgramType r100) {
        this.mKernel = new float[9];
        this.mProgramType = r100;
        int r101 = AnonymousClass1.$SwitchMap$com$byted$cast$sdk$gl$grafika$Texture2dProgram$ProgramType[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.mTextureTarget = 3553;
        this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_2D);
    L17:
        if (this.mProgramHandle == 0) goto L24;
        r100.toString();
        int r102 = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        this.maPositionLoc = r102;
        GlUtil.checkLocation(r102, "aPosition");
        int r103 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        this.maTextureCoordLoc = r103;
        GlUtil.checkLocation(r103, "aTextureCoord");
        int r104 = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
        this.muMVPMatrixLoc = r104;
        GlUtil.checkLocation(r104, "uMVPMatrix");
        int r105 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        this.muTexMatrixLoc = r105;
        GlUtil.checkLocation(r105, "uTexMatrix");
        int r106 = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
        this.muKernelLoc = r106;
        if (r106 >= 0) goto L21;
        this.muKernelLoc = -1;
        this.muTexOffsetLoc = -1;
        this.muColorAdjustLoc = -1;
        return;
    L21:
        int r107 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
        this.muTexOffsetLoc = r107;
        GlUtil.checkLocation(r107, "uTexOffset");
        int r108 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
        this.muColorAdjustLoc = r108;
        GlUtil.checkLocation(r108, "uColorAdjust");
        setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
        setTexSize(256, 256);
        return;
    L24:
        throw new RuntimeException("Unable to create program");
    L5:
        if (r101 != 2) goto L7;
        this.mTextureTarget = 36197;
        this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT);
        goto L17
    L7:
        if (r101 != 3) goto L9;
        this.mTextureTarget = 36197;
        this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_BW);
        goto L17
    L9:
        if (r101 != 4) goto L12;
        this.mTextureTarget = 36197;
        this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_FILT);
        goto L17
    L12:
        throw new RuntimeException("Unhandled type " + r100);
    }

    public void setKernel(float[] r100, float r101) {
        if (r100.length != 9) goto L7;
        System.arraycopy(r100, 0, this.mKernel, 0, 9);
        this.mColorAdjust = r101;
        return;
    L7:
        throw new IllegalArgumentException("Kernel size is " + r100.length + " vs. 9");
    }

    public void setTexSize(int r100, int r101) {
        float r102 = 1.0f / r100;
        float r103 = 1.0f / r101;
        float r104 = -r102;
        float r105 = -r103;
        this.mTexOffset = new float[]{r104, r105, 0.0f, r105, r102, r105, r104, 0.0f, 0.0f, 0.0f, r102, 0.0f, r104, r103, 0.0f, r103, r102, r103};
    }

    public void draw(float[] r110, FloatBuffer r111, int r112, int r113, int r114, int r115, float[] r116, FloatBuffer r117, int r210, int r211) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureTarget, r210);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, r110, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, r116, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, r114, 5126, false, r115, r111);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, 5126, false, r211, r117);
        GlUtil.checkGlError("glVertexAttribPointer");
        int r100 = this.muKernelLoc;
        if (r100 < 0) goto L5;
        GLES20.glUniform1fv(r100, 9, this.mKernel, 0);
        GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
        GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
    L5:
        GLES20.glDrawArrays(5, r112, r113);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }
}
