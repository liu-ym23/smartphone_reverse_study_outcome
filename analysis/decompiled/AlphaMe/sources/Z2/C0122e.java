package Z2;

import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: Z2.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0122e extends AbstractC0124f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2212a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2213b;

    public C0122e(int i4, Object obj) {
        this.f2212a = i4;
        this.f2213b = obj;
    }

    @Override // Z2.AbstractC0124f
    public final void a(Throwable th) {
        int i4 = this.f2212a;
        Object obj = this.f2213b;
        switch (i4) {
            case 0:
                if (th != null) {
                    ((Future) obj).cancel(false);
                    break;
                }
                break;
            case 1:
                ((T) obj).dispose();
                break;
            default:
                ((Function1) obj).invoke(th);
                break;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f2212a) {
            case 0:
                a((Throwable) obj);
                break;
            case 1:
                a((Throwable) obj);
                break;
            default:
                a((Throwable) obj);
                break;
        }
        return Unit.INSTANCE;
    }

    public final String toString() {
        int i4 = this.f2212a;
        Object obj = this.f2213b;
        switch (i4) {
            case 0:
                return "CancelFutureOnCancel[" + ((Future) obj) + ']';
            case 1:
                return "DisposeOnCancel[" + ((T) obj) + ']';
            default:
                return "InvokeOnCancel[" + ((Function1) obj).getClass().getSimpleName() + '@' + I.p(this) + ']';
        }
    }
}
