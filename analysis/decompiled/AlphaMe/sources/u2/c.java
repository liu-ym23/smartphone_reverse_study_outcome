package u2;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.baidu.platform.comapi.bmsdk.BmLocated;

/* loaded from: classes.dex */
public interface c {
    static void c(int i4, int i5) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i4);
        GLES30.glBindSampler(0, 0);
        float f4 = 9729;
        GLES20.glTexParameterf(3553, 10241, f4);
        GLES20.glTexParameterf(3553, BmLocated.HALF_RIGHT_BOTTOM, f4);
        float f5 = i5;
        GLES20.glTexParameterf(3553, 10242, f5);
        GLES20.glTexParameterf(3553, 10243, f5);
    }

    int a();

    void b(int i4);

    int d();
}
