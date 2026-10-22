package Mb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\bJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"LMb/o;", "LMb/I;", "LMb/f;", "source", "Ljava/util/zip/Inflater;", "inflater", "<init>", "(LMb/f;Ljava/util/zip/Inflater;)V", "(LMb/I;Ljava/util/zip/Inflater;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", Const.INTENT_KEY_PKGNAME, "", "e", "()Z", "LMb/J;", "c", "()LMb/J;", "LY8/t;", "close", "()V", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "LMb/f;", "Ljava/util/zip/Inflater;", "", "I", "bufferBytesHeldByInflater", Const.INTENT_KEY_UMID, "Z", AlipayXuiIsland.REASON_CLOSED, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class o implements I {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0968f source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Inflater inflater;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int bufferBytesHeldByInflater;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    public o(InterfaceC0968f source, Inflater inflater) {
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    public final long b(C0966d sink, long byteCount) throws DataFormatException, IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException(AlipayXuiIsland.REASON_CLOSED);
        }
        if (byteCount == 0) {
            return 0L;
        }
        try {
            E eH1 = sink.h1(1);
            int iMin = (int) Math.min(byteCount, 8192 - eH1.limit);
            e();
            int iInflate = this.inflater.inflate(eH1.data, eH1.limit, iMin);
            g();
            if (iInflate > 0) {
                eH1.limit += iInflate;
                long j10 = iInflate;
                sink.a1(sink.getSize() + j10);
                return j10;
            }
            if (eH1.pos == eH1.limit) {
                sink.head = eH1.b();
                F.b(eH1);
            }
            return 0L;
        } catch (DataFormatException e10) {
            throw new IOException(e10);
        }
    }

    @Override // Mb.I
    /* renamed from: c */
    public J getTimeout() {
        return this.source.getTimeout();
    }

    @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    public final boolean e() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.k()) {
            return true;
        }
        E e10 = this.source.getBufferField().head;
        kotlin.jvm.internal.p.f(e10);
        int i10 = e10.limit;
        int i11 = e10.pos;
        int i12 = i10 - i11;
        this.bufferBytesHeldByInflater = i12;
        this.inflater.setInput(e10.data, i11, i12);
        return false;
    }

    public final void g() throws IOException {
        int i10 = this.bufferBytesHeldByInflater;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // Mb.I
    public long u0(C0966d sink, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        do {
            long jB = b(sink, byteCount);
            if (jB > 0) {
                return jB;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.k());
        throw new EOFException("source exhausted prematurely");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(I source, Inflater inflater) {
        this(u.c(source), inflater);
        kotlin.jvm.internal.p.i(source, "source");
        kotlin.jvm.internal.p.i(inflater, "inflater");
    }
}
