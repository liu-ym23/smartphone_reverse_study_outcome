package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/core/MutatePriority;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "UserInput", "PreventUserInput", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MutatePriority extends Enum<MutatePriority> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MutatePriority[] $VALUES = null;
    public static final MutatePriority Default = null;
    public static final MutatePriority PreventUserInput = null;
    public static final MutatePriority UserInput = null;

    private static final /* synthetic */ MutatePriority[] $values() {
        return new MutatePriority[]{Default, UserInput, PreventUserInput};
    }

    public static EnumEntries<MutatePriority> getEntries() {
        return $ENTRIES;
    }

    static {
        Default = new MutatePriority("Default", 0);
        UserInput = new MutatePriority("UserInput", 1);
        PreventUserInput = new MutatePriority("PreventUserInput", 2);
        MutatePriority[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MutatePriority[] values() {
        return (MutatePriority[]) $VALUES.clone();
    }

    public static MutatePriority valueOf(String r100) {
        return (MutatePriority) r27.a.a(MutatePriority.class, r100);
    }

    private MutatePriority(String r100, int r101) {
        super(r100, r101);
    }
}
