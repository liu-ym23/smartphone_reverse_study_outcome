package com.bytedance.apm.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: TopK.java */
/* JADX INFO: loaded from: classes.dex */
public class y<E extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PriorityQueue<E> f5002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5003b;

    public y(int r3) {
        if (r3 <= 0) goto L7;
        this.f5003b = r3;
        this.f5002a = new PriorityQueue(r3, new AnonymousClass1(this));
        return;
    L7:
        throw new IllegalStateException();
    }

    public void a(E r4) {
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.aiagent.plugin");
        if (this.f5002a.size() >= this.f5003b) goto L6;
        this.f5002a.add((E) r5);
        return;
    L6:
        if (r5.compareTo((Comparable) ZeusTransformUtils.preCheckCast(this.f5002a.peek(), Comparable.class, "com.obric.aiagent.plugin")) <= 0) goto L10;
        this.f5002a.poll();
        this.f5002a.add((E) r5);
        return;
    }

    public List<E> a() {
        ArrayList r0 = new ArrayList(this.f5002a);
        Collections.sort(r0);
        return r0;
    }

    public int b() {
        return this.f5002a.size();
    }

    public void c() {
        this.f5002a.clear();
    }
}
