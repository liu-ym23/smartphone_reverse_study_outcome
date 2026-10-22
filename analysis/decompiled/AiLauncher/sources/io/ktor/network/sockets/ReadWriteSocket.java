package io.ktor.network.sockets;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/ReadWriteSocket;", "Lio/ktor/network/sockets/ASocket;", "Lio/ktor/network/sockets/AReadable;", "Lio/ktor/network/sockets/AWritable;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ReadWriteSocket extends ASocket, AReadable, AWritable {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void dispose(ReadWriteSocket readWriteSocket) {
            ReadWriteSocket.super.dispose();
        }
    }
}
