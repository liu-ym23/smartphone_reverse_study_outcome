package androidx.compose.ui.platform;

import D7.q;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR#\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R'\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00050#j\b\u0012\u0004\u0012\u00020\u0005`$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R'\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00050#j\b\u0012\u0004\u0012\u00020\u0005`$8\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(¨\u0006+"}, d2 = {"Landroidx/compose/ui/platform/FocusSorter;", "", AppAgent.CONSTRUCT, "()V", "", "Landroid/view/View;", "views", "Landroid/view/ViewGroup;", "root", "", "isRtl", "LC7/r;", "sort", "([Landroid/view/View;Landroid/view/ViewGroup;Z)V", "Landroidx/collection/MutableObjectList;", "Landroid/graphics/Rect;", "rectPool", "Landroidx/collection/MutableObjectList;", "getRectPool", "()Landroidx/collection/MutableObjectList;", "", "lastPoolIndex", "I", "getLastPoolIndex", "()I", "setLastPoolIndex", "(I)V", "rtlMult", "getRtlMult", "setRtlMult", "Landroidx/collection/MutableScatterMap;", "rectByView", "Landroidx/collection/MutableScatterMap;", "getRectByView", "()Landroidx/collection/MutableScatterMap;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "topsComparator", "Ljava/util/Comparator;", "getTopsComparator", "()Ljava/util/Comparator;", "sidesComparator", "getSidesComparator", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class FocusSorter {
    private static int lastPoolIndex;
    private static final Comparator<View> sidesComparator;
    private static final Comparator<View> topsComparator;
    public static final FocusSorter INSTANCE = new FocusSorter();
    private static final MutableObjectList<Rect> rectPool = new MutableObjectList<>(0, 1, null);
    private static int rtlMult = 1;
    private static final MutableScatterMap<View, Rect> rectByView = ScatterMapKt.mutableScatterMapOf();

    static {
        final int i = 0;
        topsComparator = new Comparator() { // from class: androidx.compose.ui.platform.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                View view = (View) obj;
                View view2 = (View) obj2;
                switch (i) {
                    case 0:
                        return FocusSorter.topsComparator$lambda$0(view, view2);
                    default:
                        return FocusSorter.sidesComparator$lambda$1(view, view2);
                }
            }
        };
        final int i6 = 1;
        sidesComparator = new Comparator() { // from class: androidx.compose.ui.platform.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                View view = (View) obj;
                View view2 = (View) obj2;
                switch (i6) {
                    case 0:
                        return FocusSorter.topsComparator$lambda$0(view, view2);
                    default:
                        return FocusSorter.sidesComparator$lambda$1(view, view2);
                }
            }
        };
    }

    private FocusSorter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sidesComparator$lambda$1(View view, View view2) {
        if (view == view2) {
            return 0;
        }
        MutableScatterMap<View, Rect> mutableScatterMap = rectByView;
        Rect rect = mutableScatterMap.get(view);
        kotlin.jvm.internal.k.c(rect);
        Rect rect2 = rect;
        Rect rect3 = mutableScatterMap.get(view2);
        kotlin.jvm.internal.k.c(rect3);
        Rect rect4 = rect3;
        int i = rect2.left - rect4.left;
        return i == 0 ? (rect2.right - rect4.right) * rtlMult : i * rtlMult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int topsComparator$lambda$0(View view, View view2) {
        if (view == view2) {
            return 0;
        }
        MutableScatterMap<View, Rect> mutableScatterMap = rectByView;
        Rect rect = mutableScatterMap.get(view);
        kotlin.jvm.internal.k.c(rect);
        Rect rect2 = rect;
        Rect rect3 = mutableScatterMap.get(view2);
        kotlin.jvm.internal.k.c(rect3);
        Rect rect4 = rect3;
        int i = rect2.top - rect4.top;
        return i == 0 ? rect2.bottom - rect4.bottom : i;
    }

    public final int getLastPoolIndex() {
        return lastPoolIndex;
    }

    public final MutableScatterMap<View, Rect> getRectByView() {
        return rectByView;
    }

    public final MutableObjectList<Rect> getRectPool() {
        return rectPool;
    }

    public final int getRtlMult() {
        return rtlMult;
    }

    public final Comparator<View> getSidesComparator() {
        return sidesComparator;
    }

    public final Comparator<View> getTopsComparator() {
        return topsComparator;
    }

    public final void setLastPoolIndex(int i) {
        lastPoolIndex = i;
    }

    public final void setRtlMult(int i) {
        rtlMult = i;
    }

    public final void sort(View[] views, ViewGroup root, boolean isRtl) {
        int length = views.length;
        if (length < 2) {
            return;
        }
        int size = length - rectPool.getSize();
        for (int i = 0; i < size; i++) {
            rectPool.add(new Rect());
        }
        for (View view : views) {
            MutableObjectList<Rect> mutableObjectList = rectPool;
            int i6 = lastPoolIndex;
            lastPoolIndex = i6 + 1;
            Rect rect = mutableObjectList.get(i6);
            view.getDrawingRect(rect);
            root.offsetDescendantRectToMyCoords(view, rect);
            rectByView.set(view, rect);
        }
        q.C0(views, topsComparator);
        Rect rect2 = rectByView.get(views[0]);
        kotlin.jvm.internal.k.c(rect2);
        int iMax = rect2.bottom;
        rtlMult = isRtl ? -1 : 1;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            Rect rect3 = rectByView.get(views[i11]);
            kotlin.jvm.internal.k.c(rect3);
            Rect rect4 = rect3;
            if (rect4.top >= iMax) {
                if (i11 - i10 > 1) {
                    Comparator<View> comparator = sidesComparator;
                    kotlin.jvm.internal.k.f(comparator, "comparator");
                    Arrays.sort(views, i10, i11, comparator);
                }
                iMax = rect4.bottom;
                i10 = i11;
            } else {
                iMax = Math.max(iMax, rect4.bottom);
            }
        }
        if (length - i10 > 1) {
            Comparator<View> comparator2 = sidesComparator;
            kotlin.jvm.internal.k.f(comparator2, "comparator");
            Arrays.sort(views, i10, length, comparator2);
        }
        lastPoolIndex = 0;
        rectByView.clear();
    }
}
