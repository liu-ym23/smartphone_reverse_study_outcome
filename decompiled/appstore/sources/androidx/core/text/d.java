package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Locale f2644a = null;

    public static class a {
        @DoNotInline
        public static int a(Locale r10) {
            return TextUtils.getLayoutDirectionFromLocale(r10);
        }
    }

    static {
        f2644a = new Locale("", "");
    }

    public static int a(Locale r10) {
        return a.a(r10);
    }
}
