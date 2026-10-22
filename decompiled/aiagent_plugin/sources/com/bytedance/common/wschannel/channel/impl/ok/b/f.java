package com.bytedance.common.wschannel.channel.impl.ok.b;

import android.support.v4.media.session.PlaybackStateCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.ab;
import e.h;
import e.y;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: compiled from: WebSocketWriter.java */
/* JADX INFO: loaded from: classes.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f6850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Random f6851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final e.f f6852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final e.e f6853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f6854e;
    final e.e f;
    final a g;
    boolean h;
    private final byte[] i;
    private final e.e.a j;

    /* JADX INFO: compiled from: WebSocketWriter.java */
    final class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f6855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f6856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f6857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f6858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f6859e;

        a(f r1) {
            this.f6859e = r1;
        }

        @Override // e.y
        public void a_(e.e r7, long r8) {
            if (this.f6858d == true) goto L18;
            this.f6859e.f.a_(r7, r8);
            if (this.f6857c == true) goto L7;
        L11:
            boolean r9 = false;
        L12:
            long r2 = this.f6859e.f.j();
            if (r2 <= 0) goto L19;
            if (r9 == true) goto L20;
            this.f6859e.a(this.f6855a, r2, this.f6857c, false);
            this.f6857c = false;
            return;
        L20:
            return;
        L19:
            return;
        L7:
            if (this.f6856b == (-1)) goto L11;
            if (this.f6859e.f.b() <= (this.f6856b - PlaybackStateCompat.ACTION_PLAY_FROM_URI)) goto L11;
            r9 = true;
            goto L12
        L18:
            throw new IOException("closed");
        }

        @Override // e.y, java.io.Flushable
        public void flush() {
            if (this.f6858d == true) goto L7;
            f r1 = this.f6859e;
            r1.a(this.f6855a, r1.f.b(), this.f6857c, false);
            this.f6857c = false;
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // e.y
        public ab a() {
            return this.f6859e.f6852c.a();
        }

        @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f6858d == true) goto L7;
            f r1 = this.f6859e;
            r1.a(this.f6855a, r1.f.b(), this.f6857c, true);
            this.f6858d = true;
            this.f6859e.h = false;
            return;
        L7:
            throw new IOException("closed");
        }
    }

    f(boolean r3, e.f r4, Random r5) {
        e.f r6 = (e.f) ZeusTransformUtils.wrapperContextForParams(r4, e.f.class, "com.obric.aiagent.plugin");
        this.f = new e.e();
        this.g = new a(this);
        Objects.requireNonNull(r6, "sink == null");
        Objects.requireNonNull(r5, "random == null");
        this.f6850a = r3;
        this.f6852c = r6;
        this.f6853d = r6.c();
        this.f6851b = r5;
        e.e.a r7 = null;
        if (r3 == false) goto L5;
        byte[] r8 = new byte[4];
    L6:
        this.i = r8;
        if (r3 == false) goto L9;
        r7 = new e.e.a();
    L9:
        this.j = r7;
        return;
    L5:
        r8 = null;
        goto L6
    }

    void a(h r2) {
        b(9, r2);
    }

    void b(h r2) {
        b(10, r2);
    }

    void a(int r2, h r3) {
        h r0 = h.f38723b;
        if (r2 != 0) goto L5;
        if (r3 != null) goto L5;
    L18:
        b(8, r0);     // Catch: Throwable -> L15
        this.f6854e = true;
        return;
    L15:
        th = move-exception;
        this.f6854e = true;
        throw th;
    L5:
        if (r2 == 0) goto L7;
        d.b(r2);
    L7:
        e.e r1 = new e.e();
        r1.c(r2);
        if (r3 == null) goto L10;
        r1.a(r3);
    L10:
        r0 = r1.t();
        goto L18
    }

    private void b(int r6, h r7) {
        if (this.f6854e == true) goto L17;
        int r0 = r7.k();
        if (r0 > 125) goto L15;
        this.f6853d.b(r6 | 128);
        if (this.f6850a == false) goto L11;
        this.f6853d.b(r0 | 128);
        this.f6851b.nextBytes(this.i);
        this.f6853d.b(this.i);
        if (r0 <= 0) goto L12;
        long r1 = this.f6853d.b();
        this.f6853d.a(r7);
        this.f6853d.a(this.j);
        this.j.a(r1);
        d.a(this.j, this.i);
        this.j.close();
    L12:
        this.f6852c.flush();
        return;
    L11:
        this.f6853d.b(r0);
        this.f6853d.a(r7);
        goto L12
    L15:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
    L17:
        throw new IOException("closed");
    }

    y a(int r3, long r4) {
        if (this.h == true) goto L7;
        this.h = true;
        this.g.f6855a = r3;
        this.g.f6856b = r4;
        this.g.f6857c = true;
        this.g.f6858d = false;
        return this.g;
    L7:
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    void a(int r2, long r3, boolean r5, boolean r6) {
        if (this.f6854e == true) goto L29;
        int r0 = 0;
        if (r5 == true) goto L8;
        r2 = 0;
    L8:
        if (r6 == false) goto L10;
        r2 = r2 | 128;
    L10:
        this.f6853d.b(r2);
        if (this.f6850a == false) goto L14;
        r0 = 128;
    L14:
        if (r3 > 125) goto L17;
        this.f6853d.b(((int) r3) | r0);
    L21:
        if (this.f6850a == false) goto L25;
        this.f6851b.nextBytes(this.i);
        this.f6853d.b(this.i);
        if (r3 <= 0) goto L26;
        long r7 = this.f6853d.b();
        this.f6853d.a_(this.f, r3);
        this.f6853d.a(this.j);
        this.j.a(r7);
        d.a(this.j, this.i);
        this.j.close();
    L26:
        this.f6852c.C();
        return;
    L25:
        this.f6853d.a_(this.f, r3);
        goto L26
    L17:
        if (r3 > 65535) goto L19;
        this.f6853d.b(r0 | 126);
        this.f6853d.c((int) r3);
        goto L21
    L19:
        this.f6853d.b(r0 | 127);
        this.f6853d.i(r3);
        goto L21
    L29:
        throw new IOException("closed");
    }
}
