package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class FileSystemException extends IOException {
    public FileSystemException(File file, File file2, String str) {
        g.f(file, "file");
        StringBuilder sb2 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb2.append(" -> " + file2);
        }
        sb2.append(": ".concat(str));
        String string = sb2.toString();
        g.e(string, "toString(...)");
        super(string);
    }
}
