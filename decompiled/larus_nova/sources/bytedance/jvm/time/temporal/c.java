package bytedance.jvm.time.temporal;

import bytedance.jvm.time.DateTimeException;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class c {
    public static int a(d r100, j r101) {
        ValueRange r102 = r100.range(r101);
        if (r102.isIntValue() == false) goto L11;
        long r103 = r100.getLong(r101);
        if (r102.isValidValue(r103) == false) goto L9;
        return (int) r103;
    L9:
        throw new DateTimeException("Invalid value for " + r101 + " (valid values " + r102 + "): " + r103);
    L11:
        throw new UnsupportedTemporalTypeException("Invalid field " + r101 + " for get() method, use getLong() instead");
    }

    public static Object b(d r100, l r101) {
        if (r101 != k.f21714a) goto L5;
        return null;
    L5:
        if (r101 != k.f21715b) goto L7;
        return null;
    L7:
        if (r101 != k.f21716c) goto L10;
        return null;
    L10:
        return r101.a(r100);
    }

    public static ValueRange c(d r100, j r101) {
        if ((r101 instanceof ChronoField) == true) goto L5;
        Objects.requireNonNull(r101, "field");
        return r101.rangeRefinedBy(r100);
    L5:
        if (r100.isSupported(r101) == false) goto L9;
        return r101.range();
    L9:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r101);
    }
}
