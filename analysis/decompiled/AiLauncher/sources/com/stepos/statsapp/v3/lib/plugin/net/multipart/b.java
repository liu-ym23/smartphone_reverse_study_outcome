package com.stepos.statsapp.v3.lib.plugin.net.multipart;

import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public final class b {
    private b() {
    }

    public static String a(byte[] bArr, int i10, int i11, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("charset may not be null or empty");
        }
        try {
            return new String(bArr, i10, i11, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr, i10, i11);
        }
    }

    public static String a(byte[] bArr, String str) {
        if (bArr != null) {
            return a(bArr, 0, bArr.length, str);
        }
        throw new IllegalArgumentException("Parameter may not be null");
    }

    public static byte[] a(String str, String str2) {
        if (str != null) {
            if (str2 != null && str2.length() != 0) {
                try {
                    return str.getBytes(str2);
                } catch (UnsupportedEncodingException unused) {
                    return str.getBytes();
                }
            }
            throw new IllegalArgumentException("charset may not be null or empty");
        }
        throw new IllegalArgumentException("data may not be null");
    }

    public static byte[] a(String str) {
        if (str != null) {
            try {
                return str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                throw new Error("HttpClient requires ASCII support");
            }
        }
        throw new IllegalArgumentException("Parameter may not be null");
    }

    public static String a(byte[] bArr, int i10, int i11) {
        if (bArr != null) {
            try {
                return new String(bArr, i10, i11, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                throw new Error("HttpClient requires ASCII support");
            }
        }
        throw new IllegalArgumentException("Parameter may not be null");
    }

    public static String a(byte[] bArr) {
        if (bArr != null) {
            return a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Parameter may not be null");
    }
}
