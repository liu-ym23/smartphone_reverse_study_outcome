package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.databind.k;
import com.fasterxml.jackson.databind.x;

/* JADX INFO: compiled from: InvalidNullException.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final x f12551d;

    public d(com.fasterxml.jackson.databind.h r1, String r2, x r3) {
        super(r1.j(), r2);
        this.f12551d = r3;
    }

    public static d a(com.fasterxml.jackson.databind.h r3, x r4, k r5) {
        d r1 = new d(r3, String.format("Invalid `null` value encountered for property %s", new Object[]{com.fasterxml.jackson.databind.l.h.a(r4, "<UNKNOWN>")}), r4);
        if (r5 == null) goto L5;
        r1.a(r5);
    L5:
        return r1;
    }
}
