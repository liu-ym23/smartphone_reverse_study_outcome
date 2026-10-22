package com.bytedance.android.shopping.anchorv4.perf.preload;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpPreloadDataManager f167326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f167327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f167328c;

    public j(PdpPreloadDataManager r100, List r101, String r102) {
        this.f167326a = r100;
        this.f167327b = r101;
        this.f167328c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Set<a> r102 = this.f167326a.f167294b;
        monitor-enter(r102);
        Iterator<T> r103 = this.f167327b.iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        p r104 = (p) r103.next();     // Catch: Throwable -> L11
        this.f167326a.f167294b.remove(new a(r104.getPromotionId(), r104.getProductId(), this.f167328c));     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
