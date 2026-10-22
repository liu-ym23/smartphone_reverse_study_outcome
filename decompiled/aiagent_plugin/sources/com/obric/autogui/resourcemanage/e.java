package com.obric.autogui.resourcemanage;

import java.util.Locale;

/* JADX INFO: compiled from: HexUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f30619a = null;

    static {
        f30619a = new e();
    }

    private e() {
    }

    public final String a(byte[] r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r5 = new StringBuilder();
        int r0 = 0;
        int r1 = r6.length;
    L6:
        if (r0 >= r1) goto L11;
        String r2 = Integer.toHexString(r6[r0] & 255);
        if (r2.length() != 1) goto L10;
        r5.append('0');
    L10:
        r5.append(r2);
        r0 = r0 + 1;
        goto L6
    L11:
        String r7 = r5.toString();
        d.h.b.o.c(r7, "toString(...)");
        String r8 = r7.toLowerCase(Locale.ROOT);
        d.h.b.o.c(r8, "toLowerCase(...)");
        return r8;
    }
}
