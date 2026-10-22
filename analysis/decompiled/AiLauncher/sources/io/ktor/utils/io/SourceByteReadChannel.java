package io.ktor.utils.io;

import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import e9.InterfaceC4014c;
import fb.v;
import g9.C4109a;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/utils/io/SourceByteReadChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lfb/v;", "source", "<init>", "(Lfb/v;)V", "", "min", "", "awaitContent", "(ILe9/c;)Ljava/lang/Object;", "", "cause", "LY8/t;", "cancel", "(Ljava/lang/Throwable;)V", "Lfb/v;", "Lio/ktor/utils/io/CloseToken;", AlipayXuiIsland.REASON_CLOSED, "Lio/ktor/utils/io/CloseToken;", "getReadBuffer", "()Lfb/v;", "getReadBuffer$annotations", "()V", "readBuffer", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "()Z", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SourceByteReadChannel implements ByteReadChannel {
    private volatile CloseToken closed;
    private final v source;

    public SourceByteReadChannel(v source) {
        p.i(source, "source");
        this.source = source;
    }

    @InternalAPI
    public static /* synthetic */ void getReadBuffer$annotations() {
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public Object awaitContent(int i10, InterfaceC4014c<? super Boolean> interfaceC4014c) throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            return C4109a.a(this.source.request(i10));
        }
        throw closedCause;
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public void cancel(Throwable cause) {
        String message;
        if (this.closed != null) {
            return;
        }
        this.source.close();
        if (cause == null || (message = cause.getMessage()) == null) {
            message = "Channel was cancelled";
        }
        this.closed = new CloseToken(new IOException(message, cause));
    }

    @Override // io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel
    public Throwable getClosedCause() {
        CloseToken closeToken = this.closed;
        if (closeToken != null) {
            return CloseToken.wrapCause$default(closeToken, null, 1, null);
        }
        return null;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public v getReadBuffer() throws Throwable {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            return this.source.getBufferField();
        }
        throw closedCause;
    }

    @Override // io.ktor.utils.io.ByteReadChannel
    public boolean isClosedForRead() {
        return this.source.k();
    }
}
