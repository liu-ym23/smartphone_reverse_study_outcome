package Wa;

import Za.B;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00040\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u0000H\u0017¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"LWa/s;", ExifInterface.LONGITUDE_EAST, "", "element", "LY8/t;", "send", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/a;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "invokeOnClose", "(Lp9/l;)V", "offer", "(Ljava/lang/Object;)Z", "isClosedForSend", "()Z", "isClosedForSend$annotations", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface s<E> {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        @Deprecated
        public static <E> boolean b(s<? super E> sVar, E e10) {
            return s.super.offer(e10);
        }
    }

    static /* synthetic */ boolean a(s sVar, Throwable th, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
        if ((i10 & 1) != 0) {
            th = null;
        }
        return sVar.close(th);
    }

    boolean close(Throwable cause);

    void invokeOnClose(InterfaceC5074l<? super Throwable, Y8.t> handler);

    boolean isClosedForSend();

    default boolean offer(E element) throws Throwable {
        Object objMo0trySendJP2dKIU = mo0trySendJP2dKIU(element);
        if (kotlinx.coroutines.channels.a.j(objMo0trySendJP2dKIU)) {
            return true;
        }
        Throwable thE = kotlinx.coroutines.channels.a.e(objMo0trySendJP2dKIU);
        if (thE == null) {
            return false;
        }
        throw B.a(thE);
    }

    Object send(E e10, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    /* renamed from: trySend-JP2dKIU */
    Object mo0trySendJP2dKIU(E element);
}
