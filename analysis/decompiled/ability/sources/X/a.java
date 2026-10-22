package X;

import O.b;
import O.c;
import org.json.JSONObject;
import x0.C2112a;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f1498a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ JSONObject f;

    public a(long j5, long j6, String str, String str2, int i, JSONObject jSONObject) {
        this.f1498a = j5;
        this.b = j6;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        P.a aVar = new P.a();
        aVar.f1053a = this.f1498a;
        aVar.b = this.b;
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        int i = c.p;
        b.f1029a.c(aVar);
        try {
            JSONObject jSONObjectA = aVar.a();
            if (jSONObjectA != null) {
                S0.b.W(jSONObjectA, aVar.f);
                C2112a.c.a(jSONObjectA.toString());
            }
        } catch (Throwable unused) {
        }
    }
}
