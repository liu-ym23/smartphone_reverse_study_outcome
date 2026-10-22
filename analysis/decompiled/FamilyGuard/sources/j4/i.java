package j4;

import p4.InterfaceC0928a;
import p4.InterfaceC0931d;

/* loaded from: classes.dex */
public class i extends c implements h, InterfaceC0931d {

    /* renamed from: h, reason: collision with root package name */
    private final int f17828h;

    /* renamed from: i, reason: collision with root package name */
    private final int f17829i;

    public i(int i5, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.f17828h = i5;
        this.f17829i = i6 >> 1;
    }

    @Override // j4.c
    protected InterfaceC0928a d() {
        return w.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return f().equals(iVar.f()) && i().equals(iVar.i()) && this.f17829i == iVar.f17829i && this.f17828h == iVar.f17828h && k.b(e(), iVar.e()) && k.b(g(), iVar.g());
        }
        if (obj instanceof InterfaceC0931d) {
            return obj.equals(b());
        }
        return false;
    }

    @Override // j4.h
    public int getArity() {
        return this.f17828h;
    }

    public int hashCode() {
        return (((g() == null ? 0 : g().hashCode() * 31) + f().hashCode()) * 31) + i().hashCode();
    }

    public String toString() {
        InterfaceC0928a interfaceC0928aB = b();
        if (interfaceC0928aB != this) {
            return interfaceC0928aB.toString();
        }
        if ("<init>".equals(f())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + f() + " (Kotlin reflection is not available)";
    }
}
