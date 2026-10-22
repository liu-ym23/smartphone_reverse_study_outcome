package Va;

import Ua.C0;
import Ua.C1086v0;
import Ua.InterfaceC1045a0;
import Ua.InterfaceC1066l;
import Ua.T;
import Ua.Y;
import Y8.t;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!H\u0096\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0004\b(\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"LVa/f;", "LVa/g;", "LUa/T;", "Landroid/os/Handler;", "handler", "", "name", "", "invokeImmediately", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "Lkotlin/coroutines/d;", "context", "l1", "(Lkotlin/coroutines/d;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "", "timeMillis", "LUa/l;", "continuation", "v0", "(JLUa/l;)V", "LUa/a0;", "U", "(JLjava/lang/Runnable;Lkotlin/coroutines/d;)LUa/a0;", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "z1", Const.INTENT_KEY_PKGNAME, "Landroid/os/Handler;", "c", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "Z", "e", "LVa/f;", "A1", "()LVa/f;", "immediate", "kotlinx-coroutines-android"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class f extends g implements T {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String name;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final boolean invokeImmediately;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final f immediate;

    public f(Handler handler, String str, boolean z10) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z10;
        this.immediate = z10 ? this : new f(handler, str, true);
    }

    public static final void B1(f fVar, Runnable runnable) {
        fVar.handler.removeCallbacks(runnable);
    }

    public static final void C1(InterfaceC1066l interfaceC1066l, f fVar) {
        interfaceC1066l.t(fVar, t.f7040a);
    }

    public static final t D1(f fVar, Runnable runnable, Throwable th) {
        fVar.handler.removeCallbacks(runnable);
        return t.f7040a;
    }

    @Override // Ua.A0
    /* renamed from: A1, reason: from getter and merged with bridge method [inline-methods] */
    public f u1() {
        return this.immediate;
    }

    @Override // Va.g, Ua.T
    public InterfaceC1045a0 U(long timeMillis, final Runnable block, kotlin.coroutines.d context) {
        if (this.handler.postDelayed(block, C5685n.k(timeMillis, 4611686018427387903L))) {
            return new InterfaceC1045a0() { // from class: Va.c
                @Override // Ua.InterfaceC1045a0
                public final void dispose() {
                    f.B1(this.f6552a, block);
                }
            };
        }
        z1(context, block);
        return C0.f6325a;
    }

    public boolean equals(Object other) {
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        return fVar.handler == this.handler && fVar.invokeImmediately == this.invokeImmediately;
    }

    @Override // Ua.I
    public void h1(kotlin.coroutines.d context, Runnable block) {
        if (this.handler.post(block)) {
            return;
        }
        z1(context, block);
    }

    public int hashCode() {
        return (this.invokeImmediately ? 1231 : 1237) ^ System.identityHashCode(this.handler);
    }

    @Override // Ua.I
    public boolean l1(kotlin.coroutines.d context) {
        return (this.invokeImmediately && p.d(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // Ua.A0, Ua.I
    /* renamed from: toString */
    public String getName() {
        String strV1 = v1();
        if (strV1 == null) {
            strV1 = this.name;
            if (strV1 == null) {
                strV1 = this.handler.toString();
            }
            if (this.invokeImmediately) {
                return strV1 + ".immediate";
            }
        }
        return strV1;
    }

    @Override // Ua.T
    public void v0(long timeMillis, final InterfaceC1066l<? super t> continuation) {
        final Runnable runnable = new Runnable() { // from class: Va.d
            @Override // java.lang.Runnable
            public final void run() {
                f.C1(continuation, this);
            }
        };
        if (this.handler.postDelayed(runnable, C5685n.k(timeMillis, 4611686018427387903L))) {
            continuation.q(new InterfaceC5074l() { // from class: Va.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return f.D1(this.f6556a, runnable, (Throwable) obj);
                }
            });
        } else {
            z1(continuation.getContext(), runnable);
        }
    }

    public final void z1(kotlin.coroutines.d context, Runnable block) {
        C1086v0.c(context, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Y.b().h1(context, block);
    }

    public /* synthetic */ f(Handler handler, String str, int i10, i iVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public f(Handler handler, String str) {
        this(handler, str, false);
    }
}
