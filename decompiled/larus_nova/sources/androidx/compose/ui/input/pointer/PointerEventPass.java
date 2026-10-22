package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEventPass;", "", "<init>", "(Ljava/lang/String;I)V", "Initial", "Main", "Final", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PointerEventPass extends Enum<PointerEventPass> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PointerEventPass[] $VALUES = null;
    public static final PointerEventPass Final = null;
    public static final PointerEventPass Initial = null;
    public static final PointerEventPass Main = null;

    private static final /* synthetic */ PointerEventPass[] $values() {
        return new PointerEventPass[]{Initial, Main, Final};
    }

    public static EnumEntries<PointerEventPass> getEntries() {
        return $ENTRIES;
    }

    static {
        Initial = new PointerEventPass("Initial", 0);
        Main = new PointerEventPass("Main", 1);
        Final = new PointerEventPass("Final", 2);
        PointerEventPass[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static PointerEventPass[] values() {
        return (PointerEventPass[]) $VALUES.clone();
    }

    public static PointerEventPass valueOf(String r100) {
        return (PointerEventPass) a.a(PointerEventPass.class, r100);
    }

    private PointerEventPass(String r100, int r101) {
        super(r100, r101);
    }
}
