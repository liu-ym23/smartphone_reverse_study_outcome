package org.c.a.h;

import org.c.a.c.c;

/* JADX INFO: compiled from: ReaderException.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f40466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f40467c;

    public a(String r1, int r2, int r3, String r4) {
        super(r4);
        this.f40465a = r1;
        this.f40466b = r3;
        this.f40467c = r2;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "unacceptable code point '" + new String(Character.toChars(this.f40466b)) + "' (0x" + Integer.toHexString(this.f40466b).toUpperCase() + ") " + getMessage() + "\nin \"" + this.f40465a + "\", position " + this.f40467c;
    }
}
