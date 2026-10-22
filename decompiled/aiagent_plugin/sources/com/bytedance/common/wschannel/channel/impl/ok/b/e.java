package com.bytedance.common.wschannel.channel.impl.ok.b;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.g;
import e.h;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: WebSocketReader.java */
/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f6845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g f6846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a f6847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f6848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f6849e;
    long f;
    boolean g;
    boolean h;
    private final long i;
    private final e.e j;
    private final e.e k;
    private final byte[] l;
    private final e.e.a m;

    /* JADX INFO: compiled from: WebSocketReader.java */
    public interface a {
        void a(int r1, String r2);

        void a(h r1);

        void a(String r1);

        void b(h r1);

        void c(h r1);
    }

    e(boolean r3, g r4, a r5, long r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        this.j = new e.e();
        this.k = new e.e();
        Objects.requireNonNull(r7, "source == null");
        Objects.requireNonNull(r8, "frameCallback == null");
        this.f6845a = r3;
        this.f6846b = r7;
        this.f6847c = r8;
        this.i = r6;
        e.e.a r9 = null;
        if (r3 == false) goto L5;
        byte[] r10 = null;
    L6:
        this.l = r10;
        if (r3 == true) goto L10;
        r9 = new e.e.a();
    L10:
        this.m = r9;
        return;
    L5:
        r10 = new byte[4];
        goto L6
    }

    void a() {
        b();
        if (this.f <= this.i) goto L7;
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        a(this.f);
        return;
    L7:
        if (this.h == false) goto L9;
        c();
        return;
    L9:
        d();
    }

    private void a(long r1) {
        this.f6846b.h(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void b() {
        if (this.f6848d == true) goto L73;
        long r0 = this.f6846b.a().y_();
        this.f6846b.a().v_();
        int r2 = this.f6846b.k() & 255;
        this.f6846b.a().a(r0, TimeUnit.NANOSECONDS);
        this.f6849e = r2 & 15;
        boolean r1 = true;
        if ((r2 & 128) == 0) goto L9;
        boolean r3 = true;
    L10:
        this.g = r3;
        if ((r2 & 8) == 0) goto L13;
        boolean r4 = true;
    L14:
        this.h = r4;
        if (r4 == false) goto L21;
        if (r3 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r2 & 64) == 0) goto L23;
        boolean r5 = true;
    L25:
        if ((r2 & 32) == 0) goto L27;
        boolean r6 = true;
    L29:
        if ((r2 & 16) == 0) goto L31;
        boolean r7 = true;
    L32:
        if (r5 == true) goto L68;
        if (r6 == true) goto L68;
        if (r7 == true) goto L68;
        int r8 = this.f6846b.k() & 255;
        if ((r8 & 128) != 0) goto L40;
        r1 = false;
    L40:
        if (r1 == this.f6845a) goto L42;
        long r9 = r8 & 127;
        this.f = r9;
        if (r9 != 126) goto L51;
        this.f = ((long) this.f6846b.l()) & 65535;
    L58:
        if (this.h == true) goto L60;
    L64:
        if (r1 == false) goto L76;
        this.f6846b.a(this.l);
        return;
    L76:
        return;
    L60:
        if (this.f <= 125) goto L64;
        throw new ProtocolException("Control frame must be less than 125B.");
    L51:
        if (r9 != 127) goto L58;
        long r10 = this.f6846b.n();
        this.f = r10;
        if (r10 >= 0) goto L58;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
    L42:
        if (this.f6845a == false) goto L44;
        String r11 = "Server-sent frames must not be masked.";
    L46:
        throw new ProtocolException(r11);
    L44:
        r11 = "Client-sent frames must be masked.";
    L68:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r7 = false;
        goto L32
    L27:
        r6 = false;
        goto L29
    L23:
        r5 = false;
        goto L25
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
    L69:
        th = move-exception;
        this.f6846b.a().a(r0, TimeUnit.NANOSECONDS);
        throw th;
    L73:
        throw new IOException("closed");
    }

    private void c() {
        long r0 = this.f;
        if (r0 <= 0) goto L7;
        this.f6846b.b(this.j, r0);
        if (this.f6845a == true) goto L7;
        this.j.a(this.m);
        this.m.a(0);
        d.a(this.m, this.l);
        this.m.close();
    L7:
        int r1 = this.f6849e;
        if (r1 != 9) goto L11;
        this.f6847c.b(this.j.t());
        return;
    L11:
        if (r1 != 10) goto L14;
        this.f6847c.c(this.j.t());
        return;
    L14:
        if (r1 != 8) goto L30;
        short r2 = 1005;
        long r4 = this.j.b();
        if (r4 == 1) goto L28;
        if (r4 == 0) goto L24;
        r2 = this.j.l();
        String r3 = this.j.u();
        String r5 = d.a(r2);
        if (r5 != null) goto L23;
    L25:
        this.f6847c.a(r2, r3);
        this.f6848d = true;
        return;
    L23:
        throw new ProtocolException(r5);
    L24:
        r3 = "";
        goto L25
    L28:
        throw new ProtocolException("Malformed close payload length of 1.");
    L30:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f6849e));
    }

    private void d() {
        int r0 = this.f6849e;
        if (r0 != 1) goto L5;
    L9:
        f();
        if (r0 != 1) goto L12;
        this.f6847c.a(this.k.u());
        return;
    L12:
        this.f6847c.a(this.k.t());
        return;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r0));
    }

    private void e() {
    L3:
        if (this.f6848d == true) goto L12;
        b();
        if (this.f > this.i) goto L6;
        if (this.h == false) goto L16;
        c();
        goto L3
    L16:
        return;
    L6:
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        a(this.f);
        return;
    }

    private void f() {
    L3:
        if (this.f6848d == true) goto L18;
        long r0 = this.f;
        if (r0 <= 0) goto L10;
        this.f6846b.b(this.k, r0);
        if (this.f6845a == true) goto L10;
        this.k.a(this.m);
        this.m.a(this.k.b() - this.f);
        d.a(this.m, this.l);
        this.m.close();
    L10:
        if (this.g == true) goto L11;
        e();
        if (this.f6849e == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f6849e));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }
}
