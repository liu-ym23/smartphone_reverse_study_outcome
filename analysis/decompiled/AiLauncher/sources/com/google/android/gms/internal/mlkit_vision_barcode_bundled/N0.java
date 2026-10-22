package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class N0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f20038a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f20039b;

    static {
        Charset.forName("US-ASCII");
        f20038a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f20039b = bArr;
        ByteBuffer.wrap(bArr);
        int i10 = C1727j0.f20088a;
        try {
            new C1719h0(bArr, 0, 0, false, null).c(0);
        } catch (zzer e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static int a(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int b(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }
}
