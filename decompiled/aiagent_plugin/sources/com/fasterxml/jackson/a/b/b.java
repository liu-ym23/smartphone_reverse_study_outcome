package com.fasterxml.jackson.a.b;

import com.fasterxml.jackson.a.h.m;
import com.fasterxml.jackson.a.i;
import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.l;

/* JADX INFO: compiled from: StreamReadException.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected transient k f11983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected m f11984e;

    @Override // com.fasterxml.jackson.a.l, com.fasterxml.jackson.a.e
    public /* synthetic */ Object c() {
        return d();
    }

    public b(k r2, String r3) {
        if (r2 != null) goto L4;
        i r0 = null;
    L5:
        super(r3, r0);
        this.f11983d = r2;
        return;
    L4:
        r0 = r2.e();
        goto L5
    }

    public b(k r2, String r3, Throwable r4) {
        if (r2 != null) goto L4;
        i r0 = null;
    L5:
        super(r3, r0, r4);
        this.f11983d = r2;
        return;
    L4:
        r0 = r2.e();
        goto L5
    }

    public k d() {
        return this.f11983d;
    }

    @Override // com.fasterxml.jackson.a.l, java.lang.Throwable
    public String getMessage() {
        String r0 = super.getMessage();
        if (this.f11984e != null) goto L5;
        return r0;
    L5:
        return r0 + "\nRequest payload : " + this.f11984e.toString();
    }
}
