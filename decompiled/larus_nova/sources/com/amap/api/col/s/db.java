package com.amap.api.col.s;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.miui.easygo.constant.EasyGoConstant;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
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
public final class db {
    public static int a(da r110) {
        cp r100 = null;
    L42:
        th = th;
    L56:
        cg.c(th, "leg", "uts");     // Catch: Throwable -> L47
        if (r100 == null) goto L46;
        r100.close();     // Catch: Throwable -> L40
    L63:
    L46:
        return -1;
    L47:
        th = move-exception;
        if (r100 != null) goto L61;
    L53:
        throw th;
    L61:
        r100.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L4:
        if (r110.f26537f.c() == false) goto L37;
        r110.f26537f.a(true);     // Catch: Throwable -> L42
        cp r101 = cp.a(new PolarisFileWrapper(r110.f26532a), r110.f26533b);     // Catch: Throwable -> L42
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L35
        byte[] r103 = a(r101, r110, r102);     // Catch: Throwable -> L35
        if (r103 != null) goto L9;
    L29:
        if (r101 != null) goto L54;
    L34:
        return -1;
    L54:
        r101.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L9:
        if (r103.length == 0) goto L29;
        cf r104 = new cf(r103, r110.f26534c);     // Catch: Throwable -> L35
        JSONObject r105 = new JSONObject(new String(cs.a().b(r104)));     // Catch: Throwable -> L35
        if (r105.has("code") == true) goto L14;
    L28:
        r100 = r101;
        goto L37
    L14:
        if (r105.getInt("code") != 1) goto L28;
        dt r106 = r110.f26537f;     // Catch: Throwable -> L35
        if (r106 == null) goto L19;
        r106.a(r103.length);     // Catch: Throwable -> L35
    L19:
        if (r110.f26537f.b() >= Integer.MAX_VALUE) goto L66;
        a(r101, r102);     // Catch: Throwable -> L35
    L26:
        return r103.length;
    L66:
        r101.c();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        cg.c(th, "ofm", "dlo");     // Catch: Throwable -> L35
    L35:
        th = th;
        r100 = r101;
    L37:
        if (r100 == null) goto L46;
        r100.close();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
        goto L46
    }

    private static boolean a(String r100, String r101) {
        return new PolarisFileWrapper(r100, r101 + ".0").exists();
    L4:
        th = move-exception;
        cg.c(th, "leg", "fet");
        return false;
    }

    private static void a(cp r100, List<String> r101) {
        if (r100 == null) goto L15;
        Iterator<String> r102 = r101.iterator();     // Catch: Throwable -> L9
    L5:
        if (r102.hasNext() == false) goto L7;
        r100.c(r102.next());     // Catch: Throwable -> L9
        goto L5
    L7:
        r100.close();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        cg.c(th, "ofm", "dlo");
        return;
    }

    public static void a(String r100, byte[] r101, da r102) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        OutputStream r103 = null;
    L22:
        th = th;
        cp r104 = null;
    L24:
        if (r103 != null) goto L39;
    L29:
        if (r104 == null) goto L48;
        r104.close();     // Catch: Throwable -> L32
        throw th;
    L32:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L48:
        throw th;
    L39:
        r103.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L4:
        if (a(r102.f26532a, r100) == false) goto L6;
        return;
    L6:
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102.f26532a);     // Catch: Throwable -> L22
        if (r105.exists() == true) goto L9;
        r105.mkdirs();     // Catch: Throwable -> L22
    L9:
        r104 = cp.a(r105, r102.f26533b);     // Catch: Throwable -> L22
        r104.a(r102.f26535d);     // Catch: Throwable -> L20
        byte[] r106 = r102.f26536e.b(r101);     // Catch: Throwable -> L20
        cp.a r107 = r104.b(r100);     // Catch: Throwable -> L20
        r103 = r107.a();     // Catch: Throwable -> L20
        r103.write(r106);     // Catch: Throwable -> L20
        r107.b();     // Catch: Throwable -> L20
        r104.b();     // Catch: Throwable -> L20
        r103.close();     // Catch: Throwable -> L13
    L41:
        r104.close();     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = th;
        goto L24
    }

    private static byte[] a(cp r100, da r101, List<String> r110) {
        File r102 = r100.a();     // Catch: Throwable -> L20
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
        byte[] r109 = dg.a(r100, r108);     // Catch: Throwable -> L20
        r106 = r106 + r109.length;     // Catch: Throwable -> L20
        r110.add(r108);     // Catch: Throwable -> L20
        if (r106 > r101.f26537f.b()) goto L15;
        r101.f26538g.b(r109);     // Catch: Throwable -> L20
    L14:
        r105 = r105 + 1;     // Catch: Throwable -> L20
    L15:
        if (r106 > 0) goto L18;
        return null;
    L18:
        return r101.f26538g.a();
    L23:
        return new byte[0];
    L20:
        th = move-exception;
        cg.c(th, "leg", "gCo");
        goto L23
    }
}
