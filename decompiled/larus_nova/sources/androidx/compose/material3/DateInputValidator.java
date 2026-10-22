package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060!j\u0002`\"¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016¨\u0006%"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "errorDatePattern", "", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "currentStartDateMillis", "", "getCurrentStartDateMillis", "()Ljava/lang/Long;", "setCurrentStartDateMillis", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "currentEndDateMillis", "getCurrentEndDateMillis", "setCurrentEndDateMillis", com.alipay.sdk.m.l.c.f25505j, "dateToValidate", "Landroidx/compose/material3/internal/CalendarDate;", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DateInputValidator {
    public static final int $stable = 0;
    private Long currentEndDateMillis;
    private Long currentStartDateMillis;
    private final DatePickerFormatter dateFormatter;
    private final DateInputFormat dateInputFormat;
    private final String errorDateOutOfYearRange;
    private final String errorDatePattern;
    private final String errorInvalidNotAllowed;
    private final String errorInvalidRangeInput;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentEndDateMillis(Long r100) {
        this.currentEndDateMillis = r100;
    }

    public final void setCurrentStartDateMillis(Long r100) {
        this.currentStartDateMillis = r100;
    }

    /* JADX INFO: renamed from: validate-XivgLIo, reason: not valid java name */
    public final String m2095validateXivgLIo(CalendarDate r110, int r111, Locale r112) {
        if (r110 != null) goto L7;
        return Strings_androidKt.formatString(this.errorDatePattern, new Object[]{this.dateInputFormat.getPatternWithDelimiters().toUpperCase(Locale.ROOT)});
    L7:
        if (this.yearRange.contains(r110.getYear()) == false) goto L9;
        SelectableDates r100 = this.selectableDates;
        if (r100.isSelectableYear(r110.getYear()) == false) goto L36;
        if (r100.isSelectableDate(r110.getUtcTimeMillis()) == false) goto L36;
        InputIdentifier.Companion r113 = InputIdentifier.Companion;
        if (InputIdentifier.m2325equalsimpl0(r111, r113.m2331getStartDateInputJ2x2o4M()) == false) goto L24;
        long r101 = r110.getUtcTimeMillis();
        Long r102 = this.currentEndDateMillis;
        if (r102 == null) goto L20;
        long r103 = r102.longValue();
    L22:
        if (r101 <= r103) goto L24;
    L32:
        return this.errorInvalidRangeInput;
    L20:
        r103 = Long.MAX_VALUE;
    L24:
        if (InputIdentifier.m2325equalsimpl0(r111, r113.m2329getEndDateInputJ2x2o4M()) == false) goto L33;
        long r114 = r110.getUtcTimeMillis();
        Long r115 = this.currentStartDateMillis;
        if (r115 == null) goto L28;
        long r104 = r115.longValue();
    L30:
        if (r114 < r104) goto L32;
        return "";
    L28:
        r104 = Long.MIN_VALUE;
        goto L30
    L33:
        return "";
    L36:
        return Strings_androidKt.formatString(this.errorInvalidNotAllowed, new Object[]{DatePickerFormatter.CC.formatDate$default(this.dateFormatter, Long.valueOf(r110.getUtcTimeMillis()), r112, false, 4, null)});
    L9:
        return Strings_androidKt.formatString(this.errorDateOutOfYearRange, new Object[]{CalendarLocale_jvmKt.toLocalString$default(this.yearRange.getFirst(), 0, 0, false, r112, 7, null), CalendarLocale_jvmKt.toLocalString$default(this.yearRange.getLast(), 0, 0, false, r112, 7, null)});
    }

    public DateInputValidator(IntRange r100, SelectableDates r101, DateInputFormat r102, DatePickerFormatter r103, String r104, String r105, String r106, String r107) {
        this.yearRange = r100;
        this.selectableDates = r101;
        this.dateInputFormat = r102;
        this.dateFormatter = r103;
        this.errorDatePattern = r104;
        this.errorDateOutOfYearRange = r105;
        this.errorInvalidNotAllowed = r106;
        this.errorInvalidRangeInput = r107;
    }
}
