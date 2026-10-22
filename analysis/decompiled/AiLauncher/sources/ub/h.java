package ub;

import Mb.C0966d;
import Mb.I;
import Mb.InterfaceC0968f;
import Mb.J;
import Mb.u;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import tb.AbstractC5531D;
import tb.x;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lub/h;", "Ltb/D;", "LMb/I;", "Ltb/x;", "mediaType", "", "contentLength", "<init>", "(Ltb/x;J)V", "l", "()Ltb/x;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "LMb/f;", "n", "()LMb/f;", "LMb/d;", "sink", "byteCount", "u0", "(LMb/d;J)J", "LMb/J;", "c", "()LMb/J;", "LY8/t;", "close", "()V", Const.INTENT_KEY_UMID, "Ltb/x;", "e", "J", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h extends AbstractC5531D implements I {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final x mediaType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final long contentLength;

    public h(x xVar, long j10) {
        this.mediaType = xVar;
        this.contentLength = j10;
    }

    @Override // Mb.I
    /* renamed from: c */
    public J getTimeout() {
        return J.f4694f;
    }

    @Override // tb.AbstractC5531D, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // tb.AbstractC5531D
    /* renamed from: i, reason: from getter */
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // tb.AbstractC5531D
    /* renamed from: l, reason: from getter */
    public x getMediaType() {
        return this.mediaType;
    }

    @Override // tb.AbstractC5531D
    /* renamed from: n */
    public InterfaceC0968f getSource() {
        return u.c(this);
    }

    @Override // Mb.I
    public long u0(C0966d sink, long byteCount) {
        kotlin.jvm.internal.p.i(sink, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }
}
