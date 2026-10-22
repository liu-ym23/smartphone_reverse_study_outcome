package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidStringDelegate_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"toUpperCase", "", "locale", "Landroidx/compose/ui/text/intl/Locale;", "toLowerCase", "capitalize", "decapitalize", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "stringDelegate", "Landroidx/compose/ui/text/PlatformStringDelegate;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StringKt {
    private static final PlatformStringDelegate stringDelegate = null;

    static {
        stringDelegate = AndroidStringDelegate_androidKt.ActualStringDelegate();
    }

    public static final String capitalize(String r100, LocaleList r101) {
        if (r101.isEmpty() == false) goto L5;
        Locale r102 = Locale.Companion.getCurrent();
    L7:
        return capitalize(r100, r102);
    L5:
        r102 = r101.get(0);
        goto L7
    }

    public static final String decapitalize(String r100, LocaleList r101) {
        if (r101.isEmpty() == false) goto L5;
        Locale r102 = Locale.Companion.getCurrent();
    L7:
        return decapitalize(r100, r102);
    L5:
        r102 = r101.get(0);
        goto L7
    }

    public static final String toLowerCase(String r100, LocaleList r101) {
        if (r101.isEmpty() == false) goto L5;
        Locale r102 = Locale.Companion.getCurrent();
    L7:
        return toLowerCase(r100, r102);
    L5:
        r102 = r101.get(0);
        goto L7
    }

    public static final String toUpperCase(String r100, LocaleList r101) {
        if (r101.isEmpty() == false) goto L5;
        Locale r102 = Locale.Companion.getCurrent();
    L7:
        return toUpperCase(r100, r102);
    L5:
        r102 = r101.get(0);
        goto L7
    }

    public static final String capitalize(String r100, Locale r101) {
        return stringDelegate.capitalize(r100, r101.getPlatformLocale());
    }

    public static final String decapitalize(String r100, Locale r101) {
        return stringDelegate.decapitalize(r100, r101.getPlatformLocale());
    }

    public static final String toLowerCase(String r100, Locale r101) {
        return stringDelegate.toLowerCase(r100, r101.getPlatformLocale());
    }

    public static final String toUpperCase(String r100, Locale r101) {
        return stringDelegate.toUpperCase(r100, r101.getPlatformLocale());
    }
}
