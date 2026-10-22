package com.bytedance.android.live.liveinteract.voicechat.util;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b> f80847a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f80848b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f80849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f80850d = null;

    public c() {
    }

    static {
        f80850d = new c();
        f80847a = new ArrayList();
        f80848b = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        ArrayList r100 = new ArrayList();
        r100.addAll(f80847a);
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        ((b) r101.next()).c(1);
        goto L4
    L7:
        if (((ArrayList) f80847a).size() != 0) goto L9;
        f80848b.removeCallbacks(this);
        f80849c = false;
    L9:
        f80848b.postDelayed(this, 1000);
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

    public static void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "timerCallback");
        ArrayList r101 = (ArrayList) f80847a;
        if (r101.contains(r100) == false) goto L6;
        r101.remove(r100);
        return;
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "timerCallback");
        List<b> r101 = f80847a;
        if (((ArrayList) r101).contains(r100) == false) goto L5;
        return;
    L5:
        ((ArrayList) r101).add(r100);
        if (f80849c == true) goto L9;
        Handler r102 = f80848b;
        r102.removeCallbacks(this);
        r102.post(this);
        f80849c = true;
        return;
    }
}
