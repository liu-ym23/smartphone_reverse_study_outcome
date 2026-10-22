package kotlin.io;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileWalkDirection;", "", "(Ljava/lang/String;I)V", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum FileWalkDirection extends Enum<FileWalkDirection> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FileWalkDirection[] $VALUES = null;
    public static final FileWalkDirection BOTTOM_UP = null;
    public static final FileWalkDirection TOP_DOWN = null;

    private static final /* synthetic */ FileWalkDirection[] $values() {
        return new FileWalkDirection[]{TOP_DOWN, BOTTOM_UP};
    }

    static {
        TOP_DOWN = new FileWalkDirection("TOP_DOWN", 0);
        BOTTOM_UP = new FileWalkDirection("BOTTOM_UP", 1);
        FileWalkDirection[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
    }

    private FileWalkDirection(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<FileWalkDirection> getEntries() {
        return $ENTRIES;
    }

    public static FileWalkDirection valueOf(String r10) {
        return (FileWalkDirection) Enum.valueOf(FileWalkDirection.class, r10);
    }

    public static FileWalkDirection[] values() {
        return (FileWalkDirection[]) $VALUES.clone();
    }
}
