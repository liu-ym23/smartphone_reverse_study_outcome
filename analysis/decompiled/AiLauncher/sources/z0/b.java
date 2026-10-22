package z0;

import android.annotation.SuppressLint;
import android.text.Html;
import android.text.Spanned;

@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class b {

    public static class a {
        public static Spanned a(String str, int i10) {
            return Html.fromHtml(str, i10);
        }
    }

    public static Spanned a(String str, int i10) {
        return a.a(str, i10);
    }
}
