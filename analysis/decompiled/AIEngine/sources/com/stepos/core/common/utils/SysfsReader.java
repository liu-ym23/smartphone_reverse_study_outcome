package com.stepos.core.common.utils;

import gc.n;
import kotlin.jvm.internal.g;
import l7.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SysfsReader {
    private static final byte ASCII_SPACE = 32;
    public static final SysfsReader INSTANCE = new SysfsReader();
    private static final byte NEWLINE = 10;
    private static final int SCRATCH_BYTES = 256;
    private static final ThreadLocal<byte[]> scratch;

    static {
        ThreadLocal<byte[]> threadLocalWithInitial = ThreadLocal.withInitial(new c(1));
        g.e(threadLocalWithInitial, "withInitial(...)");
        scratch = threadLocalWithInitial;
    }

    private SysfsReader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] scratch$lambda$0() {
        return new byte[256];
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String readFirstLine(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r5 = "path"
            kotlin.jvm.internal.g.f(r6, r5)
            r5 = 0
            java.lang.ThreadLocal<byte[]> r0 = com.stepos.core.common.utils.SysfsReader.scratch     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L2d
            byte[] r0 = (byte[]) r0     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto L11
            goto L47
        L11:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L2d
            int r6 = r1.read(r0)     // Catch: java.lang.Throwable -> L57
            r1.close()     // Catch: java.lang.Throwable -> L2d
            if (r6 > 0) goto L20
            goto L47
        L20:
            r1 = 0
            r2 = r1
        L22:
            if (r2 >= r6) goto L2f
            r3 = r0[r2]     // Catch: java.lang.Throwable -> L2d
            r4 = 10
            if (r3 == r4) goto L2f
            int r2 = r2 + 1
            goto L22
        L2d:
            r6 = move-exception
            goto L5e
        L2f:
            r6 = 32
            if (r1 >= r2) goto L3a
            r3 = r0[r1]     // Catch: java.lang.Throwable -> L2d
            if (r3 > r6) goto L3a
            int r1 = r1 + 1
            goto L2f
        L3a:
            if (r2 <= r1) goto L45
            int r3 = r2 + (-1)
            r3 = r0[r3]     // Catch: java.lang.Throwable -> L2d
            if (r3 > r6) goto L45
            int r2 = r2 + (-1)
            goto L3a
        L45:
            if (r2 > r1) goto L49
        L47:
            r3 = r5
            goto L62
        L49:
            int r2 = r2 - r1
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.US_ASCII     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = "US_ASCII"
            kotlin.jvm.internal.g.e(r6, r3)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L2d
            r3.<init>(r0, r1, r2, r6)     // Catch: java.lang.Throwable -> L2d
            goto L62
        L57:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L59
        L59:
            r0 = move-exception
            mb.y.q(r1, r6)     // Catch: java.lang.Throwable -> L2d
            throw r0     // Catch: java.lang.Throwable -> L2d
        L5e:
            kotlin.Result$Failure r3 = kotlin.c.a(r6)
        L62:
            boolean r6 = r3 instanceof kotlin.Result.Failure
            if (r6 == 0) goto L67
            goto L68
        L67:
            r5 = r3
        L68:
            java.lang.String r5 = (java.lang.String) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.utils.SysfsReader.readFirstLine(java.lang.String):java.lang.String");
    }

    public final Integer readInt(String path) {
        g.f(path, "path");
        String firstLine = readFirstLine(path);
        if (firstLine != null) {
            return n.c0(firstLine);
        }
        return null;
    }

    public final Long readLong(String path) {
        g.f(path, "path");
        String firstLine = readFirstLine(path);
        if (firstLine != null) {
            return n.d0(firstLine);
        }
        return null;
    }
}
