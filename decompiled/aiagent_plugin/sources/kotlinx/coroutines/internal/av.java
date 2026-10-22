package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes4.dex */
final class av extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final av f39384a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantReadWriteLock f39385b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, d.h.a.b<Throwable, Throwable>> f39386c = null;

    private av() {
    }

    static {
        f39384a = new av();
        f39385b = new ReentrantReadWriteLock();
        f39386c = new WeakHashMap();
    }

    @Override // kotlinx.coroutines.internal.k
    public d.h.a.b<Throwable, Throwable> a(Class<? extends Throwable> r8) {
        ReentrantReadWriteLock r0 = f39385b;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        r1.lock();
        d.h.a.b<Throwable, Throwable> r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(f39386c.get(r8), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        r1.unlock();
        if (r2 == null) goto L7;
        return r2;
    L7:
        ReentrantReadWriteLock.ReadLock r3 = r0.readLock();
        int r4 = 0;
        if (r0.getWriteHoldCount() != 0) goto L10;
        int r5 = r0.getReadHoldCount();
    L11:
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        r3.unlock();
        r6 = r6 + 1;
        goto L12
    L14:
        ReentrantReadWriteLock.WriteLock r7 = r0.writeLock();
        r7.lock();
        WeakHashMap<Class<? extends Throwable>, d.h.a.b<Throwable, Throwable>> r9 = f39386c;     // Catch: Throwable -> L26
        d.h.a.b<Throwable, Throwable> r10 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r9.get(r8), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        if (r10 == null) goto L21;
    L17:
        if (r4 >= r5) goto L19;
        r3.lock();
        r4 = r4 + 1;
        goto L17
    L19:
        r7.unlock();
        return r10;
    L21:
        d.h.a.b<Throwable, Throwable> r11 = p.a(r8);     // Catch: Throwable -> L26
        ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin")).put(r8, r11);     // Catch: Throwable -> L26
    L22:
        if (r4 >= r5) goto L24;
        r3.lock();
        r4 = r4 + 1;
        goto L22
    L24:
        r7.unlock();
        return r11;
    L26:
        th = move-exception;
    L27:
        if (r4 >= r5) goto L29;
        r3.lock();
        r4 = r4 + 1;
        goto L27
    L29:
        r7.unlock();
        throw th;
    L10:
        r5 = 0;
    L31:
        th = move-exception;
        r1.unlock();
        throw th;
    }
}
