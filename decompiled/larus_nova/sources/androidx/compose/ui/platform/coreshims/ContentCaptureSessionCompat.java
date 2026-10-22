package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Bundle getExtras(ViewStructure r100) {
            return r100.getExtras();
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static ViewStructure newViewStructure(ContentCaptureSession r100, View r101) {
            return r100.newViewStructure(r101);
        }

        public static void notifyViewAppeared(ContentCaptureSession r100, ViewStructure r101) {
            r100.notifyViewAppeared(r101);
        }

        public static void notifyViewDisappeared(ContentCaptureSession r100, AutofillId r101) {
            r100.notifyViewDisappeared(r101);
        }

        public static AutofillId newAutofillId(ContentCaptureSession r100, AutofillId r101, long r102) {
            return r100.newAutofillId(r101, r102);
        }

        public static ViewStructure newVirtualViewStructure(ContentCaptureSession r100, AutofillId r101, long r102) {
            return r100.newVirtualViewStructure(r101, r102);
        }

        public static void notifyViewTextChanged(ContentCaptureSession r100, AutofillId r101, CharSequence r102) {
            r100.notifyViewTextChanged(r101, r102);
        }

        public static void notifyViewsDisappeared(ContentCaptureSession r100, AutofillId r101, long[] r102) {
            r100.notifyViewsDisappeared(r101, r102);
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void notifyViewsAppeared(ContentCaptureSession r100, List<ViewStructure> r101) {
            r100.notifyViewsAppeared(r101);
        }
    }

    public void flush() {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        ContentCaptureSession r100 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat r101 = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(r101);
        Api29Impl.notifyViewsDisappeared(r100, r101.toAutofillId(), new long[]{Long.MIN_VALUE});
        return;
    }

    public ContentCaptureSession toContentCaptureSession() {
        return (ContentCaptureSession) this.mWrappedObj;
    }

    public AutofillId newAutofillId(long r100) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        ContentCaptureSession r101 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat r102 = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(r102);
        return Api29Impl.newAutofillId(r101, r102.toAutofillId(), r100);
    L6:
        return null;
    }

    public void notifyViewAppeared(ViewStructure r100) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r100);
        return;
    }

    public void notifyViewDisappeared(AutofillId r100) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.notifyViewDisappeared((ContentCaptureSession) this.mWrappedObj, r100);
        return;
    }

    public void notifyViewsAppeared(List<ViewStructure> r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 34) goto L6;
        Api34Impl.notifyViewsAppeared((ContentCaptureSession) this.mWrappedObj, r100);
        return;
    L6:
        if (r101 < 29) goto L15;
        ViewStructure r102 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r102).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r102);
        int r103 = 0;
    L9:
        if (r103 >= r100.size()) goto L11;
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, (ViewStructure) ListProtector.get(r100, r103));
        r103 = r103 + 1;
        goto L9
    L11:
        ViewStructure r104 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r104).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r104);
        return;
    }

    public void notifyViewsDisappeared(long[] r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 34) goto L6;
        ContentCaptureSession r102 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat r103 = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(r103);
        Api29Impl.notifyViewsDisappeared(r102, r103.toAutofillId(), r100);
        return;
    L6:
        if (r101 < 29) goto L10;
        ViewStructure r104 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r104).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r104);
        ContentCaptureSession r105 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat r106 = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(r106);
        Api29Impl.notifyViewsDisappeared(r105, r106.toAutofillId(), r100);
        ViewStructure r107 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(r107).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, r107);
        return;
    }

    private ContentCaptureSessionCompat(ContentCaptureSession r100, View r101) {
        this.mWrappedObj = r100;
        this.mView = r101;
    }

    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession r100, View r101) {
        return new ContentCaptureSessionCompat(r100, r101);
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId r100, long r101) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return null;
    L5:
        return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure((ContentCaptureSession) this.mWrappedObj, r100, r101));
    }

    public void notifyViewTextChanged(AutofillId r100, CharSequence r101) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        Api29Impl.notifyViewTextChanged((ContentCaptureSession) this.mWrappedObj, r100, r101);
        return;
    }
}
