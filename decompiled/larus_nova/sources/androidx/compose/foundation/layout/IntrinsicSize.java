package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicSize;", "", "<init>", "(Ljava/lang/String;I)V", "Min", "Max", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum IntrinsicSize extends Enum<IntrinsicSize> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IntrinsicSize[] $VALUES = null;
    public static final IntrinsicSize Max = null;
    public static final IntrinsicSize Min = null;

    private static final /* synthetic */ IntrinsicSize[] $values() {
        return new IntrinsicSize[]{Min, Max};
    }

    public static EnumEntries<IntrinsicSize> getEntries() {
        return $ENTRIES;
    }

    static {
        Min = new IntrinsicSize("Min", 0);
        Max = new IntrinsicSize("Max", 1);
        IntrinsicSize[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IntrinsicSize[] values() {
        return (IntrinsicSize[]) $VALUES.clone();
    }

    public static IntrinsicSize valueOf(String r100) {
        return (IntrinsicSize) r27.a.a(IntrinsicSize.class, r100);
    }

    private IntrinsicSize(String r100, int r101) {
        super(r100, r101);
    }
}
