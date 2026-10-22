package mb;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class w<T> extends c<T> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f10564a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10565b;

    /* renamed from: c, reason: collision with root package name */
    public int f10566c;

    /* renamed from: d, reason: collision with root package name */
    public int f10567d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends b<T> {

        /* renamed from: c, reason: collision with root package name */
        public int f10568c;

        /* renamed from: d, reason: collision with root package name */
        public int f10569d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ w<T> f10570e;

        public a(w<T> wVar) {
            this.f10570e = wVar;
            this.f10568c = wVar.f10567d;
            this.f10569d = wVar.f10566c;
        }

        @Override // mb.b
        public final void a() {
            int i10 = this.f10568c;
            if (i10 == 0) {
                this.f10545a = 2;
                return;
            }
            w<T> wVar = this.f10570e;
            Object[] objArr = wVar.f10564a;
            int i11 = this.f10569d;
            this.f10546b = (T) objArr[i11];
            this.f10545a = 1;
            this.f10569d = (i11 + 1) % wVar.f10565b;
            this.f10568c = i10 - 1;
        }
    }

    public w(Object[] objArr, int i10) {
        this.f10564a = objArr;
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "ring buffer filled size should not be negative but it is ").toString());
        }
        if (i10 <= objArr.length) {
            this.f10565b = objArr.length;
            this.f10567d = i10;
        } else {
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
            sbK.append(objArr.length);
            throw new IllegalArgumentException(sbK.toString().toString());
        }
    }

    @Override // mb.a
    public final int a() {
        return this.f10567d;
    }

    public final void b() {
        if (2 > this.f10567d) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = 2, size = " + this.f10567d).toString());
        }
        int i10 = this.f10566c;
        int i11 = this.f10565b;
        int i12 = (i10 + 2) % i11;
        Object[] objArr = this.f10564a;
        if (i10 > i12) {
            b1.G(null, objArr, i10, i11);
            Arrays.fill(objArr, 0, i12, (Object) null);
        } else {
            b1.G(null, objArr, i10, i12);
        }
        this.f10566c = i12;
        this.f10567d -= 2;
    }

    @Override // java.util.List
    public final T get(int i10) {
        int iA = a();
        if (i10 < 0 || i10 >= iA) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, iA, ", size: "));
        }
        return (T) this.f10564a[(this.f10566c + i10) % this.f10565b];
    }

    @Override // mb.c, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<T> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mb.a, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // mb.a, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Object[] objArr;
        kotlin.jvm.internal.g.f(array, "array");
        int length = array.length;
        int i10 = this.f10567d;
        if (length < i10) {
            array = (T[]) Arrays.copyOf(array, i10);
            kotlin.jvm.internal.g.e(array, "copyOf(...)");
        }
        int i11 = this.f10567d;
        int i12 = this.f10566c;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            objArr = this.f10564a;
            if (i14 >= i11 || i12 >= this.f10565b) {
                break;
            }
            array[i14] = objArr[i12];
            i14++;
            i12++;
        }
        while (i14 < i11) {
            array[i14] = objArr[i13];
            i14++;
            i13++;
        }
        if (i11 < array.length) {
            array[i11] = null;
        }
        return array;
    }
}
