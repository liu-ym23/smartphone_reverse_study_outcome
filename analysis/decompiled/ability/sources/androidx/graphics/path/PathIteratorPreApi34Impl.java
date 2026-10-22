package androidx.graphics.path;

import android.graphics.Path;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.graphics.path.PathIterator;
import androidx.graphics.path.PathSegment;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000bH\u0082 ¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000bH\u0083 ¢\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0083 ¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000bH\u0083 ¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000bH\u0083 ¢\u0006\u0004\b\u001c\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000bH\u0083 ¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000fH\u0004¢\u0006\u0004\b(\u0010)R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010*¨\u0006+"}, d2 = {"Landroidx/graphics/path/PathIteratorPreApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "Landroid/graphics/Path;", SingleFileBundle.KEY_PATH, "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "conicEvaluation", "", "tolerance", AppAgent.CONSTRUCT, "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "", "", "createInternalPathIterator", "(Landroid/graphics/Path;IF)J", "internalPathIterator", "LC7/r;", "destroyInternalPathIterator", "(J)V", "", "internalPathIteratorHasNext", "(J)Z", "", "points", TypedValues.CycleType.S_WAVE_OFFSET, "internalPathIteratorNext", "(J[FI)I", "internalPathIteratorPeek", "(J)I", "internalPathIteratorRawSize", "internalPathIteratorSize", "includeConvertedConics", "calculateSize", "(Z)I", "hasNext", "()Z", "Landroidx/graphics/path/PathSegment$Type;", "peek", "()Landroidx/graphics/path/PathSegment$Type;", "next", "([FI)Landroidx/graphics/path/PathSegment$Type;", "finalize", "()V", "J", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PathIteratorPreApi34Impl extends PathIteratorImpl {
    private final long internalPathIterator;

    public /* synthetic */ PathIteratorPreApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f, int i, e eVar) {
        this(path, (i & 2) != 0 ? PathIterator.ConicEvaluation.AsQuadratics : conicEvaluation, (i & 4) != 0 ? 0.25f : f);
    }

    private final native long createInternalPathIterator(Path path, int conicEvaluation, float tolerance);

    private final native void destroyInternalPathIterator(long internalPathIterator);

    @FastNative
    private final native boolean internalPathIteratorHasNext(long internalPathIterator);

    @FastNative
    private final native int internalPathIteratorNext(long internalPathIterator, float[] points, int offset);

    @FastNative
    private final native int internalPathIteratorPeek(long internalPathIterator);

    @FastNative
    private final native int internalPathIteratorRawSize(long internalPathIterator);

    @FastNative
    private final native int internalPathIteratorSize(long internalPathIterator);

    @Override // androidx.graphics.path.PathIteratorImpl
    public int calculateSize(boolean includeConvertedConics) {
        return (!includeConvertedConics || getConicEvaluation() == PathIterator.ConicEvaluation.AsConic) ? internalPathIteratorRawSize(this.internalPathIterator) : internalPathIteratorSize(this.internalPathIterator);
    }

    public final void finalize() {
        destroyInternalPathIterator(this.internalPathIterator);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public boolean hasNext() {
        return internalPathIteratorHasNext(this.internalPathIterator);
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type next(float[] points, int offset) {
        k.f(points, "points");
        return PathIteratorImplKt.PathSegmentTypes[internalPathIteratorNext(this.internalPathIterator, points, offset)];
    }

    @Override // androidx.graphics.path.PathIteratorImpl
    public PathSegment.Type peek() {
        return PathIteratorImplKt.PathSegmentTypes[internalPathIteratorPeek(this.internalPathIterator)];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathIteratorPreApi34Impl(Path path, PathIterator.ConicEvaluation conicEvaluation, float f) {
        super(path, conicEvaluation, f);
        k.f(path, "path");
        k.f(conicEvaluation, "conicEvaluation");
        this.internalPathIterator = createInternalPathIterator(path, conicEvaluation.ordinal(), f);
    }
}
