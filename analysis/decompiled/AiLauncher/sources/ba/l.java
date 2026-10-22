package ba;

import E9.X;
import La.H;
import com.fasterxml.jackson.core.JsonPointer;
import ea.C4019c;
import ea.InterfaceC4020d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import pa.C5080d;
import ua.C5638x;
import wa.C5776S;
import wa.InterfaceC5793q;

/* loaded from: classes5.dex */
public final class l implements InterfaceC5793q {

    /* renamed from: b, reason: collision with root package name */
    public final C5080d f15336b;

    /* renamed from: c, reason: collision with root package name */
    public final C5080d f15337c;

    /* renamed from: d, reason: collision with root package name */
    public final C5080d f15338d;

    /* renamed from: e, reason: collision with root package name */
    public final C5638x<C4019c> f15339e;

    /* renamed from: f, reason: collision with root package name */
    public final C5776S f15340f;

    /* renamed from: g, reason: collision with root package name */
    public final DeserializedContainerAbiStability f15341g;

    /* renamed from: h, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.load.kotlin.f f15342h;

    /* renamed from: i, reason: collision with root package name */
    public final String f15343i;

    public l(C5080d className, C5080d c5080d, C5080d c5080d2, ProtoBuf$Package packageProto, InterfaceC4020d nameResolver, C5638x<C4019c> c5638x, C5776S preReleaseInfo, DeserializedContainerAbiStability abiStability, kotlin.reflect.jvm.internal.impl.load.kotlin.f fVar) {
        String string;
        kotlin.jvm.internal.p.i(className, "className");
        kotlin.jvm.internal.p.i(packageProto, "packageProto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(preReleaseInfo, "preReleaseInfo");
        kotlin.jvm.internal.p.i(abiStability, "abiStability");
        this.f15336b = className;
        this.f15337c = c5080d;
        this.f15338d = c5080d2;
        this.f15339e = c5638x;
        this.f15340f = preReleaseInfo;
        this.f15341g = abiStability;
        this.f15342h = fVar;
        GeneratedMessageLite.e<ProtoBuf$Package, Integer> packageModuleName = JvmProtoBuf.f35750m;
        kotlin.jvm.internal.p.h(packageModuleName, "packageModuleName");
        Integer num = (Integer) ea.f.a(packageProto, packageModuleName);
        this.f15343i = (num == null || (string = nameResolver.getString(num.intValue())) == null) ? "main" : string;
    }

    @Override // wa.InterfaceC5793q
    public String a() {
        return "Class '" + d().a().a() + '\'';
    }

    @Override // E9.W
    public X b() {
        X NO_SOURCE_FILE = X.f2445a;
        kotlin.jvm.internal.p.h(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    public final ga.b d() {
        ga.c cVarG = e().g();
        kotlin.jvm.internal.p.h(cVarG, "getPackageFqName(...)");
        return new ga.b(cVarG, h());
    }

    public C5080d e() {
        return this.f15336b;
    }

    public C5080d f() {
        return this.f15337c;
    }

    public final kotlin.reflect.jvm.internal.impl.load.kotlin.f g() {
        return this.f15342h;
    }

    public final ga.e h() {
        String strF = e().f();
        kotlin.jvm.internal.p.h(strF, "getInternalName(...)");
        ga.e eVarJ = ga.e.j(H.s1(strF, JsonPointer.SEPARATOR, null, 2, null));
        kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
        return eVarJ;
    }

    public String toString() {
        return l.class.getSimpleName() + ": " + e();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public l(kotlin.reflect.jvm.internal.impl.load.kotlin.f kotlinClass, ProtoBuf$Package packageProto, InterfaceC4020d nameResolver, C5638x<C4019c> c5638x, boolean z10, DeserializedContainerAbiStability abiStability) {
        C5080d c5080dD;
        kotlin.jvm.internal.p.i(kotlinClass, "kotlinClass");
        kotlin.jvm.internal.p.i(packageProto, "packageProto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(abiStability, "abiStability");
        C5080d c5080dB = C5080d.b(kotlinClass.j());
        kotlin.jvm.internal.p.h(c5080dB, "byClassId(...)");
        String strE = kotlinClass.b().e();
        if (strE != null) {
            c5080dD = strE.length() > 0 ? C5080d.d(strE) : null;
        } else {
            c5080dD = null;
        }
        this(c5080dB, c5080dD, null, packageProto, nameResolver, c5638x, new C5776S(z10, null, 2, null), abiStability, kotlinClass);
    }
}
