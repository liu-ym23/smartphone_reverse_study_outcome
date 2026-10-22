package com.ttnet.org.chromium.net.impl;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.b0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
@VisibleForTesting
public class CronetBidirectionalStream extends com.ttnet.org.chromium.net.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronetUrlRequestContext f18493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Collection f18497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CronetException f18498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f18499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinkedList f18500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinkedList f18501i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18502j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18503k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.ttnet.org.chromium.net.t.b f18504l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f18505m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f18506n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f18507o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public t f18508p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Runnable f18509q;

    public interface Natives {
        long createBidirectionalStream(CronetBidirectionalStream r10, long r11, boolean r12, boolean r13, boolean r14, int r15, boolean r16, int r17);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void destroy(long r10, CronetBidirectionalStream r11, boolean r12);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean readData(long r10, CronetBidirectionalStream r11, ByteBuffer r12, int r13, int r14);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void sendRequestHeaders(long r10, CronetBidirectionalStream r11);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        int start(long r10, CronetBidirectionalStream r11, String r12, int r13, String r14, String[] r15, boolean r16);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean writevData(long r10, CronetBidirectionalStream r11, ByteBuffer[] r12, int[] r13, int[] r14, boolean r15);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int CANCELED = 5;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 3;
        public static final int READING_DONE = 4;
        public static final int STARTED = 1;
        public static final int SUCCESS = 7;
        public static final int WAITING_FOR_FLUSH = 8;
        public static final int WAITING_FOR_READ = 2;
        public static final int WRITING = 9;
        public static final int WRITING_DONE = 10;
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f18511b;

        public a(CronetBidirectionalStream r10, boolean r11) {
            this.f18511b = r10;
            this.f18510a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = CronetBidirectionalStream.a(this.f18511b);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetBidirectionalStream.b(this.f18511b) == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetBidirectionalStream.m(this.f18511b, this.f18510a);     // Catch: Throwable -> L8
            CronetBidirectionalStream.g(this.f18511b, 2);     // Catch: Throwable -> L8
            if (CronetBidirectionalStream.d(CronetBidirectionalStream.c(this.f18511b)) == false) goto L13;
        L15:
            CronetBidirectionalStream.h(this.f18511b, 8);     // Catch: Throwable -> L8
        L16:
            monitor-exit(r10);     // Catch: Throwable -> L8
            CronetBidirectionalStream.j(this.f18511b);     // Catch: Exception -> L19
            throw null;     // Catch: Exception -> L19
        L19:
            e = move-exception;
            CronetBidirectionalStream.k(this.f18511b, e);
            return;
        L13:
            if (CronetBidirectionalStream.l(this.f18511b) == false) goto L15;
            CronetBidirectionalStream.h(this.f18511b, 10);     // Catch: Throwable -> L8
            goto L16
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f18512a;

        public b(CronetBidirectionalStream r10) {
            this.f18512a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = CronetBidirectionalStream.a(this.f18512a);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetBidirectionalStream.b(this.f18512a) == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetBidirectionalStream.g(this.f18512a, 2);     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            CronetBidirectionalStream.j(this.f18512a);     // Catch: Exception -> L14
            CronetBidirectionalStream.i(this.f18512a);     // Catch: Exception -> L14
            throw null;     // Catch: Exception -> L14
        L14:
            e = move-exception;
            CronetBidirectionalStream.k(this.f18512a, e);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0.a f18513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f18514b;

        public c(CronetBidirectionalStream r10, b0.a r11) {
            this.f18514b = r10;
            this.f18513a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = CronetBidirectionalStream.a(this.f18514b);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetBidirectionalStream.b(this.f18514b) == false) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L8
            CronetBidirectionalStream.j(this.f18514b);     // Catch: Exception -> L13
            CronetBidirectionalStream.i(this.f18514b);     // Catch: Exception -> L13
            throw null;     // Catch: Exception -> L13
        L13:
            e = move-exception;
            CronetBidirectionalStream.k(this.f18514b, e);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f18515a;

        public d(CronetBidirectionalStream r10) {
            this.f18515a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetBidirectionalStream.j(this.f18515a);     // Catch: Exception -> L4
            CronetBidirectionalStream.i(this.f18515a);     // Catch: Exception -> L4
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in onCanceled method", new Object[]{e});
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetException f18516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f18517b;

        public e(CronetBidirectionalStream r10, CronetException r11) {
            this.f18517b = r10;
            this.f18516a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetBidirectionalStream.e(this.f18517b, this.f18516a);
        }
    }

    public final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteBuffer f18518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f18520c;

        public f(CronetBidirectionalStream r10, ByteBuffer r11, boolean r12) {
            this.f18520c = r10;
            this.f18518a = r11;
            this.f18519b = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18518a = null;     // Catch: Exception -> L17
            Object r10 = CronetBidirectionalStream.a(this.f18520c);     // Catch: Exception -> L17
            monitor-enter(r10);     // Catch: Exception -> L17
        L9:
            th = move-exception;
            throw th;     // Catch: Exception -> L17
        L6:
            if (CronetBidirectionalStream.b(this.f18520c) == false) goto L12;
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L12:
            if (this.f18519b == false) goto L14;
            CronetBidirectionalStream.h(this.f18520c, 10);     // Catch: Throwable -> L9
            CronetBidirectionalStream.f(this.f18520c);     // Catch: Throwable -> L9
        L14:
            monitor-exit(r10);     // Catch: Throwable -> L9
            CronetBidirectionalStream.j(this.f18520c);     // Catch: Exception -> L17
            CronetBidirectionalStream.i(this.f18520c);     // Catch: Exception -> L17
            throw null;     // Catch: Exception -> L17
        L17:
            e = move-exception;
            CronetBidirectionalStream.k(this.f18520c, e);
        }
    }

    static {
    }

    public static /* synthetic */ Object a(CronetBidirectionalStream r10) {
        return r10.f18499g;
    }

    public static /* synthetic */ boolean b(CronetBidirectionalStream r10) {
        return r10.s();
    }

    public static /* synthetic */ String c(CronetBidirectionalStream r10) {
        return r10.f18496d;
    }

    public static /* synthetic */ boolean d(String r10) {
        return o(r10);
    }

    public static /* synthetic */ void e(CronetBidirectionalStream r10, CronetException r11) {
        r10.q(r11);
    }

    public static /* synthetic */ int f(CronetBidirectionalStream r10) {
        return r10.f18506n;
    }

    public static /* synthetic */ int g(CronetBidirectionalStream r10, int r11) {
        r10.f18506n = r11;
        return r11;
    }

    public static /* synthetic */ int h(CronetBidirectionalStream r10, int r11) {
        r10.f18507o = r11;
        return r11;
    }

    public static /* synthetic */ t i(CronetBidirectionalStream r10) {
        return r10.f18508p;
    }

    public static /* synthetic */ VersionSafeCallbacks.a j(CronetBidirectionalStream r10) {
        r10.getClass();
        return null;
    }

    public static /* synthetic */ void k(CronetBidirectionalStream r10, Exception r11) {
        r10.t(r11);
    }

    public static /* synthetic */ boolean l(CronetBidirectionalStream r10) {
        return r10.f18503k;
    }

    public static /* synthetic */ boolean m(CronetBidirectionalStream r10, boolean r11) {
        r10.f18503k = r11;
        return r11;
    }

    public static boolean o(String r10) {
        if (r10.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals("HEAD") == true) goto L7;
        return true;
    }

    @CalledByNative
    private void onCanceled() {
        u(new d(this));
    }

    @CalledByNative
    private void onError(int r10, int r11, int r12, String r13, long r14) {
        t r15 = this.f18508p;
        if (r15 == null) goto L6;
        r15.j(r14);
    L6:
        if (r10 != 10) goto L8;
    L11:
        p(new QuicExceptionImpl("Exception in BidirectionalStream: " + r13, r10, r11, r12));
        return;
    L8:
        if (r10 == 3) goto L11;
        p(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + r13, r10, r11));
    }

    @CalledByNative
    private void onMetricsCollected(long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, boolean r71, long r72, long r74, String r76, long r77) {
        Object r10 = this.f18499g;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.f18504l != null) goto L19;
        com.ttnet.org.chromium.net.impl.c r11 = new com.ttnet.org.chromium.net.impl.c(r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r72, r74, -1, r76, r77, 0, "", "");     // Catch: Throwable -> L16
        this.f18504l = r11;     // Catch: Throwable -> L16
        int r12 = this.f18506n;     // Catch: Throwable -> L16
        if (r12 != 7) goto L10;
        int r13 = 0;
    L13:
        int r410 = r13;
        RequestFinishedInfoImpl r14 = new RequestFinishedInfoImpl(this.f18495c, this.f18497e, r11, r410, this.f18508p, this.f18498f);     // Catch: Throwable -> L16
        this.f18493a.i0(r14);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L10:
        if (r12 != 5) goto L12;
        r13 = 2;
        goto L13
    L12:
        r13 = 1;
        goto L13
    L19:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L16
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r10, int r11, int r12, int r13, long r14) {
        this.f18508p.j(r14);
        if (r10.position() == r12) goto L5;
    L15:
        p(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r10.limit() != r13) goto L15;
        if (r11 < 0) goto L13;
        int r15 = r12 + r11;
        if (r15 > r13) goto L13;
        r10.position(r15);
        throw null;
    L13:
        p(new CronetExceptionImpl("Invalid number of bytes read", null));
    }

    @CalledByNative
    private void onResponseHeadersReceived(int r10, String r11, String[] r12, long r13) {
        this.f18508p = v(r10, r11, r12, r13);     // Catch: Exception -> L5
        u(new b(this));
        return;
    L5:
        p(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] r10) {
        u(new c(this, new t.a(r(r10))));
    }

    @CalledByNative
    private void onStreamReady(boolean r10) {
        u(new a(this, r10));
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] r10, int[] r11, int[] r12, boolean r13) {
        Object r14 = this.f18499g;
        monitor-enter(r14);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (s() == false) goto L10;
        monitor-exit(r14);     // Catch: Throwable -> L8
        return;
    L10:
        this.f18507o = 8;     // Catch: Throwable -> L8
        if (this.f18501i.isEmpty() == true) goto L13;
        w();     // Catch: Throwable -> L8
    L13:
        monitor-exit(r14);     // Catch: Throwable -> L8
        int r15 = 0;
    L16:
        if (r15 >= r10.length) goto L39;
        ByteBuffer r16 = r10[r15];
        if (r16.position() != r11[r15]) goto L29;
        if (r16.limit() != r12[r15]) goto L29;
        r16.position(r16.limit());
        if (r13 == false) goto L27;
        boolean r17 = true;
        if (r15 != (r10.length - 1)) goto L27;
    L28:
        u(new f(this, r16, r17));
        r15 = r15 + 1;
    L27:
        r17 = false;
    L29:
        p(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
        return;
    }

    public static ArrayList r(String[] r10) {
        ArrayList r11 = new ArrayList(r10.length / 2);
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11.add(new AbstractMap.SimpleImmutableEntry(r10[r12], r10[r12 + 1]));
        r12 = r12 + 2;
        goto L4
    L6:
        return r11;
    }

    public final void n(boolean r10) {
        com.ttnet.org.chromium.base.j.d(CronetUrlRequestContext.I, "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.f18505m != 0) goto L5;
        return;
    L5:
        com.ttnet.org.chromium.net.impl.a.b().destroy(this.f18505m, this, r10);
        this.f18493a.e0();
        this.f18505m = 0;
        Runnable r11 = this.f18509q;
        if (r11 == null) goto L9;
        r11.run();
        return;
    }

    public final void p(CronetException r10) {
        u(new e(this, r10));
    }

    public final void q(CronetException r10) {
        this.f18498f = r10;
        Object r11 = this.f18499g;
        monitor-enter(r11);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (s() == false) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L10:
        this.f18507o = 6;     // Catch: Throwable -> L8
        this.f18506n = 6;     // Catch: Throwable -> L8
        n(false);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        throw null;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception notifying of failed request", new Object[]{e});
    }

    public final boolean s() {
        if (this.f18506n != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f18505m != 0) goto L7;
        return true;
    }

    public final void t(Exception r10) {
        CallbackExceptionImpl r11 = new CallbackExceptionImpl("CalledByNative method has thrown an exception", r10);
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception in CalledByNative method", new Object[]{r10});
        q(r11);
    }

    public final void u(Runnable r10) {
        this.f18494b.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(CronetUrlRequestContext.I, "Exception posting task to executor", new Object[]{e});
        monitor-enter(this.f18499g);
        this.f18507o = 6;     // Catch: Throwable -> L11
        this.f18506n = 6;     // Catch: Throwable -> L11
        n(false);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final t v(int r12, String r13, String[] r14, long r15) {
        return new t(Arrays.asList(new String[]{this.f18495c}), r12, "", r(r14), false, r13, null, r15);
    }

    public final void w() {
        int r10 = this.f18501i.size();
        ByteBuffer[] r11 = new ByteBuffer[r10];
        int[] r12 = new int[r10];
        int[] r13 = new int[r10];
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L5;
        ByteBuffer r15 = (ByteBuffer) this.f18501i.poll();
        r11[r14] = r15;
        r12[r14] = r15.position();
        r13[r14] = r15.limit();
        r14 = r14 + 1;
        goto L3
    L5:
        this.f18507o = 9;
        this.f18503k = true;
        Natives r16 = com.ttnet.org.chromium.net.impl.a.b();
        long r17 = this.f18505m;
        if (this.f18502j == true) goto L8;
    L10:
        boolean r18 = false;
    L12:
        if (r16.writevData(r17, this, r11, r12, r13, r18) == false) goto L14;
        return;
    L14:
        this.f18507o = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    L8:
        if (this.f18500h.isEmpty() == false) goto L10;
        r18 = true;
        goto L12
    }
}
