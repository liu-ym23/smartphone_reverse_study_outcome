package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.jmsl.C1569j2;
import com.autonavi.aps.amapapi.config.Const;
import com.caverock.androidsvg.BuildConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.s2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1604s2 {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f16918a = {"arm64-v8a", "x86_64"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f16919b = {"arm", "x86"};

    /* renamed from: c, reason: collision with root package name */
    public static String f16920c;

    static {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 80; i10++) {
            sb2.append("=");
        }
        f16920c = sb2.toString();
    }

    public static String a(long j10, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j10));
        } catch (Throwable th) {
            C1611u1.b(th, "ut", "ctt");
            return null;
        }
    }

    public static String b(Context context) {
        String[] strArr;
        String str = "";
        try {
            String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
            if (strArr2 != null && strArr2.length > 0) {
                str = strArr2[0];
            }
            if (!TextUtils.isEmpty(str) && Arrays.asList(f16918a).contains(str)) {
                String str2 = context.getApplicationInfo().nativeLibraryDir;
                if (!TextUtils.isEmpty(str2)) {
                    if (Arrays.asList(f16919b).contains(str2.substring(str2.lastIndexOf(File.separator) + 1)) && (strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null)) != null && strArr.length > 0) {
                        str = strArr[0];
                    }
                }
            }
        } catch (Throwable th) {
            C1611u1.b(th, "ut", "gct_p");
        }
        return TextUtils.isEmpty(str) ? Build.CPU_ABI : str;
    }

    public static String c(Map<String, String> map) {
        String string;
        if (map != null) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append(Const.STR_MART_ADD);
                }
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(entry.getValue());
            }
            string = sb2.toString();
        } else {
            string = null;
        }
        return r(string);
    }

    public static String d(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static PublicKey e() throws InvalidKeySpecException, NoSuchAlgorithmException, IOException, CertificateException, NullPointerException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C1568j1.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
        } catch (Throwable unused) {
            byteArrayInputStream = null;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(m("IWC41MDk"));
            KeyFactory keyFactory = KeyFactory.getInstance(m("EUlNB"));
            Certificate certificateGenerateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            if (certificateGenerateCertificate != null && keyFactory != null) {
                PublicKey publicKeyGeneratePublic = keyFactory.generatePublic(new X509EncodedKeySpec(certificateGenerateCertificate.getPublicKey().getEncoded()));
                try {
                    byteArrayInputStream.close();
                    return publicKeyGeneratePublic;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return publicKeyGeneratePublic;
                }
            }
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return null;
        } catch (Throwable unused2) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            return null;
        }
    }

    public static void f(Context context, String str, String str2, JSONObject jSONObject) {
        String string;
        String str3;
        String string2;
        String strM;
        string = "";
        String strQ = C1567j0.q(context);
        String strC = L1.c(strQ);
        String strL = C1567j0.l(context);
        try {
            if (jSONObject.has("info")) {
                string2 = jSONObject.getString("info");
                str3 = "请在高德开放平台官网中搜索\"" + string2 + "\"相关内容进行解决";
            } else {
                string2 = "";
                str3 = string2;
            }
            try {
                if ("INVALID_USER_SCODE".equals(string2)) {
                    String string3 = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : "";
                    string = jSONObject.has("sec_code_debug") ? jSONObject.getString("sec_code_debug") : "";
                    if (strC.equals(string3) || strC.equals(string)) {
                        strM = m("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si") + "\"请求内容过长导致业务调用失败\"相关内容进行解决";
                        str3 = strM;
                    }
                } else if ("INVALID_USER_KEY".equals(string2)) {
                    string = jSONObject.has("key") ? jSONObject.getString("key") : "";
                    if (string.length() > 0 && !strL.equals(string)) {
                        strM = m("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                        str3 = strM;
                    }
                }
            } catch (Throwable unused) {
                string = str3;
                str3 = string;
                Log.i("authErrLog", f16920c);
                Log.i("authErrLog", "                                   鉴权错误信息                                  ");
                Log.i("authErrLog", f16920c);
                i("SHA1Package:".concat(String.valueOf(strQ)));
                i("key:".concat(String.valueOf(strL)));
                i("csid:".concat(String.valueOf(str)));
                i("gsid:".concat(String.valueOf(str2)));
                i("json:" + jSONObject.toString());
                Log.i("authErrLog", "                                                                               ");
                Log.i("authErrLog", str3);
                Log.i("authErrLog", f16920c);
            }
        } catch (Throwable unused2) {
        }
        Log.i("authErrLog", f16920c);
        Log.i("authErrLog", "                                   鉴权错误信息                                  ");
        Log.i("authErrLog", f16920c);
        i("SHA1Package:".concat(String.valueOf(strQ)));
        i("key:".concat(String.valueOf(strL)));
        i("csid:".concat(String.valueOf(str)));
        i("gsid:".concat(String.valueOf(str2)));
        i("json:" + jSONObject.toString());
        Log.i("authErrLog", "                                                                               ");
        Log.i("authErrLog", str3);
        Log.i("authErrLog", f16920c);
    }

    public static void g(ByteArrayOutputStream byteArrayOutputStream, byte b10, byte[] bArr) throws IOException {
        try {
            byteArrayOutputStream.write(new byte[]{b10});
            int i10 = b10 & 255;
            if (i10 < 255 && i10 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i10 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e10) {
            C1611u1.b(e10, "ut", "wFie");
        }
    }

    public static void h(ByteArrayOutputStream byteArrayOutputStream, String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
                return;
            } catch (IOException e10) {
                C1611u1.b(e10, "ut", "wsf");
                return;
            }
        }
        int length = str.length();
        if (length > 255) {
            length = 255;
        }
        g(byteArrayOutputStream, (byte) length, t(str));
    }

    public static void i(String str) {
        int i10;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            Log.i("authErrLog", "|" + str.substring(0, 78) + "|");
            str = str.substring(78);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("|");
        sb2.append(str);
        for (i10 = 0; i10 < 78 - str.length(); i10++) {
            sb2.append(" ");
        }
        sb2.append("|");
        Log.i("authErrLog", sb2.toString());
    }

    public static boolean j(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] k(int i10, int i11) {
        return i11 > 4 ? new byte[0] : i11 == 2 ? new byte[]{(byte) (i10 / 256), (byte) (i10 % 256)} : new byte[i11];
    }

    public static C1569j2 l() throws g5 {
        return new C1569j2.a("collection", BuildConfig.VERSION_NAME, "AMap_collection_1.0").c(new String[]{"com.amap.api.collection"}).d();
    }

    public static String m(String str) {
        return str.length() < 2 ? "" : n(C1568j1.b(str.substring(1)));
    }

    public static String n(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] o() {
        try {
            String[] strArrSplit = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(Const.STR_MART_COMMA);
            byte[] bArr = new byte[strArrSplit.length];
            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                bArr[i10] = Byte.parseByte(strArrSplit[i10]);
            }
            String[] strArrSplit2 = new StringBuffer(new String(C1568j1.b(new String(bArr)))).reverse().toString().split(Const.STR_MART_COMMA);
            byte[] bArr2 = new byte[strArrSplit2.length];
            for (int i11 = 0; i11 < strArrSplit2.length; i11++) {
                bArr2[i11] = Byte.parseByte(strArrSplit2[i11]);
            }
            return bArr2;
        } catch (Throwable th) {
            C1611u1.b(th, "ut", "gIV");
            return new byte[16];
        }
    }

    public static byte[] p(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) Integer.parseInt(str.substring(i11, i11 + 2), 16);
        }
        return bArr;
    }

    public static byte[] q(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            try {
                throw th;
            } catch (Throwable th4) {
                if (gZIPOutputStream2 != null) {
                    gZIPOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th4;
            }
        }
    }

    public static String r(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] strArrSplit = str.split(Const.STR_MART_ADD);
            Arrays.sort(strArrSplit);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    stringBuffer.append(str2);
                    stringBuffer.append(Const.STR_MART_ADD);
                }
            }
            String string = stringBuffer.toString();
            return string.length() > 1 ? (String) string.subSequence(0, string.length() - 1) : str;
        } catch (Throwable th) {
            C1611u1.b(th, "ut", "sPa");
            return str;
        }
    }

    public static byte[] s(byte[] bArr) {
        try {
            return q(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] t(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static byte[] u(byte[] bArr) {
        try {
            return q(bArr);
        } catch (Throwable th) {
            C1611u1.b(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String v(String str) {
        if (str == null) {
            return null;
        }
        String strE = C1568j1.e(t(str));
        try {
            return ((char) ((strE.length() % 26) + 65)) + strE;
        } catch (Throwable th) {
            C1611u1.b(th, "ut", "tsfb64");
            return "";
        }
    }
}
