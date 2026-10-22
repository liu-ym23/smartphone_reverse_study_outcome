package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f2016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Closeable> f2017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f2018c;

    public void a() {
    }

    public aj() {
        this.f2016a = new HashMap();
        this.f2017b = new LinkedHashSet();
        this.f2018c = false;
    }

    final void d() {
        this.f2018c = true;
        Map<String, Object> r0 = this.f2016a;
        if (r0 == null) goto L14;
        monitor-enter(r0);
        Iterator<Object> r1 = this.f2016a.values().iterator();     // Catch: Throwable -> L11
    L7:
        if (r1.hasNext() == false) goto L9;
        a(r1.next());     // Catch: Throwable -> L11
        goto L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        Set<Closeable> r2 = this.f2017b;
        if (r2 == null) goto L26;
        monitor-enter(r2);
        Iterator<Closeable> r3 = this.f2017b.iterator();     // Catch: Throwable -> L23
    L19:
        if (r3.hasNext() == false) goto L21;
        a((Closeable) ZeusTransformUtils.preCheckCast(r3.next(), Closeable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
        goto L19
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L26:
        a();
    }

    <T> T a(String r4, T r5) {
        Map<String, Object> r0 = this.f2016a;
        monitor-enter(r0);
        Object r1 = this.f2016a.get(r4);     // Catch: Throwable -> L15
        if (r1 != null) goto L7;
        this.f2016a.put(r4, r5);     // Catch: Throwable -> L15
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        r5 = (T) r1;
    L12:
        if (this.f2018c == false) goto L14;
        a(r5);
    L14:
        return r5;
    L15:
        th = move-exception;
        throw th;
    }

    <T> T b(String r2) {
        Map<String, Object> r0 = this.f2016a;
        if (r0 != null) goto L6;
        return null;
    L6:
        monitor-enter(r0);
        T r1 = (T) this.f2016a.get(r2);
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    private static void a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Closeable.class) == true) goto L10;
        return;
    L10:
        ((Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.aiagent.plugin")).close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
