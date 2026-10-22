package com.stepos.core.common.cloud;

import gc.o;
import gc.r;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import mb.l;
import mb.m;
import mb.v;
import okhttp3.Response;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudRequestHeaderLog {
    public static final CloudRequestHeaderLog INSTANCE = new CloudRequestHeaderLog();
    private static final Set<String> SENSITIVE_KEYS = l.s0(new String[]{"authorization", "zy-sign", "cookie", "set-cookie"});

    private CloudRequestHeaderLog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence format$lambda$3(Map.Entry entry) {
        kotlin.jvm.internal.g.f(entry, "<destruct>");
        String str = (String) entry.getKey();
        return com.stepos.core.ota.d.i(str, "=", INSTANCE.sanitize(str, (String) entry.getValue()));
    }

    private final String sanitize(String str, String str2) throws NoSuchAlgorithmException {
        Set<String> set = SENSITIVE_KEYS;
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        if (!set.contains(lowerCase)) {
            return str2;
        }
        String str3 = o.k0(str2, "Bearer ", true) ? "Bearer " : "";
        if (str3.length() > 0) {
            str2 = r.Q0(str3.length(), str2);
        }
        return str3 + "len=" + str2.length() + ", hash=" + shortHash(str2);
    }

    private final String shortHash(String str) throws NoSuchAlgorithmException {
        if (str.length() == 0) {
            return "00000000";
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(gc.a.f9106b);
        kotlin.jvm.internal.g.e(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        kotlin.jvm.internal.g.c(bArrDigest);
        return kotlin.collections.a.z0(l.l0(bArrDigest, 4), "", null, null, new c(), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence shortHash$lambda$4(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    public final String format(Map<String, String> headers) {
        kotlin.jvm.internal.g.f(headers, "headers");
        return kotlin.collections.a.z0(kotlin.collections.a.I0(headers.entrySet(), new Comparator() { // from class: com.stepos.core.common.cloud.CloudRequestHeaderLog$format$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t8, T t10) {
                String str = (String) ((Map.Entry) t8).getKey();
                Locale locale = Locale.ROOT;
                String lowerCase = str.toLowerCase(locale);
                kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
                String lowerCase2 = ((String) ((Map.Entry) t10).getKey()).toLowerCase(locale);
                kotlin.jvm.internal.g.e(lowerCase2, "toLowerCase(...)");
                return ob.b.a(lowerCase, lowerCase2);
            }
        }), ", ", null, null, new d(0), 30);
    }

    public final String format(okhttp3.h request) {
        kotlin.jvm.internal.g.f(request, "request");
        Set<String> setC = request.f10994c.c();
        int iA0 = v.a0(m.Z(setC, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (Object obj : setC) {
            String strA = request.a((String) obj);
            if (strA == null) {
                strA = "";
            }
            linkedHashMap.put(obj, strA);
        }
        return format(linkedHashMap);
    }

    public final String format(Response response) {
        kotlin.jvm.internal.g.f(response, "response");
        Set<String> setC = response.h.c();
        int iA0 = v.a0(m.Z(setC, 10));
        if (iA0 < 16) {
            iA0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA0);
        for (Object obj : setC) {
            String strA = Response.a((String) obj, response);
            if (strA == null) {
                strA = "";
            }
            linkedHashMap.put(obj, strA);
        }
        return format(linkedHashMap);
    }
}
