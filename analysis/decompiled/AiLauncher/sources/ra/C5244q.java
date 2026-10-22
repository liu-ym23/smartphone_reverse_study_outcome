package ra;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.O;
import Z8.C1173v;
import Z8.F;
import com.networknt.schema.keyword.PropertiesValidator;
import java.util.Collection;
import java.util.List;
import ka.C4827g;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import p9.InterfaceC5074l;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;

/* renamed from: ra.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5244q extends AbstractC5239l {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f38901f = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(C5244q.class, "functions", "getFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(C5244q.class, PropertiesValidator.PROPERTY, "getProperties()Ljava/util/List;", 0))};

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0797b f38902b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f38903c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC5865h f38904d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC5865h f38905e;

    public C5244q(InterfaceC5869l storageManager, InterfaceC0797b containingClass, boolean z10) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(containingClass, "containingClass");
        this.f38902b = containingClass;
        this.f38903c = z10;
        containingClass.getKind();
        ClassKind classKind = ClassKind.CLASS;
        this.f38904d = storageManager.i(new C5242o(this));
        this.f38905e = storageManager.i(new C5243p(this));
    }

    public static final List i(C5244q c5244q) {
        return C1173v.p(C4827g.g(c5244q.f38902b), C4827g.h(c5244q.f38902b));
    }

    public static final List o(C5244q c5244q) {
        return c5244q.f38903c ? C1173v.q(C4827g.f(c5244q.f38902b)) : C1173v.m();
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    public Collection<O> a(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        List<O> listN = n();
        Ia.j jVar = new Ia.j();
        for (Object obj : listN) {
            if (kotlin.jvm.internal.p.d(((O) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    public /* bridge */ /* synthetic */ InterfaceC0799d d(ga.e eVar, M9.b bVar) {
        return (InterfaceC0799d) j(eVar, bVar);
    }

    public Void j(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        return null;
    }

    @Override // ra.AbstractC5239l, ra.InterfaceC5241n
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public List<CallableMemberDescriptor> e(C5231d kindFilter, InterfaceC5074l<? super ga.e, Boolean> nameFilter) {
        kotlin.jvm.internal.p.i(kindFilter, "kindFilter");
        kotlin.jvm.internal.p.i(nameFilter, "nameFilter");
        return F.S0(m(), n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ra.AbstractC5239l, ra.InterfaceC5238k
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Ia.j<kotlin.reflect.jvm.internal.impl.descriptors.g> c(ga.e name, M9.b location) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(location, "location");
        List<kotlin.reflect.jvm.internal.impl.descriptors.g> listM = m();
        Ia.j<kotlin.reflect.jvm.internal.impl.descriptors.g> jVar = new Ia.j<>();
        for (Object obj : listM) {
            if (kotlin.jvm.internal.p.d(((kotlin.reflect.jvm.internal.impl.descriptors.g) obj).getName(), name)) {
                jVar.add(obj);
            }
        }
        return jVar;
    }

    public final List<kotlin.reflect.jvm.internal.impl.descriptors.g> m() {
        return (List) C5868k.a(this.f38904d, this, f38901f[0]);
    }

    public final List<O> n() {
        return (List) C5868k.a(this.f38905e, this, f38901f[1]);
    }
}
