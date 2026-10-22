package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lapp/visly/stretch/Overflow;", "", "Visible", "Hidden", "Scroll", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum Overflow extends Enum<Overflow> {
    public static final Overflow Hidden = null;
    public static final Overflow Scroll = null;
    public static final Overflow Visible = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Overflow[] f15874a = null;

    public static Overflow valueOf(String r100) {
        return (Overflow) a.a(Overflow.class, r100);
    }

    public static Overflow[] values() {
        return (Overflow[]) f15874a.clone();
    }

    static {
        Overflow r100 = new Overflow("Visible", 0);
        Visible = r100;
        Overflow r101 = new Overflow("Hidden", 1);
        Hidden = r101;
        Overflow r102 = new Overflow("Scroll", 2);
        Scroll = r102;
        f15874a = new Overflow[]{r100, r101, r102};
    }

    public Overflow(String r100, int r101) {
        super(r100, r101);
    }
}
