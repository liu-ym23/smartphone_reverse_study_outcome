package com.android.server.wm;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
final class LocaleOverlayHelper {
    LocaleOverlayHelper() {
    }

    static LocaleList combineLocalesIfOverlayExists(LocaleList overlayLocales, LocaleList baseLocales) {
        if (overlayLocales != null) goto L4;
    L8:
        return overlayLocales;
    L4:
        if (overlayLocales.isEmpty() == true) goto L8;
        return combineLocales(overlayLocales, baseLocales);
    }

    private static LocaleList combineLocales(LocaleList overlayLocales, LocaleList baseLocales) {
        Locale[] combinedLocales = new Locale[overlayLocales.size() + baseLocales.size()];
        int i = 0;
    L4:
        if (i >= overlayLocales.size()) goto L6;
        combinedLocales[i] = overlayLocales.get(i);
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= baseLocales.size()) goto L11;
        combinedLocales[overlayLocales.size() + i2] = baseLocales.get(i2);
        i2 = i2 + 1;
        goto L8
    L11:
        return new LocaleList(combinedLocales);
    }
}
