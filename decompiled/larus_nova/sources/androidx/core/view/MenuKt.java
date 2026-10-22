package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", MapController.ITEM_LAYER_TAG, "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", MonitorConstants.CONNECT_TYPE_GET, "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "removeItemAt", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "index", "", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "remove", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<MenuItem>, KMutableIterator {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu r100 = this.$this_iterator;
            int r101 = this.index;
            this.index = r101 + 1;
            MenuItem r102 = r100.getItem(r101);
            if (r102 == null) goto L6;
            return r102;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu r100 = this.$this_iterator;
            int r101 = this.index - 1;
            this.index = r101;
            MenuItem r102 = r100.getItem(r101);
            if (r102 == null) goto L5;
            r100.removeItem(r102.getItemId());
            Unit r103 = Unit.INSTANCE;
        L6:
            if (r103 == null) goto L9;
            return;
        L9:
            throw new IndexOutOfBoundsException();
        L5:
            r103 = null;
            goto L6
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ MenuItem next() {
            return next();
        }

        public AnonymousClass1(Menu r100) {
            this.$this_iterator = r100;
        }
    }

    public static final Sequence<MenuItem> getChildren(final Menu r100) {
        return new MenuKt$children$1(r100);
    }

    public static final int getSize(Menu r100) {
        return r100.size();
    }

    public static final boolean isEmpty(Menu r100) {
        if (r100.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(Menu r100) {
        if (r100.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<MenuItem> iterator(Menu r100) {
        return new AnonymousClass1(r100);
    }

    public static final boolean contains(Menu r100, MenuItem r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (Intrinsics.areEqual(r100.getItem(r103), r101) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final void forEach(Menu r100, Function1<? super MenuItem, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(r100.getItem(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final void forEachIndexed(Menu r100, Function2<? super Integer, ? super MenuItem, Unit> r101) {
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.invoke(Integer.valueOf(r103), r100.getItem(r103));
        r103 = r103 + 1;
        goto L3
    }

    public static final MenuItem get(Menu r100, int r101) {
        return r100.getItem(r101);
    }

    public static final void minusAssign(Menu r100, MenuItem r101) {
        r100.removeItem(r101.getItemId());
    }

    public static final void removeItemAt(Menu r100, int r101) {
        MenuItem r102 = r100.getItem(r101);
        if (r102 == null) goto L5;
        r100.removeItem(r102.getItemId());
        Unit r103 = Unit.INSTANCE;
    L6:
        if (r103 == null) goto L9;
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L5:
        r103 = null;
        goto L6
    }
}
