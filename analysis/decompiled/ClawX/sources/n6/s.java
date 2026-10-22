package n6;

import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final m f4128a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4129b;

    /* renamed from: c, reason: collision with root package name */
    public final k f4130c;
    public final o6.a d;

    /* renamed from: e, reason: collision with root package name */
    public c f4131e;

    public s(a1.w wVar) {
        m mVar = (m) wVar.f75b;
        if (mVar == null) {
            throw new IllegalStateException("url == null");
        }
        this.f4128a = mVar;
        this.f4129b = (String) wVar.f76c;
        this.f4130c = ((androidx.fragment.app.l) wVar.d).a();
        this.d = (o6.a) wVar.f77e;
    }

    public final a1.w a() {
        a1.w wVar = new a1.w(false);
        wVar.f75b = this.f4128a;
        wVar.f76c = this.f4129b;
        wVar.f77e = this.d;
        wVar.d = this.f4130c.h();
        return wVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Request{method=");
        sb.append(this.f4129b);
        sb.append(", url=");
        sb.append(this.f4128a);
        k kVar = this.f4130c;
        if (kVar.size() != 0) {
            sb.append(", headers=[");
            Iterator it = kVar.iterator();
            int i8 = 0;
            while (true) {
                b5.o oVar = (b5.o) it;
                if (!oVar.hasNext()) {
                    sb.append(AbstractJsonLexerKt.END_LIST);
                    break;
                }
                Object next = oVar.next();
                int i9 = i8 + 1;
                if (i8 < 0) {
                    c5.n.m0();
                    throw null;
                }
                b5.g gVar = (b5.g) next;
                String str = (String) gVar.f892a;
                String str2 = (String) gVar.f893b;
                if (i8 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(AbstractJsonLexerKt.COLON);
                if (o6.d.j(str)) {
                    str2 = "██";
                }
                sb.append(str2);
                i8 = i9;
            }
        }
        o6.a aVar = o6.a.f4323a;
        o6.a aVar2 = this.d;
        if (!kotlin.jvm.internal.p.a(aVar2, aVar)) {
            sb.append(", tags=");
            sb.append(aVar2);
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
