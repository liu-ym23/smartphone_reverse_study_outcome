package y3;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import com.google.android.gms.common.internal.C1666g;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;
import x3.C5846a;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final C1666g f43846a = new C1666g("MLKitImageUtils", "");

    /* renamed from: b, reason: collision with root package name */
    public static final d f43847b = new d();

    public static d b() {
        return f43847b;
    }

    public IObjectWrapper a(C5846a c5846a) throws MlKitException {
        int iE = c5846a.e();
        if (iE == -1) {
            return ObjectWrapper.wrap((Bitmap) C1669j.k(c5846a.b()));
        }
        if (iE != 17) {
            if (iE == 35) {
                return ObjectWrapper.wrap(c5846a.g());
            }
            if (iE != 842094169) {
                throw new MlKitException("Unsupported image format: " + c5846a.e(), 3);
            }
        }
        return ObjectWrapper.wrap((ByteBuffer) C1669j.k(c5846a.c()));
    }

    public int c(C5846a c5846a) {
        if (c5846a.e() == -1) {
            return ((Bitmap) C1669j.k(c5846a.b())).getAllocationByteCount();
        }
        if (c5846a.e() == 17 || c5846a.e() == 842094169) {
            return ((ByteBuffer) C1669j.k(c5846a.c())).limit();
        }
        if (c5846a.e() != 35) {
            return 0;
        }
        return (((Image.Plane[]) C1669j.k(c5846a.h()))[0].getBuffer().limit() * 3) / 2;
    }

    public Matrix d(int i10, int i11, int i12) {
        if (i12 == 0) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postTranslate((-i10) / 2.0f, (-i11) / 2.0f);
        matrix.postRotate(i12 * 90);
        int i13 = i12 % 2;
        int i14 = i13 != 0 ? i11 : i10;
        if (i13 == 0) {
            i10 = i11;
        }
        matrix.postTranslate(i14 / 2.0f, i10 / 2.0f);
        return matrix;
    }
}
