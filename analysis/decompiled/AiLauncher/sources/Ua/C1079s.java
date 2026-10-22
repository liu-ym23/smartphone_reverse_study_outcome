package Ua;

import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"LUa/s;", "LUa/w0;", "LUa/r;", "LUa/t;", "childJob", "<init>", "(LUa/t;)V", "", "cause", "LY8/t;", "v", "(Ljava/lang/Throwable;)V", "", "e", "(Ljava/lang/Throwable;)Z", "LUa/t;", "Lkotlinx/coroutines/g;", "getParent", "()Lkotlinx/coroutines/g;", "parent", "u", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1079s extends AbstractC1088w0 implements r {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1081t childJob;

    public C1079s(InterfaceC1081t interfaceC1081t) {
        this.childJob = interfaceC1081t;
    }

    @Override // Ua.r
    public boolean e(Throwable cause) {
        return t().N(cause);
    }

    @Override // Ua.r
    public kotlinx.coroutines.g getParent() {
        return t();
    }

    @Override // Ua.AbstractC1088w0
    public boolean u() {
        return true;
    }

    @Override // Ua.AbstractC1088w0
    public void v(Throwable cause) {
        this.childJob.A(t());
    }
}
