package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f4621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f4622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f4623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m.c f4625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IMultiInstanceInvalidationService f4626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IMultiInstanceInvalidationCallback f4627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f4628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ServiceConnection f4629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f4630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f4631l;

    public static final class a extends m.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p f4632b;

        public a(p r10, String[] r11) {
            this.f4632b = r10;
            super(r11);
        }

        @Override // androidx.room.m.c
        public boolean b() {
            return true;
        }

        @Override // androidx.room.m.c
        public void c(Set r10) {
            kotlin.jvm.internal.q.g(r10, "tables");
            if (this.f4632b.j().get() == false) goto L12;
            return;
        L12:
            IMultiInstanceInvalidationService r11 = this.f4632b.h();     // Catch: RemoteException -> L9
            if (r11 == null) goto L14;
            r11.broadcastInvalidation(this.f4632b.c(), (String[]) r10.toArray(new String[0]));     // Catch: RemoteException -> L9
            return;
        L14:
            return;
        L9:
            e = move-exception;
            Log.w("ROOM", "Cannot broadcast invalidation", e);
        }
    }

    public static final class b extends IMultiInstanceInvalidationCallback.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f4633a;

        public b(p r10) {
            this.f4633a = r10;
        }

        public static /* synthetic */ void b(p r10, String[] r11) {
            c(r10, r11);
        }

        public static final void c(p r10, String[] r11) {
            kotlin.jvm.internal.q.g(r10, "this$0");
            kotlin.jvm.internal.q.g(r11, "$tables");
            r10.e().m((String[]) Arrays.copyOf(r11, r11.length));
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(final String[] r10) {
            kotlin.jvm.internal.q.g(r10, "tables");
            Executor r11 = this.f4633a.d();
            final p r12 = this.f4633a;
            r11.execute(new q(r12, r10));
        }
    }

    public static final class c implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f4634a;

        public c(p r10) {
            this.f4634a = r10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            kotlin.jvm.internal.q.g(r10, "name");
            kotlin.jvm.internal.q.g(r11, "service");
            this.f4634a.m(IMultiInstanceInvalidationService.a.a(r11));
            this.f4634a.d().execute(this.f4634a.i());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            kotlin.jvm.internal.q.g(r10, "name");
            this.f4634a.d().execute(this.f4634a.g());
            this.f4634a.m(null);
        }
    }

    public p(Context r10, String r11, Intent r12, m r13, Executor r14) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "name");
        kotlin.jvm.internal.q.g(r12, "serviceIntent");
        kotlin.jvm.internal.q.g(r13, "invalidationTracker");
        kotlin.jvm.internal.q.g(r14, "executor");
        this.f4620a = r11;
        this.f4621b = r13;
        this.f4622c = r14;
        Context r15 = r10.getApplicationContext();
        this.f4623d = r15;
        this.f4627h = new b(this);
        this.f4628i = new AtomicBoolean(false);
        c r16 = new c(this);
        this.f4629j = r16;
        this.f4630k = new n(this);
        this.f4631l = new o(this);
        l(new a(this, (String[]) r13.k().keySet().toArray(new String[0])));
        r15.bindService(r12, r16, 1);
    }

    public static /* synthetic */ void a(p r10) {
        k(r10);
    }

    public static /* synthetic */ void b(p r10) {
        n(r10);
    }

    public static final void k(p r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4621b.p(r10.f());
    }

    public static final void n(p r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        IMultiInstanceInvalidationService r11 = r10.f4626g;     // Catch: RemoteException -> L7
        if (r11 == null) goto L12;
        r10.f4624e = r11.registerCallback(r10.f4627h, r10.f4620a);     // Catch: RemoteException -> L7
        r10.f4621b.c(r10.f());     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
    }

    public final int c() {
        return this.f4624e;
    }

    public final Executor d() {
        return this.f4622c;
    }

    public final m e() {
        return this.f4621b;
    }

    public final m.c f() {
        m.c r10 = this.f4625f;
        if (r10 == null) goto L5;
        return r10;
    L5:
        kotlin.jvm.internal.q.y("observer");
        return null;
    }

    public final Runnable g() {
        return this.f4631l;
    }

    public final IMultiInstanceInvalidationService h() {
        return this.f4626g;
    }

    public final Runnable i() {
        return this.f4630k;
    }

    public final AtomicBoolean j() {
        return this.f4628i;
    }

    public final void l(m.c r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.f4625f = r10;
    }

    public final void m(IMultiInstanceInvalidationService r10) {
        this.f4626g = r10;
    }
}
