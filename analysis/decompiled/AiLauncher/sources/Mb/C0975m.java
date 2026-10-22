package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aR\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0004¨\u0006\u001f"}, d2 = {"LMb/m;", "LMb/J;", "delegate", "<init>", "(LMb/J;)V", "k", "(LMb/J;)LMb/m;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(JLjava/util/concurrent/TimeUnit;)LMb/J;", "", "f", "()Z", Const.INTENT_KEY_UMID, "()J", "deadlineNanoTime", "e", "(J)LMb/J;", "c", "()LMb/J;", Const.INTENT_KEY_PKGNAME, "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", Const.INTENT_KEY_APIKEY, "LMb/J;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "setDelegate", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0975m extends J {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public J delegate;

    public C0975m(J delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // Mb.J
    public void a() {
        this.delegate.a();
    }

    @Override // Mb.J
    public J b() {
        return this.delegate.b();
    }

    @Override // Mb.J
    public J c() {
        return this.delegate.c();
    }

    @Override // Mb.J
    public long d() {
        return this.delegate.d();
    }

    @Override // Mb.J
    public J e(long deadlineNanoTime) {
        return this.delegate.e(deadlineNanoTime);
    }

    @Override // Mb.J
    /* renamed from: f */
    public boolean getHasDeadline() {
        return this.delegate.getHasDeadline();
    }

    @Override // Mb.J
    public void g() throws IOException {
        this.delegate.g();
    }

    @Override // Mb.J
    public J h(long timeout, TimeUnit unit) {
        kotlin.jvm.internal.p.i(unit, "unit");
        return this.delegate.h(timeout, unit);
    }

    /* renamed from: j, reason: from getter */
    public final J getDelegate() {
        return this.delegate;
    }

    public final C0975m k(J delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }
}
