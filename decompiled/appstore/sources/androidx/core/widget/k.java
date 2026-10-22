package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* JADX INFO: loaded from: classes.dex */
public final class k implements OnReceiveContentListener {

    public static final class a {
        public static CharSequence a(Context r10, ClipData.Item r11, int r12) {
            if ((r12 & 1) == 0) goto L9;
            CharSequence r13 = r11.coerceToText(r10);
            if ((r13 instanceof Spanned) == true) goto L7;
            return r13;
        L7:
            return r13.toString();
        L9:
            return r11.coerceToStyledText(r10);
        }
    }

    public k() {
    }

    public static CharSequence a(Context r10, ClipData.Item r11, int r12) {
        return a.a(r10, r11, r12);
    }

    public static void b(Editable r10, CharSequence r11) {
        int r12 = Selection.getSelectionStart(r10);
        int r13 = Selection.getSelectionEnd(r10);
        int r14 = Math.max(0, Math.min(r12, r13));
        int r15 = Math.max(0, Math.max(r12, r13));
        Selection.setSelection(r10, r15);
        r10.replace(r14, r15, r11);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    public ContentInfoCompat onReceiveContent(View r10, ContentInfoCompat r11) {
        if (Log.isLoggable("ReceiveContent", 3) == false) goto L6;
        Log.d("ReceiveContent", "onReceive: " + r11);
    L6:
        if (r11.d() != 2) goto L8;
        return r11;
    L8:
        ClipData r12 = r11.b();
        int r13 = r11.c();
        TextView r14 = (TextView) r10;
        Editable r15 = (Editable) r14.getText();
        Context r16 = r14.getContext();
        int r17 = 0;
        boolean r18 = false;
    L10:
        if (r17 >= r12.getItemCount()) goto L17;
        CharSequence r19 = a(r16, r12.getItemAt(r17), r13);
        if (r19 == null) goto L16;
        if (r18 == true) goto L15;
        b(r15, r19);
        r18 = true;
        goto L16
    L15:
        r15.insert(Selection.getSelectionEnd(r15), "\n");
        r15.insert(Selection.getSelectionEnd(r15), r19);
    L16:
        r17 = r17 + 1;
        goto L10
    L17:
        return null;
    }
}
