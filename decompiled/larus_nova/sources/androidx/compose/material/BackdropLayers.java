package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/material/BackdropLayers;", "", "<init>", "(Ljava/lang/String;I)V", "Back", "Front", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum BackdropLayers extends Enum<BackdropLayers> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BackdropLayers[] $VALUES = null;
    public static final BackdropLayers Back = null;
    public static final BackdropLayers Front = null;

    private static final /* synthetic */ BackdropLayers[] $values() {
        return new BackdropLayers[]{Back, Front};
    }

    public static EnumEntries<BackdropLayers> getEntries() {
        return $ENTRIES;
    }

    static {
        Back = new BackdropLayers("Back", 0);
        Front = new BackdropLayers("Front", 1);
        BackdropLayers[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static BackdropLayers[] values() {
        return (BackdropLayers[]) $VALUES.clone();
    }

    public static BackdropLayers valueOf(String r100) {
        return (BackdropLayers) r27.a.a(BackdropLayers.class, r100);
    }

    private BackdropLayers(String r100, int r101) {
        super(r100, r101);
    }
}
