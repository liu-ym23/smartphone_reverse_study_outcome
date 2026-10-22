package D7;

import B9.C0194v;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class s implements Iterable, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f405a;
    public final Object b;

    public /* synthetic */ s(Object obj, int i) {
        this.f405a = i;
        this.b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f405a) {
            case 0:
                return kotlin.jvm.internal.k.j((Object[]) this.b);
            case 1:
                int[] array = (int[]) this.b;
                kotlin.jvm.internal.k.f(array, "array");
                return new kotlin.jvm.internal.a(array);
            case 2:
                long[] array2 = (long[]) this.b;
                kotlin.jvm.internal.k.f(array2, "array");
                return new kotlin.jvm.internal.b(array2);
            case 3:
                float[] array3 = (float[]) this.b;
                kotlin.jvm.internal.k.f(array3, "array");
                return new C7.i(array3);
            case 4:
                double[] array4 = (double[]) this.b;
                kotlin.jvm.internal.k.f(array4, "array");
                return new C7.i(array4);
            case 5:
                return new E((Iterator) ((S7.a) this.b).invoke());
            case 6:
                return ((i9.i) this.b).iterator();
            default:
                return new C7.i((C0194v) this.b);
        }
    }
}
