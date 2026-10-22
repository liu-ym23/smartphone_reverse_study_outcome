package com.obric.aiagent.ipc.utils;

import android.os.IBinder;
import android.os.IInterface;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import d.n;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: IPCManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private static final String TAG = "IPCManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f18671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class<? extends IInterface>, IInterface> f18672b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> f18673c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<Class<? extends IInterface>, m<IBinder, IBinder.DeathRecipient>> f18674d = null;

    /* JADX INFO: compiled from: IPCManager.kt */
    public static final class a<S extends IInterface> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b<S> f18675a;

        public a(b<S> r3) {
            b<S> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
            o.e(r4, "action");
            this.f18675a = r4;
        }

        public final b<S> a() {
            return this.f18675a;
        }

        public final boolean a(IInterface r3) {
            IInterface r4 = (IInterface) ZeusTransformUtils.wrapperContextForParams(r3, IInterface.class, "com.obric.aiagent.plugin");
            o.e(r4, "i");
            if (r4 == null) goto L5;
            this.f18675a.onRegister((S) r4);
            x r2 = x.f38692a;
        L6:
            if (r2 == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            r2 = null;
            goto L6
        }
    }

    /* JADX INFO: compiled from: IPCManager.kt */
    public interface b<S> {
        void onRegister(S r1);
    }

    public static /* synthetic */ boolean lambda$kkMvlJdKrpR3Sp8x49KGESgic6w(b r0, a r1) {
        return a(r0, r1);
    }

    private i() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f18674d;
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return f18672b;
    }

    static {
        f18671a = new i();
        f18672b = new ConcurrentHashMap();
        f18673c = new ConcurrentHashMap();
        f18674d = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <S extends IInterface> void a(final Class<S> r8, S r9) {
        IInterface r10 = (IInterface) ZeusTransformUtils.wrapperContextForParams(r9, IInterface.class, "com.obric.aiagent.plugin");
        o.e(r8, "clz");
        o.e(r10, "stub");
        final IBinder r0 = r10.asBinder();
        n.a r2 = n.f38560a;     // Catch: Throwable -> L27
        i r7 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        IBinder.DeathRecipient r3 = new IPCManager$registerInterface$1$recipient$1(r8, r0);     // Catch: Throwable -> L27
        ConcurrentHashMap<Class<? extends IInterface>, m<IBinder, IBinder.DeathRecipient>> r4 = f18674d;     // Catch: Throwable -> L27
        monitor-enter(r4);     // Catch: Throwable -> L27
        m<IBinder, IBinder.DeathRecipient> r5 = r4.get(r8);     // Catch: Throwable -> L24
        r0.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r3, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L24
        ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(r8, s.a(r0, r3));     // Catch: Throwable -> L24
        x r6 = x.f38692a;     // Catch: Throwable -> L24
        monitor-exit(r4);     // Catch: Throwable -> L27
        ConcurrentHashMap<Class<? extends IInterface>, IInterface> r11 = f18672b;     // Catch: Throwable -> L27
        monitor-enter(r11);     // Catch: Throwable -> L27
        ((Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.aiagent.plugin")).put(r8, r10);     // Catch: Throwable -> L21
        x r12 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(r11);     // Catch: Throwable -> L27
        r7.b(r8, r10);     // Catch: Throwable -> L27
        m r13 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r13 == null) goto L19;
        Object r14 = r13.a();     // Catch: Throwable -> L27
        n.a r15 = n.f38560a;     // Catch: Throwable -> L16
        Object r16 = n.f(Boolean.valueOf(((IBinder) ZeusTransformUtils.preCheckCast(r14, IBinder.class, "com.obric.aiagent.plugin")).unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r13.b(), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0)));     // Catch: Throwable -> L16
    L18:
        n r17 = n.g(r16);     // Catch: Throwable -> L27
    L20:
        Object r18 = n.f(r17);     // Catch: Throwable -> L27
    L30:
        if (n.c(r18) == null) goto L69;
        ConcurrentHashMap<Class<? extends IInterface>, m<IBinder, IBinder.DeathRecipient>> r19 = f18674d;
        monitor-enter(r19);
        m r20 = (m) ZeusTransformUtils.preCheckCast(r19.get(r8), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
        if (r20 != null) goto L37;
    L43:
        x r21 = x.f38692a;     // Catch: Throwable -> L53
        monitor-exit(r19);
        ConcurrentHashMap<Class<? extends IInterface>, IInterface> r22 = f18672b;
        monitor-enter(r22);
        IInterface r23 = (IInterface) ZeusTransformUtils.preCheckCast(r22.remove(r8), IInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L50
        monitor-exit(r22);
        return;
    L50:
        th = move-exception;
        throw th;
    L37:
        if (r20.a() != r0) goto L43;
        r19.remove(r8, r20);     // Catch: Throwable -> L53
        n.a r24 = n.f38560a;     // Catch: Throwable -> L41
        n.f(Boolean.valueOf(r0.unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r20.b(), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0)));     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L53
        n.f(d.o.a(th));     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L69:
        return;
    L16:
        th = move-exception;
        n.a r25 = n.f38560a;     // Catch: Throwable -> L27
        r16 = n.f(d.o.a(th));     // Catch: Throwable -> L27
        goto L18
    L19:
        r17 = null;
        goto L20
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        n.a r26 = n.f38560a;
        r18 = n.f(d.o.a(th));
        goto L30
    }

    public final <S extends IInterface> S a(Class<S> r3) {
        o.e(r3, "clz");
        ConcurrentHashMap<Class<? extends IInterface>, IInterface> r2 = f18672b;
        monitor-enter(r2);
        IInterface r4 = (IInterface) ZeusTransformUtils.preCheckCast(r2.get(r3), IInterface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        S r0 = null;
        if (r4 == null) goto L11;
        if (ZeusTransformUtils.instanceOf(r4, IInterface.class) == true) goto L10;
        r4 = null;
    L10:
        r0 = (S) r4;
    L11:
        monitor-exit(r2);
        return r0;
    L13:
        th = move-exception;
        throw th;
    }

    public final <S extends IInterface> void a(Class<S> r5, b<S> r6, boolean r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        o.e(r5, "clz");
        o.e(r8, "action");
        ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> r0 = f18673c;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r0.get(r5), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        r2 = new CopyOnWriteArrayList();
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(r5, r2);
    L5:
        r2.add(new a(r8));
        if (r7 == false) goto L11;
        IInterface r4 = a(r5);
        if (r4 == null) goto L12;
        ILogDepend.Companion.i(TAG, "addRegisterAction, immediate, " + r5 + ", " + r8);
        r8.onRegister(r4);
        return;
    L12:
        return;
    }

    public final <S extends IInterface> void a(Class<S> r4, b<S> r5) {
        final b r3 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "clz");
        o.e(r3, "action");
        ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> r6 = f18673c;
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r6.get(r4), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = new CopyOnWriteArrayList();
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")).put(r4, r1);
    L5:
        p.a((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), new $$Lambda$i$kkMvlJdKrpR3Sp8x49KGESgic6w(r3));
    }

    private static final boolean a(b r2, a r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        return o.a(r3.a(), r4);
    }

    private final <S extends IInterface> void b(Class<S> r4, S r5) {
        IInterface r3 = (IInterface) ZeusTransformUtils.wrapperContextForParams(r5, IInterface.class, "com.obric.aiagent.plugin");
        ConcurrentHashMap<Class<? extends IInterface>, CopyOnWriteArrayList<a<?>>> r6 = f18673c;
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) ZeusTransformUtils.preCheckCast(r6.get(r4), CopyOnWriteArrayList.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = new CopyOnWriteArrayList();
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")).put(r4, r1);
    L5:
        Iterator r7 = r1.iterator();
        o.c(r7, "iterator(...)");
    L7:
        if (r7.hasNext() == false) goto L11;
        a r8 = (a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.aiagent.plugin");
        if (r8.a(r3) == true) goto L7;
        r1.remove(r8);
        goto L7
    }
}
