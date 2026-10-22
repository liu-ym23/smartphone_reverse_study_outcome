package com.bytedance.frameworks.core.encrypt;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class RequestEncryptUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IEncryptConfig f7546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7547b = false;

    public interface IEncryptConfig {
        boolean isSsQueriesHeaderOpen();

        boolean isSsQueriesOpen();

        boolean isSsQueriesPlaintextOpen();
    }

    static {
    }

    public static Uri a(String r10, String r11, int r12, String r13, String r14, String r15) {
        StringBuilder r16 = new StringBuilder();
        if (r11 == null) goto L9;
        if (r10 == null) goto L6;
        r16.append(r10);
        r16.append("://");
    L6:
        r16.append(r11);
        if (r12 <= 0) goto L9;
        r16.append(':');
        r16.append(r12);
    L9:
        if (r13 != null) goto L11;
    L12:
        r16.append('/');
    L13:
        if (r13 == null) goto L15;
        r16.append(r13);
    L15:
        if (r14 == null) goto L17;
        r16.append('?');
        r16.append(r14);
    L17:
        if (r15 == null) goto L20;
        r16.append('#');
        r16.append(r15);
    L20:
        return Uri.parse(r16.toString());
    L11:
        if (r13.startsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L13;
        goto L12
    }

    public static String b(String r10, String r11) {
        if (r11 != null) goto L10;
        r11 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r10, r11);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String c(List r10, boolean r11, String r12) {
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L25;
        Pair r15 = (Pair) r14.next();
        Object r16 = r15.first;
        String r17 = (String) r16;
        if (r11 == false) goto L8;
        r17 = b((String) r16, r12);
    L8:
        List r18 = (List) r15.second;
        if (r18 == null) goto L4;
        if (r18.size() <= 0) goto L4;
        Iterator r19 = r18.iterator();
    L14:
        if (r19.hasNext() == false) goto L4;
        String r20 = (String) r19.next();
        if (r11 == false) goto L21;
        if (r20 == null) goto L19;
        r20 = b(r20, r12);
        goto L21
    L19:
        r20 = "";
    L21:
        if (r13.length() <= 0) goto L23;
        r13.append("&");
    L23:
        r13.append(r17);
        r13.append("=");
        r13.append(r20);
        goto L14
    L25:
        return r13.toString();
    }

    public static void d(Uri r10, Map r11) {
        if (r10 == null) goto L27;
        if (r11 != null) goto L28;
        return;
    L28:
        String r12 = r10.getEncodedQuery();     // Catch: Throwable -> L15
        if (r12 == null) goto L33;
        String[] r13 = r12.split("&");     // Catch: Throwable -> L15
        int r14 = r13.length;     // Catch: Throwable -> L15
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L34;
        String r16 = r13[r15];     // Catch: Throwable -> L15
        int r17 = r16.indexOf("=");     // Catch: Throwable -> L15
        if (r17 < 0) goto L18;
        String r18 = URLDecoder.decode(r16.substring(0, r17), "UTF-8");     // Catch: Throwable -> L15
        List r19 = (List) r11.get(r18);     // Catch: Throwable -> L15
        if (r19 != null) goto L17;
        r19 = new LinkedList();     // Catch: Throwable -> L15
    L17:
        r19.add(URLDecoder.decode(r16.substring(r17 + 1), "UTF-8"));     // Catch: Throwable -> L15
        r11.put(r18, r19);     // Catch: Throwable -> L15
    L22:
        r15 = r15 + 1;
        goto L8
    L18:
        String r20 = URLDecoder.decode(r16, "UTF-8");     // Catch: Throwable -> L15
        List r21 = (List) r11.get(r20);     // Catch: Throwable -> L15
        if (r21 != null) goto L21;
        r21 = new LinkedList();     // Catch: Throwable -> L15
    L21:
        r21.add("");     // Catch: Throwable -> L15
        r11.put(r20, r21);     // Catch: Throwable -> L15
        goto L22
    L34:
        return;
    L33:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is null !!!");
    L27:
        throw new IOException("parseUrl url is null !!!");
    }

    public static void e(IEncryptConfig r10) {
        f7546a = r10;
    }

    public static boolean f(Map r10, List r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L5;
        return false;
    L5:
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r10.containsKey(r12) == false) goto L14;
        r11.add(new Pair(r12, r10.get(r12)));
        if (f7546a.isSsQueriesPlaintextOpen() == true) goto L15;
        r10.remove(r12);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    public static String g(String r11, List r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r11;
    L6:
        if (f7546a != null) goto L9;
        return r11;
    L9:
        if (f7547b == false) goto L11;
        return r11;
    L11:
        LinkedHashMap r10 = new LinkedHashMap();
        Uri r13 = Uri.parse(r11);     // Catch: Throwable -> L21
        d(r13, r10);     // Catch: Throwable -> L21
        LinkedList r14 = new LinkedList();     // Catch: Throwable -> L21
        f(r10, r14, "device_id");     // Catch: Throwable -> L21
        f(r10, r14, "device_type");     // Catch: Throwable -> L21
        f(r10, r14, "device_brand");     // Catch: Throwable -> L21
        f(r10, r14, "uuid");     // Catch: Throwable -> L21
        f(r10, r14, "openudid");     // Catch: Throwable -> L21
        String r15 = c(r14, false, "UTF-8");     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r15) == false) goto L15;
        return r11;
    L15:
        byte[] r16 = r15.getBytes();     // Catch: Throwable -> L21
        byte[] r17 = EncryptorUtil.a(r16, r16.length);     // Catch: Throwable -> L21
        if (r17 != null) goto L18;
        return r11;
    L18:
        String r18 = Base64.encodeToString(r17, 2);     // Catch: Throwable -> L21
        LinkedList r19 = new LinkedList();     // Catch: Throwable -> L21
        if (f7546a.isSsQueriesOpen() == false) goto L24;
        LinkedList r20 = new LinkedList();     // Catch: Throwable -> L21
        r20.add(r18);     // Catch: Throwable -> L21
        r19.add(new Pair("ss_queries", r20));     // Catch: Throwable -> L21
    L24:
        if (f7546a.isSsQueriesHeaderOpen() == false) goto L28;
        if (r12 == null) goto L28;
        r12.add(new Pair("X-SS-QUERIES", b(r18, "UTF-8")));     // Catch: Throwable -> L21
    L28:
        if (r10.isEmpty() == true) goto L36;
        Iterator r110 = r10.entrySet().iterator();     // Catch: Throwable -> L21
    L31:
        if (r110.hasNext() == false) goto L36;
        Map.Entry r21 = (Map.Entry) r110.next();     // Catch: Throwable -> L21
        if (r21 == null) goto L31;
        r19.add(new Pair(r21.getKey(), r21.getValue()));     // Catch: Throwable -> L21
    L36:
        String r22 = c(r19, true, "UTF-8");     // Catch: Throwable -> L21
        return a(r13.getScheme(), r13.getHost(), r13.getPort(), r13.getPath(), r22, r13.getFragment()).toString();
    L21:
        th = move-exception;
        th.printStackTrace();
        return r11;
    }
}
