package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: EntityInsertionAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f<T> extends v {
    public abstract void a(androidx.sqlite.db.g r1, T r2);

    public f(p r1) {
        super(r1);
    }

    public final void insert(T r2) {
        androidx.sqlite.db.g r0 = c();
        a(r0, r2);     // Catch: Throwable -> L6
        r0.b();     // Catch: Throwable -> L6
        a(r0);
        return;
    L6:
        th = move-exception;
        a(r0);
        throw th;
    }

    public final void insert(T[] r5) {
        androidx.sqlite.db.g r0 = c();
        int r1 = r5.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L7;
        a(r0, r5[r2]);     // Catch: Throwable -> L9
        r0.b();     // Catch: Throwable -> L9
        r2 = r2 + 1;
        goto L4
    L7:
        a(r0);
        return;
    L9:
        th = move-exception;
        a(r0);
        throw th;
    }

    public final void insert(Iterable<? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        androidx.sqlite.db.g r0 = c();
        Iterator<T> r5 = r4.iterator();     // Catch: Throwable -> L10
    L5:
        if (r5.hasNext() == false) goto L8;
        a(r0, r5.next());     // Catch: Throwable -> L10
        r0.b();     // Catch: Throwable -> L10
        goto L5
    L8:
        a(r0);
        return;
    L10:
        th = move-exception;
        a(r0);
        throw th;
    }

    public final long a(T r4) {
        androidx.sqlite.db.g r0 = c();
        a(r0, r4);     // Catch: Throwable -> L6
        long r1 = r0.b();     // Catch: Throwable -> L6
        a(r0);
        return r1;
    L6:
        th = move-exception;
        a(r0);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<Long> a(Collection<? extends T> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.aiagent.plugin");
        androidx.sqlite.db.g r0 = c();
        ArrayList r1 = new ArrayList(r7.size());     // Catch: Throwable -> L10
        int r2 = 0;
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L10
    L5:
        if (r8.hasNext() == false) goto L8;
        a(r0, r8.next());     // Catch: Throwable -> L10
        r1.add(r2, Long.valueOf(r0.b()));     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        a(r0);
        return r1;
    L10:
        th = move-exception;
        a(r0);
        throw th;
    }
}
