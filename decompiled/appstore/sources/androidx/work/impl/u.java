package androidx.work.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5776b;

    public u() {
        this.f5775a = new Object();
        this.f5776b = new LinkedHashMap();
    }

    public final boolean a(androidx.work.impl.model.i r10) {
        kotlin.jvm.internal.q.g(r10, "id");
        Object r11 = this.f5775a;
        monitor-enter(r11);
        boolean r12 = this.f5776b.containsKey(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public final t b(androidx.work.impl.model.i r10) {
        kotlin.jvm.internal.q.g(r10, "id");
        Object r11 = this.f5775a;
        monitor-enter(r11);
        t r12 = (t) this.f5776b.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public final List c(String r10) {
        kotlin.jvm.internal.q.g(r10, "workSpecId");
        Object r11 = this.f5775a;
        monitor-enter(r11);
        Map r12 = this.f5776b;     // Catch: Throwable -> L10
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Throwable -> L10
        Iterator r14 = r12.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r14.hasNext() == false) goto L12;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L10
        if (kotlin.jvm.internal.q.b(((androidx.work.impl.model.i) r15.getKey()).b(), r10) == false) goto L6;
        r13.put(r15.getKey(), r15.getValue());     // Catch: Throwable -> L10
        goto L6
    L12:
        Iterator r16 = r13.keySet().iterator();     // Catch: Throwable -> L10
    L14:
        if (r16.hasNext() == false) goto L16;
        androidx.work.impl.model.i r17 = (androidx.work.impl.model.i) r16.next();     // Catch: Throwable -> L10
        this.f5776b.remove(r17);     // Catch: Throwable -> L10
        goto L14
    L16:
        List r18 = kotlin.collections.b0.x0(r13.values());     // Catch: Throwable -> L10
        monitor-exit(r11);
        return r18;
    L10:
        th = move-exception;
        throw th;
    }

    public final t d(androidx.work.impl.model.i r10) {
        kotlin.jvm.internal.q.g(r10, "id");
        Object r11 = this.f5775a;
        monitor-enter(r11);
        Map r12 = this.f5776b;     // Catch: Throwable -> L7
        Object r13 = r12.get(r10);     // Catch: Throwable -> L7
        if (r13 != null) goto L9;
        r13 = new t(r10);     // Catch: Throwable -> L7
        r12.put(r10, r13);     // Catch: Throwable -> L7
    L9:
        t r14 = (t) r13;     // Catch: Throwable -> L7
        monitor-exit(r11);
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    public final t e(androidx.work.impl.model.o r10) {
        kotlin.jvm.internal.q.g(r10, "spec");
        return d(androidx.work.impl.model.q.a(r10));
    }
}
