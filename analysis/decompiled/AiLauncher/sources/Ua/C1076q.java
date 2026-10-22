package Ua;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"LUa/q;", "LUa/w0;", "Lkotlinx/coroutines/c;", "child", "<init>", "(Lkotlinx/coroutines/c;)V", "", "cause", "LY8/t;", "v", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/c;", "", "u", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1076q extends AbstractC1088w0 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.c<?> child;

    public C1076q(kotlinx.coroutines.c<?> cVar) {
        this.child = cVar;
    }

    @Override // Ua.AbstractC1088w0
    public boolean u() {
        return true;
    }

    @Override // Ua.AbstractC1088w0
    public void v(Throwable cause) {
        kotlinx.coroutines.c<?> cVar = this.child;
        cVar.P(cVar.A(t()));
    }
}
