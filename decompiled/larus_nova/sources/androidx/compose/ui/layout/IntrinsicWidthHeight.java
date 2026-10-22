package androidx.compose.ui.layout;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "", "<init>", "(Ljava/lang/String;I)V", "Width", "Height", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum IntrinsicWidthHeight extends Enum<IntrinsicWidthHeight> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IntrinsicWidthHeight[] $VALUES = null;
    public static final IntrinsicWidthHeight Height = null;
    public static final IntrinsicWidthHeight Width = null;

    private static final /* synthetic */ IntrinsicWidthHeight[] $values() {
        return new IntrinsicWidthHeight[]{Width, Height};
    }

    public static EnumEntries<IntrinsicWidthHeight> getEntries() {
        return $ENTRIES;
    }

    static {
        Width = new IntrinsicWidthHeight("Width", 0);
        Height = new IntrinsicWidthHeight("Height", 1);
        IntrinsicWidthHeight[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IntrinsicWidthHeight[] values() {
        return (IntrinsicWidthHeight[]) $VALUES.clone();
    }

    public static IntrinsicWidthHeight valueOf(String r100) {
        return (IntrinsicWidthHeight) r27.a.a(IntrinsicWidthHeight.class, r100);
    }

    private IntrinsicWidthHeight(String r100, int r101) {
        super(r100, r101);
    }
}
