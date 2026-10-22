package kotlinx.coroutines;

import Ua.A;
import Ua.C1091z;
import Ua.x0;
import Za.C1189i;
import Za.y;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u000b\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/e;", ExifInterface.GPS_DIRECTION_TRUE, "LZa/y;", "Lkotlin/coroutines/d;", "context", "Le9/c;", "uCont", "<init>", "(Lkotlin/coroutines/d;Le9/c;)V", "", "g1", "()Z", "e1", "", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "C", "(Ljava/lang/Object;)V", "U0", "c1", "()Ljava/lang/Object;", "LOa/c;", "_decision", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e<T> extends y<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f36355e = AtomicIntegerFieldUpdater.newUpdater(e.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    public e(kotlin.coroutines.d dVar, InterfaceC4014c<? super T> interfaceC4014c) {
        super(dVar, interfaceC4014c);
    }

    private final boolean e1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f36355e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f36355e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean g1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f36355e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f36355e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // Za.y, kotlinx.coroutines.JobSupport
    public void C(Object state) {
        U0(state);
    }

    @Override // Za.y, kotlinx.coroutines.a
    public void U0(Object state) {
        if (e1()) {
            return;
        }
        C1189i.b(IntrinsicsKt__IntrinsicsJvmKt.d(this.uCont), A.a(state, this.uCont));
    }

    public final Object c1() {
        if (g1()) {
            return C4063a.g();
        }
        Object objH = x0.h(c0());
        if (objH instanceof C1091z) {
            throw ((C1091z) objH).cause;
        }
        return objH;
    }
}
