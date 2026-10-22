package androidx.viewpager2.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CompositeOnPageChangeCallback.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ViewPager2.e> f2956a;

    b(int r2) {
        this.f2956a = new ArrayList(r2);
    }

    void a(ViewPager2.e r1) {
        this.f2956a.add(r1);
    }

    void b(ViewPager2.e r1) {
        this.f2956a.remove(r1);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int r5, float r6, int r7) {
        Iterator<ViewPager2.e> r0 = this.f2956a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        ((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0.next(), ViewPager2.e.class, "com.obric.aiagent.plugin")).a(r5, r6, r7);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        a(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int r5) {
        Iterator<ViewPager2.e> r0 = this.f2956a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        ((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0.next(), ViewPager2.e.class, "com.obric.aiagent.plugin")).b(r5);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        a(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int r5) {
        Iterator<ViewPager2.e> r0 = this.f2956a.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        ((ViewPager2.e) ZeusTransformUtils.preCheckCast(r0.next(), ViewPager2.e.class, "com.obric.aiagent.plugin")).a(r5);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        a(e);
    }

    private void a(ConcurrentModificationException r2) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", r2);
    }
}
