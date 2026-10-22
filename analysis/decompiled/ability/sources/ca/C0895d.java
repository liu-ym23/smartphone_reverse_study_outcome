package ca;

import aa.InterfaceC0314a;
import aa.InterfaceC0315b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: ca.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0895d implements InterfaceC0314a {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f2108a = false;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final LinkedBlockingQueue c = new LinkedBlockingQueue();

    @Override // aa.InterfaceC0314a
    public final synchronized InterfaceC0315b d(String str) {
        C0894c c0894c;
        c0894c = (C0894c) this.b.get(str);
        if (c0894c == null) {
            c0894c = new C0894c(str, this.c, this.f2108a);
            this.b.put(str, c0894c);
        }
        return c0894c;
    }
}
