package t0;

import java.util.Map;
import jb.v;
import s8.t;
import u0.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13112c;

    public /* synthetic */ d(int i) {
        this.f13112c = i;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = 0;
        switch (this.f13112c) {
            case 0:
                return new e((Map) obj);
            case 1:
                return obj;
            case 2:
                synchronized (m.f13676c) {
                    ?? r12 = m.i;
                    int size = r12.size();
                    while (i < size) {
                        ((xb.l) r12.get(i)).invoke(obj);
                        i++;
                    }
                }
                return v.f6774a;
            case 3:
                d dVar = m.f13674a;
                return v.f6774a;
            case 4:
                return v.f6774a;
            case 5:
                return (u5.g) obj;
            case 6:
                t tVar = (t) obj;
                tVar.getClass();
                return tVar;
            case 7:
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                String str = (String) entry.getKey();
                u8.j jVar = (u8.j) entry.getValue();
                return str + "->" + jVar.f14215c + "/notes=" + jVar.f14218f.size();
            case 8:
                ((String) obj).getClass();
                return "?";
            case 9:
                y9.h hVar = (y9.h) obj;
                hVar.getClass();
                return hVar.f16054a;
            case 10:
                vc.a aVar = (vc.a) obj;
                aVar.getClass();
                vc.a.a(aVar, "JsonPrimitive", t1.e.b(new yc.g(i)));
                vc.a.a(aVar, "JsonNull", t1.e.b(new yc.g(1)));
                vc.a.a(aVar, "JsonLiteral", t1.e.b(new yc.g(2)));
                vc.a.a(aVar, "JsonObject", t1.e.b(new yc.g(3)));
                vc.a.a(aVar, "JsonArray", t1.e.b(new yc.g(4)));
                return v.f6774a;
            case 11:
                Map.Entry entry2 = (Map.Entry) obj;
                entry2.getClass();
                String str2 = (String) entry2.getKey();
                yc.f fVar = (yc.f) entry2.getValue();
                StringBuilder sb2 = new StringBuilder();
                zc.a.a(sb2, str2);
                sb2.append(':');
                sb2.append(fVar);
                return sb2.toString();
            case 12:
                obj.getClass();
                z9.f fVar2 = z9.f.f16523a;
                z9.f.b(obj, "setCornerSmoothness", new Class[]{z9.f.f16530h}, Float.valueOf(0.0f));
                return v.f6774a;
            case 13:
                obj.getClass();
                return v.f6774a;
            default:
                ((z9.g) obj).getClass();
                return v.f6774a;
        }
    }
}
