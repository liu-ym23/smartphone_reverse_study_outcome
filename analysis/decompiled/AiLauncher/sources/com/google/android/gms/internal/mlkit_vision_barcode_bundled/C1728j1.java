package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.j1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1728j1 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f20089a;

    static {
        char[] cArr = new char[80];
        f20089a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String a(InterfaceC1720h1 interfaceC1720h1, String str) throws SecurityException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        d(interfaceC1720h1, sb2, 0);
        return sb2.toString();
    }

    public static void b(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb2, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb2, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        c(i10, sb2);
        if (!str.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Character.toLowerCase(str.charAt(0)));
            for (int i11 = 1; i11 < str.length(); i11++) {
                char cCharAt = str.charAt(i11);
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
            sb2.append(L1.a(new zzde(((String) obj).getBytes(N0.f20038a))));
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            return;
        }
        if (obj instanceof zzdf) {
            sb2.append(": \"");
            sb2.append(L1.a((zzdf) obj));
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            return;
        }
        if (obj instanceof F0) {
            sb2.append(" {");
            d((F0) obj, sb2, i10 + 2);
            sb2.append("\n");
            c(i10, sb2);
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj);
            return;
        }
        int i12 = i10 + 2;
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        b(sb2, i12, "key", entry.getKey());
        b(sb2, i12, UxipConstants.f30680s, entry.getValue());
        sb2.append("\n");
        c(i10, sb2);
        sb2.append("}");
    }

    public static void c(int i10, StringBuilder sb2) {
        while (i10 > 0) {
            int i11 = 80;
            if (i10 <= 80) {
                i11 = i10;
            }
            sb2.append(f20089a, 0, i11);
            i10 -= i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1720h1 r18, java.lang.StringBuilder r19, int r20) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1728j1.d(com.google.android.gms.internal.mlkit_vision_barcode_bundled.h1, java.lang.StringBuilder, int):void");
    }
}
