package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    private static class DocumentsContractApi19Impl {
        public static Uri buildDocumentUri(String r0, String r1) {
            return DocumentsContract.buildDocumentUri(r0, r1);
        }

        static boolean isDocumentUri(Context r0, Uri r1) {
            return DocumentsContract.isDocumentUri(r0, r1);
        }

        static String getDocumentId(Uri r0) {
            return DocumentsContract.getDocumentId(r0);
        }

        static boolean deleteDocument(ContentResolver r0, Uri r1) throws FileNotFoundException {
            return DocumentsContract.deleteDocument(r0, r1);
        }

        private DocumentsContractApi19Impl() {
        }
    }

    private static class DocumentsContractApi21Impl {
        static String getTreeDocumentId(Uri r0) {
            return DocumentsContract.getTreeDocumentId(r0);
        }

        public static Uri buildTreeDocumentUri(String r0, String r1) {
            return DocumentsContract.buildTreeDocumentUri(r0, r1);
        }

        static Uri buildDocumentUriUsingTree(Uri r0, String r1) {
            return DocumentsContract.buildDocumentUriUsingTree(r0, r1);
        }

        static Uri buildChildDocumentsUri(String r0, String r1) {
            return DocumentsContract.buildChildDocumentsUri(r0, r1);
        }

        static Uri buildChildDocumentsUriUsingTree(Uri r0, String r1) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(r0, r1);
        }

        static Uri createDocument(ContentResolver r0, Uri r1, String r2, String r3) throws FileNotFoundException {
            return DocumentsContract.createDocument(r0, r1, r2, r3);
        }

        static Uri renameDocument(ContentResolver r0, Uri r1, String r2) throws FileNotFoundException {
            return DocumentsContract.renameDocument(r0, r1, r2);
        }

        private DocumentsContractApi21Impl() {
        }
    }

    private static class DocumentsContractApi24Impl {
        static boolean isTreeUri(Uri r0) {
            return DocumentsContract.isTreeUri(r0);
        }

        static boolean removeDocument(ContentResolver r0, Uri r1, Uri r2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(r0, r1, r2);
        }

        private DocumentsContractApi24Impl() {
        }
    }

    public static boolean isDocumentUri(Context r0, Uri r1) {
        return DocumentsContractApi19Impl.isDocumentUri(r0, r1);
    }

    public static boolean isTreeUri(Uri r0) {
        return DocumentsContractApi24Impl.isTreeUri(r0);
    }

    public static String getDocumentId(Uri r0) {
        return DocumentsContractApi19Impl.getDocumentId(r0);
    }

    public static String getTreeDocumentId(Uri r0) {
        return DocumentsContractApi21Impl.getTreeDocumentId(r0);
    }

    public static Uri buildDocumentUri(String r0, String r1) {
        return DocumentsContractApi19Impl.buildDocumentUri(r0, r1);
    }

    public static Uri buildDocumentUriUsingTree(Uri r0, String r1) {
        return DocumentsContractApi21Impl.buildDocumentUriUsingTree(r0, r1);
    }

    public static Uri buildTreeDocumentUri(String r0, String r1) {
        return DocumentsContractApi21Impl.buildTreeDocumentUri(r0, r1);
    }

    public static Uri buildChildDocumentsUri(String r0, String r1) {
        return DocumentsContractApi21Impl.buildChildDocumentsUri(r0, r1);
    }

    public static Uri buildChildDocumentsUriUsingTree(Uri r0, String r1) {
        return DocumentsContractApi21Impl.buildChildDocumentsUriUsingTree(r0, r1);
    }

    public static Uri createDocument(ContentResolver r0, Uri r1, String r2, String r3) throws FileNotFoundException {
        return DocumentsContractApi21Impl.createDocument(r0, r1, r2, r3);
    }

    public static Uri renameDocument(ContentResolver r0, Uri r1, String r2) throws FileNotFoundException {
        return DocumentsContractApi21Impl.renameDocument(r0, r1, r2);
    }

    public static boolean removeDocument(ContentResolver r0, Uri r1, Uri r2) throws FileNotFoundException {
        return DocumentsContractApi24Impl.removeDocument(r0, r1, r2);
    }

    private DocumentsContractCompat() {
    }
}
