package K;

import D.InterfaceC0776m;
import D.InterfaceC0778o;
import java.util.ArrayList;
import java.util.List;

/* renamed from: K.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0878d0 implements InterfaceC0776m {

    /* renamed from: b, reason: collision with root package name */
    public final int f3955b;

    public C0878d0(int i10) {
        this.f3955b = i10;
    }

    @Override // D.InterfaceC0776m
    public List<InterfaceC0778o> b(List<InterfaceC0778o> list) {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC0778o interfaceC0778o : list) {
            B0.h.b(interfaceC0778o instanceof InterfaceC0898v, "The camera info doesn't contain internal implementation.");
            if (interfaceC0778o.k() == this.f3955b) {
                arrayList.add(interfaceC0778o);
            }
        }
        return arrayList;
    }

    public int c() {
        return this.f3955b;
    }
}
