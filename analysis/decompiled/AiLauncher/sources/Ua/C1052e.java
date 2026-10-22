package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"LUa/e;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/a;", "Lkotlin/coroutines/d;", "parentContext", "Ljava/lang/Thread;", "blockedThread", "LUa/e0;", "eventLoop", "<init>", "(Lkotlin/coroutines/d;Ljava/lang/Thread;LUa/e0;)V", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "C", "(Ljava/lang/Object;)V", "Z0", "()Ljava/lang/Object;", Const.INTENT_KEY_UMID, "Ljava/lang/Thread;", "e", "LUa/e0;", "", "l0", "()Z", "isScopedCoroutine", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1052e<T> extends kotlinx.coroutines.a<T> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Thread blockedThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final AbstractC1053e0 eventLoop;

    public C1052e(kotlin.coroutines.d dVar, Thread thread, AbstractC1053e0 abstractC1053e0) {
        super(dVar, true, true);
        this.blockedThread = thread;
        this.eventLoop = abstractC1053e0;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void C(Object state) {
        if (kotlin.jvm.internal.p.d(Thread.currentThread(), this.blockedThread)) {
            return;
        }
        Thread thread = this.blockedThread;
        C1046b.a();
        LockSupport.unpark(thread);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T Z0() throws Throwable {
        C1046b.a();
        try {
            AbstractC1053e0 abstractC1053e0 = this.eventLoop;
            if (abstractC1053e0 != null) {
                AbstractC1053e0.A1(abstractC1053e0, false, 1, null);
            }
            while (true) {
                try {
                    AbstractC1053e0 abstractC1053e02 = this.eventLoop;
                    long jD1 = abstractC1053e02 != null ? abstractC1053e02.D1() : Long.MAX_VALUE;
                    if (g()) {
                        break;
                    }
                    C1046b.a();
                    LockSupport.parkNanos(this, jD1);
                    if (Thread.interrupted()) {
                        F(new InterruptedException());
                    }
                } catch (Throwable th) {
                    AbstractC1053e0 abstractC1053e03 = this.eventLoop;
                    if (abstractC1053e03 != null) {
                        AbstractC1053e0.v1(abstractC1053e03, false, 1, null);
                    }
                    throw th;
                }
            }
            AbstractC1053e0 abstractC1053e04 = this.eventLoop;
            if (abstractC1053e04 != null) {
                AbstractC1053e0.v1(abstractC1053e04, false, 1, null);
            }
            C1046b.a();
            T t10 = (T) x0.h(c0());
            C1091z c1091z = t10 instanceof C1091z ? (C1091z) t10 : null;
            if (c1091z == null) {
                return t10;
            }
            throw c1091z.cause;
        } catch (Throwable th2) {
            C1046b.a();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean l0() {
        return true;
    }
}
