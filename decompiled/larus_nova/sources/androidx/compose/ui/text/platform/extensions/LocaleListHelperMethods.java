package androidx.compose.ui.text.platform.extensions;

import android.text.style.LocaleSpan;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/platform/extensions/LocaleListHelperMethods;", "", "<init>", "()V", "localeSpan", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setTextLocales", "", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocaleListHelperMethods {
    public static final int $stable = 0;
    public static final LocaleListHelperMethods INSTANCE = null;

    static {
        INSTANCE = new LocaleListHelperMethods();
    }

    private LocaleListHelperMethods() {
    }

    public final Object localeSpan(LocaleList r100) {
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<Locale> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().getPlatformLocale());
        goto L4
    L6:
        java.util.Locale[] r103 = (java.util.Locale[]) r101.toArray(new java.util.Locale[0]);
        return new LocaleSpan(new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(r103, r103.length)));
    }

    public final void setTextLocales(AndroidTextPaint r100, LocaleList r101) {
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<Locale> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r103.next().getPlatformLocale());
        goto L4
    L6:
        java.util.Locale[] r104 = (java.util.Locale[]) r102.toArray(new java.util.Locale[0]);
        r100.setTextLocales(new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(r104, r104.length)));
    }
}
