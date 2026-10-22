package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* JADX INFO: loaded from: classes17.dex */
public class ViewCompatShims {
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static AutofillId getAutofillId(View r100) {
            return r100.getAutofillId();
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static ContentCaptureSession getContentCaptureSession(View r100) {
            return r100.getContentCaptureSession();
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static void setImportantForContentCapture(View r100, int r101) {
            r100.setImportantForContentCapture(r101);
        }
    }

    private ViewCompatShims() {
    }

    public static AutofillIdCompat getAutofillId(View r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(r100));
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View r100) {
        if (Build.VERSION.SDK_INT < 29) goto L9;
        ContentCaptureSession r101 = Api29Impl.getContentCaptureSession(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(r101, r100);
    L9:
        return null;
    }

    public static void setImportantForContentCapture(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        Api30Impl.setImportantForContentCapture(r100, r101);
        return;
    }
}
