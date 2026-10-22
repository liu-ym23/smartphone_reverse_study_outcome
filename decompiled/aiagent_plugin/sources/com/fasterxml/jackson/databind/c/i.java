package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.databind.k;
import com.fasterxml.jackson.databind.m;

/* JADX INFO: compiled from: ValueInstantiationException.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final k f12556d;

    public i(com.fasterxml.jackson.a.k r1, String r2, k r3, Throwable r4) {
        super(r1, r2, r4);
        this.f12556d = r3;
    }

    public static i a(com.fasterxml.jackson.a.k r1, String r2, k r3, Throwable r4) {
        return new i(r1, r2, r3, r4);
    }

    public k getType() {
        return this.f12556d;
    }
}
