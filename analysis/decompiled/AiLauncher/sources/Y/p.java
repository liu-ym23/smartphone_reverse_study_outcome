package Y;

import K.InterfaceC0898v;
import K.Y;
import java.util.UUID;

/* loaded from: classes.dex */
public class p extends Y {

    /* renamed from: b, reason: collision with root package name */
    public final String f6986b;

    /* renamed from: c, reason: collision with root package name */
    public int f6987c;

    public p(InterfaceC0898v interfaceC0898v) {
        super(interfaceC0898v);
        this.f6986b = "virtual-" + interfaceC0898v.h() + O6.l.DATE_SEPARATOR + UUID.randomUUID().toString();
    }

    public void b(int i10) {
        this.f6987c = i10;
    }

    @Override // K.Y, D.InterfaceC0778o
    public int e() {
        return z(0);
    }

    @Override // K.Y, K.InterfaceC0898v
    public String h() {
        return this.f6986b;
    }

    @Override // K.Y, D.InterfaceC0778o
    public int z(int i10) {
        return M.o.u(super.z(i10) - this.f6987c);
    }
}
