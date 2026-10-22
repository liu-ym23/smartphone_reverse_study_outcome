package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel_androidKt;
import com.bytedance.ee.bear.lynx.impl.globalbridge.FormatMethod;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/DatePickerFormatterImpl;", "Landroidx/compose/material3/DatePickerFormatter;", "yearSelectionSkeleton", "", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getYearSelectionSkeleton", "()Ljava/lang/String;", "getSelectedDateSkeleton", "getSelectedDateDescriptionSkeleton", "formatterCache", "", "", "formatMonthYear", "monthMillis", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Ljava/util/Locale;)Ljava/lang/String;", FormatMethod.FORMAT_DATE, "dateMillis", "forContentDescription", "", "(Ljava/lang/Long;Ljava/util/Locale;Z)Ljava/lang/String;", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DatePickerFormatterImpl implements DatePickerFormatter {
    private final Map<String, Object> formatterCache;
    private final String selectedDateDescriptionSkeleton;
    private final String selectedDateSkeleton;
    private final String yearSelectionSkeleton;

    public int hashCode() {
        return (((this.yearSelectionSkeleton.hashCode() * 31) + this.selectedDateSkeleton.hashCode()) * 31) + this.selectedDateDescriptionSkeleton.hashCode();
    }

    public final String getSelectedDateDescriptionSkeleton() {
        return this.selectedDateDescriptionSkeleton;
    }

    public final String getSelectedDateSkeleton() {
        return this.selectedDateSkeleton;
    }

    public final String getYearSelectionSkeleton() {
        return this.yearSelectionSkeleton;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DatePickerFormatterImpl) == true) goto L5;
        return false;
    L5:
        DatePickerFormatterImpl r101 = (DatePickerFormatterImpl) r100;
        if (Intrinsics.areEqual(this.yearSelectionSkeleton, r101.yearSelectionSkeleton) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.selectedDateSkeleton, r101.selectedDateSkeleton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.selectedDateDescriptionSkeleton, r101.selectedDateDescriptionSkeleton) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public String formatMonthYear(Long r100, Locale r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return CalendarModel_androidKt.formatWithSkeleton(r100.longValue(), this.yearSelectionSkeleton, r101, this.formatterCache);
    }

    public DatePickerFormatterImpl(String r100, String r101, String r102) {
        this.yearSelectionSkeleton = r100;
        this.selectedDateSkeleton = r101;
        this.selectedDateDescriptionSkeleton = r102;
        this.formatterCache = new LinkedHashMap();
    }

    @Override // androidx.compose.material3.DatePickerFormatter
    public String formatDate(Long r100, Locale r101, boolean r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        long r103 = r100.longValue();
        if (r102 == false) goto L8;
        String r104 = this.selectedDateDescriptionSkeleton;
    L10:
        return CalendarModel_androidKt.formatWithSkeleton(r103, r104, r101, this.formatterCache);
    L8:
        r104 = this.selectedDateSkeleton;
        goto L10
    }
}
