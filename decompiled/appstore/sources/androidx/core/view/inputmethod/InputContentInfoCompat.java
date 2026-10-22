package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class InputContentInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputContentInfoCompatImpl f2776a;

    public interface InputContentInfoCompatImpl {
        @NonNull
        Uri getContentUri();

        @NonNull
        ClipDescription getDescription();

        @Nullable
        Object getInputContentInfo();

        @Nullable
        Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    public static final class a implements InputContentInfoCompatImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputContentInfo f2777a;

        public a(Object r10) {
            this.f2777a = (InputContentInfo) r10;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.f2777a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.f2777a.getDescription();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return this.f2777a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.f2777a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
            this.f2777a.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
            this.f2777a.requestPermission();
        }
    }

    public InputContentInfoCompat(InputContentInfoCompatImpl r10) {
        this.f2776a = r10;
    }

    public static InputContentInfoCompat f(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new InputContentInfoCompat(new a(r10));
    }

    public Uri a() {
        return this.f2776a.getContentUri();
    }

    public ClipDescription b() {
        return this.f2776a.getDescription();
    }

    public Uri c() {
        return this.f2776a.getLinkUri();
    }

    public void d() {
        this.f2776a.requestPermission();
    }

    public Object e() {
        return this.f2776a.getInputContentInfo();
    }
}
