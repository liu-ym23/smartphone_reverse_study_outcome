package com.bytedance.safetyguard.lxc.internal.e.e;

import d.h.b.o;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: LarkOpenApiForwarder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String TAG = "LarkOpenApiForwarder";

    public static final /* synthetic */ byte[] a(InputStream r0, int r1) {
        return b(r0, r1);
    }

    private static final byte[] b(InputStream r5, int r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
        int r3 = 0;
    L3:
        int r4 = r5.read(r1);
        if (r4 < 0) goto L10;
        r3 = r3 + r4;
        if (r3 > r6) goto L9;
        r0.write(r1, 0, r4);
        goto L3
    L9:
        throw new f();
    L10:
        byte[] r7 = r0.toByteArray();
        o.c(r7, "toByteArray(...)");
        return r7;
    }
}
