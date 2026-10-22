package u2;

import B0.m;
import android.opengl.GLES20;
import androidx.fragment.app.A;
import com.stepos.alphame.utils.Property;
import h2.C0590b;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import w2.C0974a;
import w2.C0976c;
import w2.InterfaceC0977d;

/* renamed from: u2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0940b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f15490a = 0;

    static {
        new m(9, 0);
    }

    public static void a(float[] fArr, int i4, float f4, float f5, float f6, float f7) {
        fArr[i4] = f4;
        fArr[i4 + 1] = f5;
        fArr[i4 + 2] = 0.0f;
        fArr[i4 + 3] = 0.0f;
        fArr[i4 + 4] = 0.0f;
        fArr[i4 + 5] = 1.0f;
        fArr[i4 + 6] = f6;
        fArr[i4 + 7] = f7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0590b b(float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float[] fArr = new float[32];
        a(fArr, 0, f4, f5, Property.DEFAULT_FLOAT_VALUE, 1.0f);
        a(fArr, 8, f6, f7, 1.0f, 1.0f);
        a(fArr, 16, f8, f9, 1.0f, Property.DEFAULT_FLOAT_VALUE);
        a(fArr, 24, f10, f11, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
        short[] sArr = {0, 1, 2, 2, 3, 0};
        C0590b c0590b = new C0590b(new x2.b[]{new x2.b(1, 3, "a_position"), new x2.b(8, 3, "a_normal"), new x2.b(16, 2, "a_texCoord0")});
        C0976c c0976c = (C0976c) ((InterfaceC0977d) c0590b.f12697c);
        c0976c.f15857f = true;
        ByteBuffer byteBuffer = c0976c.f15854c;
        if (byteBuffer instanceof ByteBuffer) {
            byteBuffer.limit(128);
            byteBuffer.position(0);
            byteBuffer.asFloatBuffer().put(fArr, 0, 32);
        } else {
            if (!(byteBuffer instanceof FloatBuffer)) {
                throw new A("", 7);
            }
            byteBuffer.limit(32);
            byteBuffer.position(0);
            ((FloatBuffer) byteBuffer).put(fArr, 0, 32);
        }
        byteBuffer.position(0);
        FloatBuffer floatBuffer = c0976c.f15853b;
        floatBuffer.position(0);
        floatBuffer.limit(32);
        if (c0976c.f15858g) {
            GLES20.glBindBuffer(34962, c0976c.f15855d);
            GLES20.glBufferData(34962, byteBuffer.limit(), byteBuffer, c0976c.f15856e);
            c0976c.f15857f = false;
        }
        C0974a c0974a = (C0974a) c0590b.f12698d;
        c0974a.f15832d = true;
        ShortBuffer shortBuffer = c0974a.f15829a;
        shortBuffer.clear();
        shortBuffer.put(sArr, 0, 6);
        shortBuffer.flip();
        ByteBuffer byteBuffer2 = c0974a.f15830b;
        byteBuffer2.position(0);
        byteBuffer2.limit(12);
        if (c0974a.f15833e) {
            GLES20.glBufferData(34963, byteBuffer2.limit(), byteBuffer2, c0974a.f15834f);
            c0974a.f15832d = false;
        }
        return c0590b;
    }
}
