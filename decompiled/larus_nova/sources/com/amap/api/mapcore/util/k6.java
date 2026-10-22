package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class k6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f27500b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f27501c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f27502d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f27503e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f27504f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f27505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f27506h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27507a;

    public final synchronized Map<String, String> a() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f27505g == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        f27505g = true;     // Catch: Throwable -> L12
        HashMap r100 = new HashMap();     // Catch: Throwable -> L12
        r100.put(x5.b("FZW50"), x5.b("FMg"));     // Catch: Throwable -> L12
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L12
        r101.append(x5.b("SY2hhbm5lbD0"));     // Catch: Throwable -> L12
        String r102 = f27501c;     // Catch: Throwable -> L12
        r101.append(r102);     // Catch: Throwable -> L12
        r101.append(x5.b("SJmRpdj0"));     // Catch: Throwable -> L12
        String r103 = f27503e;     // Catch: Throwable -> L12
        r101.append(r103);     // Catch: Throwable -> L12
        StringBuffer r104 = new StringBuffer();     // Catch: Throwable -> L12
        r104.append(r102);     // Catch: Throwable -> L12
        r104.append(r103);     // Catch: Throwable -> L12
        r104.append(x5.b("FQA"));     // Catch: Throwable -> L12
        r104.append(f27502d);     // Catch: Throwable -> L12
        String r105 = t5.c(r104.toString());     // Catch: Throwable -> L12
        r101.append(x5.b("FJnNpZ249"));     // Catch: Throwable -> L12
        r101.append(r105.toUpperCase(Locale.US));     // Catch: Throwable -> L12
        r101.append(x5.b("SJm91dHB1dD1qc29u") + "\u0000");     // Catch: Throwable -> L12
        r100.put(x5.b("FaW4"), h6.a(n7.a(r101.toString().getBytes(), f27500b.getBytes())));     // Catch: Throwable -> L12
        r100.put(x5.b("Sa2V5dA"), f27504f);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r100;
    }

    static {
        f27500b = x5.b("SRFZHZUVZT3BOa0ZiemZRQQ");
        f27501c = x5.b("FbGJzX3Nkaw");
        f27502d = x5.b("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
        f27503e = x5.b("FQU5EU0RLMTA");
        f27504f = x5.b("FMTAw");
        f27505g = false;
    }

    private String b() {
        if (TextUtils.isEmpty(this.f27507a) == false) goto L5;
        String r100 = x5.c(q5.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA"));
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r103 >= r100.length()) goto L10;
        r101.append((char) (r100.charAt(r103) - (r103 % 48)));
        r103 = r103 + 1;
        goto L8
    L10:
        String r104 = r101.toString();
        StringBuffer r105 = new StringBuffer();
    L12:
        if (r102 >= (r104.length() / 2)) goto L14;
        r105.append((char) ((r104.charAt(r102) + r104.charAt((r104.length() - 1) - r102)) / 2));
        r102 = r102 + 1;
        goto L12
    L14:
        String r106 = r105.toString();
        this.f27507a = r106;
        return r106;
    L5:
        return this.f27507a;
    }

    public k6() {
        this.f27507a = "";
    }

    public final String a(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put(x5.b("LdGlk"), r100);     // Catch: Throwable -> L5
        r104.put(x5.b("FZGl1"), r101);     // Catch: Throwable -> L5
        r104.put(x5.b("AZGl1Mg"), r102);     // Catch: Throwable -> L5
        r104.put(x5.b("EZGl1Mw"), r103);     // Catch: Throwable -> L5
    L7:
        String r105 = r104.toString();
        if (TextUtils.isEmpty(r105) == false) goto L10;
        return null;
    L10:
        SecureRandom r106 = new SecureRandom();
        KeyGenerator r107 = KeyGenerator.getInstance(x5.b("EQUVT"));     // Catch: Throwable -> L13
        r107.init(128, r106);     // Catch: Throwable -> L13
        String r108 = h6.a(r107.generateKey().getEncoded());     // Catch: Throwable -> L13
    L15:
        if (TextUtils.isEmpty(r108) == true) goto L26;
        String r109 = h6.a(n7.a((r105 + "\u0000").getBytes(), r108.getBytes()));
        if (TextUtils.isEmpty(r109) == true) goto L26;
        PublicKey r110 = n0.a(b());     // Catch: Throwable -> L24
        byte[] r111 = r108.getBytes(XML.CHARSET_UTF8);     // Catch: Throwable -> L24
        Cipher r112 = Cipher.getInstance(x5.b("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));     // Catch: Throwable -> L21
        r112.init(1, r110);     // Catch: Throwable -> L21
        byte[] r113 = r112.doFinal(r111);     // Catch: Throwable -> L21
    L22:
        return x5.b("Fa2V5PQ") + URLEncoder.encode(h6.a(r113)) + x5.b("SJmRhdGE9") + URLEncoder.encode(r109);
    L21:
        r113 = null;
    L24:
        th = move-exception;
        th.printStackTrace();
    L26:
        return null;
    L13:
        r108 = null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }
}
