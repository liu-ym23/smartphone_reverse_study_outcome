package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
public class ViewModel<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> implements com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f180755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e f180756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> f180757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f180758d;

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public final com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> getContext() {
        com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> r100 = this.f180757c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public ViewModel() {
        this.f180758d = LazyKt.lazy(new ViewModel$lifecycleScope$2(this));
    }

    public static com.bytedance.android.shopping.prepurchase.arch.container.ability.a a(ViewModel r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getAbility");
        Intrinsics.checkNotNullParameter(r101, "service");
        j r102 = r100.f180755a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("serviceRegistry");
    L6:
        return r102.getService(r101);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.d
    public final void h0(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = k.f180766a[r101.ordinal()];
        if (r102 != 1) goto L5;
        c();
        return;
    L5:
        if (r102 != 6) goto L7;
        d();
        return;
    L7:
        if (r102 != 3) goto L9;
        b();
        return;
    L9:
        if (r102 != 4) goto L19;
        e();
        return;
    }

    public static void f(ViewModel r100, Class r101, Function3 r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$whenAbilityAvailable");
        Intrinsics.checkNotNullParameter(r101, "service");
        Intrinsics.checkNotNullParameter(r102, "block");
        BuildersKt.launch$default((CoroutineScope) r100.f180758d.getValue(), null, null, new ViewModel$whenAbilityAvailable$1(r100, r102, r101, null), 3, null);
    }
}
