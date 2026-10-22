package com.bytedanceos.common.toolbox;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static byte[] f10038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static byte[] f10039b;

        static {
            f10038a = Base64.decode(c0.a("YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4"), 0);
            f10039b = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        }

        public static byte[] a(byte[] r10) {
            DESedeKeySpec r11 = new DESedeKeySpec(f10038a);
            SecretKey r12 = SecretKeyFactory.getInstance("desede").generateSecret(r11);
            Cipher r13 = Cipher.getInstance("desede/ECB/PKCS5Padding");
            r13.init(1, r12);
            return r13.doFinal(r10);
        }

        public static byte[] b(byte[] r10) {
            DESedeKeySpec r11 = new DESedeKeySpec(f10038a);
            SecretKey r12 = SecretKeyFactory.getInstance("desede").generateSecret(r11);
            Cipher r13 = Cipher.getInstance("desede/ECB/PKCS5Padding");
            r13.init(2, r12);
            return r13.doFinal(r10);
        }
    }

    public static String a(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r10;
    L6:
        return c0.d(a.b(Base64.decode(c0.a(r10), 0)));
    }

    public static String b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return r10;
    L6:
        return c0.d(Base64.encode(a.a(c0.a(r10)), 0));
    }
}
