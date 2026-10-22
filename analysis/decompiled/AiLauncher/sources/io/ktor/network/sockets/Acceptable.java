package io.ktor.network.sockets;

import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import io.ktor.network.sockets.ASocket;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0001J\u0010\u0010\u0003\u001a\u00028\u0000H¦@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lio/ktor/network/sockets/Acceptable;", "Lio/ktor/network/sockets/ASocket;", ExifInterface.LATITUDE_SOUTH, "accept", "(Le9/c;)Ljava/lang/Object;", "ktor-network"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Acceptable<S extends ASocket> extends ASocket {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <S extends ASocket> void dispose(Acceptable<? extends S> acceptable) {
            Acceptable.super.dispose();
        }
    }

    Object accept(InterfaceC4014c<? super S> interfaceC4014c);
}
