package J;

import D.C0761b0;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

/* renamed from: J.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0870z {
    public static Uri a(File file, File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            return Uri.fromFile(file2);
        }
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), null);
    }

    public static Uri b(File file, ImageCapture.OutputFileOptions outputFileOptions) throws Throwable {
        Uri uriInsert;
        ContentResolver contentResolverA = outputFileOptions.a();
        Objects.requireNonNull(contentResolverA);
        ContentValues contentValues = outputFileOptions.b() != null ? new ContentValues(outputFileOptions.b()) : new ContentValues();
        k(contentValues, 1);
        Uri uri = null;
        try {
            try {
                C0761b0.a("FileUtil", "copyFileToMediaStore: inserting values to MediaStore");
                uriInsert = contentResolverA.insert(outputFileOptions.f(), contentValues);
            } catch (IOException | SecurityException e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                C0761b0.a("FileUtil", "copyFileToMediaStore: insert success");
                if (uriInsert == null) {
                    throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", null);
                }
                d(file, uriInsert, contentResolverA);
                m(uriInsert, contentResolverA, 0);
                return uriInsert;
            } catch (IOException | SecurityException e11) {
                e = e11;
                uri = uriInsert;
                throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + uri, e);
            }
        } catch (Throwable th2) {
            th = th2;
            uri = uriInsert;
            if (uri != null) {
                m(uri, contentResolverA, 0);
            }
            throw th;
        }
    }

    public static void c(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    fileInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, i10);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void d(File file, Uri uri, ContentResolver contentResolver) throws IOException {
        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
        try {
            if (outputStreamOpenOutputStream != null) {
                c(file, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.close();
            } else {
                throw new FileNotFoundException(uri + " cannot be resolved.");
            }
        } catch (Throwable th) {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static File e(ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        try {
            File fileC = outputFileOptions.c();
            if (fileC == null) {
                return File.createTempFile("CameraX", ".tmp");
            }
            return new File(fileC.getParent(), "CameraX" + UUID.randomUUID().toString() + f(fileC));
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e10);
        }
    }

    public static String f(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf >= 0 ? name.substring(iLastIndexOf) : "";
    }

    public static boolean g(ImageCapture.OutputFileOptions outputFileOptions) {
        return outputFileOptions.c() != null;
    }

    public static boolean h(ImageCapture.OutputFileOptions outputFileOptions) {
        return (outputFileOptions.f() == null || outputFileOptions.a() == null || outputFileOptions.b() == null) ? false : true;
    }

    public static boolean i(ImageCapture.OutputFileOptions outputFileOptions) {
        return outputFileOptions.e() != null;
    }

    public static Uri j(File file, ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        Uri uriA = null;
        try {
            try {
                if (h(outputFileOptions)) {
                    uriA = b(file, outputFileOptions);
                } else if (i(outputFileOptions)) {
                    OutputStream outputStreamE = outputFileOptions.e();
                    Objects.requireNonNull(outputStreamE);
                    c(file, outputStreamE);
                } else if (g(outputFileOptions)) {
                    File fileC = outputFileOptions.c();
                    Objects.requireNonNull(fileC);
                    uriA = a(file, fileC);
                }
                file.delete();
                return uriA;
            } catch (IOException unused) {
                throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);
            }
        } catch (Throwable th) {
            file.delete();
            throw th;
        }
    }

    public static void k(ContentValues contentValues, int i10) {
        contentValues.put("is_pending", Integer.valueOf(i10));
    }

    public static void l(File file, M.f fVar, ImageCapture.OutputFileOptions outputFileOptions, int i10) throws ImageCaptureException {
        try {
            M.f fVarH = M.f.h(file);
            fVar.g(fVarH);
            if (fVarH.s() == 0 && i10 != 0) {
                fVarH.z(i10);
            }
            ImageCapture.e eVarD = outputFileOptions.d();
            if (eVarD.b()) {
                fVarH.l();
            }
            if (eVarD.c()) {
                fVarH.m();
            }
            if (eVarD.a() != null) {
                fVarH.b(eVarD.a());
            }
            fVarH.A();
        } catch (IOException e10) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e10);
        }
    }

    public static void m(Uri uri, ContentResolver contentResolver, int i10) {
        ContentValues contentValues = new ContentValues();
        k(contentValues, i10);
        contentResolver.update(uri, contentValues, null, null);
    }
}
