package s;

/* loaded from: classes.dex */
class g<T> implements f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f20178a;

    /* renamed from: b, reason: collision with root package name */
    private int f20179b;

    g(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f20178a = new Object[i5];
    }

    @Override // s.f
    public boolean a(T t5) {
        int i5 = this.f20179b;
        Object[] objArr = this.f20178a;
        if (i5 >= objArr.length) {
            return false;
        }
        objArr[i5] = t5;
        this.f20179b = i5 + 1;
        return true;
    }

    @Override // s.f
    public T b() {
        int i5 = this.f20179b;
        if (i5 <= 0) {
            return null;
        }
        int i6 = i5 - 1;
        Object[] objArr = this.f20178a;
        T t5 = (T) objArr[i6];
        objArr[i6] = null;
        this.f20179b = i5 - 1;
        return t5;
    }

    @Override // s.f
    public void c(T[] tArr, int i5) {
        if (i5 > tArr.length) {
            i5 = tArr.length;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            T t5 = tArr[i6];
            int i7 = this.f20179b;
            Object[] objArr = this.f20178a;
            if (i7 < objArr.length) {
                objArr[i7] = t5;
                this.f20179b = i7 + 1;
            }
        }
    }
}
