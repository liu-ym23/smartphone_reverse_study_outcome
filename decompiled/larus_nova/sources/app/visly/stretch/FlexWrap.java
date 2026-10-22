package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lapp/visly/stretch/FlexWrap;", "", "NoWrap", "Wrap", "WrapReverse", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum FlexWrap extends Enum<FlexWrap> {
    public static final FlexWrap NoWrap = null;
    public static final FlexWrap Wrap = null;
    public static final FlexWrap WrapReverse = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexWrap[] f15871a = null;

    public static FlexWrap valueOf(String r100) {
        return (FlexWrap) a.a(FlexWrap.class, r100);
    }

    public static FlexWrap[] values() {
        return (FlexWrap[]) f15871a.clone();
    }

    static {
        FlexWrap r100 = new FlexWrap("NoWrap", 0);
        NoWrap = r100;
        FlexWrap r101 = new FlexWrap("Wrap", 1);
        Wrap = r101;
        FlexWrap r102 = new FlexWrap("WrapReverse", 2);
        WrapReverse = r102;
        f15871a = new FlexWrap[]{r100, r101, r102};
    }

    public FlexWrap(String r100, int r101) {
        super(r100, r101);
    }
}
