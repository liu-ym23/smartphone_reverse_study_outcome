package t2;

import h2.j;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.y;
import q2.h;
import q2.k;
import q2.m;
import q2.p;
import q2.u;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12935a;

    static {
        String strF = j.f("DiagnosticsWrkr");
        g.e(strF, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f12935a = strF;
    }

    public static final String a(m mVar, u uVar, h hVar, List list) {
        StringBuilder sb2 = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            k kVarT = y.t(pVar);
            String str = pVar.f11505a;
            q2.g gVarC = hVar.c(kVarT);
            Integer numValueOf = gVarC != null ? Integer.valueOf(gVarC.f11495c) : null;
            String strZ0 = kotlin.collections.a.z0(mVar.h(str), ",", null, null, null, 62);
            String strZ02 = kotlin.collections.a.z0(uVar.a(str), ",", null, null, null, 62);
            StringBuilder sbQ = a0.a.q("\n", str, "\t ");
            sbQ.append(pVar.f11507c);
            sbQ.append("\t ");
            sbQ.append(numValueOf);
            sbQ.append("\t ");
            sbQ.append(pVar.f11506b.name());
            sbQ.append("\t ");
            sbQ.append(strZ0);
            sbQ.append("\t ");
            sbQ.append(strZ02);
            sbQ.append('\t');
            sb2.append(sbQ.toString());
        }
        String string = sb2.toString();
        g.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
