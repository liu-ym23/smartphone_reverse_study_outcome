package androidx.core.graphics;

import android.graphics.Path;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\f"}, d2 = {"and", "Landroid/graphics/Path;", "p", "flatten", "", "Landroidx/core/graphics/PathSegment;", "error", "", "minus", SRStrategy.KEY_ORIGIN_RESOLUTION, "plus", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathKt {
    public static final Path and(Path r100, Path r101) {
        Path r102 = new Path();
        r102.op(r100, r101, Path.Op.INTERSECT);
        return r102;
    }

    public static final Iterable<PathSegment> flatten(Path r100, float r101) {
        return PathUtils.flatten(r100, r101);
    }

    public static final Path minus(Path r100, Path r101) {
        Path r102 = new Path(r100);
        r102.op(r101, Path.Op.DIFFERENCE);
        return r102;
    }

    public static final Path or(Path r100, Path r101) {
        Path r102 = new Path(r100);
        r102.op(r101, Path.Op.UNION);
        return r102;
    }

    public static final Path plus(Path r100, Path r101) {
        Path r102 = new Path(r100);
        r102.op(r101, Path.Op.UNION);
        return r102;
    }

    public static final Path xor(Path r100, Path r101) {
        Path r102 = new Path(r100);
        r102.op(r101, Path.Op.XOR);
        return r102;
    }

    public static /* synthetic */ Iterable flatten$default(Path r100, float r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 0.5f;
    L6:
        return flatten(r100, r101);
    }
}
