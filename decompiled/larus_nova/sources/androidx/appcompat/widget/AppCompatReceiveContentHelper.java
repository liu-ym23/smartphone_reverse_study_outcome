package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import com.bytedance.bpea.entry.common.DataType;
import f06.b;
import f06.c;
import f06.d;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class AppCompatReceiveContentHelper {
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final String LOG_TAG = "ReceiveContent";

    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        public static boolean onDropForTextView(DragEvent r100, TextView r101, Activity r102) {
            r102.requestDragAndDropPermissions(r100);
            int r103 = r101.getOffsetForPosition(r100.getX(), r100.getY());
            r101.beginBatchEdit();
            Selection.setSelection((Spannable) r101.getText(), r103);     // Catch: Throwable -> L6
            ViewCompat.performReceiveContent(r101, new ContentInfoCompat.Builder(r100.getClipData(), 3).build());     // Catch: Throwable -> L6
            r101.endBatchEdit();
            return true;
        L6:
            th = move-exception;
            r101.endBatchEdit();
            throw th;
        }

        public static boolean onDropForView(DragEvent r100, View r101, Activity r102) {
            r102.requestDragAndDropPermissions(r100);
            ViewCompat.performReceiveContent(r101, new ContentInfoCompat.Builder(r100.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    private static ClipData androidx_appcompat_widget_AppCompatReceiveContentHelper_android_content_ClipboardManager_getPrimaryClip(ClipboardManager r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        d r112 = r100.b(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, "android.content.ClipData", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, null, r111, false);
        return (ClipData) r112.f474983b;
    L6:
        ClipData r113 = r110.getPrimaryClip();
        r100.a(101803, "android/content/ClipboardManager", "getPrimaryClip", r110, r101, r113, r111, true);
        return r113;
    }

    public static InputConnectionCompat.OnCommitContentListener createOnCommitContentListener(final View r100) {
        return new AnonymousClass1(r100);
    }

    public static Activity tryGetActivity(View r100) {
        Context r101 = r100.getContext();
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L10;
        if ((r101 instanceof Activity) == true) goto L8;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L8:
        return (Activity) r101;
    L10:
        return null;
    }

    public static boolean maybeHandleDragEventViaPerformReceiveContent(View r100, DragEvent r101) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L24:
        return false;
    L5:
        if (r101.getLocalState() != null) goto L24;
        if (ViewCompat.getOnReceiveContentMimeTypes(r100) == null) goto L24;
        Activity r102 = tryGetActivity(r100);
        if (r102 != null) goto L14;
        Objects.toString(r100);
        return false;
    L14:
        if (r101.getAction() != 1) goto L18;
        return !(r100 instanceof TextView);
    L18:
        if (r101.getAction() != 3) goto L24;
        if ((r100 instanceof TextView) == false) goto L23;
        return OnDropApi24Impl.onDropForTextView(r101, (TextView) r100, r102);
    L23:
        return OnDropApi24Impl.onDropForView(r101, r100, r102);
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(TextView r100, int r101) {
        int r102 = 0;
        if (r101 == 16908322) goto L7;
        if (r101 == 16908337) goto L7;
    L8:
        return false;
    L7:
        if (ViewCompat.getOnReceiveContentMimeTypes(r100) == null) goto L8;
        ClipboardManager r103 = (ClipboardManager) r100.getContext().getSystemService(DataType.CLIPBOARD);
        if (r103 != null) goto L12;
        ClipData r104 = null;
    L14:
        if (r104 != null) goto L16;
    L22:
        return true;
    L16:
        if (r104.getItemCount() <= 0) goto L22;
        ContentInfoCompat.Builder r105 = new ContentInfoCompat.Builder(r104, 1);
        if (r101 == 16908322) goto L21;
        r102 = 1;
    L21:
        ViewCompat.performReceiveContent(r100, r105.setFlags(r102).build());
        goto L22
    L12:
        r104 = androidx_appcompat_widget_AppCompatReceiveContentHelper_android_content_ClipboardManager_getPrimaryClip(r103);
        goto L14
    }
}
