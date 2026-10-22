package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
public final class HtmlCompat {
    public static final int FROM_HTML_MODE_COMPACT = 63;
    public static final int FROM_HTML_MODE_LEGACY = 0;
    public static final int FROM_HTML_OPTION_USE_CSS_COLORS = 256;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_BLOCKQUOTE = 32;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_DIV = 16;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_HEADING = 2;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST = 8;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_LIST_ITEM = 4;
    public static final int FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH = 1;
    public static final int TO_HTML_PARAGRAPH_LINES_CONSECUTIVE = 0;
    public static final int TO_HTML_PARAGRAPH_LINES_INDIVIDUAL = 1;

    static class Api24Impl {
        private Api24Impl() {
        }

        static Spanned fromHtml(String r0, int r1) {
            return Html.fromHtml(r0, r1);
        }

        static Spanned fromHtml(String r0, int r1, Html.ImageGetter r2, Html.TagHandler r3) {
            return Html.fromHtml(r0, r1, r2, r3);
        }

        static String toHtml(Spanned r0, int r1) {
            return Html.toHtml(r0, r1);
        }
    }

    public static Spanned fromHtml(String r0, int r1) {
        return Api24Impl.fromHtml(r0, r1);
    }

    public static Spanned fromHtml(String r0, int r1, Html.ImageGetter r2, Html.TagHandler r3) {
        return Api24Impl.fromHtml(r0, r1, r2, r3);
    }

    public static String toHtml(Spanned r0, int r1) {
        return Api24Impl.toHtml(r0, r1);
    }

    private HtmlCompat() {
    }
}
