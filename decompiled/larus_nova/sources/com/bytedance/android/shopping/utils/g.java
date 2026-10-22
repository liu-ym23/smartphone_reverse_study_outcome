package com.bytedance.android.shopping.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187081a = 0;

    static {
    }

    public static String b(int r100) {
        int r101 = r100 / 60;
        int r102 = r100 - (r101 * 60);
        StringBuilder r103 = new StringBuilder();
        if (r101 >= 10) goto L5;
        String r104 = "0" + r101;
    L6:
        r103.append(r104);
        r103.append(':');
        if (r102 >= 10) goto L9;
        String r105 = "0" + r102;
    L10:
        r103.append(r105);
        return r103.toString();
    L9:
        r105 = String.valueOf(r102);
        goto L10
    L5:
        r104 = String.valueOf(r101);
        goto L6
    }

    public static String c(long r100) {
        long r101 = 60;
        long r102 = r100 / r101;
        long r103 = r100 - (r101 * r102);
        StringBuilder r104 = new StringBuilder();
        long r105 = 10;
        if (r102 >= r105) goto L5;
        String r106 = "0" + r102;
    L6:
        r104.append(r106);
        r104.append(':');
        if (r103 >= r105) goto L9;
        String r107 = "0" + r103;
    L10:
        r104.append(r107);
        return r104.toString();
    L9:
        r107 = String.valueOf(r103);
        goto L10
    L5:
        r106 = String.valueOf(r102);
        goto L6
    }

    public static String d(long r100) {
        long r101 = 100;
        if ((r100 % r101) != 0) goto L6;
        return String.valueOf(r100 / r101);
    L6:
        if ((r100 % ((long) 10)) != 0) goto L8;
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(a(r100, 100, 1))}, 1));
    L8:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(a(r100, 100, 2))}, 1));
    }

    public static double a(double r100, double r101, int r102) {
        if (r102 < 0) goto L6;
        return new BigDecimal(String.valueOf(r100)).divide(new BigDecimal(String.valueOf(r101)), r102, 4).doubleValue();
    L6:
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
