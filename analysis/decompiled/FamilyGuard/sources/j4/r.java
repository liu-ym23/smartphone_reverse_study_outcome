package j4;

import p4.InterfaceC0928a;

/* loaded from: classes.dex */
public abstract class r extends c implements p4.h {

    /* renamed from: h, reason: collision with root package name */
    private final boolean f17832h;

    public r() {
        this.f17832h = false;
    }

    @Override // j4.c
    public InterfaceC0928a b() {
        return this.f17832h ? this : super.b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return g().equals(rVar.g()) && f().equals(rVar.f()) && i().equals(rVar.i()) && k.b(e(), rVar.e());
        }
        if (obj instanceof p4.h) {
            return obj.equals(b());
        }
        return false;
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + f().hashCode()) * 31) + i().hashCode();
    }

    protected p4.h j() {
        if (this.f17832h) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (p4.h) super.h();
    }

    public String toString() {
        InterfaceC0928a interfaceC0928aB = b();
        if (interfaceC0928aB != this) {
            return interfaceC0928aB.toString();
        }
        return "property " + f() + " (Kotlin reflection is not available)";
    }

    public r(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, (i5 & 1) == 1);
        this.f17832h = (i5 & 2) == 2;
    }
}
