package io.ktor.websocket;

import La.C0953c;
import fb.C4074a;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import io.ktor.websocket.Frame;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/websocket/Frame$Text;", "", "readText", "(Lio/ktor/websocket/Frame$Text;)Ljava/lang/String;", "Lio/ktor/websocket/Frame;", "", "readBytes", "(Lio/ktor/websocket/Frame;)[B", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/CloseReason;", "readReason", "(Lio/ktor/websocket/Frame$Close;)Lio/ktor/websocket/CloseReason;", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FrameCommonKt {
    public static final byte[] readBytes(Frame frame) {
        p.i(frame, "<this>");
        byte[] data = frame.getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        p.h(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static final CloseReason readReason(Frame.Close close) {
        p.i(close, "<this>");
        if (close.getData().length < 2) {
            return null;
        }
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully$default(c4074a, close.getData(), 0, 0, 6, null);
        return new CloseReason(c4074a.readShort(), StringsKt.readText$default(c4074a, null, 0, 3, null));
    }

    public static final String readText(Frame.Text text) {
        p.i(text, "<this>");
        if (!text.getFin()) {
            throw new IllegalArgumentException("Text could be only extracted from non-fragmented frame");
        }
        CharsetDecoder charsetDecoderNewDecoder = C0953c.UTF_8.newDecoder();
        p.h(charsetDecoderNewDecoder, "newDecoder(...)");
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully$default(c4074a, text.getData(), 0, 0, 6, null);
        return EncodingKt.decode$default(charsetDecoderNewDecoder, c4074a, 0, 2, null);
    }
}
