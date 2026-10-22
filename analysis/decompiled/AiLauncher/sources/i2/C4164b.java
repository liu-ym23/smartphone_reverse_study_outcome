package i2;

/* renamed from: i2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4164b {
    public static <TInput, TResult, TException extends Throwable> TResult a(int i10, TInput tinput, InterfaceC4163a<TInput, TResult, TException> interfaceC4163a, InterfaceC4165c<TInput, TResult> interfaceC4165c) throws Throwable {
        TResult tresultApply;
        if (i10 < 1) {
            return interfaceC4163a.apply(tinput);
        }
        do {
            tresultApply = interfaceC4163a.apply(tinput);
            tinput = interfaceC4165c.a(tinput, tresultApply);
            if (tinput == null) {
                break;
            }
            i10--;
        } while (i10 >= 1);
        return tresultApply;
    }
}
