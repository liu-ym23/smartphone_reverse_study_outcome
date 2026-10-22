package Hb;

import Mb.I;
import Mb.InterfaceC0968f;
import Mb.u;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import okio.ByteString;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0003R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u00020\u00128\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u000f\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010 ¨\u0006\""}, d2 = {"LHb/b;", "Lokhttp3/internal/publicsuffix/a;", "<init>", "()V", "LMb/I;", "e", "()LMb/I;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/CountDownLatch;", "c", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "Lokio/ByteString;", Const.INTENT_KEY_UMID, "Lokio/ByteString;", Const.INTENT_KEY_APIKEY, "()Lokio/ByteString;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lokio/ByteString;)V", SingleFileBundle.KEY_BYTES, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "exceptionBytes", "Ljava/io/IOException;", "Ljava/io/IOException;", "readFailure", "", "()Ljava/lang/Object;", "path", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class b implements okhttp3.internal.publicsuffix.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean listRead = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ByteString bytes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ByteString exceptionBytes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public IOException readFailure;

    @Override // okhttp3.internal.publicsuffix.a
    public ByteString a() {
        ByteString byteString = this.bytes;
        if (byteString != null) {
            return byteString;
        }
        p.A(SingleFileBundle.KEY_BYTES);
        return null;
    }

    @Override // okhttp3.internal.publicsuffix.a
    public void b() throws InterruptedException {
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            g();
        }
        if (this.bytes != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Unable to load " + getPath() + " resource.");
        illegalStateException.initCause(this.readFailure);
        throw illegalStateException;
    }

    @Override // okhttp3.internal.publicsuffix.a
    public ByteString c() {
        ByteString byteString = this.exceptionBytes;
        if (byteString != null) {
            return byteString;
        }
        p.A("exceptionBytes");
        return null;
    }

    /* renamed from: d */
    public abstract Object getPath();

    public abstract I e();

    public final void f() throws IOException {
        try {
            InterfaceC0968f interfaceC0968fC = u.c(e());
            try {
                ByteString byteStringZ0 = interfaceC0968fC.z0(interfaceC0968fC.readInt());
                ByteString byteStringZ02 = interfaceC0968fC.z0(interfaceC0968fC.readInt());
                t tVar = t.f7040a;
                l9.b.a(interfaceC0968fC, null);
                synchronized (this) {
                    p.f(byteStringZ0);
                    h(byteStringZ0);
                    p.f(byteStringZ02);
                    i(byteStringZ02);
                }
            } finally {
            }
        } finally {
            this.readCompleteLatch.countDown();
        }
    }

    public final void g() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    f();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    this.readFailure = e10;
                    if (!z10) {
                        return;
                    }
                }
            } finally {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void h(ByteString byteString) {
        p.i(byteString, "<set-?>");
        this.bytes = byteString;
    }

    public void i(ByteString byteString) {
        p.i(byteString, "<set-?>");
        this.exceptionBytes = byteString;
    }
}
