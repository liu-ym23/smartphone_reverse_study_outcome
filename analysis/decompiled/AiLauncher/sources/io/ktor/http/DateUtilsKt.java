package io.ktor.http;

import Z8.C1173v;
import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDateParser;
import io.ktor.util.date.InvalidDateStringException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\"\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "Lio/ktor/util/date/GMTDate;", "fromHttpToGmtDate", "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "fromCookieToGmtDate", "toHttpDate", "(Lio/ktor/util/date/GMTDate;)Ljava/lang/String;", "", "length", "padZero", "(II)Ljava/lang/String;", "", "HTTP_DATE_FORMATS", "Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DateUtilsKt {
    private static final List<String> HTTP_DATE_FORMATS = C1173v.p("***, dd MMM YYYY hh:mm:ss zzz", "****, dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d hh:mm:ss YYYY", "***, dd-MMM-YYYY hh:mm:ss zzz", "***, dd-MMM-YYYY hh-mm-ss zzz", "***, dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh:mm:ss zzz", "*** dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh-mm-ss zzz", "***,dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d YYYY hh:mm:ss zzz");

    public static final GMTDate fromCookieToGmtDate(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        String string = La.H.D1(str).toString();
        try {
            return new CookieDateParser().parse(string);
        } catch (InvalidCookieDateException unused) {
            return fromHttpToGmtDate(string);
        }
    }

    public static final GMTDate fromHttpToGmtDate(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        String string = La.H.D1(str).toString();
        Iterator<String> it = HTTP_DATE_FORMATS.iterator();
        while (it.hasNext()) {
            try {
                return new GMTDateParser(it.next()).parse(str);
            } catch (InvalidDateStringException unused) {
            }
        }
        throw new IllegalStateException(("Failed to parse date: " + string).toString());
    }

    private static final String padZero(int i10, int i11) {
        return La.H.J0(String.valueOf(i10), i11, '0');
    }

    public static final String toHttpDate(GMTDate gMTDate) {
        kotlin.jvm.internal.p.i(gMTDate, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(gMTDate.getDayOfWeek().getValue() + ", ");
        sb2.append(padZero(gMTDate.getDayOfMonth(), 2) + ' ');
        sb2.append(gMTDate.getMonth().getValue() + ' ');
        sb2.append(padZero(gMTDate.getYear(), 4));
        sb2.append(' ' + padZero(gMTDate.getHours(), 2) + ':' + padZero(gMTDate.getMinutes(), 2) + ':' + padZero(gMTDate.getSeconds(), 2) + ' ');
        sb2.append("GMT");
        return sb2.toString();
    }
}
