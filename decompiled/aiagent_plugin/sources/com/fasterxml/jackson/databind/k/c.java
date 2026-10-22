package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ClassStack.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c f12964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Class<?> f12965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<k> f12966c;

    public c(Class<?> r2) {
        this(null, r2);
    }

    private c(c r1, Class<?> r2) {
        this.f12964a = r1;
        this.f12965b = r2;
    }

    public c a(Class<?> r2) {
        return new c(this, r2);
    }

    public void a(k r2) {
        if (this.f12966c != null) goto L5;
        this.f12966c = new ArrayList();
    L5:
        this.f12966c.add(r2);
    }

    public void a(com.fasterxml.jackson.databind.k r4) {
        ArrayList<k> r3 = this.f12966c;
        if (r3 == null) goto L8;
        Iterator<k> r5 = r3.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ((k) ZeusTransformUtils.preCheckCast(r5.next(), k.class, "com.obric.aiagent.plugin")).c(r4);
        goto L6
    L10:
        return;
    }

    public c b(Class<?> r2) {
        if (this.f12965b != r2) goto L5;
        return this;
    L5:
        c this = this.f12964a;
        if (this == null) goto L10;
        if (this.f12965b != r2) goto L5;
        return this;
    L10:
        return null;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append("[ClassStack (self-refs: ");
        ArrayList<k> r2 = this.f12966c;
        if (r2 != null) goto L5;
        String r3 = "0";
    L6:
        r1.append(r3).append(')');
    L7:
        if (this == null) goto L9;
        r0.append(' ').append(this.f12965b.getName());
        c this = this.f12964a;
        goto L7
    L9:
        r0.append(']');
        return r0.toString();
    L5:
        r3 = String.valueOf(r2.size());
        goto L6
    }
}
