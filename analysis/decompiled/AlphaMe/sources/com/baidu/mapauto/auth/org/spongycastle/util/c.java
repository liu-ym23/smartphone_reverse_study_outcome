package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f7794a = new ThreadLocal();

    public static boolean a() {
        try {
            String str = (String) AccessController.doPrivileged(new b());
            if (str == null) {
                return false;
            }
            int i4 = d.f7795a;
            char[] charArray = str.toCharArray();
            boolean z4 = false;
            for (int i5 = 0; i5 != charArray.length; i5++) {
                char c4 = charArray[i5];
                if ('A' <= c4 && 'Z' >= c4) {
                    charArray[i5] = (char) (c4 + ' ');
                    z4 = true;
                }
            }
            if (z4) {
                str = new String(charArray);
            }
            return "true".equals(str);
        } catch (AccessControlException unused) {
            return false;
        }
    }
}
