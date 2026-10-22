package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/selection/DownResolution;", "", "<init>", "(Ljava/lang/String;I)V", "Up", "Drag", "Timeout", "Cancel", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum DownResolution extends Enum<DownResolution> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DownResolution[] $VALUES = null;
    public static final DownResolution Cancel = null;
    public static final DownResolution Drag = null;
    public static final DownResolution Timeout = null;
    public static final DownResolution Up = null;

    private static final /* synthetic */ DownResolution[] $values() {
        return new DownResolution[]{Up, Drag, Timeout, Cancel};
    }

    public static EnumEntries<DownResolution> getEntries() {
        return $ENTRIES;
    }

    static {
        Up = new DownResolution("Up", 0);
        Drag = new DownResolution("Drag", 1);
        Timeout = new DownResolution("Timeout", 2);
        Cancel = new DownResolution("Cancel", 3);
        DownResolution[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DownResolution[] values() {
        return (DownResolution[]) $VALUES.clone();
    }

    public static DownResolution valueOf(String r100) {
        return (DownResolution) r27.a.a(DownResolution.class, r100);
    }

    private DownResolution(String r100, int r101) {
        super(r100, r101);
    }
}
