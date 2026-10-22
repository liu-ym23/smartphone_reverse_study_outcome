package androidx.compose.foundation.text.input.internal.undo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "", "<init>", "(Ljava/lang/String;I)V", "Start", "End", "Inner", "NotByUser", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum TextDeleteType extends Enum<TextDeleteType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextDeleteType[] $VALUES = null;
    public static final TextDeleteType End = null;
    public static final TextDeleteType Inner = null;
    public static final TextDeleteType NotByUser = null;
    public static final TextDeleteType Start = null;

    private static final /* synthetic */ TextDeleteType[] $values() {
        return new TextDeleteType[]{Start, End, Inner, NotByUser};
    }

    public static EnumEntries<TextDeleteType> getEntries() {
        return $ENTRIES;
    }

    static {
        Start = new TextDeleteType("Start", 0);
        End = new TextDeleteType("End", 1);
        Inner = new TextDeleteType("Inner", 2);
        NotByUser = new TextDeleteType("NotByUser", 3);
        TextDeleteType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TextDeleteType[] values() {
        return (TextDeleteType[]) $VALUES.clone();
    }

    public static TextDeleteType valueOf(String r100) {
        return (TextDeleteType) a.a(TextDeleteType.class, r100);
    }

    private TextDeleteType(String r100, int r101) {
        super(r100, r101);
    }
}
