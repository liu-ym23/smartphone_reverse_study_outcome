package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/HandleState;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Selection", "Cursor", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum HandleState extends Enum<HandleState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ HandleState[] $VALUES = null;
    public static final HandleState Cursor = null;
    public static final HandleState None = null;
    public static final HandleState Selection = null;

    private static final /* synthetic */ HandleState[] $values() {
        return new HandleState[]{None, Selection, Cursor};
    }

    public static EnumEntries<HandleState> getEntries() {
        return $ENTRIES;
    }

    static {
        None = new HandleState("None", 0);
        Selection = new HandleState("Selection", 1);
        Cursor = new HandleState("Cursor", 2);
        HandleState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static HandleState[] values() {
        return (HandleState[]) $VALUES.clone();
    }

    public static HandleState valueOf(String r100) {
        return (HandleState) r27.a.a(HandleState.class, r100);
    }

    private HandleState(String r100, int r101) {
        super(r100, r101);
    }
}
