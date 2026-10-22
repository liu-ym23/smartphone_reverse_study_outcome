package androidx.graphics.path;

import android.graphics.Path;
import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/graphics/path/PathIteratorApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "conicConverter", "Landroidx/graphics/path/ConicConverter;", "platformIterator", "Landroid/graphics/PathIterator;", "calculateSize", "", "includeConvertedConics", "", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/graphics/path/PathSegment$Type;", "points", "", "offset", "peek", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathIteratorApi34Impl extends PathIteratorImpl {
    private final ConicConverter conicConverter;
    private final android.graphics.PathIterator platformIterator;

    @Override // androidx.graphics.path.PathIteratorImpl
    public boolean hasNext() {
        return this.platformIterator.hasNext();
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type peek() {
        return PathIteratorImplKt.access$platformToAndroidXSegmentType(this.platformIterator.peek());
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public int calculateSize(boolean r110) {
        if (r110 == true) goto L5;
    L7:
        boolean r111 = false;
    L8:
        android.graphics.PathIterator r100 = getPath().getPathIterator();
        float[] r101 = new float[8];
        int r112 = 0;
    L10:
        if (r100.hasNext() == false) goto L16;
        if (r100.next(r101, 0) != 3) goto L15;
        if (r111 == false) goto L15;
        ConicConverter r113 = this.conicConverter;
        ConicConverter.convert$default(r113, r101, r101[6], getTolerance(), 0, 8, null);
        r112 = r112 + r113.getQuadraticCount();
    L15:
        r112 = r112 + 1;
        goto L10
    L16:
        return r112;
    L5:
        if (getConicEvaluation() != PathIterator.ConicEvaluation.AsQuadratics) goto L7;
        r111 = true;
        goto L8
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type next(float[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "points");
        if (this.conicConverter.getCurrentQuadratic() >= this.conicConverter.getQuadraticCount()) goto L6;
        this.conicConverter.nextQuadratic(r100, r101);
        return PathSegment.Type.Quadratic;
    L6:
        PathSegment.Type r102 = PathIteratorImplKt.access$platformToAndroidXSegmentType(this.platformIterator.next(r100, r101));
        if (r102 == PathSegment.Type.Conic) goto L9;
    L15:
        return r102;
    L9:
        if (getConicEvaluation() != PathIterator.ConicEvaluation.AsQuadratics) goto L15;
        ConicConverter r103 = this.conicConverter;
        r103.convert(r100, r100[r101 + 6], getTolerance(), r101);
        if (r103.getQuadraticCount() <= 0) goto L14;
        r103.nextQuadratic(r100, r101);
    L14:
        return PathSegment.Type.Quadratic;
    }

    public PathIteratorApi34Impl(Path r100, PathIterator.ConicEvaluation r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "conicEvaluation");
        super(r100, r101, r102);
        this.platformIterator = r100.getPathIterator();
        this.conicConverter = new ConicConverter();
    }

    public /* synthetic */ PathIteratorApi34Impl(Path r100, PathIterator.ConicEvaluation r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = PathIterator.ConicEvaluation.AsQuadratics;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0.25f;
    L8:
        this(r100, r101, r102);
    }
}
