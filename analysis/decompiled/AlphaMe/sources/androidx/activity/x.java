package androidx.activity;

import androidx.fragment.app.Q;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.G;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class x implements E, c {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0328z f2449a;

    /* renamed from: b, reason: collision with root package name */
    public final Q f2450b;

    /* renamed from: c, reason: collision with root package name */
    public y f2451c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ A f2452d;

    public x(A a4, AbstractC0328z lifecycle, Q onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.f2452d = a4;
        this.f2449a = lifecycle;
        this.f2450b = onBackPressedCallback;
        lifecycle.a(this);
    }

    @Override // androidx.lifecycle.E
    public final void a(G source, EnumC0326x event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != EnumC0326x.ON_START) {
            if (event != EnumC0326x.ON_STOP) {
                if (event == EnumC0326x.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                y yVar = this.f2451c;
                if (yVar != null) {
                    yVar.cancel();
                    return;
                }
                return;
            }
        }
        A a4 = this.f2452d;
        a4.getClass();
        Q onBackPressedCallback = this.f2450b;
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        a4.f2373b.add(onBackPressedCallback);
        y cancellable = new y(a4, onBackPressedCallback);
        onBackPressedCallback.getClass();
        Intrinsics.checkNotNullParameter(cancellable, "cancellable");
        onBackPressedCallback.f3638b.add(cancellable);
        a4.c();
        onBackPressedCallback.f3639c = new z(1, a4);
        this.f2451c = cancellable;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        this.f2449a.b(this);
        Q q4 = this.f2450b;
        q4.getClass();
        Intrinsics.checkNotNullParameter(this, "cancellable");
        q4.f3638b.remove(this);
        y yVar = this.f2451c;
        if (yVar != null) {
            yVar.cancel();
        }
        this.f2451c = null;
    }
}
