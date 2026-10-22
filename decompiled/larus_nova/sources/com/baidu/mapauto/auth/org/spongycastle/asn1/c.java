package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class c extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f31821b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f31822c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f31823d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f31824e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f31825a;

    static {
        f31821b = new byte[]{-1};
        f31822c = new byte[]{0};
        f31823d = new c(false);
        f31824e = new c(true);
    }

    public c(boolean r100) {
        if (r100 == false) goto L5;
        byte[] r101 = f31821b;
    L6:
        this.f31825a = r101;
        return;
    L5:
        r101 = f31822c;
        goto L6
    }

    public c(byte[] r100) {
        if (r100.length != 1) goto L13;
        byte r101 = r100[0];
        if (r101 != 0) goto L8;
        this.f31825a = f31822c;
        return;
    L8:
        if ((r101 & UByte.MAX_VALUE) != 255) goto L10;
        this.f31825a = f31821b;
        return;
    L10:
        this.f31825a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(r100);
        return;
    L13:
        throw new IllegalArgumentException("byte value should have 1 byte in it");
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p r100) throws IOException {
        r100.a(this.f31825a, 1);
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r r100) {
        if ((r100 instanceof c) == true) goto L5;
        return false;
    L5:
        if (this.f31825a[0] != ((c) r100).f31825a[0]) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final int e() {
        return 3;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean f() {
        return false;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r, com.baidu.mapauto.auth.org.spongycastle.asn1.l
    public final int hashCode() {
        return this.f31825a[0];
    }

    public final String toString() {
        if (this.f31825a[0] == 0) goto L5;
        return "TRUE";
    L5:
        return "FALSE";
    }
}
