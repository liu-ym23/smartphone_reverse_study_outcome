package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    private final List<ViewPager2.OnPageChangeCallback> mCallbacks;

    public CompositeOnPageChangeCallback(int r100) {
        this.mCallbacks = new ArrayList(r100);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException r100) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", r100);
    }

    public void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback r100) {
        this.mCallbacks.add(r100);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r100) {
        Iterator<ViewPager2.OnPageChangeCallback> r101 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r101.hasNext() == false) goto L14;
        r101.next().onPageScrollStateChanged(r100);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r100) {
        Iterator<ViewPager2.OnPageChangeCallback> r101 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r101.hasNext() == false) goto L14;
        r101.next().onPageSelected(r100);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    public void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback r100) {
        this.mCallbacks.remove(r100);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r100, float r101, int r102) {
        Iterator<ViewPager2.OnPageChangeCallback> r103 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r103.hasNext() == false) goto L14;
        r103.next().onPageScrolled(r100, r101, r102);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }
}
