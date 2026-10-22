package hd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k0.c1;
import s8.r3;
import s8.x0;
import s8.x2;
import s8.y2;
import s8.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5504c;

    /* renamed from: f, reason: collision with root package name */
    public Object f5505f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f5506g;

    public /* synthetic */ k(int i) {
        this.f5504c = i;
    }

    @Override // xb.a
    public final Object invoke() throws IOException {
        y2 y2Var;
        int i = this.f5504c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                o oVar = (o) this.f5506g;
                r rVar = (r) this.f5505f;
                try {
                } catch (IOException e10) {
                    oVar.d(2, 2, e10);
                } catch (Throwable th) {
                    oVar.d(3, 3, null);
                    bd.b.d(rVar);
                    throw th;
                }
                if (!rVar.d(true, this)) {
                    throw new IOException("Required SETTINGS preface not received");
                }
                while (rVar.d(false, this)) {
                }
                oVar.d(1, 9, null);
                bd.b.d(rVar);
                return vVar;
            case 1:
                ((xb.l) this.f5505f).invoke(x0.u(((z0) this.f5506g).f12163a));
                return vVar;
            case 2:
                ((xb.p) this.f5505f).invoke(((z0) this.f5506g).f12163a, null);
                return vVar;
            case 3:
                ((xb.l) this.f5505f).invoke(x0.u(((r3) this.f5506g).f11930a));
                return vVar;
            default:
                c1 c1Var = (c1) this.f5505f;
                int i3 = x2.f12108j;
                List<y2> list = (List) c1Var.getValue();
                y2 y2Var2 = (y2) this.f5506g;
                ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
                for (y2 y2Var3 : list) {
                    if (y2Var3.f12124a.equals(y2Var2.f12124a)) {
                        boolean z10 = !y2Var3.f12140r;
                        String str = y2Var3.f12124a;
                        String str2 = y2Var3.f12125b;
                        String str3 = y2Var3.f12126c;
                        List list2 = y2Var3.f12127d;
                        String str4 = y2Var3.f12128e;
                        List list3 = y2Var3.f12129f;
                        String str5 = y2Var3.f12130g;
                        String str6 = y2Var3.f12131h;
                        String str7 = y2Var3.i;
                        String str8 = y2Var3.f12132j;
                        y2Var = y2Var2;
                        String str9 = y2Var3.f12133k;
                        u8.p pVar = y2Var3.f12134l;
                        String str10 = y2Var3.f12135m;
                        String str11 = y2Var3.f12136n;
                        String str12 = y2Var3.f12137o;
                        List list4 = y2Var3.f12138p;
                        List list5 = y2Var3.f12139q;
                        str2.getClass();
                        list2.getClass();
                        str7.getClass();
                        str8.getClass();
                        str9.getClass();
                        pVar.getClass();
                        list5.getClass();
                        y2Var3 = new y2(str, str2, str3, list2, str4, list3, str5, str6, str7, str8, str9, pVar, str10, str11, str12, list4, list5, z10);
                    } else {
                        y2Var = y2Var2;
                    }
                    arrayList.add(y2Var3);
                    y2Var2 = y2Var;
                }
                c1Var.setValue(arrayList);
                return vVar;
        }
    }
}
