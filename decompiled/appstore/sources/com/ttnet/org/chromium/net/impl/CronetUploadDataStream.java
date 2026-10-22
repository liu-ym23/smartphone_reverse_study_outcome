package com.ttnet.org.chromium.net.impl;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.y;
import com.ttnet.org.chromium.net.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("cronet")
@VisibleForTesting
public final class CronetUploadDataStream extends z {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f18559o = "CronetUploadDataStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f18560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VersionSafeCallbacks.f f18561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CronetUrlRequest f18562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f18563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f18565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f18566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f18567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ByteBuffer f18568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f18569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f18570k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f18571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Runnable f18573n;

    public interface Natives {
        long attachUploadDataToRequest(CronetUploadDataStream r10, long r11, long r12);

        long createAdapterForTesting(CronetUploadDataStream r10);

        long createUploadDataStreamForTesting(CronetUploadDataStream r10, long r11, long r12);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void destroy(long r10);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onReadSucceeded(long r10, CronetUploadDataStream r11, int r12, boolean r13);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void onRewindSucceeded(long r10, CronetUploadDataStream r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserCallback {
        public static final int GET_LENGTH = 2;
        public static final int NOT_IN_CALLBACK = 3;
        public static final int READ = 0;
        public static final int REWIND = 1;
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f18574a;

        static {
        }

        public a(CronetUploadDataStream r10) {
            this.f18574a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = CronetUploadDataStream.d(this.f18574a);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetUploadDataStream.e(this.f18574a) != 0) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetUploadDataStream.f(this.f18574a, 3);     // Catch: Throwable -> L8
            if (CronetUploadDataStream.g(this.f18574a) == null) goto L20;
            CronetUploadDataStream.h(this.f18574a, 0);     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            CronetUploadDataStream.i(this.f18574a);     // Catch: Exception -> L16
            VersionSafeCallbacks.f r11 = CronetUploadDataStream.j(this.f18574a);     // Catch: Exception -> L16
            CronetUploadDataStream r12 = this.f18574a;     // Catch: Exception -> L16
            r11.b(r12, CronetUploadDataStream.g(r12));     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            CronetUploadDataStream.k(this.f18574a, e);
            return;
        L20:
            throw new IllegalStateException("Unexpected readData call. Buffer is null");     // Catch: Throwable -> L8
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f18575a;

        public b(CronetUploadDataStream r10) {
            this.f18575a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = CronetUploadDataStream.d(this.f18575a);
            monitor-enter(r10);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (CronetUploadDataStream.e(this.f18575a) != 0) goto L10;
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L10:
            CronetUploadDataStream.f(this.f18575a, 3);     // Catch: Throwable -> L8
            CronetUploadDataStream.h(this.f18575a, 1);     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            CronetUploadDataStream.i(this.f18575a);     // Catch: Exception -> L14
            CronetUploadDataStream.j(this.f18575a).c(this.f18575a);     // Catch: Exception -> L14
            return;
        L14:
            e = move-exception;
            CronetUploadDataStream.k(this.f18575a, e);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f18576a;

        public c(CronetUploadDataStream r10) {
            this.f18576a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetUploadDataStream.i(this.f18576a);     // Catch: Exception -> L6
            if (CronetUploadDataStream.l(this.f18576a) == true) goto L11;
            CronetUploadDataStream.j(this.f18576a).close();     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a(CronetUploadDataStream.m(), "Exception thrown when closing", new Object[]{e});
        }
    }

    static {
    }

    public CronetUploadDataStream(y r10, Executor r11, CronetUrlRequest r12) {
        this.f18567h = new a(this);
        this.f18569j = new Object();
        this.f18571l = 3;
        this.f18560a = r11;
        this.f18561b = new VersionSafeCallbacks.f(r10);
        this.f18562c = r12;
        this.f18566g = false;
    }

    public static /* synthetic */ Object d(CronetUploadDataStream r10) {
        return r10.f18569j;
    }

    public static /* synthetic */ long e(CronetUploadDataStream r10) {
        return r10.f18570k;
    }

    public static /* synthetic */ void f(CronetUploadDataStream r10, int r11) {
        r10.p(r11);
    }

    public static /* synthetic */ ByteBuffer g(CronetUploadDataStream r10) {
        return r10.f18568i;
    }

    public static /* synthetic */ int h(CronetUploadDataStream r10, int r11) {
        r10.f18571l = r11;
        return r11;
    }

    public static /* synthetic */ void i(CronetUploadDataStream r10) {
        r10.o();
    }

    public static /* synthetic */ VersionSafeCallbacks.f j(CronetUploadDataStream r10) {
        return r10.f18561b;
    }

    public static /* synthetic */ void k(CronetUploadDataStream r10, Throwable r11) {
        r10.t(r11);
    }

    public static /* synthetic */ boolean l(CronetUploadDataStream r10) {
        return r10.f18566g;
    }

    public static /* synthetic */ String m() {
        return f18559o;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(boolean r12) {
        Object r10 = this.f18569j;
        monitor-enter(r10);
        p(0);     // Catch: Throwable -> L14
        if (this.f18565f != this.f18568i.limit()) goto L31;
        if (r12 == true) goto L10;
    L16:
        int r11 = this.f18568i.position();     // Catch: Throwable -> L14
        long r13 = this.f18564e - ((long) r11);     // Catch: Throwable -> L14
        this.f18564e = r13;     // Catch: Throwable -> L14
        if (r13 < 0) goto L19;
    L23:
        this.f18568i.position(0);     // Catch: Throwable -> L14
        this.f18568i = null;     // Catch: Throwable -> L14
        this.f18571l = 3;     // Catch: Throwable -> L14
        r();     // Catch: Throwable -> L14
        if (this.f18570k != 0) goto L27;
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L27:
        d.b().onReadSucceeded(this.f18570k, this, r11, r12);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L19:
        if (this.f18563d < 0) goto L23;
        throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", new Object[]{Long.valueOf(this.f18563d - this.f18564e), Long.valueOf(this.f18563d)}));     // Catch: Throwable -> L14
    L10:
        if (this.f18563d < 0) goto L16;
        throw new IllegalArgumentException("Non-chunked upload can't have last chunk");     // Catch: Throwable -> L14
    L31:
        throw new IllegalStateException("ByteBuffer limit changed");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b(Exception r10) {
        Object r11 = this.f18569j;
        monitor-enter(r11);
        p(1);     // Catch: Throwable -> L8
        t(r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void c() {
        Object r10 = this.f18569j;
        monitor-enter(r10);
        p(1);     // Catch: Throwable -> L9
        this.f18571l = 3;     // Catch: Throwable -> L9
        this.f18564e = this.f18563d;     // Catch: Throwable -> L9
        if (this.f18570k != 0) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L11:
        d.b().onRewindSucceeded(this.f18570k, this);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void n(long r10) {
        Object r11 = this.f18569j;
        monitor-enter(r11);
        this.f18570k = d.b().attachUploadDataToRequest(this, r10, this.f18563d);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void o() {
        this.f18562c.F();
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        q();
    }

    public final void p(int r10) {
        if (this.f18571l != r10) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r10 + ", but was " + this.f18571l);
    }

    public final void q() {
        Object r10 = this.f18569j;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f18571l != 0) goto L12;
        this.f18572m = true;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.f18570k != 0) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L15:
        d.b().destroy(this.f18570k);     // Catch: Throwable -> L9
        this.f18570k = 0;     // Catch: Throwable -> L9
        Runnable r11 = this.f18573n;     // Catch: Throwable -> L9
        if (r11 == null) goto L18;
        r11.run();     // Catch: Throwable -> L9
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L9
        u(new c(this));
    }

    public final void r() {
        Object r10 = this.f18569j;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f18571l == 0) goto L14;
        if (this.f18572m == false) goto L11;
        q();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L14:
        throw new IllegalStateException("Method should not be called when read has not completed.");     // Catch: Throwable -> L9
    }

    @CalledByNative
    public void readData(ByteBuffer r10) {
        this.f18568i = r10;
        this.f18565f = r10.limit();
        u(this.f18567h);
    }

    @CalledByNative
    public void rewind() {
        u(new b(this));
    }

    public void s() {
        Object r10 = this.f18569j;
        monitor-enter(r10);
        this.f18571l = 2;     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Throwable -> L20
        this.f18562c.F();     // Catch: Throwable -> L9
        long r11 = this.f18561b.a();     // Catch: Throwable -> L9
        this.f18563d = r11;     // Catch: Throwable -> L9
        this.f18564e = r11;     // Catch: Throwable -> L9
    L11:
        Object r12 = this.f18569j;
        monitor-enter(r12);
        this.f18571l = 3;     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        t(th);
    L20:
        th = move-exception;
        throw th;
    }

    public final void t(Throwable r10) {
        Object r11 = this.f18569j;
        monitor-enter(r11);
        int r12 = this.f18571l;     // Catch: Throwable -> L19
        if (r12 == 3) goto L22;
        if (r12 != 2) goto L9;
        boolean r13 = true;
    L10:
        this.f18571l = 3;     // Catch: Throwable -> L19
        this.f18568i = null;     // Catch: Throwable -> L19
        r();     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        if (r13 == true) goto L26;
    L17:
        this.f18562c.Q(r10);
        return;
    L26:
        this.f18561b.close();     // Catch: Exception -> L15
        this.f18566g = true;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a(f18559o, "Failure closing data provider", new Object[]{e});
        goto L17
    L9:
        r13 = false;
        goto L10
    L22:
        throw new IllegalStateException("There is no read or rewind or length check in progress.");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public void u(Runnable r10) {
        this.f18560a.execute(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CronetUrlRequest r11 = this.f18562c;
        if (r11 == null) goto L10;
        r11.Q(th);
        return;
    L10:
        throw new IllegalStateException("Unexpected request usage, caught in CronetUploadDataStream, caused by " + th);
    }
}
