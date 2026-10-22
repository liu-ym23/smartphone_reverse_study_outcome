package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/text/style/ResolvedTextDirection;", "", "<init>", "(Ljava/lang/String;I)V", "Ltr", "Rtl", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ResolvedTextDirection extends Enum<ResolvedTextDirection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ResolvedTextDirection[] $VALUES = null;
    public static final ResolvedTextDirection Ltr = null;
    public static final ResolvedTextDirection Rtl = null;

    private static final /* synthetic */ ResolvedTextDirection[] $values() {
        return new ResolvedTextDirection[]{Ltr, Rtl};
    }

    public static EnumEntries<ResolvedTextDirection> getEntries() {
        return $ENTRIES;
    }

    static {
        Ltr = new ResolvedTextDirection("Ltr", 0);
        Rtl = new ResolvedTextDirection("Rtl", 1);
        ResolvedTextDirection[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ResolvedTextDirection[] values() {
        return (ResolvedTextDirection[]) $VALUES.clone();
    }

    public static ResolvedTextDirection valueOf(String r100) {
        return (ResolvedTextDirection) r27.a.a(ResolvedTextDirection.class, r100);
    }

    private ResolvedTextDirection(String r100, int r101) {
        super(r100, r101);
    }
}
