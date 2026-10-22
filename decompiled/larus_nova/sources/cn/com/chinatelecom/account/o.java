package cn.com.chinatelecom.account;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes28.dex */
public class o {
    private static File a(Context r100) {
        if (r100 == null) goto L17;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir() + "/eAccount/Log/");     // Catch: Exception -> L11
        if (r101.exists() == true) goto L6;
        r101.mkdirs();     // Catch: Exception -> L11
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "ipa_ol.ds");     // Catch: Exception -> L11
        if (r102.exists() == false) goto L9;
        r102.delete();     // Catch: Exception -> L11
    L9:
        r102.createNewFile();     // Catch: Exception -> L11
        return r102;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L17:
        return null;
    }

    public static void a(Context r100, String r101) {
        File r102 = b(r100);
        if (r102 != null) goto L5;
    L7:
        a(a(r100), r101);
        return;
    L5:
        if (r102.exists() == false) goto L7;
        a(r102, r101);
    }

    private static void a(File r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.exists() == false) goto L75;
        PolarisFileWriterWrapper r102 = null;
        BufferedWriter r103 = null;
        BufferedWriter r104 = null;
        r103 = null;
        PolarisFileWriterWrapper r105 = new PolarisFileWriterWrapper(r100, false);     // Catch: Throwable -> L24 Exception -> L26
        BufferedWriter r106 = new BufferedWriter(r105);     // Catch: Throwable -> L20 Exception -> L22
    L69:
    L18:
        e = e;
        r103 = r106;
    L59:
        e.printStackTrace();     // Catch: Throwable -> L39
        if (r103 != null) goto L65;
    L34:
        if (r105 == null) goto L76;
    L57:
        r105.close();     // Catch: Exception -> L37
        return;
    L37:
        e = move-exception;
        e.printStackTrace();
        return;
    L76:
        return;
    L65:
        r103.close();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L39:
        th = move-exception;
        Throwable th10 = th;
        r106 = r103;
        r102 = r105;
    L41:
        r105 = r102;
    L42:
        r104 = r106;
    L43:
        if (r104 != null) goto L55;
    L48:
        if (r105 == null) goto L73;
        r105.close();     // Catch: Exception -> L51
        throw th10;
    L51:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L73:
        throw th10;
    L55:
        r104.close();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L16:
        th10 = th;
        goto L42
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = "";
    L11:
        r106.write(r101);     // Catch: Throwable -> L16 Exception -> L18
        r106.flush();     // Catch: Throwable -> L16 Exception -> L18
        r106.close();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L22:
        e = move-exception;
        e = e;
    L20:
        th = move-exception;
        th10 = th;
        goto L43
    L26:
        e = e;
        r105 = null;
    L24:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L41
    }

    private static File b(Context r100) {
        if (r100 != null) goto L14;
    L13:
        return null;
    L14:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir() + "/eAccount/Log/");     // Catch: Exception -> L11
        if (r101.exists() == true) goto L7;
        return null;
    L7:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "ipa_ol.ds");     // Catch: Exception -> L11
        if (r102.exists() == true) goto L10;
        return null;
    L10:
        return r102;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String c(Context r100) {
        File r101 = b(r100);
        StringBuilder r102 = new StringBuilder();
        if (r101 != null) goto L5;
        return "";
    L5:
        if (r101.exists() == true) goto L85;
        return "";
    L85:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L29
        InputStreamReader r104 = new InputStreamReader(r103);     // Catch: Throwable -> L27
        BufferedReader r105 = new BufferedReader(r104);     // Catch: Throwable -> L25
    L91:
        String r106 = r105.readLine();     // Catch: Throwable -> L23
        if (r106 == null) goto L93;
        r102.append(r106);     // Catch: Throwable -> L23
        goto L91
    L93:
        r105.close();     // Catch: Exception -> L17
    L83:
        r104.close();     // Catch: Exception -> L21
    L81:
        r103.close();     // Catch: Exception -> L46
    L49:
        return r102.toString();
    L46:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
    L17:
        e = move-exception;
        e.printStackTrace();
    L23:
        Throwable th10 = th;
    L75:
        th10.printStackTrace();     // Catch: Throwable -> L50
        if (r105 != null) goto L87;
    L38:
        if (r104 != 0) goto L69;
    L43:
        if (r103 == null) goto L49;
    L69:
        r104.close();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L43
    L87:
        r105.close();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L50:
        th = move-exception;
        if (r105 != null) goto L79;
    L56:
        if (r104 != 0) goto L89;
    L61:
        if (r103 == null) goto L96;
        r103.close();     // Catch: Exception -> L64
        throw th;
    L64:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L96:
        throw th;
    L89:
        r104.close();     // Catch: Exception -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
        goto L61
    L79:
        r105.close();     // Catch: Exception -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = move-exception;
        r105 = null;
        th10 = th;
    L27:
        th = th;
        r105 = null;
    L31:
        th10 = th;
        r104 = r105;
    L29:
        th = th;
        r103 = null;
        r105 = null;
        goto L31
    }
}
