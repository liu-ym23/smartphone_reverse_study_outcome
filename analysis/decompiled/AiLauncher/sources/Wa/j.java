package Wa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "LY8/t;", "onUndeliveredElement", "LWa/g;", Const.INTENT_KEY_APIKEY, "(ILkotlinx/coroutines/channels/BufferOverflow;Lp9/l;)LWa/g;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class j {
    public static final <E> g<E> a(int i10, BufferOverflow bufferOverflow, InterfaceC5074l<? super E, Y8.t> interfaceC5074l) {
        if (i10 == -2) {
            return bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(g.INSTANCE.a(), interfaceC5074l) : new kotlinx.coroutines.channels.b(1, bufferOverflow, interfaceC5074l);
        }
        if (i10 != -1) {
            return i10 != 0 ? i10 != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i10, interfaceC5074l) : new kotlinx.coroutines.channels.b(i10, bufferOverflow, interfaceC5074l) : new BufferedChannel(Integer.MAX_VALUE, interfaceC5074l) : bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(0, interfaceC5074l) : new kotlinx.coroutines.channels.b(1, bufferOverflow, interfaceC5074l);
        }
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new kotlinx.coroutines.channels.b(1, BufferOverflow.DROP_OLDEST, interfaceC5074l);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static /* synthetic */ g b(int i10, BufferOverflow bufferOverflow, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            interfaceC5074l = null;
        }
        return a(i10, bufferOverflow, interfaceC5074l);
    }
}
