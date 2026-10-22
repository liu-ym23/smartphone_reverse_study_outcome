package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lapp/visly/stretch/AlignItems;", "", "FlexStart", "FlexEnd", "Center", "Baseline", "Stretch", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum AlignItems extends Enum<AlignItems> {
    public static final AlignItems Baseline = null;
    public static final AlignItems Center = null;
    public static final AlignItems FlexEnd = null;
    public static final AlignItems FlexStart = null;
    public static final AlignItems Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlignItems[] f15866a = null;

    public static AlignItems valueOf(String r100) {
        return (AlignItems) a.a(AlignItems.class, r100);
    }

    public static AlignItems[] values() {
        return (AlignItems[]) f15866a.clone();
    }

    static {
        AlignItems r100 = new AlignItems("FlexStart", 0);
        FlexStart = r100;
        AlignItems r101 = new AlignItems("FlexEnd", 1);
        FlexEnd = r101;
        AlignItems r102 = new AlignItems("Center", 2);
        Center = r102;
        AlignItems r103 = new AlignItems("Baseline", 3);
        Baseline = r103;
        AlignItems r104 = new AlignItems("Stretch", 4);
        Stretch = r104;
        f15866a = new AlignItems[]{r100, r101, r102, r103, r104};
    }

    public AlignItems(String r100, int r101) {
        super(r100, r101);
    }
}
