package com.bytedance.android.ecom.arch.slice.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcVersionUtil {
    static {
    }

    public static String a(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return "0.0.0";
    L12:
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        ArrayList r101 = new ArrayList();
        r101.addAll(r111);
    L14:
        if (r101.size() >= 3) goto L17;
        r101.add("0");
        goto L14
    L17:
        if (r101.size() <= 3) goto L20;
        r101.subList(0, 3);
    L20:
        return CollectionsKt.joinToString$default(r101, ".", null, null, 0, null, null, 62, null);
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r100 = false;
        goto L9
    }

    public static int b(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return 0;
    L11:
        SlcVersionUtil$version2Number$1 r101 = SlcVersionUtil$version2Number$1.INSTANCE;
        List r111 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        Object r102 = "0";
        if (CollectionsKt.getLastIndex(r111) < 0) goto L14;
        Object r103 = ListProtector.get(r111, 0);
    L15:
        int r104 = r101.invoke2((String) r103);
        if (1 > CollectionsKt.getLastIndex(r111)) goto L18;
        Object r105 = ListProtector.get(r111, 1);
    L19:
        int r106 = r101.invoke2((String) r105);
        if (2 > CollectionsKt.getLastIndex(r111)) goto L22;
        r102 = ListProtector.get(r111, 2);
    L22:
        int r107 = (r104 * 10000) + (r106 * 100);
        return r107 + r101.invoke2((String) r102);
    L18:
        r105 = "0";
        goto L19
    L14:
        r103 = "0";
        goto L15
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r100 = false;
        goto L9
    }
}
