package androidx.compose.foundation.lazy.grid;

import S7.k;
import S7.n;
import S7.o;
import S7.p;
import kotlin.Metadata;

@LazyGridScopeMarker
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001JX\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\b\nH&¢\u0006\u0004\b\f\u0010\rJ\u0084\u0001\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u001d\u0010\u0011\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\u0002\b\nH&¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0001\u0001\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", "key", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "span", "contentType", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "item", "(Ljava/lang/Object;LS7/k;Ljava/lang/Object;LS7/o;)V", "", "count", "Lkotlin/Function2;", "itemContent", "items", "(ILS7/k;LS7/n;LS7/k;LS7/p;)V", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyGridScope {
    static /* synthetic */ void item$default(LazyGridScope lazyGridScope, Object obj, k kVar, Object obj2, o oVar, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            kVar = null;
        }
        if ((i & 4) != 0) {
            obj2 = null;
        }
        lazyGridScope.item(obj, kVar, obj2, oVar);
    }

    static /* synthetic */ void items$default(LazyGridScope lazyGridScope, int i, k kVar, n nVar, k kVar2, p pVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i6 & 2) != 0) {
            kVar = null;
        }
        if ((i6 & 4) != 0) {
            nVar = null;
        }
        if ((i6 & 8) != 0) {
            kVar2 = new k() { // from class: androidx.compose.foundation.lazy.grid.LazyGridScope.items.1
                public final Void invoke(int i10) {
                    return null;
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        lazyGridScope.items(i, kVar, nVar, kVar2, pVar);
    }

    void item(Object key, k span, Object contentType, o content);

    void items(int count, k key, n span, k contentType, p itemContent);
}
