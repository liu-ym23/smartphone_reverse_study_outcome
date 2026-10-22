package bm3;

import com.bytedance.mira.oat.ShareElfFile;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f19572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19573b;

    public static int b(int r100) {
        if ((r100 & com.alipay.sdk.m.n.a.f25611g) != 0) goto L7;
        return 1;
    L7:
        if ((r100 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r100) != 0) goto L15;
        return 3;
    L15:
        if ((r100 & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    public a() {
    }

    public static int a(String r100) {
        int r101 = r100.length();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L26;
        char r104 = r100.charAt(r102);
        if (r104 >= 128) goto L8;
    L6:
        r103 = r103 + 1;
    L25:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r104 >= 2048) goto L11;
        r103 = r103 + 2;
        goto L25
    L11:
        if (r104 >= 55296) goto L13;
    L24:
        r103 = r103 + 3;
        goto L25
    L13:
        if (r104 > 57343) goto L24;
        if (r104 > 56319) goto L6;
        int r105 = r102 + 1;
        if (r105 >= r101) goto L6;
        if (r100.charAt(r105) < 56320) goto L6;
        if (r100.charAt(r105) > 57343) goto L6;
        r103 = r103 + 4;
        r102 = r105;
        goto L25
    L26:
        return r103;
    }

    public final void c(int r100) {
    L3:
        if ((r100 & com.alipay.sdk.m.n.a.f25611g) == 0) goto L5;
        byte[] r101 = this.f19572a;
        int r102 = this.f19573b;
        this.f19573b = r102 + 1;
        r101[r102] = (byte) ((r100 & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L5:
        byte[] r103 = this.f19572a;
        int r104 = this.f19573b;
        this.f19573b = r104 + 1;
        r103[r104] = (byte) r100;
    }

    public final void d(long r100) {
    L3:
        if (((-128) & r100) == 0) goto L5;
        byte[] r101 = this.f19572a;
        int r102 = this.f19573b;
        this.f19573b = r102 + 1;
        r101[r102] = (byte) ((((int) r100) & 127) | 128);
        r100 = r100 >>> 7;
        goto L3
    L5:
        byte[] r103 = this.f19572a;
        int r104 = this.f19573b;
        this.f19573b = r104 + 1;
        r103[r104] = (byte) r100;
    }
}
