package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material/TabSlots;", "", "<init>", "(Ljava/lang/String;I)V", "Tabs", "Divider", "Indicator", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum TabSlots extends Enum<TabSlots> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TabSlots[] $VALUES = null;
    public static final TabSlots Divider = null;
    public static final TabSlots Indicator = null;
    public static final TabSlots Tabs = null;

    private static final /* synthetic */ TabSlots[] $values() {
        return new TabSlots[]{Tabs, Divider, Indicator};
    }

    public static EnumEntries<TabSlots> getEntries() {
        return $ENTRIES;
    }

    static {
        Tabs = new TabSlots("Tabs", 0);
        Divider = new TabSlots("Divider", 1);
        Indicator = new TabSlots("Indicator", 2);
        TabSlots[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TabSlots[] values() {
        return (TabSlots[]) $VALUES.clone();
    }

    public static TabSlots valueOf(String r100) {
        return (TabSlots) r27.a.a(TabSlots.class, r100);
    }

    private TabSlots(String r100, int r101) {
        super(r100, r101);
    }
}
