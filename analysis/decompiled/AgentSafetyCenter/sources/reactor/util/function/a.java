package reactor.util.function;

import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10919a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Function f10920b;

    public /* synthetic */ a(int i) {
        this.f10919a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f10919a;
        Function function = this.f10920b;
        Object[] objArr = (Object[]) obj;
        switch (i) {
            case 0:
                return Tuples.lambda$fn6$4(function, objArr);
            case 1:
                return Tuples.lambda$fn3$1(function, objArr);
            case 2:
                return Tuples.lambda$fnAny$0(function, objArr);
            case 3:
                return Tuples.lambda$fn5$3(function, objArr);
            case 4:
                return Tuples.lambda$fn7$5(function, objArr);
            case 5:
                return Tuples.lambda$fn8$6(function, objArr);
            default:
                return Tuples.lambda$fn4$2(function, objArr);
        }
    }
}
