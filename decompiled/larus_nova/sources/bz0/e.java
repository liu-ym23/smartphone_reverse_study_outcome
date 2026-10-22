package bz0;

import android.content.DialogInterface;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.CompositeListenerUpTo6Args;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends g implements yy0.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function1<DialogInterface, Unit>> f21817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function1<DialogInterface, Unit>> f21818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21819g;

    public e() {
        this.f21817e = new CompositeListenerUpTo6Args();
        this.f21818f = new CompositeListenerUpTo6Args();
        this.f21819g = new CompositeListenerUpTo6Args();
    }

    @Override // yy0.d
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f21819g.a(r100);
    }
}
