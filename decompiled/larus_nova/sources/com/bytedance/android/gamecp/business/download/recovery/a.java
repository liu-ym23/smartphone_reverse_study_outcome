package com.bytedance.android.gamecp.business.download.recovery;

import android.os.SystemClock;
import com.bytedance.android.gamecp.business.download.p;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f52910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f52911c;

    public a(int r100, String r101, p r102) {
        this.f52909a = r100;
        this.f52910b = r101;
        this.f52911c = r102;
    }

    public final void a() {
        Lazy r100 = DisasterRecoveryManager.f52892a;
        ConcurrentHashMap<String, Runnable> r101 = DisasterRecoveryManager.f52894c.get(Integer.valueOf(this.f52909a));
        if (r101 == null) goto L5;
        Runnable r102 = r101.remove(this.f52910b);
    L5:
        ConcurrentHashMap<String, Integer> r103 = DisasterRecoveryManager.f52895d;
        if (r103.get(this.f52910b) != null) goto L9;
        yr.c.a("DisasterRecoveryManager", "fake error");
        return;
    L9:
        r103.remove(this.f52910b);
        b r104 = (b) ((HashMap) DisasterRecoveryManager.f52899h.getValue()).get(Integer.valueOf(this.f52909a));
        if (r104 == null) goto L65;
        p r105 = this.f52911c;
        Intrinsics.checkNotNullParameter(r105, "downloadInfo");
        Iterator<DisasterRecoveryStrategy> r106 = r104.f52912a.iterator();
    L13:
        if (r106.hasNext() == false) goto L41;
        DisasterRecoveryStrategy r107 = r106.next();
        DisasterRecoveryStrategy r108 = r107;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r105, "downloadInfo");
        c r109 = r108.b(r105);
        if (r109.f52913a == false) goto L18;
        yr.c.a("DisasterRecoveryManager", "已经执行过一次了");
    L38:
        boolean r110 = false;
    L39:
        if (r110 == false) goto L13;
    L42:
        DisasterRecoveryStrategy r111 = r107;
        if (r111 == null) goto L66;
        Intrinsics.checkNotNullParameter(r105, "downloadInfo");
        c r112 = r111.b(r105);
        if (r112.f52913a == false) goto L48;
        return;
    L48:
        if (r111.f52907b.a() != 1) goto L51;
        r111.a(r105, r112);
        return;
    L51:
        if (DisasterRecoveryManager.f52897f == false) goto L53;
    L56:
        boolean r113 = true;
    L57:
        if (r113 == false) goto L68;
        r111.a(r105, r112);
        return;
    L68:
        return;
    L53:
        if (DisasterRecoveryManager.f52898g.get() >= 0) goto L56;
        r113 = false;
        goto L57
    L66:
        return;
    L18:
        if (r109.f52915c.c() > 0) goto L21;
        yr.c.a("DisasterRecoveryManager", "count <= 0");
        goto L38
    L21:
        if (r109.f52915c.c() != 1) goto L24;
        yr.c.a("DisasterRecoveryManager", "count == 0");
    L36:
        r110 = true;
        goto L39
    L24:
        if (r109.f52915c.l() > 0) goto L26;
        yr.c.a("DisasterRecoveryManager", "timeWindow <= 0");
        goto L38
    L26:
        int r114 = r109.f52915c.c();
        long r115 = SystemClock.elapsedRealtime();
        if (r109.f52914b.size() >= r114) goto L30;
        r109.f52914b.add(0, Long.valueOf(r115));
    L30:
        if (r109.f52914b.size() >= r114) goto L33;
        yr.c.a("DisasterRecoveryManager", "频次：" + r109.f52914b.size() + ", 不满足");
        goto L38
    L33:
        int r116 = r114 - 1;
        if ((r115 - r109.f52914b.get(r116).longValue()) > (r109.f52915c.l() * 1000)) goto L37;
        yr.c.a("DisasterRecoveryManager", "频次：" + r109.f52914b.size() + ", 满足时间窗口");
        goto L36
    L37:
        yr.c.a("DisasterRecoveryManager", "频次：" + r109.f52914b.size() + ", 不满足时间窗口");
        r109.f52914b.remove(r116);
        r109.f52914b.add(0, Long.valueOf(r115));
        goto L38
    L41:
        r107 = null;
        goto L42
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
