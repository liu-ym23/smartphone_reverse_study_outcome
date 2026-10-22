package io.ktor.network.sockets;

import Y8.t;
import fb.v;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0004\u001a\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\"\"\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\"\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/Function1;", "", "LY8/t;", "handler", "failInvokeOnClose", "(Lp9/l;)V", "Lfb/v;", "Ljava/nio/ByteBuffer;", "buffer", "writeMessageTo", "(Lfb/v;Ljava/nio/ByteBuffer;)V", "CLOSED", "Lp9/l;", "CLOSED_INVOKED", "ktor-network"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DatagramSendChannelKt {
    private static final InterfaceC5074l<Throwable, t> CLOSED = new InterfaceC5074l() { // from class: io.ktor.network.sockets.c
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return DatagramSendChannelKt.CLOSED$lambda$0((Throwable) obj);
        }
    };
    private static final InterfaceC5074l<Throwable, t> CLOSED_INVOKED = new InterfaceC5074l() { // from class: io.ktor.network.sockets.d
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return DatagramSendChannelKt.CLOSED_INVOKED$lambda$1((Throwable) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final t CLOSED$lambda$0(Throwable th) {
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t CLOSED_INVOKED$lambda$1(Throwable th) {
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void failInvokeOnClose(InterfaceC5074l<? super Throwable, t> interfaceC5074l) {
        String str;
        if (interfaceC5074l == CLOSED_INVOKED) {
            str = "Another handler was already registered and successfully invoked";
        } else {
            str = "Another handler was already registered: " + interfaceC5074l;
        }
        throw new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeMessageTo(v vVar, ByteBuffer byteBuffer) {
        ByteReadPacketExtensions_jvmKt.readFully(vVar, byteBuffer);
        byteBuffer.flip();
    }
}
