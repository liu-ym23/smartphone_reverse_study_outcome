package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"PathHitTester", "Landroidx/compose/ui/graphics/PathHitTester;", "path", "Landroidx/compose/ui/graphics/Path;", "tolerance", "", "EmptyPath", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PathHitTesterKt {
    private static final Path EmptyPath = null;

    static {
        EmptyPath = AndroidPath_androidKt.Path();
    }

    public static final /* synthetic */ Path access$getEmptyPath$p() {
        return EmptyPath;
    }

    public static final PathHitTester PathHitTester(Path r100, float r101) {
        PathHitTester r102 = new PathHitTester();
        r102.updatePath(r100, r101);
        return r102;
    }

    public static /* synthetic */ PathHitTester PathHitTester$default(Path r100, float r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = 0.5f;
    L6:
        return PathHitTester(r100, r101);
    }
}
