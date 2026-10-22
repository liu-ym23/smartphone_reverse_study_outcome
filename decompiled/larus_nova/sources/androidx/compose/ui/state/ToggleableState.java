package androidx.compose.ui.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/state/ToggleableState;", "", "<init>", "(Ljava/lang/String;I)V", "On", "Off", "Indeterminate", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ToggleableState extends Enum<ToggleableState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ToggleableState[] $VALUES = null;
    public static final ToggleableState Indeterminate = null;
    public static final ToggleableState Off = null;
    public static final ToggleableState On = null;

    private static final /* synthetic */ ToggleableState[] $values() {
        return new ToggleableState[]{On, Off, Indeterminate};
    }

    public static EnumEntries<ToggleableState> getEntries() {
        return $ENTRIES;
    }

    static {
        On = new ToggleableState("On", 0);
        Off = new ToggleableState("Off", 1);
        Indeterminate = new ToggleableState("Indeterminate", 2);
        ToggleableState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ToggleableState[] values() {
        return (ToggleableState[]) $VALUES.clone();
    }

    public static ToggleableState valueOf(String r100) {
        return (ToggleableState) a.a(ToggleableState.class, r100);
    }

    private ToggleableState(String r100, int r101) {
        super(r100, r101);
    }
}
