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
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    public TextViewOnReceiveContentListener() {
    }

    private static void replaceSelection(Editable r100, CharSequence r101) {
        int r102 = Selection.getSelectionStart(r100);
        int r103 = Selection.getSelectionEnd(r100);
        int r104 = Math.max(0, Math.min(r102, r103));
        int r105 = Math.max(0, Math.max(r102, r103));
        Selection.setSelection(r100, r105);
        r100.replace(r104, r105, r101);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    public ContentInfoCompat onReceiveContent(View r100, ContentInfoCompat r101) {
        if (Log.isLoggable(LOG_TAG, 3) == false) goto L6;
        Objects.toString(r101);
    L6:
        if (r101.getSource() != 2) goto L8;
        return r101;
    L8:
        ClipData r102 = r101.getClip();
        int r103 = r101.getFlags();
        TextView r104 = (TextView) r100;
        Editable r105 = (Editable) r104.getText();
        Context r106 = r104.getContext();
        int r107 = 0;
        boolean r108 = false;
    L10:
        if (r107 >= r102.getItemCount()) goto L17;
        CharSequence r109 = coerceToText(r106, r102.getItemAt(r107), r103);
        if (r109 == null) goto L16;
        if (r108 == true) goto L15;
        replaceSelection(r105, r109);
        r108 = true;
        goto L16
    L15:
        r105.insert(Selection.getSelectionEnd(r105), "\n");
        r105.insert(Selection.getSelectionEnd(r105), r109);
    L16:
        r107 = r107 + 1;
        goto L10
    L17:
        return null;
    }

    private static CharSequence coerceToText(Context r100, ClipData.Item r101, int r102) {
        if ((r102 & 1) == 0) goto L9;
        CharSequence r103 = r101.coerceToText(r100);
        if ((r103 instanceof Spanned) == true) goto L7;
        return r103;
    L7:
        return r103.toString();
    L9:
        return r101.coerceToStyledText(r100);
    }
}
