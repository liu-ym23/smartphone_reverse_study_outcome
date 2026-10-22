package Ya;

import Za.y;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlinx.coroutines.flow.internal.ChildCancelledException;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"LYa/f;", ExifInterface.GPS_DIRECTION_TRUE, "LZa/y;", "Lkotlin/coroutines/d;", "context", "Le9/c;", "uCont", "<init>", "(Lkotlin/coroutines/d;Le9/c;)V", "", "cause", "", "N", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f<T> extends y<T> {
    public f(kotlin.coroutines.d dVar, InterfaceC4014c<? super T> interfaceC4014c) {
        super(dVar, interfaceC4014c);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean N(Throwable cause) {
        if (cause instanceof ChildCancelledException) {
            return true;
        }
        return H(cause);
    }
}
