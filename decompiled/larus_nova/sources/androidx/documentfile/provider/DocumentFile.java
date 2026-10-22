package androidx.documentfile.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.File;

/* JADX INFO: loaded from: classes17.dex */
public abstract class DocumentFile {
    static final String TAG = "DocumentFile";
    private final DocumentFile mParent;

    public abstract boolean canRead();

    public abstract boolean canWrite();

    public abstract DocumentFile createDirectory(String r100);

    public abstract DocumentFile createFile(String r100, String r101);

    public abstract boolean delete();

    public abstract boolean exists();

    public abstract String getName();

    public abstract String getType();

    public abstract Uri getUri();

    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isVirtual();

    public abstract long lastModified();

    public abstract long length();

    public abstract DocumentFile[] listFiles();

    public abstract boolean renameTo(String r100);

    public DocumentFile getParentFile() {
        return this.mParent;
    }

    public DocumentFile(DocumentFile r100) {
        this.mParent = r100;
    }

    public static DocumentFile fromFile(File r100) {
        return new RawDocumentFile(null, r100);
    }

    public DocumentFile findFile(String r100) {
        DocumentFile[] r101 = listFiles();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        DocumentFile r104 = r101[r103];
        if (r100.equals(r104.getName()) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static DocumentFile fromSingleUri(Context r100, Uri r101) {
        return new SingleDocumentFile(null, r100, r101);
    }

    public static DocumentFile fromTreeUri(Context r100, Uri r101) {
        return new TreeDocumentFile(null, r100, DocumentsContract.buildDocumentUriUsingTree(r101, DocumentsContract.getTreeDocumentId(r101)));
    }

    public static boolean isDocumentUri(Context r100, Uri r101) {
        return DocumentsContract.isDocumentUri(r100, r101);
    }
}
