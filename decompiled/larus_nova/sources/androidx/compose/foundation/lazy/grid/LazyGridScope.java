package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes2.dex */
@LazyGridScopeMarker
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J`\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u001b\b\u0002\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\r¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u000eJÈ\u0001\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000620\b\u0002\u0010\u0005\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015¢\u0006\u0002\b\t2%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000621\u0010\u0016\u001a-\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\b\r¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u0017JI\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\b\r¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u0019\u0082\u0001\u0001\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", MapController.ITEM_LAYER_TAG, "", "key", "span", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "contentType", "content", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LazyGridScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void stickyHeader$default(LazyGridScope r100, Object r101, Object r102, Function4 r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            r100.stickyHeader(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void item$default(LazyGridScope r100, Object r101, Function1 r102, Object r103, Function3 r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r105 & 2) == 0) goto L10;
            r102 = null;
        L10:
            if ((r105 & 4) == 0) goto L12;
            r103 = null;
        L12:
            r100.item(r101, r102, r103, r104);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void items$default(LazyGridScope r100, int r101, Function1 r102, Function2 r110, Function1 r111, Function4 r112, int r113, Object r114) {
            if (r114 != null) goto L17;
            if ((r113 & 2) == 0) goto L6;
            Function1 r103 = null;
        L8:
            if ((r113 & 4) == 0) goto L10;
            Function2 r104 = null;
        L12:
            if ((r113 & 8) == 0) goto L14;
            r111 = AnonymousClass1.INSTANCE;
        L14:
            r100.items(r101, r103, r104, r111, r112);
            return;
        L10:
            r104 = r110;
            goto L12
        L6:
            r103 = r102;
            goto L8
        L17:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
    }

    void item(Object r100, Function1<? super LazyGridItemSpanScope, GridItemSpan> r101, Object r102, Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> r103);

    void items(int r100, Function1<? super Integer, ? extends Object> r101, Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> r102, Function1<? super Integer, ? extends Object> r103, Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r104);

    void stickyHeader(Object r100, Object r101, Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r102);
}
