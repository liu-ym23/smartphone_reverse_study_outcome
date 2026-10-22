package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/TextToolbarStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Shown", "Hidden", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextToolbarStatus extends Enum<TextToolbarStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextToolbarStatus[] $VALUES = null;
    public static final TextToolbarStatus Hidden = null;
    public static final TextToolbarStatus Shown = null;

    private static final /* synthetic */ TextToolbarStatus[] $values() {
        return new TextToolbarStatus[]{Shown, Hidden};
    }

    public static EnumEntries<TextToolbarStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        Shown = new TextToolbarStatus("Shown", 0);
        Hidden = new TextToolbarStatus("Hidden", 1);
        TextToolbarStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TextToolbarStatus[] values() {
        return (TextToolbarStatus[]) $VALUES.clone();
    }

    public static TextToolbarStatus valueOf(String r100) {
        return (TextToolbarStatus) r27.a.a(TextToolbarStatus.class, r100);
    }

    private TextToolbarStatus(String r100, int r101) {
        super(r100, r101);
    }
}
