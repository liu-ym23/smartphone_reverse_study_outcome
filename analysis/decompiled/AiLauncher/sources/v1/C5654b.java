package v1;

import Mb.AbstractC0973k;
import Mb.C0966d;
import Mb.G;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0012R$\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lv1/b;", "LMb/k;", "LMb/G;", "delegate", "Lkotlin/Function1;", "Ljava/io/IOException;", "Lokio/IOException;", "LY8/t;", "onException", "<init>", "(LMb/G;Lp9/l;)V", "LMb/d;", "source", "", "byteCount", "K", "(LMb/d;J)V", "flush", "()V", "close", Const.INTENT_KEY_APIKEY, "Lp9/l;", "", Const.INTENT_KEY_PKGNAME, "Z", "hasErrors", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: v1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5654b extends AbstractC0973k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<IOException, t> onException;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean hasErrors;

    /* JADX WARN: Multi-variable type inference failed */
    public C5654b(G g10, InterfaceC5074l<? super IOException, t> interfaceC5074l) {
        super(g10);
        this.onException = interfaceC5074l;
    }

    @Override // Mb.AbstractC0973k, Mb.G
    public void K(C0966d source, long byteCount) throws EOFException {
        if (this.hasErrors) {
            source.skip(byteCount);
            return;
        }
        try {
            super.K(source, byteCount);
        } catch (IOException e10) {
            this.hasErrors = true;
            this.onException.invoke(e10);
        }
    }

    @Override // Mb.AbstractC0973k, Mb.G, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e10) {
            this.hasErrors = true;
            this.onException.invoke(e10);
        }
    }

    @Override // Mb.AbstractC0973k, Mb.G, java.io.Flushable
    public void flush() {
        try {
            super.flush();
        } catch (IOException e10) {
            this.hasErrors = true;
            this.onException.invoke(e10);
        }
    }
}
