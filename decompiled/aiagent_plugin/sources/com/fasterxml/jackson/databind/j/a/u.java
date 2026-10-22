package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.ac;

/* JADX INFO: compiled from: WritableObjectId.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectIdGenerator<?> f12851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f12853c;

    public u(ObjectIdGenerator<?> r2) {
        this.f12853c = false;
        this.f12851a = r2;
    }

    public boolean a(com.fasterxml.jackson.a.h r2, ac r3, i r4) {
        if (this.f12852b != null) goto L5;
        return false;
    L5:
        if (this.f12853c == true) goto L9;
        if (r4.f12817e == true) goto L9;
        return false;
    L9:
        if (r2.d() == false) goto L11;
        r2.f(String.valueOf(this.f12852b));
        return true;
    L11:
        r4.f12816d.a(this.f12852b, r2, r3);
        return true;
    }

    public Object a(Object r2) {
        if (this.f12852b != null) goto L6;
        this.f12852b = this.f12851a.generateId(r2);
    L6:
        return this.f12852b;
    }

    public void b(com.fasterxml.jackson.a.h r2, ac r3, i r4) {
        this.f12853c = true;
        if (r2.d() == false) goto L10;
        Object r1 = this.f12852b;
        if (r1 != null) goto L7;
        String r5 = null;
    L8:
        r2.e(r5);
        return;
    L7:
        r5 = String.valueOf(r1);
        goto L8
    L10:
        com.fasterxml.jackson.a.q r0 = r4.f12814b;
        if (r0 == null) goto L14;
        r2.b(r0);
        r4.f12816d.a(this.f12852b, r2, r3);
        return;
    }
}
