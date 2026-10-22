package com.bytedance.common.wschannel.channel.impl.ok.ws;

import c4.b;
import com.bytedance.common.utility.Logger;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public final class WebSocketReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferedSource f6981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameCallback f6982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Buffer f6988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Buffer f6989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final byte[] f6990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Buffer.UnsafeCursor f6991m;

    public interface FrameCallback {
        void onReadClose(int r10, String r11);

        void onReadMessage(String r10) throws IOException;

        void onReadMessage(ByteString r10) throws IOException;

        void onReadPing(ByteString r10);

        void onReadPong(ByteString r10);
    }

    public WebSocketReader(boolean r10, BufferedSource r11, FrameCallback r12, long r13) {
        this.f6988j = new Buffer();
        this.f6989k = new Buffer();
        if (r11 == null) goto L18;
        if (r12 == null) goto L16;
        this.f6980b = r10;
        this.f6981c = r11;
        this.f6982d = r12;
        this.f6979a = r13;
        Buffer.UnsafeCursor r14 = null;
        if (r10 == false) goto L8;
        byte[] r15 = null;
    L9:
        this.f6990l = r15;
        if (r10 == true) goto L13;
        r14 = new Buffer.UnsafeCursor();
    L13:
        this.f6991m = r14;
        return;
    L8:
        r15 = new byte[4];
        goto L9
    L16:
        throw new NullPointerException("frameCallback == null");
    L18:
        throw new NullPointerException("source == null");
    }

    public void a() {
        c();
        if (this.f6985g <= this.f6979a) goto L7;
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        g(this.f6985g);
        return;
    L7:
        if (this.f6987i == false) goto L9;
        b();
        return;
    L9:
        e();
    }

    public final void b() {
        long r10 = this.f6985g;
        if (r10 <= 0) goto L7;
        this.f6981c.readFully(this.f6988j, r10);
        if (this.f6980b == true) goto L7;
        this.f6988j.i(this.f6991m);
        this.f6991m.b(0);
        b.b(this.f6991m, this.f6990l);
        this.f6991m.close();
    L7:
        int r11 = this.f6984f;
        if (r11 != 9) goto L11;
        this.f6982d.onReadPing(this.f6988j.readByteString());
        return;
    L11:
        if (r11 != 10) goto L14;
        this.f6982d.onReadPong(this.f6988j.readByteString());
        return;
    L14:
        if (r11 != 8) goto L30;
        long r12 = this.f6988j.size();
        if (r12 == 1) goto L28;
        if (r12 == 0) goto L24;
        short r13 = this.f6988j.readShort();
        String r14 = this.f6988j.readUtf8();
        String r15 = b.a(r13);
        if (r15 != null) goto L23;
    L25:
        this.f6982d.onReadClose(r13, r14);
        this.f6983e = true;
        return;
    L23:
        throw new ProtocolException(r15);
    L24:
        r13 = 1005;
        r14 = "";
        goto L25
    L28:
        throw new ProtocolException("Malformed close payload length of 1.");
    L30:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f6984f));
    }

    public final void c() {
        if (this.f6983e == true) goto L72;
        long r10 = this.f6981c.timeout().timeoutNanos();
        this.f6981c.timeout().clearTimeout();
        byte r11 = this.f6981c.readByte();     // Catch: Throwable -> L68
        this.f6981c.timeout().timeout(r10, TimeUnit.NANOSECONDS);
        this.f6984f = r11 & Ascii.SI;
        boolean r12 = false;
        if ((r11 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) goto L9;
        boolean r13 = true;
    L10:
        this.f6986h = r13;
        if ((r11 & 8) == 0) goto L13;
        boolean r14 = true;
    L14:
        this.f6987i = r14;
        if (r14 == false) goto L21;
        if (r13 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r11 & SignedBytes.MAX_POWER_OF_TWO) == 0) goto L23;
        boolean r15 = true;
    L25:
        if ((r11 & 32) == 0) goto L27;
        boolean r16 = true;
    L29:
        if ((r11 & Ascii.DLE) == 0) goto L31;
        boolean r17 = true;
    L32:
        if (r15 == true) goto L67;
        if (r16 == true) goto L67;
        if (r17 == true) goto L67;
        byte r18 = this.f6981c.readByte();
        if ((r18 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) goto L39;
        r12 = true;
    L39:
        if (r12 == this.f6980b) goto L41;
        long r19 = r18 & Ascii.DEL;
        this.f6985g = r19;
        if (r19 != 126) goto L50;
        this.f6985g = ((long) this.f6981c.readShort()) & 65535;
    L57:
        if (this.f6987i == true) goto L59;
    L63:
        if (r12 == false) goto L75;
        this.f6981c.readFully(this.f6990l);
        return;
    L75:
        return;
    L59:
        if (this.f6985g <= 125) goto L63;
        throw new ProtocolException("Control frame must be less than 125B.");
    L50:
        if (r19 != 127) goto L57;
        long r20 = this.f6981c.readLong();
        this.f6985g = r20;
        if (r20 >= 0) goto L57;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f6985g) + " > 0x7FFFFFFFFFFFFFFF");
    L41:
        if (this.f6980b == false) goto L43;
        String r21 = "Server-sent frames must not be masked.";
    L45:
        throw new ProtocolException(r21);
    L43:
        r21 = "Client-sent frames must be masked.";
    L67:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r17 = false;
        goto L32
    L27:
        r16 = false;
        goto L29
    L23:
        r15 = false;
        goto L25
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
    L68:
        th = move-exception;
        this.f6981c.timeout().timeout(r10, TimeUnit.NANOSECONDS);
        throw th;
    L72:
        throw new IOException("closed");
    }

    public final void d() {
    L3:
        if (this.f6983e == true) goto L18;
        long r10 = this.f6985g;
        if (r10 <= 0) goto L10;
        this.f6981c.readFully(this.f6989k, r10);
        if (this.f6980b == true) goto L10;
        this.f6989k.i(this.f6991m);
        this.f6991m.b(this.f6989k.size() - this.f6985g);
        b.b(this.f6991m, this.f6990l);
        this.f6991m.close();
    L10:
        if (this.f6986h == true) goto L11;
        f();
        if (this.f6984f == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f6984f));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }

    public final void e() {
        int r10 = this.f6984f;
        if (r10 != 1) goto L5;
    L9:
        d();
        if (r10 != 1) goto L12;
        this.f6982d.onReadMessage(this.f6989k.readUtf8());
        return;
    L12:
        this.f6982d.onReadMessage(this.f6989k.readByteString());
        return;
    L5:
        if (r10 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r10));
    }

    public final void f() {
    L3:
        if (this.f6983e == true) goto L12;
        c();
        if (this.f6985g > this.f6979a) goto L6;
        if (this.f6987i == false) goto L16;
        b();
        goto L3
    L16:
        return;
    L6:
        Logger.d("WsChannelSdk_ok", "frame too large,skip");
        g(this.f6985g);
        return;
    }

    public final void g(long r10) {
        this.f6981c.skip(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
