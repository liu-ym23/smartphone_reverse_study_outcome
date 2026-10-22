package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f31915a = 0;

    public class a implements PrivilegedAction<String> {
        public a() {
        }

        @Override // java.security.PrivilegedAction
        public final String run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        String r100 = (String) AccessController.doPrivileged(new a());     // Catch: Exception -> L4
        return;
    L10:
        String.format("%n", new Object[0]);     // Catch: Exception -> L7
        return;
    }

    public static String a(byte[] r100) {
        int r101 = r100.length;
        char[] r102 = new char[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L6;
        r102[r103] = (char) (r100[r103] & UByte.MAX_VALUE);
        r103 = r103 + 1;
        goto L3
    L6:
        return new String(r102);
    }
}
