package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* loaded from: classes.dex */
public final class b {

    static class a {
        static Spanned a(String str, int i5) {
            return Html.fromHtml(str, i5);
        }

        static Spanned b(String str, int i5, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i5, imageGetter, tagHandler);
        }

        static String c(Spanned spanned, int i5) {
            return Html.toHtml(spanned, i5);
        }
    }

    public static Spanned a(String str, int i5) {
        return a.a(str, i5);
    }
}
