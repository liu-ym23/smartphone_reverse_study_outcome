package com.android.contacts.common.format;

import android.test.suitebuilder.annotation.SmallTest;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.widget.TextView;
import junit.framework.Assert;

/* JADX INFO: loaded from: classes.dex */
@SmallTest
public class SpannedTestUtils {
    public SpannedTestUtils() {
    }

    public static void checkHtmlText(String r2, TextView r3) {
        String r4 = Html.toHtml((Spanned) r3.getText());
        if (TextUtils.isEmpty(r2) == false) goto L5;
        Assert.assertEquals("", r4);
        return;
    L5:
        Assert.assertEquals("<p dir=ltr>" + r2 + "</p>\n", r4);
    }

    public static void assertPrefixSpan(CharSequence r2, int r3, int r4) {
        Assert.assertTrue(r2 instanceof Spanned);
        Spanned r5 = (Spanned) r2;
        if (r3 <= 0) goto L5;
        Assert.assertEquals(0, getNumForegroundColorSpansBetween(r5, 0, r3 - 1));
    L5:
        Assert.assertEquals(1, getNumForegroundColorSpansBetween(r5, r3, r4));
        Assert.assertEquals(0, getNumForegroundColorSpansBetween(r5, r4 + 1, r5.length() - 1));
    }

    private static int getNumForegroundColorSpansBetween(Spanned r1, int r2, int r3) {
        return ((StyleSpan[]) r1.getSpans(r2, r3, StyleSpan.class)).length;
    }

    public static void assertNotSpanned(CharSequence r1, String r2) {
        Assert.assertFalse(r1 instanceof Spanned);
        Assert.assertEquals(r2, r1);
    }

    public static int getNextTransition(SpannableString r2, int r3) {
        return r2.nextSpanTransition(r3, r2.length(), StyleSpan.class);
    }
}
