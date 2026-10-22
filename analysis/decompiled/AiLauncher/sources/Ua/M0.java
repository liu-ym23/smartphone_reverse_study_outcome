package Ua;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.d;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"LUa/M0;", ExifInterface.LATITUDE_SOUTH, "Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/d;", "context", "f1", "(Lkotlin/coroutines/d;)Ljava/lang/Object;", "oldState", "LY8/t;", "e0", "(Lkotlin/coroutines/d;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface M0<S> extends d.b {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static <S, R> R a(M0<S> m02, R r10, p9.p<? super R, ? super d.b, ? extends R> pVar) {
            return (R) d.b.a.a(m02, r10, pVar);
        }

        public static <S> kotlin.coroutines.d b(M0<S> m02, kotlin.coroutines.d dVar) {
            return d.b.a.d(m02, dVar);
        }
    }

    void e0(kotlin.coroutines.d context, S oldState);

    S f1(kotlin.coroutines.d context);
}
