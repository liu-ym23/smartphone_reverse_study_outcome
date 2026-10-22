package ic;

/* renamed from: ic.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4198b<T> {

    /* renamed from: a, reason: collision with root package name */
    public a<T>[] f33138a;

    /* renamed from: b, reason: collision with root package name */
    public int f33139b;

    /* renamed from: c, reason: collision with root package name */
    public int f33140c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f33141d;

    /* renamed from: ic.b$a */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final long f33142a;

        /* renamed from: b, reason: collision with root package name */
        public T f33143b;

        /* renamed from: c, reason: collision with root package name */
        public a<T> f33144c;

        public a(long j10, T t10, a<T> aVar) {
            this.f33142a = j10;
            this.f33143b = t10;
            this.f33144c = aVar;
        }
    }

    public C4198b() {
        this(16);
    }

    public T a(long j10) {
        for (a<T> aVar = this.f33138a[((((int) (j10 >>> 32)) ^ ((int) j10)) & Integer.MAX_VALUE) % this.f33139b]; aVar != null; aVar = aVar.f33144c) {
            if (aVar.f33142a == j10) {
                return aVar.f33143b;
            }
        }
        return null;
    }

    public long[] b() {
        long[] jArr = new long[this.f33141d];
        int i10 = 0;
        for (a<T> aVar : this.f33138a) {
            while (aVar != null) {
                jArr[i10] = aVar.f33142a;
                aVar = aVar.f33144c;
                i10++;
            }
        }
        return jArr;
    }

    public T c(long j10, T t10) {
        int i10 = ((((int) (j10 >>> 32)) ^ ((int) j10)) & Integer.MAX_VALUE) % this.f33139b;
        a<T> aVar = this.f33138a[i10];
        for (a<T> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f33144c) {
            if (aVar2.f33142a == j10) {
                T t11 = aVar2.f33143b;
                aVar2.f33143b = t10;
                return t11;
            }
        }
        this.f33138a[i10] = new a<>(j10, t10, aVar);
        this.f33141d++;
        if (this.f33141d <= this.f33140c) {
            return null;
        }
        d(this.f33139b * 2);
        return null;
    }

    public void d(int i10) {
        a<T>[] aVarArr = new a[i10];
        for (a<T> aVar : this.f33138a) {
            while (aVar != null) {
                long j10 = aVar.f33142a;
                int i11 = ((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % i10;
                a<T> aVar2 = aVar.f33144c;
                aVar.f33144c = aVarArr[i11];
                aVarArr[i11] = aVar;
                aVar = aVar2;
            }
        }
        this.f33138a = aVarArr;
        this.f33139b = i10;
        this.f33140c = (i10 * 4) / 3;
    }

    public int e() {
        return this.f33141d;
    }

    public C4198b(int i10) {
        this.f33139b = i10;
        this.f33140c = (i10 * 4) / 3;
        this.f33138a = new a[i10];
    }
}
