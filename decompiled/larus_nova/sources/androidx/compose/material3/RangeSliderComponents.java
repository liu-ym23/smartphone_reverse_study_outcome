package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/RangeSliderComponents;", "", "<init>", "(Ljava/lang/String;I)V", "ENDTHUMB", "STARTTHUMB", "TRACK", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum RangeSliderComponents extends Enum<RangeSliderComponents> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RangeSliderComponents[] $VALUES = null;
    public static final RangeSliderComponents ENDTHUMB = null;
    public static final RangeSliderComponents STARTTHUMB = null;
    public static final RangeSliderComponents TRACK = null;

    private static final /* synthetic */ RangeSliderComponents[] $values() {
        return new RangeSliderComponents[]{ENDTHUMB, STARTTHUMB, TRACK};
    }

    public static EnumEntries<RangeSliderComponents> getEntries() {
        return $ENTRIES;
    }

    static {
        ENDTHUMB = new RangeSliderComponents("ENDTHUMB", 0);
        STARTTHUMB = new RangeSliderComponents("STARTTHUMB", 1);
        TRACK = new RangeSliderComponents("TRACK", 2);
        RangeSliderComponents[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static RangeSliderComponents[] values() {
        return (RangeSliderComponents[]) $VALUES.clone();
    }

    public static RangeSliderComponents valueOf(String r100) {
        return (RangeSliderComponents) r27.a.a(RangeSliderComponents.class, r100);
    }

    private RangeSliderComponents(String r100, int r101) {
        super(r100, r101);
    }
}
