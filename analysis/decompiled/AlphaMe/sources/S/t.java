package S;

import Z2.C0141o;
import Z2.InterfaceC0140n;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class t extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final t f1772a = new t(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Object objW;
        q msg = (q) obj;
        Throwable cancellationException = (Throwable) obj2;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg instanceof p) {
            InterfaceC0140n interfaceC0140n = ((p) msg).f1765b;
            if (cancellationException == null) {
                cancellationException = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            C0141o c0141o = (C0141o) interfaceC0140n;
            c0141o.getClass();
            Z2.r rVar = new Z2.r(cancellationException, false);
            do {
                objW = c0141o.W(c0141o.G(), rVar);
                if (objW == Z2.I.f2173f || objW == Z2.I.f2174g) {
                    break;
                }
            } while (objW == Z2.I.f2175h);
        }
        return Unit.INSTANCE;
    }
}
