package org.b.b;

import java.util.Deque;
import java.util.Map;

/* JADX INFO: compiled from: ThreadLocalMapOfStacks.java */
/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ThreadLocal<Map<String, Deque<String>>> f40298a;

    public m() {
        this.f40298a = new ThreadLocal();
    }
}
