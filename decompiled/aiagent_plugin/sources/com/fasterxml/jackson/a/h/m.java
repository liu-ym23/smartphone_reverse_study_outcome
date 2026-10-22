package com.fasterxml.jackson.a.h;

import java.io.Serializable;

/* JADX INFO: compiled from: RequestPayload.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected byte[] f12114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected CharSequence f12115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f12116c;

    public String toString() {
        if (this.f12114a == null) goto L10;
        return new String(this.f12114a, this.f12116c);
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        return this.f12115b.toString();
    }
}
