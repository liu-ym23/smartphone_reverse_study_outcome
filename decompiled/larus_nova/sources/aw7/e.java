package aw7;

import androidx.collection.SieveCacheKt;
import com.larus.dora.impl.ota.g2.j0;
import java.util.Arrays;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f16578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f16579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f16583f;

    public e() {
        this.f16582e = -1;
    }

    public final boolean b(int r100) {
        long[] r101 = this.f16578a;
        long r102 = r101[r100];
        if ((j0.G2_OTA_SPACE_RESERVE_BYTES & r102) != 0) goto L6;
        return false;
    L6:
        int r103 = (int) (SieveCacheKt.NodeLinkMask & r102);
        r101[r100] = r102 & (-2147483649L);
        this.f16581d -= r103;
        this.f16582e = Math.min(this.f16582e, r100);
        return true;
    }

    public final boolean c(int r110) {
        long[] r100 = this.f16578a;
        long r101 = r100[r110];
        if ((r101 & j0.G2_OTA_SPACE_RESERVE_BYTES) == 0) goto L6;
        return false;
    L6:
        int r102 = (int) (SieveCacheKt.NodeLinkMask & r101);
        r100[r110] = r101 | j0.G2_OTA_SPACE_RESERVE_BYTES;
        this.f16581d += r102;
        this.f16582e = Math.min(this.f16582e, r110);
        return true;
    }

    public final long d(int r210) {
        long r100 = -1;
        if (r210 != (-1)) goto L5;
        return -1;
    L5:
        int r101 = this.f16580c;
        long[] r102 = this.f16578a;
        int r103 = this.f16582e;
        int r104 = 0;
        if (r103 <= 0) goto L10;
        int r110 = (int) (r102[0] >>> 32);
        int r111 = (int) (r102[r103] >>> 32);
        if (r210 <= r110) goto L10;
        if (r210 >= r111) goto L20;
        int r112 = 0;
        int r113 = 0;
    L14:
        if (r113 >= r103) goto L19;
        int r114 = (r113 + r103) >>> 1;
        if (((int) (r102[r114] >>> 32)) < r210) goto L17;
        r103 = r114;
        goto L14
    L17:
        r112 = r113;
        r113 = r114 + 1;
        goto L14
    L19:
        r103 = r112;
    L20:
        int r105 = this.f16582e;
        if (r103 == 0) goto L24;
        r104 = (int) (this.f16578a[r103] >>> 32);
    L24:
        if (r103 >= r101) goto L39;
        long[] r106 = this.f16578a;
        long r115 = r106[r103];
        r106[r103] = (((long) r104) << 32) | (r115 & BodyPartID.bodyIdMax);
        if (r104 >= r210) goto L27;
        r104 = r104 + 1;
        if ((j0.G2_OTA_SPACE_RESERVE_BYTES & r115) == 0) goto L38;
        int r107 = (int) (r115 & SieveCacheKt.NodeLinkMask);
        if (r107 > 0) goto L34;
    L37:
        r104 = r104 + r107;
        goto L38
    L34:
        if (((r104 + r107) - 1) < r210) goto L37;
        long r108 = (((long) (r210 - r104)) << 32) | (((long) r103) & BodyPartID.bodyIdMax);
    L28:
        r100 = r108;
        r105 = r103;
    L38:
        int r116 = r103;
        r103 = r103 + 1;
        r105 = r116;
        goto L24
    L27:
        r108 = b.a(r103);
    L39:
        this.f16582e = Math.max(this.f16582e, r105);
        return r100;
    L10:
        r103 = 0;
        goto L20
    }

    public final int e(long r110) {
        int r100 = -1;
        if (r110 != (-1)) goto L5;
        return -1;
    L5:
        int r101 = b.b(r110);
        int r102 = (int) (r110 >>> 32);
        int r103 = this.f16580c;
        if (r101 < 0) goto L27;
        if (r101 >= r103) goto L27;
        if (r102 != (-1)) goto L11;
    L13:
        int r104 = Math.max(0, Math.min(r101, this.f16582e));
        int r105 = this.f16582e;
        int r106 = (int) (this.f16578a[r104] >>> 32);
    L14:
        if (r104 >= r103) goto L25;
        long[] r107 = this.f16578a;
        long r111 = r107[r104];
        r107[r104] = (((long) r106) << 32) | (BodyPartID.bodyIdMax & r111);
        int r108 = (int) (SieveCacheKt.NodeLinkMask & r111);
        if (r104 == r101) goto L17;
        r106 = r106 + 1;
        if ((r111 & j0.G2_OTA_SPACE_RESERVE_BYTES) == 0) goto L24;
        r106 = r106 + r108;
    L24:
        r105 = r104;
        r104 = r104 + 1;
        goto L14
    L17:
        if (r102 != (-1)) goto L19;
    L18:
        r100 = r106;
    L26:
        this.f16582e = Math.max(this.f16582e, r104);
        goto L27
    L19:
        if (r102 >= r108) goto L26;
        r106 = (r106 + 1) + r102;
        goto L18
    L25:
        r104 = r105;
        goto L26
    L11:
        if (f(r101) == true) goto L13;
        return -1;
    L27:
        return r100;
    }

    public final boolean f(int r100) {
        if ((this.f16578a[r100] & j0.G2_OTA_SPACE_RESERVE_BYTES) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g(long[] r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.length != 0) goto L7;
        return;
    L7:
        if (this.f16578a != null) goto L9;
        return;
    L9:
        int r100 = this.f16580c;
        long[] r101 = new long[r100];
        int r102 = 0;
    L11:
        if (r102 >= this.f16580c) goto L13;
        r101[r102] = (((long) this.f16579b[r102]) << 32) | ((long) r102);
        r102 = r102 + 1;
        goto L11
    L13:
        Arrays.sort(r101);
        int r103 = 0;
        int r104 = 0;
    L15:
        if (r103 >= r110.length) goto L41;
        long r105 = r110[r103];
        int r106 = (int) (r105 >>> 32);
        if ((r105 & j0.G2_OTA_SPACE_RESERVE_BYTES) == 0) goto L19;
        boolean r107 = true;
    L20:
        int r108 = r104;
    L21:
        if (r104 >= r100) goto L31;
        long r111 = r101[r104];
        int r109 = (int) (r111 >>> 32);
        int r112 = (int) (r111 & SieveCacheKt.NodeLinkMask);
        if (r109 >= r106) goto L25;
        r108 = r104;
    L30:
        r104 = r104 + 1;
        goto L21
    L25:
        if (r109 != r106) goto L31;
        r108 = r104 + 1;
        if (r107 == false) goto L29;
        c(r112);
        goto L30
    L29:
        b(r112);
    L31:
        r103 = r103 + 1;
        r104 = r108;
        goto L15
    L19:
        r107 = false;
        goto L20
    }

    public final void a(c r110, boolean r111) {
        int r100 = r110.getGroupCount();
        int r101 = (r100 + 511) & (-256);
        long[] r102 = this.f16578a;
        int[] r103 = this.f16579b;
        if (r102 != null) goto L5;
    L6:
        r102 = new long[r101];
    L7:
        if (r103 != null) goto L9;
    L10:
        r103 = new int[r101];
    L11:
        this.f16578a = r102;
        this.f16579b = r103;
        int r104 = 0;
        int r105 = 0;
    L12:
        boolean r106 = true;
        if (r104 >= r100) goto L28;
        long r107 = r110.getGroupId(r104);
        int r112 = r110.i1(r104);
        if (r111 == false) goto L17;
    L20:
        long r113 = (((long) (r104 + r105)) << 32) | ((long) r112);
        if (r106 == false) goto L23;
        long r114 = j0.G2_OTA_SPACE_RESERVE_BYTES;
    L24:
        r102[r104] = r113 | r114;
        r103[r104] = (int) (r107 & BodyPartID.bodyIdMax);
        if (r106 == false) goto L27;
        r105 = r105 + r112;
    L27:
        r104 = r104 + 1;
        goto L12
    L23:
        r114 = 0;
        goto L24
    L17:
        if (r110.l1(r104) == true) goto L20;
        r106 = false;
        goto L20
    L28:
        this.f16583f = r110;
        this.f16580c = r100;
        this.f16581d = r105;
        this.f16582e = Math.max(0, r100 - 1);
        return;
    L9:
        if (r103.length >= r100) goto L11;
    L5:
        if (r102.length >= r100) goto L7;
        goto L6
    }
}
