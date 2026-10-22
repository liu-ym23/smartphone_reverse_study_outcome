package Ua;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000b\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¨\u0006\u0014"}, d2 = {"LUa/s0;", "LUa/w0;", "Lkotlin/Function1;", "", "LY8/t;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lp9/l;)V", "cause", "v", "(Ljava/lang/Throwable;)V", "e", "Lp9/l;", "", "u", "()Z", "onCancelling", "LOa/a;", "_invoked", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.s0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1080s0 extends AbstractC1088w0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6397f = AtomicIntegerFieldUpdater.newUpdater(C1080s0.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<Throwable, Y8.t> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public C1080s0(InterfaceC5074l<? super Throwable, Y8.t> interfaceC5074l) {
        this.handler = interfaceC5074l;
    }

    @Override // Ua.AbstractC1088w0
    public boolean u() {
        return true;
    }

    @Override // Ua.AbstractC1088w0
    public void v(Throwable cause) {
        if (f6397f.compareAndSet(this, 0, 1)) {
            this.handler.invoke(cause);
        }
    }
}
