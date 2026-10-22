package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"LMb/l;", "LMb/I;", "delegate", "<init>", "(LMb/I;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LMb/J;", "c", "()LMb/J;", "LY8/t;", "close", "()V", "", "toString", "()Ljava/lang/String;", "LMb/I;", Const.INTENT_KEY_PKGNAME, "()LMb/I;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0974l implements I {
    private final I delegate;

    public AbstractC0974l(I delegate) {
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: b, reason: from getter */
    public final I getDelegate() {
        return this.delegate;
    }

    @Override // Mb.I
    public J c() {
        return this.delegate.c();
    }

    @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // Mb.I
    public long u0(C0966d sink, long byteCount) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        return this.delegate.u0(sink, byteCount);
    }
}
