package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.databind.e.t;
import com.fasterxml.jackson.databind.k;
import com.fasterxml.jackson.databind.m;

/* JADX INFO: compiled from: InvalidDefinitionException.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final k f12548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected transient com.fasterxml.jackson.databind.c f12549e;
    protected transient t f;

    public b(com.fasterxml.jackson.a.k r1, String r2, k r3) {
        super(r1, r2);
        this.f12548d = r3;
        this.f12549e = null;
        this.f = null;
    }

    public b(com.fasterxml.jackson.a.h r1, String r2, k r3) {
        super(r1, r2);
        this.f12548d = r3;
        this.f12549e = null;
        this.f = null;
    }

    public b(com.fasterxml.jackson.a.k r1, String r2, com.fasterxml.jackson.databind.c r3, t r4) {
        super(r1, r2);
        if (r3 != null) goto L5;
        k r5 = null;
    L6:
        this.f12548d = r5;
        this.f12549e = r3;
        this.f = r4;
        return;
    L5:
        r5 = r3.getType();
        goto L6
    }

    public b(com.fasterxml.jackson.a.h r1, String r2, com.fasterxml.jackson.databind.c r3, t r4) {
        super(r1, r2);
        if (r3 != null) goto L5;
        k r5 = null;
    L6:
        this.f12548d = r5;
        this.f12549e = r3;
        this.f = r4;
        return;
    L5:
        r5 = r3.getType();
        goto L6
    }

    public static b a(com.fasterxml.jackson.a.k r1, String r2, com.fasterxml.jackson.databind.c r3, t r4) {
        return new b(r1, r2, r3, r4);
    }

    public static b a(com.fasterxml.jackson.a.k r1, String r2, k r3) {
        return new b(r1, r2, r3);
    }

    public static b a(com.fasterxml.jackson.a.h r1, String r2, com.fasterxml.jackson.databind.c r3, t r4) {
        return new b(r1, r2, r3, r4);
    }

    public static b a(com.fasterxml.jackson.a.h r1, String r2, k r3) {
        return new b(r1, r2, r3);
    }

    public k getType() {
        return this.f12548d;
    }
}
