package com.bytedance.android.shopping.anchorv4.perf.preload;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpPreloadDataManager f167323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f167324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f167325c;

    public i(PdpPreloadDataManager r100, String r101, List r102) {
        this.f167323a = r100;
        this.f167324b = r101;
        this.f167325c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List<o> r101 = ((PreloadMultiDataDTO) r100).getData();
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        o r103 = (o) r102.next();
        PdpPreloadDataManager.b(this.f167323a, this.f167324b, r103.b(), r103.c(), r103.a());
    L8:
        Set<a> r104 = this.f167323a.f167294b;
        monitor-enter(r104);
        Iterator<T> r105 = this.f167325c.iterator();     // Catch: Throwable -> L17
    L12:
        if (r105.hasNext() == false) goto L14;
        p r106 = (p) r105.next();     // Catch: Throwable -> L17
        this.f167323a.f167294b.remove(new a(r106.getPromotionId(), r106.getProductId(), this.f167324b));     // Catch: Throwable -> L17
        goto L12
    L14:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r104);
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
