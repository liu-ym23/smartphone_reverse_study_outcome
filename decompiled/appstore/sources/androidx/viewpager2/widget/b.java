package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ViewPager2.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5199a;

    public b(int r10) {
        this.f5199a = new ArrayList(r10);
    }

    public void a(ViewPager2.h r10) {
        this.f5199a.add(r10);
    }

    public void b(ViewPager2.h r10) {
        this.f5199a.remove(r10);
    }

    public final void c(ConcurrentModificationException r10) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", r10);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.h
    public void onPageScrollStateChanged(int r10) {
        Iterator r11 = this.f5199a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r11.hasNext() == false) goto L14;
        ((ViewPager2.h) r11.next()).onPageScrollStateChanged(r10);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        c(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.h
    public void onPageScrolled(int r10, float r11, int r12) {
        Iterator r13 = this.f5199a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r13.hasNext() == false) goto L14;
        ((ViewPager2.h) r13.next()).onPageScrolled(r10, r11, r12);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        c(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.h
    public void onPageSelected(int r10) {
        Iterator r11 = this.f5199a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r11.hasNext() == false) goto L14;
        ((ViewPager2.h) r11.next()).onPageSelected(r10);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        c(e);
    }
}
