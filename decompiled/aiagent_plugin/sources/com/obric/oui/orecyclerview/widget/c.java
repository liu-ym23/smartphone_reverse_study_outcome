package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: AsyncDifferConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f35706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f35707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j.e<T> f35708c;

    /* JADX INFO: compiled from: AsyncDifferConfig.java */
    public static final class a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Object f35709d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Executor f35710e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Executor f35711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Executor f35712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j.e<T> f35713c;

        public a(j.e<T> r1) {
            this.f35713c = r1;
        }

        public c<T> a() {
            if (this.f35712b != null) goto L15;
            Object r0 = f35709d;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (f35710e != null) goto L9;
            f35710e = Executors.newFixedThreadPool(2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.f35712b = f35710e;
        L15:
            return new c(this.f35711a, this.f35712b, this.f35713c);
        }

        static {
            f35709d = new Object();
        }
    }

    c(Executor r3, Executor r4, j.e<T> r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        this.f35706a = r6;
        this.f35707b = r7;
        this.f35708c = r5;
    }

    public Executor a() {
        return this.f35706a;
    }

    public Executor b() {
        return this.f35707b;
    }

    public j.e<T> c() {
        return this.f35708c;
    }
}
