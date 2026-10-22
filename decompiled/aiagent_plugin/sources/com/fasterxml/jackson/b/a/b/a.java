package com.fasterxml.jackson.b.a.b;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: StringQuotingChecker.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f12169a = null;

    /* JADX INFO: renamed from: com.fasterxml.jackson.b.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: StringQuotingChecker.java */
    public static class C0268a extends a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C0268a f12170a = null;

        static {
            f12170a = new C0268a();
        }

        public C0268a() {
        }

        public static C0268a a() {
            return f12170a;
        }

        @Override // com.fasterxml.jackson.b.a.b.a
        public boolean a(String r2) {
            if (c(r2) == false) goto L5;
        L10:
            return true;
        L5:
            if (d(r2) == true) goto L10;
            if (f(r2) == true) goto L10;
            return false;
        }

        @Override // com.fasterxml.jackson.b.a.b.a
        public boolean b(String r2) {
            if (c(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (e(r2) == true) goto L8;
            return false;
        }
    }

    public abstract boolean a(String r1);

    public boolean b(int r1, String r2) {
        switch(r1) {
            case 43: goto L5;
            case 44: goto L3;
            case 45: goto L5;
            case 46: goto L5;
            case 47: goto L3;
            case 48: goto L5;
            case 49: goto L5;
            case 50: goto L5;
            case 51: goto L5;
            case 52: goto L5;
            case 53: goto L5;
            case 54: goto L5;
            case 55: goto L5;
            case 56: goto L5;
            case 57: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    public abstract boolean b(String r1);

    public a() {
    }

    static {
        f12169a = new HashSet(Arrays.asList(new String[]{"false", "False", "FALSE", "n", "N", "no", "No", "NO", "null", "Null", "NULL", "on", "On", "ON", "off", "Off", "OFF", "true", "True", "TRUE", "y", "Y", "yes", "Yes", "YES"}));
    }

    public boolean c(String r2) {
        if (r2.length() != 0) goto L7;
        return true;
    L7:
        return a(r2.charAt(0), r2);
    }

    public boolean a(int r1, String r2) {
        if (r1 == 70) goto L29;
        if (r1 == 84) goto L29;
        if (r1 == 89) goto L29;
        if (r1 == 102) goto L29;
        if (r1 == 116) goto L29;
        if (r1 == 121) goto L29;
        if (r1 != 126) goto L17;
        return true;
    L17:
        if (r1 == 78) goto L29;
        if (r1 == 79) goto L29;
        if (r1 == 110) goto L29;
        if (r1 == 111) goto L29;
        return false;
    L29:
        return f12169a.contains(r2);
    }

    public boolean d(String r3) {
        if (r3.length() > 0) goto L5;
        return false;
    L5:
        return b(r3.charAt(0), r3);
    }

    public boolean e(String r8) {
        int r7 = r8.length();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L31;
        char r2 = r8.charAt(r1);
        if (r2 != '#') goto L7;
        if (r1 <= 0) goto L30;
        char r3 = r8.charAt(r1 - 1);
        if (' ' == r3) goto L29;
        if ('\t' != r3) goto L30;
    L29:
        return true;
    L30:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2 == ',') goto L24;
        if (r2 == ':') goto L20;
        if (r2 == '[') goto L24;
        if (r2 == ']') goto L24;
        if (r2 == '{') goto L24;
        if (r2 == '}') goto L24;
    L20:
        if (r1 >= (r7 - 1)) goto L30;
        char r4 = r8.charAt(r1 + 1);
        if (' ' == r4) goto L24;
        if ('\t' != r4) goto L30;
    L24:
        return true;
    L31:
        return false;
    }

    public boolean f(String r5) {
        int r4 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L9;
        if (r5.charAt(r1) < ' ') goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }
}
