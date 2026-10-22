package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material3/DrawerValue;", "", "<init>", "(Ljava/lang/String;I)V", "Closed", "Open", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum DrawerValue extends Enum<DrawerValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DrawerValue[] $VALUES = null;
    public static final DrawerValue Closed = null;
    public static final DrawerValue Open = null;

    private static final /* synthetic */ DrawerValue[] $values() {
        return new DrawerValue[]{Closed, Open};
    }

    public static EnumEntries<DrawerValue> getEntries() {
        return $ENTRIES;
    }

    static {
        Closed = new DrawerValue("Closed", 0);
        Open = new DrawerValue("Open", 1);
        DrawerValue[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DrawerValue[] values() {
        return (DrawerValue[]) $VALUES.clone();
    }

    public static DrawerValue valueOf(String r100) {
        return (DrawerValue) r27.a.a(DrawerValue.class, r100);
    }

    private DrawerValue(String r100, int r101) {
        super(r100, r101);
    }
}
