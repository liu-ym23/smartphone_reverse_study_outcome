package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: EntityDeletionOrUpdateAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e<T> extends v {
    public abstract void a(androidx.sqlite.db.g r1, T r2);

    public e(p r1) {
        super(r1);
    }

    public final int a(T r2) {
        androidx.sqlite.db.g r0 = c();
        a(r0, r2);     // Catch: Throwable -> L6
        int r3 = r0.a();     // Catch: Throwable -> L6
        a(r0);
        return r3;
    L6:
        th = move-exception;
        a(r0);
        throw th;
    }

    public final int a(Iterable<? extends T> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        androidx.sqlite.db.g r0 = c();
        int r1 = 0;
        Iterator<T> r6 = r5.iterator();     // Catch: Throwable -> L10
    L5:
        if (r6.hasNext() == false) goto L8;
        a(r0, r6.next());     // Catch: Throwable -> L10
        r1 = r1 + r0.a();
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
