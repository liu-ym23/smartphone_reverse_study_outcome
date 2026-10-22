package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a0\u0010\u0013\u001a\u00020\u0014*\u00020\u00032!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\b\u001aE\u0010\u0019\u001a\u00020\u0014*\u00020\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u001aH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0086\u0002\u001a\r\u0010\u001d\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\r\u0010\u001e\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 *\u00020\u0003H\u0086\u0002\u001a\u0015\u0010!\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\"\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010#\u001a\u00020\u0014*\u00020$2\b\b\u0001\u0010\f\u001a\u00020\rH\u0086\b\u001a5\u0010%\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010&\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010(\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\u0086\b\u001a5\u0010*\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010+\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010,\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\t*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\r*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006-"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Landroid/view/ViewGroup;)Lkotlin/ranges/IntRange;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", MonitorConstants.CONNECT_TYPE_GET, "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "index", "", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "remove", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<View>, KMutableIterator {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup r100 = this.$this_iterator;
            int r101 = this.index;
            this.index = r101 + 1;
            View r102 = r100.getChildAt(r101);
            if (r102 == null) goto L6;
            return r102;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup r100 = this.$this_iterator;
            int r101 = this.index - 1;
            this.index = r101;
            r100.removeViewAt(r101);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ View next() {
            return next();
        }

        public AnonymousClass1(ViewGroup r100) {
            this.$this_iterator = r100;
        }
    }

    public static final Sequence<View> getChildren(final ViewGroup r100) {
        return new ViewGroupKt$children$1(r100);
    }

    public static final Sequence<View> getDescendants(final ViewGroup r100) {
        return new ViewGroupKt$special$$inlined$Sequence$1(r100);
    }

    public static final IntRange getIndices(ViewGroup r100) {
        return RangesKt.until(0, r100.getChildCount());
    }

    public static final int getSize(ViewGroup r100) {
        return r100.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup r100) {
        if (r100.getChildCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(ViewGroup r100) {
        if (r100.getChildCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<View> iterator(ViewGroup r100) {
        return new AnonymousClass1(r100);
    }

    public static final boolean contains(ViewGroup r100, View r101) {
        if (r100.indexOfChild(r101) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(ViewGroup r100, Function1<? super View, Unit> r101) {
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(r100.getChildAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final void forEachIndexed(ViewGroup r100, Function2<? super Integer, ? super View, Unit> r101) {
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Integer.valueOf(r103), r100.getChildAt(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final View get(ViewGroup r100, int r101) {
        View r102 = r100.getChildAt(r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new IndexOutOfBoundsException("Index: " + r101 + ", Size: " + r100.getChildCount());
    }

    public static final void minusAssign(ViewGroup r100, View r101) {
        r100.removeView(r101);
    }

    public static final void plusAssign(ViewGroup r100, View r101) {
        r100.addView(r101);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams r100, int r101) {
        r100.setMargins(r101, r101, r101, r101);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams r100, int r101, int r102, int r103, int r104) {
        r100.setMargins(r101, r102, r103, r104);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams r100, int r101, int r102, int r103, int r104) {
        r100.setMarginStart(r101);
        r100.topMargin = r102;
        r100.setMarginEnd(r103);
        r100.bottomMargin = r104;
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.leftMargin;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.topMargin;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.rightMargin;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.bottomMargin;
    L14:
        r100.setMargins(r101, r102, r103, r104);
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.getMarginStart();
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.topMargin;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.getMarginEnd();
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.bottomMargin;
    L14:
        r100.setMarginStart(r101);
        r100.topMargin = r102;
        r100.setMarginEnd(r103);
        r100.bottomMargin = r104;
    }
}
