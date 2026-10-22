package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/SnackbarDuration;", "", "<init>", "(Ljava/lang/String;I)V", "Short", "Long", "Indefinite", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SnackbarDuration extends Enum<SnackbarDuration> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SnackbarDuration[] $VALUES = null;
    public static final SnackbarDuration Indefinite = null;
    public static final SnackbarDuration Long = null;
    public static final SnackbarDuration Short = null;

    private static final /* synthetic */ SnackbarDuration[] $values() {
        return new SnackbarDuration[]{Short, Long, Indefinite};
    }

    public static EnumEntries<SnackbarDuration> getEntries() {
        return $ENTRIES;
    }

    static {
        Short = new SnackbarDuration("Short", 0);
        Long = new SnackbarDuration("Long", 1);
        Indefinite = new SnackbarDuration("Indefinite", 2);
        SnackbarDuration[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static SnackbarDuration[] values() {
        return (SnackbarDuration[]) $VALUES.clone();
    }

    public static SnackbarDuration valueOf(String r100) {
        return (SnackbarDuration) r27.a.a(SnackbarDuration.class, r100);
    }

    private SnackbarDuration(String r100, int r101) {
        super(r100, r101);
    }
}
