package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/BottomSheetValue;", "", "<init>", "(Ljava/lang/String;I)V", "Collapsed", "Expanded", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum BottomSheetValue extends Enum<BottomSheetValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BottomSheetValue[] $VALUES = null;
    public static final BottomSheetValue Collapsed = null;
    public static final BottomSheetValue Expanded = null;

    private static final /* synthetic */ BottomSheetValue[] $values() {
        return new BottomSheetValue[]{Collapsed, Expanded};
    }

    public static EnumEntries<BottomSheetValue> getEntries() {
        return $ENTRIES;
    }

    static {
        Collapsed = new BottomSheetValue("Collapsed", 0);
        Expanded = new BottomSheetValue("Expanded", 1);
        BottomSheetValue[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static BottomSheetValue[] values() {
        return (BottomSheetValue[]) $VALUES.clone();
    }

    public static BottomSheetValue valueOf(String r100) {
        return (BottomSheetValue) r27.a.a(BottomSheetValue.class, r100);
    }

    private BottomSheetValue(String r100, int r101) {
        super(r100, r101);
    }
}
