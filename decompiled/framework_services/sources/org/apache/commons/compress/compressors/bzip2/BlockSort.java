package org.apache.commons.compress.compressors.bzip2;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = null;
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final int[] ftab;
    private final boolean[] mainSort_bigDone;
    private final int[] mainSort_copy;
    private final int[] mainSort_runningOrder;
    private final char[] quadrant;
    private final int[] stack_dd;
    private final int[] stack_hh;
    private final int[] stack_ll;
    private int workDone;
    private int workLimit;

    BlockSort(BZip2CompressorOutputStream.Data data) {
        this.stack_ll = new int[1000];
        this.stack_hh = new int[1000];
        this.stack_dd = new int[1000];
        this.mainSort_runningOrder = new int[256];
        this.mainSort_copy = new int[256];
        this.mainSort_bigDone = new boolean[256];
        this.ftab = new int[65537];
        this.quadrant = data.sfmap;
    }

    void blockSort(BZip2CompressorOutputStream.Data data, int last) {
        this.workLimit = last * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if ((last + 1) >= 10000) goto L5;
        fallbackSort(data, last);
    L10:
        int[] fmap = data.fmap;
        data.origPtr = -1;
        int i = 0;
    L11:
        if (i > last) goto L19;
        if (fmap[i] == 0) goto L14;
        i = i + 1;
        goto L11
    L14:
        data.origPtr = i;
        return;
    L19:
        return;
    L5:
        mainSort(data, last);
        if (this.firstAttempt == false) goto L10;
        if (this.workDone <= this.workLimit) goto L10;
        fallbackSort(data, last);
        goto L10
    }

    final void fallbackSort(BZip2CompressorOutputStream.Data data, int last) {
        data.block[0] = data.block[last + 1];
        fallbackSort(data.fmap, data.block, last + 1);
        int i = 0;
    L4:
        if (i >= (last + 1)) goto L6;
        int[] r1 = data.fmap;
        r1[i] = r1[i] - 1;
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= (last + 1)) goto L17;
        if (data.fmap[i2] == (-1)) goto L11;
        i2 = i2 + 1;
        goto L8
    L11:
        data.fmap[i2] = last;
        return;
    }

    private void fallbackSimpleSort(int[] fmap, int[] eclass, int lo, int hi) {
        if (lo != hi) goto L5;
        return;
    L5:
        if ((hi - lo) <= 3) goto L14;
        int i = hi - 4;
    L7:
        if (i < lo) goto L14;
        int tmp = fmap[i];
        int ec_tmp = eclass[tmp];
        int j = i + 4;
    L9:
        if (j > hi) goto L13;
        if (ec_tmp <= eclass[fmap[j]]) goto L13;
        fmap[j - 4] = fmap[j];
        j = j + 4;
    L13:
        fmap[j - 4] = tmp;
        i = i - 1;
    L14:
        int i2 = hi - 1;
    L15:
        if (i2 < lo) goto L23;
        int tmp2 = fmap[i2];
        int ec_tmp2 = eclass[tmp2];
        int j2 = i2 + 1;
    L17:
        if (j2 > hi) goto L21;
        if (ec_tmp2 <= eclass[fmap[j2]]) goto L21;
        fmap[j2 - 1] = fmap[j2];
        j2 = j2 + 1;
    L21:
        fmap[j2 - 1] = tmp2;
        i2 = i2 - 1;
        goto L15
    }

    private void fswap(int[] fmap, int zz1, int zz2) {
        int zztmp = fmap[zz1];
        fmap[zz1] = fmap[zz2];
        fmap[zz2] = zztmp;
    }

    private void fvswap(int[] fmap, int yyp1, int yyp2, int yyn) {
    L2:
        if (yyn <= 0) goto L4;
        fswap(fmap, yyp1, yyp2);
        yyp1 = yyp1 + 1;
        yyp2 = yyp2 + 1;
        yyn = yyn - 1;
        goto L2
    }

    private int fmin(int a, int b) {
        if (a >= b) goto L5;
        return a;
    L5:
        return b;
    }

    private void fpush(int sp, int lz, int hz) {
        this.stack_ll[sp] = lz;
        this.stack_hh[sp] = hz;
    }

    private int[] fpop(int sp) {
        return new int[]{this.stack_ll[sp], this.stack_hh[sp]};
    }

    private void fallbackQSort3(int[] fmap, int[] eclass, int loSt, int hiSt) {
        eclass = eclass;
        long r = 0;
        int ltLo = 0 + 1;
        fpush(0, loSt, hiSt);
    L3:
        if (ltLo <= 0) goto L39;
        int sp = ltLo - 1;
        int[] s = fpop(sp);
        int lo = s[0];
        int hi = s[1];
        if ((hi - lo) < 10) goto L6;
        long r2 = ((7621 * r) + 1) % 32768;
        long r3 = r2 % 3;
        if (r3 != 0) goto L11;
        long med = eclass[fmap[lo]];
    L14:
        int ltLo2 = lo;
        int unLo = lo;
        int gtHi = hi;
        int unHi = hi;
    L15:
        if (unLo > unHi) goto L21;
        int n = eclass[fmap[unLo]] - ((int) med);
        if (n == 0) goto L19;
        if (n > 0) goto L21;
        unLo = unLo + 1;
        goto L15
    L19:
        fswap(fmap, unLo, ltLo2);
        ltLo2 = ltLo2 + 1;
        unLo = unLo + 1;
    L21:
        int gtHi2 = gtHi;
    L22:
        if (unLo > unHi) goto L28;
        int n2 = eclass[fmap[unHi]] - ((int) med);
        if (n2 == 0) goto L26;
        if (n2 < 0) goto L28;
        unHi = unHi - 1;
        goto L22
    L26:
        fswap(fmap, unHi, gtHi2);
        gtHi2 = gtHi2 - 1;
        unHi = unHi - 1;
    L28:
        if (unLo > unHi) goto L29;
        fswap(fmap, unLo, unHi);
        unLo = unLo + 1;
        unHi = unHi - 1;
        gtHi = gtHi2;
        goto L15
    L29:
        if (gtHi2 < ltLo2) goto L30;
        int gtHi3 = gtHi2;
        int gtHi4 = unLo - ltLo2;
        int n3 = fmin(ltLo2 - lo, gtHi4);
        fvswap(fmap, lo, unLo - n3, n3);
        int m = fmin(hi - gtHi3, gtHi3 - unHi);
        fvswap(fmap, unHi + 1, (hi - m) + 1, m);
        int n4 = ((lo + unLo) - ltLo2) - 1;
        int m2 = (hi - (gtHi3 - unHi)) + 1;
        if ((n4 - lo) <= (hi - m2)) goto L34;
        int sp2 = sp + 1;
        fpush(sp, lo, n4);
        int sp3 = sp2 + 1;
        fpush(sp2, m2, hi);
    L35:
        eclass = eclass;
        ltLo = sp3;
        r = r2;
        goto L3
    L34:
        int sp4 = sp + 1;
        fpush(sp, m2, hi);
        sp3 = sp4 + 1;
        fpush(sp4, lo, n4);
        goto L35
    L30:
        eclass = eclass;
        ltLo = sp;
        r = r2;
        goto L3
    L11:
        if (r3 != 1) goto L13;
        med = eclass[fmap[(lo + hi) >>> 1]];
        goto L14
    L13:
        med = eclass[fmap[hi]];
        goto L14
    L6:
        fallbackSimpleSort(fmap, eclass, lo, hi);
        ltLo = sp;
        goto L3
    }

    private int[] getEclass() {
        if (this.eclass != null) goto L6;
        this.eclass = new int[this.quadrant.length / 2];
    L6:
        return this.eclass;
    }

    final void fallbackSort(int[] fmap, byte[] block, int nblock) {
        int[] ftab = new int[257];
        int[] eclass = getEclass();
        int i = 0;
    L3:
        if (i >= nblock) goto L5;
        eclass[i] = 0;
        i = i + 1;
        goto L3
    L5:
        int i2 = 0;
    L6:
        if (i2 >= nblock) goto L8;
        int r6 = block[i2] & CecDeviceType.INACTIVE;
        ftab[r6] = ftab[r6] + 1;
        i2 = i2 + 1;
        goto L6
    L8:
        int i3 = 1;
    L9:
        if (i3 >= 257) goto L11;
        ftab[i3] = ftab[i3] + ftab[i3 - 1];
        i3 = i3 + 1;
        goto L9
    L11:
        int i4 = 0;
    L12:
        if (i4 >= nblock) goto L14;
        int j = block[i4] & 255;
        int k = ftab[j] - 1;
        ftab[j] = k;
        fmap[k] = i4;
        i4 = i4 + 1;
        goto L12
    L14:
        int j2 = nblock + 64;
        BitSet bhtab = new BitSet(j2);
        int i5 = 0;
    L16:
        if (i5 >= 256) goto L18;
        bhtab.set(ftab[i5]);
        i5 = i5 + 1;
        goto L16
    L18:
        int i6 = 0;
    L20:
        if (i6 >= 32) goto L22;
        bhtab.set((i6 * 2) + nblock);
        bhtab.clear(((i6 * 2) + nblock) + 1);
        i6 = i6 + 1;
        goto L20
    L22:
        int H = 1;
    L23:
        int j3 = 0;
        int i7 = 0;
    L24:
        if (i7 >= nblock) goto L32;
        if (bhtab.get(i7) == false) goto L28;
        j3 = i7;
    L28:
        int k2 = fmap[i7] - H;
        if (k2 >= 0) goto L31;
        k2 = k2 + nblock;
    L31:
        eclass[k2] = j3;
        i7 = i7 + 1;
        goto L24
    L32:
        int nNotDone = 0;
        int r = -1;
    L33:
        int k3 = bhtab.nextClearBit(r + 1);
        int l = k3 - 1;
        if (l >= nblock) goto L38;
        r = bhtab.nextSetBit(k3 + 1) - 1;
        if (r >= nblock) goto L38;
        if (r <= l) goto L33;
        nNotDone = nNotDone + ((r - l) + 1);
        fallbackQSort3(fmap, eclass, l, r);
        int cc = -1;
        int i8 = l;
    L44:
        if (i8 > r) goto L33;
        int cc1 = eclass[fmap[i8]];
        if (cc == cc1) goto L48;
        bhtab.set(i8);
        cc = cc1;
    L48:
        i8 = i8 + 1;
    L38:
        H = H * 2;
        if (H > nblock) goto L41;
        if (nNotDone != 0) goto L23;
        return;
    }

    static {
        INCS = new int[]{1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    }

    private boolean mainSimpleSort(BZip2CompressorOutputStream.Data dataShadow, int lo, int hi, int d, int lastShadow) {
        int r4 = 1;
        int bigN = (hi - lo) + 1;
        if (bigN < 2) goto L5;
        int hp = 0;
    L13:
        if (INCS[hp] >= bigN) goto L15;
        hp = hp + 1;
        goto L13
    L15:
        int[] fmap = dataShadow.fmap;
        char[] quadrant = this.quadrant;
        byte[] block = dataShadow.block;
        int lastPlus1 = lastShadow + 1;
        boolean firstAttemptShadow = this.firstAttempt;
        int workLimitShadow = this.workLimit;
        int workDoneShadow = this.workDone;
    L16:
        hp = hp - 1;
        if (hp < 0) goto L119;
        int h = INCS[hp];
        int mj = (lo + h) - r4;
        int i = lo + h;
    L19:
        if (i > hi) goto L117;
        int k = 3;
    L21:
        if (i > hi) goto L111;
        k = k - 1;
        if (k < 0) goto L111;
        int v = fmap[i];
        int vd = v + d;
        int j = i;
        boolean onceRunned = false;
        int a = 0;
    L25:
        if (onceRunned == false) goto L29;
        fmap[j] = a;
        int r6 = j - h;
        j = r6;
        if (r6 <= mj) goto L28;
    L30:
        a = fmap[j - h];
        int i1 = a + d;
        int bigN2 = bigN;
        if (block[i1 + 1] != block[vd + 1]) goto L108;
        if (block[i1 + 2] != block[vd + 2]) goto L105;
        if (block[i1 + 3] != block[vd + 3]) goto L102;
        if (block[i1 + 4] != block[vd + 4]) goto L99;
        if (block[i1 + 5] != block[vd + 5]) goto L96;
        int i2 = i1 + 6;
        int i3 = vd + 6;
        if (block[i2] != block[i3]) goto L93;
        int x = lastShadow;
    L43:
        if (x <= 0) goto L110;
        int x2 = x - 4;
        int r3 = block[i2 + 1];
        int x3 = block[i3 + 1];
        if (r3 != x3) goto L90;
        if (quadrant[i2] != quadrant[i3]) goto L87;
        if (block[i2 + 2] != block[i3 + 2]) goto L84;
        if (quadrant[i2 + 1] != quadrant[i3 + 1]) goto L81;
        if (block[i2 + 3] != block[i3 + 3]) goto L78;
        if (quadrant[i2 + 2] != quadrant[i3 + 2]) goto L75;
        if (block[i2 + 4] != block[i3 + 4]) goto L72;
        if (quadrant[i2 + 3] != quadrant[i3 + 3]) goto L69;
        i2 = i2 + 4;
        if (i2 < lastPlus1) goto L63;
        i2 = i2 - lastPlus1;
    L63:
        int i4 = i3 + 4;
        if (i4 < lastPlus1) goto L67;
        i4 = i4 - lastPlus1;
    L67:
        i3 = i4;
        workDoneShadow = workDoneShadow + 1;
        x = x2;
        goto L43
    L69:
        if (quadrant[i2 + 3] <= quadrant[i3 + 3]) goto L110;
    L91:
        bigN = bigN2;
        goto L25
    L72:
        if ((block[i2 + 4] & CecDeviceType.INACTIVE) <= (block[i3 + 4] & CecDeviceType.INACTIVE)) goto L110;
    L75:
        if (quadrant[i2 + 2] <= quadrant[i3 + 2]) goto L110;
    L78:
        if ((block[i2 + 3] & CecDeviceType.INACTIVE) <= (block[i3 + 3] & CecDeviceType.INACTIVE)) goto L110;
    L81:
        if (quadrant[i2 + 1] <= quadrant[i3 + 1]) goto L110;
    L84:
        if ((block[i2 + 2] & CecDeviceType.INACTIVE) <= (block[i3 + 2] & CecDeviceType.INACTIVE)) goto L110;
    L87:
        if (quadrant[i2] <= quadrant[i3]) goto L110;
    L90:
        if ((block[i2 + 1] & CecDeviceType.INACTIVE) > (block[i3 + 1] & CecDeviceType.INACTIVE)) goto L91;
    L110:
        fmap[j] = v;
        i = i + 1;
        bigN = bigN2;
        goto L21
    L93:
        if ((block[i2] & CecDeviceType.INACTIVE) <= (block[i3] & CecDeviceType.INACTIVE)) goto L110;
    L96:
        if ((block[i1 + 5] & CecDeviceType.INACTIVE) <= (block[vd + 5] & CecDeviceType.INACTIVE)) goto L110;
    L99:
        if ((block[i1 + 4] & CecDeviceType.INACTIVE) <= (block[vd + 4] & CecDeviceType.INACTIVE)) goto L110;
    L102:
        if ((block[i1 + 3] & CecDeviceType.INACTIVE) <= (block[vd + 3] & CecDeviceType.INACTIVE)) goto L110;
    L105:
        if ((block[i1 + 2] & CecDeviceType.INACTIVE) <= (block[vd + 2] & CecDeviceType.INACTIVE)) goto L110;
    L108:
        if ((block[i1 + 1] & CecDeviceType.INACTIVE) <= (block[vd + 1] & CecDeviceType.INACTIVE)) goto L110;
    L28:
        bigN2 = bigN;
        goto L110
    L29:
        onceRunned = true;
    L111:
        int bigN3 = bigN;
        if (firstAttemptShadow == false) goto L116;
        if (i > hi) goto L116;
        if (workDoneShadow > workLimitShadow) goto L119;
    L116:
        bigN = bigN3;
        goto L19
    L117:
        r4 = 1;
    L119:
        this.workDone = workDoneShadow;
        if (firstAttemptShadow == false) goto L123;
        if (workDoneShadow <= workLimitShadow) goto L123;
        return true;
    L123:
        return false;
    L5:
        if (this.firstAttempt == true) goto L7;
    L9:
        return false;
    L7:
        if (this.workDone <= this.workLimit) goto L9;
        return true;
    }

    private static void vswap(int[] fmap, int p2, int p3, int n) {
        int n2 = n + p2;
    L3:
        if (p2 >= n2) goto L5;
        int t = fmap[p2];
        int p1 = p2 + 1;
        fmap[p2] = fmap[p3];
        fmap[p3] = t;
        p3 = p3 + 1;
        p2 = p1;
        goto L3
    }

    private static byte med3(byte a, byte b, byte c) {
        if (a >= b) goto L7;
        if (b < c) goto L16;
        if (a < c) goto L17;
    L15:
        return a;
    L17:
        return c;
    L16:
        return b;
    L7:
        if (b > c) goto L16;
        if (a <= c) goto L15;
        goto L15
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data dataShadow, int loSt, int hiSt, int dSt, int last) {
        int[] stack_ll = this.stack_ll;
        int[] stack_hh = this.stack_hh;
        int[] stack_dd = this.stack_dd;
        int[] fmap = dataShadow.fmap;
        byte[] block = dataShadow.block;
        stack_ll[0] = loSt;
        stack_hh[0] = hiSt;
        stack_dd[0] = dSt;
        int lo = 1;
    L3:
        int sp = lo - 1;
        if (sp < 0) goto L45;
        int lo2 = stack_ll[sp];
        int hi = stack_hh[sp];
        int d = stack_dd[sp];
        if ((hi - lo2) < 20) goto L40;
        if (d > 10) goto L40;
        int d1 = d + 1;
        int med = med3(block[fmap[lo2] + d1], block[fmap[hi] + d1], block[fmap[(lo2 + hi) >>> 1] + d1]) & CecDeviceType.INACTIVE;
        int unLo = lo2;
        int gtHi = hi;
        int ltLo = lo2;
        int unLo2 = hi;
    L11:
        if (unLo > gtHi) goto L18;
        int n = (block[fmap[unLo] + d1] & CecDeviceType.INACTIVE) - med;
        if (n == 0) goto L14;
        if (n >= 0) goto L18;
        unLo = unLo + 1;
        goto L11
    L14:
        int temp = fmap[unLo];
        fmap[unLo] = fmap[ltLo];
        fmap[ltLo] = temp;
        ltLo = ltLo + 1;
        unLo = unLo + 1;
    L18:
        int gtHi2 = unLo2;
    L19:
        if (unLo > gtHi) goto L26;
        int n2 = (block[fmap[gtHi] + d1] & CecDeviceType.INACTIVE) - med;
        if (n2 != 0) goto L23;
        int temp2 = fmap[gtHi];
        int unHi = gtHi - 1;
        fmap[gtHi] = fmap[gtHi2];
        fmap[gtHi2] = temp2;
        gtHi2 = gtHi2 - 1;
        gtHi = unHi;
        goto L19
    L23:
        if (n2 <= 0) goto L26;
        gtHi = gtHi - 1;
    L26:
        if (unLo > gtHi) goto L28;
        int temp3 = fmap[unLo];
        int unLo3 = unLo + 1;
        fmap[unLo] = fmap[gtHi];
        int unHi2 = gtHi - 1;
        fmap[gtHi] = temp3;
        gtHi = unHi2;
        unLo = unLo3;
        unLo2 = gtHi2;
        goto L11
    L28:
        if (gtHi2 >= ltLo) goto L30;
        stack_ll[sp] = lo2;
        stack_hh[sp] = hi;
        stack_dd[sp] = d1;
        sp = sp + 1;
    L43:
        lo = sp;
        goto L3
    L30:
        int gtHi3 = gtHi2;
        int gtHi4 = unLo - ltLo;
        if ((ltLo - lo2) >= gtHi4) goto L33;
        int n3 = ltLo - lo2;
    L34:
        vswap(fmap, lo2, unLo - n3, n3);
        int n4 = gtHi3 - gtHi;
        if ((hi - gtHi3) >= n4) goto L37;
        int m = hi - gtHi3;
    L38:
        vswap(fmap, unLo, (hi - m) + 1, m);
        int n5 = ((lo2 + unLo) - ltLo) - 1;
        int n6 = gtHi3 - gtHi;
        int m2 = (hi - n6) + 1;
        stack_ll[sp] = lo2;
        stack_hh[sp] = n5;
        stack_dd[sp] = d;
        int sp2 = sp + 1;
        stack_ll[sp2] = n5 + 1;
        stack_hh[sp2] = m2 - 1;
        stack_dd[sp2] = d1;
        int sp3 = sp2 + 1;
        stack_ll[sp3] = m2;
        stack_hh[sp3] = hi;
        stack_dd[sp3] = d;
        sp = sp3 + 1;
        goto L43
    L37:
        m = gtHi3 - gtHi;
        goto L38
    L33:
        n3 = unLo - ltLo;
    L40:
        if (mainSimpleSort(dataShadow, lo2, hi, d, last) == false) goto L43;
        return;
    }

    final void mainSort(BZip2CompressorOutputStream.Data dataShadow, int lastShadow) {
        int r5 = lastShadow;
        int[] runningOrder = this.mainSort_runningOrder;
        int[] copy = this.mainSort_copy;
        boolean[] bigDone = this.mainSort_bigDone;
        int[] ftab = this.ftab;
        byte[] block = dataShadow.block;
        int[] fmap = dataShadow.fmap;
        char[] quadrant = this.quadrant;
        int workLimitShadow = this.workLimit;
        boolean firstAttemptShadow = this.firstAttempt;
        int i = 65537;
    L3:
        i = i - 1;
        if (i < 0) goto L6;
        ftab[i] = 0;
        goto L3
    L6:
        int i2 = 0;
    L7:
        int r4 = 1;
        if (i2 >= 20) goto L10;
        block[(r5 + i2) + 2] = block[(i2 % (r5 + 1)) + 1];
        i2 = i2 + 1;
        goto L7
    L10:
        int i3 = r5 + 20;
        int i4 = i3 + 1;
    L11:
        i4 = i4 - 1;
        if (i4 < 0) goto L14;
        quadrant[i4] = 0;
        goto L11
    L14:
        int i5 = r5 + 1;
        block[0] = block[i5];
        int r15 = 255;
        int c1 = block[0] & CecDeviceType.INACTIVE;
        int i6 = 0;
    L15:
        if (i6 > r5) goto L17;
        int r19 = r4;
        int c2 = block[i6 + 1] & CecDeviceType.INACTIVE;
        int r18 = (c1 << 8) + c2;
        ftab[r18] = ftab[r18] + 1;
        c1 = c2;
        i6 = i6 + 1;
        r4 = r19;
        goto L15
    L17:
        int r110 = r4;
        int i7 = 1;
    L19:
        if (i7 > 65536) goto L21;
        ftab[i7] = ftab[i7] + ftab[i7 - 1];
        i7 = i7 + 1;
        goto L19
    L21:
        int i8 = block[r110];
        int c3 = i8 & 255;
        int i9 = 0;
    L22:
        if (i9 >= r5) goto L24;
        int c4 = block[i9 + 2] & CecDeviceType.INACTIVE;
        int r111 = (c3 << 8) + c4;
        int r20 = ftab[r111] - 1;
        ftab[r111] = r20;
        fmap[r20] = i9;
        c3 = c4;
        i9 = i9 + 1;
        goto L22
    L24:
        int i10 = r5 + 1;
        int r3 = ((block[i10] & CecDeviceType.INACTIVE) << 8) + (block[r110] & CecDeviceType.INACTIVE);
        int r6 = ftab[r3] - 1;
        ftab[r3] = r6;
        fmap[r6] = r5;
        int i11 = 256;
    L25:
        i11 = i11 - 1;
        if (i11 < 0) goto L28;
        bigDone[i11] = false;
        runningOrder[i11] = i11;
        goto L25
    L28:
        int h = 364;
    L30:
        if (h == r110) goto L42;
        h = h / 3;
        int i12 = h;
    L32:
        if (i12 > r15) goto L41;
        int vv = runningOrder[i12];
        int a = ftab[(vv + 1) << 8] - ftab[vv << 8];
        int b = h - 1;
        int j = i12;
        int ro = runningOrder[j - h];
    L35:
        if ((ftab[(ro + 1) << 8] - ftab[ro << 8]) <= a) goto L40;
        runningOrder[j] = ro;
        int j2 = j - h;
        if (j2 <= b) goto L38;
        ro = runningOrder[j2 - h];
        j = j2;
        goto L35
    L38:
        j = j2;
    L40:
        runningOrder[j] = vv;
        i12 = i12 + 1;
        r15 = 255;
        goto L32
    L41:
        r15 = 255;
        r110 = 1;
        goto L30
    L42:
        int i13 = 0;
    L43:
        int r0 = 255;
        if (i13 > 255) goto L95;
        int ss = runningOrder[i13];
        int j3 = 0;
    L46:
        int r7 = CLEARMASK;
        if (j3 > r0) goto L61;
        int sb = (ss << 8) + j3;
        int ftab_sb = ftab[sb];
        if ((ftab_sb & 2097152) == 2097152) goto L59;
        int lo = ftab_sb & CLEARMASK;
        int hi = (CLEARMASK & ftab[sb + 1]) - 1;
        if (hi <= lo) goto L57;
        int r23 = 2097152;
        int j4 = j3;
        mainQSort3(dataShadow, lo, hi, 2, r5);
        if (firstAttemptShadow == true) goto L55;
    L58:
        int j5 = ftab_sb | r23;
        ftab[sb] = j5;
    L60:
        j3 = j4 + 1;
        r5 = lastShadow;
        r0 = 255;
        goto L46
    L55:
        if (this.workDone <= workLimitShadow) goto L58;
        return;
    L57:
        r23 = 2097152;
        j4 = j3;
        goto L58
    L59:
        j4 = j3;
        goto L60
    L61:
        int j6 = 0;
    L63:
        if (j6 > 255) goto L65;
        copy[j6] = ftab[(j6 << 8) + ss] & CLEARMASK;
        j6 = j6 + 1;
        goto L63
    L65:
        int j7 = ss << 8;
        int j8 = ftab[j7] & CLEARMASK;
        int hj = ftab[(ss + 1) << 8] & CLEARMASK;
    L66:
        if (j8 >= hj) goto L75;
        int fmap_j = fmap[j8];
        int r21 = r7;
        int c5 = block[fmap_j] & 255;
        if (bigDone[c5] == true) goto L74;
        int r8 = copy[c5];
        if (fmap_j != 0) goto L72;
        int r17 = lastShadow;
    L73:
        fmap[r8] = r17;
        copy[c5] = copy[c5] + 1;
        goto L74
    L72:
        r17 = fmap_j - 1;
    L74:
        j8 = j8 + 1;
        r7 = r21;
        goto L66
    L75:
        int r22 = r7;
        int j9 = 256;
    L76:
        j9 = j9 - 1;
        if (j9 < 0) goto L79;
        int r2 = (j9 << 8) + ss;
        ftab[r2] = ftab[r2] | 2097152;
        goto L76
    L79:
        bigDone[ss] = true;
        if (i13 >= 255) goto L93;
        int bbStart = ftab[ss << 8] & r22;
        int bbSize = (ftab[(ss + 1) << 8] & r22) - bbStart;
        int shifts = 0;
    L83:
        if ((bbSize >> shifts) <= 65534) goto L85;
        shifts = shifts + 1;
        goto L83
    L85:
        int j10 = 0;
    L86:
        if (j10 >= bbSize) goto L93;
        int a2update = fmap[bbStart + j10];
        char qVal = (char) (j10 >> shifts);
        quadrant[a2update] = qVal;
        if (a2update >= 20) goto L90;
        quadrant[(a2update + lastShadow) + 1] = qVal;
    L90:
        j10 = j10 + 1;
    L93:
        i13 = i13 + 1;
        r5 = lastShadow;
        goto L43
    }
}
