package tb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import xb.C5873d;
import yb.AbstractC6026g;
import yb.C6034o;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B;\b\u0010\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u0011B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Ltb/k;", "", "Lyb/o;", "delegate", "<init>", "(Lyb/o;)V", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Lxb/d;", "taskRunner", "Lyb/g;", "connectionListener", "(IJLjava/util/concurrent/TimeUnit;Lxb/d;Lyb/g;)V", "(IJLjava/util/concurrent/TimeUnit;)V", "()V", Const.INTENT_KEY_APIKEY, "Lyb/o;", "()Lyb/o;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5544k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6034o delegate;

    public C5544k(C6034o delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: a, reason: from getter */
    public final C6034o getDelegate() {
        return this.delegate;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5544k(int i10, long j10, TimeUnit timeUnit, C5873d taskRunner, AbstractC6026g connectionListener) {
        this(new C6034o(taskRunner, i10, j10, timeUnit, connectionListener));
        kotlin.jvm.internal.p.i(timeUnit, "timeUnit");
        kotlin.jvm.internal.p.i(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.i(connectionListener, "connectionListener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5544k(int i10, long j10, TimeUnit timeUnit) {
        this(i10, j10, timeUnit, C5873d.f43622m, AbstractC6026g.INSTANCE.a());
        kotlin.jvm.internal.p.i(timeUnit, "timeUnit");
    }

    public C5544k() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
