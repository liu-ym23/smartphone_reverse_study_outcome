package z0;

import android.content.Context;
import android.net.ConnectivityManager;
import kotlin.jvm.internal.Intrinsics;
import s0.t;

/* renamed from: z0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1001i extends AbstractC0998f {

    /* renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f16404f;

    /* renamed from: g, reason: collision with root package name */
    public final C1000h f16405g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1001i(Context context, E0.a taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        Object systemService = this.f16398b.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f16404f = (ConnectivityManager) systemService;
        this.f16405g = new C1000h(this);
    }

    @Override // z0.AbstractC0998f
    public final Object a() {
        return AbstractC1002j.a(this.f16404f);
    }

    @Override // z0.AbstractC0998f
    public final void c() {
        try {
            t.d().a(AbstractC1002j.f16406a, "Registering network callback");
            C0.l.a(this.f16404f, this.f16405g);
        } catch (IllegalArgumentException e4) {
            t.d().c(AbstractC1002j.f16406a, "Received exception while registering network callback", e4);
        } catch (SecurityException e5) {
            t.d().c(AbstractC1002j.f16406a, "Received exception while registering network callback", e5);
        }
    }

    @Override // z0.AbstractC0998f
    public final void d() {
        try {
            t.d().a(AbstractC1002j.f16406a, "Unregistering network callback");
            C0.j.c(this.f16404f, this.f16405g);
        } catch (IllegalArgumentException e4) {
            t.d().c(AbstractC1002j.f16406a, "Received exception while unregistering network callback", e4);
        } catch (SecurityException e5) {
            t.d().c(AbstractC1002j.f16406a, "Received exception while unregistering network callback", e5);
        }
    }
}
