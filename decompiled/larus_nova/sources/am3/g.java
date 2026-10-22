package am3;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f4367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4375j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f4376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f4377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4379d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f4380e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f4381f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f4382g;

        public final int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.f4376a), Long.valueOf(this.f4377b), Integer.valueOf(this.f4378c), Integer.valueOf(this.f4379d), Integer.valueOf(this.f4380e), Long.valueOf(this.f4381f), Integer.valueOf(this.f4382g)});
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f4376a == r101.f4376a) goto L11;
        L23:
            return false;
        L11:
            if (this.f4377b != r101.f4377b) goto L23;
            if (this.f4378c != r101.f4378c) goto L23;
            if (this.f4379d != r101.f4379d) goto L23;
            if (this.f4380e != r101.f4380e) goto L23;
            if (this.f4381f != r101.f4381f) goto L23;
            if (this.f4382g != r101.f4382g) goto L23;
            return true;
        }

        public a(long r100, long r101, int r102, int r103, int r104, long r105, int r110) {
            this.f4376a = r100;
            this.f4377b = r101;
            this.f4378c = r102;
            this.f4379d = r103;
            this.f4380e = r104;
            this.f4381f = r105;
            this.f4382g = r110;
        }
    }

    public final long b() throws IOException {
        if (this.f4371f != 2) goto L7;
        long r100 = this.f4369d;
        long r101 = r100 - this.f4368c;
        this.f4371f = 6;
        this.f4368c = r100;
        this.f4369d = this.f4373h;
        this.f4373h = -1;
        return r101;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f4371f);
    }

    public final long c() throws IOException {
        if (this.f4371f != 2) goto L11;
        int r100 = this.f4370e + 1;
        this.f4370e = r100;
        if (r100 > 65) goto L9;
        long r101 = this.f4373h;
        this.f4373h = -1;
        this.f4371f = 6;
        return r101;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final int e() throws IOException {
        this.f4368c++;
        byte r100 = this.f4367b.readByte();
        if (r100 < 0) goto L5;
        return r100;
    L5:
        int r101 = r100 & ByteCompanionObject.MAX_VALUE;
        this.f4368c++;
        byte r102 = this.f4367b.readByte();
        if (r102 < 0) goto L9;
        int r103 = r102 << 7;
    L26:
        return r101 | r103;
    L9:
        r101 = r101 | ((r102 & ByteCompanionObject.MAX_VALUE) << 7);
        this.f4368c++;
        byte r104 = this.f4367b.readByte();
        if (r104 < 0) goto L12;
        r103 = r104 << 14;
        goto L26
    L12:
        r101 = r101 | ((r104 & ByteCompanionObject.MAX_VALUE) << 14);
        this.f4368c++;
        byte r105 = this.f4367b.readByte();
        if (r105 < 0) goto L15;
        r103 = r105 << 21;
        goto L26
    L15:
        int r106 = r101 | ((r105 & ByteCompanionObject.MAX_VALUE) << 21);
        this.f4368c++;
        byte r107 = this.f4367b.readByte();
        int r108 = r106 | (r107 << 28);
        if (r107 >= 0) goto L29;
        int r109 = 0;
    L19:
        if (r109 >= 5) goto L25;
        this.f4368c++;
        if (this.f4367b.readByte() >= 0) goto L22;
        r109 = r109 + 1;
        goto L19
    L22:
        return r108;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L29:
        return r108;
    }

    public final int f() throws IOException {
        int r100 = this.f4371f;
        if (r100 != 7) goto L7;
        this.f4371f = 2;
        return this.f4372g;
    L7:
        if (r100 != 6) goto L55;
    L9:
        if (this.f4368c >= this.f4369d) goto L52;
        if (this.f4367b.d() == false) goto L63;
        int r101 = e();
        if (r101 == 0) goto L51;
        int r102 = r101 >> 3;
        this.f4372g = r102;
        int r103 = r101 & 7;
        if (r103 == 0) goto L48;
        if (r103 == 1) goto L46;
        if (r103 == 2) goto L32;
        if (r103 != 3) goto L22;
        m(r102);
        goto L9
    L22:
        if (r103 == 4) goto L30;
        if (r103 != 5) goto L28;
        this.f4374i = 5;
        this.f4371f = 5;
        return r102;
    L28:
        throw new ProtocolException("Unexpected field encoding: " + r103);
    L30:
        throw new ProtocolException("Unexpected end group");
    L32:
        this.f4374i = 2;
        this.f4371f = 2;
        int r104 = e();
        if (r104 < 0) goto L45;
        if (this.f4373h != (-1)) goto L43;
        long r105 = this.f4369d;
        this.f4373h = r105;
        long r106 = this.f4368c + ((long) r104);
        this.f4369d = r106;
        if (r106 > r105) goto L41;
        return this.f4372g;
    L41:
        throw new EOFException();
    L43:
        throw new IllegalStateException();
    L45:
        throw new ProtocolException("Negative length: " + r104);
    L46:
        this.f4374i = 1;
        this.f4371f = 1;
        return r102;
    L48:
        this.f4374i = 0;
        this.f4371f = 0;
        return r102;
    L51:
        throw new ProtocolException("Unexpected tag 0");
    L63:
        return -1;
    L52:
        return -1;
    L55:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public final int g() throws IOException {
        int r100 = this.f4371f;
        if (r100 != 5) goto L5;
    L9:
        this.f4368c += 4;
        int r101 = this.f4367b.readIntLe();
        a(5);
        return r101;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f4371f);
    }

    public final long h() throws IOException {
        int r100 = this.f4371f;
        if (r100 != 1) goto L5;
    L9:
        this.f4368c += 8;
        long r101 = this.f4367b.readLongLe();
        a(1);
        return r101;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f4371f);
    }

    public final int i() throws IOException {
        int r100 = this.f4371f;
        if (r100 != 0) goto L5;
    L9:
        int r101 = e();
        a(0);
        return r101;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f4371f);
    }

    public final long j() throws IOException {
        int r100 = this.f4371f;
        if (r100 != 0) goto L5;
    L9:
        long r101 = 0;
        int r102 = 0;
    L11:
        if (r102 >= 64) goto L18;
        this.f4368c++;
        byte r103 = this.f4367b.readByte();
        r101 = r101 | (((long) (r103 & ByteCompanionObject.MAX_VALUE)) << r102);
        if ((r103 & ByteCompanionObject.MIN_VALUE) == 0) goto L14;
        r102 = r102 + 7;
        goto L11
    L14:
        a(0);
        return r101;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f4371f);
    }

    public g() {
        this.f4368c = 0;
        this.f4369d = Long.MAX_VALUE;
        this.f4371f = 2;
        this.f4372g = -1;
        this.f4373h = -1;
        this.f4374i = -1;
        this.f4375j = false;
        this.f4366a = null;
    }

    public g(g r110) {
        this.f4368c = 0;
        this.f4369d = Long.MAX_VALUE;
        this.f4371f = 2;
        this.f4372g = -1;
        this.f4373h = -1;
        this.f4374i = -1;
        this.f4375j = false;
        this.f4368c = r110.f4368c;
        this.f4369d = r110.f4369d;
        this.f4370e = r110.f4370e;
        this.f4371f = r110.f4371f;
        this.f4372g = r110.f4372g;
        this.f4373h = r110.f4373h;
        this.f4374i = r110.f4374i;
        this.f4375j = true;
        this.f4367b = r110.f4367b.b();
        this.f4366a = new a(this.f4368c, this.f4369d, this.f4370e, this.f4371f, this.f4372g, this.f4373h, this.f4374i);
    }

    public final void a(int r100) throws IOException {
        if (this.f4371f != r100) goto L5;
        this.f4371f = 6;
        return;
    L5:
        long r101 = this.f4368c;
        long r102 = this.f4369d;
        if (r101 > r102) goto L13;
        if (r101 != r102) goto L10;
        this.f4369d = this.f4373h;
        this.f4373h = -1;
        this.f4371f = 6;
        return;
    L10:
        this.f4371f = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.f4369d + " but was " + this.f4368c);
    }

    public final void d(long r100) throws IOException {
        if (this.f4371f != 6) goto L19;
        int r101 = this.f4370e - 1;
        this.f4370e = r101;
        if (r101 < 0) goto L17;
        if (this.f4373h != (-1)) goto L17;
        if (this.f4368c == this.f4369d) goto L14;
        if (r101 == 0) goto L14;
        throw new IOException("Expected to end at " + this.f4369d + " but was " + this.f4368c);
    L14:
        this.f4369d = r100;
        return;
    L17:
        throw new IllegalStateException("No corresponding call to beginMessage()");
    L19:
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public final void k(e r100) {
        l(r100, Long.MAX_VALUE);
    }

    public final void m(int r100) throws IOException {
    L3:
        if (this.f4368c >= this.f4369d) goto L34;
        if (this.f4367b.d() == false) goto L34;
        int r101 = e();
        if (r101 == 0) goto L32;
        int r102 = r101 >> 3;
        int r103 = r101 & 7;
        if (r103 != 0) goto L11;
        this.f4371f = 0;
        j();
        goto L3
    L11:
        if (r103 != 1) goto L13;
        this.f4371f = 1;
        h();
        goto L3
    L13:
        if (r103 != 2) goto L15;
        long r104 = e();
        this.f4368c += r104;
        this.f4367b.skip(r104);
        goto L3
    L15:
        if (r103 != 3) goto L17;
        m(r102);
        goto L3
    L17:
        if (r103 == 4) goto L23;
        if (r103 != 5) goto L22;
        this.f4371f = 5;
        g();
        goto L3
    L22:
        throw new ProtocolException("Unexpected field encoding: " + r103);
    L23:
        if (r102 != r100) goto L26;
        return;
    L26:
        throw new ProtocolException("Unexpected end group");
    L32:
        throw new ProtocolException("Unexpected tag 0");
    L34:
        throw new EOFException();
    }

    public final void l(e r100, long r101) {
        this.f4367b = r100;
        this.f4368c = 0;
        this.f4369d = r101;
        this.f4370e = 0;
        this.f4371f = 2;
        this.f4372g = -1;
        this.f4373h = r101;
        this.f4374i = -1;
    }
}
