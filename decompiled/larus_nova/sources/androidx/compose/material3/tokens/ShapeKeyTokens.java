package androidx.compose.material3.tokens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/tokens/ShapeKeyTokens;", "", "<init>", "(Ljava/lang/String;I)V", "CornerExtraExtraLarge", "CornerExtraLarge", "CornerExtraLargeIncreased", "CornerExtraLargeTop", "CornerExtraSmall", "CornerExtraSmallTop", "CornerFull", "CornerLarge", "CornerLargeEnd", "CornerLargeIncreased", "CornerLargeStart", "CornerLargeTop", "CornerMedium", "CornerNone", "CornerSmall", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ShapeKeyTokens extends Enum<ShapeKeyTokens> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ShapeKeyTokens[] $VALUES = null;
    public static final ShapeKeyTokens CornerExtraExtraLarge = null;
    public static final ShapeKeyTokens CornerExtraLarge = null;
    public static final ShapeKeyTokens CornerExtraLargeIncreased = null;
    public static final ShapeKeyTokens CornerExtraLargeTop = null;
    public static final ShapeKeyTokens CornerExtraSmall = null;
    public static final ShapeKeyTokens CornerExtraSmallTop = null;
    public static final ShapeKeyTokens CornerFull = null;
    public static final ShapeKeyTokens CornerLarge = null;
    public static final ShapeKeyTokens CornerLargeEnd = null;
    public static final ShapeKeyTokens CornerLargeIncreased = null;
    public static final ShapeKeyTokens CornerLargeStart = null;
    public static final ShapeKeyTokens CornerLargeTop = null;
    public static final ShapeKeyTokens CornerMedium = null;
    public static final ShapeKeyTokens CornerNone = null;
    public static final ShapeKeyTokens CornerSmall = null;

    private static final /* synthetic */ ShapeKeyTokens[] $values() {
        return new ShapeKeyTokens[]{CornerExtraExtraLarge, CornerExtraLarge, CornerExtraLargeIncreased, CornerExtraLargeTop, CornerExtraSmall, CornerExtraSmallTop, CornerFull, CornerLarge, CornerLargeEnd, CornerLargeIncreased, CornerLargeStart, CornerLargeTop, CornerMedium, CornerNone, CornerSmall};
    }

    public static EnumEntries<ShapeKeyTokens> getEntries() {
        return $ENTRIES;
    }

    static {
        CornerExtraExtraLarge = new ShapeKeyTokens("CornerExtraExtraLarge", 0);
        CornerExtraLarge = new ShapeKeyTokens("CornerExtraLarge", 1);
        CornerExtraLargeIncreased = new ShapeKeyTokens("CornerExtraLargeIncreased", 2);
        CornerExtraLargeTop = new ShapeKeyTokens("CornerExtraLargeTop", 3);
        CornerExtraSmall = new ShapeKeyTokens("CornerExtraSmall", 4);
        CornerExtraSmallTop = new ShapeKeyTokens("CornerExtraSmallTop", 5);
        CornerFull = new ShapeKeyTokens("CornerFull", 6);
        CornerLarge = new ShapeKeyTokens("CornerLarge", 7);
        CornerLargeEnd = new ShapeKeyTokens("CornerLargeEnd", 8);
        CornerLargeIncreased = new ShapeKeyTokens("CornerLargeIncreased", 9);
        CornerLargeStart = new ShapeKeyTokens("CornerLargeStart", 10);
        CornerLargeTop = new ShapeKeyTokens("CornerLargeTop", 11);
        CornerMedium = new ShapeKeyTokens("CornerMedium", 12);
        CornerNone = new ShapeKeyTokens("CornerNone", 13);
        CornerSmall = new ShapeKeyTokens("CornerSmall", 14);
        ShapeKeyTokens[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ShapeKeyTokens[] values() {
        return (ShapeKeyTokens[]) $VALUES.clone();
    }

    public static ShapeKeyTokens valueOf(String r100) {
        return (ShapeKeyTokens) a.a(ShapeKeyTokens.class, r100);
    }

    private ShapeKeyTokens(String r100, int r101) {
        super(r100, r101);
    }
}
