package com.bytedance.android.livesdk.livecommerce.view.countdown;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<WeakReference<q83.a>> f153219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f153220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f153221c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f153222a = null;

        static {
            f153222a = new d();
        }
    }

    public final void a() {
        ((CopyOnWriteArrayList) this.f153219a).clear();
        c r100 = this.f153220b;
        this.f153220b = null;
        if (r100 == null) goto L12;
        monitor-enter(r100);
        r100.f153215a = true;     // Catch: Throwable -> L9
        r100.f153216b = false;     // Catch: Throwable -> L9
        r100.f153217c.removeMessages(1);     // Catch: Throwable -> L9
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public d() {
        this.f153219a = new CopyOnWriteArrayList();
        this.f153221c = Boolean.TRUE;
    }

    public final void b(q83.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r101 = ((CopyOnWriteArrayList) this.f153219a).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        if (r100 != ((q83.a) ((WeakReference) r101.next()).get())) goto L6;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L17;
        WeakReference r103 = new WeakReference(r100);
        ((CopyOnWriteArrayList) this.f153219a).add(r103);
        return;
    L17:
        return;
    L10:
        r102 = false;
        goto L11
    }

    public final void c(q83.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = 0;
    L6:
        if (r101 >= ((CopyOnWriteArrayList) this.f153219a).size()) goto L11;
        if (((q83.a) ((WeakReference) ListProtector.get(this.f153219a, r101)).get()) == r100) goto L12;
        r101 = r101 + 1;
    L12:
        if (r101 < 0) goto L17;
        ListProtector.remove(this.f153219a, r101);
        return;
    L17:
        return;
    L11:
        r101 = -1;
        goto L12
    }

    @Override // q83.a
    public final boolean onTick(long r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f153219a).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        WeakReference r102 = (WeakReference) r101.next();
        q83.a r103 = (q83.a) r102.get();
        if (r103 == null) goto L9;
        if (r103.onTick(r100) == true) goto L4;
    L9:
        ((CopyOnWriteArrayList) this.f153219a).remove(r102);
        goto L4
    L10:
        return true;
    }
}
