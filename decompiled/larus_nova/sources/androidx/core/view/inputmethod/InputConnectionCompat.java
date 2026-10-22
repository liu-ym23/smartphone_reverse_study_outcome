package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes17.dex */
public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    public static class Api25Impl {
        private Api25Impl() {
        }

        public static boolean commitContent(InputConnection r100, InputContentInfo r101, int r102, Bundle r103) {
            return r100.commitContent(r101, r102, r103);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat r100, int r101, Bundle r102);
    }

    public static /* synthetic */ boolean a(View r100, InputContentInfoCompat r101, int r102, Bundle r103) {
        return lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(r100, r101, r102, r103);
    }

    public InputConnectionCompat() {
    }

    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(final View r100) {
        Preconditions.checkNotNull(r100);
        return new a(r100);
    }

    public static InputConnection createWrapper(final InputConnection r100, EditorInfo r101, final OnCommitContentListener r102) {
        ObjectsCompat.requireNonNull(r100, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(r101, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(r102, "onCommitContentListener must be non-null");
        final boolean r103 = false;
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return new AnonymousClass1(r100, r103, r102);
    L7:
        if (EditorInfoCompat.getContentMimeTypes(r101).length != 0) goto L10;
        return r100;
    L10:
        return new AnonymousClass2(r100, r103, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean handlePerformPrivateCommand(String r100, Bundle r101, OnCommitContentListener r102) {
        ?? r103 = 0;
        r103 = 0;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, r100) == false) goto L9;
        boolean r104 = false;
    L12:
        if (r104 == false) goto L14;
        String r105 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
    L52:
        ResultReceiver r106 = (ResultReceiver) r101.getParcelable(r105);     // Catch: Throwable -> L44
        if (r104 == false) goto L18;
        String r107 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L50:
        Uri r108 = (Uri) r101.getParcelable(r107);     // Catch: Throwable -> L42
        if (r104 == false) goto L22;
        String r109 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L23:
        ClipDescription r110 = (ClipDescription) r101.getParcelable(r109);     // Catch: Throwable -> L42
        if (r104 == false) goto L26;
        String r111 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L27:
        Uri r112 = (Uri) r101.getParcelable(r111);     // Catch: Throwable -> L42
        if (r104 == false) goto L30;
        String r113 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L31:
        int r114 = r101.getInt(r113);     // Catch: Throwable -> L42
        if (r104 == false) goto L34;
        String r115 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L35:
        Bundle r116 = (Bundle) r101.getParcelable(r115);     // Catch: Throwable -> L42
        if (r108 == null) goto L39;
        if (r110 == null) goto L39;
        r103 = r102.onCommitContent(new InputContentInfoCompat(r108, r110, r112), r114, r116);     // Catch: Throwable -> L42
    L39:
        if (r106 == 0) goto L41;
        r106.send(r103, null);
    L41:
        return r103;
    L34:
        r115 = COMMIT_CONTENT_OPTS_KEY;
        goto L35
    L30:
        r113 = COMMIT_CONTENT_FLAGS_KEY;
        goto L31
    L26:
        r111 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L27
    L22:
        r109 = COMMIT_CONTENT_DESCRIPTION_KEY;
    L42:
        th = th;
    L46:
        if (r106 == 0) goto L48;
        r106.send(0, null);
    L48:
        throw th;
    L18:
        r107 = COMMIT_CONTENT_CONTENT_URI_KEY;
    L44:
        th = th;
        r106 = 0;
        goto L46
    L14:
        r105 = COMMIT_CONTENT_RESULT_RECEIVER_KEY;
        goto L52
    L9:
        if (TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, r100) == false) goto L49;
        r104 = true;
        goto L12
    L49:
        return false;
    }

    public static InputConnection createWrapper(View r100, InputConnection r101, EditorInfo r102) {
        return createWrapper(r101, r102, createOnCommitContentListenerUsingPerformReceiveContent(r100));
    }

    private static /* synthetic */ boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View r100, InputContentInfoCompat r101, int r102, Bundle r103) {
        if (Build.VERSION.SDK_INT < 25) goto L14;
        if ((r102 & 1) == 0) goto L14;
        r101.requestPermission();     // Catch: Exception -> L12
        Parcelable r104 = (Parcelable) r101.unwrap();
        if (r103 != null) goto L10;
        r103 = new Bundle();
    L11:
        r103.putParcelable(EXTRA_INPUT_CONTENT_INFO, r104);
        goto L14
    L10:
        r103 = new Bundle(r103);
    L12:
        return false;
    L14:
        if (ViewCompat.performReceiveContent(r100, new ContentInfoCompat.Builder(new ClipData(r101.getDescription(), new ClipData.Item(r101.getContentUri())), 2).setLinkUri(r101.getLinkUri()).setExtras(r103).build()) != null) goto L19;
        return true;
    L19:
        return false;
    }

    public static boolean commitContent(InputConnection r100, EditorInfo r101, InputContentInfoCompat r102, int r103, Bundle r104) {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        int r105 = EditorInfoCompat.getProtocol(r101);
        if (r105 == 2) goto L13;
        boolean r106 = false;
        if (r105 != 3) goto L11;
    L14:
        Bundle r107 = new Bundle();
        if (r106 == false) goto L17;
        String r108 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
    L18:
        r107.putParcelable(r108, r102.getContentUri());
        if (r106 == false) goto L21;
        String r109 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
    L22:
        r107.putParcelable(r109, r102.getDescription());
        if (r106 == false) goto L25;
        String r110 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
    L26:
        r107.putParcelable(r110, r102.getLinkUri());
        if (r106 == false) goto L29;
        String r111 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
    L30:
        r107.putInt(r111, r103);
        if (r106 == false) goto L33;
        String r112 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
    L34:
        r107.putParcelable(r112, r104);
        if (r106 == false) goto L37;
        String r113 = COMMIT_CONTENT_INTEROP_ACTION;
    L39:
        return r100.performPrivateCommand(r113, r107);
    L37:
        r113 = COMMIT_CONTENT_ACTION;
        goto L39
    L33:
        r112 = COMMIT_CONTENT_OPTS_KEY;
        goto L34
    L29:
        r111 = COMMIT_CONTENT_FLAGS_KEY;
        goto L30
    L25:
        r110 = COMMIT_CONTENT_LINK_URI_KEY;
        goto L26
    L21:
        r109 = COMMIT_CONTENT_DESCRIPTION_KEY;
        goto L22
    L17:
        r108 = COMMIT_CONTENT_CONTENT_URI_KEY;
        goto L18
    L11:
        if (r105 == 4) goto L14;
        return false;
    L13:
        r106 = true;
        goto L14
    L5:
        return Api25Impl.commitContent(r100, (InputContentInfo) r102.unwrap(), r103, r104);
    }
}
