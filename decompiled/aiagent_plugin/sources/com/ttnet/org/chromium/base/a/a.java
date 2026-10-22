package com.ttnet.org.chromium.base.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: CachingUmaRecorder.java */
/* JADX INFO: loaded from: classes4.dex */
final class a implements c {
    private static final String TAG = "CachingUmaRecorder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37679a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f37680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, C1025a> f37681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f37682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Object> f37683e;
    private c f;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CachingUmaRecorder.java */
    static class C1025a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f37684a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f37685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f37686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f37687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f37688e;
        private final int f;
        private final List<Integer> g;

        static {
            f37684a = true;
        }

        C1025a(int r2, String r3, int r4, int r5, int r6) {
            if (f37684a == false) goto L5;
        L14:
            this.f37685b = r2;
            this.f37686c = r3;
            this.f37687d = r4;
            this.f37688e = r5;
            this.f = r6;
            this.g = new ArrayList(1);
            return;
        L5:
            if (r2 == 2) goto L14;
            if (r2 == 3) goto L14;
            if (r4 != 0) goto L13;
            if (r5 != 0) goto L13;
            if (r6 == 0) goto L14;
        L13:
            throw new AssertionError("Histogram type " + r2 + " must have no min/max/buckets set");
        }

        synchronized boolean a(int r3, String r4, int r5, int r6, int r7, int r8) {
            monitor-enter(this);
            boolean r0 = f37684a;     // Catch: Throwable -> L47
            if (r0 == false) goto L6;
        L10:
            if (r0 == false) goto L12;
        L16:
            if (r0 == false) goto L18;
        L22:
            if (r0 == false) goto L24;
        L28:
            if (r0 == true) goto L36;
            if (this.f == r8) goto L36;
            throw new AssertionError();     // Catch: Throwable -> L47
        L36:
            if (this.g.size() < 256) goto L43;
            if (r0 == false) goto L42;
            monitor-exit(this);
            return false;
        L42:
            throw new AssertionError("Histogram exceeded sample cache size limit");     // Catch: Throwable -> L47
        L43:
            this.g.add(Integer.valueOf(r5));     // Catch: Throwable -> L47
            monitor-exit(this);
            return true;
        L24:
            if (this.f37688e == r7) goto L28;
            throw new AssertionError();     // Catch: Throwable -> L47
        L18:
            if (this.f37687d == r6) goto L22;
            throw new AssertionError();     // Catch: Throwable -> L47
        L12:
            if (this.f37686c.equals(r4) == true) goto L16;
            throw new AssertionError();     // Catch: Throwable -> L47
        L6:
            if (this.f37685b == r3) goto L10;
            throw new AssertionError();     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    a() {
        this.f37680b = new ReentrantReadWriteLock(false);
        this.f37681c = new HashMap();
        this.f37682d = new AtomicInteger();
        this.f37683e = new ArrayList();
    }

    private void a(int r2, String r3, int r4, int r5, int r6, int r7) {
        if (b(r2, r3, r4, r5, r6, r7) == false) goto L5;
        return;
    L5:
        this.f37680b.writeLock().lock();
    L26:
        th = move-exception;
        this.f37680b.writeLock().unlock();
        throw th;
    L7:
        if (this.f != null) goto L11;
        c(r2, r3, r4, r5, r6, r7);     // Catch: Throwable -> L26
        this.f37680b.writeLock().unlock();
        return;
    L11:
        this.f37680b.readLock().lock();     // Catch: Throwable -> L26
        this.f37680b.writeLock().unlock();
    L23:
        th = move-exception;
        this.f37680b.readLock().unlock();
        throw th;
    L14:
        if (f37679a == false) goto L16;
    L20:
        d(r2, r3, r4, r5, r6, r7);     // Catch: Throwable -> L23
        this.f37680b.readLock().unlock();
        return;
    L16:
        if (this.f != null) goto L20;
        throw new AssertionError();     // Catch: Throwable -> L23
    }

    private boolean b(int r10, String r11, int r12, int r13, int r14, int r15) {
        this.f37680b.readLock().lock();
    L17:
        th = move-exception;
        this.f37680b.readLock().unlock();
        throw th;
    L4:
        if (this.f == null) goto L8;
        d(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L17
    L6:
        this.f37680b.readLock().unlock();
        return true;
    L8:
        C1025a r2 = (C1025a) ZeusTransformUtils.preCheckCast(this.f37681c.get(r11), C1025a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r2 != null) goto L14;
        this.f37680b.readLock().unlock();
        return false;
    L14:
        if (r2.a(r10, r11, r12, r13, r14, r15) == true) goto L6;
        this.f37682d.incrementAndGet();     // Catch: Throwable -> L17
        goto L6
    }

    private void c(int r10, String r11, int r12, int r13, int r14, int r15) {
        boolean r1 = f37679a;
        if (r1 == false) goto L5;
    L9:
        C1025a r2 = (C1025a) ZeusTransformUtils.preCheckCast(this.f37681c.get(r11), C1025a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        C1025a r3 = r2;
    L21:
        if (r3.a(r10, r11, r12, r13, r14, r15) == true) goto L24;
        this.f37682d.incrementAndGet();
        return;
    L24:
        return;
    L12:
        if (this.f37681c.size() < 256) goto L18;
        if (r1 == false) goto L17;
        this.f37682d.incrementAndGet();
        return;
    L17:
        throw new AssertionError("Too many histograms in cache");
    L18:
        C1025a r8 = new C1025a(r10, r11, r13, r14, r15);
        this.f37681c.put(r11, r8);
        r3 = r8;
        goto L21
    L5:
        if (this.f37680b.isWriteLockedByCurrentThread() == true) goto L9;
        throw new AssertionError();
    }

    private void d(int r8, String r9, int r10, int r11, int r12, int r13) {
        boolean r0 = f37679a;
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
    L15:
        if (r0 == false) goto L17;
    L21:
        boolean r1 = true;
        if (r8 != 1) goto L24;
        c r7 = this.f;
        if (r10 != 0) goto L38;
        r1 = false;
    L38:
        r7.a(r9, r1);
        return;
    L24:
        if (r8 != 2) goto L26;
        this.f.a(r9, r10, r11, r12, r13);
        return;
    L26:
        if (r8 != 3) goto L28;
        this.f.b(r9, r10, r11, r12, r13);
        return;
    L28:
        if (r8 != 4) goto L31;
        this.f.a(r9, r10);
        return;
    L31:
        throw new UnsupportedOperationException("Unknown histogram type " + r8);
    L17:
        if (this.f != null) goto L21;
        throw new AssertionError("recordSampleAlreadyLocked called with no delegate to record to");
    L11:
        if (this.f37680b.isWriteLockedByCurrentThread() == false) goto L15;
        throw new AssertionError();
    L5:
        if (this.f37680b.getReadHoldCount() > 0) goto L9;
        throw new AssertionError();
    }

    @Override // com.ttnet.org.chromium.base.a.c
    public void a(String r8, boolean r9) {
        a(1, r8, r9 ? 1 : 0, 0, 0, 0);
    }

    @Override // com.ttnet.org.chromium.base.a.c
    public void a(String r8, int r9, int r10, int r11, int r12) {
        a(2, r8, r9, r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.a.c
    public void b(String r8, int r9, int r10, int r11, int r12) {
        a(3, r8, r9, r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.base.a.c
    public void a(String r8, int r9) {
        a(4, r8, r9, 0, 0, 0);
    }
}
