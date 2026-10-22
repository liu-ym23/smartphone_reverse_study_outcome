package b0;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public final /* synthetic */ class y implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1424f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1425g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1426h;

    public /* synthetic */ y(int i2, int i10, Object obj, Object obj2) {
        this.f1424f = i10;
        this.f1425g = obj;
        this.f1426h = obj2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1424f) {
            case 0:
                ((Integer) obj2).getClass();
                b.a((x1) this.f1425g, (j0.d) this.f1426h, (p) obj, b.s(57));
                break;
            case 1:
                q5.q qVar = (q5.q) this.f1425g;
                d5.e eVar = (d5.e) this.f1426h;
                q5.d dVar = (q5.d) obj2;
                q7.k.e((String) obj, "<unused var>");
                if (qVar.f8747a.c(eVar.getId()) != eVar) {
                    return dVar;
                }
                if (dVar == null) {
                    return qVar.e(eVar);
                }
                if (dVar.f8669a == eVar) {
                    return dVar;
                }
                dVar.a();
                return qVar.e(eVar);
            case 2:
                ((Integer) obj2).getClass();
                w5.a0.e((String) this.f1425g, (String) this.f1426h, (p) obj, b.s(7));
                break;
            case 3:
                ((Integer) obj2).getClass();
                w5.a0.f((w5.b0) this.f1425g, (ArrayList) this.f1426h, (p) obj, b.s(1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                w5.e0.c((w5.e) this.f1425g, (p7.a) this.f1426h, (p) obj, b.s(49));
                break;
            case 5:
                ((Integer) obj2).getClass();
                w5.e0.b((w5.e) this.f1425g, (w5.f0) this.f1426h, (p) obj, b.s(1));
                break;
            default:
                y4.h hVar = (y4.h) this.f1425g;
                String str = (String) this.f1426h;
                String str2 = (String) obj;
                String str3 = (String) obj2;
                q7.k.e(str2, "stableId");
                q7.k.e(str3, "fp");
                k5.s.info$default(hVar.f11569c, str, a1.a.j("TLS fp stableId=", str2, " (saving)"), null, 4, null);
                o4.u2 u2Var = (o4.u2) hVar.f11576j.getValue();
                u2Var.getClass();
                SharedPreferences.Editor editorEdit = u2Var.f7656a.edit();
                String strConcat = "tfp:".concat(str2);
                String lowerCase = str3.toLowerCase(Locale.ROOT);
                q7.k.d(lowerCase, "toLowerCase(...)");
                editorEdit.putString(strConcat, lowerCase).apply();
                break;
        }
        return c7.r.f1986a;
    }

    public /* synthetic */ y(int i2, Object obj, Object obj2) {
        this.f1424f = i2;
        this.f1425g = obj;
        this.f1426h = obj2;
    }
}
