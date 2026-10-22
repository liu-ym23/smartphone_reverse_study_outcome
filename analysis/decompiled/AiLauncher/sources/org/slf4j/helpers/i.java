package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes5.dex */
public class i implements vc.a {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f37953a = false;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, h> f37954b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<wc.d> f37955c = new LinkedBlockingQueue<>();

    @Override // vc.a
    public synchronized vc.c a(String str) {
        h hVar;
        hVar = this.f37954b.get(str);
        if (hVar == null) {
            hVar = new h(str, this.f37955c, this.f37953a);
            this.f37954b.put(str, hVar);
        }
        return hVar;
    }

    public void b() {
        this.f37954b.clear();
        this.f37955c.clear();
    }

    public LinkedBlockingQueue<wc.d> c() {
        return this.f37955c;
    }

    public List<h> d() {
        return new ArrayList(this.f37954b.values());
    }

    public void e() {
        this.f37953a = true;
    }
}
