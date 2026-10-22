package androidx.compose.ui.text.android.selection;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/android/selection/GraphemeClusterSegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "<init>", "()V", "previous", "", "offset", TeaEventTrack.ACTION_DRAMA_NEXT, "previousStartBoundary", "previousEndBoundary", "nextStartBoundary", "nextEndBoundary", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class GraphemeClusterSegmentFinder implements SegmentFinder {
    public static final int $stable = 0;

    public GraphemeClusterSegmentFinder() {
    }

    public abstract int next(int r100);

    public abstract int previous(int r100);

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextEndBoundary(int r100) {
        return next(r100);
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int nextStartBoundary(int r100) {
        int r101 = next(r100);
        if (r101 != (-1)) goto L6;
        return -1;
    L6:
        if (next(r101) != (-1)) goto L9;
        return -1;
    L9:
        return r101;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousEndBoundary(int r100) {
        int r101 = previous(r100);
        if (r101 != (-1)) goto L6;
        return -1;
    L6:
        if (previous(r101) != (-1)) goto L9;
        return -1;
    L9:
        return r101;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int previousStartBoundary(int r100) {
        return previous(r100);
    }
}
