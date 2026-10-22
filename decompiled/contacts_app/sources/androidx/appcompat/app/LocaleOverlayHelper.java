package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat r1, LocaleListCompat r2) {
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L9;
        return combineLocales(r1, r2);
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleList r1, LocaleList r2) {
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L9;
        return combineLocales(LocaleListCompat.wrap(r1), LocaleListCompat.wrap(r2));
    L9:
        return LocaleListCompat.getEmptyLocaleList();
    }

    private static LocaleListCompat combineLocales(LocaleListCompat r4, LocaleListCompat r5) {
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = 0;
    L4:
        if (r1 >= (r4.size() + r5.size())) goto L13;
        if (r1 >= r4.size()) goto L8;
        Locale r2 = r4.get(r1);
    L9:
        if (r2 == null) goto L11;
        r0.add(r2);
    L11:
        r1 = r1 + 1;
        goto L4
    L8:
        r2 = r5.get(r1 - r4.size());
        goto L9
    L13:
        return LocaleListCompat.create((Locale[]) r0.toArray(new Locale[r0.size()]));
    }
}
