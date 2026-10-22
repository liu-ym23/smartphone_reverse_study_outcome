package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material/ModalBottomSheetValue;", "", "<init>", "(Ljava/lang/String;I)V", "Hidden", "Expanded", "HalfExpanded", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ModalBottomSheetValue extends Enum<ModalBottomSheetValue> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ModalBottomSheetValue[] $VALUES = null;
    public static final ModalBottomSheetValue Expanded = null;
    public static final ModalBottomSheetValue HalfExpanded = null;
    public static final ModalBottomSheetValue Hidden = null;

    private static final /* synthetic */ ModalBottomSheetValue[] $values() {
        return new ModalBottomSheetValue[]{Hidden, Expanded, HalfExpanded};
    }

    public static EnumEntries<ModalBottomSheetValue> getEntries() {
        return $ENTRIES;
    }

    static {
        Hidden = new ModalBottomSheetValue("Hidden", 0);
        Expanded = new ModalBottomSheetValue("Expanded", 1);
        HalfExpanded = new ModalBottomSheetValue("HalfExpanded", 2);
        ModalBottomSheetValue[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ModalBottomSheetValue[] values() {
        return (ModalBottomSheetValue[]) $VALUES.clone();
    }

    public static ModalBottomSheetValue valueOf(String r100) {
        return (ModalBottomSheetValue) r27.a.a(ModalBottomSheetValue.class, r100);
    }

    private ModalBottomSheetValue(String r100, int r101) {
        super(r100, r101);
    }
}
