package com.byted.cast.linkcommon.cybergarage.util;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes28.dex */
public final class StringUtil {
    public StringUtil() {
    }

    public static final boolean hasData(String r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.length() > 0) goto L8;
        return false;
    L8:
        return true;
    }

    public static final int toInteger(String r100) {
        return CastIntegerProtector.parseInt(r100);
    L4:
        e = move-exception;
        Debug.warning(e);
        return 0;
    }

    public static final long toLong(String r100) {
        return CastLongProtector.parseLong(r100);
    L4:
        e = move-exception;
        Debug.warning(e);
        return 0;
    }

    public static final int findFirstNotOf(String r100, String r101) {
        return findOf(r100, r101, 0, r100.length() - 1, 1, false);
    }

    public static final int findFirstOf(String r100, String r101) {
        return findOf(r100, r101, 0, r100.length() - 1, 1, true);
    }

    public static final int findLastNotOf(String r100, String r101) {
        return findOf(r100, r101, r100.length() - 1, 0, -1, false);
    }

    public static final int findLastOf(String r100, String r101) {
        return findOf(r100, r101, r100.length() - 1, 0, -1, true);
    }

    public static final String trim(String r100, String r101) {
        int r102 = findFirstNotOf(r100, r101);
        if (r102 >= 0) goto L5;
        return r100;
    L5:
        String r103 = r100.substring(r102, r100.length());
        int r104 = findLastNotOf(r103, r101);
        if (r104 >= 0) goto L9;
        return r103;
    L9:
        return r103.substring(0, r104 + 1);
    }

    public static final int findOf(String r100, String r101, int r102, int r110, int r111, boolean r112) {
        if (r111 != 0) goto L5;
        return -1;
    L5:
        int r103 = r101.length();
    L6:
        if (r111 <= 0) goto L9;
        if (r110 < r102) goto L10;
    L11:
        char r104 = r100.charAt(r102);
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r105 >= r103) goto L22;
        char r107 = r101.charAt(r105);
        if (r112 != true) goto L17;
        if (r104 != r107) goto L21;
        return r102;
    L21:
        r105 = r105 + 1;
        goto L12
    L17:
        if (r104 == r107) goto L19;
        r106 = r106 + 1;
    L19:
        if (r106 != r103) goto L21;
        return r102;
    L22:
        r102 = r102 + r111;
    L10:
        return -1;
    L9:
        if (r102 >= r110) goto L11;
        goto L11
    }
}
