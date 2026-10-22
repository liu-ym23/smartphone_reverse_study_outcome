package com.alipay.sdk.m.l0;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f25531a = null;

    static {
        f25531a = PatternProtector.compile("([\t\r\n])+");
    }

    public static int a(String r100) {
        int r101 = 0;
        if (r100.length() <= 0) goto L11;
        char[] r102 = r100.toCharArray();
        int r103 = 0;
    L6:
        if (r101 >= r102.length) goto L9;
        r103 = (r103 * 31) + r102[r101];
        r101 = r101 + 1;
        goto L6
    L9:
        return r103;
    L11:
        return 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8017a(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.length() <= 0) goto L9;
        return false;
    L9:
        return true;
    }
}
