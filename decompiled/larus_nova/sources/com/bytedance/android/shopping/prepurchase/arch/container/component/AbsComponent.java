package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import vg3.d0;
import vg3.s;

/* JADX INFO: loaded from: classes13.dex */
public abstract class AbsComponent<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f180735h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f180737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f180738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> f180739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f180740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<com.bytedance.android.shopping.prepurchase.arch.container.ability.a> f180741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<f> f180742g;

    public static final class a {
    }

    public final LifecycleRegistry P1() {
        return (LifecycleRegistry) this.f180736a.getValue();
    }

    public final CoroutineScope Q1() {
        return (CoroutineScope) this.f180737b.getValue();
    }

    public void T1() {
        this.f180738c = false;
        P1().f(Lifecycle.Event.ON_CREATE);
    }

    public void U1() {
        this.f180738c = true;
        P1().f(Lifecycle.Event.ON_DESTROY);
    }

    static {
        f180735h = LazyKt.lazy(AbsComponent$Companion$AUTO_UNREGISTER$2.INSTANCE);
    }

    public List<Class<?>> M1() {
        return CollectionsKt.listOf(d0.class);
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> O1() {
        com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> r100 = this.f180739d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public final j R1() {
        j r100 = this.f180740e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L5:
        return r100;
    }

    public AbsComponent() {
        this.f180736a = LazyKt.lazy(new AbsComponent$lifecycleRegistry$2(this));
        this.f180737b = LazyKt.lazy(new AbsComponent$lifecycleScope$2(this));
        this.f180741f = new LinkedHashSet();
        this.f180742g = new ArrayList();
    }

    public void S1() {
        P1().f(Lifecycle.Event.ON_RESUME);
    }

    public void V1() {
        P1().f(Lifecycle.Event.ON_PAUSE);
    }

    public void W1() {
        P1().f(Lifecycle.Event.ON_START);
    }

    public void X1() {
        P1().f(Lifecycle.Event.ON_STOP);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e
    public final Lifecycle getLifecycle() {
        return P1();
    }

    public void K1() {
        T1();
    }

    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T N1(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        j r101 = this.f180740e;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L6:
        return (T) r101.getService(r100);
    }

    public final void J1(s r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addAbilityUnregisterListener");
        Intrinsics.checkNotNullParameter(r101, "listener");
        ((ArrayList) this.f180742g).add(r101);
        j r102 = this.f180740e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L5:
        r102.c(r101);
    }

    public final void L1(com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "serviceRegistry");
        this.f180739d = r100;
        this.f180740e = r101.d(getClass().getSimpleName(), new AbsComponent$attachContext$1(this));
    }

    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void Z1(Class<T> r100, Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "block");
        BuildersKt.launch$default(Q1(), null, null, new AbsComponent$whenAbilityAvailable$1(this, r101, r100, null), 3, null);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        switch(com.bytedance.android.shopping.prepurchase.arch.container.component.a.f180759a[r101.ordinal()]) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L5;
            default: goto L49;
        };
    L5:
        U1();
        Set<com.bytedance.android.shopping.prepurchase.arch.container.ability.a> r102 = this.f180741f;
        monitor-enter(r102);
    L27:
        th = move-exception;
        throw th;
    L8:
        if ((!this.f180741f.isEmpty()) == false) goto L17;
        Iterator<T> r103 = this.f180741f.iterator();     // Catch: Throwable -> L27
    L11:
        if (r103.hasNext() == false) goto L16;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r104 = (com.bytedance.android.shopping.prepurchase.arch.container.ability.a) r103.next();     // Catch: Throwable -> L27
        j r105 = this.f180740e;     // Catch: Throwable -> L27
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");     // Catch: Throwable -> L27
    L15:
        r105.b(r104);     // Catch: Throwable -> L27
        goto L11
    L16:
        this.f180741f.clear();     // Catch: Throwable -> L27
    L17:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r102);
        Iterator r107 = ((ArrayList) this.f180742g).iterator();
    L21:
        if (r107.hasNext() == false) goto L26;
        f r108 = (f) r107.next();
        j r109 = this.f180740e;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L25:
        r109.a(r108);
        goto L21
    L26:
        ((ArrayList) this.f180742g).clear();
        return;
    L30:
        X1();
        return;
    L31:
        V1();
        return;
    L32:
        S1();
        return;
    L33:
        W1();
        return;
    L34:
        K1();
        return;
    }

    public static void Y1(AbsComponent r100, Class r101, com.bytedance.android.shopping.prepurchase.arch.container.ability.a r102, boolean r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        boolean r105 = ((Boolean) f180735h.getValue()).booleanValue();
    L7:
        if ((r104 & 8) == 0) goto L9;
        r103 = false;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "inst");
        if (r105 == false) goto L19;
        Set<com.bytedance.android.shopping.prepurchase.arch.container.ability.a> r106 = r100.f180741f;
        monitor-enter(r106);
        r100.f180741f.add(r102);     // Catch: Throwable -> L16
        monitor-exit(r106);
    L16:
        th = move-exception;
        throw th;
    L19:
        j r107 = r100.f180740e;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L22:
        r107.f(r101, r102, r103);
        return;
    L5:
        r105 = false;
        goto L7
    }
}
