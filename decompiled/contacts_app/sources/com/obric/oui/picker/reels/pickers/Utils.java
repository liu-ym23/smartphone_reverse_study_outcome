package com.obric.oui.picker.reels.pickers;

import android.content.Context;
import com.obric.common.oui.R;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J4\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004J0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0004J\n\u0010\u0019\u001a\u00020\u0004*\u00020\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/picker/reels/pickers/Utils;", "", "()V", "dayCount", "", "month", "isLeapYear", "", "defaultDateFormatter", "", "date", "Ljava/time/LocalDate;", "generateDateRange", "", "start", "to", "formatter", "Ljava/util/function/Function;", "generateMonthRange", "context", "Landroid/content/Context;", "generateRange", "suffix", "paddedLen", "year", "toShortRepr", "Ljava/time/DayOfWeek;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Utils {
    public static final Utils INSTANCE = null;

    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DayOfWeek.values().length];
            r0[DayOfWeek.MONDAY.ordinal()] = 1;
            r0[DayOfWeek.TUESDAY.ordinal()] = 2;
            r0[DayOfWeek.WEDNESDAY.ordinal()] = 3;
            r0[DayOfWeek.THURSDAY.ordinal()] = 4;
            r0[DayOfWeek.FRIDAY.ordinal()] = 5;
            r0[DayOfWeek.SATURDAY.ordinal()] = 6;
            r0[DayOfWeek.SUNDAY.ordinal()] = 7;
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ String $r8$lambda$KEMVXKUS00Q0I4PKfNOZEuN9pfQ(LocalDate r0) {
        return m584generateDateRange$lambda0(r0);
    }

    static {
        INSTANCE = new Utils();
    }

    public final int dayCount(int r1, boolean r2) {
        if (r1 != 1) goto L5;
    L22:
        return 31;
    L5:
        if (r1 != 2) goto L7;
        if (r2 == false) goto L21;
        return 29;
    L21:
        return 28;
    L7:
        if (r1 == 3) goto L22;
        if (r1 == 5) goto L22;
        if (r1 == 10) goto L22;
        if (r1 == 12) goto L22;
        if (r1 == 7) goto L22;
        if (r1 == 8) goto L22;
        return 30;
    }

    private Utils() {
    }

    public static /* synthetic */ List generateRange$default(Utils r0, int r1, int r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = 2;
    L9:
        return r0.generateRange(r1, r2, r3, r4);
    }

    public final List<String> generateRange(int r4, int r5, String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "suffix");
        ArrayList r3 = new ArrayList();
        if (r4 > r5) goto L8;
    L4:
        int r0 = r4 + 1;
        r3.add(Intrinsics.stringPlus(StringsKt.padStart(String.valueOf(r4), r7, '0'), r6));
        if (r4 == r5) goto L8;
        r4 = r0;
    L8:
        return r3;
    }

    public final List<String> generateMonthRange(Context r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ArrayList r3 = new ArrayList();
        if (r5 > r6) goto L23;
    L4:
        int r0 = r5 + 1;
        switch(r5) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L6:
        int r1 = R.string.oui_reel_picker_month_def;
    L19:
        String r2 = r4.getString(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "context.getString(monthRes)");
        r3.add(r2);
        if (r5 == r6) goto L23;
        r5 = r0;
        goto L4
    L7:
        r1 = R.string.oui_reel_picker_month_dec;
        goto L19
    L8:
        r1 = R.string.oui_reel_picker_month_nov;
        goto L19
    L9:
        r1 = R.string.oui_reel_picker_month_oct;
        goto L19
    L10:
        r1 = R.string.oui_reel_picker_month_sep;
        goto L19
    L11:
        r1 = R.string.oui_reel_picker_month_aug;
        goto L19
    L12:
        r1 = R.string.oui_reel_picker_month_jul;
        goto L19
    L13:
        r1 = R.string.oui_reel_picker_month_jun;
        goto L19
    L14:
        r1 = R.string.oui_reel_picker_month_may;
        goto L19
    L15:
        r1 = R.string.oui_reel_picker_month_apr;
        goto L19
    L16:
        r1 = R.string.oui_reel_picker_month_mar;
        goto L19
    L17:
        r1 = R.string.oui_reel_picker_month_feb;
        goto L19
    L18:
        r1 = R.string.oui_reel_picker_month_jan;
    L23:
        return r3;
    }

    public final int toShortRepr(DayOfWeek r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r1.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return R.string.oui_reel_picker_month_day_sun;
    L15:
        return R.string.oui_reel_picker_month_day_sat;
    L16:
        return R.string.oui_reel_picker_month_day_fri;
    L17:
        return R.string.oui_reel_picker_month_day_thu;
    L18:
        return R.string.oui_reel_picker_month_day_wed;
    L19:
        return R.string.oui_reel_picker_month_day_tue;
    L13:
        return R.string.oui_reel_picker_month_day_mon;
    }

    private final String defaultDateFormatter(LocalDate r1) {
        String r0 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "date.toString()");
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List generateDateRange$default(Utils r0, LocalDate r1, LocalDate r2, Function r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.generateDateRange(r1, r2, r3);
    }

    public final List<String> generateDateRange(LocalDate r3, LocalDate r4, Function<LocalDate, String> r5) {
        Intrinsics.checkNotNullParameter(r3, "start");
        Intrinsics.checkNotNullParameter(r4, "to");
        ArrayList r2 = new ArrayList();
        if (r5 != null) goto L6;
        r5 = new Utils$$ExternalSyntheticLambda0();
    L6:
        if (r3.isBefore(r4) == false) goto L8;
        String r0 = r5.apply(r3);
        Intrinsics.checkNotNullExpressionValue(r0, "fmt.apply(ii)");
        r2.add(r0);
        r3 = r3.plusDays(1);
        Intrinsics.checkNotNullExpressionValue(r3, "ii.plusDays(1)");
        goto L6
    L8:
        String r6 = r5.apply(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "fmt.apply(ii)");
        r2.add(r6);
        return r2;
    }

    /* JADX INFO: renamed from: generateDateRange$lambda-0, reason: not valid java name */
    private static final String m584generateDateRange$lambda0(LocalDate r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return INSTANCE.defaultDateFormatter(r1);
    }

    public final boolean isLeapYear(int r1) {
        if ((r1 % 4) != 0) goto L7;
        if ((r1 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r1 % 400) == 0) goto L8;
        return false;
    }

    public static /* synthetic */ int dayCount$default(Utils r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.dayCount(r1, r2);
    }
}
