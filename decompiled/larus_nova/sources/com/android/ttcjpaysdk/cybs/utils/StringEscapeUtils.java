package com.android.ttcjpaysdk.cybs.utils;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/cybs/utils/StringEscapeUtils;", "", "()V", "escapeHtml4", "", "input", "unescapeJava", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StringEscapeUtils {
    public static final StringEscapeUtils INSTANCE = null;

    static {
        INSTANCE = new StringEscapeUtils();
    }

    private StringEscapeUtils() {
    }

    public final String escapeHtml4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L22;
        char r104 = r100.charAt(r103);
        if (r104 != '\"') goto L7;
        r101.append("&quot;");
    L20:
        r103 = r103 + 1;
        goto L3
    L7:
        if (r104 != '<') goto L9;
        r101.append("&lt;");
        goto L20
    L9:
        if (r104 != '>') goto L11;
        r101.append("&gt;");
        goto L20
    L11:
        if (r104 != '&') goto L13;
        r101.append("&amp;");
        goto L20
    L13:
        if (r104 == '\'') goto L15;
        r101.append(r104);
        goto L20
    L15:
        r101.append("&apos;");
        goto L20
    L22:
        return r101.toString();
    }

    public final String unescapeJava(String r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        int r100 = r110.length();
        if (r100 != 0) goto L9;
        return r110;
    L9:
        if (StringsKt.indexOf$default(r110, '\\', 0, false, 6, null) >= 0) goto L11;
        return r110;
    L11:
        StringBuilder r101 = new StringBuilder(r100);
        int r102 = 0;
    L12:
        if (r102 >= r100) goto L87;
        char r103 = r110.charAt(r102);
        if (r103 != '\\') goto L15;
        int r104 = r102 + 1;
        if (r104 >= r100) goto L18;
        char r105 = r110.charAt(r104);
        if (r105 == 'b') goto L22;
        if (r105 == 'n') goto L26;
        if (r105 == 't') goto L29;
        if (r105 == 'f') goto L32;
        if (r105 == 'r') goto L35;
        if (r105 == '\"') goto L38;
        if (r105 == '\'') goto L41;
        if (r105 == '\\') goto L43;
        if (r105 == '/') goto L46;
        if (r105 == 'u') goto L49;
        if ('0' > r105) goto L65;
        if (r105 >= '8') goto L65;
        boolean r111 = true;
    L66:
        if (r111 == true) goto L67;
        r101.append(r105);
    L23:
        r102 = r102 + 2;
        goto L12
    L67:
        if ('0' <= r105) goto L69;
    L71:
        boolean r106 = false;
    L72:
        if (r106 == false) goto L74;
        int r107 = 3;
    L75:
        r102 = r102 + 2;
        int r108 = Math.min(r100, r107 + r104);
    L76:
        if (r102 >= r108) goto L84;
        char r112 = r110.charAt(r102);
        if ('0' > r112) goto L81;
        if (r112 >= '8') goto L81;
        boolean r113 = true;
    L82:
        if (r113 == false) goto L84;
        r102 = r102 + 1;
    L81:
        r113 = false;
    L84:
        r101.append((char) CastIntegerProtector.parseInt(r110.substring(r104, r102), CharsKt.checkRadix(8)));
        goto L12
    L74:
        r107 = 2;
        goto L75
    L69:
        if (r105 >= '4') goto L71;
        r106 = true;
    L65:
        r111 = false;
        goto L66
    L49:
        int r109 = r102 + 2;
    L50:
        if (r109 >= r100) goto L54;
        if (r110.charAt(r109) != 'u') goto L54;
        r109 = r109 + 1;
    L54:
        int r114 = r109 + 4;
        if (r114 > r100) goto L56;
        Integer r115 = StringsKt.toIntOrNull(r110.substring(r109, r114), 16);
        if (r115 == null) goto L59;
        r101.append((char) r115.intValue());
        r102 = r114;
        goto L12
    L59:
        r101.append(r103);
    L19:
        r102 = r104;
        goto L12
    L56:
        r101.append(r103);
        goto L19
    L46:
        r101.append('/');
        goto L23
    L43:
        r101.append('\\');
        goto L23
    L41:
        r101.append('\'');
        goto L23
    L38:
        r101.append(Typography.quote);
        goto L23
    L35:
        r101.append('\r');
        goto L23
    L32:
        r101.append('\f');
        goto L23
    L29:
        r101.append('\t');
        goto L23
    L26:
        r101.append('\n');
        goto L23
    L22:
        r101.append('\b');
        goto L23
    L18:
        r101.append('\\');
        goto L19
    L15:
        r101.append(r103);
        r102 = r102 + 1;
        goto L12
    L87:
        return r101.toString();
    }
}
