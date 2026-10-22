package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes17.dex */
public class UriMatcherCompat {
    public static /* synthetic */ boolean a(UriMatcher r100, Uri r101) {
        return lambda$asPredicate$0(r100, r101);
    }

    private UriMatcherCompat() {
    }

    public static Predicate<Uri> asPredicate(final UriMatcher r100) {
        return new w(r100);
    }

    private static /* synthetic */ boolean lambda$asPredicate$0(UriMatcher r100, Uri r101) {
        if (r100.match(r101) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
