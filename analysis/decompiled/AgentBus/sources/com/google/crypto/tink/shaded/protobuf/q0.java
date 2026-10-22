package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f2264a;

    static {
        char[] cArr = new char[80];
        f2264a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(int i2, StringBuilder sb2) {
        while (i2 > 0) {
            int i10 = 80;
            if (i2 <= 80) {
                i10 = i2;
            }
            sb2.append(f2264a, 0, i10);
            i2 -= i10;
        }
    }

    public static void b(StringBuilder sb2, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb2, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb2, i2, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        a(i2, sb2);
        if (!str.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Character.toLowerCase(str.charAt(0)));
            for (int i10 = 1; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (Character.isUpperCase(cCharAt)) {
                    sb3.append("_");
                }
                sb3.append(Character.toLowerCase(cCharAt));
            }
            str = sb3.toString();
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            g gVar = h.f2209g;
            sb2.append(ib.k.u(new g(((String) obj).getBytes(z.f2296a))));
            sb2.append('\"');
            return;
        }
        if (obj instanceof h) {
            sb2.append(": \"");
            sb2.append(ib.k.u((h) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof v) {
            sb2.append(" {");
            c((v) obj, sb2, i2 + 2);
            sb2.append("\n");
            a(i2, sb2);
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj);
            return;
        }
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i11 = i2 + 2;
        b(sb2, i11, "key", entry.getKey());
        b(sb2, i11, "value", entry.getValue());
        sb2.append("\n");
        a(i2, sb2);
        sb2.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(com.google.crypto.tink.shaded.protobuf.v r21, java.lang.StringBuilder r22, int r23) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.q0.c(com.google.crypto.tink.shaded.protobuf.v, java.lang.StringBuilder, int):void");
    }
}
