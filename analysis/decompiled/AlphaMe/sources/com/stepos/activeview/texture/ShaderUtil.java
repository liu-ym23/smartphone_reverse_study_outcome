package com.stepos.activeview.texture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.stepos.activeview.utils.Constants;
import com.stepos.activeview.utils.LogUtil;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ShaderUtil {
    public static void checkGlError(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        LogUtil.e("ES20_ERROR", str + ": glError " + iGlGetError);
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public static int createProgram(String str, String str2) {
        int iLoadShader;
        int iLoadShader2 = loadShader(35633, str);
        if (iLoadShader2 == 0 || (iLoadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                LogUtil.e("ES20_ERROR", "Could not link program: ");
                LogUtil.e("ES20_ERROR", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                GLES20.glDeleteProgram(iGlCreateProgram);
                return 0;
            }
        }
        return iGlCreateProgram;
    }

    public static String loadFromAssetsFile(String str, Resources resources) throws IOException {
        String str2 = null;
        try {
            InputStream inputStreamOpen = resources.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i4 = inputStreamOpen.read();
                if (i4 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStreamOpen.close();
                    String str3 = new String(byteArray, Constants.UTF_8_CODE);
                    try {
                        return str3.replaceAll("\\r\\n", "\n");
                    } catch (Exception e4) {
                        str2 = str3;
                        e = e4;
                        e.printStackTrace();
                        return str2;
                    }
                }
                byteArrayOutputStream.write(i4);
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static int loadShader(int i4, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i4);
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        LogUtil.e("ES20_ERROR", "Could not compile shader " + i4 + AwarenessDataItem.USERID_SPLITTER);
        LogUtil.e("ES20_ERROR", GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static int loadTexture(Context context, int i4) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            LogUtil.e("ContentValues", "Could not create a Opengl texture object");
            return 0;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i4, options);
        if (bitmapDecodeResource == null) {
            LogUtil.e("ContentValues", "error to load bitmap resource");
            GLES20.glDeleteTextures(1, iArr, 0);
            return 0;
        }
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLES20.glTexParameteri(3553, BmLocated.HALF_RIGHT_BOTTOM, 9729);
        GLUtils.texImage2D(3553, 0, bitmapDecodeResource, 0);
        bitmapDecodeResource.recycle();
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    public static int loadTexture(Context context, String str) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            LogUtil.e("ContentValues", "Could not create a Opengl texture object");
            return 0;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        if (bitmapDecodeFile == null) {
            LogUtil.e("ContentValues", "error to load bitmap resource");
            GLES20.glDeleteTextures(1, iArr, 0);
            return 0;
        }
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLES20.glTexParameteri(3553, BmLocated.HALF_RIGHT_BOTTOM, 9729);
        GLUtils.texImage2D(3553, 0, bitmapDecodeFile, 0);
        bitmapDecodeFile.recycle();
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }
}
