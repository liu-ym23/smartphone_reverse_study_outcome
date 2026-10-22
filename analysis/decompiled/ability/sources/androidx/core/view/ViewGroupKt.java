package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import g1.AbstractC1451a;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\r\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\u0007*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0007*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0010\u0010\u000f\u001a(\u0010\u0013\u001a\u00020\n*\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0011H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a.\u0010\u0016\u001a\u00020\n*\u00020\u00002\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u0015H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001e\u0010\u001d\u001a\u00020\n*\u00020\u001b2\b\b\u0001\u0010\u001c\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a<\u0010#\u001a\u00020\n*\u00020\u001b2\b\b\u0003\u0010\u001f\u001a\u00020\u00012\b\b\u0003\u0010 \u001a\u00020\u00012\b\b\u0003\u0010!\u001a\u00020\u00012\b\b\u0003\u0010\"\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b#\u0010$\u001a<\u0010'\u001a\u00020\n*\u00020\u001b2\b\b\u0003\u0010%\u001a\u00020\u00012\b\b\u0003\u0010 \u001a\u00020\u00012\b\b\u0003\u0010&\u001a\u00020\u00012\b\b\u0003\u0010\"\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b'\u0010$\"\u0016\u0010\u001c\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u0016\u0010-\u001a\u00020**\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b+\u0010,\"\u001b\u00101\u001a\b\u0012\u0004\u0012\u00020\u00030.*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b/\u00100\"\u001b\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030.*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b2\u00100¨\u00064"}, d2 = {"Landroid/view/ViewGroup;", "", "index", "Landroid/view/View;", "get", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "view", "", "contains", "(Landroid/view/ViewGroup;Landroid/view/View;)Z", "LC7/r;", "plusAssign", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "minusAssign", "isEmpty", "(Landroid/view/ViewGroup;)Z", "isNotEmpty", "Lkotlin/Function1;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "forEach", "(Landroid/view/ViewGroup;LS7/k;)V", "Lkotlin/Function2;", "forEachIndexed", "(Landroid/view/ViewGroup;LS7/n;)V", "", "iterator", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "Landroid/view/ViewGroup$MarginLayoutParams;", "size", "setMargins", "(Landroid/view/ViewGroup$MarginLayoutParams;I)V", "left", "top", "right", "bottom", "updateMargins", "(Landroid/view/ViewGroup$MarginLayoutParams;IIII)V", "start", "end", "updateMarginsRelative", "getSize", "(Landroid/view/ViewGroup;)I", "LY7/f;", "getIndices", "(Landroid/view/ViewGroup;)LY7/f;", "indices", "Li9/i;", "getChildren", "(Landroid/view/ViewGroup;)Li9/i;", "children", "getDescendants", "descendants", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewGroupKt {

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "", "hasNext", "()Z", "next", "()Landroid/view/View;", "LC7/r;", "remove", "()V", "", "index", "I", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<View>, T7.a {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index - 1;
            this.index = i;
            viewGroup.removeViewAt(i);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup viewGroup = this.$this_iterator;
            int i = this.index;
            this.index = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(ViewGroup viewGroup, View view) {
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, S7.k kVar) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            kVar.invoke(viewGroup.getChildAt(i));
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, S7.n nVar) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            nVar.invoke(Integer.valueOf(i), viewGroup.getChildAt(i));
        }
    }

    public static final View get(ViewGroup viewGroup, int i) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sbU = B7.a.u(i, "Index: ", ", Size: ");
        sbU.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sbU.toString());
    }

    public static final i9.i getChildren(final ViewGroup viewGroup) {
        return new i9.i() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // i9.i
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final i9.i getDescendants(final ViewGroup viewGroup) {
        return new i9.i() { // from class: androidx.core.view.ViewGroupKt$special$$inlined$Sequence$1
            @Override // i9.i
            public Iterator<View> iterator() {
                return new TreeIterator(ViewGroupKt.getChildren(viewGroup).iterator(), new S7.k() { // from class: androidx.core.view.ViewGroupKt$descendants$1$1
                    @Override // S7.k
                    public final Iterator<View> invoke(View view) {
                        i9.i children;
                        ViewGroup viewGroup2 = view instanceof ViewGroup ? (ViewGroup) view : null;
                        if (viewGroup2 == null || (children = ViewGroupKt.getChildren(viewGroup2)) == null) {
                            return null;
                        }
                        return children.iterator();
                    }
                });
            }
        };
    }

    public static final Y7.f getIndices(ViewGroup viewGroup) {
        return AbstractC1451a.X(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        marginLayoutParams.setMargins(i, i6, i10, i11);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i12 & 2) != 0) {
            i6 = marginLayoutParams.topMargin;
        }
        if ((i12 & 4) != 0) {
            i10 = marginLayoutParams.rightMargin;
        }
        if ((i12 & 8) != 0) {
            i11 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i, i6, i10, i11);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.setMarginEnd(i10);
        marginLayoutParams.bottomMargin = i11;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i12 & 2) != 0) {
            i6 = marginLayoutParams.topMargin;
        }
        if ((i12 & 4) != 0) {
            i10 = marginLayoutParams.getMarginEnd();
        }
        if ((i12 & 8) != 0) {
            i11 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.setMarginEnd(i10);
        marginLayoutParams.bottomMargin = i11;
    }
}
