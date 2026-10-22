package kotlin;

import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/LazyThreadSafetyMode;", "", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum LazyThreadSafetyMode extends Enum<LazyThreadSafetyMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LazyThreadSafetyMode[] $VALUES = null;
    public static final LazyThreadSafetyMode NONE = null;
    public static final LazyThreadSafetyMode PUBLICATION = null;
    public static final LazyThreadSafetyMode SYNCHRONIZED = null;

    private static final /* synthetic */ LazyThreadSafetyMode[] $values() {
        return new LazyThreadSafetyMode[]{SYNCHRONIZED, PUBLICATION, NONE};
    }

    static {
        SYNCHRONIZED = new LazyThreadSafetyMode("SYNCHRONIZED", 0);
        PUBLICATION = new LazyThreadSafetyMode("PUBLICATION", 1);
        NONE = new LazyThreadSafetyMode("NONE", 2);
        LazyThreadSafetyMode[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
    }

    private LazyThreadSafetyMode(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<LazyThreadSafetyMode> getEntries() {
        return $ENTRIES;
    }

    public static LazyThreadSafetyMode valueOf(String r10) {
        return (LazyThreadSafetyMode) Enum.valueOf(LazyThreadSafetyMode.class, r10);
    }

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[]) $VALUES.clone();
    }
}
