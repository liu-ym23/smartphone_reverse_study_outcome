package kotlinx.coroutines;

import Ka.j;
import Ua.C0;
import Ua.InterfaceC1045a0;
import Ua.InterfaceC1081t;
import Ua.r;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0097@¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0017¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0014\u001a\u00020\u00132\u0018\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\b0\u000fj\u0002`\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0018\u0010\u0012\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\b0\u000fj\u0002`\u0011H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001b\u001a\u00020\b2\u000e\u0010\u001a\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0017¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u001a\u0010'\u001a\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0004\u001a\u0004\b%\u0010\u0007R\u001a\u0010*\u001a\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b(\u0010\u0007R\u001a\u0010+\u001a\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b+\u0010\u0007R\u001a\u00101\u001a\u00020-8VX\u0097\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b.\u0010/R \u00106\u001a\b\u0012\u0004\u0012\u00020\u0002028VX\u0097\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0004\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lkotlinx/coroutines/h;", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/g;", "<init>", "()V", "", "start", "()Z", "LY8/t;", "T0", "(Le9/c;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "G", "()Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "LUa/a0;", "J", "(Lp9/l;)LUa/a0;", "onCancelling", "invokeImmediately", "I0", "(ZZLp9/l;)LUa/a0;", "cause", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/concurrent/CancellationException;)V", "LUa/t;", "child", "LUa/r;", "N0", "(LUa/t;)LUa/r;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "isActive$annotations", "isActive", Const.INTENT_KEY_BACKGROUND_COMMAND, "isCompleted$annotations", "isCompleted", "isCancelled", "isCancelled$annotations", "Lcb/d;", "R0", "()Lcb/d;", "getOnJoin$annotations", "onJoin", "LKa/j;", "getChildren", "()LKa/j;", "getChildren$annotations", "children", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h extends kotlin.coroutines.a implements g {

    /* renamed from: a, reason: collision with root package name */
    public static final h f36771a = new h();

    public h() {
        super(g.INSTANCE);
    }

    @Override // kotlinx.coroutines.g
    public CancellationException G() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.g
    public InterfaceC1045a0 I0(boolean onCancelling, boolean invokeImmediately, InterfaceC5074l<? super Throwable, t> handler) {
        return C0.f6325a;
    }

    @Override // kotlinx.coroutines.g
    public InterfaceC1045a0 J(InterfaceC5074l<? super Throwable, t> handler) {
        return C0.f6325a;
    }

    @Override // kotlinx.coroutines.g
    public r N0(InterfaceC1081t child) {
        return C0.f6325a;
    }

    @Override // kotlinx.coroutines.g
    public cb.d R0() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.g
    public Object T0(InterfaceC4014c<? super t> interfaceC4014c) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.g
    public boolean b() {
        return true;
    }

    @Override // kotlinx.coroutines.g
    public boolean g() {
        return false;
    }

    @Override // kotlinx.coroutines.g
    public j<g> getChildren() {
        return Ka.t.j();
    }

    @Override // kotlinx.coroutines.g, Wa.r
    public void i(CancellationException cause) {
    }

    @Override // kotlinx.coroutines.g
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.g
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }
}
