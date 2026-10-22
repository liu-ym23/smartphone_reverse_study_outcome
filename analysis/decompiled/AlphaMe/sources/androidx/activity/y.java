package androidx.activity;

import androidx.fragment.app.Q;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class y implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Q f2453a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f2454b;

    public y(A a4, Q onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.f2454b = a4;
        this.f2453a = onBackPressedCallback;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        A a4 = this.f2454b;
        ArrayDeque arrayDeque = a4.f2373b;
        Q q4 = this.f2453a;
        arrayDeque.remove(q4);
        if (Intrinsics.areEqual(a4.f2374c, q4)) {
            q4.getClass();
            a4.f2374c = null;
        }
        q4.getClass();
        Intrinsics.checkNotNullParameter(this, "cancellable");
        q4.f3638b.remove(this);
        Function0 function0 = q4.f3639c;
        if (function0 != null) {
            function0.invoke();
        }
        q4.f3639c = null;
    }
}
