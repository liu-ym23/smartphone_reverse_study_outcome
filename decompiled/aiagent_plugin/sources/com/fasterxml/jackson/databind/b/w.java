package com.fasterxml.jackson.databind.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: UnresolvedForwardReference.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends com.fasterxml.jackson.databind.m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.fasterxml.jackson.databind.b.a.z f12541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<x> f12542e;

    @Override // java.lang.Throwable
    public /* synthetic */ Throwable fillInStackTrace() {
        return h();
    }

    public w(com.fasterxml.jackson.a.k r1, String r2, com.fasterxml.jackson.a.i r3, com.fasterxml.jackson.databind.b.a.z r4) {
        super(r1, r2, r3);
        this.f12541d = r4;
    }

    public w(com.fasterxml.jackson.a.k r1, String r2) {
        super(r1, r2);
        this.f12542e = new ArrayList();
    }

    public com.fasterxml.jackson.databind.b.a.z f() {
        return this.f12541d;
    }

    public Object g() {
        return this.f12541d.a().key;
    }

    public void a(Object r2, Class<?> r3, com.fasterxml.jackson.a.i r4) {
        this.f12542e.add(new x(r2, r3, r4));
    }

    @Override // com.fasterxml.jackson.databind.m, com.fasterxml.jackson.a.l, java.lang.Throwable
    public String getMessage() {
        String r0 = super.getMessage();
        if (this.f12542e != null) goto L5;
        return r0;
    L5:
        StringBuilder r1 = new StringBuilder(r0);
        Iterator<x> r4 = this.f12542e.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        r1.append(((x) ZeusTransformUtils.preCheckCast(r4.next(), x.class, "com.obric.aiagent.plugin")).toString());
        if (r4.hasNext() == false) goto L7;
        r1.append(", ");
        goto L7
    L11:
        r1.append('.');
        return r1.toString();
    }

    public synchronized w h() {
        monitor-enter(this);
        monitor-exit(this);
        return this;
    }

    public w i() {
        super.fillInStackTrace();
        return this;
    }
}
