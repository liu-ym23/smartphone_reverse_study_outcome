package reactor.util.function;

import java.util.function.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5965a;
    public final /* synthetic */ Function b;

    public /* synthetic */ a(int i, Function function) {
        this.f5965a = i;
        this.b = function;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = this.f5965a;
        Function function = this.b;
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
