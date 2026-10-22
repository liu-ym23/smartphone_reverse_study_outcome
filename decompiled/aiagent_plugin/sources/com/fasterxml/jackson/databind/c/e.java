package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.databind.k;

/* JADX INFO: compiled from: InvalidTypeIdException.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final k f12552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f12553e;

    public e(com.fasterxml.jackson.a.k r1, String r2, k r3, String r4) {
        super(r1, r2);
        this.f12552d = r3;
        this.f12553e = r4;
    }

    public static e a(com.fasterxml.jackson.a.k r1, String r2, k r3, String r4) {
        return new e(r1, r2, r3, r4);
    }
}
