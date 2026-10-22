package com.autonavi.aps.protocol.aps.request.model.fields.context;

import java.util.PriorityQueue;
import java.util.Queue;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Queue<a> f19047a = new PriorityQueue(3);

    public void a(int i10) {
        while (!this.f19047a.isEmpty() && this.f19047a.peek() != null && i10 - this.f19047a.peek().f19034b > 120) {
            this.f19047a.poll();
        }
    }

    public void a(int i10, int i11) {
        a(i11);
        a aVar = new a(i10, i11);
        this.f19047a.remove(aVar);
        this.f19047a.add(aVar);
        while (this.f19047a.size() > 3) {
            this.f19047a.poll();
        }
    }

    public int a() {
        return this.f19047a.size();
    }
}
