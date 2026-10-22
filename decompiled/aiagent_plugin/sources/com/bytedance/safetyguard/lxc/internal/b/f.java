package com.bytedance.safetyguard.lxc.internal.b;

import java.util.Arrays;

/* JADX INFO: compiled from: IpAddressClassifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f9741b;

    public f(byte[] r4, int r5) {
        d.h.b.o.e(r4, "networkBytes");
        this.f9740a = r5;
        byte[] r0 = Arrays.copyOf(r4, r4.length);
        d.h.b.o.c(r0, "copyOf(...)");
        this.f9741b = r0;
        boolean r1 = true;
        if (r4.length != 4) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L20;
        int r6 = r4.length * 8;
        if (r5 < 0) goto L14;
        if (r5 > r6) goto L14;
    L15:
        if (r1 == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("CIDR prefix length is out of range".toString());
    L14:
        r1 = false;
        goto L15
    L20:
        throw new IllegalArgumentException("CIDR network must be IPv4 or IPv6".toString());
    L5:
        if (r4.length == 16) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean a(byte[] r6) {
        d.h.b.o.e(r6, "addressBytes");
        if (r6.length == this.f9741b.length) goto L5;
        return false;
    L5:
        int r0 = this.f9740a / 8;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        if (r6[r1] != this.f9741b[r1]) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return false;
    L11:
        int r2 = this.f9740a % 8;
        if (r2 != 0) goto L14;
        return true;
    L14:
        int r3 = (255 << (8 - r2)) & 255;
        if ((r6[r0] & r3) == (this.f9741b[r0] & r3)) goto L17;
        return false;
    L17:
        return true;
    }
}
