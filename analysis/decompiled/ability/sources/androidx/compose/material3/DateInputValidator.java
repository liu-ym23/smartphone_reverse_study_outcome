package androidx.compose.material3;

import Y7.f;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Stable
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u001d\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00162\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u0019ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\"R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\"R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"Landroidx/compose/material3/DateInputValidator;", "", "LY7/f;", "yearRange", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "Landroidx/compose/material3/internal/DateInputFormat;", "dateInputFormat", "Landroidx/compose/material3/DatePickerFormatter;", "dateFormatter", "", "errorDatePattern", "errorDateOutOfYearRange", "errorInvalidNotAllowed", "errorInvalidRangeInput", "", "currentStartDateMillis", "currentEndDateMillis", AppAgent.CONSTRUCT, "(LY7/f;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/DateInputFormat;Landroidx/compose/material3/DatePickerFormatter;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "Landroidx/compose/material3/internal/CalendarDate;", "dateToValidate", "Landroidx/compose/material3/InputIdentifier;", "inputIdentifier", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "locale", "validate-XivgLIo", "(Landroidx/compose/material3/internal/CalendarDate;ILjava/util/Locale;)Ljava/lang/String;", "validate", "LY7/f;", "Landroidx/compose/material3/SelectableDates;", "Landroidx/compose/material3/internal/DateInputFormat;", "Landroidx/compose/material3/DatePickerFormatter;", "Ljava/lang/String;", "Ljava/lang/Long;", "getCurrentStartDateMillis$material3_release", "()Ljava/lang/Long;", "setCurrentStartDateMillis$material3_release", "(Ljava/lang/Long;)V", "getCurrentEndDateMillis$material3_release", "setCurrentEndDateMillis$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
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
    private final f yearRange;

    public DateInputValidator(f fVar, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l5) {
        this.yearRange = fVar;
        this.selectableDates = selectableDates;
        this.dateInputFormat = dateInputFormat;
        this.dateFormatter = datePickerFormatter;
        this.errorDatePattern = str;
        this.errorDateOutOfYearRange = str2;
        this.errorInvalidNotAllowed = str3;
        this.errorInvalidRangeInput = str4;
        this.currentStartDateMillis = l;
        this.currentEndDateMillis = l5;
    }

    /* renamed from: getCurrentEndDateMillis$material3_release, reason: from getter */
    public final Long getCurrentEndDateMillis() {
        return this.currentEndDateMillis;
    }

    /* renamed from: getCurrentStartDateMillis$material3_release, reason: from getter */
    public final Long getCurrentStartDateMillis() {
        return this.currentStartDateMillis;
    }

    public final void setCurrentEndDateMillis$material3_release(Long l) {
        this.currentEndDateMillis = l;
    }

    public final void setCurrentStartDateMillis$material3_release(Long l) {
        this.currentStartDateMillis = l;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
    /* renamed from: validate-XivgLIo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m1739validateXivgLIo(androidx.compose.material3.internal.CalendarDate r8, int r9, java.util.Locale r10) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != 0) goto L24
            java.lang.String r8 = r7.errorDatePattern
            androidx.compose.material3.internal.DateInputFormat r7 = r7.dateInputFormat
            java.lang.String r7 = r7.getPatternWithDelimiters()
            java.util.Locale r9 = java.util.Locale.ROOT
            java.lang.String r7 = r7.toUpperCase(r9)
            java.lang.String r9 = "this as java.lang.String).toUpperCase(Locale.ROOT)"
            kotlin.jvm.internal.k.e(r7, r9)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.lang.String r7 = java.lang.String.format(r8, r7)
            return r7
        L24:
            Y7.f r1 = r7.yearRange
            int r2 = r8.getYear()
            boolean r1 = r1.e(r2)
            if (r1 != 0) goto L55
            java.lang.String r8 = r7.errorDateOutOfYearRange
            Y7.f r9 = r7.yearRange
            int r0 = r9.f1569a
            r4 = 7
            r5 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            java.lang.String r9 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r0, r1, r2, r3, r4, r5)
            Y7.f r7 = r7.yearRange
            int r0 = r7.b
            java.lang.String r7 = androidx.compose.material3.CalendarLocale_jvmKt.toLocalString$default(r0, r1, r2, r3, r4, r5)
            java.lang.Object[] r7 = new java.lang.Object[]{r9, r7}
            r9 = 2
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r9)
            java.lang.String r7 = java.lang.String.format(r8, r7)
            return r7
        L55:
            androidx.compose.material3.SelectableDates r1 = r7.selectableDates
            int r2 = r8.getYear()
            boolean r2 = r1.isSelectableYear(r2)
            if (r2 == 0) goto Lb1
            long r2 = r8.getUtcTimeMillis()
            boolean r1 = r1.isSelectableDate(r2)
            if (r1 != 0) goto L6c
            goto Lb1
        L6c:
            androidx.compose.material3.InputIdentifier$Companion r10 = androidx.compose.material3.InputIdentifier.INSTANCE
            int r0 = r10.m1935getStartDateInputJ2x2o4M()
            boolean r0 = androidx.compose.material3.InputIdentifier.m1929equalsimpl0(r9, r0)
            if (r0 == 0) goto L8e
            long r0 = r8.getUtcTimeMillis()
            java.lang.Long r2 = r7.currentEndDateMillis
            if (r2 == 0) goto L85
            long r2 = r2.longValue()
            goto L8a
        L85:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L8a:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto Lab
        L8e:
            int r10 = r10.m1933getEndDateInputJ2x2o4M()
            boolean r9 = androidx.compose.material3.InputIdentifier.m1929equalsimpl0(r9, r10)
            if (r9 == 0) goto Lae
            long r8 = r8.getUtcTimeMillis()
            java.lang.Long r10 = r7.currentStartDateMillis
            if (r10 == 0) goto La5
            long r0 = r10.longValue()
            goto La7
        La5:
            r0 = -9223372036854775808
        La7:
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 >= 0) goto Lae
        Lab:
            java.lang.String r7 = r7.errorInvalidRangeInput
            return r7
        Lae:
            java.lang.String r7 = ""
            return r7
        Lb1:
            java.lang.String r9 = r7.errorInvalidNotAllowed
            androidx.compose.material3.DatePickerFormatter r1 = r7.dateFormatter
            long r7 = r8.getUtcTimeMillis()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r5 = 4
            r6 = 0
            r4 = 0
            r3 = r10
            java.lang.String r7 = androidx.compose.material3.DatePickerFormatter.formatDate$default(r1, r2, r3, r4, r5, r6)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.lang.String r7 = java.lang.String.format(r9, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputValidator.m1739validateXivgLIo(androidx.compose.material3.internal.CalendarDate, int, java.util.Locale):java.lang.String");
    }

    public /* synthetic */ DateInputValidator(f fVar, SelectableDates selectableDates, DateInputFormat dateInputFormat, DatePickerFormatter datePickerFormatter, String str, String str2, String str3, String str4, Long l, Long l5, int i, e eVar) {
        this(fVar, selectableDates, dateInputFormat, datePickerFormatter, str, str2, str3, str4, (i & 256) != 0 ? null : l, (i & 512) != 0 ? null : l5);
    }
}
