package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lapp/visly/stretch/Direction;", "", "Inherit", "LTR", "RTL", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum Direction extends Enum<Direction> {
    public static final Direction Inherit = null;
    public static final Direction LTR = null;
    public static final Direction RTL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f15868a = null;

    public static Direction valueOf(String r100) {
        return (Direction) a.a(Direction.class, r100);
    }

    public static Direction[] values() {
        return (Direction[]) f15868a.clone();
    }

    static {
        Direction r100 = new Direction("Inherit", 0);
        Inherit = r100;
        Direction r101 = new Direction("LTR", 1);
        LTR = r101;
        Direction r102 = new Direction("RTL", 2);
        RTL = r102;
        f15868a = new Direction[]{r100, r101, r102};
    }

    public Direction(String r100, int r101) {
        super(r100, r101);
    }
}
