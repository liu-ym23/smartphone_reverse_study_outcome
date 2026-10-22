package com.byted.cast.sdk.gl.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.byted.cast.sdk.gl.drawer.TextureDrawer;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public class GLUtils {
    public static final Object GL_RENDER_FENCE = null;
    private static int GL_VERSION = 2;
    public static final float[] IDENTITY_MATRIX = null;
    private static final String TAG = "GLUtils";
    public static final String TEXTURE_2D_FS = "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n";
    public static float[] TEXTURE_COORDINATE = null;
    public static float[] TEXTURE_COORDINATE_VERTICAL_FLIP = null;
    public static final String TEXTURE_EXTERNAL_FS = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n";
    public static final String TEXTURE_VS = "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n";
    public static float[] VERTEX_POSITION;

    public static final enum DISPLAY_MODE extends Enum<DISPLAY_MODE> {
        private static final /* synthetic */ DISPLAY_MODE[] $VALUES = null;
        public static final DISPLAY_MODE FIT = null;
        public static final DISPLAY_MODE FULL = null;

        static {
            DISPLAY_MODE r100 = new DISPLAY_MODE("FIT", 0);
            FIT = r100;
            DISPLAY_MODE r101 = new DISPLAY_MODE("FULL", 1);
            FULL = r101;
            $VALUES = new DISPLAY_MODE[]{r100, r101};
        }

        public static DISPLAY_MODE[] values() {
            return (DISPLAY_MODE[]) $VALUES.clone();
        }

        public static DISPLAY_MODE valueOf(String r100) {
            return (DISPLAY_MODE) a.a(DISPLAY_MODE.class, r100);
        }

        private DISPLAY_MODE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public GLUtils() {
    }

    public static int createFBO() {
        int[] r100 = new int[1];
        GLES20.glGenFramebuffers(1, r100, 0);
        return r100[0];
    }

    public static int createTexture() {
        return createTextures(1)[0];
    }

    public static int createVAO() {
        int[] r100 = new int[1];
        GLES30.glGenVertexArrays(1, r100, 0);
        return r100[0];
    }

    static {
        GL_RENDER_FENCE = new Object();
        VERTEX_POSITION = new float[]{-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        TEXTURE_COORDINATE = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        TEXTURE_COORDINATE_VERTICAL_FLIP = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        float[] r100 = new float[16];
        IDENTITY_MATRIX = r100;
        Matrix.setIdentityM(r100, 0);
    }

    public static boolean isGL3() {
        if (GL_VERSION <= 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static FloatBuffer createFloatBuffer(float[] r100) {
        FloatBuffer r101 = ByteBuffer.allocateDirect(r100.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r101.put(r100).position(0);
        return r101;
    }

    public static ShortBuffer createShortBuffer(short[] r100) {
        ShortBuffer r101 = ByteBuffer.allocateDirect(r100.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        r101.put(r100).position(0);
        return r101;
    }

    public static int[] createTextures(int r100) {
        int[] r101 = new int[r100];
        GLES20.glGenTextures(r100, r101, 0);
        return r101;
    }

    public static boolean isSupportEGL14(String r100) {
        Logger r101 = LoggerManager.getLogger(r100);
        EGL14.eglGetCurrentContext();     // Catch: NoClassDefFoundError -> L6
        return true;
    L6:
        r101.i("GLUtils", "EGL14 isn't supported on this platform, change to use EGL10.");
        return false;
    }

    public static boolean checkGlError(String r100, String r101) {
        Logger r102 = LoggerManager.getLogger(r101);
        int r103 = GLES20.glGetError();
        if (r103 == 0) goto L6;
        r102.e("GLUtils", r100 + ": glError 0x" + Integer.toHexString(r103));
        return false;
    L6:
        return true;
    }

    public static int loadTextureByBitmap(Bitmap r100, String r101) {
        Logger r102 = LoggerManager.getLogger(r101);
        if (r100 != null) goto L6;
        r102.e("GLUtils", "loadTextureByBitmap，load bitmap error, check the file path is correct!");
        return 0;
    L6:
        int[] r103 = new int[1];
        GLES20.glGenTextures(1, r103, 0);
        int r104 = r103[0];
        if (r104 == 0) goto L10;
        GLES20.glBindTexture(3553, r104);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        android.opengl.GLUtils.texImage2D(3553, 0, r100, 0);
    L10:
        if (r103[0] != 0) goto L13;
        r102.e("GLUtils", "loadTextureByBitmap, the texture id is 0!");
    L13:
        return r103[0];
    }

    private static boolean validateProgram(int r100, String r101) {
        Logger r102 = LoggerManager.getLogger(r101);
        GLES20.glValidateProgram(r100);
        int[] r103 = new int[1];
        GLES20.glGetProgramiv(r100, 35715, r103, 0);
        r102.d("GLUtils", "Results of validating program: " + r103[0] + "\nLog:" + GLES20.glGetProgramInfoLog(r100));
        if (r103[0] != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static int compileShader(int r100, String r101, String r102) {
        Logger r103 = LoggerManager.getLogger(r102);
        int r104 = GLES20.glCreateShader(r100);
        GLES20.glShaderSource(r104, r101);
        GLES20.glCompileShader(r104);
        int[] r105 = new int[1];
        GLES20.glGetShaderiv(r104, 35713, r105, 0);
        if (r105[0] != 0) goto L6;
        GLES20.glDeleteShader(r104);
        r103.e("GLUtils", "Compilation of shader failed.");
        return 0;
    L6:
        return r104;
    }

    public static TextureDrawer createAndSetupTexDrawer(int r100, int r101, String r102) {
        TextureDrawer r103 = new TextureDrawer(r102);
        r103.setViewportSize(r100, r101);
        r103.setup();
        return r103;
    }

    public static int createProgram(String r100, String r101, String r102) {
        Logger r103 = LoggerManager.getLogger(r102);
        int r104 = compileShader(35633, r100, r102);
        int r105 = compileShader(35632, r101, r102);
        if (r104 == 0) goto L14;
        if (r105 == 0) goto L14;
        int r106 = GLES20.glCreateProgram();
        GLES20.glAttachShader(r106, r104);
        GLES20.glAttachShader(r106, r105);
        GLES20.glLinkProgram(r106);
        int[] r107 = new int[1];
        GLES20.glGetProgramiv(r106, 35714, r107, 0);
        if (r107[0] != 0) goto L11;
        GLES20.glDeleteProgram(r106);
        r103.d("GLUtils", "Linking of program failed !");
        return -1;
    L11:
        if (validateProgram(r106, r102) == true) goto L13;
        return -1;
    L13:
        return r106;
    L14:
        return -1;
    }

    private static Bitmap getResizedBitmap(Bitmap r100, int r101, int r102) {
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        android.graphics.Matrix r105 = new android.graphics.Matrix();
        r105.postScale(r101 / r103, r102 / r104);
        Bitmap r106 = Bitmap.createBitmap(r100, 0, 0, r103, r104, r105, false);
        r100.recycle();
        return r106;
    }

    public static int createImageTexture(ByteBuffer r110, int r111, int r112, int r113, String r114) {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        int r101 = r100[0];
        checkGlError("glGenTextures", r114);
        GLES20.glBindTexture(3553, r101);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        checkGlError("loadImageTexture", r114);
        GLES20.glTexImage2D(3553, 0, r113, r111, r112, 0, r113, 5121, r110);
        checkGlError("loadImageTexture", r114);
        return r101;
    }

    public static Bitmap loadSuitableBitmap(Context r100, Uri r101, int r110, int r111, String r112) {
        Logger r113 = LoggerManager.getLogger(r112);
        if (r100 == null) goto L47;
        if (r101 == null) goto L47;
        InputStream r102 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);     // Catch: FileNotFoundException -> L44
        if (r110 <= 0) goto L38;
        if (r111 <= 0) goto L38;
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        int r104 = 1;
        r103.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r102, null, r103);
        r102.close();     // Catch: IOException -> L13
    L15:
        r103.inJustDecodeBounds = false;
        int r105 = r103.outWidth;
        int r106 = r103.outHeight;
        r113.i("GLUtils", "loadSuitableBitmap, bitmap size = " + r105 + "x" + r106);
        int r107 = r105 / r110;
        int r108 = r106 / r111;
        if (r107 < r108) goto L19;
        r107 = r108;
    L19:
        if (r107 <= 0) goto L22;
        r104 = r107;
    L22:
        r103.inSampleSize = r104;
        r113.i("GLUtils", "loadSuitableBitmap, inSampleSize = " + r104);
        InputStream r109 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);     // Catch: FileNotFoundException -> L35
        Bitmap r114 = BitmapFactory.decodeStream(r109, null, r103);
        r109.close();     // Catch: IOException -> L27
    L30:
        if (r114.getWidth() != r110) goto L34;
        if (r114.getHeight() != r111) goto L34;
        return r114;
    L34:
        return getResizedBitmap(r114, r110, r111);
    L27:
        e = move-exception;
        e.printStackTrace();
    L35:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
    L38:
        Bitmap r115 = BitmapFactory.decodeStream(r102);
        r102.close();     // Catch: IOException -> L41
    L43:
        return r115;
    L41:
        e = move-exception;
        e.printStackTrace();
    L44:
        e = move-exception;
        e.printStackTrace();
        r113.e("GLUtils", "loadSuitableBitmap error : parsing uri error!");
        return null;
    L47:
        r113.e("GLUtils", "loadSuitableBitmap error : context and uri can'tt be null!");
        return null;
    }
}
