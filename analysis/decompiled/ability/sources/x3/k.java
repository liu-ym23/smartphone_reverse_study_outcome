package x3;

import java.text.ParsePosition;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/* loaded from: classes3.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFormatter f6880a = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ISO_LOCAL_TIME).appendOffset("+HH:MM", "Z").parseLenient().toFormatter();

    @Override // x3.d
    public final String a() {
        return "format.time";
    }

    @Override // x3.d
    public final String getName() {
        return "time";
    }

    @Override // x3.d
    public final boolean matches(String str) {
        TemporalAccessor unresolved;
        if (str != null) {
            try {
                int iIndexOf = str.indexOf(90);
                if ((-1 == iIndexOf || iIndexOf == str.length() - 1) && (unresolved = f6880a.parseUnresolved(str, new ParsePosition(0))) != null) {
                    long j5 = unresolved.getLong(ChronoField.OFFSET_SECONDS) / 60;
                    if (1439 >= j5 && -1439 <= j5) {
                        long j6 = unresolved.getLong(ChronoField.HOUR_OF_DAY);
                        long j10 = unresolved.getLong(ChronoField.MINUTE_OF_HOUR);
                        long j11 = unresolved.getLong(ChronoField.SECOND_OF_MINUTE);
                        if (j11 > 59 || j10 > 59 || j6 > 23) {
                            long j12 = j6 - (j5 / 60);
                            long j13 = j10 - (j5 % 60);
                            if (j13 < 0) {
                                j12--;
                                j13 += 60;
                            }
                            if (j12 < 0) {
                                j12 += 24;
                            }
                            if (j11 != 60 || j13 != 59 || j12 != 23) {
                            }
                        }
                    }
                }
            } catch (DateTimeException unused) {
            }
            return false;
        }
        return true;
    }
}
