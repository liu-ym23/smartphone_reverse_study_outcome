package androidx.compose.foundation.lazy;

import C7.c;
import S7.k;
import S7.o;
import S7.p;
import androidx.compose.foundation.ExperimentalFoundationApi;
import kotlin.Metadata;

@LazyScopeMarker
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J@\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ4\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0017¢\u0006\u0004\b\t\u0010\u000bJf\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u001d\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011JN\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u001d\u0010\u000f\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0007H\u0017¢\u0006\u0004\b\u0010\u0010\u0012J@\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H'¢\u0006\u0004\b\u0013\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "", "key", "contentType", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "item", "(Ljava/lang/Object;Ljava/lang/Object;LS7/o;)V", "(Ljava/lang/Object;LS7/o;)V", "", "count", "Lkotlin/Function2;", "itemContent", "items", "(ILS7/k;LS7/k;LS7/p;)V", "(ILS7/k;LS7/p;)V", "stickyHeader", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyListScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void item(LazyListScope lazyListScope, Object obj, Object obj2, o oVar) {
            LazyListScope.super.item(obj, obj2, oVar);
        }

        @Deprecated
        public static void items(LazyListScope lazyListScope, int i, k kVar, k kVar2, p pVar) {
            LazyListScope.super.items(i, kVar, kVar2, pVar);
        }
    }

    static /* synthetic */ void item$default(LazyListScope lazyListScope, Object obj, Object obj2, o oVar, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        lazyListScope.item(obj, obj2, oVar);
    }

    static /* synthetic */ void items$default(LazyListScope lazyListScope, int i, k kVar, k kVar2, p pVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i6 & 2) != 0) {
            kVar = null;
        }
        if ((i6 & 4) != 0) {
            kVar2 = new k() { // from class: androidx.compose.foundation.lazy.LazyListScope.items.1
                public final Void invoke(int i10) {
                    return null;
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        lazyListScope.items(i, kVar, kVar2, pVar);
    }

    static /* synthetic */ void stickyHeader$default(LazyListScope lazyListScope, Object obj, Object obj2, o oVar, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        lazyListScope.stickyHeader(obj, obj2, oVar);
    }

    default void item(Object key, Object contentType, o content) {
        throw new IllegalStateException("The method is not implemented");
    }

    default void items(int count, k key, k contentType, p itemContent) {
        throw new IllegalStateException("The method is not implemented");
    }

    @ExperimentalFoundationApi
    void stickyHeader(Object key, Object contentType, o content);

    static /* synthetic */ void item$default(LazyListScope lazyListScope, Object obj, o oVar, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        lazyListScope.item(obj, oVar);
    }

    @c
    /* synthetic */ default void item(Object key, o content) {
        item(key, null, content);
    }

    @c
    /* synthetic */ default void items(int count, k key, p itemContent) {
        items(count, key, new k() { // from class: androidx.compose.foundation.lazy.LazyListScope.items.2
            public final Object invoke(int i) {
                return null;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, itemContent);
    }

    static /* synthetic */ void items$default(LazyListScope lazyListScope, int i, k kVar, p pVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i6 & 2) != 0) {
            kVar = null;
        }
        lazyListScope.items(i, kVar, pVar);
    }
}
