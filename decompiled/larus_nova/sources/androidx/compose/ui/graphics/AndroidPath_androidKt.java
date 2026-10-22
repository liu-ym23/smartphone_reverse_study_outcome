package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Path", "Landroidx/compose/ui/graphics/Path;", "asComposePath", "Landroid/graphics/Path;", "asAndroidPath", "throwIllegalStateException", "", "message", "", "toPlatformPathDirection", "Landroid/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path$Direction;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPath_androidKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Path.Direction.values().length];
            r100[Path.Direction.CounterClockwise.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Path.Direction.Clockwise.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Path Path() {
        return new AndroidPath(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ android.graphics.Path.Direction access$toPlatformPathDirection(Path.Direction r100) {
        return toPlatformPathDirection(r100);
    }

    public static final android.graphics.Path asAndroidPath(Path r100) {
        if ((r100 instanceof AndroidPath) == false) goto L7;
        return ((AndroidPath) r100).getInternalPath();
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public static final Path asComposePath(android.graphics.Path r100) {
        return new AndroidPath(r100);
    }

    public static final void throwIllegalStateException(String r100) {
        throw new IllegalStateException(r100);
    }

    private static final android.graphics.Path.Direction toPlatformPathDirection(Path.Direction r100) {
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return android.graphics.Path.Direction.CW;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return android.graphics.Path.Direction.CCW;
    }
}
