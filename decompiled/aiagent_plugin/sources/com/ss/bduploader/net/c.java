package com.ss.bduploader.net;

import com.ss.bduploader.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: BDUploadDNSParser.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String TAG = "BDUploadDNSParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f37521a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f37522b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f37523c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f37524d = 60;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Lock f37525e;
    private Map<String, e> f;

    static {
    }

    static /* synthetic */ void a(c r0, int r1, b r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void b(c r0, int r1, b r2) {
        r0.c(r1, r2);
    }

    static /* synthetic */ void c(c r0, int r1, b r2) {
        r0.b(r1, r2);
    }

    private void a(int r8, b r9) {
        if (r9 != null) goto L5;
    L17:
        s.c(TAG, String.format("proc parser msg  fail, info or host is null", new Object[0]));
        return;
    L5:
        if (r9.f37517b == null) goto L17;
        s.c(TAG, String.format("----proc parser msg what:%d host:%s", new Object[]{Integer.valueOf(r8), r9.f37517b}));
        this.f37525e.lock();
        e r3 = (e) ZeusTransformUtils.preCheckCast(this.f.get(r9.f37517b), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r3 == null) goto L11;
        s.c(TAG, String.format("----get processor:%s host:%s", new Object[]{r3, r9.f37517b}));     // Catch: Throwable -> L14
        r3.a(r8, r9);     // Catch: Throwable -> L14
    L12:
        this.f37525e.unlock();
        s.c(TAG, String.format("****end proc parser msg", new Object[0]));
        return;
    L11:
        s.c(TAG, String.format("****get processor null for host:%s", new Object[]{r9.f37517b}));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.f37525e.unlock();
        throw th;
    }

    private void b(int r14, b r15) {
        if (r15 != null) goto L5;
    L24:
        s.c(TAG, String.format("proc suc msg  fail, info or host is null", new Object[0]));
        return;
    L5:
        if (r15.f37517b == null) goto L24;
        s.c(TAG, String.format("----proc suc msg what:%d host:%s", new Object[]{Integer.valueOf(r14), r15.f37517b}));
        this.f37525e.lock();
        e r16 = (e) ZeusTransformUtils.preCheckCast(this.f.get(r15.f37517b), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        s.c(TAG, String.format("get processor:%s host:%s", new Object[]{r16, r15.f37517b}));     // Catch: Throwable -> L21
        if (r16 != null) goto L11;
    L19:
        this.f37525e.unlock();
        s.c(TAG, String.format("****end proc suc msg", new Object[0]));
        return;
    L11:
        if (r16.f37526a == null) goto L19;
        Iterator<d> r3 = r16.f37526a.keySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r3.hasNext() == false) goto L18;
        d r6 = (d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (r6 == null) goto L14;
        s.c(TAG, String.format("listener:%s oncompletion suc", new Object[]{r6}));     // Catch: Throwable -> L21
        r6.a(0, r15.f37517b, r15.f37518c, r15.f37519d, null);     // Catch: Throwable -> L21
        goto L14
    L18:
        r16.f37526a.clear();     // Catch: Throwable -> L21
        this.f.remove(r15.f37517b);     // Catch: Throwable -> L21
        s.c(TAG, String.format("remove all listeners and remove host", new Object[0]));     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.f37525e.unlock();
        throw th;
    }

    private void c(int r17, b r18) {
        if (r18 != null) goto L5;
    L27:
        s.c(TAG, String.format("proc fail msg  fail, info or host is null", new Object[0]));
        return;
    L5:
        if (r18.f37517b == null) goto L27;
        s.c(TAG, String.format("----proc fail msg what:%d host:%s", new Object[]{Integer.valueOf(r17), r18.f37517b}));
        this.f37525e.lock();
        e r6 = (e) ZeusTransformUtils.preCheckCast(this.f.get(r18.f37517b), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        s.c(TAG, String.format("get processor:%s host:%s", new Object[]{r6, r18.f37517b}));     // Catch: Throwable -> L24
        if (r6 != null) goto L11;
    L22:
        this.f37525e.unlock();
        s.c(TAG, String.format("****end proc fail msg what", new Object[0]));
        return;
    L11:
        if (r6.a(r18.f37520e) == false) goto L22;
        r6.b(r17, r18);     // Catch: Throwable -> L24
        if (r6.a() == false) goto L21;
        s.c(TAG, String.format("processor end, notify result", new Object[0]));     // Catch: Throwable -> L24
        Iterator<d> r5 = r6.f37526a.keySet().iterator();     // Catch: Throwable -> L24
    L16:
        if (r5.hasNext() == false) goto L20;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r9 == null) goto L16;
        s.c(TAG, String.format("listener:%s oncompletion fail", new Object[]{r9}));     // Catch: Throwable -> L24
        r9.a(0, r18.f37517b, null, 0, null);     // Catch: Throwable -> L24
        goto L16
    L20:
        r6.f37526a.clear();     // Catch: Throwable -> L24
        this.f.remove(r18.f37517b);     // Catch: Throwable -> L24
        goto L22
    L21:
        s.c(TAG, String.format("processor is not end", new Object[0]));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.f37525e.unlock();
        throw th;
    }
}
