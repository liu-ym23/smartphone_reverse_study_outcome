package androidx.graphics.path;

import android.graphics.Path;
import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J!\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0082 J\b\u0010\u0012\u001a\u00020\u0011H\u0004J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0011\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0083 J!\u0010\u0015\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0083 J\u0011\u0010\u0019\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0083 J\u0011\u0010\u001a\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0083 J\u0011\u0010\u001b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0083 J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/graphics/path/PathIteratorPreApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "internalPathIterator", "", "calculateSize", "", "includeConvertedConics", "", "createInternalPathIterator", "destroyInternalPathIterator", "", "finalize", "hasNext", "internalPathIteratorHasNext", "internalPathIteratorNext", "points", "", "offset", "internalPathIteratorPeek", "internalPathIteratorRawSize", "internalPathIteratorSize", TeaEventTrack.ACTION_DRAMA_NEXT, "Landroidx/graphics/path/PathSegment$Type;", "peek", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PathIteratorPreApi34Impl extends PathIteratorImpl {
    private final long internalPathIterator;

    private final native long createInternalPathIterator(Path r100, int r101, float r102);

    private final native void destroyInternalPathIterator(long r100);

    private final native boolean internalPathIteratorHasNext(long r100);

    private final native int internalPathIteratorNext(long r100, float[] r101, int r102);

    private final native int internalPathIteratorPeek(long r100);

    private final native int internalPathIteratorRawSize(long r100);

    private final native int internalPathIteratorSize(long r100);

    public final void finalize() {
        destroyInternalPathIterator(this.internalPathIterator);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public boolean hasNext() {
        return internalPathIteratorHasNext(this.internalPathIterator);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type peek() {
        return PathIteratorImplKt.access$getPathSegmentTypes$p()[internalPathIteratorPeek(this.internalPathIterator)];
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public int calculateSize(boolean r100) {
        if (r100 == false) goto L8;
        if (getConicEvaluation() == PathIterator.ConicEvaluation.AsConic) goto L8;
        return internalPathIteratorSize(this.internalPathIterator);
    L8:
        return internalPathIteratorRawSize(this.internalPathIterator);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type next(float[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "points");
        return PathIteratorImplKt.access$getPathSegmentTypes$p()[internalPathIteratorNext(this.internalPathIterator, r100, r101)];
    }

    public PathIteratorPreApi34Impl(Path r100, PathIterator.ConicEvaluation r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "conicEvaluation");
        super(r100, r101, r102);
        this.internalPathIterator = createInternalPathIterator(r100, r101.ordinal(), r102);
    }

    public /* synthetic */ PathIteratorPreApi34Impl(Path r100, PathIterator.ConicEvaluation r101, float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = PathIterator.ConicEvaluation.AsQuadratics;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0.25f;
    L8:
        this(r100, r101, r102);
    }
}
