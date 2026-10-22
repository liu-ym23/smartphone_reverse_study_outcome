package n8;

import kotlinx.serialization.json.ClassDiscriminatorMode;
import lb.n;
import uc.a;
import uc.l;
import vc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final l f10653a;

    static {
        a.C0150a from = uc.a.f13193d;
        kotlin.jvm.internal.g.f(from, "from");
        uc.e eVar = from.f13194a;
        String str = eVar.f13206d;
        String str2 = eVar.f13208f;
        ClassDiscriminatorMode classDiscriminatorMode = eVar.h;
        boolean z = eVar.f13209g;
        androidx.datastore.preferences.protobuf.f module = from.f13195b;
        n nVar = n.f10413a;
        if (!kotlin.jvm.internal.g.b(str, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        uc.e eVar2 = new uc.e(true, true, false, str, true, str2, z, classDiscriminatorMode);
        kotlin.jvm.internal.g.f(module, "module");
        l lVar = new l(eVar2, module);
        if (!module.equals(wc.c.f13679a)) {
            module.b(new j(str2));
        }
        f10653a = lVar;
    }
}
