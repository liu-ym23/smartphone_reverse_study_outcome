package Wa;

import Ua.C1063j0;
import Ua.K;
import Ua.N;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LWa/a;", ExifInterface.LONGITUDE_EAST, "LWa/h;", "LWa/c;", "Lkotlin/coroutines/d;", "parentContext", "LWa/g;", "channel", "", "active", "<init>", "(Lkotlin/coroutines/d;LWa/g;Z)V", "", "cause", "LY8/t;", "x0", "(Ljava/lang/Throwable;)V", "exception", "g0", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class a<E> extends h<E> implements c<E> {
    public a(kotlin.coroutines.d dVar, g<E> gVar, boolean z10) {
        super(dVar, gVar, false, z10);
        i0((kotlinx.coroutines.g) dVar.get(kotlinx.coroutines.g.INSTANCE));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean g0(Throwable exception) {
        K.a(getContext(), exception);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void x0(Throwable cause) {
        g<E> gVarZ0 = Z0();
        if (cause != null) {
            cancellationExceptionA = cause instanceof CancellationException ? (CancellationException) cause : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = C1063j0.a(N.a(this) + " was cancelled", cause);
            }
        }
        gVarZ0.i(cancellationExceptionA);
    }
}
