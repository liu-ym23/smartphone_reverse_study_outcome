package com.bytedance.android.ec.hybrid.list.util;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f47317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f47318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f47319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<i> f47320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<i> f47321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f47322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f47323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f47324h;

    public static final class a implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f47325a;

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            i r100 = this.f47325a.f47320d.poll();
            if (r100 != null) goto L6;
            e r101 = this.f47325a;
            r101.getClass();
            Looper.myQueue().removeIdleHandler(r101.f47318b);
            r101.f47324h = false;
            return true;
        L6:
            SystemClock.uptimeMillis();
            r100.run();
            this.f47325a.getClass();
            SystemClock.uptimeMillis();
            return true;
        }

        public a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "IdleManager");
            this.f47325a = r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f47326a;

        public final void a() {
            i r100 = this.f47326a.f47321e.poll();
            if (r100 != null) goto L5;
            return;
        L5:
            r100.run();
            if ((!this.f47326a.f47321e.isEmpty()) == false) goto L8;
            this.f47326a.f47317a.post(this);
            return;
        L8:
            this.f47326a.getClass();
            this.f47326a.f47322f = true;
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

        public b(e r100) {
            Intrinsics.checkNotNullParameter(r100, "idleManager");
            this.f47326a = r100;
        }
    }

    public e() {
        this.f47317a = new Handler(Looper.getMainLooper());
        this.f47318b = new a(this);
        this.f47319c = new b(this);
        this.f47320d = new LinkedList();
        this.f47321e = new LinkedList();
    }

    public final void c() {
        Looper.myQueue().removeIdleHandler(this.f47318b);
        Intrinsics.checkNotNullParameter("default_group", "group");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        b("default_group");
    L6:
        this.f47317a.removeCallbacks(this.f47319c);
        this.f47321e.clear();
        return;
    L5:
        this.f47317a.post(new g(this, "default_group"));
        goto L6
    }

    public final void a(i r100) {
        if (this.f47324h == true) goto L6;
        Looper.myQueue().removeIdleHandler(this.f47318b);
        Looper.myQueue().addIdleHandler(this.f47318b);
        this.f47324h = true;
    L6:
        String r101 = r100.f47332a;
        this.f47320d.offer(r100);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Iterator<i> r101 = this.f47320d.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(r101.next().f47333b, r100) == false) goto L4;
        r101.remove();
        goto L4
    }
}
