package kb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public Object f7388f;

    /* renamed from: g, reason: collision with root package name */
    public Iterator f7389g;

    /* renamed from: h, reason: collision with root package name */
    public int f7390h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f7391j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f7392k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Iterator f7393l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(Iterator it, nb.c cVar) {
        super(cVar);
        this.f7393l = it;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        c0 c0Var = new c0(this.f7393l, cVar);
        c0Var.f7392k = obj;
        return c0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c0) create((gc.l) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i;
        int i3;
        int i10;
        ArrayList arrayList;
        Iterator it;
        int i11;
        int i12;
        int i13;
        a0 a0Var;
        gc.l lVar = (gc.l) this.f7392k;
        ob.a aVar = ob.a.f9351c;
        int i14 = this.f7391j;
        boolean z10 = true;
        if (i14 == 0) {
            i = 1;
            id.c.I(obj);
            i3 = 0;
            i10 = 0;
            arrayList = new ArrayList(14);
            it = this.f7393l;
            i11 = 14;
        } else {
            if (i14 != 1) {
                if (i14 != 2) {
                    if (i14 == 3) {
                        i12 = this.i;
                        int i15 = this.f7390h;
                        Iterator it2 = this.f7389g;
                        a0 a0Var2 = (a0) this.f7388f;
                        id.c.I(obj);
                        a0Var2.b();
                        while (true) {
                            int i16 = a0Var2.f7382g;
                            Object[] objArr = a0Var2.f7381f;
                            if (!it2.hasNext()) {
                                i13 = i15;
                                a0Var = a0Var2;
                                break;
                            }
                            Object next = it2.next();
                            boolean z11 = z10;
                            if (a0Var2.a() == i16) {
                                od.f.e("ring buffer is full");
                                return null;
                            }
                            int i17 = a0Var2.f7383h;
                            int i18 = a0Var2.i;
                            objArr[(i17 + i18) % i16] = next;
                            a0Var2.i = i18 + 1;
                            if (a0Var2.a() == i16) {
                                if (a0Var2.i >= 14) {
                                    ArrayList arrayList2 = new ArrayList(a0Var2);
                                    this.f7392k = lVar;
                                    this.f7388f = a0Var2;
                                    this.f7389g = it2;
                                    this.f7390h = i15;
                                    this.i = i12;
                                    this.f7391j = 3;
                                    lVar.b(arrayList2, this);
                                    ob.a aVar2 = ob.a.f9351c;
                                    return aVar;
                                }
                                int i19 = i16 + (i16 >> 1) + 1;
                                if (i19 > 14) {
                                    i19 = 14;
                                }
                                a0Var2 = new a0(a0Var2.f7383h == 0 ? Arrays.copyOf(objArr, i19) : a0Var2.toArray(new Object[i19]), a0Var2.i);
                            }
                            z10 = z11;
                        }
                    } else if (i14 == 4) {
                        i12 = this.i;
                        i13 = this.f7390h;
                        a0Var = (a0) this.f7388f;
                        id.c.I(obj);
                        a0Var.b();
                    } else {
                        if (i14 != 5) {
                            od.f.e("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                    }
                    if (a0Var.i > 14) {
                        ArrayList arrayList3 = new ArrayList(a0Var);
                        this.f7392k = lVar;
                        this.f7388f = a0Var;
                        this.f7389g = null;
                        this.f7390h = i13;
                        this.i = i12;
                        this.f7391j = 4;
                        lVar.b(arrayList3, this);
                        ob.a aVar3 = ob.a.f9351c;
                        return aVar;
                    }
                    if (!a0Var.isEmpty()) {
                        this.f7392k = null;
                        this.f7388f = null;
                        this.f7389g = null;
                        this.f7390h = i13;
                        this.i = i12;
                        this.f7391j = 5;
                        lVar.b(a0Var, this);
                        ob.a aVar4 = ob.a.f9351c;
                        return aVar;
                    }
                    return jb.v.f6774a;
                }
                id.c.I(obj);
                return jb.v.f6774a;
            }
            i = 1;
            i3 = this.i;
            int i20 = this.f7390h;
            Iterator it3 = this.f7389g;
            id.c.I(obj);
            arrayList = new ArrayList(14);
            it = it3;
            i11 = i20;
            i10 = i3;
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (i3 > 0) {
                i3--;
            } else {
                arrayList.add(next2);
                if (arrayList.size() == 14) {
                    this.f7392k = lVar;
                    this.f7388f = arrayList;
                    this.f7389g = it;
                    this.f7390h = i11;
                    this.i = i10;
                    this.f7391j = i;
                    lVar.b(arrayList, this);
                    ob.a aVar5 = ob.a.f9351c;
                    return aVar;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f7392k = null;
            this.f7388f = null;
            this.f7389g = null;
            this.f7390h = i11;
            this.i = i10;
            this.f7391j = 2;
            lVar.b(arrayList, this);
            ob.a aVar6 = ob.a.f9351c;
            return aVar;
        }
        return jb.v.f6774a;
    }
}
