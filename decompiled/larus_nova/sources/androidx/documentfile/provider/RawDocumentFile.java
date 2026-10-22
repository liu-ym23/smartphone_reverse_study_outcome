package androidx.documentfile.provider;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
class RawDocumentFile extends DocumentFile {
    private File mFile;

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return this.mFile.canRead();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return this.mFile.exists();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return this.mFile.getName();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getType() {
        if (this.mFile.isDirectory() == false) goto L7;
        return null;
    L7:
        return getTypeForName(this.mFile.getName());
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return this.mFile.isFile();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return this.mFile.lastModified();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return this.mFile.length();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ArrayList r100 = new ArrayList();
        File[] r101 = this.mFile.listFiles();
        if (r101 == null) goto L8;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L8;
        r100.add(new RawDocumentFile(this, r101[r103]));
        r103 = r103 + 1;
    L8:
        return (DocumentFile[]) r100.toArray(new DocumentFile[r100.size()]);
    }

    private static boolean deleteContents(File r100) {
        File[] r101 = r100.listFiles();
        boolean r102 = true;
        if (r101 == null) goto L13;
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        File r105 = r101[r104];
        if (r105.isDirectory() == false) goto L10;
        r102 = r102 & deleteContents(r105);
    L10:
        if (r105.delete() == true) goto L12;
        r105.toString();
        r102 = false;
    L12:
        r104 = r104 + 1;
    L13:
        return r102;
    }

    private static String getTypeForName(String r100) {
        int r101 = r100.lastIndexOf(46);
        if (r101 < 0) goto L7;
        String r102 = r100.substring(r101 + 1).toLowerCase();
        String r103 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r102);
        if (r103 == null) goto L9;
        return r103;
    L9:
        return "application/octet-stream";
    L7:
        return "application/octet-stream";
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String r100) {
        File r101 = new File(this.mFile, r100);
        if (r101.isDirectory() == true) goto L10;
        if (r101.mkdir() == true) goto L10;
        return null;
    L10:
        return new RawDocumentFile(this, r101);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r100) {
        File r101 = new File(this.mFile.getParentFile(), r100);
        if (this.mFile.renameTo(r101) == false) goto L6;
        this.mFile = r101;
        return true;
    L6:
        return false;
    }

    public RawDocumentFile(DocumentFile r100, File r101) {
        super(r100);
        this.mFile = r101;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String r100, String r101) {
        String r102 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r100);
        if (r102 == null) goto L5;
        r101 = r101 + "." + r102;
    L5:
        File r103 = new File(this.mFile, r101);
        r103.createNewFile();     // Catch: IOException -> L8
        return new RawDocumentFile(this, r103);
    L8:
        e = move-exception;
        e.toString();
        return null;
    }
}
