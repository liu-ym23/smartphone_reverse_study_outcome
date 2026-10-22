package cm3;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
    public static int b(int r100, String r101) {
        int r102 = bm3.a.a(r101);
        return (r102 + bm3.a.b(r102)) + bm3.a.b((r100 << 3) | 0);
    }

    public static void a(bm3.a r100, int r101, String r110) {
        r100.c((r101 << 3) | 2);
        r100.c(bm3.a.a(r110));
        int r102 = 0;
    L4:
        if (r102 >= r110.length()) goto L30;
        char r103 = r110.charAt(r102);
        if (r103 < 128) goto L7;
        if (r103 < 2048) goto L10;
        if (r103 < 55296) goto L28;
        if (r103 > 57343) goto L28;
        int r104 = r102 + 1;
        if (r104 >= r110.length()) goto L19;
        char r105 = r110.charAt(r104);
    L21:
        if (r103 > 56319) goto L27;
        if (r105 < 56320) goto L27;
        if (r105 > 57343) goto L27;
        int r106 = (((r103 & (-55297)) << 10) | ((-56321) & r105)) + 65536;
        byte[] r107 = r100.f19572a;
        int r108 = r100.f19573b;
        int r109 = r108 + 1;
        r107[r108] = (byte) ((r106 >> 18) | 240);
        int r111 = r109 + 1;
        r107[r109] = (byte) (((r106 >> 12) & 63) | 128);
        int r112 = r111 + 1;
        r107[r111] = (byte) (((r106 >> 6) & 63) | 128);
        r100.f19573b = r112 + 1;
        r107[r112] = (byte) ((r106 & 63) | 128);
        r102 = r102 + 2;
    L27:
        byte[] r113 = r100.f19572a;
        int r114 = r100.f19573b;
        r100.f19573b = r114 + 1;
        r113[r114] = 63;
        r102 = r104;
        goto L4
    L19:
        r105 = 0;
    L28:
        byte[] r115 = r100.f19572a;
        int r116 = r100.f19573b;
        int r117 = r116 + 1;
        r115[r116] = (byte) ((r103 >> '\f') | 224);
        int r118 = r117 + 1;
        r115[r117] = (byte) ((63 & (r103 >> 6)) | 128);
        r100.f19573b = r118 + 1;
        r115[r118] = (byte) ((r103 & '?') | 128);
    L29:
        r102 = r102 + 1;
        goto L4
    L10:
        byte[] r119 = r100.f19572a;
        int r120 = r100.f19573b;
        int r121 = r120 + 1;
        r119[r120] = (byte) ((r103 >> 6) | 192);
        r100.f19573b = r121 + 1;
        r119[r121] = (byte) ((r103 & '?') | 128);
        goto L29
    L7:
        byte[] r122 = r100.f19572a;
        int r123 = r100.f19573b;
        r100.f19573b = r123 + 1;
        r122[r123] = (byte) r103;
        goto L29
    }
}
