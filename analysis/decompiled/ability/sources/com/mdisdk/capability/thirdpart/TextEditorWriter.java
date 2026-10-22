package com.mdisdk.capability.thirdpart;

import android.text.Editable;
import android.text.Selection;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.appfunctions.metadata.a;

@UiThread
/* loaded from: classes3.dex */
final class TextEditorWriter {
    private TextEditorWriter() {
    }

    private static void checkRange(int i, int i6, int i10) {
        if (i < 0 || i6 < i || i6 > i10) {
            StringBuilder sbS = a.s(i, "Invalid text range [", i6, ",", ") for ");
            sbS.append(i10);
            throw new IndexOutOfBoundsException(sbS.toString());
        }
    }

    private static Editable editable(TextView textView) {
        Editable editableText = textView.getEditableText();
        if (editableText != null) {
            return editableText;
        }
        throw new IllegalStateException("Target has no native Editable buffer");
    }

    private static int replace(TextView textView, int i, int i6, String str) {
        Editable editable = editable(textView);
        checkRange(i, i6, editable.length());
        Selection.setSelection(editable, i6);
        Editable editable2 = editable(textView);
        checkRange(i, i6, editable2.length());
        int length = editable2.length() - i6;
        editable2.replace(i, i6, str);
        Editable editable3 = editable(textView);
        int length2 = editable3.length() - length;
        if (length2 < 0) {
            throw new IllegalStateException("Editor changed the text outside the edit range");
        }
        Selection.setSelection(editable3, length2);
        return length2;
    }

    public static void replaceText(TextView textView, String str, int i, int i6, boolean z10) {
        int length = editable(textView).length();
        if (i == -1) {
            i = length;
        }
        if (i6 == -1) {
            i6 = length;
        }
        checkRange(i, i6, length);
        if (!z10 || str.isEmpty()) {
            replace(textView, i, i6, str);
            return;
        }
        int i10 = 0;
        while (i10 < str.length()) {
            int iCharCount = Character.charCount(str.codePointAt(i10)) + i10;
            i6 = replace(textView, i, i6, str.substring(i10, iCharCount));
            i = i6;
            i10 = iCharCount;
        }
    }
}
