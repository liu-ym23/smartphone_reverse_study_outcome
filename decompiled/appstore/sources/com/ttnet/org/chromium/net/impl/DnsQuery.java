package com.ttnet.org.chromium.net.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
public class DnsQuery {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f18707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public lf.f f18708d;

    public DnsQuery(String r10) {
        this.f18706b = 0;
        this.f18705a = r10;
        this.f18708d = new lf.f();
    }

    public void a() {
        this.f18708d.c();
    }

    public List b() {
        if (this.f18706b != 0) goto L20;
        String[] r10 = this.f18707c;
        if (r10 == null) goto L20;
        if (r10.length == 0) goto L20;
        ArrayList r11 = new ArrayList();
        String[] r12 = this.f18707c;
        int r13 = r12.length;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L15;
        byte[] r15 = InetAddress.getByName(r12[r14]).getAddress();
        if (r15 == null) goto L13;
        r11.add(InetAddress.getByAddress(this.f18705a, r15));
    L13:
        r14 = r14 + 1;
        goto L9
    L15:
        if (r11.isEmpty() == true) goto L18;
        return r11;
    L18:
        throw new UnknownHostException(this.f18705a);
    L20:
        throw new UnknownHostException(this.f18705a);
    }

    public void c(Runnable r10) {
        this.f18708d.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a("DnsQuery", "Exception DnsQuery resume ", new Object[]{e});
    }

    public void d(int r10, String[] r11) {
        this.f18706b = r10;
        this.f18707c = r11;
    }

    public void e() {
        this.f18708d.a();
    }
}
