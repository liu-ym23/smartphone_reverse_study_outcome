package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    public static final class a {
        @DoNotInline
        public static boolean a(@NonNull DragEvent r10, @NonNull TextView r11, @NonNull Activity r12) {
            r12.requestDragAndDropPermissions(r10);
            int r13 = r11.getOffsetForPosition(r10.getX(), r10.getY());
            r11.beginBatchEdit();
            Selection.setSelection((Spannable) r11.getText(), r13);     // Catch: Throwable -> L6
            ViewCompat.f0(r11, new ContentInfoCompat.a(r10.getClipData(), 3).a());     // Catch: Throwable -> L6
            r11.endBatchEdit();
            return true;
        L6:
            th = move-exception;
            r11.endBatchEdit();
            throw th;
        }

        @DoNotInline
        public static boolean b(@NonNull DragEvent r10, @NonNull View r11, @NonNull Activity r12) {
            r12.requestDragAndDropPermissions(r10);
            ViewCompat.f0(r11, new ContentInfoCompat.a(r10.getClipData(), 3).a());
            return true;
        }
    }

    public static boolean a(View r10, DragEvent r11) {
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L24:
        return false;
    L5:
        if (r11.getLocalState() != null) goto L24;
        if (ViewCompat.D(r10) == null) goto L24;
        Activity r12 = c(r10);
        if (r12 != null) goto L14;
        Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + r10);
        return false;
    L14:
        if (r11.getAction() != 1) goto L18;
        return !(r10 instanceof TextView);
    L18:
        if (r11.getAction() != 3) goto L24;
        if ((r10 instanceof TextView) == false) goto L23;
        return a.a(r11, (TextView) r10, r12);
    L23:
        return a.b(r11, r10, r12);
    }

    public static boolean b(TextView r10, int r11) {
        int r12 = 0;
        if (Build.VERSION.SDK_INT < 31) goto L5;
    L25:
        return false;
    L5:
        if (ViewCompat.D(r10) == null) goto L25;
        if (r11 != 16908322) goto L9;
    L11:
        ClipboardManager r13 = (ClipboardManager) r10.getContext().getSystemService("clipboard");
        if (r13 != null) goto L14;
        ClipData r14 = null;
    L16:
        if (r14 != null) goto L18;
    L24:
        return true;
    L18:
        if (r14.getItemCount() <= 0) goto L24;
        ContentInfoCompat.a r15 = new ContentInfoCompat.a(r14, 1);
        if (r11 == 16908322) goto L23;
        r12 = 1;
    L23:
        ViewCompat.f0(r10, r15.c(r12).a());
        goto L24
    L14:
        r14 = r13.getPrimaryClip();
        goto L16
    L9:
        if (r11 == 16908337) goto L11;
        goto L11
    }

    public static Activity c(View r10) {
        Context r11 = r10.getContext();
    L4:
        if ((r11 instanceof ContextWrapper) == false) goto L10;
        if ((r11 instanceof Activity) == true) goto L8;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L4
    L8:
        return (Activity) r11;
    L10:
        return null;
    }
}
