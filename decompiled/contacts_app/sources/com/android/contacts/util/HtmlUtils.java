package com.android.contacts.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.QuoteSpan;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes2.dex */
public class HtmlUtils {

    public static class StreamItemQuoteSpan extends QuoteSpan {
        private final int mWidth;

        public StreamItemQuoteSpan(int r1, int r2) {
            super(r1);
            this.mWidth = r2;
        }

        @Override // android.text.style.QuoteSpan, android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean r1) {
            return this.mWidth;
        }
    }

    public HtmlUtils() {
    }

    public static Spanned fromHtml(Context r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return postprocess(r1, Html.fromHtml(r2));
    }

    public static CharSequence fromHtml(Context r1, String r2, Html.ImageGetter r3, Html.TagHandler r4) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return postprocess(r1, Html.fromHtml(r2, r3, r4));
    }

    static Spanned postprocess(Context r8, Spanned r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        int r0 = r9.length();
        if (r0 != 0) goto L9;
        return r9;
    L9:
        if ((r9 instanceof SpannableStringBuilder) == false) goto L11;
        SpannableStringBuilder r10 = (SpannableStringBuilder) r9;
    L12:
        QuoteSpan[] r1 = (QuoteSpan[]) r10.getSpans(0, r0, QuoteSpan.class);
        if (r1 != null) goto L15;
    L20:
        ImageSpan[] r11 = (ImageSpan[]) r10.getSpans(0, r0, ImageSpan.class);
        if (r11 == null) goto L26;
        int r3 = 0;
    L24:
        if (r3 >= r11.length) goto L26;
        ImageSpan r4 = r11[r3];
        replaceSpan(r10, r4, new ImageSpan(r4.getDrawable(), 1));
        r3 = r3 + 1;
    L26:
        int r12 = r10.length() - 1;
        int r2 = r0;
    L27:
        if (r12 < 0) goto L32;
        if (r10.charAt(r12) != '\n') goto L32;
        r2 = r12;
        r12 = r12 - 1;
    L32:
        if (r2 != r0) goto L35;
        return r10;
    L35:
        return new SpannableStringBuilder(r10, 0, r2);
    L15:
        if (r1.length == 0) goto L20;
        Resources r13 = r8.getResources();
        int r5 = r13.getColor(R.color.stream_item_stripe_color);
        int r14 = r13.getDimensionPixelSize(R.dimen.stream_item_stripe_width);
        int r6 = 0;
    L18:
        if (r6 >= r1.length) goto L20;
        replaceSpan(r10, r1[r6], new StreamItemQuoteSpan(r5, r14));
        r6 = r6 + 1;
        goto L18
    L11:
        r10 = new SpannableStringBuilder(r9);
        goto L12
    }

    private static void replaceSpan(SpannableStringBuilder r3, Object r4, Object r5) {
        r3.setSpan(r5, r3.getSpanStart(r4), r3.getSpanEnd(r4), r3.getSpanFlags(r4));
        r3.removeSpan(r4);
    }
}
