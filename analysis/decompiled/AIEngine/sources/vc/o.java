package vc;

import kotlin.collections.EmptyList;
import kotlinx.serialization.json.internal.JsonEncodingException;
import kotlinx.serialization.json.internal.WriteMode;
import rc.i;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o {
    public static final rc.e a(rc.e eVar, androidx.datastore.preferences.protobuf.f module) {
        rc.e eVarA;
        pc.a aVarC;
        kotlin.jvm.internal.g.f(eVar, "<this>");
        kotlin.jvm.internal.g.f(module, "module");
        if (!kotlin.jvm.internal.g.b(eVar.d(), i.a.f11799a)) {
            return eVar.isInline() ? a(eVar.h(0), module) : eVar;
        }
        ec.c cVarR = jd.b.r(eVar);
        rc.e eVarD = null;
        if (cVarR != null && (aVarC = module.c(cVarR, EmptyList.f10001a)) != null) {
            eVarD = aVarC.d();
        }
        return (eVarD == null || (eVarA = a(eVarD, module)) == null) ? eVar : eVarA;
    }

    public static final WriteMode b(rc.e desc, uc.a aVar) {
        kotlin.jvm.internal.g.f(desc, "desc");
        rc.i iVarD = desc.d();
        if (iVarD instanceof rc.c) {
            return WriteMode.h;
        }
        if (kotlin.jvm.internal.g.b(iVarD, j.b.f11802a)) {
            return WriteMode.f10137d;
        }
        if (!kotlin.jvm.internal.g.b(iVarD, j.c.f11803a)) {
            return WriteMode.f10136c;
        }
        rc.e eVarA = a(desc.h(0), aVar.f13195b);
        rc.i iVarD2 = eVarA.d();
        if ((iVarD2 instanceof rc.d) || kotlin.jvm.internal.g.b(iVarD2, i.b.f11800a)) {
            return WriteMode.f10138e;
        }
        throw new JsonEncodingException("Value of type '" + eVarA.i() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + eVarA.d() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }
}
