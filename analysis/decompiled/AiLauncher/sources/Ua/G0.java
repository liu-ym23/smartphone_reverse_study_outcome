package Ua;

import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"LUa/G0;", "LUa/w0;", "Le9/c;", "LY8/t;", "continuation", "<init>", "(Le9/c;)V", "", "cause", "v", "(Ljava/lang/Throwable;)V", "e", "Le9/c;", "", "u", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class G0 extends AbstractC1088w0 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4014c<Y8.t> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public G0(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        this.continuation = interfaceC4014c;
    }

    @Override // Ua.AbstractC1088w0
    public boolean u() {
        return false;
    }

    @Override // Ua.AbstractC1088w0
    public void v(Throwable cause) {
        InterfaceC4014c<Y8.t> interfaceC4014c = this.continuation;
        Result.Companion companion = Result.INSTANCE;
        interfaceC4014c.resumeWith(Result.b(Y8.t.f7040a));
    }
}
