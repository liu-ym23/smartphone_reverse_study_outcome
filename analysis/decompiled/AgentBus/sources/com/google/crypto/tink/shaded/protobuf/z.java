package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2296a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2297b;

    static {
        Charset.forName("US-ASCII");
        f2296a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2297b = bArr;
        ByteBuffer.wrap(bArr);
        androidx.datastore.preferences.protobuf.j.h(bArr, 0, 0, false);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }
}
