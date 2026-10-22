package k0;

import Ua.InterfaceC1066l;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ListenableFutureKt;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import g3.InterfaceFutureC4095a;
import java.util.concurrent.ExecutionException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lk0/b;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Runnable;", "Lg3/a;", "futureToObserve", "LUa/l;", "continuation", "<init>", "(Lg3/a;LUa/l;)V", "LY8/t;", "run", "()V", Const.INTENT_KEY_APIKEY, "Lg3/a;", "getFutureToObserve", "()Lg3/a;", Const.INTENT_KEY_PKGNAME, "LUa/l;", "getContinuation", "()LUa/l;", "concurrent-futures-ktx"}, k = 1, mv = {1, 4, 0})
/* renamed from: k0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC4798b<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceFutureC4095a<T> futureToObserve;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC1066l<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public RunnableC4798b(InterfaceFutureC4095a<T> futureToObserve, InterfaceC1066l<? super T> continuation) {
        p.j(futureToObserve, "futureToObserve");
        p.j(continuation, "continuation");
        this.futureToObserve = futureToObserve;
        this.continuation = continuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.futureToObserve.isCancelled()) {
            InterfaceC1066l.j(this.continuation, null, 1, null);
            return;
        }
        try {
            InterfaceC1066l<T> interfaceC1066l = this.continuation;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(AbstractResolvableFuture.k(this.futureToObserve)));
        } catch (ExecutionException e10) {
            InterfaceC1066l<T> interfaceC1066l2 = this.continuation;
            Throwable thC = ListenableFutureKt.c(e10);
            Result.Companion companion2 = Result.INSTANCE;
            interfaceC1066l2.resumeWith(Result.b(C4849c.a(thC)));
        }
    }
}
