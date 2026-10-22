package J;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* loaded from: classes.dex */
public class F implements U.z<a, ImageCapture.g> {

    public static abstract class a {
        public static a c(U.A<byte[]> a10, ImageCapture.OutputFileOptions outputFileOptions) {
            return new C0850e(a10, outputFileOptions);
        }

        public abstract ImageCapture.OutputFileOptions a();

        public abstract U.A<byte[]> b();
    }

    public static void b(File file, byte[] bArr) throws ImageCaptureException, IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, new S.c().b(bArr));
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e10);
        }
    }

    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageCapture.g apply(a aVar) throws ImageCaptureException, IOException {
        U.A<byte[]> aB = aVar.b();
        ImageCapture.OutputFileOptions outputFileOptionsA = aVar.a();
        File fileE = C0870z.e(outputFileOptionsA);
        b(fileE, aB.c());
        M.f fVarD = aB.d();
        Objects.requireNonNull(fVarD);
        C0870z.l(fileE, fVarD, outputFileOptionsA, aB.f());
        return new ImageCapture.g(C0870z.j(fileE, outputFileOptionsA), 256);
    }
}
