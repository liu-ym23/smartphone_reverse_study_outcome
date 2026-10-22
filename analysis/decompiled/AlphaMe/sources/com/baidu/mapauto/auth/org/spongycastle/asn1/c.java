package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class c extends r {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f7701b = {-1};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f7702c = {0};

    /* renamed from: d, reason: collision with root package name */
    public static final c f7703d = new c(false);

    /* renamed from: e, reason: collision with root package name */
    public static final c f7704e = new c(true);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f7705a;

    @Deprecated
    public c(boolean z4) {
        this.f7705a = z4 ? f7701b : f7702c;
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final void a(p pVar) throws IOException {
        pVar.a(this.f7705a, 1);
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
        return this.f7705a[0];
    }

    public final String toString() {
        return this.f7705a[0] != 0 ? "TRUE" : "FALSE";
    }

    public c(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        }
        byte b4 = bArr[0];
        if (b4 == 0) {
            this.f7705a = f7702c;
        } else if ((b4 & UByte.MAX_VALUE) == 255) {
            this.f7705a = f7701b;
        } else {
            this.f7705a = com.baidu.mapauto.auth.org.spongycastle.util.a.a(bArr);
        }
    }

    @Override // com.baidu.mapauto.auth.org.spongycastle.asn1.r
    public final boolean a(r rVar) {
        return (rVar instanceof c) && this.f7705a[0] == ((c) rVar).f7705a[0];
    }
}
