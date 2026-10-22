package z8;

import ad.b0;
import ad.n;
import ad.p;
import ad.q;
import ad.y;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kb.s;
import kb.u;
import org.json.JSONException;
import org.json.JSONObject;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ c f16489c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f16490f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ String f16491g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ JSONObject f16492h;
    public /* synthetic */ b0 i;

    @Override // xb.l
    public final Object invoke(Object obj) throws JSONException {
        Set<String> setUnmodifiableSet;
        Iterable iterableUnmodifiableList;
        c cVar = this.f16489c;
        int i = this.f16490f;
        String str = this.f16491g;
        JSONObject jSONObject = this.f16492h;
        b0 b0Var = this.i;
        n nVar = (n) obj;
        nVar.getClass();
        cVar.getClass();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("phase", "POST tool_security/device/daily_status attempt=" + (i + 1) + "/3");
        jSONObject2.put("url", str);
        JSONObject jSONObject3 = new JSONObject();
        str.getClass();
        q qVarA = null;
        try {
            p pVar = new p();
            pVar.c(null, str);
            qVarA = pVar.a();
        } catch (IllegalArgumentException unused) {
        }
        if (qVarA != null) {
            ArrayList arrayList = qVarA.f565g;
            if (arrayList == null) {
                setUnmodifiableSet = u.f7406c;
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                ec.f fVarL = p5.f.L(p5.f.O(0, arrayList.size()), 2);
                int i3 = fVarL.f3758c;
                int i10 = fVarL.f3759f;
                int i11 = fVarL.f3760g;
                if ((i11 > 0 && i3 <= i10) || (i11 < 0 && i10 <= i3)) {
                    while (true) {
                        Object obj2 = arrayList.get(i3);
                        obj2.getClass();
                        linkedHashSet.add(obj2);
                        if (i3 == i10) {
                            break;
                        }
                        i3 += i11;
                    }
                }
                setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
                setUnmodifiableSet.getClass();
            }
            for (String str2 : setUnmodifiableSet) {
                str2.getClass();
                if (arrayList == null) {
                    iterableUnmodifiableList = s.f7404c;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ec.f fVarL2 = p5.f.L(p5.f.O(0, arrayList.size()), 2);
                    int i12 = fVarL2.f3758c;
                    int i13 = fVarL2.f3759f;
                    int i14 = fVarL2.f3760g;
                    if ((i14 > 0 && i12 <= i13) || (i14 < 0 && i13 <= i12)) {
                        while (true) {
                            if (str2.equals(arrayList.get(i12))) {
                                arrayList2.add(arrayList.get(i12 + 1));
                            }
                            if (i12 == i13) {
                                break;
                            }
                            i12 += i14;
                        }
                    }
                    iterableUnmodifiableList = Collections.unmodifiableList(arrayList2);
                    iterableUnmodifiableList.getClass();
                }
                jSONObject3.put(str2, kb.l.B0(iterableUnmodifiableList, ",", null, null, null, 62));
            }
        }
        jSONObject2.put("query", jSONObject3);
        Set set = p9.a.f9925a;
        jSONObject2.put("headers", p9.a.b(nVar));
        if (jSONObject != null) {
            String string = jSONObject.toString();
            string.getClass();
            jSONObject2.put("body", p9.a.a(string, "json"));
        }
        Log.i("SecurityLogApi", "params=" + jSONObject2);
        y yVar = new y();
        yVar.f633c = nVar.c();
        yVar.o(str);
        b0Var.getClass();
        yVar.l("POST", b0Var);
        return yVar.e();
    }
}
