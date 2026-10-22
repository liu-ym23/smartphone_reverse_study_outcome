package Za;

import Ua.AbstractC1053e0;
import Ua.InterfaceC1066l;
import Ua.O0;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4111c;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00028\u0000H\u0000¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00102\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b/\u00100\u0012\u0004\b1\u0010\u0010R\u0014\u00104\u001a\u00020\u001c8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b3\u00100R\u001c\u00107\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010$\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0014R\u0013\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0?8\u0002X\u0082\u0004¨\u0006A"}, d2 = {"LZa/h;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/f;", "Lg9/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Le9/c;", "LUa/I;", "dispatcher", "continuation", "<init>", "(LUa/I;Le9/c;)V", "", "s", "()Z", "LY8/t;", "m", "()V", "y", "Lkotlinx/coroutines/c;", "n", "()Lkotlinx/coroutines/c;", "LUa/l;", "", "z", "(LUa/l;)Ljava/lang/Throwable;", "cause", "u", "(Ljava/lang/Throwable;)Z", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/d;", "context", UxipConstants.f30680s, "o", "(Lkotlin/coroutines/d;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "LUa/I;", "e", "Le9/c;", "f", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "_state", Const.INTENT_KEY_BACKGROUND_COMMAND, "countOrElement", "getCallerFrame", "()Lg9/c;", "callerFrame", "c", "()Le9/c;", "delegate", "getContext", "()Lkotlin/coroutines/d;", "p", "reusableCancellableContinuation", "LOa/e;", "_reusableCancellableContinuation", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1188h<T> extends kotlinx.coroutines.f<T> implements InterfaceC4111c, InterfaceC4014c<T> {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7730h = AtomicReferenceFieldUpdater.newUpdater(C1188h.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Ua.I dispatcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4014c<T> continuation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Object _state;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Object countOrElement;

    /* JADX WARN: Multi-variable type inference failed */
    public C1188h(Ua.I i10, InterfaceC4014c<? super T> interfaceC4014c) {
        super(-1);
        this.dispatcher = i10;
        this.continuation = interfaceC4014c;
        this._state = C1189i.f7735a;
        this.countOrElement = J.g(getContext());
    }

    @Override // kotlinx.coroutines.f
    public InterfaceC4014c<T> c() {
        return this;
    }

    @Override // g9.InterfaceC4111c
    public InterfaceC4111c getCallerFrame() {
        InterfaceC4014c<T> interfaceC4014c = this.continuation;
        if (interfaceC4014c instanceof InterfaceC4111c) {
            return (InterfaceC4111c) interfaceC4014c;
        }
        return null;
    }

    @Override // e9.InterfaceC4014c
    public kotlin.coroutines.d getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlinx.coroutines.f
    public Object i() {
        Object obj = this._state;
        this._state = C1189i.f7735a;
        return obj;
    }

    public final void m() {
        while (f7730h.get(this) == C1189i.f7736b) {
        }
    }

    public final kotlinx.coroutines.c<T> n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7730h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f7730h.set(this, C1189i.f7736b);
                return null;
            }
            if (obj instanceof kotlinx.coroutines.c) {
                if (f7730h.compareAndSet(this, obj, C1189i.f7736b)) {
                    return (kotlinx.coroutines.c) obj;
                }
            } else if (obj != C1189i.f7736b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void o(kotlin.coroutines.d context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.k1(context, this);
    }

    public final kotlinx.coroutines.c<?> p() {
        Object obj = f7730h.get(this);
        if (obj instanceof kotlinx.coroutines.c) {
            return (kotlinx.coroutines.c) obj;
        }
        return null;
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) {
        Object objB = Ua.A.b(result);
        if (C1189i.d(this.dispatcher, getContext())) {
            this._state = objB;
            this.resumeMode = 0;
            C1189i.c(this.dispatcher, getContext(), this);
            return;
        }
        AbstractC1053e0 abstractC1053e0B = O0.f6339a.b();
        if (abstractC1053e0B.B1()) {
            this._state = objB;
            this.resumeMode = 0;
            abstractC1053e0B.x1(this);
            return;
        }
        abstractC1053e0B.z1(true);
        try {
            kotlin.coroutines.d context = getContext();
            Object objI = J.i(context, this.countOrElement);
            try {
                this.continuation.resumeWith(result);
                Y8.t tVar = Y8.t.f7040a;
                while (abstractC1053e0B.E1()) {
                }
            } finally {
                J.f(context, objI);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final boolean s() {
        return f7730h.get(this) != null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + Ua.N.c(this.continuation) + ']';
    }

    public final boolean u(Throwable cause) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7730h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            C c10 = C1189i.f7736b;
            if (kotlin.jvm.internal.p.d(obj, c10)) {
                if (f7730h.compareAndSet(this, c10, cause)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (f7730h.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void y() {
        m();
        kotlinx.coroutines.c<?> cVarP = p();
        if (cVarP != null) {
            cVarP.u();
        }
    }

    public final Throwable z(InterfaceC1066l<?> continuation) {
        C c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7730h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c10 = C1189i.f7736b;
            if (obj != c10) {
                if (obj instanceof Throwable) {
                    if (f7730h.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f7730h.compareAndSet(this, c10, continuation));
        return null;
    }
}
