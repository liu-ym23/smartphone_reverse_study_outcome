package z7;

import java.text.ParsePosition;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFormatter f16482a = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ISO_LOCAL_TIME).appendOffset("+HH:MM", "Z").parseLenient().toFormatter();

    @Override // z7.d
    public final String a() {
        return "format.time";
    }

    @Override // z7.d
    public final String getName() {
        return "time";
    }

    @Override // z7.d
    public final boolean matches(String str) {
        TemporalAccessor unresolved;
        if (str != null) {
            try {
                int iIndexOf = str.indexOf(90);
                if ((-1 == iIndexOf || iIndexOf == str.length() - 1) && (unresolved = f16482a.parseUnresolved(str, new ParsePosition(0))) != null) {
                    long j10 = unresolved.getLong(ChronoField.OFFSET_SECONDS) / 60;
                    if (1439 >= j10 && -1439 <= j10) {
                        long j11 = unresolved.getLong(ChronoField.HOUR_OF_DAY);
                        long j12 = unresolved.getLong(ChronoField.MINUTE_OF_HOUR);
                        long j13 = unresolved.getLong(ChronoField.SECOND_OF_MINUTE);
                        if (j13 > 59 || j12 > 59 || j11 > 23) {
                            long j14 = j11 - (j10 / 60);
                            long j15 = j12 - (j10 % 60);
                            if (j15 < 0) {
                                j14--;
                                j15 += 60;
                            }
                            if (j14 < 0) {
                                j14 += 24;
                            }
                            if (j13 != 60 || j15 != 59 || j14 != 23) {
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
