package io.ktor.websocket;

import Ua.InterfaceC1045a0;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import fb.C4074a;
import fb.v;
import fb.x;
import io.ktor.util.NIOKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 (2\u00020\u0001:\u0006)*+,-(BI\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b \u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b!\u0010\u0016R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u0082\u0001\u0005./012¨\u00063"}, d2 = {"Lio/ktor/websocket/Frame;", "", "", "fin", "Lio/ktor/websocket/FrameType;", "frameType", "", "data", "LUa/a0;", "disposableHandle", "rsv1", "rsv2", "rsv3", "<init>", "(ZLio/ktor/websocket/FrameType;[BLUa/a0;ZZZ)V", "", "toString", "()Ljava/lang/String;", ChatTracker.CLICK_COPY, "()Lio/ktor/websocket/Frame;", "Z", "getFin", "()Z", "Lio/ktor/websocket/FrameType;", "getFrameType", "()Lio/ktor/websocket/FrameType;", "[B", "getData", "()[B", "LUa/a0;", "getDisposableHandle", "()LUa/a0;", "getRsv1", "getRsv2", "getRsv3", "Ljava/nio/ByteBuffer;", "buffer", "Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "Companion", "Binary", "Text", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30857p, "Ping", "Pong", "Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame$Pong;", "Lio/ktor/websocket/Frame$Text;", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Frame {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] Empty = new byte[0];
    private final ByteBuffer buffer;
    private final byte[] data;
    private final InterfaceC1045a0 disposableHandle;
    private final boolean fin;
    private final FrameType frameType;
    private final boolean rsv1;
    private final boolean rsv2;
    private final boolean rsv3;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/websocket/Frame$Binary;", "Lio/ktor/websocket/Frame;", "", "fin", "", "data", "rsv1", "rsv2", "rsv3", "<init>", "(Z[BZZZ)V", "Ljava/nio/ByteBuffer;", "buffer", "(ZLjava/nio/ByteBuffer;)V", "(Z[B)V", "Lfb/v;", "packet", "(ZLfb/v;)V", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Binary extends Frame {
        public /* synthetic */ Binary(boolean z10, byte[] bArr, boolean z11, boolean z12, boolean z13, int i10, kotlin.jvm.internal.i iVar) {
            this(z10, bArr, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) != 0 ? false : z13);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z10, byte[] data, boolean z11, boolean z12, boolean z13) {
            super(z10, FrameType.BINARY, data, NonDisposableHandle.INSTANCE, z11, z12, z13, null);
            p.i(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z10, ByteBuffer buffer) {
            this(z10, NIOKt.moveToByteArray(buffer));
            p.i(buffer, "buffer");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z10, byte[] data) {
            this(z10, data, false, false, false);
            p.i(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Binary(boolean z10, v packet) {
            this(z10, x.c(packet));
            p.i(packet, "packet");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/websocket/Frame$Close;", "Lio/ktor/websocket/Frame;", "", "data", "<init>", "([B)V", "Lio/ktor/websocket/CloseReason;", "reason", "(Lio/ktor/websocket/CloseReason;)V", "Lfb/v;", "packet", "(Lfb/v;)V", "()V", "Ljava/nio/ByteBuffer;", "buffer", "(Ljava/nio/ByteBuffer;)V", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Close extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Close(byte[] data) {
            super(true, FrameType.CLOSE, data, NonDisposableHandle.INSTANCE, false, false, false, null);
            p.i(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Close(v packet) {
            this(x.c(packet));
            p.i(packet, "packet");
        }

        public Close() {
            this(Frame.Empty);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Close(ByteBuffer buffer) {
            this(NIOKt.moveToByteArray(buffer));
            p.i(buffer, "buffer");
        }

        public Close(CloseReason reason) {
            p.i(reason, "reason");
            C4074a c4074a = new C4074a();
            c4074a.writeShort(reason.getCode());
            StringsKt.writeText$default(c4074a, reason.getMessage(), 0, 0, (Charset) null, 14, (Object) null);
            this(c4074a);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/websocket/Frame$Companion;", "", "<init>", "()V", "", "fin", "Lio/ktor/websocket/FrameType;", "frameType", "", "data", "rsv1", "rsv2", "rsv3", "Lio/ktor/websocket/Frame;", "byType", "(ZLio/ktor/websocket/FrameType;[BZZZ)Lio/ktor/websocket/Frame;", "Empty", "[B", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[FrameType.values().length];
                try {
                    iArr[FrameType.BINARY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FrameType.TEXT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FrameType.CLOSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FrameType.PING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[FrameType.PONG.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Frame byType(boolean fin, FrameType frameType, byte[] data, boolean rsv1, boolean rsv2, boolean rsv3) {
            p.i(frameType, "frameType");
            p.i(data, "data");
            int i10 = WhenMappings.$EnumSwitchMapping$0[frameType.ordinal()];
            if (i10 == 1) {
                return new Binary(fin, data, rsv1, rsv2, rsv3);
            }
            if (i10 == 2) {
                return new Text(fin, data, rsv1, rsv2, rsv3);
            }
            if (i10 == 3) {
                return new Close(data);
            }
            if (i10 == 4) {
                return new Ping(data);
            }
            if (i10 == 5) {
                return new Pong(data, NonDisposableHandle.INSTANCE);
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/websocket/Frame$Ping;", "Lio/ktor/websocket/Frame;", "", "data", "<init>", "([B)V", "Lfb/v;", "packet", "(Lfb/v;)V", "Ljava/nio/ByteBuffer;", "buffer", "(Ljava/nio/ByteBuffer;)V", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Ping extends Frame {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ping(byte[] data) {
            super(true, FrameType.PING, data, NonDisposableHandle.INSTANCE, false, false, false, null);
            p.i(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Ping(v packet) {
            this(x.c(packet));
            p.i(packet, "packet");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Ping(ByteBuffer buffer) {
            this(NIOKt.moveToByteArray(buffer));
            p.i(buffer, "buffer");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\t\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\t\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/websocket/Frame$Text;", "Lio/ktor/websocket/Frame;", "", "fin", "", "data", "rsv1", "rsv2", "rsv3", "<init>", "(Z[BZZZ)V", "(Z[B)V", "", "text", "(Ljava/lang/String;)V", "Lfb/v;", "packet", "(ZLfb/v;)V", "Ljava/nio/ByteBuffer;", "buffer", "(ZLjava/nio/ByteBuffer;)V", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Text extends Frame {
        public /* synthetic */ Text(boolean z10, byte[] bArr, boolean z11, boolean z12, boolean z13, int i10, kotlin.jvm.internal.i iVar) {
            this(z10, bArr, (i10 & 4) != 0 ? false : z11, (i10 & 8) != 0 ? false : z12, (i10 & 16) != 0 ? false : z13);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(boolean z10, byte[] data, boolean z11, boolean z12, boolean z13) {
            super(z10, FrameType.TEXT, data, NonDisposableHandle.INSTANCE, z11, z12, z13, null);
            p.i(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z10, byte[] data) {
            this(z10, data, false, false, false);
            p.i(data, "data");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(String text) {
            this(true, StringsKt.toByteArray$default(text, null, 1, null));
            p.i(text, "text");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z10, v packet) {
            this(z10, x.c(packet));
            p.i(packet, "packet");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Text(boolean z10, ByteBuffer buffer) {
            this(z10, NIOKt.moveToByteArray(buffer));
            p.i(buffer, "buffer");
        }
    }

    public /* synthetic */ Frame(boolean z10, FrameType frameType, byte[] bArr, InterfaceC1045a0 interfaceC1045a0, boolean z11, boolean z12, boolean z13, kotlin.jvm.internal.i iVar) {
        this(z10, frameType, bArr, interfaceC1045a0, z11, z12, z13);
    }

    public final Frame copy() {
        Companion companion = INSTANCE;
        boolean z10 = this.fin;
        FrameType frameType = this.frameType;
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        p.h(bArrCopyOf, "copyOf(...)");
        return companion.byType(z10, frameType, bArrCopyOf, this.rsv1, this.rsv2, this.rsv3);
    }

    public final ByteBuffer getBuffer() {
        return this.buffer;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final InterfaceC1045a0 getDisposableHandle() {
        return this.disposableHandle;
    }

    public final boolean getFin() {
        return this.fin;
    }

    public final FrameType getFrameType() {
        return this.frameType;
    }

    public final boolean getRsv1() {
        return this.rsv1;
    }

    public final boolean getRsv2() {
        return this.rsv2;
    }

    public final boolean getRsv3() {
        return this.rsv3;
    }

    public String toString() {
        return "Frame " + this.frameType + " (fin=" + this.fin + ", buffer len = " + this.data.length + ')';
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/websocket/Frame$Pong;", "Lio/ktor/websocket/Frame;", "", "data", "LUa/a0;", "disposableHandle", "<init>", "([BLUa/a0;)V", "Lfb/v;", "packet", "(Lfb/v;)V", "Ljava/nio/ByteBuffer;", "buffer", "(Ljava/nio/ByteBuffer;LUa/a0;)V", "(Ljava/nio/ByteBuffer;)V", "ktor-websockets"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Pong extends Frame {
        public /* synthetic */ Pong(byte[] bArr, InterfaceC1045a0 interfaceC1045a0, int i10, kotlin.jvm.internal.i iVar) {
            this(bArr, (i10 & 2) != 0 ? NonDisposableHandle.INSTANCE : interfaceC1045a0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pong(byte[] data, InterfaceC1045a0 disposableHandle) {
            super(true, FrameType.PONG, data, disposableHandle, false, false, false, null);
            p.i(data, "data");
            p.i(disposableHandle, "disposableHandle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Pong(v packet) {
            this(x.c(packet), NonDisposableHandle.INSTANCE);
            p.i(packet, "packet");
        }

        public /* synthetic */ Pong(ByteBuffer byteBuffer, InterfaceC1045a0 interfaceC1045a0, int i10, kotlin.jvm.internal.i iVar) {
            this(byteBuffer, (i10 & 2) != 0 ? NonDisposableHandle.INSTANCE : interfaceC1045a0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Pong(ByteBuffer buffer, InterfaceC1045a0 disposableHandle) {
            this(NIOKt.moveToByteArray(buffer), disposableHandle);
            p.i(buffer, "buffer");
            p.i(disposableHandle, "disposableHandle");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Pong(ByteBuffer buffer) {
            this(NIOKt.moveToByteArray(buffer), NonDisposableHandle.INSTANCE);
            p.i(buffer, "buffer");
        }
    }

    private Frame(boolean z10, FrameType frameType, byte[] bArr, InterfaceC1045a0 interfaceC1045a0, boolean z11, boolean z12, boolean z13) {
        this.fin = z10;
        this.frameType = frameType;
        this.data = bArr;
        this.disposableHandle = interfaceC1045a0;
        this.rsv1 = z11;
        this.rsv2 = z12;
        this.rsv3 = z13;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        p.h(byteBufferWrap, "wrap(...)");
        this.buffer = byteBufferWrap;
    }

    public /* synthetic */ Frame(boolean z10, FrameType frameType, byte[] bArr, InterfaceC1045a0 interfaceC1045a0, boolean z11, boolean z12, boolean z13, int i10, kotlin.jvm.internal.i iVar) {
        this(z10, frameType, bArr, (i10 & 8) != 0 ? NonDisposableHandle.INSTANCE : interfaceC1045a0, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? false : z12, (i10 & 64) != 0 ? false : z13, null);
    }
}
