package com.alipay.sdk.m.x;

import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes28.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Stack<e> f25983a;

    public boolean b() {
        return this.f25983a.isEmpty();
    }

    public e c() {
        return this.f25983a.pop();
    }

    public f() {
        this.f25983a = new Stack();
    }

    public void a() {
        if (b() == false) goto L5;
        return;
    L5:
        Iterator<e> r100 = this.f25983a.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        r100.next().a();
        goto L7
    L9:
        this.f25983a.clear();
    }

    public void a(e r100) {
        this.f25983a.push(r100);
    }
}
