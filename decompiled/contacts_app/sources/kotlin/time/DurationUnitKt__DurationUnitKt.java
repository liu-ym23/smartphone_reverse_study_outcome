package kotlin.time;

import com.obric.oui.calendar.format.DayFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DurationUnit.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0001\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0001¨\u0006\t"}, d2 = {"durationUnitByIsoChar", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    /* JADX INFO: compiled from: DurationUnit.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DurationUnit.values().length];
            r0[DurationUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[DurationUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[DurationUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[DurationUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[DurationUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[DurationUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[DurationUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DurationUnitKt__DurationUnitKt() {
    }

    public static final String shortName(DurationUnit r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r3.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return DayFormatter.DEFAULT_FORMAT;
    L7:
        return "h";
    L8:
        return "m";
    L9:
        return "s";
    L10:
        return "ms";
    L11:
        return "us";
    L12:
        return "ns";
    L5:
        throw new IllegalStateException(("Unknown unit: " + r3).toString());
    }

    public static final DurationUnit durationUnitByShortName(String r3) {
        Intrinsics.checkNotNullParameter(r3, "shortName");
        int r0 = r3.hashCode();
        if (r0 == 100) goto L35;
        if (r0 == 104) goto L32;
        if (r0 == 109) goto L29;
        if (r0 == 115) goto L26;
        if (r0 == 3494) goto L23;
        if (r0 == 3525) goto L20;
        if (r0 != 3742) goto L39;
        if (r3.equals("us") == false) goto L39;
        return DurationUnit.MICROSECONDS;
    L39:
        throw new IllegalArgumentException("Unknown duration unit short name: " + r3);
    L20:
        if (r3.equals("ns") == false) goto L39;
        return DurationUnit.NANOSECONDS;
    L23:
        if (r3.equals("ms") == false) goto L39;
        return DurationUnit.MILLISECONDS;
    L26:
        if (r3.equals("s") == false) goto L39;
        return DurationUnit.SECONDS;
    L29:
        if (r3.equals("m") == false) goto L39;
        return DurationUnit.MINUTES;
    L32:
        if (r3.equals("h") == false) goto L39;
        return DurationUnit.HOURS;
    L35:
        if (r3.equals(DayFormatter.DEFAULT_FORMAT) == false) goto L39;
        return DurationUnit.DAYS;
    }

    public static final DurationUnit durationUnitByIsoChar(char r2, boolean r3) {
        if (r3 == true) goto L9;
        if (r2 != 'D') goto L7;
        return DurationUnit.DAYS;
    L7:
        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + r2);
    L9:
        if (r2 != 'H') goto L12;
        return DurationUnit.HOURS;
    L12:
        if (r2 != 'M') goto L15;
        return DurationUnit.MINUTES;
    L15:
        if (r2 != 'S') goto L19;
        return DurationUnit.SECONDS;
    L19:
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + r2);
    }
}
