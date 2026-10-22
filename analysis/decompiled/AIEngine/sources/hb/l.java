package hb;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.stepos.core.ability.speech.AsrCloudConfig;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l {
    public static final void a(File file, long j10) throws IOException {
        if (!file.exists()) {
            com.tonyodev.fetch2core.b.e(file);
        }
        if (file.length() != j10 && j10 > 0) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(j10);
                randomAccessFile.close();
            } catch (Exception unused) {
                throw new IOException("file_allocation_error");
            }
        }
    }

    public static final String b(String filePath, boolean z) throws FileNotFoundException {
        kotlin.jvm.internal.g.f(filePath, "filePath");
        if (!z) {
            com.tonyodev.fetch2core.b.e(new File(filePath));
            return filePath;
        }
        File file = new File(filePath);
        if (file.exists()) {
            String strJ = a0.a.j(file.getParent(), "/");
            String strU = wb.d.U(file);
            String strV = wb.d.V(file);
            int i10 = 0;
            while (file.exists()) {
                i10++;
                file = new File(strJ + (strV + " (" + i10 + ")") + "." + strU);
            }
        }
        com.tonyodev.fetch2core.b.e(file);
        String absolutePath = file.getAbsolutePath();
        kotlin.jvm.internal.g.c(absolutePath);
        return absolutePath;
    }

    public static final i c(String filePath, ContentResolver contentResolver) throws FileNotFoundException {
        kotlin.jvm.internal.g.f(filePath, "filePath");
        if (!com.tonyodev.fetch2core.b.q(filePath)) {
            return d(new File(filePath));
        }
        Uri uri = Uri.parse(filePath);
        kotlin.jvm.internal.g.e(uri, "parse(...)");
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                        kotlin.jvm.internal.g.e(fileDescriptor, "getFileDescriptor(...)");
                        return new j(new FileOutputStream(fileDescriptor));
                    }
                    throw new FileNotFoundException(uri + " file_not_found");
                }
            } else if (scheme.equals(AsrCloudConfig.SCENE_MODE_FILE)) {
                File file = new File(String.valueOf(uri.getPath()));
                if (file.exists() && file.canWrite()) {
                    return d(file);
                }
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = contentResolver.openFileDescriptor(uri, "w");
                if (parcelFileDescriptorOpenFileDescriptor2 != null) {
                    FileDescriptor fileDescriptor2 = parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor();
                    kotlin.jvm.internal.g.e(fileDescriptor2, "getFileDescriptor(...)");
                    return new j(new FileOutputStream(fileDescriptor2));
                }
                throw new FileNotFoundException(uri + " file_not_found");
            }
        }
        throw new FileNotFoundException(uri + " file_not_found");
    }

    public static final k d(File file) throws FileNotFoundException {
        if (file.exists()) {
            return new k(new RandomAccessFile(file, "rw"));
        }
        throw new FileNotFoundException(a0.a.j(file.getCanonicalPath(), " file_not_found"));
    }
}
