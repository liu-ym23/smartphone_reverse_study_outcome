package com.bytedance.android.gamecp.live_impl.preview;

import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<WeakReference<ow.a>> f57928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CompositeDisposable f57929b;

    public f() {
        this.f57928a = new LinkedList();
    }

    public final void a(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        CompositeDisposable r101 = this.f57929b;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        CompositeDisposable r102 = null;
    L10:
        this.f57929b = r102;
        Iterator<T> r103 = this.f57928a.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        ow.a r104 = (ow.a) ((WeakReference) r103.next()).get();
        if (r104 == null) goto L12;
        r104.c(r100);
        goto L12
    L16:
        return;
    L4:
        if (this.f57929b != null) goto L6;
        r102 = new CompositeDisposable();
        goto L10
    }

    public final void b(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        CompositeDisposable r101 = this.f57929b;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        CompositeDisposable r102 = null;
    L10:
        this.f57929b = r102;
        Iterator<T> r103 = this.f57928a.iterator();
    L12:
        if (r103.hasNext() == false) goto L16;
        ow.a r104 = (ow.a) ((WeakReference) r103.next()).get();
        if (r104 == null) goto L12;
        r104.b(r100);
        goto L12
    L16:
        return;
    L4:
        if (this.f57929b != null) goto L6;
        r102 = new CompositeDisposable();
        goto L10
    }
}
