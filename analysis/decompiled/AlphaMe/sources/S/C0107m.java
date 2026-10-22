package S;

import a3.AbstractC0162g;
import a3.C0160e;
import a3.C0167l;
import a3.InterfaceC0164i;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* renamed from: S.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0107m extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1756a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1757b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1758c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1759d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0107m(int i4, Object obj, Object obj2, Object obj3) {
        super(1);
        this.f1756a = i4;
        this.f1757b = obj;
        this.f1758c = obj2;
        this.f1759d = obj3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f1756a) {
            case 0:
                invoke((Throwable) obj);
                break;
            case 1:
                invoke((Throwable) obj);
                break;
            default:
                invoke((Throwable) obj);
                break;
        }
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Unit unit;
        int i4 = this.f1756a;
        Object obj = this.f1758c;
        Object obj2 = this.f1759d;
        Object obj3 = this.f1757b;
        switch (i4) {
            case 0:
                ((Function1) obj3).invoke(th);
                t.d dVar = (t.d) obj;
                ((InterfaceC0164i) dVar.f15275c).d(th);
                do {
                    Object objK = ((InterfaceC0164i) dVar.f15275c).k();
                    if (objK instanceof C0167l) {
                        objK = null;
                    }
                    if (objK == null) {
                        unit = null;
                    } else {
                        ((Function2) obj2).invoke(objK, th);
                        unit = Unit.INSTANCE;
                    }
                } while (unit != null);
                return;
            case 1:
                if (obj3 == AbstractC0162g.f2301l) {
                    return;
                }
                Function1 function1 = ((C0160e) obj).f2288b;
                B0.g.y(obj2);
                throw null;
            default:
                CoroutineContext coroutineContext = (CoroutineContext) obj2;
                androidx.fragment.app.A aI = com.stepos.statsrpk.c.i((Function1) obj3, obj, null);
                if (aI != null) {
                    Z2.C.a(coroutineContext, aI);
                    return;
                }
                return;
        }
    }
}
