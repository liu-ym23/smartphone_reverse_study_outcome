package k4;

import b0.r;
import b0.y;
import java.util.Set;
import java.util.function.BiFunction;
import o4.a2;
import p5.p;
import p7.n;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5613a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f5614b;

    public /* synthetic */ f(n nVar, int i2) {
        this.f5613a = i2;
        this.f5614b = nVar;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i2 = this.f5613a;
        n nVar = this.f5614b;
        switch (i2) {
            case 0:
                return (Set) ((e) nVar).invoke(obj, obj2);
            case 1:
                return (String) ((g7.b) nVar).invoke(obj, obj2);
            case 2:
                return (Integer) ((g7.b) nVar).invoke(obj, obj2);
            case 3:
                return (a2) ((g7.b) nVar).invoke(obj, obj2);
            case 4:
                return (p) ((g7.b) nVar).invoke(obj, obj2);
            case 5:
                return (p) ((p5.n) nVar).invoke(obj, obj2);
            case 6:
                return (q5.d) ((r) nVar).invoke(obj, obj2);
            case 7:
                return (q5.d) ((y) nVar).invoke(obj, obj2);
            default:
                return (Set) ((e) nVar).invoke(obj, obj2);
        }
    }
}
