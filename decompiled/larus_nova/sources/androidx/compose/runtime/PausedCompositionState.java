package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/PausedCompositionState;", "", "<init>", "(Ljava/lang/String;I)V", "Invalid", "Cancelled", "InitialPending", "RecomposePending", "Recomposing", "ApplyPending", "Applied", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PausedCompositionState extends Enum<PausedCompositionState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PausedCompositionState[] $VALUES = null;
    public static final PausedCompositionState Applied = null;
    public static final PausedCompositionState ApplyPending = null;
    public static final PausedCompositionState Cancelled = null;
    public static final PausedCompositionState InitialPending = null;
    public static final PausedCompositionState Invalid = null;
    public static final PausedCompositionState RecomposePending = null;
    public static final PausedCompositionState Recomposing = null;

    private static final /* synthetic */ PausedCompositionState[] $values() {
        return new PausedCompositionState[]{Invalid, Cancelled, InitialPending, RecomposePending, Recomposing, ApplyPending, Applied};
    }

    public static EnumEntries<PausedCompositionState> getEntries() {
        return $ENTRIES;
    }

    static {
        Invalid = new PausedCompositionState("Invalid", 0);
        Cancelled = new PausedCompositionState("Cancelled", 1);
        InitialPending = new PausedCompositionState("InitialPending", 2);
        RecomposePending = new PausedCompositionState("RecomposePending", 3);
        Recomposing = new PausedCompositionState("Recomposing", 4);
        ApplyPending = new PausedCompositionState("ApplyPending", 5);
        Applied = new PausedCompositionState("Applied", 6);
        PausedCompositionState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static PausedCompositionState[] values() {
        return (PausedCompositionState[]) $VALUES.clone();
    }

    public static PausedCompositionState valueOf(String r100) {
        return (PausedCompositionState) r27.a.a(PausedCompositionState.class, r100);
    }

    private PausedCompositionState(String r100, int r101) {
        super(r100, r101);
    }
}
