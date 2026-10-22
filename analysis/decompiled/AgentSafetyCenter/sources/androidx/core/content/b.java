package androidx.core.content;

import android.net.Uri;
import com.fasterxml.jackson.core.JsonPointer;
import g5.f;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public String f1039a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f1040b;

    public final File a(Uri uri) {
        String encodedPath = uri.getEncodedPath();
        int iIndexOf = encodedPath.indexOf(47, 1);
        if (iIndexOf == -1) {
            f.p(uri, "Unable to find path from root: ");
            return null;
        }
        String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
        String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
        File file = (File) this.f1040b.get(strDecode);
        if (file == null) {
            f.p(uri, "Unable to find configured root for ");
            return null;
        }
        File file2 = new File(file, strDecode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            String path = canonicalFile.getPath();
            String path2 = file.getPath();
            if (c.access$000(path).startsWith(c.access$000(path2) + JsonPointer.SEPARATOR)) {
                return canonicalFile;
            }
            throw new SecurityException("Resolved path jumped beyond configured root");
        } catch (IOException unused) {
            f.p(file2, "Failed to resolve canonical path for ");
            return null;
        }
    }
}
