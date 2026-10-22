package com.bumptech.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: StandardGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {
    private static final String TAG = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f3260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f3261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a.InterfaceC0083a f3262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f3263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f3264e;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private c l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;

    static {
    }

    public e(a.InterfaceC0083a r3, c r4, ByteBuffer r5, int r6) {
        this((a.InterfaceC0083a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0083a.class, "com.obric.aiagent.plugin"));
        a(r4, r5, r6);
    }

    public e(a.InterfaceC0083a r3) {
        a.InterfaceC0083a r4 = (a.InterfaceC0083a) ZeusTransformUtils.wrapperContextForParams(r3, a.InterfaceC0083a.class, "com.obric.aiagent.plugin");
        this.f3261b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.f3262c = r4;
        this.l = new c();
    }

    @Override // com.bumptech.glide.b.a
    public ByteBuffer a() {
        return this.f3263d;
    }

    @Override // com.bumptech.glide.b.a
    public void b() {
        this.k = (this.k + 1) % this.l.f3253c;
    }

    public int a(int r2) {
        if (r2 >= 0) goto L4;
    L6:
        return -1;
    L4:
        if (r2 >= this.l.f3253c) goto L6;
        return ((b) ZeusTransformUtils.preCheckCast(this.l.f3255e.get(r2), b.class, "com.obric.aiagent.plugin")).i;
    }

    @Override // com.bumptech.glide.b.a
    public int c() {
        if (this.l.f3253c <= 0) goto L9;
        int r0 = this.k;
        if (r0 >= 0) goto L8;
        return 0;
    L8:
        return a(r0);
    L9:
        return 0;
    }

    @Override // com.bumptech.glide.b.a
    public int d() {
        return this.l.f3253c;
    }

    @Override // com.bumptech.glide.b.a
    public int e() {
        return this.k;
    }

    @Override // com.bumptech.glide.b.a
    public void f() {
        this.k = -1;
    }

    @Override // com.bumptech.glide.b.a
    public int g() {
        if (this.l.m != (-1)) goto L6;
        return 1;
    L6:
        if (this.l.m != 0) goto L10;
        return 0;
    L10:
        return this.l.m + 1;
    }

    @Override // com.bumptech.glide.b.a
    public int h() {
        return (this.f3263d.limit() + this.i.length) + (this.j.length * 4);
    }

    @Override // com.bumptech.glide.b.a
    public synchronized Bitmap i() {
        monitor-enter(this);
    L50:
        th = move-exception;
        throw th;
    L4:
        if (this.l.f3253c > 0) goto L6;
    L7:
        String r0 = TAG;     // Catch: Throwable -> L50
        if (a(r0, 3) == false) goto L10;
        a(r0, "Unable to decode frame, frameCount=" + this.l.f3253c + ", framePointer=" + this.k);     // Catch: Throwable -> L50
    L10:
        this.o = 1;     // Catch: Throwable -> L50
    L11:
        int r1 = this.o;     // Catch: Throwable -> L50
        if (r1 != 1) goto L14;
    L45:
        String r2 = TAG;     // Catch: Throwable -> L50
        if (a(r2, 3) == false) goto L48;
        a(r2, "Unable to decode frame, status=" + this.o);     // Catch: Throwable -> L50
    L48:
        monitor-exit(this);
        return null;
    L14:
        if (r1 == 2) goto L45;
        this.o = 0;     // Catch: Throwable -> L50
        if (this.f3264e != null) goto L19;
        this.f3264e = this.f3262c.a(255);     // Catch: Throwable -> L50
    L19:
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.l.f3255e.get(this.k), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        int r6 = this.k - 1;     // Catch: Throwable -> L50
        if (r6 < 0) goto L22;
        b r7 = (b) ZeusTransformUtils.preCheckCast(this.l.f3255e.get(r6), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
    L24:
        if (r5.k == null) goto L26;
        int[] r8 = r5.k;     // Catch: Throwable -> L50
    L27:
        this.f3260a = r8;     // Catch: Throwable -> L50
        if (r8 != null) goto L36;
        String r3 = TAG;     // Catch: Throwable -> L50
        if (a(r3, 3) == false) goto L32;
        a(r3, "No valid color table found for frame #" + this.k);     // Catch: Throwable -> L50
    L32:
        this.o = 1;     // Catch: Throwable -> L50
        monitor-exit(this);
        return null;
    L36:
        if (r5.f == false) goto L42;
        int[] r4 = this.f3260a;     // Catch: Throwable -> L50
        System.arraycopy(r4, 0, this.f3261b, 0, r4.length);     // Catch: Throwable -> L50
        int[] r9 = this.f3261b;     // Catch: Throwable -> L50
        this.f3260a = r9;     // Catch: Throwable -> L50
        r9[r5.h] = 0;     // Catch: Throwable -> L50
        if (r5.g != 2) goto L42;
        if (this.k != 0) goto L42;
        this.s = true;     // Catch: Throwable -> L50
    L42:
        Bitmap r10 = a(r5, r7);     // Catch: Throwable -> L50
        monitor-exit(this);
        return r10;
    L26:
        r8 = this.l.f3251a;     // Catch: Throwable -> L50
        goto L27
    L22:
        r7 = null;
        goto L24
    L6:
        if (this.k >= 0) goto L11;
        goto L7
    }

    @Override // com.bumptech.glide.b.a
    public void j() {
        this.l = null;
        byte[] r1 = this.i;
        if (r1 == null) goto L5;
        this.f3262c.a(r1);
    L5:
        int[] r2 = this.j;
        if (r2 == null) goto L8;
        this.f3262c.a(r2);
    L8:
        Bitmap r3 = this.m;
        if (r3 == null) goto L11;
        this.f3262c.a(r3);
    L11:
        this.m = null;
        this.f3263d = null;
        this.s = null;
        byte[] r0 = this.f3264e;
        if (r0 == null) goto L15;
        this.f3262c.a(r0);
        return;
    }

    public synchronized void a(c r4, ByteBuffer r5, int r6) {
        monitor-enter(this);
        if (r6 <= 0) goto L16;
        int r7 = Integer.highestOneBit(r6);     // Catch: Throwable -> L13
        this.o = 0;     // Catch: Throwable -> L13
        this.l = r4;     // Catch: Throwable -> L13
        this.k = -1;     // Catch: Throwable -> L13
        ByteBuffer r8 = r5.asReadOnlyBuffer();     // Catch: Throwable -> L13
        this.f3263d = r8;     // Catch: Throwable -> L13
        r8.position(0);     // Catch: Throwable -> L13
        this.f3263d.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L13
        this.n = false;     // Catch: Throwable -> L13
        Iterator<b> r9 = r4.f3255e.iterator();     // Catch: Throwable -> L13
    L6:
        if (r9.hasNext() == false) goto L10;
        if (((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.aiagent.plugin")).g != 3) goto L6;
        this.n = true;     // Catch: Throwable -> L13
    L10:
        this.p = r7;     // Catch: Throwable -> L13
        this.r = r4.f / r7;     // Catch: Throwable -> L13
        this.q = r4.g / r7;     // Catch: Throwable -> L13
        this.i = this.f3262c.a(r4.f * r4.g);     // Catch: Throwable -> L13
        this.j = this.f3262c.b(this.r * this.q);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException("Sample size must be >=0, not: " + r6);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.b.a
    public void a(Bitmap.Config r3) {
        if (r3 != Bitmap.Config.ARGB_8888) goto L5;
    L9:
        this.t = r3;
        return;
    L5:
        if (r3 == Bitmap.Config.RGB_565) goto L9;
        throw new IllegalArgumentException("Unsupported format: " + r3 + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    private Bitmap a(b r10, b r11) {
        int[] r8 = this.j;
        int r0 = 0;
        if (r11 != null) goto L9;
        Bitmap r1 = this.m;
        if (r1 == null) goto L7;
        this.f3262c.a(r1);
    L7:
        this.m = null;
        Arrays.fill(r8, 0);
    L9:
        if (r11 != null) goto L11;
    L15:
        if (r11 != null) goto L17;
    L39:
        c(r10);
        if (r10.f3250e == false) goto L42;
    L45:
        b(r10);
    L47:
        if (this.n == true) goto L49;
    L56:
        Bitmap r12 = m();
        int r6 = this.r;
        r12.setPixels(r8, 0, r6, 0, 0, r6, this.q);
        return r12;
    L49:
        if (r10.g == 0) goto L53;
        if (r10.g != 1) goto L56;
    L53:
        if (this.m != null) goto L55;
        this.m = m();
    L55:
        Bitmap r2 = this.m;
        int r7 = this.r;
        r2.setPixels(r8, 0, r7, 0, 0, r7, this.q);
        goto L56
    L42:
        if (this.p != 1) goto L45;
        a(r10);
        goto L47
    L17:
        if (r11.g <= 0) goto L39;
        if (r11.g != 2) goto L35;
        if (r10.f == true) goto L28;
        int r3 = this.l.l;
        if (r10.k != null) goto L25;
    L27:
        r0 = r3;
        goto L28
    L25:
        if (this.l.j != r10.h) goto L27;
    L28:
        int r4 = r11.f3249d / this.p;
        int r5 = r11.f3247b / this.p;
        int r9 = r11.f3248c / this.p;
        int r13 = r11.f3246a / this.p;
        int r14 = this.r;
        int r15 = (r5 * r14) + r13;
        int r16 = (r4 * r14) + r15;
    L29:
        if (r15 >= r16) goto L39;
        int r17 = r15 + r9;
        int r18 = r15;
    L31:
        if (r18 >= r17) goto L33;
        r8[r18] = r0;
        r18 = r18 + 1;
        goto L31
    L33:
        r15 = r15 + this.r;
        goto L29
    L35:
        if (r11.g != 3) goto L39;
        Bitmap r19 = this.m;
        if (r19 == null) goto L39;
        int r20 = this.r;
        r19.getPixels(r8, 0, r20, 0, 0, r20, this.q);
        goto L39
    L11:
        if (r11.g != 3) goto L15;
        if (this.m != null) goto L15;
        Arrays.fill(r8, 0);
        goto L15
    }

    private void a(b r19) {
        b r1 = r19;
        int[] r2 = this.j;
        int r3 = r1.f3249d;
        int r4 = r1.f3247b;
        int r5 = r1.f3248c;
        int r6 = r1.f3246a;
        if (this.k != 0) goto L5;
        boolean r7 = true;
    L6:
        int r10 = this.r;
        byte[] r11 = this.i;
        int[] r12 = this.f3260a;
        int r14 = 0;
        byte r15 = -1;
    L7:
        if (r14 >= r3) goto L21;
        int r16 = (r14 + r4) * r10;
        int r17 = r16 + r6;
        int r8 = r17 + r5;
        int r9 = r16 + r10;
        if (r9 >= r8) goto L11;
        r8 = r9;
    L11:
        int r13 = r1.f3248c * r14;
        int r18 = r17;
    L12:
        if (r18 >= r8) goto L20;
        byte r20 = r11[r13];
        int r110 = r3;
        int r21 = r20 & 255;
        if (r21 == r15) goto L19;
        int r22 = r12[r21];
        if (r22 == 0) goto L18;
        r2[r18] = r22;
        goto L19
    L18:
        r15 = r20;
    L19:
        r13 = r13 + 1;
        r18 = r18 + 1;
        r3 = r110;
        goto L12
    L20:
        r14 = r14 + 1;
        r1 = r19;
        goto L7
    L21:
        Boolean r23 = this.s;
        if (r23 == null) goto L26;
        if (r23.booleanValue() == false) goto L26;
    L30:
        boolean r24 = true;
    L32:
        this.s = Boolean.valueOf(r24);
        return;
    L26:
        if (this.s != null) goto L31;
        if (r7 == false) goto L31;
        if (r15 != (-1)) goto L30;
    L31:
        r24 = false;
        goto L32
    L5:
        r7 = false;
        goto L6
    }

    private void b(b r25) {
        int[] r2 = this.j;
        int r3 = r25.f3249d / this.p;
        int r4 = r25.f3247b / this.p;
        int r5 = r25.f3248c / this.p;
        int r6 = r25.f3246a;
        int r7 = this.p;
        int r8 = r6 / r7;
        if (this.k != 0) goto L5;
        boolean r9 = true;
    L6:
        int r12 = this.r;
        int r13 = this.q;
        byte[] r14 = this.i;
        int[] r15 = this.f3260a;
        Boolean r10 = this.s;
        int r16 = 8;
        int r19 = 1;
        int r11 = 0;
        int r17 = 0;
    L7:
        if (r11 >= r3) goto L57;
        Boolean r20 = r10;
        if (r25.f3250e == true) goto L11;
        int r22 = r3;
        int r18 = r17;
        r17 = r11;
    L25:
        int r110 = r17 + r4;
        if (r7 != 1) goto L28;
        boolean r111 = true;
    L29:
        if (r110 >= r13) goto L54;
        int r112 = r110 * r12;
        int r21 = r112 + r8;
        int r23 = r21 + r5;
        int r113 = r112 + r12;
        if (r113 >= r23) goto L33;
        r23 = r113;
    L33:
        int r24 = r18;
        int r114 = (r11 * r7) * r25.f3248c;
        if (r111 == false) goto L44;
        int r26 = r21;
    L36:
        if (r26 >= r23) goto L55;
        int r115 = r4;
        int r27 = r15[r14[r114] & 255];
        if (r27 == 0) goto L40;
        r2[r26] = r27;
    L43:
        r114 = r114 + r7;
        r26 = r26 + 1;
        r4 = r115;
        goto L36
    L40:
        if (r9 == false) goto L43;
        if (r20 != null) goto L43;
        r20 = true;
    L55:
        int r116 = r4;
        int r28 = r5;
    L56:
        r10 = r20;
        r11 = r11 + 1;
        r4 = r116;
        r5 = r28;
        r3 = r22;
        r17 = r24;
        goto L7
    L44:
        r116 = r4;
        int r29 = ((r23 - r21) * r7) + r114;
        int r30 = r21;
    L45:
        r28 = r5;
        if (r30 >= r23) goto L56;
        int r31 = a(r114, r29, r25.f3248c);
        if (r31 == 0) goto L50;
        r2[r30] = r31;
    L53:
        r114 = r114 + r7;
        r30 = r30 + 1;
        r5 = r28;
        goto L45
    L50:
        if (r9 == false) goto L53;
        if (r20 != null) goto L53;
        r20 = true;
        goto L53
    L54:
        r24 = r18;
        goto L55
    L28:
        r111 = false;
        goto L29
    L11:
        if (r17 < r3) goto L22;
        r22 = r3;
        int r32 = r19 + 1;
        if (r32 != 2) goto L15;
        r19 = r32;
        r17 = 4;
    L23:
        r18 = r17 + r16;
        goto L25
    L15:
        if (r32 != 3) goto L17;
        r19 = r32;
        r16 = 4;
        r17 = 2;
        goto L23
    L17:
        if (r32 == 4) goto L19;
        r19 = r32;
        goto L23
    L19:
        r19 = r32;
        r17 = 1;
        r16 = 2;
        goto L23
    L22:
        r22 = r3;
        goto L23
    L57:
        Boolean r210 = r10;
        if (this.s != null) goto L76;
        if (r210 != null) goto L61;
        boolean r33 = false;
    L62:
        this.s = Boolean.valueOf(r33);
        return;
    L61:
        r33 = r210.booleanValue();
        goto L62
    L76:
        return;
    L5:
        r9 = false;
        goto L6
    }

    private int a(int r10, int r11, int r12) {
        int r1 = r10;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r1 >= (this.p + r10)) goto L12;
        byte[] r7 = this.i;
        if (r1 >= r7.length) goto L12;
        if (r1 >= r11) goto L12;
        int r8 = this.f3260a[r7[r1] & 255];
        if (r8 == 0) goto L11;
        r2 = r2 + ((r8 >> 24) & 255);
        r3 = r3 + ((r8 >> 16) & 255);
        r4 = r4 + ((r8 >> 8) & 255);
        r5 = r5 + (r8 & 255);
        r6 = r6 + 1;
    L11:
        r1 = r1 + 1;
    L12:
        int r13 = r10 + r12;
        int r14 = r13;
    L14:
        if (r14 >= (this.p + r13)) goto L22;
        byte[] r9 = this.i;
        if (r14 >= r9.length) goto L22;
        if (r14 >= r11) goto L22;
        int r15 = this.f3260a[r9[r14] & 255];
        if (r15 == 0) goto L21;
        r2 = r2 + ((r15 >> 24) & 255);
        r3 = r3 + ((r15 >> 16) & 255);
        r4 = r4 + ((r15 >> 8) & 255);
        r5 = r5 + (r15 & 255);
        r6 = r6 + 1;
    L21:
        r14 = r14 + 1;
    L22:
        if (r6 != 0) goto L25;
        return 0;
    L25:
        return ((((r2 / r6) << 24) | ((r3 / r6) << 16)) | ((r4 / r6) << 8)) | (r5 / r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void c(b r29) {
        e this = this;
        if (r29 == null) goto L5;
        this.f3263d.position(r29.j);
    L5:
        if (r29 != null) goto L7;
        int r1 = this.l.f * this.l.g;
    L8:
        byte[] r2 = this.i;
        if (r2 != null) goto L11;
    L12:
        this.i = this.f3262c.a(r1);
    L13:
        byte[] r3 = this.i;
        if (this.f != null) goto L16;
        this.f = new short[4096];
    L16:
        short[] r4 = this.f;
        if (this.g != null) goto L19;
        this.g = new byte[4096];
    L19:
        byte[] r5 = this.g;
        if (this.h != null) goto L22;
        this.h = new byte[4097];
    L22:
        byte[] r6 = this.h;
        int r7 = k();
        int r9 = 1 << r7;
        int r10 = r9 + 1;
        int r11 = r9 + 2;
        int r8 = r7 + 1;
        int r12 = (1 << r8) - 1;
        int r13 = 0;
        int r14 = 0;
    L23:
        if (r14 >= r9) goto L25;
        r4[r14] = 0;
        r5[r14] = (byte) r14;
        r14 = r14 + 1;
        goto L23
    L25:
        byte[] r15 = this.f3264e;
        int r23 = r8;
        int r21 = r11;
        int r22 = r12;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
        int r25 = 0;
        int r26 = 0;
        int r24 = -1;
    L26:
        if (r13 >= r1) goto L59;
        if (r16 != 0) goto L32;
        r16 = l();
        if (r16 <= 0) goto L30;
        r17 = 0;
        goto L32
    L30:
        this.o = 3;
    L32:
        r19 = r19 + ((r15[r17] & 255) << r18);
        r17 = r17 + 1;
        r16 = r16 - 1;
        int r27 = r18 + 8;
        r21 = r21;
        r23 = r23;
        r24 = r24;
        r8 = r8;
        r25 = r25;
    L33:
        if (r27 < r23) goto L58;
        int r28 = r11;
        int r110 = r19 & r22;
        r19 = r19 >> r23;
        r27 = r27 - r23;
        if (r110 == r9) goto L36;
        if (r110 == r10) goto L38;
        if (r24 == (-1)) goto L41;
        if (r110 < r21) goto L44;
        r6[r26] = (byte) r25;
        r26 = r26 + 1;
        short r30 = r24;
    L45:
        if (r30 < r9) goto L47;
        r6[r26] = r5[r30];
        r26 = r26 + 1;
        r30 = r4[r30];
        goto L45
    L47:
        r25 = r5[r30] & 255;
        byte r31 = (byte) r25;
        r3[r20] = r31;
    L48:
        r20 = r20 + 1;
        r13 = r13 + 1;
        if (r26 <= 0) goto L51;
        r26 = r26 - 1;
        r3[r20] = r6[r26];
        goto L48
    L51:
        byte[] r210 = r6;
        if (r21 >= 4096) goto L57;
        r4[r21] = (short) r24;
        r5[r21] = r31;
        r21 = r21 + 1;
        if ((r21 & r22) != 0) goto L57;
        if (r21 >= 4096) goto L57;
        r23 = r23 + 1;
        r22 = r22 + r21;
    L57:
        r24 = r110;
        r11 = r28;
        r27 = r27;
        r6 = r210;
        goto L33
    L44:
        r30 = r110;
        goto L45
    L41:
        r3[r20] = r5[r110];
        r20 = r20 + 1;
        r13 = r13 + 1;
        r24 = r110;
        r25 = r24;
        r11 = r28;
        r27 = r27;
        goto L33
    L38:
        r18 = r27;
        r11 = r28;
        goto L26
    L36:
        r22 = r12;
        r23 = r8;
        r21 = r28;
        r11 = r21;
        r24 = -1;
        goto L33
    L58:
        r18 = r27;
    L59:
        Arrays.fill(r3, r20, r1, (byte) 0);
        return;
    L11:
        if (r2.length >= r1) goto L13;
    L7:
        r1 = r29.f3249d * r29.f3248c;
        goto L8
    }

    private int k() {
        return this.f3263d.get() & 255;
    }

    private int l() {
        int r0 = k();
        if (r0 > 0) goto L5;
        return r0;
    L5:
        ByteBuffer r1 = this.f3263d;
        r1.get(this.f3264e, 0, Math.min(r0, r1.remaining()));
        return r0;
    }

    private Bitmap m() {
        Boolean r0 = this.s;
        if (r0 != null) goto L5;
    L8:
        Bitmap.Config r1 = Bitmap.Config.ARGB_8888;
    L9:
        Bitmap r3 = this.f3262c.a(this.r, this.q, r1);
        r3.setHasAlpha(true);
        return r3;
    L5:
        if (r0.booleanValue() == true) goto L8;
        r1 = this.t;
        goto L9
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
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
