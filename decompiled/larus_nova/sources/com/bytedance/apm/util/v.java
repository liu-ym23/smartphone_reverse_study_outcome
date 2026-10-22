package com.bytedance.apm.util;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes14.dex */
public final class v<E extends Comparable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<E> f190691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f190692b;

    public class a implements Comparator<E> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((Comparable) r100).compareTo((Comparable) r101);
        }
    }

    public final List<E> b() {
        ArrayList r100 = new ArrayList(this.f190691a);
        Collections.sort(r100);
        return r100;
    }

    public v(int r100) {
        if (r100 <= 0) goto L7;
        this.f190692b = r100;
        this.f190691a = new PriorityQueue(r100, new a());
        return;
    L7:
        throw new IllegalStateException();
    }

    public final void a(E r100) {
        if (this.f190691a.size() >= this.f190692b) goto L6;
        this.f190691a.add(r100);
        return;
    L6:
        if (r100.compareTo(this.f190691a.peek()) <= 0) goto L10;
        this.f190691a.poll();
        this.f190691a.add(r100);
        return;
    }
}
