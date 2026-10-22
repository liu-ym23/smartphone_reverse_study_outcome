package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsResult;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Dns;

/* JADX INFO: loaded from: classes.dex */
public class c implements Dns {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f7316c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConcurrentMap f7318b;

    public c() {
        this.f7317a = c.class.getSimpleName();
        this.f7318b = new ConcurrentHashMap();
    }

    public static c b() {
        if (f7316c != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f7316c != null) goto L11;
        f7316c = new c();     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f7316c;
    }

    public void a(String r10, e r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f7318b.containsKey(r10) == false) goto L7;
        ((CopyOnWriteArrayList) this.f7318b.get(r10)).add(r11);
        return;
    L7:
        CopyOnWriteArrayList r12 = new CopyOnWriteArrayList();
        r12.add(r11);
        this.f7318b.put(r10, r12);
    }

    public void c(String r10, e r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (this.f7318b.containsKey(r10) == false) goto L11;
        ((CopyOnWriteArrayList) this.f7318b.get(r10)).remove(r11);
        if (((CopyOnWriteArrayList) this.f7318b.get(r10)).isEmpty() == false) goto L12;
        this.f7318b.remove(r10);
        return;
    L12:
        return;
    }

    @Override // okhttp3.Dns
    public List lookup(String r10) {
        Logger.d(this.f7317a, "lookup address list for " + r10);
        DnsResult r11 = com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().n(r10);
        if (r11 == null) goto L28;
        if (r11.ipv4List.isEmpty() == true) goto L7;
    L8:
        ArrayList r12 = new ArrayList();
        Iterator<String> r13 = r11.ipv6List.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        r12.add(InetAddress.getByName(r13.next()));
        goto L10
    L12:
        Iterator<String> r14 = r11.ipv4List.iterator();
    L14:
        if (r14.hasNext() == false) goto L17;
        r12.add(InetAddress.getByName(r14.next()));
        goto L14
    L17:
        if (this.f7318b.containsKey(r10) == false) goto L26;
        Iterator r15 = ((CopyOnWriteArrayList) this.f7318b.get(r10)).iterator();
    L20:
        if (r15.hasNext() == false) goto L26;
        e r16 = (e) r15.next();
        if (r16.U.isEmpty() == false) goto L20;
        if (r16.T != DnsResult.Source.UNKNOWN) goto L20;
        r16.T = r11.source;
        r16.U.addAll(r11.ipv6List);
        r16.U.addAll(r11.ipv4List);
    L26:
        return r12;
    L7:
        if (r11.ipv6List.isEmpty() == false) goto L8;
    L28:
        return Dns.SYSTEM.lookup(r10);
    }
}
