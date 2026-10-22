package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012<\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0017H\u0096\u0002J\t\u0010\u0018\u001a\u00020\u0002H\u0096\u0002J\u0017\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowItemIterator;", "", "Landroidx/compose/ui/layout/Measurable;", "itemCount", "", "getMeasurables", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "_list", "", "itemIndex", "listIndex", "list", "getList", "()Ljava/util/List;", "hasNext", "", TeaEventTrack.ACTION_DRAMA_NEXT, "getNext", "getNext$foundation_layout", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextualFlowItemIterator implements Iterator<Measurable>, KMappedMarker {
    public static final int $stable = 8;
    private final List<Measurable> _list;
    private final Function2<Integer, FlowLineInfo, List<Measurable>> getMeasurables;
    private final int itemCount;
    private int itemIndex;
    private int listIndex;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Measurable next() {
        return getNext$foundation_layout$default(this, null, 1, null);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.listIndex >= getList().size()) goto L5;
    L8:
        return true;
    L5:
        if (this.itemIndex < this.itemCount) goto L8;
        return false;
    }

    public final List<Measurable> getList() {
        return this._list;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Measurable next() {
        return next();
    }

    public final Measurable getNext$foundation_layout(FlowLineInfo r100) {
        if (this.listIndex >= getList().size()) goto L5;
        Measurable r101 = (Measurable) ListProtector.get(getList(), this.listIndex);
        this.listIndex++;
        return r101;
    L5:
        int r102 = this.itemIndex;
        if (r102 >= this.itemCount) goto L13;
        List<Measurable> r103 = this.getMeasurables.invoke(Integer.valueOf(r102), r100);
        this.itemIndex++;
        if (r103.isEmpty() == true) goto L15;
        Measurable r104 = (Measurable) CollectionsKt.first(r103);
        this._list.addAll(r103);
        this.listIndex++;
        return r104;
    L15:
        return next();
    L13:
        throw new IndexOutOfBoundsException("No item returned at index call. Index: " + this.itemIndex);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContextualFlowItemIterator(int r100, Function2<? super Integer, ? super FlowLineInfo, ? extends List<? extends Measurable>> r101) {
        this.itemCount = r100;
        this.getMeasurables = r101;
        this._list = new ArrayList();
    }

    public static /* synthetic */ Measurable getNext$foundation_layout$default(ContextualFlowItemIterator r100, FlowLineInfo r101, int r102, Object r110) {
        if ((r102 & 1) == 0) goto L6;
        r101 = new FlowLineInfo(0, 0, 0.0f, 0.0f, 15, null);
    L6:
        return r100.getNext$foundation_layout(r101);
    }
}
