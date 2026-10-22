package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/Handle;", "", "<init>", "(Ljava/lang/String;I)V", "Cursor", "SelectionStart", "SelectionEnd", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Handle extends Enum<Handle> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Handle[] $VALUES = null;
    public static final Handle Cursor = null;
    public static final Handle SelectionEnd = null;
    public static final Handle SelectionStart = null;

    private static final /* synthetic */ Handle[] $values() {
        return new Handle[]{Cursor, SelectionStart, SelectionEnd};
    }

    public static EnumEntries<Handle> getEntries() {
        return $ENTRIES;
    }

    static {
        Cursor = new Handle("Cursor", 0);
        SelectionStart = new Handle("SelectionStart", 1);
        SelectionEnd = new Handle("SelectionEnd", 2);
        Handle[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static Handle[] values() {
        return (Handle[]) $VALUES.clone();
    }

    public static Handle valueOf(String r100) {
        return (Handle) r27.a.a(Handle.class, r100);
    }

    private Handle(String r100, int r101) {
        super(r100, r101);
    }
}
