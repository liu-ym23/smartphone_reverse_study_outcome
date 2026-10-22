package io.ktor.network.sockets;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\u0007\u001a\u00028\u0000\"\u0012\b\u0000\u0010\u0006*\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0005*\u00028\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketBuilder;", "aSocket", "(Lio/ktor/network/selector/SelectorManager;)Lio/ktor/network/sockets/SocketBuilder;", "Lio/ktor/network/sockets/Configurable;", ExifInterface.GPS_DIRECTION_TRUE, "tcpNoDelay", "(Lio/ktor/network/sockets/Configurable;)Lio/ktor/network/sockets/Configurable;", "ktor-network"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BuildersKt {
    public static final SocketBuilder aSocket(SelectorManager selector) {
        p.i(selector, "selector");
        return new SocketBuilder(selector, SocketOptions.INSTANCE.create$ktor_network());
    }

    public static final <T extends Configurable<? extends T, ?>> T tcpNoDelay(T t10) {
        p.i(t10, "<this>");
        return (T) t10.configure(new InterfaceC5074l<?, t>() { // from class: io.ktor.network.sockets.BuildersKt.tcpNoDelay.1
            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(Object obj) {
                invoke((SocketOptions) obj);
                return t.f7040a;
            }

            public final void invoke(SocketOptions configure) {
                p.i(configure, "$this$configure");
                if (configure instanceof SocketOptions.TCPClientSocketOptions) {
                    ((SocketOptions.TCPClientSocketOptions) configure).setNoDelay(true);
                }
            }
        });
    }
}
