package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes17.dex */
public final class InputContentInfoCompat {
    private final InputContentInfoCompatImpl mImpl;

    public static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {
        final InputContentInfo mObject;

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.mObject.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.mObject.getDescription();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.mObject.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
            this.mObject.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
            this.mObject.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return this.mObject;
        }

        public InputContentInfoCompatApi25Impl(Object r100) {
            this.mObject = (InputContentInfo) r100;
        }

        public InputContentInfoCompatApi25Impl(Uri r100, ClipDescription r101, Uri r102) {
            this.mObject = new InputContentInfo(r100, r101, r102);
        }
    }

    public static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {
        private final Uri mContentUri;
        private final ClipDescription mDescription;
        private final Uri mLinkUri;

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.mContentUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.mDescription;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        public InputContentInfoCompatBaseImpl(Uri r100, ClipDescription r101, Uri r102) {
            this.mContentUri = r100;
            this.mDescription = r101;
            this.mLinkUri = r102;
        }
    }

    public interface InputContentInfoCompatImpl {
        Uri getContentUri();

        ClipDescription getDescription();

        Object getInputContentInfo();

        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }

    private InputContentInfoCompat(InputContentInfoCompatImpl r100) {
        this.mImpl = r100;
    }

    public static InputContentInfoCompat wrap(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 25) goto L9;
        return null;
    L9:
        return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(r100));
    }

    public InputContentInfoCompat(Uri r100, ClipDescription r101, Uri r102) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        this.mImpl = new InputContentInfoCompatApi25Impl(r100, r101, r102);
        return;
    L5:
        this.mImpl = new InputContentInfoCompatBaseImpl(r100, r101, r102);
    }
}
