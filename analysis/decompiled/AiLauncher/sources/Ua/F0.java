package Ua;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"LUa/F0;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/w0;", "Lkotlinx/coroutines/c;", "continuation", "<init>", "(Lkotlinx/coroutines/c;)V", "", "cause", "LY8/t;", "v", "(Ljava/lang/Throwable;)V", "e", "Lkotlinx/coroutines/c;", "", "u", "()Z", "onCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class F0<T> extends AbstractC1088w0 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final kotlinx.coroutines.c<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public F0(kotlinx.coroutines.c<? super T> cVar) {
        this.continuation = cVar;
    }

    @Override // Ua.AbstractC1088w0
    public boolean u() {
        return false;
    }

    @Override // Ua.AbstractC1088w0
    public void v(Throwable cause) {
        Object objC0 = t().c0();
        if (objC0 instanceof C1091z) {
            kotlinx.coroutines.c<T> cVar = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            cVar.resumeWith(Result.b(C4849c.a(((C1091z) objC0).cause)));
        } else {
            kotlinx.coroutines.c<T> cVar2 = this.continuation;
            Result.Companion companion2 = Result.INSTANCE;
            cVar2.resumeWith(Result.b(x0.h(objC0)));
        }
    }
}
