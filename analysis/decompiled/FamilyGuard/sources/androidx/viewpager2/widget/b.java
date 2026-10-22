package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class b extends ViewPager2.i {

    /* renamed from: a, reason: collision with root package name */
    private final List<ViewPager2.i> f11738a;

    b(int i5) {
        this.f11738a = new ArrayList(i5);
    }

    private void e(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i5) {
        try {
            Iterator<ViewPager2.i> it = this.f11738a.iterator();
            while (it.hasNext()) {
                it.next().a(i5);
            }
        } catch (ConcurrentModificationException e6) {
            e(e6);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i5, float f5, int i6) {
        try {
            Iterator<ViewPager2.i> it = this.f11738a.iterator();
            while (it.hasNext()) {
                it.next().b(i5, f5, i6);
            }
        } catch (ConcurrentModificationException e6) {
            e(e6);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void c(int i5) {
        try {
            Iterator<ViewPager2.i> it = this.f11738a.iterator();
            while (it.hasNext()) {
                it.next().c(i5);
            }
        } catch (ConcurrentModificationException e6) {
            e(e6);
        }
    }

    void d(ViewPager2.i iVar) {
        this.f11738a.add(iVar);
    }
}
