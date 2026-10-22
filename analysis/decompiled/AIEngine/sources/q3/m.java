package q3;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class m<T> {

    /* renamed from: a, reason: collision with root package name */
    public T f11566a;

    /* renamed from: b, reason: collision with root package name */
    public a<T> f11567b;

    /* renamed from: c, reason: collision with root package name */
    public a<T> f11568c;

    /* renamed from: d, reason: collision with root package name */
    public int f11569d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f11570a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11571b;

        /* renamed from: c, reason: collision with root package name */
        public a<T> f11572c;

        public a(T t8, int i10) {
            this.f11570a = t8;
            this.f11571b = i10;
        }
    }

    public abstract T a(int i10);

    public final Object b(int i10, Object obj) {
        a<T> aVar = new a<>(obj, i10);
        if (this.f11567b == null) {
            this.f11568c = aVar;
            this.f11567b = aVar;
        } else {
            a<T> aVar2 = this.f11568c;
            if (aVar2.f11572c != null) {
                throw new IllegalStateException();
            }
            aVar2.f11572c = aVar;
            this.f11568c = aVar;
        }
        this.f11569d += i10;
        return a(i10 < 16384 ? i10 + i10 : i10 + (i10 >> 2));
    }

    public final Object c(int i10, Object obj) {
        int i11 = this.f11569d + i10;
        T tA = a(i11);
        int i12 = 0;
        for (a<T> aVar = this.f11567b; aVar != null; aVar = aVar.f11572c) {
            T t8 = aVar.f11570a;
            int i13 = aVar.f11571b;
            System.arraycopy(t8, 0, tA, i12, i13);
            i12 += i13;
        }
        System.arraycopy(obj, 0, tA, i12, i10);
        int i14 = i12 + i10;
        if (i14 == i11) {
            return tA;
        }
        throw new IllegalStateException(a0.a.f("Should have gotten ", i11, i14, " entries, got "));
    }

    public final T d() {
        a<T> aVar = this.f11568c;
        if (aVar != null) {
            this.f11566a = aVar.f11570a;
        }
        this.f11568c = null;
        this.f11567b = null;
        this.f11569d = 0;
        T t8 = this.f11566a;
        return t8 == null ? a(12) : t8;
    }
}
