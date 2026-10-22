package androidx.graphics.path;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"iterator", "Landroidx/graphics/path/PathIterator;", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "graphics-path_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathUtilities {
    public static final PathIterator iterator(Path r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new PathIterator(r100, null, 0.0f, 6, null);
    }

    public static final PathIterator iterator(Path r100, PathIterator.ConicEvaluation r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "conicEvaluation");
        return new PathIterator(r100, r101, r102);
    }

    public static /* synthetic */ PathIterator iterator$default(Path r100, PathIterator.ConicEvaluation r101, float r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0.25f;
    L6:
        return iterator(r100, r101, r102);
    }
}
