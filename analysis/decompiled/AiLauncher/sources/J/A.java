package J;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.internal.utils.ImageUtil;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class A implements U.z<U.A<androidx.camera.core.i>, Bitmap> {
    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap apply(U.A<androidx.camera.core.i> a10) throws Throwable {
        androidx.camera.core.m mVar;
        Bitmap bitmapK;
        androidx.camera.core.m mVar2 = null;
        try {
            try {
                int iE = a10.e();
                if (iE == 35) {
                    androidx.camera.core.i iVarC = a10.c();
                    boolean z10 = a10.f() % 180 != 0;
                    mVar = new androidx.camera.core.m(D.Y.a(z10 ? iVarC.getHeight() : iVarC.getWidth(), z10 ? iVarC.getWidth() : iVarC.getHeight(), 1, 2));
                    try {
                        androidx.camera.core.i iVarG = ImageProcessingUtil.g(iVarC, mVar, ByteBuffer.allocateDirect(iVarC.getWidth() * iVarC.getHeight() * 4), a10.f(), false);
                        iVarC.close();
                        if (iVarG == null) {
                            throw new ImageCaptureException(0, "Can't covert YUV to RGB", null);
                        }
                        bitmapK = ImageUtil.a(iVarG);
                        iVarG.close();
                    } catch (UnsupportedOperationException e10) {
                        e = e10;
                        throw new ImageCaptureException(0, "Can't convert " + (a10.e() == 35 ? "YUV" : "JPEG") + " to bitmap", e);
                    } catch (Throwable th) {
                        th = th;
                        mVar2 = mVar;
                        if (mVar2 != null) {
                            mVar2.close();
                        }
                        throw th;
                    }
                } else {
                    if (iE != 256 && iE != 4101) {
                        throw new IllegalArgumentException("Invalid postview image format : " + a10.e());
                    }
                    androidx.camera.core.i iVarC2 = a10.c();
                    Bitmap bitmapA = ImageUtil.a(iVarC2);
                    iVarC2.close();
                    mVar = null;
                    bitmapK = ImageUtil.k(bitmapA, a10.f());
                }
                if (mVar != null) {
                    mVar.close();
                }
                return bitmapK;
            } catch (UnsupportedOperationException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
