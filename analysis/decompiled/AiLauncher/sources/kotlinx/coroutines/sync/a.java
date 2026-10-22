package kotlinx.coroutines.sync;

import M5.b;
import Ua.C1072o;
import Ua.I;
import Ua.InterfaceC1066l;
import Ua.N;
import Ua.U0;
import Y8.t;
import Za.z;
import cb.j;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sla.G;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import eb.f;
import f9.C4063a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.c;
import kotlinx.coroutines.sync.a;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0017\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0015RR\u0010\u001f\u001a@\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u00180\u0018j\u0002`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070#8\u0002X\u0082\u0004¨\u0006%"}, d2 = {"Lkotlinx/coroutines/sync/a;", "Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "Leb/a;", "", G.LOCK_LOCKED, "<init>", "(Z)V", "", "owner", "LY8/t;", "m", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)Z", "l", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "C", "(Ljava/lang/Object;)I", "F", "I", "Lkotlin/Function3;", "Lcb/j;", "", "Lkotlin/coroutines/d;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Lp9/q;", "onSelectCancellationUnlockConstructor", "D", "()Z", "isLocked", "LOa/e;", Const.INTENT_KEY_APIKEY, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class a extends SemaphoreAndMutexImpl implements InterfaceC4021a {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f36827i = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "owner$volatile");

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final q<j<?>, Object, Object, q<Throwable, Object, d, t>> onSelectCancellationUnlockConstructor;
    private volatile /* synthetic */ Object owner$volatile;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJO\u0010\u0011\u001a\u0004\u0018\u00010\u0006\"\b\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u00062 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0013\u001a\u00020\u0002\"\b\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00028\u00002 \u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0097\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0006H\u0097\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\"\u001a\u00020\u00022\u0018\u0010!\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00020\u001fj\u0002` H\u0096\u0001¢\u0006\u0004\b\"\u0010#J$\u0010(\u001a\u00020\u00022\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$2\u0006\u0010'\u001a\u00020&H\u0096\u0001¢\u0006\u0004\b(\u0010)J\u001c\u0010+\u001a\u00020\u0002*\u00020*2\u0006\u0010\u000b\u001a\u00020\u0002H\u0097\u0001¢\u0006\u0004\b+\u0010,J.\u0010-\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fH\u0097\u0001¢\u0006\u0004\b-\u0010.J\u001e\u00101\u001a\u00020\u00022\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020/H\u0096\u0001¢\u0006\u0004\b1\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00107\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00106R\u0014\u00109\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u0010:\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010=\u001a\u00020\u000f8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lkotlinx/coroutines/sync/a$a;", "LUa/l;", "LY8/t;", "LUa/U0;", "Lkotlinx/coroutines/c;", "cont", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/a;Lkotlinx/coroutines/c;Ljava/lang/Object;)V", "R", UxipConstants.f30680s, "idempotent", "Lkotlin/Function3;", "", "Lkotlin/coroutines/d;", "onCancellation", "m", "(LY8/t;Ljava/lang/Object;Lp9/q;)Ljava/lang/Object;", "e", "(LY8/t;Lp9/q;)V", "exception", "k", "(Ljava/lang/Throwable;)Ljava/lang/Object;", b.CREDENTIAL_TOKEN, "x", "(Ljava/lang/Object;)V", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "q", "(Lp9/l;)V", "LZa/z;", "segment", "", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LZa/z;I)V", "LUa/I;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LUa/I;LY8/t;)V", Const.INTENT_KEY_UMID, "(LY8/t;Lp9/l;)V", "Lkotlin/Result;", "result", "resumeWith", Const.INTENT_KEY_APIKEY, "Lkotlinx/coroutines/c;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "()Z", "isActive", Const.INTENT_KEY_BACKGROUND_COMMAND, "isCompleted", "isCancelled", "getContext", "()Lkotlin/coroutines/d;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.sync.a$a, reason: collision with other inner class name */
    public final class C0465a implements InterfaceC1066l<t>, U0 {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final c<t> cont;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Object owner;

        /* JADX WARN: Multi-variable type inference failed */
        public C0465a(c<? super t> cVar, Object obj) {
            this.cont = cVar;
            this.owner = obj;
        }

        public static final t f(a aVar, C0465a c0465a, Throwable th) {
            aVar.l(c0465a.owner);
            return t.f7040a;
        }

        public static final t n(a aVar, C0465a c0465a, Throwable th, t tVar, d dVar) {
            a.B().set(aVar, c0465a.owner);
            aVar.l(c0465a.owner);
            return t.f7040a;
        }

        @Override // Ua.InterfaceC1066l
        public boolean b() {
            return this.cont.b();
        }

        @Override // Ua.InterfaceC1066l
        public boolean cancel(Throwable cause) {
            return this.cont.cancel(cause);
        }

        @Override // Ua.InterfaceC1066l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void v(t value, InterfaceC5074l<? super Throwable, t> onCancellation) {
            this.cont.v(value, onCancellation);
        }

        @Override // Ua.InterfaceC1066l
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public <R extends t> void w(R value, q<? super Throwable, ? super R, ? super d, t> onCancellation) {
            a.B().set(a.this, this.owner);
            c<t> cVar = this.cont;
            final a aVar = a.this;
            cVar.v(value, new InterfaceC5074l() { // from class: eb.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return a.C0465a.f(aVar, this, (Throwable) obj);
                }
            });
        }

        @Override // Ua.InterfaceC1066l
        public boolean g() {
            return this.cont.g();
        }

        @Override // e9.InterfaceC4014c
        public d getContext() {
            return this.cont.getContext();
        }

        @Override // Ua.U0
        public void h(z<?> segment, int index) {
            this.cont.h(segment, index);
        }

        @Override // Ua.InterfaceC1066l
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void t(I i10, t tVar) {
            this.cont.t(i10, tVar);
        }

        @Override // Ua.InterfaceC1066l
        public boolean isCancelled() {
            return this.cont.isCancelled();
        }

        @Override // Ua.InterfaceC1066l
        public Object k(Throwable exception) {
            return this.cont.k(exception);
        }

        @Override // Ua.InterfaceC1066l
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public <R extends t> Object l(R value, Object idempotent, q<? super Throwable, ? super R, ? super d, t> onCancellation) {
            final a aVar = a.this;
            Object objL = this.cont.l(value, idempotent, new q() { // from class: eb.d
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return a.C0465a.n(aVar, this, (Throwable) obj, (t) obj2, (kotlin.coroutines.d) obj3);
                }
            });
            if (objL != null) {
                a.B().set(a.this, this.owner);
            }
            return objL;
        }

        @Override // Ua.InterfaceC1066l
        public void q(InterfaceC5074l<? super Throwable, t> handler) {
            this.cont.q(handler);
        }

        @Override // e9.InterfaceC4014c
        public void resumeWith(Object result) {
            this.cont.resumeWith(result);
        }

        @Override // Ua.InterfaceC1066l
        public void x(Object token) {
            this.cont.x(token);
        }
    }

    public a(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner$volatile = z10 ? null : f.f32434a;
        this.onSelectCancellationUnlockConstructor = new q() { // from class: eb.b
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return kotlinx.coroutines.sync.a.G(this.f32427a, (cb.j) obj, obj2, obj3);
            }
        };
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater B() {
        return f36827i;
    }

    public static /* synthetic */ Object E(a aVar, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objF;
        return (!aVar.g(obj) && (objF = aVar.F(obj, interfaceC4014c)) == C4063a.g()) ? objF : t.f7040a;
    }

    public static final q G(final a aVar, j jVar, final Object obj, Object obj2) {
        return new q() { // from class: eb.c
            @Override // p9.q
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return kotlinx.coroutines.sync.a.H(this.f32428a, obj, (Throwable) obj3, obj4, (kotlin.coroutines.d) obj5);
            }
        };
    }

    public static final t H(a aVar, Object obj, Throwable th, Object obj2, d dVar) {
        aVar.l(obj);
        return t.f7040a;
    }

    public final int C(Object owner) {
        while (D()) {
            Object obj = f36827i.get(this);
            if (obj != f.f32434a) {
                return obj == owner ? 1 : 2;
            }
        }
        return 0;
    }

    public boolean D() {
        return a() == 0;
    }

    public final Object F(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        c cVarB = C1072o.b(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c));
        try {
            h(new C0465a(cVarB, obj));
            Object objC = cVarB.C();
            if (objC == C4063a.g()) {
                g9.f.c(interfaceC4014c);
            }
            return objC == C4063a.g() ? objC : t.f7040a;
        } catch (Throwable th) {
            cVarB.Q();
            throw th;
        }
    }

    public final int I(Object owner) {
        while (!v()) {
            if (owner == null) {
                return 1;
            }
            int iC = C(owner);
            if (iC == 1) {
                return 2;
            }
            if (iC == 2) {
                return 1;
            }
        }
        f36827i.set(this, owner);
        return 0;
    }

    @Override // eb.InterfaceC4021a
    public boolean g(Object owner) {
        int I10 = I(owner);
        if (I10 == 0) {
            return true;
        }
        if (I10 == 1) {
            return false;
        }
        if (I10 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
    }

    @Override // eb.InterfaceC4021a
    public void l(Object owner) {
        while (D()) {
            Object obj = f36827i.get(this);
            if (obj != f.f32434a) {
                if (obj != owner && owner != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj + ", but " + owner + " is expected").toString());
                }
                if (f36827i.compareAndSet(this, obj, f.f32434a)) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    @Override // eb.InterfaceC4021a
    public Object m(Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
        return E(this, obj, interfaceC4014c);
    }

    public String toString() {
        return "Mutex@" + N.b(this) + "[isLocked=" + D() + ",owner=" + f36827i.get(this) + ']';
    }
}
