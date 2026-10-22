package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
public class CronetBidirectionalStream extends com.ttnet.org.chromium.net.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37899a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CronetUrlRequestContext f37900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f37901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VersionSafeCallbacks.a f37902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f37903e;
    private final String f;
    private final Collection<Object> g;
    private com.ttnet.org.chromium.net.e h;
    private final Object i;
    private LinkedList<ByteBuffer> j;
    private LinkedList<ByteBuffer> k;
    private boolean l;
    private boolean m;
    private com.ttnet.org.chromium.net.w.b n;
    private long o;
    private int p;
    private int q;
    private ah r;
    private b s;
    private Runnable t;

    interface a {
        void a(long r1, CronetBidirectionalStream r3, boolean r4);

        boolean a(long r1, CronetBidirectionalStream r3, ByteBuffer[] r4, int[] r5, int[] r6, boolean r7);
    }

    private final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ByteBuffer f37912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f37913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CronetBidirectionalStream f37914c;

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r0 = this.f37912a;     // Catch: Exception -> L22
            this.f37912a = null;     // Catch: Exception -> L22
            Object r1 = CronetBidirectionalStream.a(this.f37914c);     // Catch: Exception -> L22
            monitor-enter(r1);     // Catch: Exception -> L22
        L19:
            th = move-exception;
            throw th;     // Catch: Exception -> L22
        L5:
            if (CronetBidirectionalStream.b(this.f37914c) == false) goto L8;
            monitor-exit(r1);     // Catch: Throwable -> L19
            return;
        L8:
            boolean r3 = false;
            if (this.f37913b == false) goto L13;
            CronetBidirectionalStream.a(this.f37914c, 4);     // Catch: Throwable -> L19
            if (CronetBidirectionalStream.c(this.f37914c) != 10) goto L14;
            r3 = true;
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L19
            VersionSafeCallbacks.a r2 = CronetBidirectionalStream.e(this.f37914c);     // Catch: Exception -> L22
            CronetBidirectionalStream r4 = this.f37914c;     // Catch: Exception -> L22
            r2.a(r4, CronetBidirectionalStream.d(r4), r0, this.f37913b);     // Catch: Exception -> L22
            if (r3 == false) goto L27;
            CronetBidirectionalStream.f(this.f37914c);     // Catch: Exception -> L22
            return;
        L27:
            return;
        L13:
            CronetBidirectionalStream.a(this.f37914c, 2);     // Catch: Throwable -> L19
        L22:
            e = move-exception;
            CronetBidirectionalStream.a(this.f37914c, e);
        }
    }

    private final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CronetBidirectionalStream f37915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteBuffer f37916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f37917c;

        c(CronetBidirectionalStream r1, ByteBuffer r2, boolean r3) {
            this.f37915a = r1;
            this.f37916b = r2;
            this.f37917c = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r0 = this.f37916b;     // Catch: Exception -> L21
            this.f37916b = null;     // Catch: Exception -> L21
            Object r1 = CronetBidirectionalStream.a(this.f37915a);     // Catch: Exception -> L21
            monitor-enter(r1);     // Catch: Exception -> L21
        L18:
            th = move-exception;
            throw th;     // Catch: Exception -> L21
        L5:
            if (CronetBidirectionalStream.b(this.f37915a) == false) goto L8;
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L8:
            boolean r3 = false;
            if (this.f37917c == false) goto L13;
            CronetBidirectionalStream.b(this.f37915a, 10);     // Catch: Throwable -> L18
            if (CronetBidirectionalStream.g(this.f37915a) != 4) goto L13;
            r3 = true;
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L18
            VersionSafeCallbacks.a r2 = CronetBidirectionalStream.e(this.f37915a);     // Catch: Exception -> L21
            CronetBidirectionalStream r4 = this.f37915a;     // Catch: Exception -> L21
            r2.b(r4, CronetBidirectionalStream.d(r4), r0, this.f37917c);     // Catch: Exception -> L21
            if (r3 == false) goto L26;
            CronetBidirectionalStream.f(this.f37915a);     // Catch: Exception -> L21
            return;
        L26:
            return;
        L21:
            e = move-exception;
            CronetBidirectionalStream.a(this.f37915a, e);
        }
    }

    static {
    }

    static /* synthetic */ int a(CronetBidirectionalStream r0, int r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ Object a(CronetBidirectionalStream r0) {
        return r0.i;
    }

    static /* synthetic */ void a(CronetBidirectionalStream r0, com.ttnet.org.chromium.net.e r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(CronetBidirectionalStream r0, Exception r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a(CronetBidirectionalStream r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ boolean a(String r0) {
        return b(r0);
    }

    static /* synthetic */ int b(CronetBidirectionalStream r0, int r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ boolean b(CronetBidirectionalStream r0) {
        return r0.b();
    }

    static /* synthetic */ int c(CronetBidirectionalStream r0) {
        return r0.q;
    }

    static /* synthetic */ ah d(CronetBidirectionalStream r0) {
        return r0.r;
    }

    static /* synthetic */ VersionSafeCallbacks.a e(CronetBidirectionalStream r0) {
        return r0.f37902d;
    }

    static /* synthetic */ void f(CronetBidirectionalStream r0) {
        r0.c();
    }

    static /* synthetic */ int g(CronetBidirectionalStream r0) {
        return r0.p;
    }

    static /* synthetic */ String h(CronetBidirectionalStream r0) {
        return r0.f;
    }

    static /* synthetic */ boolean i(CronetBidirectionalStream r0) {
        return r0.m;
    }

    private void a() {
        if (f37899a == false) goto L5;
    L9:
        int r0 = this.k.size();
        ByteBuffer[] r6 = new ByteBuffer[r0];
        int[] r7 = new int[r0];
        int[] r8 = new int[r0];
        int r3 = 0;
    L10:
        if (r3 >= r0) goto L12;
        ByteBuffer r4 = (ByteBuffer) ZeusTransformUtils.preCheckCast(this.k.poll(), ByteBuffer.class, "com.obric.aiagent.plugin");
        r6[r3] = r4;
        r7[r3] = r4.position();
        r8[r3] = r4.limit();
        r3 = r3 + 1;
        goto L10
    L12:
        boolean r5 = f37899a;
        if (r5 == true) goto L20;
        if (this.k.isEmpty() == true) goto L20;
        throw new AssertionError();
    L20:
        if (r5 == true) goto L25;
        if (r0 >= 1) goto L25;
        throw new AssertionError();
    L25:
        this.q = 9;
        this.m = true;
        a r1 = com.ttnet.org.chromium.net.impl.c.a();
        long r9 = this.o;
        if (this.l == true) goto L28;
    L30:
        boolean r11 = false;
    L32:
        if (r1.a(r9, this, r6, r7, r8, r11) == false) goto L34;
        return;
    L34:
        this.q = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    L28:
        if (this.j.isEmpty() == false) goto L30;
        r11 = true;
        goto L32
    L5:
        if (this.q == 8) goto L9;
        throw new AssertionError();
    }

    private boolean b() {
        if (this.p != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.o != 0) goto L7;
        return true;
    }

    private void c() {
        Object r0 = this.i;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (b() == false) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L9:
        if (this.q == 10) goto L11;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.p != 4) goto L20;
        this.q = 7;     // Catch: Throwable -> L22
        this.p = 7;     // Catch: Throwable -> L22
        a(false);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        this.f37902d.b(this, this.r);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception in onSucceeded method", new Object[]{e});
    }

    private void onStreamReady(final boolean r2) {
        a(new AnonymousClass1(this, r2));
    }

    private void onResponseHeadersReceived(int r1, String r2, String[] r3, long r4) {
        this.r = a(r1, r2, r3, r4);     // Catch: Exception -> L5
        a(new AnonymousClass2(this));
        return;
    L5:
        b(new e("Cannot prepare ResponseInfo", null));
    }

    private void onReadCompleted(ByteBuffer r2, int r3, int r4, int r5, long r6) {
        this.r.a(r6);
        if (r2.position() == r4) goto L5;
    L26:
        b(new e("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r2.limit() != r5) goto L26;
        if (r3 < 0) goto L24;
        int r7 = r4 + r3;
        if (r7 > r5) goto L24;
        r2.position(r7);
        if (f37899a == false) goto L14;
    L18:
        this.s.f37912a = r2;
        b r8 = this.s;
        if (r3 != 0) goto L21;
        boolean r9 = true;
    L22:
        r8.f37913b = r9;
        a(this.s);
        return;
    L21:
        r9 = false;
        goto L22
    L14:
        if (this.s.f37912a == null) goto L18;
        throw new AssertionError();
    L24:
        b(new e("Invalid number of bytes read", null));
    }

    private void onWritevCompleted(ByteBuffer[] r7, int[] r8, int[] r9, boolean r10) {
        boolean r0 = f37899a;
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
    L15:
        Object r1 = this.i;
        monitor-enter(r1);
    L42:
        th = move-exception;
        throw th;
    L18:
        if (b() == false) goto L21;
        monitor-exit(r1);     // Catch: Throwable -> L42
        return;
    L21:
        this.q = 8;     // Catch: Throwable -> L42
        if (this.k.isEmpty() == true) goto L24;
        a();     // Catch: Throwable -> L42
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L42
        int r2 = 0;
    L27:
        if (r2 >= r7.length) goto L51;
        ByteBuffer r3 = r7[r2];
        if (r3.position() != r8[r2]) goto L40;
        if (r3.limit() != r9[r2]) goto L40;
        r3.position(r3.limit());
        boolean r4 = true;
        if (r10 == true) goto L36;
    L38:
        r4 = false;
    L39:
        a(new c(this, r3, r4));
        r2 = r2 + 1;
        goto L27
    L36:
        if (r2 != (r7.length - 1)) goto L38;
    L40:
        b(new e("ByteBuffer modified externally during write", null));
        return;
    L51:
        return;
    L11:
        if (r7.length == r9.length) goto L15;
        throw new AssertionError();
    L5:
        if (r7.length == r8.length) goto L9;
        throw new AssertionError();
    }

    private void onResponseTrailersReceived(String[] r2) {
        final ah.a r0 = new ah.a(a(r2));
        a(new AnonymousClass3(this, r0));
    }

    private void onError(int r2, int r3, int r4, String r5, long r6) {
        ah r0 = this.r;
        if (r0 == null) goto L6;
        r0.a(r6);
    L6:
        if (r2 != 10) goto L8;
    L11:
        b(new y("Exception in BidirectionalStream: " + r5, r2, r3, r4));
        return;
    L8:
        if (r2 == 3) goto L11;
        b(new com.ttnet.org.chromium.net.impl.a("Exception in BidirectionalStream: " + r5, r2, r3));
    }

    private void onCanceled() {
        a(new AnonymousClass4(this));
    }

    private void onMetricsCollected(long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, boolean r78, long r79, long r81, String r83, long r84) {
        Object r1 = this.i;
        monitor-enter(r1);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (this.n != null) goto L33;
        this.n = new k(r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r81, r83, r84, 0, "", "", 0, 0, -1, "", false, false, -1);     // Catch: Throwable -> L34
        boolean r2 = f37899a;     // Catch: Throwable -> L34
        if (r2 == true) goto L14;
        if (this.p == this.q) goto L14;
        throw new AssertionError();     // Catch: Throwable -> L34
    L14:
        if (r2 == true) goto L23;
        int r3 = this.p;     // Catch: Throwable -> L34
        if (r3 == 7) goto L23;
        if (r3 == 6) goto L23;
        if (r3 == 5) goto L23;
        throw new AssertionError();     // Catch: Throwable -> L34
    L23:
        int r4 = this.p;     // Catch: Throwable -> L34
        if (r4 != 7) goto L26;
        int r5 = 0;
    L29:
        int r57 = r5;
        z r6 = new z(this.f37903e, this.g, this.n, r57, this.r, this.h);     // Catch: Throwable -> L34
        this.f37900b.a(r6);     // Catch: Throwable -> L34
        monitor-exit(r1);     // Catch: Throwable -> L34
        return;
    L26:
        if (r4 != 5) goto L28;
        r5 = 2;
        goto L29
    L28:
        r5 = 1;
        goto L29
    L33:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L34
    }

    private static boolean b(String r1) {
        if (r1.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.equals("HEAD") == true) goto L7;
        return true;
    }

    private static ArrayList<Map.Entry<String, String>> a(String[] r5) {
        ArrayList<Map.Entry<String, String>> r0 = new ArrayList(r5.length / 2);
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        r0.add(new AbstractMap.SimpleImmutableEntry(r5[r1], r5[r1 + 1]));
        r1 = r1 + 2;
        goto L4
    L6:
        return r0;
    }

    private void a(Runnable r5) {
        this.f37901c.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception posting task to executor", new Object[]{e});
        monitor-enter(this.i);
        this.q = 6;     // Catch: Throwable -> L12
        this.p = 6;     // Catch: Throwable -> L12
        a(false);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private ah a(int r12, String r13, String[] r14, long r15) {
        return new ah(Arrays.asList(new String[]{this.f37903e}), r12, "", a(r14), false, r13, null, r15);
    }

    private void a(boolean r7) {
        com.ttnet.org.chromium.base.j.c(CronetUrlRequestContext.f37990a, "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.o != 0) goto L5;
        return;
    L5:
        com.ttnet.org.chromium.net.impl.c.a().a(this.o, this, r7);
        this.f37900b.s();
        this.o = 0;
        Runnable r6 = this.t;
        if (r6 == null) goto L9;
        r6.run();
        return;
    }

    private void a(com.ttnet.org.chromium.net.e r4) {
        this.h = r4;
        Object r0 = this.i;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (b() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        this.q = 6;     // Catch: Throwable -> L15
        this.p = 6;     // Catch: Throwable -> L15
        a(false);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        this.f37902d.a(this, this.r, r4);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception notifying of failed request", new Object[]{e});
    }

    private void a(Exception r5) {
        com.ttnet.org.chromium.net.impl.b r0 = new com.ttnet.org.chromium.net.impl.b("CalledByNative method has thrown an exception", r5);
        com.ttnet.org.chromium.base.j.e(CronetUrlRequestContext.f37990a, "Exception in CalledByNative method", new Object[]{r5});
        a(r0);
    }

    private void b(final com.ttnet.org.chromium.net.e r2) {
        a(new AnonymousClass5(this, r2));
    }
}
