package com.bytedance.android.latch.prefetch.internal;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f58454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f58455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f58456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f58457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<w> f58458e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f58459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f58460b;

        public a(b r100, Function0<Unit> r101) {
            this.f58459a = r100;
            this.f58460b = r101;
        }

        public final void a() {
            this.f58459a.f58458e.clear();
            b r100 = this.f58459a;
            List<String> r101 = r100.f58455b.a();
            r100.f58454a.execute(new c(r101, r100));
            this.f58459a.f58457d = true;
            k r102 = n.f58484a;
            n.a("ConfigManager initialized successfully.");
            this.f58460b.invoke();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f58457d == false) goto L6;
        r100.invoke();
        return;
    L6:
        this.f58454a.execute(new a(this, r100));
    }

    @Override // com.bytedance.android.latch.prefetch.internal.e
    public final t a(final UriWrapper r100, final com.bytedance.android.latch.a.b r110) {
        Intrinsics.checkNotNullParameter(r100, "uriWrapper");
        Intrinsics.checkNotNullParameter(r110, "dataHolder");
        Iterator<w> r101 = this.f58458e.iterator();
    L3:
        t r102 = null;
        if (r101.hasNext() == false) goto L16;
        final w r103 = r101.next();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "uriWrapper");
        Intrinsics.checkNotNullParameter(r110, "dataHolder");
        if (r103.f58494a.isEmpty() == true) goto L15;
        final s r104 = r103.f58494a.get((String) r100.f58445e.getValue());
        if (r104 == null) goto L15;
        if (r104.f58487c != PrefetchPartial.NATIVE) goto L15;
        Triple r105 = (Triple) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r104.f58488d), new PrefetchConfig$getRequestConfigByUri$1$prefetchApis$1(r104, r100, r110, r103)), PrefetchConfig$getRequestConfigByUri$1$prefetchApis$2.INSTANCE));
        if (r105 == null) goto L15;
        r102 = new t(r104.f58485a, (Map) r105.getFirst(), (JSONObject) r105.getSecond(), ((Number) r105.getThird()).intValue());
    L15:
        if (r102 == null) goto L3;
    L16:
        return r102;
    }

    public b(Executor r100, f r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, "workerExecutor");
        Intrinsics.checkNotNullParameter(r101, "configProvider");
        this.f58454a = r100;
        this.f58455b = r101;
        this.f58456c = r102;
        this.f58458e = new CopyOnWriteArrayList();
    }
}
