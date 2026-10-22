package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/tooling/InvalidationKind;", "", "<init>", "(Ljava/lang/String;I)V", "Remeasure", "Relayout", "Redraw", "ObserverNode", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum InvalidationKind extends Enum<InvalidationKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InvalidationKind[] $VALUES = null;
    public static final InvalidationKind ObserverNode = null;
    public static final InvalidationKind Redraw = null;
    public static final InvalidationKind Relayout = null;
    public static final InvalidationKind Remeasure = null;

    private static final /* synthetic */ InvalidationKind[] $values() {
        return new InvalidationKind[]{Remeasure, Relayout, Redraw, ObserverNode};
    }

    public static EnumEntries<InvalidationKind> getEntries() {
        return $ENTRIES;
    }

    static {
        Remeasure = new InvalidationKind("Remeasure", 0);
        Relayout = new InvalidationKind("Relayout", 1);
        Redraw = new InvalidationKind("Redraw", 2);
        ObserverNode = new InvalidationKind("ObserverNode", 3);
        InvalidationKind[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static InvalidationKind[] values() {
        return (InvalidationKind[]) $VALUES.clone();
    }

    public static InvalidationKind valueOf(String r100) {
        return (InvalidationKind) r27.a.a(InvalidationKind.class, r100);
    }

    private InvalidationKind(String r100, int r101) {
        super(r100, r101);
    }
}
