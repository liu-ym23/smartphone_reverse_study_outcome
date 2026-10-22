package z0;

import android.content.Context;
import android.content.IntentFilter;
import androidx.appcompat.app.A;
import kotlin.jvm.internal.Intrinsics;
import s0.t;

/* renamed from: z0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0996d extends AbstractC0998f {

    /* renamed from: f, reason: collision with root package name */
    public final A f16395f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0996d(Context context, E0.a taskExecutor) {
        super(context, taskExecutor);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskExecutor, "taskExecutor");
        this.f16395f = new A(1, this);
    }

    @Override // z0.AbstractC0998f
    public final void c() {
        t.d().a(AbstractC0997e.f16396a, getClass().getSimpleName().concat(": registering receiver"));
        this.f16398b.registerReceiver(this.f16395f, e());
    }

    @Override // z0.AbstractC0998f
    public final void d() {
        t.d().a(AbstractC0997e.f16396a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.f16398b.unregisterReceiver(this.f16395f);
    }

    public abstract IntentFilter e();
}
