package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/gestures/Orientation;", "", "<init>", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Orientation extends Enum<Orientation> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Orientation[] $VALUES = null;
    public static final Orientation Horizontal = null;
    public static final Orientation Vertical = null;

    private static final /* synthetic */ Orientation[] $values() {
        return new Orientation[]{Vertical, Horizontal};
    }

    public static EnumEntries<Orientation> getEntries() {
        return $ENTRIES;
    }

    static {
        Vertical = new Orientation("Vertical", 0);
        Horizontal = new Orientation("Horizontal", 1);
        Orientation[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static Orientation[] values() {
        return (Orientation[]) $VALUES.clone();
    }

    public static Orientation valueOf(String r100) {
        return (Orientation) r27.a.a(Orientation.class, r100);
    }

    private Orientation(String r100, int r101) {
        super(r100, r101);
    }
}
