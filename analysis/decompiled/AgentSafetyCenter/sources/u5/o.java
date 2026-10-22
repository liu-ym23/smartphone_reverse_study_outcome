package u5;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public Object f14082a;

    /* renamed from: b, reason: collision with root package name */
    public u f14083b;

    /* renamed from: c, reason: collision with root package name */
    public t5.g f14084c;

    public final boolean equals(Object obj) {
        boolean zA;
        if (this != obj) {
            if (obj instanceof o) {
                u uVar = this.f14083b;
                Object obj2 = this.f14082a;
                o oVar = (o) obj;
                Object obj3 = oVar.f14082a;
                uVar.getClass();
                if (obj2 != obj3) {
                    if ((obj2 instanceof e6.i) && (obj3 instanceof e6.i)) {
                        e6.i iVar = (e6.i) obj2;
                        e6.i iVar2 = (e6.i) obj3;
                        if (!yb.k.a(iVar.f3547a, iVar2.f3547a) || !iVar.f3548b.equals(iVar2.f3548b) || iVar.f3550d != iVar2.f3550d || !yb.k.a(iVar.f3553g, iVar2.f3553g) || !yb.k.a(iVar.i, iVar2.i) || iVar.f3556k != iVar2.f3556k || iVar.f3557l != iVar2.f3557l || iVar.f3558m != iVar2.f3558m || iVar.f3559n != iVar2.f3559n || iVar.f3560o != iVar2.f3560o || iVar.f3561p != iVar2.f3561p || iVar.f3562q != iVar2.f3562q || !iVar.f3568w.equals(iVar2.f3568w) || iVar.f3569x != iVar2.f3569x || iVar.f3551e != iVar2.f3551e || !iVar.f3570y.equals(iVar2.f3570y)) {
                            zA = false;
                        }
                    } else {
                        zA = yb.k.a(obj2, obj3);
                    }
                    if (zA || !this.f14084c.equals(oVar.f14084c)) {
                    }
                }
                zA = true;
                if (zA) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode;
        u uVar = this.f14083b;
        Object obj = this.f14082a;
        uVar.getClass();
        if (obj instanceof e6.i) {
            e6.i iVar = (e6.i) obj;
            int iHashCode2 = (iVar.f3550d.hashCode() + ((iVar.f3548b.hashCode() + (iVar.f3547a.hashCode() * 31)) * 923521)) * 961;
            iVar.f3553g.getClass();
            iHashCode = ((iVar.f3551e.hashCode() + ((iVar.f3569x.hashCode() + ((iVar.f3568w.hashCode() + ((iVar.f3562q.hashCode() + ((iVar.f3561p.hashCode() + ((iVar.f3560o.hashCode() + k0.a.h(k0.a.h(k0.a.h(k0.a.h((((1 + iHashCode2) * 31) + Arrays.hashCode(iVar.i.f548c)) * 31, 31, iVar.f3556k), 31, iVar.f3557l), 31, iVar.f3558m), 31, iVar.f3559n)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + iVar.f3570y.f3591c.hashCode();
        } else {
            iHashCode = obj != null ? obj.hashCode() : 0;
        }
        return this.f14084c.hashCode() + (iHashCode * 31);
    }
}
