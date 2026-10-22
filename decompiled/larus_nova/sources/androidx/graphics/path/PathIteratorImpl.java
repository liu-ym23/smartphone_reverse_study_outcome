package androidx.graphics.path;

import android.graphics.Path;
import android.graphics.PointF;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0014H&J\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u0012H&J\b\u0010 \u001a\u00020\u0019H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Landroidx/graphics/path/PathIteratorImpl;", "", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "getConicEvaluation", "()Landroidx/graphics/path/PathIterator$ConicEvaluation;", "getPath", "()Landroid/graphics/Path;", "pointsData", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "floatsToPoints", "", "Landroid/graphics/PointF;", "type", "Landroidx/graphics/path/PathSegment$Type;", "([FLandroidx/graphics/path/PathSegment$Type;)[Landroid/graphics/PointF;", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/graphics/path/PathSegment;", "points", "offset", "peek", "Companion", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PathIteratorImpl {
    private static final Companion Companion = null;
    private final PathIterator.ConicEvaluation conicEvaluation;
    private final Path path;
    private final float[] pointsData;
    private final float tolerance;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/graphics/path/PathIteratorImpl$Companion;", "", "()V", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[PathSegment.Type.values().length];
            r100[PathSegment.Type.Move.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[PathSegment.Type.Line.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[PathSegment.Type.Quadratic.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[PathSegment.Type.Conic.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[PathSegment.Type.Cubic.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public abstract int calculateSize(boolean r100);

    public abstract boolean hasNext();

    public abstract PathSegment.Type next(float[] r100, int r101);

    public abstract PathSegment.Type peek();

    static {
        Companion = new Companion(null);
        INVOKESTATIC_androidx_graphics_path_PathIteratorImpl_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("androidx.graphics.path");
    }

    public final PathSegment next() {
        PathSegment.Type r100 = next(this.pointsData, 0);
        if (r100 != PathSegment.Type.Done) goto L7;
        return PathSegmentUtilities.getDoneSegment();
    L7:
        if (r100 != PathSegment.Type.Close) goto L11;
        return PathSegmentUtilities.getCloseSegment();
    L11:
        if (r100 != PathSegment.Type.Conic) goto L13;
        float r101 = this.pointsData[6];
    L15:
        return new PathSegment(r100, floatsToPoints(this.pointsData, r100), r101);
    L13:
        r101 = 0.0f;
        goto L15
    }

    public final PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    public final Path getPath() {
        return this.path;
    }

    public final float getTolerance() {
        return this.tolerance;
    }

    @JvmStatic
    public static void INVOKESTATIC_androidx_graphics_path_PathIteratorImpl_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private final PointF[] floatsToPoints(float[] r110, PathSegment.Type r111) {
        int r112 = WhenMappings.$EnumSwitchMapping$0[r111.ordinal()];
        if (r112 != 1) goto L5;
        PointF[] r113 = {new PointF(r110[0], r110[1])};
    L16:
        return r113;
    L5:
        if (r112 != 2) goto L7;
        r113 = new PointF[]{new PointF(r110[0], r110[1]), new PointF(r110[2], r110[3])};
        goto L16
    L7:
        if (r112 == 3) goto L12;
        if (r112 == 4) goto L12;
        if (r112 != 5) goto L17;
        r113 = new PointF[]{new PointF(r110[0], r110[1]), new PointF(r110[2], r110[3]), new PointF(r110[4], r110[5]), new PointF(r110[6], r110[7])};
        goto L16
    L17:
        return new PointF[0];
    L12:
        r113 = new PointF[]{new PointF(r110[0], r110[1]), new PointF(r110[2], r110[3]), new PointF(r110[4], r110[5])};
        goto L16
    }

    public PathIteratorImpl(Path r100, PathIterator.ConicEvaluation r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "conicEvaluation");
        this.path = r100;
        this.conicEvaluation = r101;
        this.tolerance = r102;
        this.pointsData = new float[8];
    }

    public /* synthetic */ PathIteratorImpl(Path r100, PathIterator.ConicEvaluation r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = PathIterator.ConicEvaluation.AsQuadratics;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0.25f;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ PathSegment.Type next$default(PathIteratorImpl r100, float[] r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        return r100.next(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
    }
}
