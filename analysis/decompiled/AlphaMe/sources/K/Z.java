package K;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
public final class Z implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    public int f945a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f946b;

    public Z(ViewGroup viewGroup) {
        this.f946b = viewGroup;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f945a < this.f946b.getChildCount();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i4 = this.f945a;
        this.f945a = i4 + 1;
        View childAt = this.f946b.getChildAt(i4);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i4 = this.f945a - 1;
        this.f945a = i4;
        this.f946b.removeViewAt(i4);
    }
}
