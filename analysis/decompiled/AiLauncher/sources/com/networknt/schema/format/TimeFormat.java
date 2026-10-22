package com.networknt.schema.format;

import com.networknt.schema.ExecutionContext;
import java.text.ParsePosition;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

/* loaded from: classes2.dex */
public class TimeFormat implements Format {
    private static final long MAX_OFFSET_MIN = 1439;
    private static final long MIN_OFFSET_MIN = -1439;
    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ISO_LOCAL_TIME).appendOffset("+HH:MM", "Z").parseLenient().toFormatter();

    private boolean isSpecialCaseLeapSecond(long j10, long j11, long j12) {
        return j10 == 60 && j11 == 59 && j12 == 23;
    }

    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.time";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "time";
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, String str) {
        int iIndexOf;
        TemporalAccessor unresolved;
        if (str == null) {
            return true;
        }
        try {
            iIndexOf = str.indexOf(90);
        } catch (DateTimeException unused) {
        }
        if ((-1 != iIndexOf && iIndexOf != str.length() - 1) || (unresolved = formatter.parseUnresolved(str, new ParsePosition(0))) == null) {
            return false;
        }
        long j10 = unresolved.getLong(ChronoField.OFFSET_SECONDS) / 60;
        if (MAX_OFFSET_MIN >= j10 && MIN_OFFSET_MIN <= j10) {
            long j11 = unresolved.getLong(ChronoField.HOUR_OF_DAY);
            long j12 = unresolved.getLong(ChronoField.MINUTE_OF_HOUR);
            long j13 = unresolved.getLong(ChronoField.SECOND_OF_MINUTE);
            if (j13 <= 59 && j12 <= 59 && j11 <= 23) {
                return true;
            }
            long j14 = j11 - (j10 / 60);
            long j15 = j12 - (j10 % 60);
            if (j15 < 0) {
                j14--;
                j15 += 60;
            }
            long j16 = j15;
            if (j14 < 0) {
                j14 += 24;
            }
            return isSpecialCaseLeapSecond(j13, j16, j14);
        }
        return false;
    }
}
