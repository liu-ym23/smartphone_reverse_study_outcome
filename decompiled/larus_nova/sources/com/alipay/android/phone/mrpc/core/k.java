package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f25022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f25023b = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f25025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25026c;

        public a(int r100, int r101, int r102) {
            this.f25024a = r100;
            this.f25025b = r101;
            this.f25026c = r102;
        }
    }

    static {
        f25022a = PatternProtector.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
        f25023b = PatternProtector.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
    }

    public static long a(String r110) {
        Matcher r100 = f25022a.matcher(r110);
        if (r100.find() == false) goto L5;
        int r111 = b(r100.group(1));
        int r101 = c(r100.group(2));
        int r102 = d(r100.group(3));
        a r103 = e(r100.group(4));
    L9:
        if (r102 < 2038) goto L11;
        int r112 = 1;
        int r113 = 0;
        int r114 = 2038;
    L12:
        Time r115 = new Time("UTC");
        r115.set(r103.f25026c, r103.f25025b, r103.f25024a, r112, r113, r114);
        return r115.toMillis(false);
    L11:
        r112 = r111;
        r113 = r101;
        r114 = r102;
        goto L12
    L5:
        Matcher r116 = f25023b.matcher(r110);
        if (r116.find() == false) goto L15;
        r101 = c(r116.group(1));
        int r104 = b(r116.group(2));
        a r105 = e(r116.group(3));
        r102 = d(r116.group(4));
        r111 = r104;
        r103 = r105;
        goto L9
    L15:
        throw new IllegalArgumentException();
    }

    public static int b(String r100) {
        if (r100.length() != 2) goto L7;
        return ((r100.charAt(0) - '0') * 10) + (r100.charAt(1) - '0');
    L7:
        return r100.charAt(0) - '0';
    }

    public static int c(String r100) {
        int r101 = ((Character.toLowerCase(r100.charAt(0)) + Character.toLowerCase(r100.charAt(1))) + Character.toLowerCase(r100.charAt(2))) - 291;
        if (r101 != 9) goto L5;
        return 11;
    L5:
        if (r101 != 10) goto L7;
        return 1;
    L7:
        if (r101 != 22) goto L9;
        return 0;
    L9:
        if (r101 != 26) goto L11;
        return 7;
    L11:
        if (r101 != 29) goto L13;
        return 2;
    L13:
        if (r101 != 32) goto L15;
        return 3;
    L15:
        if (r101 != 40) goto L17;
        return 6;
    L17:
        if (r101 != 42) goto L19;
        return 5;
    L19:
        if (r101 == 48) goto L27;
        switch(r101) {
            case 35: goto L41;
            case 36: goto L25;
            case 37: goto L23;
            default: goto L22;
        };
    L23:
        return 8;
    L25:
        return 4;
    L41:
        return 9;
    L22:
        throw new IllegalArgumentException();
    L27:
        return 10;
    }

    public static int d(String r100) {
        if (r100.length() != 2) goto L11;
        int r101 = ((r100.charAt(0) - '0') * 10) + (r100.charAt(1) - '0');
        if (r101 < 70) goto L9;
        return r101 + 1900;
    L9:
        return r101 + 2000;
    L11:
        if (r100.length() != 3) goto L15;
        return ((((r100.charAt(0) - '0') * 100) + ((r100.charAt(1) - '0') * 10)) + (r100.charAt(2) - '0')) + 1900;
    L15:
        if (r100.length() == 4) goto L17;
        return 1970;
    L17:
        return ((((r100.charAt(0) - '0') * 1000) + ((r100.charAt(1) - '0') * 100)) + ((r100.charAt(2) - '0') * 10)) + (r100.charAt(3) - '0');
    }

    public static a e(String r100) {
        int r101 = r100.charAt(0) - '0';
        if (r100.charAt(1) == ':') goto L5;
        r101 = (r101 * 10) + (r100.charAt(1) - '0');
        int r102 = 2;
    L6:
        int r103 = r102 + 1;
        int r104 = r103 + 1;
        int r105 = (r104 + 1) + 1;
        return new a(r101, ((r100.charAt(r103) - '0') * 10) + (r100.charAt(r104) - '0'), ((r100.charAt(r105) - '0') * 10) + (r100.charAt(r105 + 1) - '0'));
    L5:
        r102 = 1;
        goto L6
    }
}
