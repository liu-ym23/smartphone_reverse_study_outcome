package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.List;
import java.util.Objects;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j5) {
            return contentCaptureSession.newAutofillId(autofillId, j5);
        }

        public static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        public static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j5) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j5);
        }

        public static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        public static void notifyViewDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId) {
            contentCaptureSession.notifyViewDisappeared(autofillId);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        public static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    @RequiresApi(29)
    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    @RequiresApi(29)
    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public void flush() {
        ContentCaptureSession contentCaptureSession = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(autofillId);
        Api29Impl.notifyViewsDisappeared(contentCaptureSession, autofillId.toAutofillId(), new long[]{Long.MIN_VALUE});
    }

    public AutofillId newAutofillId(long j5) {
        ContentCaptureSession contentCaptureSession = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(autofillId);
        return Api29Impl.newAutofillId(contentCaptureSession, autofillId.toAutofillId(), j5);
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId autofillId, long j5) {
        return ViewStructureCompat.toViewStructureCompat(Api29Impl.newVirtualViewStructure((ContentCaptureSession) this.mWrappedObj, autofillId, j5));
    }

    public void notifyViewAppeared(ViewStructure viewStructure) {
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructure);
    }

    public void notifyViewDisappeared(AutofillId autofillId) {
        Api29Impl.notifyViewDisappeared((ContentCaptureSession) this.mWrappedObj, autofillId);
    }

    public void notifyViewTextChanged(AutofillId autofillId, CharSequence charSequence) {
        Api29Impl.notifyViewTextChanged((ContentCaptureSession) this.mWrappedObj, autofillId, charSequence);
    }

    public void notifyViewsAppeared(List<ViewStructure> list) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.notifyViewsAppeared((ContentCaptureSession) this.mWrappedObj, list);
            return;
        }
        ViewStructure viewStructureNewViewStructure = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(viewStructureNewViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure);
        for (int i = 0; i < list.size(); i++) {
            Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, list.get(i));
        }
        ViewStructure viewStructureNewViewStructure2 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(viewStructureNewViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure2);
    }

    public void notifyViewsDisappeared(long[] jArr) {
        if (Build.VERSION.SDK_INT >= 34) {
            ContentCaptureSession contentCaptureSession = (ContentCaptureSession) this.mWrappedObj;
            AutofillIdCompat autofillId = ViewCompatShims.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId);
            Api29Impl.notifyViewsDisappeared(contentCaptureSession, autofillId.toAutofillId(), jArr);
            return;
        }
        ViewStructure viewStructureNewViewStructure = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(viewStructureNewViewStructure).putBoolean(KEY_VIEW_TREE_APPEARING, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure);
        ContentCaptureSession contentCaptureSession2 = (ContentCaptureSession) this.mWrappedObj;
        AutofillIdCompat autofillId2 = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(autofillId2);
        Api29Impl.notifyViewsDisappeared(contentCaptureSession2, autofillId2.toAutofillId(), jArr);
        ViewStructure viewStructureNewViewStructure2 = Api29Impl.newViewStructure((ContentCaptureSession) this.mWrappedObj, this.mView);
        Api23Impl.getExtras(viewStructureNewViewStructure2).putBoolean(KEY_VIEW_TREE_APPEARED, true);
        Api29Impl.notifyViewAppeared((ContentCaptureSession) this.mWrappedObj, viewStructureNewViewStructure2);
    }

    @RequiresApi(29)
    public ContentCaptureSession toContentCaptureSession() {
        return (ContentCaptureSession) this.mWrappedObj;
    }
}
