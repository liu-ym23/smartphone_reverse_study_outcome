package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: com.google.protobuf.s1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0989s1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2940a;
    public static final Charset b;
    public static final byte[] c;

    static {
        Charset.forName("US-ASCII");
        f2940a = Charset.forName("UTF-8");
        b = Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        c = bArr;
        ByteBuffer.wrap(bArr);
        AbstractC0972o.h(bArr, 0, 0, false);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int c(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }
}
