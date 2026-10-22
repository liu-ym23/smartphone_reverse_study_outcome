package x2;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f15924a;

    /* renamed from: b, reason: collision with root package name */
    public d f15925b;

    /* renamed from: c, reason: collision with root package name */
    public d f15926c;

    public c(Object[] objArr) {
        this.f15924a = objArr;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        if (this.f15925b == null) {
            Object[] objArr = this.f15924a;
            this.f15925b = new d(objArr);
            this.f15926c = new d(objArr);
        }
        d dVar = this.f15925b;
        if (!dVar.f15929c) {
            dVar.f15928b = 0;
            dVar.f15929c = true;
            this.f15926c.f15929c = false;
            return dVar;
        }
        d dVar2 = this.f15926c;
        dVar2.f15928b = 0;
        dVar2.f15929c = true;
        dVar.f15929c = false;
        return dVar2;
    }
}
