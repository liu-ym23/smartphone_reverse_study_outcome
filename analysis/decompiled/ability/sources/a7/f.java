package a7;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stepos.taskrobot.llmapi.stepfun.trace.TraceParams;
import com.volcengine.tos.TosClientException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1651a;
    public static final ObjectMapper b;
    public static HashMap c;
    public static final ThreadLocalRandom d;
    public static final InterfaceC0315b e;
    public static final boolean[] f;
    public static final byte[] g;

    static {
        String str = X6.b.f1505a;
        String str2 = X6.b.b;
        f1651a = B7.a.q(B7.a.w("ve-tos-java-sdk/v2.6.0 (", str, "/", str2, ";"), X6.b.c, ")");
        b = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE);
        c = null;
        d = ThreadLocalRandom.current();
        e = AbstractC0317d.c("com.volcengine.tos");
        f = new boolean[256];
        g = "0123456789ABCDEF".getBytes(StandardCharsets.UTF_8);
        for (byte b5 = 97; b5 <= 122; b5 = (byte) (b5 + 1)) {
            f[b5] = true;
        }
        for (byte b10 = 65; b10 <= 90; b10 = (byte) (b10 + 1)) {
            f[b10] = true;
        }
        for (byte b11 = 48; b11 <= 57; b11 = (byte) (b11 + 1)) {
            f[b11] = true;
        }
        boolean[] zArr = f;
        zArr[45] = true;
        zArr[95] = true;
        zArr[46] = true;
        zArr[126] = true;
    }

    public static long a(int i) {
        if (i == 0) {
            return 1000L;
        }
        double d6 = 1.0d;
        while (d6 < 10.0d && i > 0) {
            d6 *= 1.6d;
            i--;
        }
        if (d6 > 10.0d) {
            d6 = 10.0d;
        }
        double dNextDouble = ((((d.nextDouble(1.0d) * 2.0d) - 1.0d) * 0.2d) + 1.0d) * d6;
        if (dNextDouble < 0.0d) {
            return 0L;
        }
        return (long) (dNextDouble * 1000.0d);
    }

    public static boolean b(String str) {
        if (str != null && str.length() != 0) {
            for (char c2 : str.toCharArray()) {
                if (c2 <= 31 || c2 >= 127) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(int i) {
        if (i == 0) {
            return null;
        }
        return String.valueOf(i);
    }

    public static String d(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        try {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            return !b(strDecode) ? str : (str.contains("+") && strDecode.contains(" ")) ? strDecode.replace(" ", "+") : strDecode;
        } catch (UnsupportedEncodingException | IllegalArgumentException e6) {
            e.a("tos: unsupported http header value in key: {}", "", e6);
            return str;
        }
    }

    public static String e(String str) {
        if (str == null || str.length() == 0 || !b(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("~", "%7E").replace("/", "%2F");
        } catch (UnsupportedEncodingException e6) {
            throw new TosClientException("tos: unsupported http header value in key: ", e6);
        }
    }

    public static HashMap f() {
        HashMap map;
        HashMap map2 = c;
        if (map2 != null) {
            return map2;
        }
        synchronized (f.class) {
            HashMap map3 = new HashMap(3);
            c = map3;
            map3.put("cn-beijing", Arrays.asList("tos-cn-beijing.volces.com"));
            c.put("cn-guangzhou", Arrays.asList("tos-cn-guangzhou.volces.com"));
            c.put(TraceParams.REGION, Arrays.asList(TraceParams.END_POINT));
            map = c;
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(java.lang.String r9, boolean r10) {
        /*
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            byte[] r9 = r9.getBytes(r0)
            int r0 = r9.length
            r1 = 0
            r2 = r1
            r3 = r2
        La:
            boolean[] r4 = a7.f.f
            r5 = 47
            if (r2 >= r0) goto L23
            r6 = r9[r2]
            r7 = r6 & 255(0xff, float:3.57E-43)
            if (r6 != r5) goto L1b
            if (r10 == 0) goto L20
        L18:
            int r3 = r3 + 1
            goto L20
        L1b:
            boolean r4 = r4[r7]
            if (r4 != 0) goto L20
            goto L18
        L20:
            int r2 = r2 + 1
            goto La
        L23:
            int r0 = r9.length
            int r3 = r3 * 2
            int r3 = r3 + r0
            byte[] r0 = new byte[r3]
            r2 = r1
        L2a:
            int r3 = r9.length
            if (r1 >= r3) goto L6c
            r3 = r9[r1]
            r6 = r3 & 255(0xff, float:3.57E-43)
            r7 = 37
            if (r6 != r5) goto L4d
            if (r10 == 0) goto L48
            r0[r2] = r7
            int r3 = r2 + 1
            r6 = 50
            r0[r3] = r6
            int r3 = r2 + 2
            r6 = 70
            r0[r3] = r6
        L45:
            int r2 = r2 + 3
            goto L69
        L48:
            r0[r2] = r3
        L4a:
            int r2 = r2 + 1
            goto L69
        L4d:
            boolean r8 = r4[r6]
            if (r8 != 0) goto L66
            r0[r2] = r7
            int r7 = r2 + 1
            int r6 = r6 >> 4
            byte[] r8 = a7.f.g
            r6 = r8[r6]
            r0[r7] = r6
            int r6 = r2 + 2
            r3 = r3 & 15
            r3 = r8[r3]
            r0[r6] = r3
            goto L45
        L66:
            r0[r2] = r3
            goto L4a
        L69:
            int r1 = r1 + 1
            goto L2a
        L6c:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8
            r9.<init>(r0, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.f.g(java.lang.String, boolean):java.lang.String");
    }

    public static long h(long j5) {
        if (j5 == 0) {
            j5 = 3600;
        }
        if (j5 >= 0) {
            return j5;
        }
        throw new TosClientException("tos: invalid preSignedUrl expires, should be larger than 0.", null);
    }
}
