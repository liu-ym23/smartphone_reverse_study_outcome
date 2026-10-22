package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@SinceKotlin(version = "1.7")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/io/path/PathWalkOption;", "", "(Ljava/lang/String;I)V", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ExperimentalPathApi
public final enum PathWalkOption extends Enum<PathWalkOption> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PathWalkOption[] $VALUES = null;
    public static final PathWalkOption BREADTH_FIRST = null;
    public static final PathWalkOption FOLLOW_LINKS = null;
    public static final PathWalkOption INCLUDE_DIRECTORIES = null;

    private static final /* synthetic */ PathWalkOption[] $values() {
        return new PathWalkOption[]{INCLUDE_DIRECTORIES, BREADTH_FIRST, FOLLOW_LINKS};
    }

    static {
        INCLUDE_DIRECTORIES = new PathWalkOption("INCLUDE_DIRECTORIES", 0);
        BREADTH_FIRST = new PathWalkOption("BREADTH_FIRST", 1);
        FOLLOW_LINKS = new PathWalkOption("FOLLOW_LINKS", 2);
        PathWalkOption[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
    }

    private PathWalkOption(String r10, int r11) {
        super(r10, r11);
    }

    @NotNull
    public static EnumEntries<PathWalkOption> getEntries() {
        return $ENTRIES;
    }

    public static PathWalkOption valueOf(String r10) {
        return (PathWalkOption) Enum.valueOf(PathWalkOption.class, r10);
    }

    public static PathWalkOption[] values() {
        return (PathWalkOption[]) $VALUES.clone();
    }
}
