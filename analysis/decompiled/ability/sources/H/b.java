package H;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f706a;
    public final /* synthetic */ int b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ JSONObject d;

    public b(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        this.f706a = str;
        this.b = i;
        this.c = jSONObject;
        this.d = jSONObject2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        O.a.g().c(new P.c(this.f706a, this.b, this.c, null, null, this.d));
    }
}
