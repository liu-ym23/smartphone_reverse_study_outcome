package androidx.compose.ui.graphics;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0017H\u0096\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\t\u0010\u0019\u001a\u00020\u001dH\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPathIterator;", "Landroidx/compose/ui/graphics/PathIterator;", "path", "Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "<init>", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;F)V", "getPath", "()Landroidx/compose/ui/graphics/Path;", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "getTolerance", "()F", "segmentPoints", "", "implementation", "Landroidx/graphics/path/PathIterator;", "calculateSize", "", "includeConvertedConics", "", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", "offset", "Landroidx/compose/ui/graphics/PathSegment;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidPathIterator implements PathIterator {
    private final PathIterator.ConicEvaluation conicEvaluation;
    private final androidx.graphics.path.PathIterator implementation;
    private final Path path;
    private final float[] segmentPoints;
    private final float tolerance;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[PathIterator.ConicEvaluation.values().length];
            r100[PathIterator.ConicEvaluation.AsConic.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[PathIterator.ConicEvaluation.AsQuadratics.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L6:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[PathSegment.Type.values().length];
            r101[PathSegment.Type.Move.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L33:
            r101[PathSegment.Type.Line.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L27:
            r101[PathSegment.Type.Quadratic.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L29:
            r101[PathSegment.Type.Conic.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L21:
            r101[PathSegment.Type.Cubic.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L12:
            $EnumSwitchMapping$1 = r101;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // androidx.compose.ui.graphics.PathIterator, java.util.Iterator
    public boolean hasNext() {
        return this.implementation.hasNext();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.graphics.PathIterator, java.util.Iterator
    public PathSegment next() {
        float[] r100 = this.segmentPoints;
        if (r100.length < 8) goto L5;
        PathSegment.Type r101 = AndroidPathIterator_androidKt.access$toPathSegmentType(this.implementation.next(r100, 0));
        if (r101 != PathSegment.Type.Done) goto L11;
        return PathSegmentKt.getDoneSegment();
    L11:
        if (r101 == PathSegment.Type.Close) goto L13;
        int r102 = WhenMappings.$EnumSwitchMapping$1[r101.ordinal()];
        if (r102 != 1) goto L17;
        float[] r103 = {r100[0], r100[1]};
    L29:
        if (r101 != PathSegment.Type.Conic) goto L31;
        float r104 = r100[6];
    L33:
        return new PathSegment(r101, r103, r104);
    L31:
        r104 = 0.0f;
        goto L33
    L17:
        if (r102 != 2) goto L19;
        r103 = new float[]{r100[0], r100[1], r100[2], r100[3]};
        goto L29
    L19:
        if (r102 == 3) goto L25;
        if (r102 == 4) goto L24;
        if (r102 == 5) goto L23;
        r103 = new float[0];
        goto L29
    L23:
        r103 = new float[]{r100[0], r100[1], r100[2], r100[3], r100[4], r100[5], r100[6], r100[7]};
        goto L29
    L24:
        r103 = new float[]{r100[0], r100[1], r100[2], r100[3], r100[4], r100[5]};
        goto L29
    L25:
        r103 = new float[]{r100[0], r100[1], r100[2], r100[3], r100[4], r100[5]};
        goto L29
    L13:
        return PathSegmentKt.getCloseSegment();
    L5:
        return PathSegmentKt.getDoneSegment();
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public PathIterator.ConicEvaluation getConicEvaluation() {
        return this.conicEvaluation;
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public Path getPath() {
        return this.path;
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public float getTolerance() {
        return this.tolerance;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ PathSegment next() {
        return next();
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public int calculateSize(boolean r100) {
        return this.implementation.calculateSize(r100);
    }

    @Override // androidx.compose.ui.graphics.PathIterator
    public PathSegment.Type next(float[] r100, int r101) {
        return AndroidPathIterator_androidKt.access$toPathSegmentType(this.implementation.next(r100, r101));
    }

    public AndroidPathIterator(Path r100, PathIterator.ConicEvaluation r101, float r102) {
        this.path = r100;
        this.conicEvaluation = r101;
        this.tolerance = r102;
        this.segmentPoints = new float[8];
        Path r103 = getPath();
        if ((r103 instanceof AndroidPath) == false) goto L15;
        android.graphics.Path r104 = ((AndroidPath) r103).getInternalPath();
        PathIterator.ConicEvaluation r105 = getConicEvaluation();
        int r106 = WhenMappings.$EnumSwitchMapping$0[r105.ordinal()];
        if (r106 != 1) goto L7;
        androidx.graphics.path.PathIterator.ConicEvaluation r107 = androidx.graphics.path.PathIterator.ConicEvaluation.AsConic;
    L12:
        this.implementation = new androidx.graphics.path.PathIterator(r104, r107, getTolerance());
        return;
    L7:
        if (r106 != 2) goto L10;
        r107 = androidx.graphics.path.PathIterator.ConicEvaluation.AsQuadratics;
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }
}
