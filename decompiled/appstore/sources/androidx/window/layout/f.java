package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class f implements WindowBackend {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f5315c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile f f5316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f5317e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExtensionInterfaceCompat f5318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f5319b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final f a(Context r10) {
            q.g(r10, "context");
            if (f.a() != null) goto L14;
            ReentrantLock r11 = f.b();
            r11.lock();
        L8:
            th = move-exception;
            r11.unlock();
            throw th;
        L6:
            if (f.a() != null) goto L10;
            f.c(new f(f.f5315c.b(r10)));     // Catch: Throwable -> L8
        L10:
            Unit r12 = Unit.f21064a;     // Catch: Throwable -> L8
            r11.unlock();
        L14:
            f r13 = f.a();
            q.d(r13);
            return r13;
        }

        public final ExtensionInterfaceCompat b(Context r10) {
            q.g(r10, "context");
            if (c(SidecarCompat.f5268f.c()) == false) goto L13;
            SidecarCompat r11 = new SidecarCompat(r10);     // Catch: Throwable -> L10
            if (r11.validateExtensionInterface() == true) goto L9;
            return null;
        L9:
            return r11;
        L13:
            return null;
        L15:
            return null;
        }

        public final boolean c(Version r10) {
            if (r10 != null) goto L6;
            return false;
        L6:
            if (r10.b(Version.f5223f.a()) < 0) goto L9;
            return true;
        L9:
            return false;
        }

        public a() {
        }
    }

    public final class b implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f5320a;

        public b(f r10) {
            q.g(r10, "this$0");
            this.f5320a = r10;
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity r10, i r11) {
            q.g(r10, "activity");
            q.g(r11, "newLayout");
            Iterator r12 = this.f5320a.f().iterator();
        L4:
            if (r12.hasNext() == false) goto L9;
            c r13 = (c) r12.next();
            if (q.b(r13.d(), r10) == false) goto L4;
            r13.b(r11);
            goto L4
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f5321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f5322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Consumer f5323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i f5324d;

        public c(Activity r10, Executor r11, Consumer r12) {
            q.g(r10, "activity");
            q.g(r11, "executor");
            q.g(r12, "callback");
            this.f5321a = r10;
            this.f5322b = r11;
            this.f5323c = r12;
        }

        public static /* synthetic */ void a(c r10, i r11) {
            c(r10, r11);
        }

        public static final void c(c r10, i r11) {
            q.g(r10, "this$0");
            q.g(r11, "$newLayoutInfo");
            r10.f5323c.accept(r11);
        }

        public final void b(final i r10) {
            q.g(r10, "newLayoutInfo");
            this.f5324d = r10;
            this.f5322b.execute(new g(this, r10));
        }

        public final Activity d() {
            return this.f5321a;
        }

        public final Consumer e() {
            return this.f5323c;
        }

        public final i f() {
            return this.f5324d;
        }
    }

    static {
        f5315c = new a(null);
        f5317e = new ReentrantLock();
    }

    public f(ExtensionInterfaceCompat r10) {
        this.f5318a = r10;
        this.f5319b = new CopyOnWriteArrayList();
        ExtensionInterfaceCompat r11 = this.f5318a;
        if (r11 == null) goto L7;
        r11.setExtensionCallback(new b(this));
        return;
    }

    public static final /* synthetic */ f a() {
        return f5316d;
    }

    public static final /* synthetic */ ReentrantLock b() {
        return f5317e;
    }

    public static final /* synthetic */ void c(f r10) {
        f5316d = r10;
    }

    public final void d(Activity r10) {
        CopyOnWriteArrayList r11 = this.f5319b;
        if (r11 != null) goto L5;
    L7:
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        if (q.b(((c) r12.next()).d(), r10) == false) goto L9;
        return;
    L13:
        ExtensionInterfaceCompat r13 = this.f5318a;
        if (r13 == null) goto L21;
        r13.onWindowLayoutChangeListenerRemoved(r10);
        return;
    L21:
        return;
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L7
    }

    public final ExtensionInterfaceCompat e() {
        return this.f5318a;
    }

    public final CopyOnWriteArrayList f() {
        return this.f5319b;
    }

    public final boolean g(Activity r10) {
        CopyOnWriteArrayList r11 = this.f5319b;
        if (r11 != null) goto L5;
    L7:
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L18;
        if (q.b(((c) r12.next()).d(), r10) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return false;
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(Activity r10, Executor r11, Consumer r12) {
        q.g(r10, "activity");
        q.g(r11, "executor");
        q.g(r12, "callback");
        ReentrantLock r13 = f5317e;
        r13.lock();
        ExtensionInterfaceCompat r14 = e();     // Catch: Throwable -> L8
        if (r14 != null) goto L10;
        r12.accept(new i(t.i()));     // Catch: Throwable -> L8
        r13.unlock();
        return;
    L10:
        boolean r15 = g(r10);     // Catch: Throwable -> L8
        c r16 = new c(r10, r11, r12);     // Catch: Throwable -> L8
        f().add(r16);     // Catch: Throwable -> L8
        if (r15 == true) goto L13;
        r14.onWindowLayoutChangeListenerAdded(r10);     // Catch: Throwable -> L8
    L26:
        Unit r17 = Unit.f21064a;     // Catch: Throwable -> L8
        r13.unlock();
        return;
    L13:
        Iterator r18 = f().iterator();     // Catch: Throwable -> L8
    L14:
        i r19 = null;
        if (r18.hasNext() == false) goto L19;
        Object r20 = r18.next();     // Catch: Throwable -> L8
        if (q.b(r10, ((c) r20).d()) == false) goto L14;
    L20:
        c r21 = (c) r20;     // Catch: Throwable -> L8
        if (r21 == null) goto L24;
        r19 = r21.f();     // Catch: Throwable -> L8
    L24:
        if (r19 == null) goto L26;
        r16.b(r19);     // Catch: Throwable -> L8
        goto L26
    L19:
        r20 = null;
    L8:
        th = move-exception;
        r13.unlock();
        throw th;
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(Consumer r10) {
        q.g(r10, "callback");
        ReentrantLock r11 = f5317e;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (e() != null) goto L8;
        monitor-exit(r11);
        return;
    L8:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r13 = f().iterator();     // Catch: Throwable -> L14
    L10:
        if (r13.hasNext() == false) goto L16;
        c r14 = (c) r13.next();     // Catch: Throwable -> L14
        if (r14.e() != r10) goto L10;
        q.f(r14, "callbackWrapper");     // Catch: Throwable -> L14
        r12.add(r14);     // Catch: Throwable -> L14
        goto L10
    L16:
        f().removeAll(r12);     // Catch: Throwable -> L14
        Iterator r15 = r12.iterator();     // Catch: Throwable -> L14
    L18:
        if (r15.hasNext() == false) goto L20;
        d(((c) r15.next()).d());     // Catch: Throwable -> L14
        goto L18
    L20:
        Unit r16 = Unit.f21064a;     // Catch: Throwable -> L14
        monitor-exit(r11);
    }
}
