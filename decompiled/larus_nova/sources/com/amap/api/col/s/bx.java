package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class bx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f26357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f26358b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f26359c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f26360d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f26361e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f26362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f26363g;

    public final synchronized Map<String, String> b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f26362f == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        f26362f = true;     // Catch: Throwable -> L12
        HashMap r100 = new HashMap();     // Catch: Throwable -> L12
        r100.put(bs.c("FZW50"), bs.c("FMg"));     // Catch: Throwable -> L12
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L12
        r101.append(bs.c("SY2hhbm5lbD0"));     // Catch: Throwable -> L12
        String r102 = f26358b;     // Catch: Throwable -> L12
        r101.append(r102);     // Catch: Throwable -> L12
        r101.append(bs.c("SJmRpdj0"));     // Catch: Throwable -> L12
        String r103 = f26360d;     // Catch: Throwable -> L12
        r101.append(r103);     // Catch: Throwable -> L12
        StringBuffer r104 = new StringBuffer();     // Catch: Throwable -> L12
        r104.append(r102);     // Catch: Throwable -> L12
        r104.append(r103);     // Catch: Throwable -> L12
        r104.append(bs.c("FQA"));     // Catch: Throwable -> L12
        r104.append(f26359c);     // Catch: Throwable -> L12
        String r105 = ca.a(r104.toString());     // Catch: Throwable -> L12
        r101.append(bs.c("FJnNpZ249"));     // Catch: Throwable -> L12
        r101.append(r105.toUpperCase(Locale.US));     // Catch: Throwable -> L12
        r101.append(bs.c("SJm91dHB1dD1qc29u") + "\u0000");     // Catch: Throwable -> L12
        r100.put(bs.c("FaW4"), bv.a(cb.a(r101.toString().getBytes(), f26357a.getBytes())));     // Catch: Throwable -> L12
        r100.put(bs.c("Sa2V5dA"), f26361e);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r100;
    }

    static {
        f26357a = bs.c("SRFZHZUVZT3BOa0ZiemZRQQ");
        f26358b = bs.c("FbGJzX3Nkaw");
        f26359c = bs.c("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
        f26360d = bs.c("FQU5EU0RLMTA");
        f26361e = bs.c("FMTAw");
        f26362f = false;
    }

    public static bm.a a() {
        return new AnonymousClass1();
    }

    private String d() {
        if (TextUtils.isEmpty(this.f26363g) == false) goto L5;
        String r100 = bn.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
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
        this.f26363g = r106;
        return r106;
    L5:
        return this.f26363g;
    }

    public bx() {
        this.f26363g = "";
    }

    public static String c() {
        return by.a();
    }

    public static String a(Context r100, String r101) {
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L8
        if (r102.optInt(bs.c("UY29kZQ")) != 1) goto L14;
        String r103 = new JSONObject(r102.optString(bs.c("FZGF0YQ"))).optString(bs.c("FYWRpdQ"));     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r103) == true) goto L15;
        by.a(r103);     // Catch: JSONException -> L8
        bt.a(r100).a(r103);     // Catch: JSONException -> L8
        return r103;
    L15:
        return "";
    L14:
        return "";
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public final String a(String r100, String r101, String r102, String r103) {
        JSONObject r104 = new JSONObject();
        r104.put(bs.c("LdGlk"), r100);     // Catch: Throwable -> L5
        r104.put(bs.c("FZGl1"), r101);     // Catch: Throwable -> L5
        r104.put(bs.c("AZGl1Mg"), r102);     // Catch: Throwable -> L5
        r104.put(bs.c("EZGl1Mw"), r103);     // Catch: Throwable -> L5
    L7:
        String r105 = r104.toString();
        if (TextUtils.isEmpty(r105) == false) goto L10;
        return null;
    L10:
        String r106 = ca.a();
        if (TextUtils.isEmpty(r106) == true) goto L18;
        String r107 = bv.a(cb.a((r105 + "\u0000").getBytes(), r106.getBytes()));
        if (TextUtils.isEmpty(r107) == true) goto L18;
        return bs.c("Fa2V5PQ") + URLEncoder.encode(bv.a(bz.a(r106.getBytes(XML.CHARSET_UTF8), bz.a(d())))) + bs.c("SJmRhdGE9") + URLEncoder.encode(r107);
    L16:
        th = move-exception;
        th.printStackTrace();
    L18:
        return null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }
}
