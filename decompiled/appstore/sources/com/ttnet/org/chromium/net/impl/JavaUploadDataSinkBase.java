package com.ttnet.org.chromium.net.impl;

import android.support.v4.media.session.PlaybackStateCompat;
import com.ttnet.org.chromium.net.y;
import com.ttnet.org.chromium.net.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JavaUploadDataSinkBase extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f18711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f18714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBuffer f18715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f18716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f18717g;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkState {
        public static final int AWAITING_READ_RESULT = 0;
        public static final int AWAITING_REWIND_RESULT = 1;
        public static final int NOT_STARTED = 3;
        public static final int UPLOADING = 2;
    }

    public class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f18718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JavaUploadDataSinkBase f18719b;

        public a(JavaUploadDataSinkBase r10, Executor r11) {
            this.f18719b = r10;
            this.f18718a = r11;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            this.f18718a.execute(r10);     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            this.f18719b.u(e);
        }
    }

    public class b implements JavaUrlRequestUtils$CheckedRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JavaUploadDataSinkBase f18721b;

        public class a implements JavaUrlRequestUtils$CheckedRunnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f18722a;

            public a(b r10) {
                this.f18722a = r10;
            }

            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
            public void run() {
                y r10 = JavaUploadDataSinkBase.k(this.f18722a.f18721b);
                JavaUploadDataSinkBase r11 = this.f18722a.f18721b;
                r10.b(r11, JavaUploadDataSinkBase.d(r11));
            }
        }

        public b(JavaUploadDataSinkBase r10, boolean r11) {
            this.f18721b = r10;
            this.f18720a = r11;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
        public void run() {
            JavaUploadDataSinkBase.d(this.f18721b).flip();
            if (JavaUploadDataSinkBase.f(this.f18721b) != (-1)) goto L5;
        L8:
            JavaUploadDataSinkBase r10 = this.f18721b;
            JavaUploadDataSinkBase.i(r10, r10.t(JavaUploadDataSinkBase.d(r10)));
            if (JavaUploadDataSinkBase.h(this.f18721b) >= JavaUploadDataSinkBase.f(this.f18721b)) goto L11;
        L22:
            JavaUploadDataSinkBase.d(this.f18721b).clear();
            JavaUploadDataSinkBase.j(this.f18721b).set(0);
            JavaUploadDataSinkBase.l(this.f18721b, new a(this));
            return;
        L11:
            if (JavaUploadDataSinkBase.f(this.f18721b) != (-1)) goto L16;
            if (this.f18720a == false) goto L22;
        L16:
            if (JavaUploadDataSinkBase.f(this.f18721b) != (-1)) goto L19;
            this.f18721b.o();
            return;
        L19:
            if (JavaUploadDataSinkBase.f(this.f18721b) != JavaUploadDataSinkBase.h(this.f18721b)) goto L21;
            this.f18721b.o();
            return;
        L21:
            this.f18721b.u(new IllegalArgumentException(String.format(Locale.getDefault(), "Read upload data length %d exceeds expected length %d", new Object[]{Long.valueOf(JavaUploadDataSinkBase.h(this.f18721b)), Long.valueOf(JavaUploadDataSinkBase.f(this.f18721b))})));
            return;
        L5:
            if ((JavaUploadDataSinkBase.f(this.f18721b) - JavaUploadDataSinkBase.h(this.f18721b)) >= JavaUploadDataSinkBase.d(this.f18721b).remaining()) goto L8;
            this.f18721b.u(new IllegalArgumentException(String.format(Locale.getDefault(), "Read upload data length %d exceeds expected length %d", new Object[]{Long.valueOf(JavaUploadDataSinkBase.h(this.f18721b) + ((long) JavaUploadDataSinkBase.d(this.f18721b).remaining())), Long.valueOf(JavaUploadDataSinkBase.f(this.f18721b))})));
        }
    }

    public class c implements JavaUrlRequestUtils$CheckedRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JavaUploadDataSinkBase f18723a;

        public class a implements JavaUrlRequestUtils$CheckedRunnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f18724a;

            public a(c r10) {
                this.f18724a = r10;
            }

            @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
            public void run() {
                y r10 = JavaUploadDataSinkBase.k(this.f18724a.f18723a);
                JavaUploadDataSinkBase r11 = this.f18724a.f18723a;
                r10.b(r11, JavaUploadDataSinkBase.d(r11));
            }
        }

        public c(JavaUploadDataSinkBase r10) {
            this.f18723a = r10;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
        public void run() {
            this.f18723a.r();
            JavaUploadDataSinkBase.j(this.f18723a).set(0);
            JavaUploadDataSinkBase.l(this.f18723a, new a(this));
        }
    }

    public class d implements JavaUrlRequestUtils$CheckedRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JavaUploadDataSinkBase f18726b;

        public d(JavaUploadDataSinkBase r10, boolean r11) {
            this.f18726b = r10;
            this.f18725a = r11;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUrlRequestUtils$CheckedRunnable
        public void run() {
            JavaUploadDataSinkBase r10 = this.f18726b;
            JavaUploadDataSinkBase.g(r10, JavaUploadDataSinkBase.k(r10).a());
            if (JavaUploadDataSinkBase.f(this.f18726b) != 0) goto L6;
            this.f18726b.o();
            return;
        L6:
            if (JavaUploadDataSinkBase.f(this.f18726b) > 0) goto L8;
        L10:
            JavaUploadDataSinkBase.e(this.f18726b, ByteBuffer.allocateDirect(8192));
        L11:
            JavaUploadDataSinkBase r11 = this.f18726b;
            r11.s(JavaUploadDataSinkBase.f(r11));
            if (this.f18725a == false) goto L14;
            JavaUploadDataSinkBase.m(this.f18726b);
            return;
        L14:
            JavaUploadDataSinkBase.j(this.f18726b).set(1);
            JavaUploadDataSinkBase.k(this.f18726b).c(this.f18726b);
            return;
        L8:
            if (JavaUploadDataSinkBase.f(this.f18726b) >= PlaybackStateCompat.ACTION_PLAY_FROM_URI) goto L10;
            JavaUploadDataSinkBase r12 = this.f18726b;
            JavaUploadDataSinkBase.e(r12, ByteBuffer.allocateDirect(((int) JavaUploadDataSinkBase.f(r12)) + 1));
            goto L11
        }
    }

    public JavaUploadDataSinkBase(Executor r10, Executor r11, y r12) {
        this.f18711a = new AtomicReference(3);
        this.f18712b = new a(this, r10);
        this.f18713c = r11;
        this.f18714d = r12;
    }

    public static /* synthetic */ ByteBuffer d(JavaUploadDataSinkBase r10) {
        return r10.f18715e;
    }

    public static /* synthetic */ ByteBuffer e(JavaUploadDataSinkBase r10, ByteBuffer r11) {
        r10.f18715e = r11;
        return r11;
    }

    public static /* synthetic */ long f(JavaUploadDataSinkBase r10) {
        return r10.f18716f;
    }

    public static /* synthetic */ long g(JavaUploadDataSinkBase r10, long r11) {
        r10.f18716f = r11;
        return r11;
    }

    public static /* synthetic */ long h(JavaUploadDataSinkBase r10) {
        return r10.f18717g;
    }

    public static /* synthetic */ long i(JavaUploadDataSinkBase r10, long r11) {
        long r12 = r10.f18717g + r11;
        r10.f18717g = r12;
        return r12;
    }

    public static /* synthetic */ AtomicReference j(JavaUploadDataSinkBase r10) {
        return r10.f18711a;
    }

    public static /* synthetic */ y k(JavaUploadDataSinkBase r10) {
        return r10.f18714d;
    }

    public static /* synthetic */ void l(JavaUploadDataSinkBase r10, JavaUrlRequestUtils$CheckedRunnable r11) {
        r10.n(r11);
    }

    public static /* synthetic */ void m(JavaUploadDataSinkBase r10) {
        r10.w();
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(boolean r10) {
        if (androidx.lifecycle.p.a(this.f18711a, 0, 2) == false) goto L7;
        this.f18713c.execute(p(new b(this, r10)));
        return;
    L7:
        throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.f18711a.get());
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b(Exception r10) {
        u(r10);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void c() {
        if (androidx.lifecycle.p.a(this.f18711a, 1, 2) == false) goto L7;
        w();
        return;
    L7:
        throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.f18711a.get());
    }

    public final void n(JavaUrlRequestUtils$CheckedRunnable r10) {
        this.f18712b.execute(q(r10));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        u(e);
    }

    public abstract void o();

    public abstract Runnable p(JavaUrlRequestUtils$CheckedRunnable r10);

    public abstract Runnable q(JavaUrlRequestUtils$CheckedRunnable r10);

    public abstract void r();

    public abstract void s(long r10);

    public abstract int t(ByteBuffer r10);

    public abstract void u(Throwable r10);

    public void v(boolean r10) {
        n(new d(this, r10));
    }

    public final void w() {
        this.f18713c.execute(p(new c(this)));
    }
}
