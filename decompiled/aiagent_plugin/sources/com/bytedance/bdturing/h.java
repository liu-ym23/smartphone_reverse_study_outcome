package com.bytedance.bdturing;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OnTouchReportListener.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f6555c = 6000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f6556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f6557b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6558d;

    /* JADX INFO: compiled from: OnTouchReportListener.java */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f6560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f6561b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f6562c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f6563d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f6564e;
        int f;
        final /* synthetic */ h g;

        a(h r1) {
            this.g = r1;
        }
    }

    static {
    }

    static /* synthetic */ List a(h r0) {
        return r0.f6556a;
    }

    static /* synthetic */ boolean a(h r0, boolean r1) {
        r0.f6557b = r1;
        return r1;
    }

    public h(int r2) {
        this.f6556a = new ArrayList();
        this.f6557b = false;
        int r0 = f6555c;
        this.f6558d = r0;
        if (r2 <= r0) goto L6;
        this.f6558d = r2;
        return;
    }

    public void a(MotionEvent r6) {
        if (this.f6557b == false) goto L27;
        return;
    L27:
    L20:
        int r1 = 1;
    L21:
        if (r1 != 1) goto L31;
    L22:
        this.f6557b = true;
        a();
        return;
    L31:
        return;
    L15:
        th = th;
        r1 = 1;
    L17:
        if (r1 != 1) goto L19;
        this.f6557b = true;
        a();
    L19:
        throw th;
    L6:
        if (this.f6556a.size() >= this.f6558d) goto L12;
        r1 = r6.getAction();     // Catch: Throwable -> L15 Exception -> L20
        a r2 = new a(this);     // Catch: Throwable -> L10 Exception -> L24
        r2.f6560a = r6.getPressure();     // Catch: Throwable -> L10 Exception -> L24
        r2.f6561b = r6.getTouchMajor();     // Catch: Throwable -> L10 Exception -> L24
        r2.f6562c = r6.getX();     // Catch: Throwable -> L10 Exception -> L24
        r2.f6563d = r6.getY();     // Catch: Throwable -> L10 Exception -> L24
        r2.f6564e = r6.getEventTime();     // Catch: Throwable -> L10 Exception -> L24
        r2.f = r6.getAction();     // Catch: Throwable -> L10 Exception -> L24
        this.f6556a.add(r2);     // Catch: Throwable -> L10 Exception -> L24
        g.g("onTouch", "events : " + this.f6556a.size());     // Catch: Throwable -> L10 Exception -> L24
    L13:
        if (r1 == 1) goto L22;
        return;
    L10:
        th = th;
        goto L17
    L12:
        r1 = 1;
        goto L13
    }

    private void a() {
        VerifyTaskHandler.a().a(new AnonymousClass1(this));     // Catch: Exception -> L4
        return;
    }
}
