package bm3;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.tools.superkv.c f19585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f19586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f19591g;

    public final long b() throws IOException {
        if (this.f19589e != 2) goto L7;
        long r100 = this.f19587c;
        long r101 = r100 - this.f19586b;
        this.f19589e = 6;
        this.f19586b = r100;
        this.f19587c = this.f19591g;
        this.f19591g = -1;
        return r101;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f19589e);
    }

    public final void c() throws IOException {
        if (this.f19589e != 2) goto L11;
        int r100 = this.f19588d + 1;
        this.f19588d = r100;
        if (r100 > 65) goto L9;
        this.f19591g = -1;
        this.f19589e = 6;
        return;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final int d() throws IOException {
        this.f19586b++;
        byte r100 = this.f19585a.a();
        if (r100 < 0) goto L5;
        return r100;
    L5:
        int r101 = r100 & ByteCompanionObject.MAX_VALUE;
        this.f19586b++;
        byte r102 = this.f19585a.a();
        if (r102 < 0) goto L9;
        int r103 = r102 << 7;
    L26:
        return r101 | r103;
    L9:
        r101 = r101 | ((r102 & ByteCompanionObject.MAX_VALUE) << 7);
        this.f19586b++;
        byte r104 = this.f19585a.a();
        if (r104 < 0) goto L12;
        r103 = r104 << 14;
        goto L26
    L12:
        r101 = r101 | ((r104 & ByteCompanionObject.MAX_VALUE) << 14);
        this.f19586b++;
        byte r105 = this.f19585a.a();
        if (r105 < 0) goto L15;
        r103 = r105 << 21;
        goto L26
    L15:
        int r106 = r101 | ((r105 & ByteCompanionObject.MAX_VALUE) << 21);
        this.f19586b++;
        byte r107 = this.f19585a.a();
        int r108 = r106 | (r107 << 28);
        if (r107 >= 0) goto L29;
        int r109 = 0;
    L19:
        if (r109 >= 5) goto L25;
        this.f19586b++;
        if (this.f19585a.a() >= 0) goto L22;
        r109 = r109 + 1;
        goto L19
    L22:
        return r108;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L29:
        return r108;
    }

    public final int e() throws IOException {
        int r100 = this.f19589e;
        if (r100 != 7) goto L7;
        this.f19589e = 2;
        return this.f19590f;
    L7:
        if (r100 != 6) goto L57;
    L9:
        if (this.f19586b >= this.f19587c) goto L54;
        com.bytedance.android.tools.superkv.c r101 = this.f19585a;
        if ((r101.f187614b - r101.f187613a.position()) > 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L65;
        int r103 = d();
        if (r103 == 0) goto L53;
        int r104 = r103 >> 3;
        this.f19590f = r104;
        int r105 = r103 & 7;
        if (r105 == 0) goto L50;
        if (r105 == 1) goto L48;
        if (r105 == 2) goto L34;
        if (r105 != 3) goto L24;
        k(r104);
        goto L9
    L24:
        if (r105 == 4) goto L32;
        if (r105 != 5) goto L30;
        this.f19589e = 5;
        return r104;
    L30:
        throw new ProtocolException("Unexpected field encoding: " + r105);
    L32:
        throw new ProtocolException("Unexpected end group");
    L34:
        this.f19589e = 2;
        int r106 = d();
        if (r106 < 0) goto L47;
        if (this.f19591g != (-1)) goto L45;
        long r107 = this.f19587c;
        this.f19591g = r107;
        long r108 = this.f19586b + ((long) r106);
        this.f19587c = r108;
        if (r108 > r107) goto L43;
        return this.f19590f;
    L43:
        throw new EOFException();
    L45:
        throw new IllegalStateException();
    L47:
        throw new ProtocolException("Negative length: " + r106);
    L48:
        this.f19589e = 1;
        return r104;
    L50:
        this.f19589e = 0;
        return r104;
    L53:
        throw new ProtocolException("Unexpected tag 0");
    L65:
        return -1;
    L13:
        r102 = false;
        goto L14
    L54:
        return -1;
    L57:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public final int f() throws IOException {
        int r100 = this.f19589e;
        if (r100 == 5) goto L8;
        if (r100 == 2) goto L8;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f19589e);
    L8:
        this.f19586b += 4;
        com.bytedance.android.tools.superkv.c r101 = this.f19585a;
        r101.f187613a.get(r101.f187615c, 0, 4);
        byte[] r102 = r101.f187615c;
        int r103 = (r102[3] & UByte.MAX_VALUE) | (((r102[2] & UByte.MAX_VALUE) << 8) | (((r102[0] & UByte.MAX_VALUE) << 24) | ((r102[1] & UByte.MAX_VALUE) << 16)));
        a(5);
        return r103;
    }

    public final long g() throws IOException {
        int r100 = this.f19589e;
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L8;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f19589e);
    L8:
        this.f19586b += 8;
        com.bytedance.android.tools.superkv.c r101 = this.f19585a;
        r101.f187613a.get(r101.f187615c, 0, 8);
        byte[] r102 = r101.f187615c;
        long r103 = ((long) (r102[7] & UByte.MAX_VALUE)) | (((((((((long) (r102[0] & UByte.MAX_VALUE)) << 56) | (((long) (r102[1] & UByte.MAX_VALUE)) << 48)) | (((long) (r102[2] & UByte.MAX_VALUE)) << 40)) | (((long) (r102[3] & UByte.MAX_VALUE)) << 32)) | ((long) ((r102[4] & UByte.MAX_VALUE) << 24))) | ((long) ((r102[5] & UByte.MAX_VALUE) << 16))) | ((long) ((r102[6] & UByte.MAX_VALUE) << 8)));
        a(1);
        return r103;
    }

    public final int i() throws IOException {
        int r100 = this.f19589e;
        if (r100 != 0) goto L5;
    L9:
        int r101 = d();
        a(0);
        return r101;
    L5:
        if (r100 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f19589e);
    }

    public final long j() throws IOException {
        int r100 = this.f19589e;
        if (r100 != 0) goto L5;
    L9:
        long r101 = 0;
        int r102 = 0;
    L11:
        if (r102 >= 64) goto L18;
        this.f19586b++;
        byte r103 = this.f19585a.a();
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
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f19589e);
    }

    public c() {
        this.f19586b = 0;
        this.f19587c = Long.MAX_VALUE;
        this.f19589e = 2;
        this.f19590f = -1;
        this.f19591g = -1;
    }

    public final String h() throws IOException {
        long r100 = b();
        com.bytedance.android.tools.superkv.c r101 = this.f19585a;
        r101.getClass();
        if (r100 > 1024) goto L5;
        r101.f187613a.get(r101.f187615c, 0, (int) r100);
        byte[] r102 = r101.f187615c;
    L7:
        return new String(r102, 0, (int) r100, com.bytedance.android.tools.superkv.c.f187612d);
    L5:
        byte[] r103 = new byte[(int) r100];
        r101.f187613a.get(r103);
        r102 = r103;
        goto L7
    }

    public c(com.bytedance.android.tools.superkv.c r100) {
        this.f19586b = 0;
        this.f19587c = Long.MAX_VALUE;
        this.f19589e = 2;
        this.f19590f = -1;
        this.f19591g = -1;
        this.f19585a = r100;
    }

    public final void a(int r100) throws IOException {
        if (this.f19589e != r100) goto L5;
        this.f19589e = 6;
        return;
    L5:
        long r101 = this.f19586b;
        long r102 = this.f19587c;
        if (r101 > r102) goto L13;
        if (r101 != r102) goto L10;
        this.f19587c = this.f19591g;
        this.f19591g = -1;
        this.f19589e = 6;
        return;
    L10:
        this.f19589e = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.f19587c + " but was " + this.f19586b);
    }

    public final void k(int r100) throws IOException {
    L3:
        if (this.f19586b >= this.f19587c) goto L36;
        com.bytedance.android.tools.superkv.c r101 = this.f19585a;
        if ((r101.f187614b - r101.f187613a.position()) > 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L36;
        int r103 = d();
        if (r103 == 0) goto L34;
        int r104 = r103 >> 3;
        int r105 = r103 & 7;
        if (r105 != 0) goto L13;
        this.f19589e = 0;
        j();
        goto L3
    L13:
        if (r105 != 1) goto L15;
        this.f19589e = 1;
        g();
        goto L3
    L15:
        if (r105 != 2) goto L17;
        long r106 = d();
        this.f19586b += r106;
        ByteBuffer r107 = this.f19585a.f187613a;
        r107.position((int) (((long) r107.position()) + r106));
        goto L3
    L17:
        if (r105 != 3) goto L19;
        k(r104);
        goto L3
    L19:
        if (r105 == 4) goto L25;
        if (r105 != 5) goto L24;
        this.f19589e = 5;
        f();
        goto L3
    L24:
        throw new ProtocolException("Unexpected field encoding: " + r105);
    L25:
        if (r104 != r100) goto L28;
        return;
    L28:
        throw new ProtocolException("Unexpected end group");
    L34:
        throw new ProtocolException("Unexpected tag 0");
    L7:
        r102 = false;
    L36:
        throw new EOFException();
    }
}
