package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lapp/visly/stretch/PositionType;", "", "Relative", "Absolute", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum PositionType extends Enum<PositionType> {
    public static final PositionType Absolute = null;
    public static final PositionType Relative = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PositionType[] f15875a = null;

    public static PositionType valueOf(String r100) {
        return (PositionType) a.a(PositionType.class, r100);
    }

    public static PositionType[] values() {
        return (PositionType[]) f15875a.clone();
    }

    static {
        PositionType r100 = new PositionType("Relative", 0);
        Relative = r100;
        PositionType r101 = new PositionType("Absolute", 1);
        Absolute = r101;
        f15875a = new PositionType[]{r100, r101};
    }

    public PositionType(String r100, int r101) {
        super(r100, r101);
    }
}
