package e;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f38730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f38731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f38732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f38733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f38734e;

    public l(aa r5) {
        aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r5, aa.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, DBHelper.BATTERY_COL_SOURCE);
        u r0 = new u(r6);
        this.f38731b = r0;
        Inflater r7 = new Inflater(true);
        this.f38732c = r7;
        this.f38733d = new m((g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin"), r7);
        this.f38734e = new CRC32();
    }

    @Override // e.aa
    public long a(e r12, long r13) {
        d.h.b.o.e(r12, "sink");
        if (r13 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L28;
        if (r13 != 0) goto L10;
        return 0;
    L10:
        if (this.f38730a != 0) goto L13;
        b();
        this.f38730a = 1;
    L13:
        if (this.f38730a != 1) goto L20;
        long r7 = r12.b();
        long r14 = this.f38733d.a(r12, r13);
        if (r14 == (-1)) goto L18;
        a(r12, r7, r14);
        return r14;
    L18:
        this.f38730a = 2;
    L20:
        if (this.f38730a != 2) goto L26;
        c();
        this.f38730a = 3;
        if (this.f38731b.h() == true) goto L26;
        throw new IOException("gzip finished without exhausting source");
    L26:
        return -1;
    L28:
        throw new IllegalArgumentException(("byteCount < 0: " + r13).toString());
    L5:
        r4 = false;
        goto L6
    }

    private final void b() {
        this.f38731b.b(10);
        byte r7 = this.f38731b.f38752b.c(3);
        boolean r8 = true;
        if (((r7 >> 1) & 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        a(this.f38731b.f38752b, 0, 10);
    L8:
        a("ID1ID2", 8075, this.f38731b.l());
        this.f38731b.h(8);
        if (((r7 >> 2) & 1) != 1) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L21;
        this.f38731b.b(2);
        if (r10 == false) goto L16;
        a(this.f38731b.f38752b, 0, 2);
    L16:
        long r11 = this.f38731b.f38752b.o() & 65535;
        this.f38731b.b(r11);
        if (r10 == false) goto L19;
        a(this.f38731b.f38752b, 0, r11);
    L19:
        this.f38731b.h(r11);
    L21:
        if (((r7 >> 3) & 1) != 1) goto L23;
        boolean r1 = true;
    L25:
        if (r1 == false) goto L34;
        long r15 = this.f38731b.a((byte) 0);
        if (r15 == (-1)) goto L32;
        if (r10 == false) goto L30;
        a(this.f38731b.f38752b, 0, r15 + 1);
    L30:
        this.f38731b.h(r15 + 1);
        goto L34
    L32:
        throw new EOFException();
    L34:
        if (((r7 >> 4) & 1) == 1) goto L37;
        r8 = false;
    L37:
        if (r8 == false) goto L45;
        long r9 = this.f38731b.a((byte) 0);
        if (r9 == (-1)) goto L44;
        if (r10 == false) goto L42;
        a(this.f38731b.f38752b, 0, r9 + 1);
    L42:
        this.f38731b.h(r9 + 1);
        goto L45
    L44:
        throw new EOFException();
    L45:
        if (r10 == false) goto L48;
        a("FHCRC", this.f38731b.b(), (short) this.f38734e.getValue());
        this.f38734e.reset();
        return;
    L48:
        return;
    L23:
        r1 = false;
        goto L25
    L11:
        r0 = false;
        goto L12
    L5:
        r10 = false;
        goto L6
    }

    private final void c() {
        a("CRC", this.f38731b.p(), (int) this.f38734e.getValue());
        a("ISIZE", this.f38731b.p(), (int) this.f38732c.getBytesWritten());
    }

    @Override // e.aa
    public ab a() {
        return this.f38731b.a();
    }

    @Override // e.aa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f38733d.close();
    }

    private final void a(e r5, long r6, long r8) {
        v r7 = r5.f38713a;
        d.h.b.o.a(r7);
    L4:
        if (r6 < (r7.f38758d - r7.f38757c)) goto L8;
        r6 = r6 - ((long) (r7.f38758d - r7.f38757c));
        r7 = r7.g;
        d.h.b.o.a(r7);
    L8:
        if (r8 <= 0) goto L10;
        int r9 = (int) (((long) r7.f38757c) + r6);
        int r10 = (int) Math.min(r7.f38758d - r9, r8);
        this.f38734e.update(r7.f38756b, r9, r10);
        r8 = r8 - ((long) r10);
        r7 = r7.g;
        d.h.b.o.a(r7);
        r6 = 0;
        goto L8
    }

    private final void a(String r4, int r5, int r6) {
        if (r6 != r5) goto L4;
        return;
    L4:
        String r7 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r4, Integer.valueOf(r6), Integer.valueOf(r5)}, 3));
        d.h.b.o.c(r7, "format(this, *args)");
        throw new IOException(r7);
    }
}
