package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/Invalidation;", "", "<init>", "(Ljava/lang/String;I)V", "LookaheadMeasurement", "LookaheadPlacement", "Measurement", "Placement", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Invalidation extends Enum<Invalidation> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Invalidation[] $VALUES = null;
    public static final Invalidation LookaheadMeasurement = null;
    public static final Invalidation LookaheadPlacement = null;
    public static final Invalidation Measurement = null;
    public static final Invalidation Placement = null;

    private static final /* synthetic */ Invalidation[] $values() {
        return new Invalidation[]{LookaheadMeasurement, LookaheadPlacement, Measurement, Placement};
    }

    public static EnumEntries<Invalidation> getEntries() {
        return $ENTRIES;
    }

    static {
        LookaheadMeasurement = new Invalidation("LookaheadMeasurement", 0);
        LookaheadPlacement = new Invalidation("LookaheadPlacement", 1);
        Measurement = new Invalidation("Measurement", 2);
        Placement = new Invalidation("Placement", 3);
        Invalidation[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static Invalidation[] values() {
        return (Invalidation[]) $VALUES.clone();
    }

    public static Invalidation valueOf(String r100) {
        return (Invalidation) r27.a.a(Invalidation.class, r100);
    }

    private Invalidation(String r100, int r101) {
        super(r100, r101);
    }
}
