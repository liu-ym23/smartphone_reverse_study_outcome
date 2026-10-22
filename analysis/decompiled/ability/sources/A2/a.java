package A2;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import org.json.JSONException;
import org.json.JSONObject;
import s2.C1912a;

/* loaded from: classes2.dex */
public final class a extends g {
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(CrashType crashType, Context context, e eVar, h hVar, int i) {
        super(crashType, context, eVar, hVar);
        this.f = i;
    }

    private final void h(n2.a aVar) {
    }

    private final void i(n2.a aVar) {
    }

    private final void j(n2.a aVar) {
    }

    @Override // A2.g
    public n2.a a(int i, n2.a aVar) {
        switch (this.f) {
            case 5:
                n2.a aVarA = super.a(i, aVar);
                if (i == 0) {
                    aVarA.e(1, "app_count");
                    aVarA.e("ss_app_log", "magic_tag");
                    Header headerA = Header.a();
                    headerA.h();
                    aVarA.d(headerA);
                    Z6.k.i(aVarA, headerA, this.f89a);
                } else if (i == 1) {
                    Header headerU = aVarA.u();
                    headerU.j();
                    headerU.k();
                } else if (i == 2) {
                    Header.addRuntimeHeader(aVarA.u().f2158a);
                } else if (i == 5) {
                    Header.f(aVarA.u());
                }
                return aVarA;
            case 6:
                Context context = this.b;
                n2.a aVarA2 = super.a(i, aVar);
                if (i == 0) {
                    Header headerA2 = Header.a();
                    headerA2.h();
                    aVarA2.d(headerA2);
                    Z6.k.i(aVarA2, headerA2, this.f89a);
                } else if (i == 1) {
                    Header headerU2 = aVarA2.u();
                    headerU2.j();
                    headerU2.k();
                } else if (i == 2) {
                    Header.addRuntimeHeader(aVarA2.u().f2158a);
                    try {
                        aVarA2.u().f2158a.put("launch_did", C1912a.a(context));
                    } catch (Throwable unused) {
                    }
                } else if (i == 5) {
                    Header.f(aVarA2.u());
                }
                return aVarA2;
            case 7:
                n2.a aVarA3 = super.a(i, aVar);
                if (i == 0) {
                    Header headerA3 = Header.a();
                    headerA3.h();
                    aVarA3.d(headerA3);
                    Z6.k.i(aVarA3, headerA3, this.f89a);
                } else if (i == 1) {
                    Header headerU3 = aVarA3.u();
                    headerU3.j();
                    headerU3.k();
                } else if (i == 2) {
                    Header.addRuntimeHeader(aVarA3.u().f2158a);
                }
                return aVarA3;
            default:
                return super.a(i, aVar);
        }
    }

    @Override // A2.g
    public n2.a b(n2.a aVar) {
        switch (this.f) {
            case 0:
                Header headerA = Header.a();
                Header.addRuntimeHeader(headerA.f2158a);
                Header.f(headerA);
                headerA.h();
                headerA.j();
                headerA.k();
                aVar.d(headerA);
                aVar.e(com.stepos.statsrpk.d.o(), "process_name");
                Z6.k.i(aVar, headerA, this.f89a);
                break;
            case 2:
                Header headerA2 = Header.a();
                Header.addRuntimeHeader(headerA2.f2158a);
                Header.f(headerA2);
                headerA2.h();
                headerA2.j();
                headerA2.k();
                aVar.d(headerA2);
                break;
            case 3:
                Header headerA3 = Header.a();
                JSONObject jSONObject = headerA3.f2158a;
                Header.addRuntimeHeader(jSONObject);
                Header.f(headerA3);
                headerA3.h();
                headerA3.j();
                headerA3.k();
                try {
                    String strH = com.apm.insight.f.h(jSONObject.optString("aid"));
                    if (!TextUtils.isEmpty(strH)) {
                        jSONObject.put("x-auth-token", strH);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aVar.d(headerA3);
                Z6.k.i(aVar, headerA3, this.f89a);
                break;
        }
        return aVar;
    }

    @Override // A2.g
    public void d(n2.a aVar) {
        switch (this.f) {
            case 4:
                break;
            default:
                super.d(aVar);
                break;
        }
    }

    @Override // A2.g
    public void e(n2.a aVar) {
        switch (this.f) {
            case 4:
                break;
            default:
                super.e(aVar);
                break;
        }
    }

    @Override // A2.g
    public boolean f() {
        switch (this.f) {
            case 7:
                return false;
            default:
                return super.f();
        }
    }

    @Override // A2.g
    public void g(n2.a aVar) {
        int i = this.f;
    }
}
