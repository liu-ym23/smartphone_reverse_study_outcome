package com.bumptech.glide.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: GifHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "GifHeaderParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f3256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f3258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3259d;

    public d() {
        this.f3256a = new byte[256];
        this.f3259d = 0;
    }

    public d a(ByteBuffer r2) {
        c();
        ByteBuffer r3 = r2.asReadOnlyBuffer();
        this.f3257b = r3;
        r3.position(0);
        this.f3257b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f3257b = null;
        this.f3258c = null;
    }

    private void c() {
        this.f3257b = null;
        Arrays.fill(this.f3256a, (byte) 0);
        this.f3258c = new c();
        this.f3259d = 0;
    }

    public c b() {
        if (this.f3257b == null) goto L16;
        if (o() == true) goto L7;
        h();
        if (o() == true) goto L14;
        d();
        if (this.f3258c.f3253c >= 0) goto L14;
        this.f3258c.f3252b = 1;
    L14:
        return this.f3258c;
    L7:
        return this.f3258c;
    L16:
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void a(int r6) {
        boolean r1 = false;
    L3:
        if (r1 == true) goto L40;
        if (o() == true) goto L71;
        if (this.f3258c.f3253c > r6) goto L72;
        int r2 = m();
        if (r2 != 33) goto L11;
        int r3 = m();
        if (r3 != 1) goto L23;
        k();
        goto L3
    L23:
        if (r3 != 249) goto L25;
        this.f3258c.f3254d = new b();
        e();
        goto L3
    L25:
        if (r3 != 254) goto L27;
        k();
        goto L3
    L27:
        if (r3 != 255) goto L28;
        l();
        StringBuilder r4 = new StringBuilder();
        int r5 = 0;
    L31:
        if (r5 >= 11) goto L34;
        r4.append((char) this.f3256a[r5]);
        r5 = r5 + 1;
        goto L31
    L34:
        if (r4.toString().equals("NETSCAPE2.0") == true) goto L35;
        k();
        goto L3
    L35:
        g();
        goto L3
    L28:
        k();
        goto L3
    L11:
        if (r2 != 44) goto L13;
        if (this.f3258c.f3254d != null) goto L19;
        this.f3258c.f3254d = new b();
    L19:
        f();
        goto L3
    L13:
        if (r2 != 59) goto L14;
        r1 = true;
        goto L3
    L14:
        this.f3258c.f3252b = 1;
        goto L3
    L72:
        return;
    L71:
        return;
    }

    private void e() {
        m();
        int r0 = m();
        this.f3258c.f3254d.g = (r0 & 28) >> 2;
        boolean r2 = true;
        if (this.f3258c.f3254d.g != 0) goto L5;
        this.f3258c.f3254d.g = 1;
    L5:
        b r1 = this.f3258c.f3254d;
        if ((r0 & 1) != 0) goto L9;
        r2 = false;
    L9:
        r1.f = r2;
        int r3 = n();
        if (r3 >= 2) goto L12;
        r3 = 10;
    L12:
        this.f3258c.f3254d.i = r3 * 10;
        this.f3258c.f3254d.h = m();
        m();
    }

    private void f() {
        this.f3258c.f3254d.f3246a = n();
        this.f3258c.f3254d.f3247b = n();
        this.f3258c.f3254d.f3248c = n();
        this.f3258c.f3254d.f3249d = n();
        int r0 = m();
        boolean r2 = false;
        if ((r0 & 128) == 0) goto L5;
        boolean r1 = true;
    L6:
        int r4 = (int) Math.pow(2.0d, (r0 & 7) + 1);
        b r5 = this.f3258c.f3254d;
        if ((r0 & 64) == 0) goto L9;
        r2 = true;
    L9:
        r5.f3250e = r2;
        if (r1 == false) goto L12;
        this.f3258c.f3254d.k = b(r4);
    L13:
        this.f3258c.f3254d.j = this.f3257b.position();
        j();
        if (o() == false) goto L16;
        return;
    L16:
        this.f3258c.f3253c++;
        this.f3258c.f3255e.add(this.f3258c.f3254d);
        return;
    L12:
        this.f3258c.f3254d.k = null;
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private void g() {
    L2:
        l();
        byte[] r0 = this.f3256a;
        if (r0[0] != 1) goto L6;
        int r1 = r0[1] & 255;
        int r2 = r0[2] & 255;
        int r3 = (r2 << 8) | r1;
        this.f3258c.m = r3;
    L6:
        if (this.f3259d <= 0) goto L9;
        if (o() == false) goto L2;
        return;
    }

    private void h() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= 6) goto L7;
        r0.append((char) m());
        r1 = r1 + 1;
        goto L4
    L7:
        if (r0.toString().startsWith("GIF") == true) goto L10;
        this.f3258c.f3252b = 1;
        return;
    L10:
        i();
        if (this.f3258c.h == true) goto L13;
        return;
    L13:
        if (o() == true) goto L18;
        c r2 = this.f3258c;
        r2.f3251a = b(r2.i);
        c r3 = this.f3258c;
        r3.l = r3.f3251a[this.f3258c.j];
        return;
    }

    private void i() {
        this.f3258c.f = n();
        this.f3258c.g = n();
        int r0 = m();
        c r1 = this.f3258c;
        if ((r0 & 128) == 0) goto L5;
        boolean r2 = true;
    L6:
        r1.h = r2;
        this.f3258c.i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f3258c.j = m();
        this.f3258c.k = m();
        return;
    L5:
        r2 = false;
        goto L6
    }

    private int[] b(int r10) {
        byte[] r0 = new byte[r10 * 3];
        int[] r1 = null;
        this.f3257b.get(r0);     // Catch: BufferUnderflowException -> L7
        r1 = new int[256];     // Catch: BufferUnderflowException -> L7
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r10) goto L12;
        int r4 = r3 + 1;     // Catch: BufferUnderflowException -> L7
        int r5 = r4 + 1;     // Catch: BufferUnderflowException -> L7
        int r6 = r5 + 1;     // Catch: BufferUnderflowException -> L7
        int r7 = r2 + 1;     // Catch: BufferUnderflowException -> L7
        r1[r2] = ((((r0[r3] & 255) << 16) | (-16777216)) | ((r0[r4] & 255) << 8)) | (r0[r5] & 255);     // Catch: BufferUnderflowException -> L7
        r3 = r6;
        r2 = r7;
    L12:
        return r1;
    L7:
        e = move-exception;
        if (a(TAG, 3) == false) goto L11;
        a(TAG, "Format Error Reading Color Table", e);
    L11:
        this.f3258c.f3252b = 1;
        goto L12
    }

    private void j() {
        m();
        k();
    }

    private void k() {
    L2:
        int r0 = m();
        int r1 = Math.min(this.f3257b.position() + r0, this.f3257b.limit());
        this.f3257b.position(r1);
        if (r0 > 0) goto L2;
    }

    private void l() {
        int r0 = m();
        this.f3259d = r0;
        if (r0 <= 0) goto L18;
        int r1 = 0;
        int r2 = 0;
    L15:
        int r3 = this.f3259d;     // Catch: Exception -> L9
        if (r1 >= r3) goto L19;
        r2 = r3 - r1;     // Catch: Exception -> L9
        this.f3257b.get(this.f3256a, r1, r2);     // Catch: Exception -> L9
        r1 = r1 + r2;
        goto L15
    L19:
        return;
    L9:
        e = move-exception;
        if (a(TAG, 3) == false) goto L13;
        a(TAG, "Error Reading Block n: " + r1 + " count: " + r2 + " blockSize: " + this.f3259d, e);
    L13:
        this.f3258c.f3252b = 1;
        return;
    }

    private int m() {
        return this.f3257b.get() & 255;
    L4:
        this.f3258c.f3252b = 1;
        return 0;
    }

    private int n() {
        return this.f3257b.getShort();
    }

    private boolean o() {
        if (this.f3258c.f3252b == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
