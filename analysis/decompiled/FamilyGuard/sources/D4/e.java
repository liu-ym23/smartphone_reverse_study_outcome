package D4;

import C4.E;
import C4.G;
import C4.v;
import C4.w;
import L4.g;
import L4.h;
import L4.p;
import L4.y;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.AccessControlException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1206a;

    /* renamed from: d, reason: collision with root package name */
    public static final G f1209d;

    /* renamed from: e, reason: collision with root package name */
    public static final E f1210e;

    /* renamed from: k, reason: collision with root package name */
    private static final Method f1216k;

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f1217l;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f1207b = new String[0];

    /* renamed from: c, reason: collision with root package name */
    public static final v f1208c = v.g(new String[0]);

    /* renamed from: f, reason: collision with root package name */
    private static final p f1211f = p.o(h.e("efbbbf"), h.e("feff"), h.e("fffe"), h.e("0000ffff"), h.e("ffff0000"));

    /* renamed from: g, reason: collision with root package name */
    private static final Charset f1212g = Charset.forName("UTF-32BE");

    /* renamed from: h, reason: collision with root package name */
    private static final Charset f1213h = Charset.forName("UTF-32LE");

    /* renamed from: i, reason: collision with root package name */
    public static final TimeZone f1214i = TimeZone.getTimeZone("GMT");

    /* renamed from: j, reason: collision with root package name */
    public static final Comparator<String> f1215j = new Comparator() { // from class: D4.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((String) obj).compareTo((String) obj2);
        }
    };

    static {
        byte[] bArr = new byte[0];
        f1206a = bArr;
        Method declaredMethod = null;
        f1209d = G.v(null, bArr);
        f1210e = E.d(null, bArr);
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f1216k = declaredMethod;
        f1217l = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static boolean A(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean B(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static X509TrustManager C() throws NoSuchAlgorithmException, KeyStoreException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e6) {
            throw new AssertionError("No System TLS", e6);
        }
    }

    public static boolean D(w wVar, w wVar2) {
        return wVar.m().equals(wVar2.m()) && wVar.y() == wVar2.y() && wVar.D().equals(wVar2.D());
    }

    public static boolean E(y yVar, int i5, TimeUnit timeUnit) {
        long jNanoTime = System.nanoTime();
        long jC = yVar.b().e() ? yVar.b().c() - jNanoTime : Long.MAX_VALUE;
        yVar.b().d(Math.min(jC, timeUnit.toNanos(i5)) + jNanoTime);
        try {
            L4.e eVar = new L4.e();
            while (yVar.e(eVar, 8192L) != -1) {
                eVar.u();
            }
            if (jC == Long.MAX_VALUE) {
                yVar.b().a();
                return true;
            }
            yVar.b().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                yVar.b().a();
                return false;
            }
            yVar.b().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                yVar.b().a();
            } else {
                yVar.b().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static int F(String str, int i5, int i6) {
        while (i5 < i6) {
            char cCharAt = str.charAt(i5);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int G(String str, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            char cCharAt = str.charAt(i7);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i7 + 1;
            }
        }
        return i5;
    }

    public static ThreadFactory H(final String str, final boolean z5) {
        return new ThreadFactory() { // from class: D4.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return e.a(str, z5, runnable);
            }
        };
    }

    public static List<I4.c> I(v vVar) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < vVar.h(); i5++) {
            arrayList.add(new I4.c(vVar.e(i5), vVar.i(i5)));
        }
        return arrayList;
    }

    public static v J(List<I4.c> list) {
        v.a aVar = new v.a();
        for (I4.c cVar : list) {
            a.f1202a.b(aVar, cVar.f2994a.C(), cVar.f2995b.C());
        }
        return aVar.e();
    }

    public static String K(String str, int i5, int i6) {
        int iF = F(str, i5, i6);
        return str.substring(iF, G(str, iF, i6));
    }

    public static boolean L(String str) {
        return f1217l.matcher(str).matches();
    }

    public static /* synthetic */ Thread a(String str, boolean z5, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z5);
        return thread;
    }

    public static void b(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f1216k;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static Charset c(g gVar, Charset charset) {
        int iJ = gVar.J(f1211f);
        if (iJ == -1) {
            return charset;
        }
        if (iJ == 0) {
            return StandardCharsets.UTF_8;
        }
        if (iJ == 1) {
            return StandardCharsets.UTF_16BE;
        }
        if (iJ == 2) {
            return StandardCharsets.UTF_16LE;
        }
        if (iJ == 3) {
            return f1212g;
        }
        if (iJ == 4) {
            return f1213h;
        }
        throw new AssertionError();
    }

    public static String d(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (j(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressM = (str.startsWith("[") && str.endsWith("]")) ? m(str, 1, str.length() - 1) : m(str, 0, str.length());
        if (inetAddressM == null) {
            return null;
        }
        byte[] address = inetAddressM.getAddress();
        if (address.length == 16) {
            return y(address);
        }
        if (address.length == 4) {
            return inetAddressM.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static int e(String str, long j5, TimeUnit timeUnit) {
        if (j5 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j5);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j5 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static void f(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void g(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception unused) {
            }
        }
    }

    public static void h(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e6) {
                if (!A(e6)) {
                    throw e6;
                }
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] i(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    private static boolean j(String str) {
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int k(char c6) {
        if (c6 >= '0' && c6 <= '9') {
            return c6 - '0';
        }
        if (c6 >= 'a' && c6 <= 'f') {
            return c6 - 'W';
        }
        if (c6 < 'A' || c6 > 'F') {
            return -1;
        }
        return c6 - '7';
    }

    private static boolean l(String str, int i5, int i6, byte[] bArr, int i7) {
        int i8 = i7;
        while (i5 < i6) {
            if (i8 == bArr.length) {
                return false;
            }
            if (i8 != i7) {
                if (str.charAt(i5) != '.') {
                    return false;
                }
                i5++;
            }
            int i9 = i5;
            int i10 = 0;
            while (i9 < i6) {
                char cCharAt = str.charAt(i9);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i10 == 0 && i5 != i9) || (i10 = ((i10 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i9++;
            }
            if (i9 - i5 == 0) {
                return false;
            }
            bArr[i8] = (byte) i10;
            i8++;
            i5 = i9;
        }
        return i8 == i7 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0079, code lost:
    
        if (r4 == 16) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r5 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        r12 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r12, r12);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress m(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            r7 = 0
            if (r13 >= r14) goto L79
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L79
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = l(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L79
        L4a:
            return r7
        L4b:
            r8 = r2
            r13 = r6
        L4d:
            if (r13 >= r14) goto L60
            char r10 = r12.charAt(r13)
            int r10 = k(r10)
            if (r10 != r3) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L60:
            int r10 = r13 - r6
            if (r10 == 0) goto L78
            r11 = 4
            if (r10 <= r11) goto L68
            goto L78
        L68:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7e
            return r7
        L7e:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8a:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r12
        L8f:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: D4.e.m(java.lang.String, int, int):java.net.InetAddress");
    }

    public static int n(String str, int i5, int i6, char c6) {
        while (i5 < i6) {
            if (str.charAt(i5) == c6) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static int o(String str, int i5, int i6, String str2) {
        while (i5 < i6) {
            if (str2.indexOf(str.charAt(i5)) != -1) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static boolean p(y yVar, int i5, TimeUnit timeUnit) {
        try {
            return E(yVar, i5, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static String q(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String r(String str, @Nullable String str2) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (AccessControlException unused) {
        }
        return property != null ? property : str2;
    }

    public static String s(w wVar, boolean z5) {
        String strM;
        if (wVar.m().contains(":")) {
            strM = "[" + wVar.m() + "]";
        } else {
            strM = wVar.m();
        }
        if (!z5 && wVar.y() == w.e(wVar.D())) {
            return strM;
        }
        return strM + ":" + wVar.y();
    }

    public static <T> List<T> t(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    @SafeVarargs
    public static <T> List<T> u(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> v(Map<K, V> map) {
        return map.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int w(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (comparator.compare(strArr[i5], str) == 0) {
                return i5;
            }
        }
        return -1;
    }

    public static int x(String str) {
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i5;
            }
        }
        return -1;
    }

    private static String y(byte[] bArr) {
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < bArr.length) {
            int i9 = i7;
            while (i9 < 16 && bArr[i9] == 0 && bArr[i9 + 1] == 0) {
                i9 += 2;
            }
            int i10 = i9 - i7;
            if (i10 > i8 && i10 >= 4) {
                i5 = i7;
                i8 = i10;
            }
            i7 = i9 + 2;
        }
        L4.e eVar = new L4.e();
        while (i6 < bArr.length) {
            if (i6 == i5) {
                eVar.writeByte(58);
                i6 += i8;
                if (i6 == 16) {
                    eVar.writeByte(58);
                }
            } else {
                if (i6 > 0) {
                    eVar.writeByte(58);
                }
                eVar.Q(((bArr[i6] & 255) << 8) | (bArr[i6 + 1] & 255));
                i6 += 2;
            }
        }
        return eVar.O();
    }

    public static String[] z(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i5]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i5++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
