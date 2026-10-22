package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0012R(\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"LUa/S0;", ExifInterface.GPS_DIRECTION_TRUE, "LZa/y;", "Lkotlin/coroutines/d;", "context", "Le9/c;", "uCont", "<init>", "(Lkotlin/coroutines/d;Le9/c;)V", "", "oldValue", "LY8/t;", "e1", "(Lkotlin/coroutines/d;Ljava/lang/Object;)V", "", "c1", "()Z", "Z0", "()V", VoiceWakeupReceiver.EXTRA_STATE, "U0", "(Ljava/lang/Object;)V", "d1", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "e", "Ljava/lang/ThreadLocal;", "threadStateToRecover", "threadLocalIsSet", "Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class S0<T> extends Za.y<T> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ThreadLocal<Pair<kotlin.coroutines.d, Object>> threadStateToRecover;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public S0(kotlin.coroutines.d dVar, InterfaceC4014c<? super T> interfaceC4014c) {
        T0 t02 = T0.f6349a;
        super(dVar.get(t02) == null ? dVar.plus(t02) : dVar, interfaceC4014c);
        this.threadStateToRecover = new ThreadLocal<>();
        if (interfaceC4014c.getContext().get(kotlin.coroutines.c.INSTANCE) instanceof I) {
            return;
        }
        Object objI = Za.J.i(dVar, null);
        Za.J.f(dVar, objI);
        e1(dVar, objI);
    }

    @Override // Za.y, kotlinx.coroutines.a
    public void U0(Object state) {
        d1();
        Object objA = A.a(state, this.uCont);
        InterfaceC4014c<T> interfaceC4014c = this.uCont;
        kotlin.coroutines.d context = interfaceC4014c.getContext();
        Object objI = Za.J.i(context, null);
        S0<?> s0M = objI != Za.J.f7710a ? G.m(interfaceC4014c, context, objI) : null;
        try {
            this.uCont.resumeWith(objA);
            Y8.t tVar = Y8.t.f7040a;
            if (s0M == null || s0M.c1()) {
                Za.J.f(context, objI);
            }
        } catch (Throwable th) {
            if (s0M == null || s0M.c1()) {
                Za.J.f(context, objI);
            }
            throw th;
        }
    }

    @Override // Za.y
    public void Z0() {
        d1();
    }

    public final boolean c1() {
        boolean z10 = this.threadLocalIsSet && this.threadStateToRecover.get() == null;
        this.threadStateToRecover.remove();
        return !z10;
    }

    public final void d1() {
        if (this.threadLocalIsSet) {
            Pair<kotlin.coroutines.d, Object> pair = this.threadStateToRecover.get();
            if (pair != null) {
                Za.J.f(pair.a(), pair.b());
            }
            this.threadStateToRecover.remove();
        }
    }

    public final void e1(kotlin.coroutines.d context, Object oldValue) {
        this.threadLocalIsSet = true;
        this.threadStateToRecover.set(Y8.j.a(context, oldValue));
    }
}
