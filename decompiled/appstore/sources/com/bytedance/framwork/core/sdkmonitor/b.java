package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import androidx.appcompat.widget.p;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f7635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList f7636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList f7637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7639e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f7640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f7641b;

        public a(b r10, SDKMonitor r11) {
            this.f7641b = r10;
            this.f7640a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r10 = b.a(this.f7641b);     // Catch: Throwable -> L37
            monitor-enter(r10);     // Catch: Throwable -> L37
            LinkedList r11 = new LinkedList(b.a(this.f7641b));     // Catch: Throwable -> L33
            b.a(this.f7641b).clear();     // Catch: Throwable -> L33
            monitor-exit(r10);     // Catch: Throwable -> L33
            Iterator r12 = r11.iterator();     // Catch: Throwable -> L37
        L8:
            if (r12.hasNext() == false) goto L10;
            j r13 = (j) r12.next();     // Catch: Throwable -> L37
            b.b(this.f7641b, this.f7640a, r13);     // Catch: Throwable -> L37
            goto L8
        L10:
            LinkedList r14 = b.c(this.f7641b);     // Catch: Throwable -> L37
            monitor-enter(r14);     // Catch: Throwable -> L37
            LinkedList r15 = new LinkedList(b.c(this.f7641b));     // Catch: Throwable -> L30
            b.c(this.f7641b).clear();     // Catch: Throwable -> L30
            monitor-exit(r14);     // Catch: Throwable -> L30
            Iterator r16 = r15.iterator();     // Catch: Throwable -> L37
        L16:
            if (r16.hasNext() == false) goto L18;
            p.a(r16.next());     // Catch: Throwable -> L37
            b.d(this.f7641b, this.f7640a, null);     // Catch: Throwable -> L37
            goto L16
        L18:
            LinkedList r17 = b.e(this.f7641b);     // Catch: Throwable -> L37
            monitor-enter(r17);     // Catch: Throwable -> L37
            LinkedList r18 = new LinkedList(b.e(this.f7641b));     // Catch: Throwable -> L27
            b.e(this.f7641b).clear();     // Catch: Throwable -> L27
            monitor-exit(r17);     // Catch: Throwable -> L27
            Iterator r19 = r18.iterator();     // Catch: Throwable -> L37
        L24:
            if (r19.hasNext() == false) goto L48;
            com.bytedance.framwork.core.sdkmonitor.a r20 = (com.bytedance.framwork.core.sdkmonitor.a) r19.next();     // Catch: Throwable -> L37
            b.f(this.f7641b, this.f7640a, r20);     // Catch: Throwable -> L37
            goto L24
        L48:
            return;
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        }
    }

    public b() {
        this.f7635a = new LinkedList();
        this.f7636b = new LinkedList();
        this.f7637c = new LinkedList();
        this.f7638d = 200;
    }

    public static /* synthetic */ LinkedList a(b r10) {
        return r10.f7635a;
    }

    public static /* synthetic */ void b(b r10, SDKMonitor r11, j r12) {
        r10.j(r11, r12);
    }

    public static /* synthetic */ LinkedList c(b r10) {
        return r10.f7636b;
    }

    public static /* synthetic */ void d(b r10, SDKMonitor r11, c r12) {
        r10.i(r11, r12);
    }

    public static /* synthetic */ LinkedList e(b r10) {
        return r10.f7637c;
    }

    public static /* synthetic */ void f(b r10, SDKMonitor r11, com.bytedance.framwork.core.sdkmonitor.a r12) {
        r10.g(r11, r12);
    }

    public final void g(SDKMonitor r11, com.bytedance.framwork.core.sdkmonitor.a r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r12.f7627a) == false) goto L7;
        return;
    L7:
        if (r12.f7627a.equals("api_error") == false) goto L10;
        r11.F(r12.f7628b, r12.f7629c, r12.f7630d, r12.f7631e, r12.f7632f, r12.f7633g, r12.f7634h);
        return;
    L10:
        if (r12.f7627a.equals("api_all") == false) goto L15;
        r11.H(r12.f7628b, r12.f7629c, r12.f7630d, r12.f7631e, r12.f7632f, r12.f7633g, r12.f7634h);
        return;
    }

    public void h(SDKMonitor r10) {
        if (this.f7639e == false) goto L5;
        return;
    L5:
        this.f7639e = true;
        e5.a.e().f(new a(this, r10));
    }

    public final void i(SDKMonitor r10, c r11) {
    }

    public final void j(SDKMonitor r10, j r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.f7654a) == true) goto L9;
        r10.I(r11.f7654a, r11.f7655b, r11.f7656c, r11.f7657d, r11.f7658e, r11.f7659f, r11.f7660g);
        return;
    }

    public void k(com.bytedance.framwork.core.sdkmonitor.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LinkedList r11 = this.f7637c;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f7637c.size() <= this.f7638d) goto L11;
        this.f7637c.poll();     // Catch: Throwable -> L9
    L11:
        this.f7637c.add(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
    }

    public void l(j r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LinkedList r11 = this.f7635a;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f7635a.size() <= this.f7638d) goto L11;
        this.f7635a.poll();     // Catch: Throwable -> L9
    L11:
        this.f7635a.add(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
    }
}
