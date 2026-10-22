package com.bytedance.crash.upload;

import com.bytedance.crash.CrashType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: CrashUploadHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<a> f7781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f7782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkedList<C0177a> f7783c = null;

    /* JADX INFO: renamed from: com.bytedance.crash.upload.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CrashUploadHandler.java */
    public static class C0177a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CrashType f7784a;

        public C0177a(CrashType r1) {
            this.f7784a = r1;
        }
    }

    public void a() {
    }

    public abstract void a(CrashType r1, C0177a r2);

    public a() {
    }

    static {
        f7781a = new ConcurrentLinkedQueue();
        f7782b = false;
        f7783c = new LinkedList();
    }

    public static void b() {
        f7782b = true;
        ConcurrentLinkedQueue<a> r0 = f7781a;
        if (r0.isEmpty() == true) goto L10;
        Iterator<a> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L17;
        ((a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }

    public static void a(CrashType r5) {
        C0177a r0 = new C0177a(r5);
        f7783c.add(r0);
        ConcurrentLinkedQueue<a> r1 = f7781a;
        if (r1.isEmpty() == true) goto L10;
        Iterator<a> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        ((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.aiagent.plugin")).a(r5, r0);     // Catch: Throwable -> L11
        goto L6
    L17:
        return;
    }
}
