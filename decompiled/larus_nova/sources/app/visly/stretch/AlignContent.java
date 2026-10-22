package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lapp/visly/stretch/AlignContent;", "", "FlexStart", "FlexEnd", "Center", "Stretch", "SpaceBetween", "SpaceAround", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum AlignContent extends Enum<AlignContent> {
    public static final AlignContent Center = null;
    public static final AlignContent FlexEnd = null;
    public static final AlignContent FlexStart = null;
    public static final AlignContent SpaceAround = null;
    public static final AlignContent SpaceBetween = null;
    public static final AlignContent Stretch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlignContent[] f15865a = null;

    public static AlignContent valueOf(String r100) {
        return (AlignContent) a.a(AlignContent.class, r100);
    }

    public static AlignContent[] values() {
        return (AlignContent[]) f15865a.clone();
    }

    static {
        AlignContent r100 = new AlignContent("FlexStart", 0);
        FlexStart = r100;
        AlignContent r101 = new AlignContent("FlexEnd", 1);
        FlexEnd = r101;
        AlignContent r102 = new AlignContent("Center", 2);
        Center = r102;
        AlignContent r103 = new AlignContent("Stretch", 3);
        Stretch = r103;
        AlignContent r104 = new AlignContent("SpaceBetween", 4);
        SpaceBetween = r104;
        AlignContent r105 = new AlignContent("SpaceAround", 5);
        SpaceAround = r105;
        f15865a = new AlignContent[]{r100, r101, r102, r103, r104, r105};
    }

    public AlignContent(String r100, int r101) {
        super(r100, r101);
    }
}
