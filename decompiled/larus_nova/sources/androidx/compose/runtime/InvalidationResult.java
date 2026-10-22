package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/InvalidationResult;", "", "<init>", "(Ljava/lang/String;I)V", "IGNORED", "SCHEDULED", "DEFERRED", "IMMINENT", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum InvalidationResult extends Enum<InvalidationResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InvalidationResult[] $VALUES = null;
    public static final InvalidationResult DEFERRED = null;
    public static final InvalidationResult IGNORED = null;
    public static final InvalidationResult IMMINENT = null;
    public static final InvalidationResult SCHEDULED = null;

    private static final /* synthetic */ InvalidationResult[] $values() {
        return new InvalidationResult[]{IGNORED, SCHEDULED, DEFERRED, IMMINENT};
    }

    public static EnumEntries<InvalidationResult> getEntries() {
        return $ENTRIES;
    }

    static {
        IGNORED = new InvalidationResult("IGNORED", 0);
        SCHEDULED = new InvalidationResult("SCHEDULED", 1);
        DEFERRED = new InvalidationResult("DEFERRED", 2);
        IMMINENT = new InvalidationResult("IMMINENT", 3);
        InvalidationResult[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static InvalidationResult[] values() {
        return (InvalidationResult[]) $VALUES.clone();
    }

    public static InvalidationResult valueOf(String r100) {
        return (InvalidationResult) r27.a.a(InvalidationResult.class, r100);
    }

    private InvalidationResult(String r100, int r101) {
        super(r100, r101);
    }
}
