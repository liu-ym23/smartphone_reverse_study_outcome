package com.alipay.sdk.m.l0;

/* JADX INFO: loaded from: classes28.dex */
public class e {

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f25528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f25529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25530c;

        public b() {
            this.f25528a = new int[256];
        }

        public /* synthetic */ b(a r100) {
            this();
        }
    }

    public static b a(String r100) {
        a r101 = null;
        if (r100 == null) goto L14;
        b r102 = new b(r101);
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r104 >= 256) goto L8;
        r102.f25528a[r104] = r104;
        r104 = r104 + 1;
        goto L6
    L8:
        r102.f25529b = 0;
        r102.f25530c = 0;
        int r105 = 0;
        int r106 = 0;
    L9:
        if (r103 >= 256) goto L13;
        char r107 = r100.charAt(r105);     // Catch: Exception -> L12
        int[] r108 = r102.f25528a;     // Catch: Exception -> L12
        int r109 = r108[r103];     // Catch: Exception -> L12
        r106 = ((r107 + r109) + r106) % 256;     // Catch: Exception -> L12
        r108[r103] = r108[r106];     // Catch: Exception -> L12
        r108[r106] = r109;     // Catch: Exception -> L12
        r105 = (r105 + 1) % r100.length();     // Catch: Exception -> L12
        r103 = r103 + 1;
    L12:
        return null;
    L13:
        return r102;
    L14:
        return null;
    }

    public static byte[] a(byte[] r100) {
        if (r100 == null) goto L7;
        b r101 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
        if (r101 != null) goto L6;
        return null;
    L6:
        return a(r100, r101);
    L7:
        return null;
    }

    public static byte[] a(byte[] r100, b r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L13;
        int r102 = r101.f25529b;
        int r103 = r101.f25530c;
        int r104 = 0;
    L6:
        if (r104 >= r100.length) goto L8;
        r102 = (r102 + 1) % 256;
        int[] r105 = r101.f25528a;
        int r106 = r105[r102];
        r103 = (r103 + r106) % 256;
        r105[r102] = r105[r103];
        r105[r103] = r106;
        int r107 = (r105[r102] + r106) % 256;
        byte r108 = r100[r104];
        r100[r104] = (byte) (r105[r107] ^ r108);
        r104 = r104 + 1;
        goto L6
    L8:
        r101.f25529b = r102;
        r101.f25530c = r103;
        return r100;
    L13:
        return null;
    L10:
        return null;
    }
}
