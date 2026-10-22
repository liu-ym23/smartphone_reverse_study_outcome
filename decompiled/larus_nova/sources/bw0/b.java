package bw0;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import wp2.d;
import wp2.i;
import wp2.n;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.d f20996a;

    public b(a.d r100) {
        this.f20996a = r100;
    }

    @Override // wp2.i
    public final void a(d r100) {
        if ((r100 instanceof n) == true) goto L5;
        Object r101 = null;
    L6:
        n r102 = (n) r101;
        jy0.b.d("Recharge/RechargeClientAiService", "Request completed:(isSuccess: " + Boolean.valueOf(r100.f560560a) + ", code: " + Integer.valueOf(r100.f560561b) + ", res; null)");
        a r103 = this.f20996a.f20991a;
        Pair[] r104 = new Pair[6];
        Boolean r105 = Boolean.valueOf(r100.f560560a);
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L11:
        if (r106 == false) goto L13;
        String r107 = "1";
    L14:
        r104[0] = TuplesKt.to("success", r107);
        if (r102 == null) goto L17;
        String r108 = String.valueOf(r102.f560561b);
    L19:
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        r104[1] = TuplesKt.to("errorCode", r108);
        r104[2] = TuplesKt.to("errorDesc", "");
        r104[3] = TuplesKt.to("should_preorder", String.valueOf(0));
        r104[4] = TuplesKt.to("should_preload", "0");
        r104[5] = TuplesKt.to("predict_cost", String.valueOf(System.currentTimeMillis() - this.f20996a.f20992b));
        a.E1(r103, "livesdk_charge_preorder_runtask_result", MapsKt.mutableMapOf(r104), null);
        a.J1(this.f20996a.f20991a);
        return;
    L17:
        r108 = null;
        goto L19
    L13:
        r107 = "0";
        goto L14
    L9:
        r106 = false;
        goto L11
    L5:
        r101 = r100;
        goto L6
    }
}
