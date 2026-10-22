package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/layout/Direction;", "", "<init>", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "Both", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Direction extends Enum<Direction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Direction[] $VALUES = null;
    public static final Direction Both = null;
    public static final Direction Horizontal = null;
    public static final Direction Vertical = null;

    private static final /* synthetic */ Direction[] $values() {
        return new Direction[]{Vertical, Horizontal, Both};
    }

    public static EnumEntries<Direction> getEntries() {
        return $ENTRIES;
    }

    static {
        Vertical = new Direction("Vertical", 0);
        Horizontal = new Direction("Horizontal", 1);
        Both = new Direction("Both", 2);
        Direction[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static Direction[] values() {
        return (Direction[]) $VALUES.clone();
    }

    public static Direction valueOf(String r100) {
        return (Direction) r27.a.a(Direction.class, r100);
    }

    private Direction(String r100, int r101) {
        super(r100, r101);
    }
}
