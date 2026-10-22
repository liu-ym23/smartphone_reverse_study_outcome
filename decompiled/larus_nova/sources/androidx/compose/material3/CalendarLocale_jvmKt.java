package androidx.compose.material3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.WeakHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\nH\u0000\u001a,\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0001j\u0002`\nH\u0002\"\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u000f"}, d2 = {"CalendarLocale", "Ljava/util/Locale;", "toLocalString", "", "", "minDigits", "maxDigits", "isGroupingUsed", "", "locale", "Landroidx/compose/material3/CalendarLocale;", "cachedFormatters", "Ljava/util/WeakHashMap;", "Ljava/text/NumberFormat;", "getCachedDateTimeFormatter", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CalendarLocale_jvmKt {
    private static final WeakHashMap<String, NumberFormat> cachedFormatters = null;

    static {
        cachedFormatters = new WeakHashMap();
    }

    private static final NumberFormat getCachedDateTimeFormatter(int r100, int r101, boolean r102, Locale r103) {
        String r104 = r100 + '.' + r101 + '.' + r102 + '.' + r103.toLanguageTag();
        WeakHashMap<String, NumberFormat> r105 = cachedFormatters;
        NumberFormat r106 = r105.get(r104);
        if (r106 != null) goto L6;
        r106 = NumberFormat.getIntegerInstance(r103);
        r106.setGroupingUsed(r102);
        r106.setMinimumIntegerDigits(r100);
        r106.setMaximumIntegerDigits(r101);
        r105.put(r104, r106);
    L6:
        return r106;
    }

    public static final String toLocalString(int r100, int r101, int r102, boolean r103, Locale r104) {
        if (r104 != null) goto L5;
        r104 = Locale.getDefault();
    L5:
        return getCachedDateTimeFormatter(r101, r102, r103, r104).format(Integer.valueOf(r100));
    }

    public static /* synthetic */ String toLocalString$default(int r100, int r101, int r102, boolean r103, Locale r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = 1;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = 40;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = false;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = null;
    L15:
        return toLocalString(r100, r101, r102, r103, r104);
    }
}
