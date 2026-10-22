package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/TimePickerSelectionMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class TimePickerSelectionMode {
    public static final Companion Companion = null;
    private static final int Hour = 0;
    private static final int Minute = 0;
    private final int value;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/TimePickerSelectionMode$Companion;", "", "<init>", "()V", "Hour", "Landroidx/compose/material3/TimePickerSelectionMode;", "getHour-yecRtBI", "()I", "I", "Minute", "getMinute-yecRtBI", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getHour-yecRtBI, reason: not valid java name */
        public final int m2921getHouryecRtBI() {
            return TimePickerSelectionMode.access$getHour$cp();
        }

        /* JADX INFO: renamed from: getMinute-yecRtBI, reason: not valid java name */
        public final int m2922getMinuteyecRtBI() {
            return TimePickerSelectionMode.access$getMinute$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TimePickerSelectionMode m2914boximpl(int r100) {
        return new TimePickerSelectionMode(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    private static int m2915constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m2916equalsimpl(int r100, Object r101) {
        if ((r101 instanceof TimePickerSelectionMode) == true) goto L6;
        return false;
    L6:
        if (r100 == ((TimePickerSelectionMode) r101).m2920unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2917equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m2918hashCodeimpl(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m2916equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m2918hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2920unboximpl() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        Hour = m2915constructorimpl(0);
        Minute = m2915constructorimpl(1);
    }

    public String toString() {
        return m2919toStringimpl(this.value);
    }

    public static final /* synthetic */ int access$getHour$cp() {
        return Hour;
    }

    public static final /* synthetic */ int access$getMinute$cp() {
        return Minute;
    }

    public final int getValue() {
        return this.value;
    }

    private /* synthetic */ TimePickerSelectionMode(int r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m2919toStringimpl(int r100) {
        if (m2917equalsimpl0(r100, Hour) == false) goto L6;
        return "Hour";
    L6:
        if (m2917equalsimpl0(r100, Minute) == false) goto L8;
        return "Minute";
    L8:
        return "";
    }
}
