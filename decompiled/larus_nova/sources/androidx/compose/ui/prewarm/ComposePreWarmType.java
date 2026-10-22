package androidx.compose.ui.prewarm;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/prewarm/ComposePreWarmType;", "", "<init>", "(Ljava/lang/String;I)V", "COMPOSE_ONLY", "COMPOSE_AND_LAYOUT", AccountType.ALL, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ComposePreWarmType extends Enum<ComposePreWarmType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ComposePreWarmType[] $VALUES = null;
    public static final ComposePreWarmType ALL = null;
    public static final ComposePreWarmType COMPOSE_AND_LAYOUT = null;
    public static final ComposePreWarmType COMPOSE_ONLY = null;

    private static final /* synthetic */ ComposePreWarmType[] $values() {
        return new ComposePreWarmType[]{COMPOSE_ONLY, COMPOSE_AND_LAYOUT, ALL};
    }

    public static EnumEntries<ComposePreWarmType> getEntries() {
        return $ENTRIES;
    }

    static {
        COMPOSE_ONLY = new ComposePreWarmType("COMPOSE_ONLY", 0);
        COMPOSE_AND_LAYOUT = new ComposePreWarmType("COMPOSE_AND_LAYOUT", 1);
        ALL = new ComposePreWarmType(AccountType.ALL, 2);
        ComposePreWarmType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ComposePreWarmType[] values() {
        return (ComposePreWarmType[]) $VALUES.clone();
    }

    public static ComposePreWarmType valueOf(String r100) {
        return (ComposePreWarmType) a.a(ComposePreWarmType.class, r100);
    }

    private ComposePreWarmType(String r100, int r101) {
        super(r100, r101);
    }
}
