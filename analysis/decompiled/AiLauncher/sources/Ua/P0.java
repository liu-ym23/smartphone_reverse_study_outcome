package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000b\u0010!\u001a\u00020 8\u0002X\u0082\u0004¨\u0006\""}, d2 = {"LUa/P0;", "LUa/w0;", "<init>", "()V", "Lkotlinx/coroutines/g;", "job", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lkotlinx/coroutines/g;)V", "x", "", "cause", "v", "(Ljava/lang/Throwable;)V", "", VoiceWakeupReceiver.EXTRA_STATE, "", "z", "(I)Ljava/lang/Void;", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "e", "Ljava/lang/Thread;", "targetThread", "LUa/a0;", "f", "LUa/a0;", "cancelHandle", "", "u", "()Z", "onCancelling", "LOa/c;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class P0 extends AbstractC1088w0 {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6343g = AtomicIntegerFieldUpdater.newUpdater(P0.class, "_state$volatile");
    private volatile /* synthetic */ int _state$volatile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Thread targetThread = Thread.currentThread();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1045a0 cancelHandle;

    public final void A(kotlinx.coroutines.g job) {
        int i10;
        this.cancelHandle = JobKt__JobKt.q(job, false, this, 1, null);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6343g;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2 || i10 == 3) {
                    return;
                }
                z(i10);
                throw new KotlinNothingValueException();
            }
        } while (!f6343g.compareAndSet(this, i10, 0));
    }

    @Override // Ua.AbstractC1088w0
    public boolean u() {
        return true;
    }

    @Override // Ua.AbstractC1088w0
    public void v(Throwable cause) {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6343g;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2 || i10 == 3) {
                    return;
                }
                z(i10);
                throw new KotlinNothingValueException();
            }
        } while (!f6343g.compareAndSet(this, i10, 2));
        this.targetThread.interrupt();
        f6343g.set(this, 3);
    }

    public final void x() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6343g;
        while (true) {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        z(i10);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f6343g.compareAndSet(this, i10, 1)) {
                InterfaceC1045a0 interfaceC1045a0 = this.cancelHandle;
                if (interfaceC1045a0 != null) {
                    interfaceC1045a0.dispose();
                    return;
                }
                return;
            }
        }
    }

    public final Void z(int state) {
        throw new IllegalStateException(("Illegal state " + state).toString());
    }
}
