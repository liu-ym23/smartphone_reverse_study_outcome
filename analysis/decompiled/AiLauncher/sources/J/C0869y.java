package J;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.DngCreator;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: J.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0869y implements U.z<a, ImageCapture.g> {

    /* renamed from: a, reason: collision with root package name */
    public DngCreator f3687a;

    /* renamed from: J.y$a */
    public static abstract class a {
        public static a d(androidx.camera.core.i iVar, int i10, ImageCapture.OutputFileOptions outputFileOptions) {
            return new C0848c(iVar, i10, outputFileOptions);
        }

        public abstract androidx.camera.core.i a();

        public abstract ImageCapture.OutputFileOptions b();

        public abstract int c();
    }

    public C0869y(CameraCharacteristics cameraCharacteristics, CaptureResult captureResult) {
        this(new DngCreator(cameraCharacteristics, captureResult));
    }

    public static int b(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 90) {
            return 6;
        }
        if (i10 != 180) {
            return i10 != 270 ? 0 : 8;
        }
        return 3;
    }

    @Override // U.z
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageCapture.g apply(a aVar) throws ImageCaptureException {
        ImageCapture.OutputFileOptions outputFileOptionsB = aVar.b();
        File fileE = C0870z.e(outputFileOptionsB);
        c(fileE, aVar.a(), aVar.c());
        return new ImageCapture.g(C0870z.j(fileE, outputFileOptionsB), 32);
    }

    public final void c(File file, androidx.camera.core.i iVar, int i10) throws ImageCaptureException {
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    this.f3687a.setOrientation(b(i10));
                    this.f3687a.writeImage(fileOutputStream, iVar.g1());
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                throw new ImageCaptureException(1, "Failed to write to temp file", e10);
            } catch (IllegalArgumentException e11) {
                throw new ImageCaptureException(1, "Image with an unsupported format was used", e11);
            } catch (IllegalStateException e12) {
                throw new ImageCaptureException(1, "Not enough metadata information has been set to write a well-formatted DNG file", e12);
            }
        } finally {
            iVar.close();
        }
    }

    public C0869y(DngCreator dngCreator) {
        this.f3687a = dngCreator;
    }
}
