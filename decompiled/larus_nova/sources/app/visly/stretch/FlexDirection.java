package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lapp/visly/stretch/FlexDirection;", "", "Row", "Column", "RowReverse", "ColumnReverse", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum FlexDirection extends Enum<FlexDirection> {
    public static final FlexDirection Column = null;
    public static final FlexDirection ColumnReverse = null;
    public static final FlexDirection Row = null;
    public static final FlexDirection RowReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexDirection[] f15870a = null;

    public static FlexDirection valueOf(String r100) {
        return (FlexDirection) a.a(FlexDirection.class, r100);
    }

    public static FlexDirection[] values() {
        return (FlexDirection[]) f15870a.clone();
    }

    static {
        FlexDirection r100 = new FlexDirection("Row", 0);
        Row = r100;
        FlexDirection r101 = new FlexDirection("Column", 1);
        Column = r101;
        FlexDirection r102 = new FlexDirection("RowReverse", 2);
        RowReverse = r102;
        FlexDirection r103 = new FlexDirection("ColumnReverse", 3);
        ColumnReverse = r103;
        f15870a = new FlexDirection[]{r100, r101, r102, r103};
    }

    public FlexDirection(String r100, int r101) {
        super(r100, r101);
    }
}
