package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lapp/visly/stretch/JustifyContent;", "", "FlexStart", "FlexEnd", "Center", "SpaceBetween", "SpaceAround", "SpaceEvenly", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum JustifyContent extends Enum<JustifyContent> {
    public static final JustifyContent Center = null;
    public static final JustifyContent FlexEnd = null;
    public static final JustifyContent FlexStart = null;
    public static final JustifyContent SpaceAround = null;
    public static final JustifyContent SpaceBetween = null;
    public static final JustifyContent SpaceEvenly = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JustifyContent[] f15872a = null;

    public static JustifyContent valueOf(String r100) {
        return (JustifyContent) a.a(JustifyContent.class, r100);
    }

    public static JustifyContent[] values() {
        return (JustifyContent[]) f15872a.clone();
    }

    static {
        JustifyContent r100 = new JustifyContent("FlexStart", 0);
        FlexStart = r100;
        JustifyContent r101 = new JustifyContent("FlexEnd", 1);
        FlexEnd = r101;
        JustifyContent r102 = new JustifyContent("Center", 2);
        Center = r102;
        JustifyContent r103 = new JustifyContent("SpaceBetween", 3);
        SpaceBetween = r103;
        JustifyContent r104 = new JustifyContent("SpaceAround", 4);
        SpaceAround = r104;
        JustifyContent r105 = new JustifyContent("SpaceEvenly", 5);
        SpaceEvenly = r105;
        f15872a = new JustifyContent[]{r100, r101, r102, r103, r104, r105};
    }

    public JustifyContent(String r100, int r101) {
        super(r100, r101);
    }
}
