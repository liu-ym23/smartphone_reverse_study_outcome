package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentsContractCompat {

    private static class DocumentsContractApi19Impl {
        public static Uri buildDocumentUri(String r0, String r1) {
            return DocumentsContract.buildDocumentUri(r0, r1);
        }

        static boolean isDocumentUri(Context r2, Uri r3) {
            return DocumentsContract.isDocumentUri((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
        }

        static String getDocumentId(Uri r0) {
            return DocumentsContract.getDocumentId(r0);
        }

        static boolean deleteDocument(ContentResolver r0, Uri r1) {
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

        static Uri createDocument(ContentResolver r0, Uri r1, String r2, String r3) {
            return DocumentsContract.createDocument(r0, r1, r2, r3);
        }

        static Uri renameDocument(ContentResolver r0, Uri r1, String r2) {
            return DocumentsContract.renameDocument(r0, r1, r2);
        }

        private DocumentsContractApi21Impl() {
        }
    }

    private static class DocumentsContractApi24Impl {
        static boolean isTreeUri(Uri r0) {
            return DocumentsContract.isTreeUri(r0);
        }

        static boolean removeDocument(ContentResolver r0, Uri r1, Uri r2) {
            return DocumentsContract.removeDocument(r0, r1, r2);
        }

        private DocumentsContractApi24Impl() {
        }
    }
}
