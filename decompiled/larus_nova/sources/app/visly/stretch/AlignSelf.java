package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lapp/visly/stretch/AlignSelf;", "", "Auto", "FlexStart", "FlexEnd", "Center", "Baseline", "Stretch", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum AlignSelf extends Enum<AlignSelf> {
    public static final AlignSelf Auto = null;
    public static final AlignSelf Baseline = null;
    public static final AlignSelf Center = null;
    public static final AlignSelf FlexEnd = null;
    public static final AlignSelf FlexStart = null;
    public static final AlignSelf Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlignSelf[] f15867a = null;

    public static AlignSelf valueOf(String r100) {
        return (AlignSelf) a.a(AlignSelf.class, r100);
    }

    public static AlignSelf[] values() {
        return (AlignSelf[]) f15867a.clone();
    }

    static {
        AlignSelf r100 = new AlignSelf("Auto", 0);
        Auto = r100;
        AlignSelf r101 = new AlignSelf("FlexStart", 1);
        FlexStart = r101;
        AlignSelf r102 = new AlignSelf("FlexEnd", 2);
        FlexEnd = r102;
        AlignSelf r103 = new AlignSelf("Center", 3);
        Center = r103;
        AlignSelf r104 = new AlignSelf("Baseline", 4);
        Baseline = r104;
        AlignSelf r105 = new AlignSelf("Stretch", 5);
        Stretch = r105;
        f15867a = new AlignSelf[]{r100, r101, r102, r103, r104, r105};
    }

    public AlignSelf(String r100, int r101) {
        super(r100, r101);
    }
}
