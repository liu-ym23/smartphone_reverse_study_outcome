package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import java.util.LinkedList;

/* JADX INFO: compiled from: CacheData.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<i> f8676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<c> f8677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<a> f8678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8680e;

    public b() {
        this.f8676a = new LinkedList();
        this.f8677b = new LinkedList();
        this.f8678c = new LinkedList();
        this.f8679d = 200;
    }

    static /* synthetic */ LinkedList a(b r0) {
        return r0.f8676a;
    }

    static /* synthetic */ void a(b r0, h r1, a r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(b r0, h r1, c r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(b r0, h r1, i r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ LinkedList b(b r0) {
        return r0.f8677b;
    }

    static /* synthetic */ LinkedList c(b r0) {
        return r0.f8678c;
    }

    public void a(i r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<i> r0 = this.f8676a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f8676a.size() <= this.f8679d) goto L9;
        this.f8676a.poll();     // Catch: Throwable -> L12
    L9:
        this.f8676a.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void a(c r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<c> r0 = this.f8677b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f8677b.size() <= this.f8679d) goto L9;
        this.f8677b.poll();     // Catch: Throwable -> L12
    L9:
        this.f8677b.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void a(a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<a> r0 = this.f8678c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f8678c.size() <= this.f8679d) goto L9;
        this.f8678c.poll();     // Catch: Throwable -> L12
    L9:
        this.f8678c.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void a(final h r3) {
        if (this.f8680e == false) goto L5;
        return;
    L5:
        this.f8680e = true;
        com.bytedance.framwork.core.sdklib.thread.a.a().a(new AnonymousClass1(this, r3));
    }

    private void a(h r10, i r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.f8725a) == true) goto L9;
        r10.b(r11.f8725a, r11.f8726b, r11.f8727c, r11.f8728d, r11.f8729e, r11.f, r11.g);
        return;
    }

    private void a(h r4, c r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r4.b(r5.f8683a, r5.f8684b, r5.f8685c);
    }

    private void a(h r11, a r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r12.f8671a) == false) goto L7;
        return;
    L7:
        if (r12.f8671a.equals("api_error") == false) goto L10;
        r11.b(r12.f8672b, r12.f8673c, r12.f8674d, r12.f8675e, r12.f, r12.g, r12.h);
        return;
    L10:
        if (r12.f8671a.equals("api_all") == false) goto L15;
        r11.a(r12.f8672b, r12.f8673c, r12.f8674d, r12.f8675e, r12.f, r12.g, r12.h);
        return;
    }
}
