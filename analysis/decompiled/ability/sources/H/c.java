package H;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f707a;
    public final /* synthetic */ String b;
    public final /* synthetic */ JSONObject c;

    public /* synthetic */ c(int i, String str, JSONObject jSONObject) {
        this.f707a = i;
        this.b = str;
        this.c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f707a) {
            case 0:
                O.a.g().c(new P.b(1, this.b, this.c));
                break;
            default:
                O.a.g().c(new P.b(0, this.b, this.c));
                break;
        }
    }
}
