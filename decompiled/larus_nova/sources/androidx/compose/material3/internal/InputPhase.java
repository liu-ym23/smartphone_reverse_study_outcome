package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/internal/InputPhase;", "", "<init>", "(Ljava/lang/String;I)V", "Focused", "UnfocusedEmpty", "UnfocusedNotEmpty", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum InputPhase extends Enum<InputPhase> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InputPhase[] $VALUES = null;
    public static final InputPhase Focused = null;
    public static final InputPhase UnfocusedEmpty = null;
    public static final InputPhase UnfocusedNotEmpty = null;

    private static final /* synthetic */ InputPhase[] $values() {
        return new InputPhase[]{Focused, UnfocusedEmpty, UnfocusedNotEmpty};
    }

    public static EnumEntries<InputPhase> getEntries() {
        return $ENTRIES;
    }

    static {
        Focused = new InputPhase("Focused", 0);
        UnfocusedEmpty = new InputPhase("UnfocusedEmpty", 1);
        UnfocusedNotEmpty = new InputPhase("UnfocusedNotEmpty", 2);
        InputPhase[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static InputPhase[] values() {
        return (InputPhase[]) $VALUES.clone();
    }

    public static InputPhase valueOf(String r100) {
        return (InputPhase) r27.a.a(InputPhase.class, r100);
    }

    private InputPhase(String r100, int r101) {
        super(r100, r101);
    }
}
