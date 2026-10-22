package com.android.contacts.common.format;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class TextHighlighter {
    private static final boolean DEBUG = false;
    private final String TAG;
    private int mTextStyle;
    private CharacterStyle mTextStyleSpan;

    public TextHighlighter(int r2) {
        this.TAG = "TextHighlighter";
        this.mTextStyle = r2;
        this.mTextStyleSpan = getStyleSpan();
    }

    public void setPrefixText(TextView r1, String r2, String r3) {
        r1.setText(applyPrefixHighlight(r2, r3));
    }

    private CharacterStyle getStyleSpan() {
        return new StyleSpan(this.mTextStyle);
    }

    public void applyMaskingHighlight(SpannableString r2, int r3, int r4) {
        r2.setSpan(getStyleSpan(), r3, r4, 0);
    }

    public CharSequence applyPrefixHighlight(CharSequence r4, String r5) {
        if (r5 != null) goto L4;
        return r4;
    L4:
        int r1 = 0;
    L6:
        if (r1 >= r5.length()) goto L10;
        if (Character.isLetterOrDigit(r5.charAt(r1)) == true) goto L10;
        r1 = r1 + 1;
    L10:
        String r6 = r5.substring(r1);
        int r2 = FormatUtils.indexOfWordPrefix(r4, r6);
        if (r2 == (-1)) goto L14;
        SpannableString r3 = new SpannableString(r4);
        r3.setSpan(this.mTextStyleSpan, r2, r6.length() + r2, 0);
        return r3;
    L14:
        return r4;
    }
}
