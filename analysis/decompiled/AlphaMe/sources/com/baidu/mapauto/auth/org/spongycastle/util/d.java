package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.PrivilegedAction;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7795a = 0;

    public class a implements PrivilegedAction<String> {
        @Override // java.security.PrivilegedAction
        public final String run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        try {
        } catch (Exception unused) {
            try {
                String.format("%n", new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i4 = 0; i4 != length; i4++) {
            cArr[i4] = (char) (bArr[i4] & UByte.MAX_VALUE);
        }
        return new String(cArr);
    }
}
