package com.amap.api.col.s;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f26331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f26332b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f26333c = null;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f26332b = new String[]{"arm64-v8a", "x86_64"};
        f26333c = new String[]{"arm", "x86"};
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= 80) goto L6;
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101 = r101 + 1;
        goto L4
    L6:
        f26331a = r100.toString();
    }

    public static br a() throws bh {
        return new br.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static br b() throws bh {
        return new br.a("co", "1.0.0", "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static byte[] c() {
        String[] r100 = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r101 = new byte[r100.length];     // Catch: Throwable -> L13
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r103 >= r100.length) goto L7;
        r101[r103] = CastByteProtector.parseByte(r100[r103]);     // Catch: Throwable -> L13
        r103 = r103 + 1;     // Catch: Throwable -> L13
        goto L5
    L7:
        String[] r104 = new StringBuffer(new String(bn.b(new String(r101)))).reverse().toString().split(",");     // Catch: Throwable -> L13
        byte[] r105 = new byte[r104.length];     // Catch: Throwable -> L13
    L8:
        if (r102 >= r104.length) goto L12;
        r105[r102] = CastByteProtector.parseByte(r104[r102]);     // Catch: Throwable -> L13
        r102 = r102 + 1;
        goto L8
    L12:
        return r105;
    L13:
        th = move-exception;
        cd.a(th, "ut", "gIV");
        return new byte[16];
    }

    public static PublicKey d() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream r100 = new ByteArrayInputStream(bn.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));     // Catch: Throwable -> L19
        CertificateFactory r101 = CertificateFactory.getInstance(c("IWC41MDk"));     // Catch: Throwable -> L26
        KeyFactory r102 = KeyFactory.getInstance(c("EUlNB"));     // Catch: Throwable -> L26
        Certificate r103 = r101.generateCertificate(r100);     // Catch: Throwable -> L26
        if (r103 == null) goto L29;
        if (r102 == null) goto L29;
        PublicKey r104 = r102.generatePublic(new X509EncodedKeySpec(r103.getPublicKey().getEncoded()));     // Catch: Throwable -> L26
        r100.close();     // Catch: Throwable -> L11
    L13:
        return r104;
    L11:
        th = move-exception;
        th.printStackTrace();
    L29:
        r100.close();     // Catch: Throwable -> L16
    L18:
        return null;
    L16:
        th = move-exception;
        th.printStackTrace();
    L20:
        if (r100 != null) goto L27;
    L25:
        return null;
    L27:
        r100.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
    L19:
        r100 = null;
        goto L20
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_amap_api_col_s_bs_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static String a(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L38;
    L8:
        String r101 = "";
    L10:
        if (Build.VERSION.SDK_INT < 28) goto L33;
        String[] r102 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);     // Catch: Throwable -> L30
        if (r102 == null) goto L17;
        if (r102.length <= 0) goto L17;
        r101 = r102[0];     // Catch: Throwable -> L30
    L17:
        if (TextUtils.isEmpty(r101) == true) goto L33;
        if (Arrays.asList(f26332b).contains(r101) == false) goto L33;
        String r103 = r100.getApplicationInfo().nativeLibraryDir;     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r103) == true) goto L33;
        String r104 = r103.substring(r103.lastIndexOf(File.separator) + 1);     // Catch: Throwable -> L30
        if (Arrays.asList(f26333c).contains(r104) == false) goto L33;
        String[] r105 = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null);     // Catch: Throwable -> L30
        if (r105 == null) goto L33;
        if (r105.length <= 0) goto L33;
        r101 = r105[0];     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        cd.a(th, "ut", "gct_p");
    L33:
        if (TextUtils.isEmpty(r101) == true) goto L35;
        return r101;
    L35:
        return Build.CPU_ABI;
    L38:
        ApplicationInfo r106 = r100.getApplicationInfo();     // Catch: Throwable -> L6
        Field r107 = INVOKESTATIC_com_amap_api_col_s_bs_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(ApplicationInfo.class.getName()).getDeclaredField(MiraMonitor.KEY_PRIMARY_CPU_ABI);     // Catch: Throwable -> L6
        r107.setAccessible(true);     // Catch: Throwable -> L6
        r101 = (String) r107.get(r106);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        cd.a(th, "ut", "gct");
        goto L8
    }

    public static String b(Map<String, String> r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r102.next();
        if (r101.length() <= 0) goto L8;
        r101.append("&");
    L8:
        r101.append(r103.getKey());
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r101.append(r103.getValue());
        goto L4
    L10:
        return e(r101.toString());
    }

    public static byte[] c(byte[] r100) {
        byte[] r101 = null;
        if (r100 != null) goto L63;
    L45:
        return null;
    L63:
        if (r100.length == 0) goto L45;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L22
        ZipOutputStream r103 = new ZipOutputStream(r102);     // Catch: Throwable -> L20
        r103.putNextEntry(new ZipEntry("log"));     // Catch: Throwable -> L18
        r103.write(r100);     // Catch: Throwable -> L18
        r103.closeEntry();     // Catch: Throwable -> L18
        r103.finish();     // Catch: Throwable -> L18
        r101 = r102.toByteArray();     // Catch: Throwable -> L18
        r103.close();     // Catch: Throwable -> L12
    L14:
        r102.close();     // Catch: Throwable -> L16
    L62:
    L32:
        return r101;
    L12:
        th = move-exception;
        cd.a(th, "ut", "zp1");
    L18:
        th = th;
    L46:
        cd.a(th, "ut", "zp");     // Catch: Throwable -> L33
        if (r103 != null) goto L56;
    L30:
        if (r102 == null) goto L32;
        r102.close();     // Catch: Throwable -> L16
        goto L62
    L56:
        r103.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        cd.a(th, "ut", "zp1");
    L33:
        th = move-exception;
        if (r103 != null) goto L58;
    L39:
        if (r102 == null) goto L65;
        r102.close();     // Catch: Throwable -> L42
        throw th;
    L42:
        th = move-exception;
        cd.a(th, "ut", "zp2");
        throw th;
    L65:
        throw th;
    L58:
        r103.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        cd.a(th, "ut", "zp1");
    L20:
        th = th;
        r103 = null;
    L22:
        th = th;
        r102 = null;
        r103 = null;
    L16:
        th = move-exception;
        cd.a(th, "ut", "zp2");
        goto L32
    }

    public static byte[] d(String r100) {
        if ((r100.length() % 2) == 0) goto L5;
        r100 = "0".concat(r100);
    L5:
        int r101 = r100.length() / 2;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L8;
        int r104 = r103 * 2;
        r102[r103] = (byte) CastIntegerProtector.parseInt(r100.substring(r104, r104 + 2), 16);
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    }

    private static String e(String r100) {
    L14:
        th = move-exception;
        cd.a(th, "ut", "sPa");
    L16:
        return r100;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        String[] r101 = r100.split("&");     // Catch: Throwable -> L14
        Arrays.sort(r101);     // Catch: Throwable -> L14
        StringBuffer r102 = new StringBuffer();     // Catch: Throwable -> L14
        int r103 = r101.length;     // Catch: Throwable -> L14
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        r102.append(r101[r104]);     // Catch: Throwable -> L14
        r102.append("&");     // Catch: Throwable -> L14
        r104 = r104 + 1;     // Catch: Throwable -> L14
        goto L8
    L10:
        String r105 = r102.toString();     // Catch: Throwable -> L14
        if (r105.length() <= 1) goto L16;
        return (String) r105.subSequence(0, r105.length() - 1);
    }

    private static void f(String r100) {
    L2:
        int r101 = 0;
        if (r100.length() < 78) goto L6;
        r100.substring(0, 78);
        r100 = r100.substring(78);
    L6:
        if (r101 >= (78 - r100.length())) goto L8;
        r101 = r101 + 1;
        goto L6
    }

    public static String g(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 != null) goto L6;
        return null;
    L6:
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() != 1) goto L12;
        r103 = "0".concat(r103);
    L12:
        r101.append(r103);
        r102 = r102 + 1;
        goto L8
    L14:
        return r101.toString();
    }

    private static byte[] h(byte[] r100) throws IOException, Throwable {
        GZIPOutputStream r101 = null;
        if (r100 != null) goto L42;
        return null;
    L42:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        GZIPOutputStream r103 = new GZIPOutputStream(r102);     // Catch: Throwable -> L17
        r103.write(r100);     // Catch: Throwable -> L15
        r103.finish();     // Catch: Throwable -> L15
        byte[] r104 = r102.toByteArray();     // Catch: Throwable -> L15
        r103.close();     // Catch: Throwable -> L13
        r102.close();     // Catch: Throwable -> L11
        return r104;
    L11:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        throw th;
    L15:
        th = th;
        r101 = r103;
    L46:
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r101 != null) goto L36;
    L28:
        if (r102 != null) goto L44;
    L33:
        throw th;
    L44:
        r102.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    L36:
        r101.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L17:
        th = th;
    L19:
        th = th;
        r102 = null;
        goto L46
    }

    public static String a(Throwable r100) {
        StringWriter r101 = new StringWriter();     // Catch: Throwable -> L22
        PrintWriter r102 = new PrintWriter(r101);     // Catch: Throwable -> L20
        r100.printStackTrace(r102);     // Catch: Throwable -> L18
        Throwable r103 = r100.getCause();     // Catch: Throwable -> L18
    L6:
        if (r103 == null) goto L8;
        r103.printStackTrace(r102);     // Catch: Throwable -> L18
        r103 = r103.getCause();     // Catch: Throwable -> L18
        goto L6
    L8:
        String r104 = r101.toString();     // Catch: Throwable -> L18
        r101.close();     // Catch: Throwable -> L11
    L66:
        r102.close();     // Catch: Throwable -> L15
    L17:
        return r104;
    L15:
        th = move-exception;
        th.printStackTrace();
    L11:
        th = move-exception;
        th.printStackTrace();
    L18:
        th = th;
    L48:
        th.printStackTrace();     // Catch: Throwable -> L36
        if (r101 != null) goto L54;
    L30:
        if (r102 != null) goto L64;
    L35:
        return null;
    L64:
        r102.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();
        goto L35
    L54:
        r101.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.printStackTrace();
    L36:
        th = move-exception;
        if (r101 != null) goto L62;
    L42:
        if (r102 == null) goto L69;
        r102.close();     // Catch: Throwable -> L45
        throw th;
    L45:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L69:
        throw th;
    L62:
        r101.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = th;
        r102 = null;
    L22:
        th = th;
        r101 = null;
        r102 = null;
        goto L48
    }

    public static String b(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = bn.c(a(r100));
        return ((char) ((r101.length() % 26) + 65)) + r101;
    L8:
        th = move-exception;
        cd.a(th, "ut", "tsfb64");
        return "";
    }

    public static String c(String r100) {
        if (r100.length() >= 2) goto L7;
        return "";
    L7:
        return bn.a(r100.substring(1));
    }

    public static byte[] d(byte[] r100) {
        return h(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return new byte[0];
    }

    public static String e(byte[] r100) {
        return g(r100);
    L4:
        th = move-exception;
        cd.a(th, "ut", "h2s");
        return null;
    }

    public static String f(byte[] r100) {
        return g(r100);
    L4:
        th = move-exception;
        cd.a(th, "ut", "csb2h");
        return null;
    }

    public static String a(Map<String, String> r100) {
        if (r100.size() != 0) goto L6;
        return null;
    L6:
        StringBuffer r101 = new StringBuffer();
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L16
        boolean r103 = true;
    L8:
        if (r102.hasNext() == false) goto L19;
        Map.Entry<String, String> r104 = r102.next();     // Catch: Throwable -> L16
        if (r103 == true) goto L13;
        r101.append("&");     // Catch: Throwable -> L16
        r101.append(r104.getKey());     // Catch: Throwable -> L16
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L16
        r101.append(r104.getValue());     // Catch: Throwable -> L16
        goto L8
    L13:
        r101.append(r104.getKey());     // Catch: Throwable -> L16
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L16
        r101.append(r104.getValue());     // Catch: Throwable -> L16
        r103 = false;
    L19:
        return r101.toString();
    L16:
        th = move-exception;
        cd.a(th, "ut", "abP");
        goto L19
    }

    public static byte[] b(byte[] r100) {
        return h(r100);
    L4:
        th = move-exception;
        cd.a(th, "ut", "gZp");
        return new byte[0];
    }

    public static String a(byte[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L14;
        return new String(r100, "UTF-8");
    L9:
        return new String(r100);
    L14:
        return "";
    }

    public static byte[] a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        return r100.getBytes("UTF-8");
    L9:
        return r100.getBytes();
    L5:
        return new byte[0];
    }

    public static byte[] a(int r100) {
        return new byte[]{(byte) (r100 / 256), (byte) (r100 % 256)};
    }

    public static String a(long r100) {
        return a(r100, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static Calendar a(String r100, String r110) {
        SimpleDateFormat r101 = new SimpleDateFormat(r110, Locale.CHINA);     // Catch: ParseException -> L4
        Calendar r111 = Calendar.getInstance();     // Catch: ParseException -> L4
        Calendar r102 = Calendar.getInstance();     // Catch: ParseException -> L4
        r102.setTime(r101.parse(r100));     // Catch: ParseException -> L4
        r111.set(r111.get(1), r111.get(2), r111.get(5), r102.get(11), r102.get(12), r102.get(13));     // Catch: ParseException -> L4
        return r111;
    L4:
        e = move-exception;
        cd.a(e, "ut", "ctt");
        return null;
    }

    public static boolean a(Context r100, String r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.checkCallingOrSelfPermission(r101) == 0) goto L9;
        return false;
    L9:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L17:
        return true;
    L11:
        if (r100.getApplicationInfo().targetSdkVersion < 23) goto L17;
        if (((Integer) r100.getClass().getMethod("checkSelfPermission", new Class[]{String.class}).invoke(r100, new Object[]{r101})).intValue() == 0) goto L17;
        return false;
    L15:
        th = move-exception;
        cd.a(th, "ut", "cpm");
        goto L17
    }

    public static void a(ByteArrayOutputStream r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L15;
        int r102 = r101.length();
        if (r102 <= 255) goto L13;
        r102 = 255;
    L13:
        a(r100, (byte) r102, a(r101));
        return;
    L15:
        r100.write(new byte[]{0});     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        cd.a(e, "ut", "wsf");
    }

    public static String a(long r100, String r101) {
        return new SimpleDateFormat(r101, Locale.CHINA).format(new Date(r100));
    L4:
        th = move-exception;
        cd.a(th, "ut", "ctt");
        return null;
    }

    public static boolean a(JSONObject r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.has(r101) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static void a(ByteArrayOutputStream r100, byte r101, byte[] r102) {
        r100.write(new byte[]{r101});     // Catch: IOException -> L11
        int r103 = r101 & UByte.MAX_VALUE;     // Catch: IOException -> L11
        if (r103 >= 255) goto L8;
        if (r103 <= 0) goto L8;
        r100.write(r102);     // Catch: IOException -> L11
        return;
    L8:
        if (r103 != 255) goto L15;
        r100.write(r102, 0, 255);     // Catch: IOException -> L11
        return;
    L15:
        return;
    L11:
        e = move-exception;
        cd.a(e, "ut", "wFie");
    }

    public static Method a(Class r100, String r101, Class<?>... r102) {
        return r100.getDeclaredMethod(c(r101), r102);
    L4:
        return null;
    }

    public static void a(Context r100, String r101, String r110, JSONObject r111) {
        String r102 = bi.e(r100);
        String r103 = bq.a(r102);
        String r104 = bi.a(r100);
        String r105 = "";
        if (r111.has("info") == false) goto L7;
        String r106 = JSONObjectProtectorUtils.getString(r111, "info");     // Catch: Throwable -> L30
    L9:
        if ("INVALID_USER_SCODE".equals(r106) == false) goto L21;
        if (r111.has("sec_code") == false) goto L13;
        String r107 = JSONObjectProtectorUtils.getString(r111, "sec_code");     // Catch: Throwable -> L30
    L15:
        if (r111.has("sec_code_debug") == false) goto L18;
        r105 = JSONObjectProtectorUtils.getString(r111, "sec_code_debug");     // Catch: Throwable -> L30
    L18:
        if (r103.equals(r107) == true) goto L28;
        r103.equals(r105);     // Catch: Throwable -> L30
        goto L28
    L13:
        r107 = "";
        goto L15
    L21:
        if ("INVALID_USER_KEY".equals(r106) == false) goto L28;
        if (r111.has("key") == false) goto L26;
        r105 = JSONObjectProtectorUtils.getString(r111, "key");     // Catch: Throwable -> L30
    L26:
        if (r105.length() <= 0) goto L28;
        r104.equals(r105);     // Catch: Throwable -> L30
        goto L28
    L7:
        r106 = "";
    L28:
        f("SHA1Package:".concat(String.valueOf(r102)));
        f("key:".concat(String.valueOf(r104)));
        f("csid:".concat(String.valueOf(r101)));
        f("gsid:".concat(String.valueOf(r110)));
        f("json:" + r111.toString());
    }
}
