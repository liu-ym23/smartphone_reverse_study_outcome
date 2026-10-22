package org.b.b;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: BasicMarkerFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public class c implements org.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, org.b.e> f40280a;

    public c() {
        this.f40280a = new ConcurrentHashMap();
    }
}
