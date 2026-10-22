package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003H&J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "Landroidx/compose/foundation/gestures/ScrollScope;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "lastVisibleItemIndex", "getLastVisibleItemIndex", "itemCount", "getItemCount", "snapToItem", "", "index", "offset", "calculateDistanceTo", "targetIndex", "targetOffset", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LazyLayoutScrollScope extends ScrollScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ int calculateDistanceTo$default(LazyLayoutScrollScope r100, int r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = 0;
        L7:
            return r100.calculateDistanceTo(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateDistanceTo");
        }

        public static /* synthetic */ void snapToItem$default(LazyLayoutScrollScope r100, int r101, int r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = 0;
        L6:
            r100.snapToItem(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: snapToItem");
        }
    }

    int calculateDistanceTo(int r100, int r101);

    int getFirstVisibleItemIndex();

    int getFirstVisibleItemScrollOffset();

    int getItemCount();

    int getLastVisibleItemIndex();

    void snapToItem(int r100, int r101);
}
