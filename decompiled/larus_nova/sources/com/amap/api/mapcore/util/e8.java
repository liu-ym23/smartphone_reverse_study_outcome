package com.amap.api.mapcore.util;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class e8 {
    public static int a(d8 r110) {
        o7 r100 = null;
    L47:
        th = move-exception;
        th.printStackTrace();
    L55:
        return -1;
    L49:
        th = th;
    L73:
        t6.a(th, "leg", "uts");     // Catch: Throwable -> L56
        if (r100 == null) goto L55;
        r100.close();     // Catch: Throwable -> L47
    L67:
    L56:
        th = move-exception;
        if (r100 != null) goto L63;
    L62:
        throw th;
    L63:
        r100.close();     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        th.printStackTrace();
        goto L62
    L4:
        if (r110.f27186f.b() == false) goto L44;
        r110.f27186f.a(true);     // Catch: Throwable -> L49
        o7 r101 = o7.a(new PolarisFileWrapper(r110.f27181a), 1, 1, r110.f27182b);     // Catch: Throwable -> L49
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L42
        byte[] r103 = a(r101, r110, r102);     // Catch: Throwable -> L42
        if (r103 != null) goto L9;
    L70:
        r101.close();     // Catch: Throwable -> L39
    L41:
        return -1;
    L39:
        th = move-exception;
        th.printStackTrace();
        goto L41
    L9:
        if (r103.length == 0) goto L70;
        r6 r104 = new r6(r103, r110.f27183c);     // Catch: Throwable -> L42
        JSONObject r105 = new JSONObject(new String(r7.a().a(r104).f28591a));     // Catch: Throwable -> L42
        if (r105.has("code") == true) goto L14;
    L36:
        r100 = r101;
        goto L44
    L14:
        if (r105.getInt("code") != 1) goto L36;
        v8 r106 = r110.f27186f;     // Catch: Throwable -> L42
        if (r106 == null) goto L20;
        r106.a(r103.length);     // Catch: Throwable -> L42
    L20:
        if (r110.f27186f.a() >= Integer.MAX_VALUE) goto L75;
        Iterator r111 = r102.iterator();     // Catch: Throwable -> L27
    L23:
        if (r111.hasNext() == false) goto L25;
        r101.d((String) r111.next());     // Catch: Throwable -> L27
        goto L23
    L25:
        r101.close();     // Catch: Throwable -> L27
    L34:
        return r103.length;
    L27:
        th = move-exception;
        t6.a(th, "ofm", "dlo");     // Catch: Throwable -> L42
        goto L34
    L75:
        r101.f();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        t6.a(th, "ofm", "dlo");     // Catch: Throwable -> L42
    L42:
        th = th;
        r100 = r101;
    L44:
        if (r100 == null) goto L55;
        r100.close();     // Catch: Throwable -> L47
        goto L67
    }

    public static d8 a(WeakReference<d8> r100) {
        return (d8) new WeakReference(new d8()).get();
    }

    public static byte[] a(o7 r100, String r101) {
        byte[] r102 = new byte[0];
        InputStream r103 = null;
        o7.e r104 = r100.c(r101);     // Catch: Throwable -> L35
        if (r104 != null) goto L79;
        if (r104 != null) goto L65;
    L34:
        return r102;
    L65:
        r104.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L79:
        InputStream r105 = r104.a(0);     // Catch: Throwable -> L27
        if (r105 != null) goto L17;
        if (r105 == null) goto L81;
        r105.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
    L81:
        r104.close();     // Catch: Throwable -> L14
    L16:
        return r102;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L17:
        r102 = new byte[r105.available()];     // Catch: Throwable -> L27
        r105.read(r102);     // Catch: Throwable -> L27
        r105.close();     // Catch: Throwable -> L20
    L71:
        r104.close();     // Catch: Throwable -> L24
    L26:
        return r102;
    L24:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = th;
    L69:
        t6.a(th, "sui", "rdS");     // Catch: Throwable -> L49
        if (0 != 0) goto L75;
    L43:
        if (r104 != null) goto L63;
    L48:
        return r102;
    L63:
        r104.close();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.printStackTrace();
        goto L48
    L75:
        r103.close();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        th.printStackTrace();
    L49:
        th = move-exception;
        if (0 != 0) goto L83;
    L55:
        if (r104 == null) goto L85;
        r104.close();     // Catch: Throwable -> L58
        throw th;
    L58:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L85:
        throw th;
    L83:
        r103.close();     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        th.printStackTrace();
    L35:
        th = th;
        r104 = null;
        goto L69
    }

    public static String a(Context r100, w5 r101) {
        StringBuilder r102 = new StringBuilder();
        o5.d r103 = o5.f27736d;     // Catch: Throwable -> L5
        r102.append("\"sim\":\"");     // Catch: Throwable -> L5
        r102.append("");     // Catch: Throwable -> L5
        r102.append("\",\"sdkversion\":\"");     // Catch: Throwable -> L5
        r102.append(r101.b());     // Catch: Throwable -> L5
        r102.append("\",\"product\":\"");     // Catch: Throwable -> L5
        r102.append(r101.d());     // Catch: Throwable -> L5
        r102.append("\",\"ed\":\"");     // Catch: Throwable -> L5
        r102.append(r101.a());     // Catch: Throwable -> L5
        r102.append("\",\"nt\":\"");     // Catch: Throwable -> L5
        r102.append(o5.k(r100));     // Catch: Throwable -> L5
        r102.append("\",\"np\":\"");     // Catch: Throwable -> L5
        r102.append(o5.l(r100));     // Catch: Throwable -> L5
        r102.append("\",\"mnc\":\"");     // Catch: Throwable -> L5
        r102.append("");     // Catch: Throwable -> L5
        r102.append("\",\"ant\":\"");     // Catch: Throwable -> L5
        r102.append(o5.j(r100));     // Catch: Throwable -> L5
        r102.append("\"");     // Catch: Throwable -> L5
    L8:
        return r102.toString();
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }

    public static void a(String r100, byte[] r101, d8 r102) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        OutputStream r103 = null;
    L27:
        th = th;
        o7 r104 = null;
    L29:
        if (r103 != null) goto L46;
    L34:
        if (r104 == null) goto L54;
        r104.close();     // Catch: Throwable -> L37
        throw th;
    L37:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L54:
        throw th;
    L46:
        r103.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L52:
        boolean r105 = new PolarisFileWrapper(r102.f27181a, r100 + ".0").exists();     // Catch: Throwable -> L7
    L9:
        if (r105 == false) goto L11;
        return;
    L11:
        PolarisFileWrapper r106 = new PolarisFileWrapper(r102.f27181a);     // Catch: Throwable -> L27
        if (r106.exists() == true) goto L14;
        r106.mkdirs();     // Catch: Throwable -> L27
    L14:
        r104 = o7.a(r106, 1, 1, r102.f27182b);     // Catch: Throwable -> L27
        r104.a(r102.f27184d);     // Catch: Throwable -> L25
        byte[] r107 = r102.f27185e.b(r101);     // Catch: Throwable -> L25
        o7.d r108 = r104.b(r100);     // Catch: Throwable -> L25
        r103 = r108.a(0);     // Catch: Throwable -> L25
        r103.write(r107);     // Catch: Throwable -> L25
        r108.b();     // Catch: Throwable -> L25
        r104.i();     // Catch: Throwable -> L25
        r103.close();     // Catch: Throwable -> L18
    L48:
        r104.close();     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
    L25:
        th = th;
        goto L29
    L7:
        th = move-exception;
        t6.a(th, "leg", "fet");     // Catch: Throwable -> L27
        r105 = false;
        goto L9
    }

    private static byte[] a(o7 r100, d8 r101, List<String> r110) {
        File r102 = r100.k();     // Catch: Throwable -> L20
        if (r102 == null) goto L23;
        if (r102.exists() == false) goto L23;
        String[] r103 = r102.list();     // Catch: Throwable -> L20
        int r104 = r103.length;     // Catch: Throwable -> L20
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r105 >= r104) goto L15;
        String r107 = r103[r105];     // Catch: Throwable -> L20
        if (r107.contains(".0") == false) goto L14;
        String r108 = r107.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0];     // Catch: Throwable -> L20
        byte[] r109 = a(r100, r108);     // Catch: Throwable -> L20
        r106 = r106 + r109.length;     // Catch: Throwable -> L20
        r110.add(r108);     // Catch: Throwable -> L20
        if (r106 > r101.f27186f.a()) goto L15;
        r101.f27187g.a(r109);     // Catch: Throwable -> L20
    L14:
        r105 = r105 + 1;     // Catch: Throwable -> L20
    L15:
        if (r106 > 0) goto L18;
        return null;
    L18:
        return r101.f27187g.a();
    L23:
        return new byte[0];
    L20:
        th = move-exception;
        t6.a(th, "leg", "gCo");
        goto L23
    }

    public static void a(Context r100, d8 r101, String r102, int r103, int r104, String r105) {
        r101.f27181a = q6.a(r100, r102);
        r101.f27184d = r103;
        r101.f27182b = r104;
        r101.f27183c = r105;
    }
}
