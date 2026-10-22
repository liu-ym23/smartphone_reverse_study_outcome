package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/unit/LayoutDirection;", "", "<init>", "(Ljava/lang/String;I)V", "Ltr", "Rtl", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum LayoutDirection extends Enum<LayoutDirection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LayoutDirection[] $VALUES = null;
    public static final LayoutDirection Ltr = null;
    public static final LayoutDirection Rtl = null;

    private static final /* synthetic */ LayoutDirection[] $values() {
        return new LayoutDirection[]{Ltr, Rtl};
    }

    public static EnumEntries<LayoutDirection> getEntries() {
        return $ENTRIES;
    }

    static {
        Ltr = new LayoutDirection("Ltr", 0);
        Rtl = new LayoutDirection("Rtl", 1);
        LayoutDirection[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LayoutDirection[] values() {
        return (LayoutDirection[]) $VALUES.clone();
    }

    public static LayoutDirection valueOf(String r100) {
        return (LayoutDirection) a.a(LayoutDirection.class, r100);
    }

    private LayoutDirection(String r100, int r101) {
        super(r100, r101);
    }
}
