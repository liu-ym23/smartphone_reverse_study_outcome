package com.bytedance.android.livesdk.player.monitor;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, j> f155840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, j> f155841b;

    public e() {
        this.f155840a = new ConcurrentHashMap();
        this.f155841b = new ConcurrentHashMap();
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        c(r100, "normal");
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        e(r100, "normal");
    }

    public static void a(String r100, ConcurrentHashMap r101) {
        j r102 = (j) r101.get(r100);
        if (r102 == null) goto L6;
        long r103 = SystemClock.elapsedRealtime();
        int r104 = r102.f155903f + 1;
        r102.f155903f = r104;
        long r105 = (r103 - r102.f155899b) + r102.f155901d;
        r102.f155901d = r105;
        r102.f155902e = (long) ((r105 * 1.0f) / r104);
        return;
    }

    public static void f(String r100, ConcurrentHashMap r101) {
        j r102 = (j) r101.get(r100);
        if (r102 != null) goto L5;
        r102 = new j();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f155898a = r100;
        r101.put(r100, r102);
    L5:
        r102.f155899b = SystemClock.elapsedRealtime();
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (Intrinsics.areEqual(r101, "sei") == false) goto L5;
        a(r100, this.f155841b);
        return;
    L5:
        a(r100, this.f155840a);
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (Intrinsics.areEqual(r101, "sei") == false) goto L5;
        f(r100, this.f155841b);
        return;
    L5:
        f(r100, this.f155840a);
    }
}
