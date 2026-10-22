package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes17.dex */
class TreeDocumentFile extends DocumentFile {
    private Context mContext;
    private Uri mUri;

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        return DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
    L4:
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return DocumentsContractApi19.getName(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getType() {
        return DocumentsContractApi19.getType(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return DocumentsContractApi19.length(this.mContext, this.mUri);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ContentResolver r100 = this.mContext.getContentResolver();
        Uri r101 = this.mUri;
        Uri r102 = DocumentsContract.buildChildDocumentsUriUsingTree(r101, DocumentsContract.getDocumentId(r101));
        ArrayList r103 = new ArrayList();
        int r104 = 0;
        Cursor r105 = null;
        r105 = androidx_documentfile_provider_TreeDocumentFile_android_content_ContentResolver_query(r100, r102, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        if (r105.moveToNext() == false) goto L8;
        String r106 = r105.getString(0);     // Catch: Throwable -> L9 Exception -> L11
        r103.add(DocumentsContract.buildDocumentUriUsingTree(this.mUri, r106));     // Catch: Throwable -> L9 Exception -> L11
    L8:
        closeQuietly(r105);
        Uri[] r107 = (Uri[]) r103.toArray(new Uri[r103.size()]);
        DocumentFile[] r108 = new DocumentFile[r107.length];
    L16:
        if (r104 >= r107.length) goto L18;
        r108[r104] = new TreeDocumentFile(this, this.mContext, r107[r104]);
        r104 = r104 + 1;
        goto L16
    L18:
        return r108;
    L11:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        closeQuietly(r105);
        throw th;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return this.mUri;
    }

    private static void closeQuietly(AutoCloseable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String r100) {
        Uri r101 = createFile(this.mContext, this.mUri, "vnd.android.document/directory", r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r101);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String r100) {
        Uri r101 = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, r100);     // Catch: Exception -> L9
        if (r101 == null) goto L8;
        this.mUri = r101;     // Catch: Exception -> L9
        return true;
    L8:
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String r100, String r101) {
        Uri r102 = createFile(this.mContext, this.mUri, r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new TreeDocumentFile(this, this.mContext, r102);
    }

    public TreeDocumentFile(DocumentFile r100, Context r101, Uri r102) {
        super(r100);
        this.mContext = r101;
        this.mUri = r102;
    }

    private static Uri createFile(Context r100, Uri r101, String r102, String r103) {
        return DocumentsContract.createDocument(r100.getContentResolver(), r101, r102, r103);
    L4:
        return null;
    }

    private static Cursor androidx_documentfile_provider_TreeDocumentFile_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
