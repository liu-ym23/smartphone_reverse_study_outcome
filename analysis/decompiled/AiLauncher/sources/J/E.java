package J;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.camera.core.ImageCaptureException;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public final class E implements U.z<U.A<byte[]>, U.A<Bitmap>> {
    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public U.A<Bitmap> apply(U.A<byte[]> a10) throws ImageCaptureException, IOException {
        Rect rectB = a10.b();
        Bitmap bitmapB = b(a10.c(), rectB);
        M.f fVarD = a10.d();
        Objects.requireNonNull(fVarD);
        return U.A.j(bitmapB, fVarD, new Rect(0, 0, bitmapB.getWidth(), bitmapB.getHeight()), a10.f(), M.o.t(a10.g(), rectB), a10.a());
    }

    public final Bitmap b(byte[] bArr, Rect rect) throws ImageCaptureException, IOException {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to decode JPEG.", e10);
        }
    }
}
