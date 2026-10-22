package androidx.core.text;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

/* JADX INFO: loaded from: classes17.dex */
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

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static Spanned fromHtml(String r100, int r101) {
            return Html.fromHtml(r100, r101);
        }

        public static String toHtml(Spanned r100, int r101) {
            return Html.toHtml(r100, r101);
        }

        public static Spanned fromHtml(String r100, int r101, Html.ImageGetter r102, Html.TagHandler r103) {
            return Html.fromHtml(r100, r101, r102, r103);
        }
    }

    private HtmlCompat() {
    }

    public static Spanned fromHtml(String r100, int r101) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r100, r101);
    L7:
        return Html.fromHtml(r100);
    }

    public static String toHtml(Spanned r100, int r101) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.toHtml(r100, r101);
    L7:
        return Html.toHtml(r100);
    }

    public static Spanned fromHtml(String r100, int r101, Html.ImageGetter r102, Html.TagHandler r103) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api24Impl.fromHtml(r100, r101, r102, r103);
    L7:
        return Html.fromHtml(r100, r102, r103);
    }
}
