package com.android.contacts.format;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class PrefixHighlighter {
    private ForegroundColorSpan mPrefixColorSpan;
    private final int mPrefixHighlightColor;

    public PrefixHighlighter(int r1) {
        this.mPrefixHighlightColor = r1;
    }

    public void setText(TextView r1, String r2, char[] r3) {
        r1.setText(apply(r2, r3));
    }

    public CharSequence apply(CharSequence r4, char[] r5) {
        int r0 = FormatUtils.indexOfWordPrefix(r4, r5);
        if (r0 != (-1)) goto L5;
        return r4;
    L5:
        if (this.mPrefixColorSpan != null) goto L7;
        this.mPrefixColorSpan = new ForegroundColorSpan(this.mPrefixHighlightColor);
    L7:
        SpannableString r1 = new SpannableString(r4);
        r1.setSpan(this.mPrefixColorSpan, r0, r5.length + r0, 0);
        return r1;
    }
}
