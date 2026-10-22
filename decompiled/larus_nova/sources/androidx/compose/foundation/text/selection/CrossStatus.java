package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/selection/CrossStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CROSSED", "NOT_CROSSED", "COLLAPSED", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum CrossStatus extends Enum<CrossStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CrossStatus[] $VALUES = null;
    public static final CrossStatus COLLAPSED = null;
    public static final CrossStatus CROSSED = null;
    public static final CrossStatus NOT_CROSSED = null;

    private static final /* synthetic */ CrossStatus[] $values() {
        return new CrossStatus[]{CROSSED, NOT_CROSSED, COLLAPSED};
    }

    public static EnumEntries<CrossStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        CROSSED = new CrossStatus("CROSSED", 0);
        NOT_CROSSED = new CrossStatus("NOT_CROSSED", 1);
        COLLAPSED = new CrossStatus("COLLAPSED", 2);
        CrossStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static CrossStatus[] values() {
        return (CrossStatus[]) $VALUES.clone();
    }

    public static CrossStatus valueOf(String r100) {
        return (CrossStatus) r27.a.a(CrossStatus.class, r100);
    }

    private CrossStatus(String r100, int r101) {
        super(r100, r101);
    }
}
