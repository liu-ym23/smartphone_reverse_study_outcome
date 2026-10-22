package ba;

/* loaded from: classes.dex */
public final class b extends d7.b {

    /* renamed from: h, reason: collision with root package name */
    public int f1590h = -1;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f1591i;

    public b(c cVar) {
        this.f1591i = cVar;
    }

    @Override // d7.b
    public final void a() {
        int i2;
        Object[] objArr;
        do {
            i2 = this.f1590h + 1;
            this.f1590h = i2;
            objArr = this.f1591i.f1592f;
            if (i2 >= objArr.length) {
                break;
            }
        } while (objArr[i2] == null);
        if (i2 >= objArr.length) {
            this.f2945f = 2;
            return;
        }
        Object obj = objArr[i2];
        q7.k.c(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
        this.f2946g = obj;
        this.f2945f = 1;
    }
}
