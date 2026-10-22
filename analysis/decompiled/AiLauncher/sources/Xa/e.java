package Xa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", Const.INTENT_KEY_APIKEY, "(LXa/b;ILkotlinx/coroutines/channels/BufferOverflow;)LXa/b;", Const.INTENT_KEY_UMID, "(LXa/b;)LXa/b;", "Lkotlin/coroutines/d;", "context", "e", "(LXa/b;Lkotlin/coroutines/d;)LXa/b;", "LY8/t;", "c", "(Lkotlin/coroutines/d;)V", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class e {
    public static final <T> b<T> a(b<? extends T> bVar, int i10, BufferOverflow bufferOverflow) {
        if (i10 < 0 && i10 != -2 && i10 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i10).toString());
        }
        if (i10 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i10 == -1) {
            bufferOverflow = BufferOverflow.DROP_OLDEST;
            i10 = 0;
        }
        int i11 = i10;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if (bVar instanceof Ya.h) {
            return Ya.h.f((Ya.h) bVar, null, i11, bufferOverflow2, 1, null);
        }
        return new Ya.d(bVar, null, i11, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ b b(b bVar, int i10, BufferOverflow bufferOverflow, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -2;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return d.d(bVar, i10, bufferOverflow);
    }

    public static final void c(kotlin.coroutines.d dVar) {
        if (dVar.get(kotlinx.coroutines.g.INSTANCE) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + dVar).toString());
    }

    public static final <T> b<T> d(b<? extends T> bVar) {
        return b(bVar, -1, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> e(b<? extends T> bVar, kotlin.coroutines.d dVar) {
        c(dVar);
        if (kotlin.jvm.internal.p.d(dVar, EmptyCoroutineContext.f34779a)) {
            return bVar;
        }
        if (bVar instanceof Ya.h) {
            return Ya.h.f((Ya.h) bVar, dVar, 0, null, 6, null);
        }
        return new Ya.d(bVar, dVar, 0, null, 12, null);
    }
}
