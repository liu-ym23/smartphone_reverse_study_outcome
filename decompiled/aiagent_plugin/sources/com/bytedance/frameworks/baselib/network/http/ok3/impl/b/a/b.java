package com.bytedance.frameworks.baselib.network.http.ok3.impl.b.a;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.d;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.e;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.b.l;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.v;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTRedirectDispatchManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f8435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f8436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock f8437c = null;

    static {
        f8437c = new ReentrantReadWriteLock();
    }

    private b() {
    }

    public static b a() {
        if (f8435a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8435a != null) goto L9;
        f8435a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f8435a;
    }

    public v a(v r6, v r7, String r8, m r9) {
        if (r6 != null) goto L4;
    L52:
        return r7;
    L4:
        if (TextUtils.isEmpty(r6.b()) == true) goto L52;
        if (r7 == null) goto L52;
        if (TextUtils.isEmpty(r7.b()) == true) goto L52;
        String r5 = r6.toString();
        ReentrantReadWriteLock r10 = f8437c;     // Catch: Throwable -> L23
        r10.readLock().lock();     // Catch: Throwable -> L23
        a r0 = f8436b;     // Catch: Throwable -> L23
        if (r0 != null) goto L13;
    L21:
        r10.readLock().unlock();
        return r7;
    L13:
        if (r0.b() == false) goto L21;
        c r11 = (c) ZeusTransformUtils.preCheckCast(f8436b.a(r5), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        if (r11 == null) goto L21;
        if (r11.f8438b == false) goto L21;
        ReentrantReadWriteLock.ReadLock r12 = r10.readLock();
    L26:
        r12.unlock();
        v r13 = null;
        e r14 = l.a().a(new com.bytedance.frameworks.baselib.network.http.ok3.impl.b.m(r7.toString(), r8, new ArrayList()));     // Catch: Throwable -> L46
        if (r14 != null) goto L30;
    L32:
        String r15 = null;
    L34:
        if (TextUtils.isEmpty(r15) == false) goto L36;
        return r7;
    L36:
        r13 = v.c(r15);     // Catch: Throwable -> L46
        if (r13 != null) goto L39;
        return r7;
    L39:
        if (r9 == null) goto L48;
        d r1 = new d();     // Catch: Throwable -> L46
        boolean r2 = true;
        r1.f8442d = true;     // Catch: Throwable -> L46
        r1.f8440b = 0;     // Catch: Throwable -> L46
        r1.f8441c = 0;     // Catch: Throwable -> L46
        r1.f8443e = 0;     // Catch: Throwable -> L46
        r1.f = false;     // Catch: Throwable -> L46
        r1.g = r13.toString();     // Catch: Throwable -> L46
        r1.f8439a = "redirect_dispatch_" + r7.b();     // Catch: Throwable -> L46
        if (r15.equals(r7.toString()) == false) goto L44;
        r2 = false;
    L44:
        r9.a(r8, r1, r2);     // Catch: Throwable -> L46
    L48:
        return r13;
    L30:
        if (com.bytedance.frameworks.baselib.network.http.i.l.b(r14.f8444a) == false) goto L32;
        r15 = r14.f8444a;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.printStackTrace();
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L49
        r12 = f8437c.readLock();
    L49:
        th = move-exception;
        f8437c.readLock().unlock();
        throw th;
    }

    public static void a(JSONObject r2) {
        ReentrantReadWriteLock r0 = f8437c;     // Catch: Throwable -> L16
        r0.writeLock().lock();     // Catch: Throwable -> L16
        a r1 = new a();     // Catch: Throwable -> L16
        f8436b = r1;     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r0.writeLock().unlock();
        return;
    L7:
        if (r1.b(r2) == true) goto L9;
        f8436b.a(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<com.bytedance.frameworks.baselib.network.b.a.a, c>> r3 = f8436b.c();     // Catch: Throwable -> L16
        if (r3 != null) goto L12;
    L13:
        f8436b.a(false);     // Catch: Throwable -> L16
    L14:
        r0.writeLock().unlock();
        return;
    L12:
        if (r3.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        f8437c.writeLock().unlock();
        throw th;
    }
}
