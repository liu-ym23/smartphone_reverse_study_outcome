package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/internal/SwipeEdge;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "Right", "None", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SwipeEdge extends Enum<SwipeEdge> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SwipeEdge[] $VALUES = null;
    public static final SwipeEdge Left = null;
    public static final SwipeEdge None = null;
    public static final SwipeEdge Right = null;

    private static final /* synthetic */ SwipeEdge[] $values() {
        return new SwipeEdge[]{Left, Right, None};
    }

    public static EnumEntries<SwipeEdge> getEntries() {
        return $ENTRIES;
    }

    static {
        Left = new SwipeEdge("Left", 0);
        Right = new SwipeEdge("Right", 1);
        None = new SwipeEdge("None", 2);
        SwipeEdge[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SwipeEdge[] values() {
        return (SwipeEdge[]) $VALUES.clone();
    }

    public static SwipeEdge valueOf(String r100) {
        return (SwipeEdge) r27.a.a(SwipeEdge.class, r100);
    }

    private SwipeEdge(String r100, int r101) {
        super(r100, r101);
    }
}
