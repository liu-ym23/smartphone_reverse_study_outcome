package com.bytedance.android.ecom.arch.slice.render.widget.fresco;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f50930a;

    public /* synthetic */ b(c r100) {
        this.f50930a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r100 = this.f50930a;
        if (r100.a() == false) goto L6;
        h r101 = r100.f50934d;
        r101.f50948g = false;
        r101.f50942a.scheduleDeferredRelease(r101);
        return;
    }
}
