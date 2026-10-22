package z3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6491a;

    public /* synthetic */ p(int i8) {
        this.f6491a = i8;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f6491a) {
            case 0:
                a4.c createClientPlugin = (a4.c) obj;
                kotlin.jvm.internal.p.e(createClientPlugin, "$this$createClientPlugin");
                o oVar = (o) createClientPlugin.f93b;
                List listH0 = c5.m.H0(oVar.f6486a);
                List listH02 = c5.m.H0(oVar.f6487b);
                f5.c cVar = null;
                createClientPlugin.a(a4.i.f111c, new s(oVar.f6488c, null));
                createClientPlugin.a(a4.i.f110b, new a4.m(listH0, 3, cVar));
                createClientPlugin.a(a.f6413f, new t(listH02, cVar, 0));
                createClientPlugin.a(a.d, new t(listH02, cVar, 1));
                break;
            case 1:
                a4.c createClientPlugin2 = (a4.c) obj;
                kotlin.jvm.internal.p.e(createClientPlugin2, "$this$createClientPlugin");
                a0 a0Var = (a0) createClientPlugin2.f93b;
                LinkedHashMap linkedHashMap = a0Var.f6417b;
                kotlin.jvm.internal.p.e(linkedHashMap, "<this>");
                int size = linkedHashMap.size();
                Iterable iterableS = c5.s.f1092a;
                if (size != 0) {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    if (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (it.hasNext()) {
                            ArrayList arrayList = new ArrayList(linkedHashMap.size());
                            arrayList.add(new b5.g(entry.getKey(), entry.getValue()));
                            do {
                                Map.Entry entry2 = (Map.Entry) it.next();
                                arrayList.add(new b5.g(entry2.getKey(), entry2.getValue()));
                            } while (it.hasNext());
                            iterableS = arrayList;
                        } else {
                            iterableS = a.a.S(new b5.g(entry.getKey(), entry.getValue()));
                        }
                    }
                }
                List<b5.g> listJ0 = c5.m.J0(iterableS, new e0(1));
                Charset charset = a0Var.f6418c;
                LinkedHashSet linkedHashSet = a0Var.f6416a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : linkedHashSet) {
                    if (!a0Var.f6417b.containsKey((Charset) obj2)) {
                        arrayList2.add(obj2);
                    }
                }
                List<Charset> listJ02 = c5.m.J0(arrayList2, new e0(0));
                StringBuilder sb = new StringBuilder();
                for (Charset charset2 : listJ02) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(x.f.V(charset2));
                }
                for (b5.g gVar : listJ0) {
                    Charset charset3 = (Charset) gVar.f892a;
                    float fFloatValue = ((Number) gVar.f893b).floatValue();
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    double d = fFloatValue;
                    if (0.0d > d || d > 1.0d) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (Float.isNaN(100 * fFloatValue)) {
                        throw new IllegalArgumentException("Cannot round NaN value.");
                    }
                    sb.append(x.f.V(charset3) + ";q=" + (Math.round(r7) / 100.0d));
                }
                if (sb.length() == 0) {
                    sb.append(x.f.V(charset));
                }
                String string = sb.toString();
                Charset charset4 = (Charset) c5.m.v0(listJ02);
                if (charset4 == null) {
                    b5.g gVar2 = (b5.g) c5.m.v0(listJ0);
                    charset4 = gVar2 != null ? (Charset) gVar2.f892a : null;
                    if (charset4 == null) {
                        charset4 = x5.a.f6276a;
                    }
                }
                createClientPlugin2.a(a.f6412e, new c0(string, charset4, null));
                createClientPlugin2.a(a4.i.f112e, new d0(charset, null));
                break;
            case 2:
                a4.c createClientPlugin3 = (a4.c) obj;
                kotlin.jvm.internal.p.e(createClientPlugin3, "$this$createClientPlugin");
                ((g0) createClientPlugin3.f93b).getClass();
                createClientPlugin3.a(a4.i.f110b, new a4.m(createClientPlugin3, 4, null));
                break;
            case 3:
                a4.c createClientPlugin4 = (a4.c) obj;
                kotlin.jvm.internal.p.e(createClientPlugin4, "$this$createClientPlugin");
                createClientPlugin4.a(a.f6414g, new a4.m(createClientPlugin4, 5, null));
                break;
            default:
                a4.c createClientPlugin5 = (a4.c) obj;
                kotlin.jvm.internal.p.e(createClientPlugin5, "$this$createClientPlugin");
                r0 r0Var = (r0) createClientPlugin5.f93b;
                createClientPlugin5.a(a4.i.f110b, new j(r0Var.f6498a, r0Var.f6499b, r0Var.f6500c, null));
                break;
        }
        return b5.a0.f883a;
    }
}
