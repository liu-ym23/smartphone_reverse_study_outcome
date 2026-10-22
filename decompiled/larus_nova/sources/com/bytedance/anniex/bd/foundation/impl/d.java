package com.bytedance.anniex.bd.foundation.impl;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Locale;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d {
    public static final String a(int r100) {
        int r101 = com.bytedance.rts.foundation.c.f267576a;
        int r102 = com.bytedance.rts.foundation.h.f267580a;
        return com.bytedance.rts.foundation.r.a("0123456789ABCDEF", (int) Math.floor(com.bytedance.rts.foundation.k.b(IntCompanionObject.INSTANCE, r100) / ((double) 16))) + com.bytedance.rts.foundation.r.a("0123456789ABCDEF", r100 % 16);
    }

    public static final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        if (Intrinsics.areEqual(r100, "") == false) goto L5;
        return false;
    L5:
        String r101 = StringsKt.trim(r100).toString();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r101, "<this>");
        String r102 = r101.toUpperCase(Locale.ROOT);
        boolean r103 = com.bytedance.rts.foundation.r.g(r102, "#");
        Object r104 = r102;
        if (r103 == false) goto L8;
        r104 = ListProtector.get(com.bytedance.rts.foundation.r.f(r102, "#", -1), 1);
    L8:
        String r105 = (String) r104;
        int r106 = r105.length();
        if (r106 != 3) goto L11;
    L17:
        int r107 = 0;
    L18:
        if (r107 >= r106) goto L30;
        String r108 = com.bytedance.rts.foundation.r.a(r105, r107);
        int r109 = 0;
    L21:
        if (r109 >= 16) goto L26;
        if (Intrinsics.areEqual(r108, com.bytedance.rts.foundation.r.a("0123456789ABCDEF", r109)) == true) goto L24;
        r109 = r109 + 1;
        goto L21
    L24:
        boolean r110 = true;
    L27:
        if (r110 == false) goto L28;
        r107 = r107 + 1;
        goto L18
    L28:
        return false;
    L26:
        r110 = false;
        goto L27
    L30:
        return true;
    L11:
        if (r106 == 4) goto L17;
        if (r106 == 6) goto L17;
        if (r106 == 8) goto L17;
        return false;
    }
}
