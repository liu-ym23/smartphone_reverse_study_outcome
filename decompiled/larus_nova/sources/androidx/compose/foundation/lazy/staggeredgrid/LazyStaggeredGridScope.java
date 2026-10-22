package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes2.dex */
@LazyStaggeredGridScopeMarker
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH&¢\u0006\u0002\u0010\rJ½\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t21\u0010\u0014\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH&¢\u0006\u0002\u0010\u0016\u0082\u0001\u0001\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", MapController.ITEM_LAYER_TAG, "", "key", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LazyStaggeredGridScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void item$default(LazyStaggeredGridScope r100, Object r101, Object r102, StaggeredGridItemSpan r103, Function3 r104, int r105, Object r106) {
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
        public static /* synthetic */ void items$default(LazyStaggeredGridScope r100, int r101, Function1 r102, Function1 r110, Function1 r111, Function4 r112, int r113, Object r114) {
            if (r114 != null) goto L17;
            if ((r113 & 2) == 0) goto L6;
            Function1 r103 = null;
        L8:
            if ((r113 & 4) == 0) goto L10;
            r110 = AnonymousClass1.INSTANCE;
        L10:
            Function1 r104 = r110;
            if ((r113 & 8) == 0) goto L13;
            Function1 r105 = null;
        L14:
            r100.items(r101, r103, r104, r105, r112);
            return;
        L13:
            r105 = r111;
            goto L14
        L6:
            r103 = r102;
            goto L8
        L17:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
    }

    void item(Object r100, Object r101, StaggeredGridItemSpan r102, Function3<? super LazyStaggeredGridItemScope, ? super Composer, ? super Integer, Unit> r103);

    void items(int r100, Function1<? super Integer, ? extends Object> r101, Function1<? super Integer, ? extends Object> r102, Function1<? super Integer, StaggeredGridItemSpan> r103, Function4<? super LazyStaggeredGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> r104);
}
