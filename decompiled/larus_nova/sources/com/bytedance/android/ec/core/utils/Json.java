package com.bytedance.android.ec.core.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class Json {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Json f45532b = null;

    public Json() {
    }

    static {
        f45532b = new Json();
        f45531a = LazyKt.lazy(Json$gson$2.INSTANCE);
    }

    public static String d(Object r100) {
        return GsonProtectorUtils.toJson((Gson) f45531a.getValue(), r100);
    }

    public final String a(Object[] r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("[");
        if (r100 != null) goto L5;
    L10:
        r101.append("]");
    L12:
        return r101.toString();
    L5:
        if (r100.length <= 0) goto L10;
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        r101.append(c(r100[r103]));
        r101.append(",");
        r103 = r103 + 1;
        goto L7
    L9:
        r101.setCharAt(r101.length() - 1, ']');
        goto L12
    }

    public final String b(List<?> r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("[");
        if (r100 != null) goto L5;
    L11:
        r101.append("]");
    L13:
        return r101.toString();
    L5:
        if (r100.size() <= 0) goto L11;
        Iterator<?> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.append(c(r102.next()));
        r101.append(",");
        goto L8
    L10:
        r101.setCharAt(r101.length() - 1, ']');
        goto L13
    }

    public final String c(Object r110) {
        StringBuilder r100 = new StringBuilder();
        if (r110 != null) goto L6;
        r100.append("\"\"");
    L92:
        return r100.toString();
    L6:
        if ((r110 instanceof String) == false) goto L8;
    L54:
        r100.append("\"");
        String r111 = r110.toString();
        if (r111 != null) goto L57;
        String r112 = "";
    L90:
        r100.append(r112);
        r100.append("\"");
        goto L92
    L57:
        StringBuilder r101 = new StringBuilder();
        int r102 = r111.length();
        int r103 = 0;
    L58:
        if (r103 >= r102) goto L89;
        char r104 = r111.charAt(r103);
        if (r104 != '\f') goto L62;
        r101.append("\\f");
    L88:
        r103 = r103 + 1;
        goto L58
    L62:
        if (r104 != '\r') goto L64;
        r101.append("\\r");
        goto L88
    L64:
        if (r104 != '\"') goto L66;
        r101.append("\\\"");
        goto L88
    L66:
        if (r104 != '/') goto L68;
        r101.append("\\/");
        goto L88
    L68:
        if (r104 == '\\') goto L83;
        switch(r104) {
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            default: goto L71;
        };
    L75:
        r101.append("\\n");
        goto L88
    L76:
        r101.append("\\t");
        goto L88
    L77:
        r101.append("\\b");
        goto L88
    L71:
        if (Intrinsics.compare(r104, 0) >= 0) goto L73;
    L82:
        r101.append(r104);
        goto L88
    L73:
        if (Intrinsics.compare(r104, 31) > 0) goto L82;
        String r105 = Integer.toHexString(r104);
        r101.append("\\u");
        int r106 = 0;
    L79:
        if (r106 >= (4 - r105.length())) goto L81;
        r101.append('0');
        r106 = r106 + 1;
        goto L79
    L81:
        r101.append(r105.toUpperCase(Locale.ROOT));
        goto L88
    L83:
        r101.append("\\\\");
        goto L88
    L89:
        r112 = r101.toString();
        goto L90
    L8:
        if ((r110 instanceof Integer) == true) goto L54;
        if ((r110 instanceof Float) == true) goto L54;
        if ((r110 instanceof Boolean) == true) goto L54;
        if ((r110 instanceof Short) == true) goto L54;
        if ((r110 instanceof Double) == true) goto L54;
        if ((r110 instanceof Long) == true) goto L54;
        if ((r110 instanceof BigDecimal) == true) goto L54;
        if ((r110 instanceof BigInteger) == true) goto L54;
        if ((r110 instanceof Byte) == true) goto L54;
        if ((r110 instanceof Object[]) == false) goto L30;
        r100.append(a((Object[]) r110));
        goto L92
    L30:
        if ((r110 instanceof List) == false) goto L33;
        r100.append(b((List) r110));
        goto L92
    L33:
        if ((r110 instanceof Map) == false) goto L44;
        Map r113 = (Map) r110;
        StringBuilder r107 = new StringBuilder();
        r107.append("{");
        if (r113.size() <= 0) goto L41;
        Iterator r108 = r113.keySet().iterator();
    L38:
        if (r108.hasNext() == false) goto L40;
        Object r109 = r108.next();
        r107.append(c(r109));
        r107.append(":");
        r107.append(c(r113.get(r109)));
        r107.append(",");
        goto L38
    L40:
        r107.setCharAt(r107.length() - 1, '}');
    L42:
        r100.append(r107.toString());
        goto L92
    L41:
        r107.append(com.alipay.sdk.m.u.i.f25855d);
        goto L42
    L44:
        if ((r110 instanceof Set) == false) goto L92;
        Set r114 = (Set) r110;
        StringBuilder r115 = new StringBuilder();
        r115.append("[");
        if (r114.size() <= 0) goto L52;
        Iterator r116 = r114.iterator();
    L49:
        if (r116.hasNext() == false) goto L51;
        r115.append(c(r116.next()));
        r115.append(",");
        goto L49
    L51:
        r115.setCharAt(r115.length() - 1, ']');
    L53:
        r100.append(r115.toString());
        goto L92
    L52:
        r115.append("]");
        goto L53
    }
}
