package ua;

import E9.InterfaceC0819y;
import Z8.C1174w;
import ea.AbstractC4017a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import ra.InterfaceC5238k;
import wa.C5769K;
import wa.InterfaceC5793q;
import xa.InterfaceC5869l;

/* renamed from: ua.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5634t extends AbstractC5631q {

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC4017a f42646h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC5793q f42647i;

    /* renamed from: j, reason: collision with root package name */
    public final ea.e f42648j;

    /* renamed from: k, reason: collision with root package name */
    public final C5603M f42649k;

    /* renamed from: l, reason: collision with root package name */
    public ProtoBuf$PackageFragment f42650l;

    /* renamed from: m, reason: collision with root package name */
    public InterfaceC5238k f42651m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5634t(ga.c fqName, InterfaceC5869l storageManager, InterfaceC0819y module, ProtoBuf$PackageFragment proto, AbstractC4017a metadataVersion, InterfaceC5793q interfaceC5793q) {
        super(fqName, storageManager, module);
        kotlin.jvm.internal.p.i(fqName, "fqName");
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        kotlin.jvm.internal.p.i(module, "module");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        this.f42646h = metadataVersion;
        this.f42647i = interfaceC5793q;
        ProtoBuf$StringTable protoBuf$StringTableO = proto.O();
        kotlin.jvm.internal.p.h(protoBuf$StringTableO, "getStrings(...)");
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTableN = proto.N();
        kotlin.jvm.internal.p.h(protoBuf$QualifiedNameTableN, "getQualifiedNames(...)");
        ea.e eVar = new ea.e(protoBuf$StringTableO, protoBuf$QualifiedNameTableN);
        this.f42648j = eVar;
        this.f42649k = new C5603M(proto, eVar, metadataVersion, new C5632r(this));
        this.f42650l = proto;
    }

    public static final E9.W I0(AbstractC5634t abstractC5634t, ga.b it) {
        kotlin.jvm.internal.p.i(it, "it");
        InterfaceC5793q interfaceC5793q = abstractC5634t.f42647i;
        if (interfaceC5793q != null) {
            return interfaceC5793q;
        }
        E9.W NO_SOURCE = E9.W.f2444a;
        kotlin.jvm.internal.p.h(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    public static final Collection K0(AbstractC5634t abstractC5634t) {
        Collection<ga.b> collectionB = abstractC5634t.A0().b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionB) {
            ga.b bVar = (ga.b) obj;
            if (!bVar.j() && !C5625k.f42602c.a().contains(bVar)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ga.b) it.next()).h());
        }
        return arrayList2;
    }

    @Override // ua.AbstractC5631q
    public void F0(C5627m components) {
        kotlin.jvm.internal.p.i(components, "components");
        ProtoBuf$PackageFragment protoBuf$PackageFragment = this.f42650l;
        if (protoBuf$PackageFragment == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize");
        }
        this.f42650l = null;
        ProtoBuf$Package protoBuf$PackageM = protoBuf$PackageFragment.M();
        kotlin.jvm.internal.p.h(protoBuf$PackageM, "getPackage(...)");
        this.f42651m = new C5769K(this, protoBuf$PackageM, this.f42648j, this.f42646h, this.f42647i, components, "scope of " + this, new C5633s(this));
    }

    @Override // ua.AbstractC5631q
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public C5603M A0() {
        return this.f42649k;
    }

    @Override // E9.E
    public InterfaceC5238k m() {
        InterfaceC5238k interfaceC5238k = this.f42651m;
        if (interfaceC5238k != null) {
            return interfaceC5238k;
        }
        kotlin.jvm.internal.p.A("_memberScope");
        return null;
    }
}
