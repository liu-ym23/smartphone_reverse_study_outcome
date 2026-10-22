package cfc;

import android.opengl.GLES20;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static int a() {
        int[] r100 = new int[1];
        GLES20.glGenTextures(1, r100, 0);
        GLES20.glBindTexture(36197, r100[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return r100[0];
    }
}
