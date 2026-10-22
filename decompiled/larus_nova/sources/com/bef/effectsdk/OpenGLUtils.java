package com.bef.effectsdk;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.ParcelFileDescriptor;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class OpenGLUtils {
    private static final String FAIL_RES = null;
    private static final String HEIGHT = "\"height\"";
    public static final int NOT_INIT = -1;
    public static final int NO_TEXTURE = -1;
    public static final int ON_DRAWN = 1;
    private static final String RES = "\"res\"";
    private static final String TEXTURE_ID = "\"textureId\"";
    private static final String WIDTH = "\"width\"";

    public OpenGLUtils() {
    }

    public static int getExternalOESTextureID() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        GLES20.glBindTexture(36197, r100[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return r100[0];
    }

    public static void saveBitmap(Bitmap r100, String r101) {
    }

    static {
        FAIL_RES = String.format(Locale.US, "{%s: false}", new Object[]{RES});
    }

    public static void checkGlError(String r100) {
        int r101 = GLES20.glGetError();
        if (r101 != 0) goto L6;
        return;
    L6:
        throw new RuntimeException(r100 + ": glError 0x" + Integer.toHexString(r101));
    }

    public static Bitmap loadBitmap(String r100) {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: Throwable -> L10 Exception -> L14
    L29:
        Bitmap r103 = BitmapFactory.decodeStream(r102);     // Catch: Throwable -> L7 Exception -> L9
        r102.close();     // Catch: IOException -> L18
    L6:
        return r103;
    L7:
        th = th;
        r101 = r102;
    L11:
        if (r101 != null) goto L25;
    L13:
        throw th;
    L25:
        r101.close();     // Catch: IOException -> L19
    L15:
        if (r102 != null) goto L21;
    L17:
        return null;
    L21:
        r102.close();     // Catch: IOException -> L20
    L14:
        r102 = null;
    L10:
        th = th;
        goto L11
    }

    public static String loadTexture(String r100) {
        Bitmap r101 = BitmapFactory.decodeFile(r100);
        if (r101 == null) goto L5;
        int r102 = loadTexture(r101, -1, false);
        return String.format(Locale.US, "{%s: true, %s: %d, %s: %d, %s: %d}", new Object[]{RES, WIDTH, Integer.valueOf(r101.getWidth()), HEIGHT, Integer.valueOf(r101.getHeight()), TEXTURE_ID, Integer.valueOf(r102)});
    L5:
        return FAIL_RES;
    }

    public static int loadProgram(String r100, String r101) {
        int[] r102 = new int[1];
        int r103 = loadShader(r100, 35633);
        if (r103 != 0) goto L5;
        return 0;
    L5:
        int r104 = loadShader(r101, 35632);
        if (r104 != 0) goto L8;
        return 0;
    L8:
        int r105 = GLES20.glCreateProgram();
        GLES20.glAttachShader(r105, r103);
        GLES20.glAttachShader(r105, r104);
        GLES20.glLinkProgram(r105);
        GLES20.glGetProgramiv(r105, 35714, r102, 0);
        if (r102[0] > 0) goto L11;
        return 0;
    L11:
        GLES20.glDeleteShader(r103);
        GLES20.glDeleteShader(r104);
        return r105;
    }

    private static int loadShader(String r100, int r101) {
        int[] r102 = new int[1];
        int r103 = GLES20.glCreateShader(r101);
        GLES20.glShaderSource(r103, r100);
        GLES20.glCompileShader(r103);
        GLES20.glGetShaderiv(r103, 35713, r102, 0);
        if (r102[0] != 0) goto L6;
        GLES20.glGetShaderInfoLog(r103);
        return 0;
    L6:
        return r103;
    }

    public static int loadTexture(Bitmap r100, int r101) {
        return loadTexture(r100, r101, false);
    }

    public static int loadShader(int r100, String r101) {
        int r102 = GLES20.glCreateShader(r100);
        GLES20.glShaderSource(r102, r101);
        GLES20.glCompileShader(r102);
        return r102;
    }

    public static Bitmap loadBitmap(FileDescriptor r100, long r101, long r102) throws IOException {
        FileInputStream r103 = new AssetFileDescriptor(ParcelFileDescriptor.dup(r100), r101, r102).createInputStream();
        Bitmap r104 = BitmapFactory.decodeStream(r103);     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        r103.close();
        throw th;
    }

    public static int loadTexture(Bitmap r100, int r101, boolean r102) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int[] r103 = new int[1];
        if (r101 != (-1)) goto L8;
        GLES20.glGenTextures(1, r103, 0);
        GLES20.glBindTexture(3553, r103[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, r100, 0);
    L9:
        if (r102 == false) goto L12;
        r100.recycle();
    L12:
        return r103[0];
    L8:
        GLES20.glBindTexture(3553, r101);
        GLUtils.texImage2D(3553, 0, r100, 0);
        r103[0] = r101;
        goto L9
    }

    public static void byte2Bitmap(byte[] r100, int r101, int r102, String r103) {
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r104.eraseColor(FakePickerAvatarCreator.BLUE);
        r104.copyPixelsFromBuffer(ByteBuffer.wrap(r100));
        saveBitmap(r104, r103);
    }

    public static int initEffectTexture(int r110, int r111, int[] r112, int r113) {
        GLES20.glGenTextures(1, r112, 0);
        GLES20.glBindTexture(r113, r112[0]);
        GLES20.glTexParameterf(r113, 10240, 9729.0f);
        GLES20.glTexParameterf(r113, 10241, 9729.0f);
        GLES20.glTexParameterf(r113, 10242, 33071.0f);
        GLES20.glTexParameterf(r113, 10243, 33071.0f);
        GLES20.glTexImage2D(r113, 0, 6408, r110, r111, 0, 6408, 5121, null);
        return r112[0];
    }

    public static Bitmap loadBitmap(byte[] r100, int r101, int r102, boolean r103) {
        BitmapFactory.Options r104 = new BitmapFactory.Options();
        r104.inPremultiplied = r103;
        Bitmap r105 = BitmapFactory.decodeByteArray(r100, r101, r102, r104);
        if (r105 == null) goto L8;
        Bitmap.Config r106 = r105.getConfig();
        Bitmap.Config r107 = Bitmap.Config.ARGB_8888;
        if (r106 != r107) goto L7;
        return r105;
    L7:
        return r105.copy(r107, true);
    L8:
        return r105;
    }
}
