package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.FileNotFoundException;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    public static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        public static String getTreeDocumentId(Uri r100) {
            return DocumentsContract.getTreeDocumentId(r100);
        }

        public static Uri buildChildDocumentsUri(String r100, String r101) {
            return DocumentsContract.buildChildDocumentsUri(r100, r101);
        }

        public static Uri buildChildDocumentsUriUsingTree(Uri r100, String r101) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(r100, r101);
        }

        public static Uri buildDocumentUriUsingTree(Uri r100, String r101) {
            return DocumentsContract.buildDocumentUriUsingTree(r100, r101);
        }

        public static Uri buildTreeDocumentUri(String r100, String r101) {
            return DocumentsContract.buildTreeDocumentUri(r100, r101);
        }

        public static Uri renameDocument(ContentResolver r100, Uri r101, String r102) throws FileNotFoundException {
            return DocumentsContract.renameDocument(r100, r101, r102);
        }

        public static Uri createDocument(ContentResolver r100, Uri r101, String r102, String r103) throws FileNotFoundException {
            return DocumentsContract.createDocument(r100, r101, r102, r103);
        }
    }

    public static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        public static boolean isTreeUri(Uri r100) {
            return DocumentsContract.isTreeUri(r100);
        }

        public static boolean removeDocument(ContentResolver r100, Uri r101, Uri r102) throws FileNotFoundException {
            return DocumentsContract.removeDocument(r100, r101, r102);
        }
    }

    private DocumentsContractCompat() {
    }

    public static String getDocumentId(Uri r100) {
        return DocumentsContract.getDocumentId(r100);
    }

    public static String getTreeDocumentId(Uri r100) {
        return DocumentsContractApi21Impl.getTreeDocumentId(r100);
    }

    public static boolean isTreeUri(Uri r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L11;
        List<String> r101 = r100.getPathSegments();
        if (r101.size() >= 2) goto L7;
        return false;
    L7:
        if (PATH_TREE.equals(ListProtector.get(r101, 0)) == false) goto L13;
        return true;
    L13:
        return false;
    L11:
        return DocumentsContractApi24Impl.isTreeUri(r100);
    }

    public static Uri buildChildDocumentsUri(String r100, String r101) {
        return DocumentsContractApi21Impl.buildChildDocumentsUri(r100, r101);
    }

    public static Uri buildChildDocumentsUriUsingTree(Uri r100, String r101) {
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(r100, r101);
    }

    public static Uri buildDocumentUri(String r100, String r101) {
        return DocumentsContract.buildDocumentUri(r100, r101);
    }

    public static Uri buildDocumentUriUsingTree(Uri r100, String r101) {
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(r100, r101);
    }

    public static Uri buildTreeDocumentUri(String r100, String r101) {
        return DocumentsContractApi21Impl.buildTreeDocumentUri(r100, r101);
    }

    public static boolean isDocumentUri(Context r100, Uri r101) {
        return DocumentsContract.isDocumentUri(r100, r101);
    }

    public static boolean removeDocument(ContentResolver r100, Uri r101, Uri r102) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return DocumentsContractApi24Impl.removeDocument(r100, r101, r102);
    L7:
        return DocumentsContract.deleteDocument(r100, r101);
    }

    public static Uri renameDocument(ContentResolver r100, Uri r101, String r102) throws FileNotFoundException {
        return DocumentsContractApi21Impl.renameDocument(r100, r101, r102);
    }

    public static Uri createDocument(ContentResolver r100, Uri r101, String r102, String r103) throws FileNotFoundException {
        return DocumentsContractApi21Impl.createDocument(r100, r101, r102, r103);
    }
}
