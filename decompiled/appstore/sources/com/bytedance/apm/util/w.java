package com.bytedance.apm.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PriorityQueue f6676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6677b;

    public class a implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f6678a;

        public a(w r10) {
            this.f6678a = r10;
        }

        public int a(Comparable r10, Comparable r11) {
            return r10.compareTo(r11);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((Comparable) r10, (Comparable) r11);
        }
    }

    public w(int r10) {
        if (r10 <= 0) goto L7;
        this.f6677b = r10;
        this.f6676a = new PriorityQueue(r10, new a(this));
        return;
    L7:
        throw new IllegalStateException();
    }

    public void a(Comparable r10) {
        if (this.f6676a.size() >= this.f6677b) goto L6;
        this.f6676a.add(r10);
        return;
    L6:
        if (r10.compareTo((Comparable) this.f6676a.peek()) <= 0) goto L10;
        this.f6676a.poll();
        this.f6676a.add(r10);
        return;
    }

    public void b() {
        this.f6676a.clear();
    }

    public int c() {
        return this.f6676a.size();
    }

    public List d() {
        ArrayList r10 = new ArrayList(this.f6676a);
        Collections.sort(r10);
        return r10;
    }
}
