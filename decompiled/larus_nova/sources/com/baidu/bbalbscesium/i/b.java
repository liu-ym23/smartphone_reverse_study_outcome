package com.baidu.bbalbscesium.i;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
public class b implements Serializable, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f30130d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f30131e = 64;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f30132f = 63;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f30133g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ObjectStreamField[] f30134h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f30135i = 7997698588986878753L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f30136j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f30137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient int f30138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient boolean f30139c;

    static {
        f30136j = true;
        f30134h = new ObjectStreamField[]{new ObjectStreamField("bits", long[].class)};
    }

    public b() {
        this.f30138b = 0;
        this.f30139c = false;
        f(64);
        this.f30139c = false;
    }

    public b(int r100) {
        this.f30138b = 0;
        this.f30139c = false;
        if (r100 < 0) goto L7;
        f(r100);
        this.f30139c = true;
        return;
    L7:
        throw new NegativeArraySizeException("nbits < 0: " + r100);
    }

    private b(long[] r100) {
        this.f30138b = 0;
        this.f30139c = false;
        this.f30137a = r100;
        this.f30138b = r100.length;
        b();
    }

    public static b a(ByteBuffer r110) {
        ByteBuffer r111 = r110.slice().order(ByteOrder.LITTLE_ENDIAN);
        int r100 = r111.remaining();
    L3:
        if (r100 <= 0) goto L7;
        if (r111.get(r100 - 1) != 0) goto L7;
        r100 = r100 - 1;
    L7:
        long[] r101 = new long[(r100 + 7) / 8];
        r111.limit(r100);
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r111.remaining() < 8) goto L11;
        r101[r103] = r111.getLong();
        r103 = r103 + 1;
        goto L9
    L11:
        int r104 = r111.remaining();
    L12:
        if (r102 >= r104) goto L15;
        r101[r103] = r101[r103] | ((((long) r111.get()) & 255) << (r102 * 8));
        r102 = r102 + 1;
        goto L12
    L15:
        return new b(r101);
    }

    public static b a(LongBuffer r100) {
        LongBuffer r101 = r100.slice();
        int r102 = r101.remaining();
    L3:
        if (r102 <= 0) goto L7;
        if (r101.get(r102 - 1) != 0) goto L7;
        r102 = r102 - 1;
    L7:
        long[] r103 = new long[r102];
        r101.get(r103);
        return new b(r103);
    }

    public static b a(byte[] r100) {
        return a(ByteBuffer.wrap(r100));
    }

    public static b a(long[] r100) {
        int r101 = r100.length;
    L3:
        if (r101 <= 0) goto L8;
        if (r100[r101 - 1] != 0) goto L8;
        r101 = r101 - 1;
    L8:
        return new b(Arrays.copyOf(r100, r101));
    }

    private static void a(int r100, int r101) {
        if (r100 < 0) goto L11;
        if (r101 < 0) goto L9;
        if (r100 > r101) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException("fromIndex: " + r100 + " > toIndex: " + r101);
    L9:
        throw new IndexOutOfBoundsException("toIndex < 0: " + r101);
    L11:
        throw new IndexOutOfBoundsException("fromIndex < 0: " + r100);
    }

    private void a(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        long[] r101 = (long[]) r100.readFields().get("bits", null);
        this.f30137a = r101;
        this.f30138b = r101.length;
        f();
        long[] r102 = this.f30137a;
        if (r102.length <= 0) goto L7;
        boolean r103 = true;
        if (r102[r102.length - 1] != 0) goto L7;
    L8:
        this.f30139c = r103;
        b();
        return;
    L7:
        r103 = false;
        goto L8
    }

    private void a(ObjectOutputStream r100) throws IOException {
        b();
        if (this.f30139c == true) goto L5;
        j();
    L5:
        r100.putFields().put("bits", this.f30137a);
        r100.writeFields();
    }

    private void b() {
        boolean r100 = f30136j;
        if (r100 == true) goto L11;
        int r101 = this.f30138b;
        if (r101 == 0) goto L11;
        if (this.f30137a[r101 - 1] != 0) goto L11;
        throw new AssertionError();
    L11:
        if (r100 == true) goto L19;
        int r102 = this.f30138b;
        if (r102 < 0) goto L18;
        if (r102 <= this.f30137a.length) goto L19;
    L18:
        throw new AssertionError();
    L19:
        if (r100 == true) goto L27;
        int r103 = this.f30138b;
        long[] r104 = this.f30137a;
        if (r103 != r104.length) goto L23;
        return;
    L23:
        if (r104[r103] != 0) goto L26;
        return;
    L26:
        throw new AssertionError();
    }

    private void b(int r100) {
        long[] r101 = this.f30137a;
        if (r101.length >= r100) goto L6;
        int r102 = Math.max(r101.length * 2, r100);
        this.f30137a = Arrays.copyOf(this.f30137a, r102);
        this.f30139c = false;
        return;
    }

    private void c(int r100) {
        int r101 = r100 + 1;
        if (this.f30138b >= r101) goto L6;
        b(r101);
        this.f30138b = r101;
        return;
    }

    private void f() {
        int r100 = this.f30138b - 1;
    L3:
        if (r100 < 0) goto L8;
        if (this.f30137a[r100] != 0) goto L8;
        r100 = r100 - 1;
    L8:
        this.f30138b = r100 + 1;
    }

    private void f(int r100) {
        this.f30137a = new long[l(r100 - 1) + 1];
    }

    private void j() {
        int r100 = this.f30138b;
        long[] r101 = this.f30137a;
        if (r100 == r101.length) goto L6;
        this.f30137a = Arrays.copyOf(r101, r100);
        b();
        return;
    }

    private static int l(int r100) {
        return r100 >> 6;
    }

    public int a() {
        int r100 = 0;
        int r101 = 0;
    L4:
        if (r100 >= this.f30138b) goto L6;
        r101 = r101 + Long.bitCount(this.f30137a[r100]);
        r100 = r100 + 1;
        goto L4
    L6:
        return r101;
    }

    public void a(int r100) {
        if (r100 < 0) goto L9;
        int r101 = l(r100);
        if (r101 < this.f30138b) goto L6;
        return;
    L6:
        long[] r102 = this.f30137a;
        r102[r101] = r102[r101] & (~(1 << r100));
        f();
        b();
        return;
    L9:
        throw new IndexOutOfBoundsException("bitIndex < 0: " + r100);
    }

    public void a(int r100, int r101, boolean r102) {
        if (r102 == false) goto L4;
        e(r100, r101);
        return;
    L4:
        b(r100, r101);
    }

    public void a(int r100, boolean r101) {
        if (r101 == false) goto L4;
        k(r100);
        return;
    L4:
        a(r100);
    }

    public void a(b r100) {
        if (this != r100) goto L4;
        return;
    L4:
        int r101 = this.f30138b;
        if (r101 <= r100.f30138b) goto L7;
        long[] r102 = this.f30137a;
        int r103 = r101 - 1;
        this.f30138b = r103;
        r102[r103] = 0;
        goto L4
    L7:
        int r104 = 0;
    L9:
        if (r104 >= this.f30138b) goto L11;
        long[] r105 = this.f30137a;
        r105[r104] = r105[r104] & r100.f30137a[r104];
        r104 = r104 + 1;
        goto L9
    L11:
        f();
        b();
    }

    public void b(int r100, int r110) {
        a(r100, r110);
        if (r100 != r110) goto L5;
        return;
    L5:
        int r101 = l(r100);
        if (r101 < this.f30138b) goto L8;
        return;
    L8:
        int r102 = l(r110 - 1);
        if (r102 < this.f30138b) goto L11;
        r110 = e();
        r102 = this.f30138b - 1;
    L11:
        long r103 = (-1) << r100;
        long r104 = (-1) >>> (-r110);
        if (r101 != r102) goto L14;
        long[] r105 = this.f30137a;
        r105[r101] = (~(r104 & r103)) & r105[r101];
    L19:
        f();
        b();
        return;
    L14:
        long[] r106 = this.f30137a;
        r106[r101] = (~r103) & r106[r101];
    L15:
        r101 = r101 + 1;
        if (r101 >= r102) goto L18;
        this.f30137a[r101] = 0;
        goto L15
    L18:
        long[] r107 = this.f30137a;
        r107[r102] = (~r104) & r107[r102];
        goto L19
    }

    public void b(b r100) {
        int r101 = Math.min(this.f30138b, r100.f30138b) - 1;
    L3:
        if (r101 < 0) goto L5;
        long[] r102 = this.f30137a;
        r102[r101] = r102[r101] & (~r100.f30137a[r101]);
        r101 = r101 - 1;
        goto L3
    L5:
        f();
        b();
    }

    public void c() {
    L2:
        int r100 = this.f30138b;
        if (r100 <= 0) goto L5;
        long[] r101 = this.f30137a;
        int r102 = r100 - 1;
        this.f30138b = r102;
        r101[r102] = 0;
        goto L2
    }

    public void c(int r100, int r110) {
        a(r100, r110);
        if (r100 != r110) goto L5;
        return;
    L5:
        int r101 = l(r100);
        int r102 = l(r110 - 1);
        c(r102);
        long r103 = (-1) << r100;
        long r104 = (-1) >>> (-r110);
        if (r101 != r102) goto L8;
        long[] r105 = this.f30137a;
        r105[r101] = (r104 & r103) ^ r105[r101];
    L13:
        f();
        b();
        return;
    L8:
        long[] r106 = this.f30137a;
        r106[r101] = r106[r101] ^ r103;
    L9:
        r101 = r101 + 1;
        if (r101 >= r102) goto L12;
        long[] r107 = this.f30137a;
        r107[r101] = ~r107[r101];
        goto L9
    L12:
        long[] r108 = this.f30137a;
        r108[r102] = r104 ^ r108[r102];
        goto L13
    }

    public boolean c(b r100) {
        int r101 = Math.min(this.f30138b, r100.f30138b) - 1;
    L3:
        if (r101 < 0) goto L8;
        if ((this.f30137a[r101] & r100.f30137a[r101]) != 0) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public Object clone() {
        if (this.f30139c == true) goto L9;
        j();
    L9:
        b r100 = (b) super.clone();     // Catch: CloneNotSupportedException -> L7
        r100.f30137a = (long[]) this.f30137a.clone();     // Catch: CloneNotSupportedException -> L7
        r100.b();     // Catch: CloneNotSupportedException -> L7
        return r100;
    L8:
        throw new InternalError();
    }

    public b d(int r110, int r111) {
        a(r110, r111);
        b();
        int r100 = e();
        int r101 = 0;
        if (r100 <= r110) goto L26;
        if (r110 == r111) goto L26;
        if (r111 <= r100) goto L8;
        r111 = r100;
    L8:
        int r102 = r111 - r110;
        b r103 = new b(r102);
        int r104 = l(r102 - 1) + 1;
        int r105 = l(r110);
        int r106 = r110 & 63;
        if (r106 != 0) goto L11;
        boolean r107 = true;
    L12:
        int r108 = r104 - 1;
        if (r101 >= r108) goto L19;
        long[] r109 = r103.f30137a;
        long[] r112 = this.f30137a;
        if (r107 == false) goto L17;
        long r113 = r112[r105];
    L18:
        r109[r101] = r113;
        r101 = r101 + 1;
        r105 = r105 + 1;
        goto L12
    L17:
        r113 = (r112[r105] >>> r110) | (r112[r105 + 1] << (-r110));
        goto L18
    L19:
        long r114 = (-1) >>> (-r111);
        long[] r115 = r103.f30137a;
        if (((r111 - 1) & 63) >= r106) goto L22;
        long[] r116 = this.f30137a;
        long r117 = ((r116[r105 + 1] & r114) << (-r110)) | (r116[r105] >>> r110);
    L23:
        r115[r108] = r117;
        r103.f30138b = r104;
        r103.f();
        r103.b();
        return r103;
    L22:
        r117 = (this.f30137a[r105] & r114) >>> r110;
        goto L23
    L11:
        r107 = false;
    L26:
        return new b(0);
    }

    public void d(int r100) {
        if (r100 < 0) goto L6;
        int r101 = l(r100);
        c(r101);
        long[] r102 = this.f30137a;
        r102[r101] = r102[r101] ^ (1 << r100);
        f();
        b();
        return;
    L6:
        throw new IndexOutOfBoundsException("bitIndex < 0: " + r100);
    }

    public void d(b r100) {
        if (this != r100) goto L4;
        return;
    L4:
        int r101 = Math.min(this.f30138b, r100.f30138b);
        int r102 = this.f30138b;
        int r103 = r100.f30138b;
        if (r102 >= r103) goto L7;
        b(r103);
        this.f30138b = r100.f30138b;
    L7:
        int r104 = 0;
    L8:
        if (r104 >= r101) goto L11;
        long[] r105 = this.f30137a;
        r105[r104] = r105[r104] | r100.f30137a[r104];
        r104 = r104 + 1;
        goto L8
    L11:
        if (r101 >= r100.f30138b) goto L13;
        System.arraycopy(r100.f30137a, r101, this.f30137a, r101, this.f30138b - r101);
    L13:
        b();
    }

    public boolean d() {
        if (this.f30138b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int e() {
        int r100 = this.f30138b;
        if (r100 != 0) goto L6;
        return 0;
    L6:
        int r101 = r100 - 1;
        return (r101 * 64) + (64 - Long.numberOfLeadingZeros(this.f30137a[r101]));
    }

    public void e(int r110, int r111) {
        a(r110, r111);
        if (r110 != r111) goto L5;
        return;
    L5:
        int r100 = l(r110);
        int r101 = l(r111 - 1);
        c(r101);
        long r102 = (-1) << r110;
        long r112 = (-1) >>> (-r111);
        if (r100 != r101) goto L8;
        long[] r103 = this.f30137a;
        r103[r100] = (r112 & r102) | r103[r100];
    L13:
        b();
        return;
    L8:
        long[] r104 = this.f30137a;
        r104[r100] = r102 | r104[r100];
    L9:
        r100 = r100 + 1;
        if (r100 >= r101) goto L12;
        this.f30137a[r100] = -1;
        goto L9
    L12:
        long[] r105 = this.f30137a;
        r105[r101] = r112 | r105[r101];
        goto L13
    }

    public void e(b r100) {
        int r101 = Math.min(this.f30138b, r100.f30138b);
        int r102 = this.f30138b;
        int r103 = r100.f30138b;
        if (r102 >= r103) goto L5;
        b(r103);
        this.f30138b = r100.f30138b;
    L5:
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L8;
        long[] r105 = this.f30137a;
        r105[r104] = r105[r104] ^ r100.f30137a[r104];
        r104 = r104 + 1;
        goto L6
    L8:
        int r106 = r100.f30138b;
        if (r101 >= r106) goto L11;
        System.arraycopy(r100.f30137a, r101, this.f30137a, r101, r106 - r101);
    L11:
        f();
        b();
    }

    public boolean e(int r100) {
        if (r100 < 0) goto L11;
        b();
        int r101 = l(r100);
        if (r101 < this.f30138b) goto L6;
    L8:
        return false;
    L6:
        if ((this.f30137a[r101] & (1 << r100)) == 0) goto L8;
        return true;
    L11:
        throw new IndexOutOfBoundsException("bitIndex < 0: " + r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (this != r100) goto L8;
        return true;
    L8:
        b r101 = (b) r100;
        b();
        r101.b();
        if (this.f30138b == r101.f30138b) goto L11;
        return false;
    L11:
        int r102 = 0;
    L13:
        if (r102 >= this.f30138b) goto L18;
        if (this.f30137a[r102] != r101.f30137a[r102]) goto L16;
        r102 = r102 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public int g() {
        return this.f30137a.length * 64;
    }

    public int g(int r100) {
        if (r100 < 0) goto L17;
        b();
        int r101 = l(r100);
        if (r101 < this.f30138b) goto L6;
        return r100;
    L6:
        long r102 = (~this.f30137a[r101]) & ((-1) << r100);
    L8:
        if (r102 != 0) goto L10;
        r101 = r101 + 1;
        int r103 = this.f30138b;
        if (r101 == r103) goto L14;
        r102 = ~this.f30137a[r101];
        goto L8
    L14:
        return r103 * 64;
    L10:
        return (r101 * 64) + Long.numberOfTrailingZeros(r102);
    L17:
        throw new IndexOutOfBoundsException("fromIndex < 0: " + r100);
    }

    public int h(int r100) {
        if (r100 < 0) goto L16;
        b();
        int r101 = l(r100);
        if (r101 < this.f30138b) goto L6;
        return -1;
    L6:
        long r102 = this.f30137a[r101] & ((-1) << r100);
    L8:
        if (r102 != 0) goto L10;
        r101 = r101 + 1;
        if (r101 == this.f30138b) goto L13;
        r102 = this.f30137a[r101];
        goto L8
    L13:
        return -1;
    L10:
        return (r101 * 64) + Long.numberOfTrailingZeros(r102);
    L16:
        throw new IndexOutOfBoundsException("fromIndex < 0: " + r100);
    }

    public byte[] h() {
        int r100 = this.f30138b;
        int r101 = 0;
        if (r100 == 0) goto L5;
        int r102 = r100 - 1;
        int r103 = r102 * 8;
        long r104 = this.f30137a[r102];
    L8:
        if (r104 == 0) goto L10;
        r103 = r103 + 1;
        r104 = r104 >>> 8;
        goto L8
    L10:
        byte[] r105 = new byte[r103];
        ByteBuffer r106 = ByteBuffer.wrap(r105).order(ByteOrder.LITTLE_ENDIAN);
    L11:
        if (r101 >= r102) goto L13;
        r106.putLong(this.f30137a[r101]);
        r101 = r101 + 1;
        goto L11
    L13:
        long r107 = this.f30137a[r102];
    L15:
        if (r107 == 0) goto L17;
        r106.put((byte) (255 & r107));
        r107 = r107 >>> 8;
        goto L15
    L17:
        return r105;
    L5:
        return new byte[0];
    }

    public int hashCode() {
        int r100 = this.f30138b;
        long r101 = 1234;
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L7;
        r101 = r101 ^ (this.f30137a[r100] * ((long) (r100 + 1)));
        goto L3
    L7:
        return (int) ((r101 >> 32) ^ r101);
    }

    public int i(int r100) {
        if (r100 >= 0) goto L8;
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        throw new IndexOutOfBoundsException("fromIndex < -1: " + r100);
    L8:
        b();
        int r101 = l(r100);
        if (r101 < this.f30138b) goto L11;
        return r100;
    L11:
        long r102 = (~this.f30137a[r101]) & ((-1) >>> (-(r100 + 1)));
    L13:
        if (r102 != 0) goto L15;
        int r103 = r101 - 1;
        if (r101 == 0) goto L18;
        r102 = ~this.f30137a[r103];
        r101 = r103;
        goto L13
    L18:
        return -1;
    L15:
        return (((r101 + 1) * 64) - 1) - Long.numberOfLeadingZeros(r102);
    }

    public long[] i() {
        return Arrays.copyOf(this.f30137a, this.f30138b);
    }

    public int j(int r100) {
        if (r100 >= 0) goto L8;
        if (r100 != (-1)) goto L7;
        return -1;
    L7:
        throw new IndexOutOfBoundsException("fromIndex < -1: " + r100);
    L8:
        b();
        int r101 = l(r100);
        if (r101 >= this.f30138b) goto L11;
        long r102 = this.f30137a[r101] & ((-1) >>> (-(r100 + 1)));
    L14:
        if (r102 != 0) goto L16;
        int r103 = r101 - 1;
        if (r101 == 0) goto L19;
        r102 = this.f30137a[r103];
        r101 = r103;
        goto L14
    L19:
        return -1;
    L16:
        return (((r101 + 1) * 64) - 1) - Long.numberOfLeadingZeros(r102);
    L11:
        return e() - 1;
    }

    public void k(int r100) {
        if (r100 < 0) goto L6;
        int r101 = l(r100);
        c(r101);
        long[] r102 = this.f30137a;
        r102[r101] = r102[r101] | (1 << r100);
        b();
        return;
    L6:
        throw new IndexOutOfBoundsException("bitIndex < 0: " + r100);
    }

    public String toString() {
        b();
        int r100 = this.f30138b;
        if (r100 <= 128) goto L5;
        int r101 = a();
    L6:
        StringBuilder r102 = new StringBuilder((r101 * 6) + 2);
        r102.append('{');
        int r103 = h(0);
        if (r103 == (-1)) goto L15;
        r102.append(r103);
    L9:
        r103 = h(r103 + 1);
        if (r103 < 0) goto L15;
        int r104 = g(r103);
    L12:
        r102.append(", ");
        r102.append(r103);
        r103 = r103 + 1;
        if (r103 < r104) goto L12;
    L15:
        r102.append('}');
        return r102.toString();
    L5:
        r101 = r100 * 64;
        goto L6
    }
}
