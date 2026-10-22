package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/layout/IntrinsicMinMax;", "", "<init>", "(Ljava/lang/String;I)V", "Min", "Max", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum IntrinsicMinMax extends Enum<IntrinsicMinMax> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IntrinsicMinMax[] $VALUES = null;
    public static final IntrinsicMinMax Max = null;
    public static final IntrinsicMinMax Min = null;

    private static final /* synthetic */ IntrinsicMinMax[] $values() {
        return new IntrinsicMinMax[]{Min, Max};
    }

    public static EnumEntries<IntrinsicMinMax> getEntries() {
        return $ENTRIES;
    }

    static {
        Min = new IntrinsicMinMax("Min", 0);
        Max = new IntrinsicMinMax("Max", 1);
        IntrinsicMinMax[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IntrinsicMinMax[] values() {
        return (IntrinsicMinMax[]) $VALUES.clone();
    }

    public static IntrinsicMinMax valueOf(String r100) {
        return (IntrinsicMinMax) r27.a.a(IntrinsicMinMax.class, r100);
    }

    private IntrinsicMinMax(String r100, int r101) {
        super(r100, r101);
    }
}
