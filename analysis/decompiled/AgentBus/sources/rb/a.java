package rb;

import h4.n;
import n7.m;
import qb.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: o, reason: collision with root package name */
    public static final long[] f9135o = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* renamed from: c, reason: collision with root package name */
    public long f9138c;

    /* renamed from: d, reason: collision with root package name */
    public long f9139d;

    /* renamed from: e, reason: collision with root package name */
    public long f9140e;

    /* renamed from: f, reason: collision with root package name */
    public long f9141f;

    /* renamed from: g, reason: collision with root package name */
    public long f9142g;

    /* renamed from: h, reason: collision with root package name */
    public long f9143h;

    /* renamed from: i, reason: collision with root package name */
    public long f9144i;

    /* renamed from: j, reason: collision with root package name */
    public long f9145j;

    /* renamed from: k, reason: collision with root package name */
    public long f9146k;

    /* renamed from: l, reason: collision with root package name */
    public long f9147l;

    /* renamed from: n, reason: collision with root package name */
    public int f9149n;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9136a = new byte[8];

    /* renamed from: m, reason: collision with root package name */
    public final long[] f9148m = new long[80];

    /* renamed from: b, reason: collision with root package name */
    public int f9137b = 0;

    public a() {
        i();
        new n("SHA-512");
        d.a();
        i();
    }

    public static long a(long j2, long j4, long j10) {
        return ((~j2) & j10) ^ (j4 & j2);
    }

    public static long b(long j2, long j4, long j10) {
        return ((j2 & j10) ^ (j2 & j4)) ^ (j4 & j10);
    }

    public static long c(long j2) {
        return ((j2 >>> 39) | (j2 << 25)) ^ (((j2 << 36) | (j2 >>> 28)) ^ ((j2 << 30) | (j2 >>> 34)));
    }

    public static long d(long j2) {
        return ((j2 >>> 41) | (j2 << 23)) ^ (((j2 << 50) | (j2 >>> 14)) ^ ((j2 << 46) | (j2 >>> 18)));
    }

    public final int e(int i2, byte[] bArr) {
        long j2 = this.f9138c;
        if (j2 > 2305843009213693951L) {
            this.f9139d += j2 >>> 61;
            this.f9138c = j2 & 2305843009213693951L;
        }
        long j4 = this.f9138c << 3;
        long j10 = this.f9139d;
        byte b10 = -128;
        while (true) {
            j(b10);
            if (this.f9137b == 0) {
                break;
            }
            b10 = 0;
        }
        if (this.f9149n > 14) {
            g();
        }
        long[] jArr = this.f9148m;
        jArr[14] = j10;
        jArr[15] = j4;
        g();
        m.B(i2, this.f9140e, bArr);
        m.B(i2 + 8, this.f9141f, bArr);
        m.B(i2 + 16, this.f9142g, bArr);
        m.B(i2 + 24, this.f9143h, bArr);
        m.B(i2 + 32, this.f9144i, bArr);
        m.B(i2 + 40, this.f9145j, bArr);
        m.B(i2 + 48, this.f9146k, bArr);
        m.B(i2 + 56, this.f9147l, bArr);
        i();
        return 64;
    }

    public final int f() {
        return 64;
    }

    public final void g() {
        long[] jArr;
        long j2 = this.f9138c;
        if (j2 > 2305843009213693951L) {
            this.f9139d += j2 >>> 61;
            this.f9138c = j2 & 2305843009213693951L;
        }
        int i2 = 16;
        while (true) {
            jArr = this.f9148m;
            if (i2 > 79) {
                break;
            }
            long j4 = jArr[i2 - 2];
            long j10 = ((j4 >>> 6) ^ (((j4 << 45) | (j4 >>> 19)) ^ ((j4 << 3) | (j4 >>> 61)))) + jArr[i2 - 7];
            long j11 = jArr[i2 - 15];
            jArr[i2] = j10 + ((((j11 >>> 8) | (j11 << 56)) ^ ((j11 << 63) | (j11 >>> 1))) ^ (j11 >>> 7)) + jArr[i2 - 16];
            i2++;
        }
        long j12 = this.f9140e;
        long j13 = this.f9141f;
        long j14 = this.f9142g;
        long j15 = this.f9143h;
        long j16 = this.f9144i;
        long j17 = this.f9145j;
        long j18 = this.f9146k;
        long j19 = j12;
        long j20 = j15;
        long j21 = j13;
        long j22 = j16;
        long j23 = j14;
        long j24 = j17;
        long j25 = this.f9147l;
        int i10 = 0;
        int i11 = 0;
        while (i10 < 10) {
            long jD = d(j22);
            long jA = a(j22, j24, j18);
            long j26 = j22;
            long j27 = j18;
            long j28 = j24;
            long[] jArr2 = f9135o;
            int i12 = i11 + 1;
            long j29 = jD + jA + jArr2[i11] + jArr[i11] + j25;
            long j30 = j20 + j29;
            long j31 = j21;
            long j32 = j23;
            long jC = c(j19) + b(j19, j31, j32) + j29;
            long jD2 = d(j30) + a(j30, j26, j28) + jArr2[i12];
            int i13 = i11 + 2;
            long j33 = jD2 + jArr[i12] + j27;
            long j34 = j32 + j33;
            long j35 = j19;
            long jC2 = c(jC) + b(jC, j35, j31) + j33;
            int i14 = i11 + 3;
            long jD3 = d(j34) + a(j34, j30, j26) + jArr2[i13] + jArr[i13] + j28;
            long j36 = j31 + jD3;
            long jC3 = c(jC2) + b(jC2, jC, j35) + jD3;
            int i15 = i11 + 4;
            long jD4 = d(j36) + a(j36, j34, j30) + jArr2[i14] + jArr[i14] + j26;
            long j37 = j35 + jD4;
            long jC4 = c(jC3) + b(jC3, jC2, jC) + jD4;
            int i16 = i11 + 5;
            long jD5 = d(j37) + a(j37, j36, j34) + jArr2[i15] + jArr[i15] + j30;
            long j38 = jC + jD5;
            long jC5 = c(jC4) + b(jC4, jC3, jC2) + jD5;
            int i17 = i11 + 6;
            long jD6 = d(j38) + a(j38, j37, j36) + jArr2[i16] + jArr[i16] + j34;
            long j39 = jC2 + jD6;
            long jC6 = c(jC5) + b(jC5, jC4, jC3) + jD6;
            int i18 = i11 + 7;
            long jD7 = d(j39) + a(j39, j38, j37) + jArr2[i17] + jArr[i17] + j36;
            long j40 = jC3 + jD7;
            long jC7 = c(jC6) + b(jC6, jC5, jC4) + jD7;
            i11 += 8;
            long jD8 = d(j40) + a(j40, j39, j38) + jArr2[i18] + jArr[i18] + j37;
            long j41 = jC4 + jD8;
            long jC8 = jD8 + c(jC7) + b(jC7, jC6, jC5);
            i10++;
            j24 = j40;
            j23 = jC6;
            j22 = j41;
            j25 = j38;
            j21 = jC7;
            j20 = jC5;
            j18 = j39;
            j19 = jC8;
        }
        this.f9140e += j19;
        this.f9141f += j21;
        this.f9142g += j23;
        this.f9143h += j20;
        this.f9144i += j22;
        this.f9145j += j24;
        this.f9146k += j18;
        this.f9147l += j25;
        this.f9149n = 0;
        for (int i19 = 0; i19 < 16; i19++) {
            jArr[i19] = 0;
        }
    }

    public final void h(int i2, byte[] bArr) {
        this.f9148m[this.f9149n] = (m.g(i2 + 4, bArr) & 4294967295L) | ((m.g(i2, bArr) & 4294967295L) << 32);
        int i10 = this.f9149n + 1;
        this.f9149n = i10;
        if (i10 == 16) {
            g();
        }
    }

    public final void i() {
        this.f9138c = 0L;
        this.f9139d = 0L;
        int i2 = 0;
        this.f9137b = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f9136a;
            if (i10 >= bArr.length) {
                break;
            }
            bArr[i10] = 0;
            i10++;
        }
        this.f9149n = 0;
        while (true) {
            long[] jArr = this.f9148m;
            if (i2 == jArr.length) {
                this.f9140e = 7640891576956012808L;
                this.f9141f = -4942790177534073029L;
                this.f9142g = 4354685564936845355L;
                this.f9143h = -6534734903238641935L;
                this.f9144i = 5840696475078001361L;
                this.f9145j = -7276294671716946913L;
                this.f9146k = 2270897969802886507L;
                this.f9147l = 6620516959819538809L;
                return;
            }
            jArr[i2] = 0;
            i2++;
        }
    }

    public final void j(byte b10) {
        int i2 = this.f9137b;
        int i10 = i2 + 1;
        this.f9137b = i10;
        byte[] bArr = this.f9136a;
        bArr[i2] = b10;
        if (i10 == bArr.length) {
            h(0, bArr);
            this.f9137b = 0;
        }
        this.f9138c++;
    }

    public final void k(byte[] bArr, int i2, int i10) {
        while (this.f9137b != 0 && i10 > 0) {
            j(bArr[i2]);
            i2++;
            i10--;
        }
        while (true) {
            byte[] bArr2 = this.f9136a;
            if (i10 < bArr2.length) {
                break;
            }
            h(i2, bArr);
            i2 += bArr2.length;
            i10 -= bArr2.length;
            this.f9138c += bArr2.length;
        }
        while (i10 > 0) {
            j(bArr[i2]);
            i2++;
            i10--;
        }
    }
}
