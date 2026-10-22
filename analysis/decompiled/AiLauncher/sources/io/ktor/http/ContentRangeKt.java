package io.ktor.http;

import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.util.date.GMTDateParser;
import kotlin.Metadata;
import v9.C5683l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lv9/l;", "range", "", "fullLength", "Lio/ktor/http/RangeUnits;", "unit", "", "contentRangeHeaderValue", "(Lv9/l;Ljava/lang/Long;Lio/ktor/http/RangeUnits;)Ljava/lang/String;", "(Lv9/l;Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContentRangeKt {
    public static final String contentRangeHeaderValue(C5683l c5683l, Long l10, RangeUnits unit) {
        kotlin.jvm.internal.p.i(unit, "unit");
        return contentRangeHeaderValue(c5683l, l10, unit.getUnitToken());
    }

    public static /* synthetic */ String contentRangeHeaderValue$default(C5683l c5683l, Long l10, RangeUnits rangeUnits, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            rangeUnits = RangeUnits.Bytes;
        }
        return contentRangeHeaderValue(c5683l, l10, rangeUnits);
    }

    public static final String contentRangeHeaderValue(C5683l c5683l, Long l10, String unit) {
        kotlin.jvm.internal.p.i(unit, "unit");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(unit);
        sb2.append(" ");
        if (c5683l != null) {
            sb2.append(c5683l.getFirst());
            sb2.append('-');
            sb2.append(c5683l.getLast());
        } else {
            sb2.append(GMTDateParser.ANY);
        }
        sb2.append(JsonPointer.SEPARATOR);
        Object obj = l10;
        if (l10 == null) {
            obj = "*";
        }
        sb2.append(obj);
        return sb2.toString();
    }

    public static /* synthetic */ String contentRangeHeaderValue$default(C5683l c5683l, Long l10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str = RangeUnits.Bytes.getUnitToken();
        }
        return contentRangeHeaderValue(c5683l, l10, str);
    }
}
