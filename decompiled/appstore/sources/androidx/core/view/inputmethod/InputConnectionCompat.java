package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.e;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputConnectionCompat {

    public interface OnCommitContentListener {
        boolean onCommitContent(@NonNull InputContentInfoCompat r10, int r11, @Nullable Bundle r12);
    }

    public class a extends InputConnectionWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OnCommitContentListener f2775a;

        public a(InputConnection r10, boolean r11, OnCommitContentListener r12) {
            this.f2775a = r12;
            super(r10, r11);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo r10, int r11, Bundle r12) {
            if (this.f2775a.onCommitContent(InputContentInfoCompat.f(r10), r11, r12) == false) goto L7;
            return true;
        L7:
            return super.commitContent(r10, r11, r12);
        }
    }

    public static /* synthetic */ boolean a(View r10, InputContentInfoCompat r11, int r12, Bundle r13) {
        return e(r10, r11, r12, r13);
    }

    public static OnCommitContentListener b(final View r10) {
        e.g(r10);
        return new b(r10);
    }

    public static InputConnection c(View r10, InputConnection r11, EditorInfo r12) {
        return d(r11, r12, b(r10));
    }

    public static InputConnection d(InputConnection r10, EditorInfo r11, OnCommitContentListener r12) {
        androidx.core.util.b.c(r10, "inputConnection must be non-null");
        androidx.core.util.b.c(r11, "editorInfo must be non-null");
        androidx.core.util.b.c(r12, "onCommitContentListener must be non-null");
        return new a(r10, false, r12);
    }

    public static /* synthetic */ boolean e(View r10, InputContentInfoCompat r11, int r12, Bundle r13) {
        if ((r12 & 1) == 0) goto L14;
        r11.d();     // Catch: Exception -> L10
        InputContentInfo r14 = (InputContentInfo) r11.e();
        if (r13 != null) goto L8;
        r13 = new Bundle();
    L9:
        r13.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", r14);
        goto L14
    L8:
        r13 = new Bundle(r13);
    L10:
        e = move-exception;
        Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
        return false;
    L14:
        if (ViewCompat.f0(r10, new ContentInfoCompat.a(new ClipData(r11.b(), new ClipData.Item(r11.a())), 2).d(r11.c()).b(r13).a()) != null) goto L17;
        return true;
    L17:
        return false;
    }
}
