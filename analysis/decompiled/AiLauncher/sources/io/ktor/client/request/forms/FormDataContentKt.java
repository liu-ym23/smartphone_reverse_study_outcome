package io.ktor.client.request.forms;

import La.C0951a;
import La.K;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.v;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a \u0010\b\u001a\u00020\u0007*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "generateBoundary", "()Ljava/lang/String;", "Lfb/v;", "Lio/ktor/utils/io/core/Input;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "LY8/t;", "copyTo", "(Lfb/v;Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "", "RN_BYTES", "[B", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FormDataContentKt {
    private static final byte[] RN_BYTES = StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object copyTo(v vVar, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objWritePacket = ByteWriteChannelOperationsKt.writePacket(byteWriteChannel, vVar, interfaceC4014c);
        return objWritePacket == C4063a.g() ? objWritePacket : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateBoundary() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 32; i10++) {
            String string = Integer.toString(Random.INSTANCE.f(), C0951a.a(16));
            p.h(string, "toString(...)");
            sb2.append(string);
        }
        return K.R1(sb2.toString(), 70);
    }
}
