package app.visly.stretch;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lapp/visly/stretch/Display;", "", "Flex", "None", "GaiaX"}, k = 1, mv = {1, 7, 1})
public final enum Display extends Enum<Display> {
    public static final Display Flex = null;
    public static final Display None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Display[] f15869a = null;

    public static Display valueOf(String r100) {
        return (Display) a.a(Display.class, r100);
    }

    public static Display[] values() {
        return (Display[]) f15869a.clone();
    }

    static {
        Display r100 = new Display("Flex", 0);
        Flex = r100;
        Display r101 = new Display("None", 1);
        None = r101;
        f15869a = new Display[]{r100, r101};
    }

    public Display(String r100, int r101) {
        super(r100, r101);
    }
}
