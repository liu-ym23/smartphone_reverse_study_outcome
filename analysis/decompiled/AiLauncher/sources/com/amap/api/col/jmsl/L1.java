package com.amap.api.col.jmsl;

import android.content.Context;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.security.MessageDigest;
import java.util.List;

/* loaded from: classes.dex */
public class L1 {
    public static String a(String str) {
        byte[] bArrDigest;
        if (str == null) {
            bArrDigest = null;
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(C1604s2.m("ETUQ1"));
                messageDigest.update(C1604s2.t(str));
                bArrDigest = messageDigest.digest();
            } catch (Throwable th) {
                th.printStackTrace();
                bArrDigest = new byte[0];
            }
        }
        try {
            return C1604s2.d(bArrDigest);
        } catch (Throwable th2) {
            C1611u1.b(th2, "ut", "csb2h");
            return null;
        }
    }

    public static String b(byte[] bArr) {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(C1604s2.m("ETUQ1"));
            messageDigest.update(bArr);
            bArrDigest = messageDigest.digest();
        } catch (Throwable th) {
            C1611u1.b(th, "MD5", "gmb");
            bArrDigest = null;
        }
        try {
            return C1604s2.d(bArrDigest);
        } catch (Throwable th2) {
            C1611u1.b(th2, "ut", "h2s");
            return null;
        }
    }

    public static String c(String str) {
        byte[] bArrDigest;
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(C1604s2.m("ETUQ1"));
            messageDigest.update(C1604s2.t(str));
            bArrDigest = messageDigest.digest();
        } catch (Throwable th) {
            C1611u1.b(th, "MD5", "gmb");
            bArrDigest = new byte[0];
        }
        try {
            return C1604s2.d(bArrDigest);
        } catch (Throwable th2) {
            C1611u1.b(th2, "ut", "h2s");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.Proxy$Type] */
    public static Proxy d(Context context) {
        Proxy proxy;
        String str = "pu";
        try {
            URI uri = new URI("http://restsdk.amap.com");
            if (S0.s(context) == 0) {
                try {
                    List<Proxy> listSelect = ProxySelector.getDefault().select(uri);
                    if (listSelect != null && !listSelect.isEmpty() && (proxy = listSelect.get(0)) != null) {
                        Proxy.Type type = proxy.type();
                        str = Proxy.Type.DIRECT;
                        if (type != str) {
                            return proxy;
                        }
                    }
                } catch (Throwable th) {
                    C1541c2.b(th, "pu", "gpsc");
                }
            }
        } catch (Throwable th2) {
            C1541c2.b(th2, str, "gp");
        }
        return null;
    }
}
